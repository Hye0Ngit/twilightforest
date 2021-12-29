// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFAchievementPage;
import twilightforest.TFFeature;

public class EntityTFHedgeSpider extends sb
{
    public EntityTFHedgeSpider(final zv world) {
        super(world);
        this.aH = "/mods/twilightforest/textures/model/hedgespider.png";
    }
    
    public EntityTFHedgeSpider(final zv world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    protected mp j() {
        final double var2 = 16.0;
        return (mp)this.q.b((mp)this, var2);
    }
    
    protected boolean i_() {
        final int chunkX = kx.c(this.u) >> 4;
        final int chunkZ = kx.c(this.w) >> 4;
        return TFFeature.getNearestFeature(chunkX, chunkZ, this.q) == TFFeature.hedgeMaze || super.i_();
    }
    
    public void a(final mg par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof sk) {
            ((sk)par1DamageSource.h()).a((ka)TFAchievementPage.twilightHunter);
            final int chunkX = kx.c(this.u) >> 4;
            final int chunkZ = kx.c(this.w) >> 4;
            if (TFFeature.getNearestFeature(chunkX, chunkZ, this.q) == TFFeature.hedgeMaze) {
                ((sk)par1DamageSource.h()).a((ka)TFAchievementPage.twilightHedge);
            }
        }
    }
}
