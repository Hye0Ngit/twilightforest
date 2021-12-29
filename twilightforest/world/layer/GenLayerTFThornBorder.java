// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.layer;

import net.minecraft.world.biome.Biome;
import twilightforest.biomes.TFBiomes;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraft.world.gen.layer.GenLayer;

public class GenLayerTFThornBorder extends GenLayer
{
    public GenLayerTFThornBorder(final long l, final GenLayer genlayer) {
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
        final int highlandsCenter = Biome.func_185362_a(TFBiomes.highlandsCenter);
        final int thornlands = Biome.func_185362_a(TFBiomes.thornlands);
        for (int dz = 0; dz < depth; ++dz) {
            for (int dx = 0; dx < width; ++dx) {
                final int right = input[dx + 0 + (dz + 1) * nwidth];
                final int left = input[dx + 2 + (dz + 1) * nwidth];
                final int up = input[dx + 1 + (dz + 0) * nwidth];
                final int down = input[dx + 1 + (dz + 2) * nwidth];
                final int center = input[dx + 1 + (dz + 1) * nwidth];
                final int ur = input[dx + 0 + (dz + 0) * nwidth];
                final int ul = input[dx + 2 + (dz + 0) * nwidth];
                final int dr = input[dx + 0 + (dz + 2) * nwidth];
                final int dl = input[dx + 2 + (dz + 2) * nwidth];
                if (this.onBorder(highlandsCenter, center, right, left, up, down)) {
                    output[dx + dz * width] = thornlands;
                }
                else if (this.onBorder(highlandsCenter, center, ur, ul, dr, dl)) {
                    output[dx + dz * width] = thornlands;
                }
                else {
                    output[dx + dz * width] = center;
                }
            }
        }
        return output;
    }
    
    private boolean onBorder(final int biomeID, final int biomeID2, final int center, final int right, final int left, final int up, final int down) {
        return center == biomeID && (right == biomeID2 || left == biomeID2 || up == biomeID2 || down == biomeID2);
    }
    
    private boolean onBorder(final int biomeID, final int center, final int right, final int left, final int up, final int down) {
        return center != biomeID && (right == biomeID || left == biomeID || up == biomeID || down == biomeID);
    }
}
