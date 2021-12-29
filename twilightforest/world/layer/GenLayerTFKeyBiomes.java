// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.layer;

import twilightforest.biomes.TFBiomeBase;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraft.world.gen.layer.GenLayer;

public class GenLayerTFKeyBiomes extends GenLayer
{
    public GenLayerTFKeyBiomes(final long l, final GenLayer genlayer) {
        super(l);
        this.field_75909_a = genlayer;
    }
    
    public GenLayerTFKeyBiomes(final long l) {
        super(l);
    }
    
    public int[] func_75904_a(final int x, final int z, final int width, final int depth) {
        final int[] src = this.field_75909_a.func_75904_a(x, z, width, depth);
        final int[] dest = IntCache.func_76445_a(width * depth);
        for (int dz = 0; dz < depth; ++dz) {
            for (int dx = 0; dx < width; ++dx) {
                this.func_75903_a((long)(dx + x | 0x3), (long)(dz + z | 0x3));
                final int ox = this.func_75902_a(3) + 1;
                final int oz = this.func_75902_a(3) + 1;
                if ((dx + x & 0x3) == ox && (dz + z & 0x3) == oz) {
                    if ((dx + x & 0x4) == 0x0) {
                        if ((dz + z & 0x4) == 0x0) {
                            dest[dx + dz * width] = TFBiomeBase.glacier.field_76756_M;
                        }
                        else {
                            dest[dx + dz * width] = TFBiomeBase.fireSwamp.field_76756_M;
                        }
                    }
                    else if ((dz + z & 0x4) == 0x0) {
                        dest[dx + dz * width] = TFBiomeBase.darkForestCenter.field_76756_M;
                    }
                    else {
                        dest[dx + dz * width] = TFBiomeBase.highlandsCenter.field_76756_M;
                    }
                }
                else {
                    dest[dx + dz * width] = src[dx + dz * width];
                }
            }
        }
        return dest;
    }
}
