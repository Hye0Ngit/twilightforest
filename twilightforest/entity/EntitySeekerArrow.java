// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import java.util.Iterator;
import java.util.List;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.command.IEntitySelector;
import net.minecraft.util.Vec3;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;

public class EntitySeekerArrow extends EntityArrow
{
    private EntityLivingBase homingTarget;
    double seekDistance;
    
    public EntitySeekerArrow(final World par1World) {
        super(par1World);
        this.seekDistance = 5.0;
    }
    
    public EntitySeekerArrow(final World world, final EntityPlayer player, final float velocity) {
        super(world, (EntityLivingBase)player, velocity);
        this.seekDistance = 5.0;
    }
    
    public void func_70071_h_() {
        if (this.isThisArrowFlying()) {
            if (this.homingTarget == null) {
                final double minX = this.field_70142_S;
                final double minY = this.field_70137_T;
                final double minZ = this.field_70136_U;
                final double maxX = this.field_70142_S;
                final double maxY = this.field_70137_T;
                final double maxZ = this.field_70136_U;
                AxisAlignedBB targetBB = AxisAlignedBB.func_72330_a(minX, minY, minZ, maxX, maxY, maxZ);
                Vec3 courseVec = Vec3.func_72443_a(this.field_70159_w * this.seekDistance, this.field_70181_x * this.seekDistance, this.field_70179_y * this.seekDistance);
                courseVec.func_72442_b(0.5235988f);
                targetBB = targetBB.func_72321_a(courseVec.field_72450_a, courseVec.field_72448_b, courseVec.field_72449_c);
                courseVec = Vec3.func_72443_a(this.field_70159_w * this.seekDistance, this.field_70181_x * this.seekDistance, this.field_70179_y * this.seekDistance);
                courseVec.func_72442_b(-0.5235988f);
                final AxisAlignedBB func_72321_a;
                targetBB = (func_72321_a = targetBB.func_72321_a(courseVec.field_72450_a, courseVec.field_72448_b, courseVec.field_72449_c));
                func_72321_a.field_72338_b -= 3.0;
                final AxisAlignedBB axisAlignedBB = targetBB;
                axisAlignedBB.field_72337_e += 3.0;
                final List targets = this.field_70170_p.func_94576_a((Entity)this, targetBB, IEntitySelector.field_94557_a);
                double closestDot = 1.0;
                for (final Object thing : targets) {
                    if (thing instanceof EntityLivingBase && !(thing instanceof EntityPlayer)) {
                        final EntityLivingBase living = (EntityLivingBase)thing;
                        System.out.println("Possible target : " + living);
                        courseVec = Vec3.func_72443_a(this.field_70159_w, this.field_70181_x, this.field_70179_y);
                        courseVec = courseVec.func_72432_b();
                        Vec3 targetVec = Vec3.func_72443_a(this.field_70165_t - living.field_70165_t, this.field_70163_u - (living.field_70163_u + living.func_70047_e()), this.field_70161_v - living.field_70161_v);
                        targetVec = targetVec.func_72432_b();
                        final double dot = courseVec.func_72430_b(targetVec);
                        if (dot >= closestDot) {
                            continue;
                        }
                        this.homingTarget = living;
                        closestDot = dot;
                    }
                }
                if (targets.size() > 0) {}
            }
            else {
                Vec3 targetVec2 = Vec3.func_72443_a(this.field_70165_t - this.homingTarget.field_70165_t, this.field_70163_u - (this.homingTarget.field_70163_u + this.homingTarget.func_70047_e()), this.field_70161_v - this.homingTarget.field_70161_v);
                targetVec2 = targetVec2.func_72432_b();
                Vec3 courseVec2 = Vec3.func_72443_a(this.field_70159_w * this.seekDistance, this.field_70181_x * this.seekDistance, this.field_70179_y * this.seekDistance);
                courseVec2 = courseVec2.func_72432_b();
                final double dotProduct = courseVec2.func_72430_b(targetVec2);
                if (dotProduct < 0.0) {
                    float currentSpeed = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
                    currentSpeed *= 1.0;
                    final Vec3 vec3 = targetVec2;
                    vec3.field_72450_a *= currentSpeed;
                    final Vec3 vec4 = targetVec2;
                    vec4.field_72448_b *= currentSpeed;
                    final Vec3 vec5 = targetVec2;
                    vec5.field_72449_c *= currentSpeed;
                    final double dx = MathHelper.func_151237_a(targetVec2.field_72450_a, -2.0, 2.0);
                    final double dy = MathHelper.func_151237_a(targetVec2.field_72448_b, -1.0, 1.0);
                    final double dz = MathHelper.func_151237_a(targetVec2.field_72449_c, -2.0, 2.0);
                    this.field_70159_w -= dx;
                    this.field_70181_x -= dy;
                    this.field_70179_y -= dz;
                }
                else {
                    this.homingTarget = null;
                }
            }
            this.field_70181_x += 0.04500000178813934;
        }
        super.func_70071_h_();
    }
    
    private boolean isThisArrowFlying() {
        return MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y) > 1.0;
    }
}
