// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFSkeletonDruid extends ij
{
    private static final kp defaultHeldItem;
    
    public EntityTFSkeletonDruid(final ge world) {
        super(world);
        this.ae = "/twilightforest/skeletondruid.png";
        this.bb = 0.25f;
        this.aL.a(1, (zc)new wj((ne)this));
        this.aL.a(2, (zc)new xj((ka)this));
        this.aL.a(3, (zc)new td((ka)this, this.bb));
        this.aL.a(4, (zc)new EntityAITFMagicAttack((ne)this, this.bb, 1, 60));
        this.aL.a(5, (zc)new nk((ka)this, this.bb));
        this.aL.a(6, (zc)new ul((ne)this, (Class)ih.class, 8.0f));
        this.aL.a(6, (zc)new bs((ne)this));
        this.aM.a(1, (zc)new jx((ne)this, false));
        this.aM.a(2, (zc)new aba((ne)this, (Class)ih.class, 16.0f, 0, true));
    }
    
    public boolean c_() {
        return true;
    }
    
    public int d() {
        return 20;
    }
    
    protected String i() {
        return "mob.skeleton";
    }
    
    protected String j() {
        return "mob.skeletonhurt";
    }
    
    protected String k() {
        return "mob.skeletonhurt";
    }
    
    public void b(final ph nbttagcompound) {
        super.b(nbttagcompound);
    }
    
    public void a(final ph nbttagcompound) {
        super.a(nbttagcompound);
    }
    
    protected int f() {
        return id.Q.bP;
    }
    
    protected void dropFewItems() {
        if (this.bS.nextInt(3) == 0) {
            this.b(id.C.bP, 1);
        }
        for (int i = this.bS.nextInt(3), k = 0; k < i; ++k) {
            this.b(id.aW.bP, 1);
        }
    }
    
    public kp getHeldItem() {
        return EntityTFSkeletonDruid.defaultHeldItem;
    }
    
    public void a(final rq par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.b() instanceof ih) {
            ((ih)par1DamageSource.b()).a((xo)TFAchievementPage.twilightHunter);
        }
    }
    
    static {
        defaultHeldItem = new kp(id.Q, 1);
    }
}
