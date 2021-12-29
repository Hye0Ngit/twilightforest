// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.entity.ai.EntityAITasks;
import twilightforest.world.TFWorld;
import twilightforest.TFFeature;
import twilightforest.loot.TFTreasure;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.block.state.IBlockState;
import twilightforest.enums.TowerDeviceVariant;
import twilightforest.block.BlockTFTowerDevice;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.AxisAlignedBB;
import java.util.Iterator;
import net.minecraft.entity.EntityLivingBase;
import twilightforest.entity.EntityTFMiniGhast;
import net.minecraft.entity.effect.EntityLightningBolt;
import java.util.Collections;
import java.util.Collection;
import net.minecraft.world.storage.WorldInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import twilightforest.client.particle.TFParticleType;
import twilightforest.TwilightForestMod;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.BossVariant;
import twilightforest.block.BlockTFBossSpawner;
import twilightforest.block.TFBlocks;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.entity.ai.EntityAIBase;
import java.util.ArrayList;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityLiving;
import twilightforest.entity.NoClipMoveHelper;
import net.minecraft.world.BossInfo;
import net.minecraft.world.World;
import net.minecraft.world.BossInfoServer;
import net.minecraft.util.math.BlockPos;
import java.util.List;
import net.minecraft.network.datasync.DataParameter;
import twilightforest.entity.EntityTFTowerGhast;

public class EntityTFUrGhast extends EntityTFTowerGhast
{
    private static final DataParameter<Boolean> DATA_TANTRUM;
    private static final int HOVER_ALTITUDE = 20;
    private List<BlockPos> trapLocations;
    private int nextTantrumCry;
    private float damageUntilNextPhase;
    private boolean noTrapMode;
    private final BossInfoServer bossInfo;
    
    public EntityTFUrGhast(final World world) {
        super(world);
        this.damageUntilNextPhase = 10.0f;
        this.bossInfo = new BossInfoServer(this.func_145748_c_(), BossInfo.Color.RED, BossInfo.Overlay.PROGRESS);
        this.func_70105_a(14.0f, 18.0f);
        this.wanderFactor = 32.0f;
        this.field_70145_X = true;
        this.setInTantrum(false);
        this.field_70728_aV = 317;
        this.field_70765_h = new NoClipMoveHelper((EntityLiving)this);
    }
    
    public void func_96094_a(final String name) {
        super.func_96094_a(name);
        this.bossInfo.func_186739_a(this.func_145748_c_());
    }
    
