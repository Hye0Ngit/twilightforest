// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFAchievementPage;
import twilightforest.TFFeature;

public class EntityTFSwarmSpider extends sb
{
    protected boolean shouldSpawn;
    
    public EntityTFSwarmSpider(final zv world) {
        this(world, true);
    }
    
    public EntityTFSwarmSpider(final zv world, final boolean spawnMore) {
        super(world);
        this.shouldSpawn = false;
        this.a(0.8f, 0.4f);
        this.setSpawnMore(spawnMore);
        this.aH = "/mods/twilightforest/textures/model/swarmspider.png";
        this.be = 2;
    }
    
    public EntityTFSwarmSpider(final zv world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    public int aW() {
        return 3;
    }
    
    public float m() {
        return 0.5f;
    }
    
    public float bw() {
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
    
    protected void a(final mp entity, final float f) {
        super.a(entity, f);
    }
    
    protected mp j() {
        final double var2 = 16.0;
        return (mp)this.q.b((mp)this, var2);
    }
    
    public int c(final mp par1Entity) {
        return (!this.F && this.ab.nextInt(4) == 0) ? 1 : 0;
    }
    
    protected boolean spawnAnother() {
        final EntityTFSwarmSpider another = new EntityTFSwarmSpider(this.q, false);
        final double sx = this.u + (this.ab.nextBoolean() ? 0.9 : -0.9);
        final double sy = this.v;
        final double sz = this.w + (this.ab.nextBoolean() ? 0.9 : -0.9);
        another.b(sx, sy, sz, this.ab.nextFloat() * 360.0f, 0.0f);
        if (!another.bv()) {
            another.w();
            return false;
        }
        this.q.d((mp)another);
        return true;
    }
    
    protected boolean i_() {
        final int chunkX = kx.c(this.u) >> 4;
        final int chunkZ = kx.c(this.w) >> 4;
        return TFFeature.getNearestFeature(chunkX, chunkZ, this.q) == TFFeature.hedgeMaze || super.i_();
    }
    
    public boolean shouldSpawnMore() {
        return this.shouldSpawn;
    }
    
    public void setSpawnMore(final boolean flag) {
        this.shouldSpawn = flag;
    }
    
    public void b(final bs nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.a("SpawnMore", this.shouldSpawnMore());
    }
    
    public void a(final bs nbttagcompound) {
        super.a(nbttagcompound);
        this.setSpawnMore(nbttagcompound.n("SpawnMore"));
    }
    
    public void a(final mg par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof sk) {
            ((sk)par1DamageSource.h()).a((ka)TFAchievementPage.twilightHunter);
            final int chunkX = kx.c(this.u) >> 4;
            final int chunkZ = kx.c(this.w) >> 4;
            if (TFFeature.getNearestFeature(chunkX, chunkZ, this.q) == TFFeature.hedgeMaze) {
                ((sk)par1DamageSource.h()).a((ka)TFAchievementPage.twilightHedge);
            }
        }
    }
    
    public int by() {
        return 16;
    }
}
