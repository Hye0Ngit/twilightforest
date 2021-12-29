// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.layer;

import com.google.common.collect.ImmutableList;
import twilightforest.world.registration.biomes.BiomeKeys;
import twilightforest.world.components.TFBiomeProvider;
import net.minecraft.world.level.newbiome.context.Context;
import net.minecraft.core.Registry;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.resources.ResourceKey;
import java.util.List;
import net.minecraft.world.level.newbiome.layer.traits.AreaTransformer0;

public enum GenLayerTFBiomes implements AreaTransformer0
{
    INSTANCE;
    
    private static final int RARE_BIOME_CHANCE = 15;
    protected static final List<ResourceKey<Biome>> commonBiomes;
    protected static final List<ResourceKey<Biome>> rareBiomes;
    private Registry<Biome> registry;
    
    public GenLayerTFBiomes setup(final Registry<Biome> registry) {
        this.registry = registry;
        return this;
    }
    
    public int m_7215_(final Context iNoiseRandom, final int x, final int y) {
        if (iNoiseRandom.m_5826_(15) == 0) {
            return this.getRandomBiome(iNoiseRandom, GenLayerTFBiomes.rareBiomes);
        }
        return this.getRandomBiome(iNoiseRandom, GenLayerTFBiomes.commonBiomes);
    }
    
    private int getRandomBiome(final Context random, final List<ResourceKey<Biome>> biomes) {
        return TFBiomeProvider.getBiomeId(biomes.get(random.m_5826_(biomes.size())), this.registry);
    }
    
    static {
        commonBiomes = (List)ImmutableList.of((Object)BiomeKeys.FOREST, (Object)BiomeKeys.DENSE_FOREST, (Object)BiomeKeys.MUSHROOM_FOREST, (Object)BiomeKeys.OAK_SAVANNAH, (Object)BiomeKeys.FIREFLY_FOREST);
        rareBiomes = (List)ImmutableList.of((Object)BiomeKeys.LAKE, (Object)BiomeKeys.DENSE_MUSHROOM_FOREST, (Object)BiomeKeys.ENCHANTED_FOREST, (Object)BiomeKeys.CLEARING, (Object)BiomeKeys.SPOOKY_FOREST);
    }
}
