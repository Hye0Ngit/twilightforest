// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import java.util.Random;
import twilightforest.TFTreasure;
import twilightforest.block.TFBlocks;
import twilightforest.TwilightForestMod;
import java.util.Iterator;
import java.util.List;
import cpw.mods.fml.common.FMLLog;
import java.util.Collection;
import net.minecraft.server.MinecraftServer;
import java.util.ArrayList;

public class EntityTFUrGhast extends EntityTFTowerGhast implements qp
{
    private static final int DATA_BOSSHEALTH = 17;
    private static final int DATA_TANTRUM = 18;
    private static final int CRUISING_ALTITUDE = 235;
    private static final int HOVER_ALTITUDE = 20;
    public double courseX;
    public double courseY;
    public double courseZ;
    ArrayList trapLocations;
    ArrayList travelCoords;
    int currentTravelCoordIndex;
    int travelPathRepetitions;
    int desiredRepetitions;
    int nextTantrumCry;
    int fireballTolerance;
    boolean noTrapMode;
    
    public EntityTFUrGhast(final zv par1World) {
        super(par1World);
        this.a(14.0f, 18.0f);
        this.aggroRange = 128.0f;
        this.wanderFactor = 32.0f;
        this.aH = "/mods/twilightforest/textures/model/towerboss.png";
        this.Z = true;
        this.trapLocations = new ArrayList();
        this.travelCoords = new ArrayList();
        this.setInTantrum(false);
        this.fireballTolerance = 3;
        this.be = 317;
        this.noTrapMode = false;
    }
    
    @Override
    public int aW() {
        return 250;
    }
    
    protected void a() {
        super.a();
        this.ah.a(17, (Object)new Integer(this.aW()));
        this.ah.a(18, (Object)0);
    }
    
    protected boolean bm() {
        return false;
    }
    
    @Override
    public void l_() {
        super.l_();
        if (!this.q.I) {
            this.ah.b(17, (Object)this.aS);
        }
        final byte aggroStatus = this.ah.a(16);
        switch (aggroStatus) {
            default: {
                this.aH = "/mods/twilightforest/textures/model/towerboss.png";
                break;
            }
            case 1: {
                this.aH = "/mods/twilightforest/textures/model/towerboss_openeyes.png";
                break;
            }
            case 2: {
                this.aH = "/mods/twilightforest/textures/model/towerboss_fire.png";
                break;
            }
        }
        if (this.aZ > 0) {
            for (int k = 0; k < 5; ++k) {
                final double d = this.ab.nextGaussian() * 0.02;
                final double d2 = this.ab.nextGaussian() * 0.02;
                final double d3 = this.ab.nextGaussian() * 0.02;
                final String explosionType = this.ab.nextBoolean() ? "hugeexplosion" : "explode";
                this.q.a(explosionType, this.u + this.ab.nextFloat() * this.O * 2.0f - this.O, this.v + this.ab.nextFloat() * this.P, this.w + this.ab.nextFloat() * this.O * 2.0f - this.O, d, d2, d3);
            }
        }
    }
    
    @Override
    public boolean a(final mg par1DamageSource, final int par2) {
        if (par1DamageSource == mg.d) {
            return false;
        }
        if ("fireball".equals(par1DamageSource.n()) && par1DamageSource.i() instanceof sk) {
            if (--this.fireballTolerance == 0) {
                this.startTantrum();
            }
            return super.a(mg.a(par1DamageSource.h(), par1DamageSource.i()), par2);
        }
        return super.a(par1DamageSource, par2);
    }
    
    protected void startTantrum() {
        this.setInTantrum(true);
        final int rainTime = 6000;
        final ajp worldInfo = MinecraftServer.D().b[0].L();
        worldInfo.b(true);
        worldInfo.a(true);
        worldInfo.g(rainTime);
        worldInfo.f(rainTime);
        this.spawnGhastsAtTraps();
    }
    
