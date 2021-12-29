// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFAchievementPage;
import twilightforest.TFFeature;

public class EntityTFSwarmSpider extends ts
{
    protected boolean shouldSpawn;
    
    public EntityTFSwarmSpider(final abv world) {
        this(world, true);
    }
    
    public EntityTFSwarmSpider(final abv world, final boolean spawnMore) {
        super(world);
        this.shouldSpawn = false;
        this.a(0.8f, 0.4f);
        this.setSpawnMore(spawnMore);
        this.b = 2;
    }
    
    public EntityTFSwarmSpider(final abv world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    protected void ay() {
        super.ay();
        this.a(to.a).a(3.0);
        this.a(to.e).a(1.0);
    }
    
    public float spiderScaleAmount() {
        return 0.5f;
    }
    
    public float bt() {
        return 0.5f;
    }
    
    public void l_() {
        if (this.shouldSpawnMore()) {
            if (!this.q.I) {
                for (int more = 1 + this.ab.nextInt(2), i = 0; i < more; ++i) {
                    if (!this.spawnAnother()) {
                        this.spawnAnother();
                    }
                }
            }
            this.setSpawnMore(false);
        }
        super.l_();
    }
    
    protected void a(final nm entity, final float f) {
        super.a(entity, f);
    }
    
    protected nm bL() {
        final double var2 = 16.0;
        return (nm)this.q.b((nm)this, var2);
    }
    
    protected boolean spawnAnother() {
        final EntityTFSwarmSpider another = new EntityTFSwarmSpider(this.q, false);
        final double sx = this.u + (this.ab.nextBoolean() ? 0.9 : -0.9);
        final double sy = this.v;
        final double sz = this.w + (this.ab.nextBoolean() ? 0.9 : -0.9);
        another.b(sx, sy, sz, this.ab.nextFloat() * 360.0f, 0.0f);
        if (!another.bs()) {
            another.w();
            return false;
        }
        this.q.d((nm)another);
        return true;
    }
    
    protected boolean i_() {
        final int chunkX = lr.c(this.u) >> 4;
        final int chunkZ = lr.c(this.w) >> 4;
        return TFFeature.getNearestFeature(chunkX, chunkZ, this.q) == TFFeature.hedgeMaze || super.i_();
    }
    
    public boolean shouldSpawnMore() {
        return this.shouldSpawn;
    }
    
    public void setSpawnMore(final boolean flag) {
        this.shouldSpawn = flag;
    }
    
    public void b(final bx nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.a("SpawnMore", this.shouldSpawnMore());
    }
    
    public void a(final bx nbttagcompound) {
        super.a(nbttagcompound);
        this.setSpawnMore(nbttagcompound.n("SpawnMore"));
    }
    
    public void a(final na par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof ue) {
            ((ue)par1DamageSource.h()).a((kt)TFAchievementPage.twilightHunter);
            final int chunkX = lr.c(this.u) >> 4;
            final int chunkZ = lr.c(this.w) >> 4;
            if (TFFeature.getNearestFeature(chunkX, chunkZ, this.q) == TFFeature.hedgeMaze) {
                ((ue)par1DamageSource.h()).a((kt)TFAchievementPage.twilightHedge);
            }
        }
    }
    
    public int bv() {
        return 16;
    }
}
