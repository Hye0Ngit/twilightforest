// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Iterator;
import java.util.List;

public class EntityTFLich extends yy
{
    EntityTFLich masterLich;
    private static final aan[] heldItems;
    public static final int MAX_SHADOW_CLONES = 2;
    public static final int INITIAL_SHIELD_STRENGTH = 5;
    public static final int MAX_ACTIVE_MINIONS = 3;
    public static final int INITIAL_MINIONS_TO_SUMMON = 9;
    public static final int MAX_HEALTH = 100;
    
    public EntityTFLich(final xd world) {
        super(world);
        this.a(1.1f, 2.5f);
        this.bm = "/twilightforest/twilightlich64.png";
        this.setShadowClone(false);
        this.masterLich = null;
        this.ab = true;
        this.setShieldStrength(5);
        this.setMinionsToSummon(9);
        this.c = 6;
        this.bI = 217;
    }
    
    public EntityTFLich(final xd world, final double x, final double y, final double z) {
        this(world);
        this.d(x, y, z);
    }
    
    public EntityTFLich(final xd world, final EntityTFLich otherLich) {
        this(world);
        this.setShadowClone(true);
        this.masterLich = otherLich;
    }
    
    protected void b() {
        super.b();
        this.ac.a(16, (Object)0);
        this.ac.a(17, (Object)0);
        this.ac.a(18, (Object)0);
    }
    
    public int d() {
        return 100;
    }
    
    public aan ae() {
        return EntityTFLich.heldItems[this.getPhase() - 1];
    }
    
    protected void a(final boolean par1, final int par2) {
        this.dropScepter();
        for (int totalDrops = this.U.nextInt(3 + par2) + 2, i = 0; i < totalDrops; ++i) {
            this.dropGoldThing();
        }
        for (int totalDrops = this.U.nextInt(4 + par2) + 1, i = 0; i < totalDrops; ++i) {
            this.b(yr.bn.bQ, 1);
        }
        for (int totalDrops = this.U.nextInt(5 + par2) + 5, i = 0; i < totalDrops; ++i) {
            this.b(yr.aX.bQ, 1);
        }
    }
    
    private void dropScepter() {
        final int scepterType = this.U.nextInt(3);
        if (scepterType == 0) {
            this.a(new aan(TFItems.scepterZombie), 0.0f);
        }
        else if (scepterType == 1) {
            this.a(new aan(TFItems.scepterLifeDrain), 0.0f);
        }
        else {
            this.a(new aan(TFItems.scepterTwilight), 0.0f);
        }
    }
    
    private void dropGoldThing() {
        final int thingType = this.U.nextInt(5);
        aan goldThing;
        if (thingType == 0) {
            goldThing = new aan(yr.G);
        }
        else if (thingType == 1) {
            goldThing = new aan(yr.al);
        }
        else if (thingType == 2) {
            goldThing = new aan(yr.am);
        }
        else if (thingType == 3) {
            goldThing = new aan(yr.an);
        }
        else {
            goldThing = new aan(yr.ao);
        }
        ais.a(this.U, goldThing, 10 + this.U.nextInt(30));
        this.a(goldThing, 0.0f);
    }
    
    public void q() {
    }
    
    protected boolean c_() {
        return false;
    }
    
    public boolean J() {
        return false;
    }
    
    public boolean H() {
        return false;
    }
    
    public int getPhase() {
        if (this.isShadowClone() || this.getShieldStrength() > 0) {
            return 1;
        }
        if (this.getMinionsToSummon() > 0) {
            return 2;
        }
        return 3;
    }
    
    public void e() {
        final float angle = this.bd * 3.141593f / 180.0f;
        final double dx = this.o + gk.b(angle) * 0.65;
        final double dy = this.p + this.J * 0.94;
        final double dz = this.q + gk.a(angle) * 0.65;
        final int factor = (80 - this.bE) / 10;
        for (int particles = (factor > 0) ? this.U.nextInt(factor) : 1, j1 = 0; j1 < particles; ++j1) {
            float sparkle = 1.0f - (this.bE + 1.0f) / 60.0f;
            sparkle *= sparkle;
            final float red = 0.37f * sparkle;
            final float grn = 0.99f * sparkle;
            final float blu = 0.89f * sparkle;
            this.k.a("mobSpell", dx + this.U.nextGaussian() * 0.025, dy + this.U.nextGaussian() * 0.025, dz + this.U.nextGaussian() * 0.025, (double)red, (double)grn, (double)blu);
        }
        if (this.isShadowClone()) {
            this.checkForMaster();
        }
        super.e();
    }
    
