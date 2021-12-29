// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.monster;

import net.minecraft.world.entity.AgeableMob;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.damagesource.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import javax.annotation.Nullable;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.Difficulty;
import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.goal.target.NonTameRandomTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.animal.Wolf;

public class HostileWolf extends Wolf implements Enemy
{
    public HostileWolf(final EntityType<? extends HostileWolf> type, final Level world) {
        super((EntityType)type, world);
        this.m_7105_(false);
        this.m_21839_(false);
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22279_, 0.30000001192092896).m_22268_(Attributes.f_22276_, 20.0).m_22268_(Attributes.f_22281_, 2.0);
    }
    
    protected void m_8099_() {
        this.f_21345_.m_25352_(1, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(4, (Goal)new LeapAtTargetGoal((Mob)this, 0.4f));
        this.f_21345_.m_25352_(5, (Goal)new MeleeAttackGoal((PathfinderMob)this, 1.0, true));
        this.f_21345_.m_25352_(8, (Goal)new WaterAvoidingRandomStrollGoal((PathfinderMob)this, 1.0));
        this.f_21345_.m_25352_(10, (Goal)new LookAtPlayerGoal((Mob)this, (Class)Player.class, 8.0f));
        this.f_21345_.m_25352_(10, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21346_.m_25352_(4, (Goal)new NearestAttackableTargetGoal((Mob)this, (Class)Player.class, true));
        this.f_21346_.m_25352_(5, (Goal)new NonTameRandomTargetGoal((TamableAnimal)this, (Class)Animal.class, false, HostileWolf.f_30357_));
        this.f_21346_.m_25352_(6, (Goal)new NonTameRandomTargetGoal((TamableAnimal)this, (Class)Turtle.class, false, Turtle.f_30122_));
        this.f_21346_.m_25352_(8, (Goal)new ResetUniversalAngerTargetGoal((Mob)this, true));
    }
    
    public static boolean getCanSpawnHere(final EntityType<? extends HostileWolf> pType, final ServerLevelAccessor pLevel, final MobSpawnType pReason, final BlockPos pPos, final Random pRandom) {
        return pLevel.m_46791_() != Difficulty.PEACEFUL && Monster.m_33008_(pLevel, pPos, pRandom) && m_21400_((EntityType)pType, (LevelAccessor)pLevel, pReason, pPos, pRandom);
    }
    
    public void m_6710_(@Nullable final LivingEntity entity) {
        if (entity != null && entity != this.m_5448_()) {
            this.m_5496_(this.getTargetSound(), 4.0f, this.m_6100_());
        }
        super.m_6710_(entity);
    }
    
    protected SoundEvent getTargetSound() {
        return TFSounds.HOSTILE_WOLF_TARGET;
    }
    
    protected SoundEvent m_7515_() {
        return TFSounds.HOSTILE_WOLF_AMBIENT;
    }
    
    protected SoundEvent m_7975_(final DamageSource damageSourceIn) {
        return TFSounds.HOSTILE_WOLF_HURT;
    }
    
    protected SoundEvent m_5592_() {
        return TFSounds.HOSTILE_WOLF_DEATH;
    }
    
    public InteractionResult m_7111_(final Player player, final Vec3 vec, final InteractionHand hand) {
        return InteractionResult.PASS;
    }
    
    public InteractionResult m_6071_(final Player playerIn, final InteractionHand hand) {
        return InteractionResult.PASS;
    }
    
    public boolean m_6898_(final ItemStack stack) {
        return false;
    }
    
    public boolean m_30429_() {
        return false;
    }
    
    public boolean m_7848_(final Animal otherAnimal) {
        return false;
    }
    
    public Wolf m_142606_(final ServerLevel world, final AgeableMob mate) {
        return null;
    }
    
    protected boolean m_8028_() {
        return true;
    }
}
