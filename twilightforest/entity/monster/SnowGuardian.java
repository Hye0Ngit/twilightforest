// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.monster;

import twilightforest.client.particle.TFParticleType;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import javax.annotation.Nullable;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.ServerLevelAccessor;
import twilightforest.item.TFItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;

public class SnowGuardian extends BaseIceMob
{
    public SnowGuardian(final EntityType<? extends SnowGuardian> type, final Level world) {
        super(type, world);
    }
    
    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(1, (Goal)new MeleeAttackGoal((PathfinderMob)this, 1.0, false));
        this.f_21345_.m_25352_(2, (Goal)new WaterAvoidingRandomStrollGoal((PathfinderMob)this, 1.0));
        this.f_21345_.m_25352_(3, (Goal)new LookAtPlayerGoal((Mob)this, (Class)Player.class, 8.0f));
        this.f_21345_.m_25352_(3, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21346_.m_25352_(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)this, (Class)Player.class, true));
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Monster.m_33035_().m_22268_(Attributes.f_22279_, 0.23000000417232513).m_22268_(Attributes.f_22281_, 3.0).m_22268_(Attributes.f_22276_, 10.0);
    }
    
    protected SoundEvent m_7515_() {
        return TFSounds.ICE_GUARDIAN_AMBIENT;
    }
    
    protected SoundEvent m_7975_(final DamageSource source) {
        return TFSounds.ICE_GUARDIAN_HURT;
    }
    
    protected SoundEvent m_5592_() {
        return TFSounds.ICE_GUARDIAN_DEATH;
    }
    
    public float m_6100_() {
        return (this.f_19796_.nextFloat() - this.f_19796_.nextFloat()) * 0.2f + 0.8f;
    }
    
    protected void m_6851_(final DifficultyInstance difficulty) {
        final int type = this.f_19796_.nextInt(4);
        this.m_8061_(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)this.makeItemForSlot(EquipmentSlot.MAINHAND, type)));
        this.m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)this.makeItemForSlot(EquipmentSlot.CHEST, type)));
        this.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)this.makeItemForSlot(EquipmentSlot.HEAD, type)));
    }
    
    private Item makeItemForSlot(final EquipmentSlot slot, final int type) {
        Item item = null;
        Label_0405: {
            switch (slot) {
                default: {
                    switch (type) {
                        default: {
                            item = (Item)TFItems.IRONWOOD_SWORD.get();
                            break Label_0405;
                        }
                        case 1: {
                            item = (Item)TFItems.STEELEAF_SWORD.get();
                            break Label_0405;
                        }
                        case 2:
                        case 3: {
                            item = (Item)TFItems.KNIGHTMETAL_SWORD.get();
                            break Label_0405;
                        }
                    }
                    break;
                }
                case FEET: {
                    switch (type) {
                        default: {
                            item = (Item)TFItems.IRONWOOD_BOOTS.get();
                            break Label_0405;
                        }
                        case 1: {
                            item = (Item)TFItems.STEELEAF_BOOTS.get();
                            break Label_0405;
                        }
                        case 2: {
                            item = (Item)TFItems.KNIGHTMETAL_BOOTS.get();
                            break Label_0405;
                        }
                        case 3: {
                            item = (Item)TFItems.ARCTIC_BOOTS.get();
                            break Label_0405;
                        }
                    }
                    break;
                }
                case LEGS: {
                    switch (type) {
                        default: {
                            item = (Item)TFItems.IRONWOOD_LEGGINGS.get();
                            break Label_0405;
                        }
                        case 1: {
                            item = (Item)TFItems.STEELEAF_LEGGINGS.get();
                            break Label_0405;
                        }
                        case 2: {
                            item = (Item)TFItems.KNIGHTMETAL_LEGGINGS.get();
                            break Label_0405;
                        }
                        case 3: {
                            item = (Item)TFItems.ARCTIC_LEGGINGS.get();
                            break Label_0405;
                        }
                    }
                    break;
                }
                case CHEST: {
                    switch (type) {
                        default: {
                            item = (Item)TFItems.IRONWOOD_CHESTPLATE.get();
                            break Label_0405;
                        }
                        case 1: {
                            item = (Item)TFItems.STEELEAF_CHESTPLATE.get();
                            break Label_0405;
                        }
                        case 2: {
                            item = (Item)TFItems.KNIGHTMETAL_CHESTPLATE.get();
                            break Label_0405;
                        }
                        case 3: {
                            item = (Item)TFItems.ARCTIC_CHESTPLATE.get();
                            break Label_0405;
                        }
                    }
                    break;
                }
                case HEAD: {
                    switch (type) {
                        default: {
                            item = (Item)TFItems.IRONWOOD_HELMET.get();
                            break Label_0405;
                        }
                        case 1: {
                            item = (Item)TFItems.STEELEAF_HELMET.get();
                            break Label_0405;
                        }
                        case 2: {
                            item = (Item)TFItems.KNIGHTMETAL_HELMET.get();
                            break Label_0405;
                        }
                        case 3: {
                            item = (Item)TFItems.ARCTIC_HELMET.get();
                            break Label_0405;
                        }
                    }
                    break;
                }
            }
        }
        return item;
    }
    
    @Nullable
    public SpawnGroupData m_6518_(final ServerLevelAccessor worldIn, final DifficultyInstance difficulty, final MobSpawnType reason, @Nullable final SpawnGroupData spawnDataIn, @Nullable final CompoundTag dataTag) {
        final SpawnGroupData data = super.m_6518_(worldIn, difficulty, reason, spawnDataIn, dataTag);
        this.m_6851_(difficulty);
        this.m_6850_(difficulty);
        return data;
    }
    
    @Override
    public void m_8107_() {
        super.m_8107_();
        if (this.f_19853_.f_46443_) {
            for (int i = 0; i < 3; ++i) {
                final float px = (this.f_19796_.nextFloat() - this.f_19796_.nextFloat()) * 0.3f;
                final float py = this.m_20192_() + (this.f_19796_.nextFloat() - this.f_19796_.nextFloat()) * 0.5f;
                final float pz = (this.f_19796_.nextFloat() - this.f_19796_.nextFloat()) * 0.3f;
                this.f_19853_.m_7106_((ParticleOptions)TFParticleType.SNOW_GUARDIAN.get(), this.f_19790_ + px, this.f_19791_ + py, this.f_19792_ + pz, 0.0, 0.0, 0.0);
            }
        }
    }
    
    public int m_5792_() {
        return 8;
    }
}
