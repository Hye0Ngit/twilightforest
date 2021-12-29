// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFNatureBolt extends EntityTFProjectile
{
    public EntityTFNatureBolt(final wz world) {
        super(world);
    }
    
    public EntityTFNatureBolt(final wz world, final double d, final double d1, final double d2) {
        super(world, d, d1, d2);
    }
    
    public EntityTFNatureBolt(final wz world, final acl entityliving, final double d, final double d1, final double d2) {
        super(world, entityliving, d, d1, d2);
    }
    
    @Override
    public void explode() {
        final int dx = (int)this.o;
        final int dy = (int)this.p;
        final int dz = (int)this.q;
        if (this.k.f(dx, dy, dz).a()) {
            this.k.d(dx, dy, dz, ox.K.bO, 2);
        }
    }
    
    @Override
    public void hitEntity(final nk entityHit) {
        entityHit.a(ma.a((nk)this, (nk)this.owner), 1);
        if (entityHit instanceof acl) {
            byte byte0 = 0;
            if (this.k.q > 1) {
                if (this.k.q == 2) {
                    byte0 = 3;
                }
                else if (this.k.q == 3) {
                    byte0 = 7;
                }
            }
            if (byte0 > 0) {
                ((acl)entityHit).b(new ala(zy.u.H, byte0 * 20, 0));
            }
        }
    }
    
    @Override
    public void makeTrail() {
        for (int i = 0; i < 5; ++i) {
            final double dx = this.o + 0.5 * (this.U.nextDouble() - this.U.nextDouble());
            final double dy = this.p + 0.5 * (this.U.nextDouble() - this.U.nextDouble());
            final double dz = this.q + 0.5 * (this.U.nextDouble() - this.U.nextDouble());
            this.k.a("crit", dx, dy, dz, 0.0, 0.0, 0.0);
        }
    }
}
