// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFLich extends yt
{
    private static final aai defaultHeldItem;
    
    public EntityTFLich(final wz world) {
        super(world);
        this.a(1.1f, 2.5f);
        this.bm = "/twilightforest/twilightlich64.png";
        this.H = 0.25f;
    }
    
    public int d() {
        return 50;
    }
    
    public aai ae() {
        return EntityTFLich.defaultHeldItem;
    }
    
    public void e() {
        final int factor = (80 - this.bE) / 10;
        for (int particles = (factor > 0) ? this.U.nextInt(factor) : 0, j1 = 0; j1 < particles; ++j1) {
            final float sparkle = (80 - this.bE) / 20.0f;
            final float f = (this.U.nextFloat() - 0.5f) * sparkle;
            final float f2 = (this.U.nextFloat() - 0.5f) * sparkle;
            final float f3 = (this.U.nextFloat() - 0.5f) * sparkle;
            final float angle = this.bd * 3.141593f / 180.0f;
            final double dx = this.o + gh.b(angle) * 0.65;
            final double dy = this.p + this.J * 0.82;
            final double dz = this.q + gh.a(angle) * 0.65;
            this.k.a("mobSpell", dx, dy, dz, (double)f, (double)f2, (double)f3);
        }
        super.e();
    }
    
    protected void a(final nk targetedEntity, final float f) {
        if (this.bE == 60) {
            this.teleportToSightOfEntity(targetedEntity);
        }
        if (this.m(targetedEntity) && this.bE == 0 && f < 20.0f) {
            final float bodyFacingAngle = this.bd * 3.141593f / 180.0f;
            final double sx = this.o + gh.b(bodyFacingAngle) * 0.65;
            final double sy = this.p + this.J * 0.82;
            final double sz = this.q + gh.a(bodyFacingAngle) * 0.65;
            final double tx = targetedEntity.o - sx;
            final double ty = targetedEntity.y.b + targetedEntity.J / 2.0f - (this.p + this.J / 2.0f);
            final double tz = targetedEntity.q - sz;
            this.k.a((nk)this, "mob.ghast.fireball", this.A_(), (this.U.nextFloat() - this.U.nextFloat()) * 0.2f + 1.0f);
            final EntityTFProjectile projectile = new EntityTFLichBolt(this.k, (acl)this, tx, ty, tz);
            projectile.c(sx, sy, sz, this.u, this.v);
            this.k.a((nk)projectile);
            this.bE = 80;
        }
        this.ap = true;
    }
    
    protected boolean teleportRandomly() {
        final double d = this.o + (this.U.nextDouble() - 0.5) * 64.0;
        final double d2 = this.p + (this.U.nextInt(64) - 32);
        final double d3 = this.q + (this.U.nextDouble() - 0.5) * 64.0;
        return this.teleportTo(d, d2, d3);
    }
    
    protected boolean teleportToEntity(final nk entity) {
        bm vec3d = bm.b(this.o - entity.o, this.y.b + this.J / 2.0f - entity.p + entity.H(), this.q - entity.q);
        vec3d = vec3d.c();
        final double d = 16.0;
        final double d2 = this.o + (this.U.nextDouble() - 0.5) * 8.0 - vec3d.a * d;
        final double d3 = this.p + (this.U.nextInt(16) - 8) - vec3d.b * d;
        final double d4 = this.q + (this.U.nextDouble() - 0.5) * 8.0 - vec3d.c * d;
        return this.teleportTo(d2, d3, d4);
    }
    
    protected boolean teleportToSightOfEntity(final nk entity) {
        double tx = 0.0;
        double ty = 0.0;
        double tz = 0.0;
        final int tries = 100;
        for (int i = 0; i < tries; ++i) {
            tx = entity.o + (this.U.nextDouble() - 0.5) * 16.0;
            ty = entity.p + (this.U.nextInt(16) - 8);
            tz = entity.q + (this.U.nextDouble() - 0.5) * 16.0;
            if (this.canEntitySee(entity, tx, ty, tz)) {
                break;
            }
        }
        if (tries == 99) {
            return false;
        }
        if (this.teleportTo(tx, ty, tz)) {
            this.a(entity, 100.0f, 100.0f);
            return true;
        }
        return false;
    }
    
    protected boolean canEntitySee(final nk entity, final double dx, final double dy, final double dz) {
        return this.k.a(bm.b(entity.o, entity.p + entity.H(), entity.q), bm.b(dx, dy, dz)) == null;
    }
    
    protected boolean teleportTo(final double d, final double d1, final double d2) {
        final double d3 = this.o;
        final double d4 = this.p;
        final double d5 = this.q;
        this.o = d;
        this.p = d1;
        this.q = d2;
        boolean flag = false;
        final int i = gh.c(this.o);
        int j = gh.c(this.p);
        final int k = gh.c(this.q);
        if (this.k.j(i, j, k)) {
            boolean flag2 = false;
            while (!flag2 && j > 0) {
                final int i2 = this.k.a(i, j - 1, k);
                if (i2 == 0 || !ox.m[i2].cd.a()) {
                    --this.p;
                    --j;
                }
                else {
                    flag2 = true;
                }
            }
            if (flag2) {
                this.d(this.o, this.p, this.q);
                if (this.k.a((nk)this, this.y).size() == 0 && !this.k.b(this.y)) {
                    flag = true;
                }
            }
        }
        if (!flag) {
            this.d(d3, d4, d5);
            return false;
        }
        for (int l = 128, j2 = 0; j2 < l; ++j2) {
            final double d6 = j2 / (l - 1.0);
            final float f = (this.U.nextFloat() - 0.5f) * 0.2f;
            final float f2 = (this.U.nextFloat() - 0.5f) * 0.2f;
            final float f3 = (this.U.nextFloat() - 0.5f) * 0.2f;
            final double d7 = d3 + (this.o - d3) * d6 + (this.U.nextDouble() - 0.5) * this.I * 2.0;
            final double d8 = d4 + (this.p - d4) * d6 + this.U.nextDouble() * this.J;
            final double d9 = d5 + (this.q - d5) * d6 + (this.U.nextDouble() - 0.5) * this.I * 2.0;
            this.k.a("spell", d7, d8, d9, (double)f, (double)f2, (double)f3);
        }
        this.k.a(d3, d4, d5, "mob.endermen.portal", 1.0f, 1.0f);
        this.k.a((nk)this, "mob.endermen.portal", 1.0f, 1.0f);
        return true;
    }
    
    static {
        defaultHeldItem = new aai(ym.aX, 1);
    }
}
