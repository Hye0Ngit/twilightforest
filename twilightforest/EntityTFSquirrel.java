// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityTFSquirrel extends mi implements lo
{
    public EntityTFSquirrel(final xv par1World) {
        super(par1World);
        this.aF = "/twilightforest/squirrel2.png";
        this.a(0.3f, 0.7f);
        this.X = 1.0f;
        this.az().a(true);
        this.bm.a(0, (nc)new mz((md)this));
        this.bm.a(1, (nc)new nt((mi)this, 0.38f));
        this.bm.a(2, (nc)new od((mi)this, 0.18f, uk.S.cg, true));
        this.bm.a(3, (nc)new mr((mi)this, (Class)qx.class, 2.0f, 0.23f, 0.4f));
        this.bm.a(5, (nc)new nw((mi)this, 0.25f));
        this.bm.a(6, (nc)new nw((mi)this, 0.38f));
        this.bm.a(7, (nc)new nh((md)this, (Class)qx.class, 6.0f));
        this.bm.a(8, (nc)new nv((md)this));
    }
    
    public int aT() {
        return 1;
    }
    
    protected void a(final float par1) {
    }
    
    public boolean be() {
        return true;
    }
    
    public float bt() {
        return 0.3f;
    }
    
    public float a(final int par1, final int par2, final int par3) {
        final agb underMaterial = this.p.g(par1, par2 - 1, par3);
        if (underMaterial == agb.j) {
            return 12.0f;
        }
        if (underMaterial == agb.d) {
            return 15.0f;
        }
        if (underMaterial == agb.b) {
            return 10.0f;
        }
        return this.p.p(par1, par2, par3) - 0.5f;
    }
    
    protected boolean bj() {
        return false;
    }
    
    public void a(final lh par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.f() instanceof qx) {
            ((qx)par1DamageSource.f()).a((jl)TFAchievementPage.twilightHunter);
        }
    }
}
