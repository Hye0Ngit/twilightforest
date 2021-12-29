// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class GenLayerTFMinorFeaturesElimination extends wp
{
    public GenLayerTFMinorFeaturesElimination(final long par1, final wp par3GenLayer) {
        super(par1);
        this.a = par3GenLayer;
    }
    
    public int[] a(final int x, final int z, final int width, final int depth) {
        final int[] in = this.a.a(x - 5, z - 5, width + 10, depth + 10);
        final int[] out = ad.a(width * depth);
        for (int dz = 0; dz < depth; ++dz) {
            for (int dx = 0; dx < width; ++dx) {
                this.a((long)(dx + x), (long)(dz + z));
                final int inputBiome = in[dx + 5 + (dz + 5) * (width + 10)];
                if (inputBiome == TFBiomeBase.minorFeature.M) {
                    boolean valid = true;
                    for (int sz = 1; sz <= 4; ++sz) {
                        for (int sx = 1; sx <= 4; ++sx) {
                            final int scanBiome = in[dx + sx + 5 + (dz + sz + 5) * (width + 10)];
                            if (TFBiomeBase.isFeature(scanBiome)) {
                                valid = false;
                            }
                        }
                    }
                    if (valid) {
                        out[dx + dz * width] = inputBiome;
                    }
                    else {
                        out[dx + dz * width] = in[dx + 6 + (dz + 6) * (width + 10)];
                    }
                }
                else {
                    out[dx + dz * width] = inputBiome;
                }
            }
        }
        return out;
    }
}
