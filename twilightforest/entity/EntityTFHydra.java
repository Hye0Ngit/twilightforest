// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.item.TFItems;
import twilightforest.TFAchievementPage;
import java.util.Iterator;
import java.util.List;
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;

public class EntityTFHydra extends ng implements qp, qq, rq
{
    private static int TICKS_BEFORE_HEALING;
    private static int HEAD_RESPAWN_TICKS;
    private static int HEAD_MAX_DAMAGE;
    private static float ARMOR_MULTIPLIER;
    private static int MAX_HEALTH;
    private static float HEADS_ACTIVITY_FACTOR;
    private static int SECONDARY_FLAME_CHANCE;
    private static int SECONDARY_MORTAR_CHANCE;
    private static final int DATA_SPAWNHEADS = 17;
    private static final int DATA_BOSSHEALTH = 18;
    public mp[] partArray;
    public qr body;
    public HydraHeadContainer[] hc;
    public int numHeads;
    public qr leftLeg;
    public qr rightLeg;
    public qr tail;
    mp currentTarget;
    public int ticksSinceDamaged;
    
    public EntityTFHydra(final zv world) {
        super(world);
        this.numHeads = 7;
        this.currentTarget = null;
        this.ticksSinceDamaged = 0;
        this.partArray = new mp[] { (mp)(this.body = new qr((qq)this, "body", 4.0f, 4.0f)), (mp)(this.leftLeg = new qr((qq)this, "leg", 2.0f, 3.0f)), (mp)(this.rightLeg = new qr((qq)this, "leg", 2.0f, 3.0f)), (mp)(this.tail = new qr((qq)this, "tail", 4.0f, 4.0f)) };
        this.hc = new HydraHeadContainer[this.numHeads];
        for (int i = 0; i < this.numHeads; ++i) {
            this.hc[i] = new HydraHeadContainer(this, i, i < 3);
        }
        final ArrayList partList = new ArrayList();
        Collections.addAll(partList, this.partArray);
        for (int j = 0; j < this.numHeads; ++j) {
            Collections.addAll(partList, this.hc[j].getNeckArray());
        }
        this.partArray = partList.toArray(this.partArray);
        this.a(16.0f, 12.0f);
        this.am = true;
        this.aH = "/mods/twilightforest/textures/model/hydra4.png";
        this.ag = true;
        this.be = 511;
        this.setSpawnHeads(true);
    }
    
