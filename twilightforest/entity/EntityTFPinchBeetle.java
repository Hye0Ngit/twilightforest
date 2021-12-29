// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.TFAchievementPage;
import twilightforest.entity.ai.EntityAITFChargeAttack;
import twilightforest.entity.ai.EntityAITFKidnapRider;

public class EntityTFPinchBeetle extends rv
{
    public EntityTFPinchBeetle(final zv world) {
        super(world);
        this.aH = "/mods/twilightforest/textures/model/pinchbeetle.png";
        this.bI = 0.23f;
        this.a(1.2f, 1.1f);
        this.bo.a(0, (og)new od((ng)this));
        this.bo.a(1, (og)new EntityAITFKidnapRider((nl)this, 0.4f));
        this.bo.a(2, (og)new EntityAITFChargeAttack((ng)this, 0.4f));
        this.bo.a(4, (og)new oo((ng)this, (Class)sk.class, this.bI, false));
        this.bo.a(6, (og)new pa((nl)this, this.bI));
        this.bo.a(7, (og)new ol((ng)this, (Class)sk.class, 8.0f));
        this.bp.a(1, (og)new pk((ng)this, false));
        this.bp.a(2, (og)new pl((ng)this, (Class)sk.class, 16.0f, 0, true));
    }
    
    protected boolean bh() {
        return true;
    }
    
    public int aW() {
        return 40;
    }
    
    public int aZ() {
        int var1 = super.aZ() + 2;
        if (var1 > 20) {
            var1 = 20;
        }
        return var1;
    }
    
    protected String bb() {
        return null;
    }
    
    protected String bc() {
        return "mob.spider.say";
    }
    
    protected String bd() {
        return "mob.spider.death";
    }
    
    protected void a(final int var1, final int var2, final int var3, final int var4) {
        this.q.a((mp)this, "mob.spider.step", 0.15f, 1.0f);
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
            this.az().a(this.n, 100.0f, 100.0f);
            final aqw riderPos = this.getRiderPosition();
            this.i(riderPos.c, riderPos.d, riderPos.e);
        }
    }
    
    public void a(final mg par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof sk) {
            ((sk)par1DamageSource.h()).a((ka)TFAchievementPage.twilightHunter);
        }
    }
    
    public int c(final mp par1Entity) {
        return 8;
    }
    
    @SideOnly(Side.CLIENT)
    public float Q() {
        return 1.1f;
    }
    
    public boolean m(final mp par1Entity) {
        if (this.n == null && par1Entity.o == null) {
            par1Entity.a((mp)this);
        }
        return super.m(par1Entity);
    }
    
    public boolean a_(final sk par1EntityPlayer) {
        return super.a_(par1EntityPlayer);
    }
    
    public float e() {
        return 0.25f;
    }
    
    public ni bF() {
        return ni.c;
    }
    
    public void U() {
        if (this.n != null) {
            final aqw riderPos = this.getRiderPosition();
            this.n.b(riderPos.c, riderPos.d, riderPos.e);
        }
    }
    
    public double W() {
        return 0.75;
    }
    
    public aqw getRiderPosition() {
        if (this.n != null) {
            final float distance = 0.9f;
            final double var1 = Math.cos((this.A + 90.0f) * 3.141592653589793 / 180.0) * distance;
            final double var2 = Math.sin((this.A + 90.0f) * 3.141592653589793 / 180.0) * distance;
            return this.q.T().a(this.u + var1, this.v + this.W() + this.n.V(), this.w + var2);
        }
        return this.q.T().a(this.u, this.v, this.w);
    }
}
