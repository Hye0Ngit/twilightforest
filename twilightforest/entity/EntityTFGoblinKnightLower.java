// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.item.TFItems;
import twilightforest.entity.ai.EntityAITFRiderSpearAttack;

public class EntityTFGoblinKnightLower extends tl
{
    private static final int DATA_EQUIP = 17;
    
    public EntityTFGoblinKnightLower(final abv par1World) {
        super(par1World);
        this.a(0.7f, 1.1f);
        this.c.a(0, (pr)new EntityAITFRiderSpearAttack(this));
        this.c.a(1, (pr)new po((of)this));
        this.c.a(3, (pr)new pz((om)this, (Class)ue.class, 1.0, false));
        this.c.a(6, (pr)new ql((om)this, 1.0));
        this.c.a(7, (pr)new pw((of)this, (Class)ue.class, 8.0f));
        this.c.a(7, (pr)new qk((of)this));
        this.d.a(1, (pr)new qw((om)this, false));
        this.d.a(2, (pr)new qx((om)this, (Class)ue.class, 0, false));
        this.setHasArmor(true);
    }
    
    protected void ay() {
        super.ay();
        this.a(to.a).a(20.0);
        this.a(to.d).a(0.28);
        this.a(to.e).a(4.0);
    }
    
    protected boolean be() {
        return true;
    }
    
    protected void a() {
        super.a();
        this.ah.a(17, (Object)0);
    }
    
    public boolean hasArmor() {
        return (this.ah.a(17) & 0x1) > 0;
    }
    
    public void setHasArmor(final boolean flag) {
        byte otherFlags = this.ah.a(17);
        otherFlags &= 0x7E;
        if (flag) {
            this.ah.b(17, (Object)(byte)(otherFlags | 0x1));
        }
        else {
            this.ah.b(17, (Object)otherFlags);
        }
    }
    
    public void b(final bx par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        par1NBTTagCompound.a("hasArmor", this.hasArmor());
    }
    
    public void a(final bx par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        this.setHasArmor(par1NBTTagCompound.n("hasArmor"));
    }
    
    public void initCreature() {
        final EntityTFGoblinKnightUpper upper = new EntityTFGoblinKnightUpper(this.q);
        upper.b(this.u, this.v, this.w, this.A, 0.0f);
        upper.a((oh)null);
        this.q.d((nm)upper);
        upper.a((nm)this);
    }
    
    public oh a(final oh par1EntityLivingData) {
        final Object par1EntityLivingData2 = super.a(par1EntityLivingData);
        final EntityTFGoblinKnightUpper upper = new EntityTFGoblinKnightUpper(this.q);
        upper.b(this.u, this.v, this.w, this.A, 0.0f);
        upper.a((oh)null);
        this.q.d((nm)upper);
        upper.a((nm)this);
        return (oh)par1EntityLivingData2;
    }
    
    public double X() {
        return 1.0;
    }
    
    public void l_() {
        if (this.S() && this.n != null && this.n instanceof of && this.m() == null) {
            this.d(((of)this.n).m());
        }
        super.l_();
    }
    
    public boolean m(final nm par1Entity) {
        if (this.n != null && this.n instanceof of) {
            return ((of)this.n).m(par1Entity);
        }
        return super.m(par1Entity);
    }
    
    public boolean a(final na par1DamageSource, final float damageAmount) {
        nm attacker = null;
        if (par1DamageSource.h() != null) {
            attacker = par1DamageSource.h();
        }
        if (par1DamageSource.i() != null) {
            attacker = par1DamageSource.i();
        }
        if (attacker != null) {
            final double dx = this.u - attacker.u;
            final double dz = this.w - attacker.w;
            final float angle = (float)(Math.atan2(dz, dx) * 180.0 / 3.141592653589793) - 90.0f;
            final float difference = lr.e((this.aN - angle) % 360.0f);
            EntityTFGoblinKnightUpper upper = null;
            if (this.n != null && this.n instanceof EntityTFGoblinKnightUpper) {
                upper = (EntityTFGoblinKnightUpper)this.n;
            }
            if (upper != null && upper.hasShield() && difference > 150.0f && difference < 230.0f && upper.takeHitOnShield(par1DamageSource, damageAmount)) {
                return false;
            }
            if (this.hasArmor() && (difference > 300.0f || difference < 60.0f)) {
                this.breakArmor();
            }
        }
        final boolean attackSuccess = super.a(par1DamageSource, damageAmount);
        return attackSuccess;
    }
    
    public void breakArmor() {
        this.a(new yd((yb)yb.ag));
        this.a(new yd((yb)yb.ag));
        this.a(new yd((yb)yb.ag));
        this.setHasArmor(false);
    }
    
    public int aP() {
        int armor = super.aP();
        if (this.hasArmor()) {
            armor += 17;
        }
        if (armor > 20) {
            armor = 20;
        }
        return armor;
    }
    
    protected int s() {
        return TFItems.armorShard.cv;
    }
}
