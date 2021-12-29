// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFAchievementPage;
import twilightforest.biomes.TFBiomeBase;

public class EntityTFMosquitoSwarm extends qj
{
    public EntityTFMosquitoSwarm(final yc par1World) {
        super(par1World);
        this.aG = "/twilightforest/mosquitoswarm.png";
        this.a(0.7f, 1.9f);
        this.bH = 0.23f;
        this.X = 2.1f;
        this.bn.a(0, (nc)new mz((md)this));
        this.bn.a(3, (nc)new nk((md)this, (Class)qx.class, this.bH, false));
        this.bn.a(6, (nc)new nw((mi)this, this.bH));
        this.bo.a(1, (nc)new og((md)this, true));
        this.bo.a(2, (nc)new oh((md)this, (Class)qx.class, 16.0f, 0, true));
    }
    
    protected boolean be() {
        return true;
    }
    
    public int aT() {
        return 12;
    }
    
    protected String aY() {
        return "mob.tf.mosquito.mosquito";
    }
    
    public boolean m(final lq par1Entity) {
        if (super.m(par1Entity)) {
            if (par1Entity instanceof md) {
                byte duration = 7;
                if (this.p.s > 1) {
                    if (this.p.s == 2) {
                        duration = 15;
                    }
                    else if (this.p.s == 3) {
                        duration = 30;
                    }
                }
                if (duration > 0) {
                    ((md)par1Entity).d(new lm(ll.s.H, duration * 20, 0));
                }
            }
            return true;
        }
        return false;
    }
    
    public boolean bs() {
        if (this.p.a(ke.c(this.t), ke.c(this.v)) == TFBiomeBase.swamp) {
            return this.p.b(this.D) && this.p.a((lq)this, this.D).size() == 0;
        }
        return super.bs();
    }
    
    public int bv() {
        return 1;
    }
    
    public void a(final lh par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.f() instanceof qx) {
            ((qx)par1DamageSource.f()).a((jl)TFAchievementPage.twilightHunter);
        }
    }
    
    public int c(final lq par1Entity) {
        return 3;
    }
}
