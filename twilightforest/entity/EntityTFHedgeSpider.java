// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFAchievementPage;
import twilightforest.TFFeature;

public class EntityTFHedgeSpider extends qp
{
    public EntityTFHedgeSpider(final yc world) {
        super(world);
        this.aG = "/twilightforest/hedgespider.png";
    }
    
    public EntityTFHedgeSpider(final yc world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    protected lq j() {
        final double var2 = 16.0;
        return (lq)this.p.b((lq)this, var2);
    }
    
    public boolean bs() {
        final int chunkX = ke.c(this.t) >> 4;
        final int chunkZ = ke.c(this.v) >> 4;
        if (TFFeature.getNearestFeature(chunkX, chunkZ, this.p) == TFFeature.hedgeMaze) {
            return this.p.b(this.D) && this.p.a((lq)this, this.D).size() == 0 && !this.p.d(this.D);
        }
        return super.bs();
    }
    
    public void a(final lh par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.f() instanceof qx) {
            ((qx)par1DamageSource.f()).a((jl)TFAchievementPage.twilightHunter);
            final int chunkX = ke.c(this.t) >> 4;
            final int chunkZ = ke.c(this.v) >> 4;
            if (TFFeature.getNearestFeature(chunkX, chunkZ, this.p) == TFFeature.hedgeMaze) {
                ((qx)par1DamageSource.f()).a((jl)TFAchievementPage.twilightHedge);
            }
        }
    }
}