    public EntityTFHydra(final zv world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    public int aW() {
        return EntityTFHydra.MAX_HEALTH;
    }
    
    public void c() {
        if ((this.hc[0].headEntity == null || this.hc[1].headEntity == null || this.hc[2].headEntity == null) && this.shouldSpawnHeads() && !this.q.I) {
            for (int i = 0; i < this.numHeads; ++i) {
                (this.hc[i].headEntity = new EntityTFHydraHead(this, "head" + i, 3.0f, 3.0f)).b(this.u, this.v, this.w);
                this.q.d((mp)this.hc[i].headEntity);
            }
            this.setSpawnHeads(false);
        }
        this.body.l_();
        for (int i = 0; i < this.numHeads; ++i) {
            this.hc[i].onUpdate();
        }
        if (!this.q.I) {
            this.ah.b(18, (Object)this.aS);
        }
        else {
            if (this.b() != this.aS) {
                this.b(this.b());
            }
            if (this.aS > 0) {
                this.aZ = 0;
            }
        }
        if (this.aW > 0) {
            for (int i = 0; i < this.numHeads; ++i) {
                this.hc[i].setHurtTime(this.aW);
            }
        }
        ++this.ticksSinceDamaged;
        if (!this.q.I && this.ticksSinceDamaged > EntityTFHydra.TICKS_BEFORE_HEALING && this.ticksSinceDamaged % 5 == 0) {
            this.j(1);
        }
        this.setDifficultyVariables();
        if (this.bu > 0) {
            final double var1 = this.u + (this.bv - this.u) / this.bu;
            final double var2 = this.v + (this.bw - this.v) / this.bu;
            final double var3 = this.w + (this.bx - this.w) / this.bu;
            final double var4 = kx.g(this.by - this.A);
            this.A += (float)(var4 / this.bu);
            this.B += (float)((this.bz - this.B) / this.bu);
            --this.bu;
            this.b(var1, var2, var3);
            this.b(this.A, this.B);
        }
        if (Math.abs(this.x) < 0.005) {
            this.x = 0.0;
        }
        if (Math.abs(this.y) < 0.005) {
            this.y = 0.0;
        }
        if (Math.abs(this.z) < 0.005) {
            this.z = 0.0;
        }
        this.q.C.a("ai");
        if (this.bj()) {
            this.bG = false;
            this.bD = 0.0f;
            this.bE = 0.0f;
            this.bF = 0.0f;
        }
        else if (this.bi()) {
            this.q.C.a("oldAi");
            this.bq();
            this.q.C.b();
            this.aA = this.A;
        }
        this.q.C.b();
        this.q.C.a("jump");
        if (this.bG) {
            if (!this.G() && !this.I()) {
                if (this.F) {
                    this.bl();
                }
            }
            else {
                this.y += 0.03999999910593033;
            }
        }
        this.q.C.b();
        this.q.C.a("travel");
        this.bD *= 0.98f;
        this.bE *= 0.98f;
        this.bF *= 0.9f;
        final float var5 = this.aO;
        this.aO *= this.bE();
        this.e(this.bD, this.bE);
        this.aO = var5;
        this.q.C.b();
        final qr body = this.body;
        final qr body2 = this.body;
        final float n = 6.0f;
        body2.P = n;
        body.O = n;
        this.tail.O = 6.0f;
        this.tail.P = 2.0f;
        final float angle = (this.ay + 180.0f) * 3.141593f / 180.0f;
        double dx = this.u - kx.a(angle) * 3.0;
        double dy = this.v + 0.1;
        double dz = this.w + kx.b(angle) * 3.0;
        this.body.b(dx, dy, dz);
        dx = this.u - kx.a(angle) * 10.5;
        dy = this.v + 0.1;
        dz = this.w + kx.b(angle) * 10.5;
        this.tail.b(dx, dy, dz);
        this.q.C.a("push");
        if (!this.q.I && this.aW == 0) {
            this.collideWithEntities(this.q.b((mp)this, this.body.E), (mp)this.body);
            this.collideWithEntities(this.q.b((mp)this, this.tail.E), (mp)this.tail);
        }
        this.q.C.b();
        if (!this.q.I) {
            this.destroyBlocksInAABB(this.body.E);
            this.destroyBlocksInAABB(this.tail.E);
            for (int j = 0; j < this.numHeads; ++j) {
                if (this.hc[j].headEntity != null && this.hc[j].isActive()) {
                    this.destroyBlocksInAABB(this.hc[j].headEntity.E);
                }
            }
            if (this.ac % 20 == 0 && this.isUnsteadySurfaceBeneath()) {
                this.destroyBlocksInAABB(this.E.d(0.0, -1.0, 0.0));
            }
        }
    }
    
    protected void a() {
        super.a();
        this.ah.a(17, (Object)0);
        this.ah.a(18, (Object)new Integer(EntityTFHydra.MAX_HEALTH));
    }
    
    public boolean shouldSpawnHeads() {
        return this.ah.a(17) != 0;
    }
    
    public void setSpawnHeads(final boolean flag) {
        if (flag) {
            this.ah.b(17, (Object)127);
        }
        else {
            this.ah.b(17, (Object)0);
        }
    }
    
    public void b(final bs nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.a("SpawnHeads", this.shouldSpawnHeads());
        nbttagcompound.a("NumHeads", (byte)this.countActiveHeads());
    }
    
    public void a(final bs nbttagcompound) {
        super.a(nbttagcompound);
        this.setSpawnHeads(nbttagcompound.n("SpawnHeads"));
        this.activateNumberOfHeads(nbttagcompound.c("NumHeads"));
    }
    
    protected void bq() {
        ++this.bC;
        final sk entityplayer = this.q.a((mp)this, -1.0);
        this.bn();
        this.bD = 0.0f;
        this.bE = 0.0f;
        final float f = 48.0f;
        for (int i = 0; i < this.numHeads; ++i) {
            if (this.hc[i].isActive() && this.hc[i].getDamageTaken() > EntityTFHydra.HEAD_MAX_DAMAGE) {
                this.hc[i].setNextState(11);
                this.hc[i].endCurrentAction();
                this.hc[i].setRespawnCounter(EntityTFHydra.HEAD_RESPAWN_TICKS);
                final int otherHead = this.getRandomDeadHead();
                if (otherHead != -1) {
                    this.hc[otherHead].setRespawnCounter(EntityTFHydra.HEAD_RESPAWN_TICKS);
                }
            }
        }
        if (this.ab.nextFloat() < 0.7f) {
            final sk entityplayer2 = this.q.a((mp)this, (double)f);
            if (entityplayer2 != null) {
                this.currentTarget = (mp)entityplayer2;
                this.bJ = 100 + this.ab.nextInt(20);
            }
            else {
                this.bF = (this.ab.nextFloat() - 0.5f) * 20.0f;
            }
        }
        if (this.currentTarget != null) {
            this.a(this.currentTarget, 10.0f, (float)this.bs());
            for (int i = 0; i < this.numHeads; ++i) {
                if (!this.isHeadAttacking(this.hc[i]) && !this.hc[i].isSecondaryAttacking) {
                    this.hc[i].setTargetEntity(this.currentTarget);
                }
            }
            if (this.currentTarget.R()) {
                final float distance = this.currentTarget.d((mp)this);
                if (this.n(this.currentTarget)) {
                    this.attackEntity(this.currentTarget, distance);
                }
            }
            if (this.bJ-- <= 0 || this.currentTarget.M || this.currentTarget.e((mp)this) > f * f) {
                this.currentTarget = null;
            }
        }
        else {
            if (this.ab.nextFloat() < 0.05f) {
                this.bF = (this.ab.nextFloat() - 0.5f) * 20.0f;
            }
            this.A += this.bF;
            this.B = this.bH;
            for (int i = 0; i < this.numHeads; ++i) {
                if (this.hc[i].currentState == 0) {
                    this.hc[i].setTargetEntity(null);
                }
            }
        }
        this.secondaryAttacks();
        final boolean flag = this.G();
        final boolean flag2 = this.I();
        if (flag || flag2) {
            this.bG = (this.ab.nextFloat() < 0.8f);
        }
    }
    
    private void setDifficultyVariables() {
        if (this.q.r < 3) {
            EntityTFHydra.HEADS_ACTIVITY_FACTOR = 0.3f;
        }
        else {
            EntityTFHydra.HEADS_ACTIVITY_FACTOR = 0.5f;
        }
    }
    
    private int getRandomDeadHead() {
        for (int i = 0; i < this.numHeads; ++i) {
            if (this.hc[i].currentState == 12 && this.hc[i].respawnCounter == -1) {
                return i;
            }
        }
        return -1;
    }
    
    private void activateNumberOfHeads(final int howMany) {
        for (int moreHeads = howMany - this.countActiveHeads(), i = 0; i < moreHeads; ++i) {
            final int otherHead = this.getRandomDeadHead();
            if (otherHead != -1) {
                this.hc[otherHead].currentState = 0;
                this.hc[otherHead].setNextState(0);
                this.hc[otherHead].endCurrentAction();
            }
        }
    }
    
    private void attackEntity(final mp target, final float distance) {
        final int BITE_CHANCE = 10;
        final int FLAME_CHANCE = 100;
        final int MORTAR_CHANCE = 160;
        final boolean targetAbove = target.E.b > this.E.e;
        for (int i = 0; i < 3; ++i) {
            if (this.hc[i].currentState == 0 && !this.areTooManyHeadsAttacking(target, i)) {
                if (distance > 4.0f && distance < 10.0f && this.ab.nextInt(BITE_CHANCE) == 0 && this.countActiveHeads() > 2 && !this.areOtherHeadsBiting(target, i)) {
                    this.hc[i].setNextState(1);
                }
                else if (distance > 0.0f && distance < 20.0f && this.ab.nextInt(FLAME_CHANCE) == 0) {
                    this.hc[i].setNextState(5);
                }
                else if (distance > 8.0f && distance < 32.0f && !targetAbove && this.ab.nextInt(MORTAR_CHANCE) == 0) {
                    this.hc[i].setNextState(8);
                }
            }
        }
        for (int i = 3; i < this.numHeads; ++i) {
            if (this.hc[i].currentState == 0 && !this.areTooManyHeadsAttacking(target, i)) {
                if (distance > 0.0f && distance < 20.0f && this.ab.nextInt(FLAME_CHANCE) == 0) {
                    this.hc[i].setNextState(5);
                }
                else if (distance > 8.0f && distance < 32.0f && !targetAbove && this.ab.nextInt(MORTAR_CHANCE) == 0) {
                    this.hc[i].setNextState(8);
                }
            }
        }
    }
    
    protected boolean areTooManyHeadsAttacking(final mp target, final int testHead) {
        int otherAttacks = 0;
        for (int i = 0; i < this.numHeads; ++i) {
            if (i != testHead && this.isHeadAttacking(this.hc[i])) {
                ++otherAttacks;
                if (this.isHeadBiting(this.hc[i])) {
                    otherAttacks += 2;
                }
            }
        }
        return otherAttacks >= 1.0f + this.countActiveHeads() * EntityTFHydra.HEADS_ACTIVITY_FACTOR;
    }
    
    public int countActiveHeads() {
        int count = 0;
        for (int i = 0; i < this.numHeads; ++i) {
            if (this.hc[i].isActive()) {
                ++count;
            }
        }
        return count;
    }
    
    private boolean isHeadAttacking(final HydraHeadContainer head) {
        return head.currentState == 1 || head.currentState == 2 || head.currentState == 3 || head.currentState == 5 || head.currentState == 6 || head.currentState == 8 || head.currentState == 9;
    }
    
    protected boolean areOtherHeadsBiting(final mp target, final int testHead) {
        for (int i = 0; i < this.numHeads; ++i) {
            if (i != testHead && this.isHeadBiting(this.hc[i])) {
                return true;
            }
        }
        return false;
    }
    
    protected boolean isHeadBiting(final HydraHeadContainer head) {
        return head.currentState == 1 || head.currentState == 2 || head.currentState == 3 || head.nextState == 1;
    }
    
    private void secondaryAttacks() {
        for (int i = 0; i < this.numHeads; ++i) {
            if (this.hc[i].headEntity == null) {
                return;
            }
        }
        final ng secondaryTarget = this.findSecondaryTarget(20.0);
        if (secondaryTarget != null) {
            final float distance = secondaryTarget.d((mp)this);
            for (int j = 1; j < this.numHeads; ++j) {
                if (this.hc[j].isActive() && this.hc[j].currentState == 0 && this.isTargetOnThisSide(j, (mp)secondaryTarget)) {
                    if (distance > 0.0f && distance < 20.0f && this.ab.nextInt(EntityTFHydra.SECONDARY_FLAME_CHANCE) == 0) {
                        this.hc[j].setTargetEntity((mp)secondaryTarget);
                        this.hc[j].isSecondaryAttacking = true;
                        this.hc[j].setNextState(5);
                    }
                    else if (distance > 8.0f && distance < 32.0f && this.ab.nextInt(EntityTFHydra.SECONDARY_MORTAR_CHANCE) == 0) {
                        this.hc[j].setTargetEntity((mp)secondaryTarget);
                        this.hc[j].isSecondaryAttacking = true;
                        this.hc[j].setNextState(8);
                    }
                }
            }
        }
    }
    
    public boolean isTargetOnThisSide(final int headNum, final mp target) {
        final double headDist = this.distanceSqXZ((mp)this.hc[headNum].headEntity, target);
        final double middleDist = this.distanceSqXZ((mp)this, target);
        return headDist < middleDist;
    }
    
    private double distanceSqXZ(final mp headEntity, final mp target) {
        final double distX = headEntity.u - target.u;
        final double distZ = headEntity.w - target.w;
        return distX * distX + distZ * distZ;
    }
    
    public ng findSecondaryTarget(final double range) {
        double closestRange = -1.0;
        ng closestEntity = null;
        final List nearbyEntities = this.q.a((Class)ng.class, aqr.a().a(this.u, this.v, this.w, this.u + 1.0, this.v + 1.0, this.w + 1.0).b(range, range, range));
        for (final ng nearbyLiving : nearbyEntities) {
            if (!(nearbyLiving instanceof EntityTFHydra)) {
                if (nearbyLiving instanceof EntityTFHydraPart) {
                    continue;
                }
                if (nearbyLiving == this.currentTarget) {
                    continue;
                }
                if (this.isAnyHeadTargeting((mp)nearbyLiving)) {
                    continue;
                }
                if (!this.n((mp)nearbyLiving)) {
                    continue;
                }
                final double curDist = nearbyLiving.e(this.u, this.v, this.w);
                if ((range >= 0.0 && curDist >= range * range) || (closestRange != -1.0 && curDist >= closestRange)) {
                    continue;
                }
                closestRange = curDist;
                closestEntity = nearbyLiving;
            }
        }
        return closestEntity;
    }
    
    boolean isAnyHeadTargeting(final mp targetEntity) {
        for (int i = 0; i < this.numHeads; ++i) {
            if (this.hc[i].targetEntity != null && this.hc[i].targetEntity.equals((Object)targetEntity)) {
                return true;
            }
        }
        return false;
    }
    
    private void collideWithEntities(final List par1List, final mp part) {
        final double pushPower = 4.0;
        final double centerX = (part.E.a + part.E.d) / 2.0;
        final double centerY = (part.E.c + part.E.f) / 2.0;
        for (final mp entity : par1List) {
            if (entity instanceof ng) {
                final double distX = entity.u - centerX;
                final double distZ = entity.w - centerY;
                final double sqDist = distX * distX + distZ * distZ;
                entity.g(distX / sqDist * pushPower, 0.20000000298023224, distZ / sqDist * pushPower);
            }
        }
    }
    
    private boolean isUnsteadySurfaceBeneath() {
        final int minX = kx.c(this.E.a);
        final int minZ = kx.c(this.E.c);
        final int maxX = kx.c(this.E.d);
        final int maxZ = kx.c(this.E.f);
        final int minY = kx.c(this.E.b);
        int solid = 0;
        int total = 0;
        final int dy = minY - 1;
        for (int dx = minX; dx <= maxX; ++dx) {
            for (int dz = minZ; dz <= maxZ; ++dz) {
                ++total;
                if (this.q.g(dx, dy, dz).a()) {
                    ++solid;
                }
            }
        }
        return solid / (float)total < 0.6f;
    }
    
    private boolean destroyBlocksInAABB(final aqr par1AxisAlignedBB) {
        final int minX = kx.c(par1AxisAlignedBB.a);
        final int minY = kx.c(par1AxisAlignedBB.b);
        final int minZ = kx.c(par1AxisAlignedBB.c);
        final int maxX = kx.c(par1AxisAlignedBB.d);
        final int maxY = kx.c(par1AxisAlignedBB.e);
        final int maxZ = kx.c(par1AxisAlignedBB.f);
        boolean wasBlocked = false;
        boolean didDestroy = false;
        for (int dx = minX; dx <= maxX; ++dx) {
            for (int dy = minY; dy <= maxY; ++dy) {
                for (int dz = minZ; dz <= maxZ; ++dz) {
                    final int currentID = this.q.a(dx, dy, dz);
                    if (currentID != 0) {
                        final int currentMeta = this.q.h(dx, dy, dz);
                        if (currentID != aou.at.cz && currentID != aou.bN.cz && currentID != aou.D.cz) {
                            didDestroy = true;
                            this.q.f(dx, dy, dz, 0, 0, 2);
                            this.q.e(2001, dx, dy, dz, currentID + (currentMeta << 12));
                        }
                        else {
                            wasBlocked = true;
                        }
                    }
                }
            }
        }
        return wasBlocked;
    }
    
    public int bs() {
        return 500;
    }
    
    public boolean a(final qr dragonpart, final mg damagesource, final int i) {
        final double range = this.calculateRange(damagesource);
        return range <= 400.0 && this.superAttackFrom(damagesource, Math.round(i / 8.0f));
    }
    
    protected boolean superAttackFrom(final mg par1DamageSource, final int par2) {
        return super.a(par1DamageSource, par2);
    }
    
    public boolean attackEntityFromPart(final EntityTFHydraPart part, final mg damagesource, final int damageAmount) {
        if (!this.q.I && damagesource == mg.d && part.D() != null) {
            this.destroyBlocksInAABB(part.D());
        }
        HydraHeadContainer headCon = null;
        for (int i = 0; i < this.numHeads; ++i) {
            if (this.hc[i].headEntity == part) {
                headCon = this.hc[i];
            }
        }
        final double range = this.calculateRange(damagesource);
        if (range > 400.0) {
            return false;
        }
        if (headCon != null && !headCon.isActive()) {
            return false;
        }
        boolean tookDamage;
        if (headCon != null && headCon.getCurrentMouthOpen() > 0.5) {
            tookDamage = this.superAttackFrom(damagesource, damageAmount);
            headCon.addDamage(damageAmount);
        }
        else {
            final int armoredDamage = Math.round(damageAmount / EntityTFHydra.ARMOR_MULTIPLIER);
            tookDamage = this.superAttackFrom(damagesource, armoredDamage);
            if (headCon != null) {
                headCon.addDamage(armoredDamage);
            }
        }
        if (tookDamage) {
            this.ticksSinceDamaged = 0;
        }
        return tookDamage;
    }
    
    protected double calculateRange(final mg damagesource) {
        double range = -1.0;
        if (damagesource.h() != null) {
            range = this.e(damagesource.h());
        }
        if (damagesource.i() != null) {
            range = this.e(damagesource.i());
        }
        return range;
    }
    
    public boolean a(final mg par1DamageSource, final int par2) {
        return false;
    }
    
    public mp[] an() {
        return this.partArray;
    }
    
    public boolean K() {
        return false;
    }
    
    public boolean L() {
        return false;
    }
    
    public void a(final mp entity, final int i, final double d, final double d1) {
    }
    
    protected String bb() {
        return "mob.tf.hydra.growl";
    }
    
    protected String bc() {
        return "mob.tf.hydra.hurt";
    }
    
    protected String bd() {
        return "mob.tf.hydra.death";
    }
    
    protected float ba() {
        return 2.0f;
    }
    
    public void a(final mg par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof sk) {
            ((sk)par1DamageSource.h()).a((ka)TFAchievementPage.twilightHunter);
        }
    }
    
