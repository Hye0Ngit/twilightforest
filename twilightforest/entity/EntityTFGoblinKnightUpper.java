// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.item.TFItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import java.util.List;
import twilightforest.entity.ai.EntityAITFHeavySpearAttack;

public class EntityTFGoblinKnightUpper extends tl
{
    private static final int SHIELD_DAMAGE_THRESHOLD = 10;
    private static final int DATA_EQUIP = 17;
    public int shieldHits;
    public int heavySpearTimer;
    
    public EntityTFGoblinKnightUpper(final abv par1World) {
        super(par1World);
        this.a(1.1f, 1.3f);
        this.c.a(0, (pr)new EntityAITFHeavySpearAttack(this));
        this.c.a(1, (pr)new po((of)this));
        this.c.a(3, (pr)new pz((om)this, (Class)ue.class, 1.0, false));
        this.c.a(6, (pr)new ql((om)this, 1.0));
        this.c.a(7, (pr)new pw((of)this, (Class)ue.class, 8.0f));
        this.c.a(7, (pr)new qk((of)this));
        this.d.a(1, (pr)new qw((om)this, false));
        this.d.a(2, (pr)new qx((om)this, (Class)ue.class, 0, false));
        this.setHasArmor(true);
        this.setHasShield(true);
        this.shieldHits = 0;
    }
    
    protected boolean be() {
        return true;
    }
    
    protected void ay() {
        super.ay();
        this.a(to.a).a(30.0);
        this.a(to.d).a(0.28);
        this.a(to.e).a(4.0);
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
    
    public boolean hasShield() {
        return (this.ah.a(17) & 0x2) > 0;
    }
    
    public void setHasShield(final boolean flag) {
        byte otherFlags = this.ah.a(17);
        otherFlags &= 0x7D;
        if (flag) {
            this.ah.b(17, (Object)(byte)(otherFlags | 0x2));
        }
        else {
            this.ah.b(17, (Object)otherFlags);
        }
    }
    
    public void b(final bx par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        par1NBTTagCompound.a("hasArmor", this.hasArmor());
        par1NBTTagCompound.a("hasShield", this.hasShield());
    }
    
    public void a(final bx par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        this.setHasArmor(par1NBTTagCompound.n("hasArmor"));
        this.setHasShield(par1NBTTagCompound.n("hasShield"));
    }
    
    public void l_() {
        if (this.S()) {
            if (this.o != null && this.o instanceof of && this.m() == null) {
                this.d(((of)this.o).m());
            }
            if (this.heavySpearTimer > 0) {
                --this.heavySpearTimer;
                if (this.heavySpearTimer == 25) {
                    this.landHeavySpearAttack();
                }
            }
            if (this.o == null && this.hasShield()) {
                this.breakShield();
            }
        }
        super.l_();
    }
    
    private void landHeavySpearAttack() {
        final asz vector = this.Z();
        final double dist = 1.25;
        final double px = this.u + vector.c * dist;
        final double py = this.E.b - 0.75;
        final double pz = this.w + vector.e * dist;
        for (int i = 0; i < 50; ++i) {
            this.q.a("largesmoke", px, py, pz, (double)((this.ab.nextFloat() - this.ab.nextFloat()) * 0.25f), 0.0, (double)((this.ab.nextFloat() - this.ab.nextFloat()) * 0.25f));
        }
        final double radius = 1.5;
        final asu spearBB = asu.a().a(px - radius, py - radius, pz - radius, px + radius, py + radius, pz + radius);
        final List<nm> inBox = this.q.a((Class)nm.class, spearBB);
        for (final nm entity : inBox) {
            if (this.o != null && entity != this.o && entity != this) {
                super.m(entity);
            }
        }
    }
    
    public int getAttackStrength(final nm par1Entity) {
        if (this.heavySpearTimer > 0) {
            return 20;
        }
        return 8;
    }
    
    public void U() {
        super.U();
        if (this.o != null) {
            this.aN = ((of)this.o).aN;
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final byte par1) {
        if (par1 == 4) {
            this.heavySpearTimer = 60;
        }
        else {
            super.a(par1);
        }
    }
    
    public boolean m(final nm par1Entity) {
        if (this.heavySpearTimer > 0) {
            return false;
        }
        if (this.ab.nextInt(2) == 0) {
            this.startHeavySpearAttack();
            return false;
        }
        this.aU();
        return super.m(par1Entity);
    }
    
    private void startHeavySpearAttack() {
        this.heavySpearTimer = 60;
        this.q.a((nm)this, (byte)4);
    }
    
    public boolean a(final na par1DamageSource, final float damageAmount) {
        if (par1DamageSource == na.d && this.o != null) {
            return false;
        }
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
            if (this.hasShield() && difference > 150.0f && difference < 230.0f) {
                if (this.takeHitOnShield(par1DamageSource, damageAmount)) {
                    return false;
                }
            }
            else if (this.hasShield() && this.ab.nextBoolean()) {
                this.damageShield();
            }
            if (this.hasArmor() && (difference > 300.0f || difference < 60.0f)) {
                this.breakArmor();
            }
        }
        final boolean attackSuccess = super.a(par1DamageSource, damageAmount);
        if (attackSuccess && this.o != null && this.o instanceof of && attacker != null) {
            ((of)this.o).a(attacker, damageAmount, 0.1, 0.1);
        }
        return attackSuccess;
    }
    
    public void breakArmor() {
        this.a(new yd((yb)yb.ag));
        this.a(new yd((yb)yb.ag));
        this.a(new yd((yb)yb.ag));
        this.setHasArmor(false);
    }
    
    public void breakShield() {
        this.a(new yd((yb)yb.ag));
        this.a(new yd((yb)yb.ag));
        this.a(new yd((yb)yb.ag));
        this.setHasShield(false);
    }
    
    public boolean takeHitOnShield(final na par1DamageSource, final float damageAmount) {
        if (damageAmount > 10.0f && !this.q.I) {
            this.damageShield();
        }
        else {
            this.q.a((nm)this, "random.break", 1.0f, ((this.ab.nextFloat() - this.ab.nextFloat()) * 0.7f + 1.0f) * 2.0f);
        }
        final of toKnockback = (of)((this.o != null && this.o instanceof of) ? ((of)this.o) : this);
        if (par1DamageSource.i() != null) {
            double d0;
            double d2;
            for (d0 = par1DamageSource.i().u - this.u, d2 = par1DamageSource.i().w - this.w; d0 * d0 + d2 * d2 < 1.0E-4; d0 = (Math.random() - Math.random()) * 0.01, d2 = (Math.random() - Math.random()) * 0.01) {}
            toKnockback.a(par1DamageSource.i(), 0.0f, d0 / 4.0, d2 / 4.0);
            if (par1DamageSource.i() instanceof of) {
                this.b((oe)par1DamageSource.i());
            }
        }
        return true;
    }
    
    private void damageShield() {
        this.q.a((nm)this, "mob.zombie.metal", 0.25f, 0.25f);
        ++this.shieldHits;
        if (!this.q.I && this.shieldHits >= 3) {
            this.breakShield();
        }
    }
    
    public int aP() {
        int armor = super.aP();
        if (this.hasArmor()) {
            armor += 20;
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
