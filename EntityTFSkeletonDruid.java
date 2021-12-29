// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFSkeletonDruid extends yt
{
    private static final aai defaultHeldItem;
    
    public EntityTFSkeletonDruid(final wz world) {
        super(world);
        this.bm = "/twilightforest/skeletondruid.png";
    }
    
    public int d() {
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
    
    public void e() {
        if (this.k.m()) {
            final float f = this.a(1.0f);
            if (f <= 0.5f || !this.k.m(gh.c(this.o), gh.c(this.p), gh.c(this.q)) || this.U.nextFloat() * 30.0f < (f - 0.4f) * 2.0f) {}
        }
        super.e();
    }
    
    protected void a(final nk targetedEntity, final float f) {
        final double tx = targetedEntity.o - this.o;
        final double ty = targetedEntity.y.b + targetedEntity.J / 2.0f - (this.p + this.J / 2.0f);
        final double tz = targetedEntity.q - this.q;
        if (this.m(targetedEntity) && this.bE == 0 && f < 10.0f) {
            this.k.a((nk)this, "mob.ghast.fireball", this.A_(), (this.U.nextFloat() - this.U.nextFloat()) * 0.2f + 1.0f);
            final EntityTFProjectile projectile = new EntityTFNatureBolt(this.k, (acl)this, tx, ty, tz);
            this.k.a((nk)projectile);
            this.bE = 40;
        }
        this.ap = true;
    }
    
    public void b(final adt nbttagcompound) {
        super.b(nbttagcompound);
    }
    
    public void a(final adt nbttagcompound) {
        super.a(nbttagcompound);
    }
    
    protected int f() {
        return ym.R.bQ;
    }
    
    protected void dropFewItems() {
        if (this.U.nextInt(3) == 0) {
            this.b(ym.D.bQ, 1);
        }
        for (int i = this.U.nextInt(3), k = 0; k < i; ++k) {
            this.b(ym.aX.bQ, 1);
        }
    }
    
    public aai ae() {
        return EntityTFSkeletonDruid.defaultHeldItem;
    }
    
    static {
        defaultHeldItem = new aai(ym.R, 1);
    }
}
