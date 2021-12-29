// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import java.util.Iterator;
import java.util.List;
import twilightforest.entity.EntityTFFireBeetle;

public class EntityAITFFireBreath extends pr
{
    private of entityHost;
    private oe attackTarget;
    protected double breathX;
    protected double breathY;
    protected double breathZ;
    private abv worldObj;
    private float moveSpeed;
    private int maxDuration;
    private float attackChance;
    private float breathRange;
    private int durationLeft;
    
    public EntityAITFFireBreath(final of par1EntityLiving, final float speed, final float range, final int time, final float chance) {
        this.entityHost = par1EntityLiving;
        this.worldObj = par1EntityLiving.q;
        this.moveSpeed = speed;
        this.breathRange = range;
        this.maxDuration = time;
        this.attackChance = chance;
        this.a(7);
    }
    
    public boolean a() {
        this.attackTarget = this.entityHost.m();
        if (this.attackTarget == null || this.entityHost.d((nm)this.attackTarget) > this.breathRange || !this.entityHost.o((nm)this.attackTarget)) {
            return false;
        }
        this.breathX = this.attackTarget.u;
        this.breathY = this.attackTarget.v + this.attackTarget.f();
        this.breathZ = this.attackTarget.w;
        return this.entityHost.aC().nextFloat() < this.attackChance;
    }
    
    public void c() {
        this.durationLeft = this.maxDuration;
        if (this.entityHost instanceof EntityTFFireBeetle) {
            ((EntityTFFireBeetle)this.entityHost).setBreathing(true);
        }
    }
    
    public boolean b() {
        return this.durationLeft > 0 && !this.entityHost.M && !this.attackTarget.M && this.entityHost.d((nm)this.attackTarget) <= this.breathRange && this.entityHost.o((nm)this.attackTarget);
    }
    
    public void e() {
        --this.durationLeft;
        this.entityHost.h().a(this.breathX, this.breathY, this.breathZ, 100.0f, 100.0f);
        this.faceVec(this.breathX, this.breathY, this.breathZ, 100.0f, 100.0f);
        if (this.maxDuration - this.durationLeft > 5) {
            final nm target = this.getHeadLookTarget();
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
    
    private nm getHeadLookTarget() {
        nm pointedEntity = null;
        final double range = 30.0;
        final asz srcVec = this.entityHost.q.V().a(this.entityHost.u, this.entityHost.v + 0.25, this.entityHost.w);
        final asz lookVec = this.entityHost.j(1.0f);
        final asz destVec = srcVec.c(lookVec.c * range, lookVec.d * range, lookVec.e * range);
        final float var9 = 3.0f;
        final List<nm> possibleList = this.entityHost.q.b((nm)this.entityHost, this.entityHost.E.a(lookVec.c * range, lookVec.d * range, lookVec.e * range).b((double)var9, (double)var9, (double)var9));
        double hitDist = 0.0;
        for (final nm possibleEntity : possibleList) {
            if (possibleEntity.K() && possibleEntity != this.entityHost) {
                final float borderSize = possibleEntity.Y();
                final asu collisionBB = possibleEntity.E.b((double)borderSize, (double)borderSize, (double)borderSize);
                final asx interceptPos = collisionBB.a(srcVec, destVec);
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
        final double xOffset = xCoord - this.entityHost.u;
        final double zOffset = zCoord - this.entityHost.w;
        final double yOffset = this.entityHost.v + 0.25 - yCoord;
        final double distance = lr.a(xOffset * xOffset + zOffset * zOffset);
        final float xyAngle = (float)(Math.atan2(zOffset, xOffset) * 180.0 / 3.141592653589793) - 90.0f;
        final float zdAngle = (float)(-(Math.atan2(yOffset, distance) * 180.0 / 3.141592653589793));
        this.entityHost.B = -this.updateRotation(this.entityHost.B, zdAngle, pitchConstraint);
        this.entityHost.A = this.updateRotation(this.entityHost.A, xyAngle, yawConstraint);
    }
    
    private float updateRotation(final float par1, final float par2, final float par3) {
        float var4 = lr.g(par2 - par1);
        if (var4 > par3) {
            var4 = par3;
        }
        if (var4 < -par3) {
            var4 = -par3;
        }
        return par1 + var4;
    }
}
