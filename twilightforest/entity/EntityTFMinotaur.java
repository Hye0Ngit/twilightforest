// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFAchievementPage;
import twilightforest.item.TFItems;
import twilightforest.entity.ai.EntityAITFChargeAttack;

public class EntityTFMinotaur extends qj
{
    public EntityTFMinotaur(final yc par1World) {
        super(par1World);
        this.aG = "/twilightforest/minotaur.png";
        this.bH = 0.25f;
        this.bn.a(0, (nc)new mz((md)this));
        this.bn.a(2, (nc)new EntityAITFChargeAttack((md)this, 0.55f));
        this.bn.a(3, (nc)new nk((md)this, (Class)qx.class, this.bH, false));
        this.bn.a(6, (nc)new nw((mi)this, this.bH));
        this.bn.a(7, (nc)new nh((md)this, (Class)qx.class, 8.0f));
        this.bn.a(7, (nc)new nv((md)this));
        this.bo.a(1, (nc)new og((md)this, false));
        this.bo.a(2, (nc)new oh((md)this, (Class)qx.class, 16.0f, 0, false));
        this.b(0, new ur(up.J));
    }
    
    public int aT() {
        return 30;
    }
    
    protected void a() {
        super.a();
        this.ag.a(17, (Object)0);
    }
    
    protected boolean be() {
        return true;
    }
    
    public boolean isCharging() {
        return this.ag.a(17) != 0;
    }
    
    public void setCharging(final boolean flag) {
        if (flag) {
            this.ag.b(17, (Object)127);
        }
        else {
            this.ag.b(17, (Object)0);
        }
    }
    
    public boolean m(final lq par1Entity) {
        final boolean success = super.m(par1Entity);
        if (success && this.isCharging()) {
            par1Entity.x += 0.4000000059604645;
            this.p.a((lq)this, "mob.irongolem.throw", 1.0f, 1.0f);
        }
        return success;
    }
    
    public void c() {
        super.c();
        if (this.isCharging()) {
            this.bh += (float)0.6;
        }
    }
    
    protected String aY() {
        return "mob.cow.say";
    }
    
    protected String aZ() {
        return "mob.cow.hurt";
    }
    
    protected String ba() {
        return "mob.cow.hurt";
    }
    
    protected void a(final int par1, final int par2, final int par3, final int par4) {
        this.p.a((lq)this, "mob.cow.step", 0.15f, 1.0f);
    }
    
    protected int bb() {
        return TFItems.meefRaw.cj;
    }
    
    protected void a(final boolean par1, final int par2) {
        for (int numDrops = this.aa.nextInt(2) + this.aa.nextInt(1 + par2), i = 0; i < numDrops; ++i) {
            if (this.af()) {
                this.b(TFItems.meefSteak.cj, 1);
            }
            else {
                this.b(TFItems.meefRaw.cj, 1);
            }
        }
    }
    
    protected void l(final int par1) {
        this.b(TFItems.mazeMapFocus.cj, 1);
    }
    
    public void bG() {
        this.bF();
    }
    
    public void a(final lh par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.f() instanceof qx) {
            ((qx)par1DamageSource.f()).a((jl)TFAchievementPage.twilightHunter);
        }
    }
    
    public int c(final lq par1Entity) {
        return 7;
    }
}
