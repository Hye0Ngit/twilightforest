// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLiving;
import twilightforest.entity.boss.EntityTFSnowQueen;

public class EntityAITFHoverThenDrop extends EntityAITFHoverBase<EntityTFSnowQueen>
{
    private int hoverTimer;
    private int dropTimer;
    private int seekTimer;
    private final int maxHoverTime;
    private final int maxDropTime;
    private final int maxSeekTime;
    private double dropY;
    
    public EntityAITFHoverThenDrop(final EntityTFSnowQueen snowQueen, final int hoverTime, final int dropTime) {
        super((EntityLiving)snowQueen, 6.0f, 0.0f);
        this.func_75248_a(3);
        this.maxHoverTime = hoverTime;
        this.maxSeekTime = hoverTime;
        this.maxDropTime = dropTime;
        this.hoverTimer = 0;
    }
    
    public boolean func_75250_a() {
        final EntityLivingBase target = ((EntityTFSnowQueen)this.attacker).func_70638_az();
        return target != null && target.func_70089_S() && ((EntityTFSnowQueen)this.attacker).getCurrentPhase() == EntityTFSnowQueen.Phase.DROP;
    }
    
    public boolean func_75253_b() {
        final EntityLivingBase target = ((EntityTFSnowQueen)this.attacker).func_70638_az();
        if (target == null || !target.func_70089_S()) {
            return false;
        }
        if (((EntityTFSnowQueen)this.attacker).getCurrentPhase() != EntityTFSnowQueen.Phase.DROP) {
            return false;
        }
        if (this.seekTimer > this.maxSeekTime) {
            return false;
        }
        if (((EntityTFSnowQueen)this.attacker).func_70092_e(this.hoverPosX, this.hoverPosY, this.hoverPosZ) <= 1.0) {
            ++this.hoverTimer;
            return true;
        }
        if (this.dropTimer < this.maxDropTime) {
            return true;
        }
        ((EntityTFSnowQueen)this.attacker).incrementSuccessfulDrops();
        return false;
    }
    
    public void func_75251_c() {
        this.hoverTimer = 0;
        this.dropTimer = 0;
    }
    
    public void func_75246_d() {
        if (this.hoverTimer > 0) {
            ++this.hoverTimer;
        }
        else {
            ++this.seekTimer;
        }
        if (this.hoverTimer < this.maxHoverTime) {
            final double offsetX = this.hoverPosX - ((EntityTFSnowQueen)this.attacker).field_70165_t;
            final double offsetY = this.hoverPosY - ((EntityTFSnowQueen)this.attacker).field_70163_u;
            final double offsetZ = this.hoverPosZ - ((EntityTFSnowQueen)this.attacker).field_70161_v;
            double distanceDesired = offsetX * offsetX + offsetY * offsetY + offsetZ * offsetZ;
            distanceDesired = MathHelper.func_76133_a(distanceDesired);
            final double velX = offsetX / distanceDesired * 0.05;
            double velY = offsetY / distanceDesired * 0.1;
            final double velZ = offsetZ / distanceDesired * 0.05;
            velY += 0.05000000074505806;
            ((EntityTFSnowQueen)this.attacker).func_70024_g(velX, velY, velZ);
            final EntityLivingBase target = ((EntityTFSnowQueen)this.attacker).func_70638_az();
            if (target != null) {
                ((EntityTFSnowQueen)this.attacker).func_70625_a((Entity)target, 30.0f, 30.0f);
                ((EntityTFSnowQueen)this.attacker).func_70671_ap().func_75651_a((Entity)target, 30.0f, 30.0f);
            }
        }
        else {
            ++this.dropTimer;
            if (((EntityTFSnowQueen)this.attacker).field_70163_u > this.dropY) {
                ((EntityTFSnowQueen)this.attacker).destroyBlocksInAABB(((EntityTFSnowQueen)this.attacker).func_174813_aQ().func_72314_b(1.0, 0.5, 1.0));
            }
        }
    }
    
    @Override
    protected void makeNewHoverSpot(final EntityLivingBase target) {
        super.makeNewHoverSpot(target);
        this.dropY = target.field_70163_u - 1.0;
        this.seekTimer = 0;
    }
}
