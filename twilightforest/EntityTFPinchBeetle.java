// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

public class EntityTFPinchBeetle extends qj
{
    public EntityTFPinchBeetle(final xv world) {
        super(world);
        this.aF = "/twilightforest/pinchbeetle.png";
        this.bG = 0.23f;
        this.a(1.2f, 1.1f);
        this.bm.a(0, (nc)new mz((md)this));
        this.bm.a(1, (nc)new EntityAITFKidnapRider((mi)this, 0.4f));
        this.bm.a(2, (nc)new EntityAITFChargeAttack((md)this, 0.4f));
        this.bm.a(4, (nc)new nk((md)this, (Class)qx.class, this.bG, false));
        this.bm.a(6, (nc)new nw((mi)this, this.bG));
        this.bm.a(7, (nc)new nh((md)this, (Class)qx.class, 8.0f));
        this.bn.a(1, (nc)new og((md)this, false));
        this.bn.a(2, (nc)new oh((md)this, (Class)qx.class, 16.0f, 0, true));
    }
    
    protected boolean be() {
        return true;
    }
    
    public int aT() {
        return 40;
    }
    
    public int aW() {
        int var1 = super.aW() + 2;
        if (var1 > 20) {
            var1 = 20;
        }
        return var1;
    }
    
    protected String aY() {
        return null;
    }
    
    protected String aZ() {
        return "mob.spider.say";
    }
    
    protected String ba() {
        return "mob.spider.death";
    }
    
    protected void a(final int var1, final int var2, final int var3, final int var4) {
        this.p.a((lq)this, "mob.spider.step", 0.15f, 1.0f);
    }
    
    public void c() {
        if (this.n != null) {
            this.a(1.9f, 2.0f);
        }
        else {
            this.a(1.2f, 1.1f);
        }
        super.c();
        if (this.n != null) {
            this.aw().a(this.n, 100.0f, 100.0f);
            final aob riderPos = this.getRiderPosition();
            this.i(riderPos.c, riderPos.d, riderPos.e);
        }
    }
    
    public void a(final lh par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.f() instanceof qx) {
            ((qx)par1DamageSource.f()).a((jl)TFAchievementPage.twilightHunter);
        }
    }
    
    public int c(final lq par1Entity) {
        return 8;
    }
    
    @SideOnly(Side.CLIENT)
    public float R() {
        return 1.1f;
    }
    
    public boolean m(final lq par1Entity) {
        if (this.n == null && par1Entity.o == null) {
            par1Entity.a((lq)this);
        }
        return super.m(par1Entity);
    }
    
    public boolean a(final qx par1EntityPlayer) {
        return super.a(par1EntityPlayer);
    }
    
    public float e() {
        return 0.25f;
    }
    
    public mf bC() {
        return mf.c;
    }
    
    public void V() {
        if (this.n != null) {
            final aob riderPos = this.getRiderPosition();
            this.n.b(riderPos.c, riderPos.d, riderPos.e);
        }
    }
    
    public double X() {
        return 0.75;
    }
    
    public aob getRiderPosition() {
        if (this.n != null) {
            final float distance = 0.9f;
            final double var1 = Math.cos((this.z + 90.0f) * 3.141592653589793 / 180.0) * distance;
            final double var2 = Math.sin((this.z + 90.0f) * 3.141592653589793 / 180.0) * distance;
            return this.p.S().a(this.t + var1, this.u + this.X() + this.n.W(), this.v + var2);
        }
        return this.p.S().a(this.t, this.u, this.v);
    }
}
