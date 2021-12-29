// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.monster;

import net.minecraft.world.entity.ai.control.MoveControl;
import java.util.EnumSet;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.WorldGenLevel;
import twilightforest.world.registration.TFFeature;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.Difficulty;
import java.util.Random;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.damagesource.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import twilightforest.entity.boss.UrGhast;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.world.entity.monster.Ghast;

public class CarminiteGhastguard extends Ghast
{
    private static final EntityDataAccessor<Byte> ATTACK_STATUS;
    private static final EntityDataAccessor<Byte> ATTACK_TIMER;
    private static final EntityDataAccessor<Byte> ATTACK_PREVTIMER;
    private AIAttack attackAI;
    protected float wanderFactor;
    private int inTrapCounter;
    private BlockPos homePosition;
    private float maximumHomeDistance;
    
    public CarminiteGhastguard(final EntityType<? extends CarminiteGhastguard> type, final Level world) {
        super((EntityType)type, world);
        this.homePosition = BlockPos.f_121853_;
        this.maximumHomeDistance = -1.0f;
        this.wanderFactor = 16.0f;
        this.inTrapCounter = 0;
    }
    
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_((EntityDataAccessor)CarminiteGhastguard.ATTACK_STATUS, (Object)0);
        this.f_19804_.m_135372_((EntityDataAccessor)CarminiteGhastguard.ATTACK_TIMER, (Object)0);
        this.f_19804_.m_135372_((EntityDataAccessor)CarminiteGhastguard.ATTACK_PREVTIMER, (Object)0);
    }
    
    protected void m_8099_() {
        this.f_21345_.m_25352_(5, (Goal)new AIHomedFly(this));
        if (!(this instanceof UrGhast)) {
            this.f_21345_.m_25352_(5, (Goal)new AIRandomFly(this));
        }
        this.f_21345_.m_25352_(7, (Goal)new Ghast.GhastLookGoal((Ghast)this));
        this.f_21345_.m_25352_(7, (Goal)(this.attackAI = new AIAttack(this)));
        this.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal((Mob)this, (Class)Player.class, true));
    }
    
    protected SoundEvent m_7515_() {
        return TFSounds.GHASTGUARD_AMBIENT;
    }
    
    protected SoundEvent m_7975_(final DamageSource damageSourceIn) {
        return TFSounds.GHASTGUARD_HURT;
    }
    
    protected SoundEvent m_5592_() {
        return TFSounds.GHASTGUARD_DEATH;
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Ghast.m_32752_().m_22268_(Attributes.f_22276_, 30.0).m_22268_(Attributes.f_22277_, 64.0);
    }
    
    public SoundEvent getFireSound() {
        return TFSounds.GHASTGUARD_SHOOT;
    }
    
    public SoundEvent getWarnSound() {
        return TFSounds.GHASTGUARD_WARN;
    }
    
    protected float m_6121_() {
        return 0.5f;
    }
    
    public int m_8100_() {
        return 160;
    }
    
    public int m_5792_() {
        return 8;
    }
    
    public void m_8107_() {
        if (this.m_6073_() > 0.5f) {
            this.f_20891_ += 2;
        }
        if (this.f_19796_.nextBoolean()) {
            this.f_19853_.m_7106_((ParticleOptions)DustParticleOptions.f_123656_, this.m_20185_() + (this.f_19796_.nextDouble() - 0.5) * this.m_20205_(), this.m_20186_() + this.f_19796_.nextDouble() * this.m_20206_() - 0.25, this.m_20189_() + (this.f_19796_.nextDouble() - 0.5) * this.m_20205_(), 0.0, 0.0, 0.0);
        }
        super.m_8107_();
    }
    
    protected void m_8024_() {
        this.findHome();
        if (this.inTrapCounter > 0) {
            --this.inTrapCounter;
            this.m_6710_((LivingEntity)null);
        }
        final int status = (this.m_5448_() != null && this.shouldAttack(this.m_5448_())) ? 1 : 0;
        this.f_19804_.m_135381_((EntityDataAccessor)CarminiteGhastguard.ATTACK_STATUS, (Object)(byte)status);
        this.f_19804_.m_135381_((EntityDataAccessor)CarminiteGhastguard.ATTACK_TIMER, (Object)(byte)this.attackAI.attackTimer);
        this.f_19804_.m_135381_((EntityDataAccessor)CarminiteGhastguard.ATTACK_PREVTIMER, (Object)(byte)this.attackAI.prevAttackTimer);
    }
    
    public int getAttackStatus() {
        return (byte)this.f_19804_.m_135370_((EntityDataAccessor)CarminiteGhastguard.ATTACK_STATUS);
    }
    
    public int getAttackTimer() {
        return (byte)this.f_19804_.m_135370_((EntityDataAccessor)CarminiteGhastguard.ATTACK_TIMER);
    }
    
    public int getPrevAttackTimer() {
        return (byte)this.f_19804_.m_135370_((EntityDataAccessor)CarminiteGhastguard.ATTACK_PREVTIMER);
    }
    
    protected boolean shouldAttack(final LivingEntity living) {
        return true;
    }
    
    public int m_8132_() {
        return 500;
    }
    
    protected void spitFireball() {
        final Vec3 vec3d = this.m_20252_(1.0f);
        final double d2 = this.m_5448_().m_20185_() - (this.m_20185_() + vec3d.f_82479_ * 4.0);
        final double d3 = this.m_5448_().m_142469_().f_82289_ + this.m_5448_().m_20206_() / 2.0f - (0.5 + this.m_20186_() + this.m_20206_() / 2.0f);
        final double d4 = this.m_5448_().m_20189_() - (this.m_20189_() + vec3d.f_82481_ * 4.0);
        final LargeFireball entitylargefireball = new LargeFireball(this.f_19853_, (LivingEntity)this, d2, d3, d4, this.m_32751_());
        entitylargefireball.m_6034_(this.m_20185_() + vec3d.f_82479_ * 4.0, this.m_20186_() + this.m_20206_() / 2.0f + 0.5, this.m_20189_() + vec3d.f_82481_ * 4.0);
        this.f_19853_.m_7967_((Entity)entitylargefireball);
        if (this.f_19796_.nextInt(6) == 0) {
            this.m_6710_((LivingEntity)null);
        }
    }
    
    public static boolean ghastSpawnHandler(final EntityType<? extends CarminiteGhastguard> entityType, final LevelAccessor world, final MobSpawnType reason, final BlockPos pos, final Random random) {
        return world.m_46791_() != Difficulty.PEACEFUL && m_21400_((EntityType)entityType, world, reason, pos, random);
    }
    
    public boolean m_6914_(final LevelReader world) {
        return world.m_45784_((Entity)this) && !world.m_46855_(this.m_142469_());
    }
    
    private void findHome() {
        if (!this.hasHome()) {
            final int chunkX = Mth.m_14107_(this.m_20185_()) >> 4;
            final int chunkZ = Mth.m_14107_(this.m_20189_()) >> 4;
            final TFFeature nearFeature = TFFeature.getFeatureForRegion(chunkX, chunkZ, (WorldGenLevel)this.f_19853_);
            if (nearFeature != TFFeature.DARK_TOWER) {
                this.m_21536_();
                this.f_20891_ += 5;
            }
            else {
                final BlockPos cc = TFFeature.getNearestCenterXYZ(chunkX, chunkZ);
                this.m_21446_(cc.m_6630_(128), 64);
            }
        }
    }
    
    public void setInTrap() {
        this.inTrapCounter = 10;
    }
    
    public boolean m_21533_() {
        return this.m_21444_(this.m_142538_());
    }
    
    public boolean m_21444_(final BlockPos pos) {
        return this.maximumHomeDistance == -1.0f || (pos.m_123342_() > 64 && pos.m_123342_() < 210 && this.homePosition.m_123331_((Vec3i)pos) < this.maximumHomeDistance * this.maximumHomeDistance);
    }
    
    public void m_21446_(final BlockPos pos, final int distance) {
        this.homePosition = pos;
        this.maximumHomeDistance = (float)distance;
    }
    
    public BlockPos m_21534_() {
        return this.homePosition;
    }
    
    public float m_21535_() {
        return this.maximumHomeDistance;
    }
    
    public boolean m_21536_() {
        this.maximumHomeDistance = -1.0f;
        return false;
    }
    
    protected boolean m_7341_(final Entity entityIn) {
        return false;
    }
    
    public boolean hasHome() {
        return this.maximumHomeDistance != -1.0f;
    }
    
    static {
        ATTACK_STATUS = SynchedEntityData.m_135353_((Class)CarminiteGhastguard.class, EntityDataSerializers.f_135027_);
        ATTACK_TIMER = SynchedEntityData.m_135353_((Class)CarminiteGhastguard.class, EntityDataSerializers.f_135027_);
        ATTACK_PREVTIMER = SynchedEntityData.m_135353_((Class)CarminiteGhastguard.class, EntityDataSerializers.f_135027_);
    }
    
    public static class AIRandomFly extends Goal
    {
        private final CarminiteGhastguard parentEntity;
        
        public AIRandomFly(final CarminiteGhastguard ghast) {
            this.parentEntity = ghast;
            this.m_7021_((EnumSet)EnumSet.of(Goal.Flag.MOVE));
        }
        
        public boolean m_8036_() {
            final MoveControl entitymovehelper = this.parentEntity.m_21566_();
            if (!entitymovehelper.m_24995_()) {
                return this.parentEntity.m_5448_() == null;
            }
            final double d0 = entitymovehelper.m_25000_() - this.parentEntity.m_20185_();
            final double d2 = entitymovehelper.m_25001_() - this.parentEntity.m_20186_();
            final double d3 = entitymovehelper.m_25002_() - this.parentEntity.m_20189_();
            final double d4 = d0 * d0 + d2 * d2 + d3 * d3;
            return this.parentEntity.m_5448_() == null && (d4 < 1.0 || d4 > 3600.0);
        }
        
        public boolean m_8045_() {
            return false;
        }
        
        public void m_8056_() {
            final Random random = this.parentEntity.m_21187_();
            final double d0 = this.parentEntity.m_20185_() + (random.nextFloat() * 2.0f - 1.0f) * this.parentEntity.wanderFactor;
            final double d2 = this.parentEntity.m_20186_() + (random.nextFloat() * 2.0f - 1.0f) * this.parentEntity.wanderFactor;
            final double d3 = this.parentEntity.m_20189_() + (random.nextFloat() * 2.0f - 1.0f) * this.parentEntity.wanderFactor;
            this.parentEntity.m_21566_().m_6849_(d0, d2, d3, 1.0);
        }
    }
    
    public static class AIHomedFly extends Goal
    {
        private final CarminiteGhastguard parentEntity;
        
        AIHomedFly(final CarminiteGhastguard ghast) {
            this.parentEntity = ghast;
            this.m_7021_((EnumSet)EnumSet.of(Goal.Flag.MOVE));
        }
        
        public boolean m_8036_() {
            final MoveControl entitymovehelper = this.parentEntity.m_21566_();
            if (!entitymovehelper.m_24995_()) {
                return !this.parentEntity.m_21533_();
            }
            final double d0 = entitymovehelper.m_25000_() - this.parentEntity.m_20185_();
            final double d2 = entitymovehelper.m_25001_() - this.parentEntity.m_20186_();
            final double d3 = entitymovehelper.m_25002_() - this.parentEntity.m_20189_();
            final double d4 = d0 * d0 + d2 * d2 + d3 * d3;
            return (d4 < 1.0 || d4 > 3600.0) && !this.parentEntity.m_21533_();
        }
        
        public boolean m_8045_() {
            return false;
        }
        
        public void m_8056_() {
            final Random random = this.parentEntity.m_21187_();
            final double d0 = this.parentEntity.m_20185_() + (random.nextFloat() * 2.0f - 1.0f) * this.parentEntity.wanderFactor;
            final double d2 = this.parentEntity.m_20186_() + (random.nextFloat() * 2.0f - 1.0f) * this.parentEntity.wanderFactor;
            final double d3 = this.parentEntity.m_20189_() + (random.nextFloat() * 2.0f - 1.0f) * this.parentEntity.wanderFactor;
            this.parentEntity.m_21566_().m_6849_(d0, d2, d3, 1.0);
            if (this.parentEntity.m_20238_(Vec3.m_82528_((Vec3i)this.parentEntity.m_21534_())) > 256.0) {
                final Vec3 vecToHome = Vec3.m_82528_((Vec3i)this.parentEntity.m_21534_()).m_82546_(this.parentEntity.m_20182_()).m_82541_();
                final double targetX = this.parentEntity.m_20185_() + vecToHome.f_82479_ * this.parentEntity.wanderFactor + (this.parentEntity.f_19796_.nextFloat() * 2.0f - 1.0f) * this.parentEntity.wanderFactor;
                final double targetY = this.parentEntity.m_20186_() + vecToHome.f_82480_ * this.parentEntity.wanderFactor + (this.parentEntity.f_19796_.nextFloat() * 2.0f - 1.0f) * this.parentEntity.wanderFactor;
                final double targetZ = this.parentEntity.m_20189_() + vecToHome.f_82481_ * this.parentEntity.wanderFactor + (this.parentEntity.f_19796_.nextFloat() * 2.0f - 1.0f) * this.parentEntity.wanderFactor;
                this.parentEntity.m_21566_().m_6849_(targetX, targetY, targetZ, 1.0);
            }
            else {
                this.parentEntity.m_21566_().m_6849_(this.parentEntity.m_21534_().m_123341_() + 0.5, (double)this.parentEntity.m_21534_().m_123342_(), this.parentEntity.m_21534_().m_123343_() + 0.5, 1.0);
            }
        }
    }
    
    public static class AIAttack extends Goal
    {
        private final CarminiteGhastguard parentEntity;
        public int attackTimer;
        public int prevAttackTimer;
        
        public AIAttack(final CarminiteGhastguard ghast) {
            this.parentEntity = ghast;
        }
        
        public boolean m_8036_() {
            return this.parentEntity.m_5448_() != null && this.parentEntity.shouldAttack(this.parentEntity.m_5448_());
        }
        
        public void m_8056_() {
            final int n = 0;
            this.prevAttackTimer = n;
            this.attackTimer = n;
        }
        
        public void m_8041_() {
            this.parentEntity.m_32758_(false);
        }
        
        public void m_8037_() {
            final LivingEntity entitylivingbase = this.parentEntity.m_5448_();
            if (entitylivingbase.m_20280_((Entity)this.parentEntity) < 4096.0 && this.parentEntity.m_21574_().m_148306_((Entity)entitylivingbase)) {
                this.prevAttackTimer = this.attackTimer;
                ++this.attackTimer;
                this.parentEntity.m_21563_().m_24960_((Entity)entitylivingbase, 10.0f, (float)this.parentEntity.m_8132_());
                if (this.attackTimer == 10) {
                    this.parentEntity.m_5496_(this.parentEntity.getWarnSound(), 10.0f, this.parentEntity.m_6100_());
                }
                if (this.attackTimer == 20) {
                    if (this.parentEntity.shouldAttack(entitylivingbase)) {
                        this.parentEntity.m_5496_(this.parentEntity.getFireSound(), 10.0f, this.parentEntity.m_6100_());
                        this.parentEntity.spitFireball();
                        this.prevAttackTimer = this.attackTimer;
                    }
                    this.attackTimer = -40;
                }
            }
            else if (this.attackTimer > 0) {
                this.prevAttackTimer = this.attackTimer;
                --this.attackTimer;
            }
            this.parentEntity.m_32758_(this.attackTimer > 10);
        }
    }
}
