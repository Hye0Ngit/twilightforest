// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFRaven extends EntityTFBird
{
    EntityTFRavenLookHelper ravenLook;
    
    public EntityTFRaven(final ge par1World) {
        super(par1World);
        this.ravenLook = new EntityTFRavenLookHelper((ne)this);
        this.ae = "/twilightforest/raven.png";
        this.b(0.3f, 0.7f);
        this.bP = 1.0f;
        this.al().a(true);
        this.aL.a(0, (zc)new wj((ne)this));
        this.aL.a(1, (zc)new pb((ka)this, 0.38f));
        this.aL.a(2, (zc)new zk((ka)this, 0.18f, id.R.bP, true));
        this.aL.a(5, (zc)new nk((ka)this, 0.25f));
        this.aL.a(6, (zc)new ul((ne)this, (Class)ih.class, 6.0f));
        this.aL.a(7, (zc)new bs((ne)this));
    }
    
    public int d() {
        return 10;
    }
    
    protected void z_() {
        super.z_();
        this.ravenLook.a();
    }
    
    public eo ai() {
        return this.ravenLook;
    }
    
    protected String i() {
        return "mob.tf.raven.caw";
    }
    
    protected String j() {
        return "mob.tf.raven.squawk";
    }
    
    protected String k() {
        return "mob.tf.raven.squawk";
    }
    
    @Override
    protected int f() {
        return TFItems.feather.bP;
    }
    
    public float a(final int par1, final int par2, final int par3) {
        final na underMaterial = this.bi.d(par1, par2 - 1, par3);
        if (underMaterial == na.i) {
            return 200.0f;
        }
        if (underMaterial == na.d) {
            return 15.0f;
        }
        if (underMaterial == na.b) {
            return 9.0f;
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
