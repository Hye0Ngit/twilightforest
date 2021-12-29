// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraftforge.entity.PartEntity;
import twilightforest.entity.TFPart;
import net.minecraft.network.protocol.game.ClientboundAddMobPacket;
import net.minecraft.nbt.CompoundTag;
import javax.annotation.Nullable;
import net.minecraft.network.chat.Component;
import twilightforest.entity.monster.IceCrystal;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import twilightforest.util.WorldUtil;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraft.world.phys.AABB;
import twilightforest.util.TFDamageSources;
import java.util.Iterator;
import net.minecraft.world.entity.LivingEntity;
import twilightforest.loot.TFTreasure;
import twilightforest.block.TwilightChest;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import twilightforest.advancements.TFAdvancements;
import twilightforest.world.registration.TFGenerationSettings;
import twilightforest.world.registration.TFFeature;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;
import twilightforest.client.particle.TFParticleType;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.damagesource.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import twilightforest.entity.ai.HoverBeamGoal;
import twilightforest.entity.ai.HoverThenDropGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import twilightforest.entity.ai.HoverSummonGoal;
import java.util.ArrayList;
import net.minecraft.world.BossEvent;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.server.level.ServerPlayer;
import java.util.List;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.network.syncher.EntityDataAccessor;
import twilightforest.entity.IBreathAttacker;
import net.minecraft.world.entity.monster.Monster;

public class SnowQueen extends Monster implements IBreathAttacker
{
    private static final int MAX_SUMMONS = 6;
    private static final EntityDataAccessor<Boolean> BEAM_FLAG;
    private static final EntityDataAccessor<Byte> PHASE_FLAG;
    private final ServerBossEvent bossInfo;
    private static final int MAX_DAMAGE_WHILE_BEAMING = 25;
    private static final float BREATH_DAMAGE = 4.0f;
    public final SnowQueenIceShield[] iceArray;
    private int summonsRemaining;
    private int successfulDrops;
    private int maxDrops;
    private int damageWhileBeaming;
    private final List<ServerPlayer> hurtBy;
    
    public SnowQueen(final EntityType<? extends SnowQueen> type, final Level world) {
        super((EntityType)type, world);
        this.bossInfo = new ServerBossEvent(this.m_5446_(), BossEvent.BossBarColor.WHITE, BossEvent.BossBarOverlay.PROGRESS);
        this.iceArray = new SnowQueenIceShield[7];
        this.summonsRemaining = 0;
        this.hurtBy = new ArrayList<ServerPlayer>();
        for (int i = 0; i < this.iceArray.length; ++i) {
            this.iceArray[i] = new SnowQueenIceShield(this);
        }
        this.setCurrentPhase(Phase.SUMMON);
        this.m_5825_();
        this.f_21364_ = 317;
    }
    
