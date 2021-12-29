import java.util.Iterator;
import java.util.List;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFLich extends ij
{
    EntityTFLich masterLich;
    private static final kp[] heldItems;
    public static final int MAX_SHADOW_CLONES = 2;
    public static final int INITIAL_SHIELD_STRENGTH = 5;
    public static final int MAX_ACTIVE_MINIONS = 3;
    public static final int INITIAL_MINIONS_TO_SUMMON = 9;
    public static final int MAX_HEALTH = 100;
    
    public EntityTFLich(final ge world) {
        super(world);
        this.b(1.1f, 2.5f);
        this.ae = "/twilightforest/twilightlich64.png";
        this.setShadowClone(false);
        this.masterLich = null;
        this.bX = true;
        this.setShieldStrength(5);
        this.setMinionsToSummon(9);
        this.c = 6;
        this.aA = 217;
    }
    
    public EntityTFLich(final ge world, final double x, final double y, final double z) {
        this(world);
        this.c(x, y, z);
    }
    
    public EntityTFLich(final ge world, final EntityTFLich otherLich) {
        this(world);
        this.setShadowClone(true);
        this.masterLich = otherLich;
    }
    
    protected void b() {
        super.b();
        this.bY.a(16, (Object)0);
        this.bY.a(17, (Object)0);
        this.bY.a(18, (Object)0);
    }
    
    public int d() {
        return 100;
    }
    
    protected void a(final boolean par1, final int par2) {
        this.dropScepter();
        for (int totalDrops = this.bS.nextInt(3 + par2) + 2, i = 0; i < totalDrops; ++i) {
            this.dropGoldThing();
        }
        for (int totalDrops = this.bS.nextInt(4 + par2) + 1, i = 0; i < totalDrops; ++i) {
            this.b(id.bm.bP, 1);
        }
        for (int totalDrops = this.bS.nextInt(5 + par2) + 5, i = 0; i < totalDrops; ++i) {
            this.b(id.aW.bP, 1);
        }
    }
    
    private void dropScepter() {
        final int scepterType = this.bS.nextInt(3);
        if (scepterType == 0) {
            this.a(new kp(TFItems.scepterZombie), 0.0f);
        }
        else if (scepterType == 1) {
            this.a(new kp(TFItems.scepterLifeDrain), 0.0f);
        }
        else {
            this.a(new kp(TFItems.scepterTwilight), 0.0f);
        }
    }
    
    private void dropGoldThing() {
        final int thingType = this.bS.nextInt(5);
        kp goldThing;
        if (thingType == 0) {
            goldThing = new kp(id.F);
        }
        else if (thingType == 1) {
            goldThing = new kp(id.ak);
        }
        else if (thingType == 2) {
            goldThing = new kp(id.al);
        }
        else if (thingType == 3) {
            goldThing = new kp(id.am);
        }
        else {
            goldThing = new kp(id.an);
        }
        vo.a(this.bS, goldThing, 10 + this.bS.nextInt(30));
        this.a(goldThing, 0.0f);
    }
    
    public void u() {
    }
    
    protected boolean n() {
        return false;
    }
    
    public boolean aV() {
        return false;
    }
    
    public boolean aU() {
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
        final float angle = this.V * 3.141593f / 180.0f;
        final double dx = this.bm + kb.b(angle) * 0.65;
        final double dy = this.bn + this.bH * 0.94;
        final double dz = this.bo + kb.a(angle) * 0.65;
        final int factor = (80 - this.aw) / 10;
        for (int particles = (factor > 0) ? this.bS.nextInt(factor) : 1, j1 = 0; j1 < particles; ++j1) {
            float sparkle = 1.0f - (this.aw + 1.0f) / 60.0f;
            sparkle *= sparkle;
            final float red = 0.37f * sparkle;
            final float grn = 0.99f * sparkle;
            final float blu = 0.89f * sparkle;
            this.bi.a("mobSpell", dx + this.bS.nextGaussian() * 0.025, dy + this.bS.nextGaussian() * 0.025, dz + this.bS.nextGaussian() * 0.025, (double)red, (double)grn, (double)blu);
        }
        if (this.isShadowClone()) {
            this.checkForMaster();
        }
        super.e();
    }
    
    public boolean a(final rq par1DamageSource, final int par2) {
        if (par1DamageSource.l() == "inWall" && this.d != null) {
            this.teleportToSightOfEntity(this.d);
        }
        if (this.isShadowClone()) {
            this.bi.a((tv)this, "random.fizz", 1.0f, ((this.bS.nextFloat() - this.bS.nextFloat()) * 0.7f + 1.0f) * 2.0f);
            return false;
        }
        final tv prevTarget = this.d;
        if (par1DamageSource.a() instanceof EntityTFLich) {
            return false;
        }
        if (this.getShieldStrength() > 0 && !par1DamageSource.e()) {
            this.bi.a((tv)this, "random.break", 1.0f, ((this.bS.nextFloat() - this.bS.nextFloat()) * 0.7f + 1.0f) * 2.0f);
            if (par1DamageSource.a() instanceof ih) {
                this.d = par1DamageSource.a();
            }
            return false;
        }
        if (super.a(par1DamageSource, par2)) {
            if (this.d instanceof EntityTFLich) {
                this.d = prevTarget;
            }
            if (this.getShieldStrength() > 0) {
                this.setShieldStrength(this.getShieldStrength() - 1);
                this.bi.a((tv)this, "random.break", 1.0f, ((this.bS.nextFloat() - this.bS.nextFloat()) * 0.7f + 1.0f) * 2.0f);
            }
            return true;
        }
        return false;
    }
    
    protected void a(final tv targetedEntity, final float f) {
        if (!this.isShadowClone() && this.aw % 15 == 0) {
            this.popNearbyMob();
        }
        if (this.getPhase() == 1) {
            if (this.aw == 60 && !this.bi.F) {
                this.teleportToSightOfEntity(targetedEntity);
                if (!this.isShadowClone()) {
                    this.checkAndSpawnClones(targetedEntity);
                }
            }
            if (this.h(targetedEntity) && this.aw == 0 && f < 20.0f) {
                this.launchBoltAt(targetedEntity);
                this.aw = 100;
            }
            this.e = true;
        }
        if (this.getPhase() == 2 && !this.isShadowClone()) {
            this.despawnClones();
            if (this.aw % 15 == 0) {
                this.checkAndSpawnMinions(targetedEntity);
            }
            if (this.aw == 0) {
                if (f < 2.0f) {
                    this.a(targetedEntity);
                    this.aw = 20;
                }
                else if (f < 20.0f && this.h(targetedEntity)) {
                    this.launchBoltAt(targetedEntity);
                    this.aw = 60;
                }
                else {
                    this.teleportToSightOfEntity(targetedEntity);
                    this.aw = 20;
                }
            }
            this.e = true;
        }
        if (this.getPhase() == 3 && this.aw <= 0 && f < 2.0f && targetedEntity.bw.e > this.bw.b && targetedEntity.bw.b < this.bw.e) {
            this.aw = 20;
            this.a(targetedEntity);
            this.e = true;
        }
    }
    
    protected void launchBoltAt(final tv targetedEntity) {
        final float bodyFacingAngle = this.V * 3.141593f / 180.0f;
        final double sx = this.bm + kb.b(bodyFacingAngle) * 0.65;
        final double sy = this.bn + this.bH * 0.82;
        final double sz = this.bo + kb.a(bodyFacingAngle) * 0.65;
        final double tx = targetedEntity.bm - sx;
        final double ty = targetedEntity.bw.b + targetedEntity.bH / 2.0f - (this.bn + this.bH / 2.0f);
        final double tz = targetedEntity.bo - sz;
        this.bi.a((tv)this, "mob.ghast.fireball", this.p(), (this.bS.nextFloat() - this.bS.nextFloat()) * 0.2f + 1.0f);
        final bj projectile = new EntityTFLichBolt(this.bi, (ne)this);
        projectile.a(tx, ty, tz, projectile.c(), 1.0f);
        projectile.c(sx, sy, sz, this.bs, this.bt);
        this.bi.b((tv)projectile);
    }
    
    protected void popNearbyMob() {
        final List nearbyMobs = this.bi.b((tv)this, fp.b(this.bm, this.bn, this.bo, this.bm + 1.0, this.bn + 1.0, this.bo + 1.0).b(32.0, 16.0, 32.0));
        for (final tv entity : nearbyMobs) {
            if (entity instanceof ne && this.canPop(entity) && this.h(entity)) {
                final ne mob = (ne)entity;
                if (!this.bi.F) {
                    mob.X();
                    mob.aC();
                    this.bi.a((tv)mob, mob.k(), mob.p(), (this.bS.nextFloat() - this.bS.nextFloat()) * 0.2f + 1.0f);
                }
                this.makeRedMagicTrail(mob.bm, mob.bn + mob.bH / 2.0, mob.bo, this.bm, this.bn + this.bH / 2.0, this.bo);
                break;
            }
        }
    }
    
    protected boolean canPop(final tv nearby) {
        final Class[] arr$;
        final Class[] poppable = arr$ = new Class[] { hc.class, wl.class, oa.class, dg.class, hn.class, EntityTFSwarmSpider.class };
        for (final Class pop : arr$) {
            if (nearby.getClass() == pop) {
                return true;
            }
        }
        return false;
    }
    
    protected void checkAndSpawnClones(final tv targetedEntity) {
        if (this.countMyClones() < 2) {
            this.spawnShadowClone(targetedEntity);
        }
    }
    
    protected int countMyClones() {
        final List nearbyLiches = this.bi.a((Class)EntityTFLich.class, fp.b(this.bm, this.bn, this.bo, this.bm + 1.0, this.bn + 1.0, this.bo + 1.0).b(32.0, 16.0, 32.0));
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
    
    protected void spawnShadowClone(final tv targetedEntity) {
        final cj cloneSpot = this.findVecInLOSOf(targetedEntity);
        final EntityTFLich newClone = new EntityTFLich(this.bi, this);
        newClone.c(cloneSpot.a, cloneSpot.b, cloneSpot.c);
        this.bi.b((tv)newClone);
        newClone.d = targetedEntity;
        newClone.aw = 60 + this.bS.nextInt(3) - this.bS.nextInt(3);
        this.makeTeleportTrail(this.bm, this.bn, this.bo, cloneSpot.a, cloneSpot.b, cloneSpot.c);
    }
    
    protected void despawnClones() {
        final List nearbyLiches = this.bi.a((Class)this.getClass(), fp.b(this.bm, this.bn, this.bo, this.bm + 1.0, this.bn + 1.0, this.bo + 1.0).b(32.0, 16.0, 32.0));
        for (final EntityTFLich nearbyLich : nearbyLiches) {
            if (nearbyLich.isShadowClone()) {
                nearbyLich.bE = true;
            }
        }
    }
    
    protected void checkAndSpawnMinions(final tv targetedEntity) {
        if (!this.bi.F && this.getMinionsToSummon() > 0) {
            final int minions = this.countMyMinions();
            if (minions < 3) {
                this.spawnMinionAt((ne)targetedEntity);
                this.setMinionsToSummon(this.getMinionsToSummon() - 1);
            }
        }
    }
    
    protected int countMyMinions() {
        final List nearbyMinons = this.bi.a((Class)EntityTFLichMinion.class, fp.b(this.bm, this.bn, this.bo, this.bm + 1.0, this.bn + 1.0, this.bo + 1.0).b(32.0, 16.0, 32.0));
        int count = 0;
        for (final EntityTFLichMinion nearbyMinon : nearbyMinons) {
            if (nearbyMinon.master == this) {
                ++count;
            }
        }
        return count;
    }
    
    protected void spawnMinionAt(final ne targetedEntity) {
        final cj minionSpot = this.findVecInLOSOf((tv)targetedEntity);
        final EntityTFLichMinion minion = new EntityTFLichMinion(this.bi, this);
        minion.c(minionSpot.a, minionSpot.b, minionSpot.c);
        this.bi.b((tv)minion);
        minion.b(targetedEntity);
        minion.aC();
        this.bi.a((tv)minion, "random.pop", 1.0f, ((this.bS.nextFloat() - this.bS.nextFloat()) * 0.7f + 1.0f) * 2.0f);
        this.makeBlackMagicTrail(this.bm, this.bn + this.B(), this.bo, minionSpot.a, minionSpot.b + minion.bH / 2.0, minionSpot.c);
    }
    
    public boolean wantsNewMinion(final EntityTFLichMinion minion) {
        return this.countMyMinions() < 3;
    }
    
    protected void checkForMaster() {
        if (this.masterLich == null) {
            this.findNewMaster();
        }
        if (!this.bi.F) {
            if (this.masterLich == null || this.masterLich.bE) {
                this.bE = true;
            }
            else {
                final double distance = (this.bm - this.masterLich.bm) * (this.bm - this.masterLich.bm) + (this.bn - this.masterLich.bn) * (this.bn - this.masterLich.bn) + (this.bo - this.masterLich.bo) * (this.bo - this.masterLich.bo);
            }
        }
    }
    
    private void findNewMaster() {
        final List nearbyLiches = this.bi.a((Class)EntityTFLich.class, fp.b(this.bm, this.bn, this.bo, this.bm + 1.0, this.bn + 1.0, this.bo + 1.0).b(32.0, 16.0, 32.0));
        for (final EntityTFLich nearbyLich : nearbyLiches) {
            if (!nearbyLich.isShadowClone() && nearbyLich.wantsNewClone(this)) {
                this.masterLich = nearbyLich;
                this.makeTeleportTrail(this.bm, this.bn, this.bo, nearbyLich.bm, nearbyLich.bn, nearbyLich.bo);
                this.b(this.masterLich.at());
                break;
            }
        }
    }
    
    protected void teleportToSightOfEntity(final tv entity) {
        final cj dest = this.findVecInLOSOf(entity);
        final double srcX = this.bm;
        final double srcY = this.bn;
        final double srcZ = this.bo;
        if (dest != null) {
            this.teleportToNoChecks(dest.a, dest.b, dest.c);
            this.a(entity, 100.0f, 100.0f);
            this.V = this.bs;
            if (!this.h(entity)) {
                System.out.println("Teleport fail!!!");
                this.teleportToNoChecks(srcX, srcY, srcZ);
            }
        }
    }
    
    protected cj findVecInLOSOf(final tv targetEntity) {
        double tx = 0.0;
        double ty = 0.0;
        double tz = 0.0;
        final int tries = 100;
        for (int i = 0; i < tries; ++i) {
            tx = targetEntity.bm + this.bS.nextGaussian() * 16.0;
            ty = targetEntity.bn + this.bS.nextGaussian() * 8.0;
            tz = targetEntity.bo + this.bS.nextGaussian() * 16.0;
            boolean groundFlag = false;
            final int bx = kb.b(tx);
            int by = kb.b(ty);
            final int bz = kb.b(tz);
            while (!groundFlag && ty > 0.0) {
                final int whatsThere = this.bi.a(bx, by - 1, bz);
                if (whatsThere == 0 || !vz.m[whatsThere].cd.a()) {
                    --ty;
                    --by;
                }
                else {
                    groundFlag = true;
                }
            }
            if (by != 0) {
                if (this.canEntitySee(targetEntity, tx, ty, tz)) {
                    final float halfWidth = this.bG / 2.0f;
                    final fp destBox = fp.a(tx - halfWidth, ty - this.bF + this.bO, tz - halfWidth, tx + halfWidth, ty - this.bF + this.bO + this.bH, tz + halfWidth);
                    if (this.bi.a((tv)this, destBox).size() <= 0) {
                        if (!this.bi.c(destBox)) {
                            break;
                        }
                    }
                }
            }
        }
        if (tries == 99) {
            return null;
        }
        return cj.b(tx, ty, tz);
    }
    
    protected boolean canEntitySee(final tv entity, final double dx, final double dy, final double dz) {
        return this.bi.a(cj.b(entity.bm, entity.bn + entity.B(), entity.bo), cj.b(dx, dy, dz)) == null;
    }
    
    protected boolean teleportToNoChecks(final double destX, final double destY, final double destZ) {
        final double srcX = this.bm;
        final double srcY = this.bn;
        final double srcZ = this.bo;
        this.c(destX, destY, destZ);
        this.makeTeleportTrail(srcX, srcY, srcZ, destX, destY, destZ);
        this.bi.a(srcX, srcY, srcZ, "mob.endermen.portal", 1.0f, 1.0f);
        this.bi.a((tv)this, "mob.endermen.portal", 1.0f, 1.0f);
        this.aZ = false;
        return true;
    }
    
    protected void makeTeleportTrail(final double srcX, final double srcY, final double srcZ, final double destX, final double destY, final double destZ) {
        for (int particles = 128, i = 0; i < particles; ++i) {
            final double trailFactor = i / (particles - 1.0);
            final float f = (this.bS.nextFloat() - 0.5f) * 0.2f;
            final float f2 = (this.bS.nextFloat() - 0.5f) * 0.2f;
            final float f3 = (this.bS.nextFloat() - 0.5f) * 0.2f;
            final double tx = srcX + (destX - srcX) * trailFactor + (this.bS.nextDouble() - 0.5) * this.bG * 2.0;
            final double ty = srcY + (destY - srcY) * trailFactor + this.bS.nextDouble() * this.bH;
            final double tz = srcZ + (destZ - srcZ) * trailFactor + (this.bS.nextDouble() - 0.5) * this.bG * 2.0;
            this.bi.a("spell", tx, ty, tz, (double)f, (double)f2, (double)f3);
        }
    }
    
    protected void makeRedMagicTrail(final double srcX, final double srcY, final double srcZ, final double destX, final double destY, final double destZ) {
        for (int particles = 32, i = 0; i < particles; ++i) {
            final double trailFactor = i / (particles - 1.0);
            final float f = 1.0f;
            final float f2 = 0.5f;
            final float f3 = 0.5f;
            final double tx = srcX + (destX - srcX) * trailFactor + this.bS.nextGaussian() * 0.005;
            final double ty = srcY + (destY - srcY) * trailFactor + this.bS.nextGaussian() * 0.005;
            final double tz = srcZ + (destZ - srcZ) * trailFactor + this.bS.nextGaussian() * 0.005;
            this.bi.a("mobSpell", tx, ty, tz, (double)f, (double)f2, (double)f3);
        }
    }
    
    protected void makeBlackMagicTrail(final double srcX, final double srcY, final double srcZ, final double destX, final double destY, final double destZ) {
        for (int particles = 32, i = 0; i < particles; ++i) {
            final double trailFactor = i / (particles - 1.0);
            final float f = 0.2f;
            final float f2 = 0.2f;
            final float f3 = 0.2f;
            final double tx = srcX + (destX - srcX) * trailFactor + this.bS.nextGaussian() * 0.005;
            final double ty = srcY + (destY - srcY) * trailFactor + this.bS.nextGaussian() * 0.005;
            final double tz = srcZ + (destZ - srcZ) * trailFactor + this.bS.nextGaussian() * 0.005;
            this.bi.a("mobSpell", tx, ty, tz, (double)f, (double)f2, (double)f3);
        }
    }
    
    public boolean isShadowClone() {
        return (this.bY.a(16) & 0x2) != 0x0;
    }
    
    public void setShadowClone(final boolean par1) {
        final byte var2 = this.bY.a(16);
        if (par1) {
            this.bY.b(16, (Object)(byte)(var2 | 0x2));
        }
        else {
            this.bY.b(16, (Object)(byte)(var2 & 0xFFFFFFFD));
        }
    }
    
    public byte getShieldStrength() {
        return this.bY.a(17);
    }
    
    public void setShieldStrength(final int shieldStrength) {
        this.bY.b(17, (Object)(byte)shieldStrength);
    }
    
    public byte getMinionsToSummon() {
        return this.bY.a(18);
    }
    
    public void setMinionsToSummon(final int minionsToSummon) {
        this.bY.b(18, (Object)(byte)minionsToSummon);
    }
    
    protected String i() {
        return "mob.blaze.breathe";
    }
    
    protected String j() {
        return "mob.blaze.hit";
    }
    
    protected String k() {
        return "mob.blaze.death";
    }
    
    public void b(final ph nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.a("ShadowClone", this.isShadowClone());
        nbttagcompound.a("ShieldStrength", this.getShieldStrength());
        nbttagcompound.a("MinionsToSummon", this.getMinionsToSummon());
    }
    
    public void a(final ph nbttagcompound) {
        super.a(nbttagcompound);
        this.setShadowClone(nbttagcompound.o("ShadowClone"));
        this.setShieldStrength(nbttagcompound.d("ShieldStrength"));
        this.setMinionsToSummon(nbttagcompound.d("MinionsToSummon"));
    }
    
    public void a(final rq par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.b() instanceof ih) {
            ((ih)par1DamageSource.b()).a((xo)TFAchievementPage.twilightHunter);
        }
    }
    
    static {
        heldItems = new kp[] { new kp(TFItems.scepterTwilight, 1), new kp(TFItems.scepterZombie, 1), new kp(id.F, 1) };
    }
}
