// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.biomes.TFBiomeBase;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraft.world.gen.layer.GenLayer;

public class GenLayerTFStabilizeBiomes extends GenLayer
{
    private static final int RAD = 1;
    private static final int DIAM = 2;
    protected GenLayer biomeLayer;
    protected GenLayer featureLayer;
    
    public GenLayerTFStabilizeBiomes(final int par1, final GenLayer biomes, final GenLayer features) {
        super((long)par1);
        this.biomeLayer = biomes;
        this.featureLayer = features;
    }
    
    public void func_75905_a(final long par1) {
        this.biomeLayer.func_75905_a(par1);
        this.featureLayer.func_75905_a(par1);
        super.func_75905_a(par1);
    }
    
    public int[] func_75904_a(final int x, final int z, final int width, final int depth) {
        final int nwidth = width + 2;
        final int[] biomes = this.biomeLayer.func_75904_a(x - 1, z - 1, nwidth, depth + 2);
        final int[] features = this.featureLayer.func_75904_a(x - 1, z - 1, nwidth, depth + 2);
        final int[] out = IntCache.func_76445_a(width * depth);
        for (int dz = 0; dz < depth; ++dz) {
            for (int dx = 0; dx < width; ++dx) {
                this.func_75903_a((long)(dx + x), (long)(dz + z));
                boolean nearFeature = false;
                int underFeature = 0;
                for (int sx = -1; sx <= 1; ++sx) {
                    for (int sz = -1; sz <= 1; ++sz) {
                        final int featureAt = features[dx + sx + 1 + (dz + sz + 1) * nwidth];
                        final int inputBiome = biomes[dx + sx + 1 + (dz + sz + 1) * nwidth];
                        if (TFBiomeBase.isFeature(featureAt)) {
                            nearFeature = true;
                            underFeature = inputBiome;
                            break;
                        }
                    }
                }
                if (nearFeature) {
                    out[dx + dz * width] = underFeature;
                }
                else {
                    out[dx + dz * width] = biomes[dx + 1 + (dz + 1) * nwidth];
                }
            }
        }
        return out;
    }
}
