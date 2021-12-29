// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class GenLayerTFMinorFeatures extends wp
{
    public GenLayerTFMinorFeatures(final long par1, final wp par3GenLayer) {
        super(par1);
        this.a = par3GenLayer;
    }
    
    public int[] a(final int x, final int z, final int width, final int depth) {
        final int[] in = this.a.a(x - 1, z - 1, width + 2, depth + 2);
        final int[] out = ad.a(width * depth);
        for (int dz = 0; dz < depth; ++dz) {
            for (int dx = 0; dx < width; ++dx) {
                this.a((long)(dx + x), (long)(dz + z));
                final int inputBiome = in[dx + 1 + (dz + 1) * (width + 2)];
                int up = in[dx + 1 + (dz + 1 - 1) * (width + 2)];
                int right = in[dx + 1 + 1 + (dz + 1) * (width + 2)];
                final int left = in[dx + 1 - 1 + (dz + 1) * (width + 2)];
                final int down = in[dx + 1 + (dz + 1 + 1) * (width + 2)];
                final int ul = in[dx + 1 - 1 + (dz + 1 - 1) * (width + 2)];
                final int dr = in[dx + 1 + 1 + (dz + 1 + 1) * (width + 2)];
                int ur = in[dx + 1 + 1 + (dz + 1 - 1) * (width + 2)];
                final int dl = in[dx + 1 - 1 + (dz + 1 + 1) * (width + 2)];
                if (ul == inputBiome && dr == inputBiome && ur == inputBiome && dl == inputBiome && up == inputBiome && right == inputBiome && left == inputBiome && down == inputBiome) {
                    if (dz > 0) {
                        up = out[dx + (dz - 1) * width];
                    }
                    if (dx > 0) {
                        right = out[dx - 1 + dz * width];
                    }
                    if (dz > 0 && dx > 0) {
                        ur = out[dx - 1 + (dz - 1) * width];
                    }
                    if (!TFBiomeBase.isFeature(ur) && !TFBiomeBase.isFeature(up) && !TFBiomeBase.isFeature(right)) {
                        out[dx + dz * width] = TFBiomeBase.minorFeature.M;
                    }
                    else {
                        out[dx + dz * width] = inputBiome;
                    }
                }
                else {
                    out[dx + dz * width] = inputBiome;
                }
            }
        }
        return out;
    }
    
    boolean isValid(final int biome) {
        return !TFBiomeBase.isFeature(biome) && biome != TFBiomeBase.i.M;
    }
}
