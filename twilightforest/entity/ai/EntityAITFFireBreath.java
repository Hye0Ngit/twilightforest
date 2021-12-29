// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.AxisAlignedBB;
import java.util.Iterator;
import java.util.List;
import net.minecraft.util.Vec3;
import twilightforest.entity.EntityTFFireBeetle;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAITFFireBreath extends EntityAIBase
{
    private EntityLiving entityHost;
    private EntityLiving attackTarget;
    protected double breathX;
    protected double breathY;
    protected double breathZ;
    private World worldObj;
    private float moveSpeed;
    private int maxDuration;
    private float attackChance;
    private float breathRange;
    private int durationLeft;
    
    public EntityAITFFireBreath(final EntityLiving par1EntityLiving, final float speed, final float range, final int time, final float chance) {
        this.entityHost = par1EntityLiving;
        this.worldObj = par1EntityLiving.field_70170_p;
        this.moveSpeed = speed;
        this.breathRange = range;
        this.maxDuration = time;
        this.attackChance = chance;
        this.func_75248_a(7);
    }
    
    public boolean func_75250_a() {
        this.attackTarget = this.entityHost.func_70638_az();
        if (this.attackTarget == null || this.entityHost.func_70032_d((Entity)this.attackTarget) > this.breathRange || !this.entityHost.func_70685_l((Entity)this.attackTarget)) {
            return false;
        }
        this.breathX = this.attackTarget.field_70165_t;
        this.breathY = this.attackTarget.field_70163_u + this.attackTarget.func_70047_e();
        this.breathZ = this.attackTarget.field_70161_v;
        return this.entityHost.func_70681_au().nextFloat() < this.attackChance;
    }
    
    public void func_75249_e() {
        this.durationLeft = this.maxDuration;
        if (this.entityHost instanceof EntityTFFireBeetle) {
            ((EntityTFFireBeetle)this.entityHost).setBreathing(true);
        }
    }
    
    public boolean func_75253_b() {
        return this.durationLeft > 0 && !this.entityHost.field_70128_L && !this.attackTarget.field_70128_L && this.entityHost.func_70032_d((Entity)this.attackTarget) <= this.breathRange && this.entityHost.func_70685_l((Entity)this.attackTarget);
    }
    
    public void func_75246_d() {
        --this.durationLeft;
        this.entityHost.func_70671_ap().func_75650_a(this.breathX, this.breathY, this.breathZ, 100.0f, 100.0f);
        this.faceVec(this.breathX, this.breathY, this.breathZ, 100.0f, 100.0f);
        if (this.maxDuration - this.durationLeft > 5) {
            final Entity target = this.getHeadLookTarget();
            if (target != null) {
                ((EntityTFFireBeetle)this.entityHost).doBreathAttack(target);
            }
        }
    }
    
    public void func_75251_c() {
        this.durationLeft = 0;
        if (this.entityHost instanceof EntityTFFireBeetle) {
            ((EntityTFFireBeetle)this.entityHost).setBreathing(false);
        }
    }
    
    private Entity getHeadLookTarget() {
        Entity pointedEntity = null;
        final double range = 30.0;
        final Vec3 srcVec = this.entityHost.field_70170_p.func_82732_R().func_72345_a(this.entityHost.field_70165_t, this.entityHost.field_70163_u + 0.25, this.entityHost.field_70161_v);
        final Vec3 lookVec = this.entityHost.func_70676_i(1.0f);
        final Vec3 destVec = srcVec.func_72441_c(lookVec.field_72450_a * range, lookVec.field_72448_b * range, lookVec.field_72449_c * range);
        final float var9 = 3.0f;
        final List possibleList = this.entityHost.field_70170_p.func_72839_b((Entity)this.entityHost, this.entityHost.field_70121_D.func_72321_a(lookVec.field_72450_a * range, lookVec.field_72448_b * range, lookVec.field_72449_c * range).func_72314_b((double)var9, (double)var9, (double)var9));
        double hitDist = 0.0;
        for (final Entity possibleEntity : possibleList) {
            if (possibleEntity.func_70067_L() && possibleEntity != this.entityHost) {
                final float borderSize = possibleEntity.func_70111_Y();
                final AxisAlignedBB collisionBB = possibleEntity.field_70121_D.func_72314_b((double)borderSize, (double)borderSize, (double)borderSize);
                final MovingObjectPosition interceptPos = collisionBB.func_72327_a(srcVec, destVec);
                if (collisionBB.func_72318_a(srcVec)) {
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
                    final double possibleDist = srcVec.func_72438_d(interceptPos.field_72307_f);
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
        final double xOffset = xCoord - this.entityHost.field_70165_t;
        final double zOffset = zCoord - this.entityHost.field_70161_v;
        final double yOffset = this.entityHost.field_70163_u + 0.25 - yCoord;
        final double distance = MathHelper.func_76133_a(xOffset * xOffset + zOffset * zOffset);
        final float xyAngle = (float)(Math.atan2(zOffset, xOffset) * 180.0 / 3.141592653589793) - 90.0f;
        final float zdAngle = (float)(-(Math.atan2(yOffset, distance) * 180.0 / 3.141592653589793));
        this.entityHost.field_70125_A = -this.updateRotation(this.entityHost.field_70125_A, zdAngle, pitchConstraint);
        this.entityHost.field_70177_z = this.updateRotation(this.entityHost.field_70177_z, xyAngle, yawConstraint);
    }
    
    private float updateRotation(final float par1, final float par2, final float par3) {
        float var4 = MathHelper.func_76142_g(par2 - par1);
        if (var4 > par3) {
            var4 = par3;
        }
        if (var4 < -par3) {
            var4 = -par3;
        }
        return par1 + var4;
    }
}
