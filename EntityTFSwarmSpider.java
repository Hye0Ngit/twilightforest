// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFSwarmSpider extends cu
{
    public EntityTFSwarmSpider(final fq world) {
        this(world, true);
    }
    
    public EntityTFSwarmSpider(final fq world, final boolean spawnMore) {
        super(world);
        this.b(0.8f, 0.4f);
        this.c = 0;
        this.ap = 3;
        this.setSpawnMore(spawnMore);
        this.ae = "/twilightforest/swarmspider.png";
        this.aA = 2;
    }
    
    public int c() {
        return 3;
    }
    
    public void y_() {
        if (this.shouldSpawnMore()) {
            if (!this.bi.I) {
                for (int more = 1 + this.bS.nextInt(2), i = 0; i < more; ++i) {
                    if (!this.spawnAnother()) {
                        this.spawnAnother();
                    }
                }
            }
            this.setSpawnMore(false);
        }
        super.y_();
    }
    
    protected void b() {
        super.b();
        this.bY.a(17, (Object)0);
    }
    
    protected void a(final se entity, final float f) {
        this.c = ((!this.bx && this.bS.nextInt(4) == 0) ? 1 : 0);
        super.a(entity, f);
    }
    
    protected boolean spawnAnother() {
        final EntityTFSwarmSpider another = new EntityTFSwarmSpider(this.bi, false);
        final double sx = this.bm + (this.bS.nextDouble() - this.bS.nextDouble()) * 4.0;
        final double sy = this.bn + this.bS.nextInt(3) - 1.0;
        final double sz = this.bo + (this.bi.w.nextDouble() - this.bS.nextDouble()) * 4.0;
        another.c(sx, sy, sz, this.bS.nextFloat() * 360.0f, 0.0f);
        if (!another.g()) {
            return false;
        }
        this.bi.b((se)another);
        return true;
    }
    
    public boolean g() {
        return this.bi.a(this.bw) && this.bi.a((se)this, this.bw).size() == 0 && !this.bi.c(this.bw);
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
    
    public void b(final nu nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.a("SpawnMore", this.shouldSpawnMore());
    }
    
    public void a(final nu nbttagcompound) {
        super.a(nbttagcompound);
        this.setSpawnMore(nbttagcompound.n("SpawnMore"));
    }
}
