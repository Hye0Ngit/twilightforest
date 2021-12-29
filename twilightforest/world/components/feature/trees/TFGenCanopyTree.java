// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature.trees;

import twilightforest.util.FeatureLogic;
import java.util.Iterator;
import twilightforest.util.FeaturePlacers;
import twilightforest.util.FeatureUtil;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import java.util.function.BiConsumer;
import java.util.Random;
import net.minecraft.world.level.WorldGenLevel;
import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import java.util.List;
import twilightforest.world.components.feature.config.TFTreeFeatureConfig;

public class TFGenCanopyTree extends TFTreeGenerator<TFTreeFeatureConfig>
{
    private List<BlockPos> leaves;
    
    public TFGenCanopyTree(final Codec<TFTreeFeatureConfig> config) {
        super(config);
        this.leaves = Lists.newArrayList();
    }
    
    @Override
    protected boolean generate(final WorldGenLevel world, final Random random, final BlockPos pos, final BiConsumer<BlockPos, BlockState> trunkPlacer, final BiConsumer<BlockPos, BlockState> leavesPlacer, final BiConsumer<BlockPos, BlockState> decorationPlacer, final TFTreeFeatureConfig config) {
        int treeHeight = config.minHeight;
        if (random.nextInt(config.chanceAddFiveFirst) == 0) {
            treeHeight += random.nextInt(5);
            if (random.nextInt(config.chanceAddFiveSecond) == 0) {
                treeHeight += random.nextInt(5);
            }
        }
        if (world.m_151562_(pos.m_123342_() + treeHeight)) {
            return false;
        }
        final BlockState state = world.m_8055_(pos.m_7495_());
        if (!state.m_60734_().canSustainPlant(state, (BlockGetter)world, pos.m_7495_(), Direction.UP, config.getSapling(random, pos))) {
            return false;
        }
        this.leaves.clear();
        this.buildBranch((LevelAccessor)world, pos, trunkPlacer, 0, treeHeight, 0.0, 0.0, true, random, config);
        final int numBranches = 3 + random.nextInt(2);
        float offset = random.nextFloat();
        for (int b = 0; b < numBranches; ++b) {
            this.buildBranch((LevelAccessor)world, pos, trunkPlacer, treeHeight - 10 + b, 9.0, 0.3 * b + offset, 0.2, false, random, config);
        }
        if (config.hasLeaves) {
            for (final BlockPos leafPos : this.leaves) {
                this.makeLeafBlob((LevelSimulatedReader)world, leavesPlacer, random, leafPos, config);
            }
        }
        if (FeatureUtil.hasAirAround((LevelAccessor)world, pos.m_7495_())) {
            FeaturePlacers.placeIfValidTreePos((LevelAccessor)world, trunkPlacer, random, pos.m_7495_(), config.trunkProvider);
        }
        else {
            FeaturePlacers.placeIfValidRootPos((LevelAccessor)world, decorationPlacer, random, pos.m_7495_(), config.rootsProvider);
        }
        final int numRoots = 3 + random.nextInt(2);
        offset = random.nextFloat();
        for (int b2 = 0; b2 < numRoots; ++b2) {
            FeaturePlacers.buildRoot((LevelAccessor)world, decorationPlacer, random, pos, offset, b2, config.rootsProvider);
        }
        return true;
    }
    
    private void makeLeafBlob(final LevelSimulatedReader world, final BiConsumer<BlockPos, BlockState> leafPlacer, final Random random, final BlockPos leafPos, final TFTreeFeatureConfig config) {
        FeaturePlacers.placeCircleOdd(world, leafPlacer, FeaturePlacers.VALID_TREE_POS, random, leafPos.m_7495_(), 3.0f, config.leavesProvider);
        FeaturePlacers.placeCircleOdd(world, leafPlacer, FeaturePlacers.VALID_TREE_POS, random, leafPos, 4.0f, config.leavesProvider);
        FeaturePlacers.placeCircleOdd(world, leafPlacer, FeaturePlacers.VALID_TREE_POS, random, leafPos.m_7494_(), 2.0f, config.leavesProvider);
    }
    
    void buildBranch(final LevelAccessor world, final BlockPos pos, final BiConsumer<BlockPos, BlockState> trunkPlacer, final int height, final double length, final double angle, final double tilt, final boolean trunk, final Random treeRNG, final TFTreeFeatureConfig config) {
        final BlockPos src = pos.m_6630_(height);
        final BlockPos dest = FeatureLogic.translate(src, length, angle, tilt);
        if (world.isAreaLoaded(dest, 5)) {
            if (trunk) {
                FeaturePlacers.drawBresenhamTree((LevelSimulatedReader)world, trunkPlacer, FeaturePlacers.VALID_TREE_POS, src, dest, config.trunkProvider, treeRNG);
            }
            else {
                FeaturePlacers.drawBresenhamBranch(world, trunkPlacer, treeRNG, src, dest, config.branchProvider);
            }
            if (trunk) {
                FeaturePlacers.addFirefly(world, pos, 3 + treeRNG.nextInt(7), treeRNG.nextDouble());
            }
            FeaturePlacers.placeIfValidTreePos(world, trunkPlacer, treeRNG, dest.m_142126_(), config.branchProvider);
            FeaturePlacers.placeIfValidTreePos(world, trunkPlacer, treeRNG, dest.m_142125_(), config.branchProvider);
            FeaturePlacers.placeIfValidTreePos(world, trunkPlacer, treeRNG, dest.m_142128_(), config.branchProvider);
            FeaturePlacers.placeIfValidTreePos(world, trunkPlacer, treeRNG, dest.m_142127_(), config.branchProvider);
            this.leaves.add(dest);
        }
    }
}
