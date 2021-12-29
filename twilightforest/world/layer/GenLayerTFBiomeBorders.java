// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.layer;

import net.minecraft.world.biome.Biome;
import twilightforest.biomes.TFBiomes;
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
        final int lake = Biome.func_185362_a(TFBiomes.tfLake);
        final int fireflyForest = Biome.func_185362_a(TFBiomes.fireflyForest);
        final int clearing = Biome.func_185362_a(TFBiomes.clearing);
        final int oakSavanna = Biome.func_185362_a(TFBiomes.oakSavanna);
        final int deepMushrooms = Biome.func_185362_a(TFBiomes.deepMushrooms);
        final int mushrooms = Biome.func_185362_a(TFBiomes.mushrooms);
        final int glacier = Biome.func_185362_a(TFBiomes.glacier);
        final int snowyForest = Biome.func_185362_a(TFBiomes.snowy_forest);
        for (int dz = 0; dz < depth; ++dz) {
            for (int dx = 0; dx < width; ++dx) {
                final int right = input[dx + 0 + (dz + 1) * nwidth];
                final int left = input[dx + 2 + (dz + 1) * nwidth];
                final int up = input[dx + 1 + (dz + 0) * nwidth];
                final int down = input[dx + 1 + (dz + 2) * nwidth];
                final int center = input[dx + 1 + (dz + 1) * nwidth];
                if (this.onBorder(lake, center, right, left, up, down)) {
                    output[dx + dz * width] = fireflyForest;
                }
                else if (this.onBorder(clearing, center, right, left, up, down)) {
                    output[dx + dz * width] = oakSavanna;
                }
                else if (this.onBorder(deepMushrooms, center, right, left, up, down)) {
                    output[dx + dz * width] = mushrooms;
                }
                else if (this.onBorder(glacier, center, right, left, up, down)) {
                    output[dx + dz * width] = snowyForest;
                }
                else {
                    output[dx + dz * width] = center;
                }
            }
        }
        return output;
    }
    
    private boolean onBorder(final int biome, final int center, final int right, final int left, final int up, final int down) {
        return center == biome && (right != biome || left != biome || up != biome || down != biome);
    }
}
