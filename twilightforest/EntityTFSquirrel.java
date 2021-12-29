// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityTFSquirrel extends bc
{
    public EntityTFSquirrel(final xd par1World) {
        super(par1World);
        this.bm = "/twilightforest/squirrel2.png";
        this.a(0.3f, 0.7f);
        this.R = 1.0f;
        this.aM().a(true);
        this.bT.a(0, (rc)new aje((acq)this));
        this.bT.a(1, (rc)new ke((aaa)this, 0.38f));
        this.bT.a(2, (rc)new akz((aaa)this, 0.18f, yr.S.bQ, true));
        this.bT.a(3, (rc)new fg((aaa)this, (Class)yw.class, 2.0f, 0.23f, 0.4f));
        this.bT.a(5, (rc)new acu((aaa)this, 0.25f));
        this.bT.a(6, (rc)new acu((aaa)this, 0.38f));
        this.bT.a(7, (rc)new ob((acq)this, (Class)yw.class, 6.0f));
        this.bT.a(8, (rc)new bd((acq)this));
    }
    
    public int d() {
        return 1;
    }
    
    protected void e(final float par1) {
    }
    
    public boolean b_() {
        return true;
    }
    
    public float bd() {
        return 0.3f;
    }
    
    public bc a(final bc var1) {
        return null;
    }
    
    public float a(final int par1, final int par2, final int par3) {
        final acn underMaterial = this.k.f(par1, par2 - 1, par3);
        if (underMaterial == acn.i) {
            return 12.0f;
        }
        if (underMaterial == acn.d) {
            return 15.0f;
        }
        if (underMaterial == acn.b) {
            return 10.0f;
        }
        return this.k.c(par1, par2, par3) - 0.5f;
    }
    
    public void a(final md par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.b() instanceof yw) {
            ((yw)par1DamageSource.b()).a((ajw)TFAchievementPage.twilightHunter);
        }
    }
}
