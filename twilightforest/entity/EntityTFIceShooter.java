// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.stats.StatBase;
import twilightforest.TFAchievementPage;
import net.minecraft.util.DamageSource;
import twilightforest.TwilightForestMod;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFIceShooter extends EntityMob implements IRangedAttackMob
{
    public EntityTFIceShooter(final World par1World) {
        super(par1World);
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIArrowAttack((IRangedAttackMob)this, 1.25, 20, 10.0f));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, 0, true));
        this.func_70105_a(0.8f, 1.8f);
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.23000000417232513);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(3.0);
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    public float func_70047_e() {
        return this.field_70131_O * 0.6f;
    }
    
    protected Item func_146068_u() {
        return Items.field_151126_ay;
    }
    
    public void func_70636_d() {
        super.func_70636_d();
        for (int i = 0; i < 3; ++i) {
            final float px = (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.3f;
            final float py = this.func_70047_e() + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.5f;
            final float pz = (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.3f;
            TwilightForestMod.proxy.spawnParticle(this.field_70170_p, "snowguardian", this.field_70142_S + px, this.field_70137_T + py, this.field_70136_U + pz, 0.0, 0.0, 0.0);
        }
    }
    
    protected String func_70639_aQ() {
        return "TwilightForest:mob.ice.noise";
    }
    
    protected String func_70621_aR() {
        return "TwilightForest:mob.ice.hurt";
    }
    
    protected String func_70673_aS() {
        return "TwilightForest:mob.ice.death";
    }
    
    public void func_70645_a(final DamageSource par1DamageSource) {
        super.func_70645_a(par1DamageSource);
        if (par1DamageSource.func_76364_f() instanceof EntityPlayer) {
            ((EntityPlayer)par1DamageSource.func_76364_f()).func_71029_a((StatBase)TFAchievementPage.twilightHunter);
        }
    }
    
    public int func_70641_bl() {
        return 8;
    }
    
    public void func_82196_d(final EntityLivingBase par1EntityLivingBase, final float par2) {
        final EntityTFIceSnowball entitysnowball = new EntityTFIceSnowball(this.field_70170_p, (EntityLivingBase)this);
        final double d0 = par1EntityLivingBase.field_70165_t - this.field_70165_t;
        final double d2 = par1EntityLivingBase.field_70163_u + par1EntityLivingBase.func_70047_e() - 1.100000023841858 - entitysnowball.field_70163_u;
        final double d3 = par1EntityLivingBase.field_70161_v - this.field_70161_v;
        final float f1 = MathHelper.func_76133_a(d0 * d0 + d3 * d3) * 0.2f;
        entitysnowball.func_70186_c(d0, d2 + f1, d3, 0.6f, 12.0f);
        this.func_85030_a("random.bow", 1.0f, 1.0f / (this.func_70681_au().nextFloat() * 0.4f + 0.8f));
        this.field_70170_p.func_72838_d((Entity)entitysnowball);
    }
}
