// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFAchievementPage;
import java.util.Iterator;
import java.util.List;
import twilightforest.item.TFItems;

public class EntityTFLich extends rv implements qp
{
    private static final int DATA_ISCLONE = 16;
    private static final int DATA_SHIELDSTRENGTH = 17;
    private static final int DATA_MINIONSLEFT = 18;
    private static final int DATA_BOSSHEALTH = 19;
    private static final int DATA_ATTACKTYPE = 20;
    EntityTFLich masterLich;
    private static final wg[] heldItems;
    public static final int MAX_SHADOW_CLONES = 2;
    public static final int INITIAL_SHIELD_STRENGTH = 5;
    public static final int MAX_ACTIVE_MINIONS = 3;
    public static final int INITIAL_MINIONS_TO_SUMMON = 9;
    public static final int MAX_HEALTH = 100;
    
    public EntityTFLich(final zv world) {
        super(world);
        this.a(1.1f, 2.5f);
        this.aH = "/mods/twilightforest/textures/model/twilightlich64.png";
        this.setShadowClone(false);
        this.masterLich = null;
        this.ag = true;
        this.setShieldStrength(5);
        this.setMinionsToSummon(9);
        this.be = 217;
    }
    
    public EntityTFLich(final zv world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    public EntityTFLich(final zv world, final EntityTFLich otherLich) {
        this(world);
        this.setShadowClone(true);
        this.masterLich = otherLich;
    }
    
    protected void a() {
        super.a();
        this.ah.a(16, (Object)0);
        this.ah.a(17, (Object)0);
        this.ah.a(18, (Object)0);
        this.ah.a(19, (Object)new Integer(100));
        this.ah.a(20, (Object)0);
    }
    
    public int aW() {
        return 100;
    }
    
    public wg bG() {
        return EntityTFLich.heldItems[this.getPhase() - 1];
    }
    
    protected void a(final boolean par1, final int par2) {
        this.dropScepter();
        for (int totalDrops = this.ab.nextInt(3 + par2) + 2, i = 0; i < totalDrops; ++i) {
            this.dropGoldThing();
        }
        for (int totalDrops = this.ab.nextInt(4 + par2) + 1, i = 0; i < totalDrops; ++i) {
            this.b(we.bo.cp, 1);
        }
        for (int totalDrops = this.ab.nextInt(5 + par2) + 5, i = 0; i < totalDrops; ++i) {
            this.b(we.aY.cp, 1);
        }
        this.a(new wg(TFItems.trophy, 1, 2), 0.0f);
    }
    
    private void dropScepter() {
        final int scepterType = this.ab.nextInt(3);
        if (scepterType == 0) {
            this.a(new wg(TFItems.scepterZombie), 0.0f);
        }
        else if (scepterType == 1) {
            this.a(new wg(TFItems.scepterLifeDrain), 0.0f);
        }
        else {
            this.a(new wg(TFItems.scepterTwilight), 0.0f);
        }
    }
    
    private void dropGoldThing() {
        final int thingType = this.ab.nextInt(5);
        wg goldThing;
        if (thingType == 0) {
            goldThing = new wg(we.H);
        }
        else if (thingType == 1) {
            goldThing = new wg((we)we.am);
        }
        else if (thingType == 2) {
            goldThing = new wg((we)we.an);
        }
        else if (thingType == 3) {
            goldThing = new wg((we)we.ao);
        }
        else {
            goldThing = new wg((we)we.ap);
        }
        yv.a(this.ab, goldThing, 10 + this.ab.nextInt(30));
        this.a(goldThing, 0.0f);
    }
    
    public void al() {
    }
    
    protected boolean bm() {
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
        final float angle = this.ay * 3.141593f / 180.0f;
        final double dx = this.u + kx.b(angle) * 0.65;
        final double dy = this.v + this.P * 0.94;
        final double dz = this.w + kx.a(angle) * 0.65;
        final int factor = (80 - this.ba) / 10;
        for (int particles = (factor > 0) ? this.ab.nextInt(factor) : 1, j1 = 0; j1 < particles; ++j1) {
            float sparkle = 1.0f - (this.ba + 1.0f) / 60.0f;
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
            this.ah.b(19, (Object)this.aS);
        }
        super.c();
    }
    
    public boolean a(final mg par1DamageSource, final int par2) {
        if (par1DamageSource.n() == "inWall" && this.a_ != null) {
            this.teleportToSightOfEntity(this.a_);
        }
        if (this.isShadowClone()) {
            this.q.a((mp)this, "random.fizz", 1.0f, ((this.ab.nextFloat() - this.ab.nextFloat()) * 0.7f + 1.0f) * 2.0f);
            return false;
        }
        final mp prevTarget = this.a_;
        if (par1DamageSource.i() instanceof EntityTFLich) {
            return false;
        }
        if (this.getShieldStrength() > 0) {
            if (par1DamageSource.e() && par2 > 2) {
                if (this.getShieldStrength() > 0) {
                    this.setShieldStrength(this.getShieldStrength() - 1);
                    this.q.a((mp)this, "random.break", 1.0f, ((this.ab.nextFloat() - this.ab.nextFloat()) * 0.7f + 1.0f) * 2.0f);
                }
            }
            else {
                this.q.a((mp)this, "random.break", 1.0f, ((this.ab.nextFloat() - this.ab.nextFloat()) * 0.7f + 1.0f) * 2.0f);
                if (par1DamageSource.i() instanceof sk) {
                    this.a_ = par1DamageSource.i();
                }
            }
            return false;
        }
        if (super.a(par1DamageSource, par2)) {
            if (this.a_ instanceof EntityTFLich) {
                this.a_ = prevTarget;
            }
            if (this.getPhase() < 3 || this.ab.nextInt(4) == 0) {
                this.teleportToSightOfEntity(this.a_);
            }
            return true;
        }
        return false;
    }
    
    protected void a(final mp targetedEntity, final float f) {
        if (!this.isShadowClone() && this.ba % 15 == 0) {
            this.popNearbyMob();
        }
        if (this.getPhase() == 1) {
            if (this.ba == 60 && !this.q.I) {
                this.teleportToSightOfEntity(targetedEntity);
                if (!this.isShadowClone()) {
                    this.checkAndSpawnClones(targetedEntity);
                }
            }
            if (this.n(targetedEntity) && this.ba == 0 && f < 20.0f) {
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
                this.ba = 100;
            }
            this.b = true;
        }
        if (this.getPhase() == 2 && !this.isShadowClone()) {
            this.despawnClones();
            if (this.ba % 15 == 0) {
                this.checkAndSpawnMinions(targetedEntity);
            }
            if (this.ba == 0) {
                if (f < 2.0f) {
                    this.m(targetedEntity);
                    this.ba = 20;
                }
                else if (f < 20.0f && this.n(targetedEntity)) {
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
                    this.ba = 60;
                }
                else {
                    this.teleportToSightOfEntity(targetedEntity);
                    this.ba = 20;
                }
            }
            this.b = true;
        }
        if (this.getPhase() == 3 && this.ba <= 0 && f < 2.0f && targetedEntity.E.e > this.E.b && targetedEntity.E.b < this.E.e) {
            this.ba = 20;
            this.m(targetedEntity);
            this.b = true;
        }
    }
    
    protected void launchBoltAt(final mp targetedEntity) {
        final float bodyFacingAngle = this.ay * 3.141593f / 180.0f;
        final double sx = this.u + kx.b(bodyFacingAngle) * 0.65;
        final double sy = this.v + this.P * 0.82;
        final double sz = this.w + kx.a(bodyFacingAngle) * 0.65;
        final double tx = targetedEntity.u - sx;
        final double ty = targetedEntity.E.b + targetedEntity.P / 2.0f - (this.v + this.P / 2.0f);
        final double tz = targetedEntity.w - sz;
        this.q.a((mp)this, "mob.ghast.fireball", this.ba(), (this.ab.nextFloat() - this.ab.nextFloat()) * 0.2f + 1.0f);
        final EntityTFLichBolt projectile = new EntityTFLichBolt(this.q, (ng)this);
        projectile.c(tx, ty, tz, projectile.func_40077_c(), 1.0f);
        projectile.b(sx, sy, sz, this.A, this.B);
        this.q.d((mp)projectile);
    }
    
    protected void launchBombAt(final mp targetedEntity) {
        final float bodyFacingAngle = this.ay * 3.141593f / 180.0f;
        final double sx = this.u + kx.b(bodyFacingAngle) * 0.65;
        final double sy = this.v + this.P * 0.82;
        final double sz = this.w + kx.a(bodyFacingAngle) * 0.65;
        final double tx = targetedEntity.u - sx;
        final double ty = targetedEntity.E.b + targetedEntity.P / 2.0f - (this.v + this.P / 2.0f);
        final double tz = targetedEntity.w - sz;
        this.q.a((mp)this, "mob.ghast.fireball", this.ba(), (this.ab.nextFloat() - this.ab.nextFloat()) * 0.2f + 1.0f);
        final EntityTFLichBomb projectile = new EntityTFLichBomb(this.q, (ng)this);
        projectile.c(tx, ty, tz, projectile.func_40077_c(), 1.0f);
        projectile.b(sx, sy, sz, this.A, this.B);
        this.q.d((mp)projectile);
    }
    
    protected void popNearbyMob() {
        final List nearbyMobs = this.q.b((mp)this, aqr.a().a(this.u, this.v, this.w, this.u + 1.0, this.v + 1.0, this.w + 1.0).b(32.0, 16.0, 32.0));
        for (final mp entity : nearbyMobs) {
            if (entity instanceof ng && this.canPop(entity) && this.n(entity)) {
                final ng mob = (ng)entity;
                if (!this.q.I) {
                    mob.w();
                    mob.aU();
                }
                this.makeRedMagicTrail(mob.u, mob.v + mob.P / 2.0, mob.w, this.u, this.v + this.P / 2.0, this.w);
                break;
            }
        }
    }
    
    protected boolean canPop(final mp nearby) {
        final Class[] arr$;
        final Class[] poppable = arr$ = new Class[] { rz.class, sd.class, rp.class, sb.class, ro.class, EntityTFSwarmSpider.class };
        for (final Class pop : arr$) {
            if (nearby.getClass() == pop) {
                return true;
            }
        }
        return false;
    }
    
    protected void checkAndSpawnClones(final mp targetedEntity) {
        if (this.countMyClones() < 2) {
            this.spawnShadowClone(targetedEntity);
        }
    }
    
    protected int countMyClones() {
        final List nearbyLiches = this.q.a((Class)EntityTFLich.class, aqr.a().a(this.u, this.v, this.w, this.u + 1.0, this.v + 1.0, this.w + 1.0).b(32.0, 16.0, 32.0));
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
    
    protected void spawnShadowClone(final mp targetedEntity) {
        final aqw cloneSpot = this.findVecInLOSOf(targetedEntity);
        final EntityTFLich newClone = new EntityTFLich(this.q, this);
        newClone.b(cloneSpot.c, cloneSpot.d, cloneSpot.e);
        this.q.d((mp)newClone);
        newClone.a_ = targetedEntity;
        newClone.ba = 60 + this.ab.nextInt(3) - this.ab.nextInt(3);
        this.makeTeleportTrail(this.u, this.v, this.w, cloneSpot.c, cloneSpot.d, cloneSpot.e);
    }
    
    protected void despawnClones() {
        final List nearbyLiches = this.q.a((Class)this.getClass(), aqr.a().a(this.u, this.v, this.w, this.u + 1.0, this.v + 1.0, this.w + 1.0).b(32.0, 16.0, 32.0));
        for (final EntityTFLich nearbyLich : nearbyLiches) {
            if (nearbyLich.isShadowClone()) {
                nearbyLich.M = true;
            }
        }
    }
    
    protected void checkAndSpawnMinions(final mp targetedEntity) {
        if (!this.q.I && this.getMinionsToSummon() > 0) {
            final int minions = this.countMyMinions();
            if (minions < 3) {
                this.spawnMinionAt((ng)targetedEntity);
                this.setMinionsToSummon(this.getMinionsToSummon() - 1);
            }
        }
    }
    
    protected int countMyMinions() {
        final List nearbyMinons = this.q.a((Class)EntityTFLichMinion.class, aqr.a().a(this.u, this.v, this.w, this.u + 1.0, this.v + 1.0, this.w + 1.0).b(32.0, 16.0, 32.0));
        int count = 0;
        for (final EntityTFLichMinion nearbyMinon : nearbyMinons) {
            if (nearbyMinon.master == this) {
                ++count;
            }
        }
        return count;
    }
    
    protected void spawnMinionAt(final ng targetedEntity) {
        final aqw minionSpot = this.findVecInLOSOf((mp)targetedEntity);
        final EntityTFLichMinion minion = new EntityTFLichMinion(this.q, this);
        minion.b(minionSpot.c, minionSpot.d, minionSpot.e);
        minion.bJ();
        this.q.d((mp)minion);
        minion.b(targetedEntity);
        minion.aU();
        this.q.a((mp)minion, "random.pop", 1.0f, ((this.ab.nextFloat() - this.ab.nextFloat()) * 0.7f + 1.0f) * 2.0f);
        this.makeBlackMagicTrail(this.u, this.v + this.e(), this.w, minionSpot.c, minionSpot.d + minion.P / 2.0, minionSpot.e);
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
        final List nearbyLiches = this.q.a((Class)EntityTFLich.class, aqr.a().a(this.u, this.v, this.w, this.u + 1.0, this.v + 1.0, this.w + 1.0).b(32.0, 16.0, 32.0));
        for (final EntityTFLich nearbyLich : nearbyLiches) {
            if (!nearbyLich.isShadowClone() && nearbyLich.wantsNewClone(this)) {
                this.masterLich = nearbyLich;
                this.makeTeleportTrail(this.u, this.v, this.w, nearbyLich.u, nearbyLich.v, nearbyLich.w);
                this.b(this.masterLich.aJ());
                break;
            }
        }
    }
    
    protected void teleportToSightOfEntity(final mp entity) {
        final aqw dest = this.findVecInLOSOf(entity);
        final double srcX = this.u;
        final double srcY = this.v;
        final double srcZ = this.w;
        if (dest != null) {
            this.teleportToNoChecks(dest.c, dest.d, dest.e);
            this.a(entity, 100.0f, 100.0f);
            this.ay = this.A;
            if (!this.n(entity)) {
                this.teleportToNoChecks(srcX, srcY, srcZ);
            }
        }
    }
    
    protected aqw findVecInLOSOf(final mp targetEntity) {
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
            final int bx = kx.c(tx);
            int by = kx.c(ty);
            final int bz = kx.c(tz);
            while (!groundFlag && ty > 0.0) {
                final int whatsThere = this.q.a(bx, by - 1, bz);
                if (whatsThere == 0 || !aou.r[whatsThere].cO.a()) {
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
                    final aqr destBox = aqr.a(tx - halfWidth, ty - this.N + this.X, tz - halfWidth, tx + halfWidth, ty - this.N + this.X + this.P, tz + halfWidth);
                    if (this.q.a((mp)this, destBox).size() <= 0) {
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
        return this.q.T().a(tx, ty, tz);
    }
    
    protected boolean canEntitySee(final mp entity, final double dx, final double dy, final double dz) {
        return this.q.a(this.q.T().a(entity.u, entity.v + entity.e(), entity.w), this.q.T().a(dx, dy, dz)) == null;
    }
    
    protected boolean teleportToNoChecks(final double destX, final double destY, final double destZ) {
        final double srcX = this.u;
        final double srcY = this.v;
        final double srcZ = this.w;
        this.b(destX, destY, destZ);
        this.makeTeleportTrail(srcX, srcY, srcZ, destX, destY, destZ);
        this.q.a(srcX, srcY, srcZ, "mob.endermen.portal", 1.0f, 1.0f);
        this.q.a((mp)this, "mob.endermen.portal", 1.0f, 1.0f);
        this.bG = false;
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
        return (this.ah.a(16) & 0x2) != 0x0;
    }
    
    public void setShadowClone(final boolean par1) {
        final byte var2 = this.ah.a(16);
        if (par1) {
            this.ah.b(16, (Object)(byte)(var2 | 0x2));
        }
        else {
            this.ah.b(16, (Object)(byte)(var2 & 0xFFFFFFFD));
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
    
    protected String bb() {
        return "mob.blaze.breathe";
    }
    
    protected String bc() {
        return "mob.blaze.hit";
    }
    
    protected String bd() {
        return "mob.blaze.death";
    }
    
    public void b(final bs nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.a("ShadowClone", this.isShadowClone());
        nbttagcompound.a("ShieldStrength", this.getShieldStrength());
        nbttagcompound.a("MinionsToSummon", this.getMinionsToSummon());
    }
    
    public void a(final bs nbttagcompound) {
        super.a(nbttagcompound);
        this.setShadowClone(nbttagcompound.n("ShadowClone"));
        this.setShieldStrength(nbttagcompound.c("ShieldStrength"));
        this.setMinionsToSummon(nbttagcompound.c("MinionsToSummon"));
    }
    
    public void a(final mg par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof sk) {
            ((sk)par1DamageSource.h()).a((ka)TFAchievementPage.twilightHunter);
            ((sk)par1DamageSource.h()).a((ka)TFAchievementPage.twilightLich);
        }
    }
    
    public int b() {
        return this.ah.c(19);
    }
    
    public int c(final mp par1Entity) {
        return 6;
    }
    
    public ni bF() {
        return ni.b;
    }
    
    static {
        heldItems = new wg[] { new wg(TFItems.scepterTwilight, 1), new wg(TFItems.scepterZombie, 1), new wg(we.H, 1) };
    }
}
