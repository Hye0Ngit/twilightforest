// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;
import java.util.EnumSet;
import net.minecraft.world.entity.ai.goal.Goal;
import twilightforest.entity.monster.Redcap;
import net.minecraft.world.entity.LivingEntity;

public class RedcapShyGoal extends RedcapBaseGoal
{
    private LivingEntity entityTarget;
    private final float speed;
    private final boolean lefty;
    private double targetX;
    private double targetY;
    private double targetZ;
    private static final double minDistance = 3.0;
    private static final double maxDistance = 6.0;
    
    public RedcapShyGoal(final Redcap entityTFRedcap, final float moveSpeed) {
        super(entityTFRedcap);
        this.lefty = (Math.random() < 0.5);
        this.speed = moveSpeed;
        this.m_7021_((EnumSet)EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }
    
    public boolean m_8036_() {
        final LivingEntity attackTarget = this.redcap.m_5448_();
        if (attackTarget == null || !this.redcap.isShy() || attackTarget.m_20270_((Entity)this.redcap) > 6.0 || attackTarget.m_20270_((Entity)this.redcap) < 3.0 || !this.isTargetLookingAtMe(attackTarget)) {
            return false;
        }
        this.entityTarget = attackTarget;
        final Vec3 avoidPos = this.findCirclePoint((Entity)this.redcap, (Entity)this.entityTarget, 5.0, this.lefty ? 1.0 : -1.0);
        this.targetX = avoidPos.f_82479_;
        this.targetY = avoidPos.f_82480_;
        this.targetZ = avoidPos.f_82481_;
        return true;
    }
    
    public void m_8056_() {
        this.redcap.m_21573_().m_26519_(this.targetX, this.targetY, this.targetZ, (double)this.speed);
    }
    
    public boolean m_8045_() {
        final LivingEntity attackTarget = this.redcap.m_5448_();
        return attackTarget != null && this.entityTarget.m_6084_() && !this.redcap.m_21573_().m_26571_() && this.redcap.isShy() && attackTarget.m_20270_((Entity)this.redcap) < 6.0 && attackTarget.m_20270_((Entity)this.redcap) > 3.0 && this.isTargetLookingAtMe(attackTarget);
    }
    
    public void m_8037_() {
        this.redcap.m_21563_().m_24960_((Entity)this.entityTarget, 30.0f, 30.0f);
    }
    
    public void m_8041_() {
        this.entityTarget = null;
        this.redcap.m_21573_().m_26573_();
    }
    
    private Vec3 findCirclePoint(final Entity circler, final Entity toCircle, final double radius, final double rotation) {
        final double vecx = circler.m_20185_() - toCircle.m_20185_();
        final double vecz = circler.m_20189_() - toCircle.m_20189_();
        float rangle = (float)Math.atan2(vecz, vecx);
        rangle += (float)rotation;
        final double dx = Mth.m_14089_(rangle) * radius;
        final double dz = Mth.m_14031_(rangle) * radius;
        return new Vec3(toCircle.m_20185_() + dx, circler.m_142469_().f_82289_, toCircle.m_20189_() + dz);
    }
}
