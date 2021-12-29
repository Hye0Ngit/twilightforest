// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

public class EntityTFLichBomb extends up
{
    public EntityTFLichBomb(final abv par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }
    
    public EntityTFLichBomb(final abv par1World, final oe par2EntityLiving) {
        super(par1World, par2EntityLiving);
    }
    
    public EntityTFLichBomb(final abv par1World) {
        super(par1World);
    }
    
    protected float func_40077_c() {
        return 0.35f;
    }
    
    public void l_() {
        super.l_();
        this.makeTrail();
    }
    
    public void makeTrail() {
        for (int i = 0; i < 1; ++i) {
            final double sx = 0.5 * (this.ab.nextDouble() - this.ab.nextDouble()) + this.x;
            final double sy = 0.5 * (this.ab.nextDouble() - this.ab.nextDouble()) + this.y;
            final double sz = 0.5 * (this.ab.nextDouble() - this.ab.nextDouble()) + this.z;
            final double dx = this.u + sx;
            final double dy = this.v + sy;
            final double dz = this.w + sz;
            this.q.a("flame", dx, dy, dz, sx * -0.25, sy * -0.25, sz * -0.25);
        }
    }
    
    public boolean ae() {
        return true;
    }
    
    public boolean K() {
        return true;
    }
    
    public float Y() {
        return 1.0f;
    }
    
    public boolean a(final na damagesource, final float i) {
        this.J();
        if (damagesource.i() != null) {
            this.explode();
            return true;
        }
        return false;
    }
    
    protected void explode() {
        final float explosionPower = 2.0f;
        this.q.a((nm)this, this.u, this.v, this.w, explosionPower, false, false);
        this.w();
    }
    
    protected float e() {
        return 0.001f;
    }
    
    protected void a(final asx par1MovingObjectPosition) {
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
