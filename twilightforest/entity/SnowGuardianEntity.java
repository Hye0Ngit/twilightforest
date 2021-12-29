// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.client.particle.TFParticleType;
import net.minecraft.particles.IParticleData;
import net.minecraft.nbt.CompoundNBT;
import javax.annotation.Nullable;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.world.IServerWorld;
import twilightforest.item.TFItems;
import net.minecraft.item.Item;
import net.minecraft.util.IItemProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.util.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;

public class SnowGuardianEntity extends IceMobEntity
{
    public SnowGuardianEntity(final EntityType<? extends SnowGuardianEntity> type, final World world) {
        super(type, world);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (Goal)new SwimGoal((MobEntity)this));
        this.field_70714_bg.func_75776_a(1, (Goal)new MeleeAttackGoal((CreatureEntity)this, 1.0, false));
        this.field_70714_bg.func_75776_a(2, (Goal)new WaterAvoidingRandomWalkingGoal((CreatureEntity)this, 1.0));
        this.field_70714_bg.func_75776_a(3, (Goal)new LookAtGoal((MobEntity)this, (Class)PlayerEntity.class, 8.0f));
        this.field_70714_bg.func_75776_a(3, (Goal)new LookRandomlyGoal((MobEntity)this));
        this.field_70715_bh.func_75776_a(1, (Goal)new HurtByTargetGoal((CreatureEntity)this, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (Goal)new NearestAttackableTargetGoal((MobEntity)this, (Class)PlayerEntity.class, true));
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MonsterEntity.func_234295_eP_().func_233815_a_(Attributes.field_233821_d_, 0.23000000417232513).func_233815_a_(Attributes.field_233823_f_, 3.0).func_233815_a_(Attributes.field_233818_a_, 10.0);
    }
    
    protected SoundEvent func_184639_G() {
        return TFSounds.ICE_GUARDIAN_AMBIENT;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return TFSounds.ICE_GUARDIAN_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.ICE_GUARDIAN_DEATH;
    }
    
    protected float func_70647_i() {
        return (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f + 0.8f;
    }
    
    protected void func_180481_a(final DifficultyInstance difficulty) {
        final int type = this.field_70146_Z.nextInt(4);
        this.func_184201_a(EquipmentSlotType.MAINHAND, new ItemStack((IItemProvider)this.makeItemForSlot(EquipmentSlotType.MAINHAND, type)));
        this.func_184201_a(EquipmentSlotType.CHEST, new ItemStack((IItemProvider)this.makeItemForSlot(EquipmentSlotType.CHEST, type)));
        this.func_184201_a(EquipmentSlotType.HEAD, new ItemStack((IItemProvider)this.makeItemForSlot(EquipmentSlotType.HEAD, type)));
    }
    
    private Item makeItemForSlot(final EquipmentSlotType slot, final int type) {
        switch (slot) {
            default: {
                switch (type) {
                    default: {
                        return (Item)TFItems.ironwood_sword.get();
                    }
                    case 1: {
                        return (Item)TFItems.steeleaf_sword.get();
                    }
                    case 2:
                    case 3: {
                        return (Item)TFItems.knightmetal_sword.get();
                    }
                }
                break;
            }
            case FEET: {
                switch (type) {
                    default: {
                        return (Item)TFItems.ironwood_boots.get();
                    }
                    case 1: {
                        return (Item)TFItems.steeleaf_boots.get();
                    }
                    case 2: {
                        return (Item)TFItems.knightmetal_boots.get();
                    }
                    case 3: {
                        return (Item)TFItems.arctic_boots.get();
                    }
                }
                break;
            }
            case LEGS: {
                switch (type) {
                    default: {
                        return (Item)TFItems.ironwood_leggings.get();
                    }
                    case 1: {
                        return (Item)TFItems.steeleaf_leggings.get();
                    }
                    case 2: {
                        return (Item)TFItems.knightmetal_leggings.get();
                    }
                    case 3: {
                        return (Item)TFItems.arctic_leggings.get();
                    }
                }
                break;
            }
            case CHEST: {
                switch (type) {
                    default: {
                        return (Item)TFItems.ironwood_chestplate.get();
                    }
                    case 1: {
                        return (Item)TFItems.steeleaf_chestplate.get();
                    }
                    case 2: {
                        return (Item)TFItems.knightmetal_chestplate.get();
                    }
                    case 3: {
                        return (Item)TFItems.arctic_chestplate.get();
                    }
                }
                break;
            }
            case HEAD: {
                switch (type) {
                    default: {
                        return (Item)TFItems.ironwood_helmet.get();
                    }
                    case 1: {
                        return (Item)TFItems.steeleaf_helmet.get();
                    }
                    case 2: {
                        return (Item)TFItems.knightmetal_helmet.get();
                    }
                    case 3: {
                        return (Item)TFItems.arctic_helmet.get();
                    }
                }
                break;
            }
        }
    }
    
    @Nullable
    public ILivingEntityData func_213386_a(final IServerWorld worldIn, final DifficultyInstance difficulty, final SpawnReason reason, @Nullable final ILivingEntityData spawnDataIn, @Nullable final CompoundNBT dataTag) {
        final ILivingEntityData data = super.func_213386_a(worldIn, difficulty, reason, spawnDataIn, dataTag);
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
                this.field_70170_p.func_195594_a((IParticleData)TFParticleType.SNOW_GUARDIAN.get(), this.field_70142_S + px, this.field_70137_T + py, this.field_70136_U + pz, 0.0, 0.0, 0.0);
            }
        }
    }
    
    public int func_70641_bl() {
        return 8;
    }
}
