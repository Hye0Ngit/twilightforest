// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFAchievementPage;
import twilightforest.item.TFItems;
import twilightforest.entity.ai.EntityAITFMagicAttack;

public class EntityTFDeathTome extends tl
{
    public EntityTFDeathTome(final abv par1World) {
        super(par1World);
        this.c.a(0, (pr)new po((of)this));
        this.c.a(4, (pr)new EntityAITFMagicAttack((of)this, 1.0f, 2, 60));
        this.c.a(5, (pr)new ql((om)this, 1.0));
        this.c.a(6, (pr)new pw((of)this, (Class)ue.class, 8.0f));
        this.c.a(6, (pr)new qk((of)this));
        this.d.a(1, (pr)new qw((om)this, false));
        this.d.a(2, (pr)new qx((om)this, (Class)ue.class, 0, true));
    }
    
    public int getAttackStrength(final nm par1Entity) {
        return 4;
    }
    
    protected boolean be() {
        return true;
    }
    
    protected void ay() {
        super.ay();
        this.a(to.a).a(30.0);
        this.a(to.d).a(0.25);
    }
    
    public void c() {
        super.c();
        for (int i = 0; i < 1; ++i) {
            this.q.a("enchantmenttable", this.u + (this.ab.nextDouble() - 0.5) * this.O, this.v + this.ab.nextDouble() * (this.P - 0.75) + 0.5, this.w + (this.ab.nextDouble() - 0.5) * this.O, 0.0, 0.5, 0.0);
        }
    }
    
    public boolean a(final na par1DamageSource, float par2) {
        if (par1DamageSource.m()) {
            par2 *= 2.0f;
        }
        if (super.a(par1DamageSource, par2)) {
            if (this.ab.nextInt(2) == 0) {
                this.a(yb.aM.cv, 1, 1.0f);
            }
            return true;
        }
        return false;
    }
    
    protected int s() {
        return yb.aM.cv;
    }
    
    protected void b(final boolean par1, final int par2) {
        for (int var3 = this.ab.nextInt(3 + par2), var4 = 0; var4 < var3; ++var4) {
            this.b(yb.aM.cv, 1);
        }
        if (this.ab.nextInt(5) - par2 <= 0) {
            this.b(yb.bH.cv, 1);
        }
        else {
            this.b(yb.aN.cv, 1);
        }
    }
    
    protected void l(final int par1) {
        this.b(TFItems.magicMapFocus.cv, 1);
    }
    
    public void a(final na par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof ue) {
            ((ue)par1DamageSource.h()).a((kt)TFAchievementPage.twilightHunter);
        }
    }
}
