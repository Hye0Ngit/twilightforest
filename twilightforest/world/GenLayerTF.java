// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

public abstract class GenLayerTF extends agp
{
    public GenLayerTF(final long l) {
        super(l);
    }
    
    public static agp[] makeTheWorld(final long l) {
        final byte zoomFactor = 4;
        agp biomes = new GenLayerTFBiomes(1L);
        agp features = new GenLayerTFMajorFeatures(1L);
        biomes = (agp)new ahb(1000L, biomes);
        biomes = (agp)new ahb(1001L, biomes);
        biomes = new GenLayerTFBiomeBorders(500L, biomes);
        biomes = (agp)new ahb(1002L, biomes);
        biomes = (agp)new ahb(1003L, biomes);
        features = GenLayerTFFeatureZoom.multipleZoom(1000L, features, 4);
        features = new GenLayerTFMinorFeatures(700, biomes, features);
        features = new GenLayerTFClearMajorFeatures(700L, features);
        features = new GenLayerTFClearMinorFeatures(701L, features);
        biomes = (agp)new ahb(1004L, biomes);
        biomes = (agp)new ahb(1005L, biomes);
        agp riverLayer = new GenLayerTFStream(1L, biomes);
        riverLayer = (agp)new agv(7000L, riverLayer);
        biomes = (agp)new agt(100L, biomes, riverLayer);
        agp genlayervoronoizoom = (agp)new aha(10L, biomes);
        features = GenLayerTFFeatureZoom.multipleZoom(1004L, features, 4);
        genlayervoronoizoom = new GenLayerTFReinsertFeatures(100L, genlayervoronoizoom, features);
        biomes.a(l);
        genlayervoronoizoom.a(l);
        features.a(l);
        return new agp[] { biomes, genlayervoronoizoom, features };
    }
}
