// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFAchievementPage;
import twilightforest.item.TFItems;

public class EntityTFHelmetCrab extends tl
{
    public EntityTFHelmetCrab(final abv world) {
        super(world);
        this.a(0.8f, 1.1f);
        this.c.a(0, (pr)new po((of)this));
        this.c.a(2, (pr)new pv((of)this, 0.28f));
        this.c.a(3, (pr)new pz((om)this, (Class)ue.class, 1.0, false));
        this.c.a(6, (pr)new ql((om)this, 1.0));
        this.c.a(7, (pr)new pw((of)this, (Class)ue.class, 8.0f));
        this.c.a(7, (pr)new qk((of)this));
        this.d.a(1, (pr)new qw((om)this, true));
        this.d.a(2, (pr)new qx((om)this, (Class)ue.class, 0, true));
    }
    
    public EntityTFHelmetCrab(final abv world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    protected void a() {
        super.a();
    }
    
    protected boolean be() {
        return true;
    }
    
    protected void ay() {
        super.ay();
        this.a(to.a).a(13.0);
        this.a(to.d).a(0.28);
        this.a(to.e).a(3.0);
    }
    
    protected String r() {
        return null;
    }
    
    protected String aN() {
        return "mob.spider.say";
    }
    
    protected String aO() {
        return "mob.spider.death";
    }
    
    protected void a(final int par1, final int par2, final int par3, final int par4) {
        this.a("mob.spider.step", 0.15f, 1.0f);
    }
    
    protected int s() {
        return TFItems.armorShard.cv;
    }
    
    protected void b(final boolean flag, final int i) {
        super.b(flag, i);
        if (this.ab.nextInt(2) == 0) {
            this.b(yb.aW.cv, 1 + i);
        }
    }
    
    public void a(final na par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof ue) {
            ((ue)par1DamageSource.h()).a((kt)TFAchievementPage.twilightHunter);
        }
    }
    
    public int bv() {
        return 8;
    }
    
    public oi aX() {
        return oi.c;
    }
    
    public int aP() {
        int i = super.aP() + 6;
        if (i > 20) {
            i = 20;
        }
        return i;
    }
}
