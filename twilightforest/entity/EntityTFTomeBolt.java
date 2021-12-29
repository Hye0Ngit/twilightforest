// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

public class EntityTFTomeBolt extends sv
{
    public EntityTFTomeBolt(final zv par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }
    
    public EntityTFTomeBolt(final zv par1World, final ng par2EntityLiving) {
        super(par1World, par2EntityLiving);
    }
    
    public EntityTFTomeBolt(final zv par1World) {
        super(par1World);
    }
    
    public void l_() {
        super.l_();
        this.makeTrail();
    }
    
    protected float g() {
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
    
    protected void a(final aqu par1MovingObjectPosition) {
        if (par1MovingObjectPosition.g != null && par1MovingObjectPosition.g instanceof ng && par1MovingObjectPosition.g.a(mg.a((mp)this, (mp)this.h()), 6)) {
            final byte potionStrength = (byte)((this.q.r == 0) ? 3 : ((this.q.r == 2) ? 7 : 9));
            if (potionStrength > 0) {
                ((ng)par1MovingObjectPosition.g).d(new ml(mk.d.H, potionStrength * 20, 1));
            }
        }
        for (int i = 0; i < 8; ++i) {
            this.q.a("iconcrack_" + we.bF.cp, this.u, this.v, this.w, this.ab.nextGaussian() * 0.05, this.ab.nextDouble() * 0.2, this.ab.nextGaussian() * 0.05);
        }
        if (!this.q.I) {
            this.w();
        }
    }
}
