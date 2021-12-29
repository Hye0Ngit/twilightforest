// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.world.entity.ai.control.MoveControl;
import java.util.EnumSet;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import java.util.Random;
import net.minecraftforge.entity.PartEntity;
import twilightforest.entity.TFPart;
import net.minecraft.network.protocol.game.ClientboundAddMobPacket;
import twilightforest.loot.TFTreasure;
import twilightforest.block.TwilightChest;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import twilightforest.advancements.TFAdvancements;
import twilightforest.world.registration.TFGenerationSettings;
import twilightforest.world.registration.TFFeature;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.IntArrayTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.Difficulty;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import twilightforest.network.ThrowPlayerPacket;
import net.minecraftforge.fmllegacy.network.PacketDistributor;
import twilightforest.network.TFPacketHandler;
import net.minecraft.world.damagesource.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.level.block.state.BlockState;
import java.util.Iterator;
import net.minecraft.world.phys.AABB;
import twilightforest.util.EntityUtil;
import net.minecraft.world.level.material.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import javax.annotation.Nullable;
import net.minecraft.network.chat.Component;
import net.minecraft.world.BossEvent;
import java.util.ArrayList;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import java.util.List;
import net.minecraft.world.entity.monster.Monster;

public class Naga extends Monster
{
    private static final int TICKS_BEFORE_HEALING = 600;
    private static final int MAX_SEGMENTS = 12;
    private static final int LEASH_X = 46;
    private static final int LEASH_Y = 7;
    private static final int LEASH_Z = 46;
    private static final double DEFAULT_SPEED = 0.3;
    private int currentSegmentCount;
    private final float healthPerSegment;
    private final NagaSegment[] bodySegments;
    private AIMovementPattern movementAI;
    private int ticksSinceDamaged;
    private final List<ServerPlayer> hurtBy;
    private final ServerBossEvent bossInfo;
    private final AttributeModifier slowSpeed;
    private final AttributeModifier fastSpeed;
    private static final EntityDataAccessor<Boolean> DATA_DAZE;
    private static final EntityDataAccessor<Boolean> DATA_CHARGE;
    
