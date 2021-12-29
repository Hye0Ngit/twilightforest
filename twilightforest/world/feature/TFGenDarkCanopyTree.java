// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.state.Property;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.shapes.BitSetVoxelShapePart;
import net.minecraft.block.BlockState;
import net.minecraft.world.IWorldWriter;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import java.util.OptionalInt;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.util.math.shapes.VoxelShapePart;
import java.util.List;
import java.util.Set;
import java.util.Iterator;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.IWorld;
import java.util.Comparator;
import net.minecraft.util.math.vector.Vector3i;
import com.google.common.collect.Lists;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.util.math.MutableBoundingBox;
import com.google.common.collect.Sets;
import net.minecraft.util.Direction;
import net.minecraft.block.material.Material;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.ISeedReader;
import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class TFGenDarkCanopyTree extends Feature<BaseTreeFeatureConfig>
{
    int difference;
    BlockPos validPos;
    
    public TFGenDarkCanopyTree(final Codec<BaseTreeFeatureConfig> config) {
        super((Codec)config);
        this.difference = 0;
        this.validPos = new BlockPos(0, 0, 0);
    }
    
    public boolean generate(final ISeedReader reader, final ChunkGenerator generator, final Random rand, BlockPos pos, final BaseTreeFeatureConfig config) {
        boolean foundDirt = false;
        for (int dy = pos.func_177956_o(); dy >= 0; --dy) {
            final Material materialUnder = reader.func_180495_p(new BlockPos(pos.func_177958_n(), dy - 1, pos.func_177952_p())).func_185904_a();
            if (materialUnder == Material.field_151577_b || materialUnder == Material.field_151578_c) {
                foundDirt = true;
                pos = new BlockPos(pos.func_177958_n(), dy, pos.func_177952_p());
                this.validPos = pos;
                break;
            }
            if (materialUnder == Material.field_151576_e) {
                break;
            }
            if (materialUnder == Material.field_151595_p) {
                break;
            }
        }
        if (!foundDirt) {
            return false;
        }
        for (final Direction e : Direction.Plane.HORIZONTAL) {
            if (reader.func_180495_p(pos.func_177972_a(e)).func_185904_a() == Material.field_151575_d) {
                return false;
            }
        }
        final Set<BlockPos> set = Sets.newHashSet();
        final Set<BlockPos> set2 = Sets.newHashSet();
        final Set<BlockPos> set3 = Sets.newHashSet();
        final MutableBoundingBox mutableboundingbox = MutableBoundingBox.func_78887_a();
        final boolean flag = this.place((IWorldGenerationReader)reader, rand, pos, set, set2, mutableboundingbox, config);
        this.difference = mutableboundingbox.field_78895_b - pos.func_177956_o();
        mutableboundingbox.field_78895_b = pos.func_177956_o();
        mutableboundingbox.field_78894_e -= this.difference;
        if (flag && !set.isEmpty()) {
            if (!config.field_227370_o_.isEmpty()) {
                final List<BlockPos> list = Lists.newArrayList((Iterable)set);
                final List<BlockPos> list2 = Lists.newArrayList((Iterable)set2);
                list.sort(Comparator.comparingInt(Vector3i::func_177956_o));
                list2.sort(Comparator.comparingInt(Vector3i::func_177956_o));
                config.field_227370_o_.forEach(p_236405_6_ -> p_236405_6_.func_225576_a_(reader, rand, list, list1, set2, mutableboundingbox));
            }
            final VoxelShapePart voxelshapepart = this.func_236403_a_((IWorld)reader, mutableboundingbox, set, set3);
            Template.func_222857_a((IWorld)reader, 3, voxelshapepart, mutableboundingbox.field_78897_a, mutableboundingbox.field_78895_b, mutableboundingbox.field_78896_c);
            return true;
        }
        return false;
    }
    
    private boolean place(final IWorldGenerationReader generationReader, final Random rand, final BlockPos positionIn, final Set<BlockPos> p_225557_4_, final Set<BlockPos> p_225557_5_, final MutableBoundingBox boundingBoxIn, final BaseTreeFeatureConfig configIn) {
        final int i = configIn.field_236678_g_.func_236917_a_(rand);
        final int j = configIn.field_236677_f_.func_230374_a_(rand, i, configIn);
        final int k = i - j;
        final int l = configIn.field_236677_f_.func_230376_a_(rand, k);
        BlockPos blockpos;
        if (!configIn.field_227372_q_) {
            final int i2 = generationReader.func_205770_a(Heightmap.Type.OCEAN_FLOOR, positionIn).func_177956_o();
            final int j2 = generationReader.func_205770_a(Heightmap.Type.WORLD_SURFACE, positionIn).func_177956_o();
            if (j2 - i2 > configIn.field_236680_i_) {
                return false;
            }
            blockpos = new BlockPos(positionIn.func_177958_n(), this.validPos.func_177956_o(), positionIn.func_177952_p());
        }
        else {
            blockpos = positionIn;
        }
        if (blockpos.func_177956_o() < 1 || blockpos.func_177956_o() + i + 1 > 256) {
            return false;
        }
        final OptionalInt optionalint = configIn.field_236679_h_.func_236710_c_();
        final int l2 = this.func_241521_a_((IWorldGenerationBaseReader)generationReader, i, blockpos, configIn);
        if (l2 >= i || (optionalint.isPresent() && l2 >= optionalint.getAsInt())) {
            final List<FoliagePlacer.Foliage> list = configIn.field_236678_g_.func_230382_a_(generationReader, rand, l2, blockpos, (Set)p_225557_4_, boundingBoxIn, configIn);
            list.forEach(p_236407_8_ -> configIn.field_236677_f_.func_236752_a_(generationReader, rand, configIn, l1, p_236407_8_, j, l, p_225557_5_, boundingBoxIn));
            return true;
        }
        return false;
    }
    
    private int func_241521_a_(final IWorldGenerationBaseReader p_241521_1_, final int p_241521_2_, final BlockPos p_241521_3_, final BaseTreeFeatureConfig p_241521_4_) {
        final BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
        for (int i = 0; i <= p_241521_2_ + 1; ++i) {
            for (int j = p_241521_4_.field_236679_h_.func_230369_a_(p_241521_2_, i), k = -j; k <= j; ++k) {
                for (int l = -j; l <= j; ++l) {
                    blockpos$mutable.func_239621_a_((Vector3i)p_241521_3_, k, i, l);
                    if (!p_241521_4_.field_236681_j_) {
                        return i - 2;
                    }
                }
            }
        }
        return p_241521_2_;
    }
    
    protected void func_230367_a_(final IWorldWriter world, final BlockPos pos, final BlockState state) {
        func_236408_b_(world, pos, state);
    }
    
    public static void func_236408_b_(final IWorldWriter p_236408_0_, final BlockPos p_236408_1_, final BlockState p_236408_2_) {
        p_236408_0_.func_180501_a(p_236408_1_, p_236408_2_, 19);
    }
    
    private VoxelShapePart func_236403_a_(final IWorld p_236403_1_, final MutableBoundingBox p_236403_2_, final Set<BlockPos> p_236403_3_, final Set<BlockPos> p_236403_4_) {
        final List<Set<BlockPos>> list = Lists.newArrayList();
        final VoxelShapePart voxelshapepart = (VoxelShapePart)new BitSetVoxelShapePart(p_236403_2_.func_78883_b(), p_236403_2_.func_78882_c(), p_236403_2_.func_78880_d());
        for (int j = 0; j < 6; ++j) {
            list.add(Sets.newHashSet());
        }
        final BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
        for (final BlockPos blockpos : Lists.newArrayList((Iterable)p_236403_4_)) {
            if (p_236403_2_.func_175898_b((Vector3i)blockpos)) {
                voxelshapepart.func_199625_a(blockpos.func_177958_n() - p_236403_2_.field_78897_a, blockpos.func_177956_o() - p_236403_2_.field_78895_b, blockpos.func_177952_p() - p_236403_2_.field_78896_c, true, true);
            }
        }
        for (final BlockPos blockpos2 : Lists.newArrayList((Iterable)p_236403_3_)) {
            if (p_236403_2_.func_175898_b((Vector3i)blockpos2)) {
                voxelshapepart.func_199625_a(blockpos2.func_177958_n() - p_236403_2_.field_78897_a, blockpos2.func_177956_o() - p_236403_2_.field_78895_b, blockpos2.func_177952_p() - p_236403_2_.field_78896_c, true, true);
            }
            for (final Direction direction : Direction.values()) {
                blockpos$mutable.func_239622_a_((Vector3i)blockpos2, direction);
                if (!p_236403_3_.contains(blockpos$mutable)) {
                    final BlockState blockstate = p_236403_1_.func_180495_p((BlockPos)blockpos$mutable);
                    if (blockstate.func_235901_b_((Property)BlockStateProperties.field_208514_aa)) {
                        list.get(0).add(blockpos$mutable.func_185334_h());
                        func_236408_b_((IWorldWriter)p_236403_1_, (BlockPos)blockpos$mutable, (BlockState)blockstate.func_206870_a((Property)BlockStateProperties.field_208514_aa, (Comparable)1));
                        if (p_236403_2_.func_175898_b((Vector3i)blockpos$mutable)) {
                            voxelshapepart.func_199625_a(blockpos$mutable.func_177958_n() - p_236403_2_.field_78897_a, blockpos$mutable.func_177956_o() - p_236403_2_.field_78895_b, blockpos$mutable.func_177952_p() - p_236403_2_.field_78896_c, true, true);
                        }
                    }
                }
            }
        }
        for (int l = 1; l < 6; ++l) {
            final Set<BlockPos> set = list.get(l - 1);
            final Set<BlockPos> set2 = list.get(l);
            for (final BlockPos blockpos3 : set) {
                if (p_236403_2_.func_175898_b((Vector3i)blockpos3)) {
                    voxelshapepart.func_199625_a(blockpos3.func_177958_n() - p_236403_2_.field_78897_a, blockpos3.func_177956_o() - p_236403_2_.field_78895_b, blockpos3.func_177952_p() - p_236403_2_.field_78896_c, true, true);
                }
                for (final Direction direction2 : Direction.values()) {
                    blockpos$mutable.func_239622_a_((Vector3i)blockpos3, direction2);
                    if (!set.contains(blockpos$mutable) && !set2.contains(blockpos$mutable)) {
                        final BlockState blockstate2 = p_236403_1_.func_180495_p((BlockPos)blockpos$mutable);
                        if (blockstate2.func_235901_b_((Property)BlockStateProperties.field_208514_aa)) {
                            final int k = (int)blockstate2.func_177229_b((Property)BlockStateProperties.field_208514_aa);
                            if (k > l + 1) {
                                final BlockState blockstate3 = (BlockState)blockstate2.func_206870_a((Property)BlockStateProperties.field_208514_aa, (Comparable)(l + 1));
                                func_236408_b_((IWorldWriter)p_236403_1_, (BlockPos)blockpos$mutable, blockstate3);
                                if (p_236403_2_.func_175898_b((Vector3i)blockpos$mutable)) {
                                    voxelshapepart.func_199625_a(blockpos$mutable.func_177958_n() - p_236403_2_.field_78897_a, blockpos$mutable.func_177956_o() - p_236403_2_.field_78895_b, blockpos$mutable.func_177952_p() - p_236403_2_.field_78896_c, true, true);
                                }
                                set2.add(blockpos$mutable.func_185334_h());
                            }
                        }
                    }
                }
            }
        }
        return voxelshapepart;
    }
}
