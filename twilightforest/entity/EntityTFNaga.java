// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFAchievementPage;
import twilightforest.block.TFBlocks;
import twilightforest.item.TFItems;

public class EntityTFNaga extends rv implements rq, qp
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
    protected ajc pathToEntity;
    protected mp targetEntity;
    int circleCount;
    int intimidateTimer;
    int crumblePlayerTimer;
    int chargeCount;
    boolean clockwise;
    public int ticksSinceDamaged;
    
    public EntityTFNaga(final zv world) {
        super(world);
        this.currentSegments = 0;
        this.LEASH_X = 46;
        this.LEASH_Y = 7;
        this.LEASH_Z = 46;
        this.ticksSinceDamaged = 0;
        this.aH = "/mods/twilightforest/textures/model/nagahead.png";
        this.a(1.75f, 3.0f);
        this.bI = 0.6f;
        this.Y = 2.0f;
        this.aS = this.aW();
        this.segmentHealth = this.aW() / 10;
        this.setSegmentsPerHealth();
        this.be = 217;
        this.am = true;
        this.circleCount = 15;
    }
    
    protected void a() {
        super.a();
        this.ah.a(16, (Object)new Integer(this.aW()));
    }
    
    public int c(final mp par1Entity) {
        return 6;
    }
    
    public int aW() {
        if (this.q == null) {
            return 200;
        }
        switch (this.q.r) {
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
        int newSegments = this.aS / this.segmentHealth + ((this.aS > 0) ? 2 : 0);
        if (newSegments < 0) {
            newSegments = 0;
        }
        if (newSegments > EntityTFNaga.MAX_SEGMENTS) {
            newSegments = EntityTFNaga.MAX_SEGMENTS;
        }
        if (this.q != null && !this.q.I && newSegments != oldSegments) {
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
        this.aO = 0.6f - this.currentSegments / 12.0f * 0.2f;
        this.aP = this.aO / 2.0f;
        for (int i = 0; i < this.currentSegments; ++i) {
            if (this.body != null && this.body.length > i && this.body[i] != null) {
                this.body[i].aO = this.aO * 1.25f;
                this.body[i].aP = this.aP * 1.25f;
            }
        }
    }
    
    public boolean f_() {
        return false;
    }
    
    public boolean I() {
        return false;
    }
    
    public void l_() {
        this.despawnIfInvalid();
        if (this.aZ > 0) {
            for (int k = 0; k < 5; ++k) {
                final double d = this.ab.nextGaussian() * 0.02;
                final double d2 = this.ab.nextGaussian() * 0.02;
                final double d3 = this.ab.nextGaussian() * 0.02;
                final String explosionType = this.ab.nextBoolean() ? "hugeexplosion" : "explode";
                this.q.a(explosionType, this.u + this.ab.nextFloat() * this.O * 2.0f - this.O, this.v + this.ab.nextFloat() * this.P, this.w + this.ab.nextFloat() * this.O * 2.0f - this.O, d, d2, d3);
            }
        }
        ++this.ticksSinceDamaged;
        if (!this.q.I && this.ticksSinceDamaged > EntityTFNaga.TICKS_BEFORE_HEALING && this.ticksSinceDamaged % 20 == 0) {
            this.j(1);
            this.setSegmentsPerHealth();
        }
        if (!this.q.I) {
            this.ah.b(16, (Object)this.aS);
        }
        super.l_();
    }
    
    protected void bq() {
        if (this.G && this.hasTarget()) {
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
        else if (!this.targetEntity.R()) {
            this.targetEntity = null;
        }
        else {
            final float targetDistance = this.targetEntity.d((mp)this);
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
        final boolean inWater = this.G();
        final boolean inLava = this.I();
        aqw vec3d = this.k() ? this.pathToEntity.a((mp)this) : null;
        final double d = this.O * 4.0f;
        while (vec3d != null && vec3d.d(this.u, vec3d.d, this.w) < d * d) {
            this.pathToEntity.a();
            if (this.pathToEntity.b()) {
                vec3d = null;
                this.pathToEntity = null;
            }
            else {
                vec3d = this.pathToEntity.a((mp)this);
            }
        }
        this.bG = false;
        if (vec3d != null) {
            final double d2 = vec3d.c - this.u;
            final double d3 = vec3d.e - this.w;
            final double dist = kx.a(d2 * d2 + d3 * d3);
            final int i = kx.c(this.E.b + 0.5);
            final double d4 = vec3d.d - i;
            final float f2 = (float)(Math.atan2(d3, d2) * 180.0 / 3.1415927410125732) - 90.0f;
            float f3 = f2 - this.A;
            this.bE = this.bI;
            if (dist > 4.0 && this.chargeCount == 0) {
                this.bD = kx.b(this.bi * 0.3f) * this.bI * 0.6f;
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
            this.A += f3;
            if (d4 > 0.0) {
                this.bG = true;
            }
        }
        if (this.intimidateTimer > 0 && this.hasTarget()) {
            this.a(this.targetEntity, 30.0f, 30.0f);
            this.bE = 0.1f;
        }
        if (this.intimidateTimer > 0 && this.hasTarget()) {
            this.a(this.targetEntity, 30.0f, 30.0f);
            this.bE = 0.1f;
        }
        if (this.ab.nextFloat() < 0.8f && (inWater || inLava)) {
            this.bG = true;
        }
        this.pullSegments();
    }
    
    protected void breakNearbyBlocks() {
        final int minx = kx.c(this.E.a - 0.5);
        final int miny = kx.c(this.E.b + 1.01);
        final int minz = kx.c(this.E.c - 0.5);
        final int maxx = kx.c(this.E.d + 0.5);
        final int maxy = kx.c(this.E.e + 0.001);
        final int maxz = kx.c(this.E.f + 0.5);
        if (this.q.e(minx, miny, minz, maxx, maxy, maxz)) {
            for (int dx = minx; dx <= maxx; ++dx) {
                for (int dy = miny; dy <= maxy; ++dy) {
                    for (int dz = minz; dz <= maxz; ++dz) {
                        final int i5 = this.q.a(dx, dy, dz);
                        if (i5 > 0) {
                            this.breakBlock(dx, dy, dz);
                        }
                    }
                }
            }
        }
    }
    
    protected String bb() {
        return (this.ab.nextInt(3) != 0) ? "mob.tf.naga.hiss" : "mob.tf.naga.rattle";
    }
    
    protected String bc() {
        return "mob.tf.naga.hurt";
    }
    
    protected String bd() {
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
                if (this.targetEntity.E.b > this.E.e) {
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
            final aqw tpoint = this.findCirclePoint(this.targetEntity, 14.0, 3.141592653589793);
            this.pathToEntity = this.q.a((mp)this, (int)tpoint.c, (int)tpoint.d, (int)tpoint.e, 40.0f, true, true, true, true);
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
            final aqw tpoint2 = this.findCirclePoint(this.targetEntity, radius, rotation);
            this.pathToEntity = this.q.a((mp)this, (int)tpoint2.c, (int)tpoint2.d, (int)tpoint2.e, 40.0f, true, true, true, true);
            if (this.circleCount == 0) {
                this.doIntimidate();
            }
        }
    }
    
    protected void crumbleBelowTarget(final int range) {
        final int floor = (int)this.E.b;
        final int targetY = (int)this.targetEntity.E.b;
        if (targetY > floor) {
            final int dx = (int)this.targetEntity.u + this.ab.nextInt(range) - this.ab.nextInt(range);
            final int dz = (int)this.targetEntity.w + this.ab.nextInt(range) - this.ab.nextInt(range);
            int dy = targetY - this.ab.nextInt(range) + this.ab.nextInt((range > 1) ? (range - 1) : range);
            if (dy <= floor) {
                dy = targetY;
            }
            if (this.q.a(dx, dy, dz) != 0) {
                this.breakBlock(dx, dy, dz);
                for (int k = 0; k < 20; ++k) {
                    final double d = this.ab.nextGaussian() * 0.02;
                    final double d2 = this.ab.nextGaussian() * 0.02;
                    final double d3 = this.ab.nextGaussian() * 0.02;
                    this.q.a("crit", this.u + this.ab.nextFloat() * this.O * 2.0f - this.O, this.v + this.ab.nextFloat() * this.P, this.w + this.ab.nextFloat() * this.O * 2.0f - this.O, d, d2, d3);
                }
            }
        }
    }
    
    protected void breakBlock(final int dx, final int dy, final int dz) {
        final int whatsThere = this.q.a(dx, dy, dz);
        final int whatsMeta = this.q.h(dx, dy, dz);
        if (whatsThere > 0) {
            aou.r[whatsThere].c(this.q, dx, dy, dz, whatsMeta, 0);
            this.q.f(dx, dy, dz, 0, 0, 2);
            this.q.e(2001, dx, dy, dz, whatsThere + (whatsMeta << 12));
        }
    }
    
    protected void doCircle() {
        this.circleCount += 10 + this.ab.nextInt(10);
        this.goNormal();
    }
    
    protected void doCrumblePlayer() {
        this.crumblePlayerTimer = 20 + this.ab.nextInt(20);
        this.goSlow();
    }
    
    protected void doCharge() {
        this.chargeCount = 4;
        this.goFast();
    }
    
    protected void doIntimidate() {
        this.intimidateTimer += 15 + this.ab.nextInt(10);
        this.goSlow();
    }
    
    protected void goSlow() {
        this.bE = 0.0f;
        this.bD = 0.0f;
        this.bI = 0.1f;
        this.pathToEntity = null;
    }
    
    protected void goNormal() {
        this.bI = 0.6f;
    }
    
    protected void goFast() {
        this.bI = 1.0f;
    }
    
    public boolean L() {
        return false;
    }
    
    protected aqw findCirclePoint(final mp toCircle, final double radius, final double rotation) {
        final double vecx = this.u - toCircle.u;
        final double vecz = this.w - toCircle.w;
        float rangle = (float)Math.atan2(vecz, vecx);
        rangle += (float)(this.clockwise ? rotation : (-rotation));
        final double dx = kx.b(rangle) * radius;
        final double dz = kx.a(rangle) * radius;
        return this.q.T().a(toCircle.u + dx, this.E.b, toCircle.w + dz);
    }
    
    public boolean hasTarget() {
        return this.targetEntity != null;
    }
    
    protected mp findTarget() {
        final sk entityplayer = this.q.a((mp)this, 32.0);
        if (entityplayer != null && this.n((mp)entityplayer) && this.isEntityWithinHomeArea((mp)entityplayer)) {
            return (mp)entityplayer;
        }
        return null;
    }
    
    public boolean a(final mg damagesource, final int i) {
        if (damagesource.h() != null && !this.isEntityWithinHomeArea(damagesource.h())) {
            return false;
        }
        if (damagesource.i() != null && !this.isEntityWithinHomeArea(damagesource.i())) {
            return false;
        }
        if (super.a(damagesource, i)) {
            this.setSegmentsPerHealth();
            final mp entity = damagesource.i();
            if (entity != this) {
                this.targetEntity = entity;
            }
            this.ticksSinceDamaged = 0;
            return true;
        }
        return false;
    }
    
    protected void a(final mp toAttack, final float f) {
        if (this.ba <= 0 && f < 4.0f && toAttack.E.e > this.E.b - 2.5 && toAttack.E.b < this.E.e + 2.5) {
            this.ba = 20;
            this.m(toAttack);
            if (this.bI > 0.8) {
                toAttack.g((double)(-kx.a(this.A * 3.141593f / 180.0f) * 1.0f), 0.1, (double)(kx.b(this.A * 3.141593f / 180.0f) * 1.0f));
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
            int dx = kx.c(this.u + this.ab.nextInt(21) - 6.0);
            int dy = kx.c(this.v + this.ab.nextInt(7) - 3.0);
            int dz = kx.c(this.w + this.ab.nextInt(21) - 6.0);
            if (!this.d(dx, dy, dz)) {
                dx = this.aM().a + this.ab.nextInt(21) - this.ab.nextInt(21);
                dy = this.aM().b + this.ab.nextInt(7) - this.ab.nextInt(7);
                dz = this.aM().c + this.ab.nextInt(21) - this.ab.nextInt(21);
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
            this.pathToEntity = this.q.a((mp)this, tx, ty, tz, 80.0f, true, true, true, true);
        }
    }
    
    public float a(final int i, final int j, final int k) {
        if (!this.d(i, j, k)) {
            return Float.MIN_VALUE;
        }
        return 0.0f;
    }
    
    public boolean k() {
        return this.pathToEntity != null;
    }
    
    protected int be() {
        return TFItems.nagaScale.cp;
    }
    
    protected void a(final boolean flag, final int z) {
        final int i = this.be();
        if (i > 0) {
            for (int j = 6 + this.ab.nextInt(6), k = 0; k < j; ++k) {
                this.b(i, 1);
            }
        }
        this.a(new wg(TFItems.trophy, 1, 1), 0.0f);
    }
    
    protected void despawnIfInvalid() {
        if (!this.q.I && this.q.r == 0) {
            this.despawnMe();
        }
        if (!this.q.I) {
            for (int i = 0; i < this.currentSegments; ++i) {
                if (this.body != null && this.body[i] != null && this.body[i].M) {
                    this.despawnMe();
                }
            }
            if (!this.aL()) {}
        }
    }
    
    protected void despawnMe() {
        if (this.isLeashed()) {
            final t home = this.aM();
            this.q.f(home.a, home.b, home.c, TFBlocks.bossSpawner.cz, 0, 2);
        }
        this.w();
    }
    
    public boolean isLeashed() {
        return this.aN() > -1.0f;
    }
    
    public boolean d(final int x, final int y, final int z) {
        if (this.aN() == -1.0f) {
            return true;
        }
        final int distX = Math.abs(this.aM().a - x);
        final int distY = Math.abs(this.aM().b - y);
        final int distZ = Math.abs(this.aM().c - z);
        return distX <= this.LEASH_X && distY <= this.LEASH_Y && distZ <= this.LEASH_Z;
    }
    
    public boolean isEntityWithinHomeArea(final mp entity) {
        return this.d(kx.c(entity.u), kx.c(entity.v), kx.c(entity.w));
    }
    
    protected void spawnBodySegments() {
        if (!this.q.I) {
            if (this.body == null) {
                this.body = new EntityTFNagaSegment[EntityTFNaga.MAX_SEGMENTS];
            }
            for (int i = 0; i < this.currentSegments; ++i) {
                if (this.body[i] == null || this.body[i].M) {
                    (this.body[i] = new EntityTFNagaSegment(this.q, this, i)).b(this.u + 0.1 * i, this.v + 0.5, this.w + 0.1 * i, this.ab.nextFloat() * 360.0f, 0.0f);
                    this.q.d((mp)this.body[i]);
                }
            }
        }
    }
    
    protected void pullSegments() {
        this.spawnBodySegments();
        if (!this.q.I) {
            this.body[0].pullTowards((mp)this);
            for (int i = 1; i < this.currentSegments; ++i) {
                this.body[i].pullTowards((mp)this.body[i - 1]);
            }
        }
    }
    
    public void b(final bs nbttagcompound) {
        final t home = this.aM();
        nbttagcompound.a("Home", (cf)this.a(new double[] { home.a, home.b, home.c }));
        nbttagcompound.a("HasHome", this.aP());
        super.b(nbttagcompound);
    }
    
    public void a(final bs nbttagcompound) {
        super.a(nbttagcompound);
        final ca homelist = nbttagcompound.m("Home");
        this.b((int)((bv)homelist.b(0)).a, (int)((bv)homelist.b(1)).a, (int)((bv)homelist.b(2)).a, this.LEASH_X);
        if (!nbttagcompound.n("HasHome")) {
            this.aO();
        }
        this.setSegmentsPerHealth();
    }
    
    public void a(final mg par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof sk) {
            ((sk)par1DamageSource.h()).a((ka)TFAchievementPage.twilightHunter);
            ((sk)par1DamageSource.h()).a((ka)TFAchievementPage.twilightNaga);
        }
    }
    
    public float getMoveSpeed() {
        return this.bI;
    }
    
    public int b() {
        return this.ah.c(16);
    }
    
    static {
        EntityTFNaga.TICKS_BEFORE_HEALING = 600;
        EntityTFNaga.MAX_SEGMENTS = 12;
    }
}
