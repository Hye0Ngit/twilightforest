// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

public class EntityTFLichBomb extends ri
{
    public EntityTFLichBomb(final yc par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }
    
    public EntityTFLichBomb(final yc par1World, final md par2EntityLiving) {
        super(par1World, par2EntityLiving);
    }
    
    public EntityTFLichBomb(final yc par1World) {
        super(par1World);
    }
    
    protected float func_40077_c() {
        return 0.35f;
    }
    
    public void j_() {
        super.j_();
        this.makeTrail();
    }
    
    public void makeTrail() {
        for (int i = 0; i < 1; ++i) {
            final double sx = 0.5 * (this.aa.nextDouble() - this.aa.nextDouble()) + this.w;
            final double sy = 0.5 * (this.aa.nextDouble() - this.aa.nextDouble()) + this.x;
            final double sz = 0.5 * (this.aa.nextDouble() - this.aa.nextDouble()) + this.y;
            final double dx = this.t + sx;
            final double dy = this.u + sy;
            final double dz = this.v + sz;
            this.p.a("flame", dx, dy, dz, sx * -0.25, sy * -0.25, sz * -0.25);
        }
    }
    
    public boolean af() {
        return true;
    }
    
    public boolean L() {
        return true;
    }
    
    public float Y() {
        return 1.0f;
    }
    
    public boolean a(final lh damagesource, final int i) {
        this.K();
        if (damagesource.g() != null) {
            this.explode();
            return true;
        }
        return false;
    }
    
    protected void explode() {
        final float explosionPower = 2.0f;
        this.p.a((lq)this, this.t, this.u, this.v, explosionPower, false, false);
        this.x();
    }
    
    protected float g() {
        return 0.001f;
    }
    
    protected void a(final aoh par1MovingObjectPosition) {
        boolean passThrough = false;
        if (par1MovingObjectPosition.g != null && (par1MovingObjectPosition.g instanceof EntityTFLichBolt || par1MovingObjectPosition.g instanceof EntityTFLichBomb)) {
            passThrough = true;
        }
        if (par1MovingObjectPosition.g != null && par1MovingObjectPosition.g instanceof EntityTFLich) {
            passThrough = true;
        }
        if (!passThrough) {
            this.explode();
        }
    }
}
