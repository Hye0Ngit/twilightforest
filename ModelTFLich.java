// 
// Decompiled by Procyon v0.6-prerelease
// 

public class ModelTFLich extends ib
{
    ql collar;
    ql cloak;
    
    public ModelTFLich() {
        this.l = 64;
        this.m = 64;
        final float f = 0.0f;
        (this.e = new ql((hl)this, 8, 16)).a(-4.0f, 0.0f, -2.0f, 8, 24, 4, f);
        this.e.a(0.0f, 0.0f + f, 0.0f);
        this.e.b(64, 64);
        (this.f = new ql((hl)this, 0, 16)).a(-2.0f, -2.0f, -1.0f, 2, 12, 2, f);
        this.f.b(64, 64);
        this.f.a(-5.0f, 2.0f, 0.0f);
        this.g = new ql((hl)this, 0, 16);
        this.g.i = true;
        this.g.a(-2.0f, -2.0f, -1.0f, 2, 12, 2, f);
        this.g.a(5.0f, 2.0f, 0.0f);
        this.g.b(64, 64);
        (this.d = new ql((hl)this, 32, 0)).a(-4.0f, -12.0f, -4.0f, 8, 8, 8, f + 0.5f);
        this.d.a(0.0f, 0.0f, 0.0f);
        this.d.b(64, 64);
        (this.c = new ql((hl)this, 0, 0)).a(-4.0f, -8.0f, -4.0f, 8, 8, 8);
        this.c.a(0.0f, 0.0f, 0.0f);
        this.c.b(64, 64);
        (this.n = new ql((hl)this, 0, 16)).a(-1.0f, 0.0f, -1.0f, 2, 12, 2);
        this.n.a(-2.0f, 12.0f, 0.0f);
        this.n.b(64, 64);
        (this.o = new ql((hl)this, 0, 16)).a(-1.0f, 0.0f, -1.0f, 2, 12, 2);
        this.o.a(2.0f, 12.0f, 0.0f);
        this.o.b(64, 64);
        this.o.i = true;
        (this.collar = new ql((hl)this, 32, 16)).a(-6.0f, 0.0f, 0.0f, 12, 12, 1);
        this.collar.a(0.0f, 1.0f, -1.0f);
        this.collar.b(64, 64);
        this.setRotation(this.collar, 2.164208f, 0.0f, 0.0f);
        (this.cloak = new ql((hl)this, 0, 44)).a(-6.0f, 0.0f, 0.0f, 12, 19, 1);
        this.cloak.a(0.0f, 0.0f, 2.5f);
        this.cloak.b(64, 64);
        this.setRotation(this.cloak, 0.0f, 0.0f, 0.0f);
    }
    
    public void a(final nk entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.a(entity, f, f1, f2, f3, f4, f5 * 1.125f);
        this.collar.a(f5 * 1.125f);
        this.cloak.a(f5 * 1.125f);
    }
    
    public void a(final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        this.u = false;
        super.a(f, f1, f2, f3, f4, f5);
        final float ogSin = gh.a(this.h * 3.141593f);
        final float otherSin = gh.a((1.0f - (1.0f - this.h) * (1.0f - this.h)) * 3.141593f);
        this.f.h = 0.0f;
        this.g.h = 0.5f;
        this.f.g = -(0.1f - ogSin * 0.6f);
        this.g.g = 0.1f - ogSin * 0.6f;
        this.f.f = -1.570796f;
        this.g.f = -3.141593f;
        final ql f6 = this.f;
        f6.f -= ogSin * 1.2f - otherSin * 0.4f;
        final ql g = this.g;
        g.f -= ogSin * 1.2f - otherSin * 0.4f;
        final ql f7 = this.f;
        f7.h += gh.b(f2 * 0.09f) * 0.05f + 0.05f;
        final ql g2 = this.g;
        g2.h -= gh.b(f2 * 0.09f) * 0.05f + 0.05f;
        final ql f8 = this.f;
        f8.f += gh.a(f2 * 0.067f) * 0.05f;
        final ql g3 = this.g;
        g3.f -= gh.a(f2 * 0.067f) * 0.05f;
    }
    
    private void setRotation(final ql model, final float x, final float y, final float z) {
        model.f = x;
        model.g = y;
        model.h = z;
    }
}
