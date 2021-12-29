// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFAchievementPage;
import java.util.Iterator;
import java.util.List;
import twilightforest.item.TFItems;

public class EntityTFLich extends tl implements sf
{
    private static final int DATA_ISCLONE = 21;
    private static final int DATA_SHIELDSTRENGTH = 17;
    private static final int DATA_MINIONSLEFT = 18;
    private static final int DATA_BOSSHEALTH = 19;
    private static final int DATA_ATTACKTYPE = 20;
    EntityTFLich masterLich;
    private static final yd[] heldItems;
    public static final int MAX_SHADOW_CLONES = 2;
    public static final int INITIAL_SHIELD_STRENGTH = 5;
    public static final int MAX_ACTIVE_MINIONS = 3;
    public static final int INITIAL_MINIONS_TO_SUMMON = 9;
    public static final int MAX_HEALTH = 100;
    
    public EntityTFLich(final abv world) {
        super(world);
        this.a(1.1f, 2.5f);
        this.setShadowClone(false);
        this.masterLich = null;
        this.ag = true;
        this.setShieldStrength(5);
        this.setMinionsToSummon(9);
        this.b = 217;
    }
    
    public EntityTFLich(final abv world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    public EntityTFLich(final abv world, final EntityTFLich otherLich) {
        this(world);
        this.setShadowClone(true);
        this.masterLich = otherLich;
    }
    
    protected void a() {
        super.a();
        this.ah.a(21, (Object)0);
        this.ah.a(17, (Object)0);
        this.ah.a(18, (Object)0);
        this.ah.a(19, (Object)new Integer(100));
        this.ah.a(20, (Object)0);
    }
    
    protected void ay() {
        super.ay();
        this.a(to.a).a(100.0);
        this.a(to.e).a(6.0);
    }
    
    public yd aY() {
        return EntityTFLich.heldItems[this.getPhase() - 1];
    }
    
    protected void b(final boolean par1, final int par2) {
        this.dropScepter();
        for (int totalDrops = this.ab.nextInt(3 + par2) + 2, i = 0; i < totalDrops; ++i) {
            this.dropGoldThing();
        }
        for (int totalDrops = this.ab.nextInt(4 + par2) + 1, i = 0; i < totalDrops; ++i) {
            this.b(yb.bp.cv, 1);
        }
        for (int totalDrops = this.ab.nextInt(5 + par2) + 5, i = 0; i < totalDrops; ++i) {
            this.b(yb.aZ.cv, 1);
        }
        this.a(new yd(TFItems.trophy, 1, 2), 0.0f);
    }
    
    private void dropScepter() {
        final int scepterType = this.ab.nextInt(3);
        if (scepterType == 0) {
            this.a(new yd(TFItems.scepterZombie), 0.0f);
        }
        else if (scepterType == 1) {
            this.a(new yd(TFItems.scepterLifeDrain), 0.0f);
        }
        else {
            this.a(new yd(TFItems.scepterTwilight), 0.0f);
        }
    }
    
    private void dropGoldThing() {
        final int thingType = this.ab.nextInt(5);
        yd goldThing;
        if (thingType == 0) {
            goldThing = new yd(yb.I);
        }
        else if (thingType == 1) {
            goldThing = new yd((yb)yb.an);
        }
        else if (thingType == 2) {
            goldThing = new yd((yb)yb.ao);
        }
        else if (thingType == 3) {
            goldThing = new yd((yb)yb.ap);
        }
        else {
            goldThing = new yd((yb)yb.aq);
        }
        aav.a(this.ab, goldThing, 10 + this.ab.nextInt(30));
        this.a(goldThing, 0.0f);
    }
    
    public void al() {
    }
    
    protected boolean t() {
        return false;
    }
    
    public boolean I() {
        return false;
    }
    
    public boolean G() {
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
        final float angle = this.aN * 3.141593f / 180.0f;
        final double dx = this.u + lr.b(angle) * 0.65;
        final double dy = this.v + this.P * 0.94;
        final double dz = this.w + lr.a(angle) * 0.65;
        final int factor = (80 - this.aC) / 10;
        for (int particles = (factor > 0) ? this.ab.nextInt(factor) : 1, j1 = 0; j1 < particles; ++j1) {
            float sparkle = 1.0f - (this.aC + 1.0f) / 60.0f;
            sparkle *= sparkle;
            float red = 0.37f * sparkle;
            float grn = 0.99f * sparkle;
            float blu = 0.89f * sparkle;
            if (this.getNextAttackType() != 0) {
                red = 0.99f * sparkle;
                grn = 0.47f * sparkle;
                blu = 0.0f * sparkle;
            }
            this.q.a("mobSpell", dx + this.ab.nextGaussian() * 0.025, dy + this.ab.nextGaussian() * 0.025, dz + this.ab.nextGaussian() * 0.025, (double)red, (double)grn, (double)blu);
        }
        if (this.isShadowClone()) {
            this.checkForMaster();
        }
        if (!this.q.I) {
            this.ah.b(19, (Object)(int)this.aM());
        }
        super.c();
    }
    
    public boolean a(final na par1DamageSource, final float damage) {
        if (par1DamageSource.n() == "inWall" && this.j != null) {
            this.teleportToSightOfEntity(this.j);
        }
        if (this.isShadowClone()) {
            this.q.a((nm)this, "random.fizz", 1.0f, ((this.ab.nextFloat() - this.ab.nextFloat()) * 0.7f + 1.0f) * 2.0f);
            return false;
        }
        final nm prevTarget = this.j;
        if (par1DamageSource.i() instanceof EntityTFLich) {
            return false;
        }
        if (this.getShieldStrength() > 0) {
            if (par1DamageSource.e() && damage > 2.0f) {
                if (this.getShieldStrength() > 0) {
                    this.setShieldStrength(this.getShieldStrength() - 1);
                    this.q.a((nm)this, "random.break", 1.0f, ((this.ab.nextFloat() - this.ab.nextFloat()) * 0.7f + 1.0f) * 2.0f);
                }
            }
            else {
                this.q.a((nm)this, "random.break", 1.0f, ((this.ab.nextFloat() - this.ab.nextFloat()) * 0.7f + 1.0f) * 2.0f);
                if (par1DamageSource.i() instanceof ue) {
                    this.j = par1DamageSource.i();
                }
            }
            return false;
        }
        if (super.a(par1DamageSource, damage)) {
            if (this.j instanceof EntityTFLich) {
                this.j = prevTarget;
            }
            if (this.getPhase() < 3 || this.ab.nextInt(4) == 0) {
                this.teleportToSightOfEntity(this.j);
            }
            return true;
        }
        return false;
    }
    
    protected void a(final nm targetedEntity, final float f) {
        if (!this.isShadowClone() && this.aC % 15 == 0) {
            this.popNearbyMob();
        }
        if (this.getPhase() == 1) {
            if (this.aC == 60 && !this.q.I) {
                this.teleportToSightOfEntity(targetedEntity);
                if (!this.isShadowClone()) {
                    this.checkAndSpawnClones(targetedEntity);
                }
            }
            if (this.o(targetedEntity) && this.aC == 0 && f < 20.0f) {
                if (this.getNextAttackType() == 0) {
                    this.launchBoltAt(targetedEntity);
                }
                else {
                    this.launchBombAt(targetedEntity);
                }
                if (this.ab.nextInt(3) > 0) {
                    this.setNextAttackType(0);
                }
                else {
                    this.setNextAttackType(1);
                }
                this.aC = 100;
            }
            this.bn = true;
        }
        if (this.getPhase() == 2 && !this.isShadowClone()) {
            this.despawnClones();
            if (this.aC % 15 == 0) {
                this.checkAndSpawnMinions(targetedEntity);
            }
            if (this.aC == 0) {
                if (f < 2.0f) {
                    this.m(targetedEntity);
                    this.aC = 20;
                }
                else if (f < 20.0f && this.o(targetedEntity)) {
                    if (this.getNextAttackType() == 0) {
                        this.launchBoltAt(targetedEntity);
                    }
                    else {
                        this.launchBombAt(targetedEntity);
                    }
                    if (this.ab.nextInt(2) > 0) {
                        this.setNextAttackType(0);
                    }
                    else {
                        this.setNextAttackType(1);
                    }
                    this.aC = 60;
                }
                else {
                    this.teleportToSightOfEntity(targetedEntity);
                    this.aC = 20;
                }
            }
            this.bn = true;
        }
        if (this.getPhase() == 3 && this.aC <= 0 && f < 2.0f && targetedEntity.E.e > this.E.b && targetedEntity.E.b < this.E.e) {
            this.aC = 20;
            this.m(targetedEntity);
            this.bn = true;
        }
    }
    
    protected void launchBoltAt(final nm targetedEntity) {
        final float bodyFacingAngle = this.aN * 3.141593f / 180.0f;
        final double sx = this.u + lr.b(bodyFacingAngle) * 0.65;
        final double sy = this.v + this.P * 0.82;
        final double sz = this.w + lr.a(bodyFacingAngle) * 0.65;
        final double tx = targetedEntity.u - sx;
        final double ty = targetedEntity.E.b + targetedEntity.P / 2.0f - (this.v + this.P / 2.0f);
        final double tz = targetedEntity.w - sz;
        this.q.a((nm)this, "mob.ghast.fireball", this.aZ(), (this.ab.nextFloat() - this.ab.nextFloat()) * 0.2f + 1.0f);
        final EntityTFLichBolt projectile = new EntityTFLichBolt(this.q, (oe)this);
        projectile.c(tx, ty, tz, projectile.func_40077_c(), 1.0f);
        projectile.b(sx, sy, sz, this.A, this.B);
        this.q.d((nm)projectile);
    }
    
    protected void launchBombAt(final nm targetedEntity) {
        final float bodyFacingAngle = this.aN * 3.141593f / 180.0f;
        final double sx = this.u + lr.b(bodyFacingAngle) * 0.65;
        final double sy = this.v + this.P * 0.82;
        final double sz = this.w + lr.a(bodyFacingAngle) * 0.65;
        final double tx = targetedEntity.u - sx;
        final double ty = targetedEntity.E.b + targetedEntity.P / 2.0f - (this.v + this.P / 2.0f);
        final double tz = targetedEntity.w - sz;
        this.q.a((nm)this, "mob.ghast.fireball", this.aZ(), (this.ab.nextFloat() - this.ab.nextFloat()) * 0.2f + 1.0f);
        final EntityTFLichBomb projectile = new EntityTFLichBomb(this.q, (oe)this);
        projectile.c(tx, ty, tz, projectile.func_40077_c(), 1.0f);
        projectile.b(sx, sy, sz, this.A, this.B);
        this.q.d((nm)projectile);
    }
    
    protected void popNearbyMob() {
        final List<nm> nearbyMobs = this.q.b((nm)this, asu.a().a(this.u, this.v, this.w, this.u + 1.0, this.v + 1.0, this.w + 1.0).b(32.0, 16.0, 32.0));
        for (final nm entity : nearbyMobs) {
            if (entity instanceof of && this.canPop(entity) && this.o(entity)) {
                final of mob = (of)entity;
                if (!this.q.I) {
                    mob.w();
                    mob.q();
                }
                this.makeRedMagicTrail(mob.u, mob.v + mob.P / 2.0, mob.w, this.u, this.v + this.P / 2.0, this.w);
                break;
            }
        }
    }
    
    protected boolean canPop(final nm nearby) {
        final Class[] arr$;
        final Class[] poppable = arr$ = new Class[] { tq.class, tv.class, tf.class, ts.class, te.class, EntityTFSwarmSpider.class };
        for (final Class pop : arr$) {
            if (nearby.getClass() == pop) {
                return true;
            }
        }
        return false;
    }
    
    protected void checkAndSpawnClones(final nm targetedEntity) {
        if (this.countMyClones() < 2) {
            this.spawnShadowClone(targetedEntity);
        }
    }
    
    protected int countMyClones() {
        final List<EntityTFLich> nearbyLiches = this.q.a((Class)EntityTFLich.class, asu.a().a(this.u, this.v, this.w, this.u + 1.0, this.v + 1.0, this.w + 1.0).b(32.0, 16.0, 32.0));
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
    
    protected void spawnShadowClone(final nm targetedEntity) {
        final asz cloneSpot = this.findVecInLOSOf(targetedEntity);
        final EntityTFLich newClone = new EntityTFLich(this.q, this);
        newClone.b(cloneSpot.c, cloneSpot.d, cloneSpot.e);
        this.q.d((nm)newClone);
        newClone.j = targetedEntity;
        newClone.aC = 60 + this.ab.nextInt(3) - this.ab.nextInt(3);
        this.makeTeleportTrail(this.u, this.v, this.w, cloneSpot.c, cloneSpot.d, cloneSpot.e);
    }
    
    protected void despawnClones() {
        final List<EntityTFLich> nearbyLiches = this.q.a((Class)this.getClass(), asu.a().a(this.u, this.v, this.w, this.u + 1.0, this.v + 1.0, this.w + 1.0).b(32.0, 16.0, 32.0));
        for (final EntityTFLich nearbyLich : nearbyLiches) {
            if (nearbyLich.isShadowClone()) {
                nearbyLich.M = true;
            }
        }
    }
    
    protected void checkAndSpawnMinions(final nm targetedEntity) {
        if (!this.q.I && this.getMinionsToSummon() > 0) {
            final int minions = this.countMyMinions();
            if (minions < 3) {
                this.spawnMinionAt((oe)targetedEntity);
                this.setMinionsToSummon(this.getMinionsToSummon() - 1);
            }
        }
    }
    
    protected int countMyMinions() {
        final List<EntityTFLichMinion> nearbyMinons = this.q.a((Class)EntityTFLichMinion.class, asu.a().a(this.u, this.v, this.w, this.u + 1.0, this.v + 1.0, this.w + 1.0).b(32.0, 16.0, 32.0));
        int count = 0;
        for (final EntityTFLichMinion nearbyMinon : nearbyMinons) {
            if (nearbyMinon.master == this) {
                ++count;
            }
        }
        return count;
    }
    
    protected void spawnMinionAt(final oe targetedEntity) {
        final asz minionSpot = this.findVecInLOSOf((nm)targetedEntity);
        final EntityTFLichMinion minion = new EntityTFLichMinion(this.q, this);
        minion.b(minionSpot.c, minionSpot.d, minionSpot.e);
        this.q.d((nm)minion);
        minion.d(targetedEntity);
        minion.q();
        this.q.a((nm)minion, "random.pop", 1.0f, ((this.ab.nextFloat() - this.ab.nextFloat()) * 0.7f + 1.0f) * 2.0f);
        this.makeBlackMagicTrail(this.u, this.v + this.f(), this.w, minionSpot.c, minionSpot.d + minion.P / 2.0, minionSpot.e);
    }
    
    public boolean wantsNewMinion(final EntityTFLichMinion minion) {
        return this.countMyMinions() < 3;
    }
    
    protected void checkForMaster() {
        if (this.masterLich == null) {
            this.findNewMaster();
        }
        if (!this.q.I) {
            if (this.masterLich == null || this.masterLich.M) {
                this.M = true;
            }
            else {
                final double distance = (this.u - this.masterLich.u) * (this.u - this.masterLich.u) + (this.v - this.masterLich.v) * (this.v - this.masterLich.v) + (this.w - this.masterLich.w) * (this.w - this.masterLich.w);
            }
        }
    }
    
    private void findNewMaster() {
        final List<EntityTFLich> nearbyLiches = this.q.a((Class)EntityTFLich.class, asu.a().a(this.u, this.v, this.w, this.u + 1.0, this.v + 1.0, this.w + 1.0).b(32.0, 16.0, 32.0));
        for (final EntityTFLich nearbyLich : nearbyLiches) {
            if (!nearbyLich.isShadowClone() && nearbyLich.wantsNewClone(this)) {
                this.masterLich = nearbyLich;
                this.makeTeleportTrail(this.u, this.v, this.w, nearbyLich.u, nearbyLich.v, nearbyLich.w);
                this.d(this.masterLich.m());
                break;
            }
        }
    }
    
    protected void teleportToSightOfEntity(final nm entity) {
        final asz dest = this.findVecInLOSOf(entity);
        final double srcX = this.u;
        final double srcY = this.v;
        final double srcZ = this.w;
        if (dest != null) {
            this.teleportToNoChecks(dest.c, dest.d, dest.e);
            this.a(entity, 100.0f, 100.0f);
            this.aN = this.A;
            if (!this.o(entity)) {
                this.teleportToNoChecks(srcX, srcY, srcZ);
            }
        }
    }
    
    protected asz findVecInLOSOf(final nm targetEntity) {
        if (targetEntity == null) {
            return null;
        }
        double tx = 0.0;
        double ty = 0.0;
        double tz = 0.0;
        final int tries = 100;
        for (int i = 0; i < tries; ++i) {
            tx = targetEntity.u + this.ab.nextGaussian() * 16.0;
            ty = targetEntity.v + this.ab.nextGaussian() * 8.0;
            tz = targetEntity.w + this.ab.nextGaussian() * 16.0;
            boolean groundFlag = false;
            final int bx = lr.c(tx);
            int by = lr.c(ty);
            final int bz = lr.c(tz);
            while (!groundFlag && ty > 0.0) {
                final int whatsThere = this.q.a(bx, by - 1, bz);
                if (whatsThere == 0 || !aqw.s[whatsThere].cU.a()) {
                    --ty;
                    --by;
                }
                else {
                    groundFlag = true;
                }
            }
            if (by != 0) {
                if (this.canEntitySee(targetEntity, tx, ty, tz)) {
                    final float halfWidth = this.O / 2.0f;
                    final asu destBox = asu.a(tx - halfWidth, ty - this.N + this.X, tz - halfWidth, tx + halfWidth, ty - this.N + this.X + this.P, tz + halfWidth);
                    if (this.q.a((nm)this, destBox).size() <= 0) {
                        if (!this.q.d(destBox)) {
                            break;
                        }
                    }
                }
            }
        }
        if (tries == 99) {
            return null;
        }
        return this.q.V().a(tx, ty, tz);
    }
    
    protected boolean canEntitySee(final nm entity, final double dx, final double dy, final double dz) {
        return this.q.a(this.q.V().a(entity.u, entity.v + entity.f(), entity.w), this.q.V().a(dx, dy, dz)) == null;
    }
    
    protected boolean teleportToNoChecks(final double destX, final double destY, final double destZ) {
        final double srcX = this.u;
        final double srcY = this.v;
        final double srcZ = this.w;
        this.b(destX, destY, destZ);
        this.makeTeleportTrail(srcX, srcY, srcZ, destX, destY, destZ);
        this.q.a(srcX, srcY, srcZ, "mob.endermen.portal", 1.0f, 1.0f);
        this.q.a((nm)this, "mob.endermen.portal", 1.0f, 1.0f);
        this.bd = false;
        return true;
    }
    
    protected void makeTeleportTrail(final double srcX, final double srcY, final double srcZ, final double destX, final double destY, final double destZ) {
        for (int particles = 128, i = 0; i < particles; ++i) {
            final double trailFactor = i / (particles - 1.0);
            final float f = (this.ab.nextFloat() - 0.5f) * 0.2f;
            final float f2 = (this.ab.nextFloat() - 0.5f) * 0.2f;
            final float f3 = (this.ab.nextFloat() - 0.5f) * 0.2f;
            final double tx = srcX + (destX - srcX) * trailFactor + (this.ab.nextDouble() - 0.5) * this.O * 2.0;
            final double ty = srcY + (destY - srcY) * trailFactor + this.ab.nextDouble() * this.P;
            final double tz = srcZ + (destZ - srcZ) * trailFactor + (this.ab.nextDouble() - 0.5) * this.O * 2.0;
            this.q.a("spell", tx, ty, tz, (double)f, (double)f2, (double)f3);
        }
    }
    
    protected void makeRedMagicTrail(final double srcX, final double srcY, final double srcZ, final double destX, final double destY, final double destZ) {
        for (int particles = 32, i = 0; i < particles; ++i) {
            final double trailFactor = i / (particles - 1.0);
            final float f = 1.0f;
            final float f2 = 0.5f;
            final float f3 = 0.5f;
            final double tx = srcX + (destX - srcX) * trailFactor + this.ab.nextGaussian() * 0.005;
            final double ty = srcY + (destY - srcY) * trailFactor + this.ab.nextGaussian() * 0.005;
            final double tz = srcZ + (destZ - srcZ) * trailFactor + this.ab.nextGaussian() * 0.005;
            this.q.a("mobSpell", tx, ty, tz, (double)f, (double)f2, (double)f3);
        }
    }
    
    protected void makeBlackMagicTrail(final double srcX, final double srcY, final double srcZ, final double destX, final double destY, final double destZ) {
        for (int particles = 32, i = 0; i < particles; ++i) {
            final double trailFactor = i / (particles - 1.0);
            final float f = 0.2f;
            final float f2 = 0.2f;
            final float f3 = 0.2f;
            final double tx = srcX + (destX - srcX) * trailFactor + this.ab.nextGaussian() * 0.005;
            final double ty = srcY + (destY - srcY) * trailFactor + this.ab.nextGaussian() * 0.005;
            final double tz = srcZ + (destZ - srcZ) * trailFactor + this.ab.nextGaussian() * 0.005;
            this.q.a("mobSpell", tx, ty, tz, (double)f, (double)f2, (double)f3);
        }
    }
    
    public boolean isShadowClone() {
        return (this.ah.a(21) & 0x2) != 0x0;
    }
    
    public void setShadowClone(final boolean par1) {
        final byte var2 = this.ah.a(21);
        if (par1) {
            this.ah.b(21, (Object)(byte)(var2 | 0x2));
        }
        else {
            this.ah.b(21, (Object)(byte)(var2 & 0xFFFFFFFD));
        }
    }
    
    public byte getShieldStrength() {
        return this.ah.a(17);
    }
    
    public void setShieldStrength(final int shieldStrength) {
        this.ah.b(17, (Object)(byte)shieldStrength);
    }
    
    public byte getMinionsToSummon() {
        return this.ah.a(18);
    }
    
    public void setMinionsToSummon(final int minionsToSummon) {
        this.ah.b(18, (Object)(byte)minionsToSummon);
    }
    
    public byte getNextAttackType() {
        return this.ah.a(20);
    }
    
    public void setNextAttackType(final int attackType) {
        this.ah.b(20, (Object)(byte)attackType);
    }
    
    protected String r() {
        return "mob.blaze.breathe";
    }
    
    protected String aN() {
        return "mob.blaze.hit";
    }
    
    protected String aO() {
        return "mob.blaze.death";
    }
    
    public void b(final bx nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.a("ShadowClone", this.isShadowClone());
        nbttagcompound.a("ShieldStrength", this.getShieldStrength());
        nbttagcompound.a("MinionsToSummon", this.getMinionsToSummon());
    }
    
    public void a(final bx nbttagcompound) {
        super.a(nbttagcompound);
        this.setShadowClone(nbttagcompound.n("ShadowClone"));
        this.setShieldStrength(nbttagcompound.c("ShieldStrength"));
        this.setMinionsToSummon(nbttagcompound.c("MinionsToSummon"));
    }
    
    public void a(final na par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof ue) {
            ((ue)par1DamageSource.h()).a((kt)TFAchievementPage.twilightHunter);
            ((ue)par1DamageSource.h()).a((kt)TFAchievementPage.twilightLich);
        }
    }
    
    public oi aX() {
        return oi.b;
    }
    
    static {
        heldItems = new yd[] { new yd(TFItems.scepterTwilight, 1), new yd(TFItems.scepterZombie, 1), new yd(yb.I, 1) };
    }
}
