// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.monster;

import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import twilightforest.TFSounds;
import net.minecraft.world.entity.LivingEntity;
import twilightforest.util.TFDamageSources;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import twilightforest.item.TFItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.nbt.CompoundTag;
import javax.annotation.Nullable;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.PathfinderMob;
import twilightforest.entity.ai.ChargeAttackGoal;
import twilightforest.entity.boss.Minoshroom;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.network.syncher.EntityDataAccessor;
import twilightforest.entity.ITFCharger;
import net.minecraft.world.entity.monster.Monster;

public class Minotaur extends Monster implements ITFCharger
{
    private static final EntityDataAccessor<Boolean> CHARGING;
    
    public Minotaur(final EntityType<? extends Minotaur> type, final Level world) {
        super((EntityType)type, world);
    }
    
    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(2, (Goal)new ChargeAttackGoal((PathfinderMob)this, 1.5f, this instanceof Minoshroom));
        this.f_21345_.m_25352_(3, (Goal)new MeleeAttackGoal((PathfinderMob)this, 1.0, false));
        this.f_21345_.m_25352_(6, (Goal)new WaterAvoidingRandomStrollGoal((PathfinderMob)this, 1.0));
        this.f_21345_.m_25352_(7, (Goal)new LookAtPlayerGoal((Mob)this, (Class)Player.class, 8.0f));
        this.f_21345_.m_25352_(7, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21346_.m_25352_(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)this, (Class)Player.class, false));
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Monster.m_33035_().m_22268_(Attributes.f_22276_, 30.0).m_22268_(Attributes.f_22279_, 0.25);
    }
    
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_((EntityDataAccessor)Minotaur.CHARGING, (Object)false);
    }
    
    @Nullable
    public SpawnGroupData m_6518_(final ServerLevelAccessor worldIn, final DifficultyInstance difficulty, final MobSpawnType reason, @Nullable final SpawnGroupData livingdata, @Nullable final CompoundTag dataTag) {
        final SpawnGroupData data = super.m_6518_(worldIn, difficulty, reason, livingdata, dataTag);
        this.m_6851_(difficulty);
        this.m_6850_(difficulty);
        return data;
    }
    
    protected void m_6851_(final DifficultyInstance difficulty) {
        final int random = this.f_19796_.nextInt(10);
        final float additionalDiff = difficulty.m_19056_() + 1.0f;
        final int result = (int)(random / additionalDiff);
        if (result == 0) {
            this.m_8061_(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)TFItems.GOLDEN_MINOTAUR_AXE.get()));
        }
        else {
            this.m_8061_(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)Items.f_42433_));
        }
    }
    
    public boolean isCharging() {
        return (boolean)this.f_19804_.m_135370_((EntityDataAccessor)Minotaur.CHARGING);
    }
    
    public void setCharging(final boolean flag) {
        this.f_19804_.m_135381_((EntityDataAccessor)Minotaur.CHARGING, (Object)flag);
    }
    
    public boolean m_7327_(final Entity entity) {
        entity.m_6469_(TFDamageSources.axing((LivingEntity)this), (float)this.m_21133_(Attributes.f_22281_));
        final boolean success = super.m_7327_(entity);
        if (success && this.isCharging()) {
            entity.m_6469_(TFDamageSources.axing((LivingEntity)this), (float)this.m_21133_(Attributes.f_22281_));
            entity.m_5997_(0.0, 0.4, 0.0);
            this.m_5496_(TFSounds.MINOTAUR_ATTACK, 1.0f, 1.0f);
        }
        return success;
    }
    
    public void m_8107_() {
        super.m_8107_();
        if (this.isCharging()) {
            this.f_20924_ += (float)0.6;
        }
    }
    
    protected SoundEvent m_7515_() {
        return TFSounds.MINOTAUR_AMBIENT;
    }
    
    protected SoundEvent m_7975_(final DamageSource source) {
        return TFSounds.MINOTAUR_HURT;
    }
    
    protected SoundEvent m_5592_() {
        return TFSounds.MINOTAUR_DEATH;
    }
    
    protected void m_7355_(final BlockPos pos, final BlockState block) {
        this.m_5496_(TFSounds.MINOTAUR_STEP, 0.15f, 0.8f);
    }
    
    public float m_6100_() {
        return (this.f_19796_.nextFloat() - this.f_19796_.nextFloat()) * 0.2f + 0.7f;
    }
    
    static {
        CHARGING = SynchedEntityData.m_135353_((Class)Minotaur.class, EntityDataSerializers.f_135035_);
    }
}
