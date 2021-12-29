// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.world.entity.ai.control.MoveControl;
import java.util.EnumSet;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.world.entity.ai.goal.WrappedGoal;
import net.minecraft.core.Vec3i;
import twilightforest.loot.TFTreasure;
import twilightforest.block.TwilightChest;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import twilightforest.advancements.TFAdvancements;
import twilightforest.world.registration.TFGenerationSettings;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.state.properties.Property;
import twilightforest.block.GhastTrapBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import twilightforest.entity.projectile.UrGhastFireball;
import net.minecraft.world.phys.AABB;
import twilightforest.util.TFDamageSources;
import java.util.Iterator;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import twilightforest.entity.monster.CarminiteGhastling;
import twilightforest.entity.TFEntities;
import net.minecraft.world.entity.LightningBolt;
import java.util.Collections;
import java.util.Collection;
import net.minecraft.world.entity.Entity;
import twilightforest.TwilightForestMod;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.particles.ParticleTypes;
import twilightforest.client.particle.TFParticleType;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.damagesource.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import javax.annotation.Nullable;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Mob;
import twilightforest.entity.NoClipMoveHelper;
import java.util.ArrayList;
import net.minecraft.world.BossEvent;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.core.BlockPos;
import java.util.List;
import net.minecraft.network.syncher.EntityDataAccessor;
import twilightforest.entity.monster.CarminiteGhastguard;

public class UrGhast extends CarminiteGhastguard
{
    private static final EntityDataAccessor<Boolean> DATA_TANTRUM;
    private static final int HOVER_ALTITUDE = 20;
    private List<BlockPos> trapLocations;
    private int nextTantrumCry;
    private float damageUntilNextPhase;
    private boolean noTrapMode;
    private final ServerBossEvent bossInfo;
    private final List<ServerPlayer> hurtBy;
    
    public UrGhast(final EntityType<? extends UrGhast> type, final Level world) {
        super(type, world);
        this.damageUntilNextPhase = 10.0f;
        this.bossInfo = new ServerBossEvent(this.m_5446_(), BossEvent.BossBarColor.RED, BossEvent.BossBarOverlay.PROGRESS);
        this.hurtBy = new ArrayList<ServerPlayer>();
        this.wanderFactor = 32.0f;
        this.f_19794_ = true;
        this.setInTantrum(false);
        this.f_21364_ = 317;
        this.f_21342_ = new NoClipMoveHelper((Mob)this);
    }
    
    public void m_6593_(@Nullable final Component name) {
        super.m_6593_(name);
        this.bossInfo.m_6456_(this.m_5446_());
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return CarminiteGhastguard.registerAttributes().m_22268_(Attributes.f_22276_, 250.0).m_22268_(Attributes.f_22277_, 128.0);
    }
    