    public boolean a(final md par1DamageSource, final int par2) {
        if (par1DamageSource.l() == "inWall" && this.ao != null) {
            this.teleportToSightOfEntity(this.ao);
        }
        if (this.isShadowClone()) {
            this.k.a((nn)this, "random.fizz", 1.0f, ((this.U.nextFloat() - this.U.nextFloat()) * 0.7f + 1.0f) * 2.0f);
            return false;
        }
        final nn prevTarget = this.ao;
        if (par1DamageSource.a() instanceof EntityTFLich) {
            return false;
        }
        if (this.getShieldStrength() > 0 && !par1DamageSource.e()) {
            this.k.a((nn)this, "random.break", 1.0f, ((this.U.nextFloat() - this.U.nextFloat()) * 0.7f + 1.0f) * 2.0f);
            if (par1DamageSource.a() instanceof yw) {
                this.ao = par1DamageSource.a();
            }
            return false;
        }
        if (super.a(par1DamageSource, par2)) {
            if (this.ao instanceof EntityTFLich) {
                this.ao = prevTarget;
            }
            if (this.getShieldStrength() > 0) {
                this.setShieldStrength(this.getShieldStrength() - 1);
                this.k.a((nn)this, "random.break", 1.0f, ((this.U.nextFloat() - this.U.nextFloat()) * 0.7f + 1.0f) * 2.0f);
            }
            return true;
        }
        return false;
    }
    
    protected void a(final nn targetedEntity, final float f) {
        if (!this.isShadowClone() && this.bE % 15 == 0) {
            this.popNearbyMob();
        }
        if (this.getPhase() == 1) {
            if (this.bE == 60 && !this.k.F) {
                this.teleportToSightOfEntity(targetedEntity);
                if (!this.isShadowClone()) {
                    this.checkAndSpawnClones(targetedEntity);
                }
            }
            if (this.m(targetedEntity) && this.bE == 0 && f < 20.0f) {
                this.launchBoltAt(targetedEntity);
                this.bE = 100;
            }
            this.ap = true;
        }
        if (this.getPhase() == 2 && !this.isShadowClone()) {
            this.despawnClones();
            if (this.bE % 15 == 0) {
                this.checkAndSpawnMinions(targetedEntity);
            }
            if (this.bE == 0) {
                if (f < 2.0f) {
                    this.c(targetedEntity);
                    this.bE = 20;
                }
                else if (f < 20.0f && this.m(targetedEntity)) {
                    this.launchBoltAt(targetedEntity);
                    this.bE = 60;
                }
                else {
                    this.teleportToSightOfEntity(targetedEntity);
                    this.bE = 20;
                }
            }
            this.ap = true;
        }
        if (this.getPhase() == 3 && this.bE <= 0 && f < 2.0f && targetedEntity.y.e > this.y.b && targetedEntity.y.b < this.y.e) {
            this.bE = 20;
            this.c(targetedEntity);
            this.ap = true;
        }
    }
    
    protected void launchBoltAt(final nn targetedEntity) {
        final float bodyFacingAngle = this.bd * 3.141593f / 180.0f;
        final double sx = this.o + gk.b(bodyFacingAngle) * 0.65;
        final double sy = this.p + this.J * 0.82;
        final double sz = this.q + gk.a(bodyFacingAngle) * 0.65;
        final double tx = targetedEntity.o - sx;
        final double ty = targetedEntity.y.b + targetedEntity.J / 2.0f - (this.p + this.J / 2.0f);
        final double tz = targetedEntity.q - sz;
        this.k.a((nn)this, "mob.ghast.fireball", this.C_(), (this.U.nextFloat() - this.U.nextFloat()) * 0.2f + 1.0f);
        final EntityTFLichBolt projectile = new EntityTFLichBolt(this.k, (acq)this);
        projectile.a(tx, ty, tz, projectile.c(), 1.0f);
        projectile.c(sx, sy, sz, this.u, this.v);
        this.k.a((nn)projectile);
    }
    
