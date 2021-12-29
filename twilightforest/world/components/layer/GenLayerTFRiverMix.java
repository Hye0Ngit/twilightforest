// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.layer;

import twilightforest.world.components.TFBiomeProvider;
import twilightforest.world.registration.biomes.BiomeKeys;
import net.minecraft.world.level.newbiome.area.Area;
import net.minecraft.world.level.newbiome.context.Context;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.core.Registry;
import net.minecraft.world.level.newbiome.layer.traits.DimensionOffset0Transformer;
import net.minecraft.world.level.newbiome.layer.traits.AreaTransformer2;

public enum GenLayerTFRiverMix implements AreaTransformer2, DimensionOffset0Transformer
{
    INSTANCE;
    
    private Registry<Biome> registry;
    
    public GenLayerTFRiverMix setup(final Registry<Biome> registry) {
        this.registry = registry;
        return this;
    }
    
    public int m_5924_(final Context iNoiseRandom, final Area area1, final Area area2, final int val1, final int val2) {
        final int biomeInputs = area1.m_7929_(this.m_6320_(val1), this.m_6317_(val2));
        final int riverInputs = area2.m_7929_(this.m_6320_(val1), this.m_6317_(val2));
        final int stream = TFBiomeProvider.getBiomeId(BiomeKeys.STREAM, this.registry);
        if (riverInputs == stream) {
            return riverInputs;
        }
        return biomeInputs;
    }
}
