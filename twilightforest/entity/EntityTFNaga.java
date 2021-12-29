// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFAchievementPage;
import twilightforest.block.TFBlocks;
import twilightforest.item.TFItems;

public class EntityTFNaga extends tl implements tg, sf, sg
{
    private static int TICKS_BEFORE_HEALING;
    private static int MAX_SEGMENTS;
    int currentSegments;
    int segmentHealth;
    int LEASH_X;
    int LEASH_Y;
    int LEASH_Z;
    EntityTFNagaSegment[] body;
    protected alc bp;
    protected nm targetEntity;
    int circleCount;
    int intimidateTimer;
    int crumblePlayerTimer;
    int chargeCount;
    boolean clockwise;
    public int ticksSinceDamaged;
    
    public EntityTFNaga(final abv world) {
        super(world);
        this.currentSegments = 0;
        this.LEASH_X = 46;
        this.LEASH_Y = 7;
        this.LEASH_Z = 46;
        this.ticksSinceDamaged = 0;
        this.a(1.75f, 3.0f);
        this.Y = 2.0f;
        this.g((float)this.getMaxHealth());
        this.segmentHealth = this.getMaxHealth() / 10;
        this.setSegmentsPerHealth();
        this.b = 217;
        this.am = true;
        this.circleCount = 15;
        this.body = new EntityTFNagaSegment[EntityTFNaga.MAX_SEGMENTS];
        for (int i = 0; i < this.body.length; ++i) {
            world.d((nm)(this.body[i] = new EntityTFNagaSegment(this, i)));
        }
        this.goNormal();
    }
    
    protected void a() {
        super.a();
    }
    
    protected boolean be() {
        return true;
    }
    
