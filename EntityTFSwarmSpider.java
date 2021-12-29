// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFSwarmSpider extends vq
{
    public EntityTFSwarmSpider(final ry world) {
        this(world, true);
    }
    
    public EntityTFSwarmSpider(final ry world, final boolean spawnMore) {
        super(world);
        this.a(0.8f, 0.4f);
        this.a = 0;
        this.aM = 3;
        this.setSpawnMore(spawnMore);
        this.aA = "/twilightforest/swarmspider.png";
        this.aX = 2;
    }
    
    public int f_() {
        return 3;
    }
    
    public void a() {
        if (this.shouldSpawnMore()) {
            for (int more = 1 + this.Y.nextInt(2), i = 0; i < more; ++i) {
                if (!this.spawnAnother()) {
                    this.spawnAnother();
                }
            }
            this.setSpawnMore(false);
        }
        super.a();
    }
    
    protected void b() {
        super.b();
        this.ag.a(17, (Object)0);
    }
    
    protected void a(final ia entity, final float f) {
        this.a = ((!this.D && this.Y.nextInt(4) == 0) ? 1 : 0);
        super.a(entity, f);
    }
    
    protected boolean spawnAnother() {
        final EntityTFSwarmSpider another = new EntityTFSwarmSpider(this.o, false);
        final double sx = this.s + (this.Y.nextDouble() - this.Y.nextDouble()) * 4.0;
        final double sy = this.t + this.Y.nextInt(3) - 1.0;
        final double sz = this.u + (this.o.w.nextDouble() - this.Y.nextDouble()) * 4.0;
        another.c(sx, sy, sz, this.Y.nextFloat() * 360.0f, 0.0f);
        if (!another.i()) {
            return false;
        }
        this.o.a((ia)another);
        return true;
    }
    
    public boolean i() {
        return this.o.a(this.C) && this.o.a((ia)this, this.C).size() == 0 && !this.o.b(this.C);
    }
    
    public boolean shouldSpawnMore() {
        return (this.ag.a(17) & 0x1) != 0x0;
    }
    
    public void setSpawnMore(final boolean flag) {
        final byte byte0 = this.ag.a(17);
        if (flag) {
            this.ag.b(17, (Object)(byte)(byte0 | 0x1));
        }
        else {
            this.ag.b(17, (Object)(byte)(byte0 & 0xFFFFFFFE));
        }
    }
    
    public void a(final ik nbttagcompound) {
        super.a(nbttagcompound);
        nbttagcompound.a("SpawnMore", this.shouldSpawnMore());
    }
    
    public void b(final ik nbttagcompound) {
        super.b(nbttagcompound);
        this.setSpawnMore(nbttagcompound.m("SpawnMore"));
    }
}
