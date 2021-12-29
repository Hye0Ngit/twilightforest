// 
// Decompiled by Procyon v0.6-prerelease
// 

public class GenLayerTFStream extends jx
{
    public GenLayerTFStream(final long l, final jx genlayer) {
        super(l);
        super.a = genlayer;
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
                final int left = input[dx + 0 + (dz + 1) * nwidth];
                final int right = input[dx + 2 + (dz + 1) * nwidth];
                final int down = input[dx + 1 + (dz + 0) * nwidth];
                final int up = input[dx + 1 + (dz + 2) * nwidth];
                final int mid = input[dx + 1 + (dz + 1) * nwidth];
                if (mid == 0 || left == 0 || right == 0 || down == 0 || up == 0) {
                    output[dx + dz * width] = TFBiomeBase.stream.F;
                }
                else if (mid != left || mid != down || mid != right || mid != up) {
                    output[dx + dz * width] = TFBiomeBase.stream.F;
                }
                else {
                    output[dx + dz * width] = -1;
                }
            }
        }
        return output;
    }
}
