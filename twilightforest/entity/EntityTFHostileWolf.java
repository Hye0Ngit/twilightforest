// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFFeature;
import twilightforest.TFAchievementPage;

public class EntityTFHostileWolf extends qo implements rq
{
    public EntityTFHostileWolf(final zv world) {
        super(world);
        this.l(true);
        this.bp.a(4, (og)new pl((ng)this, (Class)sk.class, 16.0f, 0, true));
    }
    
    public EntityTFHostileWolf(final zv world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    public int aW() {
        return 10;
    }
    
    public void l_() {
        super.l_();
        if (!this.q.I && this.q.r == 0) {
            this.w();
        }
    }
    
    public void a(final mg par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof sk) {
            ((sk)par1DamageSource.h()).a((ka)TFAchievementPage.twilightHunter);
        }
    }
    
    public boolean bv() {
        final int chunkX = kx.c(this.u) >> 4;
        final int chunkZ = kx.c(this.w) >> 4;
        if (TFFeature.getNearestFeature(chunkX, chunkZ, this.q) == TFFeature.hedgeMaze) {
            return this.q.b(this.E) && this.q.a((mp)this, this.E).size() == 0 && !this.q.d(this.E);
        }
        return this.isValidMobLightLevel() && this.q.b(this.E) && this.q.a((mp)this, this.E).size() == 0 && !this.q.d(this.E);
    }
    
    protected boolean isValidMobLightLevel() {
        final int var1 = kx.c(this.u);
        final int var2 = kx.c(this.E.b);
        final int var3 = kx.c(this.w);
        if (this.q.b(aag.a, var1, var2, var3) > this.ab.nextInt(32)) {
            return false;
        }
        int var4 = this.q.n(var1, var2, var3);
        if (this.q.N()) {
            final int var5 = this.q.j;
            this.q.j = 10;
            var4 = this.q.n(var1, var2, var3);
            this.q.j = var5;
        }
        return var4 <= this.ab.nextInt(8);
    }
    
    public boolean c(final wg par1ItemStack) {
        return false;
    }
    
    public boolean a_(final sk par1EntityPlayer) {
        return false;
    }
}
