// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import twilightforest.block.TFBlocks;
import net.minecraft.world.IBlockReader;
import twilightforest.util.FeatureUtil;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import java.util.Iterator;
import java.util.List;
import net.minecraft.world.IWorldWriter;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.block.BlockState;
import net.minecraft.state.Property;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.util.math.shapes.BitSetVoxelShapePart;
import com.google.common.collect.Lists;
import net.minecraft.util.math.shapes.VoxelShapePart;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.ISeedReader;
import com.google.common.collect.Sets;
import net.minecraft.util.math.MutableBoundingBox;
import java.util.Set;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.IWorld;
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.feature.Feature;
import twilightforest.world.feature.config.TFTreeFeatureConfig;

public abstract class TFTreeGenerator<T extends TFTreeFeatureConfig> extends Feature<T>
{
    public TFTreeGenerator(final Codec<T> configIn) {
        super((Codec)configIn);
    }
    
    protected boolean generate(final IWorld world, final Random random, final BlockPos pos, final Set<BlockPos> logpos, final Set<BlockPos> leavespos, final MutableBoundingBox mbb, final T config) {
        final Set<BlockPos> branchSet = Sets.newHashSet();
        final Set<BlockPos> rootSet = Sets.newHashSet();
        return this.generate(world, random, pos, logpos, leavespos, branchSet, rootSet, mbb, config);
    }
    
    public boolean generate(final ISeedReader world, final ChunkGenerator generator, final Random random, final BlockPos pos, final T config) {
        final Set<BlockPos> logs = Sets.newHashSet();
        final Set<BlockPos> leaves = Sets.newHashSet();
        final MutableBoundingBox mutableboundingbox = MutableBoundingBox.func_78887_a();
        final boolean flag = this.generate((IWorld)world, random, pos, logs, leaves, mutableboundingbox, config);
        if (mutableboundingbox.field_78897_a <= mutableboundingbox.field_78893_d && flag && !logs.isEmpty()) {
            final VoxelShapePart voxelshapepart = this.getVoxelShapePart((IWorld)world, mutableboundingbox, logs);
            Template.func_222857_a((IWorld)world, 3, voxelshapepart, mutableboundingbox.field_78897_a, mutableboundingbox.field_78895_b, mutableboundingbox.field_78896_c);
            return true;
        }
        return false;
    }
    
