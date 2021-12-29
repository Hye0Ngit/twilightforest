// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public abstract class GenLayerTF extends wp
{
    public GenLayerTF(final long l) {
        super(l);
    }
    
    public static wp[] makeTheWorld(final long l) {
        final byte zoomFactor = 4;
        wp biomes = new GenLayerTFBiomes(1L);
        biomes = new GenLayerTFMajorFeatures(1000L, biomes);
        biomes = new GenLayerTFRegionZoom(1001L, biomes, true);
        biomes = new GenLayerTFBiomeBorders(500L, biomes);
        biomes = new GenLayerTFRegionZoom(1002L, biomes, false);
        biomes = new GenLayerTFRegionZoom(1003L, biomes, true);
        biomes = new GenLayerTFRegionZoom(1004L, biomes, false);
        biomes = new GenLayerTFRegionZoom(1005L, biomes, false);
        wp riverLayer = new GenLayerTFStream(1L, biomes);
        riverLayer = (wp)new fk(7000L, riverLayer);
        biomes = (wp)new akl(100L, biomes, riverLayer);
        GenLayerTFRegionZoom features = new GenLayerTFRegionZoom(10L, biomes, true);
        features = new GenLayerTFRegionZoom(11L, features, false);
        biomes = new GenLayerTFRemoveFeatures(700L, biomes);
        wp genlayervoronoizoom = (wp)new abo(10L, biomes);
        genlayervoronoizoom = new GenLayerTFReinsertFeatures(100L, genlayervoronoizoom, features);
        biomes.a(l);
        genlayervoronoizoom.a(l);
        features.a(l);
        return new wp[] { biomes, genlayervoronoizoom, features };
    }
}
