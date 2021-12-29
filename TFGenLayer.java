// 
// Decompiled by Procyon v0.6-prerelease
// 

public abstract class TFGenLayer extends es
{
    public TFGenLayer(final long l) {
        super(l);
    }
    
    public static es[] makeTheWorld(final long l) {
        es baseLayer = new LayerTFBase(1L);
        baseLayer = (es)new xa(2000L, baseLayer);
        baseLayer = (es)new cl(1L, baseLayer);
        baseLayer = (es)new eo(2001L, baseLayer);
        baseLayer = (es)new cl(2L, baseLayer);
        baseLayer = (es)new eo(2002L, baseLayer);
        baseLayer = (es)new cl(3L, baseLayer);
        baseLayer = (es)new eo(2003L, baseLayer);
        baseLayer = (es)new cl(3L, baseLayer);
        baseLayer = (es)new eo(2004L, baseLayer);
        baseLayer = (es)new cl(3L, baseLayer);
        final byte zoomFactor = 4;
        es riverLayer = baseLayer;
        riverLayer = eo.a(1000L, riverLayer, 0);
        riverLayer = (es)new nd(100L, riverLayer);
        riverLayer = eo.a(1000L, riverLayer, zoomFactor + 2);
        riverLayer = new GenLayerTFStream(1L, riverLayer);
        riverLayer = (es)new hs(1000L, riverLayer);
        es biomes = baseLayer;
        biomes = eo.a(1000L, biomes, 0);
        biomes = new GenLayerTFBiomes(200L, biomes);
        biomes = eo.a(1000L, biomes, 1);
        biomes = new GenLayerTFLakes(777L, biomes);
        biomes = new GenLayerTFGlaciers(200L, biomes);
        biomes = new GenLayerTFSnow(300L, biomes);
        biomes = eo.a(1000L, biomes, 1);
        es temperature = (es)new pw(biomes);
        es rainfall = (es)new vf(biomes);
        for (int i = 0; i < zoomFactor; ++i) {
            biomes = (es)new eo((long)(1000 + i), biomes);
            if (i == 0) {
                biomes = (es)new cl(3L, biomes);
            }
            temperature = (es)new lu((long)(1000 + i), temperature);
            temperature = (es)new dv(temperature, biomes, i);
            rainfall = (es)new lu((long)(1000 + i), rainfall);
            rainfall = (es)new ts(rainfall, biomes, i);
        }
        biomes = (es)new hs(1000L, biomes);
        biomes = (es)new ws(100L, biomes, riverLayer);
        biomes = new GenLayerTFOceanReplacement(100L, biomes);
        temperature = lu.a(1000L, temperature, 2);
        rainfall = lu.a(1000L, rainfall, 2);
        final kn genlayerzoomvoronoi = new kn(10L, biomes);
        biomes.b(l);
        temperature.b(l);
        rainfall.b(l);
        genlayerzoomvoronoi.b(l);
        return new es[] { biomes, (es)genlayerzoomvoronoi, temperature, rainfall };
    }
}
