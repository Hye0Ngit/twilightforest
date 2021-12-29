// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature.trees;

import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.tags.Tag;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.shapes.BitSetDiscreteVoxelShape;
import net.minecraft.world.level.LevelWriter;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import java.util.OptionalInt;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.phys.shapes.DiscreteVoxelShape;
import java.util.List;
import net.minecraft.world.level.block.state.BlockState;
import java.util.function.BiConsumer;
import java.util.Iterator;
import java.util.Random;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import java.util.Set;
import net.minecraft.world.level.LevelAccessor;
import com.google.common.collect.Iterables;
import net.minecraft.world.level.LevelSimulatedReader;
import java.util.Comparator;
import net.minecraft.core.Vec3i;
import com.google.common.collect.Lists;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import com.google.common.collect.Sets;
import net.minecraft.core.Direction;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;

public class TFGenDarkCanopyTree extends Feature<TreeConfiguration>
{
    int difference;
    BlockPos validPos;
    
    public TFGenDarkCanopyTree(final Codec<TreeConfiguration> config) {
        super((Codec)config);
        this.difference = 0;
        this.validPos = new BlockPos(0, 0, 0);
    }
    
    public boolean m_142674_(final FeaturePlaceContext<TreeConfiguration> ctx) {
        final WorldGenLevel reader = ctx.m_159774_();
        BlockPos pos = ctx.m_159777_();
        final Random rand = ctx.m_159776_();
        final TreeConfiguration config = (TreeConfiguration)ctx.m_159778_();
        boolean foundDirt = false;
        for (int dy = pos.m_123342_(); dy >= 0; --dy) {
            final Material materialUnder = reader.m_8055_(new BlockPos(pos.m_123341_(), dy - 1, pos.m_123343_())).m_60767_();
            if (materialUnder == Material.f_76315_ || materialUnder == Material.f_76314_) {
                foundDirt = true;
                pos = new BlockPos(pos.m_123341_(), dy, pos.m_123343_());
                this.validPos = pos;
                break;
            }
            if (materialUnder == Material.f_76278_) {
                break;
            }
            if (materialUnder == Material.f_76317_) {
                break;
            }
        }
        if (!foundDirt) {
            return false;
        }
        for (final Direction e : Direction.Plane.HORIZONTAL) {
            if (reader.m_8055_(pos.m_142300_(e)).m_60767_() == Material.f_76320_) {
                return false;
            }
        }
        final Set<BlockPos> set1 = Sets.newHashSet();
        final Set<BlockPos> set2 = Sets.newHashSet();
        final Set<BlockPos> set3 = Sets.newHashSet();
        final BoundingBox mutableboundingbox = BoundingBox.m_71044_();
        final BiConsumer<BlockPos, BlockState> biConsumer = (p_160555_, p_160556_) -> {
            set1.add(p_160555_.m_7949_());
            reader.m_7731_(p_160555_, p_160556_, 19);
            return;
        };
        final BiConsumer<BlockPos, BlockState> biConsumer2 = (p_160548_, p_160549_) -> {
            set2.add(p_160548_.m_7949_());
            reader.m_7731_(p_160548_, p_160549_, 19);
            return;
        };
        final BiConsumer<BlockPos, BlockState> biConsumer3 = (p_160543_, p_160544_) -> {
            set3.add(p_160543_.m_7949_());
            reader.m_7731_(p_160543_, p_160544_, 19);
            return;
        };
        final boolean flag = this.doPlace(reader, rand, pos, biConsumer, biConsumer2, config);
        this.difference = mutableboundingbox.m_162396_() - pos.m_123342_();
        mutableboundingbox.m_162367_(0, pos.m_123342_(), 0);
        if (flag && (!set1.isEmpty() || !set2.isEmpty())) {
            if (!config.f_68187_.isEmpty()) {
                final List<BlockPos> list1 = Lists.newArrayList((Iterable)set1);
                final List<BlockPos> list2 = Lists.newArrayList((Iterable)set2);
                list1.sort(Comparator.comparingInt(Vec3i::m_123342_));
                list2.sort(Comparator.comparingInt(Vec3i::m_123342_));
                config.f_68187_.forEach(p_160528_ -> p_160528_.m_142741_((LevelSimulatedReader)reader, biConsumer2, rand, list1, list2));
            }
            return BoundingBox.m_162378_(Iterables.concat((Iterable)set1, (Iterable)set2, (Iterable)set3)).map(p_160521_ -> {
                final DiscreteVoxelShape shape = updateLeaves((LevelAccessor)reader, p_160521_, set1, set3);
                StructureTemplate.m_74510_((LevelAccessor)reader, 3, shape, p_160521_.m_162395_(), p_160521_.m_162396_(), p_160521_.m_162398_());
                return true;
            }).orElse(false);
        }
        return false;
    }
    
