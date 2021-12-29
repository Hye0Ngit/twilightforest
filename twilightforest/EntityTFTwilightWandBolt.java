// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityTFTwilightWandBolt extends av
{
    public EntityTFTwilightWandBolt(final xd par1World) {
        super(par1World);
    }
    
    public EntityTFTwilightWandBolt(final xd par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }
    
    public EntityTFTwilightWandBolt(final xd par1World, final acq par2EntityLiving) {
        super(par1World, par2EntityLiving);
    }
    
    public void J_() {
        super.J_();
        this.makeTrail();
    }
    
    public void makeTrail() {
        for (int i = 0; i < 5; ++i) {
            final double dx = this.o + 0.5 * (this.U.nextDouble() - this.U.nextDouble());
            final double dy = this.p + 0.5 * (this.U.nextDouble() - this.U.nextDouble());
            final double dz = this.q + 0.5 * (this.U.nextDouble() - this.U.nextDouble());
            final double s1 = (this.U.nextFloat() * 0.5f + 0.5f) * 0.17f;
            final double s2 = (this.U.nextFloat() * 0.5f + 0.5f) * 0.8f;
            final double s3 = (this.U.nextFloat() * 0.5f + 0.5f) * 0.69f;
            this.k.a("mobSpell", dx, dy, dz, s1, s2, s3);
        }
    }
    
    protected float e() {
        return 0.003f;
    }
    
    protected void a(final pl par1MovingObjectPosition) {
        if (par1MovingObjectPosition.g == null || !(par1MovingObjectPosition.g instanceof acq) || par1MovingObjectPosition.g.a(md.b((nn)this, (nn)this.c), 6)) {}
        for (int i = 0; i < 8; ++i) {
            this.k.a("iconcrack_" + yr.bn.bQ, this.o, this.p, this.q, this.U.nextGaussian() * 0.05, this.U.nextDouble() * 0.2, this.U.nextGaussian() * 0.05);
        }
        if (!this.k.F) {
            this.A();
        }
    }
}
