// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import java.util.Iterator;
import java.util.List;
import twilightforest.entity.EntityTFFireBeetle;

public class EntityAITFFireBreath extends nc
{
    private md entityHost;
    private md attackTarget;
    protected double breathX;
    protected double breathY;
    protected double breathZ;
    private yc worldObj;
    private float moveSpeed;
    private int maxDuration;
    private float attackChance;
    private float breathRange;
    private int durationLeft;
    
    public EntityAITFFireBreath(final md par1EntityLiving, final float speed, final float range, final int time, final float chance) {
        this.entityHost = par1EntityLiving;
        this.worldObj = par1EntityLiving.p;
        this.moveSpeed = speed;
        this.breathRange = range;
        this.maxDuration = time;
        this.attackChance = chance;
        this.a(7);
    }
    
    public boolean a() {
        this.attackTarget = this.entityHost.aG();
        if (this.attackTarget == null || this.entityHost.d((lq)this.attackTarget) > this.breathRange || !this.entityHost.n((lq)this.attackTarget)) {
            return false;
        }
        this.breathX = this.attackTarget.t;
        this.breathY = this.attackTarget.u + this.attackTarget.e();
        this.breathZ = this.attackTarget.v;
        return this.entityHost.aB().nextFloat() < this.attackChance;
    }
    
    public void c() {
        this.durationLeft = this.maxDuration;
        if (this.entityHost instanceof EntityTFFireBeetle) {
            ((EntityTFFireBeetle)this.entityHost).setBreathing(true);
        }
    }
    
    public boolean b() {
        return this.durationLeft > 0 && !this.entityHost.L && !this.attackTarget.L && this.entityHost.d((lq)this.attackTarget) <= this.breathRange && this.entityHost.n((lq)this.attackTarget);
    }
    
    public void e() {
        --this.durationLeft;
        this.entityHost.aw().a(this.breathX, this.breathY, this.breathZ, 100.0f, 100.0f);
        this.faceVec(this.breathX, this.breathY, this.breathZ, 100.0f, 100.0f);
        if (this.maxDuration - this.durationLeft > 5) {
            final lq target = this.getHeadLookTarget();
            if (target != null) {
                ((EntityTFFireBeetle)this.entityHost).doBreathAttack(target);
            }
        }
    }
    
    public void d() {
        this.durationLeft = 0;
        if (this.entityHost instanceof EntityTFFireBeetle) {
            ((EntityTFFireBeetle)this.entityHost).setBreathing(false);
        }
    }
    
    private lq getHeadLookTarget() {
        lq pointedEntity = null;
        final double range = 30.0;
        final aoj srcVec = this.entityHost.p.S().a(this.entityHost.t, this.entityHost.u + 0.25, this.entityHost.v);
        final aoj lookVec = this.entityHost.i(1.0f);
        final aoj destVec = srcVec.c(lookVec.c * range, lookVec.d * range, lookVec.e * range);
        final float var9 = 3.0f;
        final List possibleList = this.entityHost.p.b((lq)this.entityHost, this.entityHost.D.a(lookVec.c * range, lookVec.d * range, lookVec.e * range).b((double)var9, (double)var9, (double)var9));
        double hitDist = 0.0;
        for (final lq possibleEntity : possibleList) {
            if (possibleEntity.L() && possibleEntity != this.entityHost) {
                final float borderSize = possibleEntity.Y();
                final aoe collisionBB = possibleEntity.D.b((double)borderSize, (double)borderSize, (double)borderSize);
                final aoh interceptPos = collisionBB.a(srcVec, destVec);
                if (collisionBB.a(srcVec)) {
                    if (0.0 >= hitDist && hitDist != 0.0) {
                        continue;
                    }
                    pointedEntity = possibleEntity;
                    hitDist = 0.0;
                }
                else {
                    if (interceptPos == null) {
                        continue;
                    }
                    final double possibleDist = srcVec.d(interceptPos.f);
                    if (possibleDist >= hitDist && hitDist != 0.0) {
                        continue;
                    }
                    pointedEntity = possibleEntity;
                    hitDist = possibleDist;
                }
            }
        }
        return pointedEntity;
    }
    
    public void faceVec(final double xCoord, final double yCoord, final double zCoord, final float yawConstraint, final float pitchConstraint) {
        final double xOffset = xCoord - this.entityHost.t;
        final double zOffset = zCoord - this.entityHost.v;
        final double yOffset = this.entityHost.u + 0.25 - yCoord;
        final double distance = ke.a(xOffset * xOffset + zOffset * zOffset);
        final float xyAngle = (float)(Math.atan2(zOffset, xOffset) * 180.0 / 3.141592653589793) - 90.0f;
        final float zdAngle = (float)(-(Math.atan2(yOffset, distance) * 180.0 / 3.141592653589793));
        this.entityHost.A = -this.updateRotation(this.entityHost.A, zdAngle, pitchConstraint);
        this.entityHost.z = this.updateRotation(this.entityHost.z, xyAngle, yawConstraint);
    }
    
    private float updateRotation(final float par1, final float par2, final float par3) {
        float var4 = ke.g(par2 - par1);
        if (var4 > par3) {
            var4 = par3;
        }
        if (var4 < -par3) {
            var4 = -par3;
        }
        return par1 + var4;
    }
}
