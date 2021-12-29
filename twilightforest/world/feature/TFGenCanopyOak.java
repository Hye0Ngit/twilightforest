// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import twilightforest.util.FeatureUtil;
import java.util.Iterator;
import net.minecraft.block.BlockState;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.Direction;
import net.minecraft.util.math.MutableBoundingBox;
import java.util.Set;
import java.util.Random;
import net.minecraft.world.IWorld;
import com.google.common.collect.Lists;
import twilightforest.world.feature.config.TFTreeFeatureConfig;
import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import java.util.List;

public class TFGenCanopyOak extends TFGenCanopyTree
{
    private final List<BlockPos> leaves;
    
    public TFGenCanopyOak(final Codec<TFTreeFeatureConfig> config) {
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
        this.buildTrunk(world, random, pos, trunk, treeHeight, mbb, config);
        final int numBranches = 12 + random.nextInt(9);
        float bangle = random.nextFloat();
        for (int b = 0; b < numBranches; ++b) {
            final float btilt = 0.15f + random.nextFloat() * 0.35f;
            this.buildBranch(world, pos, trunk, branch, treeHeight - 10 + b / 2, 5.0, bangle, btilt, false, random, mbb, config);
            bangle += random.nextFloat() * 0.4f;
            if (bangle > 1.0f) {
                --bangle;
            }
        }
        for (final BlockPos leafPos : leaves) {
            this.makeLeafBlob(world, random, leafPos, leaves, config);
        }
        this.makeRoots(world, random, pos, trunk, root, mbb, config);
        this.makeRoots(world, random, pos.func_177974_f(), trunk, root, mbb, config);
        this.makeRoots(world, random, pos.func_177968_d(), trunk, root, mbb, config);
        this.makeRoots(world, random, pos.func_177974_f().func_177968_d(), trunk, root, mbb, config);
        return true;
    }
    
    private void makeLeafBlob(final IWorld world, final Random rand, final BlockPos leafPos, final Set<BlockPos> setLeaves, final TFTreeFeatureConfig config) {
        FeatureUtil.drawLeafBlob(world, leafPos, 2, config.leavesProvider.func_225574_a_(rand, leafPos), setLeaves);
    }
    
    private void makeRoots(final IWorld world, final Random random, final BlockPos pos, final Set<BlockPos> trunk, final Set<BlockPos> root, final MutableBoundingBox mbb, final TFTreeFeatureConfig config) {
        if (FeatureUtil.hasAirAround(world, pos.func_177977_b())) {
            this.setLogBlockState(world, random, pos.func_177977_b(), trunk, mbb, config);
        }
        else {
            this.setRootsBlockState(world, random, pos.func_177977_b(), root, mbb, config);
        }
        final int numRoots = 1 + random.nextInt(2);
        final float offset = random.nextFloat();
        for (int b = 0; b < numRoots; ++b) {
            this.buildRoot(world, random, pos, root, offset, b, mbb, config);
        }
    }
    
    private void buildTrunk(final IWorld world, final Random rand, final BlockPos pos, final Set<BlockPos> trunk, final int treeHeight, final MutableBoundingBox mbb, final TFTreeFeatureConfig config) {
        for (int dy = 0; dy < treeHeight; ++dy) {
            this.setLogBlockState(world, rand, pos.func_177982_a(0, dy, 0), trunk, mbb, config);
            this.setLogBlockState(world, rand, pos.func_177982_a(1, dy, 0), trunk, mbb, config);
            this.setLogBlockState(world, rand, pos.func_177982_a(0, dy, 1), trunk, mbb, config);
            this.setLogBlockState(world, rand, pos.func_177982_a(1, dy, 1), trunk, mbb, config);
        }
        this.leaves.add(pos.func_177982_a(0, treeHeight, 0));
    }
    
    @Override
    void buildBranch(final IWorld world, final BlockPos pos, final Set<BlockPos> logpos, final Set<BlockPos> branchpos, final int height, final double length, final double angle, final double tilt, final boolean trunk, final Random treeRNG, final MutableBoundingBox mbb, final TFTreeFeatureConfig config) {
        final BlockPos src = pos.func_177981_b(height);
        BlockPos dest = FeatureUtil.translate(src, length, angle, tilt);
        final int limit = 5;
        if (dest.func_177958_n() - pos.func_177958_n() < -limit) {
            dest = new BlockPos(pos.func_177958_n() - limit, dest.func_177956_o(), dest.func_177952_p());
        }
        if (dest.func_177958_n() - pos.func_177958_n() > limit) {
            dest = new BlockPos(pos.func_177958_n() + limit, dest.func_177956_o(), dest.func_177952_p());
        }
        if (dest.func_177952_p() - pos.func_177952_p() < -limit) {
            dest = new BlockPos(dest.func_177958_n(), dest.func_177956_o(), pos.func_177952_p() - limit);
        }
        if (dest.func_177952_p() - pos.func_177952_p() > limit) {
            dest = new BlockPos(dest.func_177958_n(), dest.func_177956_o(), pos.func_177952_p() + limit);
        }
        if (trunk) {
            FeatureUtil.drawBresenhamTree(world, src, dest, config.trunkProvider.func_225574_a_(treeRNG, src), logpos);
        }
        else {
            FeatureUtil.drawBresenhamBranch(this, world, treeRNG, src, dest, branchpos, mbb, config);
        }
        this.setBranchBlockState(world, treeRNG, dest.func_177974_f(), branchpos, mbb, config);
        this.setBranchBlockState(world, treeRNG, dest.func_177976_e(), branchpos, mbb, config);
        this.setBranchBlockState(world, treeRNG, dest.func_177978_c(), branchpos, mbb, config);
        this.setBranchBlockState(world, treeRNG, dest.func_177968_d(), branchpos, mbb, config);
        this.leaves.add(dest);
    }
}
