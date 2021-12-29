// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFNatureBolt extends bj
{
    public EntityTFNatureBolt(final ge par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }
    
    public EntityTFNatureBolt(final ge par1World, final ne par2EntityLiving) {
        super(par1World, par2EntityLiving);
    }
    
    public EntityTFNatureBolt(final ge par1World) {
        super(par1World);
    }
    
    public void F_() {
        super.F_();
        this.makeTrail();
    }
    
    protected float e() {
        return 0.003f;
    }
    
    public void makeTrail() {
        for (int i = 0; i < 5; ++i) {
            final double dx = this.bm + 0.5 * (this.bS.nextDouble() - this.bS.nextDouble());
            final double dy = this.bn + 0.5 * (this.bS.nextDouble() - this.bS.nextDouble());
            final double dz = this.bo + 0.5 * (this.bS.nextDouble() - this.bS.nextDouble());
            this.bi.a("crit", dx, dy, dz, 0.0, 0.0, 0.0);
        }
    }
    
    protected void a(final wu par1MovingObjectPosition) {
        if (par1MovingObjectPosition.g != null && par1MovingObjectPosition.g instanceof ne) {
            if (par1MovingObjectPosition.g.a(rq.b((tv)this, (tv)this.c), 2)) {
                final byte poisonStrength = (byte)((this.bi.q == 0) ? 0 : ((this.bi.q == 2) ? 3 : 7));
                if (poisonStrength > 0) {
                    ((ne)par1MovingObjectPosition.g).e(new zv(kf.u.H, poisonStrength * 20, 0));
                    System.out.println("Poisoning entityHit " + par1MovingObjectPosition.g);
                }
            }
        }
        else if (par1MovingObjectPosition != null) {
            final int dx = kb.b((double)par1MovingObjectPosition.b);
            final int dy = kb.b((double)par1MovingObjectPosition.c);
            final int dz = kb.b((double)par1MovingObjectPosition.d);
            if (this.bi.d(dx, dy, dz).a()) {
                this.bi.b(dx, dy, dz, vz.K.bO, 2);
            }
        }
        for (int i = 0; i < 8; ++i) {
            this.bi.a("iconcrack_" + vz.K.bO, this.bm, this.bn, this.bo, this.bS.nextGaussian() * 0.05, this.bS.nextDouble() * 0.2, this.bS.nextGaussian() * 0.05);
        }
        if (!this.bi.F) {
            this.X();
        }
    }
}
