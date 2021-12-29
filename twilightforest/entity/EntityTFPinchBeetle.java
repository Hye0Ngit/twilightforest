// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.TFAchievementPage;
import twilightforest.entity.ai.EntityAITFChargeAttack;
import twilightforest.entity.ai.EntityAITFKidnapRider;

public class EntityTFPinchBeetle extends tl
{
    public EntityTFPinchBeetle(final abv world) {
        super(world);
        this.a(1.2f, 1.1f);
        this.c.a(0, (pr)new po((of)this));
        this.c.a(1, (pr)new EntityAITFKidnapRider((om)this, 2.0f));
        this.c.a(2, (pr)new EntityAITFChargeAttack((om)this, 2.0f));
        this.c.a(4, (pr)new pz((om)this, (Class)ue.class, 1.0, false));
        this.c.a(6, (pr)new ql((om)this, 1.0));
        this.c.a(7, (pr)new pw((of)this, (Class)ue.class, 8.0f));
        this.d.a(1, (pr)new qw((om)this, false));
        this.d.a(2, (pr)new qx((om)this, (Class)ue.class, 0, true));
    }
    
    protected boolean be() {
        return true;
    }
    
    protected void ay() {
        super.ay();
        this.a(to.a).a(40.0);
        this.a(to.d).a(0.23);
        this.a(to.e).a(4.0);
    }
    
    public int aP() {
        int var1 = super.aP() + 2;
        if (var1 > 20) {
            var1 = 20;
        }
        return var1;
    }
    
    protected String r() {
        return null;
    }
    
    protected String aN() {
        return "mob.spider.say";
    }
    
    protected String aO() {
        return "mob.spider.death";
    }
    
    protected void a(final int var1, final int var2, final int var3, final int var4) {
        this.q.a((nm)this, "mob.spider.step", 0.15f, 1.0f);
    }
    
    public void c() {
        if (this.n != null) {
            this.a(1.9f, 2.0f);
            if (this.n.ag()) {
                this.n.b(false);
            }
        }
        else {
            this.a(1.2f, 1.1f);
        }
        super.c();
        if (this.n != null) {
            this.h().a(this.n, 100.0f, 100.0f);
            final asz riderPos = this.getRiderPosition();
            this.i(riderPos.c, riderPos.d, riderPos.e);
        }
    }
    
    public void a(final na par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof ue) {
            ((ue)par1DamageSource.h()).a((kt)TFAchievementPage.twilightHunter);
        }
    }
    
    public int getAttackStrength(final nm par1Entity) {
        return 8;
    }
    
    @SideOnly(Side.CLIENT)
    public float R() {
        return 1.1f;
    }
    
    public boolean m(final nm par1Entity) {
        if (this.n == null && par1Entity.o == null) {
            par1Entity.a((nm)this);
        }
        return super.m(par1Entity);
    }
    
    public boolean a(final ue par1EntityPlayer) {
        return super.a(par1EntityPlayer);
    }
    
    public float f() {
        return 0.25f;
    }
    
    public oi aX() {
        return oi.c;
    }
    
    public void V() {
        if (this.n != null) {
            final asz riderPos = this.getRiderPosition();
            this.n.b(riderPos.c, riderPos.d, riderPos.e);
        }
    }
    
    public double X() {
        return 0.75;
    }
    
    public asz getRiderPosition() {
        if (this.n != null) {
            final float distance = 0.9f;
            final double var1 = Math.cos((this.A + 90.0f) * 3.141592653589793 / 180.0) * distance;
            final double var2 = Math.sin((this.A + 90.0f) * 3.141592653589793 / 180.0) * distance;
            return this.q.V().a(this.u + var1, this.v + this.X() + this.n.W(), this.w + var2);
        }
        return this.q.V().a(this.u, this.v, this.w);
    }
}
