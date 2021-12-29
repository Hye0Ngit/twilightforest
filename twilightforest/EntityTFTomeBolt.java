// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityTFTomeBolt extends rh
{
    public EntityTFTomeBolt(final xv par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }
    
    public EntityTFTomeBolt(final xv par1World, final md par2EntityLiving) {
        super(par1World, par2EntityLiving);
    }
    
    public EntityTFTomeBolt(final xv par1World) {
        super(par1World);
    }
    
    public void j_() {
        super.j_();
        this.makeTrail();
    }
    
    protected float g() {
        return 0.003f;
    }
    
    public void makeTrail() {
        for (int i = 0; i < 5; ++i) {
            final double dx = this.t + 0.5 * (this.aa.nextDouble() - this.aa.nextDouble());
            final double dy = this.u + 0.5 * (this.aa.nextDouble() - this.aa.nextDouble());
            final double dz = this.v + 0.5 * (this.aa.nextDouble() - this.aa.nextDouble());
            this.p.a("crit", dx, dy, dz, 0.0, 0.0, 0.0);
        }
    }
    
    protected void a(final anz par1MovingObjectPosition) {
        if (par1MovingObjectPosition.g != null && par1MovingObjectPosition.g instanceof md && par1MovingObjectPosition.g.a(lh.a((lq)this, (lq)this.h()), 6)) {
            final byte potionStrength = (byte)((this.p.t == 0) ? 3 : ((this.p.t == 2) ? 7 : 9));
            if (potionStrength > 0) {
                ((md)par1MovingObjectPosition.g).d(new lm(ll.d.H, potionStrength * 20, 1));
            }
        }
        for (int i = 0; i < 8; ++i) {
            this.p.a("iconcrack_" + uk.bE.cg, this.t, this.u, this.v, this.aa.nextGaussian() * 0.05, this.aa.nextDouble() * 0.2, this.aa.nextGaussian() * 0.05);
        }
        if (!this.p.J) {
            this.x();
        }
    }
}
