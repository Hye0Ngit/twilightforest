// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFAchievementPage;
import twilightforest.block.TFBlocks;
import twilightforest.item.TFItems;

public class EntityTFNaga extends qj implements qe, pl
{
    private static int TICKS_BEFORE_HEALING;
    private static final int DATA_BOSSHEALTH = 16;
    private static int MAX_SEGMENTS;
    int currentSegments;
    int segmentHealth;
    int LEASH_X;
    int LEASH_Y;
    int LEASH_Z;
    EntityTFNagaSegment[] body;
    protected ahl pathToEntity;
    protected lq targetEntity;
    int circleCount;
    int intimidateTimer;
    int crumblePlayerTimer;
    int chargeCount;
    boolean clockwise;
    public int ticksSinceDamaged;
    
    public EntityTFNaga(final yc world) {
        super(world);
        this.currentSegments = 0;
        this.LEASH_X = 46;
        this.LEASH_Y = 7;
        this.LEASH_Z = 46;
        this.ticksSinceDamaged = 0;
        this.aG = "/twilightforest/nagahead.png";
        this.a(1.75f, 3.0f);
        this.bH = 0.6f;
        this.X = 2.0f;
        this.aR = this.aT();
        this.segmentHealth = this.aT() / 10;
        this.setSegmentsPerHealth();
        this.bd = 217;
        this.al = true;
        this.circleCount = 15;
    }
    
    protected void a() {
        super.a();
        this.ag.a(16, (Object)new Integer(this.aT()));
    }
    
    public int c(final lq par1Entity) {
        return 6;
    }
    
    public int aT() {
        if (this.p == null) {
            return 200;
        }
        switch (this.p.s) {
            default: {
                return 200;
            }
            case 1: {
                return 120;
            }
            case 3: {
                return 250;
            }
        }
    }
    
    protected int setSegmentsPerHealth() {
        final int oldSegments = this.currentSegments;
        int newSegments = this.aR / this.segmentHealth + ((this.aR > 0) ? 2 : 0);
        if (newSegments < 0) {
            newSegments = 0;
        }
        if (this.p != null && !this.p.I && newSegments != oldSegments) {
            if (newSegments < oldSegments) {
                for (int i = newSegments; i < oldSegments; ++i) {
                    if (this.body != null && this.body[i] != null) {
                        this.body[i].selfDestruct();
                    }
                }
            }
            else {
                this.spawnBodySegments();
            }
            this.currentSegments = newSegments;
            this.setMovementFactorPerSegments();
        }
        return this.currentSegments;
    }
    
    protected void setMovementFactorPerSegments() {
        this.aN = 0.6f - this.currentSegments / 12.0f * 0.2f;
        this.aO = this.aN / 2.0f;
        for (int i = 0; i < this.currentSegments; ++i) {
            if (this.body != null && this.body[i] != null) {
                this.body[i].aN = this.aN * 1.25f;
                this.body[i].aO = this.aO * 1.25f;
            }
        }
    }
    
    public boolean f_() {
        return false;
    }
    
    public boolean J() {
        return false;
    }
    
    public void j_() {
        this.despawnIfInvalid();
        if (this.aY > 0) {
            for (int k = 0; k < 5; ++k) {
                final double d = this.aa.nextGaussian() * 0.02;
                final double d2 = this.aa.nextGaussian() * 0.02;
                final double d3 = this.aa.nextGaussian() * 0.02;
                final String explosionType = this.aa.nextBoolean() ? "hugeexplosion" : "explode";
                this.p.a(explosionType, this.t + this.aa.nextFloat() * this.N * 2.0f - this.N, this.u + this.aa.nextFloat() * this.O, this.v + this.aa.nextFloat() * this.N * 2.0f - this.N, d, d2, d3);
            }
        }
        ++this.ticksSinceDamaged;
        if (!this.p.I && this.ticksSinceDamaged > EntityTFNaga.TICKS_BEFORE_HEALING && this.ticksSinceDamaged % 20 == 0) {
            this.i(1);
            this.setSegmentsPerHealth();
        }
        if (!this.p.I) {
            this.ag.b(16, (Object)this.aR);
        }
        super.j_();
    }
    
