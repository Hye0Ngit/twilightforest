// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

public abstract class GenLayerTF extends akn
{
    public GenLayerTF(final long l) {
        super(l);
    }
    
    public static akn[] makeTheWorld(final long l) {
        final byte zoomFactor = 4;
        akn biomes = new GenLayerTFBiomes(1L);
        biomes = (akn)new akz(1000L, biomes);
        biomes = (akn)new akz(1001L, biomes);
        biomes = new GenLayerTFBiomeBorders(500L, biomes);
        biomes = (akn)new akz(1002L, biomes);
        biomes = (akn)new akz(1003L, biomes);
        biomes = (akn)new akz(1004L, biomes);
        biomes = (akn)new akz(1005L, biomes);
        akn riverLayer = new GenLayerTFStream(1L, biomes);
        riverLayer = (akn)new akt(7000L, riverLayer);
        biomes = (akn)new akr(100L, biomes, riverLayer);
        final akn genlayervoronoizoom = (akn)new aky(10L, biomes);
        biomes.a(l);
        genlayervoronoizoom.a(l);
        return new akn[] { biomes, genlayervoronoizoom };
    }
    
    public static akn[] makeTheWorldPreFeatureRemoval(final long l) {
        final byte zoomFactor = 4;
        akn biomes = new GenLayerTFBiomes(1L);
        akn features = new GenLayerTFMajorFeatures(1L);
        biomes = (akn)new akz(1000L, biomes);
        biomes = (akn)new akz(1001L, biomes);
        biomes = new GenLayerTFBiomeBorders(500L, biomes);
        biomes = (akn)new akz(1002L, biomes);
        biomes = (akn)new akz(1003L, biomes);
        features = GenLayerTFFeatureZoom.multipleZoom(1000L, features, 4);
        features = new GenLayerTFMinorFeatures(700, biomes, features);
        features = new GenLayerTFClearMajorFeatures(700L, features);
        features = new GenLayerTFClearMinorFeatures(701L, features);
        biomes = (akn)new akz(1004L, biomes);
        biomes = (akn)new akz(1005L, biomes);
        akn riverLayer = new GenLayerTFStream(1L, biomes);
        riverLayer = (akn)new akt(7000L, riverLayer);
        biomes = (akn)new akr(100L, biomes, riverLayer);
        akn genlayervoronoizoom = (akn)new aky(10L, biomes);
        features = GenLayerTFFeatureZoom.multipleZoom(1004L, features, 4);
        genlayervoronoizoom = new GenLayerTFReinsertFeatures(100L, genlayervoronoizoom, features);
        biomes.a(l);
        genlayervoronoizoom.a(l);
        features.a(l);
        return new akn[] { biomes, genlayervoronoizoom, features };
    }
    
    public static akn[] makeTheWorldPreset(final long l) {
        final byte zoomFactor = 4;
        akn biomes = new GenLayerTFBiomes(1L);
        akn features = new GenLayerTFMajorFeatures(1L);
        biomes = (akn)new akz(1000L, biomes);
        biomes = (akn)new akz(1001L, biomes);
        features = GenLayerTFFeatureZoom.multipleZoom(1000L, features, 2);
        biomes = new GenLayerTFStabilizeBiomes(900, biomes, features);
        biomes = new GenLayerTFBiomeBorders(500L, biomes);
        biomes = (akn)new akz(1002L, biomes);
        biomes = (akn)new akz(1003L, biomes);
        features = GenLayerTFFeatureZoom.multipleZoom(1002L, features, 2);
        features = new GenLayerTFMinorFeatures(700, biomes, features);
        features = new GenLayerTFClearMajorFeatures(700L, features);
        features = new GenLayerTFClearMinorFeatures(701L, features);
        biomes = (akn)new akz(1004L, biomes);
        biomes = (akn)new akz(1005L, biomes);
        akn riverLayer = new GenLayerTFStream(1L, biomes);
        riverLayer = (akn)new akt(7000L, riverLayer);
        biomes = (akn)new akr(100L, biomes, riverLayer);
        akn genlayervoronoizoom = (akn)new aky(10L, biomes);
        features = GenLayerTFFeatureZoom.multipleZoom(1004L, features, 4);
        genlayervoronoizoom = new GenLayerTFReinsertFeatures(100L, genlayervoronoizoom, features);
        biomes.a(l);
        genlayervoronoizoom.a(l);
        features.a(l);
        return new akn[] { biomes, genlayervoronoizoom, features };
    }
}
