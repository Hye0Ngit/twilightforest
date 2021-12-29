// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.monster;

import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import java.util.List;
import java.util.EnumSet;
import java.util.function.Predicate;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.tags.Tag;
import twilightforest.data.ItemTagGenerator;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.damagesource.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import twilightforest.entity.ai.FlockToSameKindGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.PathfinderMob;
import twilightforest.entity.ai.PanicOnFlockDeathGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.world.entity.monster.Monster;

public class Kobold extends Monster
{
    private static final EntityDataAccessor<Boolean> PANICKED;
    private int lastEatenBreadTicks;
    private int eatingTime;
    
    public Kobold(final EntityType<? extends Kobold> type, final Level world) {
        super((EntityType)type, world);
        this.m_21553_(true);
    }
    
    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(1, (Goal)new PanicOnFlockDeathGoal((PathfinderMob)this, 2.0f));
        this.f_21345_.m_25352_(2, (Goal)new SeekBreadGoal(this));
        this.f_21345_.m_25352_(2, (Goal)new RunAwayWhileHoldingBreadGoal(this));
        this.f_21345_.m_25352_(3, (Goal)new LeapAtTargetGoal((Mob)this, 0.3f));
        this.f_21345_.m_25352_(4, (Goal)new MeleeAttackGoal((PathfinderMob)this, 1.0, false));
        this.f_21345_.m_25352_(5, (Goal)new FlockToSameKindGoal((Mob)this, 1.0));
        this.f_21345_.m_25352_(6, (Goal)new WaterAvoidingRandomStrollGoal((PathfinderMob)this, 1.0));
        this.f_21345_.m_25352_(7, (Goal)new LookAtPlayerGoal((Mob)this, (Class)Player.class, 8.0f));
        this.f_21345_.m_25352_(7, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21346_.m_25352_(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.f_21346_.m_25352_(2, (Goal)new KoboldAttackPlayerTarget(this));
    }
    
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_((EntityDataAccessor)Kobold.PANICKED, (Object)false);
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Monster.m_33035_().m_22268_(Attributes.f_22276_, 13.0).m_22268_(Attributes.f_22279_, 0.28).m_22268_(Attributes.f_22281_, 4.0);
    }
    
    protected SoundEvent m_7515_() {
        return TFSounds.KOBOLD_AMBIENT;
    }
    
    protected SoundEvent m_7975_(final DamageSource source) {
        return TFSounds.KOBOLD_HURT;
    }
    
    protected SoundEvent m_5592_() {
        return TFSounds.KOBOLD_DEATH;
    }
    
    public boolean isPanicked() {
        return (boolean)this.f_19804_.m_135370_((EntityDataAccessor)Kobold.PANICKED);
    }
    
    public void setPanicked(final boolean flag) {
        this.f_19804_.m_135381_((EntityDataAccessor)Kobold.PANICKED, (Object)flag);
    }
    
    public SoundEvent m_7866_(final ItemStack pItemStack) {
        return TFSounds.KOBOLD_MUNCH;
    }
    
    public void m_8107_() {
        super.m_8107_();
        if (this.f_19853_.f_46443_ && this.isPanicked()) {
            for (int i = 0; i < 2; ++i) {
                this.f_19853_.m_7106_((ParticleOptions)ParticleTypes.f_123769_, this.m_20185_() + (this.f_19796_.nextDouble() - 0.5) * this.m_20205_() * 0.5, this.m_20186_() + this.m_20192_(), this.m_20189_() + (this.f_19796_.nextDouble() - 0.5) * this.m_20205_() * 0.5, 0.0, 0.0, 0.0);
            }
        }
        if (!this.f_19853_.f_46443_ && this.m_6084_() && this.m_6844_(EquipmentSlot.MAINHAND).m_150922_((Tag)ItemTagGenerator.KOBOLD_PACIFICATION_BREADS)) {
            ++this.lastEatenBreadTicks;
            if (this.eatingTime > 0) {
                --this.eatingTime;
            }
            final ItemStack itemstack = this.m_6844_(EquipmentSlot.MAINHAND);
            if (this.canEat(itemstack)) {
                if (this.eatingTime <= 0) {
                    final ItemStack itemstack2 = itemstack.m_41671_(this.f_19853_, (LivingEntity)this);
                    if (!itemstack2.m_41619_()) {
                        this.m_8061_(EquipmentSlot.MAINHAND, itemstack2);
                    }
                }
                if (this.lastEatenBreadTicks > 60 && this.f_19796_.nextFloat() < 0.1f) {
                    this.m_5496_(this.m_7866_(itemstack), 0.75f, 0.9f);
                    this.f_19853_.m_7605_((Entity)this, (byte)45);
                    this.lastEatenBreadTicks = 0;
                }
            }
        }
    }
    
