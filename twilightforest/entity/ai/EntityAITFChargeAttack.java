// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import twilightforest.entity.EntityTFMinotaur;

public class EntityAITFChargeAttack extends nc
{
    protected static final double MIN_RANGE_SQ = 16.0;
    protected static final double MAX_RANGE_SQ = 64.0;
    protected static final int FREQ = 1;
    protected md charger;
    protected md chargeTarget;
    protected double chargeX;
    protected double chargeY;
    protected double chargeZ;
    protected float speed;
    protected int windup;
    protected boolean hasAttacked;
    
    public EntityAITFChargeAttack(final md entityLiving, final float f) {
        this.charger = entityLiving;
        this.speed = f;
        this.windup = 0;
        this.hasAttacked = false;
        this.a(3);
    }
    
    public boolean a() {
        this.chargeTarget = this.charger.aG();
        if (this.chargeTarget == null) {
            return false;
        }
        final double distance = this.charger.e((lq)this.chargeTarget);
        if (distance < 16.0 || distance > 64.0) {
            return false;
        }
        if (!this.charger.E) {
            return false;
        }
        final aoj chargePos = this.findChargePoint((lq)this.charger, (lq)this.chargeTarget, 2.1);
        final boolean canSeeTargetFromDest = this.chargeTarget.p.a(this.charger.p.S().a(this.chargeTarget.t, this.chargeTarget.u + this.chargeTarget.e(), this.chargeTarget.v), chargePos) == null;
        if (chargePos == null || !canSeeTargetFromDest) {
            return false;
        }
        this.chargeX = chargePos.c;
        this.chargeY = chargePos.d;
        this.chargeZ = chargePos.e;
        return this.charger.aB().nextInt(1) == 0;
    }
    
    public void c() {
        this.windup = 15 + this.charger.aB().nextInt(30);
    }
    
    public boolean b() {
        return this.windup > 0 || !this.charger.az().f();
    }
    
    public void e() {
        this.charger.aw().a(this.chargeX, this.chargeY - 1.0, this.chargeZ, 10.0f, (float)this.charger.bp());
        if (this.windup > 0) {
            if (--this.windup == 0) {
                final boolean setpath = this.charger.az().a(this.chargeX, this.chargeY, this.chargeZ, this.speed);
            }
            else {
                final md charger = this.charger;
                charger.bh += (float)0.8;
                if (this.charger instanceof EntityTFMinotaur) {
                    ((EntityTFMinotaur)this.charger).setCharging(true);
                }
            }
        }
        final double var1 = this.charger.N * 2.1f * this.charger.N * 2.1f;
        if (this.charger.e(this.chargeTarget.t, this.chargeTarget.D.b, this.chargeTarget.v) <= var1 && !this.hasAttacked) {
            this.hasAttacked = true;
            this.charger.m((lq)this.chargeTarget);
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
    
    protected aoj findChargePoint(final lq attacker, final lq target, final double overshoot) {
        final double vecx = target.t - attacker.t;
        final double vecz = target.v - attacker.v;
        final float rangle = (float)Math.atan2(vecz, vecx);
        final double distance = ke.a(vecx * vecx + vecz * vecz);
        final double dx = ke.b(rangle) * (distance + overshoot);
        final double dz = ke.a(rangle) * (distance + overshoot);
        return this.charger.p.S().a(attacker.t + dx, target.u, attacker.v + dz);
    }
}