    protected void a(final boolean par1, final int par2) {
        for (int totalDrops = this.ab.nextInt(3 + par2) + 5, i = 0; i < totalDrops; ++i) {
            this.b(TFItems.hydraChop.cp, 5);
        }
        for (int totalDrops = this.ab.nextInt(4 + par2) + 7, i = 0; i < totalDrops; ++i) {
            this.b(TFItems.fieryBlood.cp, 1);
        }
        this.b(TFItems.trophy.cp, 1);
    }
    
    protected boolean bm() {
        return false;
    }
    
    public boolean ae() {
        return false;
    }
    
    protected void aS() {
        ++this.aZ;
        if (this.aZ == 1) {
            for (int i = 0; i < this.numHeads; ++i) {
                this.hc[i].setRespawnCounter(-1);
                if (this.hc[i].isActive()) {
                    this.hc[i].setNextState(0);
                    this.hc[i].endCurrentAction();
                    this.hc[i].setHurtTime(200);
                }
            }
        }
        if (this.aZ <= 140 && this.aZ % 20 == 0) {
            final int headToDie = this.aZ / 20 - 1;
            if (this.hc[headToDie].isActive()) {
                this.hc[headToDie].setNextState(11);
                this.hc[headToDie].endCurrentAction();
            }
        }
        if (this.aZ == 200) {
            if (!this.q.I && (this.bl > 0 || this.aT()) && !this.h_()) {
                int var1 = this.d(this.bk);
                while (var1 > 0) {
                    final int var2 = nc.a(var1);
                    var1 -= var2;
                    this.q.d((mp)new nc(this.q, this.u, this.v, this.w, var2));
                }
            }
            this.w();
        }
        for (int var1 = 0; var1 < 20; ++var1) {
            final double var3 = this.ab.nextGaussian() * 0.02;
            final double var4 = this.ab.nextGaussian() * 0.02;
            final double var5 = this.ab.nextGaussian() * 0.02;
            final String particle = (this.ab.nextInt(2) == 0) ? "largeexplode" : "explode";
            this.q.a(particle, this.u + this.ab.nextFloat() * this.body.O * 2.0f - this.body.O, this.v + this.ab.nextFloat() * this.body.P, this.w + this.ab.nextFloat() * this.body.O * 2.0f - this.body.O, var3, var4, var5);
        }
    }
    
    public zv d() {
        return this.q;
    }
    
    public int b() {
        return this.ah.c(18);
    }
    
    static {
        EntityTFHydra.TICKS_BEFORE_HEALING = 1000;
        EntityTFHydra.HEAD_RESPAWN_TICKS = 100;
        EntityTFHydra.HEAD_MAX_DAMAGE = 120;
        EntityTFHydra.ARMOR_MULTIPLIER = 8.0f;
        EntityTFHydra.MAX_HEALTH = 360;
        EntityTFHydra.HEADS_ACTIVITY_FACTOR = 0.3f;
        EntityTFHydra.SECONDARY_FLAME_CHANCE = 10;
        EntityTFHydra.SECONDARY_MORTAR_CHANCE = 16;
    }
}
