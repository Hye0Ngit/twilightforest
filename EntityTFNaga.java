// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFNaga extends ij implements gg
{
    int segments;
    int segmentHealth;
    int LEASH_X;
    int LEASH_Y;
    int LEASH_Z;
    EntityTFNagaSegment[] body;
    protected ed pathToEntity;
    protected tv targetEntity;
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
    
    public EntityTFNaga(final ge world) {
        super(world);
        this.segments = 0;
        this.LEASH_X = 46;
        this.LEASH_Y = 7;
        this.LEASH_Z = 46;
        this.ae = "/twilightforest/nagahead.png";
        this.b(1.75f, 3.0f);
        this.bb = 0.6f;
        this.bP = 2.0f;
        this.ap = this.d();
        this.segmentHealth = this.d() / 10;
        this.setSegmentsPerHealth();
        this.c = 6;
        this.aA = 217;
        this.circleCount = 15;
    }
    
    public int d() {
        if (this.bi == null) {
            return 200;
        }
        switch (this.bi.q) {
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
        final int oldSegments = this.segments;
        final int newSegments = this.ap / this.segmentHealth + ((this.ap > 0) ? 2 : 0);
        if (this.bi != null && !this.bi.F && newSegments != oldSegments) {
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
        this.al = 0.6f - this.segments / 12.0f * 0.2f;
        this.am = this.al / 2.0f;
        for (int i = 0; i < this.segments; ++i) {
            if (this.body != null && this.body[i] != null) {
                this.body[i].al = this.al * 1.25f;
                this.body[i].am = this.am * 1.25f;
            }
        }
    }
    
    public void setHome(final int x, final int y, final int z) {
        this.homeX = x;
        this.homeY = y;
        this.homeZ = z;
    }
    
    public boolean g_() {
        return false;
    }
    
    public boolean aV() {
        return false;
    }
    
    public void F_() {
        this.despawnIfInvalid();
        if (this.av > 0) {
            for (int k = 0; k < 5; ++k) {
                final double d = this.bS.nextGaussian() * 0.02;
                final double d2 = this.bS.nextGaussian() * 0.02;
                final double d3 = this.bS.nextGaussian() * 0.02;
                final String explosionType = this.bS.nextBoolean() ? "hugeexplosion" : "explode";
                this.bi.a(explosionType, this.bm + this.bS.nextFloat() * this.bG * 2.0f - this.bG, this.bn + this.bS.nextFloat() * this.bH, this.bo + this.bS.nextFloat() * this.bG * 2.0f - this.bG, d, d2, d3);
            }
        }
        super.F_();
    }
    
    protected void d_() {
        if (this.by && this.hasTarget()) {
            this.breakNearbyBlocks();
        }
        if (this.targetEntity == null) {
            this.targetEntity = this.findTarget();
            if (this.targetEntity != null) {
                this.acquireNewPath();
            }
        }
        else if (!this.targetEntity.aE()) {
            this.targetEntity = null;
        }
        else {
            final float targetDistance = this.targetEntity.i((tv)this);
            if (targetDistance > 80.0f) {
                this.targetEntity = null;
            }
            else if (this.h(this.targetEntity)) {
                this.a(this.targetEntity, targetDistance);
            }
        }
        if (!this.H()) {
            this.acquireNewPath();
        }
        final boolean inWater = this.aU();
        final boolean inLava = this.aV();
        cj vec3d = this.H() ? this.pathToEntity.a((tv)this) : null;
        final double d = this.bG * 4.0f;
        while (vec3d != null && vec3d.d(this.bm, vec3d.b, this.bo) < d * d) {
            this.pathToEntity.a();
            if (this.pathToEntity.b()) {
                vec3d = null;
                this.pathToEntity = null;
            }
            else {
                vec3d = this.pathToEntity.a((tv)this);
            }
        }
        this.aZ = false;
        if (vec3d != null) {
            final double d2 = vec3d.a - this.bm;
            final double d3 = vec3d.c - this.bo;
            final double dist = kb.a(d2 * d2 + d3 * d3);
            final int i = kb.b(this.bw.b + 0.5);
            final double d4 = vec3d.b - i;
            final float f2 = (float)(Math.atan2(d3, d2) * 180.0 / 3.1415927410125732) - 90.0f;
            float f3 = f2 - this.bs;
            this.aX = this.bb;
            if (dist > 4.0 && this.chargeCount == 0) {
                this.aW = kb.b(this.bT * 0.3f) * this.bb * 0.6f;
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
            this.bs += f3;
            if (d4 > 0.0) {
                this.aZ = true;
            }
        }
        if (this.intimidateTimer > 0 && this.hasTarget()) {
            this.a(this.targetEntity, 30.0f, 30.0f);
            this.aX = 0.1f;
        }
        if (this.intimidateTimer > 0 && this.hasTarget()) {
            this.a(this.targetEntity, 30.0f, 30.0f);
            this.aX = 0.1f;
        }
        if (this.bS.nextFloat() < 0.8f && (inWater || inLava)) {
            this.aZ = true;
        }
        this.pullSegments();
    }
    
    protected void breakNearbyBlocks() {
        final int minx = kb.b(this.bw.a - 0.5);
        final int miny = kb.b(this.bw.b + 1.01);
        final int minz = kb.b(this.bw.c - 0.5);
        final int maxx = kb.b(this.bw.d + 0.5);
        final int maxy = kb.b(this.bw.e + 0.001);
        final int maxz = kb.b(this.bw.f + 0.5);
        if (this.bi.a(minx, miny, minz, maxx, maxy, maxz)) {
            for (int dx = minx; dx <= maxx; ++dx) {
                for (int dy = miny; dy <= maxy; ++dy) {
                    for (int dz = minz; dz <= maxz; ++dz) {
                        final int i5 = this.bi.a(dx, dy, dz);
                        if (i5 > 0) {
                            this.breakBlock(dx, dy, dz);
                        }
                    }
                }
            }
        }
    }
    
    protected String i() {
        return (this.bS.nextInt(3) != 0) ? "mob.tf.naga.hiss" : "mob.tf.naga.rattle";
    }
    
    protected String j() {
        return "mob.tf.naga.hurt";
    }
    
    protected String k() {
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
                if (this.targetEntity.bw.b > this.bw.e) {
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
            final cj tpoint = this.findCirclePoint(this.targetEntity, 14.0, 3.141592653589793);
            this.pathToEntity = this.bi.a((tv)this, (int)tpoint.a, (int)tpoint.b, (int)tpoint.c, 40.0f, true, true, true, true);
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
            final cj tpoint2 = this.findCirclePoint(this.targetEntity, radius, rotation);
            this.pathToEntity = this.bi.a((tv)this, (int)tpoint2.a, (int)tpoint2.b, (int)tpoint2.c, 40.0f, true, true, true, true);
            if (this.circleCount == 0) {
                this.doIntimidate();
            }
        }
    }
    
    protected void crumbleBelowTarget(final int range) {
        final int floor = (int)this.bw.b;
        final int targetY = (int)this.targetEntity.bw.b;
        if (targetY > floor) {
            final int dx = (int)this.targetEntity.bm + this.bS.nextInt(range) - this.bS.nextInt(range);
            final int dz = (int)this.targetEntity.bo + this.bS.nextInt(range) - this.bS.nextInt(range);
            int dy = targetY - this.bS.nextInt(range) + this.bS.nextInt((range > 1) ? (range - 1) : range);
            if (dy <= floor) {
                dy = targetY;
            }
            if (this.bi.a(dx, dy, dz) != 0) {
                this.breakBlock(dx, dy, dz);
                for (int k = 0; k < 20; ++k) {
                    final double d = this.bS.nextGaussian() * 0.02;
                    final double d2 = this.bS.nextGaussian() * 0.02;
                    final double d3 = this.bS.nextGaussian() * 0.02;
                    this.bi.a("crit", this.bm + this.bS.nextFloat() * this.bG * 2.0f - this.bG, this.bn + this.bS.nextFloat() * this.bH, this.bo + this.bS.nextFloat() * this.bG * 2.0f - this.bG, d, d2, d3);
                }
            }
        }
    }
    
    protected void breakBlock(final int dx, final int dy, final int dz) {
        final int whatsThere = this.bi.a(dx, dy, dz);
        final int whatsMeta = this.bi.c(dx, dy, dz);
        if (whatsThere > 0) {
            vz.m[whatsThere].b(this.bi, dx, dy, dz, whatsMeta, 0);
            this.bi.e(dx, dy, dz, 0);
            this.bi.f(2001, dx, dy, dz, whatsThere + (whatsMeta << 12));
        }
    }
    
    protected void doCircle() {
        this.circleCount += 10 + this.bS.nextInt(10);
        this.goNormal();
    }
    
    protected void doCrumblePlayer() {
        this.crumblePlayerTimer = 20 + this.bS.nextInt(20);
        this.goSlow();
    }
    
    protected void doCharge() {
        this.chargeCount = 4;
        this.goFast();
    }
    
    protected void doIntimidate() {
        this.intimidateTimer += 15 + this.bS.nextInt(10);
        this.goSlow();
    }
    
    protected void goSlow() {
        this.aX = 0.0f;
        this.aW = 0.0f;
        this.bb = 0.1f;
        this.pathToEntity = null;
    }
    
    protected void goNormal() {
        this.bb = 0.6f;
    }
    
    protected void goFast() {
        this.bb = 1.0f;
    }
    
    public boolean e_() {
        return false;
    }
    
    protected cj findCirclePoint(final tv toCircle, final double radius, final double rotation) {
        final double vecx = this.bm - toCircle.bm;
        final double vecz = this.bo - toCircle.bo;
        float rangle = (float)Math.atan2(vecz, vecx);
        rangle += (float)(this.clockwise ? rotation : (-rotation));
        final double dx = kb.b(rangle) * radius;
        final double dz = kb.a(rangle) * radius;
        return cj.b(toCircle.bm + dx, this.bw.b, toCircle.bo + dz);
    }
    
    public boolean hasTarget() {
        return this.targetEntity != null;
    }
    
    protected tv findTarget() {
        final ih entityplayer = this.bi.a((tv)this, 32.0);
        if (entityplayer != null && this.h((tv)entityplayer)) {
            return (tv)entityplayer;
        }
        return null;
    }
    
    public boolean a(final rq damagesource, final int i) {
        if (!super.a(damagesource, i)) {
            return false;
        }
        this.setSegmentsPerHealth();
        final tv entity = damagesource.a();
        if (this.bg == entity || this.bh == entity) {
            return true;
        }
        if (entity != this) {
            this.targetEntity = entity;
        }
        return true;
    }
    
    public boolean a(final tv entity) {
        return entity.a(rq.a((ne)this), this.c);
    }
    
    protected void a(final tv toAttack, final float f) {
        if (this.aw <= 0 && f < 4.0f && toAttack.bw.e > this.bw.b - 2.5 && toAttack.bw.b < this.bw.e + 2.5) {
            this.aw = 20;
            this.a(toAttack);
            if (this.bb > 0.8) {
                toAttack.b_((double)(-kb.a(this.bs * 3.141593f / 180.0f) * 1.0f), 0.1, (double)(kb.b(this.bs * 3.141593f / 180.0f) * 1.0f));
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
            int dx = kb.b(this.bm + this.bS.nextInt(21) - 6.0);
            int dy = kb.b(this.bn + this.bS.nextInt(7) - 3.0);
            int dz = kb.b(this.bo + this.bS.nextInt(21) - 6.0);
            if (this.isLeashed() && (dx > this.homeX + this.LEASH_X || dx < this.homeX - this.LEASH_X || dz > this.homeZ + this.LEASH_Z || dz < this.homeZ - this.LEASH_Z || dy > this.homeY + this.LEASH_Y || dy < this.homeY - this.LEASH_Y)) {
                dx = this.homeX + this.bS.nextInt(21) - this.bS.nextInt(21);
                dy = this.homeY + this.bS.nextInt(7) - this.bS.nextInt(7);
                dz = this.homeZ + this.bS.nextInt(21) - this.bS.nextInt(21);
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
            this.pathToEntity = this.bi.a((tv)this, tx, ty, tz, 80.0f, true, true, true, true);
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
    
    public boolean H() {
        return this.pathToEntity != null;
    }
    
    protected int f() {
        return TFItems.nagaScale.bP;
    }
    
    protected void a(final boolean flag, final int z) {
        final int i = this.f();
        if (i > 0) {
            for (int j = 6 + this.bS.nextInt(6), k = 0; k < j; ++k) {
                this.b(i, 1);
            }
        }
    }
    
    protected void despawnIfInvalid() {
        if (!this.bi.F && this.bi.q == 0) {
            this.despawnMe();
        }
        if (!this.bi.F) {
            for (int i = 0; i < this.segments; ++i) {
                if (this.body != null && this.body[i] != null && this.body[i].bE) {
                    this.despawnMe();
                }
            }
            if (this.isLeashed()) {
                final int distX = Math.abs((int)(this.homeX - this.bm));
                final int distY = Math.abs((int)(this.homeY - this.bn));
                final int distZ = Math.abs((int)(this.homeZ - this.bo));
                if (distX > this.LEASH_X || distY > this.LEASH_Y || distZ > this.LEASH_Z) {
                    this.despawnMe();
                }
            }
        }
    }
    
    protected void despawnMe() {
        if (this.isLeashed()) {
            this.bi.e(this.homeX, this.homeY, this.homeZ, TFBlocks.bossSpawner.bO);
        }
        this.X();
    }
    
    public boolean isLeashed() {
        return this.homeX != 0 && this.homeY != 0 && this.homeZ != 0;
    }
    
    protected void spawnBodySegments() {
        if (!this.bi.F) {
            this.body = new EntityTFNagaSegment[this.segments];
            for (int i = 0; i < this.segments; ++i) {
                (this.body[i] = new EntityTFNagaSegment(this.bi, this, i)).c(this.bm + 0.1 * i, this.bn + 0.5, this.bo + 0.1 * i, this.bS.nextFloat() * 360.0f, 0.0f);
                this.bi.b((tv)this.body[i]);
            }
        }
    }
    
    protected void pullSegments() {
        if (this.body == null || this.body.length < this.segments) {
            this.spawnBodySegments();
        }
        if (!this.bi.F) {
            this.body[0].pullTowards((tv)this);
            for (int i = 1; i < this.segments; ++i) {
                this.body[i].pullTowards((tv)this.body[i - 1]);
            }
        }
    }
    
    public void b(final ph nbttagcompound) {
        nbttagcompound.a("Home", (jz)this.a(new double[] { this.homeX, this.homeY, this.homeZ }));
        super.b(nbttagcompound);
    }
    
    public void a(final ph nbttagcompound) {
        super.a(nbttagcompound);
        final tx homelist = nbttagcompound.n("Home");
        this.setHome((int)((ud)homelist.a(0)).a, (int)((ud)homelist.a(1)).a, (int)((ud)homelist.a(2)).a);
        this.setSegmentsPerHealth();
    }
    
    public void a(final rq par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.b() instanceof ih) {
            ((ih)par1DamageSource.b()).a((xo)TFAchievementPage.twilightHunter);
            ((ih)par1DamageSource.b()).a((xo)TFAchievementPage.twilightNaga);
        }
    }
}
