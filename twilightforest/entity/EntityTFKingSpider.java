// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

public class EntityTFKingSpider extends ts
{
    public EntityTFKingSpider(final abv world) {
        super(world);
        this.a(1.6f, 1.6f);
        this.k().a(true);
        this.c.a(2, (pr)new pz((om)this, (Class)ue.class, 1.0, false));
        this.c.a(3, (pr)new pv((of)this, 0.3f));
        this.c.a(6, (pr)new ql((om)this, 0.20000000298023224));
        this.c.a(7, (pr)new pw((of)this, (Class)ue.class, 6.0f));
        this.c.a(8, (pr)new qk((of)this));
        this.d.a(2, (pr)new qw((om)this, false));
        this.d.a(2, (pr)new qx((om)this, (Class)ue.class, 0, true));
    }
    
    protected boolean be() {
        return true;
    }
    
    protected void ay() {
        super.ay();
        this.a(to.a).a(30.0);
        this.a(to.d).a(0.35);
        this.a(to.e).a(6.0);
    }
    
    protected nm bL() {
        final double var2 = 16.0;
        return (nm)this.q.b((nm)this, var2);
    }
    
    public float spiderScaleAmount() {
        return 1.9f;
    }
    
    public float bt() {
        return 2.0f;
    }
    
    public boolean e() {
        return false;
    }
    
    public oh a(final oh par1EntityLivingData) {
        final Object par1EntityLivingData2 = super.a(par1EntityLivingData);
        final EntityTFSkeletonDruid druid = new EntityTFSkeletonDruid(this.q);
        druid.b(this.u, this.v, this.w, this.A, 0.0f);
        druid.a((oh)null);
        this.q.d((nm)druid);
        druid.a((nm)this);
        return (oh)par1EntityLivingData2;
    }
}
