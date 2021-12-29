// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

public abstract class GenLayerTF extends ain
{
    public GenLayerTF(final long l) {
        super(l);
    }
    
    public static ain[] makeTheWorld(final long l) {
        final byte zoomFactor = 4;
        ain biomes = new GenLayerTFBiomes(1L);
        biomes = (ain)new aiz(1000L, biomes);
        biomes = (ain)new aiz(1001L, biomes);
        biomes = new GenLayerTFBiomeBorders(500L, biomes);
        biomes = (ain)new aiz(1002L, biomes);
        biomes = (ain)new aiz(1003L, biomes);
        biomes = (ain)new aiz(1004L, biomes);
        biomes = (ain)new aiz(1005L, biomes);
        ain riverLayer = new GenLayerTFStream(1L, biomes);
        riverLayer = (ain)new ait(7000L, riverLayer);
        biomes = (ain)new air(100L, biomes, riverLayer);
        final ain genlayervoronoizoom = (ain)new aiy(10L, biomes);
        biomes.a(l);
        genlayervoronoizoom.a(l);
        return new ain[] { biomes, genlayervoronoizoom };
    }
    
    public static ain[] makeTheWorldPreFeatureRemoval(final long l) {
        final byte zoomFactor = 4;
        ain biomes = new GenLayerTFBiomes(1L);
        ain features = new GenLayerTFMajorFeatures(1L);
        biomes = (ain)new aiz(1000L, biomes);
        biomes = (ain)new aiz(1001L, biomes);
        biomes = new GenLayerTFBiomeBorders(500L, biomes);
        biomes = (ain)new aiz(1002L, biomes);
        biomes = (ain)new aiz(1003L, biomes);
        features = GenLayerTFFeatureZoom.multipleZoom(1000L, features, 4);
        features = new GenLayerTFMinorFeatures(700, biomes, features);
        features = new GenLayerTFClearMajorFeatures(700L, features);
        features = new GenLayerTFClearMinorFeatures(701L, features);
        biomes = (ain)new aiz(1004L, biomes);
        biomes = (ain)new aiz(1005L, biomes);
        ain riverLayer = new GenLayerTFStream(1L, biomes);
        riverLayer = (ain)new ait(7000L, riverLayer);
        biomes = (ain)new air(100L, biomes, riverLayer);
        ain genlayervoronoizoom = (ain)new aiy(10L, biomes);
        features = GenLayerTFFeatureZoom.multipleZoom(1004L, features, 4);
        genlayervoronoizoom = new GenLayerTFReinsertFeatures(100L, genlayervoronoizoom, features);
        biomes.a(l);
        genlayervoronoizoom.a(l);
        features.a(l);
        return new ain[] { biomes, genlayervoronoizoom, features };
    }
    
    public static ain[] makeTheWorldPreset(final long l) {
        final byte zoomFactor = 4;
        ain biomes = new GenLayerTFBiomes(1L);
        ain features = new GenLayerTFMajorFeatures(1L);
        biomes = (ain)new aiz(1000L, biomes);
        biomes = (ain)new aiz(1001L, biomes);
        features = GenLayerTFFeatureZoom.multipleZoom(1000L, features, 2);
        biomes = new GenLayerTFStabilizeBiomes(900, biomes, features);
        biomes = new GenLayerTFBiomeBorders(500L, biomes);
        biomes = (ain)new aiz(1002L, biomes);
        biomes = (ain)new aiz(1003L, biomes);
        features = GenLayerTFFeatureZoom.multipleZoom(1002L, features, 2);
        features = new GenLayerTFMinorFeatures(700, biomes, features);
        features = new GenLayerTFClearMajorFeatures(700L, features);
        features = new GenLayerTFClearMinorFeatures(701L, features);
        biomes = (ain)new aiz(1004L, biomes);
        biomes = (ain)new aiz(1005L, biomes);
        ain riverLayer = new GenLayerTFStream(1L, biomes);
        riverLayer = (ain)new ait(7000L, riverLayer);
        biomes = (ain)new air(100L, biomes, riverLayer);
        ain genlayervoronoizoom = (ain)new aiy(10L, biomes);
        features = GenLayerTFFeatureZoom.multipleZoom(1004L, features, 4);
        genlayervoronoizoom = new GenLayerTFReinsertFeatures(100L, genlayervoronoizoom, features);
        biomes.a(l);
        genlayervoronoizoom.a(l);
        features.a(l);
        return new ain[] { biomes, genlayervoronoizoom, features };
    }
}
