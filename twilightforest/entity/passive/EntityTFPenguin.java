// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import twilightforest.TFAchievementPage;

public class EntityTFPenguin extends EntityTFBird
{
    public EntityTFPenguin(final abv world) {
        super(world);
        this.a(0.5f, 0.9f);
        this.c.a(0, (pr)new po((of)this));
        this.c.a(1, (pr)new qi((om)this, 1.75));
        this.c.a(2, (pr)new pj((ro)this, 1.0));
        this.c.a(3, (pr)new qt((om)this, 0.75, yb.aW.cv, false));
        this.c.a(4, (pr)new pq((ro)this, 1.0));
        this.c.a(5, (pr)new ql((om)this, 1.0));
        this.c.a(6, (pr)new pw((of)this, (Class)ue.class, 6.0f));
        this.c.a(7, (pr)new pu((of)this, (Class)EntityTFPenguin.class, 5.0f, 0.02f));
        this.c.a(8, (pr)new qk((of)this));
    }
    
    protected String r() {
        return null;
    }
    
    @Override
    public ro createChild(final nj entityanimal) {
        return new EntityTFPenguin(this.q);
    }
    
    public boolean c(final yd par1ItemStack) {
        return par1ItemStack != null && par1ItemStack.d == yb.aW.cv;
    }
    
    public void a(final na par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof ue) {
            ((ue)par1DamageSource.h()).a((kt)TFAchievementPage.twilightHunter);
        }
    }
    
    protected void ay() {
        super.ay();
        this.a(to.a).a(10.0);
        this.a(to.d).a(0.10000001192092896);
    }
}
