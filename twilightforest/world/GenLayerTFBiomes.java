// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.biomes.TFBiomeBase;

public class GenLayerTFBiomes extends agp
{
    protected yr[] commonBiomes;
    protected yr[] rareBiomes;
    
    public GenLayerTFBiomes(final long l, final agp genlayer) {
        super(l);
        this.commonBiomes = new yr[] { TFBiomeBase.twilightForest, TFBiomeBase.twilightForest2, TFBiomeBase.highlands, TFBiomeBase.mushrooms, TFBiomeBase.swamp, TFBiomeBase.clearing, TFBiomeBase.darkForest };
        this.rareBiomes = new yr[] { TFBiomeBase.tfLake, TFBiomeBase.glacier, TFBiomeBase.deepMushrooms, TFBiomeBase.enchantedForest, TFBiomeBase.fireSwamp };
        this.a = genlayer;
    }
    
    public GenLayerTFBiomes(final long l) {
        super(l);
        this.commonBiomes = new yr[] { TFBiomeBase.twilightForest, TFBiomeBase.twilightForest2, TFBiomeBase.highlands, TFBiomeBase.mushrooms, TFBiomeBase.swamp, TFBiomeBase.clearing, TFBiomeBase.darkForest };
        this.rareBiomes = new yr[] { TFBiomeBase.tfLake, TFBiomeBase.glacier, TFBiomeBase.deepMushrooms, TFBiomeBase.enchantedForest, TFBiomeBase.fireSwamp };
    }
    
    public int[] a(final int x, final int z, final int width, final int depth) {
        final int[] dest = agn.a(width * depth);
        for (int dz = 0; dz < depth; ++dz) {
            for (int dx = 0; dx < width; ++dx) {
                this.a((long)(dx + x), (long)(dz + z));
                if (this.a(15) == 0) {
                    dest[dx + dz * width] = this.rareBiomes[this.a(this.rareBiomes.length)].N;
                }
                else {
                    dest[dx + dz * width] = this.commonBiomes[this.a(this.commonBiomes.length)].N;
                }
            }
        }
        return dest;
    }
}
