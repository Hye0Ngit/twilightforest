// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.biomes.TFBiomeBase;

public class GenLayerTFMinorFeatures extends ain
{
    protected ain featureLayer;
    protected ain biomeLayer;
    
    public GenLayerTFMinorFeatures(final int par1, final ain biomes, final ain features) {
        super((long)par1);
        this.featureLayer = features;
        this.biomeLayer = biomes;
    }
    
    public void a(final long par1) {
        this.featureLayer.a(par1);
        this.biomeLayer.a(par1);
        super.a(par1);
    }
    
    public int[] a(final int x, final int z, final int width, final int depth) {
        final int nwidth = width + 2;
        final int[] biomes = this.biomeLayer.a(x - 1, z - 1, nwidth, depth + 2);
        final int[] features = this.featureLayer.a(x, z, width, depth);
        final int[] out = ail.a(width * depth);
        for (int dz = 0; dz < depth; ++dz) {
            for (int dx = 0; dx < width; ++dx) {
                this.a((long)(dx + x), (long)(dz + z));
                final int featureAt = features[dx + dz * width];
                final int inputBiome = biomes[dx + 1 + (dz + 1) * nwidth];
                if (TFBiomeBase.isFeature(featureAt)) {
                    out[dx + dz * width] = featureAt;
                }
                else if (this.a(2) == 0) {
                    final int up = biomes[dx + 1 + (dz + 0) * nwidth];
                    final int right = biomes[dx + 2 + (dz + 1) * nwidth];
                    final int left = biomes[dx + 0 + (dz + 1) * nwidth];
                    final int down = biomes[dx + 1 + (dz + 2) * nwidth];
                    final int ul = biomes[dx + 0 + (dz + 0) * nwidth];
                    final int dr = biomes[dx + 2 + (dz + 2) * nwidth];
                    final int ur = biomes[dx + 2 + (dz + 0) * nwidth];
                    final int dl = biomes[dx + 0 + (dz + 2) * nwidth];
                    if (ul == inputBiome && dr == inputBiome && ur == inputBiome && dl == inputBiome && up == inputBiome && right == inputBiome && left == inputBiome && down == inputBiome) {
                        out[dx + dz * width] = this.a(TFBiomeBase.majorFeature.N);
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
