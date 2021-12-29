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

public class EntityTFHydra extends md implements pl, pm
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
    public lq[] partArray;
    public pn body;
    public HydraHeadContainer[] hc;
    public int numHeads;
    public pn leftLeg;
    public pn rightLeg;
    public pn tail;
    lq currentTarget;
    public int ticksSinceDamaged;
    
    public EntityTFHydra(final yc world) {
        super(world);
        this.numHeads = 7;
        this.currentTarget = null;
        this.ticksSinceDamaged = 0;
        this.partArray = new lq[] { (lq)(this.body = new pn((pm)this, "body", 4.0f, 4.0f)), (lq)(this.leftLeg = new pn((pm)this, "leg", 2.0f, 3.0f)), (lq)(this.rightLeg = new pn((pm)this, "leg", 2.0f, 3.0f)), (lq)(this.tail = new pn((pm)this, "tail", 4.0f, 4.0f)) };
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
        this.al = true;
        this.aG = "/twilightforest/hydra4.png";
        this.af = true;
        this.bd = 511;
        this.setSpawnHeads(true);
    }
    
    public EntityTFHydra(final yc world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    public int aT() {
        return EntityTFHydra.MAX_HEALTH;
    }
    
    public void c() {
        if ((this.hc[0].headEntity == null || this.hc[1].headEntity == null || this.hc[2].headEntity == null) && this.shouldSpawnHeads() && !this.p.I) {
            for (int i = 0; i < this.numHeads; ++i) {
                (this.hc[i].headEntity = new EntityTFHydraHead(this, "head" + i, 3.0f, 3.0f)).b(this.t, this.u, this.v);
                this.p.d((lq)this.hc[i].headEntity);
            }
            this.setSpawnHeads(false);
        }
        this.body.j_();
        for (int i = 0; i < this.numHeads; ++i) {
            this.hc[i].onUpdate();
        }
        if (!this.p.I) {
            this.ag.b(18, (Object)this.aR);
        }
        else {
            if (this.b() != this.aR) {
                this.j(this.b());
            }
            if (this.aR > 0) {
                this.aY = 0;
            }
        }
        if (this.aV > 0) {
            for (int i = 0; i < this.numHeads; ++i) {
                this.hc[i].setHurtTime(this.aV);
            }
        }
        ++this.ticksSinceDamaged;
        if (!this.p.I && this.ticksSinceDamaged > EntityTFHydra.TICKS_BEFORE_HEALING && this.ticksSinceDamaged % 5 == 0) {
            this.i(1);
        }
        this.setDifficultyVariables();
        if (this.bt > 0) {
            final double var1 = this.t + (this.bu - this.t) / this.bt;
            final double var2 = this.u + (this.bv - this.u) / this.bt;
            final double var3 = this.v + (this.bw - this.v) / this.bt;
            final double var4 = ke.g(this.bx - this.z);
            this.z += (float)(var4 / this.bt);
            this.A += (float)((this.by - this.A) / this.bt);
            --this.bt;
            this.b(var1, var2, var3);
            this.b(this.z, this.A);
        }
        if (Math.abs(this.w) < 0.005) {
            this.w = 0.0;
        }
        if (Math.abs(this.x) < 0.005) {
            this.x = 0.0;
        }
        if (Math.abs(this.y) < 0.005) {
            this.y = 0.0;
        }
        this.p.D.a("ai");
        if (this.bg()) {
            this.bF = false;
            this.bC = 0.0f;
            this.bD = 0.0f;
            this.bE = 0.0f;
        }
        else if (this.bf()) {
            this.p.D.a("oldAi");
            this.bn();
            this.p.D.b();
            this.az = this.z;
        }
        this.p.D.b();
        this.p.D.a("jump");
        if (this.bF) {
            if (!this.H() && !this.J()) {
                if (this.E) {
                    this.bi();
                }
            }
            else {
                this.x += 0.03999999910593033;
            }
        }
        this.p.D.b();
        this.p.D.a("travel");
        this.bC *= 0.98f;
        this.bD *= 0.98f;
        this.bE *= 0.9f;
        final float var5 = this.aN;
        this.aN *= this.bB();
        this.e(this.bC, this.bD);
        this.aN = var5;
        this.p.D.b();
        final pn body = this.body;
        final pn body2 = this.body;
        final float n = 6.0f;
        body2.O = n;
        body.N = n;
        this.tail.N = 6.0f;
        this.tail.O = 2.0f;
        final float angle = (this.ax + 180.0f) * 3.141593f / 180.0f;
        double dx = this.t - ke.a(angle) * 3.0;
        double dy = this.u + 0.1;
        double dz = this.v + ke.b(angle) * 3.0;
        this.body.b(dx, dy, dz);
        dx = this.t - ke.a(angle) * 10.5;
        dy = this.u + 0.1;
        dz = this.v + ke.b(angle) * 10.5;
        this.tail.b(dx, dy, dz);
        this.p.D.a("push");
        if (!this.p.I && this.aV == 0) {
            this.collideWithEntities(this.p.b((lq)this, this.body.D), (lq)this.body);
            this.collideWithEntities(this.p.b((lq)this, this.tail.D), (lq)this.tail);
        }
        this.p.D.b();
        if (!this.p.I) {
            this.destroyBlocksInAABB(this.body.D);
            this.destroyBlocksInAABB(this.tail.D);
            for (int j = 0; j < this.numHeads; ++j) {
                if (this.hc[j].headEntity != null && this.hc[j].isActive()) {
                    this.destroyBlocksInAABB(this.hc[j].headEntity.D);
                }
            }
            if (this.ab % 20 == 0 && this.isUnsteadySurfaceBeneath()) {
                this.destroyBlocksInAABB(this.D.d(0.0, -1.0, 0.0));
            }
        }
    }
    
    protected void a() {
        super.a();
        this.ag.a(17, (Object)0);
        this.ag.a(18, (Object)new Integer(EntityTFHydra.MAX_HEALTH));
    }
    
    public boolean shouldSpawnHeads() {
        return this.ag.a(17) != 0;
    }
    
    public void setSpawnHeads(final boolean flag) {
        if (flag) {
            this.ag.b(17, (Object)127);
        }
        else {
            this.ag.b(17, (Object)0);
        }
    }
    
    public void b(final bq nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.a("SpawnHeads", this.shouldSpawnHeads());
        nbttagcompound.a("NumHeads", (byte)this.countActiveHeads());
    }
    
    public void a(final bq nbttagcompound) {
        super.a(nbttagcompound);
        this.setSpawnHeads(nbttagcompound.n("SpawnHeads"));
        this.activateNumberOfHeads(nbttagcompound.c("NumHeads"));
    }
    
    protected void bn() {
        ++this.bB;
        final qx entityplayer = this.p.a((lq)this, -1.0);
        this.bk();
        this.bC = 0.0f;
        this.bD = 0.0f;
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
        if (this.aa.nextFloat() < 0.7f) {
            final qx entityplayer2 = this.p.a((lq)this, (double)f);
            if (entityplayer2 != null) {
                this.currentTarget = (lq)entityplayer2;
                this.bI = 100 + this.aa.nextInt(20);
            }
            else {
                this.bE = (this.aa.nextFloat() - 0.5f) * 20.0f;
            }
        }
        if (this.currentTarget != null) {
            this.a(this.currentTarget, 10.0f, (float)this.bp());
            for (int i = 0; i < this.numHeads; ++i) {
                if (!this.isHeadAttacking(this.hc[i]) && !this.hc[i].isSecondaryAttacking) {
                    this.hc[i].setTargetEntity(this.currentTarget);
                }
            }
            if (this.currentTarget.S()) {
                final float distance = this.currentTarget.d((lq)this);
                if (this.n(this.currentTarget)) {
                    this.attackEntity(this.currentTarget, distance);
                }
            }
            if (this.bI-- <= 0 || this.currentTarget.L || this.currentTarget.e((lq)this) > f * f) {
                this.currentTarget = null;
            }
        }
        else {
            if (this.aa.nextFloat() < 0.05f) {
                this.bE = (this.aa.nextFloat() - 0.5f) * 20.0f;
            }
            this.z += this.bE;
            this.A = this.bG;
            for (int i = 0; i < this.numHeads; ++i) {
                if (this.hc[i].currentState == 0) {
                    this.hc[i].setTargetEntity(null);
                }
            }
        }
        this.secondaryAttacks();
        final boolean flag = this.H();
        final boolean flag2 = this.J();
        if (flag || flag2) {
            this.bF = (this.aa.nextFloat() < 0.8f);
        }
    }
    
    private void setDifficultyVariables() {
        if (this.p.s < 3) {
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
    
    private void attackEntity(final lq target, final float distance) {
        final int BITE_CHANCE = 10;
        final int FLAME_CHANCE = 100;
        final int MORTAR_CHANCE = 160;
        final boolean targetAbove = target.D.b > this.D.e;
        for (int i = 0; i < 3; ++i) {
            if (this.hc[i].currentState == 0 && !this.areTooManyHeadsAttacking(target, i)) {
                if (distance > 4.0f && distance < 10.0f && this.aa.nextInt(BITE_CHANCE) == 0 && this.countActiveHeads() > 2 && !this.areOtherHeadsBiting(target, i)) {
                    this.hc[i].setNextState(1);
                }
                else if (distance > 0.0f && distance < 20.0f && this.aa.nextInt(FLAME_CHANCE) == 0) {
                    this.hc[i].setNextState(5);
                }
                else if (distance > 8.0f && distance < 32.0f && !targetAbove && this.aa.nextInt(MORTAR_CHANCE) == 0) {
                    this.hc[i].setNextState(8);
                }
            }
        }
        for (int i = 3; i < this.numHeads; ++i) {
            if (this.hc[i].currentState == 0 && !this.areTooManyHeadsAttacking(target, i)) {
                if (distance > 0.0f && distance < 20.0f && this.aa.nextInt(FLAME_CHANCE) == 0) {
                    this.hc[i].setNextState(5);
                }
                else if (distance > 8.0f && distance < 32.0f && !targetAbove && this.aa.nextInt(MORTAR_CHANCE) == 0) {
                    this.hc[i].setNextState(8);
                }
            }
        }
    }
    
    protected boolean areTooManyHeadsAttacking(final lq target, final int testHead) {
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
    
    protected boolean areOtherHeadsBiting(final lq target, final int testHead) {
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
        final md secondaryTarget = this.findSecondaryTarget(20.0);
        if (secondaryTarget != null) {
            final float distance = secondaryTarget.d((lq)this);
            for (int j = 1; j < this.numHeads; ++j) {
                if (this.hc[j].isActive() && this.hc[j].currentState == 0 && this.isTargetOnThisSide(j, (lq)secondaryTarget)) {
                    if (distance > 0.0f && distance < 20.0f && this.aa.nextInt(EntityTFHydra.SECONDARY_FLAME_CHANCE) == 0) {
                        this.hc[j].setTargetEntity((lq)secondaryTarget);
                        this.hc[j].isSecondaryAttacking = true;
                        this.hc[j].setNextState(5);
                    }
                    else if (distance > 8.0f && distance < 32.0f && this.aa.nextInt(EntityTFHydra.SECONDARY_MORTAR_CHANCE) == 0) {
                        this.hc[j].setTargetEntity((lq)secondaryTarget);
                        this.hc[j].isSecondaryAttacking = true;
                        this.hc[j].setNextState(8);
                    }
                }
            }
        }
    }
    
    public boolean isTargetOnThisSide(final int headNum, final lq target) {
        final double headDist = this.distanceSqXZ((lq)this.hc[headNum].headEntity, target);
        final double middleDist = this.distanceSqXZ((lq)this, target);
        return headDist < middleDist;
    }
    
    private double distanceSqXZ(final lq headEntity, final lq target) {
        final double distX = headEntity.t - target.t;
        final double distZ = headEntity.v - target.v;
        return distX * distX + distZ * distZ;
    }
    
    public md findSecondaryTarget(final double range) {
        double closestRange = -1.0;
        md closestEntity = null;
        final List nearbyEntities = this.p.a((Class)md.class, aoe.a().a(this.t, this.u, this.v, this.t + 1.0, this.u + 1.0, this.v + 1.0).b(range, range, range));
        for (final md nearbyLiving : nearbyEntities) {
            if (!(nearbyLiving instanceof EntityTFHydra)) {
                if (nearbyLiving instanceof EntityTFHydraPart) {
                    continue;
                }
                if (nearbyLiving == this.currentTarget) {
                    continue;
                }
                if (this.isAnyHeadTargeting((lq)nearbyLiving)) {
                    continue;
                }
                if (!this.n((lq)nearbyLiving)) {
                    continue;
                }
                final double curDist = nearbyLiving.e(this.t, this.u, this.v);
                if ((range >= 0.0 && curDist >= range * range) || (closestRange != -1.0 && curDist >= closestRange)) {
                    continue;
                }
                closestRange = curDist;
                closestEntity = nearbyLiving;
            }
        }
        return closestEntity;
    }
    
    boolean isAnyHeadTargeting(final lq targetEntity) {
        for (int i = 0; i < this.numHeads; ++i) {
            if (this.hc[i].targetEntity != null && this.hc[i].targetEntity.equals((Object)targetEntity)) {
                return true;
            }
        }
        return false;
    }
    
    private void collideWithEntities(final List par1List, final lq part) {
        final double pushPower = 4.0;
        final double centerX = (part.D.a + part.D.d) / 2.0;
        final double centerY = (part.D.c + part.D.f) / 2.0;
        for (final lq entity : par1List) {
            if (entity instanceof md) {
                final double distX = entity.t - centerX;
                final double distZ = entity.v - centerY;
                final double sqDist = distX * distX + distZ * distZ;
                entity.g(distX / sqDist * pushPower, 0.20000000298023224, distZ / sqDist * pushPower);
            }
        }
    }
    
    private boolean isUnsteadySurfaceBeneath() {
        final int minX = ke.c(this.D.a);
        final int minZ = ke.c(this.D.c);
        final int maxX = ke.c(this.D.d);
        final int maxZ = ke.c(this.D.f);
        final int minY = ke.c(this.D.b);
        int solid = 0;
        int total = 0;
        final int dy = minY - 1;
        for (int dx = minX; dx <= maxX; ++dx) {
            for (int dz = minZ; dz <= maxZ; ++dz) {
                ++total;
                if (this.p.g(dx, dy, dz).a()) {
                    ++solid;
                }
            }
        }
        return solid / (float)total < 0.6f;
    }
    
    private boolean destroyBlocksInAABB(final aoe par1AxisAlignedBB) {
        final int minX = ke.c(par1AxisAlignedBB.a);
        final int minY = ke.c(par1AxisAlignedBB.b);
        final int minZ = ke.c(par1AxisAlignedBB.c);
        final int maxX = ke.c(par1AxisAlignedBB.d);
        final int maxY = ke.c(par1AxisAlignedBB.e);
        final int maxZ = ke.c(par1AxisAlignedBB.f);
        boolean wasBlocked = false;
        boolean didDestroy = false;
        for (int dx = minX; dx <= maxX; ++dx) {
            for (int dy = minY; dy <= maxY; ++dy) {
                for (int dz = minZ; dz <= maxZ; ++dz) {
                    final int currentID = this.p.a(dx, dy, dz);
                    if (currentID != 0) {
                        final int currentMeta = this.p.h(dx, dy, dz);
                        if (currentID != amq.as.cm && currentID != amq.bM.cm && currentID != amq.C.cm) {
                            didDestroy = true;
                            this.p.e(dx, dy, dz, 0);
                            this.p.f(2001, dx, dy, dz, currentID + (currentMeta << 12));
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
    
    public int bp() {
        return 500;
    }
    
    public boolean a(final pn dragonpart, final lh damagesource, final int i) {
        final double range = this.calculateRange(damagesource);
        return range <= 400.0 && this.superAttackFrom(damagesource, Math.round(i / 8.0f));
    }
    
    protected boolean superAttackFrom(final lh par1DamageSource, final int par2) {
        return super.a(par1DamageSource, par2);
    }
    
    public boolean attackEntityFromPart(final EntityTFHydraPart part, final lh damagesource, final int damageAmount) {
        if (!this.p.I && damagesource == lh.d && part.E() != null) {
            this.destroyBlocksInAABB(part.E());
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
    
    protected double calculateRange(final lh damagesource) {
        double range = -1.0;
        if (damagesource.f() != null) {
            range = this.e(damagesource.f());
        }
        if (damagesource.g() != null) {
            range = this.e(damagesource.g());
        }
        return range;
    }
    
    public boolean a(final lh par1DamageSource, final int par2) {
        return false;
    }
    
    public lq[] ao() {
        return this.partArray;
    }
    
    public boolean L() {
        return false;
    }
    
    public boolean M() {
        return false;
    }
    
    public void a(final lq entity, final int i, final double d, final double d1) {
    }
    
    protected String aY() {
        return "mob.tf.hydra.growl";
    }
    
    protected String aZ() {
        return "mob.tf.hydra.hurt";
    }
    
    protected String ba() {
        return "mob.tf.hydra.death";
    }
    
    protected float aX() {
        return 2.0f;
    }
    
    public void a(final lh par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.f() instanceof qx) {
            ((qx)par1DamageSource.f()).a((jl)TFAchievementPage.twilightHunter);
        }
    }
    
    protected void a(final boolean par1, final int par2) {
        for (int totalDrops = this.aa.nextInt(3 + par2) + 5, i = 0; i < totalDrops; ++i) {
            this.b(TFItems.hydraChop.cj, 5);
        }
        for (int totalDrops = this.aa.nextInt(4 + par2) + 7, i = 0; i < totalDrops; ++i) {
            this.b(TFItems.fieryBlood.cj, 1);
        }
        this.b(TFItems.hydraTrophy.cj, 1);
    }
    
    protected boolean bj() {
        return false;
    }
    
    public boolean af() {
        return false;
    }
    
    protected void aP() {
        ++this.aY;
        if (this.aY == 1) {
            for (int i = 0; i < this.numHeads; ++i) {
                this.hc[i].setRespawnCounter(-1);
                if (this.hc[i].isActive()) {
                    this.hc[i].setNextState(0);
                    this.hc[i].endCurrentAction();
                    this.hc[i].setHurtTime(200);
                }
            }
        }
        if (this.aY <= 140 && this.aY % 20 == 0) {
            final int headToDie = this.aY / 20 - 1;
            if (this.hc[headToDie].isActive()) {
                this.hc[headToDie].setNextState(11);
                this.hc[headToDie].endCurrentAction();
            }
        }
        if (this.aY == 200) {
            if (!this.p.I && (this.bk > 0 || this.aQ()) && !this.h_()) {
                int var1 = this.c(this.bj);
                while (var1 > 0) {
                    final int var2 = lz.a(var1);
                    var1 -= var2;
                    this.p.d((lq)new lz(this.p, this.t, this.u, this.v, var2));
                }
            }
            this.x();
        }
        for (int var1 = 0; var1 < 20; ++var1) {
            final double var3 = this.aa.nextGaussian() * 0.02;
            final double var4 = this.aa.nextGaussian() * 0.02;
            final double var5 = this.aa.nextGaussian() * 0.02;
            final String particle = (this.aa.nextInt(2) == 0) ? "largeexplode" : "explode";
            this.p.a(particle, this.t + this.aa.nextFloat() * this.body.N * 2.0f - this.body.N, this.u + this.aa.nextFloat() * this.body.O, this.v + this.aa.nextFloat() * this.body.N * 2.0f - this.body.N, var3, var4, var5);
        }
    }
    
    public yc d() {
        return this.p;
    }
    
    public int b() {
        return this.ag.c(18);
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
