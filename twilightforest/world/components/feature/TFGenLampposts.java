// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature;

import net.minecraft.world.level.block.state.BlockState;
import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;

public class TFGenLampposts extends Feature<BlockStateConfiguration>
{
    private static final Rotation[] ROTATIONS;
    
    public TFGenLampposts(final Codec<BlockStateConfiguration> configIn) {
        super((Codec)configIn);
    }
    
    public boolean m_142674_(final FeaturePlaceContext<BlockStateConfiguration> ctx) {
        final WorldGenLevel world = ctx.m_159774_();
        final BlockPos pos = ctx.m_159777_();
        final Random rand = ctx.m_159776_();
        final BlockStateConfiguration config = (BlockStateConfiguration)ctx.m_159778_();
        if (world.m_8055_(pos.m_7495_()).m_60734_() != Blocks.f_50440_) {
            return false;
        }
        final int height = 1 + rand.nextInt(4);
        for (int dy = 0; dy <= height; ++dy) {
            final BlockState state = world.m_8055_(pos.m_6630_(dy));
            if (!state.m_60795_() && !state.m_60767_().m_76336_()) {
                return false;
            }
        }
        for (int dy = 0; dy < height; ++dy) {
            world.m_7731_(pos.m_6630_(dy), ((Block)TFBlocks.CANOPY_FENCE.get()).m_49966_(), 18);
        }
        world.m_7731_(pos.m_6630_(height), config.f_67547_.m_60717_(TFGenLampposts.ROTATIONS[rand.nextInt(TFGenLampposts.ROTATIONS.length)]), 18);
        return true;
    }
    
    static {
        ROTATIONS = Rotation.values();
    }
}
