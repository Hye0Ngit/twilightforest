// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature.trees;

import twilightforest.util.FeatureLogic;
import twilightforest.util.FeatureUtil;
import twilightforest.util.FeaturePlacers;
import java.util.Iterator;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import java.util.function.BiConsumer;
import java.util.Random;
import net.minecraft.world.level.WorldGenLevel;
import com.google.common.collect.Lists;
import twilightforest.world.components.feature.config.TFTreeFeatureConfig;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import java.util.List;

public class TFGenCanopyOak extends TFGenCanopyTree
{
    private final List<BlockPos> leaves;
    
    public TFGenCanopyOak(final Codec<TFTreeFeatureConfig> config) {
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
        this.buildTrunk((LevelAccessor)world, trunkPlacer, random, pos, treeHeight, config);
        final int numBranches = 12 + random.nextInt(9);
        float bangle = random.nextFloat();
        for (int b = 0; b < numBranches; ++b) {
            final float btilt = 0.15f + random.nextFloat() * 0.35f;
            this.buildBranch((LevelAccessor)world, pos, trunkPlacer, treeHeight - 10 + b / 2, 5.0, bangle, btilt, false, random, config);
            bangle += random.nextFloat() * 0.4f;
            if (bangle > 1.0f) {
                --bangle;
            }
        }
        for (final BlockPos leafPos : this.leaves) {
            this.makeLeafBlob((LevelSimulatedReader)world, leavesPlacer, random, leafPos, config);
        }
        makeRoots((LevelAccessor)world, trunkPlacer, decorationPlacer, random, pos, config);
        makeRoots((LevelAccessor)world, trunkPlacer, decorationPlacer, random, pos.m_142126_(), config);
        makeRoots((LevelAccessor)world, trunkPlacer, decorationPlacer, random, pos.m_142128_(), config);
        makeRoots((LevelAccessor)world, trunkPlacer, decorationPlacer, random, pos.m_142126_().m_142128_(), config);
        return true;
    }
    
    private void makeLeafBlob(final LevelSimulatedReader world, final BiConsumer<BlockPos, BlockState> leafPlacer, final Random rand, final BlockPos leafPos, final TFTreeFeatureConfig config) {
        FeaturePlacers.placeSpheroid(world, leafPlacer, FeaturePlacers.VALID_TREE_POS, rand, leafPos, 2.5f, 2.5f, config.leavesProvider);
    }
    
    private static void makeRoots(final LevelAccessor world, final BiConsumer<BlockPos, BlockState> trunkPlacer, final BiConsumer<BlockPos, BlockState> decoPlacer, final Random random, final BlockPos pos, final TFTreeFeatureConfig config) {
        if (FeatureUtil.hasAirAround(world, pos.m_7495_())) {
            FeaturePlacers.placeIfValidTreePos(world, trunkPlacer, random, pos.m_7495_(), config.trunkProvider);
        }
        else {
            FeaturePlacers.placeIfValidRootPos(world, decoPlacer, random, pos.m_7495_(), config.rootsProvider);
        }
        final int numRoots = 1 + random.nextInt(2);
        final float offset = random.nextFloat();
        for (int b = 0; b < numRoots; ++b) {
            FeaturePlacers.buildRoot(world, decoPlacer, random, pos, offset, b, config.rootsProvider);
        }
    }
    
    private void buildTrunk(final LevelAccessor world, final BiConsumer<BlockPos, BlockState> trunkPlacer, final Random rand, final BlockPos pos, final int treeHeight, final TFTreeFeatureConfig config) {
        for (int dy = 0; dy < treeHeight; ++dy) {
            FeaturePlacers.placeIfValidTreePos(world, trunkPlacer, rand, pos.m_142082_(0, dy, 0), config.trunkProvider);
            FeaturePlacers.placeIfValidTreePos(world, trunkPlacer, rand, pos.m_142082_(1, dy, 0), config.trunkProvider);
            FeaturePlacers.placeIfValidTreePos(world, trunkPlacer, rand, pos.m_142082_(0, dy, 1), config.trunkProvider);
            FeaturePlacers.placeIfValidTreePos(world, trunkPlacer, rand, pos.m_142082_(1, dy, 1), config.trunkProvider);
        }
        this.leaves.add(pos.m_142082_(0, treeHeight, 0));
    }
    
    @Override
    void buildBranch(final LevelAccessor world, final BlockPos pos, final BiConsumer<BlockPos, BlockState> trunkPlacer, final int height, final double length, final double angle, final double tilt, final boolean trunk, final Random treeRNG, final TFTreeFeatureConfig config) {
        final BlockPos src = pos.m_6630_(height);
        BlockPos dest = FeatureLogic.translate(src, length, angle, tilt);
        final int limit = 5;
        if (dest.m_123341_() - pos.m_123341_() < -limit) {
            dest = new BlockPos(pos.m_123341_() - limit, dest.m_123342_(), dest.m_123343_());
        }
        if (dest.m_123341_() - pos.m_123341_() > limit) {
            dest = new BlockPos(pos.m_123341_() + limit, dest.m_123342_(), dest.m_123343_());
        }
        if (dest.m_123343_() - pos.m_123343_() < -limit) {
            dest = new BlockPos(dest.m_123341_(), dest.m_123342_(), pos.m_123343_() - limit);
        }
        if (dest.m_123343_() - pos.m_123343_() > limit) {
            dest = new BlockPos(dest.m_123341_(), dest.m_123342_(), pos.m_123343_() + limit);
        }
        if (trunk) {
            FeaturePlacers.drawBresenhamTree((LevelSimulatedReader)world, trunkPlacer, FeaturePlacers.VALID_TREE_POS, src, dest, config.trunkProvider, treeRNG);
        }
        else {
            FeaturePlacers.drawBresenhamBranch(world, trunkPlacer, treeRNG, src, dest, config.branchProvider);
        }
        FeaturePlacers.placeIfValidTreePos(world, trunkPlacer, treeRNG, dest.m_142126_(), config.branchProvider);
        FeaturePlacers.placeIfValidTreePos(world, trunkPlacer, treeRNG, dest.m_142125_(), config.branchProvider);
        FeaturePlacers.placeIfValidTreePos(world, trunkPlacer, treeRNG, dest.m_142127_(), config.branchProvider);
        FeaturePlacers.placeIfValidTreePos(world, trunkPlacer, treeRNG, dest.m_142128_(), config.branchProvider);
        this.leaves.add(dest);
    }
}
