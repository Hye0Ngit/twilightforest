// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Random;

public class EntityAITFRedcapShy extends EntityAITFRedcapBase
{
    md entityTarget;
    float speed;
    boolean lefty;
    double xPosition;
    double yPosition;
    double zPosition;
    double minDistance;
    double maxDistance;
    
    public EntityAITFRedcapShy(final EntityTFRedcap entityTFRedcap, final float moveSpeed) {
        this.minDistance = 3.0;
        this.maxDistance = 6.0;
        this.me = entityTFRedcap;
        this.speed = moveSpeed;
        this.lefty = new Random().nextBoolean();
        this.a(1);
    }
    
    public boolean a() {
        final md attackTarget = this.me.aG();
        if (attackTarget == null || !this.me.isShy() || attackTarget.d((lq)this.me) > this.maxDistance || attackTarget.d((lq)this.me) < this.minDistance || !this.isTargetLookingAtMe(attackTarget)) {
            return false;
        }
        this.entityTarget = attackTarget;
        final aob avoidPos = this.findCirclePoint((lq)this.me, (lq)this.entityTarget, 5.0, this.lefty ? 1.0 : -1.0);
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
        final boolean shouldContinue = this.me.isShy() && attackTarget.d((lq)this.me) < this.maxDistance && attackTarget.d((lq)this.me) > this.minDistance && this.isTargetLookingAtMe(attackTarget);
        return shouldContinue;
    }
    
    public void e() {
        this.me.aw().a((lq)this.entityTarget, 30.0f, 30.0f);
    }
    
    public void d() {
        this.entityTarget = null;
        this.me.az().g();
    }
    
    protected aob findCirclePoint(final lq circler, final lq toCircle, final double radius, final double rotation) {
        final double vecx = circler.t - toCircle.t;
        final double vecz = circler.v - toCircle.v;
        float rangle = (float)Math.atan2(vecz, vecx);
        rangle += (float)rotation;
        final double dx = ke.b(rangle) * radius;
        final double dz = ke.a(rangle) * radius;
        return this.me.p.S().a(toCircle.t + dx, circler.D.b, toCircle.v + dz);
    }
}
