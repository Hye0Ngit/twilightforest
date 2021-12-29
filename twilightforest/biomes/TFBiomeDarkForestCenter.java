// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

public class TFBiomeDarkForestCenter extends TFBiomeDarkForest
{
    public TFBiomeDarkForestCenter(final int i) {
        super(i);
    }
    
    @Override
    public int func_150558_b(final int x, final int y, final int z) {
        final double d0 = TFBiomeDarkForestCenter.field_150606_ad.func_151601_a(x * 0.0225, z * 0.0225);
        return (d0 < -0.2) ? 6714688 : 5587220;
    }
    
    @Override
    public int func_150571_c(final int x, final int y, final int z) {
        final double d0 = TFBiomeDarkForestCenter.field_150606_ad.func_151601_a(x * 0.0225, z * 0.0225);
        return (d0 < -0.1) ? 16351774 : 15289876;
    }
}
