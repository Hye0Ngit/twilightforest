// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityTFPenguin extends EntityTFBird
{
    public EntityTFPenguin(final xv world) {
        super(world);
        this.aF = "/twilightforest/penguin.png";
        this.bm.a(0, (nc)new mz((md)this));
        this.bm.a(1, (nc)new nt((mi)this, 0.38f));
        this.bm.a(2, (nc)new mu((ox)this, 0.25f));
        this.bm.a(3, (nc)new od((mi)this, 0.25f, uk.aU.cg, false));
        this.bm.a(4, (nc)new nb((ox)this, 0.28f));
        this.bm.a(5, (nc)new nw((mi)this, 0.25f));
        this.bm.a(6, (nc)new nh((md)this, (Class)qx.class, 6.0f));
        this.bm.a(7, (nc)new nf((md)this, (Class)EntityTFPenguin.class, 5.0f, 0.02f));
        this.bm.a(8, (nc)new nv((md)this));
    }
    
    public EntityTFPenguin(final xv world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    protected String aY() {
        return null;
    }
    
    @Override
    public ox func_90011_a(final ln entityanimal) {
        return new EntityTFPenguin(this.p);
    }
    
    public boolean isWheat(final um par1ItemStack) {
        return par1ItemStack != null && par1ItemStack.c == uk.aU.cg;
    }
    
    public void a(final lh par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.f() instanceof qx) {
            ((qx)par1DamageSource.f()).a((jl)TFAchievementPage.twilightHunter);
        }
    }
    
    public int aT() {
        return 10;
    }
}
