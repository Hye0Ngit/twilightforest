// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFNatureBolt extends EntityTFProjectile
{
    public EntityTFNatureBolt(final fq world) {
        super(world);
    }
    
    public EntityTFNatureBolt(final fq world, final lx entityliving, final double d, final double d1, final double d2) {
        super(world, entityliving, d, d1, d2);
    }
    
    @Override
    public void explode() {
        final int dx = (int)this.bm;
        final int dy = (int)this.bn;
        final int dz = (int)this.bo;
        if (this.bi.d(dx, dy, dz).a()) {
            this.bi.b(dx, dy, dz, ud.M.bO, 2);
        }
    }
    
    @Override
    public void hitEntity(final se entityHit) {
        entityHit.a(qc.a((se)this, (se)this.owner), 1);
        if (entityHit instanceof lx) {
            byte byte0 = 0;
            if (this.bi.v > 1) {
                if (this.bi.v == 2) {
                    byte0 = 3;
                }
                else if (this.bi.v == 3) {
                    byte0 = 7;
                }
            }
            if (byte0 > 0) {
                ((lx)entityHit).e(new xu(jc.u.H, byte0 * 20, 0));
            }
        }
    }
    
    @Override
    public void makeTrail() {
        for (int i = 0; i < 5; ++i) {
            final double dx = this.bm + 0.5 * (this.bS.nextDouble() - this.bS.nextDouble());
            final double dy = this.bn + 0.5 * (this.bS.nextDouble() - this.bS.nextDouble());
            final double dz = this.bo + 0.5 * (this.bS.nextDouble() - this.bS.nextDouble());
            this.bi.a("crit", dx, dy, dz, 0.0, 0.0, 0.0);
        }
    }
}