    protected void popNearbyMob() {
        final List nearbyMobs = this.k.b((nn)this, wu.b(this.o, this.p, this.q, this.o + 1.0, this.p + 1.0, this.q + 1.0).b(32.0, 16.0, 32.0));
        for (final nn entity : nearbyMobs) {
            if (entity instanceof acq && this.canPop(entity) && this.m(entity)) {
                final acq mob = (acq)entity;
                if (!this.k.F) {
                    mob.A();
                    mob.ba();
                }
                this.makeRedMagicTrail(mob.o, mob.p + mob.J / 2.0, mob.q, this.o, this.p + this.J / 2.0, this.q);
                break;
            }
        }
    }
    
    protected boolean canPop(final nn nearby) {
        final Class[] arr$;
        final Class[] poppable = arr$ = new Class[] { xr.class, ajg.class, jg.class, cb.class, yd.class, EntityTFSwarmSpider.class };
        for (final Class pop : arr$) {
            if (nearby.getClass() == pop) {
                return true;
            }
        }
        return false;
    }
    
    protected void checkAndSpawnClones(final nn targetedEntity) {
        if (this.countMyClones() < 2) {
            this.spawnShadowClone(targetedEntity);
        }
    }
    
    protected int countMyClones() {
        final List nearbyLiches = this.k.a((Class)EntityTFLich.class, wu.b(this.o, this.p, this.q, this.o + 1.0, this.p + 1.0, this.q + 1.0).b(32.0, 16.0, 32.0));
        int count = 0;
        for (final EntityTFLich nearbyLich : nearbyLiches) {
            if (nearbyLich.isShadowClone() && nearbyLich.masterLich == this) {
                ++count;
            }
        }
        return count;
    }
    
    public boolean wantsNewClone(final EntityTFLich clone) {
        return clone.isShadowClone() && this.countMyClones() < 2;
    }
    
    protected void spawnShadowClone(final nn targetedEntity) {
        final bo cloneSpot = this.findVecInLOSOf(targetedEntity);
        final EntityTFLich newClone = new EntityTFLich(this.k, this);
        newClone.d(cloneSpot.a, cloneSpot.b, cloneSpot.c);
        this.k.a((nn)newClone);
        newClone.ao = targetedEntity;
        newClone.bE = 60 + this.U.nextInt(3) - this.U.nextInt(3);
        this.makeTeleportTrail(this.o, this.p, this.q, cloneSpot.a, cloneSpot.b, cloneSpot.c);
    }
    
    protected void despawnClones() {
        final List nearbyLiches = this.k.a((Class)this.getClass(), wu.b(this.o, this.p, this.q, this.o + 1.0, this.p + 1.0, this.q + 1.0).b(32.0, 16.0, 32.0));
        for (final EntityTFLich nearbyLich : nearbyLiches) {
            if (nearbyLich.isShadowClone()) {
                nearbyLich.G = true;
            }
        }
    }
    
    protected void checkAndSpawnMinions(final nn targetedEntity) {
        if (!this.k.F && this.getMinionsToSummon() > 0) {
            final int minions = this.countMyMinions();
            if (minions < 3) {
                this.spawnMinionAt((acq)targetedEntity);
                this.setMinionsToSummon(this.getMinionsToSummon() - 1);
            }
        }
    }
    
    protected int countMyMinions() {
        final List nearbyMinons = this.k.a((Class)EntityTFLichMinion.class, wu.b(this.o, this.p, this.q, this.o + 1.0, this.p + 1.0, this.q + 1.0).b(32.0, 16.0, 32.0));
        int count = 0;
        for (final EntityTFLichMinion nearbyMinon : nearbyMinons) {
            if (nearbyMinon.master == this) {
                ++count;
            }
        }
        return count;
    }
    
    protected void spawnMinionAt(final acq targetedEntity) {
        final bo minionSpot = this.findVecInLOSOf((nn)targetedEntity);
        final EntityTFLichMinion minion = new EntityTFLichMinion(this.k, this);
        minion.d(minionSpot.a, minionSpot.b, minionSpot.c);
        this.k.a((nn)minion);
        minion.c(targetedEntity);
        minion.ba();
        this.k.a((nn)minion, "random.pop", 1.0f, ((this.U.nextFloat() - this.U.nextFloat()) * 0.7f + 1.0f) * 2.0f);
        this.makeBlackMagicTrail(this.o, this.p + this.I(), this.q, minionSpot.a, minionSpot.b + minion.J / 2.0, minionSpot.c);
    }
    
