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
import java.util.Collection;
import net.minecraft.server.MinecraftServer;
import cpw.mods.fml.common.FMLLog;
import java.util.ArrayList;

public class EntityTFUrGhast extends EntityTFTowerGhast implements sf
{
    private static final int DATA_TANTRUM = 18;
    private static final int CRUISING_ALTITUDE = 235;
    private static final int HOVER_ALTITUDE = 20;
    public double courseX;
    public double courseY;
    public double courseZ;
    ArrayList<t> trapLocations;
    ArrayList<t> travelCoords;
    int currentTravelCoordIndex;
    int travelPathRepetitions;
    int desiredRepetitions;
    int nextTantrumCry;
    float damageUntilNextPhase;
    boolean noTrapMode;
    
    public EntityTFUrGhast(final abv par1World) {
        super(par1World);
        this.a(14.0f, 18.0f);
        this.aggroRange = 128.0f;
        this.wanderFactor = 32.0f;
        this.Z = true;
        this.trapLocations = new ArrayList<t>();
        this.travelCoords = new ArrayList<t>();
        this.setInTantrum(false);
        this.damageUntilNextPhase = 45.0f;
        this.b = 317;
        this.noTrapMode = false;
    }
    
    @Override
    protected void ay() {
        super.ay();
        this.a(to.a).a(250.0);
    }
    
    protected void a() {
        super.a();
        this.ah.a(18, (Object)0);
    }
    
    protected boolean t() {
        return false;
    }
    
