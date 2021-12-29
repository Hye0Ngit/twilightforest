// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFAchievementPage;

public class EntityTFBunny extends mi implements lo
{
    public EntityTFBunny(final yc par1World) {
        super(par1World);
        this.aG = "/twilightforest/bunnydutch.png";
        this.a(0.3f, 0.7f);
        this.X = 1.0f;
        this.az().a(true);
        this.bn.a(0, (nc)new mz((md)this));
        this.bn.a(1, (nc)new nt((mi)this, 0.38f));
        this.bn.a(2, (nc)new od((mi)this, 0.18f, up.S.cj, true));
        this.bn.a(3, (nc)new mr((mi)this, (Class)qx.class, 2.0f, 0.23f, 0.4f));
        this.bn.a(5, (nc)new nw((mi)this, 0.25f));
        this.bn.a(6, (nc)new nw((mi)this, 0.38f));
        this.bn.a(7, (nc)new nh((md)this, (Class)qx.class, 6.0f));
        this.bn.a(8, (nc)new nv((md)this));
        this.setBunnyType(this.aa.nextInt(4));
    }
    
    public int aT() {
        return 1;
    }
    
    protected void a() {
        super.a();
        this.ag.a(16, (Object)0);
    }
    
    public boolean be() {
        return true;
    }
    
    public String O() {
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
                return super.O();
            }
        }
    }
    
    public void b(final bq par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        par1NBTTagCompound.a("BunnyType", this.getBunnyType());
    }
    
    public void a(final bq par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        this.setBunnyType(par1NBTTagCompound.e("BunnyType"));
    }
    
    public int getBunnyType() {
        return this.ag.a(16);
    }
    
    public void setBunnyType(final int par1) {
        this.ag.b(16, (Object)(byte)par1);
    }
    
    public float bt() {
        return 0.3f;
    }
    
    protected boolean bj() {
        return false;
    }
    
    public float a(final int par1, final int par2, final int par3) {
        final agi underMaterial = this.p.g(par1, par2 - 1, par3);
        if (underMaterial == agi.j) {
            return -1.0f;
        }
        if (underMaterial == agi.d) {
            return -1.0f;
        }
        if (underMaterial == agi.b) {
            return 10.0f;
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
