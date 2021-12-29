// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.util.Mth;
import java.util.Optional;
import net.minecraft.world.phys.AABB;
import java.util.Iterator;
import java.util.List;
import java.util.Collection;
import java.util.Arrays;
import java.util.Objects;
import net.minecraft.world.phys.Vec3;
import java.util.function.Predicate;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.Entity;
import java.util.EnumSet;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import twilightforest.entity.IBreathAttacker;
import net.minecraft.world.entity.Mob;

public class BreathAttackGoal<T extends Mob & IBreathAttacker> extends Goal
{
    private final T entityHost;
    private LivingEntity attackTarget;
    private double breathX;
    private double breathY;
    private double breathZ;
    private final int maxDuration;
    private final float attackChance;
    private final float breathRange;
    private int durationLeft;
    
    public BreathAttackGoal(final T living, final float range, final int time, final float chance) {
        this.entityHost = living;
        this.breathRange = range;
        this.maxDuration = time;
        this.attackChance = chance;
        this.m_7021_((EnumSet)EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
    }
    
    public boolean m_8036_() {
        this.attackTarget = this.entityHost.m_142581_();
        if (this.attackTarget == null || this.entityHost.m_20270_((Entity)this.attackTarget) > this.breathRange || !this.entityHost.m_21574_().m_148306_((Entity)this.attackTarget) || !EntitySelector.f_20406_.and(EntitySelector.f_20403_).test(this.attackTarget)) {
            return false;
        }
        this.breathX = this.attackTarget.m_20185_();
        this.breathY = this.attackTarget.m_20186_() + this.attackTarget.m_20192_();
        this.breathZ = this.attackTarget.m_20189_();
        return this.entityHost.m_21187_().nextFloat() < this.attackChance;
    }
    
    public void m_8056_() {
        this.durationLeft = this.maxDuration;
        this.entityHost.setBreathing(true);
    }
    
    public boolean m_8045_() {
        return this.durationLeft > 0 && this.entityHost.m_6084_() && this.attackTarget.m_6084_() && this.entityHost.m_20270_((Entity)this.attackTarget) <= this.breathRange && this.entityHost.m_21574_().m_148306_((Entity)this.attackTarget) && EntitySelector.f_20406_.and(EntitySelector.f_20403_).test(this.attackTarget);
    }
    
    public void m_8037_() {
        --this.durationLeft;
        this.entityHost.m_21563_().m_24950_(this.breathX, this.breathY, this.breathZ, 100.0f, 100.0f);
        this.faceVec(this.breathX, this.breathY, this.breathZ, 100.0f, 100.0f);
        if (this.maxDuration - this.durationLeft > 5) {
            final Entity target = this.getHeadLookTarget();
            if (target != null) {
                this.entityHost.doBreathAttack(target);
            }
        }
    }
    
    public void m_8041_() {
        this.durationLeft = 0;
        this.attackTarget = null;
        this.entityHost.setBreathing(false);
    }
    
    private Entity getHeadLookTarget() {
        Entity pointedEntity = null;
        final double range = 30.0;
        final double offset = 3.0;
        final Vec3 srcVec = new Vec3(this.entityHost.m_20185_(), this.entityHost.m_20186_() + 0.25, this.entityHost.m_20189_());
        final Vec3 lookVec = this.entityHost.m_20252_(1.0f);
        final Vec3 destVec = srcVec.m_82520_(lookVec.f_82479_ * range, lookVec.f_82480_ * range, lookVec.f_82481_ * range);
        final float var9 = 0.5f;
        final List<Entity> possibleList = this.entityHost.f_19853_.m_45933_((Entity)this.entityHost, this.entityHost.m_142469_().m_82386_(lookVec.f_82479_ * offset, lookVec.f_82480_ * offset, lookVec.f_82481_ * offset).m_82377_((double)var9, (double)var9, (double)var9));
        double hitDist = 0.0;
        if (this.entityHost.isMultipartEntity()) {
            possibleList.removeAll(Arrays.asList((Object[])Objects.requireNonNull((T[])this.entityHost.getParts())));
        }
        for (final Entity possibleEntity : possibleList) {
            if (possibleEntity.m_6087_() && possibleEntity != this.entityHost && EntitySelector.f_20406_.and(EntitySelector.f_20403_).test(possibleEntity)) {
                final float borderSize = possibleEntity.m_6143_();
                final AABB collisionBB = possibleEntity.m_142469_().m_82377_((double)borderSize, (double)borderSize, (double)borderSize);
                final Optional<Vec3> interceptPos = collisionBB.m_82371_(srcVec, destVec);
                if (collisionBB.m_82390_(srcVec)) {
                    if (0.0 >= hitDist && hitDist != 0.0) {
                        continue;
                    }
                    pointedEntity = possibleEntity;
                    hitDist = 0.0;
                }
                else {
                    if (!interceptPos.isPresent()) {
                        continue;
                    }
                    final double possibleDist = srcVec.m_82554_((Vec3)interceptPos.get());
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
    
    public void faceVec(final double x, final double y, final double z, final float yawConstraint, final float pitchConstraint) {
        final double xOffset = x - this.entityHost.m_20185_();
        final double zOffset = z - this.entityHost.m_20189_();
        final double yOffset = this.entityHost.m_20186_() + 0.25 - y;
        final double distance = Mth.m_14116_((float)(xOffset * xOffset + zOffset * zOffset));
        final float xyAngle = (float)(Math.atan2(zOffset, xOffset) * 180.0 / 3.141592653589793) - 90.0f;
        final float zdAngle = (float)(-(Math.atan2(yOffset, distance) * 180.0 / 3.141592653589793));
        this.entityHost.m_146926_(-this.updateRotation(this.entityHost.m_146909_(), zdAngle, pitchConstraint));
        this.entityHost.m_146922_(this.updateRotation(this.entityHost.m_146908_(), xyAngle, yawConstraint));
    }
    
    private float updateRotation(final float current, final float target, final float maxDelta) {
        float delta = Mth.m_14177_(target - current);
        if (delta > maxDelta) {
            delta = maxDelta;
        }
        if (delta < -maxDelta) {
            delta = -maxDelta;
        }
        return current + delta;
    }
}
