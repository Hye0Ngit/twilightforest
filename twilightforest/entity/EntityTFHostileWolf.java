// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFFeature;
import twilightforest.TFAchievementPage;

public class EntityTFHostileWolf extends se implements tg
{
    public EntityTFHostileWolf(final abv world) {
        super(world);
        this.l(true);
        this.d.a(4, (pr)new qx((om)this, (Class)ue.class, 0, true));
    }
    
    public EntityTFHostileWolf(final abv world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    protected void ay() {
        super.ay();
        this.a(to.a).a(10.0);
    }
    
    public void l_() {
        super.l_();
        if (!this.q.I && this.q.r == 0) {
            this.w();
        }
    }
    
    public void a(final na par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof ue) {
            ((ue)par1DamageSource.h()).a((kt)TFAchievementPage.twilightHunter);
        }
    }
    
    public boolean bs() {
        final int chunkX = lr.c(this.u) >> 4;
        final int chunkZ = lr.c(this.w) >> 4;
        if (TFFeature.getNearestFeature(chunkX, chunkZ, this.q) == TFFeature.hedgeMaze) {
            return this.q.b(this.E) && this.q.a((nm)this, this.E).size() == 0 && !this.q.d(this.E);
        }
        return this.isValidMobLightLevel() && this.q.b(this.E) && this.q.a((nm)this, this.E).size() == 0 && !this.q.d(this.E);
    }
    
    protected boolean isValidMobLightLevel() {
        final int var1 = lr.c(this.u);
        final int var2 = lr.c(this.E.b);
        final int var3 = lr.c(this.w);
        if (this.q.b(acg.a, var1, var2, var3) > this.ab.nextInt(32)) {
            return false;
        }
        int var4 = this.q.n(var1, var2, var3);
        if (this.q.P()) {
            final int var5 = this.q.j;
            this.q.j = 10;
            var4 = this.q.n(var1, var2, var3);
            this.q.j = var5;
        }
        return var4 <= this.ab.nextInt(8);
    }
    
    public boolean c(final yd par1ItemStack) {
        return false;
    }
    
    public boolean a(final ue par1EntityPlayer) {
        return false;
    }
}
