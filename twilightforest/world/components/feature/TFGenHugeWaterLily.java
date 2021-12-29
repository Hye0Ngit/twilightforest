// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature;

import net.minecraft.world.level.material.Material;
import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;

public class TFGenHugeWaterLily extends Feature<NoneFeatureConfiguration>
{
    public TFGenHugeWaterLily(final Codec<NoneFeatureConfiguration> config) {
        super((Codec)config);
    }
    
    public boolean m_142674_(final FeaturePlaceContext<NoneFeatureConfiguration> ctx) {
        final WorldGenLevel world = ctx.m_159774_();
        final BlockPos pos = ctx.m_159777_();
        final Random random = ctx.m_159776_();
        for (int i = 0; i < 4; ++i) {
            final BlockPos pos_ = pos.m_142082_(random.nextInt(8) - random.nextInt(8), random.nextInt(4) - random.nextInt(4), random.nextInt(8) - random.nextInt(8));
            if (this.shouldPlacePadAt((LevelAccessor)world, pos_)) {
                world.m_7731_(pos_, ((Block)TFBlocks.HUGE_WATER_LILY.get()).m_49966_(), 18);
            }
        }
        return true;
    }
    
    private boolean shouldPlacePadAt(final LevelAccessor world, final BlockPos pos) {
        return world.m_46859_(pos) && world.m_8055_(pos.m_7495_()).m_60767_() == Material.f_76305_;
    }
}
