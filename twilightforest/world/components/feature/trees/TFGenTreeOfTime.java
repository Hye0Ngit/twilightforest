// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature.trees;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.RotatedPillarBlock;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import java.util.function.BiConsumer;
import net.minecraft.core.BlockPos;
import java.util.Random;
import net.minecraft.world.level.WorldGenLevel;
import twilightforest.world.components.feature.config.TFTreeFeatureConfig;
import com.mojang.serialization.Codec;

public class TFGenTreeOfTime extends TFGenHollowTree
{
    public TFGenTreeOfTime(final Codec<TFTreeFeatureConfig> config) {
        super(config);
    }
    
    @Override
    public boolean generate(final WorldGenLevel world, final Random random, final BlockPos pos, final BiConsumer<BlockPos, BlockState> trunkPlacer, final BiConsumer<BlockPos, BlockState> leavesPlacer, final BiConsumer<BlockPos, BlockState> decorationPlacer, final TFTreeFeatureConfig config) {
        final int height = 8;
        final int diameter = 1;
        if (world.m_151562_(pos.m_123342_() + 1) || world.m_151562_(pos.m_123342_() + 8 + 1)) {
            return false;
        }
        final BlockState state = world.m_8055_(pos.m_7495_());
        if (!state.m_60734_().canSustainPlant(state, (BlockGetter)world, pos.m_7495_(), Direction.UP, config.getSapling(random, pos))) {
            return false;
        }
        this.buildTrunk((LevelAccessor)world, trunkPlacer, decorationPlacer, random, pos, 1, 8, config);
        this.buildTinyCrown(world, trunkPlacer, leavesPlacer, random, pos, 1, 8, config);
        this.buildBranchRing(world, trunkPlacer, leavesPlacer, random, pos, 1, 1, 0, 12, 0.75, 3, 5, 3, false, config);
        this.buildBranchRing(world, trunkPlacer, leavesPlacer, random, pos, 1, 1, 2, 18, 0.9, 3, 5, 3, false, config);
        world.m_7731_(pos.m_142082_(-1, 2, 0), (BlockState)((Block)TFBlocks.TIME_LOG_CORE.get()).m_49966_().m_61124_((Property)RotatedPillarBlock.f_55923_, (Comparable)Direction.Axis.Y), 3);
        return true;
    }
    
    protected void buildTinyCrown(final WorldGenLevel world, final BiConsumer<BlockPos, BlockState> trunkPlacer, final BiConsumer<BlockPos, BlockState> leavesPlacer, final Random random, final BlockPos pos, final int diameter, final int height, final TFTreeFeatureConfig config) {
        final int crownRadius = 4;
        final int bvar = 1;
        this.buildBranchRing(world, trunkPlacer, leavesPlacer, random, pos, diameter, height - 4, 0, 4, 0.35, 1, 3, 1, true, config);
        this.buildBranchRing(world, trunkPlacer, leavesPlacer, random, pos, diameter, height - 2, 0, 4, 0.28, 1, 3, 1, true, config);
        this.buildBranchRing(world, trunkPlacer, leavesPlacer, random, pos, diameter, height, 0, 4, 0.15, 2, 4, 0, true, config);
        this.buildBranchRing(world, trunkPlacer, leavesPlacer, random, pos, diameter, height, 0, 2, 0.05, 1, 3, 0, true, config);
    }
}
