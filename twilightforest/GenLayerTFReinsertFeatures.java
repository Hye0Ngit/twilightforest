// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class GenLayerTFReinsertFeatures extends wp
{
    private wp withoutLayer;
    private wp withLayer;
    
    public GenLayerTFReinsertFeatures(final long par1, final wp par3GenLayer, final wp par4GenLayer) {
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
        final int[] dest = ad.a(mapWidth * mapDepth);
        for (int i = 0; i < mapWidth * mapDepth; ++i) {
            if (TFBiomeBase.isFeature(with[i])) {
                dest[i] = with[i];
            }
            else {
                dest[i] = without[i];
            }
        }
        return dest;
    }
}