    protected void spawnGhastsAtTraps() {
        final ArrayList ghastSpawns = new ArrayList(this.trapLocations);
        for (int numSpawns = Math.min(2, ghastSpawns.size()), i = 0; i < numSpawns; ++i) {
            final int index = this.ab.nextInt(ghastSpawns.size());
            final t spawnCoord = ghastSpawns.get(index);
            ghastSpawns.remove(index);
            this.spawnMinionGhastsAt(spawnCoord.a, spawnCoord.b, spawnCoord.c);
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
        this.q.c((mp)new qy(this.q, (double)x, (double)(y + 4), (double)z));
        for (int i = 0; i < tries; ++i) {
            final EntityTFMiniGhast minion = new EntityTFMiniGhast(this.q);
            final double sx = x + (this.ab.nextDouble() - this.ab.nextDouble()) * rangeXZ;
            final double sy = y + this.ab.nextDouble() * rangeY;
            final double sz = z + (this.ab.nextDouble() - this.ab.nextDouble()) * rangeXZ;
            minion.b(sx, sy, sz, this.q.s.nextFloat() * 360.0f, 0.0f);
            minion.makeBossMinion();
            if (minion.bv()) {
                this.q.d((mp)minion);
                minion.aU();
            }
            if (++spawns >= maxSpawns) {
                break;
            }
        }
    }
    
    @Override
    protected void bq() {
        if (!this.q.I && this.q.r == 0) {
            this.w();
        }
        this.bn();
        final List nearbyGhasts = this.q.a((Class)EntityTFMiniGhast.class, this.E.b(1.0, 1.0, 1.0));
        for (final EntityTFMiniGhast ghast : nearbyGhasts) {
            ghast.w();
            this.j(2);
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
            this.targetedEntity = null;
            return;
        }
        this.f = this.g;
        if (this.targetedEntity != null && this.targetedEntity.M) {
            this.targetedEntity = null;
        }
        if (this.targetedEntity == null) {
            this.targetedEntity = this.findPlayerInRange();
        }
        else if (!this.isAggressive && this.targetedEntity instanceof sk) {
            this.checkToIncreaseAggro((sk)this.targetedEntity);
        }
        if (this.isInTantrum()) {
            this.shedTear();
            this.targetedEntity = null;
            if (--this.nextTantrumCry <= 0) {
                this.a(this.bc(), this.ba(), this.aY());
                this.nextTantrumCry = 20 + this.ab.nextInt(30);
            }
            if (this.ac % 10 == 0) {
                this.doTantrumDamageEffects();
            }
        }
        this.checkAndChangeCourse();
        final double offsetX = this.c - this.u;
        final double offsetY = this.d - this.v;
        final double offsetZ = this.e - this.w;
        double distanceToWaypoint = offsetX * offsetX + offsetY * offsetY + offsetZ * offsetZ;
        if (distanceToWaypoint < 1.0 || distanceToWaypoint > 3600.0) {
            this.makeNewWaypoint();
        }
        if (this.b-- <= 0) {
            this.b += this.ab.nextInt(5) + 0;
            distanceToWaypoint = kx.a(distanceToWaypoint);
            final double speed = 0.05;
            this.x += offsetX / distanceToWaypoint * speed;
            this.y += offsetY / distanceToWaypoint * speed;
            this.z += offsetZ / distanceToWaypoint * speed;
        }
        final double targetRange = (this.aggroCounter > 0 || this.isAggressive) ? this.aggroRange : ((double)this.stareRange);
        if (this.targetedEntity != null && this.targetedEntity.e((mp)this) < targetRange * targetRange && this.n((mp)this.targetedEntity)) {
            this.a((mp)this.targetedEntity, 10.0f, (float)this.bs());
            if (this.isAggressive) {
                if (this.g == 10) {
                    this.a("mob.ghast.charge", this.ba(), this.aY());
                }
                ++this.g;
                if (this.g == 20) {
                    this.spitFireball();
                    this.g = -40;
                }
            }
        }
        else {
            this.isAggressive = false;
            this.targetedEntity = null;
            this.A = -(float)Math.atan2(this.x, this.z) * 180.0f / 3.1415927f;
            this.B = 0.0f;
        }
        if (this.g > 0 && !this.isAggressive) {
            --this.g;
        }
        final byte currentAggroStatus = this.ah.a(16);
        final byte newAggroStatus = (byte)((this.g > 10) ? 2 : ((this.aggroCounter > 0 || this.isAggressive) ? 1 : 0));
        if (currentAggroStatus != newAggroStatus) {
            this.ah.b(16, (Object)newAggroStatus);
        }
    }
    
    private void doTantrumDamageEffects() {
        final aqr below = this.E.c(0.0, -16.0, 0.0).b(0.0, 16.0, 0.0);
        final List playersBelow = this.q.a((Class)sk.class, below);
        for (final sk player : playersBelow) {
            final int dx = kx.c(player.u);
            final int dy = kx.c(player.v);
            final int dz = kx.c(player.w);
            if (this.q.l(dx, dy, dz)) {
                player.a(mg.m, 3);
            }
        }
        final List ghastsBelow = this.q.a((Class)EntityTFMiniGhast.class, below);
        for (final EntityTFMiniGhast entityTFMiniGhast : ghastsBelow) {
            final EntityTFMiniGhast ghast = entityTFMiniGhast;
            ++entityTFMiniGhast.y;
        }
    }
    
    private void shedTear() {
        TwilightForestMod.proxy.spawnParticle("bosstear", this.u + (this.ab.nextDouble() - 0.5) * this.O, this.v + this.ab.nextDouble() * this.P - 0.25, this.w + (this.ab.nextDouble() - 0.5) * this.O, 0.0, 0.0, 0.0);
    }
    
    protected void makeNewWaypoint() {
        double closestDistance = this.e(this.courseX, this.courseY, this.courseZ);
        for (int i = 0; i < 50; ++i) {
            final double potentialX = this.u + (this.ab.nextFloat() * 2.0f - 1.0f) * this.wanderFactor;
            final double potentialY = this.courseY + this.ab.nextFloat() * 8.0f - 4.0;
            final double potentialZ = this.w + (this.ab.nextFloat() * 2.0f - 1.0f) * this.wanderFactor;
            final double offsetX = this.courseX - potentialX;
            final double offsetY = this.courseY - potentialY;
            final double offsetZ = this.courseZ - potentialZ;
            final double potentialDistanceToCourse = offsetX * offsetX + offsetY * offsetY + offsetZ * offsetZ;
            if (potentialDistanceToCourse < closestDistance) {
                this.c = potentialX;
                this.d = potentialY;
                this.e = potentialZ;
                closestDistance = potentialDistanceToCourse;
            }
        }
    }
    
    protected void checkAndChangeCourse() {
        if (this.courseX == 0.0 && this.courseY == 0.0 && this.courseZ == 0.0) {
            this.changeCourse();
        }
        final double offsetX = this.courseX - this.u;
        final double offsetY = this.courseY - this.v;
        final double offsetZ = this.courseZ - this.w;
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
            this.courseX = this.travelCoords.get(this.currentTravelCoordIndex).a;
            this.courseY = this.travelCoords.get(this.currentTravelCoordIndex).b + 20;
            this.courseZ = this.travelCoords.get(this.currentTravelCoordIndex).c;
            ++this.currentTravelCoordIndex;
        }
    }
    
