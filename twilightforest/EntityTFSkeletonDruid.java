// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityTFSkeletonDruid extends qj
{
    private static final um defaultHeldItem;
    
    public EntityTFSkeletonDruid(final xv world) {
        super(world);
        this.aF = "/twilightforest/skeletondruid.png";
        this.bG = 0.25f;
        this.bm.a(1, (nc)new mz((md)this));
        this.bm.a(2, (nc)new nz((mi)this));
        this.bm.a(3, (nc)new my((mi)this, this.bG));
        this.bm.a(4, (nc)new EntityAITFMagicAttack((md)this, this.bG, 1, 60));
        this.bm.a(5, (nc)new nw((mi)this, this.bG));
        this.bm.a(6, (nc)new nh((md)this, (Class)qx.class, 8.0f));
        this.bm.a(6, (nc)new nv((md)this));
        this.bn.a(1, (nc)new og((md)this, false));
        this.bn.a(2, (nc)new oh((md)this, (Class)qx.class, 16.0f, 0, true));
    }
    
    public boolean be() {
        return true;
    }
    
    public int aT() {
        return 20;
    }
    
    protected String aY() {
        return "mob.skeleton";
    }
    
    protected String aZ() {
        return "mob.skeletonhurt";
    }
    
    protected String ba() {
        return "mob.skeletonhurt";
    }
    
    public void b(final bq nbttagcompound) {
        super.b(nbttagcompound);
    }
    
    public void a(final bq nbttagcompound) {
        super.a(nbttagcompound);
    }
    
    protected int bb() {
        return uk.R.cg;
    }
    
    protected void dropFewItems() {
        if (this.aa.nextInt(3) == 0) {
            this.b(uk.D.cg, 1);
        }
        for (int i = this.aa.nextInt(3), k = 0; k < i; ++k) {
            this.b(uk.aX.cg, 1);
        }
    }
    
    public um bD() {
        return EntityTFSkeletonDruid.defaultHeldItem;
    }
    
    public void a(final lh par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.f() instanceof qx) {
            ((qx)par1DamageSource.f()).a((jl)TFAchievementPage.twilightHunter);
        }
    }
    
    static {
        defaultHeldItem = new um(uk.R, 1);
    }
}
