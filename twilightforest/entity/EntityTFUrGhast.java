// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import java.util.Random;
import twilightforest.TFTreasure;
import net.minecraft.nbt.NBTTagCompound;
import twilightforest.block.TFBlocks;
import net.minecraft.util.Vec3;
import twilightforest.TwilightForestMod;
import net.minecraft.util.AxisAlignedBB;
import java.util.Iterator;
import java.util.List;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import java.util.Collection;
import net.minecraft.world.storage.WorldInfo;
import net.minecraft.server.MinecraftServer;
import cpw.mods.fml.common.FMLLog;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;
import net.minecraft.util.ChunkCoordinates;
import java.util.ArrayList;
import net.minecraft.entity.boss.IBossDisplayData;

public class EntityTFUrGhast extends EntityTFTowerGhast implements IBossDisplayData
{
    private static final int DATA_TANTRUM = 18;
    private static final int CRUISING_ALTITUDE = 235;
    private static final int HOVER_ALTITUDE = 20;
    public double courseX;
    public double courseY;
    public double courseZ;
    ArrayList<ChunkCoordinates> trapLocations;
    ArrayList<ChunkCoordinates> travelCoords;
    int currentTravelCoordIndex;
    int travelPathRepetitions;
    int desiredRepetitions;
    int nextTantrumCry;
    float damageUntilNextPhase;
    boolean noTrapMode;
    
    public EntityTFUrGhast(final World par1World) {
        super(par1World);
        this.func_70105_a(14.0f, 18.0f);
        this.aggroRange = 128.0f;
        this.wanderFactor = 32.0f;
        this.field_70145_X = true;
        this.trapLocations = new ArrayList<ChunkCoordinates>();
        this.travelCoords = new ArrayList<ChunkCoordinates>();
        this.setInTantrum(false);
        this.damageUntilNextPhase = 45.0f;
        this.field_70728_aV = 317;
        this.noTrapMode = false;
    }
    