    private boolean checkGhastsAtTraps() {
        int trapsWithEnoughGhasts = 0;
        for (final t trap : this.trapLocations) {
            final aqr aabb = aqr.a().a((double)trap.a, (double)trap.b, (double)trap.c, (double)(trap.a + 1), (double)(trap.b + 1), (double)(trap.c + 1)).b(8.0, 16.0, 8.0);
            final List nearbyGhasts = this.q.a((Class)EntityTFMiniGhast.class, aabb);
            if (nearbyGhasts.size() >= 4) {
                ++trapsWithEnoughGhasts;
            }
        }
        return trapsWithEnoughGhasts >= 1;
    }
    
    private void makeTravelPath() {
        final int px = kx.c(this.u);
        final int py = kx.c(this.v);
        final int pz = kx.c(this.w);
        ArrayList potentialPoints;
        if (!this.noTrapMode) {
            potentialPoints = new ArrayList(this.trapLocations);
        }
        else {
            potentialPoints = new ArrayList();
            potentialPoints.add(new t(px + 20, py - 20, pz));
            potentialPoints.add(new t(px, py - 20, pz - 20));
            potentialPoints.add(new t(px - 20, py - 20, pz));
            potentialPoints.add(new t(px, py - 20, pz + 20));
        }
        this.travelCoords.clear();
        while (!potentialPoints.isEmpty()) {
            final int index = this.ab.nextInt(potentialPoints.size());
            this.travelCoords.add(potentialPoints.get(index));
            potentialPoints.remove(index);
        }
        this.travelCoords.add(new t(px, py - 20, pz));
    }
    
