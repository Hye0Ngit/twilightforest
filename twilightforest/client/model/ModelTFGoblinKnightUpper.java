// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import twilightforest.entity.EntityTFGoblinKnightUpper;

public class ModelTFGoblinKnightUpper extends bbg
{
    public bcr breastplate;
    public bcr helmet;
    public bcr righthorn1;
    public bcr righthorn2;
    public bcr lefthorn1;
    public bcr lefthorn2;
    public bcr shield;
    public bcr spear;
    
    public ModelTFGoblinKnightUpper() {
        this.l = 0;
        this.m = 0;
        this.n = false;
        this.o = false;
        this.t = 128;
        this.u = 64;
        (this.k = new bcr((bbl)this, 0, 0)).a(-5.0f, 0.0f, -1.0f, 10, 16, 1);
        (this.j = new bcr((bbl)this, 24, 0)).a(-3.0f, -6.0f, -1.0f, 6, 6, 1);
        (this.c = new bcr((bbl)this, 0, 0)).a(0.0f, 0.0f, 0.0f, 0, 0, 0);
        this.c.a(0.0f, 12.0f, 0.0f);
        (this.d = new bcr((bbl)this, 0, 0)).a(0.0f, 0.0f, 0.0f, 0, 0, 0);
        this.d.a(0.0f, 12.0f, 0.0f);
        (this.helmet = new bcr((bbl)this, 0, 0)).a(-3.5f, -11.0f, -3.5f, 7, 11, 7);
        this.helmet.g = 0.7853982f;
        (this.righthorn1 = new bcr((bbl)this, 28, 0)).a(-6.0f, -1.5f, -1.5f, 7, 3, 3);
        this.righthorn1.a(-3.5f, -9.0f, 0.0f);
        this.righthorn1.g = 0.2617994f;
        this.righthorn1.h = 0.17453294f;
        (this.righthorn2 = new bcr((bbl)this, 28, 6)).a(-3.0f, -1.0f, -1.0f, 3, 2, 2);
        this.righthorn2.a(-5.5f, 0.0f, 0.0f);
        this.righthorn2.h = 0.17453294f;
        this.righthorn1.a(this.righthorn2);
        this.lefthorn1 = new bcr((bbl)this, 28, 0);
        this.lefthorn1.i = true;
        this.lefthorn1.a(-1.0f, -1.5f, -1.5f, 7, 3, 3);
        this.lefthorn1.a(3.5f, -9.0f, 0.0f);
        this.lefthorn1.g = -0.2617994f;
        this.lefthorn1.h = -0.17453294f;
        (this.lefthorn2 = new bcr((bbl)this, 28, 6)).a(0.0f, -1.0f, -1.0f, 3, 2, 2);
        this.lefthorn2.a(5.5f, 0.0f, 0.0f);
        this.lefthorn2.h = -0.17453294f;
        this.lefthorn1.a(this.lefthorn2);
        this.d.a(this.helmet);
        this.d.a(this.righthorn1);
        this.d.a(this.lefthorn1);
        (this.e = new bcr((bbl)this, 0, 18)).a(0.0f, 12.0f, 0.0f);
        this.e.a(-5.5f, 0.0f, -2.0f, 11, 8, 4);
        this.e.a(30, 24).a(-6.5f, 0.0f, -2.0f, 1, 4, 4);
        this.e.a(30, 24).a(5.5f, 0.0f, -2.0f, 1, 4, 4);
        (this.f = new bcr((bbl)this, 44, 16)).a(-4.0f, -2.0f, -2.0f, 4, 12, 4);
        this.f.a(-6.5f, 14.0f, 0.0f);
        this.g = new bcr((bbl)this, 44, 16);
        this.g.i = true;
        this.g.a(0.0f, -2.0f, -2.0f, 4, 12, 4);
        this.g.a(6.5f, 14.0f, 0.0f);
        (this.h = new bcr((bbl)this, 30, 16)).a(-1.5f, 0.0f, -2.0f, 3, 4, 4);
        this.h.a(-4.0f, 20.0f, 0.0f);
        this.i = new bcr((bbl)this, 30, 16);
        this.i.i = true;
        this.i.a(-1.5f, 0.0f, -2.0f, 3, 4, 4);
        this.i.a(4.0f, 20.0f, 0.0f);
        (this.shield = new bcr((bbl)this, 63, 36)).a(-6.0f, -6.0f, -2.0f, 12, 20, 2);
        this.shield.a(0.0f, 12.0f, 0.0f);
        this.shield.f = 1.5707964f;
        this.g.a(this.shield);
        (this.spear = new bcr((bbl)this, 108, 0)).a(-1.0f, -19.0f, -1.0f, 2, 40, 2);
        this.spear.a(-2.0f, 8.5f, 0.0f);
        this.spear.f = 1.5707964f;
        this.f.a(this.spear);
        (this.breastplate = new bcr((bbl)this, 64, 0)).a(-6.5f, 0.0f, -3.0f, 13, 12, 6);
        this.breastplate.a(0.0f, 11.5f, 0.0f);
    }
    
