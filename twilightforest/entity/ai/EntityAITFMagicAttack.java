// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MathHelper;
import twilightforest.entity.EntityTFSlimeProjectile;
import twilightforest.entity.EntityTFLichBolt;
import twilightforest.entity.EntityTFTomeBolt;
import twilightforest.entity.EntityTFNatureBolt;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.world.World;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAITFMagicAttack extends EntityAIBase
{
    public static final int SLIME = 4;
    public static final int LICH = 3;
    public static final int TOME = 2;
    public static final int NATURE = 1;
    World worldObj;
    EntityLiving entityHost;
    EntityLivingBase attackTarget;
    int rangedAttackTime;
    float moveSpeed;
    int ticksLookingAtTarget;
    int rangedAttackID;
    int maxRangedAttackTime;
    float attackChance;
    
    public EntityAITFMagicAttack(final EntityLiving par1EntityLiving, final float speed, final int id, final int time) {
        this(par1EntityLiving, speed, id, time, 1.0f);
    }
    
    public EntityAITFMagicAttack(final EntityLiving par1EntityLiving, final float speed, final int id, final int time, final float chance) {
        this.rangedAttackTime = 0;
        this.ticksLookingAtTarget = 0;
        this.entityHost = par1EntityLiving;
        this.worldObj = par1EntityLiving.field_70170_p;
        this.moveSpeed = speed;
        this.rangedAttackID = id;
        this.maxRangedAttackTime = time;
        this.attackChance = chance;
        this.func_75248_a(3);
    }
    
    public boolean func_75250_a() {
        final EntityLivingBase var1 = this.entityHost.func_70638_az();
        if (var1 == null || this.entityHost.func_70681_au().nextFloat() > this.attackChance) {
            return false;
        }
        this.attackTarget = var1;
        return true;
    }
    
    public boolean func_75253_b() {
        return this.func_75250_a() || !this.entityHost.func_70661_as().func_75500_f();
    }
    
    public void func_75251_c() {
        this.attackTarget = null;
    }
    
    public void func_75246_d() {
        final double maxRange = 100.0;
        final double targetDistance = this.entityHost.func_70092_e(this.attackTarget.field_70165_t, this.attackTarget.field_70121_D.field_72338_b, this.attackTarget.field_70161_v);
        final boolean canSee = this.entityHost.func_70635_at().func_75522_a((Entity)this.attackTarget);
        if (canSee) {
            ++this.ticksLookingAtTarget;
        }
        else {
            this.ticksLookingAtTarget = 0;
        }
        if (targetDistance <= maxRange && this.ticksLookingAtTarget >= 20) {
            this.entityHost.func_70661_as().func_75499_g();
        }
        else {
            this.entityHost.func_70661_as().func_75497_a((Entity)this.attackTarget, (double)this.moveSpeed);
        }
        this.entityHost.func_70671_ap().func_75651_a((Entity)this.attackTarget, 30.0f, 30.0f);
        this.rangedAttackTime = Math.max(this.rangedAttackTime - 1, 0);
        if (this.rangedAttackTime <= 0 && targetDistance <= maxRange && canSee) {
            this.doRangedAttack();
            this.rangedAttackTime = this.maxRangedAttackTime;
        }
    }
    
    protected void doRangedAttack() {
        EntityThrowable projectile = null;
        if (this.rangedAttackID == 1) {
            projectile = new EntityTFNatureBolt(this.worldObj, (EntityLivingBase)this.entityHost);
            this.worldObj.func_72956_a((Entity)this.entityHost, "mob.ghast.fireball", 1.0f, 1.0f / (this.entityHost.func_70681_au().nextFloat() * 0.4f + 0.8f));
        }
        else if (this.rangedAttackID == 2) {
            projectile = new EntityTFTomeBolt(this.worldObj, (EntityLivingBase)this.entityHost);
            this.worldObj.func_72956_a((Entity)this.entityHost, "mob.ghast.fireball", 1.0f, 1.0f / (this.entityHost.func_70681_au().nextFloat() * 0.4f + 0.8f));
        }
        else if (this.rangedAttackID == 3) {
            projectile = new EntityTFLichBolt(this.worldObj, (EntityLivingBase)this.entityHost);
            this.worldObj.func_72956_a((Entity)this.entityHost, "mob.ghast.fireball", 1.0f, 1.0f / (this.entityHost.func_70681_au().nextFloat() * 0.4f + 0.8f));
        }
        else if (this.rangedAttackID == 4) {
            projectile = new EntityTFSlimeProjectile(this.worldObj, (EntityLivingBase)this.entityHost);
            this.worldObj.func_72956_a((Entity)this.entityHost, "mob.slime.small", 1.0f, 1.0f / (this.entityHost.func_70681_au().nextFloat() * 0.4f + 0.8f));
        }
        if (projectile != null) {
            final double tx = this.attackTarget.field_70165_t - this.entityHost.field_70165_t;
            final double ty = this.attackTarget.field_70163_u + this.attackTarget.func_70047_e() - 1.100000023841858 - projectile.field_70163_u;
            final double tz = this.attackTarget.field_70161_v - this.entityHost.field_70161_v;
            final float heightOffset = MathHelper.func_76133_a(tx * tx + tz * tz) * 0.2f;
            projectile.func_70186_c(tx, ty + heightOffset, tz, 0.6f, 6.0f);
            this.worldObj.func_72838_d((Entity)projectile);
        }
    }
}
