// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature.trees.growers;

import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import java.util.Iterator;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.shapes.BitSetDiscreteVoxelShape;
import net.minecraft.world.phys.shapes.DiscreteVoxelShape;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import java.util.Set;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import com.google.common.collect.Iterables;
import java.util.Comparator;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.BiConsumer;
import java.util.Random;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelWriter;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.tags.Tag;
import net.minecraft.tags.BlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelSimulatedReader;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;

public class SnowTreePlacer extends Feature<TreeConfiguration>
{
    public SnowTreePlacer(final Codec<TreeConfiguration> p_67201_) {
        super((Codec)p_67201_);
    }
    
    public static boolean isFree(final LevelSimulatedReader p_67263_, final BlockPos p_67264_) {
        return validTreePos(p_67263_, p_67264_) || p_67263_.m_7433_(p_67264_, p_67281_ -> p_67281_.m_60620_((Tag)BlockTags.f_13106_));
    }
    
    private static boolean isVine(final LevelSimulatedReader p_67278_, final BlockPos p_67279_) {
        return p_67278_.m_7433_(p_67279_, p_67276_ -> p_67276_.m_60713_(Blocks.f_50191_));
    }
    
    private static boolean isBlockWater(final LevelSimulatedReader p_67283_, final BlockPos p_67284_) {
        return p_67283_.m_7433_(p_67284_, p_67271_ -> p_67271_.m_60713_(Blocks.f_49990_));
    }
    
    public static boolean isAirOrLeaves(final LevelSimulatedReader p_67268_, final BlockPos p_67269_) {
        return p_67268_.m_7433_(p_67269_, p_67266_ -> p_67266_.m_60795_() || p_67266_.m_60620_((Tag)BlockTags.f_13035_));
    }
    
    private static boolean isReplaceablePlant(final LevelSimulatedReader p_67289_, final BlockPos p_67290_) {
        return p_67289_.m_7433_(p_67290_, p_160551_ -> {
            final Material material = p_160551_.m_60767_();
            return material == Material.f_76302_;
        });
    }
    
    public static boolean isBlockUnderValid(final LevelSimulatedReader reader, final BlockPos pos) {
        return reader.m_7433_(pos, state -> state.m_60620_((Tag)BlockTags.f_144279_)) || reader.m_7433_(pos, state -> state.m_60620_((Tag)BlockTags.f_144274_));
    }
    
    private static void setBlockKnownShape(final LevelWriter p_67257_, final BlockPos p_67258_, final BlockState p_67259_) {
        p_67257_.m_7731_(p_67258_, p_67259_, 19);
    }
    
    public static boolean validTreePos(final LevelSimulatedReader p_67273_, final BlockPos p_67274_) {
        return isAirOrLeaves(p_67273_, p_67274_) || isReplaceablePlant(p_67273_, p_67274_) || isBlockWater(p_67273_, p_67274_);
    }
    
    private boolean doPlace(final WorldGenLevel p_160511_, final Random p_160512_, final BlockPos p_160513_, final BiConsumer<BlockPos, BlockState> p_160514_, final BiConsumer<BlockPos, BlockState> p_160515_, final TreeConfiguration p_160516_) {
        final int i = p_160516_.f_68190_.m_70309_(p_160512_);
        final int j = p_160516_.f_68189_.m_5969_(p_160512_, i, p_160516_);
        final int k = i - j;
        final int l = p_160516_.f_68189_.m_5937_(p_160512_, k);
        if (p_160513_.m_123342_() < p_160511_.m_141937_() + 1 || p_160513_.m_123342_() + i + 1 > p_160511_.m_151558_()) {
            return false;
        }
        if (!isBlockUnderValid((LevelSimulatedReader)p_160511_, p_160513_.m_7495_())) {
            return false;
        }
        final OptionalInt optionalint = p_160516_.f_68191_.m_68295_();
        final int i2 = this.getMaxFreeTreeHeight((LevelSimulatedReader)p_160511_, i, p_160513_, p_160516_);
        if (i2 >= i || (optionalint.isPresent() && i2 >= optionalint.getAsInt())) {
            final List<FoliagePlacer.FoliageAttachment> list = p_160516_.f_68190_.m_142625_((LevelSimulatedReader)p_160511_, (BiConsumer)p_160514_, p_160512_, i2, p_160513_, p_160516_);
            list.forEach(p_160539_ -> p_160516_.f_68189_.m_161413_((LevelSimulatedReader)p_160511_, p_160515_, p_160512_, p_160516_, i1, p_160539_, j, l));
            return true;
        }
        return false;
    }
    
