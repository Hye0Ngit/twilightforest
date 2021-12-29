// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature.trees;

import net.minecraft.world.level.LevelSimulatedReader;
import twilightforest.util.FeatureUtil;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.RotatedPillarBlock;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import twilightforest.util.FeaturePlacers;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import java.util.function.BiConsumer;
import net.minecraft.core.BlockPos;
import java.util.Random;
import net.minecraft.world.level.WorldGenLevel;
import com.mojang.serialization.Codec;
import twilightforest.world.components.feature.config.TFTreeFeatureConfig;

public class TFGenMinersTree extends TFTreeGenerator<TFTreeFeatureConfig>
{
    public TFGenMinersTree(final Codec<TFTreeFeatureConfig> config) {
        super(config);
    }
    
    @Override
    protected boolean generate(final WorldGenLevel world, final Random random, final BlockPos pos, final BiConsumer<BlockPos, BlockState> trunkPlacer, final BiConsumer<BlockPos, BlockState> leavesPlacer, final BiConsumer<BlockPos, BlockState> decorationPlacer, final TFTreeFeatureConfig config) {
        if (world.m_151562_(pos.m_123342_() + 12)) {
            return false;
        }
        final BlockState state = world.m_8055_(pos.m_7495_());
        if (!state.m_60734_().canSustainPlant(state, (BlockGetter)world, pos.m_7495_(), Direction.UP, config.getSapling(random, pos))) {
            return false;
        }
        for (int dy = 0; dy <= 9; ++dy) {
            FeaturePlacers.placeIfValidTreePos((LevelAccessor)world, trunkPlacer, random, pos.m_6630_(dy), config.trunkProvider);
        }
        putBranchWithLeaves((LevelAccessor)world, trunkPlacer, leavesPlacer, random, pos.m_142082_(0, 9, 1), true, config);
        putBranchWithLeaves((LevelAccessor)world, trunkPlacer, leavesPlacer, random, pos.m_142082_(0, 9, 2), false, config);
        putBranchWithLeaves((LevelAccessor)world, trunkPlacer, leavesPlacer, random, pos.m_142082_(0, 8, 3), false, config);
        putBranchWithLeaves((LevelAccessor)world, trunkPlacer, leavesPlacer, random, pos.m_142082_(0, 7, 4), false, config);
        putBranchWithLeaves((LevelAccessor)world, trunkPlacer, leavesPlacer, random, pos.m_142082_(0, 6, 5), false, config);
        putBranchWithLeaves((LevelAccessor)world, trunkPlacer, leavesPlacer, random, pos.m_142082_(0, 9, -1), true, config);
        putBranchWithLeaves((LevelAccessor)world, trunkPlacer, leavesPlacer, random, pos.m_142082_(0, 9, -2), false, config);
        putBranchWithLeaves((LevelAccessor)world, trunkPlacer, leavesPlacer, random, pos.m_142082_(0, 8, -3), false, config);
        putBranchWithLeaves((LevelAccessor)world, trunkPlacer, leavesPlacer, random, pos.m_142082_(0, 7, -4), false, config);
        putBranchWithLeaves((LevelAccessor)world, trunkPlacer, leavesPlacer, random, pos.m_142082_(0, 6, -5), false, config);
        world.m_7731_(pos.m_7494_(), (BlockState)((Block)TFBlocks.MINING_LOG_CORE.get()).m_49966_().m_61124_((Property)RotatedPillarBlock.f_55923_, (Comparable)Direction.Axis.Y), 3);
        world.m_6219_().m_5945_(pos.m_7494_(), (Object)TFBlocks.MINING_LOG_CORE.get(), 20);
        if (FeatureUtil.hasAirAround((LevelAccessor)world, pos.m_7495_())) {
            FeaturePlacers.placeIfValidTreePos((LevelAccessor)world, trunkPlacer, random, pos.m_7495_(), config.trunkProvider);
        }
        else {
            FeaturePlacers.placeIfValidRootPos((LevelAccessor)world, decorationPlacer, random, pos.m_7495_(), config.rootsProvider);
        }
        final int numRoots = 3 + random.nextInt(2);
        final float offset = random.nextFloat();
        for (int b = 0; b < numRoots; ++b) {
            FeaturePlacers.buildRoot((LevelAccessor)world, decorationPlacer, random, pos, offset, b, config.rootsProvider);
        }
        return true;
    }
    
    protected static void putBranchWithLeaves(final LevelAccessor world, final BiConsumer<BlockPos, BlockState> trunkPlacer, final BiConsumer<BlockPos, BlockState> leavesPlacer, final Random rand, final BlockPos pos, final boolean bushy, final TFTreeFeatureConfig config) {
        FeaturePlacers.placeIfValidTreePos(world, trunkPlacer, rand, pos, config.branchProvider);
        for (int lx = -1; lx <= 1; ++lx) {
            for (int ly = -1; ly <= 1; ++ly) {
                for (int lz = -1; lz <= 1; ++lz) {
                    if (bushy || Math.abs(ly) <= 0 || Math.abs(lx) <= 0) {
                        FeaturePlacers.placeProvidedBlock((LevelSimulatedReader)world, leavesPlacer, FeaturePlacers.VALID_TREE_POS, pos.m_142082_(lx, ly, lz), config.leavesProvider, rand);
                    }
                }
            }
        }
    }
}
