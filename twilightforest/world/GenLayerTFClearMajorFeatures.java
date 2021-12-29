// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.biomes.TFBiomeBase;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraft.world.gen.layer.GenLayer;

public class GenLayerTFClearMajorFeatures extends GenLayer
{
    private static final int SCAN = 4;
    private static final int DSCAN = 9;
    
    public GenLayerTFClearMajorFeatures(final long par1, final GenLayer par3GenLayer) {
        super(par1);
        this.field_75909_a = par3GenLayer;
    }
    
    public int[] func_75904_a(final int x, final int z, final int width, final int depth) {
        final int[] in = this.field_75909_a.func_75904_a(x - 4, z - 4, width + 9, depth + 9);
        final int[] out = IntCache.func_76445_a(width * depth);
        for (int dz = 0; dz < depth; ++dz) {
            for (int dx = 0; dx < width; ++dx) {
                this.func_75903_a((long)(dx + x), (long)(dz + z));
                final int inputBiome = in[dx + 4 + (dz + 4) * (width + 9)];
                if (inputBiome > 0 && inputBiome < TFBiomeBase.majorFeature.field_76756_M) {
                    boolean valid = true;
                    for (int sz = 0; sz <= 8; ++sz) {
                        for (int sx = 0; sx <= 8; ++sx) {
                            final int scanBiome = in[dx + sx + (dz + sz) * (width + 9)];
                            if (scanBiome == TFBiomeBase.majorFeature.field_76756_M) {
                                valid = false;
                            }
                        }
                    }
                    out[dx + dz * width] = (valid ? inputBiome : 0);
                }
                else {
                    out[dx + dz * width] = inputBiome;
                }
            }
        }
        return out;
    }
}
