// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.material.Material;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;

public class TFGenWebs extends Feature<NoneFeatureConfiguration>
{
    public TFGenWebs(final Codec<NoneFeatureConfiguration> config) {
        super((Codec)config);
    }
    
    private static boolean isValidMaterial(final Material material) {
        return material == Material.f_76274_ || material == Material.f_76320_;
    }
    
    public boolean m_142674_(final FeaturePlaceContext<NoneFeatureConfiguration> config) {
        final WorldGenLevel world = config.m_159774_();
        final ChunkGenerator generator = config.m_159775_();
        BlockPos pos;
        for (pos = config.m_159777_().m_6630_(config.m_159776_().nextInt(world.m_151558_() - config.m_159777_().m_123342_())); pos.m_123342_() > config.m_159777_().m_123342_() && world.m_46859_(pos); pos = pos.m_7495_()) {}
        if (!isValidMaterial(world.m_8055_(pos).m_60767_())) {
            return false;
        }
        while (!world.m_46859_(pos.m_7495_())) {
            pos = pos.m_7495_();
            if (pos.m_123342_() <= config.m_159777_().m_123342_() || !isValidMaterial(world.m_8055_(pos).m_60767_())) {
                return false;
            }
        }
        world.m_7731_(pos.m_7495_(), Blocks.f_50033_.m_49966_(), 18);
        return true;
    }
}
