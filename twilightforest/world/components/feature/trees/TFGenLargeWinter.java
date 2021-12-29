// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature.trees;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.core.Direction;
import twilightforest.util.FeaturePlacers;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelSimulatedReader;
import twilightforest.world.components.feature.trees.growers.SnowTreePlacer;
import net.minecraft.world.level.block.state.BlockState;
import java.util.function.BiConsumer;
import net.minecraft.core.BlockPos;
import java.util.Random;
import net.minecraft.world.level.WorldGenLevel;
import com.mojang.serialization.Codec;
import twilightforest.world.components.feature.config.TFTreeFeatureConfig;

public class TFGenLargeWinter extends TFTreeGenerator<TFTreeFeatureConfig>
{
    public TFGenLargeWinter(final Codec<TFTreeFeatureConfig> config) {
        super(config);
    }
    
    @Override
    protected boolean generate(final WorldGenLevel world, final Random random, final BlockPos pos, final BiConsumer<BlockPos, BlockState> trunkPlacer, final BiConsumer<BlockPos, BlockState> leavesPlacer, final BiConsumer<BlockPos, BlockState> decorationPlacer, final TFTreeFeatureConfig config) {
        int treeHeight = 35;
        if (random.nextInt(3) == 0) {
            treeHeight += random.nextInt(10);
            if (random.nextInt(8) == 0) {
                treeHeight += random.nextInt(10);
            }
        }
        if (world.m_151562_(pos.m_123342_() + treeHeight)) {
            return false;
        }
        if (!SnowTreePlacer.isBlockUnderValid((LevelSimulatedReader)world, pos.m_7495_())) {
            return false;
        }
        this.buildTrunk((LevelAccessor)world, trunkPlacer, random, pos, treeHeight, config);
        this.makeLeaves((LevelAccessor)world, trunkPlacer, leavesPlacer, random, pos, treeHeight, config);
        final int numRoots = 4 + random.nextInt(3);
        final float offset = random.nextFloat();
        for (int b = 0; b < numRoots; ++b) {
            FeaturePlacers.buildRoot((LevelAccessor)world, decorationPlacer, random, pos, offset, b, config.rootsProvider);
        }
        return true;
    }
    
    private void makeLeaves(final LevelAccessor world, final BiConsumer<BlockPos, BlockState> trunkPlacer, final BiConsumer<BlockPos, BlockState> leavesPlacer, final Random random, final BlockPos pos, final int treeHeight, final TFTreeFeatureConfig config) {
        final int offGround = 3;
        final int leafType = 1;
        for (int dy = 0; dy < treeHeight; ++dy) {
            final int radius = this.leafRadius(treeHeight, dy, leafType);
            FeaturePlacers.placeCircleEven((LevelSimulatedReader)world, leavesPlacer, FeaturePlacers.VALID_TREE_POS, random, pos.m_6630_(offGround + treeHeight - dy), (float)radius, config.leavesProvider);
            this.makePineBranches(world, trunkPlacer, random, pos.m_6630_(offGround + treeHeight - dy), radius, config);
        }
    }
    
    private void makePineBranches(final LevelAccessor world, final BiConsumer<BlockPos, BlockState> trunkPlacer, final Random rand, final BlockPos pos, final int radius, final TFTreeFeatureConfig config) {
        final int branchLength = (radius > 4) ? (radius - 1) : (radius - 2);
        switch (pos.m_123342_() % 2) {
            case 0: {
                for (int i = 1; i <= branchLength; ++i) {
                    this.placeLogAt(trunkPlacer, rand, pos.m_142082_(-i, 0, 0), Direction.Axis.X, config);
                    this.placeLogAt(trunkPlacer, rand, pos.m_142082_(0, 0, i + 1), Direction.Axis.Z, config);
                    this.placeLogAt(trunkPlacer, rand, pos.m_142082_(i + 1, 0, 1), Direction.Axis.X, config);
                    this.placeLogAt(trunkPlacer, rand, pos.m_142082_(1, 0, -i), Direction.Axis.Z, config);
                }
                break;
            }
            case 1: {
                for (int i = 1; i <= branchLength; ++i) {
                    this.placeLogAt(trunkPlacer, rand, pos.m_142082_(-1, 0, 1), Direction.Axis.X, config);
                    this.placeLogAt(trunkPlacer, rand, pos.m_142082_(1, 0, i + 1), Direction.Axis.Z, config);
                    this.placeLogAt(trunkPlacer, rand, pos.m_142082_(i + 1, 0, 0), Direction.Axis.X, config);
                    this.placeLogAt(trunkPlacer, rand, pos.m_142082_(0, 0, -i), Direction.Axis.Z, config);
                }
                break;
            }
        }
    }
    
    private void placeLogAt(final BiConsumer<BlockPos, BlockState> trunkPlacer, final Random rand, final BlockPos pos, final Direction.Axis axis, final TFTreeFeatureConfig config) {
        trunkPlacer.accept(pos, (BlockState)config.trunkProvider.m_7112_(rand, pos).m_61124_((Property)RotatedPillarBlock.f_55923_, (Comparable)axis));
    }
    
    private int leafRadius(final int treeHeight, final int dy, final int functionType) {
        return switch (functionType) {
            case 1 -> (int)(4.0f * dy / treeHeight + 0.75f * dy % 3.0f);
            case 99 -> (treeHeight - dy / 2 - 1) % 4;
            default -> (dy - 1) % 4;
        };
    }
    
    private void buildTrunk(final LevelAccessor world, final BiConsumer<BlockPos, BlockState> trunkPlacer, final Random rand, final BlockPos pos, final int treeHeight, final TFTreeFeatureConfig config) {
        for (int dy = 0; dy < treeHeight; ++dy) {
            FeaturePlacers.placeIfValidTreePos(world, trunkPlacer, rand, pos.m_142082_(0, dy, 0), config.trunkProvider);
            FeaturePlacers.placeIfValidTreePos(world, trunkPlacer, rand, pos.m_142082_(1, dy, 0), config.trunkProvider);
            FeaturePlacers.placeIfValidTreePos(world, trunkPlacer, rand, pos.m_142082_(0, dy, 1), config.trunkProvider);
            FeaturePlacers.placeIfValidTreePos(world, trunkPlacer, rand, pos.m_142082_(1, dy, 1), config.trunkProvider);
        }
    }
}
