// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFAchievementPage;

public class EntityTFSquirrel extends nl implements mn
{
    public EntityTFSquirrel(final zv par1World) {
        super(par1World);
        this.aH = "/mods/twilightforest/textures/model/squirrel2.png";
        this.a(0.3f, 0.7f);
        this.Y = 1.0f;
        this.aC().a(true);
        this.bo.a(0, (og)new od((ng)this));
        this.bo.a(1, (og)new ox((nl)this, 0.38f));
        this.bo.a(2, (og)new ph((nl)this, 0.18f, we.T.cp, true));
        this.bo.a(3, (og)new nu((nl)this, (Class)sk.class, 2.0f, 0.23f, 0.4f));
        this.bo.a(5, (og)new pa((nl)this, 0.25f));
        this.bo.a(6, (og)new pa((nl)this, 0.38f));
        this.bo.a(7, (og)new ol((ng)this, (Class)sk.class, 6.0f));
        this.bo.a(8, (og)new oz((ng)this));
    }
    
    public int aW() {
        return 1;
    }
    
    protected void a(final float par1) {
    }
    
    public boolean bh() {
        return true;
    }
    
    public float bw() {
        return 0.3f;
    }
    
    public float a(final int par1, final int par2, final int par3) {
        final ahz underMaterial = this.q.g(par1, par2 - 1, par3);
        if (underMaterial == ahz.j) {
            return 12.0f;
        }
        if (underMaterial == ahz.d) {
            return 15.0f;
        }
        if (underMaterial == ahz.b) {
            return 10.0f;
        }
        return this.q.q(par1, par2, par3) - 0.5f;
    }
    
    protected boolean bm() {
        return false;
    }
    
    public void a(final mg par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof sk) {
            ((sk)par1DamageSource.h()).a((ka)TFAchievementPage.twilightHunter);
        }
    }
}
