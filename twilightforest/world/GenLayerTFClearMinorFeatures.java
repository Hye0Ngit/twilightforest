// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.biomes.TFBiomeBase;

public class GenLayerTFClearMinorFeatures extends agw
{
    private static final int SCAN = 3;
    private static final int DSCAN = 6;
    
    public GenLayerTFClearMinorFeatures(final long par1, final agw par3GenLayer) {
        super(par1);
        this.a = par3GenLayer;
    }
    
    public int[] a(final int x, final int z, final int width, final int depth) {
        final int[] in = this.a.a(x - 3, z - 3, width + 6, depth + 6);
        final int[] out = agu.a(width * depth);
        for (int dz = 0; dz < depth; ++dz) {
            for (int dx = 0; dx < width; ++dx) {
                this.a((long)(dx + x), (long)(dz + z));
                final int inputBiome = in[dx + 3 + (dz + 3) * (width + 6)];
                if (inputBiome > 0 && inputBiome < TFBiomeBase.majorFeature.N) {
                    boolean valid = true;
                    for (int sz = 0; sz <= 6; ++sz) {
                        for (int sx = 0; sx <= 6; ++sx) {
                            final int scanBiome = in[dx + sx + (dz + sz) * (width + 6)];
                            if (scanBiome >= inputBiome && (sz != 3 || sx != 3)) {
                                valid = false;
                            }
                        }
                    }
                    in[dx + 3 + (dz + 3) * (width + 6)] = (out[dx + dz * width] = (valid ? inputBiome : 0));
                }
                else {
                    out[dx + dz * width] = inputBiome;
                }
            }
        }
        return out;
    }
}