    @Override
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(250.0);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(18, (Object)0);
    }
    
    protected boolean func_70692_ba() {
        return false;
    }
    
    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        final byte aggroStatus = this.field_70180_af.func_75683_a(16);
        if (this.field_70725_aQ > 0) {
            for (int k = 0; k < 5; ++k) {
                final double d = this.field_70146_Z.nextGaussian() * 0.02;
                final double d2 = this.field_70146_Z.nextGaussian() * 0.02;
                final double d3 = this.field_70146_Z.nextGaussian() * 0.02;
                final String explosionType = this.field_70146_Z.nextBoolean() ? "hugeexplosion" : "explode";
                this.field_70170_p.func_72869_a(explosionType, this.field_70165_t + this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0f - this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextFloat() * this.field_70131_O, this.field_70161_v + this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0f - this.field_70130_N, d, d2, d3);
            }
        }
    }
    
    @Override
    public boolean func_70097_a(final DamageSource source, float damage) {
        if (source == DamageSource.field_76368_d) {
            return false;
        }
        boolean attackSuccessful = false;
        if (this.isInTantrum()) {
            damage /= 4.0f;
        }
        if ("fireball".equals(source.func_76355_l()) && source.func_76346_g() instanceof EntityPlayer) {
            attackSuccessful = super.func_70097_a(DamageSource.func_76356_a(source.func_76364_f(), source.func_76346_g()), damage);
        }
        else {
            attackSuccessful = super.func_70097_a(source, damage);
        }
        if (!this.field_70170_p.field_72995_K) {
            if (this.field_70737_aN == this.field_70738_aO) {
                this.damageUntilNextPhase -= this.getLastDamage();
                FMLLog.info("[Urghast] Attack successful, %f damage until phase switch.", new Object[] { this.damageUntilNextPhase });
                if (this.damageUntilNextPhase <= 0.0f) {
                    this.switchPhase();
                }
            }
            else {
                FMLLog.info("[Urghast] Attack fail with %s type attack for %f damage", new Object[] { source.field_76373_n, damage });
            }
        }
        return attackSuccessful;
    }
    
    private float getLastDamage() {
        return this.field_70735_aL - this.func_110143_aJ();
    }
    
    private void switchPhase() {
        if (this.isInTantrum()) {
            this.stopTantrum();
        }
        else {
            this.startTantrum();
        }
        this.damageUntilNextPhase = 48.0f;
    }
    
    protected void startTantrum() {
        this.setInTantrum(true);
        final int rainTime = 6000;
        final WorldInfo worldInfo = MinecraftServer.func_71276_C().field_71305_c[0].func_72912_H();
        worldInfo.func_76084_b(true);
        worldInfo.func_76069_a(true);
        worldInfo.func_76080_g(rainTime);
        worldInfo.func_76090_f(rainTime);
        this.spawnGhastsAtTraps();
    }
    
    protected void spawnGhastsAtTraps() {
        final ArrayList<ChunkCoordinates> ghastSpawns = new ArrayList<ChunkCoordinates>(this.trapLocations);
        for (int numSpawns = Math.min(2, ghastSpawns.size()), i = 0; i < numSpawns; ++i) {
            final int index = this.field_70146_Z.nextInt(ghastSpawns.size());
            final ChunkCoordinates spawnCoord = ghastSpawns.get(index);
            ghastSpawns.remove(index);
            this.spawnMinionGhastsAt(spawnCoord.field_71574_a, spawnCoord.field_71572_b, spawnCoord.field_71573_c);
        }
    }
    
    public void stopTantrum() {
        this.setInTantrum(false);
    }
    
    private void spawnMinionGhastsAt(final int x, final int y, final int z) {
        final int tries = 24;
        int spawns = 0;
        final int maxSpawns = 6;
        final int rangeXZ = 4;
        final int rangeY = 8;
        this.field_70170_p.func_72942_c((Entity)new EntityLightningBolt(this.field_70170_p, (double)x, (double)(y + 4), (double)z));
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
    protected void func_70626_be() {
        if (!this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u == 0) {
            this.func_70106_y();
        }
        this.func_70623_bb();
        final List<EntityTFMiniGhast> nearbyGhasts = this.field_70170_p.func_72872_a((Class)EntityTFMiniGhast.class, this.field_70121_D.func_72314_b(1.0, 1.0, 1.0));
        for (final EntityTFMiniGhast ghast : nearbyGhasts) {
            ghast.func_70106_y();
            this.func_70691_i(2.0f);
        }
        if (this.trapLocations.isEmpty() && !this.noTrapMode) {
            this.scanForTrapsTwice();
        }
        if (this.trapLocations.isEmpty() && !this.noTrapMode) {
            FMLLog.info("[TwilightForest] Ur-ghast cannot find traps nearby, entering trap-less mode", new Object[0]);
            this.noTrapMode = true;
        }
        if (this.inTrapCounter > 0) {
            --this.inTrapCounter;
            this.field_70792_g = null;
            return;
        }
        this.field_70794_e = this.field_70791_f;
        if (this.field_70792_g != null && this.field_70792_g.field_70128_L) {
            this.field_70792_g = null;
        }
        if (this.field_70792_g == null) {
            this.field_70792_g = this.findPlayerInRange();
        }
        else if (!this.isAggressive && this.field_70792_g instanceof EntityPlayer) {
            this.checkToIncreaseAggro((EntityPlayer)this.field_70792_g);
        }
        if (this.isInTantrum()) {
            this.shedTear();
            this.field_70792_g = null;
            if (--this.nextTantrumCry <= 0) {
                this.func_85030_a(this.func_70621_aR(), this.func_70599_aP(), this.func_70647_i());
                this.nextTantrumCry = 20 + this.field_70146_Z.nextInt(30);
            }
            if (this.field_70173_aa % 10 == 0) {
                this.doTantrumDamageEffects();
            }
        }
        this.checkAndChangeCourse();
        final double offsetX = this.field_70795_b - this.field_70165_t;
        final double offsetY = this.field_70796_c - this.field_70163_u;
        final double offsetZ = this.field_70793_d - this.field_70161_v;
        double distanceToWaypoint = offsetX * offsetX + offsetY * offsetY + offsetZ * offsetZ;
        if (distanceToWaypoint < 1.0 || distanceToWaypoint > 3600.0) {
            this.makeNewWaypoint();
        }
        if (this.field_70797_a-- <= 0) {
            this.field_70797_a += this.field_70146_Z.nextInt(5) + 0;
            distanceToWaypoint = MathHelper.func_76133_a(distanceToWaypoint);
            final double speed = 0.05;
            this.field_70159_w += offsetX / distanceToWaypoint * speed;
            this.field_70181_x += offsetY / distanceToWaypoint * speed;
            this.field_70179_y += offsetZ / distanceToWaypoint * speed;
        }
        final double targetRange = (this.aggroCounter > 0 || this.isAggressive) ? this.aggroRange : ((double)this.stareRange);
        if (this.field_70792_g != null && this.field_70792_g.func_70068_e((Entity)this) < targetRange * targetRange && this.func_70685_l((Entity)this.field_70792_g)) {
            this.func_70625_a((Entity)this.field_70792_g, 10.0f, (float)this.func_70646_bf());
            if (this.isAggressive) {
                if (this.field_70791_f == 10) {
                    this.func_85030_a("mob.ghast.charge", this.func_70599_aP(), this.func_70647_i());
                }
                ++this.field_70791_f;
                if (this.field_70791_f == 20) {
                    this.spitFireball();
                    this.field_70791_f = -40;
                }
            }
        }
        else {
            this.isAggressive = false;
            this.field_70792_g = null;
            this.field_70177_z = -(float)Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0f / 3.1415927f;
            this.field_70125_A = 0.0f;
        }
        if (this.field_70791_f > 0 && !this.isAggressive) {
            --this.field_70791_f;
        }
        final byte currentAggroStatus = this.field_70180_af.func_75683_a(16);
        final byte newAggroStatus = (byte)((this.field_70791_f > 10) ? 2 : ((this.aggroCounter > 0 || this.isAggressive) ? 1 : 0));
        if (currentAggroStatus != newAggroStatus) {
            this.field_70180_af.func_75692_b(16, (Object)newAggroStatus);
        }
    }
    
    private void doTantrumDamageEffects() {
        final AxisAlignedBB below = this.field_70121_D.func_72325_c(0.0, -16.0, 0.0).func_72314_b(0.0, 16.0, 0.0);
        final List<EntityPlayer> playersBelow = this.field_70170_p.func_72872_a((Class)EntityPlayer.class, below);
        for (final EntityPlayer player : playersBelow) {
            final int dx = MathHelper.func_76128_c(player.field_70165_t);
            final int dy = MathHelper.func_76128_c(player.field_70163_u);
            final int dz = MathHelper.func_76128_c(player.field_70161_v);
            if (this.field_70170_p.func_72937_j(dx, dy, dz)) {
                player.func_70097_a(DamageSource.field_82728_o, 3.0f);
            }
        }
        final List<EntityTFMiniGhast> ghastsBelow = this.field_70170_p.func_72872_a((Class)EntityTFMiniGhast.class, below);
        for (final EntityTFMiniGhast entityTFMiniGhast : ghastsBelow) {
            final EntityTFMiniGhast ghast = entityTFMiniGhast;
            ++entityTFMiniGhast.field_70181_x;
        }
    }
    
    private void shedTear() {
        TwilightForestMod.proxy.spawnParticle("bosstear", this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * this.field_70130_N, 0.0, 0.0, 0.0);
    }
    
    protected void makeNewWaypoint() {
        double closestDistance = this.func_70092_e(this.courseX, this.courseY, this.courseZ);
        for (int i = 0; i < 50; ++i) {
            final double potentialX = this.field_70165_t + (this.field_70146_Z.nextFloat() * 2.0f - 1.0f) * this.wanderFactor;
            final double potentialY = this.courseY + this.field_70146_Z.nextFloat() * 8.0f - 4.0;
            final double potentialZ = this.field_70161_v + (this.field_70146_Z.nextFloat() * 2.0f - 1.0f) * this.wanderFactor;
            final double offsetX = this.courseX - potentialX;
            final double offsetY = this.courseY - potentialY;
            final double offsetZ = this.courseZ - potentialZ;
            final double potentialDistanceToCourse = offsetX * offsetX + offsetY * offsetY + offsetZ * offsetZ;
            if (potentialDistanceToCourse < closestDistance) {
                this.field_70795_b = potentialX;
                this.field_70796_c = potentialY;
                this.field_70793_d = potentialZ;
                closestDistance = potentialDistanceToCourse;
            }
        }
    }
    
    protected void checkAndChangeCourse() {
        if (this.courseX == 0.0 && this.courseY == 0.0 && this.courseZ == 0.0) {
            this.changeCourse();
        }
        final double offsetX = this.courseX - this.field_70165_t;
        final double offsetY = this.courseY - this.field_70163_u;
        final double offsetZ = this.courseZ - this.field_70161_v;
        final double distanceToCourse = offsetX * offsetX + offsetY * offsetY + offsetZ * offsetZ;
        if (distanceToCourse < 100.0) {
            this.changeCourse();
        }
    }
    
    private void changeCourse() {
        if (this.travelCoords.isEmpty()) {
            this.makeTravelPath();
        }
        if (!this.travelCoords.isEmpty()) {
            if (this.currentTravelCoordIndex >= this.travelCoords.size()) {
                this.currentTravelCoordIndex = 0;
                ++this.travelPathRepetitions;
                if (!this.checkGhastsAtTraps()) {
                    this.spawnGhastsAtTraps();
                }
            }
            this.courseX = this.travelCoords.get(this.currentTravelCoordIndex).field_71574_a;
            this.courseY = this.travelCoords.get(this.currentTravelCoordIndex).field_71572_b + 20;
            this.courseZ = this.travelCoords.get(this.currentTravelCoordIndex).field_71573_c;
            ++this.currentTravelCoordIndex;
        }
    }
    
    private boolean checkGhastsAtTraps() {
        int trapsWithEnoughGhasts = 0;
        for (final ChunkCoordinates trap : this.trapLocations) {
            final AxisAlignedBB aabb = AxisAlignedBB.func_72332_a().func_72299_a((double)trap.field_71574_a, (double)trap.field_71572_b, (double)trap.field_71573_c, (double)(trap.field_71574_a + 1), (double)(trap.field_71572_b + 1), (double)(trap.field_71573_c + 1)).func_72314_b(8.0, 16.0, 8.0);
            final List<EntityTFMiniGhast> nearbyGhasts = this.field_70170_p.func_72872_a((Class)EntityTFMiniGhast.class, aabb);
            if (nearbyGhasts.size() >= 4) {
                ++trapsWithEnoughGhasts;
            }
        }
        return trapsWithEnoughGhasts >= 1;
    }
    
    private void makeTravelPath() {
        final int px = MathHelper.func_76128_c(this.field_70165_t);
        final int py = MathHelper.func_76128_c(this.field_70163_u);
        final int pz = MathHelper.func_76128_c(this.field_70161_v);
        ArrayList<ChunkCoordinates> potentialPoints;
        if (!this.noTrapMode) {
            potentialPoints = new ArrayList<ChunkCoordinates>(this.trapLocations);
        }
        else {
            potentialPoints = new ArrayList<ChunkCoordinates>();
            potentialPoints.add(new ChunkCoordinates(px + 20, py - 20, pz));
            potentialPoints.add(new ChunkCoordinates(px, py - 20, pz - 20));
            potentialPoints.add(new ChunkCoordinates(px - 20, py - 20, pz));
            potentialPoints.add(new ChunkCoordinates(px, py - 20, pz + 20));
        }
        this.travelCoords.clear();
        while (!potentialPoints.isEmpty()) {
            final int index = this.field_70146_Z.nextInt(potentialPoints.size());
            this.travelCoords.add(potentialPoints.get(index));
            potentialPoints.remove(index);
        }
        if (this.noTrapMode) {
            this.travelCoords.add(new ChunkCoordinates(px, py - 20, pz));
        }
    }
    
    @Override
    protected void spitFireball() {
        final double offsetX = this.field_70792_g.field_70165_t - this.field_70165_t;
        final double offsetY = this.field_70792_g.field_70121_D.field_72338_b + this.field_70792_g.field_70131_O / 2.0f - (this.field_70163_u + this.field_70131_O / 2.0f);
        final double offsetZ = this.field_70792_g.field_70161_v - this.field_70161_v;
        this.field_70170_p.func_72889_a((EntityPlayer)null, 1008, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
        EntityTFUrGhastFireball entityFireball = new EntityTFUrGhastFireball(this.field_70170_p, this, offsetX, offsetY, offsetZ);
        entityFireball.field_92057_e = 1;
        final double shotSpawnDistance = 8.5;
        final Vec3 lookVec = this.func_70676_i(1.0f);
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
        final int px = MathHelper.func_76128_c(this.field_70165_t);
        final int py = MathHelper.func_76128_c(this.field_70163_u);
        final int pz = MathHelper.func_76128_c(this.field_70161_v);
        this.scanForTraps(scanRangeXZ, scanRangeY, px, py, pz);
        if (this.trapLocations.size() > 0) {
            int ax = 0;
            int ay = 0;
            int az = 0;
            for (final ChunkCoordinates trapCoords : this.trapLocations) {
                ax += trapCoords.field_71574_a;
                ay += trapCoords.field_71572_b;
                az += trapCoords.field_71573_c;
            }
            ax /= this.trapLocations.size();
            ay /= this.trapLocations.size();
            az /= this.trapLocations.size();
            this.scanForTraps(scanRangeXZ, scanRangeY, ax, ay, az);
        }
    }
    
    protected void scanForTraps(final int scanRangeXZ, final int scanRangeY, final int px, final int py, final int pz) {
        for (int sx = -scanRangeXZ; sx <= scanRangeXZ; ++sx) {
            for (int sz = -scanRangeXZ; sz <= scanRangeXZ; ++sz) {
                for (int sy = -scanRangeY; sy <= scanRangeY; ++sy) {
                    if (this.isTrapAt(px + sx, py + sy, pz + sz)) {
                        final ChunkCoordinates trapCoords = new ChunkCoordinates(px + sx, py + sy, pz + sz);
                        if (!this.trapLocations.contains(trapCoords)) {
                            this.trapLocations.add(trapCoords);
                        }
                    }
                }
            }
        }
    }
    
    private boolean isTrapAt(final int x, final int y, final int z) {
        return this.field_70170_p.func_72899_e(x, y, z) && this.field_70170_p.func_72798_a(x, y, z) == TFBlocks.towerDevice.field_71990_ca && (this.field_70170_p.func_72805_g(x, y, z) == 10 || this.field_70170_p.func_72805_g(x, y, z) == 11);
    }
    
    public boolean func_70027_ad() {
        return false;
    }
    
    public boolean func_70104_M() {
        return false;
    }
    
    public boolean isInTantrum() {
        return this.field_70180_af.func_75683_a(18) != 0;
    }
    
    public void setInTantrum(final boolean par1) {
        this.field_70180_af.func_75692_b(18, (Object)(par1 ? -1 : ((Byte)0)));
        this.damageUntilNextPhase = 48.0f;
    }
    
    @Override
    protected float func_70599_aP() {
        return 16.0f;
    }
    
    protected float func_70647_i() {
        return (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f + 0.5f;
    }
    
    public void func_70014_b(final NBTTagCompound nbttagcompound) {
        nbttagcompound.func_74757_a("inTantrum", this.isInTantrum());
        super.func_70014_b(nbttagcompound);
    }
    
    public void func_70037_a(final NBTTagCompound nbttagcompound) {
        super.func_70037_a(nbttagcompound);
        this.setInTantrum(nbttagcompound.func_74767_n("inTantrum"));
    }
    
    protected void func_70609_aI() {
        super.func_70609_aI();
        if (this.field_70725_aQ == 20 && !this.field_70170_p.field_72995_K) {
            final ChunkCoordinates chestCoords = this.findChestCoords();
            TFTreasure.darktower_boss.generate(this.field_70170_p, null, chestCoords.field_71574_a, chestCoords.field_71572_b, chestCoords.field_71573_c);
        }
    }
    
    private ChunkCoordinates findChestCoords() {
        if (this.trapLocations.size() > 0) {
            int ax = 0;
            int ay = 0;
            int az = 0;
            for (final ChunkCoordinates trapCoords : this.trapLocations) {
                ax += trapCoords.field_71574_a;
                ay += trapCoords.field_71572_b;
                az += trapCoords.field_71573_c;
            }
            ax /= this.trapLocations.size();
            ay /= this.trapLocations.size();
            az /= this.trapLocations.size();
            return new ChunkCoordinates(ax, ay + 2, az);
        }
        return new ChunkCoordinates(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v));
    }
}
