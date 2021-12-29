// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.layer;

import twilightforest.biomes.TFBiomeBase;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraft.world.gen.layer.GenLayer;

public class GenLayerTFBiomeBorders extends GenLayer
{
    public GenLayerTFBiomeBorders(final long l, final GenLayer genlayer) {
        super(l);
        this.field_75909_a = genlayer;
    }
    
    public int[] func_75904_a(final int x, final int z, final int width, final int depth) {
        final int nx = x - 1;
        final int nz = z - 1;
        final int nwidth = width + 2;
        final int ndepth = depth + 2;
        final int[] input = this.field_75909_a.func_75904_a(nx, nz, nwidth, ndepth);
        final int[] output = IntCache.func_76445_a(width * depth);
        for (int dz = 0; dz < depth; ++dz) {
            for (int dx = 0; dx < width; ++dx) {
                final int right = input[dx + 0 + (dz + 1) * nwidth];
                final int left = input[dx + 2 + (dz + 1) * nwidth];
                final int up = input[dx + 1 + (dz + 0) * nwidth];
                final int down = input[dx + 1 + (dz + 2) * nwidth];
                final int center = input[dx + 1 + (dz + 1) * nwidth];
                if (this.onBorder(TFBiomeBase.tfLake.field_76756_M, center, right, left, up, down)) {
                    output[dx + dz * width] = TFBiomeBase.fireflyForest.field_76756_M;
                }
                else if (this.onBorder(TFBiomeBase.clearing.field_76756_M, center, right, left, up, down)) {
                    output[dx + dz * width] = TFBiomeBase.oakSavanna.field_76756_M;
                }
                else if (this.onBorder(TFBiomeBase.deepMushrooms.field_76756_M, center, right, left, up, down)) {
                    output[dx + dz * width] = TFBiomeBase.mushrooms.field_76756_M;
                }
                else if (this.onBorder(TFBiomeBase.glacier.field_76756_M, center, right, left, up, down)) {
                    output[dx + dz * width] = TFBiomeBase.tfSnow.field_76756_M;
                }
                else {
                    output[dx + dz * width] = center;
                }
            }
        }
        return output;
    }
    
    boolean onBorder(final int biome, final int center, final int right, final int left, final int up, final int down) {
        return center == biome && (right != biome || left != biome || up != biome || down != biome);
    }
}
