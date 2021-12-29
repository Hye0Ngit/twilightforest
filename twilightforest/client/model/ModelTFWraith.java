// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

public class ModelTFWraith extends bbt
{
    public bdc dress;
    
    public ModelTFWraith() {
        final float f = 0.0f;
        (this.dress = new bdc((bbx)this, 40, 16)).a(-4.0f, 12.0f, -2.0f, 8, 12, 4, f);
        this.dress.a(0.0f, 0.0f, 0.0f);
    }
    
    public void a(final mp entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        this.a(f, f1, f2, f3, f4, f5, entity);
        this.c.a(f5);
        this.e.a(f5);
        this.f.a(f5);
        this.g.a(f5);
        this.dress.a(f5);
        this.d.a(f5);
    }
    
    public void a(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final mp par7Entity) {
        super.a(par1, par2, par3, par4, par5, par6, par7Entity);
        final float var8 = kx.a(this.p * 3.1415927f);
        final float var9 = kx.a((1.0f - (1.0f - this.p) * (1.0f - this.p)) * 3.1415927f);
        this.f.h = 0.0f;
        this.g.h = 0.0f;
        this.f.g = -(0.1f - var8 * 0.6f);
        this.g.g = 0.1f - var8 * 0.6f;
        this.f.f = -1.5707964f;
        this.g.f = -1.5707964f;
        final bdc f = this.f;
        f.f -= var8 * 1.2f - var9 * 0.4f;
        final bdc g = this.g;
        g.f -= var8 * 1.2f - var9 * 0.4f;
        final bdc f2 = this.f;
        f2.h += kx.b(par3 * 0.09f) * 0.05f + 0.05f;
        final bdc g2 = this.g;
        g2.h -= kx.b(par3 * 0.09f) * 0.05f + 0.05f;
        final bdc f3 = this.f;
        f3.f += kx.a(par3 * 0.067f) * 0.05f;
        final bdc g3 = this.g;
        g3.f -= kx.a(par3 * 0.067f) * 0.05f;
    }
}
