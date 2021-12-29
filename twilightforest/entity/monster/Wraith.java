// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.monster;

import net.minecraft.world.entity.ai.control.MoveControl;
import java.util.EnumSet;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.monster.Monster;
import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.ServerLevelAccessor;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.Mth;
import twilightforest.util.TFDamageSources;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.Mob;
import twilightforest.entity.NoClipMoveHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.FlyingMob;

public class Wraith extends FlyingMob implements Enemy
{
    public Wraith(final EntityType<? extends Wraith> type, final Level world) {
        super((EntityType)type, world);
        this.f_21342_ = new NoClipMoveHelper((Mob)this);
        this.f_19794_ = true;
    }
    
    protected void m_8099_() {
        this.f_21345_.m_25352_(4, (Goal)new AIAttack(this));
        this.f_21345_.m_25352_(5, (Goal)new AIFlyTowardsTarget(this));
        this.f_21345_.m_25352_(6, (Goal)new AIRandomFly(this));
        this.f_21345_.m_25352_(7, (Goal)new AILookAround(this));
        this.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal((Mob)this, (Class)Player.class, false));
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 20.0).m_22268_(Attributes.f_22279_, 0.5).m_22268_(Attributes.f_22281_, 5.0);
    }
    
    public boolean m_20161_() {
        return false;
    }
    
    public boolean m_7327_(final Entity entityIn) {
        float f = (float)this.m_21051_(Attributes.f_22281_).m_22135_();
        int i = 0;
        if (entityIn instanceof final LivingEntity livingEntity) {
            f += EnchantmentHelper.m_44833_(this.m_21205_(), livingEntity.m_6336_());
            i += EnchantmentHelper.m_44894_((LivingEntity)this);
        }
        final boolean flag = entityIn.m_6469_(TFDamageSources.haunt((LivingEntity)this), f);
        if (flag) {
            if (i > 0 && entityIn instanceof LivingEntity) {
                ((LivingEntity)entityIn).m_147240_((double)(i * 0.5f), (double)Mth.m_14031_(this.m_146908_() * 0.017453292f), (double)(-Mth.m_14089_(this.m_146908_() * 0.017453292f)));
                this.m_20334_(this.m_20184_().m_7096_() * 0.6, this.m_20184_().m_7098_(), this.m_20184_().m_7094_() * 0.6);
            }
            final int j = EnchantmentHelper.m_44914_((LivingEntity)this);
            if (j > 0) {
                entityIn.m_20254_(j * 4);
            }
            if (entityIn instanceof final Player entityplayer) {
                final ItemStack itemstack = this.m_21205_();
                final ItemStack itemstack2 = entityplayer.m_6117_() ? entityplayer.m_21211_() : ItemStack.f_41583_;
                if (!itemstack.m_41619_() && !itemstack2.m_41619_() && itemstack.m_41720_() instanceof AxeItem && itemstack2.m_41720_() == Items.f_42740_) {
                    final float f2 = 0.25f + EnchantmentHelper.m_44926_((LivingEntity)this) * 0.05f;
                    if (this.f_19796_.nextFloat() < f2) {
                        entityplayer.m_36335_().m_41524_(Items.f_42740_, 100);
                        this.f_19853_.m_7605_((Entity)entityplayer, (byte)30);
                    }
                }
            }
            this.m_19970_((LivingEntity)this, entityIn);
        }
        return flag;
    }
    
    private void despawnIfPeaceful() {
        if (!this.f_19853_.f_46443_ && this.f_19853_.m_46791_() == Difficulty.PEACEFUL) {
            this.m_146870_();
        }
    }
    
    public void m_8107_() {
        super.m_8107_();
        this.despawnIfPeaceful();
    }
    
    public boolean m_6469_(final DamageSource source, final float amount) {
        if (!super.m_6469_(source, amount)) {
            return false;
        }
        final Entity entity = source.m_7639_();
        if (this.m_20202_() == entity || this.m_20197_().contains(entity)) {
            return true;
        }
        if (entity != this && entity instanceof LivingEntity && !source.m_19390_()) {
            this.m_6710_((LivingEntity)entity);
        }
        return true;
    }
    
    protected boolean m_7341_(final Entity entityIn) {
        return false;
    }
    
    protected SoundEvent m_7515_() {
        return TFSounds.WRAITH_AMBIENT;
    }
    
    protected SoundEvent m_7975_(final DamageSource source) {
        return TFSounds.WRAITH_HURT;
    }
    
    protected SoundEvent m_5592_() {
        return TFSounds.WRAITH_DEATH;
    }
    
    public static boolean getCanSpawnHere(final EntityType<? extends Wraith> entity, final ServerLevelAccessor world, final MobSpawnType reason, final BlockPos pos, final Random random) {
        return world.m_46791_() != Difficulty.PEACEFUL && Monster.m_33008_(world, pos, random) && m_21400_((EntityType)entity, (LevelAccessor)world, reason, pos, random);
    }
    
    static class AIFlyTowardsTarget extends Goal
    {
        private final Wraith taskOwner;
        
        AIFlyTowardsTarget(final Wraith wraith) {
            this.taskOwner = wraith;
            this.m_7021_((EnumSet)EnumSet.of(Goal.Flag.MOVE));
        }
        
        public boolean m_8036_() {
            return this.taskOwner.m_5448_() != null;
        }
        
        public boolean m_8045_() {
            return false;
        }
        
        public void m_8056_() {
            final LivingEntity target = this.taskOwner.m_5448_();
            if (target != null) {
                this.taskOwner.m_21566_().m_6849_(target.m_20185_(), target.m_20186_(), target.m_20189_(), 0.5);
            }
        }
    }
    
    static class AIAttack extends Goal
    {
        private final Wraith taskOwner;
        private int attackTick;
        
        AIAttack(final Wraith taskOwner) {
            this.attackTick = 20;
            this.taskOwner = taskOwner;
        }
        
        public boolean m_8036_() {
            final LivingEntity target = this.taskOwner.m_5448_();
            return target != null && target.m_142469_().f_82292_ > this.taskOwner.m_142469_().f_82289_ && target.m_142469_().f_82289_ < this.taskOwner.m_142469_().f_82292_ && this.taskOwner.m_20280_((Entity)target) <= 4.0;
        }
        
        public void m_8037_() {
            if (this.attackTick > 0) {
                --this.attackTick;
            }
        }
        
        public void m_8041_() {
            this.attackTick = 20;
        }
        
        public void m_8056_() {
            if (this.taskOwner.m_5448_() != null) {
                this.taskOwner.m_7327_((Entity)this.taskOwner.m_5448_());
            }
            this.attackTick = 20;
        }
    }
    
    static class AIRandomFly extends Goal
    {
        private final Wraith parentEntity;
        
        public AIRandomFly(final Wraith wraith) {
            this.parentEntity = wraith;
            this.m_7021_((EnumSet)EnumSet.of(Goal.Flag.MOVE));
        }
        
        public boolean m_8036_() {
            if (this.parentEntity.m_5448_() != null) {
                return false;
            }
            final MoveControl entitymovehelper = this.parentEntity.m_21566_();
            final double d0 = entitymovehelper.m_25000_() - this.parentEntity.m_20185_();
            final double d2 = entitymovehelper.m_25001_() - this.parentEntity.m_20186_();
            final double d3 = entitymovehelper.m_25002_() - this.parentEntity.m_20189_();
            final double d4 = d0 * d0 + d2 * d2 + d3 * d3;
            return d4 < 1.0 || d4 > 3600.0;
        }
        
        public boolean m_8045_() {
            return false;
        }
        
        public void m_8056_() {
            final Random random = this.parentEntity.m_21187_();
            final double d0 = this.parentEntity.m_20185_() + (random.nextFloat() * 2.0f - 1.0f) * 16.0f;
            final double d2 = this.parentEntity.m_20186_() + (random.nextFloat() * 2.0f - 1.0f) * 16.0f;
            final double d3 = this.parentEntity.m_20189_() + (random.nextFloat() * 2.0f - 1.0f) * 16.0f;
            this.parentEntity.m_21566_().m_6849_(d0, d2, d3, 0.5);
        }
    }
    
    public static class AILookAround extends Goal
    {
        private final Wraith parentEntity;
        
        public AILookAround(final Wraith wraith) {
            this.parentEntity = wraith;
            this.m_7021_((EnumSet)EnumSet.of(Goal.Flag.LOOK));
        }
        
        public boolean m_8036_() {
            return true;
        }
        
        public void m_8037_() {
            if (this.parentEntity.m_5448_() == null) {
                this.parentEntity.m_146922_(-(float)Mth.m_14136_(this.parentEntity.m_20184_().m_7096_(), this.parentEntity.m_20184_().m_7094_()) * 57.295776f);
                this.parentEntity.m_5618_(this.parentEntity.m_146908_());
            }
            else {
                final LivingEntity entitylivingbase = this.parentEntity.m_5448_();
                if (entitylivingbase.m_20280_((Entity)this.parentEntity) < 4096.0) {
                    final double d1 = entitylivingbase.m_20185_() - this.parentEntity.m_20185_();
                    final double d2 = entitylivingbase.m_20189_() - this.parentEntity.m_20189_();
                    this.parentEntity.m_146922_(-(float)Mth.m_14136_(d1, d2) * 57.295776f);
                    this.parentEntity.m_5618_(this.parentEntity.m_146908_());
                }
            }
        }
    }
}
