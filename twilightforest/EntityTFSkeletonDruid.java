// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityTFSkeletonDruid extends yy
{
    private static final aan defaultHeldItem;
    
    public EntityTFSkeletonDruid(final xd world) {
        super(world);
        this.bm = "/twilightforest/skeletondruid.png";
        this.cj = 0.25f;
        this.bT.a(1, (rc)new aje((acq)this));
        this.bT.a(2, (rc)new ajt((aaa)this));
        this.bT.a(3, (rc)new na((aaa)this, this.cj));
        this.bT.a(4, (rc)new EntityAITFMagicAttack((acq)this, this.cj, 1, 60));
        this.bT.a(5, (rc)new acu((aaa)this, this.cj));
        this.bT.a(6, (rc)new ob((acq)this, (Class)yw.class, 8.0f));
        this.bT.a(6, (rc)new bd((acq)this));
        this.bU.a(1, (rc)new zy((acq)this, false));
        this.bU.a(2, (rc)new amf((acq)this, (Class)yw.class, 16.0f, 0, true));
    }
    
    public boolean b_() {
        return true;
    }
    
    public int d() {
        return 20;
    }
    
    protected String m() {
        return "mob.skeleton";
    }
    
    protected String n() {
        return "mob.skeletonhurt";
    }
    
    protected String o() {
        return "mob.skeletonhurt";
    }
    
    public void b(final ady nbttagcompound) {
        super.b(nbttagcompound);
    }
    
    public void a(final ady nbttagcompound) {
        super.a(nbttagcompound);
    }
    
    protected int f() {
        return yr.R.bQ;
    }
    
    protected void dropFewItems() {
        if (this.U.nextInt(3) == 0) {
            this.b(yr.D.bQ, 1);
        }
        for (int i = this.U.nextInt(3), k = 0; k < i; ++k) {
            this.b(yr.aX.bQ, 1);
        }
    }
    
    public aan ae() {
        return EntityTFSkeletonDruid.defaultHeldItem;
    }
    
    public void a(final md par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.b() instanceof yw) {
            ((yw)par1DamageSource.b()).a((ajw)TFAchievementPage.twilightHunter);
        }
    }
    
    static {
        defaultHeldItem = new aan(yr.R, 1);
    }
}
