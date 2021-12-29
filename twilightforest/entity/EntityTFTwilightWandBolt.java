// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

public class EntityTFTwilightWandBolt extends ri
{
    public EntityTFTwilightWandBolt(final yc par1World) {
        super(par1World);
    }
    
    public EntityTFTwilightWandBolt(final yc par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }
    
    public EntityTFTwilightWandBolt(final yc par1World, final md par2EntityLiving) {
        super(par1World, par2EntityLiving);
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
    
    protected float g() {
        return 0.003f;
    }
    
    protected void a(final aoh par1MovingObjectPosition) {
        if (par1MovingObjectPosition.g == null || !(par1MovingObjectPosition.g instanceof md) || par1MovingObjectPosition.g.a(lh.b((lq)this, (lq)this.h()), 6)) {}
        for (int i = 0; i < 8; ++i) {
            this.p.a("iconcrack_" + up.bn.cj, this.t, this.u, this.v, this.aa.nextGaussian() * 0.05, this.aa.nextDouble() * 0.2, this.aa.nextGaussian() * 0.05);
        }
        if (!this.p.I) {
            this.x();
        }
    }
}
