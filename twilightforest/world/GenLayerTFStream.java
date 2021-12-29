// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.biomes.TFBiomeBase;
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
        for (int dz = 0; dz < depth; ++dz) {
            for (int dx = 0; dx < width; ++dx) {
                final int left = input[dx + 0 + (dz + 1) * nwidth];
                final int right = input[dx + 2 + (dz + 1) * nwidth];
                final int down = input[dx + 1 + (dz + 0) * nwidth];
                final int up = input[dx + 1 + (dz + 2) * nwidth];
                final int mid = input[dx + 1 + (dz + 1) * nwidth];
                if (this.shouldStream(mid, left, down, right, up)) {
                    output[dx + dz * width] = TFBiomeBase.stream.field_76756_M;
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
        return biome1 != biome2 && biome1 != -biome2 && (biome1 != TFBiomeBase.glacier.field_76756_M || biome2 != TFBiomeBase.snow.field_76756_M) && (biome1 != TFBiomeBase.snow.field_76756_M || biome2 != TFBiomeBase.glacier.field_76756_M) && (biome1 != TFBiomeBase.deepMushrooms.field_76756_M || biome2 != TFBiomeBase.mushrooms.field_76756_M) && (biome1 != TFBiomeBase.mushrooms.field_76756_M || biome2 != TFBiomeBase.deepMushrooms.field_76756_M) && (biome1 != TFBiomeBase.swamp.field_76756_M || biome2 != TFBiomeBase.fireSwamp.field_76756_M) && (biome1 != TFBiomeBase.fireSwamp.field_76756_M || biome2 != TFBiomeBase.swamp.field_76756_M) && biome1 != TFBiomeBase.tfLake.field_76756_M && biome2 != TFBiomeBase.tfLake.field_76756_M && biome1 != TFBiomeBase.clearing.field_76756_M && biome2 != TFBiomeBase.clearing.field_76756_M && !TFBiomeBase.isFeature(biome1) && !TFBiomeBase.isFeature(biome2);
    }
}
