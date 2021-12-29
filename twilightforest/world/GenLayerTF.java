// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

public abstract class GenLayerTF extends agw
{
    public GenLayerTF(final long l) {
        super(l);
    }
    
    public static agw[] makeTheWorld(final long l) {
        final byte zoomFactor = 4;
        agw biomes = new GenLayerTFBiomes(1L);
        agw features = new GenLayerTFMajorFeatures(1L);
        biomes = (agw)new ahi(1000L, biomes);
        biomes = (agw)new ahi(1001L, biomes);
        biomes = new GenLayerTFBiomeBorders(500L, biomes);
        biomes = (agw)new ahi(1002L, biomes);
        biomes = (agw)new ahi(1003L, biomes);
        features = GenLayerTFFeatureZoom.multipleZoom(1000L, features, 4);
        features = new GenLayerTFMinorFeatures(700, biomes, features);
        features = new GenLayerTFClearMajorFeatures(700L, features);
        features = new GenLayerTFClearMinorFeatures(701L, features);
        biomes = (agw)new ahi(1004L, biomes);
        biomes = (agw)new ahi(1005L, biomes);
        agw riverLayer = new GenLayerTFStream(1L, biomes);
        riverLayer = (agw)new ahc(7000L, riverLayer);
        biomes = (agw)new aha(100L, biomes, riverLayer);
        agw genlayervoronoizoom = (agw)new ahh(10L, biomes);
        features = GenLayerTFFeatureZoom.multipleZoom(1004L, features, 4);
        genlayervoronoizoom = new GenLayerTFReinsertFeatures(100L, genlayervoronoizoom, features);
        biomes.a(l);
        genlayervoronoizoom.a(l);
        features.a(l);
        return new agw[] { biomes, genlayervoronoizoom, features };
    }
}
