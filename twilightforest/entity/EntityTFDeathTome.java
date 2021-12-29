// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFAchievementPage;
import twilightforest.item.TFItems;
import twilightforest.entity.ai.EntityAITFMagicAttack;

public class EntityTFDeathTome extends rv
{
    public EntityTFDeathTome(final zv par1World) {
        super(par1World);
        this.aH = "/item/book.png";
        this.bI = 0.25f;
        this.bo.a(0, (og)new od((ng)this));
        this.bo.a(4, (og)new EntityAITFMagicAttack((ng)this, this.bI, 2, 60));
        this.bo.a(5, (og)new pa((nl)this, this.bI));
        this.bo.a(6, (og)new ol((ng)this, (Class)sk.class, 8.0f));
        this.bo.a(6, (og)new oz((ng)this));
        this.bp.a(1, (og)new pk((ng)this, false));
        this.bp.a(2, (og)new pl((ng)this, (Class)sk.class, 16.0f, 0, true));
    }
    
    public int c(final mp par1Entity) {
        return 4;
    }
    
    protected boolean bh() {
        return true;
    }
    
    public int aW() {
        return 30;
    }
    
    public void c() {
        super.c();
        for (int i = 0; i < 1; ++i) {
            this.q.a("enchantmenttable", this.u + (this.ab.nextDouble() - 0.5) * this.O, this.v + this.ab.nextDouble() * (this.P - 0.75) + 0.5, this.w + (this.ab.nextDouble() - 0.5) * this.O, 0.0, 0.5, 0.0);
        }
    }
    
    public boolean a(final mg par1DamageSource, int par2) {
        if (par1DamageSource.m()) {
            par2 *= 2;
        }
        if (super.a(par1DamageSource, par2)) {
            if (this.ab.nextInt(2) == 0) {
                this.a(we.aL.cp, 1, 1.0f);
            }
            return true;
        }
        return false;
    }
    
    protected int be() {
        return we.aL.cp;
    }
    
    protected void a(final boolean par1, final int par2) {
        for (int var3 = this.ab.nextInt(3 + par2), var4 = 0; var4 < var3; ++var4) {
            this.b(we.aL.cp, 1);
        }
        if (this.ab.nextInt(5) - par2 <= 0) {
            this.b(we.bG.cp, 1);
        }
        else {
            this.b(we.aM.cp, 1);
        }
    }
    
    protected void l(final int par1) {
        this.b(TFItems.magicMapFocus.cp, 1);
    }
    
    public void a(final mg par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof sk) {
            ((sk)par1DamageSource.h()).a((ka)TFAchievementPage.twilightHunter);
        }
    }
}
