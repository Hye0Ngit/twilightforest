// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityTFSlimeProjectile extends rh
{
    public EntityTFSlimeProjectile(final xv par1World) {
        super(par1World);
    }
    
    public EntityTFSlimeProjectile(final xv par1World, final md par2EntityLiving) {
        super(par1World, par2EntityLiving);
    }
    
    public void j_() {
        super.j_();
        this.makeTrail();
    }
    
    protected float g() {
        return 0.006f;
    }
    
    public void makeTrail() {
        for (int i = 0; i < 2; ++i) {
            final double dx = this.t + 0.5 * (this.aa.nextDouble() - this.aa.nextDouble());
            final double dy = this.u + 0.5 * (this.aa.nextDouble() - this.aa.nextDouble());
            final double dz = this.v + 0.5 * (this.aa.nextDouble() - this.aa.nextDouble());
            this.p.a("slime", dx, dy, dz, 0.0, 0.0, 0.0);
        }
    }
    
    public boolean a(final lh damagesource, final int i) {
        this.K();
        this.pop();
        return true;
    }
    
    protected void a(final anz par1MovingObjectPosition) {
        if (par1MovingObjectPosition.g == null || !(par1MovingObjectPosition.g instanceof md) || par1MovingObjectPosition.g.a(lh.a((lq)this, (lq)this.h()), 8)) {}
        this.pop();
    }
    
    protected void pop() {
        for (int i = 0; i < 8; ++i) {
            this.p.a("slime", this.t, this.u, this.v, this.aa.nextGaussian() * 0.05, this.aa.nextDouble() * 0.2, this.aa.nextGaussian() * 0.05);
        }
        this.p.a((lq)this, "mob.slime.big", 1.0f, 1.0f / (this.aa.nextFloat() * 0.4f + 0.8f));
        if (!this.p.J) {
            this.x();
        }
    }
}
