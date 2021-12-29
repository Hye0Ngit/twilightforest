// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityTFHostileWolf extends yo
{
    public EntityTFHostileWolf(final xd world) {
        super(world);
        this.g(true);
        this.bx = 10;
        this.bU.a(4, (rc)new amf((acq)this, (Class)yw.class, 16.0f, 0, true));
    }
    
    public EntityTFHostileWolf(final xd world, final double x, final double y, final double z) {
        this(world);
        this.d(x, y, z);
    }
    
    public void J_() {
        super.J_();
        if (!this.k.F && this.k.q == 0) {
            this.A();
        }
    }
    
    public void a(final md par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.b() instanceof yw) {
            ((yw)par1DamageSource.b()).a((ajw)TFAchievementPage.twilightHunter);
        }
    }
    
    public boolean i() {
        final int chunkX = gk.c(this.o) >> 4;
        final int chunkZ = gk.c(this.q) >> 4;
        if (TFFeature.getNearestFeature(chunkX, chunkZ, this.k) == TFFeature.hedgeMaze) {
            return this.k.a(this.y) && this.k.a((nn)this, this.y).size() == 0 && !this.k.b(this.y);
        }
        return this.isValidMobLightLevel() && this.k.a(this.y) && this.k.a((nn)this, this.y).size() == 0 && !this.k.b(this.y);
    }
    
    protected boolean isValidMobLightLevel() {
        final int var1 = gk.c(this.o);
        final int var2 = gk.c(this.y.b);
        final int var3 = gk.c(this.q);
        if (this.k.b(wl.a, var1, var2, var3) > this.U.nextInt(32)) {
            return false;
        }
        int var4 = this.k.o(var1, var2, var3);
        if (this.k.F()) {
            final int var5 = this.k.f;
            this.k.f = 10;
            var4 = this.k.o(var1, var2, var3);
            this.k.f = var5;
        }
        return var4 <= this.U.nextInt(8);
    }
}