    @Override
    protected void spitFireball() {
        final double offsetX = this.targetedEntity.u - this.u;
        final double offsetY = this.targetedEntity.E.b + this.targetedEntity.P / 2.0f - (this.v + this.P / 2.0f);
        final double offsetZ = this.targetedEntity.w - this.w;
        this.q.a((sk)null, 1008, (int)this.u, (int)this.v, (int)this.w, 0);
        EntityTFUrGhastFireball entityFireball = new EntityTFUrGhastFireball(this.q, this, offsetX, offsetY, offsetZ);
        entityFireball.e = 1;
        final double shotSpawnDistance = 8.5;
        final aqw lookVec = this.i(1.0f);
        entityFireball.u = this.u + lookVec.c * shotSpawnDistance;
        entityFireball.v = this.v + this.P / 2.0f + lookVec.d * shotSpawnDistance;
        entityFireball.w = this.w + lookVec.e * shotSpawnDistance;
        this.q.d((mp)entityFireball);
        for (int i = 0; i < 2; ++i) {
            entityFireball = new EntityTFUrGhastFireball(this.q, this, offsetX + (this.ab.nextFloat() - this.ab.nextFloat()) * 8.0f, offsetY, offsetZ + (this.ab.nextFloat() - this.ab.nextFloat()) * 8.0f);
            entityFireball.e = 1;
            entityFireball.u = this.u + lookVec.c * shotSpawnDistance;
            entityFireball.v = this.v + this.P / 2.0f + lookVec.d * shotSpawnDistance;
            entityFireball.w = this.w + lookVec.e * shotSpawnDistance;
            this.q.d((mp)entityFireball);
        }
    }
    
    private void scanForTrapsTwice() {
        final int scanRangeXZ = 48;
        final int scanRangeY = 32;
        final int px = kx.c(this.u);
        final int py = kx.c(this.v);
        final int pz = kx.c(this.w);
        this.scanForTraps(scanRangeXZ, scanRangeY, px, py, pz);
        if (this.trapLocations.size() > 0) {
            int ax = 0;
            int ay = 0;
            int az = 0;
            for (final t trapCoords : this.trapLocations) {
                ax += trapCoords.a;
                ay += trapCoords.b;
                az += trapCoords.c;
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
                        final t trapCoords = new t(px + sx, py + sy, pz + sz);
                        if (!this.trapLocations.contains(trapCoords)) {
                            this.trapLocations.add(trapCoords);
                        }
                    }
                }
            }
        }
    }
    
    private boolean isTrapAt(final int x, final int y, final int z) {
        return this.q.f(x, y, z) && this.q.a(x, y, z) == TFBlocks.towerDevice.cz && (this.q.h(x, y, z) == 10 || this.q.h(x, y, z) == 11);
    }
    
    public boolean ae() {
        return false;
    }
    
    public boolean L() {
        return false;
    }
    
    public boolean isInTantrum() {
        return this.ah.a(18) != 0;
    }
    
    public void setInTantrum(final boolean par1) {
        this.ah.b(18, (Object)(par1 ? -1 : ((Byte)0)));
        if (!this.isInTantrum()) {
            this.fireballTolerance = 3;
        }
    }
    
    @Override
    protected float ba() {
        return 16.0f;
    }
    
    protected float aY() {
        return (this.ab.nextFloat() - this.ab.nextFloat()) * 0.2f + 0.5f;
    }
    
    public int b() {
        return this.ah.c(17);
    }
    
    public void b(final bs nbttagcompound) {
        nbttagcompound.a("inTantrum", this.isInTantrum());
        super.b(nbttagcompound);
    }
    
    public void a(final bs nbttagcompound) {
        super.a(nbttagcompound);
        this.setInTantrum(nbttagcompound.n("inTantrum"));
    }
    
    protected void aS() {
        super.aS();
        if (this.aZ == 20 && !this.q.I) {
            final t chestCoords = this.findChestCoords();
            TFTreasure.darktower_boss.generate(this.q, null, chestCoords.a, chestCoords.b, chestCoords.c);
        }
    }
    
    private t findChestCoords() {
        if (this.trapLocations.size() > 0) {
            int ax = 0;
            int ay = 0;
            int az = 0;
            for (final t trapCoords : this.trapLocations) {
                ax += trapCoords.a;
                ay += trapCoords.b;
                az += trapCoords.c;
            }
            ax /= this.trapLocations.size();
            ay /= this.trapLocations.size();
            az /= this.trapLocations.size();
            return new t(ax, ay + 2, az);
        }
        return new t(kx.c(this.u), kx.c(this.v), kx.c(this.w));
    }
}