    public boolean wantsNewMinion(final EntityTFLichMinion minion) {
        return this.countMyMinions() < 3;
    }
    
    protected void checkForMaster() {
        if (this.masterLich == null) {
            this.findNewMaster();
        }
        if (!this.k.F) {
            if (this.masterLich == null || this.masterLich.G) {
                this.G = true;
            }
            else {
                final double distance = (this.o - this.masterLich.o) * (this.o - this.masterLich.o) + (this.p - this.masterLich.p) * (this.p - this.masterLich.p) + (this.q - this.masterLich.q) * (this.q - this.masterLich.q);
            }
        }
    }
    
    private void findNewMaster() {
        final List nearbyLiches = this.k.a((Class)EntityTFLich.class, wu.b(this.o, this.p, this.q, this.o + 1.0, this.p + 1.0, this.q + 1.0).b(32.0, 16.0, 32.0));
        for (final EntityTFLich nearbyLich : nearbyLiches) {
            if (!nearbyLich.isShadowClone() && nearbyLich.wantsNewClone(this)) {
                this.masterLich = nearbyLich;
                this.makeTeleportTrail(this.o, this.p, this.q, nearbyLich.o, nearbyLich.p, nearbyLich.q);
                this.c(this.masterLich.aT());
                break;
            }
        }
    }
    
    protected void teleportToSightOfEntity(final nn entity) {
        final bo dest = this.findVecInLOSOf(entity);
        final double srcX = this.o;
        final double srcY = this.p;
        final double srcZ = this.q;
        if (dest != null) {
            this.teleportToNoChecks(dest.a, dest.b, dest.c);
            this.a(entity, 100.0f, 100.0f);
            this.bd = this.u;
            if (!this.m(entity)) {
                System.out.println("Teleport fail!!!");
                this.teleportToNoChecks(srcX, srcY, srcZ);
            }
        }
    }
    
    protected bo findVecInLOSOf(final nn targetEntity) {
        double tx = 0.0;
        double ty = 0.0;
        double tz = 0.0;
        final int tries = 100;
        for (int i = 0; i < tries; ++i) {
            tx = targetEntity.o + this.U.nextGaussian() * 16.0;
            ty = targetEntity.p + this.U.nextGaussian() * 8.0;
            tz = targetEntity.q + this.U.nextGaussian() * 16.0;
            boolean groundFlag = false;
            final int bx = gk.c(tx);
            int by = gk.c(ty);
            final int bz = gk.c(tz);
            while (!groundFlag && ty > 0.0) {
                final int whatsThere = this.k.a(bx, by - 1, bz);
                if (whatsThere == 0 || !pb.m[whatsThere].cd.a()) {
                    --ty;
                    --by;
                }
                else {
                    groundFlag = true;
                }
            }
            if (by != 0) {
                if (this.canEntitySee(targetEntity, tx, ty, tz)) {
                    final float halfWidth = this.I / 2.0f;
                    final wu destBox = wu.a(tx - halfWidth, ty - this.H + this.Q, tz - halfWidth, tx + halfWidth, ty - this.H + this.Q + this.J, tz + halfWidth);
                    if (this.k.a((nn)this, destBox).size() <= 0) {
                        if (!this.k.b(destBox)) {
                            break;
                        }
                    }
                }
            }
        }
        if (tries == 99) {
            return null;
        }
        return bo.b(tx, ty, tz);
    }
    
    protected boolean canEntitySee(final nn entity, final double dx, final double dy, final double dz) {
        return this.k.a(bo.b(entity.o, entity.p + entity.I(), entity.q), bo.b(dx, dy, dz)) == null;
    }
    
    protected boolean teleportToNoChecks(final double destX, final double destY, final double destZ) {
        final double srcX = this.o;
        final double srcY = this.p;
        final double srcZ = this.q;
        this.d(destX, destY, destZ);
        this.makeTeleportTrail(srcX, srcY, srcZ, destX, destY, destZ);
        this.k.a(srcX, srcY, srcZ, "mob.endermen.portal", 1.0f, 1.0f);
        this.k.a((nn)this, "mob.endermen.portal", 1.0f, 1.0f);
        this.ch = false;
        return true;
    }
    
