// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

public class EntityTFTwilightWandBolt extends sv
{
    public EntityTFTwilightWandBolt(final zv par1World) {
        super(par1World);
    }
    
    public EntityTFTwilightWandBolt(final zv par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }
    
    public EntityTFTwilightWandBolt(final zv par1World, final ng par2EntityLiving) {
        super(par1World, par2EntityLiving);
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
    
    protected float g() {
        return 0.003f;
    }
    
    protected void a(final aqu par1MovingObjectPosition) {
        if (par1MovingObjectPosition.g == null || !(par1MovingObjectPosition.g instanceof ng) || par1MovingObjectPosition.g.a(mg.b((mp)this, (mp)this.h()), 6)) {}
        for (int i = 0; i < 8; ++i) {
            this.q.a("iconcrack_" + we.bo.cp, this.u, this.v, this.w, this.ab.nextGaussian() * 0.05, this.ab.nextDouble() * 0.2, this.ab.nextGaussian() * 0.05);
        }
        if (!this.q.I) {
            this.w();
        }
    }
}
