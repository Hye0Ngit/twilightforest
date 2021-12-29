// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityTFSwarmSpider extends cb
{
    public EntityTFSwarmSpider(final xd world) {
        this(world, true);
    }
    
    public EntityTFSwarmSpider(final xd world, final boolean spawnMore) {
        super(world);
        this.a(0.8f, 0.4f);
        this.c = 0;
        this.bx = 3;
        this.setSpawnMore(spawnMore);
        this.bm = "/twilightforest/swarmspider.png";
        this.bI = 2;
    }
    
    public EntityTFSwarmSpider(final xd world, final double x, final double y, final double z) {
        this(world);
        this.d(x, y, z);
    }
    
    public int d() {
        return 3;
    }
    
    public float r() {
        return 0.5f;
    }
    
    public float bd() {
        return 0.5f;
    }
    
    public void J_() {
        if (this.shouldSpawnMore()) {
            if (!this.k.F) {
                for (int more = 1 + this.U.nextInt(2), i = 0; i < more; ++i) {
                    if (!this.spawnAnother()) {
                        this.spawnAnother();
                    }
                }
            }
            this.setSpawnMore(false);
        }
        super.J_();
    }
    
    protected void b() {
        super.b();
        this.ac.a(17, (Object)0);
    }
    
    protected void a(final nn entity, final float f) {
        this.c = ((!this.z && this.U.nextInt(4) == 0) ? 1 : 0);
        super.a(entity, f);
    }
    
    protected boolean spawnAnother() {
        final EntityTFSwarmSpider another = new EntityTFSwarmSpider(this.k, false);
        final double sx = this.o + (this.U.nextDouble() - this.U.nextDouble()) * 4.0;
        final double sy = this.p + this.U.nextInt(3) - 1.0;
        final double sz = this.q + (this.k.r.nextDouble() - this.U.nextDouble()) * 4.0;
        another.c(sx, sy, sz, this.U.nextFloat() * 360.0f, 0.0f);
        if (!another.i()) {
            return false;
        }
        this.k.a((nn)another);
        return true;
    }
    
    public boolean i() {
        final int chunkX = gk.c(this.o) >> 4;
        final int chunkZ = gk.c(this.q) >> 4;
        if (TFFeature.getNearestFeature(chunkX, chunkZ, this.k) == TFFeature.hedgeMaze) {
            return this.k.a(this.y) && this.k.a((nn)this, this.y).size() == 0 && !this.k.b(this.y);
        }
        return super.i();
    }
    
    public boolean shouldSpawnMore() {
        return (this.ac.a(17) & 0x1) != 0x0;
    }
    
    public void setSpawnMore(final boolean flag) {
        final byte byte0 = this.ac.a(17);
        if (flag) {
            this.ac.b(17, (Object)(byte)(byte0 | 0x1));
        }
        else {
            this.ac.b(17, (Object)(byte)(byte0 & 0xFFFFFFFE));
        }
    }
    
    public void b(final ady nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.a("SpawnMore", this.shouldSpawnMore());
    }
    
    public void a(final ady nbttagcompound) {
        super.a(nbttagcompound);
        this.setSpawnMore(nbttagcompound.o("SpawnMore"));
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
