// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFSwarmSpider extends bz
{
    public EntityTFSwarmSpider(final wz world) {
        this(world, true);
    }
    
    public EntityTFSwarmSpider(final wz world, final boolean spawnMore) {
        super(world);
        this.a(0.8f, 0.4f);
        this.c = 0;
        this.bx = 3;
        this.setSpawnMore(spawnMore);
        this.bm = "/twilightforest/swarmspider.png";
        this.bI = 2;
    }
    
    public int d() {
        return 3;
    }
    
    public void I_() {
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
        super.I_();
    }
    
    protected void b() {
        super.b();
        this.ac.a(17, (Object)0);
    }
    
    protected void a(final nk entity, final float f) {
        this.c = ((!this.z && this.U.nextInt(4) == 0) ? 1 : 0);
        super.a(entity, f);
    }
    
    protected boolean spawnAnother() {
        final EntityTFSwarmSpider another = new EntityTFSwarmSpider(this.k, false);
        final double sx = this.o + (this.U.nextDouble() - this.U.nextDouble()) * 4.0;
        final double sy = this.p + this.U.nextInt(3) - 1.0;
        final double sz = this.q + (this.k.r.nextDouble() - this.U.nextDouble()) * 4.0;
        another.c(sx, sy, sz, this.U.nextFloat() * 360.0f, 0.0f);
        if (!another.h()) {
            return false;
        }
        this.k.a((nk)another);
        return true;
    }
    
    public boolean h() {
        return this.k.a(this.y) && this.k.a((nk)this, this.y).size() == 0 && !this.k.b(this.y);
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
    
    public void b(final adt nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.a("SpawnMore", this.shouldSpawnMore());
    }
    
    public void a(final adt nbttagcompound) {
        super.a(nbttagcompound);
        this.setSpawnMore(nbttagcompound.o("SpawnMore"));
    }
}
