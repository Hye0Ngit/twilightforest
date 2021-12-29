// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityTFSwarmSpider extends qp
{
    protected boolean shouldSpawn;
    
    public EntityTFSwarmSpider(final xv world) {
        this(world, true);
    }
    
    public EntityTFSwarmSpider(final xv world, final boolean spawnMore) {
        super(world);
        this.shouldSpawn = false;
        this.a(0.8f, 0.4f);
        this.aQ = 3;
        this.setSpawnMore(spawnMore);
        this.aF = "/twilightforest/swarmspider.png";
        this.bc = 2;
    }
    
    public EntityTFSwarmSpider(final xv world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    public int aT() {
        return 3;
    }
    
    public float m() {
        return 0.5f;
    }
    
    public float bt() {
        return 0.5f;
    }
    
    public void j_() {
        if (this.shouldSpawnMore()) {
            if (!this.p.J) {
                for (int more = 1 + this.aa.nextInt(2), i = 0; i < more; ++i) {
                    if (!this.spawnAnother()) {
                        this.spawnAnother();
                    }
                }
            }
            this.setSpawnMore(false);
        }
        super.j_();
    }
    
    protected void a(final lq entity, final float f) {
        super.a(entity, f);
    }
    
    protected lq j() {
        final double var2 = 16.0;
        return (lq)this.p.b((lq)this, var2);
    }
    
    public int c(final lq par1Entity) {
        return (!this.E && this.aa.nextInt(4) == 0) ? 1 : 0;
    }
    
    protected boolean spawnAnother() {
        final EntityTFSwarmSpider another = new EntityTFSwarmSpider(this.p, false);
        final double sx = this.t + (this.aa.nextDouble() - this.aa.nextDouble()) * 4.0;
        final double sy = this.u + this.aa.nextInt(3) - 1.0;
        final double sz = this.v + (this.p.u.nextDouble() - this.aa.nextDouble()) * 4.0;
        another.b(sx, sy, sz, this.aa.nextFloat() * 360.0f, 0.0f);
        if (!another.bs()) {
            return false;
        }
        this.p.d((lq)another);
        return true;
    }
    
    public boolean bs() {
        final int chunkX = ke.c(this.t) >> 4;
        final int chunkZ = ke.c(this.v) >> 4;
        if (TFFeature.getNearestFeature(chunkX, chunkZ, this.p) == TFFeature.hedgeMaze) {
            return this.p.b(this.D) && this.p.a((lq)this, this.D).size() == 0 && !this.p.d(this.D);
        }
        return super.bs();
    }
    
    public boolean shouldSpawnMore() {
        return this.shouldSpawn;
    }
    
    public void setSpawnMore(final boolean flag) {
        this.shouldSpawn = flag;
    }
    
    public void b(final bq nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.a("SpawnMore", this.shouldSpawnMore());
    }
    
    public void a(final bq nbttagcompound) {
        super.a(nbttagcompound);
        this.setSpawnMore(nbttagcompound.n("SpawnMore"));
    }
    
    public void a(final lh par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.f() instanceof qx) {
            ((qx)par1DamageSource.f()).a((jl)TFAchievementPage.twilightHunter);
            final int chunkX = ke.c(this.t) >> 4;
            final int chunkZ = ke.c(this.v) >> 4;
            if (TFFeature.getNearestFeature(chunkX, chunkZ, this.p) == TFFeature.hedgeMaze) {
                ((qx)par1DamageSource.f()).a((jl)TFAchievementPage.twilightHedge);
            }
        }
    }
}
