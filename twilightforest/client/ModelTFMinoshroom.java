// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

public class ModelTFMinoshroom extends aww
{
    ayf body;
    ayf leg1;
    ayf leg2;
    ayf leg3;
    ayf leg4;
    ayf udders;
    ayf horn1a;
    ayf horn1b;
    ayf horn2a;
    ayf horn2b;
    ayf snout;
    
    public ModelTFMinoshroom() {
        this.t = 128;
        this.u = 32;
        (this.c = new ayf((axa)this, 0, 0)).a(-4.0f, -8.0f, -4.0f, 8, 8, 8);
        this.c.a(0.0f, -6.0f, -9.0f);
        (this.body = new ayf((axa)this, 18, 4)).a(-6.0f, -10.0f, -7.0f, 12, 18, 10);
        this.body.a(0.0f, 5.0f, 2.0f);
        this.setRotation(this.body, 1.570796f, 0.0f, 0.0f);
        (this.leg1 = new ayf((axa)this, 0, 16)).a(-3.0f, 0.0f, -2.0f, 4, 12, 4);
        this.leg1.a(-3.0f, 12.0f, 7.0f);
        (this.leg2 = new ayf((axa)this, 0, 16)).a(-1.0f, 0.0f, -2.0f, 4, 12, 4);
        this.leg2.a(3.0f, 12.0f, 7.0f);
        (this.leg3 = new ayf((axa)this, 0, 16)).a(-3.0f, 0.0f, -3.0f, 4, 12, 4);
        this.leg3.a(-3.0f, 12.0f, -5.0f);
        (this.leg4 = new ayf((axa)this, 0, 16)).a(-1.0f, 0.0f, -3.0f, 4, 12, 4);
        this.leg4.a(3.0f, 12.0f, -5.0f);
        (this.udders = new ayf((axa)this, 52, 0)).a(-2.0f, -3.0f, 0.0f, 4, 6, 2);
        this.udders.a(0.0f, 14.0f, 6.0f);
        this.setRotation(this.udders, 1.570796f, 0.0f, 0.0f);
        (this.e = new ayf((axa)this, 64, 0)).a(-4.0f, 0.0f, -2.5f, 8, 12, 5);
        this.e.a(0.0f, -6.0f, -9.0f);
        (this.g = new ayf((axa)this, 90, 0)).a(-1.0f, -2.0f, -2.0f, 4, 12, 4);
        this.g.a(5.0f, -4.0f, -9.0f);
        this.g.i = true;
        (this.f = new ayf((axa)this, 90, 0)).a(-3.0f, -2.0f, -2.0f, 4, 12, 4);
        this.f.a(-5.0f, -4.0f, -9.0f);
        (this.horn1a = new ayf((axa)this, 24, 0)).a(0.0f, -1.0f, -1.0f, 3, 2, 2);
        this.horn1a.a(4.0f, -6.0f, 0.0f);
        this.horn1a.g = 0.2617994f;
        this.c.a(this.horn1a);
        (this.horn1b = new ayf((axa)this, 24, 2)).a(-1.0f, -4.0f, -1.0f, 2, 4, 2);
        this.horn1b.a(2.75f, 0.0f, 0.0f);
        this.horn1b.f = 0.5235988f;
        this.horn1b.g = -0.5235988f;
        this.horn1a.a(this.horn1b);
        (this.horn2a = new ayf((axa)this, 24, 0)).a(-3.0f, -1.0f, -1.0f, 3, 2, 2);
        this.horn2a.a(-4.0f, -6.0f, 0.0f);
        this.horn2a.g = -0.2617994f;
        this.c.a(this.horn2a);
        (this.horn2b = new ayf((axa)this, 24, 2)).a(-1.0f, -4.0f, -1.0f, 2, 4, 2);
        this.horn2b.a(-2.75f, 0.0f, 0.0f);
        this.horn2b.f = 0.5235988f;
        this.horn2b.g = 0.5235988f;
        this.horn2a.a(this.horn2b);
        (this.snout = new ayf((axa)this, 9, 12)).a(-2.0f, -1.0f, -1.0f, 4, 3, 1);
        this.snout.a(0.0f, -2.0f, -4.0f);
        this.c.a(this.snout);
    }
    
    public void a(final lq entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        this.a(f, f1, f2, f3, f4, f5, entity);
        this.c.a(f5);
        this.body.a(f5);
        this.leg1.a(f5);
        this.leg2.a(f5);
        this.leg3.a(f5);
        this.leg4.a(f5);
        this.udders.a(f5);
        this.e.a(f5);
        this.g.a(f5);
        this.f.a(f5);
    }
    
    private void setRotation(final ayf model, final float x, final float y, final float z) {
        model.f = x;
        model.g = y;
        model.h = z;
    }
    
    public void a(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final lq entity) {
        this.c.g = par4 / 57.295776f;
        this.c.f = par5 / 57.295776f;
        this.d.g = this.c.g;
        this.d.f = this.c.f;
        this.f.f = ke.b(par1 * 0.6662f + 3.1415927f) * 2.0f * par2 * 0.5f;
        this.g.f = ke.b(par1 * 0.6662f) * 2.0f * par2 * 0.5f;
        this.f.h = 0.0f;
        this.g.h = 0.0f;
        this.h.f = ke.b(par1 * 0.6662f) * 1.4f * par2;
        this.i.f = ke.b(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.h.g = 0.0f;
        this.i.g = 0.0f;
        if (this.l != 0) {
            this.g.f = this.g.f * 0.5f - 0.31415927f * this.l;
        }
        if (this.m != 0) {
            this.f.f = this.f.f * 0.5f - 0.31415927f * this.m;
        }
        final ayf f = this.f;
        f.h += ke.b(par3 * 0.09f) * 0.05f + 0.05f;
        final ayf g = this.g;
        g.h -= ke.b(par3 * 0.09f) * 0.05f + 0.05f;
        final ayf f2 = this.f;
        f2.f += ke.a(par3 * 0.067f) * 0.05f;
        final ayf g2 = this.g;
        g2.f -= ke.a(par3 * 0.067f) * 0.05f;
        if (this.o) {
            final float var7 = 0.0f;
            final float var8 = 0.0f;
            this.f.h = 0.0f;
            this.g.h = 0.0f;
            this.f.g = -(0.1f - var7 * 0.6f) + this.c.g;
            this.g.g = 0.1f - var7 * 0.6f + this.c.g + 0.4f;
            this.f.f = -1.5707964f + this.c.f;
            this.g.f = -1.5707964f + this.c.f;
            final ayf f3 = this.f;
            f3.f -= var7 * 1.2f - var8 * 0.4f;
            final ayf g3 = this.g;
            g3.f -= var7 * 1.2f - var8 * 0.4f;
            final ayf f4 = this.f;
            f4.h += ke.b(par3 * 0.09f) * 0.05f + 0.05f;
            final ayf g4 = this.g;
            g4.h -= ke.b(par3 * 0.09f) * 0.05f + 0.05f;
            final ayf f5 = this.f;
            f5.f += ke.a(par3 * 0.067f) * 0.05f;
            final ayf g5 = this.g;
            g5.f -= ke.a(par3 * 0.067f) * 0.05f;
        }
        this.body.f = 1.5707964f;
        this.leg1.f = ke.b(par1 * 0.6662f) * 1.4f * par2;
        this.leg2.f = ke.b(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.leg3.f = ke.b(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.leg4.f = ke.b(par1 * 0.6662f) * 1.4f * par2;
    }
}
