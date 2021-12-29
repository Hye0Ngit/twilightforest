// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.biomes.TFBiomeBase;

public class GenLayerTFBiomeBorders extends akn
{
    public GenLayerTFBiomeBorders(final long l, final akn genlayer) {
        super(l);
        this.a = genlayer;
    }
    
    public int[] a(final int x, final int z, final int width, final int depth) {
        final int nx = x - 1;
        final int nz = z - 1;
        final int nwidth = width + 2;
        final int ndepth = depth + 2;
        final int[] input = this.a.a(nx, nz, nwidth, ndepth);
        final int[] output = akl.a(width * depth);
        for (int dz = 0; dz < depth; ++dz) {
            for (int dx = 0; dx < width; ++dx) {
                final int right = input[dx + 0 + (dz + 1) * nwidth];
                final int left = input[dx + 2 + (dz + 1) * nwidth];
                final int up = input[dx + 1 + (dz + 0) * nwidth];
                final int down = input[dx + 1 + (dz + 2) * nwidth];
                final int center = input[dx + 1 + (dz + 1) * nwidth];
                if (this.onBorder(TFBiomeBase.tfLake.N, center, right, left, up, down)) {
                    output[dx + dz * width] = TFBiomeBase.lakeBorder.N;
                }
                else if (this.onBorder(TFBiomeBase.clearing.N, center, right, left, up, down)) {
                    output[dx + dz * width] = TFBiomeBase.clearingBorder.N;
                }
                else if (this.onBorder(TFBiomeBase.deepMushrooms.N, center, right, left, up, down)) {
                    output[dx + dz * width] = TFBiomeBase.mushrooms.N;
                }
                else if (this.onBorder(TFBiomeBase.glacier.N, center, right, left, up, down)) {
                    output[dx + dz * width] = TFBiomeBase.snow.N;
                }
                else {
                    output[dx + dz * width] = center;
                }
            }
        }
        return output;
    }
    
    boolean onBorder(final int biome, final int center, final int right, final int left, final int up, final int down) {
        return center == biome && ((right != biome && !TFBiomeBase.isFeature(right)) || (left != biome && !TFBiomeBase.isFeature(left)) || (up != biome && !TFBiomeBase.isFeature(up)) || (down != biome && !TFBiomeBase.isFeature(down)));
    }
}
