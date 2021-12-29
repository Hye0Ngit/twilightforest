// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.biomes.TFBiomeBase;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraft.world.gen.layer.GenLayer;

public class GenLayerTFMinorFeatures extends GenLayer
{
    protected GenLayer featureLayer;
    protected GenLayer biomeLayer;
    
    public GenLayerTFMinorFeatures(final int par1, final GenLayer biomes, final GenLayer features) {
        super((long)par1);
        this.featureLayer = features;
        this.biomeLayer = biomes;
    }
    
    public void func_75905_a(final long par1) {
        this.featureLayer.func_75905_a(par1);
        this.biomeLayer.func_75905_a(par1);
        super.func_75905_a(par1);
    }
    
    public int[] func_75904_a(final int x, final int z, final int width, final int depth) {
        final int nwidth = width + 2;
        final int[] biomes = this.biomeLayer.func_75904_a(x - 1, z - 1, nwidth, depth + 2);
        final int[] features = this.featureLayer.func_75904_a(x, z, width, depth);
        final int[] out = IntCache.func_76445_a(width * depth);
        for (int dz = 0; dz < depth; ++dz) {
            for (int dx = 0; dx < width; ++dx) {
                this.func_75903_a((long)(dx + x), (long)(dz + z));
                final int featureAt = features[dx + dz * width];
                final int inputBiome = biomes[dx + 1 + (dz + 1) * nwidth];
                if (TFBiomeBase.isFeature(featureAt)) {
                    out[dx + dz * width] = featureAt;
                }
                else if (this.func_75902_a(2) == 0) {
                    final int up = biomes[dx + 1 + (dz + 0) * nwidth];
                    final int right = biomes[dx + 2 + (dz + 1) * nwidth];
                    final int left = biomes[dx + 0 + (dz + 1) * nwidth];
                    final int down = biomes[dx + 1 + (dz + 2) * nwidth];
                    final int ul = biomes[dx + 0 + (dz + 0) * nwidth];
                    final int dr = biomes[dx + 2 + (dz + 2) * nwidth];
                    final int ur = biomes[dx + 2 + (dz + 0) * nwidth];
                    final int dl = biomes[dx + 0 + (dz + 2) * nwidth];
                    if (ul == inputBiome && dr == inputBiome && ur == inputBiome && dl == inputBiome && up == inputBiome && right == inputBiome && left == inputBiome && down == inputBiome) {
                        out[dx + dz * width] = this.func_75902_a(TFBiomeBase.majorFeature.field_76756_M);
                    }
                    else {
                        out[dx + dz * width] = 0;
                    }
                }
                else {
                    out[dx + dz * width] = 0;
                }
            }
        }
        return out;
    }
}
