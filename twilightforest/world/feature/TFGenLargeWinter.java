// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.world.IWorldWriter;
import net.minecraft.state.Property;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.world.gen.IWorldGenerationReader;
import twilightforest.util.FeatureUtil;
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

public class TFGenLargeWinter extends TFTreeGenerator<TFTreeFeatureConfig>
{
    public TFGenLargeWinter(final Codec<TFTreeFeatureConfig> config) {
        super(config);
    }
    
    @Override
    protected boolean generate(final IWorld world, final Random random, final BlockPos pos, final Set<BlockPos> trunk, final Set<BlockPos> leaves, final Set<BlockPos> branch, final Set<BlockPos> root, final MutableBoundingBox mbb, final TFTreeFeatureConfig config) {
        int treeHeight = 35;
        if (random.nextInt(3) == 0) {
            treeHeight += random.nextInt(10);
            if (random.nextInt(8) == 0) {
                treeHeight += random.nextInt(10);
            }
        }
        if (pos.func_177956_o() >= 256 - treeHeight) {
            return false;
        }
        final BlockState state = world.func_180495_p(pos.func_177977_b());
        if (!state.func_177230_c().canSustainPlant(state, (IBlockReader)world, pos.func_177977_b(), Direction.UP, config.getSapling(random, pos))) {
            return false;
        }
        this.buildTrunk(world, random, pos, trunk, treeHeight, mbb, config);
        this.makeLeaves(world, random, pos, treeHeight, trunk, leaves, mbb, config);
        final int numRoots = 4 + random.nextInt(3);
        final float offset = random.nextFloat();
        for (int b = 0; b < numRoots; ++b) {
            this.buildRoot(world, random, pos, root, offset, b, mbb, config);
        }
        return true;
    }
    
    private void makeLeaves(final IWorld world, final Random random, final BlockPos pos, final int treeHeight, final Set<BlockPos> trunk, final Set<BlockPos> leaves, final MutableBoundingBox mbb, final TFTreeFeatureConfig config) {
        final int offGround = 3;
        final int leafType = 1;
        for (int dy = 0; dy < treeHeight; ++dy) {
            final int radius = this.leafRadius(treeHeight, dy, leafType);
            FeatureUtil.makeLeafCircle2(world, pos.func_177981_b(offGround + treeHeight - dy), radius, config.leavesProvider.func_225574_a_(random, pos.func_177981_b(offGround + treeHeight - dy)), leaves);
            this.makePineBranches(world, random, pos.func_177981_b(offGround + treeHeight - dy), trunk, radius, mbb, config);
        }
    }
    
    private void makePineBranches(final IWorld world, final Random rand, final BlockPos pos, final Set<BlockPos> trunk, final int radius, final MutableBoundingBox mbb, final TFTreeFeatureConfig config) {
        final int branchLength = (radius > 4) ? (radius - 1) : (radius - 2);
        switch (pos.func_177956_o() % 2) {
            case 0: {
                for (int i = 1; i <= branchLength; ++i) {
                    this.placeLogAt((IWorldGenerationReader)world, rand, pos.func_177982_a(-i, 0, 0), Direction.Axis.X, trunk, mbb, config);
                    this.placeLogAt((IWorldGenerationReader)world, rand, pos.func_177982_a(0, 0, i + 1), Direction.Axis.Z, trunk, mbb, config);
                    this.placeLogAt((IWorldGenerationReader)world, rand, pos.func_177982_a(i + 1, 0, 1), Direction.Axis.X, trunk, mbb, config);
                    this.placeLogAt((IWorldGenerationReader)world, rand, pos.func_177982_a(1, 0, -i), Direction.Axis.Z, trunk, mbb, config);
                }
                break;
            }
            case 1: {
                for (int i = 1; i <= branchLength; ++i) {
                    this.placeLogAt((IWorldGenerationReader)world, rand, pos.func_177982_a(-1, 0, 1), Direction.Axis.X, trunk, mbb, config);
                    this.placeLogAt((IWorldGenerationReader)world, rand, pos.func_177982_a(1, 0, i + 1), Direction.Axis.Z, trunk, mbb, config);
                    this.placeLogAt((IWorldGenerationReader)world, rand, pos.func_177982_a(i + 1, 0, 0), Direction.Axis.X, trunk, mbb, config);
                    this.placeLogAt((IWorldGenerationReader)world, rand, pos.func_177982_a(0, 0, -i), Direction.Axis.Z, trunk, mbb, config);
                }
                break;
            }
        }
    }
    
    private void placeLogAt(final IWorldGenerationReader reader, final Random rand, final BlockPos pos, final Direction.Axis axis, final Set<BlockPos> logPos, final MutableBoundingBox boundingBox, final TFTreeFeatureConfig config) {
        this.setBlockState((IWorldWriter)reader, pos, (BlockState)config.trunkProvider.func_225574_a_(rand, pos).func_206870_a((Property)RotatedPillarBlock.field_176298_M, (Comparable)axis), boundingBox);
        logPos.add(pos.func_185334_h());
    }
    
    private int leafRadius(final int treeHeight, final int dy, final int functionType) {
        switch (functionType) {
            default: {
                return (dy - 1) % 4;
            }
            case 1: {
                return (int)(4.0f * dy / treeHeight + 0.75f * dy % 3.0f);
            }
            case 99: {
                return (treeHeight - dy / 2 - 1) % 4;
            }
        }
    }
    
    private void buildTrunk(final IWorld world, final Random rand, final BlockPos pos, final Set<BlockPos> trunk, final int treeHeight, final MutableBoundingBox mbb, final TFTreeFeatureConfig config) {
        for (int dy = 0; dy < treeHeight; ++dy) {
            this.setLogBlockState(world, rand, pos.func_177982_a(0, dy, 0), trunk, mbb, config);
            this.setLogBlockState(world, rand, pos.func_177982_a(1, dy, 0), trunk, mbb, config);
            this.setLogBlockState(world, rand, pos.func_177982_a(0, dy, 1), trunk, mbb, config);
            this.setLogBlockState(world, rand, pos.func_177982_a(1, dy, 1), trunk, mbb, config);
        }
    }
}
