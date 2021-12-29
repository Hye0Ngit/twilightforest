// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFSkeletonDruid extends zo
{
    private static final dk defaultHeldItem;
    
    public EntityTFSkeletonDruid(final ry world) {
        super(world);
        this.aA = "/twilightforest/skeletondruid.png";
    }
    
    public int f_() {
        return 20;
    }
    
    protected String e() {
        return "mob.skeleton";
    }
    
    protected String f() {
        return "mob.skeletonhurt";
    }
    
    protected String g() {
        return "mob.skeletonhurt";
    }
    
    public void c() {
        if (this.o.l()) {
            final float f = this.b(1.0f);
            if (f <= 0.5f || !this.o.l(me.c(this.s), me.c(this.t), me.c(this.u)) || this.Y.nextFloat() * 30.0f < (f - 0.4f) * 2.0f) {}
        }
        super.c();
    }
    
    protected void a(final ia targetedEntity, final float f) {
        final double tx = targetedEntity.s - this.s;
        final double ty = targetedEntity.C.b + targetedEntity.N / 2.0f - (this.t + this.N / 2.0f);
        final double tz = targetedEntity.u - this.u;
        if (this.i(targetedEntity) && this.aT == 0 && f < 10.0f) {
            this.o.a((ia)this, "mob.ghast.fireball", this.w_(), (this.Y.nextFloat() - this.Y.nextFloat()) * 0.2f + 1.0f);
            final EntityTFProjectile projectile = new EntityTFNatureBolt(this.o, (nq)this, tx, ty, tz);
            this.o.a((ia)projectile);
            this.aT = 40;
        }
        this.i = true;
    }
    
    public void a(final ik nbttagcompound) {
        super.a(nbttagcompound);
    }
    
    public void b(final ik nbttagcompound) {
        super.b(nbttagcompound);
    }
    
    protected int k() {
        return acy.Q.bM;
    }
    
    protected void dropFewItems() {
        if (this.Y.nextInt(3) == 0) {
            this.b(acy.C.bM, 1);
        }
        for (int i = this.Y.nextInt(3), k = 0; k < i; ++k) {
            this.b(acy.aW.bM, 1);
        }
    }
    
    public dk s() {
        return EntityTFSkeletonDruid.defaultHeldItem;
    }
    
    static {
        defaultHeldItem = new dk(acy.Q, 1);
    }
}