    private int getMaxFreeTreeHeight(final LevelSimulatedReader p_67216_, final int p_67217_, final BlockPos p_67218_, final TreeConfiguration p_67219_) {
        final BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
        for (int i = 0; i <= p_67217_ + 1; ++i) {
            for (int j = p_67219_.f_68191_.m_6133_(p_67217_, i), k = -j; k <= j; ++k) {
                for (int l = -j; l <= j; ++l) {
                    blockpos$mutableblockpos.m_122154_((Vec3i)p_67218_, k, i, l);
                    if (!isFree(p_67216_, (BlockPos)blockpos$mutableblockpos) || (!p_67219_.f_68193_ && isVine(p_67216_, (BlockPos)blockpos$mutableblockpos))) {
                        return i - 2;
                    }
                }
            }
        }
        return p_67217_;
    }
    
    protected void m_5974_(final LevelWriter p_67221_, final BlockPos p_67222_, final BlockState p_67223_) {
        setBlockKnownShape(p_67221_, p_67222_, p_67223_);
    }
    
    public final boolean m_142674_(final FeaturePlaceContext<TreeConfiguration> p_160530_) {
        final WorldGenLevel worldgenlevel = p_160530_.m_159774_();
        final Random random = p_160530_.m_159776_();
        final BlockPos blockpos = p_160530_.m_159777_();
        final TreeConfiguration treeconfiguration = (TreeConfiguration)p_160530_.m_159778_();
        final Set<BlockPos> set = Sets.newHashSet();
        final Set<BlockPos> set2 = Sets.newHashSet();
        final Set<BlockPos> set3 = Sets.newHashSet();
        final BiConsumer<BlockPos, BlockState> biconsumer = (p_160555_, p_160556_) -> {
            set.add(p_160555_.m_7949_());
            worldgenlevel.m_7731_(p_160555_, p_160556_, 19);
            return;
        };
        final BiConsumer<BlockPos, BlockState> biconsumer2 = (p_160548_, p_160549_) -> {
            set1.add(p_160548_.m_7949_());
            worldgenlevel.m_7731_(p_160548_, p_160549_, 19);
            return;
        };
        final BiConsumer<BlockPos, BlockState> biconsumer3 = (p_160543_, p_160544_) -> {
            set2.add(p_160543_.m_7949_());
            worldgenlevel.m_7731_(p_160543_, p_160544_, 19);
            return;
        };
        final boolean flag = this.doPlace(worldgenlevel, random, blockpos, biconsumer, biconsumer2, treeconfiguration);
        if (flag && (!set.isEmpty() || !set2.isEmpty())) {
            if (!treeconfiguration.f_68187_.isEmpty()) {
                final List<BlockPos> list = Lists.newArrayList((Iterable)set);
                final List<BlockPos> list2 = Lists.newArrayList((Iterable)set2);
                list.sort(Comparator.comparingInt(Vec3i::m_123342_));
                list2.sort(Comparator.comparingInt(Vec3i::m_123342_));
                treeconfiguration.f_68187_.forEach(p_160528_ -> p_160528_.m_142741_((LevelSimulatedReader)worldgenlevel, biconsumer2, random, list, list1));
            }
            return BoundingBox.m_162378_(Iterables.concat((Iterable)set, (Iterable)set2, (Iterable)set3)).map(p_160521_ -> {
                final DiscreteVoxelShape discretevoxelshape = updateLeaves((LevelAccessor)worldgenlevel, p_160521_, set, set2);
                StructureTemplate.m_74510_((LevelAccessor)worldgenlevel, 3, discretevoxelshape, p_160521_.m_162395_(), p_160521_.m_162396_(), p_160521_.m_162398_());
                return true;
            }).orElse(false);
        }
        return false;
    }
    
