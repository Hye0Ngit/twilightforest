// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityTFRaven extends EntityTFBird
{
    EntityTFRavenLookHelper ravenLook;
    
    public EntityTFRaven(final xd par1World) {
        super(par1World);
        this.ravenLook = new EntityTFRavenLookHelper((acq)this);
        this.bm = "/twilightforest/raven.png";
        this.a(0.3f, 0.7f);
        this.R = 1.0f;
        this.aM().a(true);
        this.bT.a(0, (rc)new aje((acq)this));
        this.bT.a(1, (rc)new ke((aaa)this, 0.38f));
        this.bT.a(2, (rc)new akz((aaa)this, 0.18f, yr.S.bQ, true));
        this.bT.a(5, (rc)new acu((aaa)this, 0.25f));
        this.bT.a(6, (rc)new ob((acq)this, (Class)yw.class, 6.0f));
        this.bT.a(7, (rc)new bd((acq)this));
    }
    
    public int d() {
        return 10;
    }
    
    protected void s_() {
        super.s_();
        this.ravenLook.a();
    }
    
    public vz aJ() {
        return this.ravenLook;
    }
    
    protected String m() {
        return "mob.tf.raven.caw";
    }
    
    protected String n() {
        return "mob.tf.raven.squawk";
    }
    
    protected String o() {
        return "mob.tf.raven.squawk";
    }
    
    @Override
    protected int f() {
        return TFItems.feather.bQ;
    }
    
    public float bd() {
        return 0.3f;
    }
    
    public float a(final int par1, final int par2, final int par3) {
        final acn underMaterial = this.k.f(par1, par2 - 1, par3);
        if (underMaterial == acn.i) {
            return 200.0f;
        }
        if (underMaterial == acn.d) {
            return 15.0f;
        }
        if (underMaterial == acn.b) {
            return 9.0f;
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
