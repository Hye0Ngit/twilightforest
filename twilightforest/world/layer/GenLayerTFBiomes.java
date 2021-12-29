// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.layer;

import com.google.common.collect.ImmutableList;
import twilightforest.worldgen.biomes.BiomeKeys;
import twilightforest.world.TFBiomeProvider;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.RegistryKey;
import java.util.List;
import net.minecraft.world.gen.layer.traits.IAreaTransformer0;

public enum GenLayerTFBiomes implements IAreaTransformer0
{
    INSTANCE;
    
    private static final int RARE_BIOME_CHANCE = 15;
    protected static final List<RegistryKey<Biome>> commonBiomes;
    protected static final List<RegistryKey<Biome>> rareBiomes;
    private Registry<Biome> registry;
    
    public GenLayerTFBiomes setup(final Registry<Biome> registry) {
        this.registry = registry;
        return this;
    }
    
    public int func_215735_a(final INoiseRandom iNoiseRandom, final int x, final int y) {
        if (iNoiseRandom.func_202696_a(15) == 0) {
            return this.getRandomBiome(iNoiseRandom, GenLayerTFBiomes.rareBiomes);
        }
        return this.getRandomBiome(iNoiseRandom, GenLayerTFBiomes.commonBiomes);
    }
    
    private int getRandomBiome(final INoiseRandom random, final List<RegistryKey<Biome>> biomes) {
        return TFBiomeProvider.getBiomeId(biomes.get(random.func_202696_a(biomes.size())), this.registry);
    }
    
    static {
        commonBiomes = (List)ImmutableList.of((Object)BiomeKeys.FOREST, (Object)BiomeKeys.DENSE_FOREST, (Object)BiomeKeys.MUSHROOM_FOREST, (Object)BiomeKeys.OAK_SAVANNAH, (Object)BiomeKeys.FIREFLY_FOREST);
        rareBiomes = (List)ImmutableList.of((Object)BiomeKeys.LAKE, (Object)BiomeKeys.DENSE_MUSHROOM_FOREST, (Object)BiomeKeys.ENCHANTED_FOREST, (Object)BiomeKeys.CLEARING, (Object)BiomeKeys.SPOOKY_FOREST);
    }
}
