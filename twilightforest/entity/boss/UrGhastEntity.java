// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.entity.ai.controller.MovementController;
import java.util.EnumSet;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.entity.ai.goal.PrioritizedGoal;
import net.minecraft.util.math.vector.Vector3i;
import twilightforest.world.TFGenerationSettings;
import twilightforest.TFFeature;
import net.minecraft.util.Direction;
import twilightforest.loot.TFTreasure;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.state.Property;
import twilightforest.block.GhastTrapBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.AxisAlignedBB;
import twilightforest.util.TFDamageSources;
import java.util.Iterator;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.IWorld;
import net.minecraft.entity.SpawnReason;
import twilightforest.entity.CarminiteGhastlingEntity;
import twilightforest.entity.TFEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.LightningBoltEntity;
import java.util.Collections;
import java.util.Collection;
import net.minecraft.world.storage.ServerWorldInfo;
import twilightforest.TwilightForestMod;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.ParticleTypes;
import twilightforest.client.particle.TFParticleType;
import net.minecraft.particles.IParticleData;
import net.minecraft.util.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.Difficulty;
import net.minecraft.entity.ai.goal.Goal;
import java.util.ArrayList;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import javax.annotation.Nullable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.entity.MobEntity;
import twilightforest.entity.NoClipMoveHelper;
import net.minecraft.world.BossInfo;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.world.server.ServerBossInfo;
import net.minecraft.util.math.BlockPos;
import java.util.List;
import net.minecraft.network.datasync.DataParameter;
import twilightforest.entity.CarminiteGhastguardEntity;

public class UrGhastEntity extends CarminiteGhastguardEntity
{
    private static final DataParameter<Boolean> DATA_TANTRUM;
    private static final int HOVER_ALTITUDE = 20;
    private List<BlockPos> trapLocations;
    private int nextTantrumCry;
    private float damageUntilNextPhase;
    private boolean noTrapMode;
    private final ServerBossInfo bossInfo;
    
    public UrGhastEntity(final EntityType<? extends UrGhastEntity> type, final World world) {
        super(type, world);
        this.damageUntilNextPhase = 10.0f;
        this.bossInfo = new ServerBossInfo(this.func_145748_c_(), BossInfo.Color.RED, BossInfo.Overlay.PROGRESS);
        this.wanderFactor = 32.0f;
        this.field_70145_X = true;
        this.setInTantrum(false);
        this.field_70728_aV = 317;
        this.field_70765_h = new NoClipMoveHelper((MobEntity)this);
    }
    
