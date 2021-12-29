// 
// Decompiled by Procyon v0.6-prerelease
// 

public class GenLayerTFBiomeBorders extends wl
{
    public GenLayerTFBiomeBorders(final long l, final wl genlayer) {
        super(l);
        this.a = genlayer;
    }
    
    public int[] a(final int x, final int z, final int width, final int depth) {
        final int nx = x - 1;
        final int nz = z - 1;
        final int nwidth = width + 2;
        final int ndepth = depth + 2;
        final int[] input = this.a.a(nx, nz, nwidth, ndepth);
        final int[] output = ac.a(width * depth);
        for (int dz = 0; dz < depth; ++dz) {
            for (int dx = 0; dx < width; ++dx) {
                final int right = input[dx + 0 + (dz + 1) * nwidth];
                final int left = input[dx + 2 + (dz + 1) * nwidth];
                final int up = input[dx + 1 + (dz + 0) * nwidth];
                final int down = input[dx + 1 + (dz + 2) * nwidth];
                final int center = input[dx + 1 + (dz + 1) * nwidth];
                if (this.onBorder(TFBiomeBase.tfLake.M, center, right, left, up, down)) {
                    output[dx + dz * width] = TFBiomeBase.lakeBorder.M;
                }
                else if (this.onBorder(TFBiomeBase.clearing.M, center, right, left, up, down)) {
                    output[dx + dz * width] = TFBiomeBase.clearingBorder.M;
                }
                else if (this.onBorder(TFBiomeBase.deepMushrooms.M, center, right, left, up, down)) {
                    output[dx + dz * width] = TFBiomeBase.mushrooms.M;
                }
                else if (this.onBorder(TFBiomeBase.glacier.M, center, right, left, up, down)) {
                    output[dx + dz * width] = TFBiomeBase.snow.M;
                }
                else {
                    output[dx + dz * width] = center;
                }
            }
        }
        return output;
    }
    
    boolean onBorder(final int biome, final int center, final int right, final int left, final int up, final int down) {
        return center == biome && ((right != biome && right != TFBiomeBase.largeFeature.M) || (left != biome && left != TFBiomeBase.largeFeature.M) || (up != biome && up != TFBiomeBase.largeFeature.M) || (down != biome && down != TFBiomeBase.largeFeature.M));
    }
}
