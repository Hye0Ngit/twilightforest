// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityTFHedgeSpider extends cb
{
    public EntityTFHedgeSpider(final xd world) {
        super(world);
        this.bm = "/twilightforest/hedgespider.png";
    }
    
    public EntityTFHedgeSpider(final xd world, final double x, final double y, final double z) {
        this(world);
        this.d(x, y, z);
    }
    
    public boolean i() {
        final int chunkX = gk.c(this.o) >> 4;
        final int chunkZ = gk.c(this.q) >> 4;
        if (TFFeature.getNearestFeature(chunkX, chunkZ, this.k) == TFFeature.hedgeMaze) {
            return this.k.a(this.y) && this.k.a((nn)this, this.y).size() == 0 && !this.k.b(this.y);
        }
        return super.i();
    }
    
    public void a(final md par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.b() instanceof yw) {
            ((yw)par1DamageSource.b()).a((ajw)TFAchievementPage.twilightHunter);
            final int chunkX = gk.c(this.o) >> 4;
            final int chunkZ = gk.c(this.q) >> 4;
            if (TFFeature.getNearestFeature(chunkX, chunkZ, this.k) == TFFeature.hedgeMaze) {
                ((yw)par1DamageSource.b()).a((ajw)TFAchievementPage.twilightHedge);
            }
        }
    }
}
