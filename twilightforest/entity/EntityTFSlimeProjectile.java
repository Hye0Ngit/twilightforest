// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

public class EntityTFSlimeProjectile extends up
{
    public EntityTFSlimeProjectile(final abv par1World) {
        super(par1World);
    }
    
    public EntityTFSlimeProjectile(final abv par1World, final oe par2EntityLiving) {
        super(par1World, par2EntityLiving);
    }
    
    public void l_() {
        super.l_();
        this.makeTrail();
    }
    
    protected float e() {
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
    
    public boolean a(final na damagesource, final float i) {
        this.J();
        this.pop();
        return true;
    }
    
    protected void a(final asx par1MovingObjectPosition) {
        if (par1MovingObjectPosition.g == null || !(par1MovingObjectPosition.g instanceof oe) || par1MovingObjectPosition.g.a(na.a((nm)this, (nm)this.h()), 8.0f)) {}
        this.pop();
    }
    
    protected void pop() {
        for (int i = 0; i < 8; ++i) {
            this.q.a("slime", this.u, this.v, this.w, this.ab.nextGaussian() * 0.05, this.ab.nextDouble() * 0.2, this.ab.nextGaussian() * 0.05);
        }
        this.q.a((nm)this, "mob.slime.big", 1.0f, 1.0f / (this.ab.nextFloat() * 0.4f + 0.8f));
        if (!this.q.I) {
            this.w();
        }
    }
}
