// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature.trees;

import twilightforest.util.FeaturePlacers;
import net.minecraft.world.level.LevelAccessor;
import twilightforest.util.FeatureUtil;
import net.minecraft.world.level.block.state.BlockState;
import java.util.function.BiConsumer;
import net.minecraft.core.BlockPos;
import java.util.Random;
import net.minecraft.world.level.WorldGenLevel;
import twilightforest.world.components.feature.config.TFTreeFeatureConfig;
import com.mojang.serialization.Codec;

public class TFGenHollowStump extends TFGenHollowTree
{
    public TFGenHollowStump(final Codec<TFTreeFeatureConfig> config) {
        super(config);
    }
    
    @Override
    public boolean generate(final WorldGenLevel world, final Random random, final BlockPos pos, final BiConsumer<BlockPos, BlockState> trunkPlacer, final BiConsumer<BlockPos, BlockState> leavesPlacer, final BiConsumer<BlockPos, BlockState> decorationPlacer, final TFTreeFeatureConfig config) {
        final int radius = random.nextInt(2) + 2;
        if (!FeatureUtil.isAreaSuitable(world, pos.m_142082_(-radius, 0, -radius), 2 * radius, 6, 2 * radius)) {
            return false;
        }
        this.buildTrunk((LevelAccessor)world, trunkPlacer, decorationPlacer, random, pos, radius, 6, config);
        this.buildBranchRing(world, trunkPlacer, leavesPlacer, random, pos, radius, 3, 2, 6, 0.75, 3, 5, 3, false, config);
        this.buildBranchRing(world, trunkPlacer, leavesPlacer, random, pos, radius, 1, 2, 8, 0.9, 3, 5, 3, false, config);
        return true;
    }
    
    @Override
    protected void buildTrunk(final LevelAccessor world, final BiConsumer<BlockPos, BlockState> trunkPlacer, final BiConsumer<BlockPos, BlockState> decoPlacer, final Random random, final BlockPos pos, final int diameter, final int maxheight, final TFTreeFeatureConfig config) {
        final int hollow = diameter >> 1;
        for (int dx = -diameter; dx <= diameter; ++dx) {
            for (int dz = -diameter; dz <= diameter; ++dz) {
                for (int dy = -4; dy < 0; ++dy) {
                    final int ax = Math.abs(dx);
                    final int az = Math.abs(dz);
                    final int dist = (int)(Math.max(ax, az) + Math.min(ax, az) * 0.5);
                    if (dist <= diameter) {
                        final BlockPos dPos = pos.m_142082_(dx, dy, dz);
                        if (FeatureUtil.hasAirAround(world, dPos)) {
                            FeaturePlacers.placeIfValidTreePos(world, trunkPlacer, random, dPos, config.trunkProvider);
                        }
                        else {
                            FeaturePlacers.placeIfValidRootPos(world, decoPlacer, random, dPos, config.rootsProvider);
                        }
                    }
                }
            }
        }
        for (int dx = -diameter; dx <= diameter; ++dx) {
            for (int dz = -diameter; dz <= diameter; ++dz) {
                for (int height = 2 + random.nextInt(3) + random.nextInt(2), dy2 = 0; dy2 <= height; ++dy2) {
                    final int ax2 = Math.abs(dx);
                    final int az2 = Math.abs(dz);
                    final int dist2 = Math.max(ax2, az2) + (Math.min(ax2, az2) >> 1);
                    if (dist2 <= diameter && dist2 > hollow) {
                        FeaturePlacers.placeIfValidTreePos(world, trunkPlacer, random, pos.m_142082_(dx, dy2, dz), config.trunkProvider);
                    }
                }
            }
        }
    }
}
