// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.biomes.TFBiomeBase;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraft.world.gen.layer.GenLayer;

public class GenLayerTFRemoveFeatures extends GenLayer
{
    public GenLayerTFRemoveFeatures(final long par1, final GenLayer par3GenLayer) {
        super(par1);
        this.field_75909_a = par3GenLayer;
    }
    
    public int[] func_75904_a(final int mapX, final int mapZ, final int mapWidth, final int mapDepth) {
        final int srcWidth = mapWidth + 1;
        final int srcDepth = mapDepth + 1;
        final int[] src = this.field_75909_a.func_75904_a(mapX, mapZ, srcWidth, mapDepth);
        final int[] dest = IntCache.func_76445_a(mapWidth * mapDepth);
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
