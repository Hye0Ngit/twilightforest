// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import twilightforest.entity.EntityTFGoblinKnightLower;

public class ModelTFGoblinKnightLower extends bbg
{
    public bcr tunic;
    
    public ModelTFGoblinKnightLower() {
        this.l = 0;
        this.m = 0;
        this.n = false;
        this.o = false;
        this.t = 128;
        this.u = 64;
        (this.k = new bcr((bbl)this, 0, 0)).a(-5.0f, 0.0f, -1.0f, 10, 16, 1);
        (this.j = new bcr((bbl)this, 24, 0)).a(-3.0f, -6.0f, -1.0f, 6, 6, 1);
        (this.c = new bcr((bbl)this, 0, 32)).a(-2.5f, -5.0f, -3.5f, 5, 5, 5);
        this.c.a(0.0f, 10.0f, 1.0f);
        (this.d = new bcr((bbl)this, 0, 0)).a(0.0f, 0.0f, 0.0f, 0, 0, 0);
        (this.e = new bcr((bbl)this, 16, 48)).a(-3.5f, 0.0f, -2.0f, 7, 8, 4);
        this.e.a(0.0f, 8.0f, 0.0f);
        (this.f = new bcr((bbl)this, 40, 48)).a(-2.0f, -2.0f, -1.5f, 2, 8, 3);
        this.f.a(-3.5f, 10.0f, 0.0f);
        this.g = new bcr((bbl)this, 40, 48);
        this.g.i = true;
        this.g.a(0.0f, -2.0f, -1.5f, 2, 8, 3);
        this.g.a(3.5f, 10.0f, 0.0f);
        (this.h = new bcr((bbl)this, 0, 48)).a(-3.0f, 0.0f, -2.0f, 4, 8, 4);
        this.h.a(-2.5f, 16.0f, 0.0f);
        this.i = new bcr((bbl)this, 0, 48);
        this.i.i = true;
        this.i.a(-1.0f, 0.0f, -2.0f, 4, 8, 4);
        this.i.a(2.5f, 16.0f, 0.0f);
        (this.tunic = new bcr((bbl)this, 64, 19)).a(-6.0f, 0.0f, -3.0f, 12, 9, 6);
        this.tunic.a(0.0f, 7.5f, 0.0f);
    }
    
    public void a(final nm par1Entity, final float par2, final float par3, final float par4, final float par5, final float par6, final float par7) {
        super.a(par1Entity, par2, par3, par4, par5, par6, par7);
        if (((EntityTFGoblinKnightLower)par1Entity).hasArmor()) {
            this.renderTunic(par7);
        }
    }
    
    public void renderTunic(final float par1) {
        this.tunic.a(par1);
    }
    
    public void a(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final nm par7Entity) {
        this.c.g = par4 / 57.295776f;
        this.c.f = par5 / 57.295776f;
        this.d.g = this.c.g;
        this.d.f = this.c.f;
        this.f.f = lr.b(par1 * 0.6662f + 3.1415927f) * 2.0f * par2 * 0.5f;
        this.g.f = lr.b(par1 * 0.6662f) * 2.0f * par2 * 0.5f;
        this.f.h = 0.0f;
        this.g.h = 0.0f;
        this.h.f = lr.b(par1 * 0.6662f) * 1.4f * par2;
        this.i.f = lr.b(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.h.g = 0.0f;
        this.i.g = 0.0f;
        if (par7Entity.n != null) {
            this.c.g = 0.0f;
            this.c.f = 0.0f;
            this.d.g = this.c.g;
            this.d.f = this.c.f;
        }
        if (this.l != 0) {
            this.g.f = this.g.f * 0.5f - 0.31415927f * this.l;
        }
        if (this.m != 0) {
            this.f.f = this.f.f * 0.5f - 0.31415927f * this.m;
        }
        this.f.g = 0.0f;
        this.g.g = 0.0f;
        final bcr f = this.f;
        f.h += lr.b(par3 * 0.09f) * 0.05f + 0.05f;
        final bcr g = this.g;
        g.h -= lr.b(par3 * 0.09f) * 0.05f + 0.05f;
        final bcr f2 = this.f;
        f2.f += lr.a(par3 * 0.067f) * 0.05f;
        final bcr g2 = this.g;
        g2.f -= lr.a(par3 * 0.067f) * 0.05f;
    }
}
