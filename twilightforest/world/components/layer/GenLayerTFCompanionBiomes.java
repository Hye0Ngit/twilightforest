// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.layer;

import twilightforest.world.components.TFBiomeProvider;
import twilightforest.world.registration.biomes.BiomeKeys;
import net.minecraft.world.level.newbiome.context.Context;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.core.Registry;
import net.minecraft.world.level.newbiome.layer.traits.CastleTransformer;

public enum GenLayerTFCompanionBiomes implements CastleTransformer
{
    INSTANCE;
    
    private Registry<Biome> registry;
    
    public GenLayerTFCompanionBiomes setup(final Registry<Biome> registry) {
        this.registry = registry;
        return this;
    }
    
    public int m_6949_(final Context noise, final int up, final int left, final int down, final int right, final int center) {
        final int fireSwamp = TFBiomeProvider.getBiomeId(BiomeKeys.FIRE_SWAMP, this.registry);
        final int swamp = TFBiomeProvider.getBiomeId(BiomeKeys.SWAMP, this.registry);
        final int glacier = TFBiomeProvider.getBiomeId(BiomeKeys.GLACIER, this.registry);
        final int snowyForest = TFBiomeProvider.getBiomeId(BiomeKeys.SNOWY_FOREST, this.registry);
        final int darkForestCenter = TFBiomeProvider.getBiomeId(BiomeKeys.DARK_FOREST_CENTER, this.registry);
        final int darkForest = TFBiomeProvider.getBiomeId(BiomeKeys.DARK_FOREST, this.registry);
        final int highlandsCenter = TFBiomeProvider.getBiomeId(BiomeKeys.FINAL_PLATEAU, this.registry);
        final int highlands = TFBiomeProvider.getBiomeId(BiomeKeys.HIGHLANDS, this.registry);
        if (this.isKey(fireSwamp, center, right, left, up, down)) {
            return swamp;
        }
        if (this.isKey(glacier, center, right, left, up, down)) {
            return snowyForest;
        }
        if (this.isKey(darkForestCenter, center, right, left, up, down)) {
            return darkForest;
        }
        if (this.isKey(highlandsCenter, center, right, left, up, down)) {
            return highlands;
        }
        return center;
    }
    
    boolean isKey(final int biome, final int center, final int right, final int left, final int up, final int down) {
        return center != biome && (right == biome || left == biome || up == biome || down == biome);
    }
}