    protected void bn() {
        if (this.F && this.hasTarget()) {
            this.breakNearbyBlocks();
        }
        if (this.targetEntity != null && !this.isEntityWithinHomeArea(this.targetEntity)) {
            this.targetEntity = null;
        }
        if (this.targetEntity == null) {
            this.targetEntity = this.findTarget();
            if (this.targetEntity != null) {
                this.acquireNewPath();
            }
        }
        else if (!this.targetEntity.S()) {
            this.targetEntity = null;
        }
        else {
            final float targetDistance = this.targetEntity.d((lq)this);
            if (targetDistance > 80.0f) {
                this.targetEntity = null;
            }
            else if (this.n(this.targetEntity)) {
                this.a(this.targetEntity, targetDistance);
            }
        }
        if (!this.k()) {
            this.acquireNewPath();
        }
        final boolean inWater = this.H();
        final boolean inLava = this.J();
        aoj vec3d = this.k() ? this.pathToEntity.a((lq)this) : null;
        final double d = this.N * 4.0f;
        while (vec3d != null && vec3d.d(this.t, vec3d.d, this.v) < d * d) {
            this.pathToEntity.a();
            if (this.pathToEntity.b()) {
                vec3d = null;
                this.pathToEntity = null;
            }
            else {
                vec3d = this.pathToEntity.a((lq)this);
            }
        }
        this.bF = false;
        if (vec3d != null) {
            final double d2 = vec3d.c - this.t;
            final double d3 = vec3d.e - this.v;
            final double dist = ke.a(d2 * d2 + d3 * d3);
            final int i = ke.c(this.D.b + 0.5);
            final double d4 = vec3d.d - i;
            final float f2 = (float)(Math.atan2(d3, d2) * 180.0 / 3.1415927410125732) - 90.0f;
            float f3 = f2 - this.z;
            this.bD = this.bH;
            if (dist > 4.0 && this.chargeCount == 0) {
                this.bC = ke.b(this.bh * 0.3f) * this.bH * 0.6f;
            }
            while (f3 < -180.0f) {
                f3 += 360.0f;
            }
            while (f3 >= 180.0f) {
                f3 -= 360.0f;
            }
            if (f3 > 30.0f) {
                f3 = 30.0f;
            }
            if (f3 < -30.0f) {
                f3 = -30.0f;
            }
            this.z += f3;
            if (d4 > 0.0) {
                this.bF = true;
            }
        }
        if (this.intimidateTimer > 0 && this.hasTarget()) {
            this.a(this.targetEntity, 30.0f, 30.0f);
            this.bD = 0.1f;
        }
        if (this.intimidateTimer > 0 && this.hasTarget()) {
            this.a(this.targetEntity, 30.0f, 30.0f);
            this.bD = 0.1f;
        }
        if (this.aa.nextFloat() < 0.8f && (inWater || inLava)) {
            this.bF = true;
        }
        this.pullSegments();
    }
    
    protected void breakNearbyBlocks() {
        final int minx = ke.c(this.D.a - 0.5);
        final int miny = ke.c(this.D.b + 1.01);
        final int minz = ke.c(this.D.c - 0.5);
        final int maxx = ke.c(this.D.d + 0.5);
        final int maxy = ke.c(this.D.e + 0.001);
        final int maxz = ke.c(this.D.f + 0.5);
        if (this.p.d(minx, miny, minz, maxx, maxy, maxz)) {
            for (int dx = minx; dx <= maxx; ++dx) {
                for (int dy = miny; dy <= maxy; ++dy) {
                    for (int dz = minz; dz <= maxz; ++dz) {
                        final int i5 = this.p.a(dx, dy, dz);
                        if (i5 > 0) {
                            this.breakBlock(dx, dy, dz);
                        }
                    }
                }
            }
        }
    }
    
