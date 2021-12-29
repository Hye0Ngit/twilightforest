// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityTFNatureBolt extends av
{
    public EntityTFNatureBolt(final xd par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }
    
    public EntityTFNatureBolt(final xd par1World, final acq par2EntityLiving) {
        super(par1World, par2EntityLiving);
    }
    
    public EntityTFNatureBolt(final xd par1World) {
        super(par1World);
    }
    
    public void J_() {
        super.J_();
        this.makeTrail();
    }
    
    protected float e() {
        return 0.003f;
    }
    
    public void makeTrail() {
        for (int i = 0; i < 5; ++i) {
            final double dx = this.o + 0.5 * (this.U.nextDouble() - this.U.nextDouble());
            final double dy = this.p + 0.5 * (this.U.nextDouble() - this.U.nextDouble());
            final double dz = this.q + 0.5 * (this.U.nextDouble() - this.U.nextDouble());
            this.k.a("crit", dx, dy, dz, 0.0, 0.0, 0.0);
        }
    }
    
    protected void a(final pl par1MovingObjectPosition) {
        if (par1MovingObjectPosition.g != null && par1MovingObjectPosition.g instanceof acq) {
            if (par1MovingObjectPosition.g.a(md.b((nn)this, (nn)this.c), 2)) {
                final byte poisonStrength = (byte)((this.k.q == 0) ? 0 : ((this.k.q == 2) ? 3 : 7));
                if (poisonStrength > 0) {
                    ((acq)par1MovingObjectPosition.g).b(new alg(aad.u.H, poisonStrength * 20, 0));
                    System.out.println("Poisoning entityHit " + par1MovingObjectPosition.g);
                }
            }
        }
        else if (par1MovingObjectPosition != null) {
            final int dx = gk.c((double)par1MovingObjectPosition.b);
            final int dy = gk.c((double)par1MovingObjectPosition.c);
            final int dz = gk.c((double)par1MovingObjectPosition.d);
            if (this.k.f(dx, dy, dz).a()) {
                this.k.d(dx, dy, dz, pb.K.bO, 2);
            }
        }
        for (int i = 0; i < 8; ++i) {
            this.k.a("iconcrack_" + pb.K.bO, this.o, this.p, this.q, this.U.nextGaussian() * 0.05, this.U.nextDouble() * 0.2, this.U.nextGaussian() * 0.05);
        }
        if (!this.k.F) {
            this.A();
        }
    }
}
