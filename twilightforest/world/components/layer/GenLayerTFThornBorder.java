// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.layer;

import twilightforest.world.components.TFBiomeProvider;
import twilightforest.world.registration.biomes.BiomeKeys;
import net.minecraft.world.level.newbiome.context.Context;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.core.Registry;

public enum GenLayerTFThornBorder implements IThornsTransformer
{
    INSTANCE;
    
    private Registry<Biome> registry;
    
    public GenLayerTFThornBorder setup(final Registry<Biome> registry) {
        this.registry = registry;
        return this;
    }
    
    @Override
    public int apply(final Context noise, final int up, final int left, final int down, final int right, final int center, final int nw, final int sw, final int se, final int ne) {
        final int highlandsCenter = TFBiomeProvider.getBiomeId(BiomeKeys.FINAL_PLATEAU, this.registry);
        final int thornlands = TFBiomeProvider.getBiomeId(BiomeKeys.THORNLANDS, this.registry);
        if (this.onBorder(highlandsCenter, center, right, left, up, down)) {
            return thornlands;
        }
        if (this.onBorder(highlandsCenter, center, ne, nw, se, sw)) {
            return thornlands;
        }
        return center;
    }
    
    private boolean onBorder(final int biomeID, final int center, final int right, final int left, final int up, final int down) {
        return center != biomeID && (right == biomeID || left == biomeID || up == biomeID || down == biomeID);
    }
}
