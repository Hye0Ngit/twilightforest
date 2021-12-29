// 
// Decompiled by Procyon v0.6-prerelease
// 

public class GenLayerReinsertFeatures extends fh
{
    private fh withoutLayer;
    private fh withLayer;
    
    public GenLayerReinsertFeatures(final long par1, final fh par3GenLayer, final fh par4GenLayer) {
        super(par1);
        this.withoutLayer = par3GenLayer;
        this.withLayer = par4GenLayer;
    }
    
    public void a(final long par1) {
        this.withoutLayer.a(par1);
        this.withLayer.a(par1);
        super.a(par1);
    }
    
    public int[] a(final int mapX, final int mapZ, final int mapWidth, final int mapDepth) {
        final int[] without = this.withoutLayer.a(mapX, mapZ, mapWidth, mapDepth);
        final int[] with = this.withLayer.a(mapX, mapZ, mapWidth, mapDepth);
        final int[] dest = ak.a(mapWidth * mapDepth);
        for (int i = 0; i < mapWidth * mapDepth; ++i) {
            if (with[i] == TFBiomeBase.largeFeature.M) {
                dest[i] = with[i];
            }
            else {
                dest[i] = without[i];
            }
        }
        return dest;
    }
}
