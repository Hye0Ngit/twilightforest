// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

public class EntityTFTomeBolt extends up
{
    public EntityTFTomeBolt(final abv par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }
    
    public EntityTFTomeBolt(final abv par1World, final oe par2EntityLiving) {
        super(par1World, par2EntityLiving);
    }
    
    public EntityTFTomeBolt(final abv par1World) {
        super(par1World);
    }
    
    public void l_() {
        super.l_();
        this.makeTrail();
    }
    
    protected float e() {
        return 0.003f;
    }
    
    public void makeTrail() {
        for (int i = 0; i < 5; ++i) {
            final double dx = this.u + 0.5 * (this.ab.nextDouble() - this.ab.nextDouble());
            final double dy = this.v + 0.5 * (this.ab.nextDouble() - this.ab.nextDouble());
            final double dz = this.w + 0.5 * (this.ab.nextDouble() - this.ab.nextDouble());
            this.q.a("crit", dx, dy, dz, 0.0, 0.0, 0.0);
        }
    }
    
    protected void a(final asx par1MovingObjectPosition) {
        if (par1MovingObjectPosition.g != null && par1MovingObjectPosition.g instanceof oe && par1MovingObjectPosition.g.a(na.a((nm)this, (nm)this.h()), 6.0f)) {
            final byte potionStrength = (byte)((this.q.r == 0) ? 3 : ((this.q.r == 2) ? 7 : 9));
            if (potionStrength > 0) {
                ((oe)par1MovingObjectPosition.g).c(new ni(nh.d.H, potionStrength * 20, 1));
            }
        }
        for (int i = 0; i < 8; ++i) {
            this.q.a("iconcrack_" + yb.bG.cv, this.u, this.v, this.w, this.ab.nextGaussian() * 0.05, this.ab.nextDouble() * 0.2, this.ab.nextGaussian() * 0.05);
        }
        if (!this.q.I) {
            this.w();
        }
    }
}
