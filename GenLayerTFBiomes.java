// 
// Decompiled by Procyon v0.6-prerelease
// 

public class GenLayerTFBiomes extends fh
{
    protected lt[] commonBiomes;
    protected lt[] rareBiomes;
    
    public GenLayerTFBiomes(final long l, final fh genlayer) {
        super(l);
        this.commonBiomes = new lt[] { TFBiomeBase.twilightForest, TFBiomeBase.twilightForest2, TFBiomeBase.highlands, TFBiomeBase.deepMushrooms, TFBiomeBase.swamp, TFBiomeBase.clearing };
        this.rareBiomes = new lt[] { TFBiomeBase.tfLake, TFBiomeBase.glacier };
        this.a = genlayer;
    }
    
    public GenLayerTFBiomes(final long l) {
        super(l);
        this.commonBiomes = new lt[] { TFBiomeBase.twilightForest, TFBiomeBase.twilightForest2, TFBiomeBase.highlands, TFBiomeBase.deepMushrooms, TFBiomeBase.swamp, TFBiomeBase.clearing };
        this.rareBiomes = new lt[] { TFBiomeBase.tfLake, TFBiomeBase.glacier };
    }
    
    public int[] a(final int x, final int z, final int width, final int depth) {
        final int[] dest = ak.a(width * depth);
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
