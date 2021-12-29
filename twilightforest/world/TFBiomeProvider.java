// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import java.util.Arrays;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import twilightforest.world.layer.GenLayerTFRiverMix;
import net.minecraft.world.gen.layer.GenLayerSmooth;
import twilightforest.world.layer.GenLayerTFStream;
import twilightforest.world.layer.GenLayerTFThornBorder;
import twilightforest.world.layer.GenLayerTFBiomeStabilize;
import net.minecraft.world.gen.layer.GenLayerZoom;
import twilightforest.world.layer.GenLayerTFCompanionBiomes;
import twilightforest.world.layer.GenLayerTFKeyBiomes;
import twilightforest.world.layer.GenLayerTFBiomes;
import twilightforest.biomes.TFBiomes;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeProvider;

public class TFBiomeProvider extends BiomeProvider
{
    private final TFBiomeCache mapCache;
    
    public TFBiomeProvider(final World world) {
        this.func_76932_a().clear();
        this.func_76932_a().add(TFBiomes.twilightForest);
        this.func_76932_a().add(TFBiomes.denseTwilightForest);
        this.func_76932_a().add(TFBiomes.clearing);
        this.func_76932_a().add(TFBiomes.tfSwamp);
        this.func_76932_a().add(TFBiomes.mushrooms);
        this.makeLayers(world.func_72905_C());
        this.mapCache = new TFBiomeCache(this, 512, true);
    }
    
    private void makeLayers(final long seed) {
        GenLayer biomes = new GenLayerTFBiomes(1L);
        biomes = new GenLayerTFKeyBiomes(1000L, biomes);
        biomes = new GenLayerTFCompanionBiomes(1000L, biomes);
        biomes = (GenLayer)new GenLayerZoom(1000L, biomes);
        biomes = (GenLayer)new GenLayerZoom(1001L, biomes);
        biomes = new GenLayerTFBiomeStabilize(700L, biomes);
        biomes = new GenLayerTFThornBorder(500L, biomes);
        biomes = (GenLayer)new GenLayerZoom(1002L, biomes);
        biomes = (GenLayer)new GenLayerZoom(1003L, biomes);
        biomes = (GenLayer)new GenLayerZoom(1004L, biomes);
        biomes = (GenLayer)new GenLayerZoom(1005L, biomes);
        GenLayer riverLayer = new GenLayerTFStream(1L, biomes);
        riverLayer = (GenLayer)new GenLayerSmooth(7000L, riverLayer);
        biomes = new GenLayerTFRiverMix(100L, biomes, riverLayer);
        final GenLayer genlayervoronoizoom = (GenLayer)new GenLayerVoronoiZoom(10L, biomes);
        biomes.func_75905_a(seed);
        genlayervoronoizoom.func_75905_a(seed);
        this.field_76944_d = biomes;
        this.field_76945_e = genlayervoronoizoom;
    }
    
    public Biome[] func_76937_a(final Biome[] biomes, final int x, final int z, final int width, final int height) {
        return this.getBiomesForGeneration(biomes, x, z, width, height, true);
    }
    
    public Biome[] getBiomesForGeneration(final Biome[] biomes, final int x, final int z, final int width, final int height, final boolean useCache) {
        if (useCache && this.mapCache.isGridAligned(x, z, width, height)) {
            final Biome[] cached = this.mapCache.getBiomes(x, z);
            return Arrays.copyOf(cached, cached.length);
        }
        return super.func_76937_a(biomes, x, z, width, height);
    }
    
    public void func_76938_b() {
        this.mapCache.cleanup();
        super.func_76938_b();
    }
}
