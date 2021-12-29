// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFAchievementPage;
import twilightforest.item.TFItems;

public class EntityTFSkeletonDruid extends tl implements tn
{
    public EntityTFSkeletonDruid(final abv world) {
        super(world);
        this.c.a(1, (pr)new po((of)this));
        this.c.a(2, (pr)new qo((om)this));
        this.c.a(3, (pr)new pn((om)this, 1.0));
        this.c.a(4, (pr)new qm((tn)this, 1.0, 60, 10.0f));
        this.c.a(5, (pr)new ql((om)this, 1.0));
        this.c.a(6, (pr)new pw((of)this, (Class)ue.class, 8.0f));
        this.c.a(6, (pr)new qk((of)this));
        this.d.a(1, (pr)new qw((om)this, false));
        this.d.a(2, (pr)new qx((om)this, (Class)ue.class, 0, true));
        this.c(0, new yd(yb.T));
    }
    
    public boolean be() {
        return true;
    }
    
    protected void ay() {
        super.ay();
        this.a(to.a).a(20.0);
        this.a(to.d).a(0.25);
    }
    
    protected String r() {
        return "mob.skeleton.say";
    }
    
    protected String aN() {
        return "mob.skeleton.hurt";
    }
    
    protected String aO() {
        return "mob.skeleton.death";
    }
    
    protected void a(final int par1, final int par2, final int par3, final int par4) {
        this.a("mob.skeleton.step", 0.15f, 1.0f);
    }
    
    protected int s() {
        return TFItems.torchberries.cv;
    }
    
    protected void b(final boolean par1, final int lootingModifier) {
        for (int numberOfItemsToDrop = this.ab.nextInt(3 + lootingModifier), i = 0; i < numberOfItemsToDrop; ++i) {
            this.b(TFItems.torchberries.cv, 1);
        }
        for (int numberOfItemsToDrop = this.ab.nextInt(3 + lootingModifier), i = 0; i < numberOfItemsToDrop; ++i) {
            this.b(yb.aZ.cv, 1);
        }
    }
    
    public oi aX() {
        return oi.b;
    }
    
    public void a(final na par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof ue) {
            ((ue)par1DamageSource.h()).a((kt)TFAchievementPage.twilightHunter);
        }
    }
    
    public void a(final oe attackTarget, final float extraDamage) {
        final EntityTFNatureBolt natureBolt = new EntityTFNatureBolt(this.q, (oe)this);
        this.q.a((nm)this, "mob.ghast.fireball", 1.0f, 1.0f / (this.ab.nextFloat() * 0.4f + 0.8f));
        natureBolt.setTarget(attackTarget);
        final double tx = attackTarget.u - this.u;
        final double ty = attackTarget.v + attackTarget.f() - 2.699999988079071 - this.v;
        final double tz = attackTarget.w - this.w;
        final float heightOffset = lr.a(tx * tx + tz * tz) * 0.2f;
        natureBolt.c(tx, ty + heightOffset, tz, 0.6f, 6.0f);
        this.q.d((nm)natureBolt);
    }
}
