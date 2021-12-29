// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.stats.StatBase;
import twilightforest.TFAchievementPage;
import net.minecraft.util.DamageSource;
import twilightforest.biomes.TFBiomeBase;
import net.minecraft.util.MathHelper;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.Potion;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFMosquitoSwarm extends EntityMob
{
    public EntityTFMosquitoSwarm(final World par1World) {
        super(par1World);
        this.func_70105_a(0.7f, 1.9f);
        this.field_70138_W = 2.1f;
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityPlayer.class, 1.0, false));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, 0, true));
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(12.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.23);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(3.0);
    }
    
    protected String func_70639_aQ() {
        return "TwilightForest:mob.mosquito.mosquito";
    }
    
    public boolean func_70652_k(final Entity par1Entity) {
        if (super.func_70652_k(par1Entity)) {
            if (par1Entity instanceof EntityLivingBase) {
                byte duration = 7;
                if (this.field_70170_p.field_73013_u > 1) {
                    if (this.field_70170_p.field_73013_u == 2) {
                        duration = 15;
                    }
                    else if (this.field_70170_p.field_73013_u == 3) {
                        duration = 30;
                    }
                }
                if (duration > 0) {
                    ((EntityLivingBase)par1Entity).func_70690_d(new PotionEffect(Potion.field_76438_s.field_76415_H, duration * 20, 0));
                }
            }
            return true;
        }
        return false;
    }
    
    public boolean func_70601_bi() {
        if (this.field_70170_p.func_72807_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70161_v)) == TFBiomeBase.tfSwamp) {
            return this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a((Entity)this, this.field_70121_D).size() == 0;
        }
        return super.func_70601_bi();
    }
    
    public int func_70641_bl() {
        return 1;
    }
    
    public void func_70645_a(final DamageSource par1DamageSource) {
        super.func_70645_a(par1DamageSource);
        if (par1DamageSource.func_76364_f() instanceof EntityPlayer) {
            ((EntityPlayer)par1DamageSource.func_76364_f()).func_71029_a((StatBase)TFAchievementPage.twilightHunter);
        }
    }
}
