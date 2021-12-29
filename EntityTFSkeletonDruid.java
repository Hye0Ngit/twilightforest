// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFSkeletonDruid extends hm
{
    private static final jm defaultHeldItem;
    
    public EntityTFSkeletonDruid(final fq world) {
        super(world);
        this.ae = "/twilightforest/skeletondruid.png";
    }
    
    public int c() {
        return 20;
    }
    
    protected String c_() {
        return "mob.skeleton";
    }
    
    protected String m() {
        return "mob.skeletonhurt";
    }
    
    protected String n() {
        return "mob.skeletonhurt";
    }
    
    public void d() {
        if (this.bi.e()) {
            final float f = this.a(1.0f);
            if (f <= 0.5f || !this.bi.j(iy.b(this.bm), iy.b(this.bn), iy.b(this.bo)) || this.bS.nextFloat() * 30.0f < (f - 0.4f) * 2.0f) {}
        }
        super.d();
    }
    
    protected void a(final se targetedEntity, final float f) {
        final double tx = targetedEntity.bm - this.bm;
        final double ty = targetedEntity.bw.b + targetedEntity.bH / 2.0f - (this.bn + this.bH / 2.0f);
        final double tz = targetedEntity.bo - this.bo;
        if (this.g(targetedEntity) && this.aw == 0 && f < 10.0f) {
            this.bi.a((se)this, "mob.ghast.fireball", this.o(), (this.bS.nextFloat() - this.bS.nextFloat()) * 0.2f + 1.0f);
            final EntityTFProjectile projectile = new EntityTFNatureBolt(this.bi, (lx)this, tx, ty, tz);
            this.bi.b((se)projectile);
            this.aw = 40;
        }
        this.e = true;
    }
    
    public void b(final nu nbttagcompound) {
        super.b(nbttagcompound);
    }
    
    public void a(final nu nbttagcompound) {
        super.a(nbttagcompound);
    }
    
    protected int e() {
        return hg.Q.bN;
    }
    
    protected void dropFewItems() {
        if (this.bS.nextInt(3) == 0) {
            this.b(hg.C.bN, 1);
        }
        for (int i = this.bS.nextInt(3), k = 0; k < i; ++k) {
            this.b(hg.aW.bN, 1);
        }
    }
    
    public jm getHeldItem() {
        return EntityTFSkeletonDruid.defaultHeldItem;
    }
    
    static {
        defaultHeldItem = new jm(hg.Q, 1);
    }
}