    private VoxelShapePart getVoxelShapePart(final IWorld world, final MutableBoundingBox mbb, final Set<BlockPos> logPosSet) {
        final List<Set<BlockPos>> list = Lists.newArrayList();
        final VoxelShapePart voxelshapepart = (VoxelShapePart)new BitSetVoxelShapePart(mbb.func_78883_b(), mbb.func_78882_c(), mbb.func_78880_d());
        for (int j = 0; j < 6; ++j) {
            list.add(Sets.newHashSet());
        }
        final BlockPos.Mutable mutable = new BlockPos.Mutable();
        for (final BlockPos logPos : Lists.newArrayList((Iterable)logPosSet)) {
            if (mbb.func_175898_b((Vector3i)logPos)) {
                voxelshapepart.func_199625_a(logPos.func_177958_n() - mbb.field_78897_a, logPos.func_177956_o() - mbb.field_78895_b, logPos.func_177952_p() - mbb.field_78896_c, true, true);
            }
            for (final Direction direction : Direction.values()) {
                mutable.func_239622_a_((Vector3i)logPos, direction);
                if (!logPosSet.contains(mutable)) {
                    final BlockState blockstate = world.func_180495_p((BlockPos)mutable);
                    if (blockstate.func_235901_b_((Property)BlockStateProperties.field_208514_aa)) {
                        list.get(0).add(mutable.func_185334_h());
                        TreeFeature.func_236408_b_((IWorldWriter)world, (BlockPos)mutable, (BlockState)blockstate.func_206870_a((Property)BlockStateProperties.field_208514_aa, (Comparable)1));
                        if (mbb.func_175898_b((Vector3i)mutable)) {
                            voxelshapepart.func_199625_a(mutable.func_177958_n() - mbb.field_78897_a, mutable.func_177956_o() - mbb.field_78895_b, mutable.func_177952_p() - mbb.field_78896_c, true, true);
                        }
                    }
                }
            }
        }
        for (int l = 1; l < 6; ++l) {
            final Set<BlockPos> set = list.get(l - 1);
            final Set<BlockPos> set2 = list.get(l);
            for (final BlockPos blockpos2 : set) {
                if (mbb.func_175898_b((Vector3i)blockpos2)) {
                    voxelshapepart.func_199625_a(blockpos2.func_177958_n() - mbb.field_78897_a, blockpos2.func_177956_o() - mbb.field_78895_b, blockpos2.func_177952_p() - mbb.field_78896_c, true, true);
                }
                for (final Direction direction2 : Direction.values()) {
                    mutable.func_239622_a_((Vector3i)blockpos2, direction2);
                    if (!set.contains(mutable) && !set2.contains(mutable)) {
                        final BlockState blockstate2 = world.func_180495_p((BlockPos)mutable);
                        if (blockstate2.func_235901_b_((Property)BlockStateProperties.field_208514_aa)) {
                            final int k = (int)blockstate2.func_177229_b((Property)BlockStateProperties.field_208514_aa);
                            if (k > l + 1) {
                                final BlockState blockstate3 = (BlockState)blockstate2.func_206870_a((Property)BlockStateProperties.field_208514_aa, (Comparable)(l + 1));
                                TreeFeature.func_236408_b_((IWorldWriter)world, (BlockPos)mutable, blockstate3);
                                if (mbb.func_175898_b((Vector3i)mutable)) {
                                    voxelshapepart.func_199625_a(mutable.func_177958_n() - mbb.field_78897_a, mutable.func_177956_o() - mbb.field_78895_b, mutable.func_177952_p() - mbb.field_78896_c, true, true);
                                }
                                set2.add(mutable.func_185334_h());
                            }
                        }
                    }
                }
            }
        }
        return voxelshapepart;
    }
    
    protected abstract boolean generate(final IWorld p0, final Random p1, final BlockPos p2, final Set<BlockPos> p3, final Set<BlockPos> p4, final Set<BlockPos> p5, final Set<BlockPos> p6, final MutableBoundingBox p7, final T p8);
    
    protected boolean setLogBlockState(final IWorld world, final Random random, final BlockPos pos, final Set<BlockPos> logPos, final MutableBoundingBox mbb, final TFTreeFeatureConfig config) {
        if (TreeFeature.func_236404_a_((IWorldGenerationBaseReader)world, pos)) {
            this.setBlockState((IWorldWriter)world, pos, config.trunkProvider.func_225574_a_(random, pos), mbb);
            logPos.add(pos.func_185334_h());
            return true;
        }
        return false;
    }
    
    protected boolean setLeavesBlockState(final IWorld world, final Random random, final BlockPos pos, final Set<BlockPos> leavesPos, final MutableBoundingBox mbb, final TFTreeFeatureConfig config) {
        if (TreeFeature.func_236404_a_((IWorldGenerationBaseReader)world, pos)) {
            this.setBlockState((IWorldWriter)world, pos, config.leavesProvider.func_225574_a_(random, pos), mbb);
            leavesPos.add(pos.func_185334_h());
            return true;
        }
        return false;
    }
    
    public boolean setBranchBlockState(final IWorld world, final Random random, final BlockPos pos, final Set<BlockPos> branchpos, final MutableBoundingBox mbb, final TFTreeFeatureConfig config) {
        if (TreeFeature.func_236404_a_((IWorldGenerationBaseReader)world, pos)) {
            this.setBlockState((IWorldWriter)world, pos, config.branchProvider.func_225574_a_(random, pos), mbb);
            branchpos.add(pos.func_185334_h());
            return true;
        }
        return false;
    }
    
    protected boolean setRootsBlockState(final IWorld world, final Random random, final BlockPos pos, final Set<BlockPos> branchpos, final MutableBoundingBox mbb, final TFTreeFeatureConfig config) {
        if (canRootGrowIn((IWorldReader)world, pos)) {
            this.setBlockState((IWorldWriter)world, pos, config.rootsProvider.func_225574_a_(random, pos), mbb);
            branchpos.add(pos.func_185334_h());
            return true;
        }
        return false;
    }
    
