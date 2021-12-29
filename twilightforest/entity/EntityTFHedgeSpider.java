// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFAchievementPage;
import twilightforest.TFFeature;

public class EntityTFHedgeSpider extends ts
{
    public EntityTFHedgeSpider(final abv world) {
        super(world);
    }
    
    public EntityTFHedgeSpider(final abv world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    protected nm bL() {
        final double var2 = 16.0;
        return (nm)this.q.b((nm)this, var2);
    }
    
    protected boolean i_() {
        final int chunkX = lr.c(this.u) >> 4;
        final int chunkZ = lr.c(this.w) >> 4;
        return TFFeature.getNearestFeature(chunkX, chunkZ, this.q) == TFFeature.hedgeMaze || super.i_();
    }
    
    public void a(final na par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof ue) {
            ((ue)par1DamageSource.h()).a((kt)TFAchievementPage.twilightHunter);
            final int chunkX = lr.c(this.u) >> 4;
            final int chunkZ = lr.c(this.w) >> 4;
            if (TFFeature.getNearestFeature(chunkX, chunkZ, this.q) == TFFeature.hedgeMaze) {
                ((ue)par1DamageSource.h()).a((kt)TFAchievementPage.twilightHedge);
            }
        }
    }
}
