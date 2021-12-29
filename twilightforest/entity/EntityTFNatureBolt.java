// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

public class EntityTFNatureBolt extends ri
{
    public EntityTFNatureBolt(final yc par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }
    
    public EntityTFNatureBolt(final yc par1World, final md par2EntityLiving) {
        super(par1World, par2EntityLiving);
    }
    
    public EntityTFNatureBolt(final yc par1World) {
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
    
    protected void a(final aoh par1MovingObjectPosition) {
        if (par1MovingObjectPosition.g != null && par1MovingObjectPosition.g instanceof md) {
            if (par1MovingObjectPosition.g.a(lh.b((lq)this, (lq)this.h()), 2)) {
                final byte poisonStrength = (byte)((this.p.s == 0) ? 0 : ((this.p.s == 2) ? 3 : 7));
                if (poisonStrength > 0) {
                    ((md)par1MovingObjectPosition.g).d(new lm(ll.u.H, poisonStrength * 20, 0));
                }
            }
        }
        else if (par1MovingObjectPosition != null) {
            final int dx = ke.c((double)par1MovingObjectPosition.b);
            final int dy = ke.c((double)par1MovingObjectPosition.c);
            final int dz = ke.c((double)par1MovingObjectPosition.d);
            if (this.p.g(dx, dy, dz).a()) {
                this.p.d(dx, dy, dz, amq.N.cm, 2);
            }
        }
        for (int i = 0; i < 8; ++i) {
            this.p.a("iconcrack_" + amq.N.cm, this.t, this.u, this.v, this.aa.nextGaussian() * 0.05, this.aa.nextDouble() * 0.2, this.aa.nextGaussian() * 0.05);
        }
        if (!this.p.I) {
            this.x();
        }
    }
}
