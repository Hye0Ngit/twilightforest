// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.client.particle.TFParticleType;
import twilightforest.TwilightForestMod;
import net.minecraft.entity.IEntityLivingData;
import twilightforest.item.TFItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.world.DifficultyInstance;
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
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;

public class EntityTFSnowGuardian extends EntityTFIceMob
{
    public static final ResourceLocation LOOT_TABLE;
    
    public EntityTFSnowGuardian(final World world) {
        super(world);
        this.func_70105_a(0.6f, 1.8f);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIAttackMelee((EntityCreature)this, 1.0, false));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIWanderAvoidWater((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, true));
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.23000000417232513);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(3.0);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10.0);
    }
    
    protected SoundEvent func_184639_G() {
        return TFSounds.ICE_AMBIENT;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return TFSounds.ICE_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.ICE_DEATH;
    }
    
    protected float func_70647_i() {
        return (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f + 0.8f;
    }
    
    protected void func_180481_a(final DifficultyInstance difficulty) {
        final int type = this.field_70146_Z.nextInt(4);
        this.func_184201_a(EntityEquipmentSlot.MAINHAND, new ItemStack(this.makeItemForSlot(EntityEquipmentSlot.MAINHAND, type)));
        this.func_184201_a(EntityEquipmentSlot.CHEST, new ItemStack(this.makeItemForSlot(EntityEquipmentSlot.CHEST, type)));
        this.func_184201_a(EntityEquipmentSlot.HEAD, new ItemStack(this.makeItemForSlot(EntityEquipmentSlot.HEAD, type)));
    }
    
    private Item makeItemForSlot(final EntityEquipmentSlot slot, final int type) {
        switch (slot) {
            default: {
                switch (type) {
                    default: {
                        return TFItems.ironwood_sword;
                    }
                    case 1: {
                        return TFItems.steeleaf_sword;
                    }
                    case 2: {
                        return TFItems.knightmetal_sword;
                    }
                    case 3: {
                        return TFItems.knightmetal_sword;
                    }
                }
                break;
            }
            case FEET: {
                switch (type) {
                    default: {
                        return TFItems.ironwood_boots;
                    }
                    case 1: {
                        return TFItems.steeleaf_boots;
                    }
                    case 2: {
                        return TFItems.knightmetal_boots;
                    }
                    case 3: {
                        return TFItems.arctic_boots;
                    }
                }
                break;
            }
            case LEGS: {
                switch (type) {
                    default: {
                        return TFItems.ironwood_leggings;
                    }
                    case 1: {
                        return TFItems.steeleaf_leggings;
                    }
                    case 2: {
                        return TFItems.knightmetal_leggings;
                    }
                    case 3: {
                        return TFItems.arctic_leggings;
                    }
                }
                break;
            }
            case CHEST: {
                switch (type) {
                    default: {
                        return TFItems.ironwood_chestplate;
                    }
                    case 1: {
                        return TFItems.steeleaf_chestplate;
                    }
                    case 2: {
                        return TFItems.knightmetal_chestplate;
                    }
                    case 3: {
                        return TFItems.arctic_chestplate;
                    }
                }
                break;
            }
            case HEAD: {
                switch (type) {
                    default: {
                        return TFItems.ironwood_helmet;
                    }
                    case 1: {
                        return TFItems.steeleaf_helmet;
                    }
                    case 2: {
                        return TFItems.knightmetal_helmet;
                    }
                    case 3: {
                        return TFItems.arctic_helmet;
                    }
                }
                break;
            }
        }
    }
    
    public ResourceLocation func_184647_J() {
        return EntityTFSnowGuardian.LOOT_TABLE;
    }
    
    public IEntityLivingData func_180482_a(final DifficultyInstance difficulty, final IEntityLivingData livingData) {
        final IEntityLivingData data = super.func_180482_a(difficulty, livingData);
        this.func_180481_a(difficulty);
        this.func_180483_b(difficulty);
        return data;
    }
    
    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (this.field_70170_p.field_72995_K) {
            for (int i = 0; i < 3; ++i) {
                final float px = (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.3f;
                final float py = this.func_70047_e() + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.5f;
                final float pz = (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.3f;
                TwilightForestMod.proxy.spawnParticle(TFParticleType.SNOW_GUARDIAN, this.field_70142_S + px, this.field_70137_T + py, this.field_70136_U + pz, 0.0, 0.0, 0.0);
            }
        }
    }
    
    public int func_70641_bl() {
        return 8;
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/snow_guardian");
    }
}
