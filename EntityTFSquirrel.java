// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFSquirrel extends br
{
    public EntityTFSquirrel(final ge par1World) {
        super(par1World);
        this.ae = "/twilightforest/squirrel2.png";
        this.b(0.3f, 0.7f);
        this.bP = 1.0f;
        this.al().a(true);
        this.aL.a(0, (zc)new wj((ne)this));
        this.aL.a(1, (zc)new pb((ka)this, 0.38f));
        this.aL.a(2, (zc)new zk((ka)this, 0.18f, id.R.bP, true));
        this.aL.a(3, (zc)new ik((ka)this, (Class)ih.class, 2.0f, 0.23f, 0.4f));
        this.aL.a(5, (zc)new nk((ka)this, 0.25f));
        this.aL.a(6, (zc)new nk((ka)this, 0.38f));
        this.aL.a(7, (zc)new ul((ne)this, (Class)ih.class, 6.0f));
        this.aL.a(8, (zc)new bs((ne)this));
    }
    
    public int d() {
        return 1;
    }
    
    protected void a(final float par1) {
    }
    
    public boolean c_() {
        return true;
    }
    
    public br a(final br var1) {
        return null;
    }
    
    public float a(final int par1, final int par2, final int par3) {
        final na underMaterial = this.bi.d(par1, par2 - 1, par3);
        if (underMaterial == na.i) {
            return 12.0f;
        }
        if (underMaterial == na.d) {
            return 15.0f;
        }
        if (underMaterial == na.b) {
            return 10.0f;
        }
        return this.bi.p(par1, par2, par3) - 0.5f;
    }
    
    public void a(final rq par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.b() instanceof ih) {
            ((ih)par1DamageSource.b()).a((xo)TFAchievementPage.twilightHunter);
        }
    }
}
