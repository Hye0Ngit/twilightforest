// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.biomes.TFBiomeBase;

public class GenLayerTFReinsertFeatures extends agp
{
    private agp withoutLayer;
    private agp withLayer;
    
    public GenLayerTFReinsertFeatures(final long par1, final agp par3GenLayer, final agp par4GenLayer) {
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
        final int[] dest = agn.a(mapWidth * mapDepth);
        for (int i = 0; i < mapWidth * mapDepth; ++i) {
            if (with[i] > 0) {
                dest[i] = ((with[i] == TFBiomeBase.majorFeature.N) ? with[i] : TFBiomeBase.minorFeature.N);
            }
            else {
                if (without[i] < 0) {
                    System.err.println("Getting an invalid value " + without[i] + " in the without layer at " + mapX + ", " + mapZ);
                    System.err.println("Suppressing bad biome value during terrain generation");
                    without[i] = TFBiomeBase.twilightForest.N;
                }
                dest[i] = without[i];
            }
        }
        return dest;
    }
}