    protected void makeTeleportTrail(final double srcX, final double srcY, final double srcZ, final double destX, final double destY, final double destZ) {
        for (int particles = 128, i = 0; i < particles; ++i) {
            final double trailFactor = i / (particles - 1.0);
            final float f = (this.U.nextFloat() - 0.5f) * 0.2f;
            final float f2 = (this.U.nextFloat() - 0.5f) * 0.2f;
            final float f3 = (this.U.nextFloat() - 0.5f) * 0.2f;
            final double tx = srcX + (destX - srcX) * trailFactor + (this.U.nextDouble() - 0.5) * this.I * 2.0;
            final double ty = srcY + (destY - srcY) * trailFactor + this.U.nextDouble() * this.J;
            final double tz = srcZ + (destZ - srcZ) * trailFactor + (this.U.nextDouble() - 0.5) * this.I * 2.0;
            this.k.a("spell", tx, ty, tz, (double)f, (double)f2, (double)f3);
        }
    }
    
    protected void makeRedMagicTrail(final double srcX, final double srcY, final double srcZ, final double destX, final double destY, final double destZ) {
        for (int particles = 32, i = 0; i < particles; ++i) {
            final double trailFactor = i / (particles - 1.0);
            final float f = 1.0f;
            final float f2 = 0.5f;
            final float f3 = 0.5f;
            final double tx = srcX + (destX - srcX) * trailFactor + this.U.nextGaussian() * 0.005;
            final double ty = srcY + (destY - srcY) * trailFactor + this.U.nextGaussian() * 0.005;
            final double tz = srcZ + (destZ - srcZ) * trailFactor + this.U.nextGaussian() * 0.005;
            this.k.a("mobSpell", tx, ty, tz, (double)f, (double)f2, (double)f3);
        }
    }
    
    protected void makeBlackMagicTrail(final double srcX, final double srcY, final double srcZ, final double destX, final double destY, final double destZ) {
        for (int particles = 32, i = 0; i < particles; ++i) {
            final double trailFactor = i / (particles - 1.0);
            final float f = 0.2f;
            final float f2 = 0.2f;
            final float f3 = 0.2f;
            final double tx = srcX + (destX - srcX) * trailFactor + this.U.nextGaussian() * 0.005;
            final double ty = srcY + (destY - srcY) * trailFactor + this.U.nextGaussian() * 0.005;
            final double tz = srcZ + (destZ - srcZ) * trailFactor + this.U.nextGaussian() * 0.005;
            this.k.a("mobSpell", tx, ty, tz, (double)f, (double)f2, (double)f3);
        }
    }
    
    public boolean isShadowClone() {
        return (this.ac.a(16) & 0x2) != 0x0;
    }
    
    public void setShadowClone(final boolean par1) {
        final byte var2 = this.ac.a(16);
        if (par1) {
            this.ac.b(16, (Object)(byte)(var2 | 0x2));
        }
        else {
            this.ac.b(16, (Object)(byte)(var2 & 0xFFFFFFFD));
        }
    }
    
    public byte getShieldStrength() {
        return this.ac.a(17);
    }
    
    public void setShieldStrength(final int shieldStrength) {
        this.ac.b(17, (Object)(byte)shieldStrength);
    }
    
    public byte getMinionsToSummon() {
        return this.ac.a(18);
    }
    
    public void setMinionsToSummon(final int minionsToSummon) {
        this.ac.b(18, (Object)(byte)minionsToSummon);
    }
    
    protected String m() {
        return "mob.blaze.breathe";
    }
    
    protected String n() {
        return "mob.blaze.hit";
    }
    
    protected String o() {
        return "mob.blaze.death";
    }
    
    public void b(final ady nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.a("ShadowClone", this.isShadowClone());
        nbttagcompound.a("ShieldStrength", this.getShieldStrength());
        nbttagcompound.a("MinionsToSummon", this.getMinionsToSummon());
    }
    
    public void a(final ady nbttagcompound) {
        super.a(nbttagcompound);
        this.setShadowClone(nbttagcompound.o("ShadowClone"));
        this.setShieldStrength(nbttagcompound.d("ShieldStrength"));
        this.setMinionsToSummon(nbttagcompound.d("MinionsToSummon"));
    }
    
    public void a(final md par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.b() instanceof yw) {
            ((yw)par1DamageSource.b()).a((ajw)TFAchievementPage.twilightHunter);
        }
    }
    
    static {
        heldItems = new aan[] { new aan(TFItems.scepterTwilight, 1), new aan(TFItems.scepterZombie, 1), new aan(yr.G, 1) };
    }
}
