// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

public class ModelTFKobold extends bbt
{
    bdc rightear;
    bdc leftear;
    bdc snout;
    bdc jaw;
    boolean isJumping;
    
    public ModelTFKobold() {
        this.isJumping = false;
        this.t = 64;
        this.u = 32;
        (this.c = new bdc((bbx)this, 0, 0)).a(-3.5f, -7.0f, -3.0f, 7, 6, 6);
        this.c.a(0.0f, 13.0f, 0.0f);
        (this.e = new bdc((bbx)this, 12, 19)).a(0.0f, 0.0f, 0.0f, 7, 7, 4);
        this.e.a(-3.5f, 12.0f, -2.0f);
        (this.f = new bdc((bbx)this, 36, 17)).a(-3.0f, -1.0f, -1.5f, 3, 7, 3);
        this.f.a(-3.5f, 12.0f, 0.0f);
        this.g.i = true;
        (this.g = new bdc((bbx)this, 36, 17)).a(0.0f, -1.0f, -1.5f, 3, 7, 3);
        this.g.a(3.5f, 12.0f, 0.0f);
        this.g.i = false;
        (this.h = new bdc((bbx)this, 0, 20)).a(-1.5f, 0.0f, -1.5f, 3, 5, 3);
        this.h.a(-2.0f, 19.0f, 0.0f);
        (this.i = new bdc((bbx)this, 0, 20)).a(-1.5f, 0.0f, -1.5f, 3, 5, 3);
        this.i.a(2.0f, 19.0f, 0.0f);
        (this.rightear = new bdc((bbx)this, 48, 20)).a(0.0f, -4.0f, 0.0f, 4, 4, 1);
        this.rightear.a(3.5f, -3.0f, -1.0f);
        this.rightear.g = 0.2617994f;
        this.rightear.h = -0.3490659f;
        this.c.a(this.rightear);
        (this.leftear = new bdc((bbx)this, 48, 25)).a(-4.0f, -4.0f, 0.0f, 4, 4, 1);
        this.leftear.a(-3.5f, -3.0f, -1.0f);
        this.leftear.g = -0.2617994f;
        this.leftear.h = 0.3490659f;
        this.c.a(this.leftear);
        (this.snout = new bdc((bbx)this, 28, 0)).a(-1.5f, -2.0f, -2.0f, 3, 2, 3);
        this.snout.a(0.0f, -2.0f, -3.0f);
        this.c.a(this.snout);
        (this.jaw = new bdc((bbx)this, 28, 5)).a(-1.5f, 0.0f, -2.0f, 3, 1, 3);
        this.jaw.a(0.0f, -2.0f, -3.0f);
        this.jaw.f = 0.20944f;
        this.c.a(this.jaw);
    }
    
    public void setRotationAngles(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6) {
        this.c.g = par4 / 57.295776f;
        this.c.f = par5 / 57.295776f;
        this.f.f = kx.b(par1 * 0.6662f + 3.1415927f) * 2.0f * par2 * 0.5f;
        this.g.f = kx.b(par1 * 0.6662f) * 2.0f * par2 * 0.5f;
        this.f.h = 0.0f;
        this.g.h = 0.0f;
        this.f.f = -0.47123894f;
        this.g.f = -0.47123894f;
        this.h.f = kx.b(par1 * 0.6662f) * 1.4f * par2;
        this.i.f = kx.b(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.h.g = 0.0f;
        this.i.g = 0.0f;
        final bdc f = this.f;
        f.h += kx.b(par3 * 0.19f) * 0.15f + 0.05f;
        final bdc g = this.g;
        g.h -= kx.b(par3 * 0.19f) * 0.15f + 0.05f;
        final bdc f2 = this.f;
        f2.f += kx.a(par3 * 0.267f) * 0.25f;
        final bdc g2 = this.g;
        g2.f -= kx.a(par3 * 0.267f) * 0.25f;
        if (this.isJumping) {
            this.jaw.f = 1.44f;
        }
        else {
            this.jaw.f = 0.20944f;
        }
    }
    
    public void a(final ng par1EntityLiving, final float par2, final float par3, final float par4) {
        this.isJumping = (par1EntityLiving.y > 0.0);
    }
    
    public void a(final mp entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5);
        this.c.a(f5);
        this.e.a(f5);
        this.f.a(f5);
        this.g.a(f5);
        this.h.a(f5);
        this.i.a(f5);
    }
}
