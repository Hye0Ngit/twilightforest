// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFAchievementPage;
import twilightforest.biomes.TFBiomeBase;

public class EntityTFMosquitoSwarm extends tl
{
    public EntityTFMosquitoSwarm(final abv par1World) {
        super(par1World);
        this.a(0.7f, 1.9f);
        this.Y = 2.1f;
        this.c.a(0, (pr)new po((of)this));
        this.c.a(3, (pr)new pz((om)this, (Class)ue.class, 1.0, false));
        this.c.a(6, (pr)new ql((om)this, 1.0));
        this.d.a(1, (pr)new qw((om)this, true));
        this.d.a(2, (pr)new qx((om)this, (Class)ue.class, 0, true));
    }
    
    protected boolean be() {
        return true;
    }
    
    protected void ay() {
        super.ay();
        this.a(to.a).a(12.0);
        this.a(to.d).a(0.23);
        this.a(to.e).a(3.0);
    }
    
    protected String r() {
        return "TwilightForest:mob.mosquito.mosquito";
    }
    
    public boolean m(final nm par1Entity) {
        if (super.m(par1Entity)) {
            if (par1Entity instanceof oe) {
                byte duration = 7;
                if (this.q.r > 1) {
                    if (this.q.r == 2) {
                        duration = 15;
                    }
                    else if (this.q.r == 3) {
                        duration = 30;
                    }
                }
                if (duration > 0) {
                    ((oe)par1Entity).c(new ni(nh.s.H, duration * 20, 0));
                }
            }
            return true;
        }
        return false;
    }
    
    public boolean bs() {
        if (this.q.a(lr.c(this.u), lr.c(this.w)) == TFBiomeBase.swamp) {
            return this.q.b(this.E) && this.q.a((nm)this, this.E).size() == 0;
        }
        return super.bs();
    }
    
    public int bv() {
        return 1;
    }
    
    public void a(final na par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof ue) {
            ((ue)par1DamageSource.h()).a((kt)TFAchievementPage.twilightHunter);
        }
    }
}
