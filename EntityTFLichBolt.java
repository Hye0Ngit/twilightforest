// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFLichBolt extends EntityTFProjectile
{
    public EntityTFLichBolt(final wz world) {
        super(world);
    }
    
    public EntityTFLichBolt(final wz world, final double d, final double d1, final double d2) {
        super(world, d, d1, d2);
    }
    
    public EntityTFLichBolt(final wz world, final acl entityliving, final double d, final double d1, final double d2) {
        super(world, entityliving, d, d1, d2);
    }
    
    @Override
    public void explode() {
    }
    
    @Override
    public void hitEntity(final nk entityHit) {
        entityHit.a(ma.a((nk)this, (nk)this.owner), 1);
    }
    
    @Override
    public void makeTrail() {
        for (int i = 0; i < 5; ++i) {
            final double dx = this.o + 0.5 * (this.U.nextDouble() - this.U.nextDouble());
            final double dy = this.p + 0.5 * (this.U.nextDouble() - this.U.nextDouble());
            final double dz = this.q + 0.5 * (this.U.nextDouble() - this.U.nextDouble());
            final double sparkle = 0.5;
            final double s1 = (this.U.nextFloat() - 0.5f) * sparkle;
            final double s2 = (this.U.nextFloat() - 0.5f) * sparkle;
            final double s3 = (this.U.nextFloat() - 0.5f) * sparkle;
            this.k.a("mobSpell", dx, dy, dz, s1, s2, s3);
        }
    }
    
    public boolean a(final ma damagesource, final int i) {
        this.J();
        if (damagesource.a() != null) {
            final bm vec3d = damagesource.a().Q();
            if (vec3d != null) {
                this.r = vec3d.a;
                this.s = vec3d.b;
                this.t = vec3d.c;
                this.accelerationX = this.r * 0.1;
                this.accelerationY = this.s * 0.1;
                this.accelerationZ = this.t * 0.1;
            }
            if (damagesource.a() instanceof acl) {
                this.owner = (acl)damagesource.a();
            }
            return true;
        }
        return false;
    }
}