    private boolean doPlace(final WorldGenLevel p_160511_, final Random p_160512_, BlockPos p_160513_, final BiConsumer<BlockPos, BlockState> p_160514_, final BiConsumer<BlockPos, BlockState> p_160515_, final TreeConfiguration p_160516_) {
        final int i = p_160516_.f_68190_.m_70309_(p_160512_);
        final int j = p_160516_.f_68189_.m_5969_(p_160512_, i, p_160516_);
        final int k = i - j;
        final int l = p_160516_.f_68189_.m_5937_(p_160512_, k);
        p_160513_ = new BlockPos(p_160513_.m_123341_(), this.validPos.m_123342_(), p_160513_.m_123343_());
        if (p_160513_.m_123342_() < p_160511_.m_141937_() + 1 || p_160513_.m_123342_() + i + 1 > p_160511_.m_151558_()) {
            return false;
        }
        if (!p_160516_.f_161214_.m_7112_(p_160512_, p_160513_).m_60710_((LevelReader)p_160511_, p_160513_)) {
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
    
    private int getMaxFreeTreeHeight(final LevelSimulatedReader level, final int trunkHeight, final BlockPos pos, final TreeConfiguration config) {
        final BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
        for (int i = 0; i <= trunkHeight + 1; ++i) {
            for (int j = config.f_68191_.m_6133_(trunkHeight, i), k = -j; k <= j; ++k) {
                for (int l = -j; l <= j; ++l) {
                    mutable.m_122154_((Vec3i)pos, k, i, l);
                    if (!isFree(level, (BlockPos)mutable) || !config.f_68193_) {
                        return i - 2;
                    }
                }
            }
        }
        return trunkHeight;
    }
    
    protected void m_5974_(final LevelWriter world, final BlockPos pos, final BlockState state) {
        setBlockKnownShape(world, pos, state);
    }
    
    public static void setBlockKnownShape(final LevelWriter p_236408_0_, final BlockPos p_236408_1_, final BlockState p_236408_2_) {
        p_236408_0_.m_7731_(p_236408_1_, p_236408_2_, 19);
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
    
    public static boolean isFree(final LevelSimulatedReader pLevel, final BlockPos pPos) {
        return validTreePos(pLevel, pPos) || pLevel.m_7433_(pPos, p_67281_ -> p_67281_.m_60620_((Tag)BlockTags.f_13106_));
    }
    
    private static boolean isBlockWater(final LevelSimulatedReader pLevel, final BlockPos pPos) {
        return pLevel.m_7433_(pPos, p_67271_ -> p_67271_.m_60713_(Blocks.f_49990_));
    }
    
    public static boolean isAirOrLeaves(final LevelSimulatedReader pLevel, final BlockPos pPos) {
        return pLevel.m_7433_(pPos, p_67266_ -> p_67266_.m_60795_() || p_67266_.m_60620_((Tag)BlockTags.f_13035_) || p_67266_.m_60713_((Block)TFBlocks.HARDENED_DARK_LEAVES.get()));
    }
    
    private static boolean isReplaceablePlant(final LevelSimulatedReader pLevel, final BlockPos pPos) {
        return pLevel.m_7433_(pPos, p_160551_ -> {
            final Material material = p_160551_.m_60767_();
            return material == Material.f_76302_;
        });
    }
    
    public static boolean validTreePos(final LevelSimulatedReader pLevel, final BlockPos pPos) {
        return isAirOrLeaves(pLevel, pPos) || isReplaceablePlant(pLevel, pPos) || isBlockWater(pLevel, pPos);
    }
}
