// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.stats.StatBase;
import twilightforest.TFAchievementPage;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFAdherent extends EntityMob implements IRangedAttackMob, ITFCharger
{
    private static final int CHARGE_FLAG = 17;
    
    public EntityTFAdherent(final World world) {
        super(world);
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIRestrictSun((EntityCreature)this));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIFleeSun((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIArrowAttack((IRangedAttackMob)this, 1.0, 60, 10.0f));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, 0, true));
        this.func_70105_a(0.8f, 2.2f);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(17, (Object)0);
    }
    
    public boolean func_70650_aV() {
        return true;
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(20.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25);
    }
    
    public void func_70645_a(final DamageSource par1DamageSource) {
        super.func_70645_a(par1DamageSource);
        if (par1DamageSource.func_76364_f() instanceof EntityPlayer) {
            ((EntityPlayer)par1DamageSource.func_76364_f()).func_71029_a((StatBase)TFAchievementPage.twilightHunter);
        }
    }
    
    public void func_82196_d(final EntityLivingBase attackTarget, final float extraDamage) {
        final EntityTFNatureBolt natureBolt = new EntityTFNatureBolt(this.field_70170_p, (EntityLivingBase)this);
        this.field_70170_p.func_72956_a((Entity)this, "mob.ghast.fireball", 1.0f, 1.0f / (this.field_70146_Z.nextFloat() * 0.4f + 0.8f));
        natureBolt.setTarget(attackTarget);
        final double tx = attackTarget.field_70165_t - this.field_70165_t;
        final double ty = attackTarget.field_70163_u + attackTarget.func_70047_e() - 2.699999988079071 - this.field_70163_u;
        final double tz = attackTarget.field_70161_v - this.field_70161_v;
        final float heightOffset = MathHelper.func_76133_a(tx * tx + tz * tz) * 0.2f;
        natureBolt.func_70186_c(tx, ty + heightOffset, tz, 0.6f, 6.0f);
        this.field_70170_p.func_72838_d((Entity)natureBolt);
    }
    
    public boolean isCharging() {
        return this.field_70180_af.func_75683_a(17) != 0;
    }
    
    public void setCharging(final boolean flag) {
        if (flag) {
            this.field_70180_af.func_75692_b(17, (Object)127);
        }
        else {
            this.field_70180_af.func_75692_b(17, (Object)0);
        }
    }
}
