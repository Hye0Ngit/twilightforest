// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityTFLichBolt extends rh
{
    public md playerReflects;
    
    public EntityTFLichBolt(final xv par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
        this.playerReflects = null;
    }
    
    public EntityTFLichBolt(final xv par1World, final md par2EntityLiving) {
        super(par1World, par2EntityLiving);
        this.playerReflects = null;
    }
    
    public EntityTFLichBolt(final xv par1World) {
        super(par1World);
        this.playerReflects = null;
    }
    
    protected float func_40077_c() {
        return 0.5f;
    }
    
    public void j_() {
        super.j_();
        this.makeTrail();
    }
    
    public void makeTrail() {
        for (int i = 0; i < 5; ++i) {
            final double dx = this.t + 0.5 * (this.aa.nextDouble() - this.aa.nextDouble());
            final double dy = this.u + 0.5 * (this.aa.nextDouble() - this.aa.nextDouble());
            final double dz = this.v + 0.5 * (this.aa.nextDouble() - this.aa.nextDouble());
            final double s1 = (this.aa.nextFloat() * 0.5f + 0.5f) * 0.17f;
            final double s2 = (this.aa.nextFloat() * 0.5f + 0.5f) * 0.8f;
            final double s3 = (this.aa.nextFloat() * 0.5f + 0.5f) * 0.69f;
            this.p.a("mobSpell", dx, dy, dz, s1, s2, s3);
        }
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
            final aob vec3d = damagesource.g().Z();
            if (vec3d != null) {
                this.c(vec3d.c, vec3d.d, vec3d.e, 1.5f, 0.1f);
            }
            if (damagesource.g() instanceof md) {
                this.playerReflects = (md)damagesource.g();
            }
            return true;
        }
        return false;
    }
    
    public md h() {
        if (this.playerReflects != null) {
            return this.playerReflects;
        }
        return super.h();
    }
    
    protected float g() {
        return 0.0f;
    }
    
    protected void a(final anz par1MovingObjectPosition) {
        boolean passThrough = false;
        if (par1MovingObjectPosition.g != null && (par1MovingObjectPosition.g instanceof EntityTFLichBolt || par1MovingObjectPosition.g instanceof EntityTFLichBomb)) {
            passThrough = true;
        }
        if (par1MovingObjectPosition.g != null && par1MovingObjectPosition.g instanceof md) {
            if (par1MovingObjectPosition.g instanceof EntityTFLich) {
                final EntityTFLich lich = (EntityTFLich)par1MovingObjectPosition.g;
                if (lich.isShadowClone()) {
                    passThrough = true;
                }
            }
            if (passThrough || par1MovingObjectPosition.g.a(lh.b((lq)this, (lq)this.h()), 6)) {}
        }
        if (!passThrough) {
            for (int i = 0; i < 8; ++i) {
                this.p.a("iconcrack_" + uk.bn.cg, this.t, this.u, this.v, this.aa.nextGaussian() * 0.05, this.aa.nextDouble() * 0.2, this.aa.nextGaussian() * 0.05);
            }
            if (!this.p.J) {
                this.x();
            }
        }
    }
}
