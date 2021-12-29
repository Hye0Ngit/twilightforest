// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.TFAchievementPage;
import twilightforest.entity.ai.EntityAITFMagicAttack;

public class EntityTFSlimeBeetle extends tl
{
    public EntityTFSlimeBeetle(final abv world) {
        super(world);
        this.a(0.9f, 1.75f);
        this.c.a(0, (pr)new po((of)this));
        this.c.a(2, (pr)new pf((om)this, (Class)ue.class, 2.0f, 1.25, 2.0));
        this.c.a(3, (pr)new EntityAITFMagicAttack((of)this, 1.0f, 4, 30));
        this.c.a(6, (pr)new ql((om)this, 1.0));
        this.c.a(7, (pr)new pw((of)this, (Class)ue.class, 8.0f));
        this.c.a(8, (pr)new qk((of)this));
        this.d.a(1, (pr)new qw((om)this, false));
        this.d.a(2, (pr)new qx((om)this, (Class)ue.class, 0, true));
    }
    
    protected boolean be() {
        return true;
    }
    
    protected void ay() {
        super.ay();
        this.a(to.a).a(25.0);
        this.a(to.d).a(0.23);
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
    
    protected void a(final int var1, final int var2, final int var3, final int var4) {
        this.q.a((nm)this, "mob.spider.step", 0.15f, 1.0f);
    }
    
    public void c() {
        super.c();
    }
    
    public void a(final na par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof ue) {
            ((ue)par1DamageSource.h()).a((kt)TFAchievementPage.twilightHunter);
        }
    }
    
    public int getAttackStrength(final nm par1Entity) {
        return 4;
    }
    
    @SideOnly(Side.CLIENT)
    public float R() {
        return 1.1f;
    }
    
    public float f() {
        return 0.25f;
    }
    
    public oi aX() {
        return oi.c;
    }
    
    protected int s() {
        return yb.aO.cv;
    }
}
