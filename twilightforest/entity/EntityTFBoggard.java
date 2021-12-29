// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFFeature;
import twilightforest.TFAchievementPage;
import twilightforest.item.TFItems;
import twilightforest.entity.ai.EntityAITFChargeAttack;

public class EntityTFBoggard extends tl
{
    private boolean shy;
    
    public EntityTFBoggard(final abv world) {
        super(world);
        this.a(0.8f, 1.1f);
        this.shy = true;
        this.c.a(0, (pr)new po((of)this));
        this.c.a(2, (pr)new EntityAITFChargeAttack((om)this, 2.0f));
        this.c.a(3, (pr)new pz((om)this, (Class)ue.class, 1.0, false));
        this.c.a(6, (pr)new ql((om)this, 1.0));
        this.c.a(7, (pr)new pw((of)this, (Class)ue.class, 8.0f));
        this.c.a(7, (pr)new qk((of)this));
        this.d.a(1, (pr)new qw((om)this, false));
        this.d.a(2, (pr)new qx((om)this, (Class)ue.class, 0, false));
    }
    
    public EntityTFBoggard(final abv world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    protected boolean be() {
        return true;
    }
    
    protected void ay() {
        super.ay();
        this.a(to.a).a(14.0);
        this.a(to.d).a(0.28);
        this.a(to.e).a(3.0);
    }
    
    protected String r() {
        return "TwilightForest:mob.redcap.redcap";
    }
    
    protected String aN() {
        return "TwilightForest:mob.redcap.redcaphurt";
    }
    
    protected String aO() {
        return "TwilightForest:mob.redcap.redcapdie";
    }
    
    protected int s() {
        return yb.ai.cv;
    }
    
    protected void b(final boolean flag, final int i) {
        if (this.ab.nextInt(5) == 0) {
            this.b(TFItems.mazeMapFocus.cv, 1 + i);
        }
        if (this.ab.nextInt(6) == 0) {
            this.b(yb.ai.cv, 1 + i);
        }
        if (this.ab.nextInt(9) == 0) {
            this.b(yb.i.cv, 1 + i);
        }
    }
    
    public boolean isShy() {
        return this.shy && this.aT <= 0;
    }
    
    public boolean isTargetLookingAtMe() {
        final double dx = this.u - this.j.u;
        final double dz = this.w - this.j.w;
        final float angle = (float)(Math.atan2(dz, dx) * 180.0 / 3.1415927410125732) - 90.0f;
        final float difference = lr.e((this.j.A - angle) % 360.0f);
        return difference < 60.0f || difference > 300.0f;
    }
    
    public void a(final na par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof ue) {
            ((ue)par1DamageSource.h()).a((kt)TFAchievementPage.twilightHunter);
            final int chunkX = lr.c(this.u) >> 4;
            final int chunkZ = lr.c(this.w) >> 4;
            if (TFFeature.getNearestFeature(chunkX, chunkZ, this.q) == TFFeature.hill1) {
                ((ue)par1DamageSource.h()).a((kt)TFAchievementPage.twilightHill1);
            }
        }
    }
    
    public void e(final float par1, final float par2) {
        super.e(par1, par2);
    }
}