    public void m_7822_(final byte pId) {
        if (pId == 45) {
            final ItemStack itemstack = this.m_6844_(EquipmentSlot.MAINHAND);
            if (!itemstack.m_41619_()) {
                for (int i = 0; i < 8; ++i) {
                    final Vec3 vec3 = new Vec3(0.0, Math.random() * 0.1 + 0.1, 0.0).m_82496_(-this.m_146909_() * 0.017453292f).m_82524_(-this.m_146908_() * 0.017453292f);
                    this.f_19853_.m_7106_((ParticleOptions)new ItemParticleOption(ParticleTypes.f_123752_, itemstack), this.m_20185_(), this.m_20188_(), this.m_20189_(), vec3.f_82479_, vec3.f_82480_ + 0.05, vec3.f_82481_);
                }
            }
        }
        else {
            super.m_7822_(pId);
        }
    }
    
    private boolean canEat(final ItemStack stack) {
        return stack.m_41720_().m_41472_() && !this.isPanicked();
    }
    
    public boolean m_7066_(final ItemStack stack) {
        final EquipmentSlot equipmentslot = Mob.m_147233_(stack);
        return this.m_6844_(equipmentslot).m_41619_() && equipmentslot == EquipmentSlot.MAINHAND && super.m_7066_(stack);
    }
    
    public boolean m_7252_(final ItemStack stack) {
        return this.m_6844_(EquipmentSlot.MAINHAND).m_41619_() && stack.m_150922_((Tag)ItemTagGenerator.KOBOLD_PACIFICATION_BREADS) && !this.isPanicked();
    }
    
    protected void m_7581_(final ItemEntity item) {
        final ItemStack itemstack = item.m_32055_();
        if (this.m_7252_(itemstack)) {
            final int i = itemstack.m_41613_();
            if (i > 1) {
                this.dropItemStack(itemstack.m_41620_(i - 1));
            }
            this.m_21053_(item);
            this.m_8061_(EquipmentSlot.MAINHAND, itemstack.m_41620_(1));
            this.f_21347_[EquipmentSlot.MAINHAND.m_20749_()] = 2.0f;
            this.m_7938_((Entity)item, itemstack.m_41613_());
            item.m_146870_();
            this.lastEatenBreadTicks = 1;
            this.eatingTime = this.difficultyTime() + this.f_19796_.nextInt(600);
            this.m_6710_((LivingEntity)null);
        }
    }
    
    private int difficultyTime() {
        switch (this.f_19853_.m_46791_()) {
            case EASY: {
                return 400;
            }
            case NORMAL: {
                return 200;
            }
            case HARD: {
                return 100;
            }
            default: {
                return 200;
            }
        }
    }
    
    private void dropItemStack(final ItemStack stack) {
        final ItemEntity itementity = new ItemEntity(this.f_19853_, this.m_20185_(), this.m_20186_(), this.m_20189_(), stack);
        this.f_19853_.m_7967_((Entity)itementity);
    }
    
    public void m_7380_(final CompoundTag tag) {
        super.m_7380_(tag);
        tag.m_128405_("EatingTimeLeft", this.eatingTime);
        tag.m_128405_("TimeSinceBreadLastEaten", this.lastEatenBreadTicks);
    }
    
