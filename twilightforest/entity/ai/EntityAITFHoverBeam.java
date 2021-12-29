// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.AxisAlignedBB;
import java.util.Iterator;
import java.util.List;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLiving;
import twilightforest.entity.boss.EntityTFSnowQueen;

public class EntityAITFHoverBeam extends EntityAITFHoverBase<EntityTFSnowQueen>
{
    private int hoverTimer;
    private int beamTimer;
    private int seekTimer;
    private final int maxHoverTime;
    private final int maxBeamTime;
    private final int maxSeekTime;
    private double beamY;
    private boolean isInPosition;
    
    public EntityAITFHoverBeam(final EntityTFSnowQueen snowQueen, final int hoverTime, final int dropTime) {
        super((EntityLiving)snowQueen, 3.0f, 4.0f);
        this.func_75248_a(3);
        this.maxHoverTime = hoverTime;
        this.maxSeekTime = hoverTime;
        this.maxBeamTime = dropTime;
        this.hoverTimer = 0;
        this.isInPosition = false;
    }
    
    public boolean func_75250_a() {
        final EntityLivingBase target = ((EntityTFSnowQueen)this.attacker).func_70638_az();
        return target != null && target.func_70089_S() && ((EntityTFSnowQueen)this.attacker).getCurrentPhase() == EntityTFSnowQueen.Phase.BEAM;
    }
    
    public boolean func_75253_b() {
        final EntityLivingBase target = ((EntityTFSnowQueen)this.attacker).func_70638_az();
        return target != null && target.func_70089_S() && ((EntityTFSnowQueen)this.attacker).getCurrentPhase() == EntityTFSnowQueen.Phase.BEAM && this.seekTimer < this.maxSeekTime && this.beamTimer < this.maxBeamTime;
    }
    
    public void func_75251_c() {
        this.seekTimer = 0;
        this.hoverTimer = 0;
        this.beamTimer = 0;
        this.isInPosition = false;
        ((EntityTFSnowQueen)this.attacker).setBreathing(false);
    }
    
    public void func_75246_d() {
        if (((EntityTFSnowQueen)this.attacker).func_70092_e(this.hoverPosX, this.hoverPosY, this.hoverPosZ) <= 1.0) {
            this.isInPosition = true;
        }
        if (this.isInPosition) {
            ++this.hoverTimer;
        }
        else {
            ++this.seekTimer;
        }
        if (this.hoverTimer >= this.maxHoverTime) {
            ++this.beamTimer;
            ((EntityTFSnowQueen)this.attacker).setBreathing(true);
            this.doRayAttack();
            this.hoverPosY -= 0.05000000074505806;
            if (this.hoverPosY < this.beamY) {
                this.hoverPosY = this.beamY;
            }
        }
        final double offsetX = this.hoverPosX - ((EntityTFSnowQueen)this.attacker).field_70165_t;
        final double offsetY = this.hoverPosY - ((EntityTFSnowQueen)this.attacker).field_70163_u;
        final double offsetZ = this.hoverPosZ - ((EntityTFSnowQueen)this.attacker).field_70161_v;
        double distanceDesired = offsetX * offsetX + offsetY * offsetY + offsetZ * offsetZ;
        distanceDesired = MathHelper.func_76133_a(distanceDesired);
        if (distanceDesired > 0.5) {
            final double velX = offsetX / distanceDesired * 0.05;
            double velY = offsetY / distanceDesired * 0.1;
            final double velZ = offsetZ / distanceDesired * 0.05;
            velY += 0.019999999552965164;
            ((EntityTFSnowQueen)this.attacker).func_70024_g(velX, velY, velZ);
        }
        final EntityLivingBase target = ((EntityTFSnowQueen)this.attacker).func_70638_az();
        if (target != null) {
            final float tracking = this.isInPosition ? 1.0f : 20.0f;
            ((EntityTFSnowQueen)this.attacker).func_70625_a((Entity)target, tracking, tracking);
            ((EntityTFSnowQueen)this.attacker).func_70671_ap().func_75651_a((Entity)target, tracking, tracking);
        }
    }
    
    private void doRayAttack() {
        final double range = 20.0;
        final double offset = 10.0;
        final Vec3d srcVec = new Vec3d(((EntityTFSnowQueen)this.attacker).field_70165_t, ((EntityTFSnowQueen)this.attacker).field_70163_u + 0.25, ((EntityTFSnowQueen)this.attacker).field_70161_v);
        final Vec3d lookVec = ((EntityTFSnowQueen)this.attacker).func_70676_i(1.0f);
        final Vec3d destVec = srcVec.func_72441_c(lookVec.field_72450_a * range, lookVec.field_72448_b * range, lookVec.field_72449_c * range);
        final List<Entity> possibleList = ((EntityTFSnowQueen)this.attacker).field_70170_p.func_72839_b((Entity)this.attacker, ((EntityTFSnowQueen)this.attacker).func_174813_aQ().func_72317_d(lookVec.field_72450_a * offset, lookVec.field_72448_b * offset, lookVec.field_72449_c * offset).func_72314_b(range, range, range));
        double hitDist = 0.0;
        for (final Entity possibleEntity : possibleList) {
            if (possibleEntity.func_70067_L() && possibleEntity != this.attacker) {
                final float borderSize = possibleEntity.func_70111_Y();
                final AxisAlignedBB collisionBB = possibleEntity.func_174813_aQ().func_72314_b((double)borderSize, (double)borderSize, (double)borderSize);
                final RayTraceResult interceptPos = collisionBB.func_72327_a(srcVec, destVec);
                if (collisionBB.func_72318_a(srcVec)) {
                    if (0.0 >= hitDist && hitDist != 0.0) {
                        continue;
                    }
                    ((EntityTFSnowQueen)this.attacker).doBreathAttack(possibleEntity);
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
                    ((EntityTFSnowQueen)this.attacker).doBreathAttack(possibleEntity);
                    hitDist = possibleDist;
                }
            }
        }
    }
    
    @Override
    protected void makeNewHoverSpot(final EntityLivingBase target) {
        super.makeNewHoverSpot(target);
        this.beamY = target.field_70163_u;
        this.seekTimer = 0;
    }
}
