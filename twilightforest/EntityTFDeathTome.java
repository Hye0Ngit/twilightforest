// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityTFDeathTome extends qj
{
    public EntityTFDeathTome(final xv par1World) {
        super(par1World);
        this.aF = "/item/book.png";
        this.bG = 0.25f;
        this.bm.a(0, (nc)new mz((md)this));
        this.bm.a(4, (nc)new EntityAITFMagicAttack((md)this, this.bG, 2, 60));
        this.bm.a(5, (nc)new nw((mi)this, this.bG));
        this.bm.a(6, (nc)new nh((md)this, (Class)qx.class, 8.0f));
        this.bm.a(6, (nc)new nv((md)this));
        this.bn.a(1, (nc)new og((md)this, false));
        this.bn.a(2, (nc)new oh((md)this, (Class)qx.class, 16.0f, 0, true));
    }
    
    public int c(final lq par1Entity) {
        return 4;
    }
    
    protected boolean be() {
        return true;
    }
    
    public int aT() {
        return 30;
    }
    
    public void c() {
        super.c();
        for (int i = 0; i < 1; ++i) {
            this.p.a("enchantmenttable", this.t + (this.aa.nextDouble() - 0.5) * this.N, this.u + this.aa.nextDouble() * (this.O - 0.75) + 0.5, this.v + (this.aa.nextDouble() - 0.5) * this.N, 0.0, 0.5, 0.0);
        }
    }
    
    public boolean a(final lh par1DamageSource, int par2) {
        if (par1DamageSource.k()) {
            par2 *= 2;
        }
        if (super.a(par1DamageSource, par2)) {
            if (this.aa.nextInt(2) == 0) {
                this.a(uk.aK.cg, 1, 1.0f);
            }
            return true;
        }
        return false;
    }
    
    protected int bb() {
        return uk.aK.cg;
    }
    
    protected void a(final boolean par1, final int par2) {
        for (int var3 = this.aa.nextInt(3 + par2), var4 = 0; var4 < var3; ++var4) {
            this.b(uk.aK.cg, 1);
        }
        if (this.aa.nextInt(5) - par2 <= 0) {
            this.b(uk.bF.cg, 1);
        }
        else {
            this.b(uk.aL.cg, 1);
        }
    }
    
    protected void l(final int par1) {
        this.b(TFItems.magicMapFocus.cg, 1);
    }
    
    public void a(final lh par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.f() instanceof qx) {
            ((qx)par1DamageSource.f()).a((jl)TFAchievementPage.twilightHunter);
        }
    }
}
