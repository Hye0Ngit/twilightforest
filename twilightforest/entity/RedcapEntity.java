// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.nbt.CompoundNBT;
import javax.annotation.Nullable;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.util.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import twilightforest.entity.ai.RedcapLightTNTGoal;
import twilightforest.entity.ai.RedcapShyGoal;
import net.minecraft.entity.CreatureEntity;
import twilightforest.entity.ai.AvoidAnyEntityGoal;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.block.Blocks;
import net.minecraft.util.IItemProvider;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.monster.MonsterEntity;

public class RedcapEntity extends MonsterEntity
{
    public ItemStack heldPick;
    public ItemStack heldTNT;
    public ItemStack heldFlint;
    
    public RedcapEntity(final EntityType<? extends RedcapEntity> type, final World world) {
        super((EntityType)type, world);
        this.heldPick = new ItemStack((IItemProvider)Items.field_151035_b);
        this.heldTNT = new ItemStack((IItemProvider)Blocks.field_150335_W);
        this.heldFlint = new ItemStack((IItemProvider)Items.field_151033_d);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (Goal)new SwimGoal((MobEntity)this));
        this.field_70714_bg.func_75776_a(1, (Goal)new AvoidAnyEntityGoal<Object>((CreatureEntity)this, TNTEntity.class, 2.0f, 1.0, 2.0));
        this.field_70714_bg.func_75776_a(2, (Goal)new RedcapShyGoal(this, 1.0f));
        this.field_70714_bg.func_75776_a(3, (Goal)new RedcapLightTNTGoal(this, 1.0f));
        this.field_70714_bg.func_75776_a(5, (Goal)new MeleeAttackGoal((CreatureEntity)this, 1.0, false));
        this.field_70714_bg.func_75776_a(6, (Goal)new WaterAvoidingRandomWalkingGoal((CreatureEntity)this, 1.0));
        this.field_70714_bg.func_75776_a(7, (Goal)new LookAtGoal((MobEntity)this, (Class)PlayerEntity.class, 8.0f));
        this.field_70714_bg.func_75776_a(7, (Goal)new LookRandomlyGoal((MobEntity)this));
        this.field_70715_bh.func_75776_a(1, (Goal)new HurtByTargetGoal((CreatureEntity)this, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (Goal)new NearestAttackableTargetGoal((MobEntity)this, (Class)PlayerEntity.class, true));
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MonsterEntity.func_234295_eP_().func_233815_a_(Attributes.field_233818_a_, 20.0).func_233815_a_(Attributes.field_233821_d_, 0.28);
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
    
    public boolean isShy() {
        return this.field_70718_bc <= 0;
    }
    
    @Nullable
    public ILivingEntityData func_213386_a(final IServerWorld worldIn, final DifficultyInstance difficulty, final SpawnReason reason, @Nullable final ILivingEntityData spawnDataIn, @Nullable final CompoundNBT dataTag) {
        final ILivingEntityData data = super.func_213386_a(worldIn, difficulty, reason, spawnDataIn, dataTag);
        this.func_180481_a(difficulty);
        this.func_180483_b(difficulty);
        this.func_184642_a(EquipmentSlotType.MAINHAND, 0.2f);
        this.func_184642_a(EquipmentSlotType.FEET, 0.2f);
        return data;
    }
    
    protected void func_180481_a(final DifficultyInstance difficulty) {
        this.func_184201_a(EquipmentSlotType.MAINHAND, this.heldPick);
        this.func_184201_a(EquipmentSlotType.FEET, new ItemStack((IItemProvider)Items.field_151167_ab));
    }
    
    public void func_213281_b(final CompoundNBT compound) {
        super.func_213281_b(compound);
        compound.func_74768_a("TNTLeft", this.heldTNT.func_190916_E());
    }
    
    public void func_70037_a(final CompoundNBT compound) {
        super.func_70037_a(compound);
        this.heldTNT.func_190920_e(compound.func_74762_e("TNTLeft"));
    }
}