    public void func_200203_b(@Nullable final ITextComponent name) {
        super.func_200203_b(name);
        this.bossInfo.func_186739_a(this.func_145748_c_());
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return CarminiteGhastguardEntity.registerAttributes().func_233815_a_(Attributes.field_233818_a_, 250.0).func_233815_a_(Attributes.field_233819_b_, 128.0);
    }
    
    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)UrGhastEntity.DATA_TANTRUM, (Object)false);
    }
    
    @Override
    protected void func_184651_r() {
        super.func_184651_r();
        this.trapLocations = new ArrayList<BlockPos>();
        this.field_70714_bg.field_220892_d.removeIf(e -> e.func_220772_j() instanceof AIHomedFly);
        this.field_70714_bg.func_75776_a(5, (Goal)new AIWaypointFly(this));
    }
    
    public boolean func_213397_c(final double p_213397_1_) {
        return false;
    }
    
    public void func_70623_bb() {
        if (this.field_70170_p.func_175659_aa() == Difficulty.PEACEFUL) {
            if (this.hasHome()) {
                this.field_70170_p.func_175656_a(this.func_213384_dI(), ((Block)TFBlocks.boss_spawner_ur_ghast.get()).func_176223_P());
            }
            this.func_70106_y();
        }
        else {
            super.func_70623_bb();
        }
    }
    
    @Override
    protected SoundEvent func_184639_G() {
        return TFSounds.URGHAST_AMBIENT;
    }
    
    @Override
    protected SoundEvent func_184601_bQ(final DamageSource damageSourceIn) {
        return TFSounds.URGHAST_HURT;
    }
    
    @Override
    protected SoundEvent func_184615_bR() {
        return TFSounds.URGHAST_DEATH;
    }
    
    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            this.bossInfo.func_186735_a(this.func_110143_aJ() / this.func_110138_aP());
        }
        else {
            if (this.isInTantrum()) {
                this.field_70170_p.func_195594_a((IParticleData)TFParticleType.BOSS_TEAR.get(), this.func_226277_ct_() + (this.field_70146_Z.nextDouble() - 0.5) * this.func_213311_cf() * 0.75, this.func_226278_cu_() + this.field_70146_Z.nextDouble() * this.func_213302_cg() * 0.5, this.func_226281_cx_() + (this.field_70146_Z.nextDouble() - 0.5) * this.func_213311_cf() * 0.75, 0.0, 0.0, 0.0);
            }
            if (this.field_70725_aQ > 0) {
                for (int k = 0; k < 5; ++k) {
                    final double d = this.field_70146_Z.nextGaussian() * 0.02;
                    final double d2 = this.field_70146_Z.nextGaussian() * 0.02;
                    final double d3 = this.field_70146_Z.nextGaussian() * 0.02;
                    this.field_70170_p.func_195594_a((IParticleData)(this.field_70146_Z.nextBoolean() ? ParticleTypes.field_197626_s : ParticleTypes.field_197627_t), this.func_226277_ct_() + this.field_70146_Z.nextFloat() * this.func_213311_cf() * 2.0f - this.func_213311_cf(), this.func_226278_cu_() + this.field_70146_Z.nextFloat() * this.func_213302_cg(), this.func_226281_cx_() + this.field_70146_Z.nextFloat() * this.func_213311_cf() * 2.0f - this.func_213311_cf(), d, d2, d3);
                }
            }
        }
    }
    
    public boolean func_180431_b(final DamageSource src) {
        return src == DamageSource.field_76368_d || src == DamageSource.field_76372_a || src == DamageSource.field_76370_b || super.func_180431_b(src);
    }
    
    public void func_233627_a_(final float strength, final double xRatio, final double zRatio) {
    }
    
    public boolean func_70097_a(final DamageSource source, float damage) {
        if (this.isInTantrum()) {
            damage /= 10.0f;
        }
        final float oldHealth = this.func_110143_aJ();
        boolean attackSuccessful;
        if ("fireball".equals(source.func_76355_l()) && source.func_76346_g() instanceof PlayerEntity) {
            attackSuccessful = super.func_70097_a(DamageSource.func_76356_a(source.func_76346_g(), source.func_76364_f()), damage);
        }
        else {
            attackSuccessful = super.func_70097_a(source, damage);
        }
        final float lastDamage = oldHealth - this.func_110143_aJ();
        if (!this.field_70170_p.field_72995_K) {
            if (this.field_70737_aN == this.field_70738_aO) {
                this.damageUntilNextPhase -= lastDamage;
                TwilightForestMod.LOGGER.debug("Urghast Attack successful, {} damage until phase switch.", (Object)this.damageUntilNextPhase);
                if (this.damageUntilNextPhase <= 0.0f) {
                    this.switchPhase();
                }
            }
            else {
                TwilightForestMod.LOGGER.debug("Urghast Attack fail with {} type attack for {} damage", (Object)source.field_76373_n, (Object)damage);
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
        final int rainTime = 6000;
        final ServerWorldInfo worldInfo = (ServerWorldInfo)this.field_70170_p.func_73046_m().func_71218_a(World.field_234918_g_).func_72912_H();
        worldInfo.func_230391_a_(0);
        worldInfo.func_76080_g(rainTime);
        worldInfo.func_76090_f(rainTime);
        worldInfo.func_76084_b(true);
        worldInfo.func_76069_a(true);
        this.spawnGhastsAtTraps();
    }
    
    private void spawnGhastsAtTraps() {
        final List<BlockPos> ghastSpawns = new ArrayList<BlockPos>(this.trapLocations);
        Collections.shuffle(ghastSpawns);
        for (int numSpawns = Math.min(2, ghastSpawns.size()), i = 0; i < numSpawns; ++i) {
            final BlockPos spawnCoord = ghastSpawns.get(i);
            this.spawnMinionGhastsAt(spawnCoord.func_177958_n(), spawnCoord.func_177956_o(), spawnCoord.func_177952_p());
        }
    }
    
    private void spawnMinionGhastsAt(final int x, final int y, final int z) {
        final int tries = 24;
        int spawns = 0;
        final int maxSpawns = 6;
        final int rangeXZ = 4;
        final int rangeY = 8;
        final LightningBoltEntity bolt = new LightningBoltEntity(EntityType.field_200728_aG, this.field_70170_p);
        bolt.func_70107_b((double)x, (double)(y + 4), (double)z);
        bolt.func_233623_a_(true);
        this.field_70170_p.func_217376_c((Entity)bolt);
        for (int i = 0; i < tries; ++i) {
            final CarminiteGhastlingEntity minion = new CarminiteGhastlingEntity(TFEntities.mini_ghast, this.field_70170_p);
            final double sx = x + (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble()) * rangeXZ;
            final double sy = y + this.field_70146_Z.nextDouble() * rangeY;
            final double sz = z + (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble()) * rangeXZ;
            minion.func_70012_b(sx, sy, sz, this.field_70170_p.field_73012_v.nextFloat() * 360.0f, 0.0f);
            minion.makeBossMinion();
            if (minion.func_213380_a((IWorld)this.field_70170_p, SpawnReason.MOB_SUMMONED)) {
                this.field_70170_p.func_217376_c((Entity)minion);
                minion.func_70656_aK();
            }
            if (++spawns >= maxSpawns) {
                break;
            }
        }
    }
    
    @Override
    protected void func_70619_bc() {
        super.func_70619_bc();
        this.func_213394_dL();
        for (final CarminiteGhastlingEntity ghast : this.field_70170_p.func_217357_a((Class)CarminiteGhastlingEntity.class, this.func_174813_aQ().func_72314_b(1.0, 1.0, 1.0))) {
            ghast.func_70656_aK();
            ghast.func_70106_y();
            this.func_70691_i(2.0f);
        }
        if (this.trapLocations.isEmpty() && !this.noTrapMode) {
            this.scanForTrapsTwice();
            if (this.trapLocations.isEmpty()) {
                this.noTrapMode = true;
            }
        }
        if (this.isInTantrum()) {
            this.func_70624_b((LivingEntity)null);
            if (--this.nextTantrumCry <= 0) {
                this.func_184185_a(this.func_184601_bQ(null), this.func_70599_aP(), this.func_70647_i());
                this.nextTantrumCry = 20 + this.field_70146_Z.nextInt(30);
            }
            if (this.field_70173_aa % 10 == 0) {
                this.doTantrumDamageEffects();
            }
        }
    }
    
    private void doTantrumDamageEffects() {
        final AxisAlignedBB below = this.func_174813_aQ().func_72317_d(0.0, -16.0, 0.0).func_72314_b(0.0, 16.0, 0.0);
        for (final PlayerEntity player : this.field_70170_p.func_217357_a((Class)PlayerEntity.class, below)) {
            if (this.field_70170_p.func_175710_j(player.func_233580_cy_())) {
                player.func_70097_a(TFDamageSources.GHAST_TEAR, 3.0f);
            }
        }
        for (final CarminiteGhastlingEntity ghast : this.field_70170_p.func_217357_a((Class)CarminiteGhastlingEntity.class, below)) {
            ghast.func_70024_g(0.0, 1.0, 0.0);
        }
    }
    
    private boolean checkGhastsAtTraps() {
        int trapsWithEnoughGhasts = 0;
        for (final BlockPos trap : this.trapLocations) {
            final AxisAlignedBB aabb = new AxisAlignedBB(trap, trap.func_177982_a(1, 1, 1)).func_72314_b(8.0, 16.0, 8.0);
            final List<CarminiteGhastlingEntity> nearbyGhasts = this.field_70170_p.func_217357_a((Class)CarminiteGhastlingEntity.class, aabb);
            if (nearbyGhasts.size() >= 4) {
                ++trapsWithEnoughGhasts;
            }
        }
        return trapsWithEnoughGhasts >= 1;
    }
    
    @Override
    protected void spitFireball() {
        final double offsetX = this.func_70638_az().func_226277_ct_() - this.func_226277_ct_();
        final double offsetY = this.func_70638_az().func_174813_aQ().field_72338_b + this.func_70638_az().func_213302_cg() / 2.0f - (this.func_226278_cu_() + this.func_213302_cg() / 2.0f);
        final double offsetZ = this.func_70638_az().func_226281_cx_() - this.func_226281_cx_();
        UrGhastFireballEntity entityFireball = new UrGhastFireballEntity(this.field_70170_p, this, offsetX, offsetY, offsetZ);
        entityFireball.field_92057_e = 1;
        final double shotSpawnDistance = 8.5;
        final Vector3d lookVec = this.func_70676_i(1.0f);
        entityFireball.func_70107_b(this.func_226277_ct_() + lookVec.field_72450_a * shotSpawnDistance, this.func_226278_cu_() + this.func_213302_cg() / 2.0f + lookVec.field_72448_b * shotSpawnDistance, this.func_226281_cx_() + lookVec.field_72449_c * shotSpawnDistance);
        this.field_70170_p.func_217376_c((Entity)entityFireball);
        for (int i = 0; i < 2; ++i) {
            entityFireball = new UrGhastFireballEntity(this.field_70170_p, this, offsetX + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 8.0f, offsetY, offsetZ + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 8.0f);
            entityFireball.field_92057_e = 1;
            entityFireball.func_70107_b(this.func_226277_ct_() + lookVec.field_72450_a * shotSpawnDistance, this.func_226278_cu_() + this.func_213302_cg() / 2.0f + lookVec.field_72448_b * shotSpawnDistance, this.func_226281_cx_() + lookVec.field_72449_c * shotSpawnDistance);
            this.field_70170_p.func_217376_c((Entity)entityFireball);
        }
    }
    
    private void scanForTrapsTwice() {
        final int scanRangeXZ = 48;
        final int scanRangeY = 32;
        this.scanForTraps(scanRangeXZ, scanRangeY, this.func_233580_cy_());
        if (this.trapLocations.size() > 0) {
            int ax = 0;
            int ay = 0;
            int az = 0;
            for (final BlockPos trapCoords : this.trapLocations) {
                ax += trapCoords.func_177958_n();
                ay += trapCoords.func_177956_o();
                az += trapCoords.func_177952_p();
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
                    final BlockPos trapCoords = pos.func_177982_a(sx, sy, sz);
                    if (this.isTrapAt(trapCoords)) {
                        this.trapLocations.add(trapCoords);
                    }
                }
            }
        }
    }
    
    private boolean isTrapAt(final BlockPos pos) {
        final BlockState inactive = (BlockState)((GhastTrapBlock)TFBlocks.ghast_trap.get()).func_176223_P().func_206870_a((Property)GhastTrapBlock.ACTIVE, (Comparable)false);
        final BlockState active = (BlockState)((GhastTrapBlock)TFBlocks.ghast_trap.get()).func_176223_P().func_206870_a((Property)GhastTrapBlock.ACTIVE, (Comparable)true);
        return this.field_70170_p.func_175667_e(pos) && (this.field_70170_p.func_180495_p(pos) == inactive || this.field_70170_p.func_180495_p(pos) == active);
    }
    
    public void func_184178_b(final ServerPlayerEntity player) {
        super.func_184178_b(player);
        this.bossInfo.func_186760_a(player);
    }
    
    public void func_184203_c(final ServerPlayerEntity player) {
        super.func_184203_c(player);
        this.bossInfo.func_186761_b(player);
    }
    
    public boolean func_70027_ad() {
        return false;
    }
    
    public boolean func_70104_M() {
        return false;
    }
    
    public boolean isInTantrum() {
        return (boolean)this.field_70180_af.func_187225_a((DataParameter)UrGhastEntity.DATA_TANTRUM);
    }
    
    public void setInTantrum(final boolean inTantrum) {
        this.field_70180_af.func_187227_b((DataParameter)UrGhastEntity.DATA_TANTRUM, (Object)inTantrum);
        this.resetDamageUntilNextPhase();
    }
    
    @Override
    protected float func_70599_aP() {
        return 16.0f;
    }
    
    protected float func_70647_i() {
        return (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f + 0.5f;
    }
    
    public void func_213281_b(final CompoundNBT compound) {
        compound.func_74757_a("inTantrum", this.isInTantrum());
        super.func_213281_b(compound);
    }
    
    public void func_70037_a(final CompoundNBT compound) {
        super.func_70037_a(compound);
        this.setInTantrum(compound.func_74767_n("inTantrum"));
        if (this.func_145818_k_()) {
            this.bossInfo.func_186739_a(this.func_145748_c_());
        }
    }
    
    protected void func_70609_aI() {
        super.func_70609_aI();
        if (this.field_70725_aQ == 20 && !this.field_70170_p.field_72995_K) {
            TFTreasure.darktower_boss.generateChest((IWorld)this.field_70170_p, this.findChestCoords(), Direction.NORTH, false);
        }
    }
    
    public void func_70645_a(final DamageSource cause) {
        super.func_70645_a(cause);
        if (!this.field_70170_p.field_72995_K) {
            TFGenerationSettings.markStructureConquered(this.field_70170_p, this.findChestCoords(), TFFeature.DARK_TOWER);
        }
    }
    
    private BlockPos findChestCoords() {
        if (this.trapLocations.size() > 0) {
            int ax = 0;
            int ay = 0;
            int az = 0;
            for (final BlockPos trapCoords : this.trapLocations) {
                ax += trapCoords.func_177958_n();
                ay += trapCoords.func_177956_o();
                az += trapCoords.func_177952_p();
            }
            ax /= this.trapLocations.size();
            ay /= this.trapLocations.size();
            az /= this.trapLocations.size();
            return new BlockPos(ax, ay + 2, az);
        }
        return new BlockPos((Vector3i)this.func_233580_cy_());
    }
    
    @Override
    protected boolean shouldAttack(final LivingEntity living) {
        return !this.isInTantrum();
    }
    
    @Override
    protected boolean func_184228_n(final Entity entityIn) {
        return false;
    }
    
    public boolean func_184222_aU() {
        return false;
    }
    
    static {
        DATA_TANTRUM = EntityDataManager.func_187226_a((Class)UrGhastEntity.class, DataSerializers.field_187198_h);
    }
    
    static class AIWaypointFly extends Goal
    {
        private final UrGhastEntity taskOwner;
        private final List<BlockPos> pointsToVisit;
        private int currentPoint;
        
        AIWaypointFly(final UrGhastEntity ghast) {
            this.currentPoint = 0;
            this.taskOwner = ghast;
            this.pointsToVisit = this.createPath();
            this.func_220684_a((EnumSet)EnumSet.of(Goal.Flag.MOVE));
        }
        
        public boolean func_75250_a() {
            final MovementController entitymovehelper = this.taskOwner.func_70605_aq();
            if (!entitymovehelper.func_75640_a()) {
                return true;
            }
            final double d0 = entitymovehelper.func_179917_d() - this.taskOwner.func_226277_ct_();
            final double d2 = entitymovehelper.func_179919_e() - this.taskOwner.func_226278_cu_();
            final double d3 = entitymovehelper.func_179918_f() - this.taskOwner.func_226281_cx_();
            final double d4 = d0 * d0 + d2 * d2 + d3 * d3;
            return d4 < 1.0 || d4 > 3600.0;
        }
        
        public boolean func_75253_b() {
            return false;
        }
        
        public void func_75249_e() {
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
                final double x = this.pointsToVisit.get(this.currentPoint).func_177958_n();
                final double y = this.pointsToVisit.get(this.currentPoint).func_177956_o() + 20;
                final double z = this.pointsToVisit.get(this.currentPoint).func_177952_p();
                this.taskOwner.func_70605_aq().func_75642_a(x, y, z, 1.0);
                ++this.currentPoint;
                this.taskOwner.field_70145_X = false;
            }
        }
        
        private List<BlockPos> createPath() {
            final List<BlockPos> potentialPoints = new ArrayList<BlockPos>();
            final BlockPos pos = new BlockPos((Vector3i)this.taskOwner.func_233580_cy_());
            if (!this.taskOwner.noTrapMode) {
                potentialPoints.addAll(this.taskOwner.trapLocations);
            }
            else {
                potentialPoints.add(pos.func_177982_a(20, -20, 0));
                potentialPoints.add(pos.func_177982_a(0, -20, -20));
                potentialPoints.add(pos.func_177982_a(-20, -20, 0));
                potentialPoints.add(pos.func_177982_a(0, -20, 20));
            }
            Collections.shuffle(potentialPoints);
            if (this.taskOwner.noTrapMode) {
                potentialPoints.add(pos.func_177979_c(20));
            }
            return potentialPoints;
        }
    }
}
