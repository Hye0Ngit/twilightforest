// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFAchievementPage;

public class EntityTFTinyBird extends EntityTFBird
{
    public EntityTFTinyBird(final zv par1World) {
        super(par1World);
        this.aH = "/mods/twilightforest/textures/model/tinybirdbrown.png";
        this.a(0.3f, 0.7f);
        this.Y = 2.0f;
        this.aC().a(true);
        this.bo.a(0, (og)new od((ng)this));
        this.bo.a(1, (og)new ox((nl)this, 0.38f));
        this.bo.a(2, (og)new ph((nl)this, 0.18f, we.T.cp, true));
        this.bo.a(3, (og)new nu((nl)this, (Class)sk.class, 2.0f, 0.23f, 0.4f));
        this.bo.a(5, (og)new pa((nl)this, 0.25f));
        this.bo.a(6, (og)new ol((ng)this, (Class)sk.class, 6.0f));
        this.bo.a(7, (og)new oz((ng)this));
        this.setBirdType(this.ab.nextInt(4));
    }
    
    protected void a() {
        super.a();
        this.ah.a(16, (Object)0);
    }
    
    public int aW() {
        return 1;
    }
    
    public String N() {
        switch (this.getBirdType()) {
            case 0: {
                return "/mods/twilightforest/textures/model/tinybirdbrown.png";
            }
            case 1: {
                return "/mods/twilightforest/textures/model/tinybirdblue.png";
            }
            case 2: {
                return "/mods/twilightforest/textures/model/tinybirdred.png";
            }
            case 3: {
                return "/mods/twilightforest/textures/model/tinybirdgold.png";
            }
            default: {
                return super.N();
            }
        }
    }
    
    public void b(final bs par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        par1NBTTagCompound.a("BirdType", this.getBirdType());
    }
    
    public void a(final bs par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        this.setBirdType(par1NBTTagCompound.e("BirdType"));
    }
    
    public int getBirdType() {
        return this.ah.a(16);
    }
    
    public void setBirdType(final int par1) {
        this.ah.b(16, (Object)(byte)par1);
    }
    
    protected String bb() {
        return "mob.tf.tinybird.chirp";
    }
    
    protected String bc() {
        return "mob.tf.tinybird.hurt";
    }
    
    protected String bd() {
        return "mob.tf.tinybird.hurt";
    }
    
    public float bw() {
        return 0.3f;
    }
    
    protected boolean bm() {
        return false;
    }
    
    public float a(final int par1, final int par2, final int par3) {
        final ahz underMaterial = this.q.g(par1, par2 - 1, par3);
        if (underMaterial == ahz.j) {
            return 200.0f;
        }
        if (underMaterial == ahz.d) {
            return 15.0f;
        }
        if (underMaterial == ahz.b) {
            return 9.0f;
        }
        return this.q.q(par1, par2, par3) - 0.5f;
    }
    
    public void a(final mg par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof sk) {
            ((sk)par1DamageSource.h()).a((ka)TFAchievementPage.twilightHunter);
        }
    }
}
