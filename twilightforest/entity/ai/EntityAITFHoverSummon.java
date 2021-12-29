// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import twilightforest.entity.boss.EntityTFSnowQueen;

public class EntityAITFHoverSummon extends EntityAITFHoverBase<EntityTFSnowQueen>
{
    private static final int MAX_MINIONS_AT_ONCE = 4;
    private int seekTimer;
    private final int maxSeekTime;
    
    public EntityAITFHoverSummon(final EntityTFSnowQueen snowQueen, final double speed) {
        super((EntityLiving)snowQueen, 6.0f, 6.0f);
        this.func_75248_a(3);
        this.maxSeekTime = 80;
    }
    
    public boolean func_75250_a() {
        final EntityLivingBase target = ((EntityTFSnowQueen)this.attacker).func_70638_az();
        return target != null && target.func_70089_S() && ((EntityTFSnowQueen)this.attacker).getCurrentPhase() == EntityTFSnowQueen.Phase.SUMMON && ((EntityTFSnowQueen)this.attacker).func_70635_at().func_75522_a((Entity)target);
    }
    
    public boolean func_75253_b() {
        final EntityLivingBase target = ((EntityTFSnowQueen)this.attacker).func_70638_az();
        return target != null && target.func_70089_S() && ((EntityTFSnowQueen)this.attacker).getCurrentPhase() == EntityTFSnowQueen.Phase.SUMMON && this.seekTimer <= this.maxSeekTime && this.canEntitySee((Entity)this.attacker, this.hoverPosX, this.hoverPosY, this.hoverPosZ);
    }
    
    public void func_75251_c() {
    }
    
    public void func_75246_d() {
        ++this.seekTimer;
        final EntityLivingBase target = ((EntityTFSnowQueen)this.attacker).func_70638_az();
        if (((EntityTFSnowQueen)this.attacker).func_70092_e(this.hoverPosX, this.hoverPosY, this.hoverPosZ) <= 1.0) {
            this.checkAndSummon();
            this.makeNewHoverSpot(target);
        }
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
        if (target != null) {
            ((EntityTFSnowQueen)this.attacker).func_70625_a((Entity)target, 30.0f, 30.0f);
            ((EntityTFSnowQueen)this.attacker).func_70671_ap().func_75651_a((Entity)target, 30.0f, 30.0f);
        }
    }
    
    @Override
    protected void makeNewHoverSpot(final EntityLivingBase target) {
        super.makeNewHoverSpot(target);
        this.seekTimer = 0;
    }
    
    private void checkAndSummon() {
        if (((EntityTFSnowQueen)this.attacker).getSummonsRemaining() > 0 && ((EntityTFSnowQueen)this.attacker).countMyMinions() < 4) {
            ((EntityTFSnowQueen)this.attacker).summonMinionAt(((EntityTFSnowQueen)this.attacker).func_70638_az());
        }
    }
}
