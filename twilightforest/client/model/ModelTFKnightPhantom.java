// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

public class ModelTFKnightPhantom extends bbg
{
    public bcr helmet;
    public bcr righthorn1;
    public bcr righthorn2;
    public bcr lefthorn1;
    public bcr lefthorn2;
    
    public ModelTFKnightPhantom() {
        this.l = 0;
        this.m = 0;
        this.n = false;
        this.o = false;
        this.t = 128;
        this.u = 64;
        (this.k = new bcr((bbl)this, 0, 0)).a(-5.0f, 0.0f, -1.0f, 10, 16, 1);
        (this.j = new bcr((bbl)this, 24, 0)).a(-3.0f, -6.0f, -1.0f, 6, 6, 1);
        (this.c = new bcr((bbl)this, 0, 0)).a(0.0f, 0.0f, 0.0f, 0, 0, 0);
        this.c.a(0.0f, -10.0f, 0.0f);
        (this.d = new bcr((bbl)this, 0, 0)).a(0.0f, 0.0f, 0.0f, 0, 0, 0);
        this.d.a(0.0f, -10.0f, 0.0f);
        (this.helmet = new bcr((bbl)this, 0, 0)).a(-4.0f, -11.0f, -4.0f, 8, 11, 8);
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
        (this.e = new bcr((bbl)this, 0, 18)).a(0.0f, 2.0f, 0.0f);
        this.e.a(-7.0f, -12.0f, -3.5f, 14, 12, 7);
        this.e.a(30, 24).a(-6.0f, 0.0f, -3.0f, 12, 8, 6);
        (this.f = new bcr((bbl)this, 44, 16)).a(-5.0f, -2.0f, -3.0f, 6, 7, 6);
        this.f.a(-8.0f, -8.0f, 0.0f);
        this.g = new bcr((bbl)this, 44, 16);
        this.g.i = true;
        this.g.a(-1.0f, -2.0f, -3.0f, 6, 7, 6);
        this.g.a(8.0f, -8.0f, 0.0f);
        (this.h = new bcr((bbl)this, 0, 0)).a(0.0f, 0.0f, 0.0f, 0, 0, 0);
        this.h.a(0.0f, 12.0f, 0.0f);
        (this.i = new bcr((bbl)this, 0, 0)).a(0.0f, 0.0f, 0.0f, 0, 0, 0);
        this.i.a(0.0f, 12.0f, 0.0f);
    }
    
    public void a(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final nm par7Entity) {
        this.c.g = par4 / 57.295776f;
        this.c.f = par5 / 57.295776f;
        this.c.h = 0.0f;
        this.d.g = this.c.g;
        this.d.f = this.c.f;
        this.d.h = this.c.h;
        this.f.f = lr.b(par1 * 0.6662f + 3.1415927f) * 2.0f * par2 * 0.5f;
        this.g.f = lr.b(par1 * 0.6662f) * 2.0f * par2 * 0.5f;
        this.f.h = 0.0f;
        this.g.h = 0.0f;
        if (this.l != 0) {
            this.g.f = this.g.f * 0.5f - 0.31415927f * this.l;
        }
        this.m = 1;
        if (this.m != 0) {
            this.f.f = this.f.f * 0.5f - 0.31415927f * this.m;
        }
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
