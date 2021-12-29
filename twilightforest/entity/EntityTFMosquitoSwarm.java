// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFAchievementPage;
import twilightforest.biomes.TFBiomeBase;

public class EntityTFMosquitoSwarm extends rv
{
    public EntityTFMosquitoSwarm(final zv par1World) {
        super(par1World);
        this.aH = "/mods/twilightforest/textures/model/mosquitoswarm.png";
        this.a(0.7f, 1.9f);
        this.bI = 0.23f;
        this.Y = 2.1f;
        this.bo.a(0, (og)new od((ng)this));
        this.bo.a(3, (og)new oo((ng)this, (Class)sk.class, this.bI, false));
        this.bo.a(6, (og)new pa((nl)this, this.bI));
        this.bp.a(1, (og)new pk((ng)this, true));
        this.bp.a(2, (og)new pl((ng)this, (Class)sk.class, 16.0f, 0, true));
    }
    
    protected boolean bh() {
        return true;
    }
    
    public int aW() {
        return 12;
    }
    
    protected String bb() {
        return "mob.tf.mosquito.mosquito";
    }
    
    public boolean m(final mp par1Entity) {
        if (super.m(par1Entity)) {
            if (par1Entity instanceof ng) {
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
                    ((ng)par1Entity).d(new ml(mk.s.H, duration * 20, 0));
                }
            }
            return true;
        }
        return false;
    }
    
    public boolean bv() {
        if (this.q.a(kx.c(this.u), kx.c(this.w)) == TFBiomeBase.swamp) {
            return this.q.b(this.E) && this.q.a((mp)this, this.E).size() == 0;
        }
        return super.bv();
    }
    
    public int by() {
        return 1;
    }
    
    public void a(final mg par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof sk) {
            ((sk)par1DamageSource.h()).a((ka)TFAchievementPage.twilightHunter);
        }
    }
    
    public int c(final mp par1Entity) {
        return 3;
    }
}