    protected String aY() {
        return (this.aa.nextInt(3) != 0) ? "mob.tf.naga.hiss" : "mob.tf.naga.rattle";
    }
    
    protected String aZ() {
        return "mob.tf.naga.hurt";
    }
    
    protected String ba() {
        return "mob.tf.naga.hurt";
    }
    
    protected void acquireNewPath() {
        if (!this.hasTarget()) {
            this.wanderRandomly();
            return;
        }
        if (this.intimidateTimer > 0) {
            this.pathToEntity = null;
            --this.intimidateTimer;
            if (this.intimidateTimer == 0) {
                this.clockwise = !this.clockwise;
                if (this.targetEntity.D.b > this.D.e) {
                    this.doCrumblePlayer();
                }
                else {
                    this.doCharge();
                }
            }
            return;
        }
        if (this.crumblePlayerTimer > 0) {
            this.pathToEntity = null;
            --this.crumblePlayerTimer;
            this.crumbleBelowTarget(2);
            this.crumbleBelowTarget(3);
            if (this.crumblePlayerTimer == 0) {
                this.doCharge();
            }
        }
        if (this.chargeCount > 0) {
            --this.chargeCount;
            final aoj tpoint = this.findCirclePoint(this.targetEntity, 14.0, 3.141592653589793);
            this.pathToEntity = this.p.a((lq)this, (int)tpoint.c, (int)tpoint.d, (int)tpoint.e, 40.0f, true, true, true, true);
            if (this.chargeCount == 0) {
                this.doCircle();
            }
        }
        if (this.circleCount > 0) {
            --this.circleCount;
            double radius = (this.circleCount % 2 == 0) ? 12.0 : 14.0;
            double rotation = 1.0;
            if (this.circleCount > 1 && this.circleCount < 3) {
                radius = 16.0;
            }
            if (this.circleCount == 1) {
                rotation = 0.1;
            }
            final aoj tpoint2 = this.findCirclePoint(this.targetEntity, radius, rotation);
            this.pathToEntity = this.p.a((lq)this, (int)tpoint2.c, (int)tpoint2.d, (int)tpoint2.e, 40.0f, true, true, true, true);
            if (this.circleCount == 0) {
                this.doIntimidate();
            }
        }
    }
    
    protected void crumbleBelowTarget(final int range) {
        final int floor = (int)this.D.b;
        final int targetY = (int)this.targetEntity.D.b;
        if (targetY > floor) {
            final int dx = (int)this.targetEntity.t + this.aa.nextInt(range) - this.aa.nextInt(range);
            final int dz = (int)this.targetEntity.v + this.aa.nextInt(range) - this.aa.nextInt(range);
            int dy = targetY - this.aa.nextInt(range) + this.aa.nextInt((range > 1) ? (range - 1) : range);
            if (dy <= floor) {
                dy = targetY;
            }
            if (this.p.a(dx, dy, dz) != 0) {
                this.breakBlock(dx, dy, dz);
                for (int k = 0; k < 20; ++k) {
                    final double d = this.aa.nextGaussian() * 0.02;
                    final double d2 = this.aa.nextGaussian() * 0.02;
                    final double d3 = this.aa.nextGaussian() * 0.02;
                    this.p.a("crit", this.t + this.aa.nextFloat() * this.N * 2.0f - this.N, this.u + this.aa.nextFloat() * this.O, this.v + this.aa.nextFloat() * this.N * 2.0f - this.N, d, d2, d3);
                }
            }
        }
    }
    
    protected void breakBlock(final int dx, final int dy, final int dz) {
        final int whatsThere = this.p.a(dx, dy, dz);
        final int whatsMeta = this.p.h(dx, dy, dz);
        if (whatsThere > 0) {
            amq.p[whatsThere].c(this.p, dx, dy, dz, whatsMeta, 0);
            this.p.e(dx, dy, dz, 0);
            this.p.f(2001, dx, dy, dz, whatsThere + (whatsMeta << 12));
        }
    }
    
    protected void doCircle() {
        this.circleCount += 10 + this.aa.nextInt(10);
        this.goNormal();
    }
    
