// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import twilightforest.TFSounds;
import net.minecraft.entity.LivingEntity;
import twilightforest.util.TFDamageSources;
import net.minecraft.entity.Entity;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import twilightforest.item.TFItems;
import net.minecraft.util.IItemProvider;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.nbt.CompoundNBT;
import javax.annotation.Nullable;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.CreatureEntity;
import twilightforest.entity.ai.ChargeAttackGoal;
import twilightforest.entity.boss.MinoshroomEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.entity.monster.MonsterEntity;

public class MinotaurEntity extends MonsterEntity implements ITFCharger
{
    private static final DataParameter<Boolean> CHARGING;
    
    public MinotaurEntity(final EntityType<? extends MinotaurEntity> type, final World world) {
        super((EntityType)type, world);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (Goal)new SwimGoal((MobEntity)this));
        this.field_70714_bg.func_75776_a(2, (Goal)new ChargeAttackGoal((CreatureEntity)this, 1.5f, this instanceof MinoshroomEntity));
        this.field_70714_bg.func_75776_a(3, (Goal)new MeleeAttackGoal((CreatureEntity)this, 1.0, false));
        this.field_70714_bg.func_75776_a(6, (Goal)new WaterAvoidingRandomWalkingGoal((CreatureEntity)this, 1.0));
        this.field_70714_bg.func_75776_a(7, (Goal)new LookAtGoal((MobEntity)this, (Class)PlayerEntity.class, 8.0f));
        this.field_70714_bg.func_75776_a(7, (Goal)new LookRandomlyGoal((MobEntity)this));
        this.field_70715_bh.func_75776_a(1, (Goal)new HurtByTargetGoal((CreatureEntity)this, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (Goal)new NearestAttackableTargetGoal((MobEntity)this, (Class)PlayerEntity.class, false));
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MonsterEntity.func_234295_eP_().func_233815_a_(Attributes.field_233818_a_, 30.0).func_233815_a_(Attributes.field_233821_d_, 0.25);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)MinotaurEntity.CHARGING, (Object)false);
    }
    
    @Nullable
    public ILivingEntityData func_213386_a(final IServerWorld worldIn, final DifficultyInstance difficulty, final SpawnReason reason, @Nullable final ILivingEntityData livingdata, @Nullable final CompoundNBT dataTag) {
        final ILivingEntityData data = super.func_213386_a(worldIn, difficulty, reason, livingdata, dataTag);
        this.func_180481_a(difficulty);
        this.func_180483_b(difficulty);
        return data;
    }
    
    protected void func_180481_a(final DifficultyInstance difficulty) {
        final int random = this.field_70146_Z.nextInt(10);
        final float additionalDiff = difficulty.func_180168_b() + 1.0f;
        final int result = (int)(random / additionalDiff);
        if (result == 0) {
            this.func_184201_a(EquipmentSlotType.MAINHAND, new ItemStack((IItemProvider)TFItems.minotaur_axe_gold.get()));
        }
        else {
            this.func_184201_a(EquipmentSlotType.MAINHAND, new ItemStack((IItemProvider)Items.field_151006_E));
        }
    }
    
    public boolean isCharging() {
        return (boolean)this.field_70180_af.func_187225_a((DataParameter)MinotaurEntity.CHARGING);
    }
    
    public void setCharging(final boolean flag) {
        this.field_70180_af.func_187227_b((DataParameter)MinotaurEntity.CHARGING, (Object)flag);
    }
    
    public boolean func_70652_k(final Entity entity) {
        entity.func_70097_a(TFDamageSources.AXING((LivingEntity)this), (float)this.func_233637_b_(Attributes.field_233823_f_));
        final boolean success = super.func_70652_k(entity);
        if (success && this.isCharging()) {
            entity.func_70097_a(TFDamageSources.AXING((LivingEntity)this), (float)this.func_233637_b_(Attributes.field_233823_f_));
            entity.func_70024_g(0.0, 0.4, 0.0);
            this.func_184185_a(TFSounds.MINOTAUR_ATTACK, 1.0f, 1.0f);
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
        return TFSounds.MINOTAUR_AMBIENT;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return TFSounds.MINOTAUR_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.MINOTAUR_DEATH;
    }
    
    protected void func_180429_a(final BlockPos pos, final BlockState block) {
        this.func_184185_a(TFSounds.MINOTAUR_STEP, 0.15f, 0.8f);
    }
    
    protected float func_70647_i() {
        return (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f + 0.7f;
    }
    
    static {
        CHARGING = EntityDataManager.func_187226_a((Class)MinotaurEntity.class, DataSerializers.field_187198_h);
    }
}
