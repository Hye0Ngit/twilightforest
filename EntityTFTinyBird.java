// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFTinyBird extends EntityTFBird
{
    public EntityTFTinyBird(final ge par1World) {
        super(par1World);
        this.ae = "/twilightforest/tinybirdbrown.png";
        this.b(0.3f, 0.7f);
        this.bP = 2.0f;
        this.al().a(true);
        this.aL.a(0, (zc)new wj((ne)this));
        this.aL.a(1, (zc)new pb((ka)this, 0.38f));
        this.aL.a(2, (zc)new zk((ka)this, 0.18f, id.R.bP, true));
        this.aL.a(3, (zc)new ik((ka)this, (Class)ih.class, 2.0f, 0.23f, 0.4f));
        this.aL.a(5, (zc)new nk((ka)this, 0.25f));
        this.aL.a(6, (zc)new ul((ne)this, (Class)ih.class, 6.0f));
        this.aL.a(7, (zc)new bs((ne)this));
        this.setBirdType(this.bS.nextInt(4));
    }
    
    protected void b() {
        super.b();
        this.bY.a(16, (Object)0);
    }
    
    public int d() {
        return 1;
    }
    
    public void b(final ph par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        par1NBTTagCompound.a("BirdType", this.getBirdType());
    }
    
    public void a(final ph par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        this.setBirdType(par1NBTTagCompound.f("BirdType"));
    }
    
    public int getBirdType() {
        return this.bY.a(16);
    }
    
    public void setBirdType(final int par1) {
        this.bY.b(16, (Object)(byte)par1);
    }
    
    protected String i() {
        return "mob.tf.tinybird.chirp";
    }
    
    protected String j() {
        return "mob.tf.tinybird.hurt";
    }
    
    protected String k() {
        return "mob.tf.tinybird.hurt";
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
