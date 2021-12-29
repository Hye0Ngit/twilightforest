// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.entity.IEntityLivingData;
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
import net.minecraft.entity.ai.EntityAIAttackMelee;
import twilightforest.entity.ai.EntityAITFRedcapLightTNT;
import twilightforest.entity.ai.EntityAITFRedcapShy;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFRedcap extends EntityMob
{
    public static final ResourceLocation LOOT_TABLE;
    public ItemStack heldPick;
    public ItemStack heldTNT;
    public ItemStack heldFlint;
    
    public EntityTFRedcap(final World world) {
        super(world);
        this.heldPick = new ItemStack(Items.field_151035_b, 1);
        this.heldTNT = new ItemStack(Blocks.field_150335_W, 1);
        this.heldFlint = new ItemStack(Items.field_151033_d, 1);
        this.func_70105_a(0.9f, 1.4f);
    }
    
    public EntityTFRedcap(final World world, final double x, final double y, final double z) {
        this(world);
        this.func_70107_b(x, y, z);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, (Class)EntityTNTPrimed.class, 2.0f, 1.0, 2.0));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAITFRedcapShy(this, 1.0f));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITFRedcapLightTNT(this, 1.0f));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIAttackMelee((EntityCreature)this, 1.0, false));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWanderAvoidWater((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, true));
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(20.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.28);
    }
    
    protected SoundEvent func_184639_G() {
        return TFSounds.REDCAP_AMBIENT;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return TFSounds.REDCAP_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.REDCAP_DEATH;
    }
    
    public ResourceLocation func_184647_J() {
        return EntityTFRedcap.LOOT_TABLE;
    }
    
    public boolean isShy() {
        return this.field_70718_bc <= 0;
    }
    
    public IEntityLivingData func_180482_a(final DifficultyInstance difficulty, final IEntityLivingData livingdata) {
        final IEntityLivingData data = super.func_180482_a(difficulty, livingdata);
        this.func_180481_a(difficulty);
        this.func_180483_b(difficulty);
        this.func_184642_a(EntityEquipmentSlot.MAINHAND, 0.2f);
        this.func_184642_a(EntityEquipmentSlot.FEET, 0.2f);
        return data;
    }
    
    protected void func_180481_a(final DifficultyInstance difficulty) {
        this.func_184201_a(EntityEquipmentSlot.MAINHAND, this.heldPick);
        this.func_184201_a(EntityEquipmentSlot.FEET, new ItemStack((Item)Items.field_151167_ab));
    }
    
    public void func_70014_b(final NBTTagCompound compound) {
        super.func_70014_b(compound);
        compound.func_74768_a("TNTLeft", this.heldTNT.func_190916_E());
    }
    
    public void func_70037_a(final NBTTagCompound compound) {
        super.func_70037_a(compound);
        this.heldTNT.func_190920_e(compound.func_74762_e("TNTLeft"));
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/redcap");
    }
}
