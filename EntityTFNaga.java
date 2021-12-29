// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFNaga extends yt implements xb
{
    int segments;
    int segmentHealth;
    int LEASH_X;
    int LEASH_Y;
    int LEASH_Z;
    EntityTFNagaSegment[] body;
    protected vq pathToEntity;
    protected nk targetEntity;
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
    
    public EntityTFNaga(final wz world) {
        super(world);
        this.segments = 0;
        this.LEASH_X = 46;
        this.LEASH_Y = 7;
        this.LEASH_Z = 46;
        this.bm = "/twilightforest/nagahead.png";
        this.a(1.75f, 3.0f);
        this.cj = 0.6f;
        this.R = 2.0f;
        if (this.k != null) {
            switch (this.k.q) {
                default: {
                    this.bx = 200;
                    break;
                }
                case 1: {
                    this.bx = 120;
                    break;
                }
                case 3: {
                    this.bx = 250;
                    break;
                }
            }
            this.segmentHealth = this.bx / 10;
            this.setSegmentsPerHealth();
        }
        this.c = 6;
        this.bI = 217;
        this.circleCount = 15;
    }
    
    protected int setSegmentsPerHealth() {
        final int oldSegments = this.segments;
        final int newSegments = this.bx / this.segmentHealth + ((this.bx > 0) ? 2 : 0);
        if (!this.k.F && newSegments != oldSegments) {
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
        this.bt = 0.6f - this.segments / 12.0f * 0.2f;
        this.bu = this.bt / 2.0f;
        for (int i = 0; i < this.segments; ++i) {
            if (this.body != null && this.body[i] != null) {
                this.body[i].bt = this.bt * 1.25f;
                this.body[i].bu = this.bu * 1.25f;
            }
        }
    }
    
    public void setHome(final int x, final int y, final int z) {
        this.homeX = x;
        this.homeY = y;
        this.homeZ = z;
    }
    
    public boolean f_() {
        return false;
    }
    
    public boolean I() {
        return false;
    }
    
    public void I_() {
        this.despawnIfInvalid();
        if (this.bD > 0) {
            for (int k = 0; k < 5; ++k) {
                final double d = this.U.nextGaussian() * 0.02;
                final double d2 = this.U.nextGaussian() * 0.02;
                final double d3 = this.U.nextGaussian() * 0.02;
                final String explosionType = this.U.nextBoolean() ? "hugeexplosion" : "explode";
                this.k.a(explosionType, this.o + this.U.nextFloat() * this.I * 2.0f - this.I, this.p + this.U.nextFloat() * this.J, this.q + this.U.nextFloat() * this.I * 2.0f - this.I, d, d2, d3);
            }
        }
        super.I_();
    }
    
    protected void x_() {
        if (this.A && this.hasTarget()) {
            this.breakNearbyBlocks();
        }
        if (this.targetEntity == null) {
            this.targetEntity = this.findTarget();
            if (this.targetEntity != null) {
                this.acquireNewPath();
            }
        }
        else if (!this.targetEntity.M()) {
            this.targetEntity = null;
        }
        else {
            final float targetDistance = this.targetEntity.e((nk)this);
            if (targetDistance > 80.0f) {
                this.targetEntity = null;
            }
            else if (this.m(this.targetEntity)) {
                this.a(this.targetEntity, targetDistance);
            }
        }
        if (!this.ap()) {
            this.acquireNewPath();
        }
        final boolean inWater = this.G();
        final boolean inLava = this.I();
        bm vec3d = this.ap() ? this.pathToEntity.a((nk)this) : null;
        final double d = this.I * 4.0f;
        while (vec3d != null && vec3d.d(this.o, vec3d.b, this.q) < d * d) {
            this.pathToEntity.a();
            if (this.pathToEntity.b()) {
                vec3d = null;
                this.pathToEntity = null;
            }
            else {
                vec3d = this.pathToEntity.a((nk)this);
            }
        }
        this.ch = false;
        if (vec3d != null) {
            final double d2 = vec3d.a - this.o;
            final double d3 = vec3d.c - this.q;
            final double dist = gh.a(d2 * d2 + d3 * d3);
            final int i = gh.c(this.y.b + 0.5);
            final double d4 = vec3d.b - i;
            final float f2 = (float)(Math.atan2(d3, d2) * 180.0 / 3.1415927410125732) - 90.0f;
            float f3 = f2 - this.u;
            this.cf = this.cj;
            if (dist > 4.0 && this.chargeCount == 0) {
                this.ce = gh.b(this.bN * 0.3f) * this.cj * 0.6f;
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
            this.u += f3;
            if (d4 > 0.0) {
                this.ch = true;
            }
        }
        if (this.intimidateTimer > 0 && this.hasTarget()) {
            this.a(this.targetEntity, 30.0f, 30.0f);
            this.cf = 0.1f;
        }
        if (this.intimidateTimer > 0 && this.hasTarget()) {
            this.a(this.targetEntity, 30.0f, 30.0f);
            this.cf = 0.1f;
        }
        if (this.U.nextFloat() < 0.8f && (inWater || inLava)) {
            this.ch = true;
        }
        this.pullSegments();
    }
    
    protected void breakNearbyBlocks() {
        final int minx = gh.c(this.y.a - 0.5);
        final int miny = gh.c(this.y.b + 1.01);
        final int minz = gh.c(this.y.c - 0.5);
        final int maxx = gh.c(this.y.d + 0.5);
        final int maxy = gh.c(this.y.e + 0.001);
        final int maxz = gh.c(this.y.f + 0.5);
        if (this.k.b(minx, miny, minz, maxx, maxy, maxz)) {
            for (int dx = minx; dx <= maxx; ++dx) {
                for (int dy = miny; dy <= maxy; ++dy) {
                    for (int dz = minz; dz <= maxz; ++dz) {
                        final int i5 = this.k.a(dx, dy, dz);
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
                if (this.targetEntity.y.b > this.y.e) {
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
            final bm tpoint = this.findCirclePoint(this.targetEntity, 14.0, 3.141592653589793);
            this.pathToEntity = this.k.a((nk)this, (int)tpoint.a, (int)tpoint.b, (int)tpoint.c, 40.0f, true, true, true, true);
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
            final bm tpoint2 = this.findCirclePoint(this.targetEntity, radius, rotation);
            this.pathToEntity = this.k.a((nk)this, (int)tpoint2.a, (int)tpoint2.b, (int)tpoint2.c, 40.0f, true, true, true, true);
            if (this.circleCount == 0) {
                this.doIntimidate();
            }
        }
    }
    
    protected void crumbleBelowTarget(final int range) {
        final int floor = (int)this.y.b;
        final int targetY = (int)this.targetEntity.y.b;
        if (targetY > floor) {
            final int dx = (int)this.targetEntity.o + this.U.nextInt(range) - this.U.nextInt(range);
            final int dz = (int)this.targetEntity.q + this.U.nextInt(range) - this.U.nextInt(range);
            int dy = targetY - this.U.nextInt(range) + this.U.nextInt((range > 1) ? (range - 1) : range);
            if (dy <= floor) {
                dy = targetY;
            }
            if (this.k.a(dx, dy, dz) != 0) {
                this.breakBlock(dx, dy, dz);
                for (int k = 0; k < 20; ++k) {
                    final double d = this.U.nextGaussian() * 0.02;
                    final double d2 = this.U.nextGaussian() * 0.02;
                    final double d3 = this.U.nextGaussian() * 0.02;
                    this.k.a("crit", this.o + this.U.nextFloat() * this.I * 2.0f - this.I, this.p + this.U.nextFloat() * this.J, this.q + this.U.nextFloat() * this.I * 2.0f - this.I, d, d2, d3);
                }
            }
        }
    }
    
    protected void breakBlock(final int dx, final int dy, final int dz) {
        final int whatsThere = this.k.a(dx, dy, dz);
        final int whatsMeta = this.k.e(dx, dy, dz);
        if (whatsThere > 0) {
            ox.m[whatsThere].a(this.k, dx, dy, dz, whatsMeta, 0);
            this.k.g(dx, dy, dz, 0);
            this.k.g(2001, dx, dy, dz, whatsThere + (whatsMeta << 12));
        }
    }
    
    protected void doCircle() {
        this.circleCount += 10 + this.U.nextInt(10);
        this.goNormal();
    }
    
    protected void doCrumblePlayer() {
        this.crumblePlayerTimer = 20 + this.U.nextInt(20);
        this.goSlow();
    }
    
    protected void doCharge() {
        this.chargeCount = 4;
        this.goFast();
    }
    
    protected void doIntimidate() {
        this.intimidateTimer += 15 + this.U.nextInt(10);
        this.goSlow();
    }
    
    protected void goSlow() {
        this.cf = 0.0f;
        this.ce = 0.0f;
        this.cj = 0.1f;
        this.pathToEntity = null;
    }
    
    protected void goNormal() {
        this.cj = 0.6f;
    }
    
    protected void goFast() {
        this.cj = 1.0f;
    }
    
    public boolean e_() {
        return false;
    }
    
    protected bm findCirclePoint(final nk toCircle, final double radius, final double rotation) {
        final double vecx = this.o - toCircle.o;
        final double vecz = this.q - toCircle.q;
        float rangle = (float)Math.atan2(vecz, vecx);
        rangle += (float)(this.clockwise ? rotation : (-rotation));
        final double dx = gh.b(rangle) * radius;
        final double dz = gh.a(rangle) * radius;
        return bm.b(toCircle.o + dx, this.y.b, toCircle.q + dz);
    }
    
    public boolean hasTarget() {
        return this.targetEntity != null;
    }
    
    protected nk findTarget() {
        final yr entityplayer = this.k.a((nk)this, 32.0);
        if (entityplayer != null && this.m((nk)entityplayer)) {
            return (nk)entityplayer;
        }
        return null;
    }
    
    public boolean a(final ma damagesource, final int i) {
        if (!super.a(damagesource, i)) {
            return false;
        }
        this.setSegmentsPerHealth();
        final nk entity = damagesource.a();
        if (this.i == entity || this.j == entity) {
            return true;
        }
        if (entity != this) {
            this.targetEntity = entity;
        }
        return true;
    }
    
    public boolean c(final nk entity) {
        return entity.a(ma.a((acl)this), this.c);
    }
    
    protected void a(final nk toAttack, final float f) {
        if (this.bE <= 0 && f < 4.0f && toAttack.y.e > this.y.b - 2.5 && toAttack.y.b < this.y.e + 2.5) {
            this.bE = 20;
            this.c(toAttack);
            if (this.cj > 0.8) {
                toAttack.c((double)(-gh.a(this.u * 3.141593f / 180.0f) * 1.0f), 0.1, (double)(gh.b(this.u * 3.141593f / 180.0f) * 1.0f));
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
            int dx = gh.c(this.o + this.U.nextInt(21) - 6.0);
            int dy = gh.c(this.p + this.U.nextInt(7) - 3.0);
            int dz = gh.c(this.q + this.U.nextInt(21) - 6.0);
            if (this.isLeashed() && (dx > this.homeX + this.LEASH_X || dx < this.homeX - this.LEASH_X || dz > this.homeZ + this.LEASH_Z || dz < this.homeZ - this.LEASH_Z || dy > this.homeY + this.LEASH_Y || dy < this.homeY - this.LEASH_Y)) {
                dx = this.homeX + this.U.nextInt(21) - this.U.nextInt(21);
                dy = this.homeY + this.U.nextInt(7) - this.U.nextInt(7);
                dz = this.homeZ + this.U.nextInt(21) - this.U.nextInt(21);
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
            this.pathToEntity = this.k.a((nk)this, tx, ty, tz, 80.0f, true, true, true, true);
        }
    }
    
    public float a(final int i, final int j, final int k) {
        final int distX = Math.abs(this.homeX - i);
        final int distY = Math.abs(this.homeY - j);
        final int distZ = Math.abs(this.homeZ - k);
        if (this.isLeashed() && (distX > this.LEASH_X - 10 || distY > this.LEASH_Y || distZ > this.LEASH_Z - 10)) {
            return Float.MIN_VALUE;
        }
        return 0.0f;
    }
    
    public boolean ap() {
        return this.pathToEntity != null;
    }
    
    protected int f() {
        return TFItems.nagaScale.bQ;
    }
    
    protected void a(final boolean flag, final int z) {
        final int i = this.f();
        if (i > 0) {
            for (int j = 6 + this.U.nextInt(6), k = 0; k < j; ++k) {
                this.b(i, 1);
            }
        }
    }
    
    protected void despawnIfInvalid() {
        if (!this.k.F && this.k.q == 0) {
            this.despawnMe();
        }
        if (!this.k.F) {
            for (int i = 0; i < this.segments; ++i) {
                if (this.body != null && this.body[i] != null && this.body[i].G) {
                    this.despawnMe();
                }
            }
            if (this.isLeashed()) {
                final int distX = Math.abs((int)(this.homeX - this.o));
                final int distY = Math.abs((int)(this.homeY - this.p));
                final int distZ = Math.abs((int)(this.homeZ - this.q));
                if (distX > this.LEASH_X || distY > this.LEASH_Y || distZ > this.LEASH_Z) {
                    this.despawnMe();
                }
            }
        }
    }
    
    protected void despawnMe() {
        if (this.isLeashed()) {
            this.k.g(this.homeX, this.homeY, this.homeZ, TFBlocks.bossSpawner.bO);
        }
        this.z();
    }
    
    public boolean isLeashed() {
        return this.homeX != 0 && this.homeY != 0 && this.homeZ != 0;
    }
    
    protected void spawnBodySegments() {
        if (!this.k.F) {
            this.body = new EntityTFNagaSegment[this.segments];
            for (int i = 0; i < this.segments; ++i) {
                (this.body[i] = new EntityTFNagaSegment(this.k, this, i)).c(this.o + 0.1 * i, this.p + 0.5, this.q + 0.1 * i, this.U.nextFloat() * 360.0f, 0.0f);
                this.k.a((nk)this.body[i]);
            }
        }
    }
    
    protected void pullSegments() {
        if (this.body == null || this.body.length < this.segments) {
            this.spawnBodySegments();
        }
        if (!this.k.F) {
            this.body[0].pullTowards((nk)this);
            for (int i = 1; i < this.segments; ++i) {
                this.body[i].pullTowards((nk)this.body[i - 1]);
            }
        }
    }
    
    public void b(final adt nbttagcompound) {
        nbttagcompound.a("Home", (ge)this.a(new double[] { this.homeX, this.homeY, this.homeZ }));
        super.b(nbttagcompound);
    }
    
    public void a(final adt nbttagcompound) {
        super.a(nbttagcompound);
        final nl homelist = nbttagcompound.n("Home");
        this.setHome((int)((ahf)homelist.a(0)).a, (int)((ahf)homelist.a(1)).a, (int)((ahf)homelist.a(2)).a);
        this.setSegmentsPerHealth();
    }
    
    public int d() {
        return 0;
    }
}
