// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.util.math.MathHelper;
import java.util.Optional;
import net.minecraft.util.math.AxisAlignedBB;
import java.util.Iterator;
import java.util.List;
import java.util.Collection;
import java.util.Arrays;
import java.util.Objects;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.EntityPredicates;
import net.minecraft.entity.Entity;
import java.util.EnumSet;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import twilightforest.entity.IBreathAttacker;
import net.minecraft.entity.MobEntity;

public class BreathAttackGoal<T extends MobEntity & IBreathAttacker> extends Goal
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
        this.func_220684_a((EnumSet)EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
    }
    
    public boolean func_75250_a() {
        this.attackTarget = this.entityHost.func_70643_av();
        if (this.attackTarget == null || this.entityHost.func_70032_d((Entity)this.attackTarget) > this.breathRange || !this.entityHost.func_70635_at().func_75522_a((Entity)this.attackTarget) || !EntityPredicates.field_233583_f_.test(this.attackTarget)) {
            return false;
        }
        this.breathX = this.attackTarget.func_226277_ct_();
        this.breathY = this.attackTarget.func_226278_cu_() + this.attackTarget.func_70047_e();
        this.breathZ = this.attackTarget.func_226281_cx_();
        return this.entityHost.func_70681_au().nextFloat() < this.attackChance;
    }
    
    public void func_75249_e() {
        this.durationLeft = this.maxDuration;
        this.entityHost.setBreathing(true);
    }
    
    public boolean func_75253_b() {
        return this.durationLeft > 0 && this.entityHost.func_70089_S() && this.attackTarget.func_70089_S() && this.entityHost.func_70032_d((Entity)this.attackTarget) <= this.breathRange && this.entityHost.func_70635_at().func_75522_a((Entity)this.attackTarget) && EntityPredicates.field_233583_f_.test(this.attackTarget);
    }
    
    public void func_75246_d() {
        --this.durationLeft;
        this.entityHost.func_70671_ap().func_75650_a(this.breathX, this.breathY, this.breathZ, 100.0f, 100.0f);
        this.faceVec(this.breathX, this.breathY, this.breathZ, 100.0f, 100.0f);
        if (this.maxDuration - this.durationLeft > 5) {
            final Entity target = this.getHeadLookTarget();
            if (target != null) {
                this.entityHost.doBreathAttack(target);
            }
        }
    }
    
    public void func_75251_c() {
        this.durationLeft = 0;
        this.attackTarget = null;
        this.entityHost.setBreathing(false);
    }
    
    private Entity getHeadLookTarget() {
        Entity pointedEntity = null;
        final double range = 30.0;
        final double offset = 3.0;
        final Vector3d srcVec = new Vector3d(this.entityHost.func_226277_ct_(), this.entityHost.func_226278_cu_() + 0.25, this.entityHost.func_226281_cx_());
        final Vector3d lookVec = this.entityHost.func_70676_i(1.0f);
        final Vector3d destVec = srcVec.func_72441_c(lookVec.field_72450_a * range, lookVec.field_72448_b * range, lookVec.field_72449_c * range);
        final float var9 = 0.5f;
        final List<Entity> possibleList = this.entityHost.field_70170_p.func_72839_b((Entity)this.entityHost, this.entityHost.func_174813_aQ().func_72317_d(lookVec.field_72450_a * offset, lookVec.field_72448_b * offset, lookVec.field_72449_c * offset).func_72314_b((double)var9, (double)var9, (double)var9));
        double hitDist = 0.0;
        if (this.entityHost.isMultipartEntity()) {
            possibleList.removeAll(Arrays.asList((Object[])Objects.requireNonNull((T[])this.entityHost.getParts())));
        }
        for (final Entity possibleEntity : possibleList) {
            if (possibleEntity.func_70067_L() && possibleEntity != this.entityHost && EntityPredicates.field_233583_f_.test(possibleEntity)) {
                final float borderSize = possibleEntity.func_70111_Y();
                final AxisAlignedBB collisionBB = possibleEntity.func_174813_aQ().func_72314_b((double)borderSize, (double)borderSize, (double)borderSize);
                final Optional<Vector3d> interceptPos = collisionBB.func_216365_b(srcVec, destVec);
                if (collisionBB.func_72318_a(srcVec)) {
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
                    final double possibleDist = srcVec.func_72438_d((Vector3d)interceptPos.get());
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
        final double xOffset = x - this.entityHost.func_226277_ct_();
        final double zOffset = z - this.entityHost.func_226281_cx_();
        final double yOffset = this.entityHost.func_226278_cu_() + 0.25 - y;
        final double distance = MathHelper.func_76133_a(xOffset * xOffset + zOffset * zOffset);
        final float xyAngle = (float)(Math.atan2(zOffset, xOffset) * 180.0 / 3.141592653589793) - 90.0f;
        final float zdAngle = (float)(-(Math.atan2(yOffset, distance) * 180.0 / 3.141592653589793));
        this.entityHost.field_70125_A = -this.updateRotation(this.entityHost.field_70125_A, zdAngle, pitchConstraint);
        this.entityHost.field_70177_z = this.updateRotation(this.entityHost.field_70177_z, xyAngle, yawConstraint);
    }
    
    private float updateRotation(final float current, final float target, final float maxDelta) {
        float delta = MathHelper.func_76142_g(target - current);
        if (delta > maxDelta) {
            delta = maxDelta;
        }
        if (delta < -maxDelta) {
            delta = -maxDelta;
        }
        return current + delta;
    }
}
