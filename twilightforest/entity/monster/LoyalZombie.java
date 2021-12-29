// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.monster;

import net.minecraft.world.entity.MobType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;

public class LoyalZombie extends TamableAnimal
{
    public LoyalZombie(final EntityType<? extends LoyalZombie> type, final Level world) {
        super((EntityType)type, world);
    }
    
    protected void m_8099_() {
        this.f_21345_.m_25352_(1, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(4, (Goal)new MeleeAttackGoal((PathfinderMob)this, 1.0, true));
        this.f_21345_.m_25352_(5, (Goal)new FollowOwnerGoal((TamableAnimal)this, 1.0, 10.0f, 2.0f, true));
        this.f_21345_.m_25352_(7, (Goal)new WaterAvoidingRandomStrollGoal((PathfinderMob)this, 1.0));
        this.f_21345_.m_25352_(9, (Goal)new LookAtPlayerGoal((Mob)this, (Class)Player.class, 8.0f));
        this.f_21345_.m_25352_(9, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21346_.m_25352_(1, (Goal)new OwnerHurtByTargetGoal((TamableAnimal)this));
        this.f_21346_.m_25352_(2, (Goal)new OwnerHurtTargetGoal((TamableAnimal)this));
        this.f_21346_.m_25352_(3, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.f_21346_.m_25352_(4, (Goal)new NearestAttackableTargetGoal((Mob)this, (Class)Monster.class, true));
    }
    
    public Animal getBreedOffspring(final ServerLevel world, final AgeableMob entityanimal) {
        return null;
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 40.0).m_22268_(Attributes.f_22279_, 0.3).m_22268_(Attributes.f_22284_, 3.0);
    }
    
    public boolean m_7327_(final Entity entity) {
        final boolean success = entity.m_6469_(DamageSource.m_19370_((LivingEntity)this), 7.0f);
        if (success) {
            entity.m_5997_(0.0, 0.2, 0.0);
        }
        return success;
    }
    
    public void m_8107_() {
        if (!this.f_19853_.f_46443_ && this.m_21124_(MobEffects.f_19600_) == null) {
            this.m_20254_(100);
        }
        super.m_8107_();
    }
    
    public boolean m_7757_(final LivingEntity target, final LivingEntity owner) {
        if (target instanceof Creeper || target instanceof Ghast) {
            return false;
        }
        if (target instanceof final LoyalZombie zombie) {
            return !zombie.m_21824_() || zombie.m_142480_() != owner;
        }
        return (!(target instanceof Player) || !(owner instanceof Player) || ((Player)owner).m_7099_((Player)target)) && (!(target instanceof AbstractHorse) || !((AbstractHorse)target).m_30614_()) && (!(target instanceof TamableAnimal) || !((TamableAnimal)target).m_21824_());
    }
    
    public boolean m_6785_(final double distanceToClosestPlayer) {
        return !this.m_21824_();
    }
    
    protected SoundEvent m_7515_() {
        return TFSounds.LOYAL_ZOMBIE_AMBIENT;
    }
    
    protected SoundEvent m_7975_(final DamageSource source) {
        return TFSounds.LOYAL_ZOMBIE_HURT;
    }
    
    protected SoundEvent m_5592_() {
        return TFSounds.LOYAL_ZOMBIE_DEATH;
    }
    
    protected void m_7355_(final BlockPos pos, final BlockState block) {
        this.m_5496_(TFSounds.LOYAL_ZOMBIE_STEP, 0.15f, 1.0f);
    }
    
    public MobType m_6336_() {
        return MobType.f_21641_;
    }
    
    protected void m_21226_() {
    }
}
