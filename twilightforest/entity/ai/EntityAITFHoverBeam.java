// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.AxisAlignedBB;
import java.util.Iterator;
import java.util.List;
import net.minecraft.util.Vec3;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.player.EntityPlayer;
import twilightforest.entity.boss.EntityTFSnowQueen;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAITFHoverBeam extends EntityAIBase
{
    private static final float HOVER_HEIGHT = 3.0f;
    private static final float HOVER_RADIUS = 4.0f;
    private Class<? extends EntityLivingBase> classTarget;
    private EntityTFSnowQueen attacker;
    private double hoverPosX;
    private double hoverPosY;
    private double hoverPosZ;
    private int hoverTimer;
    private int beamTimer;
    private int maxHoverTime;
    private int maxBeamTime;
    private int seekTimer;
    private int maxSeekTime;
    private double beamY;
    private boolean isInPosition;
    
    public EntityAITFHoverBeam(final EntityTFSnowQueen entityTFSnowQueen, final Class<EntityPlayer> class1, final int hoverTime, final int dropTime) {
        this.attacker = entityTFSnowQueen;
        this.classTarget = (Class<? extends EntityLivingBase>)class1;
        this.func_75248_a(3);
        this.maxHoverTime = hoverTime;
        this.maxSeekTime = hoverTime;
        this.maxBeamTime = dropTime;
        this.hoverTimer = 0;
        this.isInPosition = false;
    }
    
    public boolean func_75250_a() {
        final EntityLivingBase target = this.attacker.func_70638_az();
        return target != null && target.func_70089_S() && (this.classTarget == null || this.classTarget.isAssignableFrom(target.getClass())) && this.attacker.getCurrentPhase() == EntityTFSnowQueen.Phase.BEAM;
    }
    
    public boolean func_75253_b() {
        final EntityLivingBase target = this.attacker.func_70638_az();
        return target != null && target.func_70089_S() && this.attacker.getCurrentPhase() == EntityTFSnowQueen.Phase.BEAM && this.seekTimer < this.maxSeekTime && this.beamTimer < this.maxBeamTime;
    }
    
    public void func_75249_e() {
        final EntityLivingBase target = this.attacker.func_70638_az();
        if (target != null) {
            this.makeNewHoverSpot(target);
        }
    }
    
    public void func_75251_c() {
        this.seekTimer = 0;
        this.hoverTimer = 0;
        this.beamTimer = 0;
        this.isInPosition = false;
        this.attacker.setBreathing(false);
    }
    
    public void func_75246_d() {
        if (this.attacker.func_70092_e(this.hoverPosX, this.hoverPosY, this.hoverPosZ) <= 1.0) {
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
            this.attacker.setBreathing(true);
            final Entity target = this.getHeadLookTarget();
            if (target != null) {
                this.attacker.doBreathAttack(target);
            }
            this.hoverPosY -= 0.05000000074505806;
            if (this.hoverPosY < this.beamY) {
                this.hoverPosY = this.beamY;
            }
        }
        final double offsetX = this.hoverPosX - this.attacker.field_70165_t;
        final double offsetY = this.hoverPosY - this.attacker.field_70163_u;
        final double offsetZ = this.hoverPosZ - this.attacker.field_70161_v;
        double distanceDesired = offsetX * offsetX + offsetY * offsetY + offsetZ * offsetZ;
        distanceDesired = MathHelper.func_76133_a(distanceDesired);
        if (distanceDesired > 0.5) {
            final double velX = offsetX / distanceDesired * 0.05;
            double velY = offsetY / distanceDesired * 0.1;
            final double velZ = offsetZ / distanceDesired * 0.05;
            velY += 0.019999999552965164;
            this.attacker.func_70024_g(velX, velY, velZ);
        }
        final EntityLivingBase target2 = this.attacker.func_70638_az();
        if (target2 != null) {
            final float tracking = this.isInPosition ? 1.0f : 20.0f;
            this.attacker.func_70625_a((Entity)target2, tracking, tracking);
            this.attacker.func_70671_ap().func_75651_a((Entity)target2, tracking, tracking);
        }
    }
    
    private Entity getHeadLookTarget() {
        Entity pointedEntity = null;
        final double range = 30.0;
        final Vec3 srcVec = Vec3.func_72443_a(this.attacker.field_70165_t, this.attacker.field_70163_u + 0.25, this.attacker.field_70161_v);
        final Vec3 lookVec = this.attacker.func_70676_i(1.0f);
        final Vec3 destVec = srcVec.func_72441_c(lookVec.field_72450_a * range, lookVec.field_72448_b * range, lookVec.field_72449_c * range);
        final float var9 = 3.0f;
        final List<Entity> possibleList = this.attacker.field_70170_p.func_72839_b((Entity)this.attacker, this.attacker.field_70121_D.func_72321_a(lookVec.field_72450_a * range, lookVec.field_72448_b * range, lookVec.field_72449_c * range).func_72314_b((double)var9, (double)var9, (double)var9));
        double hitDist = 0.0;
        for (final Entity possibleEntity : possibleList) {
            if (possibleEntity.func_70067_L() && possibleEntity != this.attacker) {
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
    
    private void makeNewHoverSpot(final EntityLivingBase target) {
        double hx = 0.0;
        double hy = 0.0;
        double hz = 0.0;
        final int tries = 100;
        for (int i = 0; i < tries; ++i) {
            hx = target.field_70165_t + (this.attacker.func_70681_au().nextFloat() - this.attacker.func_70681_au().nextFloat()) * 4.0f;
            hy = target.field_70163_u + 3.0;
            hz = target.field_70161_v + (this.attacker.func_70681_au().nextFloat() - this.attacker.func_70681_au().nextFloat()) * 4.0f;
            if (!this.isPositionOccupied(hx, hy, hz) && this.canEntitySee((Entity)this.attacker, hx, hy, hz) && this.canEntitySee((Entity)target, hx, hy, hz)) {
                break;
            }
        }
        if (tries == 99) {}
        this.hoverPosX = hx;
        this.hoverPosY = hy;
        this.hoverPosZ = hz;
        this.beamY = target.field_70163_u;
        this.seekTimer = 0;
    }
    
    private boolean isPositionOccupied(final double hx, final double hy, final double hz) {
        final float radius = this.attacker.field_70130_N / 2.0f;
        final AxisAlignedBB aabb = AxisAlignedBB.func_72330_a(hx - radius, hy, hz - radius, hx + radius, hy + this.attacker.field_70131_O, hz + radius);
        final boolean isOccupied = this.attacker.field_70170_p.func_72945_a((Entity)this.attacker, aabb).isEmpty();
        return isOccupied;
    }
    
    protected boolean canEntitySee(final Entity entity, final double dx, final double dy, final double dz) {
        return entity.field_70170_p.func_72933_a(Vec3.func_72443_a(entity.field_70165_t, entity.field_70163_u + entity.func_70047_e(), entity.field_70161_v), Vec3.func_72443_a(dx, dy, dz)) == null;
    }
}
