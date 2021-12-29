// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature;

import java.util.Random;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.core.BlockPos;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import twilightforest.block.TrollRootBlock;
import net.minecraft.world.level.LevelReader;
import twilightforest.block.TFPlantBlock;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;

public class UndergroundPlantFeature extends Feature<BlockStateConfiguration>
{
    private final boolean isTrollber;
    
    public UndergroundPlantFeature(final Codec<BlockStateConfiguration> config, final boolean trollber) {
        super((Codec)config);
        this.isTrollber = trollber;
    }
    
    public boolean m_142674_(final FeaturePlaceContext<BlockStateConfiguration> ctx) {
        final WorldGenLevel world = ctx.m_159774_();
        BlockPos pos = ctx.m_159777_();
        final Random random = ctx.m_159776_();
        final int copyX = pos.m_123341_();
        final int copyZ = pos.m_123343_();
        while (pos.m_123342_() > world.m_141937_()) {
            if (world.m_46859_(pos) && random.nextInt(6) > 0) {
                if (!this.isTrollber && TFPlantBlock.canPlaceRootAt((LevelReader)world, pos)) {
                    world.m_7731_(pos, ((BlockStateConfiguration)ctx.m_159778_()).f_67547_, 18);
                }
                else if (this.isTrollber && TrollRootBlock.canPlaceRootBelow((LevelReader)world, pos.m_7494_())) {
                    if (random.nextInt(10) == 0) {
                        world.m_7731_(pos, ((Block)TFBlocks.UNRIPE_TROLLBER.get()).m_49966_(), 18);
                    }
                    else {
                        world.m_7731_(pos, ((BlockStateConfiguration)ctx.m_159778_()).f_67547_, 18);
                    }
                }
            }
            else {
                pos = new BlockPos(copyX + random.nextInt(4) - random.nextInt(4), pos.m_123342_(), copyZ + random.nextInt(4) - random.nextInt(4));
            }
            pos = pos.m_7495_();
        }
        return true;
    }
}
