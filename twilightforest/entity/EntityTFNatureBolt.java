// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

public class EntityTFNatureBolt extends up
{
    private ue playerTarget;
    
    public EntityTFNatureBolt(final abv par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }
    
    public EntityTFNatureBolt(final abv par1World, final oe par2EntityLiving) {
        super(par1World, par2EntityLiving);
    }
    
    public EntityTFNatureBolt(final abv par1World) {
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
        if (par1MovingObjectPosition.g != null && par1MovingObjectPosition.g instanceof oe && par1MovingObjectPosition.g.a(na.b((nm)this, (nm)this.h()), 2.0f)) {
            final byte poisonStrength = (byte)((this.q.r == 0) ? 0 : ((this.q.r == 2) ? 3 : 7));
            if (poisonStrength > 0) {
                ((oe)par1MovingObjectPosition.g).c(new ni(nh.u.H, poisonStrength * 20, 0));
            }
        }
        for (int i = 0; i < 8; ++i) {
            this.q.a("tilecrack_" + aqw.P.cF + "_0", this.u, this.v, this.w, this.ab.nextGaussian() * 0.05, this.ab.nextDouble() * 0.2, this.ab.nextGaussian() * 0.05);
        }
        if (!this.q.I) {
            this.w();
            if (par1MovingObjectPosition != null) {
                final int dx = lr.c((double)par1MovingObjectPosition.b);
                final int dy = lr.c((double)par1MovingObjectPosition.c);
                final int dz = lr.c((double)par1MovingObjectPosition.d);
                final ajz materialHit = this.q.g(dx, dy, dz);
                if (materialHit == ajz.b && this.playerTarget != null) {
                    yb.aY.a(new yd(yb.aY, 1, 15), this.playerTarget, this.q, dx, dy, dz, 0, 0.0f, 0.0f, 0.0f);
                }
                else if (materialHit.a() && this.canReplaceBlock(this.q, dx, dy, dz)) {
                    this.q.f(dx, dy, dz, aqw.P.cF, 2, 3);
                }
            }
        }
    }
    
    private boolean canReplaceBlock(final abv worldObj, final int dx, final int dy, final int dz) {
        final int blockID = worldObj.a(dx, dy, dz);
        final int meta = worldObj.h(dx, dy, dz);
        final aqw blockObj = aqw.s[blockID];
        final float hardness = (blockObj == null) ? -1.0f : blockObj.l(worldObj, dx, dy, dz);
        return hardness >= 0.0f && hardness < 50.0f;
    }
    
    public void setTarget(final oe attackTarget) {
        if (attackTarget instanceof ue) {
            this.playerTarget = (ue)attackTarget;
        }
    }
}
