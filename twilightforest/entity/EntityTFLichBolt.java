// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

public class EntityTFLichBolt extends up
{
    public oe playerReflects;
    
    public EntityTFLichBolt(final abv par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
        this.playerReflects = null;
    }
    
    public EntityTFLichBolt(final abv par1World, final oe par2EntityLiving) {
        super(par1World, par2EntityLiving);
        this.playerReflects = null;
    }
    
    public EntityTFLichBolt(final abv par1World) {
        super(par1World);
        this.playerReflects = null;
    }
    
    protected float func_40077_c() {
        return 0.5f;
    }
    
    public void l_() {
        super.l_();
        this.makeTrail();
    }
    
    public void makeTrail() {
        for (int i = 0; i < 5; ++i) {
            final double dx = this.u + 0.5 * (this.ab.nextDouble() - this.ab.nextDouble());
            final double dy = this.v + 0.5 * (this.ab.nextDouble() - this.ab.nextDouble());
            final double dz = this.w + 0.5 * (this.ab.nextDouble() - this.ab.nextDouble());
            final double s1 = (this.ab.nextFloat() * 0.5f + 0.5f) * 0.17f;
            final double s2 = (this.ab.nextFloat() * 0.5f + 0.5f) * 0.8f;
            final double s3 = (this.ab.nextFloat() * 0.5f + 0.5f) * 0.69f;
            this.q.a("mobSpell", dx, dy, dz, s1, s2, s3);
        }
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
            final asz vec3d = damagesource.i().Z();
            if (vec3d != null) {
                this.c(vec3d.c, vec3d.d, vec3d.e, 1.5f, 0.1f);
            }
            if (damagesource.i() instanceof oe) {
                this.playerReflects = (oe)damagesource.i();
            }
            return true;
        }
        return false;
    }
    
    public oe h() {
        if (this.playerReflects != null) {
            return this.playerReflects;
        }
        return super.h();
    }
    
    protected float e() {
        return 0.0f;
    }
    
    protected void a(final asx par1MovingObjectPosition) {
        boolean passThrough = false;
        if (par1MovingObjectPosition.g != null && (par1MovingObjectPosition.g instanceof EntityTFLichBolt || par1MovingObjectPosition.g instanceof EntityTFLichBomb)) {
            passThrough = true;
        }
        if (par1MovingObjectPosition.g != null && par1MovingObjectPosition.g instanceof oe) {
            if (par1MovingObjectPosition.g instanceof EntityTFLich) {
                final EntityTFLich lich = (EntityTFLich)par1MovingObjectPosition.g;
                if (lich.isShadowClone()) {
                    passThrough = true;
                }
            }
            if (passThrough || par1MovingObjectPosition.g.a(na.b((nm)this, (nm)this.h()), 6.0f)) {}
        }
        if (!passThrough) {
            for (int i = 0; i < 8; ++i) {
                this.q.a("iconcrack_" + yb.bp.cv, this.u, this.v, this.w, this.ab.nextGaussian() * 0.05, this.ab.nextDouble() * 0.2, this.ab.nextGaussian() * 0.05);
            }
            if (!this.q.I) {
                this.w();
            }
        }
    }
}
