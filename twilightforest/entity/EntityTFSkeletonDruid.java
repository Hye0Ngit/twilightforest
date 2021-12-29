// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFAchievementPage;
import twilightforest.entity.ai.EntityAITFMagicAttack;

public class EntityTFSkeletonDruid extends qj
{
    private static final ur defaultHeldItem;
    
    public EntityTFSkeletonDruid(final yc world) {
        super(world);
        this.aG = "/twilightforest/skeletondruid.png";
        this.bH = 0.25f;
        this.bn.a(1, (nc)new mz((md)this));
        this.bn.a(2, (nc)new nz((mi)this));
        this.bn.a(3, (nc)new my((mi)this, this.bH));
        this.bn.a(4, (nc)new EntityAITFMagicAttack((md)this, this.bH, 1, 60));
        this.bn.a(5, (nc)new nw((mi)this, this.bH));
        this.bn.a(6, (nc)new nh((md)this, (Class)qx.class, 8.0f));
        this.bn.a(6, (nc)new nv((md)this));
        this.bo.a(1, (nc)new og((md)this, false));
        this.bo.a(2, (nc)new oh((md)this, (Class)qx.class, 16.0f, 0, true));
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
        return up.R.cj;
    }
    
    protected void dropFewItems() {
        if (this.aa.nextInt(3) == 0) {
            this.b(up.D.cj, 1);
        }
        for (int i = this.aa.nextInt(3), k = 0; k < i; ++k) {
            this.b(up.aX.cj, 1);
        }
    }
    
    public ur bD() {
        return EntityTFSkeletonDruid.defaultHeldItem;
    }
    
    public void a(final lh par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.f() instanceof qx) {
            ((qx)par1DamageSource.f()).a((jl)TFAchievementPage.twilightHunter);
        }
    }
    
    static {
        defaultHeldItem = new ur(up.R, 1);
    }
}