    @Override
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_((EntityDataAccessor)UrGhast.DATA_TANTRUM, (Object)false);
    }
    
    @Override
    protected void m_8099_() {
        super.m_8099_();
        this.trapLocations = new ArrayList<BlockPos>();
        this.f_21345_.f_25345_.removeIf(e -> e.m_26015_() instanceof AIHomedFly);
        this.f_21345_.m_25352_(5, (Goal)new AIWaypointFly(this));
    }
    
    public boolean m_6785_(final double p_213397_1_) {
        return false;
    }
    
    public void m_6043_() {
        if (this.f_19853_.m_46791_() == Difficulty.PEACEFUL) {
            if (this.hasHome()) {
                this.f_19853_.m_46597_(this.m_21534_(), ((Block)TFBlocks.UR_GHAST_BOSS_SPAWNER.get()).m_49966_());
            }
            this.m_146870_();
        }
        else {
            super.m_6043_();
        }
    }
    
    @Override
    protected SoundEvent m_7515_() {
        return TFSounds.URGHAST_AMBIENT;
    }
    
    @Override
    protected SoundEvent m_7975_(final DamageSource damageSourceIn) {
        return TFSounds.URGHAST_HURT;
    }
    
    @Override
    protected SoundEvent m_5592_() {
        return TFSounds.URGHAST_DEATH;
    }
    
    @Override
    public SoundEvent getFireSound() {
        return TFSounds.URGHAST_SHOOT;
    }
    
    @Override
    public SoundEvent getWarnSound() {
        return TFSounds.URGHAST_WARN;
    }
    
    @Override
    public void m_8107_() {
        super.m_8107_();
        if (!this.f_19853_.f_46443_) {
            this.bossInfo.m_142711_(this.m_21223_() / this.m_21233_());
        }
        else {
            if (this.isInTantrum()) {
                this.f_19853_.m_7106_((ParticleOptions)TFParticleType.BOSS_TEAR.get(), this.m_20185_() + (this.f_19796_.nextDouble() - 0.5) * this.m_20205_() * 0.75, this.m_20186_() + this.f_19796_.nextDouble() * this.m_20206_() * 0.5, this.m_20189_() + (this.f_19796_.nextDouble() - 0.5) * this.m_20205_() * 0.75, 0.0, 0.0, 0.0);
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
    }
    
    public boolean m_6673_(final DamageSource src) {
        return src == DamageSource.f_19310_ || src == DamageSource.f_19305_ || src == DamageSource.f_19307_ || super.m_6673_(src);
    }
    
    public void m_147240_(final double strength, final double xRatio, final double zRatio) {
    }
    
    public boolean m_6469_(final DamageSource source, float damage) {
        if (this.isInTantrum()) {
            damage /= 10.0f;
        }
        final float oldHealth = this.m_21223_();
        boolean attackSuccessful;
        if ("fireball".equals(source.m_19385_()) && source.m_7639_() instanceof Player) {
            attackSuccessful = super.m_6469_(DamageSource.m_19361_(source.m_7639_(), source.m_7640_()), damage);
        }
        else {
            attackSuccessful = super.m_6469_(source, damage);
        }
        final float lastDamage = oldHealth - this.m_21223_();
        final Entity 7639_ = source.m_7639_();
        if (7639_ instanceof final ServerPlayer player) {
            if (!this.hurtBy.contains(player)) {
                this.hurtBy.add(player);
            }
        }
        if (!this.f_19853_.f_46443_) {
            if (this.f_20916_ == this.f_20917_) {
                this.damageUntilNextPhase -= lastDamage;
                TwilightForestMod.LOGGER.debug("Urghast Attack successful, {} damage until phase switch.", (Object)this.damageUntilNextPhase);
                if (this.damageUntilNextPhase <= 0.0f) {
                    this.switchPhase();
                }
            }
            else {
                TwilightForestMod.LOGGER.debug("Urghast Attack fail with {} type attack for {} damage", (Object)source.f_19326_, (Object)damage);
            }
        }
        return attackSuccessful;
    }
    
    private void switchPhase() {
        if (this.isInTantrum()) {
            this.setInTantrum(false);
        }
        else {
            this.startTantrum();
        }
        this.resetDamageUntilNextPhase();
    }
    
    public void resetDamageUntilNextPhase() {
        this.damageUntilNextPhase = 18.0f;
    }
    
    private void startTantrum() {
        this.setInTantrum(true);
        this.spawnGhastsAtTraps();
    }
    
    private void spawnGhastsAtTraps() {
        final List<BlockPos> ghastSpawns = new ArrayList<BlockPos>(this.trapLocations);
        Collections.shuffle(ghastSpawns);
        for (int numSpawns = Math.min(2, ghastSpawns.size()), i = 0; i < numSpawns; ++i) {
            final BlockPos spawnCoord = ghastSpawns.get(i);
            this.spawnMinionGhastsAt(spawnCoord.m_123341_(), spawnCoord.m_123342_(), spawnCoord.m_123343_());
        }
    }
    
    private void spawnMinionGhastsAt(final int x, final int y, final int z) {
        final int tries = 24;
        int spawns = 0;
        final int maxSpawns = 6;
        final int rangeXZ = 4;
        final int rangeY = 8;
        final LightningBolt bolt = new LightningBolt(EntityType.f_20465_, this.f_19853_);
        bolt.m_6034_((double)x, (double)(y + 4), (double)z);
        bolt.m_20874_(true);
        this.f_19853_.m_7967_((Entity)bolt);
        for (int i = 0; i < tries; ++i) {
            final CarminiteGhastling minion = new CarminiteGhastling(TFEntities.CARMINITE_GHASTLING, this.f_19853_);
            final double sx = x + (this.f_19796_.nextDouble() - this.f_19796_.nextDouble()) * rangeXZ;
            final double sy = y + this.f_19796_.nextDouble() * rangeY;
            final double sz = z + (this.f_19796_.nextDouble() - this.f_19796_.nextDouble()) * rangeXZ;
            minion.m_7678_(sx, sy, sz, this.f_19853_.f_46441_.nextFloat() * 360.0f, 0.0f);
            minion.makeBossMinion();
            if (minion.m_5545_((LevelAccessor)this.f_19853_, MobSpawnType.MOB_SUMMONED)) {
                this.f_19853_.m_7967_((Entity)minion);
                minion.m_21373_();
            }
            if (++spawns >= maxSpawns) {
                break;
            }
        }
    }
    
    @Override
    protected void m_8024_() {
        super.m_8024_();
        this.m_21536_();
        for (final CarminiteGhastling ghast : this.f_19853_.m_45976_((Class)CarminiteGhastling.class, this.m_142469_().m_82377_(1.0, 1.0, 1.0))) {
            ghast.m_21373_();
            ghast.m_146870_();
            this.m_5634_(2.0f);
        }
        if (this.trapLocations.isEmpty() && !this.noTrapMode) {
            this.scanForTrapsTwice();
            if (this.trapLocations.isEmpty()) {
                this.noTrapMode = true;
            }
        }
        if (this.isInTantrum()) {
            this.m_6710_((LivingEntity)null);
            if (--this.nextTantrumCry <= 0) {
                this.m_5496_(this.m_7975_(null), this.m_6121_(), this.m_6100_());
                this.nextTantrumCry = 20 + this.f_19796_.nextInt(30);
            }
            if (this.f_19797_ % 10 == 0) {
                this.doTantrumDamageEffects();
            }
        }
    }
    
    private void doTantrumDamageEffects() {
        final AABB below = this.m_142469_().m_82386_(0.0, -16.0, 0.0).m_82377_(0.0, 16.0, 0.0);
        for (final Player player : this.f_19853_.m_45976_((Class)Player.class, below)) {
            if (this.f_19853_.m_46861_(player.m_142538_())) {
                player.m_6469_(TFDamageSources.GHAST_TEAR, 3.0f);
            }
        }
        for (final CarminiteGhastling ghast : this.f_19853_.m_45976_((Class)CarminiteGhastling.class, below)) {
            ghast.m_5997_(0.0, 1.0, 0.0);
        }
    }
    
    private boolean checkGhastsAtTraps() {
        int trapsWithEnoughGhasts = 0;
        for (final BlockPos trap : this.trapLocations) {
            final AABB aabb = new AABB(trap, trap.m_142082_(1, 1, 1)).m_82377_(8.0, 16.0, 8.0);
            final List<CarminiteGhastling> nearbyGhasts = this.f_19853_.m_45976_((Class)CarminiteGhastling.class, aabb);
            if (nearbyGhasts.size() >= 4) {
                ++trapsWithEnoughGhasts;
            }
        }
        return trapsWithEnoughGhasts >= 1;
    }
    
    @Override
    protected void spitFireball() {
        final double offsetX = this.m_5448_().m_20185_() - this.m_20185_();
        final double offsetY = this.m_5448_().m_142469_().f_82289_ + this.m_5448_().m_20206_() / 2.0f - (this.m_20186_() + this.m_20206_() / 2.0f);
        final double offsetZ = this.m_5448_().m_20189_() - this.m_20189_();
        UrGhastFireball entityFireball = new UrGhastFireball(this.f_19853_, this, offsetX, offsetY, offsetZ, 1);
        final double shotSpawnDistance = 8.5;
        final Vec3 lookVec = this.m_20252_(1.0f);
        entityFireball.m_6034_(this.m_20185_() + lookVec.f_82479_ * shotSpawnDistance, this.m_20186_() + this.m_20206_() / 2.0f + lookVec.f_82480_ * shotSpawnDistance, this.m_20189_() + lookVec.f_82481_ * shotSpawnDistance);
        this.f_19853_.m_7967_((Entity)entityFireball);
        for (int i = 0; i < 2; ++i) {
            entityFireball = new UrGhastFireball(this.f_19853_, this, offsetX + (this.f_19796_.nextFloat() - this.f_19796_.nextFloat()) * 8.0f, offsetY, offsetZ + (this.f_19796_.nextFloat() - this.f_19796_.nextFloat()) * 8.0f, 1);
            entityFireball.m_6034_(this.m_20185_() + lookVec.f_82479_ * shotSpawnDistance, this.m_20186_() + this.m_20206_() / 2.0f + lookVec.f_82480_ * shotSpawnDistance, this.m_20189_() + lookVec.f_82481_ * shotSpawnDistance);
            this.f_19853_.m_7967_((Entity)entityFireball);
        }
    }
    
    private void scanForTrapsTwice() {
        final int scanRangeXZ = 48;
        final int scanRangeY = 32;
        this.scanForTraps(scanRangeXZ, scanRangeY, this.m_142538_());
        if (this.trapLocations.size() > 0) {
            int ax = 0;
            int ay = 0;
            int az = 0;
            for (final BlockPos trapCoords : this.trapLocations) {
                ax += trapCoords.m_123341_();
                ay += trapCoords.m_123342_();
                az += trapCoords.m_123343_();
            }
            ax /= this.trapLocations.size();
            ay /= this.trapLocations.size();
            az /= this.trapLocations.size();
            this.scanForTraps(scanRangeXZ, scanRangeY, new BlockPos(ax, ay, az));
        }
    }
    
    private void scanForTraps(final int scanRangeXZ, final int scanRangeY, final BlockPos pos) {
        for (int sx = -scanRangeXZ; sx <= scanRangeXZ; ++sx) {
            for (int sz = -scanRangeXZ; sz <= scanRangeXZ; ++sz) {
                for (int sy = -scanRangeY; sy <= scanRangeY; ++sy) {
                    final BlockPos trapCoords = pos.m_142082_(sx, sy, sz);
                    if (this.isTrapAt(trapCoords)) {
                        this.trapLocations.add(trapCoords);
                    }
                }
            }
        }
    }
    
    private boolean isTrapAt(final BlockPos pos) {
        final BlockState inactive = (BlockState)((GhastTrapBlock)TFBlocks.GHAST_TRAP.get()).m_49966_().m_61124_((Property)GhastTrapBlock.ACTIVE, (Comparable)false);
        final BlockState active = (BlockState)((GhastTrapBlock)TFBlocks.GHAST_TRAP.get()).m_49966_().m_61124_((Property)GhastTrapBlock.ACTIVE, (Comparable)true);
        return this.f_19853_.m_46805_(pos) && (this.f_19853_.m_8055_(pos) == inactive || this.f_19853_.m_8055_(pos) == active);
    }
    
    public void m_6457_(final ServerPlayer player) {
        super.m_6457_(player);
        this.bossInfo.m_6543_(player);
    }
    
    public void m_6452_(final ServerPlayer player) {
        super.m_6452_(player);
        this.bossInfo.m_6539_(player);
    }
    
    public boolean m_6060_() {
        return false;
    }
    
    public boolean m_6094_() {
        return false;
    }
    
    public boolean isInTantrum() {
        return (boolean)this.f_19804_.m_135370_((EntityDataAccessor)UrGhast.DATA_TANTRUM);
    }
    
    public void setInTantrum(final boolean inTantrum) {
        this.f_19804_.m_135381_((EntityDataAccessor)UrGhast.DATA_TANTRUM, (Object)inTantrum);
        this.resetDamageUntilNextPhase();
    }
    
    @Override
    protected float m_6121_() {
        return 16.0f;
    }
    
    public float m_6100_() {
        return (this.f_19796_.nextFloat() - this.f_19796_.nextFloat()) * 0.2f + 0.5f;
    }
    
    public void m_7380_(final CompoundTag compound) {
        compound.m_128379_("inTantrum", this.isInTantrum());
        super.m_7380_(compound);
    }
    
    public void m_7378_(final CompoundTag compound) {
        super.m_7378_(compound);
        this.setInTantrum(compound.m_128471_("inTantrum"));
        if (this.m_8077_()) {
            this.bossInfo.m_6456_(this.m_5446_());
        }
    }
    
    public void m_6667_(final DamageSource cause) {
        super.m_6667_(cause);
        if (!this.f_19853_.f_46443_) {
            TFGenerationSettings.markStructureConquered(this.f_19853_, this.findChestCoords(), TFFeature.DARK_TOWER);
            for (final ServerPlayer player : this.hurtBy) {
                TFAdvancements.HURT_BOSS.trigger(player, (Entity)this);
            }
            TFTreasure.entityDropsIntoContainer((LivingEntity)this, this.m_7771_(true, cause).m_78975_(LootContextParamSets.f_81415_), ((TwilightChest)TFBlocks.DARKWOOD_CHEST.get()).m_49966_(), this.findChestCoords());
        }
    }
    
    protected boolean m_6125_() {
        return false;
    }
    
    private BlockPos findChestCoords() {
        if (this.trapLocations.size() > 0) {
            int ax = 0;
            int ay = 0;
            int az = 0;
            for (final BlockPos trapCoords : this.trapLocations) {
                ax += trapCoords.m_123341_();
                ay += trapCoords.m_123342_();
                az += trapCoords.m_123343_();
            }
            ax /= this.trapLocations.size();
            ay /= this.trapLocations.size();
            az /= this.trapLocations.size();
            return new BlockPos(ax, ay + 2, az);
        }
        return new BlockPos((Vec3i)this.m_142538_());
    }
    
    @Override
    protected boolean shouldAttack(final LivingEntity living) {
        return !this.isInTantrum();
    }
    
    @Override
    protected boolean m_7341_(final Entity entityIn) {
        return false;
    }
    
    public boolean m_6072_() {
        return false;
    }
    
    static {
        DATA_TANTRUM = SynchedEntityData.m_135353_((Class)UrGhast.class, EntityDataSerializers.f_135035_);
    }
    
    static class AIWaypointFly extends Goal
    {
        private final UrGhast taskOwner;
        private final List<BlockPos> pointsToVisit;
        private int currentPoint;
        
        AIWaypointFly(final UrGhast ghast) {
            this.currentPoint = 0;
            this.taskOwner = ghast;
            this.pointsToVisit = this.createPath();
            this.m_7021_((EnumSet)EnumSet.of(Goal.Flag.MOVE));
        }
        
        public boolean m_8036_() {
            final MoveControl entitymovehelper = this.taskOwner.m_21566_();
            if (!entitymovehelper.m_24995_()) {
                return true;
            }
            final double d0 = entitymovehelper.m_25000_() - this.taskOwner.m_20185_();
            final double d2 = entitymovehelper.m_25001_() - this.taskOwner.m_20186_();
            final double d3 = entitymovehelper.m_25002_() - this.taskOwner.m_20189_();
            final double d4 = d0 * d0 + d2 * d2 + d3 * d3;
            return d4 < 1.0 || d4 > 3600.0;
        }
        
        public boolean m_8045_() {
            return false;
        }
        
        public void m_8056_() {
            if (this.pointsToVisit.isEmpty()) {
                this.pointsToVisit.addAll(this.createPath());
            }
            else {
                if (this.currentPoint >= this.pointsToVisit.size()) {
                    this.currentPoint = 0;
                    if (!this.taskOwner.checkGhastsAtTraps()) {
                        this.taskOwner.spawnGhastsAtTraps();
                    }
                }
                final double x = this.pointsToVisit.get(this.currentPoint).m_123341_();
                final double y = this.pointsToVisit.get(this.currentPoint).m_123342_() + 20;
                final double z = this.pointsToVisit.get(this.currentPoint).m_123343_();
                this.taskOwner.m_21566_().m_6849_(x, y, z, 1.0);
                ++this.currentPoint;
                this.taskOwner.f_19794_ = false;
            }
        }
        
        private List<BlockPos> createPath() {
            final List<BlockPos> potentialPoints = new ArrayList<BlockPos>();
            final BlockPos pos = new BlockPos((Vec3i)this.taskOwner.m_142538_());
            if (!this.taskOwner.noTrapMode) {
                potentialPoints.addAll(this.taskOwner.trapLocations);
            }
            else {
                potentialPoints.add(pos.m_142082_(20, -20, 0));
                potentialPoints.add(pos.m_142082_(0, -20, -20));
                potentialPoints.add(pos.m_142082_(-20, -20, 0));
                potentialPoints.add(pos.m_142082_(0, -20, 20));
            }
            Collections.shuffle(potentialPoints);
            if (this.taskOwner.noTrapMode) {
                potentialPoints.add(pos.m_6625_(20));
            }
            return potentialPoints;
        }
    }
}
