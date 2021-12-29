// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class GenLayerTFStream extends wp
{
    public GenLayerTFStream(final long l, final wp genlayer) {
        super(l);
        super.a = genlayer;
    }
    
    public int[] a(final int x, final int z, final int width, final int depth) {
        final int nx = x - 1;
        final int nz = z - 1;
        final int nwidth = width + 2;
        final int ndepth = depth + 2;
        final int[] input = this.a.a(nx, nz, nwidth, ndepth);
        final int[] output = ad.a(width * depth);
        for (int dz = 0; dz < depth; ++dz) {
            for (int dx = 0; dx < width; ++dx) {
                final int left = input[dx + 0 + (dz + 1) * nwidth];
                final int right = input[dx + 2 + (dz + 1) * nwidth];
                final int down = input[dx + 1 + (dz + 0) * nwidth];
                final int up = input[dx + 1 + (dz + 2) * nwidth];
                final int mid = input[dx + 1 + (dz + 1) * nwidth];
                if (this.shouldStream(mid, left, down, right, up)) {
                    output[dx + dz * width] = TFBiomeBase.stream.M;
                }
                else {
                    output[dx + dz * width] = -1;
                }
            }
        }
        return output;
    }
    
    boolean shouldStream(final int mid, final int left, final int down, final int right, final int up) {
        return this.shouldStream(mid, left) || this.shouldStream(mid, right) || this.shouldStream(mid, down) || this.shouldStream(mid, up);
    }
    
    boolean shouldStream(final int biome1, final int biome2) {
        return biome1 != biome2 && biome1 != -biome2 && (biome1 != TFBiomeBase.glacier.M || biome2 != TFBiomeBase.snow.M) && (biome1 != TFBiomeBase.snow.M || biome2 != TFBiomeBase.glacier.M) && (biome1 != TFBiomeBase.deepMushrooms.M || biome2 != TFBiomeBase.mushrooms.M) && (biome1 != TFBiomeBase.mushrooms.M || biome2 != TFBiomeBase.deepMushrooms.M) && biome1 != TFBiomeBase.tfLake.M && biome2 != TFBiomeBase.tfLake.M && biome1 != TFBiomeBase.clearing.M && biome2 != TFBiomeBase.clearing.M && !TFBiomeBase.isFeature(biome1) && !TFBiomeBase.isFeature(biome2);
    }
}
