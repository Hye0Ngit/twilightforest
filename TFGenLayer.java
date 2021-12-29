// 
// Decompiled by Procyon v0.6-prerelease
// 

public abstract class TFGenLayer extends jx
{
    public TFGenLayer(final long l) {
        super(l);
    }
    
    public static jx[] makeTheWorld(final long l) {
        jx baseLayer = new LayerTFBase(1L);
        baseLayer = (jx)new gn(2000L, baseLayer);
        baseLayer = (jx)new tv(1L, baseLayer);
        baseLayer = (jx)new act(2001L, baseLayer);
        baseLayer = (jx)new tv(2L, baseLayer);
        baseLayer = (jx)new act(2002L, baseLayer);
        baseLayer = (jx)new tv(3L, baseLayer);
        baseLayer = (jx)new act(2003L, baseLayer);
        baseLayer = (jx)new tv(3L, baseLayer);
        baseLayer = (jx)new act(2004L, baseLayer);
        baseLayer = (jx)new tv(3L, baseLayer);
        final byte zoomFactor = 4;
        jx riverLayer = baseLayer;
        riverLayer = act.a(1000L, riverLayer, 0);
        riverLayer = (jx)new sp(100L, riverLayer);
        riverLayer = act.a(1000L, riverLayer, zoomFactor + 2);
        riverLayer = new GenLayerTFStream(1L, riverLayer);
        riverLayer = (jx)new acn(1000L, riverLayer);
        jx biomes = baseLayer;
        biomes = act.a(1000L, biomes, 0);
        biomes = new GenLayerTFBiomes(200L, biomes);
        biomes = act.a(1000L, biomes, 1);
        biomes = new GenLayerTFLakes(777L, biomes);
        biomes = new GenLayerTFGlaciers(200L, biomes);
        biomes = new GenLayerTFSnow(300L, biomes);
        biomes = act.a(1000L, biomes, 1);
        jx temperature = (jx)new afc(biomes);
        jx rainfall = (jx)new afd(biomes);
        for (int i = 0; i < zoomFactor; ++i) {
            biomes = (jx)new act((long)(1000 + i), biomes);
            if (i == 0) {
                biomes = (jx)new tv(3L, biomes);
            }
            temperature = (jx)new jw((long)(1000 + i), temperature);
            temperature = (jx)new rk(temperature, biomes, i);
            rainfall = (jx)new jw((long)(1000 + i), rainfall);
            rainfall = (jx)new mh(rainfall, biomes, i);
        }
        biomes = (jx)new acn(1000L, biomes);
        biomes = (jx)new na(100L, biomes, riverLayer);
        biomes = new GenLayerTFOceanReplacement(100L, biomes);
        temperature = jw.a(1000L, temperature, 2);
        rainfall = jw.a(1000L, rainfall, 2);
        final df genlayerzoomvoronoi = new df(10L, biomes);
        biomes.b(l);
        temperature.b(l);
        rainfall.b(l);
        genlayerzoomvoronoi.b(l);
        return new jx[] { biomes, (jx)genlayerzoomvoronoi, temperature, rainfall };
    }
}
