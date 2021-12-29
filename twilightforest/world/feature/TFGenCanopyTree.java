// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import java.util.Iterator;
import net.minecraft.block.BlockState;
import twilightforest.util.FeatureUtil;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.Direction;
import net.minecraft.util.math.MutableBoundingBox;
import java.util.Set;
import java.util.Random;
import net.minecraft.world.IWorld;
import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import java.util.List;
import twilightforest.world.feature.config.TFTreeFeatureConfig;

public class TFGenCanopyTree extends TFTreeGenerator<TFTreeFeatureConfig>
{
    private List<BlockPos> leaves;
    
    public TFGenCanopyTree(final Codec<TFTreeFeatureConfig> config) {
        super(config);
        this.leaves = Lists.newArrayList();
    }
    
    @Override
    protected boolean generate(final IWorld world, final Random random, final BlockPos pos, final Set<BlockPos> trunk, final Set<BlockPos> leaves, final Set<BlockPos> branch, final Set<BlockPos> root, final MutableBoundingBox mbb, final TFTreeFeatureConfig config) {
        int treeHeight = config.minHeight;
        if (random.nextInt(config.chanceAddFiveFirst) == 0) {
            treeHeight += random.nextInt(5);
            if (random.nextInt(config.chanceAddFiveSecond) == 0) {
                treeHeight += random.nextInt(5);
            }
        }
        if (pos.func_177956_o() >= 256 - treeHeight) {
            return false;
        }
        final BlockState state = world.func_180495_p(pos.func_177977_b());
        if (!state.func_177230_c().canSustainPlant(state, (IBlockReader)world, pos.func_177977_b(), Direction.UP, config.getSapling(random, pos))) {
            return false;
        }
        this.leaves.clear();
        this.buildBranch(world, pos, trunk, branch, 0, treeHeight, 0.0, 0.0, true, random, mbb, config);
        final int numBranches = 3 + random.nextInt(2);
        float offset = random.nextFloat();
        for (int b = 0; b < numBranches; ++b) {
            this.buildBranch(world, pos, trunk, branch, treeHeight - 10 + b, 9.0, 0.3 * b + offset, 0.2, false, random, mbb, config);
        }
        if (config.hasLeaves) {
            for (final BlockPos leafPos : this.leaves) {
                this.makeLeafBlob(world, random, leafPos, leaves, config);
            }
        }
        if (FeatureUtil.hasAirAround(world, pos.func_177977_b())) {
            this.setLogBlockState(world, random, pos.func_177977_b(), trunk, mbb, config);
        }
        else {
            this.setRootsBlockState(world, random, pos.func_177977_b(), root, mbb, config);
        }
        final int numRoots = 3 + random.nextInt(2);
        offset = random.nextFloat();
        for (int b2 = 0; b2 < numRoots; ++b2) {
            this.buildRoot(world, random, pos, root, offset, b2, mbb, config);
        }
        return true;
    }
    
    private void makeLeafBlob(final IWorld world, final Random random, final BlockPos leafPos, final Set<BlockPos> setLeaves, final TFTreeFeatureConfig config) {
        FeatureUtil.makeLeafCircle(world, leafPos.func_177977_b(), 3, config.leavesProvider.func_225574_a_(random, leafPos.func_177977_b()), setLeaves, true);
        FeatureUtil.makeLeafCircle(world, leafPos, 4, config.leavesProvider.func_225574_a_(random, leafPos), setLeaves, true);
        FeatureUtil.makeLeafCircle(world, leafPos.func_177984_a(), 2, config.leavesProvider.func_225574_a_(random, leafPos.func_177984_a()), setLeaves, true);
    }
    
    void buildBranch(final IWorld world, final BlockPos pos, final Set<BlockPos> logpos, final Set<BlockPos> branchpos, final int height, final double length, final double angle, final double tilt, final boolean trunk, final Random treeRNG, final MutableBoundingBox mbb, final TFTreeFeatureConfig config) {
        final BlockPos src = pos.func_177981_b(height);
        final BlockPos dest = FeatureUtil.translate(src, length, angle, tilt);
        if (world.isAreaLoaded(dest, 5)) {
            if (trunk) {
                FeatureUtil.drawBresenhamTree(world, src, dest, config.trunkProvider.func_225574_a_(treeRNG, src), logpos);
            }
            else {
                FeatureUtil.drawBresenhamBranch(this, world, treeRNG, src, dest, branchpos, mbb, config);
            }
            if (trunk) {
                this.addFirefly(world, pos, 3 + treeRNG.nextInt(7), treeRNG.nextDouble());
            }
            this.setBranchBlockState(world, treeRNG, dest.func_177974_f(), branchpos, mbb, config);
            this.setBranchBlockState(world, treeRNG, dest.func_177976_e(), branchpos, mbb, config);
            this.setBranchBlockState(world, treeRNG, dest.func_177968_d(), branchpos, mbb, config);
            this.setBranchBlockState(world, treeRNG, dest.func_177978_c(), branchpos, mbb, config);
            this.leaves.add(dest);
        }
    }
}