    @Override
    public void l_() {
        super.l_();
        final byte aggroStatus = this.ah.a(16);
        if (this.aB > 0) {
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
    public boolean a(final na source, float damage) {
        if (source == na.d) {
            return false;
        }
        boolean attackSuccessful = false;
        if (this.isInTantrum()) {
            damage /= 4.0f;
        }
        if ("fireball".equals(source.n()) && source.i() instanceof ue) {
            attackSuccessful = super.a(na.a(source.h(), source.i()), damage);
        }
        else {
            attackSuccessful = super.a(source, damage);
        }
        if (!this.q.I) {
            if (this.ay == this.az) {
                this.damageUntilNextPhase -= this.getLastDamage();
                FMLLog.info("[Urghast] Attack successful, %f damage until phase switch.", new Object[] { this.damageUntilNextPhase });
                if (this.damageUntilNextPhase <= 0.0f) {
                    this.switchPhase();
                }
            }
            else {
                FMLLog.info("[Urghast] Attack fail with %s type attack for %f damage", new Object[] { source.o, damage });
            }
        }
        return attackSuccessful;
    }
    
    private float getLastDamage() {
        return this.ax - this.aM();
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
        final alp worldInfo = MinecraftServer.F().b[0].N();
        worldInfo.b(true);
        worldInfo.a(true);
        worldInfo.g(rainTime);
        worldInfo.f(rainTime);
        this.spawnGhastsAtTraps();
    }
    
    protected void spawnGhastsAtTraps() {
        final ArrayList<t> ghastSpawns = new ArrayList<t>(this.trapLocations);
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
        this.q.c((nm)new so(this.q, (double)x, (double)(y + 4), (double)z));
        for (int i = 0; i < tries; ++i) {
            final EntityTFMiniGhast minion = new EntityTFMiniGhast(this.q);
            final double sx = x + (this.ab.nextDouble() - this.ab.nextDouble()) * rangeXZ;
            final double sy = y + this.ab.nextDouble() * rangeY;
            final double sz = z + (this.ab.nextDouble() - this.ab.nextDouble()) * rangeXZ;
            minion.b(sx, sy, sz, this.q.s.nextFloat() * 360.0f, 0.0f);
            minion.makeBossMinion();
            if (minion.bs()) {
                this.q.d((nm)minion);
                minion.q();
            }
            if (++spawns >= maxSpawns) {
                break;
            }
        }
    }
    
    @Override
    protected void bk() {
        if (!this.q.I && this.q.r == 0) {
            this.w();
        }
        this.bo();
        final List<EntityTFMiniGhast> nearbyGhasts = this.q.a((Class)EntityTFMiniGhast.class, this.E.b(1.0, 1.0, 1.0));
        for (final EntityTFMiniGhast ghast : nearbyGhasts) {
            ghast.w();
            this.f(2.0f);
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
            this.bq = null;
            return;
        }
        this.bo = this.bp;
        if (this.bq != null && this.bq.M) {
            this.bq = null;
        }
        if (this.bq == null) {
            this.bq = this.findPlayerInRange();
        }
        else if (!this.isAggressive && this.bq instanceof ue) {
            this.checkToIncreaseAggro((ue)this.bq);
        }
        if (this.isInTantrum()) {
            this.shedTear();
            this.bq = null;
            if (--this.nextTantrumCry <= 0) {
                this.a(this.aN(), this.aZ(), this.ba());
                this.nextTantrumCry = 20 + this.ab.nextInt(30);
            }
            if (this.ac % 10 == 0) {
                this.doTantrumDamageEffects();
            }
        }
        this.checkAndChangeCourse();
        final double offsetX = this.i - this.u;
        final double offsetY = this.j - this.v;
        final double offsetZ = this.bn - this.w;
        double distanceToWaypoint = offsetX * offsetX + offsetY * offsetY + offsetZ * offsetZ;
        if (distanceToWaypoint < 1.0 || distanceToWaypoint > 3600.0) {
            this.makeNewWaypoint();
        }
        if (this.h-- <= 0) {
            this.h += this.ab.nextInt(5) + 0;
            distanceToWaypoint = lr.a(distanceToWaypoint);
            final double speed = 0.05;
            this.x += offsetX / distanceToWaypoint * speed;
            this.y += offsetY / distanceToWaypoint * speed;
            this.z += offsetZ / distanceToWaypoint * speed;
        }
        final double targetRange = (this.aggroCounter > 0 || this.isAggressive) ? this.aggroRange : ((double)this.stareRange);
        if (this.bq != null && this.bq.e((nm)this) < targetRange * targetRange && this.o((nm)this.bq)) {
            this.a((nm)this.bq, 10.0f, (float)this.bp());
            if (this.isAggressive) {
                if (this.bp == 10) {
                    this.a("mob.ghast.charge", this.aZ(), this.ba());
                }
                ++this.bp;
                if (this.bp == 20) {
                    this.spitFireball();
                    this.bp = -40;
                }
            }
        }
        else {
            this.isAggressive = false;
            this.bq = null;
            this.A = -(float)Math.atan2(this.x, this.z) * 180.0f / 3.1415927f;
            this.B = 0.0f;
        }
        if (this.bp > 0 && !this.isAggressive) {
            --this.bp;
        }
        final byte currentAggroStatus = this.ah.a(16);
        final byte newAggroStatus = (byte)((this.bp > 10) ? 2 : ((this.aggroCounter > 0 || this.isAggressive) ? 1 : 0));
        if (currentAggroStatus != newAggroStatus) {
            this.ah.b(16, (Object)newAggroStatus);
        }
    }
    
    private void doTantrumDamageEffects() {
        final asu below = this.E.c(0.0, -16.0, 0.0).b(0.0, 16.0, 0.0);
        final List<ue> playersBelow = this.q.a((Class)ue.class, below);
        for (final ue player : playersBelow) {
            final int dx = lr.c(player.u);
            final int dy = lr.c(player.v);
            final int dz = lr.c(player.w);
            if (this.q.l(dx, dy, dz)) {
                player.a(na.m, 3.0f);
            }
        }
        final List<EntityTFMiniGhast> ghastsBelow = this.q.a((Class)EntityTFMiniGhast.class, below);
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
                this.i = potentialX;
                this.j = potentialY;
                this.bn = potentialZ;
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
            final asu aabb = asu.a().a((double)trap.a, (double)trap.b, (double)trap.c, (double)(trap.a + 1), (double)(trap.b + 1), (double)(trap.c + 1)).b(8.0, 16.0, 8.0);
            final List<EntityTFMiniGhast> nearbyGhasts = this.q.a((Class)EntityTFMiniGhast.class, aabb);
            if (nearbyGhasts.size() >= 4) {
                ++trapsWithEnoughGhasts;
            }
        }
        return trapsWithEnoughGhasts >= 1;
    }
    
    private void makeTravelPath() {
        final int px = lr.c(this.u);
        final int py = lr.c(this.v);
        final int pz = lr.c(this.w);
        ArrayList<t> potentialPoints;
        if (!this.noTrapMode) {
            potentialPoints = new ArrayList<t>(this.trapLocations);
        }
        else {
            potentialPoints = new ArrayList<t>();
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
        if (this.noTrapMode) {
            this.travelCoords.add(new t(px, py - 20, pz));
        }
    }
    
    @Override
    protected void spitFireball() {
        final double offsetX = this.bq.u - this.u;
        final double offsetY = this.bq.E.b + this.bq.P / 2.0f - (this.v + this.P / 2.0f);
        final double offsetZ = this.bq.w - this.w;
        this.q.a((ue)null, 1008, (int)this.u, (int)this.v, (int)this.w, 0);
        EntityTFUrGhastFireball entityFireball = new EntityTFUrGhastFireball(this.q, this, offsetX, offsetY, offsetZ);
        entityFireball.e = 1;
        final double shotSpawnDistance = 8.5;
        final asz lookVec = this.j(1.0f);
        entityFireball.u = this.u + lookVec.c * shotSpawnDistance;
        entityFireball.v = this.v + this.P / 2.0f + lookVec.d * shotSpawnDistance;
        entityFireball.w = this.w + lookVec.e * shotSpawnDistance;
        this.q.d((nm)entityFireball);
        for (int i = 0; i < 2; ++i) {
            entityFireball = new EntityTFUrGhastFireball(this.q, this, offsetX + (this.ab.nextFloat() - this.ab.nextFloat()) * 8.0f, offsetY, offsetZ + (this.ab.nextFloat() - this.ab.nextFloat()) * 8.0f);
            entityFireball.e = 1;
            entityFireball.u = this.u + lookVec.c * shotSpawnDistance;
            entityFireball.v = this.v + this.P / 2.0f + lookVec.d * shotSpawnDistance;
            entityFireball.w = this.w + lookVec.e * shotSpawnDistance;
            this.q.d((nm)entityFireball);
        }
    }
    
    private void scanForTrapsTwice() {
        final int scanRangeXZ = 48;
        final int scanRangeY = 32;
        final int px = lr.c(this.u);
        final int py = lr.c(this.v);
        final int pz = lr.c(this.w);
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
        return this.q.f(x, y, z) && this.q.a(x, y, z) == TFBlocks.towerDevice.cF && (this.q.h(x, y, z) == 10 || this.q.h(x, y, z) == 11);
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
        this.damageUntilNextPhase = 48.0f;
    }
    
    @Override
    protected float aZ() {
        return 16.0f;
    }
    
    protected float ba() {
        return (this.ab.nextFloat() - this.ab.nextFloat()) * 0.2f + 0.5f;
    }
    
    public void b(final bx nbttagcompound) {
        nbttagcompound.a("inTantrum", this.isInTantrum());
        super.b(nbttagcompound);
    }
    
    public void a(final bx nbttagcompound) {
        super.a(nbttagcompound);
        this.setInTantrum(nbttagcompound.n("inTantrum"));
    }
    
    protected void aA() {
        super.aA();
        if (this.aB == 20 && !this.q.I) {
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
        return new t(lr.c(this.u), lr.c(this.v), lr.c(this.w));
    }
}
