// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import twilightforest.TwilightForestMod;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.init.SoundEvents;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import twilightforest.item.TFItems;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.world.DifficultyInstance;
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
import twilightforest.entity.boss.EntityTFMinoshroom;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFMinotaur extends EntityMob implements ITFCharger
{
    public static final ResourceLocation LOOT_TABLE;
    private static final DataParameter<Boolean> CHARGING;
    
    public EntityTFMinotaur(final World world) {
        super(world);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAITFChargeAttack((EntityCreature)this, 2.0f, this instanceof EntityTFMinoshroom));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAttackMelee((EntityCreature)this, 1.0, false));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWanderAvoidWater((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, false));
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(30.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)EntityTFMinotaur.CHARGING, (Object)false);
    }
    
    public IEntityLivingData func_180482_a(final DifficultyInstance difficulty, final IEntityLivingData livingdata) {
        final IEntityLivingData data = super.func_180482_a(difficulty, livingdata);
        this.func_180481_a(difficulty);
        this.func_180483_b(difficulty);
        return data;
    }
    
    protected void func_180481_a(final DifficultyInstance difficulty) {
        final int random = this.field_70146_Z.nextInt(10);
        final float additionalDiff = difficulty.func_180168_b() + 1.0f;
        final int result = (int)(random / additionalDiff);
        if (result == 0) {
            this.func_184201_a(EntityEquipmentSlot.MAINHAND, new ItemStack(TFItems.minotaur_axe_gold));
        }
        else {
            this.func_184201_a(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.field_151006_E));
        }
    }
    
    public boolean isCharging() {
        return (boolean)this.field_70180_af.func_187225_a((DataParameter)EntityTFMinotaur.CHARGING);
    }
    
    public void setCharging(final boolean flag) {
        this.field_70180_af.func_187227_b((DataParameter)EntityTFMinotaur.CHARGING, (Object)flag);
    }
    
    public boolean func_70652_k(final Entity entity) {
        final boolean success = super.func_70652_k(entity);
        if (success && this.isCharging()) {
            entity.field_70181_x += 0.4;
            this.func_184185_a(SoundEvents.field_187596_cD, 1.0f, 1.0f);
        }
        return success;
    }
    
    public void func_70636_d() {
        super.func_70636_d();
        if (this.isCharging()) {
            this.field_70721_aZ += (float)0.6;
        }
    }
    
    protected SoundEvent func_184639_G() {
        return SoundEvents.field_187558_ak;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return SoundEvents.field_187562_am;
    }
    
    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187560_al;
    }
    
    protected void func_180429_a(final BlockPos pos, final Block block) {
        this.func_184185_a(SoundEvents.field_187566_ao, 0.15f, 0.8f);
    }
    
    protected float func_70647_i() {
        return (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f + 0.7f;
    }
    
    public ResourceLocation func_184647_J() {
        return EntityTFMinotaur.LOOT_TABLE;
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/minotaur");
        CHARGING = EntityDataManager.func_187226_a((Class)EntityTFMinotaur.class, DataSerializers.field_187198_h);
    }
}
