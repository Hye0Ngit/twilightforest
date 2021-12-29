// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.util.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.EntityCreature;
import twilightforest.entity.ai.EntityAITFChargeAttack;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFBoggard extends EntityMob
{
    public static final ResourceLocation LOOT_TABLE;
    
    public EntityTFBoggard(final World world) {
        super(world);
        this.func_70105_a(0.8f, 1.1f);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAITFChargeAttack((EntityCreature)this, 2.0f, false));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAttackMelee((EntityCreature)this, 1.0, false));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWanderAvoidWater((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, false));
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(14.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.28);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(3.0);
    }
    
    protected SoundEvent func_184639_G() {
        return TFSounds.REDCAP_AMBIENT;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return TFSounds.REDCAP_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.REDCAP_AMBIENT;
    }
    
    public ResourceLocation func_184647_J() {
        return EntityTFBoggard.LOOT_TABLE;
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/boggard");
    }
}
