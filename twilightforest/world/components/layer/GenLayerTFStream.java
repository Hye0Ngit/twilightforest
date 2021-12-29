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

public enum GenLayerTFStream implements CastleTransformer
{
    INSTANCE;
    
    private Registry<Biome> registry;
    
    public GenLayerTFStream setup(final Registry<Biome> registry) {
        this.registry = registry;
        return this;
    }
    
    public int m_6949_(final Context iNoiseRandom, final int up, final int left, final int down, final int right, final int mid) {
        if (this.shouldStream(mid, left) || this.shouldStream(mid, right) || this.shouldStream(mid, down) || this.shouldStream(mid, up)) {
            return TFBiomeProvider.getBiomeId(BiomeKeys.STREAM, this.registry);
        }
        return mid;
    }
    
    boolean shouldStream(final int biome1, final int biome2) {
        if (biome1 == biome2) {
            return false;
        }
        if (biome1 == -biome2) {
            return false;
        }
        final int tfLake = TFBiomeProvider.getBiomeId(BiomeKeys.LAKE, this.registry);
        final int thornlands = TFBiomeProvider.getBiomeId(BiomeKeys.THORNLANDS, this.registry);
        return !this.testEitherBiomeOR(biome1, biome2, tfLake, tfLake) && !this.testEitherBiomeOR(biome1, biome2, thornlands, thornlands) && !this.testEitherBiomeOR(biome1, biome2, TFBiomeProvider.getBiomeId(BiomeKeys.CLEARING, this.registry), TFBiomeProvider.getBiomeId(BiomeKeys.OAK_SAVANNAH, this.registry)) && !this.testEitherBiomeAND(biome1, biome2, TFBiomeProvider.getBiomeId(BiomeKeys.SNOWY_FOREST, this.registry), TFBiomeProvider.getBiomeId(BiomeKeys.GLACIER, this.registry)) && !this.testEitherBiomeAND(biome1, biome2, TFBiomeProvider.getBiomeId(BiomeKeys.MUSHROOM_FOREST, this.registry), TFBiomeProvider.getBiomeId(BiomeKeys.DENSE_MUSHROOM_FOREST, this.registry)) && !this.testEitherBiomeAND(biome1, biome2, TFBiomeProvider.getBiomeId(BiomeKeys.SWAMP, this.registry), TFBiomeProvider.getBiomeId(BiomeKeys.FIRE_SWAMP, this.registry)) && !this.testEitherBiomeAND(biome1, biome2, TFBiomeProvider.getBiomeId(BiomeKeys.DARK_FOREST, this.registry), TFBiomeProvider.getBiomeId(BiomeKeys.DARK_FOREST_CENTER, this.registry)) && !this.testEitherBiomeAND(biome1, biome2, TFBiomeProvider.getBiomeId(BiomeKeys.HIGHLANDS, this.registry), TFBiomeProvider.getBiomeId(BiomeKeys.FINAL_PLATEAU, this.registry));
    }
    
    private boolean testEitherBiomeAND(final int test1, final int test2, final int predicate1, final int predicate2) {
        return (test1 == predicate1 && test2 == predicate2) || (test2 == predicate1 && test1 == predicate2);
    }
    
    private boolean testEitherBiomeOR(final int test1, final int test2, final int predicate1, final int predicate2) {
        return test1 == predicate1 || test2 == predicate2 || test2 == predicate1 || test1 == predicate2;
    }
}