    public void m_7378_(final CompoundTag tag) {
        super.m_7378_(tag);
        this.eatingTime = tag.m_128451_("EatingTimeLeft");
        this.lastEatenBreadTicks = tag.m_128451_("TimeSinceBreadLastEaten");
    }
    
    public int m_5792_() {
        return 1;
    }
    
    static {
        PANICKED = SynchedEntityData.m_135353_((Class)Kobold.class, EntityDataSerializers.f_135035_);
    }
    
    private static class KoboldAttackPlayerTarget extends NearestAttackableTargetGoal<Player>
    {
        public KoboldAttackPlayerTarget(final Kobold mob) {
            super((Mob)mob, (Class)Player.class, true);
        }
        
        public boolean m_8036_() {
            return !this.f_26135_.m_6844_(EquipmentSlot.MAINHAND).m_150922_((Tag)ItemTagGenerator.KOBOLD_PACIFICATION_BREADS) && super.m_8036_();
        }
    }
    
    private static class SeekBreadGoal extends Goal
    {
        private static final Predicate<ItemEntity> ALLOWED_ITEMS;
        private final Kobold mob;
        
        public SeekBreadGoal(final Kobold mob) {
            this.m_7021_((EnumSet)EnumSet.of(Goal.Flag.MOVE));
            this.mob = mob;
        }
        
        public boolean m_8036_() {
            if (!this.mob.f_20935_.m_41619_()) {
                return false;
            }
            if (this.mob.isPanicked()) {
                return false;
            }
            if (this.mob.m_21187_().nextInt(10) != 0) {
                return false;
            }
            final List<ItemEntity> list = this.mob.f_19853_.m_6443_((Class)ItemEntity.class, this.mob.m_142469_().m_82377_(8.0, 8.0, 8.0), (Predicate)SeekBreadGoal.ALLOWED_ITEMS);
            return !list.isEmpty() && this.mob.m_6844_(EquipmentSlot.MAINHAND).m_41619_();
        }
        
        public void m_8037_() {
            final List<ItemEntity> list = this.mob.f_19853_.m_6443_((Class)ItemEntity.class, this.mob.m_142469_().m_82377_(8.0, 8.0, 8.0), (Predicate)SeekBreadGoal.ALLOWED_ITEMS);
            final ItemStack itemstack = this.mob.m_6844_(EquipmentSlot.MAINHAND);
            if (itemstack.m_41619_() && !list.isEmpty()) {
                this.mob.m_21573_().m_5624_((Entity)list.get(0), 1.2000000476837158);
                this.mob.m_21563_().m_24946_(list.get(0).m_20185_(), list.get(0).m_20186_(), list.get(0).m_20189_());
            }
        }
        
        public void m_8056_() {
            final List<ItemEntity> list = this.mob.f_19853_.m_6443_((Class)ItemEntity.class, this.mob.m_142469_().m_82377_(8.0, 8.0, 8.0), (Predicate)SeekBreadGoal.ALLOWED_ITEMS);
            if (!list.isEmpty()) {
                this.mob.m_21573_().m_5624_((Entity)list.get(0), 1.2000000476837158);
            }
        }
        
        static {
            ALLOWED_ITEMS = (item -> item.m_32055_().m_150922_((Tag)ItemTagGenerator.KOBOLD_PACIFICATION_BREADS));
        }
    }
    
    private static class RunAwayWhileHoldingBreadGoal extends AvoidEntityGoal<Player>
    {
        public RunAwayWhileHoldingBreadGoal(final Kobold mob) {
            super((PathfinderMob)mob, (Class)Player.class, 8.0f, 1.5, 1.5);
        }
        
        public boolean m_8036_() {
            return this.f_25015_.m_6844_(EquipmentSlot.MAINHAND).m_150922_((Tag)ItemTagGenerator.KOBOLD_PACIFICATION_BREADS) && super.m_8036_();
        }
    }
}