    protected void doCrumblePlayer() {
        this.crumblePlayerTimer = 20 + this.aa.nextInt(20);
        this.goSlow();
    }
    
    protected void doCharge() {
        this.chargeCount = 4;
        this.goFast();
    }
    
    protected void doIntimidate() {
        this.intimidateTimer += 15 + this.aa.nextInt(10);
        this.goSlow();
    }
    
    protected void goSlow() {
        this.bD = 0.0f;
        this.bC = 0.0f;
        this.bH = 0.1f;
        this.pathToEntity = null;
    }
    
    protected void goNormal() {
        this.bH = 0.6f;
    }
    
    protected void goFast() {
        this.bH = 1.0f;
    }
    
    public boolean M() {
        return false;
    }
    
    protected aoj findCirclePoint(final lq toCircle, final double radius, final double rotation) {
        final double vecx = this.t - toCircle.t;
        final double vecz = this.v - toCircle.v;
        float rangle = (float)Math.atan2(vecz, vecx);
        rangle += (float)(this.clockwise ? rotation : (-rotation));
        final double dx = ke.b(rangle) * radius;
        final double dz = ke.a(rangle) * radius;
        return this.p.S().a(toCircle.t + dx, this.D.b, toCircle.v + dz);
    }
    
    public boolean hasTarget() {
        return this.targetEntity != null;
    }
    
    protected lq findTarget() {
        final qx entityplayer = this.p.a((lq)this, 32.0);
        if (entityplayer != null && this.n((lq)entityplayer) && this.isEntityWithinHomeArea((lq)entityplayer)) {
            return (lq)entityplayer;
        }
        return null;
    }
    
    public boolean a(final lh damagesource, final int i) {
        if (damagesource.f() != null && !this.isEntityWithinHomeArea(damagesource.f())) {
            return false;
        }
        if (damagesource.g() != null && !this.isEntityWithinHomeArea(damagesource.g())) {
            return false;
        }
        if (super.a(damagesource, i)) {
            this.setSegmentsPerHealth();
            final lq entity = damagesource.g();
            if (entity != this) {
                this.targetEntity = entity;
            }
            this.ticksSinceDamaged = 0;
            return true;
        }
        return false;
    }
    
    protected void a(final lq toAttack, final float f) {
        if (this.aZ <= 0 && f < 4.0f && toAttack.D.e > this.D.b - 2.5 && toAttack.D.b < this.D.e + 2.5) {
            this.aZ = 20;
            this.m(toAttack);
            if (this.bH > 0.8) {
                toAttack.g((double)(-ke.a(this.z * 3.141593f / 180.0f) * 1.0f), 0.1, (double)(ke.b(this.z * 3.141593f / 180.0f) * 1.0f));
            }
        }
    }
    
    protected void wanderRandomly() {
        this.goNormal();
        boolean flag = false;
        int tx = -1;
        int ty = -1;
        int tz = -1;
        float worstweight = -99999.0f;
        for (int l = 0; l < 10; ++l) {
            int dx = ke.c(this.t + this.aa.nextInt(21) - 6.0);
            int dy = ke.c(this.u + this.aa.nextInt(7) - 3.0);
            int dz = ke.c(this.v + this.aa.nextInt(21) - 6.0);
            if (!this.e(dx, dy, dz)) {
                dx = this.aJ().a + this.aa.nextInt(21) - this.aa.nextInt(21);
                dy = this.aJ().b + this.aa.nextInt(7) - this.aa.nextInt(7);
                dz = this.aJ().c + this.aa.nextInt(21) - this.aa.nextInt(21);
            }
            final float weight = this.a(dx, dy, dz);
            if (weight > worstweight) {
                worstweight = weight;
                tx = dx;
                ty = dy;
                tz = dz;
                flag = true;
            }
        }
        if (flag) {
            this.pathToEntity = this.p.a((lq)this, tx, ty, tz, 80.0f, true, true, true, true);
        }
    }
    
