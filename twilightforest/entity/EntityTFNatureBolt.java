// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

public class EntityTFNatureBolt extends sv
{
    private sk playerTarget;
    
    public EntityTFNatureBolt(final zv par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }
    
    public EntityTFNatureBolt(final zv par1World, final ng par2EntityLiving) {
        super(par1World, par2EntityLiving);
    }
    
    public EntityTFNatureBolt(final zv par1World) {
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
        if (par1MovingObjectPosition.g != null && par1MovingObjectPosition.g instanceof ng && par1MovingObjectPosition.g.a(mg.b((mp)this, (mp)this.h()), 2)) {
            final byte poisonStrength = (byte)((this.q.r == 0) ? 0 : ((this.q.r == 2) ? 3 : 7));
            if (poisonStrength > 0) {
                ((ng)par1MovingObjectPosition.g).d(new ml(mk.u.H, poisonStrength * 20, 0));
            }
        }
        for (int i = 0; i < 8; ++i) {
            this.q.a("tilecrack_" + aou.O.cz + "_0", this.u, this.v, this.w, this.ab.nextGaussian() * 0.05, this.ab.nextDouble() * 0.2, this.ab.nextGaussian() * 0.05);
        }
        if (!this.q.I) {
            this.w();
            if (par1MovingObjectPosition != null) {
                final int dx = kx.c((double)par1MovingObjectPosition.b);
                final int dy = kx.c((double)par1MovingObjectPosition.c);
                final int dz = kx.c((double)par1MovingObjectPosition.d);
                final ahz materialHit = this.q.g(dx, dy, dz);
                if (materialHit == ahz.b && this.playerTarget != null) {
                    we.aX.a(new wg(we.aX, 1, 15), this.playerTarget, this.q, dx, dy, dz, 0, 0.0f, 0.0f, 0.0f);
                }
                else if (materialHit.a() && this.canReplaceBlock(this.q, dx, dy, dz)) {
                    this.q.f(dx, dy, dz, aou.O.cz, 2, 3);
                }
            }
        }
    }
    
    private boolean canReplaceBlock(final zv worldObj, final int dx, final int dy, final int dz) {
        final int blockID = worldObj.a(dx, dy, dz);
        final int meta = worldObj.h(dx, dy, dz);
        final aou blockObj = aou.r[blockID];
        final float hardness = (blockObj == null) ? -1.0f : blockObj.l(worldObj, dx, dy, dz);
        return hardness >= 0.0f && hardness < 50.0f;
    }
    
    public void setTarget(final ng attackTarget) {
        if (attackTarget instanceof sk) {
            this.playerTarget = (sk)attackTarget;
        }
    }
}
