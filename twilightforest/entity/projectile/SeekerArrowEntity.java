// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.projectile;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.entity.Entity;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.network.datasync.DataParameter;

public class SeekerArrowEntity extends TFArrowEntity
{
    private static final DataParameter<Integer> TARGET;
    private static final double seekDistance = 5.0;
    private static final double seekFactor = 0.8;
    private static final double seekAngle = 0.5235987755982988;
    private static final double seekThreshold = 0.5;
    
    public SeekerArrowEntity(final EntityType<? extends SeekerArrowEntity> type, final World world) {
        super(type, world);
    }
    
    public SeekerArrowEntity(final EntityType<? extends SeekerArrowEntity> type, final World world, final LivingEntity shooter) {
        super(type, world, shooter);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)SeekerArrowEntity.TARGET, (Object)(-1));
    }
    
    public void func_70071_h_() {
        if (this.isThisArrowFlying()) {
            if (!this.field_70170_p.field_72995_K) {
                this.updateTarget();
            }
            if (this.field_70170_p.field_72995_K && !this.field_70254_i) {
                for (int i = 0; i < 4; ++i) {
                    this.field_70170_p.func_195594_a((IParticleData)ParticleTypes.field_197607_R, this.func_226277_ct_() + this.func_213322_ci().func_82615_a() * i / 4.0, this.func_226278_cu_() + this.func_213322_ci().func_82617_b() * i / 4.0, this.func_226281_cx_() + this.func_213322_ci().func_82616_c() * i / 4.0, -this.func_213322_ci().func_82615_a(), -this.func_213322_ci().func_82617_b() + 0.2, -this.func_213322_ci().func_82616_c());
                }
            }
            final Entity target = this.getTarget();
            if (target != null) {
                final Vector3d targetVec = this.getVectorToTarget(target).func_186678_a(0.8);
                final Vector3d courseVec = this.getMotionVec();
                final double courseLen = courseVec.func_72433_c();
                final double targetLen = targetVec.func_72433_c();
                final double totalLen = Math.sqrt(courseLen * courseLen + targetLen * targetLen);
                final double dotProduct = courseVec.func_72430_b(targetVec) / (courseLen * targetLen);
                if (dotProduct > 0.5) {
                    final Vector3d newMotion = courseVec.func_186678_a(courseLen / totalLen).func_178787_e(targetVec.func_186678_a(courseLen / totalLen));
                    this.func_213317_d(newMotion.func_72441_c(0.0, 0.04500000178813934, 0.0));
                }
                else if (!this.field_70170_p.field_72995_K) {
                    this.setTarget(null);
                }
            }
        }
        super.func_70071_h_();
    }
    
    private void updateTarget() {
        Entity target = this.getTarget();
        if (target != null && !target.func_70089_S()) {
            target = null;
            this.setTarget(null);
        }
        if (target == null) {
            AxisAlignedBB targetBB;
            final AxisAlignedBB positionBB = targetBB = new AxisAlignedBB(this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_(), this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_());
            Vector3d courseVec = this.getMotionVec().func_186678_a(5.0).func_178785_b(0.5235988f);
            targetBB = targetBB.func_111270_a(positionBB.func_191194_a(courseVec));
            courseVec = this.getMotionVec().func_186678_a(5.0).func_178785_b(-0.5235988f);
            targetBB = targetBB.func_111270_a(positionBB.func_191194_a(courseVec));
            targetBB = targetBB.func_72314_b(0.0, 2.5, 0.0);
            double closestDot = -1.0;
            Entity closestTarget = null;
            final List<MonsterEntity> monsters = this.field_70170_p.func_217357_a((Class)MonsterEntity.class, targetBB);
            for (final LivingEntity living : this.field_70170_p.func_217357_a((Class)LivingEntity.class, targetBB)) {
                if (!monsters.isEmpty()) {
                    for (final MonsterEntity targets : monsters) {
                        final Vector3d motionVec = this.getMotionVec().func_72432_b();
                        final Vector3d targetVec = this.getVectorToTarget((Entity)living).func_72432_b();
                        final double dot = motionVec.func_72430_b(targetVec);
                        if (dot > Math.max(closestDot, 0.5)) {
                            closestDot = dot;
                            closestTarget = (Entity)targets;
                            break;
                        }
                    }
                }
                if (living instanceof PlayerEntity) {
                    continue;
                }
                if (this.func_234616_v_() != null && living instanceof TameableEntity && ((TameableEntity)living).func_70902_q() == this.func_234616_v_()) {
                    continue;
                }
                final Vector3d motionVec2 = this.getMotionVec().func_72432_b();
                final Vector3d targetVec2 = this.getVectorToTarget((Entity)living).func_72432_b();
                final double dot2 = motionVec2.func_72430_b(targetVec2);
                if (dot2 <= Math.max(closestDot, 0.5)) {
                    continue;
                }
                closestDot = dot2;
                if (!monsters.isEmpty()) {
                    continue;
                }
                closestTarget = (Entity)living;
            }
            if (closestTarget != null) {
                this.setTarget(closestTarget);
            }
        }
    }
    
    private Vector3d getMotionVec() {
        return new Vector3d(this.func_213322_ci().func_82615_a(), this.func_213322_ci().func_82617_b(), this.func_213322_ci().func_82616_c());
    }
    
    private Vector3d getVectorToTarget(final Entity target) {
        return new Vector3d(target.func_226277_ct_() - this.func_226277_ct_(), target.func_226278_cu_() + target.func_70047_e() - this.func_226278_cu_(), target.func_226281_cx_() - this.func_226281_cx_());
    }
    
    @Nullable
    private Entity getTarget() {
        return this.field_70170_p.func_73045_a((int)this.field_70180_af.func_187225_a((DataParameter)SeekerArrowEntity.TARGET));
    }
    
    private void setTarget(@Nullable final Entity e) {
        this.field_70180_af.func_187227_b((DataParameter)SeekerArrowEntity.TARGET, (Object)((e == null) ? -1 : e.func_145782_y()));
    }
    
    private boolean isThisArrowFlying() {
        return !this.field_70254_i && this.func_213322_ci().func_189985_c() > 1.0;
    }
    
    static {
        TARGET = EntityDataManager.func_187226_a((Class)SeekerArrowEntity.class, DataSerializers.field_187192_b);
    }
}