    public float a(final int i, final int j, final int k) {
        if (!this.e(i, j, k)) {
            return Float.MIN_VALUE;
        }
        return 0.0f;
    }
    
    public boolean k() {
        return this.pathToEntity != null;
    }
    
    protected int bb() {
        return TFItems.nagaScale.cj;
    }
    
    protected void a(final boolean flag, final int z) {
        final int i = this.bb();
        if (i > 0) {
            for (int j = 6 + this.aa.nextInt(6), k = 0; k < j; ++k) {
                this.b(i, 1);
            }
        }
    }
    
    protected void despawnIfInvalid() {
        if (!this.p.I && this.p.s == 0) {
            this.despawnMe();
        }
        if (!this.p.I) {
            for (int i = 0; i < this.currentSegments; ++i) {
                if (this.body != null && this.body[i] != null && this.body[i].L) {
                    this.despawnMe();
                }
            }
            if (!this.aI()) {}
        }
    }
    
    protected void despawnMe() {
        if (this.isLeashed()) {
            final s home = this.aJ();
            this.p.e(home.a, home.b, home.c, TFBlocks.bossSpawner.cm);
        }
        this.x();
    }
    
    public boolean isLeashed() {
        return this.aK() > -1.0f;
    }
    
    public boolean e(final int x, final int y, final int z) {
        if (this.aK() == -1.0f) {
            return true;
        }
        final int distX = Math.abs(this.aJ().a - x);
        final int distY = Math.abs(this.aJ().b - y);
        final int distZ = Math.abs(this.aJ().c - z);
        return distX <= this.LEASH_X && distY <= this.LEASH_Y && distZ <= this.LEASH_Z;
    }
    
    public boolean isEntityWithinHomeArea(final lq entity) {
        return this.e(ke.c(entity.t), ke.c(entity.u), ke.c(entity.v));
    }
    
    protected void spawnBodySegments() {
        if (!this.p.I) {
            if (this.body == null) {
                this.body = new EntityTFNagaSegment[EntityTFNaga.MAX_SEGMENTS];
            }
            for (int i = 0; i < this.currentSegments; ++i) {
                if (this.body[i] == null || this.body[i].L) {
                    (this.body[i] = new EntityTFNagaSegment(this.p, this, i)).b(this.t + 0.1 * i, this.u + 0.5, this.v + 0.1 * i, this.aa.nextFloat() * 360.0f, 0.0f);
                    this.p.d((lq)this.body[i]);
                }
            }
        }
    }
    
    protected void pullSegments() {
        this.spawnBodySegments();
        if (!this.p.I) {
            this.body[0].pullTowards((lq)this);
            for (int i = 1; i < this.currentSegments; ++i) {
                this.body[i].pullTowards((lq)this.body[i - 1]);
            }
        }
    }
    
    public void b(final bq nbttagcompound) {
        final s home = this.aJ();
        nbttagcompound.a("Home", (cd)this.a(new double[] { home.a, home.b, home.c }));
        nbttagcompound.a("HasHome", this.aM());
        super.b(nbttagcompound);
    }
    
    public void a(final bq nbttagcompound) {
        super.a(nbttagcompound);
        final by homelist = nbttagcompound.m("Home");
        this.b((int)((bt)homelist.b(0)).a, (int)((bt)homelist.b(1)).a, (int)((bt)homelist.b(2)).a, this.LEASH_X);
        if (!nbttagcompound.n("HasHome")) {
            this.aL();
        }
        this.setSegmentsPerHealth();
    }
    
    public void a(final lh par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.f() instanceof qx) {
            ((qx)par1DamageSource.f()).a((jl)TFAchievementPage.twilightHunter);
            ((qx)par1DamageSource.f()).a((jl)TFAchievementPage.twilightNaga);
        }
    }
    
    public float getMoveSpeed() {
        return this.bH;
    }
    
    public int b() {
        return this.ag.c(16);
    }
    
    static {
        EntityTFNaga.TICKS_BEFORE_HEALING = 600;
        EntityTFNaga.MAX_SEGMENTS = 12;
    }
}
