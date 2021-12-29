// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import javax.annotation.Nullable;
import java.util.Iterator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.network.datasync.DataParameter;

public class EntitySeekerArrow extends EntityTFArrow
{
    private static final DataParameter<Integer> TARGET;
    private static final double seekDistance = 5.0;
    private static final double seekFactor = 0.2;
    private static final double seekAngle = 0.5235987755982988;
    private static final double seekThreshold = 0.5;
    
    public EntitySeekerArrow(final World world) {
        super(world);
    }
    
    public EntitySeekerArrow(final World world, final EntityLivingBase shooter) {
        super(world, shooter);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)EntitySeekerArrow.TARGET, (Object)(-1));
    }
    
    public void func_70071_h_() {
        if (this.isThisArrowFlying()) {
            if (!this.field_70170_p.field_72995_K) {
                this.updateTarget();
            }
            if (this.field_70170_p.field_72995_K && !this.field_70254_i) {
                for (int i = 0; i < 4; ++i) {
                    this.field_70170_p.func_175688_a(EnumParticleTypes.SPELL_WITCH, this.field_70165_t + this.field_70159_w * i / 4.0, this.field_70163_u + this.field_70181_x * i / 4.0, this.field_70161_v + this.field_70179_y * i / 4.0, -this.field_70159_w, -this.field_70181_x + 0.2, -this.field_70179_y, new int[0]);
                }
            }
            final Entity target = this.getTarget();
            if (target != null) {
                final Vec3d targetVec = this.getVectorToTarget(target).func_186678_a(0.2);
                final Vec3d courseVec = this.getMotionVec();
                final double courseLen = courseVec.func_72433_c();
                final double targetLen = targetVec.func_72433_c();
                final double totalLen = Math.sqrt(courseLen * courseLen + targetLen * targetLen);
                final double dotProduct = courseVec.func_72430_b(targetVec) / (courseLen * targetLen);
                if (dotProduct > 0.5) {
                    final Vec3d newMotion = courseVec.func_186678_a(courseLen / totalLen).func_178787_e(targetVec.func_186678_a(targetLen / totalLen));
                    this.field_70159_w = newMotion.field_72450_a;
                    this.field_70181_x = newMotion.field_72448_b;
                    this.field_70179_y = newMotion.field_72449_c;
                    this.field_70181_x += 0.04500000178813934;
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
        if (target != null && target.field_70128_L) {
            this.setTarget(target = null);
        }
        if (target == null) {
            AxisAlignedBB targetBB;
            final AxisAlignedBB positionBB = targetBB = new AxisAlignedBB(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70165_t, this.field_70163_u, this.field_70161_v);
            Vec3d courseVec = this.getMotionVec().func_186678_a(5.0).func_178785_b(0.5235988f);
            targetBB = targetBB.func_111270_a(positionBB.func_191194_a(courseVec));
            courseVec = this.getMotionVec().func_186678_a(5.0).func_178785_b(-0.5235988f);
            targetBB = targetBB.func_111270_a(positionBB.func_191194_a(courseVec));
            targetBB = targetBB.func_72314_b(0.0, 2.5, 0.0);
            double closestDot = -1.0;
            Entity closestTarget = null;
            for (final EntityLivingBase living : this.field_70170_p.func_72872_a((Class)EntityLivingBase.class, targetBB)) {
                if (living instanceof EntityPlayer) {
                    continue;
                }
                final Vec3d motionVec = this.getMotionVec().func_72432_b();
                final Vec3d targetVec = this.getVectorToTarget((Entity)living).func_72432_b();
                final double dot = motionVec.func_72430_b(targetVec);
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
    
    private Vec3d getMotionVec() {
        return new Vec3d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
    }
    
    private Vec3d getVectorToTarget(final Entity target) {
        return new Vec3d(target.field_70165_t - this.field_70165_t, target.field_70163_u + target.func_70047_e() - this.field_70163_u, target.field_70161_v - this.field_70161_v);
    }
    
    @Nullable
    private Entity getTarget() {
        return this.field_70170_p.func_73045_a((int)this.field_70180_af.func_187225_a((DataParameter)EntitySeekerArrow.TARGET));
    }
    
    private void setTarget(@Nullable final Entity e) {
        this.field_70180_af.func_187227_b((DataParameter)EntitySeekerArrow.TARGET, (Object)((e == null) ? -1 : e.func_145782_y()));
    }
    
    private boolean isThisArrowFlying() {
        return !this.field_70254_i && this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y > 1.0;
    }
    
    static {
        TARGET = EntityDataManager.func_187226_a((Class)EntitySeekerArrow.class, DataSerializers.field_187192_b);
    }
}
