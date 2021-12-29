// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.layer;

import net.minecraft.world.biome.Biome;
import twilightforest.biomes.TFBiomes;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraft.world.gen.layer.GenLayer;

public class GenLayerTFStream extends GenLayer
{
    public GenLayerTFStream(final long l, final GenLayer genlayer) {
        super(l);
        super.field_75909_a = genlayer;
    }
    
    public int[] func_75904_a(final int x, final int z, final int width, final int depth) {
        final int nx = x - 1;
        final int nz = z - 1;
        final int nwidth = width + 2;
        final int ndepth = depth + 2;
        final int[] input = this.field_75909_a.func_75904_a(nx, nz, nwidth, ndepth);
        final int[] output = IntCache.func_76445_a(width * depth);
        final int stream = Biome.func_185362_a(TFBiomes.stream);
        for (int dz = 0; dz < depth; ++dz) {
            for (int dx = 0; dx < width; ++dx) {
                final int left = input[dx + 0 + (dz + 1) * nwidth];
                final int right = input[dx + 2 + (dz + 1) * nwidth];
                final int down = input[dx + 1 + (dz + 0) * nwidth];
                final int up = input[dx + 1 + (dz + 2) * nwidth];
                final int mid = input[dx + 1 + (dz + 1) * nwidth];
                if (this.shouldStream(mid, left, down, right, up)) {
                    output[dx + dz * width] = stream;
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
    
    boolean shouldStream(final int id1, final int id2) {
        if (id1 == id2) {
            return false;
        }
        if (id1 == -id2) {
            return false;
        }
        final Biome biome1 = Biome.func_185357_a(id1);
        final Biome biome2 = Biome.func_185357_a(id2);
        return (biome1 != TFBiomes.glacier || biome2 != TFBiomes.snowy_forest) && (biome1 != TFBiomes.snowy_forest || biome2 != TFBiomes.glacier) && (biome1 != TFBiomes.deepMushrooms || biome2 != TFBiomes.mushrooms) && (biome1 != TFBiomes.mushrooms || biome2 != TFBiomes.deepMushrooms) && (biome1 != TFBiomes.tfSwamp || biome2 != TFBiomes.fireSwamp) && (biome1 != TFBiomes.fireSwamp || biome2 != TFBiomes.tfSwamp) && (biome1 != TFBiomes.highlands || biome2 != TFBiomes.highlandsCenter) && (biome1 != TFBiomes.highlandsCenter || biome2 != TFBiomes.highlands) && (biome1 != TFBiomes.darkForest || biome2 != TFBiomes.darkForestCenter) && (biome1 != TFBiomes.darkForestCenter || biome2 != TFBiomes.darkForest) && biome1 != TFBiomes.tfLake && biome2 != TFBiomes.tfLake && biome1 != TFBiomes.clearing && biome2 != TFBiomes.oakSavanna && biome1 != TFBiomes.oakSavanna && biome2 != TFBiomes.clearing && biome1 != TFBiomes.thornlands && biome2 != TFBiomes.thornlands;
    }
}
