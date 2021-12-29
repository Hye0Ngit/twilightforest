// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.layer;

import net.minecraft.world.gen.layer.IntCache;
import net.minecraft.world.gen.layer.GenLayer;

public class GenLayerTFBiomeStabilize extends GenLayer
{
    public GenLayerTFBiomeStabilize(final long l, final GenLayer genlayer) {
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
        final int offX = x & 0x3;
        final int offZ = z & 0x3;
        for (int dz = 0; dz < depth; ++dz) {
            for (int dx = 0; dx < width; ++dx) {
                final int centerX = (dx + offX + 1 & 0xFFFFFFFC) - offX;
                final int centerZ = (dz + offZ + 1 & 0xFFFFFFFC) - offZ;
                if (dx <= centerX + 1 && dx >= centerX - 1 && dz <= centerZ + 1 && dz >= centerZ - 1) {
                    output[dx + dz * width] = input[centerX + 1 + (centerZ + 1) * nwidth];
                }
                else {
                    output[dx + dz * width] = input[dx + 1 + (dz + 1) * nwidth];
                }
            }
        }
        return output;
    }
}