    protected void m_8099_() {
        this.f_21345_.m_25352_(1, (Goal)new HoverSummonGoal(this));
        this.f_21345_.m_25352_(2, (Goal)new HoverThenDropGoal(this, 80, 20));
        this.f_21345_.m_25352_(3, (Goal)new HoverBeamGoal(this, 80, 100));
        this.f_21345_.m_25352_(6, (Goal)new MeleeAttackGoal((PathfinderMob)this, 1.0, true));
        this.f_21345_.m_25352_(8, (Goal)new LookAtPlayerGoal((Mob)this, (Class)Player.class, 8.0f));
        this.f_21345_.m_25352_(8, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21346_.m_25352_(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)this, (Class)Player.class, true));
    }
    
    public boolean m_6094_() {
        return false;
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Monster.m_33035_().m_22268_(Attributes.f_22279_, 0.23000000417232513).m_22268_(Attributes.f_22281_, 7.0).m_22268_(Attributes.f_22277_, 40.0).m_22268_(Attributes.f_22276_, 200.0);
    }
    
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_((EntityDataAccessor)SnowQueen.BEAM_FLAG, (Object)false);
        this.f_19804_.m_135372_((EntityDataAccessor)SnowQueen.PHASE_FLAG, (Object)0);
    }
    
    protected SoundEvent m_7515_() {
        return TFSounds.SNOW_QUEEN_AMBIENT;
    }
    
    protected SoundEvent m_7975_(final DamageSource source) {
        return TFSounds.SNOW_QUEEN_HURT;
    }
    
    protected SoundEvent m_5592_() {
        return TFSounds.SNOW_QUEEN_DEATH;
    }
    
    public void m_8107_() {
        super.m_8107_();
        if (!this.f_19853_.f_46443_) {
            this.bossInfo.m_142711_(this.m_21223_() / this.m_21233_());
        }
        else {
            this.spawnParticles();
        }
    }
    
    private void spawnParticles() {
        for (int i = 0; i < 3; ++i) {
            final float px = (this.f_19796_.nextFloat() - this.f_19796_.nextFloat()) * 0.3f;
            final float py = this.m_20192_() + (this.f_19796_.nextFloat() - this.f_19796_.nextFloat()) * 0.5f;
            final float pz = (this.f_19796_.nextFloat() - this.f_19796_.nextFloat()) * 0.3f;
            this.f_19853_.m_7106_((ParticleOptions)TFParticleType.SNOW_GUARDIAN.get(), this.f_19790_ + px, this.f_19791_ + py, this.f_19792_ + pz, 0.0, 0.0, 0.0);
        }
        if (this.getCurrentPhase() == Phase.DROP) {
            for (final Entity ice : this.iceArray) {
                final float px2 = (this.f_19796_.nextFloat() - this.f_19796_.nextFloat()) * 0.5f;
                final float py2 = (this.f_19796_.nextFloat() - this.f_19796_.nextFloat()) * 0.5f;
                final float pz2 = (this.f_19796_.nextFloat() - this.f_19796_.nextFloat()) * 0.5f;
                this.f_19853_.m_7106_((ParticleOptions)TFParticleType.SNOW_WARNING.get(), ice.f_19790_ + px2, ice.f_19791_ + py2, ice.f_19792_ + pz2, 0.0, 0.0, 0.0);
            }
        }
        if (this.isBreathing() && this.m_6084_()) {
            final Vec3 look = this.m_20154_();
            final double dist = 0.5;
            final double px3 = this.m_20185_() + look.f_82479_ * dist;
            final double py3 = this.m_20186_() + 1.7000000476837158 + look.f_82480_ * dist;
            final double pz3 = this.m_20189_() + look.f_82481_ * dist;
            for (int j = 0; j < 10; ++j) {
                double dx = look.f_82479_;
                double dy = 0.0;
                double dz = look.f_82481_;
                final double spread = 2.0 + this.m_21187_().nextDouble() * 2.5;
                final double velocity = 2.0 + this.m_21187_().nextDouble() * 0.15;
                dx += this.m_21187_().nextGaussian() * 0.0075 * spread;
                dy += this.m_21187_().nextGaussian() * 0.0075 * spread;
                dz += this.m_21187_().nextGaussian() * 0.0075 * spread;
                dx *= velocity;
                dy *= velocity;
                dz *= velocity;
                this.f_19853_.m_7106_((ParticleOptions)TFParticleType.ICE_BEAM.get(), px3, py3, pz3, dx, dy, dz);
            }
        }
    }
    
    public void m_8119_() {
        super.m_8119_();
        for (int i = 0; i < this.iceArray.length; ++i) {
            this.iceArray[i].m_8119_();
            if (i < this.iceArray.length - 1) {
                final Vec3 blockPos = this.getIceShieldPosition(i);
                this.iceArray[i].m_6034_(blockPos.f_82479_, blockPos.f_82480_, blockPos.f_82481_);
            }
            else {
                this.iceArray[i].m_6034_(this.m_20185_(), this.m_20186_() - 1.0, this.m_20189_());
            }
            this.iceArray[i].m_146922_(this.getIceShieldAngle(i));
            if (!this.f_19853_.f_46443_) {
                this.applyShieldCollisions((Entity)this.iceArray[i]);
            }
        }
        if (this.f_20919_ > 0) {
            for (int k = 0; k < 5; ++k) {
                final double d = this.f_19796_.nextGaussian() * 0.02;
                final double d2 = this.f_19796_.nextGaussian() * 0.02;
                final double d3 = this.f_19796_.nextGaussian() * 0.02;
                this.f_19853_.m_7106_((ParticleOptions)(this.f_19796_.nextBoolean() ? ParticleTypes.f_123812_ : ParticleTypes.f_123813_), this.m_20185_() + this.f_19796_.nextFloat() * this.m_20205_() * 2.0f - this.m_20205_(), this.m_20186_() + this.f_19796_.nextFloat() * this.m_20206_(), this.m_20189_() + this.f_19796_.nextFloat() * this.m_20205_() * 2.0f - this.m_20205_(), d, d2, d3);
            }
        }
    }
    
    public boolean m_6785_(final double p_213397_1_) {
        return false;
    }
    
    public void m_6043_() {
        if (this.f_19853_.m_46791_() == Difficulty.PEACEFUL) {
            if (this.m_21534_() != BlockPos.f_121853_) {
                this.f_19853_.m_46597_(this.m_21534_(), ((Block)TFBlocks.SNOW_QUEEN_BOSS_SPAWNER.get()).m_49966_());
            }
            this.m_146870_();
        }
        else {
            super.m_6043_();
        }
    }
    
    public void m_6667_(final DamageSource cause) {
        super.m_6667_(cause);
        if (!this.f_19853_.f_46443_) {
            TFGenerationSettings.markStructureConquered(this.f_19853_, this.m_142538_(), TFFeature.ICE_TOWER);
            for (final ServerPlayer player : this.hurtBy) {
                TFAdvancements.HURT_BOSS.trigger(player, (Entity)this);
            }
            TFTreasure.entityDropsIntoContainer((LivingEntity)this, this.m_7771_(true, cause).m_78975_(LootContextParamSets.f_81415_), ((TwilightChest)TFBlocks.TWILIGHT_OAK_CHEST.get()).m_49966_(), new BlockPos(this.m_20182_()));
        }
    }
    
    protected boolean m_6125_() {
        return false;
    }
    
    private void applyShieldCollisions(final Entity collider) {
        final List<Entity> list = this.f_19853_.m_45933_(collider, collider.m_142469_().m_82377_(-0.20000000298023224, -0.20000000298023224, -0.20000000298023224));
        for (final Entity collided : list) {
            if (collided.m_6094_()) {
                this.applyShieldCollision(collider, collided);
            }
        }
    }
    
    private void applyShieldCollision(final Entity collider, final Entity collided) {
        if (collided != this) {
            collided.m_7334_(collider);
            if (collided instanceof LivingEntity && super.m_7327_(collided)) {
                final Vec3 motion = collided.m_20184_();
                collided.m_20334_(motion.f_82479_, motion.f_82480_ + 0.4, motion.f_82481_);
                this.m_5496_(TFSounds.SNOW_QUEEN_ATTACK, 1.0f, 1.0f);
            }
        }
    }
    
    protected void m_8024_() {
        super.m_8024_();
        if (this.getCurrentPhase() == Phase.SUMMON && this.getSummonsRemaining() == 0 && this.countMyMinions() <= 0) {
            this.setCurrentPhase(Phase.DROP);
        }
        if (this.getCurrentPhase() == Phase.DROP && this.successfulDrops >= this.maxDrops) {
            this.setCurrentPhase(Phase.BEAM);
        }
        if (this.getCurrentPhase() == Phase.BEAM && this.damageWhileBeaming >= 25) {
            this.setCurrentPhase(Phase.SUMMON);
        }
    }
    
    public boolean m_6469_(final DamageSource source, final float damage) {
        final boolean result = super.m_6469_(TFDamageSources.SQUISH, damage);
        if (result && this.getCurrentPhase() == Phase.BEAM) {
            this.damageWhileBeaming += (int)damage;
        }
        final Entity 7639_ = source.m_7639_();
        if (7639_ instanceof final ServerPlayer player) {
            if (!this.hurtBy.contains(player)) {
                this.hurtBy.add(player);
            }
        }
        return result;
    }
    
    private Vec3 getIceShieldPosition(final int idx) {
        return this.getIceShieldPosition(this.getIceShieldAngle(idx), 1.0f);
    }
    
    private float getIceShieldAngle(final int idx) {
        return 60.0f * idx + this.f_19797_ * 5.0f;
    }
    
    private Vec3 getIceShieldPosition(final float angle, final float distance) {
        final double dx = Math.cos(angle * 3.141592653589793 / 180.0) * distance;
        final double dz = Math.sin(angle * 3.141592653589793 / 180.0) * distance;
        return new Vec3(this.m_20185_() + dx, this.m_20186_() + this.getShieldYOffset(), this.m_20189_() + dz);
    }
    
    private double getShieldYOffset() {
        return 0.10000000149011612;
    }
    
    public boolean m_142535_(final float distance, final float damageMultiplier, final DamageSource cause) {
        return false;
    }
    
    public void destroyBlocksInAABB(final AABB box) {
        if (ForgeEventFactory.getMobGriefingEvent(this.f_19853_, (Entity)this)) {
            for (final BlockPos pos : WorldUtil.getAllInBB(box)) {
                final BlockState state = this.f_19853_.m_8055_(pos);
                if (state.m_60734_() == Blocks.f_50126_ || state.m_60734_() == Blocks.f_50354_) {
                    this.f_19853_.m_46961_(pos, false);
                }
            }
        }
    }
    
    public boolean isBreathing() {
        return (boolean)this.f_19804_.m_135370_((EntityDataAccessor)SnowQueen.BEAM_FLAG);
    }
    
    public void setBreathing(final boolean flag) {
        this.f_19804_.m_135381_((EntityDataAccessor)SnowQueen.BEAM_FLAG, (Object)flag);
    }
    
    public Phase getCurrentPhase() {
        return Phase.values()[(byte)this.f_19804_.m_135370_((EntityDataAccessor)SnowQueen.PHASE_FLAG)];
    }
    
    public void setCurrentPhase(final Phase currentPhase) {
        this.f_19804_.m_135381_((EntityDataAccessor)SnowQueen.PHASE_FLAG, (Object)(byte)currentPhase.ordinal());
        if (currentPhase == Phase.SUMMON) {
            this.setSummonsRemaining(6);
        }
        if (currentPhase == Phase.DROP) {
            this.successfulDrops = 0;
            this.maxDrops = 2 + this.f_19796_.nextInt(3);
        }
        if (currentPhase == Phase.BEAM) {
            this.damageWhileBeaming = 0;
        }
    }
    
    public int getSummonsRemaining() {
        return this.summonsRemaining;
    }
    
    public void setSummonsRemaining(final int summonsRemaining) {
        this.summonsRemaining = summonsRemaining;
    }
    
    public void summonMinionAt(final LivingEntity targetedEntity) {
        final IceCrystal minion = new IceCrystal(this.f_19853_);
        minion.m_19890_(this.m_20185_(), this.m_20186_(), this.m_20189_(), 0.0f, 0.0f);
        this.f_19853_.m_7967_((Entity)minion);
        for (int i = 0; i < 100; ++i) {
            double attemptX;
            double attemptY;
            double attemptZ;
            if (this.m_21534_() != BlockPos.f_121853_) {
                final BlockPos home = this.m_21534_();
                attemptX = home.m_123341_() + this.f_19796_.nextGaussian() * 7.0;
                attemptY = home.m_123342_() + this.f_19796_.nextGaussian() * 2.0;
                attemptZ = home.m_123343_() + this.f_19796_.nextGaussian() * 7.0;
            }
            else {
                attemptX = targetedEntity.m_20185_() + this.f_19796_.nextGaussian() * 16.0;
                attemptY = targetedEntity.m_20186_() + this.f_19796_.nextGaussian() * 8.0;
                attemptZ = targetedEntity.m_20189_() + this.f_19796_.nextGaussian() * 16.0;
            }
            if (minion.m_20984_(attemptX, attemptY, attemptZ, true)) {
                break;
            }
        }
        minion.m_6710_(targetedEntity);
        minion.setToDieIn30Seconds();
        --this.summonsRemaining;
    }
    
    public int countMyMinions() {
        return this.f_19853_.m_45976_((Class)IceCrystal.class, new AABB(this.m_20185_(), this.m_20186_(), this.m_20189_(), this.m_20185_() + 1.0, this.m_20186_() + 1.0, this.m_20189_() + 1.0).m_82377_(32.0, 16.0, 32.0)).size();
    }
    
    public void incrementSuccessfulDrops() {
        ++this.successfulDrops;
    }
    
    public void doBreathAttack(final Entity target) {
        target.m_6469_(TFDamageSources.CHILLING_BREATH, 4.0f);
    }
    
    public void m_6593_(@Nullable final Component name) {
        super.m_6593_(name);
        this.bossInfo.m_6456_(this.m_5446_());
    }
    
    public void m_6457_(final ServerPlayer player) {
        super.m_6457_(player);
        this.bossInfo.m_6543_(player);
    }
    
    public void m_6452_(final ServerPlayer player) {
        super.m_6452_(player);
        this.bossInfo.m_6539_(player);
    }
    
    public void m_7378_(final CompoundTag compound) {
        super.m_7378_(compound);
        if (this.m_8077_()) {
            this.bossInfo.m_6456_(this.m_5446_());
        }
    }
    
    protected boolean m_7341_(final Entity entityIn) {
        return false;
    }
    
    public boolean m_6072_() {
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
        return this.iceArray;
    }
    
    static {
        BEAM_FLAG = SynchedEntityData.m_135353_((Class)SnowQueen.class, EntityDataSerializers.f_135035_);
        PHASE_FLAG = SynchedEntityData.m_135353_((Class)SnowQueen.class, EntityDataSerializers.f_135027_);
    }
    
    public enum Phase
    {
        SUMMON, 
        DROP, 
        BEAM;
    }
}
