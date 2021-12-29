// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.entity.CreatureAttribute;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.entity.monster.GhastEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.potion.Effects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.OwnerHurtTargetGoal;
import net.minecraft.entity.ai.goal.OwnerHurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.TameableEntity;

public class LoyalZombieEntity extends TameableEntity
{
    public LoyalZombieEntity(final EntityType<? extends LoyalZombieEntity> type, final World world) {
        super((EntityType)type, world);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(1, (Goal)new SwimGoal((MobEntity)this));
        this.field_70714_bg.func_75776_a(4, (Goal)new MeleeAttackGoal((CreatureEntity)this, 1.0, true));
        this.field_70714_bg.func_75776_a(5, (Goal)new FollowOwnerGoal((TameableEntity)this, 1.0, 10.0f, 2.0f, true));
        this.field_70714_bg.func_75776_a(7, (Goal)new WaterAvoidingRandomWalkingGoal((CreatureEntity)this, 1.0));
        this.field_70714_bg.func_75776_a(9, (Goal)new LookAtGoal((MobEntity)this, (Class)PlayerEntity.class, 8.0f));
        this.field_70714_bg.func_75776_a(9, (Goal)new LookRandomlyGoal((MobEntity)this));
        this.field_70715_bh.func_75776_a(1, (Goal)new OwnerHurtByTargetGoal((TameableEntity)this));
        this.field_70715_bh.func_75776_a(2, (Goal)new OwnerHurtTargetGoal((TameableEntity)this));
        this.field_70715_bh.func_75776_a(3, (Goal)new HurtByTargetGoal((CreatureEntity)this, new Class[0]));
        this.field_70715_bh.func_75776_a(4, (Goal)new NearestAttackableTargetGoal((MobEntity)this, (Class)MonsterEntity.class, true));
    }
    
    public AnimalEntity createChild(final ServerWorld world, final AgeableEntity entityanimal) {
        return null;
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MobEntity.func_233666_p_().func_233815_a_(Attributes.field_233818_a_, 40.0).func_233815_a_(Attributes.field_233821_d_, 0.3).func_233815_a_(Attributes.field_233826_i_, 3.0);
    }
    
    public boolean func_70652_k(final Entity entity) {
        final boolean success = entity.func_70097_a(DamageSource.func_76358_a((LivingEntity)this), 7.0f);
        if (success) {
            entity.func_70024_g(0.0, 0.2, 0.0);
        }
        return success;
    }
    
    public void func_70636_d() {
        if (!this.field_70170_p.field_72995_K && this.func_70660_b(Effects.field_76420_g) == null) {
            this.func_70015_d(100);
        }
        super.func_70636_d();
    }
    
    public boolean func_142018_a(final LivingEntity target, final LivingEntity owner) {
        if (target instanceof CreeperEntity || target instanceof GhastEntity) {
            return false;
        }
        if (target instanceof LoyalZombieEntity) {
            final LoyalZombieEntity zombie = (LoyalZombieEntity)target;
            return !zombie.func_70909_n() || zombie.func_70902_q() != owner;
        }
        return (!(target instanceof PlayerEntity) || !(owner instanceof PlayerEntity) || ((PlayerEntity)owner).func_96122_a((PlayerEntity)target)) && (!(target instanceof AbstractHorseEntity) || !((AbstractHorseEntity)target).func_110248_bS()) && (!(target instanceof TameableEntity) || !((TameableEntity)target).func_70909_n());
    }
    
    public boolean func_213397_c(final double distanceToClosestPlayer) {
        return !this.func_70909_n();
    }
    
    protected SoundEvent func_184639_G() {
        return TFSounds.LOYAL_ZOMBIE_AMBIENT;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return TFSounds.LOYAL_ZOMBIE_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.LOYAL_ZOMBIE_DEATH;
    }
    
    protected void func_180429_a(final BlockPos pos, final BlockState block) {
        this.func_184185_a(TFSounds.LOYAL_ZOMBIE_STEP, 0.15f, 1.0f);
    }
    
    public CreatureAttribute func_70668_bt() {
        return CreatureAttribute.field_223223_b_;
    }
    
    protected void func_226294_cV_() {
    }
}