    private static DiscreteVoxelShape updateLeaves(final LevelAccessor p_67203_, final BoundingBox p_67204_, final Set<BlockPos> p_67205_, final Set<BlockPos> p_67206_) {
        final List<Set<BlockPos>> list = Lists.newArrayList();
        final DiscreteVoxelShape discretevoxelshape = (DiscreteVoxelShape)new BitSetDiscreteVoxelShape(p_67204_.m_71056_(), p_67204_.m_71057_(), p_67204_.m_71058_());
        final int i = 6;
        for (int j = 0; j < 6; ++j) {
            list.add(Sets.newHashSet());
        }
        final BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
        for (final BlockPos blockpos : Lists.newArrayList((Iterable)p_67206_)) {
            if (p_67204_.m_71051_((Vec3i)blockpos)) {
                discretevoxelshape.m_142703_(blockpos.m_123341_() - p_67204_.m_162395_(), blockpos.m_123342_() - p_67204_.m_162396_(), blockpos.m_123343_() - p_67204_.m_162398_());
            }
        }
        for (final BlockPos blockpos2 : Lists.newArrayList((Iterable)p_67205_)) {
            if (p_67204_.m_71051_((Vec3i)blockpos2)) {
                discretevoxelshape.m_142703_(blockpos2.m_123341_() - p_67204_.m_162395_(), blockpos2.m_123342_() - p_67204_.m_162396_(), blockpos2.m_123343_() - p_67204_.m_162398_());
            }
            for (final Direction direction : Direction.values()) {
                blockpos$mutableblockpos.m_122159_((Vec3i)blockpos2, direction);
                if (!p_67205_.contains(blockpos$mutableblockpos)) {
                    final BlockState blockstate = p_67203_.m_8055_((BlockPos)blockpos$mutableblockpos);
                    if (blockstate.m_61138_((Property)BlockStateProperties.f_61414_)) {
                        list.get(0).add(blockpos$mutableblockpos.m_7949_());
                        setBlockKnownShape((LevelWriter)p_67203_, (BlockPos)blockpos$mutableblockpos, (BlockState)blockstate.m_61124_((Property)BlockStateProperties.f_61414_, (Comparable)1));
                        if (p_67204_.m_71051_((Vec3i)blockpos$mutableblockpos)) {
                            discretevoxelshape.m_142703_(blockpos$mutableblockpos.m_123341_() - p_67204_.m_162395_(), blockpos$mutableblockpos.m_123342_() - p_67204_.m_162396_(), blockpos$mutableblockpos.m_123343_() - p_67204_.m_162398_());
                        }
                    }
                }
            }
        }
        for (int l = 1; l < 6; ++l) {
            final Set<BlockPos> set = list.get(l - 1);
            final Set<BlockPos> set2 = list.get(l);
            for (final BlockPos blockpos3 : set) {
                if (p_67204_.m_71051_((Vec3i)blockpos3)) {
                    discretevoxelshape.m_142703_(blockpos3.m_123341_() - p_67204_.m_162395_(), blockpos3.m_123342_() - p_67204_.m_162396_(), blockpos3.m_123343_() - p_67204_.m_162398_());
                }
                for (final Direction direction2 : Direction.values()) {
                    blockpos$mutableblockpos.m_122159_((Vec3i)blockpos3, direction2);
                    if (!set.contains(blockpos$mutableblockpos) && !set2.contains(blockpos$mutableblockpos)) {
                        final BlockState blockstate2 = p_67203_.m_8055_((BlockPos)blockpos$mutableblockpos);
                        if (blockstate2.m_61138_((Property)BlockStateProperties.f_61414_)) {
                            final int k = (int)blockstate2.m_61143_((Property)BlockStateProperties.f_61414_);
                            if (k > l + 1) {
                                final BlockState blockstate3 = (BlockState)blockstate2.m_61124_((Property)BlockStateProperties.f_61414_, (Comparable)(l + 1));
                                setBlockKnownShape((LevelWriter)p_67203_, (BlockPos)blockpos$mutableblockpos, blockstate3);
                                if (p_67204_.m_71051_((Vec3i)blockpos$mutableblockpos)) {
                                    discretevoxelshape.m_142703_(blockpos$mutableblockpos.m_123341_() - p_67204_.m_162395_(), blockpos$mutableblockpos.m_123342_() - p_67204_.m_162396_(), blockpos$mutableblockpos.m_123343_() - p_67204_.m_162398_());
                                }
                                set2.add(blockpos$mutableblockpos.m_7949_());
                            }
                        }
                    }
                }
            }
        }
        return discretevoxelshape;
    }
}
