// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityTFTinyBird extends EntityTFBird
{
    public EntityTFTinyBird(final xv par1World) {
        super(par1World);
        this.aF = "/twilightforest/tinybirdbrown.png";
        this.a(0.3f, 0.7f);
        this.X = 2.0f;
        this.az().a(true);
        this.bm.a(0, (nc)new mz((md)this));
        this.bm.a(1, (nc)new nt((mi)this, 0.38f));
        this.bm.a(2, (nc)new od((mi)this, 0.18f, uk.S.cg, true));
        this.bm.a(3, (nc)new mr((mi)this, (Class)qx.class, 2.0f, 0.23f, 0.4f));
        this.bm.a(5, (nc)new nw((mi)this, 0.25f));
        this.bm.a(6, (nc)new nh((md)this, (Class)qx.class, 6.0f));
        this.bm.a(7, (nc)new nv((md)this));
        this.setBirdType(this.aa.nextInt(4));
    }
    
    protected void a() {
        super.a();
        this.ag.a(16, (Object)0);
    }
    
    public int aT() {
        return 1;
    }
    
    public String O() {
        switch (this.getBirdType()) {
            case 0: {
                return "/twilightforest/tinybirdbrown.png";
            }
            case 1: {
                return "/twilightforest/tinybirdblue.png";
            }
            case 2: {
                return "/twilightforest/tinybirdred.png";
            }
            case 3: {
                return "/twilightforest/tinybirdgold.png";
            }
            default: {
                return super.O();
            }
        }
    }
    
    public void b(final bq par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        par1NBTTagCompound.a("BirdType", this.getBirdType());
    }
    
    public void a(final bq par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        this.setBirdType(par1NBTTagCompound.e("BirdType"));
    }
    
    public int getBirdType() {
        return this.ag.a(16);
    }
    
    public void setBirdType(final int par1) {
        this.ag.b(16, (Object)(byte)par1);
    }
    
    protected String aY() {
        return "mob.tf.tinybird.chirp";
    }
    
    protected String aZ() {
        return "mob.tf.tinybird.hurt";
    }
    
    protected String ba() {
        return "mob.tf.tinybird.hurt";
    }
    
    public float bt() {
        return 0.3f;
    }
    
    protected boolean bj() {
        return false;
    }
    
    public float a(final int par1, final int par2, final int par3) {
        final agb underMaterial = this.p.g(par1, par2 - 1, par3);
        if (underMaterial == agb.j) {
            return 200.0f;
        }
        if (underMaterial == agb.d) {
            return 15.0f;
        }
        if (underMaterial == agb.b) {
            return 9.0f;
        }
        return this.p.p(par1, par2, par3) - 0.5f;
    }
    
    public void a(final lh par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.f() instanceof qx) {
            ((qx)par1DamageSource.f()).a((jl)TFAchievementPage.twilightHunter);
        }
    }
}