    @Override
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(250.0);
        this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(128.0);
    }
    
    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)EntityTFUrGhast.DATA_TANTRUM, (Object)false);
    }
    
    @Override
    protected void func_184651_r() {
        super.func_184651_r();
        this.trapLocations = new ArrayList<BlockPos>();
        this.field_70714_bg.field_75782_a.removeIf(e -> e.field_75733_a instanceof AIHomedFly);
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new AIWaypointFly(this));
    }
    
    protected boolean func_70692_ba() {
        return false;
    }
    
    protected void func_70623_bb() {
        if (this.field_70170_p.func_175659_aa() == EnumDifficulty.PEACEFUL) {
            if (this.hasHome()) {
                this.field_70170_p.func_175656_a(this.getHomePosition(), TFBlocks.boss_spawner.func_176223_P().func_177226_a((IProperty)BlockTFBossSpawner.VARIANT, (Comparable)BossVariant.UR_GHAST));
            }
            this.func_70106_y();
        }
        else {
            super.func_70623_bb();
        }
    }
    
    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            this.bossInfo.func_186735_a(this.func_110143_aJ() / this.func_110138_aP());
        }
        else {
            if (this.isInTantrum()) {
                TwilightForestMod.proxy.spawnParticle(TFParticleType.BOSS_TEAR, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * this.field_70130_N, 0.0, 0.0, 0.0);
            }
            if (this.field_70725_aQ > 0) {
                for (int k = 0; k < 5; ++k) {
                    final double d = this.field_70146_Z.nextGaussian() * 0.02;
                    final double d2 = this.field_70146_Z.nextGaussian() * 0.02;
                    final double d3 = this.field_70146_Z.nextGaussian() * 0.02;
                    this.field_70170_p.func_175688_a(this.field_70146_Z.nextBoolean() ? EnumParticleTypes.EXPLOSION_HUGE : EnumParticleTypes.EXPLOSION_NORMAL, this.field_70165_t + this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0f - this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextFloat() * this.field_70131_O, this.field_70161_v + this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0f - this.field_70130_N, d, d2, d3, new int[0]);
                }
            }
        }
    }
    
    public boolean func_180431_b(final DamageSource src) {
        return src == DamageSource.field_76368_d || super.func_180431_b(src);
    }
    
    public void func_70653_a(final Entity entityIn, final float strength, final double xRatio, final double zRatio) {
    }
    
    public boolean func_70097_a(final DamageSource source, float damage) {
        if (this.isInTantrum()) {
            damage /= 10.0f;
        }
        final float oldHealth = this.func_110143_aJ();
        boolean attackSuccessful;
        if ("fireball".equals(source.func_76355_l()) && source.func_76346_g() instanceof EntityPlayer) {
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
        final WorldInfo worldInfo = this.field_70170_p.func_73046_m().field_71305_c[0].func_72912_H();
        worldInfo.func_176142_i(0);
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
        this.field_70170_p.func_72942_c((Entity)new EntityLightningBolt(this.field_70170_p, (double)x, (double)(y + 4), (double)z, true));
        for (int i = 0; i < tries; ++i) {
            final EntityTFMiniGhast minion = new EntityTFMiniGhast(this.field_70170_p);
            final double sx = x + (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble()) * rangeXZ;
            final double sy = y + this.field_70146_Z.nextDouble() * rangeY;
            final double sz = z + (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble()) * rangeXZ;
            minion.func_70012_b(sx, sy, sz, this.field_70170_p.field_73012_v.nextFloat() * 360.0f, 0.0f);
            minion.makeBossMinion();
            if (minion.func_70601_bi()) {
                this.field_70170_p.func_72838_d((Entity)minion);
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
        this.detachHome();
        for (final EntityTFMiniGhast ghast : this.field_70170_p.func_72872_a((Class)EntityTFMiniGhast.class, this.func_174813_aQ().func_72314_b(1.0, 1.0, 1.0))) {
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
            this.func_70624_b((EntityLivingBase)null);
            if (--this.nextTantrumCry <= 0) {
                this.func_184185_a(this.func_184601_bQ((DamageSource)null), this.func_70599_aP(), this.func_70647_i());
                this.nextTantrumCry = 20 + this.field_70146_Z.nextInt(30);
            }
            if (this.field_70173_aa % 10 == 0) {
                this.doTantrumDamageEffects();
            }
        }
    }
    
    private void doTantrumDamageEffects() {
        final AxisAlignedBB below = this.func_174813_aQ().func_72317_d(0.0, -16.0, 0.0).func_72314_b(0.0, 16.0, 0.0);
        for (final EntityPlayer player : this.field_70170_p.func_72872_a((Class)EntityPlayer.class, below)) {
            if (this.field_70170_p.func_175678_i(new BlockPos((Entity)player))) {
                player.func_70097_a(DamageSource.field_82728_o, 3.0f);
            }
        }
        for (final EntityTFMiniGhast entityTFMiniGhast : this.field_70170_p.func_72872_a((Class)EntityTFMiniGhast.class, below)) {
            final EntityTFMiniGhast ghast = entityTFMiniGhast;
            ++entityTFMiniGhast.field_70181_x;
        }
    }
    
    private boolean checkGhastsAtTraps() {
        int trapsWithEnoughGhasts = 0;
        for (final BlockPos trap : this.trapLocations) {
            final AxisAlignedBB aabb = new AxisAlignedBB(trap, trap.func_177982_a(1, 1, 1)).func_72314_b(8.0, 16.0, 8.0);
            final List<EntityTFMiniGhast> nearbyGhasts = this.field_70170_p.func_72872_a((Class)EntityTFMiniGhast.class, aabb);
            if (nearbyGhasts.size() >= 4) {
                ++trapsWithEnoughGhasts;
            }
        }
        return trapsWithEnoughGhasts >= 1;
    }
    
    @Override
    protected void spitFireball() {
        final double offsetX = this.func_70638_az().field_70165_t - this.field_70165_t;
        final double offsetY = this.func_70638_az().func_174813_aQ().field_72338_b + this.func_70638_az().field_70131_O / 2.0f - (this.field_70163_u + this.field_70131_O / 2.0f);
        final double offsetZ = this.func_70638_az().field_70161_v - this.field_70161_v;
        EntityTFUrGhastFireball entityFireball = new EntityTFUrGhastFireball(this.field_70170_p, this, offsetX, offsetY, offsetZ);
        entityFireball.field_92057_e = 1;
        final double shotSpawnDistance = 8.5;
        final Vec3d lookVec = this.func_70676_i(1.0f);
        entityFireball.field_70165_t = this.field_70165_t + lookVec.field_72450_a * shotSpawnDistance;
        entityFireball.field_70163_u = this.field_70163_u + this.field_70131_O / 2.0f + lookVec.field_72448_b * shotSpawnDistance;
        entityFireball.field_70161_v = this.field_70161_v + lookVec.field_72449_c * shotSpawnDistance;
        this.field_70170_p.func_72838_d((Entity)entityFireball);
        for (int i = 0; i < 2; ++i) {
            entityFireball = new EntityTFUrGhastFireball(this.field_70170_p, this, offsetX + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 8.0f, offsetY, offsetZ + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 8.0f);
            entityFireball.field_92057_e = 1;
            entityFireball.field_70165_t = this.field_70165_t + lookVec.field_72450_a * shotSpawnDistance;
            entityFireball.field_70163_u = this.field_70163_u + this.field_70131_O / 2.0f + lookVec.field_72448_b * shotSpawnDistance;
            entityFireball.field_70161_v = this.field_70161_v + lookVec.field_72449_c * shotSpawnDistance;
            this.field_70170_p.func_72838_d((Entity)entityFireball);
        }
    }
    
    private void scanForTrapsTwice() {
        final int scanRangeXZ = 48;
        final int scanRangeY = 32;
        this.scanForTraps(scanRangeXZ, scanRangeY, new BlockPos((Entity)this));
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
        final IBlockState inactive = TFBlocks.tower_device.func_176223_P().func_177226_a((IProperty)BlockTFTowerDevice.VARIANT, (Comparable)TowerDeviceVariant.GHASTTRAP_INACTIVE);
        final IBlockState active = TFBlocks.tower_device.func_176223_P().func_177226_a((IProperty)BlockTFTowerDevice.VARIANT, (Comparable)TowerDeviceVariant.GHASTTRAP_ACTIVE);
        return this.field_70170_p.func_175667_e(pos) && (this.field_70170_p.func_180495_p(pos) == inactive || this.field_70170_p.func_180495_p(pos) == active);
    }
    
    public void func_184178_b(final EntityPlayerMP player) {
        super.func_184178_b(player);
        this.bossInfo.func_186760_a(player);
    }
    
    public void func_184203_c(final EntityPlayerMP player) {
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
        return (boolean)this.field_70180_af.func_187225_a((DataParameter)EntityTFUrGhast.DATA_TANTRUM);
    }
    
    public void setInTantrum(final boolean inTantrum) {
        this.field_70180_af.func_187227_b((DataParameter)EntityTFUrGhast.DATA_TANTRUM, (Object)inTantrum);
        this.resetDamageUntilNextPhase();
    }
    
    @Override
    protected float func_70599_aP() {
        return 16.0f;
    }
    
    protected float func_70647_i() {
        return (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f + 0.5f;
    }
    
    public void func_70014_b(final NBTTagCompound compound) {
        compound.func_74757_a("inTantrum", this.isInTantrum());
        super.func_70014_b(compound);
    }
    
    public void func_70037_a(final NBTTagCompound compound) {
        super.func_70037_a(compound);
        this.setInTantrum(compound.func_74767_n("inTantrum"));
        if (this.func_145818_k_()) {
            this.bossInfo.func_186739_a(this.func_145748_c_());
        }
    }
    
    protected void func_70609_aI() {
        super.func_70609_aI();
        if (this.field_70725_aQ == 20 && !this.field_70170_p.field_72995_K) {
            TFTreasure.darktower_boss.generateChest(this.field_70170_p, this.findChestCoords(), false);
        }
    }
    
    public void func_70645_a(final DamageSource cause) {
        super.func_70645_a(cause);
        if (!this.field_70170_p.field_72995_K) {
            TFWorld.markStructureConquered(this.field_70170_p, this.findChestCoords(), TFFeature.DARK_TOWER);
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
        return new BlockPos((Entity)this);
    }
    
    @Override
    protected boolean shouldAttack(final EntityLivingBase living) {
        return !this.isInTantrum();
    }
    
    public boolean func_184222_aU() {
        return false;
    }
    
    static {
        DATA_TANTRUM = EntityDataManager.func_187226_a((Class)EntityTFUrGhast.class, DataSerializers.field_187198_h);
    }
    
    static class AIWaypointFly extends EntityAIBase
    {
        private final EntityTFUrGhast taskOwner;
        private final List<BlockPos> pointsToVisit;
        private int currentPoint;
        
        AIWaypointFly(final EntityTFUrGhast ghast) {
            this.currentPoint = 0;
            this.taskOwner = ghast;
            this.pointsToVisit = this.createPath();
            this.func_75248_a(1);
        }
        
        public boolean func_75250_a() {
            final EntityMoveHelper entitymovehelper = this.taskOwner.func_70605_aq();
            if (!entitymovehelper.func_75640_a()) {
                return true;
            }
            final double d0 = entitymovehelper.func_179917_d() - this.taskOwner.field_70165_t;
            final double d2 = entitymovehelper.func_179919_e() - this.taskOwner.field_70163_u;
            final double d3 = entitymovehelper.func_179918_f() - this.taskOwner.field_70161_v;
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
            final BlockPos pos = new BlockPos((Entity)this.taskOwner);
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
