// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityTFHostileWolf extends pk
{
    public EntityTFHostileWolf(final xv world) {
        super(world);
        this.i(true);
        this.aQ = 10;
        this.bn.a(4, (nc)new oh((md)this, (Class)qx.class, 16.0f, 0, true));
    }
    
    public EntityTFHostileWolf(final xv world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    public void j_() {
        super.j_();
        if (!this.p.J && this.p.t == 0) {
            this.x();
        }
    }
    
    public void a(final lh par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.f() instanceof qx) {
            ((qx)par1DamageSource.f()).a((jl)TFAchievementPage.twilightHunter);
        }
    }
    
    public boolean bs() {
        final int chunkX = ke.c(this.t) >> 4;
        final int chunkZ = ke.c(this.v) >> 4;
        if (TFFeature.getNearestFeature(chunkX, chunkZ, this.p) == TFFeature.hedgeMaze) {
            return this.p.b(this.D) && this.p.a((lq)this, this.D).size() == 0 && !this.p.d(this.D);
        }
        return this.isValidMobLightLevel() && this.p.b(this.D) && this.p.a((lq)this, this.D).size() == 0 && !this.p.d(this.D);
    }
    
    protected boolean isValidMobLightLevel() {
        final int var1 = ke.c(this.t);
        final int var2 = ke.c(this.D.b);
        final int var3 = ke.c(this.v);
        if (this.p.b(yh.a, var1, var2, var3) > this.aa.nextInt(32)) {
            return false;
        }
        int var4 = this.p.m(var1, var2, var3);
        if (this.p.M()) {
            final int var5 = this.p.j;
            this.p.j = 10;
            var4 = this.p.m(var1, var2, var3);
            this.p.j = var5;
        }
        return var4 <= this.aa.nextInt(8);
    }
}