    protected final void setBlockState(final IWorldWriter world, final BlockPos pos, final BlockState state, final MutableBoundingBox mbb) {
        world.func_180501_a(pos, state, 19);
        mbb.func_78888_b(new MutableBoundingBox((Vector3i)pos, (Vector3i)pos));
    }
    
    protected void buildRoot(final IWorld world, final Random rand, final BlockPos pos, final Set<BlockPos> setpos, final double offset, final int b, final MutableBoundingBox mbb, final T config) {
        final BlockPos dest = FeatureUtil.translate(pos.func_177979_c(b + 2), 5.0, 0.3 * b + offset, 0.8);
        final BlockPos[] bresenhamArrays;
        final BlockPos[] lineArray = bresenhamArrays = FeatureUtil.getBresenhamArrays(pos.func_177977_b(), dest);
        for (final BlockPos coord : bresenhamArrays) {
            this.setRootsBlockState(world, rand, coord, setpos, mbb, config);
        }
    }
    
    public static boolean canRootGrowIn(final IWorldReader world, final BlockPos pos) {
        final BlockState blockState = world.func_180495_p(pos);
        final Block blockID = blockState.func_177230_c();
        if (blockState.isAir((IBlockReader)world, pos)) {
            return FeatureUtil.isNearSolid(world, pos);
        }
        return blockState.func_185887_b((IBlockReader)world, pos) >= 0.0f && blockID != TFBlocks.stronghold_shield.get() && blockID != TFBlocks.trophy_pedestal.get() && blockID != TFBlocks.boss_spawner_naga.get() && blockID != TFBlocks.boss_spawner_lich.get() && blockID != TFBlocks.boss_spawner_hydra.get() && blockID != TFBlocks.boss_spawner_ur_ghast.get() && blockID != TFBlocks.boss_spawner_knight_phantom.get() && blockID != TFBlocks.boss_spawner_snow_queen.get() && blockID != TFBlocks.boss_spawner_minoshroom.get() && blockID != TFBlocks.boss_spawner_alpha_yeti.get() && (blockState.func_185904_a() == Material.field_151577_b || blockState.func_185904_a() == Material.field_151578_c || blockState.func_185904_a() == Material.field_151576_e || blockState.func_185904_a() == Material.field_151586_h);
    }
    
    protected void addFirefly(final IWorld world, final BlockPos pos, final int height, final double angle) {
        final int iAngle = (int)(angle * 4.0);
        if (iAngle == 0) {
            this.setIfEmpty(world, pos.func_177982_a(1, height, 0), (BlockState)((Block)TFBlocks.firefly.get()).func_176223_P().func_206870_a((Property)DirectionalBlock.field_176387_N, (Comparable)Direction.EAST));
        }
        else if (iAngle == 1) {
            this.setIfEmpty(world, pos.func_177982_a(-1, height, 0), (BlockState)((Block)TFBlocks.firefly.get()).func_176223_P().func_206870_a((Property)DirectionalBlock.field_176387_N, (Comparable)Direction.WEST));
        }
        else if (iAngle == 2) {
            this.setIfEmpty(world, pos.func_177982_a(0, height, 1), (BlockState)((Block)TFBlocks.firefly.get()).func_176223_P().func_206870_a((Property)DirectionalBlock.field_176387_N, (Comparable)Direction.SOUTH));
        }
        else if (iAngle == 3) {
            this.setIfEmpty(world, pos.func_177982_a(0, height, -1), (BlockState)((Block)TFBlocks.firefly.get()).func_176223_P().func_206870_a((Property)DirectionalBlock.field_176387_N, (Comparable)Direction.NORTH));
        }
    }
    
    private void setIfEmpty(final IWorld world, final BlockPos pos, final BlockState state) {
        if (world.func_175623_d(pos)) {
            world.func_180501_a(pos, state, 3);
        }
    }
}
