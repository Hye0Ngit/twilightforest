// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Iterator;
import java.util.List;

public class EntityTFLich extends qj implements pl
{
    private static final int DATA_ISCLONE = 16;
    private static final int DATA_SHIELDSTRENGTH = 17;
    private static final int DATA_MINIONSLEFT = 18;
    private static final int DATA_BOSSHEALTH = 19;
    private static final int DATA_ATTACKTYPE = 20;
    EntityTFLich masterLich;
    private static final um[] heldItems;
    public static final int MAX_SHADOW_CLONES = 2;
    public static final int INITIAL_SHIELD_STRENGTH = 5;
    public static final int MAX_ACTIVE_MINIONS = 3;
    public static final int INITIAL_MINIONS_TO_SUMMON = 9;
    public static final int MAX_HEALTH = 100;
    
    public EntityTFLich(final xv world) {
        super(world);
        this.a(1.1f, 2.5f);
        this.aF = "/twilightforest/twilightlich64.png";
        this.setShadowClone(false);
        this.masterLich = null;
        this.af = true;
        this.setShieldStrength(5);
        this.setMinionsToSummon(9);
        this.bc = 217;
    }
    
    public EntityTFLich(final xv world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    public EntityTFLich(final xv world, final EntityTFLich otherLich) {
        this(world);
        this.setShadowClone(true);
        this.masterLich = otherLich;
    }
    
    protected void a() {
        super.a();
        this.ag.a(16, (Object)0);
        this.ag.a(17, (Object)0);
        this.ag.a(18, (Object)0);
        this.ag.a(19, (Object)new Integer(100));
        this.ag.a(20, (Object)0);
    }
    
    public int aT() {
        return 100;
    }
    
    public um bD() {
        return EntityTFLich.heldItems[this.getPhase() - 1];
    }
    
    protected void a(final boolean par1, final int par2) {
        this.dropScepter();
        for (int totalDrops = this.aa.nextInt(3 + par2) + 2, i = 0; i < totalDrops; ++i) {
            this.dropGoldThing();
        }
        for (int totalDrops = this.aa.nextInt(4 + par2) + 1, i = 0; i < totalDrops; ++i) {
            this.b(uk.bn.cg, 1);
        }
        for (int totalDrops = this.aa.nextInt(5 + par2) + 5, i = 0; i < totalDrops; ++i) {
            this.b(uk.aX.cg, 1);
        }
    }
    
    private void dropScepter() {
        final int scepterType = this.aa.nextInt(3);
        if (scepterType == 0) {
            this.a(new um(TFItems.scepterZombie), 0.0f);
        }
        else if (scepterType == 1) {
            this.a(new um(TFItems.scepterLifeDrain), 0.0f);
        }
        else {
            this.a(new um(TFItems.scepterTwilight), 0.0f);
        }
    }
    
    private void dropGoldThing() {
        final int thingType = this.aa.nextInt(5);
        um goldThing;
        if (thingType == 0) {
            goldThing = new um(uk.G);
        }
        else if (thingType == 1) {
            goldThing = new um(uk.al);
        }
        else if (thingType == 2) {
            goldThing = new um(uk.am);
        }
        else if (thingType == 3) {
            goldThing = new um(uk.an);
        }
        else {
            goldThing = new um(uk.ao);
        }
        wy.a(this.aa, goldThing, 10 + this.aa.nextInt(30));
        this.a(goldThing, 0.0f);
    }
    
    public void am() {
    }
    
    protected boolean bj() {
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
    
    public void c() {
        final float angle = this.aw * 3.141593f / 180.0f;
        final double dx = this.t + ke.b(angle) * 0.65;
        final double dy = this.u + this.O * 0.94;
        final double dz = this.v + ke.a(angle) * 0.65;
        final int factor = (80 - this.aY) / 10;
        for (int particles = (factor > 0) ? this.aa.nextInt(factor) : 1, j1 = 0; j1 < particles; ++j1) {
            float sparkle = 1.0f - (this.aY + 1.0f) / 60.0f;
            sparkle *= sparkle;
            float red = 0.37f * sparkle;
            float grn = 0.99f * sparkle;
            float blu = 0.89f * sparkle;
            if (this.getNextAttackType() != 0) {
                red = 0.99f * sparkle;
                grn = 0.47f * sparkle;
                blu = 0.0f * sparkle;
            }
            this.p.a("mobSpell", dx + this.aa.nextGaussian() * 0.025, dy + this.aa.nextGaussian() * 0.025, dz + this.aa.nextGaussian() * 0.025, (double)red, (double)grn, (double)blu);
        }
        if (this.isShadowClone()) {
            this.checkForMaster();
        }
        if (!this.p.J) {
            this.ag.b(19, (Object)this.aQ);
        }
        super.c();
    }
    
    public boolean a(final lh par1DamageSource, final int par2) {
        if (par1DamageSource.l() == "inWall" && this.a_ != null) {
            this.teleportToSightOfEntity(this.a_);
        }
        if (this.isShadowClone()) {
            this.p.a((lq)this, "random.fizz", 1.0f, ((this.aa.nextFloat() - this.aa.nextFloat()) * 0.7f + 1.0f) * 2.0f);
            return false;
        }
        final lq prevTarget = this.a_;
        if (par1DamageSource.g() instanceof EntityTFLich) {
            return false;
        }
        if (this.getShieldStrength() > 0) {
            if (par1DamageSource.c() && par2 > 2) {
                if (this.getShieldStrength() > 0) {
                    this.setShieldStrength(this.getShieldStrength() - 1);
                    this.p.a((lq)this, "random.break", 1.0f, ((this.aa.nextFloat() - this.aa.nextFloat()) * 0.7f + 1.0f) * 2.0f);
                }
            }
            else {
                this.p.a((lq)this, "random.break", 1.0f, ((this.aa.nextFloat() - this.aa.nextFloat()) * 0.7f + 1.0f) * 2.0f);
                if (par1DamageSource.g() instanceof qx) {
                    this.a_ = par1DamageSource.g();
                }
            }
            return false;
        }
        if (super.a(par1DamageSource, par2)) {
            if (this.a_ instanceof EntityTFLich) {
                this.a_ = prevTarget;
            }
            if (this.getPhase() < 3 || this.aa.nextInt(4) == 0) {
                this.teleportToSightOfEntity(this.a_);
            }
            return true;
        }
        return false;
    }
    
    protected void a(final lq targetedEntity, final float f) {
        if (!this.isShadowClone() && this.aY % 15 == 0) {
            this.popNearbyMob();
        }
        if (this.getPhase() == 1) {
            if (this.aY == 60 && !this.p.J) {
                this.teleportToSightOfEntity(targetedEntity);
                if (!this.isShadowClone()) {
                    this.checkAndSpawnClones(targetedEntity);
                }
            }
            if (this.n(targetedEntity) && this.aY == 0 && f < 20.0f) {
                if (this.getNextAttackType() == 0) {
                    this.launchBoltAt(targetedEntity);
                }
                else {
                    this.launchBombAt(targetedEntity);
                }
                if (this.aa.nextInt(3) > 0) {
                    this.setNextAttackType(0);
                }
                else {
                    this.setNextAttackType(1);
                }
                this.aY = 100;
            }
            this.b = true;
        }
        if (this.getPhase() == 2 && !this.isShadowClone()) {
            this.despawnClones();
            if (this.aY % 15 == 0) {
                this.checkAndSpawnMinions(targetedEntity);
            }
            if (this.aY == 0) {
                if (f < 2.0f) {
                    this.m(targetedEntity);
                    this.aY = 20;
                }
                else if (f < 20.0f && this.n(targetedEntity)) {
                    if (this.getNextAttackType() == 0) {
                        this.launchBoltAt(targetedEntity);
                    }
                    else {
                        this.launchBombAt(targetedEntity);
                    }
                    if (this.aa.nextInt(2) > 0) {
                        this.setNextAttackType(0);
                    }
                    else {
                        this.setNextAttackType(1);
                    }
                    this.aY = 60;
                }
                else {
                    this.teleportToSightOfEntity(targetedEntity);
                    this.aY = 20;
                }
            }
            this.b = true;
        }
        if (this.getPhase() == 3 && this.aY <= 0 && f < 2.0f && targetedEntity.D.e > this.D.b && targetedEntity.D.b < this.D.e) {
            this.aY = 20;
            this.m(targetedEntity);
            this.b = true;
        }
    }
    
    protected void launchBoltAt(final lq targetedEntity) {
        final float bodyFacingAngle = this.aw * 3.141593f / 180.0f;
        final double sx = this.t + ke.b(bodyFacingAngle) * 0.65;
        final double sy = this.u + this.O * 0.82;
        final double sz = this.v + ke.a(bodyFacingAngle) * 0.65;
        final double tx = targetedEntity.t - sx;
        final double ty = targetedEntity.D.b + targetedEntity.O / 2.0f - (this.u + this.O / 2.0f);
        final double tz = targetedEntity.v - sz;
        this.p.a((lq)this, "mob.ghast.fireball", this.aX(), (this.aa.nextFloat() - this.aa.nextFloat()) * 0.2f + 1.0f);
        final EntityTFLichBolt projectile = new EntityTFLichBolt(this.p, (md)this);
        projectile.c(tx, ty, tz, projectile.func_40077_c(), 1.0f);
        projectile.b(sx, sy, sz, this.z, this.A);
        this.p.d((lq)projectile);
    }
    
    protected void launchBombAt(final lq targetedEntity) {
        final float bodyFacingAngle = this.aw * 3.141593f / 180.0f;
        final double sx = this.t + ke.b(bodyFacingAngle) * 0.65;
        final double sy = this.u + this.O * 0.82;
        final double sz = this.v + ke.a(bodyFacingAngle) * 0.65;
        final double tx = targetedEntity.t - sx;
        final double ty = targetedEntity.D.b + targetedEntity.O / 2.0f - (this.u + this.O / 2.0f);
        final double tz = targetedEntity.v - sz;
        this.p.a((lq)this, "mob.ghast.fireball", this.aX(), (this.aa.nextFloat() - this.aa.nextFloat()) * 0.2f + 1.0f);
        final EntityTFLichBomb projectile = new EntityTFLichBomb(this.p, (md)this);
        projectile.c(tx, ty, tz, projectile.func_40077_c(), 1.0f);
        projectile.b(sx, sy, sz, this.z, this.A);
        this.p.d((lq)projectile);
    }
    
    protected void popNearbyMob() {
        final List nearbyMobs = this.p.b((lq)this, anw.a().a(this.t, this.u, this.v, this.t + 1.0, this.u + 1.0, this.v + 1.0).b(32.0, 16.0, 32.0));
        for (final lq entity : nearbyMobs) {
            if (entity instanceof md && this.canPop(entity) && this.n(entity)) {
                final md mob = (md)entity;
                if (!this.p.J) {
                    mob.x();
                    mob.aR();
                }
                this.makeRedMagicTrail(mob.t, mob.u + mob.O / 2.0, mob.v, this.t, this.u + this.O / 2.0, this.v);
                break;
            }
        }
    }
    
    protected boolean canPop(final lq nearby) {
        final Class[] arr$;
        final Class[] poppable = arr$ = new Class[] { qn.class, qr.class, qd.class, qp.class, qc.class, EntityTFSwarmSpider.class };
        for (final Class pop : arr$) {
            if (nearby.getClass() == pop) {
                return true;
            }
        }
        return false;
    }
    
    protected void checkAndSpawnClones(final lq targetedEntity) {
        if (this.countMyClones() < 2) {
            this.spawnShadowClone(targetedEntity);
        }
    }
    
    protected int countMyClones() {
        final List nearbyLiches = this.p.a((Class)EntityTFLich.class, anw.a().a(this.t, this.u, this.v, this.t + 1.0, this.u + 1.0, this.v + 1.0).b(32.0, 16.0, 32.0));
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
    
    protected void spawnShadowClone(final lq targetedEntity) {
        final aob cloneSpot = this.findVecInLOSOf(targetedEntity);
        final EntityTFLich newClone = new EntityTFLich(this.p, this);
        newClone.b(cloneSpot.c, cloneSpot.d, cloneSpot.e);
        this.p.d((lq)newClone);
        newClone.a_ = targetedEntity;
        newClone.aY = 60 + this.aa.nextInt(3) - this.aa.nextInt(3);
        this.makeTeleportTrail(this.t, this.u, this.v, cloneSpot.c, cloneSpot.d, cloneSpot.e);
    }
    
    protected void despawnClones() {
        final List nearbyLiches = this.p.a((Class)this.getClass(), anw.a().a(this.t, this.u, this.v, this.t + 1.0, this.u + 1.0, this.v + 1.0).b(32.0, 16.0, 32.0));
        for (final EntityTFLich nearbyLich : nearbyLiches) {
            if (nearbyLich.isShadowClone()) {
                nearbyLich.L = true;
            }
        }
    }
    
    protected void checkAndSpawnMinions(final lq targetedEntity) {
        if (!this.p.J && this.getMinionsToSummon() > 0) {
            final int minions = this.countMyMinions();
            if (minions < 3) {
                this.spawnMinionAt((md)targetedEntity);
                this.setMinionsToSummon(this.getMinionsToSummon() - 1);
            }
        }
    }
    
    protected int countMyMinions() {
        final List nearbyMinons = this.p.a((Class)EntityTFLichMinion.class, anw.a().a(this.t, this.u, this.v, this.t + 1.0, this.u + 1.0, this.v + 1.0).b(32.0, 16.0, 32.0));
        int count = 0;
        for (final EntityTFLichMinion nearbyMinon : nearbyMinons) {
            if (nearbyMinon.master == this) {
                ++count;
            }
        }
        return count;
    }
    
    protected void spawnMinionAt(final md targetedEntity) {
        final aob minionSpot = this.findVecInLOSOf((lq)targetedEntity);
        final EntityTFLichMinion minion = new EntityTFLichMinion(this.p, this);
        minion.b(minionSpot.c, minionSpot.d, minionSpot.e);
        minion.bG();
        this.p.d((lq)minion);
        minion.b(targetedEntity);
        minion.aR();
        this.p.a((lq)minion, "random.pop", 1.0f, ((this.aa.nextFloat() - this.aa.nextFloat()) * 0.7f + 1.0f) * 2.0f);
        this.makeBlackMagicTrail(this.t, this.u + this.e(), this.v, minionSpot.c, minionSpot.d + minion.O / 2.0, minionSpot.e);
    }
    
    public boolean wantsNewMinion(final EntityTFLichMinion minion) {
        return this.countMyMinions() < 3;
    }
    
    protected void checkForMaster() {
        if (this.masterLich == null) {
            this.findNewMaster();
        }
        if (!this.p.J) {
            if (this.masterLich == null || this.masterLich.L) {
                this.L = true;
            }
            else {
                final double distance = (this.t - this.masterLich.t) * (this.t - this.masterLich.t) + (this.u - this.masterLich.u) * (this.u - this.masterLich.u) + (this.v - this.masterLich.v) * (this.v - this.masterLich.v);
            }
        }
    }
    
    private void findNewMaster() {
        final List nearbyLiches = this.p.a((Class)EntityTFLich.class, anw.a().a(this.t, this.u, this.v, this.t + 1.0, this.u + 1.0, this.v + 1.0).b(32.0, 16.0, 32.0));
        for (final EntityTFLich nearbyLich : nearbyLiches) {
            if (!nearbyLich.isShadowClone() && nearbyLich.wantsNewClone(this)) {
                this.masterLich = nearbyLich;
                this.makeTeleportTrail(this.t, this.u, this.v, nearbyLich.t, nearbyLich.u, nearbyLich.v);
                this.b(this.masterLich.aG());
                break;
            }
        }
    }
    
    protected void teleportToSightOfEntity(final lq entity) {
        final aob dest = this.findVecInLOSOf(entity);
        final double srcX = this.t;
        final double srcY = this.u;
        final double srcZ = this.v;
        if (dest != null) {
            this.teleportToNoChecks(dest.c, dest.d, dest.e);
            this.a(entity, 100.0f, 100.0f);
            this.aw = this.z;
            if (!this.n(entity)) {
                this.teleportToNoChecks(srcX, srcY, srcZ);
            }
        }
    }
    
    protected aob findVecInLOSOf(final lq targetEntity) {
        double tx = 0.0;
        double ty = 0.0;
        double tz = 0.0;
        final int tries = 100;
        for (int i = 0; i < tries; ++i) {
            tx = targetEntity.t + this.aa.nextGaussian() * 16.0;
            ty = targetEntity.u + this.aa.nextGaussian() * 8.0;
            tz = targetEntity.v + this.aa.nextGaussian() * 16.0;
            boolean groundFlag = false;
            final int bx = ke.c(tx);
            int by = ke.c(ty);
            final int bz = ke.c(tz);
            while (!groundFlag && ty > 0.0) {
                final int whatsThere = this.p.a(bx, by - 1, bz);
                if (whatsThere == 0 || !amj.p[whatsThere].cB.a()) {
                    --ty;
                    --by;
                }
                else {
                    groundFlag = true;
                }
            }
            if (by != 0) {
                if (this.canEntitySee(targetEntity, tx, ty, tz)) {
                    final float halfWidth = this.N / 2.0f;
                    final anw destBox = anw.a(tx - halfWidth, ty - this.M + this.W, tz - halfWidth, tx + halfWidth, ty - this.M + this.W + this.O, tz + halfWidth);
                    if (this.p.a((lq)this, destBox).size() <= 0) {
                        if (!this.p.d(destBox)) {
                            break;
                        }
                    }
                }
            }
        }
        if (tries == 99) {
            return null;
        }
        return this.p.S().a(tx, ty, tz);
    }
    
    protected boolean canEntitySee(final lq entity, final double dx, final double dy, final double dz) {
        return this.p.a(this.p.S().a(entity.t, entity.u + entity.e(), entity.v), this.p.S().a(dx, dy, dz)) == null;
    }
    
    protected boolean teleportToNoChecks(final double destX, final double destY, final double destZ) {
        final double srcX = this.t;
        final double srcY = this.u;
        final double srcZ = this.v;
        this.b(destX, destY, destZ);
        this.makeTeleportTrail(srcX, srcY, srcZ, destX, destY, destZ);
        this.p.a(srcX, srcY, srcZ, "mob.endermen.portal", 1.0f, 1.0f);
        this.p.a((lq)this, "mob.endermen.portal", 1.0f, 1.0f);
        this.bE = false;
        return true;
    }
    
    protected void makeTeleportTrail(final double srcX, final double srcY, final double srcZ, final double destX, final double destY, final double destZ) {
        for (int particles = 128, i = 0; i < particles; ++i) {
            final double trailFactor = i / (particles - 1.0);
            final float f = (this.aa.nextFloat() - 0.5f) * 0.2f;
            final float f2 = (this.aa.nextFloat() - 0.5f) * 0.2f;
            final float f3 = (this.aa.nextFloat() - 0.5f) * 0.2f;
            final double tx = srcX + (destX - srcX) * trailFactor + (this.aa.nextDouble() - 0.5) * this.N * 2.0;
            final double ty = srcY + (destY - srcY) * trailFactor + this.aa.nextDouble() * this.O;
            final double tz = srcZ + (destZ - srcZ) * trailFactor + (this.aa.nextDouble() - 0.5) * this.N * 2.0;
            this.p.a("spell", tx, ty, tz, (double)f, (double)f2, (double)f3);
        }
    }
    
    protected void makeRedMagicTrail(final double srcX, final double srcY, final double srcZ, final double destX, final double destY, final double destZ) {
        for (int particles = 32, i = 0; i < particles; ++i) {
            final double trailFactor = i / (particles - 1.0);
            final float f = 1.0f;
            final float f2 = 0.5f;
            final float f3 = 0.5f;
            final double tx = srcX + (destX - srcX) * trailFactor + this.aa.nextGaussian() * 0.005;
            final double ty = srcY + (destY - srcY) * trailFactor + this.aa.nextGaussian() * 0.005;
            final double tz = srcZ + (destZ - srcZ) * trailFactor + this.aa.nextGaussian() * 0.005;
            this.p.a("mobSpell", tx, ty, tz, (double)f, (double)f2, (double)f3);
        }
    }
    
    protected void makeBlackMagicTrail(final double srcX, final double srcY, final double srcZ, final double destX, final double destY, final double destZ) {
        for (int particles = 32, i = 0; i < particles; ++i) {
            final double trailFactor = i / (particles - 1.0);
            final float f = 0.2f;
            final float f2 = 0.2f;
            final float f3 = 0.2f;
            final double tx = srcX + (destX - srcX) * trailFactor + this.aa.nextGaussian() * 0.005;
            final double ty = srcY + (destY - srcY) * trailFactor + this.aa.nextGaussian() * 0.005;
            final double tz = srcZ + (destZ - srcZ) * trailFactor + this.aa.nextGaussian() * 0.005;
            this.p.a("mobSpell", tx, ty, tz, (double)f, (double)f2, (double)f3);
        }
    }
    
    public boolean isShadowClone() {
        return (this.ag.a(16) & 0x2) != 0x0;
    }
    
    public void setShadowClone(final boolean par1) {
        final byte var2 = this.ag.a(16);
        if (par1) {
            this.ag.b(16, (Object)(byte)(var2 | 0x2));
        }
        else {
            this.ag.b(16, (Object)(byte)(var2 & 0xFFFFFFFD));
        }
    }
    
    public byte getShieldStrength() {
        return this.ag.a(17);
    }
    
    public void setShieldStrength(final int shieldStrength) {
        this.ag.b(17, (Object)(byte)shieldStrength);
    }
    
    public byte getMinionsToSummon() {
        return this.ag.a(18);
    }
    
    public void setMinionsToSummon(final int minionsToSummon) {
        this.ag.b(18, (Object)(byte)minionsToSummon);
    }
    
    public byte getNextAttackType() {
        return this.ag.a(20);
    }
    
    public void setNextAttackType(final int attackType) {
        this.ag.b(20, (Object)(byte)attackType);
    }
    
    protected String aY() {
        return "mob.blaze.breathe";
    }
    
    protected String aZ() {
        return "mob.blaze.hit";
    }
    
    protected String ba() {
        return "mob.blaze.death";
    }
    
    public void b(final bq nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.a("ShadowClone", this.isShadowClone());
        nbttagcompound.a("ShieldStrength", this.getShieldStrength());
        nbttagcompound.a("MinionsToSummon", this.getMinionsToSummon());
    }
    
    public void a(final bq nbttagcompound) {
        super.a(nbttagcompound);
        this.setShadowClone(nbttagcompound.n("ShadowClone"));
        this.setShieldStrength(nbttagcompound.c("ShieldStrength"));
        this.setMinionsToSummon(nbttagcompound.c("MinionsToSummon"));
    }
    
    public void a(final lh par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.f() instanceof qx) {
            ((qx)par1DamageSource.f()).a((jl)TFAchievementPage.twilightHunter);
            ((qx)par1DamageSource.f()).a((jl)TFAchievementPage.twilightLich);
        }
    }
    
    public int b() {
        return this.ag.c(19);
    }
    
    public int c(final lq par1Entity) {
        return 6;
    }
    
    public mf bC() {
        return mf.b;
    }
    
    static {
        heldItems = new um[] { new um(TFItems.scepterTwilight, 1), new um(TFItems.scepterZombie, 1), new um(uk.G, 1) };
    }
}
