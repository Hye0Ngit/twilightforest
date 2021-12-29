// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.biomes.TFBiomeBase;

public class GenLayerTFClearMajorFeatures extends agw
{
    private static final int SCAN = 4;
    private static final int DSCAN = 9;
    
    public GenLayerTFClearMajorFeatures(final long par1, final agw par3GenLayer) {
        super(par1);
        this.a = par3GenLayer;
    }
    
    public int[] a(final int x, final int z, final int width, final int depth) {
        final int[] in = this.a.a(x - 4, z - 4, width + 9, depth + 9);
        final int[] out = agu.a(width * depth);
        for (int dz = 0; dz < depth; ++dz) {
            for (int dx = 0; dx < width; ++dx) {
                this.a((long)(dx + x), (long)(dz + z));
                final int inputBiome = in[dx + 4 + (dz + 4) * (width + 9)];
                if (inputBiome > 0 && inputBiome < TFBiomeBase.majorFeature.N) {
                    boolean valid = true;
                    for (int sz = 0; sz <= 8; ++sz) {
                        for (int sx = 0; sx <= 8; ++sx) {
                            final int scanBiome = in[dx + sx + (dz + sz) * (width + 9)];
                            if (scanBiome == TFBiomeBase.majorFeature.N) {
                                valid = false;
                            }
                        }
                    }
                    out[dx + dz * width] = (valid ? inputBiome : 0);
                }
                else {
                    out[dx + dz * width] = inputBiome;
                }
            }
        }
        return out;
    }
}
