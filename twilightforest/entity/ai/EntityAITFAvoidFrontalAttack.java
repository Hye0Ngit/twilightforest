// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import twilightforest.entity.EntityTFRedcap;

public class EntityAITFAvoidFrontalAttack extends pr
{
    oe entityTarget;
    of me;
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
        this.me = (of)entityTFRedcap;
        this.speed = moveSpeed;
        this.lefty = this.me.q.s.nextBoolean();
        this.a(1);
    }
    
    public boolean a() {
        final oe attackTarget = this.me.m();
        if (attackTarget == null || attackTarget.d((nm)this.me) > this.maxDistance || attackTarget.d((nm)this.me) < this.minDistance || !this.isTargetLookingAtMe(attackTarget)) {
            return false;
        }
        this.entityTarget = attackTarget;
        final asz avoidPos = this.findCirclePoint((nm)this.me, (nm)this.entityTarget, 5.0, this.lefty ? 1.0 : -1.0);
        if (avoidPos == null) {
            return false;
        }
        this.xPosition = avoidPos.c;
        this.yPosition = avoidPos.d;
        this.zPosition = avoidPos.e;
        return true;
    }
    
    public void c() {
        this.me.k().a(this.xPosition, this.yPosition, this.zPosition, (double)this.speed);
    }
    
    public boolean b() {
        final oe attackTarget = this.me.m();
        if (attackTarget == null) {
            return false;
        }
        if (!this.entityTarget.S()) {
            return false;
        }
        if (this.me.k().g()) {
            return false;
        }
        final boolean shouldContinue = attackTarget.d((nm)this.me) < this.maxDistance && attackTarget.d((nm)this.me) > this.minDistance && this.isTargetLookingAtMe(attackTarget);
        return shouldContinue;
    }
    
    public void e() {
        this.me.h().a((nm)this.entityTarget, 30.0f, 30.0f);
    }
    
    public void d() {
        this.entityTarget = null;
        this.me.k().h();
    }
    
    protected asz findCirclePoint(final nm circler, final nm toCircle, final double radius, final double rotation) {
        final double vecx = circler.u - toCircle.u;
        final double vecz = circler.w - toCircle.w;
        float rangle = (float)Math.atan2(vecz, vecx);
        rangle += (float)rotation;
        final double dx = lr.b(rangle) * radius;
        final double dz = lr.a(rangle) * radius;
        return this.me.q.V().a(toCircle.u + dx, circler.E.b, toCircle.w + dz);
    }
    
    public boolean isTargetLookingAtMe(final oe attackTarget) {
        final double dx = this.me.u - attackTarget.u;
        final double dz = this.me.w - attackTarget.w;
        final float angle = (float)(Math.atan2(dz, dx) * 180.0 / 3.1415927410125732) - 90.0f;
        final float difference = lr.e((attackTarget.A - angle) % 360.0f);
        return difference < 60.0f || difference > 300.0f;
    }
}
