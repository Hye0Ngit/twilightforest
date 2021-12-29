// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFNaga extends zo implements aey
{
    int segments;
    int segmentHealth;
    int LEASH_X;
    int LEASH_Y;
    int LEASH_Z;
    EntityTFNagaSegment[] body;
    protected dw pathToEntity;
    protected ia targetEntity;
    int lastTorchX;
    int lastTorchZ;
    int homeX;
    int homeY;
    int homeZ;
    int circleCount;
    int intimidateTimer;
    int crumblePlayerTimer;
    int chargeCount;
    boolean clockwise;
    
    public EntityTFNaga(final ry world) {
        super(world);
        this.segments = 0;
        this.LEASH_X = 46;
        this.LEASH_Y = 7;
        this.LEASH_Z = 46;
        this.aA = "/twilightforest/nagahead.png";
        this.a(1.75f, 3.0f);
        this.bw = 0.6f;
        this.V = 2.0f;
        if (this.o != null) {
            switch (this.o.v) {
                default: {
                    this.aM = 200;
                    break;
                }
                case 1: {
                    this.aM = 120;
                    break;
                }
                case 3: {
                    this.aM = 250;
                    break;
                }
            }
        }
        this.segmentHealth = this.aM / 10;
        this.setSegmentsPerHealth();
        this.a = 6;
        this.aX = 217;
        this.circleCount = 15;
    }
    
    protected int setSegmentsPerHealth() {
        final int oldSegments = this.segments;
        final int newSegments = this.aM / this.segmentHealth + ((this.aM > 0) ? 2 : 0);
        if (newSegments != oldSegments) {
            if (newSegments < oldSegments) {
                for (int i = newSegments; i < oldSegments; ++i) {
                    if (this.body != null && this.body[i] != null) {
                        this.body[i].selfDestruct();
                    }
                }
            }
            this.segments = newSegments;
            this.setMovementFactorPerSegments();
        }
        return this.segments;
    }
    
    protected void setMovementFactorPerSegments() {
        this.aI = 0.6f - this.segments / 12.0f * 0.2f;
        this.aJ = this.aI / 2.0f;
        for (int i = 0; i < this.segments; ++i) {
            if (this.body != null && this.body[i] != null) {
                this.body[i].aI = this.aI * 1.25f;
                this.body[i].aJ = this.aJ * 1.25f;
            }
        }
    }
    
    public void setHome(final int x, final int y, final int z) {
        this.homeX = x;
        this.homeY = y;
        this.homeZ = z;
    }
    
    public boolean d_() {
        return false;
    }
    
    public boolean F() {
        return false;
    }
    
    public void a() {
        this.despawnIfInvalid();
        if (this.aS > 0) {
            for (int k = 0; k < 5; ++k) {
                final double d = this.Y.nextGaussian() * 0.02;
                final double d2 = this.Y.nextGaussian() * 0.02;
                final double d3 = this.Y.nextGaussian() * 0.02;
                final String explosionType = this.Y.nextBoolean() ? "hugeexplosion" : "explode";
                this.o.a(explosionType, this.s + this.Y.nextFloat() * this.M * 2.0f - this.M, this.t + this.Y.nextFloat() * this.N, this.u + this.Y.nextFloat() * this.M * 2.0f - this.M, d, d2, d3);
            }
        }
        super.a();
    }
    
    protected void n() {
        if (this.E && this.hasTarget()) {
            this.breakNearbyBlocks();
        }
        if (this.targetEntity == null) {
            this.targetEntity = this.findTarget();
            if (this.targetEntity != null) {
                this.acquireNewPath();
            }
        }
        else if (!this.targetEntity.K()) {
            this.targetEntity = null;
        }
        else {
            final float targetDistance = this.targetEntity.c((ia)this);
            if (targetDistance > 80.0f) {
                this.targetEntity = null;
            }
            else if (this.i(this.targetEntity)) {
                this.a(this.targetEntity, targetDistance);
            }
        }
        if (!this.aB()) {
            this.acquireNewPath();
        }
        final boolean inWater = this.D();
        final boolean inLava = this.F();
        fb vec3d = this.aB() ? this.pathToEntity.a((ia)this) : null;
        final double d = this.M * 4.0f;
        while (vec3d != null && vec3d.d(this.s, vec3d.b, this.u) < d * d) {
            this.pathToEntity.a();
            if (this.pathToEntity.b()) {
                vec3d = null;
                this.pathToEntity = null;
            }
            else {
                vec3d = this.pathToEntity.a((ia)this);
            }
        }
        this.bu = false;
        if (vec3d != null) {
            final double d2 = vec3d.a - this.s;
            final double d3 = vec3d.c - this.u;
            final double dist = me.a(d2 * d2 + d3 * d3);
            final int i = me.c(this.C.b + 0.5);
            final double d4 = vec3d.b - i;
            final float f2 = (float)(Math.atan2(d3, d2) * 180.0 / 3.1415927410125732) - 90.0f;
            float f3 = f2 - this.y;
            this.bs = this.bw;
            if (dist > 4.0 && this.chargeCount == 0) {
                this.br = me.b(this.bc * 0.3f) * this.bw * 0.6f;
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
            this.y += f3;
            if (d4 > 0.0) {
                this.bu = true;
            }
        }
        if (this.intimidateTimer > 0 && this.hasTarget()) {
            this.a(this.targetEntity, 30.0f, 30.0f);
            this.bs = 0.1f;
        }
        if (this.intimidateTimer > 0 && this.hasTarget()) {
            this.a(this.targetEntity, 30.0f, 30.0f);
            this.bs = 0.1f;
        }
        if (this.Y.nextFloat() < 0.8f && (inWater || inLava)) {
            this.bu = true;
        }
        this.pullSegments();
    }
    
    protected void breakNearbyBlocks() {
        final int minx = me.c(this.C.a - 0.5);
        final int miny = me.c(this.C.b + 1.01);
        final int minz = me.c(this.C.c - 0.5);
        final int maxx = me.c(this.C.d + 0.5);
        final int maxy = me.c(this.C.e + 0.001);
        final int maxz = me.c(this.C.f + 0.5);
        if (this.o.b(minx, miny, minz, maxx, maxy, maxz)) {
            for (int dx = minx; dx <= maxx; ++dx) {
                for (int dy = miny; dy <= maxy; ++dy) {
                    for (int dz = minz; dz <= maxz; ++dz) {
                        final int i5 = this.o.a(dx, dy, dz);
                        if (i5 > 0) {
                            this.breakBlock(dx, dy, dz);
                        }
                    }
                }
            }
        }
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
                if (this.targetEntity.C.b > this.C.e) {
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
            final fb tpoint = this.findCirclePoint(this.targetEntity, 14.0, 3.141592653589793);
            this.pathToEntity = this.o.a((ia)this, (int)tpoint.a, (int)tpoint.b, (int)tpoint.c, 40.0f);
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
            final fb tpoint2 = this.findCirclePoint(this.targetEntity, radius, rotation);
            this.pathToEntity = this.o.a((ia)this, (int)tpoint2.a, (int)tpoint2.b, (int)tpoint2.c, 40.0f);
            if (this.circleCount == 0) {
                this.doIntimidate();
            }
        }
    }
    
    protected void crumbleBelowTarget(final int range) {
        final int floor = (int)this.C.b;
        final int targetY = (int)this.targetEntity.C.b;
        if (targetY > floor) {
            final int dx = (int)this.targetEntity.s + this.Y.nextInt(range) - this.Y.nextInt(range);
            final int dz = (int)this.targetEntity.u + this.Y.nextInt(range) - this.Y.nextInt(range);
            int dy = targetY - this.Y.nextInt(range) + this.Y.nextInt((range > 1) ? (range - 1) : range);
            if (dy <= floor) {
                dy = targetY;
            }
            if (this.o.a(dx, dy, dz) != 0) {
                this.breakBlock(dx, dy, dz);
                for (int k = 0; k < 20; ++k) {
                    final double d = this.Y.nextGaussian() * 0.02;
                    final double d2 = this.Y.nextGaussian() * 0.02;
                    final double d3 = this.Y.nextGaussian() * 0.02;
                    this.o.a("crit", this.s + this.Y.nextFloat() * this.M * 2.0f - this.M, this.t + this.Y.nextFloat() * this.N, this.u + this.Y.nextFloat() * this.M * 2.0f - this.M, d, d2, d3);
                }
            }
        }
    }
    
    protected void breakBlock(final int dx, final int dy, final int dz) {
        final int whatsThere = this.o.a(dx, dy, dz);
        final int whatsMeta = this.o.d(dx, dy, dz);
        if (whatsThere > 0) {
            yy.k[whatsThere].b(this.o, dx, dy, dz, whatsMeta, 0);
            this.o.g(dx, dy, dz, 0);
            this.o.g(2001, dx, dy, dz, whatsThere + whatsMeta * 256);
        }
    }
    
    protected void doCircle() {
        System.out.println("Resuming circle mode");
        this.circleCount += 10 + this.Y.nextInt(10);
        this.goNormal();
    }
    
    protected void doCrumblePlayer() {
        this.crumblePlayerTimer = 20 + this.Y.nextInt(20);
        this.goSlow();
    }
    
    protected void doCharge() {
        this.chargeCount = 4;
        this.goFast();
    }
    
    protected void doIntimidate() {
        this.intimidateTimer += 15 + this.Y.nextInt(10);
        this.goSlow();
    }
    
    protected void goSlow() {
        this.bs = 0.0f;
        this.br = 0.0f;
        this.bw = 0.1f;
        this.pathToEntity = null;
    }
    
    protected void goNormal() {
        this.bw = 0.6f;
    }
    
    protected void goFast() {
        this.bw = 1.0f;
    }
    
    public boolean H() {
        return false;
    }
    
    protected fb findCirclePoint(final ia toCircle, final double radius, final double rotation) {
        final double vecx = this.s - toCircle.s;
        final double vecz = this.u - toCircle.u;
        float rangle = (float)Math.atan2(vecz, vecx);
        rangle += (float)(this.clockwise ? rotation : (-rotation));
        final double dx = me.b(rangle) * radius;
        final double dz = me.a(rangle) * radius;
        return fb.b(toCircle.s + dx, this.C.b, toCircle.u + dz);
    }
    
    public boolean hasTarget() {
        return this.targetEntity != null;
    }
    
    protected ia findTarget() {
        final vi entityplayer = this.o.a((ia)this, 32.0);
        if (entityplayer != null && this.i((ia)entityplayer)) {
            return (ia)entityplayer;
        }
        return null;
    }
    
    public boolean a(final pm damagesource, final int i) {
        if (!super.a(damagesource, i)) {
            return false;
        }
        this.setSegmentsPerHealth();
        final ia entity = damagesource.a();
        if (this.m == entity || this.n == entity) {
            return true;
        }
        if (entity != this) {
            this.targetEntity = entity;
        }
        return true;
    }
    
    protected boolean b(final ia entity) {
        return entity.a(pm.a((nq)this), this.a);
    }
    
    protected void a(final ia toAttack, final float f) {
        if (this.aT <= 0 && f < 4.0f && toAttack.C.e > this.C.b - 2.5 && toAttack.C.b < this.C.e + 2.5) {
            this.aT = 20;
            this.b(toAttack);
            if (this.bw > 0.8) {
                toAttack.h((double)(-me.a(this.y * 3.141593f / 180.0f) * 1.0f), 0.1, (double)(me.b(this.y * 3.141593f / 180.0f) * 1.0f));
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
            int dx = me.c(this.s + this.Y.nextInt(21) - 6.0);
            int dy = me.c(this.t + this.Y.nextInt(7) - 3.0);
            int dz = me.c(this.u + this.Y.nextInt(21) - 6.0);
            if (this.isLeashed() && (dx > this.homeX + this.LEASH_X || dx < this.homeX - this.LEASH_X || dz > this.homeZ + this.LEASH_Z || dz < this.homeZ - this.LEASH_Z || dy > this.homeY + this.LEASH_Y || dy < this.homeY - this.LEASH_Y)) {
                dx = this.homeX + this.Y.nextInt(21) - this.Y.nextInt(21);
                dy = this.homeY + this.Y.nextInt(7) - this.Y.nextInt(7);
                dz = this.homeZ + this.Y.nextInt(21) - this.Y.nextInt(21);
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
            this.pathToEntity = this.o.a((ia)this, tx, ty, tz, 80.0f);
        }
    }
    
    protected float a(final int i, final int j, final int k) {
        final int distX = Math.abs(this.homeX - i);
        final int distY = Math.abs(this.homeY - j);
        final int distZ = Math.abs(this.homeZ - k);
        if (this.isLeashed() && (distX > this.LEASH_X - 10 || distY > this.LEASH_Y || distZ > this.LEASH_Z - 10)) {
            return Float.MIN_VALUE;
        }
        return 0.0f;
    }
    
    public boolean aB() {
        return this.pathToEntity != null;
    }
    
    protected int k() {
        return TFItems.nagaScale.bM;
    }
    
    protected void a(final boolean flag, final int z) {
        final int i = this.k();
        if (i > 0) {
            for (int j = 6 + this.Y.nextInt(6), k = 0; k < j; ++k) {
                this.b(i, 1);
            }
        }
    }
    
    protected void despawnIfInvalid() {
        if (!this.o.I && this.o.v == 0) {
            this.despawnMe();
        }
        for (int i = 0; i < this.segments; ++i) {
            if (this.body != null && this.body[i] != null && this.body[i].K) {
                this.despawnMe();
            }
        }
        if (this.isLeashed()) {
            final int distX = Math.abs((int)(this.homeX - this.s));
            final int distY = Math.abs((int)(this.homeY - this.t));
            final int distZ = Math.abs((int)(this.homeZ - this.u));
            if (distX > this.LEASH_X || distY > this.LEASH_Y || distZ > this.LEASH_Z) {
                this.despawnMe();
            }
        }
    }
    
    protected void despawnMe() {
        if (this.isLeashed()) {
            this.o.g(this.homeX, this.homeY, this.homeZ, TFBlocks.bossSpawner.bM);
        }
        this.v();
    }
    
    public boolean isLeashed() {
        return this.homeX != 0 && this.homeY != 0 && this.homeZ != 0;
    }
    
    protected void spawnBodySegments() {
        this.body = new EntityTFNagaSegment[this.segments];
        for (int i = 0; i < this.segments; ++i) {
            (this.body[i] = new EntityTFNagaSegment(this.o, this, i)).c(this.s + 0.1 * i, this.t + 0.5, this.u + 0.1 * i, this.Y.nextFloat() * 360.0f, 0.0f);
            this.o.a((ia)this.body[i]);
        }
    }
    
    protected void pullSegments() {
        if (this.body == null || this.body.length < this.segments) {
            this.spawnBodySegments();
        }
        this.body[0].pullTowards((ia)this);
        for (int i = 1; i < this.segments; ++i) {
            this.body[i].pullTowards((ia)this.body[i - 1]);
        }
    }
    
    public void a(final ik nbttagcompound) {
        nbttagcompound.a("Home", (um)this.a(new double[] { this.homeX, this.homeY, this.homeZ }));
        super.a(nbttagcompound);
    }
    
    public void b(final ik nbttagcompound) {
        super.b(nbttagcompound);
        final yi homelist = nbttagcompound.l("Home");
        this.setHome((int)((fg)homelist.a(0)).a, (int)((fg)homelist.a(1)).a, (int)((fg)homelist.a(2)).a);
        this.setSegmentsPerHealth();
    }
    
    public int f_() {
        return 0;
    }
}
