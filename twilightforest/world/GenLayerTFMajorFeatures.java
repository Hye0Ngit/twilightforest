// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.biomes.TFBiomeBase;

public class GenLayerTFMajorFeatures extends agp
{
    public GenLayerTFMajorFeatures(final long par1) {
        super(par1);
    }
    
    public int[] a(final int x, final int z, final int width, final int depth) {
        final int[] out = agn.a(width * depth);
        for (int i = 0; i < out.length; ++i) {
            out[i] = TFBiomeBase.majorFeature.N;
        }
        return out;
    }
}
