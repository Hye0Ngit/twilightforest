// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerRiverMix;
import net.minecraft.world.gen.layer.GenLayerSmooth;
import net.minecraft.world.gen.layer.GenLayerZoom;
import net.minecraft.world.gen.layer.GenLayer;

public abstract class GenLayerTF extends GenLayer
{
    public GenLayerTF(final long l) {
        super(l);
    }
    
    public static GenLayer[] makeTheWorld(final long l) {
        final byte zoomFactor = 4;
        GenLayer biomes = new GenLayerTFBiomes(1L);
        biomes = (GenLayer)new GenLayerZoom(1000L, biomes);
        biomes = (GenLayer)new GenLayerZoom(1001L, biomes);
        biomes = new GenLayerTFBiomeBorders(500L, biomes);
        biomes = (GenLayer)new GenLayerZoom(1002L, biomes);
        biomes = (GenLayer)new GenLayerZoom(1003L, biomes);
        biomes = (GenLayer)new GenLayerZoom(1004L, biomes);
        biomes = (GenLayer)new GenLayerZoom(1005L, biomes);
        GenLayer riverLayer = new GenLayerTFStream(1L, biomes);
        riverLayer = (GenLayer)new GenLayerSmooth(7000L, riverLayer);
        biomes = (GenLayer)new GenLayerRiverMix(100L, biomes, riverLayer);
        final GenLayer genlayervoronoizoom = (GenLayer)new GenLayerVoronoiZoom(10L, biomes);
        biomes.func_75905_a(l);
        genlayervoronoizoom.func_75905_a(l);
        return new GenLayer[] { biomes, genlayervoronoizoom };
    }
    
    public static GenLayer[] makeTheWorldPreFeatureRemoval(final long l) {
        final byte zoomFactor = 4;
        GenLayer biomes = new GenLayerTFBiomes(1L);
        GenLayer features = new GenLayerTFMajorFeatures(1L);
        biomes = (GenLayer)new GenLayerZoom(1000L, biomes);
        biomes = (GenLayer)new GenLayerZoom(1001L, biomes);
        biomes = new GenLayerTFBiomeBorders(500L, biomes);
        biomes = (GenLayer)new GenLayerZoom(1002L, biomes);
        biomes = (GenLayer)new GenLayerZoom(1003L, biomes);
        features = GenLayerTFFeatureZoom.multipleZoom(1000L, features, 4);
        features = new GenLayerTFMinorFeatures(700, biomes, features);
        features = new GenLayerTFClearMajorFeatures(700L, features);
        features = new GenLayerTFClearMinorFeatures(701L, features);
        biomes = (GenLayer)new GenLayerZoom(1004L, biomes);
        biomes = (GenLayer)new GenLayerZoom(1005L, biomes);
        GenLayer riverLayer = new GenLayerTFStream(1L, biomes);
        riverLayer = (GenLayer)new GenLayerSmooth(7000L, riverLayer);
        biomes = (GenLayer)new GenLayerRiverMix(100L, biomes, riverLayer);
        GenLayer genlayervoronoizoom = (GenLayer)new GenLayerVoronoiZoom(10L, biomes);
        features = GenLayerTFFeatureZoom.multipleZoom(1004L, features, 4);
        genlayervoronoizoom = new GenLayerTFReinsertFeatures(100L, genlayervoronoizoom, features);
        biomes.func_75905_a(l);
        genlayervoronoizoom.func_75905_a(l);
        features.func_75905_a(l);
        return new GenLayer[] { biomes, genlayervoronoizoom, features };
    }
    
    public static GenLayer[] makeTheWorldPreset(final long l) {
        final byte zoomFactor = 4;
        GenLayer biomes = new GenLayerTFBiomes(1L);
        GenLayer features = new GenLayerTFMajorFeatures(1L);
        biomes = (GenLayer)new GenLayerZoom(1000L, biomes);
        biomes = (GenLayer)new GenLayerZoom(1001L, biomes);
        features = GenLayerTFFeatureZoom.multipleZoom(1000L, features, 2);
        biomes = new GenLayerTFStabilizeBiomes(900, biomes, features);
        biomes = new GenLayerTFBiomeBorders(500L, biomes);
        biomes = (GenLayer)new GenLayerZoom(1002L, biomes);
        biomes = (GenLayer)new GenLayerZoom(1003L, biomes);
        features = GenLayerTFFeatureZoom.multipleZoom(1002L, features, 2);
        features = new GenLayerTFMinorFeatures(700, biomes, features);
        features = new GenLayerTFClearMajorFeatures(700L, features);
        features = new GenLayerTFClearMinorFeatures(701L, features);
        biomes = (GenLayer)new GenLayerZoom(1004L, biomes);
        biomes = (GenLayer)new GenLayerZoom(1005L, biomes);
        GenLayer riverLayer = new GenLayerTFStream(1L, biomes);
        riverLayer = (GenLayer)new GenLayerSmooth(7000L, riverLayer);
        biomes = (GenLayer)new GenLayerRiverMix(100L, biomes, riverLayer);
        GenLayer genlayervoronoizoom = (GenLayer)new GenLayerVoronoiZoom(10L, biomes);
        features = GenLayerTFFeatureZoom.multipleZoom(1004L, features, 4);
        genlayervoronoizoom = new GenLayerTFReinsertFeatures(100L, genlayervoronoizoom, features);
        biomes.func_75905_a(l);
        genlayervoronoizoom.func_75905_a(l);
        features.func_75905_a(l);
        return new GenLayer[] { biomes, genlayervoronoizoom, features };
    }
}
