// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import twilightforest.entity.EntityTFRedcap;

public class EntityAITFAvoidFrontalAttack extends og
{
    ng entityTarget;
    ng me;
    float speed;
    boolean lefty;
    double xPosition;
    double yPosition;
    double zPosition;
    double minDistance;
    double maxDistance;
    
    public EntityAITFAvoidFrontalAttack(final EntityTFRedcap entityTFRedcap, final float moveSpeed) {
        this.minDistance = 3.0;
        this.maxDistance = 6.0;
        this.me = (ng)entityTFRedcap;
        this.speed = moveSpeed;
        this.lefty = this.me.q.s.nextBoolean();
        this.a(1);
    }
    
    public boolean a() {
        final ng attackTarget = this.me.aJ();
        if (attackTarget == null || attackTarget.d((mp)this.me) > this.maxDistance || attackTarget.d((mp)this.me) < this.minDistance || !this.isTargetLookingAtMe(attackTarget)) {
            return false;
        }
        this.entityTarget = attackTarget;
        final aqw avoidPos = this.findCirclePoint((mp)this.me, (mp)this.entityTarget, 5.0, this.lefty ? 1.0 : -1.0);
        if (avoidPos == null) {
            return false;
        }
        this.xPosition = avoidPos.c;
        this.yPosition = avoidPos.d;
        this.zPosition = avoidPos.e;
        return true;
    }
    
    public void c() {
        this.me.aC().a(this.xPosition, this.yPosition, this.zPosition, this.speed);
    }
    
    public boolean b() {
        final ng attackTarget = this.me.aJ();
        if (attackTarget == null) {
            return false;
        }
        if (!this.entityTarget.R()) {
            return false;
        }
        if (this.me.aC().f()) {
            return false;
        }
        final boolean shouldContinue = attackTarget.d((mp)this.me) < this.maxDistance && attackTarget.d((mp)this.me) > this.minDistance && this.isTargetLookingAtMe(attackTarget);
        return shouldContinue;
    }
    
    public void e() {
        this.me.az().a((mp)this.entityTarget, 30.0f, 30.0f);
    }
    
    public void d() {
        this.entityTarget = null;
        this.me.aC().g();
    }
    
    protected aqw findCirclePoint(final mp circler, final mp toCircle, final double radius, final double rotation) {
        final double vecx = circler.u - toCircle.u;
        final double vecz = circler.w - toCircle.w;
        float rangle = (float)Math.atan2(vecz, vecx);
        rangle += (float)rotation;
        final double dx = kx.b(rangle) * radius;
        final double dz = kx.a(rangle) * radius;
        return this.me.q.T().a(toCircle.u + dx, circler.E.b, toCircle.w + dz);
    }
    
    public boolean isTargetLookingAtMe(final ng target) {
        final double dx = this.me.u - target.u;
        final double dz = this.me.w - target.w;
        final float angle = (float)(Math.atan2(dz, dx) * 180.0 / 3.1415927410125732) - 90.0f;
        final float difference = kx.e((target.A - angle) % 360.0f);
        return difference < 60.0f || difference > 300.0f;
    }
}
