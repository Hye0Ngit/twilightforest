// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.biomes.TFBiomeBase;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraft.world.gen.layer.GenLayer;

public class GenLayerTFMajorFeatures extends GenLayer
{
    public GenLayerTFMajorFeatures(final long par1) {
        super(par1);
    }
    
    public int[] func_75904_a(final int x, final int z, final int width, final int depth) {
        final int[] out = IntCache.func_76445_a(width * depth);
        for (int i = 0; i < out.length; ++i) {
            out[i] = TFBiomeBase.majorFeature.field_76756_M;
        }
        return out;
    }
}
