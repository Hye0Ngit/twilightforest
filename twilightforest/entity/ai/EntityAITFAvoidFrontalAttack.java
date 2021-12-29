// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import twilightforest.entity.EntityTFRedcap;

public class EntityAITFAvoidFrontalAttack extends nc
{
    md entityTarget;
    md me;
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
        this.me = (md)entityTFRedcap;
        this.speed = moveSpeed;
        this.lefty = this.me.p.t.nextBoolean();
        this.a(1);
    }
    
    public boolean a() {
        final md attackTarget = this.me.aG();
        if (attackTarget == null || attackTarget.d((lq)this.me) > this.maxDistance || attackTarget.d((lq)this.me) < this.minDistance || !this.isTargetLookingAtMe(attackTarget)) {
            return false;
        }
        this.entityTarget = attackTarget;
        final aoj avoidPos = this.findCirclePoint((lq)this.me, (lq)this.entityTarget, 5.0, this.lefty ? 1.0 : -1.0);
        if (avoidPos == null) {
            return false;
        }
        this.xPosition = avoidPos.c;
        this.yPosition = avoidPos.d;
        this.zPosition = avoidPos.e;
        return true;
    }
    
    public void c() {
        this.me.az().a(this.xPosition, this.yPosition, this.zPosition, this.speed);
    }
    
    public boolean b() {
        final md attackTarget = this.me.aG();
        if (attackTarget == null) {
            return false;
        }
        if (!this.entityTarget.S()) {
            return false;
        }
        if (this.me.az().f()) {
            return false;
        }
        final boolean shouldContinue = attackTarget.d((lq)this.me) < this.maxDistance && attackTarget.d((lq)this.me) > this.minDistance && this.isTargetLookingAtMe(attackTarget);
        return shouldContinue;
    }
    
    public void e() {
        this.me.aw().a((lq)this.entityTarget, 30.0f, 30.0f);
    }
    
    public void d() {
        this.entityTarget = null;
        this.me.az().g();
    }
    
    protected aoj findCirclePoint(final lq circler, final lq toCircle, final double radius, final double rotation) {
        final double vecx = circler.t - toCircle.t;
        final double vecz = circler.v - toCircle.v;
        float rangle = (float)Math.atan2(vecz, vecx);
        rangle += (float)rotation;
        final double dx = ke.b(rangle) * radius;
        final double dz = ke.a(rangle) * radius;
        return this.me.p.S().a(toCircle.t + dx, circler.D.b, toCircle.v + dz);
    }
    
    public boolean isTargetLookingAtMe(final md target) {
        final double dx = this.me.t - target.t;
        final double dz = this.me.v - target.v;
        final float angle = (float)(Math.atan2(dz, dx) * 180.0 / 3.1415927410125732) - 90.0f;
        final float difference = ke.e((target.z - angle) % 360.0f);
        return difference < 60.0f || difference > 300.0f;
    }
}
