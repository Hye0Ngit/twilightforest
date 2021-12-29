// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TwilightForestMod;
import twilightforest.biomes.TFBiomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFMosquitoSwarm extends EntityMob
{
    public static final ResourceLocation LOOT_TABLE;
    
    public EntityTFMosquitoSwarm(final World world) {
        super(world);
        this.func_70105_a(0.7f, 1.9f);
        this.field_70138_W = 2.1f;
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAttackMelee((EntityCreature)this, 1.0, false));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWanderAvoidWater((EntityCreature)this, 1.0));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, true));
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(12.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.23);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(3.0);
    }
    
    protected SoundEvent func_184639_G() {
        return TFSounds.MOSQUITO;
    }
    
    public boolean func_70652_k(final Entity entity) {
        if (super.func_70652_k(entity)) {
            if (entity instanceof EntityLivingBase) {
                int duration = 0;
                switch (this.field_70170_p.func_175659_aa()) {
                    case EASY: {
                        duration = 7;
                        break;
                    }
                    default: {
                        duration = 15;
                        break;
                    }
                    case HARD: {
                        duration = 30;
                        break;
                    }
                }
                ((EntityLivingBase)entity).func_70690_d(new PotionEffect(MobEffects.field_76438_s, duration * 20, 0));
            }
            return true;
        }
        return false;
    }
    
    public boolean func_70601_bi() {
        if (this.field_70170_p.func_180494_b(new BlockPos((Entity)this)) == TFBiomes.tfSwamp) {
            return this.field_70170_p.func_72855_b(this.func_174813_aQ()) && this.field_70170_p.func_184144_a((Entity)this, this.func_174813_aQ()).size() == 0;
        }
        return super.func_70601_bi();
    }
    
    public int func_70641_bl() {
        return 1;
    }
    
    protected ResourceLocation func_184647_J() {
        return EntityTFMosquitoSwarm.LOOT_TABLE;
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/mosquito_swarm");
    }
}
