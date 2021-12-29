// 
// Decompiled by Procyon v0.6-prerelease
// 

public class GenLayerTFBiomes extends es
{
    private km[] biomesToMake;
    
    public GenLayerTFBiomes(final long l, final es genlayer) {
        super(l);
        this.biomesToMake = new km[] { TFBiomeBase.twilightForest, TFBiomeBase.twilightForest, TFBiomeBase.highlands, TFBiomeBase.mushrooms, TFBiomeBase.swamp };
        this.a = genlayer;
    }
    
    public int[] a(final int i, final int j, final int k, final int l) {
        final int[] ai = this.a.a(i, j, k, l);
        final int[] ai2 = ah.a(k * l);
        for (int i2 = 0; i2 < l; ++i2) {
            for (int j2 = 0; j2 < k; ++j2) {
                this.a((long)(j2 + i), (long)(i2 + j));
                ai2[j2 + i2 * k] = ((ai[j2 + i2 * k] <= 0) ? 0 : this.biomesToMake[this.a(this.biomesToMake.length)].K);
            }
        }
        return ai2;
    }
}