    public void a(final nm par1Entity, final float par2, final float par3, final float par4, final float par5, final float par6, final float par7) {
        this.shield.k = !((EntityTFGoblinKnightUpper)par1Entity).hasShield();
        super.a(par1Entity, par2, par3, par4, par5, par6, par7);
        if (((EntityTFGoblinKnightUpper)par1Entity).hasArmor()) {
            this.renderBreastplate(par7);
        }
    }
    
    public void renderBreastplate(final float par1) {
        this.breastplate.a(par1);
    }
    
    public void a(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final nm par7Entity) {
        final EntityTFGoblinKnightUpper upperKnight = (EntityTFGoblinKnightUpper)par7Entity;
        final boolean hasShield = upperKnight.hasShield();
        this.c.g = par4 / 57.295776f;
        this.c.f = par5 / 57.295776f;
        this.c.h = 0.0f;
        this.d.g = this.c.g;
        this.d.f = this.c.f;
        this.d.h = this.c.h;
        this.f.f = lr.b(par1 * 0.6662f + 3.1415927f) * 2.0f * par2 * 0.5f;
        final float leftConstraint = hasShield ? 0.2f : par2;
        this.g.f = lr.b(par1 * 0.6662f) * 2.0f * leftConstraint * 0.5f;
        this.f.h = 0.0f;
        this.g.h = 0.0f;
        this.h.f = lr.b(par1 * 0.6662f) * 1.4f * par2;
        this.i.f = lr.b(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.h.g = 0.0f;
        this.i.g = 0.0f;
        if (this.q) {
            final bcr f = this.f;
            f.f -= 0.62831855f;
            final bcr g = this.g;
            g.f -= 0.62831855f;
            this.h.f = 0.0f;
            this.i.f = 0.0f;
        }
        if (this.l != 0) {
            this.g.f = this.g.f * 0.5f - 0.31415927f * this.l;
        }
        this.m = 1;
        if (this.m != 0) {
            this.f.f = this.f.f * 0.5f - 0.31415927f * this.m;
        }
        final bcr f2 = this.f;
        f2.f -= (float)2.0734511513692637;
        if (upperKnight.heavySpearTimer > 0) {
            final bcr f3 = this.f;
            f3.f -= this.getArmRotationDuringSwing(60 - upperKnight.heavySpearTimer + par6) / 57.295776f;
        }
        this.f.g = 0.0f;
        this.g.g = 0.0f;
        final bcr f4 = this.f;
        f4.h += lr.b(par3 * 0.09f) * 0.05f + 0.05f;
        final bcr g2 = this.g;
        g2.h -= lr.b(par3 * 0.09f) * 0.05f + 0.05f;
        final bcr f5 = this.f;
        f5.f += lr.a(par3 * 0.067f) * 0.05f;
        final bcr g3 = this.g;
        g3.f -= lr.a(par3 * 0.067f) * 0.05f;
        this.g.h = -this.g.h;
        this.shield.f = (float)(6.283185307179586 - this.g.f);
    }
    
    private float getArmRotationDuringSwing(final float attackTime) {
        if (attackTime <= 10.0f) {
            return attackTime * 1.0f;
        }
        if (attackTime > 10.0f && attackTime <= 30.0f) {
            return 10.0f;
        }
        if (attackTime > 30.0f && attackTime <= 33.0f) {
            return (attackTime - 30.0f) * -8.0f + 10.0f;
        }
        if (attackTime > 33.0f && attackTime <= 50.0f) {
            return -15.0f;
        }
        if (attackTime > 50.0f && attackTime <= 60.0f) {
            return (10.0f - (attackTime - 50.0f)) * -1.5f;
        }
        return 0.0f;
    }
}
