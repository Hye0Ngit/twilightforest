// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFSwarmSpider extends dg
{
    public EntityTFSwarmSpider(final ge world) {
        this(world, true);
    }
    
    public EntityTFSwarmSpider(final ge world, final boolean spawnMore) {
        super(world);
        this.b(0.8f, 0.4f);
        this.c = 0;
        this.ap = 3;
        this.setSpawnMore(spawnMore);
        this.ae = "/twilightforest/swarmspider.png";
        this.aA = 2;
    }
    
    public EntityTFSwarmSpider(final ge world, final double x, final double y, final double z) {
        this(world);
        this.c(x, y, z);
    }
    
    public int d() {
        return 3;
    }
    
    public void F_() {
        if (this.shouldSpawnMore()) {
            if (!this.bi.F) {
                for (int more = 1 + this.bS.nextInt(2), i = 0; i < more; ++i) {
                    if (!this.spawnAnother()) {
                        this.spawnAnother();
                    }
                }
            }
            this.setSpawnMore(false);
        }
        super.F_();
    }
    
    protected void b() {
        super.b();
        this.bY.a(17, (Object)0);
    }
    
    protected void a(final tv entity, final float f) {
        this.c = ((!this.bx && this.bS.nextInt(4) == 0) ? 1 : 0);
        super.a(entity, f);
    }
    
    protected boolean spawnAnother() {
        final EntityTFSwarmSpider another = new EntityTFSwarmSpider(this.bi, false);
        final double sx = this.bm + (this.bS.nextDouble() - this.bS.nextDouble()) * 4.0;
        final double sy = this.bn + this.bS.nextInt(3) - 1.0;
        final double sz = this.bo + (this.bi.r.nextDouble() - this.bS.nextDouble()) * 4.0;
        another.c(sx, sy, sz, this.bS.nextFloat() * 360.0f, 0.0f);
        if (!another.l()) {
            return false;
        }
        this.bi.b((tv)another);
        return true;
    }
    
    public boolean l() {
        final int chunkX = kb.b(this.bm) >> 4;
        final int chunkZ = kb.b(this.bo) >> 4;
        if (TFFeature.getNearestFeature(chunkX, chunkZ, this.bi) == TFFeature.hedgeMaze) {
            return this.bi.a(this.bw) && this.bi.a((tv)this, this.bw).size() == 0 && !this.bi.c(this.bw);
        }
        return super.l();
    }
    
    public boolean shouldSpawnMore() {
        return (this.bY.a(17) & 0x1) != 0x0;
    }
    
    public void setSpawnMore(final boolean flag) {
        final byte byte0 = this.bY.a(17);
        if (flag) {
            this.bY.b(17, (Object)(byte)(byte0 | 0x1));
        }
        else {
            this.bY.b(17, (Object)(byte)(byte0 & 0xFFFFFFFE));
        }
    }
    
    public void b(final ph nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.a("SpawnMore", this.shouldSpawnMore());
    }
    
    public void a(final ph nbttagcompound) {
        super.a(nbttagcompound);
        this.setSpawnMore(nbttagcompound.o("SpawnMore"));
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
