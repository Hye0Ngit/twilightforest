// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

public class EntityTFSlimeProjectile extends sv
{
    public EntityTFSlimeProjectile(final zv par1World) {
        super(par1World);
    }
    
    public EntityTFSlimeProjectile(final zv par1World, final ng par2EntityLiving) {
        super(par1World, par2EntityLiving);
    }
    
    public void l_() {
        super.l_();
        this.makeTrail();
    }
    
    protected float g() {
        return 0.006f;
    }
    
    public void makeTrail() {
        for (int i = 0; i < 2; ++i) {
            final double dx = this.u + 0.5 * (this.ab.nextDouble() - this.ab.nextDouble());
            final double dy = this.v + 0.5 * (this.ab.nextDouble() - this.ab.nextDouble());
            final double dz = this.w + 0.5 * (this.ab.nextDouble() - this.ab.nextDouble());
            this.q.a("slime", dx, dy, dz, 0.0, 0.0, 0.0);
        }
    }
    
    public boolean a(final mg damagesource, final int i) {
        this.J();
        this.pop();
        return true;
    }
    
    protected void a(final aqu par1MovingObjectPosition) {
        if (par1MovingObjectPosition.g == null || !(par1MovingObjectPosition.g instanceof ng) || par1MovingObjectPosition.g.a(mg.a((mp)this, (mp)this.h()), 8)) {}
        this.pop();
    }
    
    protected void pop() {
        for (int i = 0; i < 8; ++i) {
            this.q.a("slime", this.u, this.v, this.w, this.ab.nextGaussian() * 0.05, this.ab.nextDouble() * 0.2, this.ab.nextGaussian() * 0.05);
        }
        this.q.a((mp)this, "mob.slime.big", 1.0f, 1.0f / (this.ab.nextFloat() * 0.4f + 0.8f));
        if (!this.q.I) {
            this.w();
        }
    }
}
