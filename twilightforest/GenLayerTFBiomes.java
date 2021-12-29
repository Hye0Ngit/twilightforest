// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class GenLayerTFBiomes extends wp
{
    protected abn[] commonBiomes;
    protected abn[] rareBiomes;
    
    public GenLayerTFBiomes(final long l, final wp genlayer) {
        super(l);
        this.commonBiomes = new abn[] { TFBiomeBase.twilightForest, TFBiomeBase.twilightForest2, TFBiomeBase.highlands, TFBiomeBase.mushrooms, TFBiomeBase.swamp, TFBiomeBase.clearing, TFBiomeBase.darkForest };
        this.rareBiomes = new abn[] { TFBiomeBase.tfLake, TFBiomeBase.glacier, TFBiomeBase.deepMushrooms, TFBiomeBase.enchantedForest };
        this.a = genlayer;
    }
    
    public GenLayerTFBiomes(final long l) {
        super(l);
        this.commonBiomes = new abn[] { TFBiomeBase.twilightForest, TFBiomeBase.twilightForest2, TFBiomeBase.highlands, TFBiomeBase.mushrooms, TFBiomeBase.swamp, TFBiomeBase.clearing, TFBiomeBase.darkForest };
        this.rareBiomes = new abn[] { TFBiomeBase.tfLake, TFBiomeBase.glacier, TFBiomeBase.deepMushrooms, TFBiomeBase.enchantedForest };
    }
    
    public int[] a(final int x, final int z, final int width, final int depth) {
        final int[] dest = ad.a(width * depth);
        for (int dz = 0; dz < depth; ++dz) {
            for (int dx = 0; dx < width; ++dx) {
                this.a((long)(dx + x), (long)(dz + z));
                if (this.a(15) == 0) {
                    dest[dx + dz * width] = this.rareBiomes[this.a(this.rareBiomes.length)].M;
                }
                else {
                    dest[dx + dz * width] = this.commonBiomes[this.a(this.commonBiomes.length)].M;
                }
            }
        }
        return dest;
    }
}
