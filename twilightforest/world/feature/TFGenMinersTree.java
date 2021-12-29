// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import twilightforest.util.FeatureUtil;
import net.minecraft.state.Property;
import net.minecraft.block.RotatedPillarBlock;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.Direction;
import net.minecraft.util.math.MutableBoundingBox;
import java.util.Set;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.IWorld;
import com.mojang.serialization.Codec;
import twilightforest.world.feature.config.TFTreeFeatureConfig;

public class TFGenMinersTree extends TFTreeGenerator<TFTreeFeatureConfig>
{
    public TFGenMinersTree(final Codec<TFTreeFeatureConfig> config) {
        super(config);
    }
    
    @Override
    protected boolean generate(final IWorld world, final Random rand, final BlockPos pos, final Set<BlockPos> trunk, final Set<BlockPos> leaves, final Set<BlockPos> branch, final Set<BlockPos> root, final MutableBoundingBox mbb, final TFTreeFeatureConfig config) {
        if (pos.func_177956_o() >= 244) {
            return false;
        }
        final BlockState state = world.func_180495_p(pos.func_177977_b());
        if (!state.func_177230_c().canSustainPlant(state, (IBlockReader)world, pos.func_177977_b(), Direction.UP, config.getSapling(rand, pos))) {
            return false;
        }
        for (int dy = 0; dy <= 9; ++dy) {
            this.setLogBlockState(world, rand, pos.func_177981_b(dy), trunk, mbb, config);
        }
        this.putBranchWithLeaves(world, rand, pos.func_177982_a(0, 9, 1), leaves, branch, true, mbb, config);
        this.putBranchWithLeaves(world, rand, pos.func_177982_a(0, 9, 2), leaves, branch, false, mbb, config);
        this.putBranchWithLeaves(world, rand, pos.func_177982_a(0, 8, 3), leaves, branch, false, mbb, config);
        this.putBranchWithLeaves(world, rand, pos.func_177982_a(0, 7, 4), leaves, branch, false, mbb, config);
        this.putBranchWithLeaves(world, rand, pos.func_177982_a(0, 6, 5), leaves, branch, false, mbb, config);
        this.putBranchWithLeaves(world, rand, pos.func_177982_a(0, 9, -1), leaves, branch, true, mbb, config);
        this.putBranchWithLeaves(world, rand, pos.func_177982_a(0, 9, -2), leaves, branch, false, mbb, config);
        this.putBranchWithLeaves(world, rand, pos.func_177982_a(0, 8, -3), leaves, branch, false, mbb, config);
        this.putBranchWithLeaves(world, rand, pos.func_177982_a(0, 7, -4), leaves, branch, false, mbb, config);
        this.putBranchWithLeaves(world, rand, pos.func_177982_a(0, 6, -5), leaves, branch, false, mbb, config);
        world.func_180501_a(pos.func_177984_a(), (BlockState)((Block)TFBlocks.mining_log_core.get()).func_176223_P().func_206870_a((Property)RotatedPillarBlock.field_176298_M, (Comparable)Direction.Axis.Y), 3);
        world.func_205220_G_().func_205360_a(pos.func_177984_a(), (Object)TFBlocks.mining_log_core.get(), 20);
        if (FeatureUtil.hasAirAround(world, pos.func_177977_b())) {
            this.setLogBlockState(world, rand, pos.func_177977_b(), trunk, mbb, config);
        }
        else {
            this.setRootsBlockState(world, rand, pos.func_177977_b(), root, mbb, config);
        }
        final int numRoots = 3 + rand.nextInt(2);
        final double offset = rand.nextDouble();
        for (int b = 0; b < numRoots; ++b) {
            this.buildRoot(world, rand, pos, root, offset, b, mbb, config);
        }
        return true;
    }
    
    protected void putBranchWithLeaves(final IWorld world, final Random rand, final BlockPos pos, final Set<BlockPos> leaves, final Set<BlockPos> branch, final boolean bushy, final MutableBoundingBox mbb, final TFTreeFeatureConfig config) {
        this.setBranchBlockState(world, rand, pos, branch, mbb, config);
        for (int lx = -1; lx <= 1; ++lx) {
            for (int ly = -1; ly <= 1; ++ly) {
                for (int lz = -1; lz <= 1; ++lz) {
                    if (bushy || Math.abs(ly) <= 0 || Math.abs(lx) <= 0) {
                        FeatureUtil.putLeafBlock(world, pos.func_177982_a(lx, ly, lz), config.leavesProvider.func_225574_a_(rand, pos.func_177982_a(lx, ly, lz)), leaves);
                    }
                }
            }
        }
    }
}
