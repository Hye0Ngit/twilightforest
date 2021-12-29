// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFHedgeSpider extends dg
{
    public EntityTFHedgeSpider(final ge world) {
        super(world);
        this.ae = "/twilightforest/hedgespider.png";
    }
    
    public EntityTFHedgeSpider(final ge world, final double x, final double y, final double z) {
        this(world);
        this.c(x, y, z);
    }
    
    public boolean l() {
        final int chunkX = kb.b(this.bm) >> 4;
        final int chunkZ = kb.b(this.bo) >> 4;
        if (TFFeature.getNearestFeature(chunkX, chunkZ, this.bi) == TFFeature.hedgeMaze) {
            return this.bi.a(this.bw) && this.bi.a((tv)this, this.bw).size() == 0 && !this.bi.c(this.bw);
        }
        return super.l();
    }
    
    public void a(final rq par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.b() instanceof ih) {
            ((ih)par1DamageSource.b()).a((xo)TFAchievementPage.twilightHunter);
            final int chunkX = kb.b(this.bm) >> 4;
            final int chunkZ = kb.b(this.bo) >> 4;
            if (TFFeature.getNearestFeature(chunkX, chunkZ, this.bi) == TFFeature.hedgeMaze) {
                ((ih)par1DamageSource.b()).a((xo)TFAchievementPage.twilightHedge);
            }
        }
    }
}
