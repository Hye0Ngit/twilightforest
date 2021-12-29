// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import twilightforest.entity.EntityTFMinotaur;

public class EntityAITFChargeAttack extends pr
{
    protected static final double MIN_RANGE_SQ = 16.0;
    protected static final double MAX_RANGE_SQ = 64.0;
    protected static final int FREQ = 1;
    protected om charger;
    protected oe chargeTarget;
    protected double chargeX;
    protected double chargeY;
    protected double chargeZ;
    protected float speed;
    protected int windup;
    protected boolean hasAttacked;
    
    public EntityAITFChargeAttack(final om entityLiving, final float f) {
        this.charger = entityLiving;
        this.speed = f;
        this.windup = 0;
        this.hasAttacked = false;
        this.a(3);
    }
    
    public boolean a() {
        this.chargeTarget = this.charger.m();
        if (this.chargeTarget == null) {
            return false;
        }
        final double distance = this.charger.e((nm)this.chargeTarget);
        if (distance < 16.0 || distance > 64.0) {
            return false;
        }
        if (!this.charger.F) {
            return false;
        }
        final asz chargePos = this.findChargePoint((nm)this.charger, (nm)this.chargeTarget, 2.1);
        final boolean canSeeTargetFromDest = this.chargeTarget.q.a(this.charger.q.V().a(this.chargeTarget.u, this.chargeTarget.v + this.chargeTarget.f(), this.chargeTarget.w), chargePos) == null;
        if (chargePos == null || !canSeeTargetFromDest) {
            return false;
        }
        this.chargeX = chargePos.c;
        this.chargeY = chargePos.d;
        this.chargeZ = chargePos.e;
        return this.charger.aC().nextInt(1) == 0;
    }
    
    public void c() {
        this.windup = 15 + this.charger.aC().nextInt(30);
    }
    
    public boolean b() {
        return this.windup > 0 || !this.charger.k().g();
    }
    
    public void e() {
        this.charger.h().a(this.chargeX, this.chargeY - 1.0, this.chargeZ, 10.0f, (float)this.charger.bp());
        if (this.windup > 0) {
            if (--this.windup == 0) {
                final boolean setpath = this.charger.k().a(this.chargeX, this.chargeY, this.chargeZ, (double)this.speed);
            }
            else {
                final om charger = this.charger;
                charger.aG += (float)0.8;
                if (this.charger instanceof EntityTFMinotaur) {
                    ((EntityTFMinotaur)this.charger).setCharging(true);
                }
            }
        }
        final double var1 = this.charger.O * 2.1f * this.charger.O * 2.1f;
        if (this.charger.e(this.chargeTarget.u, this.chargeTarget.E.b, this.chargeTarget.w) <= var1 && !this.hasAttacked) {
            this.hasAttacked = true;
            this.charger.m((nm)this.chargeTarget);
        }
    }
    
    public void d() {
        this.windup = 0;
        this.chargeTarget = null;
        this.hasAttacked = false;
        if (this.charger instanceof EntityTFMinotaur) {
            ((EntityTFMinotaur)this.charger).setCharging(false);
        }
    }
    
    protected asz findChargePoint(final nm attacker, final nm target, final double overshoot) {
        final double vecx = target.u - attacker.u;
        final double vecz = target.w - attacker.w;
        final float rangle = (float)Math.atan2(vecz, vecx);
        final double distance = lr.a(vecx * vecx + vecz * vecz);
        final double dx = lr.b(rangle) * (distance + overshoot);
        final double dz = lr.a(rangle) * (distance + overshoot);
        return this.charger.q.V().a(attacker.u + dx, target.v, attacker.w + dz);
    }
}
