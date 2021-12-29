// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFAchievementPage;
import twilightforest.item.TFItems;
import twilightforest.entity.ai.EntityAITFChargeAttack;

public class EntityTFMinotaur extends tl
{
    public EntityTFMinotaur(final abv par1World) {
        super(par1World);
        this.c.a(0, (pr)new po((of)this));
        this.c.a(2, (pr)new EntityAITFChargeAttack((om)this, 2.0f));
        this.c.a(3, (pr)new pz((om)this, (Class)ue.class, 1.0, false));
        this.c.a(6, (pr)new ql((om)this, 1.0));
        this.c.a(7, (pr)new pw((of)this, (Class)ue.class, 8.0f));
        this.c.a(7, (pr)new qk((of)this));
        this.d.a(1, (pr)new qw((om)this, false));
        this.d.a(2, (pr)new qx((om)this, (Class)ue.class, 0, false));
        this.c(0, new yd(yb.L));
    }
    
    protected void ay() {
        super.ay();
        this.a(to.a).a(30.0);
        this.a(to.d).a(0.25);
        this.a(to.e).a(7.0);
    }
    
    protected void a() {
        super.a();
        this.ah.a(17, (Object)0);
    }
    
    protected boolean be() {
        return true;
    }
    
    public boolean isCharging() {
        return this.ah.a(17) != 0;
    }
    
    public void setCharging(final boolean flag) {
        if (flag) {
            this.ah.b(17, (Object)127);
        }
        else {
            this.ah.b(17, (Object)0);
        }
    }
    
    public boolean m(final nm par1Entity) {
        final boolean success = super.m(par1Entity);
        if (success && this.isCharging()) {
            par1Entity.y += 0.4000000059604645;
            this.q.a((nm)this, "mob.irongolem.throw", 1.0f, 1.0f);
        }
        return success;
    }
    
    public void c() {
        super.c();
        if (this.isCharging()) {
            this.aG += (float)0.6;
        }
    }
    
    protected String r() {
        return "mob.cow.say";
    }
    
    protected String aN() {
        return "mob.cow.hurt";
    }
    
    protected String aO() {
        return "mob.cow.hurt";
    }
    
    protected void a(final int par1, final int par2, final int par3, final int par4) {
        this.q.a((nm)this, "mob.cow.step", 0.15f, 1.0f);
    }
    
    protected int s() {
        return TFItems.meefRaw.cv;
    }
    
    protected void b(final boolean par1, final int par2) {
        for (int numDrops = this.ab.nextInt(2) + this.ab.nextInt(1 + par2), i = 0; i < numDrops; ++i) {
            if (this.ae()) {
                this.b(TFItems.meefSteak.cv, 1);
            }
            else {
                this.b(TFItems.meefRaw.cv, 1);
            }
        }
    }
    
    protected void l(final int par1) {
        this.b(TFItems.mazeMapFocus.cv, 1);
    }
    
    public void a(final na par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof ue) {
            ((ue)par1DamageSource.h()).a((kt)TFAchievementPage.twilightHunter);
        }
    }
}
