// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.projectile;

import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.world.phys.EntityHitResult;
import javax.annotation.Nullable;
import java.util.Iterator;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import net.minecraft.world.entity.monster.Monster;
import java.util.List;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import twilightforest.entity.TFEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.network.syncher.EntityDataAccessor;

public class SeekerArrow extends TFArrow
{
    private static final EntityDataAccessor<Integer> TARGET;
    private static final double seekDistance = 5.0;
    private static final double seekFactor = 0.8;
    private static final double seekAngle = 0.5235987755982988;
    private static final double seekThreshold = 0.5;
    
    public SeekerArrow(final EntityType<? extends SeekerArrow> type, final Level world) {
        super(type, world);
        this.m_36781_(1.0);
    }
    
    public SeekerArrow(final Level world, final Entity shooter) {
        super(TFEntities.SEEKER_ARROW, world, shooter);
        this.m_36781_(1.0);
    }
    
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_((EntityDataAccessor)SeekerArrow.TARGET, (Object)(-1));
    }
    
    public void m_8119_() {
        if (this.isThisArrowFlying()) {
            if (!this.f_19853_.f_46443_) {
                this.updateTarget();
            }
            if (this.f_19853_.f_46443_ && !this.f_36703_) {
                for (int i = 0; i < 4; ++i) {
                    this.f_19853_.m_7106_((ParticleOptions)ParticleTypes.f_123771_, this.m_20185_() + this.m_20184_().m_7096_() * i / 4.0, this.m_20186_() + this.m_20184_().m_7098_() * i / 4.0, this.m_20189_() + this.m_20184_().m_7094_() * i / 4.0, -this.m_20184_().m_7096_(), -this.m_20184_().m_7098_() + 0.2, -this.m_20184_().m_7094_());
                }
            }
            final Entity target = this.getTarget();
            if (target != null) {
                final Vec3 targetVec = this.getVectorToTarget(target).m_82490_(0.8);
                final Vec3 courseVec = this.getMotionVec();
                final double courseLen = courseVec.m_82553_();
                final double targetLen = targetVec.m_82553_();
                final double totalLen = Math.sqrt(courseLen * courseLen + targetLen * targetLen);
                final double dotProduct = courseVec.m_82526_(targetVec) / (courseLen * targetLen);
                if (dotProduct > 0.5) {
                    final Vec3 newMotion = courseVec.m_82490_(courseLen / totalLen).m_82549_(targetVec.m_82490_(courseLen / totalLen));
                    this.m_20256_(newMotion.m_82520_(0.0, 0.04500000178813934, 0.0));
                }
                else if (!this.f_19853_.f_46443_) {
                    this.setTarget(null);
                }
            }
        }
        super.m_8119_();
    }
    
    private void updateTarget() {
        Entity target = this.getTarget();
        if (target != null && !target.m_6084_()) {
            target = null;
            this.setTarget(null);
        }
        if (target == null) {
            AABB targetBB;
            final AABB positionBB = targetBB = new AABB(this.m_20185_(), this.m_20186_(), this.m_20189_(), this.m_20185_(), this.m_20186_(), this.m_20189_());
            Vec3 courseVec = this.getMotionVec().m_82490_(5.0).m_82524_(0.5235988f);
            targetBB = targetBB.m_82367_(positionBB.m_82383_(courseVec));
            courseVec = this.getMotionVec().m_82490_(5.0).m_82524_(-0.5235988f);
            targetBB = targetBB.m_82367_(positionBB.m_82383_(courseVec));
            targetBB = targetBB.m_82377_(0.0, 2.5, 0.0);
            double closestDot = -1.0;
            Entity closestTarget = null;
            final List<LivingEntity> entityList = this.f_19853_.m_45976_((Class)LivingEntity.class, targetBB);
            final List<LivingEntity> monsters = entityList.stream().filter(l -> l instanceof Monster).collect((Collector<? super Object, ?, List<LivingEntity>>)Collectors.toList());
            if (!monsters.isEmpty() && monsters.get(0).m_142582_((Entity)this)) {
                this.setTarget((Entity)monsters.get(0));
                return;
            }
            for (final LivingEntity living : entityList) {
                if (!living.m_142582_((Entity)this)) {
                    continue;
                }
                if (living instanceof Player) {
                    continue;
                }
                if (this.m_37282_() != null) {
                    final LivingEntity livingEntity = living;
                    if (livingEntity instanceof final TamableAnimal animal) {
                        if (animal.m_142480_() == this.m_37282_()) {
                            continue;
                        }
                    }
                }
                final Vec3 motionVec = this.getMotionVec().m_82541_();
                final Vec3 targetVec = this.getVectorToTarget((Entity)living).m_82541_();
                final double dot = motionVec.m_82526_(targetVec);
                if (dot <= Math.max(closestDot, 0.5)) {
                    continue;
                }
                closestDot = dot;
                closestTarget = (Entity)living;
            }
            if (closestTarget != null) {
                this.setTarget(closestTarget);
            }
        }
    }
    
    private Vec3 getMotionVec() {
        return new Vec3(this.m_20184_().m_7096_(), this.m_20184_().m_7098_(), this.m_20184_().m_7094_());
    }
    
    private Vec3 getVectorToTarget(final Entity target) {
        return new Vec3(target.m_20185_() - this.m_20185_(), target.m_20186_() + target.m_20192_() - this.m_20186_(), target.m_20189_() - this.m_20189_());
    }
    
    @Nullable
    private Entity getTarget() {
        return this.f_19853_.m_6815_((int)this.f_19804_.m_135370_((EntityDataAccessor)SeekerArrow.TARGET));
    }
    
    private void setTarget(@Nullable final Entity e) {
        this.f_19804_.m_135381_((EntityDataAccessor)SeekerArrow.TARGET, (Object)((e == null) ? -1 : e.m_142049_()));
    }
    
    private boolean isThisArrowFlying() {
        return !this.f_36703_ && this.m_20184_().m_82556_() > 1.0;
    }
    
    protected void m_5790_(final EntityHitResult pResult) {
        this.m_36762_(false);
        super.m_5790_(pResult);
    }
    
    static {
        TARGET = SynchedEntityData.m_135353_((Class)SeekerArrow.class, EntityDataSerializers.f_135028_);
    }
}
