// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.biomes.TFBiomeBase;

public class GenLayerTFStabilizeBiomes extends ain
{
    private static final int RAD = 1;
    private static final int DIAM = 2;
    protected ain biomeLayer;
    protected ain featureLayer;
    
    public GenLayerTFStabilizeBiomes(final int par1, final ain biomes, final ain features) {
        super((long)par1);
        this.biomeLayer = biomes;
        this.featureLayer = features;
    }
    
    public void a(final long par1) {
        this.biomeLayer.a(par1);
        this.featureLayer.a(par1);
        super.a(par1);
    }
    
    public int[] a(final int x, final int z, final int width, final int depth) {
        final int nwidth = width + 2;
        final int[] biomes = this.biomeLayer.a(x - 1, z - 1, nwidth, depth + 2);
        final int[] features = this.featureLayer.a(x - 1, z - 1, nwidth, depth + 2);
        final int[] out = ail.a(width * depth);
        for (int dz = 0; dz < depth; ++dz) {
            for (int dx = 0; dx < width; ++dx) {
                this.a((long)(dx + x), (long)(dz + z));
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
