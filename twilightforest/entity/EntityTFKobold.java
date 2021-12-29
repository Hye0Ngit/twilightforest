// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFAchievementPage;
import twilightforest.entity.ai.EntityAITFFlockToSameKind;
import twilightforest.entity.ai.EntityAITFPanicOnFlockDeath;

public class EntityTFKobold extends tl
{
    private boolean shy;
    
    public EntityTFKobold(final abv world) {
        super(world);
        this.a(0.8f, 1.1f);
        this.shy = true;
        this.c.a(0, (pr)new po((of)this));
        this.c.a(1, (pr)new EntityAITFPanicOnFlockDeath((om)this, 2.0f));
        this.c.a(2, (pr)new pv((of)this, 0.3f));
        this.c.a(3, (pr)new pz((om)this, (Class)ue.class, 1.0, false));
        this.c.a(4, (pr)new EntityAITFFlockToSameKind((of)this, 1.0));
        this.c.a(6, (pr)new ql((om)this, 1.0));
        this.c.a(7, (pr)new pw((of)this, (Class)ue.class, 8.0f));
        this.c.a(7, (pr)new qk((of)this));
        this.d.a(1, (pr)new qw((om)this, true));
        this.d.a(2, (pr)new qx((om)this, (Class)ue.class, 0, true));
    }
    
    public EntityTFKobold(final abv world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    protected void a() {
        super.a();
        this.ah.a(17, (Object)0);
    }
    
    protected boolean be() {
        return true;
    }
    
    protected void ay() {
        super.ay();
        this.a(to.a).a(13.0);
        this.a(to.d).a(0.28);
        this.a(to.e).a(4.0);
    }
    
    protected String r() {
        return "TwilightForest:mob.kobold.kobold";
    }
    
    protected String aN() {
        return "TwilightForest:mob.kobold.hurt";
    }
    
    protected String aO() {
        return "TwilightForest:mob.kobold.die";
    }
    
    protected int s() {
        return yb.V.cv;
    }
    
    protected void b(final boolean flag, final int i) {
        super.b(flag, i);
        if (this.ab.nextInt(2) == 0) {
            this.b(yb.bs.cv, 1 + i);
        }
    }
    
    public boolean isShy() {
        return this.shy && this.aT <= 0;
    }
    
    public boolean isPanicked() {
        return this.ah.a(17) != 0;
    }
    
    public void setPanicked(final boolean flag) {
        if (flag) {
            this.ah.b(17, (Object)127);
        }
        else {
            this.ah.b(17, (Object)0);
        }
    }
    
    public void c() {
        super.c();
        if (this.isPanicked()) {
            for (int i = 0; i < 2; ++i) {
                this.q.a("splash", this.u + (this.ab.nextDouble() - 0.5) * this.O * 0.5, this.v + this.f(), this.w + (this.ab.nextDouble() - 0.5) * this.O * 0.5, 0.0, 0.0, 0.0);
            }
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
}
