// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFNatureBolt extends EntityTFProjectile
{
    public EntityTFNatureBolt(final ry world, final nq entityliving, final double d, final double d1, final double d2) {
        super(world, entityliving, d, d1, d2);
    }
    
    @Override
    public void explode() {
        final int dx = (int)this.s;
        final int dy = (int)this.t;
        final int dz = (int)this.u;
        if (this.o.e(dx, dy, dz).b()) {
            this.o.d(dx, dy, dz, yy.K.bM, 2);
        }
    }
    
    @Override
    public void hitEntity(final ia entityHit) {
        entityHit.a(pm.a((ia)this, (ia)this.shootingEntity), 1);
        if (entityHit instanceof nq) {
            byte byte0 = 0;
            if (this.o.v > 1) {
                if (this.o.v == 2) {
                    byte0 = 3;
                }
                else if (this.o.v == 3) {
                    byte0 = 7;
                }
            }
            if (byte0 > 0) {
                ((nq)entityHit).a(new s(abg.u.H, byte0 * 20, 0));
            }
        }
    }
    
    @Override
    public void makeTrail() {
        for (int i = 0; i < 5; ++i) {
            final double dx = this.s + 0.5 * (this.Y.nextDouble() - this.Y.nextDouble());
            final double dy = this.t + 0.5 * (this.Y.nextDouble() - this.Y.nextDouble());
            final double dz = this.u + 0.5 * (this.Y.nextDouble() - this.Y.nextDouble());
            this.o.a("crit", dx, dy, dz, 0.0, 0.0, 0.0);
        }
    }
}