    public Naga(final EntityType<? extends Naga> type, final Level world) {
        super((EntityType)type, world);
        this.currentSegmentCount = 0;
        this.bodySegments = new NagaSegment[12];
        this.ticksSinceDamaged = 0;
        this.hurtBy = new ArrayList<ServerPlayer>();
        this.bossInfo = new ServerBossEvent(this.m_5446_(), BossEvent.BossBarColor.GREEN, BossEvent.BossBarOverlay.NOTCHED_10);
        this.slowSpeed = new AttributeModifier("Naga Slow Speed", 0.25, AttributeModifier.Operation.ADDITION);
        this.fastSpeed = new AttributeModifier("Naga Fast Speed", 0.5, AttributeModifier.Operation.ADDITION);
        this.f_19793_ = 2.0f;
        this.healthPerSegment = this.m_21233_() / 10.0f;
        this.f_21364_ = 217;
        this.f_19811_ = true;
        for (int i = 0; i < this.bodySegments.length; ++i) {
            this.bodySegments[i] = new NagaSegment(this);
        }
        this.goNormal();
    }
    
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_((EntityDataAccessor)Naga.DATA_DAZE, (Object)false);
        this.f_19804_.m_135372_((EntityDataAccessor)Naga.DATA_CHARGE, (Object)false);
    }
    
    public boolean isDazed() {
        return (boolean)this.f_19804_.m_135370_((EntityDataAccessor)Naga.DATA_DAZE);
    }
    
    protected void setDazed(final boolean daze) {
        this.f_19804_.m_135381_((EntityDataAccessor)Naga.DATA_DAZE, (Object)daze);
    }
    
    public boolean isCharging() {
        return (boolean)this.f_19804_.m_135370_((EntityDataAccessor)Naga.DATA_CHARGE);
    }
    
    protected void setCharging(final boolean charge) {
        this.f_19804_.m_135381_((EntityDataAccessor)Naga.DATA_CHARGE, (Object)charge);
    }
    
    private float getMaxHealthPerDifficulty() {
        return switch (this.f_19853_.m_46791_()) {
            case EASY -> 120.0f;
            case HARD -> 250.0f;
            default -> 200.0f;
        };
    }
    
    public void m_6593_(@Nullable final Component name) {
        super.m_6593_(name);
        this.bossInfo.m_6456_(this.m_5446_());
    }
    
    public boolean m_6785_(final double p_213397_1_) {
        return false;
    }
    
    protected void m_8099_() {
        this.f_21345_.m_25352_(1, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(2, (Goal)new AIAttack(this));
        this.f_21345_.m_25352_(3, (Goal)new AISmash(this));
        this.f_21345_.m_25352_(4, (Goal)(this.movementAI = new AIMovementPattern(this)));
        this.f_21345_.m_25352_(8, (Goal)new RandomStrollGoal(this, 1.0, 1) {
            public void m_8056_() {
                Naga.this.goNormal();
                super.m_8056_();
            }
            
            protected Vec3 m_7037_() {
                return DefaultRandomPos.m_148403_(this.f_25725_, 30, 7);
            }
        });
        this.f_21346_.m_25352_(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)this, (Class)Player.class, false));
        this.f_21342_ = new NagaMoveHelper((Mob)this);
    }
    
    public void m_8107_() {
        super.m_8107_();
        if (this.f_19853_.f_46443_ || !ForgeEventFactory.getMobGriefingEvent(this.f_19853_, (Entity)this)) {
            return;
        }
        final AABB bb = this.m_142469_();
        final int minx = Mth.m_14107_(bb.f_82288_ - 0.75);
        final int miny = Mth.m_14107_(bb.f_82289_ + 1.01);
        final int minz = Mth.m_14107_(bb.f_82290_ - 0.75);
        final int maxx = Mth.m_14107_(bb.f_82291_ + 0.75);
        final int maxy = Mth.m_14107_(bb.f_82292_ + 0.0);
        final int maxz = Mth.m_14107_(bb.f_82293_ + 0.75);
        final BlockPos min = new BlockPos(minx, miny, minz);
        final BlockPos max = new BlockPos(maxx, maxy, maxz);
        if (this.f_19853_.m_46832_(min, max)) {
            for (final BlockPos pos : BlockPos.m_121940_(min, max)) {
                final BlockState state = this.f_19853_.m_8055_(pos);
                if (state.m_60767_() == Material.f_76274_ && EntityUtil.canDestroyBlock(this.f_19853_, pos, state, (Entity)this)) {
                    this.f_19853_.m_46961_(pos, true);
                }
            }
        }
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Monster.m_33035_().m_22268_(Attributes.f_22276_, 200.0).m_22268_(Attributes.f_22279_, 0.3).m_22268_(Attributes.f_22281_, 5.0).m_22268_(Attributes.f_22277_, 80.0);
    }
    
    private void setSegmentsPerHealth() {
        final int oldSegments = this.currentSegmentCount;
        final int newSegments = Mth.m_14045_((int)(this.m_21223_() / this.healthPerSegment + ((this.m_21223_() > 0.0f) ? 2 : 0)), 0, 12);
        this.currentSegmentCount = newSegments;
        if (newSegments < oldSegments) {
            for (int i = newSegments; i < oldSegments; ++i) {
                this.bodySegments[i].selfDestruct();
            }
        }
        else if (newSegments > oldSegments) {
            this.activateBodySegments();
        }
        if (!this.f_19853_.f_46443_) {
            double newSpeed = 0.3 - newSegments * -0.016666668f;
            if (newSpeed < 0.0) {
                newSpeed = 0.0;
            }
            this.m_21051_(Attributes.f_22279_).m_22100_(newSpeed);
        }
    }
    
    public boolean m_20161_() {
        return false;
    }
    
    public boolean m_20077_() {
        return false;
    }
    
    public void m_8119_() {
        if (this.f_20919_ > 0) {
            for (int k = 0; k < 5; ++k) {
                final double d = this.f_19796_.nextGaussian() * 0.02;
                final double d2 = this.f_19796_.nextGaussian() * 0.02;
                final double d3 = this.f_19796_.nextGaussian() * 0.02;
                this.f_19853_.m_7106_((ParticleOptions)(this.f_19796_.nextBoolean() ? ParticleTypes.f_123812_ : ParticleTypes.f_123813_), this.m_20185_() + this.f_19796_.nextFloat() * this.m_20205_() * 2.0f - this.m_20205_(), this.m_20186_() + this.f_19796_.nextFloat() * this.m_20206_(), this.m_20189_() + this.f_19796_.nextFloat() * this.m_20205_() * 2.0f - this.m_20205_(), d, d2, d3);
            }
        }
        ++this.ticksSinceDamaged;
        if (!this.f_19853_.f_46443_ && this.ticksSinceDamaged > 600 && this.ticksSinceDamaged % 20 == 0) {
            this.m_5634_(1.0f);
        }
        this.setSegmentsPerHealth();
        super.m_8119_();
        this.moveSegments();
    }
    
    protected void m_8024_() {
        super.m_8024_();
        if (this.m_5448_() != null && (this.m_20280_((Entity)this.m_5448_()) > 6400.0 || !this.isEntityWithinHomeArea((Entity)this.m_5448_()))) {
            this.m_6710_((LivingEntity)null);
        }
        final double d = this.m_20205_() * 4.0f;
        Vec3 vec3d = this.m_21691_() ? this.m_21573_().m_26570_().m_77380_((Entity)this) : null;
        while (vec3d != null && vec3d.m_82531_(this.m_20185_(), vec3d.f_82480_, this.m_20189_()) < d * d) {
            this.m_21573_().m_26570_().m_77374_();
            if (this.m_21573_().m_26570_().m_77392_()) {
                vec3d = null;
            }
            else {
                vec3d = this.m_21573_().m_26570_().m_77380_((Entity)this);
            }
        }
        if (!this.m_21533_()) {
            this.m_6710_((LivingEntity)null);
            this.m_21573_().m_26536_(this.m_21573_().m_7864_(this.m_21534_(), 0), 1.0);
        }
        this.bossInfo.m_142711_(this.m_21223_() / this.m_21233_());
    }
    
    protected SoundEvent m_7515_() {
        return TFSounds.NAGA_HISS;
    }
    
    protected SoundEvent m_7975_(final DamageSource source) {
        return TFSounds.NAGA_HURT;
    }
    
    protected SoundEvent m_5592_() {
        return TFSounds.NAGA_HURT;
    }
    
    private void crumbleBelowTarget(final int range) {
        if (!ForgeEventFactory.getMobGriefingEvent(this.f_19853_, (Entity)this)) {
            return;
        }
        final int floor = (int)this.m_142469_().f_82289_;
        final int targetY = (int)this.m_5448_().m_142469_().f_82289_;
        if (targetY > floor) {
            final int dx = (int)this.m_5448_().m_20185_() + this.f_19796_.nextInt(range) - this.f_19796_.nextInt(range);
            final int dz = (int)this.m_5448_().m_20189_() + this.f_19796_.nextInt(range) - this.f_19796_.nextInt(range);
            int dy = targetY - this.f_19796_.nextInt(range) + this.f_19796_.nextInt((range > 1) ? (range - 1) : range);
            if (dy <= floor) {
                dy = targetY;
            }
            final BlockPos pos = new BlockPos(dx, dy, dz);
            if (EntityUtil.canDestroyBlock(this.f_19853_, pos, (Entity)this)) {
                this.f_19853_.m_46961_(pos, true);
                for (int k = 0; k < 20; ++k) {
                    final double d = this.f_19796_.nextGaussian() * 0.02;
                    final double d2 = this.f_19796_.nextGaussian() * 0.02;
                    final double d3 = this.f_19796_.nextGaussian() * 0.02;
                    this.f_19853_.m_7106_((ParticleOptions)ParticleTypes.f_123797_, this.m_20185_() + this.f_19796_.nextFloat() * this.m_20205_() * 2.0f - this.m_20205_(), this.m_20186_() + this.f_19796_.nextFloat() * this.m_20206_(), this.m_20189_() + this.f_19796_.nextFloat() * this.m_20205_() * 2.0f - this.m_20205_(), d, d2, d3);
                }
            }
        }
    }
    
    private void goSlow() {
        this.m_21051_(Attributes.f_22279_).m_22130_(this.slowSpeed);
        this.m_21051_(Attributes.f_22279_).m_22130_(this.fastSpeed);
        this.m_21051_(Attributes.f_22279_).m_22118_(this.slowSpeed);
    }
    
    private void goNormal() {
        this.m_21051_(Attributes.f_22279_).m_22130_(this.slowSpeed);
        this.m_21051_(Attributes.f_22279_).m_22130_(this.fastSpeed);
    }
    
    private void goFast() {
        this.m_21051_(Attributes.f_22279_).m_22130_(this.slowSpeed);
        this.m_21051_(Attributes.f_22279_).m_22130_(this.fastSpeed);
        this.m_21051_(Attributes.f_22279_).m_22118_(this.fastSpeed);
    }
    
    public boolean m_6094_() {
        return false;
    }
    
    private BlockPos findCirclePoint(final boolean clockwise, final double radius, final double rotation) {
        final LivingEntity toCircle = this.m_5448_();
        final double vecx = this.m_20185_() - toCircle.m_20185_();
        final double vecz = this.m_20189_() - toCircle.m_20189_();
        float rangle = (float)Math.atan2(vecz, vecx);
        rangle += (float)(clockwise ? rotation : (-rotation));
        final double dx = Mth.m_14089_(rangle) * radius;
        final double dz = Mth.m_14031_(rangle) * radius;
        final double dy = Math.min(this.m_142469_().f_82289_, toCircle.m_20186_());
        return new BlockPos(toCircle.m_20185_() + dx, dy, toCircle.m_20189_() + dz);
    }
    
    public boolean m_6673_(final DamageSource src) {
        return (src.m_7639_() != null && !this.isEntityWithinHomeArea(src.m_7639_())) || (src.m_7640_() != null && !this.isEntityWithinHomeArea(src.m_7640_())) || src.m_19384_() || src.m_19372_() || super.m_6673_(src);
    }
    
    public boolean m_6469_(final DamageSource source, final float amount) {
        if (source != DamageSource.f_19315_ && super.m_6469_(source, amount)) {
            this.ticksSinceDamaged = 0;
            final Entity 7639_ = source.m_7639_();
            if (7639_ instanceof final ServerPlayer player) {
                if (!this.hurtBy.contains(player)) {
                    this.hurtBy.add(player);
                }
            }
            return true;
        }
        return false;
    }
    
    public boolean m_7327_(final Entity toAttack) {
        if (this.movementAI.movementState == MovementState.CHARGE && toAttack instanceof LivingEntity && ((LivingEntity)toAttack).m_21254_()) {
            final Vec3 motion = this.m_20184_();
            toAttack.m_5997_(motion.f_82479_ * 1.25, 0.5, motion.f_82481_ * 1.25);
            this.m_20334_(motion.f_82479_ * -1.5, motion.f_82480_ + 0.5, motion.f_82481_ * -1.5);
            if (toAttack instanceof final ServerPlayer serverPlayer) {
                TFPacketHandler.CHANNEL.send(PacketDistributor.PLAYER.with(() -> serverPlayer), (Object)new ThrowPlayerPacket((float)toAttack.m_20184_().m_7096_(), (float)toAttack.m_20184_().m_7098_(), (float)toAttack.m_20184_().m_7094_()));
            }
            this.m_6469_(DamageSource.f_19318_, 4.0f);
            this.f_19853_.m_5594_((Player)null, toAttack.m_142538_(), SoundEvents.f_12346_, SoundSource.PLAYERS, 1.0f, 0.8f + this.f_19853_.f_46441_.nextFloat() * 0.4f);
            this.movementAI.doDaze();
            return false;
        }
        final boolean result = super.m_7327_(toAttack);
        if (result) {
            toAttack.m_5997_((double)(-Mth.m_14031_(this.m_146908_() * 3.141593f / 180.0f) * 2.0f), 0.4000000059604645, (double)(Mth.m_14089_(this.m_146908_() * 3.141593f / 180.0f) * 2.0f));
        }
        return result;
    }
    
    public float m_21692_(final BlockPos pos) {
        if (!this.m_21444_(pos)) {
            return Float.MIN_VALUE;
        }
        return 0.0f;
    }
    
    public void m_6043_() {
        if (this.f_19853_.m_46791_() == Difficulty.PEACEFUL) {
            if (this.m_21534_() != BlockPos.f_121853_) {
                this.f_19853_.m_46597_(this.m_21534_(), ((Block)TFBlocks.NAGA_BOSS_SPAWNER.get()).m_49966_());
            }
            this.m_146870_();
        }
        else {
            super.m_6043_();
        }
    }
    
    public void m_142687_(final Entity.RemovalReason reason) {
        super.m_142687_(reason);
        if (this.f_19853_ instanceof ServerLevel) {
            for (final NagaSegment seg : this.bodySegments) {
                seg.m_142687_(Entity.RemovalReason.KILLED);
            }
        }
    }
    
    public boolean m_21444_(final BlockPos pos) {
        if (this.m_21535_() == -1.0f) {
            return true;
        }
        final int distX = Math.abs(this.m_21534_().m_123341_() - pos.m_123341_());
        final int distY = Math.abs(this.m_21534_().m_123342_() - pos.m_123342_());
        final int distZ = Math.abs(this.m_21534_().m_123343_() - pos.m_123343_());
        return distX <= 46 && distY <= 7 && distZ <= 46;
    }
    
    private boolean isEntityWithinHomeArea(final Entity entity) {
        return this.m_21444_(entity.m_142538_());
    }
    
    private void activateBodySegments() {
        for (int i = 0; i < this.currentSegmentCount; ++i) {
            final NagaSegment segment = this.bodySegments[i];
            segment.activate();
            segment.m_7678_(this.m_20185_() + 0.1 * i, this.m_20186_() + 0.5, this.m_20189_() + 0.1 * i, this.f_19796_.nextFloat() * 360.0f, 0.0f);
            for (int j = 0; j < 20; ++j) {
                final double d0 = this.f_19796_.nextGaussian() * 0.02;
                final double d2 = this.f_19796_.nextGaussian() * 0.02;
                final double d3 = this.f_19796_.nextGaussian() * 0.02;
                this.f_19853_.m_7106_((ParticleOptions)ParticleTypes.f_123813_, segment.m_20185_() + this.f_19796_.nextFloat() * segment.m_20205_() * 2.0f - segment.m_20205_() - d0 * 10.0, segment.m_20186_() + this.f_19796_.nextFloat() * segment.m_20206_() - d2 * 10.0, segment.m_20189_() + this.f_19796_.nextFloat() * segment.m_20205_() * 2.0f - segment.m_20205_() - d3 * 10.0, d0, d2, d3);
            }
        }
    }
    
    private void moveSegments() {
        for (int i = 0; i < this.bodySegments.length; ++i) {
            this.bodySegments[i].m_8119_();
            final Entity leader = (Entity)((i == 0) ? this : this.bodySegments[i - 1]);
            final double followX = leader.m_20185_();
            final double followY = leader.m_20186_();
            final double followZ = leader.m_20189_();
            final float angle = (leader.m_146908_() + 180.0f) * 3.141593f / 180.0f;
            final double straightenForce = 0.05 + 1.0 / (i + 1) * 0.5;
            final double idealX = -Mth.m_14031_(angle) * straightenForce;
            final double idealZ = Mth.m_14089_(angle) * straightenForce;
            Vec3 diff = new Vec3(this.bodySegments[i].m_20185_() - followX, this.bodySegments[i].m_20186_() - followY, this.bodySegments[i].m_20189_() - followZ);
            diff = diff.m_82541_();
            diff = diff.m_82520_(idealX, 0.0, idealZ).m_82541_();
            final double f = 2.0;
            final double destX = followX + f * diff.f_82479_;
            final double destY = followY + f * diff.f_82480_;
            final double destZ = followZ + f * diff.f_82481_;
            this.bodySegments[i].m_6034_(destX, destY, destZ);
            final double distance = Mth.m_14116_((float)(diff.f_82479_ * diff.f_82479_ + diff.f_82481_ * diff.f_82481_));
            if (i == 0) {
                diff = diff.m_82520_(0.0, -0.15, 0.0);
            }
            this.bodySegments[i].m_19915_((float)(Math.atan2(diff.f_82481_, diff.f_82479_) * 180.0 / 3.141592653589793) + 90.0f, -(float)(Math.atan2(diff.f_82480_, distance) * 180.0 / 3.141592653589793));
        }
    }
    
    public void m_7380_(final CompoundTag compound) {
        if (this.m_21534_() != BlockPos.f_121853_) {
            final BlockPos home = this.m_21534_();
            compound.m_128365_("Home", (Tag)new IntArrayTag(new int[] { home.m_123341_(), home.m_123342_(), home.m_123343_() }));
        }
        super.m_7380_(compound);
    }
    
    public void m_7378_(final CompoundTag compound) {
        super.m_7378_(compound);
        if (compound.m_128425_("Home", 11)) {
            final int[] home = compound.m_128465_("Home");
            this.m_21446_(new BlockPos(home[0], home[1], home[2]), 20);
        }
        else {
            this.m_21536_();
        }
        if (this.m_8077_()) {
            this.bossInfo.m_6456_(this.m_5446_());
        }
    }
    
    public void m_6667_(final DamageSource cause) {
        super.m_6667_(cause);
        if (!this.f_19853_.f_46443_) {
            TFGenerationSettings.markStructureConquered(this.f_19853_, new BlockPos((Vec3i)this.m_142538_()), TFFeature.NAGA_COURTYARD);
            for (final ServerPlayer player : this.hurtBy) {
                TFAdvancements.HURT_BOSS.trigger(player, (Entity)this);
            }
            TFTreasure.entityDropsIntoContainer((LivingEntity)this, this.m_7771_(true, cause).m_78975_(LootContextParamSets.f_81415_), this.f_19796_.nextBoolean() ? ((TwilightChest)TFBlocks.TWILIGHT_OAK_CHEST.get()).m_49966_() : ((TwilightChest)TFBlocks.CANOPY_CHEST.get()).m_49966_(), new BlockPos(this.m_20182_()));
        }
    }
    
    protected boolean m_6125_() {
        return false;
    }
    
    public boolean isMultipartEntity() {
        return true;
    }
    
    public void m_142223_(final ClientboundAddMobPacket p_147206_) {
        super.m_142223_(p_147206_);
        TFPart.assignPartIDs((Entity)this);
    }
    
    @Nullable
    public PartEntity<?>[] getParts() {
        return this.bodySegments;
    }
    
    public void m_6457_(final ServerPlayer player) {
        super.m_6457_(player);
        this.bossInfo.m_6543_(player);
    }
    
    public void m_6452_(final ServerPlayer player) {
        super.m_6452_(player);
        this.bossInfo.m_6539_(player);
    }
    
    protected boolean m_7341_(final Entity entityIn) {
        return false;
    }
    
    public boolean m_6072_() {
        return false;
    }
    
    static /* synthetic */ float access$300(final Naga x0) {
        return x0.m_6121_();
    }
    
    static {
        DATA_DAZE = SynchedEntityData.m_135353_((Class)Naga.class, EntityDataSerializers.f_135035_);
        DATA_CHARGE = SynchedEntityData.m_135353_((Class)Naga.class, EntityDataSerializers.f_135035_);
    }
    
    static class AIAttack extends Goal
    {
        private final Naga taskOwner;
        private int attackTick;
        
        AIAttack(final Naga taskOwner) {
            this.attackTick = 20;
            this.taskOwner = taskOwner;
        }
        
        public boolean m_8036_() {
            final LivingEntity target = this.taskOwner.m_5448_();
            return target != null && target.m_142469_().f_82292_ > this.taskOwner.m_142469_().f_82289_ - 2.5 && target.m_142469_().f_82289_ < this.taskOwner.m_142469_().f_82292_ + 2.5 && this.taskOwner.m_20280_((Entity)target) <= 4.0 && this.taskOwner.m_21574_().m_148306_((Entity)target);
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
            this.taskOwner.m_7327_((Entity)this.taskOwner.m_5448_());
            this.attackTick = 20;
        }
    }
    
    static class AISmash extends Goal
    {
        private final Naga taskOwner;
        
        AISmash(final Naga taskOwner) {
            this.taskOwner = taskOwner;
        }
        
        public boolean m_8036_() {
            return this.taskOwner.f_19862_ && ForgeEventFactory.getMobGriefingEvent(this.taskOwner.f_19853_, (Entity)this.taskOwner);
        }
        
        public void m_8056_() {
            if (this.taskOwner.f_19853_.f_46443_) {
                return;
            }
            final AABB bb = this.taskOwner.m_142469_();
            final int minx = Mth.m_14107_(bb.f_82288_ - 0.75);
            final int miny = Mth.m_14107_(bb.f_82289_ + 1.01);
            final int minz = Mth.m_14107_(bb.f_82290_ - 0.75);
            final int maxx = Mth.m_14107_(bb.f_82291_ + 0.75);
            final int maxy = Mth.m_14107_(bb.f_82292_ + 0.0);
            final int maxz = Mth.m_14107_(bb.f_82293_ + 0.75);
            final BlockPos min = new BlockPos(minx, miny, minz);
            final BlockPos max = new BlockPos(maxx, maxy, maxz);
            if (this.taskOwner.f_19853_.m_46832_(min, max)) {
                for (final BlockPos pos : BlockPos.m_121940_(min, max)) {
                    if (EntityUtil.canDestroyBlock(this.taskOwner.f_19853_, pos, (Entity)this.taskOwner)) {
                        this.taskOwner.f_19853_.m_46961_(pos, true);
                    }
                }
            }
        }
    }
    
    enum MovementState
    {
        INTIMIDATE, 
        CRUMBLE, 
        CHARGE, 
        CIRCLE, 
        DAZE;
    }
    
    static class AIMovementPattern extends Goal
    {
        private final Naga taskOwner;
        private MovementState movementState;
        private int stateCounter;
        private boolean clockwise;
        
        AIMovementPattern(final Naga taskOwner) {
            this.taskOwner = taskOwner;
            this.m_7021_((EnumSet)EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
            this.m_8041_();
        }
        
        public boolean m_8036_() {
            return this.taskOwner.m_5448_() != null;
        }
        
        public void m_8041_() {
            this.movementState = MovementState.CIRCLE;
            this.stateCounter = 15;
            this.clockwise = false;
        }
        
        public void m_8037_() {
            if (!this.taskOwner.m_21573_().m_26571_()) {
                this.taskOwner.setDazed(false);
                return;
            }
            switch (this.movementState) {
                case INTIMIDATE: {
                    this.taskOwner.m_21573_().m_26573_();
                    this.taskOwner.m_21563_().m_24960_((Entity)this.taskOwner.m_5448_(), 30.0f, 30.0f);
                    this.taskOwner.m_21391_((Entity)this.taskOwner.m_5448_(), 30.0f, 30.0f);
                    this.taskOwner.f_20902_ = 0.1f;
                    break;
                }
                case CRUMBLE: {
                    this.taskOwner.m_21573_().m_26573_();
                    this.taskOwner.crumbleBelowTarget(2);
                    this.taskOwner.crumbleBelowTarget(3);
                    break;
                }
                case CHARGE: {
                    final BlockPos tpoint = this.taskOwner.findCirclePoint(this.clockwise, 14.0, 3.141592653589793);
                    this.taskOwner.m_21573_().m_26519_((double)tpoint.m_123341_(), (double)tpoint.m_123342_(), (double)tpoint.m_123343_(), 1.0);
                    this.taskOwner.setCharging(true);
                    break;
                }
                case CIRCLE: {
                    double radius = (this.stateCounter % 2 == 0) ? 12.0 : 14.0;
                    double rotation = 1.0;
                    if (this.stateCounter == 2) {
                        radius = 16.0;
                    }
                    if (this.stateCounter == 1) {
                        rotation = 0.1;
                    }
                    final BlockPos tpoint2 = this.taskOwner.findCirclePoint(this.clockwise, radius, rotation);
                    this.taskOwner.m_21573_().m_26519_((double)tpoint2.m_123341_(), (double)tpoint2.m_123342_(), (double)tpoint2.m_123343_(), 1.0);
                    break;
                }
                case DAZE: {
                    this.taskOwner.setDazed(true);
                    this.taskOwner.setCharging(false);
                    break;
                }
            }
            --this.stateCounter;
            if (this.stateCounter <= 0) {
                this.transitionState();
            }
        }
        
        private void transitionState() {
            this.taskOwner.setDazed(false);
            this.taskOwner.setCharging(false);
            switch (this.movementState) {
                case INTIMIDATE: {
                    this.clockwise = !this.clockwise;
                    if (this.taskOwner.m_5448_().m_142469_().f_82289_ > this.taskOwner.m_142469_().f_82292_) {
                        this.doCrumblePlayer();
                        break;
                    }
                    this.doCharge();
                    break;
                }
                case CRUMBLE: {
                    this.doCharge();
                    break;
                }
                case CHARGE:
                case DAZE: {
                    this.doCircle();
                    break;
                }
                case CIRCLE: {
                    this.doIntimidate();
                    break;
                }
            }
        }
        
        private void doDaze() {
            this.movementState = MovementState.DAZE;
            this.taskOwner.m_21573_().m_26573_();
            this.stateCounter = 60 + this.taskOwner.f_19796_.nextInt(40);
        }
        
        private void doCircle() {
            this.movementState = MovementState.CIRCLE;
            this.stateCounter += 10 + this.taskOwner.f_19796_.nextInt(10);
            this.taskOwner.goNormal();
        }
        
        private void doCrumblePlayer() {
            this.movementState = MovementState.CRUMBLE;
            this.stateCounter = 20 + this.taskOwner.f_19796_.nextInt(20);
            this.taskOwner.goSlow();
        }
        
        private void doCharge() {
            this.movementState = MovementState.CHARGE;
            this.stateCounter = 3;
            this.taskOwner.goFast();
        }
        
        private void doIntimidate() {
            this.movementState = MovementState.INTIMIDATE;
            this.taskOwner.m_5496_(TFSounds.NAGA_RATTLE, Naga.access$300(this.taskOwner) * 4.0f, this.taskOwner.m_6100_());
            this.stateCounter += 15 + this.taskOwner.f_19796_.nextInt(10);
            this.taskOwner.goSlow();
        }
    }
    
    static class NagaMoveHelper extends MoveControl
    {
        public NagaMoveHelper(final Mob naga) {
            super(naga);
        }
        
        public void m_8126_() {
            final MovementState currentState = ((Naga)this.f_24974_).movementAI.movementState;
            if (currentState == MovementState.DAZE) {
                this.f_24974_.f_20900_ = 0.0f;
            }
            else if (currentState != MovementState.CHARGE && currentState != MovementState.INTIMIDATE) {
                this.f_24974_.f_20900_ = Mth.m_14089_(this.f_24974_.f_19797_ * 0.3f) * 0.6f;
            }
            else {
                final Mob f_24974_ = this.f_24974_;
                f_24974_.f_20900_ *= 0.8f;
            }
            super.m_8126_();
        }
    }
}
