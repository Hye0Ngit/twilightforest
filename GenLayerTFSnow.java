// 
// Decompiled by Procyon v0.6-prerelease
// 

public class GenLayerTFSnow extends jx
{
    public GenLayerTFSnow(final long l, final jx genlayer) {
        super(l);
        this.a = genlayer;
    }
    
    public int[] a(final int x, final int z, final int width, final int depth) {
        final int nx = x - 1;
        final int nz = z - 1;
        final int nwidth = width + 2;
        final int ndepth = depth + 2;
        final int[] input = this.a.a(nx, nz, nwidth, ndepth);
        final int[] output = bm.a(width * depth);
        for (int dz = 0; dz < depth; ++dz) {
            for (int dx = 0; dx < width; ++dx) {
                final int v01 = input[dx + 0 + (dz + 1) * nwidth];
                final int v2 = input[dx + 2 + (dz + 1) * nwidth];
                final int v3 = input[dx + 1 + (dz + 0) * nwidth];
                final int v4 = input[dx + 1 + (dz + 2) * nwidth];
                final int v5 = input[dx + 1 + (dz + 1) * nwidth];
                if (v01 == TFBiomeBase.glacier.F || v2 == TFBiomeBase.glacier.F || v3 == TFBiomeBase.glacier.F || v4 == TFBiomeBase.glacier.F) {
                    output[dx + dz * width] = TFBiomeBase.snow.F;
                }
                else {
                    output[dx + dz * width] = v5;
                }
            }
        }
        return output;
    }
}
