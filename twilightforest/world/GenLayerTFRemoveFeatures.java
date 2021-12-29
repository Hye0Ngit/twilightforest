// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.biomes.TFBiomeBase;

public class GenLayerTFRemoveFeatures extends akn
{
    public GenLayerTFRemoveFeatures(final long par1, final akn par3GenLayer) {
        super(par1);
        this.a = par3GenLayer;
    }
    
    public int[] a(final int mapX, final int mapZ, final int mapWidth, final int mapDepth) {
        final int srcWidth = mapWidth + 1;
        final int srcDepth = mapDepth + 1;
        final int[] src = this.a.a(mapX, mapZ, srcWidth, mapDepth);
        final int[] dest = akl.a(mapWidth * mapDepth);
        for (int dz = 0; dz < mapDepth; ++dz) {
            for (int dx = 0; dx < mapWidth; ++dx) {
                final int srcVal = src[dx + dz * srcWidth];
                if (!TFBiomeBase.isFeature(srcVal)) {
                    dest[dx + dz * mapWidth] = srcVal;
                }
                else {
                    dest[dx + dz * mapWidth] = src[dx + 1 + (dz + 1) * srcWidth];
                }
            }
        }
        return dest;
    }
}
