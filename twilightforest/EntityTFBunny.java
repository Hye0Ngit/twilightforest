// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityTFBunny extends bc
{
    public EntityTFBunny(final xd par1World) {
        super(par1World);
        this.bm = "/twilightforest/bunnydutch.png";
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
        this.setBunnyType(this.U.nextInt(4));
    }
    
    public int d() {
        return 1;
    }
    
    protected void b() {
        super.b();
        this.ac.a(16, (Object)0);
    }
    
    public boolean b_() {
        return true;
    }
    
    public String v_() {
        switch (this.getBunnyType()) {
            case 0: {
                return "/twilightforest/bunnydutch.png";
            }
            case 1: {
                return "/twilightforest/bunnydutch.png";
            }
            case 2: {
                return "/twilightforest/bunnywhite.png";
            }
            case 3: {
                return "/twilightforest/bunnybrown.png";
            }
            default: {
                return super.v_();
            }
        }
    }
    
    public void b(final ady par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        par1NBTTagCompound.a("BunnyType", this.getBunnyType());
    }
    
    public void a(final ady par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        this.setBunnyType(par1NBTTagCompound.f("BunnyType"));
    }
    
    public int getBunnyType() {
        return this.ac.a(16);
    }
    
    public void setBunnyType(final int par1) {
        this.ac.b(16, (Object)(byte)par1);
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
            return -1.0f;
        }
        if (underMaterial == acn.d) {
            return -1.0f;
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
