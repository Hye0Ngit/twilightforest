// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature;

import net.minecraft.tags.Tag;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.RotatedPillarBlock;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import twilightforest.util.WorldUtil;
import net.minecraft.world.level.levelgen.Heightmap;
import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import com.mojang.serialization.Codec;
import twilightforest.world.components.feature.config.ThornsConfig;
import net.minecraft.world.level.levelgen.feature.Feature;

public class TwilightThorns extends Feature<ThornsConfig>
{
    public TwilightThorns(final Codec<ThornsConfig> config) {
        super((Codec)config);
    }
    
    public boolean m_142674_(final FeaturePlaceContext<ThornsConfig> ctx) {
        final WorldGenLevel world = ctx.m_159774_();
        final BlockPos pos = ctx.m_159777_();
        final Random rand = ctx.m_159776_();
        final int nextLength = 2 + rand.nextInt(4);
        final int maxLength = 2 + rand.nextInt(4) + rand.nextInt(4) + rand.nextInt(4);
        this.placeThorns(world, rand, pos, nextLength, Direction.UP, maxLength, pos, (ThornsConfig)ctx.m_159778_(), true);
        return true;
    }
    
    private void placeThorns(final WorldGenLevel world, final Random rand, final BlockPos pos, final int length, final Direction dir, final int maxLength, final BlockPos oPos, final ThornsConfig config, final boolean avoidGiantCloud) {
        boolean complete = false;
        for (int i = 0; i < length; ++i) {
            final BlockPos dPos = pos.m_5484_(dir, i);
            if ((avoidGiantCloud && dPos.m_123342_() - 64 > WorldUtil.getBaseHeight((LevelAccessor)world, dPos.m_123341_(), dPos.m_123343_(), Heightmap.Types.MOTION_BLOCKING_NO_LEAVES)) || Math.abs(dPos.m_123341_() - oPos.m_123341_()) >= config.maxSpread() || Math.abs(dPos.m_123343_() - oPos.m_123343_()) >= config.maxSpread() || !this.canPlaceThorns((LevelAccessor)world, dPos)) {
                break;
            }
            world.m_7731_(dPos, (BlockState)((Block)TFBlocks.BROWN_THORNS.get()).m_49966_().m_61124_((Property)RotatedPillarBlock.f_55923_, (Comparable)dir.m_122434_()), 3);
            if (i == length - 1) {
                complete = true;
                if (rand.nextInt(config.chanceOfLeaf()) == 0 && world.m_46859_(dPos.m_142300_(dir))) {
                    if (rand.nextInt(config.chanceLeafIsRose()) > 0) {
                        world.m_7731_(dPos.m_142300_(dir), (BlockState)((Block)TFBlocks.THORN_LEAVES.get()).m_49966_().m_61124_((Property)LeavesBlock.f_54419_, (Comparable)true), 3);
                    }
                    else {
                        world.m_7731_(dPos.m_142300_(dir), ((Block)TFBlocks.THORN_ROSE.get()).m_49966_(), 3);
                    }
                }
            }
        }
        if (complete && maxLength > 1) {
            final Direction nextDir = Direction.m_122404_(rand);
            final BlockPos nextPos = pos.m_5484_(dir, length - 1).m_142300_(nextDir);
            final int nextLength = 1 + rand.nextInt(maxLength);
            this.placeThorns(world, rand, nextPos, nextLength, nextDir, maxLength - 1, oPos, config, false);
        }
        if (complete && length > 3 && rand.nextInt(config.chanceOfBranch()) == 0) {
            final int middle = rand.nextInt(length);
            final Direction nextDir2 = Direction.m_122404_(rand);
            final BlockPos nextPos2 = pos.m_5484_(dir, middle).m_142300_(nextDir2);
            final int nextLength2 = 1 + rand.nextInt(maxLength);
            this.placeThorns(world, rand, nextPos2, nextLength2, nextDir2, maxLength - 1, oPos, config, false);
        }
        if (complete && length > 3 && rand.nextInt(config.chanceOfLeaf()) == 0) {
            final int middle = rand.nextInt(length);
            final Direction nextDir2 = Direction.m_122404_(rand);
            final BlockPos nextPos2 = pos.m_5484_(dir, middle).m_142300_(nextDir2);
            if (world.m_46859_(nextPos2)) {
                world.m_7731_(nextPos2, ((Block)TFBlocks.THORN_LEAVES.get()).m_49966_(), 3);
            }
        }
    }
    
    private boolean canPlaceThorns(final LevelAccessor world, final BlockPos pos) {
        final BlockState state = world.m_8055_(pos);
        return state.m_60795_() || state.m_60620_((Tag)BlockTags.f_13035_);
    }
}