    public int getMaxHealth() {
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
    
    protected void ay() {
        super.ay();
        this.a(to.a).a((double)this.getMaxHealth());
        this.a(to.d).a(2.0);
        this.a(to.e).a(6.0);
    }
    
    protected int setSegmentsPerHealth() {
        final int oldSegments = this.currentSegments;
        int newSegments = (int)(this.aM() / this.segmentHealth + ((this.aM() > 0.0f) ? 2 : 0));
        if (newSegments < 0) {
            newSegments = 0;
        }
        if (newSegments > EntityTFNaga.MAX_SEGMENTS) {
            newSegments = EntityTFNaga.MAX_SEGMENTS;
        }
        if (newSegments != oldSegments) {
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
        }
        this.currentSegments = newSegments;
        this.setMovementFactorPerSegments();
        return this.currentSegments;
    }
    
    protected void setMovementFactorPerSegments() {
        final float movementFactor = 0.6f - this.currentSegments / 12.0f * 0.2f;
        this.a(to.d).a((double)movementFactor);
    }
    
    public boolean e_() {
        return false;
    }
    
    public boolean I() {
        return false;
    }
    
    public void l_() {
        this.despawnIfInvalid();
        if (this.aB > 0) {
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
            this.f(1.0f);
        }
        this.setSegmentsPerHealth();
        super.l_();
        this.moveSegments();
        for (int i = 0; i < this.body.length; ++i) {
            if (!this.body[i].ai && !this.q.I) {
                this.q.d((nm)this.body[i]);
            }
        }
    }
    
    protected void bh() {
        super.bh();
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
        else if (!this.targetEntity.S()) {
            this.targetEntity = null;
        }
        else {
            final float targetDistance = this.targetEntity.d((nm)this);
            if (targetDistance > 80.0f) {
                this.targetEntity = null;
            }
            else if (this.o(this.targetEntity)) {
                this.a(this.targetEntity, targetDistance);
            }
        }
        if (!this.bM()) {
            this.acquireNewPath();
        }
        final boolean inWater = this.G();
        final boolean inLava = this.I();
        asz vec3d = this.bM() ? this.bp.a((nm)this) : null;
        final double d = this.O * 4.0f;
        while (vec3d != null && vec3d.d(this.u, vec3d.d, this.w) < d * d) {
            this.bp.a();
            if (this.bp.b()) {
                vec3d = null;
                this.bp = null;
            }
            else {
                vec3d = this.bp.a((nm)this);
            }
        }
        this.bd = false;
        if (vec3d != null) {
            final double d2 = vec3d.c - this.u;
            final double d3 = vec3d.e - this.w;
            final double dist = lr.a(d2 * d2 + d3 * d3);
            final int i = lr.c(this.E.b + 0.5);
            final double d4 = vec3d.d - i;
            final float f2 = (float)(Math.atan2(d3, d2) * 180.0 / 3.1415927410125732) - 90.0f;
            float f3 = f2 - this.A;
            this.bf = this.getMoveSpeed();
            this.i(0.5f);
            if (dist > 4.0 && this.chargeCount == 0) {
                this.be = lr.b(this.ac * 0.3f) * this.getMoveSpeed() * 0.6f;
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
            if (d4 > 0.6) {
                this.bd = true;
            }
        }
        if (this.intimidateTimer > 0 && this.hasTarget()) {
            this.a(this.targetEntity, 30.0f, 30.0f);
            this.bf = 0.1f;
        }
        if (this.intimidateTimer > 0 && this.hasTarget()) {
            this.a(this.targetEntity, 30.0f, 30.0f);
            this.bf = 0.1f;
        }
        if (this.ab.nextFloat() < 0.8f && (inWater || inLava)) {
            this.bd = true;
        }
    }
    
    private float getMoveSpeed() {
        return 0.5f;
    }
    
    private void setMoveSpeed(final float f) {
        this.i(f);
    }
    
    protected void breakNearbyBlocks() {
        final int minx = lr.c(this.E.a - 0.5);
        final int miny = lr.c(this.E.b + 1.01);
        final int minz = lr.c(this.E.c - 0.5);
        final int maxx = lr.c(this.E.d + 0.5);
        final int maxy = lr.c(this.E.e + 0.001);
        final int maxz = lr.c(this.E.f + 0.5);
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
    
    protected String r() {
        return (this.ab.nextInt(3) != 0) ? "TwilightForest:mob.naga.hiss" : "TwilightForest:mob.naga.rattle";
    }
    
    protected String aN() {
        return "TwilightForest:mob.naga.hurt";
    }
    
    protected String aO() {
        return "TwilightForest:mob.naga.hurt";
    }
    
    protected void acquireNewPath() {
        if (!this.hasTarget()) {
            this.wanderRandomly();
            return;
        }
        if (this.intimidateTimer > 0) {
            this.bp = null;
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
            this.bp = null;
            --this.crumblePlayerTimer;
            this.crumbleBelowTarget(2);
            this.crumbleBelowTarget(3);
            if (this.crumblePlayerTimer == 0) {
                this.doCharge();
            }
        }
        if (this.chargeCount > 0) {
            --this.chargeCount;
            final asz tpoint = this.findCirclePoint(this.targetEntity, 14.0, 3.141592653589793);
            this.bp = this.q.a((nm)this, lr.c(tpoint.c), lr.c(tpoint.d), lr.c(tpoint.e), 40.0f, true, true, true, true);
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
            final asz tpoint2 = this.findCirclePoint(this.targetEntity, radius, rotation);
            this.bp = this.q.a((nm)this, (int)tpoint2.c, (int)tpoint2.d, (int)tpoint2.e, 40.0f, true, true, true, true);
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
            aqw.s[whatsThere].c(this.q, dx, dy, dz, whatsMeta, 0);
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
        this.be = 0.0f;
        this.setMoveSpeed(0.1f);
        this.bp = null;
    }
    
    protected void goNormal() {
        this.setMoveSpeed(0.6f);
    }
    
    protected void goFast() {
        this.setMoveSpeed(1.0f);
    }
    
    public boolean L() {
        return false;
    }
    
    protected asz findCirclePoint(final nm toCircle, final double radius, final double rotation) {
        final double vecx = this.u - toCircle.u;
        final double vecz = this.w - toCircle.w;
        float rangle = (float)Math.atan2(vecz, vecx);
        rangle += (float)(this.clockwise ? rotation : (-rotation));
        final double dx = lr.b(rangle) * radius;
        final double dz = lr.a(rangle) * radius;
        final double dy = Math.min(this.E.b, toCircle.v);
        return this.q.V().a(toCircle.u + dx, dy, toCircle.w + dz);
    }
    
    public boolean hasTarget() {
        return this.targetEntity != null;
    }
    
    protected nm findTarget() {
        final ue entityplayer = this.q.a((nm)this, 32.0);
        if (entityplayer != null && this.o((nm)entityplayer) && this.isEntityWithinHomeArea((nm)entityplayer)) {
            return (nm)entityplayer;
        }
        return null;
    }
    
    public boolean a(final na damagesource, final float i) {
        if (damagesource.h() != null && !this.isEntityWithinHomeArea(damagesource.h())) {
            return false;
        }
        if (damagesource.i() != null && !this.isEntityWithinHomeArea(damagesource.i())) {
            return false;
        }
        if (super.a(damagesource, i)) {
            this.setSegmentsPerHealth();
            final nm entity = damagesource.i();
            if (entity != this) {
                this.targetEntity = entity;
            }
            this.ticksSinceDamaged = 0;
            return true;
        }
        return false;
    }
    
    protected void a(final nm toAttack, final float f) {
        if (this.aC <= 0 && f < 4.0f && toAttack.E.e > this.E.b - 2.5 && toAttack.E.b < this.E.e + 2.5) {
            this.aC = 20;
            this.m(toAttack);
            if (this.getMoveSpeed() > 0.8) {
                toAttack.g((double)(-lr.a(this.A * 3.141593f / 180.0f) * 1.0f), 0.1, (double)(lr.b(this.A * 3.141593f / 180.0f) * 1.0f));
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
            int dx = lr.c(this.u + this.ab.nextInt(21) - 6.0);
            int dy = lr.c(this.v + this.ab.nextInt(7) - 3.0);
            int dz = lr.c(this.w + this.ab.nextInt(21) - 6.0);
            if (!this.isWithinHomeDistance(dx, dy, dz)) {
                dx = this.getHomePosition().a + this.ab.nextInt(21) - this.ab.nextInt(21);
                dy = this.getHomePosition().b + this.ab.nextInt(7) - this.ab.nextInt(7);
                dz = this.getHomePosition().c + this.ab.nextInt(21) - this.ab.nextInt(21);
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
            this.bp = this.q.a((nm)this, tx, ty, tz, 80.0f, true, true, true, true);
        }
    }
    
    public float a(final int i, final int j, final int k) {
        if (!this.isWithinHomeDistance(i, j, k)) {
            return Float.MIN_VALUE;
        }
        return 0.0f;
    }
    
    public boolean bM() {
        return this.bp != null;
    }
    
    protected int s() {
        return TFItems.nagaScale.cv;
    }
    
    protected void b(final boolean flag, final int z) {
        final int i = this.s();
        if (i > 0) {
            for (int j = 6 + this.ab.nextInt(6), k = 0; k < j; ++k) {
                this.b(i, 1);
            }
        }
        this.a(new yd(TFItems.trophy, 1, 1), 0.0f);
    }
    
    protected void despawnIfInvalid() {
        if (!this.q.I && this.q.r == 0) {
            this.despawnMe();
        }
    }
    
    protected void despawnMe() {
        if (this.isLeashed()) {
            final t home = this.getHomePosition();
            this.q.f(home.a, home.b, home.c, TFBlocks.bossSpawner.cF, 0, 2);
        }
        this.w();
    }
    
    public boolean isLeashed() {
        return this.getMaximumHomeDistance() > -1.0f;
    }
    
    public boolean isWithinHomeDistance(final int x, final int y, final int z) {
        if (this.getMaximumHomeDistance() == -1.0f) {
            return true;
        }
        final int distX = Math.abs(this.getHomePosition().a - x);
        final int distY = Math.abs(this.getHomePosition().b - y);
        final int distZ = Math.abs(this.getHomePosition().c - z);
        return distX <= this.LEASH_X && distY <= this.LEASH_Y && distZ <= this.LEASH_Z;
    }
    
    public boolean isEntityWithinHomeArea(final nm entity) {
        return this.isWithinHomeDistance(lr.c(entity.u), lr.c(entity.v), lr.c(entity.w));
    }
    
    protected void spawnBodySegments() {
        if (!this.q.I) {
            if (this.body == null) {
                this.body = new EntityTFNagaSegment[EntityTFNaga.MAX_SEGMENTS];
            }
            for (int i = 0; i < this.currentSegments; ++i) {
                if (this.body[i] == null || this.body[i].M) {
                    (this.body[i] = new EntityTFNagaSegment(this, i)).b(this.u + 0.1 * i, this.v + 0.5, this.w + 0.1 * i, this.ab.nextFloat() * 360.0f, 0.0f);
                    this.q.d((nm)this.body[i]);
                }
            }
        }
    }
    
    protected void moveSegments() {
        for (int i = 0; i < this.currentSegments; ++i) {
            nm leader;
            if (i == 0) {
                leader = (nm)this;
            }
            else {
                leader = this.body[i - 1];
            }
            final double followX = leader.u;
            final double followY = leader.v;
            final double followZ = leader.w;
            final float angle = (leader.A + 180.0f) * 3.141593f / 180.0f;
            final double straightenForce = 0.05 + 1.0 / (float)(i + 1) * 0.5;
            final double idealX = -lr.a(angle) * straightenForce;
            final double idealZ = lr.b(angle) * straightenForce;
            asz diff = this.q.V().a(this.body[i].u - followX, this.body[i].v - followY, this.body[i].w - followZ);
            diff = diff.a();
            diff = diff.c(idealX, 0.0, idealZ);
            diff = diff.a();
            final double f = 2.0;
            final double destX = followX + f * diff.c;
            final double destY = followY + f * diff.d;
            final double destZ = followZ + f * diff.e;
            this.body[i].b(destX, destY, destZ);
            this.body[i].x = f * diff.c;
            this.body[i].y = f * diff.d;
            this.body[i].z = f * diff.e;
            final double distance = lr.a(diff.c * diff.c + diff.e * diff.e);
            if (i == 0) {
                final asz asz = diff;
                asz.d -= 0.15;
            }
            this.body[i].b((float)(Math.atan2(diff.e, diff.c) * 180.0 / 3.141592653589793) + 90.0f, -(float)(Math.atan2(diff.d, distance) * 180.0 / 3.141592653589793));
        }
    }
    
    public void b(final bx nbttagcompound) {
        final t home = this.getHomePosition();
        nbttagcompound.a("Home", (ck)this.a(new double[] { home.a, home.b, home.c }));
        nbttagcompound.a("HasHome", this.hasHome());
        super.b(nbttagcompound);
    }
    
    public void a(final bx nbttagcompound) {
        super.a(nbttagcompound);
        final cf homelist = nbttagcompound.m("Home");
        this.setHomeArea((int)((ca)homelist.b(0)).a, (int)((ca)homelist.b(1)).a, (int)((ca)homelist.b(2)).a, this.LEASH_X);
        if (!nbttagcompound.n("HasHome")) {
            this.detachHome();
        }
        this.setSegmentsPerHealth();
    }
    
    public void a(final na par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof ue) {
            ((ue)par1DamageSource.h()).a((kt)TFAchievementPage.twilightHunter);
            ((ue)par1DamageSource.h()).a((kt)TFAchievementPage.twilightNaga);
        }
    }
    
    public abv b() {
        return this.q;
    }
    
    public boolean a(final sh entitydragonpart, final na damagesource, final float i) {
        return false;
    }
    
    public nm[] an() {
        return this.body;
    }
    
    public void setHomeArea(final int par1, final int par2, final int par3, final int par4) {
        this.b(par1, par2, par3, par4);
    }
    
    public t getHomePosition() {
        return this.bP();
    }
    
    public float getMaximumHomeDistance() {
        return this.bQ();
    }
    
    public void detachHome() {
        this.bR();
    }
    
    public boolean hasHome() {
        return this.bS();
    }
    
    static {
        EntityTFNaga.TICKS_BEFORE_HEALING = 600;
        EntityTFNaga.MAX_SEGMENTS = 12;
    }
}
