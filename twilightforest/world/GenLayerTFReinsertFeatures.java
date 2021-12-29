// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.biomes.TFBiomeBase;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraft.world.gen.layer.GenLayer;

public class GenLayerTFReinsertFeatures extends GenLayer
{
    private GenLayer withoutLayer;
    private GenLayer withLayer;
    
    public GenLayerTFReinsertFeatures(final long par1, final GenLayer par3GenLayer, final GenLayer par4GenLayer) {
        super(par1);
        this.withoutLayer = par3GenLayer;
        this.withLayer = par4GenLayer;
    }
    
    public void func_75905_a(final long par1) {
        this.withoutLayer.func_75905_a(par1);
        this.withLayer.func_75905_a(par1);
        super.func_75905_a(par1);
    }
    
    public int[] func_75904_a(final int mapX, final int mapZ, final int mapWidth, final int mapDepth) {
        final int[] without = this.withoutLayer.func_75904_a(mapX, mapZ, mapWidth, mapDepth);
        final int[] with = this.withLayer.func_75904_a(mapX, mapZ, mapWidth, mapDepth);
        final int[] dest = IntCache.func_76445_a(mapWidth * mapDepth);
        for (int i = 0; i < mapWidth * mapDepth; ++i) {
            if (with[i] > 0) {
                dest[i] = ((with[i] == TFBiomeBase.majorFeature.field_76756_M) ? with[i] : TFBiomeBase.minorFeature.field_76756_M);
            }
            else {
                if (without[i] < 0) {
                    without[i] = TFBiomeBase.twilightForest.field_76756_M;
                }
                dest[i] = without[i];
            }
        }
        return dest;
    }
}
