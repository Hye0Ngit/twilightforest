// 
// Decompiled by Procyon v0.6-prerelease
// 

public abstract class GenLayerTF extends wl
{
    public GenLayerTF(final long l) {
        super(l);
    }
    
    public static wl[] makeTheWorld(final long l) {
        final byte zoomFactor = 4;
        wl biomes = new GenLayerTFBiomes(1L);
        biomes = new GenLayerTFFourZoom(1000L, biomes);
        biomes = new GenLayerTFRegionZoom(1001L, biomes, true);
        biomes = new GenLayerTFBiomeBorders(500L, biomes);
        for (int i = 0; i < zoomFactor; ++i) {
            biomes = new GenLayerTFRegionZoom(1002 + i, biomes, i == 1);
        }
        wl riverLayer = new GenLayerTFStream(1L, biomes);
        riverLayer = (wl)new fh(7000L, riverLayer);
        biomes = (wl)new akf(100L, biomes, riverLayer);
        GenLayerTFRegionZoom features = new GenLayerTFRegionZoom(10L, biomes, true);
        features = new GenLayerTFRegionZoom(11L, features, false);
        biomes = new GenLayerTFRemoveFeatures(700L, biomes);
        wl genlayervoronoizoom = (wl)new abj(10L, biomes);
        genlayervoronoizoom = new GenLayerReinsertFeatures(100L, genlayervoronoizoom, features);
        biomes.a(l);
        genlayervoronoizoom.a(l);
        features.a(l);
        return new wl[] { biomes, genlayervoronoizoom, features };
    }
}
