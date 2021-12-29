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
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIWander;
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
        this.field_70750_az = "/mods/twilightforest/textures/model/mosquitoswarm.png";
        this.func_70105_a(0.7f, 1.9f);
        this.field_70697_bw = 0.23f;
        this.field_70138_W = 2.1f;
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAttackOnCollide((EntityLiving)this, (Class)EntityPlayer.class, this.field_70697_bw, false));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWander((EntityCreature)this, this.field_70697_bw));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityLiving)this, true));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityLiving)this, (Class)EntityPlayer.class, 16.0f, 0, true));
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    public int func_70667_aM() {
        return 12;
    }
    
    protected String func_70639_aQ() {
        return "mob.tf.mosquito.mosquito";
    }
    
    public boolean func_70652_k(final Entity par1Entity) {
        if (super.func_70652_k(par1Entity)) {
            if (par1Entity instanceof EntityLiving) {
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
                    ((EntityLiving)par1Entity).func_70690_d(new PotionEffect(Potion.field_76438_s.field_76415_H, duration * 20, 0));
                }
            }
            return true;
        }
        return false;
    }
    
    public boolean func_70601_bi() {
        if (this.field_70170_p.func_72807_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70161_v)) == TFBiomeBase.swamp) {
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
    
    public int func_82193_c(final Entity par1Entity) {
        return 3;
    }
}
