// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

public class ModelTFKobold extends aww
{
    ayf rightear;
    ayf leftear;
    ayf snout;
    ayf jaw;
    boolean isJumping;
    
    public ModelTFKobold() {
        this.isJumping = false;
        this.t = 64;
        this.u = 32;
        (this.c = new ayf((axa)this, 0, 0)).a(-3.5f, -7.0f, -3.0f, 7, 6, 6);
        this.c.a(0.0f, 13.0f, 0.0f);
        (this.e = new ayf((axa)this, 12, 19)).a(0.0f, 0.0f, 0.0f, 7, 7, 4);
        this.e.a(-3.5f, 12.0f, -2.0f);
        (this.f = new ayf((axa)this, 36, 17)).a(-3.0f, -1.0f, -1.5f, 3, 7, 3);
        this.f.a(-3.5f, 12.0f, 0.0f);
        this.g.i = true;
        (this.g = new ayf((axa)this, 36, 17)).a(0.0f, -1.0f, -1.5f, 3, 7, 3);
        this.g.a(3.5f, 12.0f, 0.0f);
        this.g.i = false;
        (this.h = new ayf((axa)this, 0, 20)).a(-1.5f, 0.0f, -1.5f, 3, 5, 3);
        this.h.a(-2.0f, 19.0f, 0.0f);
        (this.i = new ayf((axa)this, 0, 20)).a(-1.5f, 0.0f, -1.5f, 3, 5, 3);
        this.i.a(2.0f, 19.0f, 0.0f);
        (this.rightear = new ayf((axa)this, 48, 20)).a(0.0f, -4.0f, 0.0f, 4, 4, 1);
        this.rightear.a(3.5f, -3.0f, -1.0f);
        this.rightear.g = 0.2617994f;
        this.rightear.h = -0.3490659f;
        this.c.a(this.rightear);
        (this.leftear = new ayf((axa)this, 48, 25)).a(-4.0f, -4.0f, 0.0f, 4, 4, 1);
        this.leftear.a(-3.5f, -3.0f, -1.0f);
        this.leftear.g = -0.2617994f;
        this.leftear.h = 0.3490659f;
        this.c.a(this.leftear);
        (this.snout = new ayf((axa)this, 28, 0)).a(-1.5f, -2.0f, -2.0f, 3, 2, 3);
        this.snout.a(0.0f, -2.0f, -3.0f);
        this.c.a(this.snout);
        (this.jaw = new ayf((axa)this, 28, 5)).a(-1.5f, 0.0f, -2.0f, 3, 1, 3);
        this.jaw.a(0.0f, -2.0f, -3.0f);
        this.jaw.f = 0.20944f;
        this.c.a(this.jaw);
    }
    
    public void setRotationAngles(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6) {
        this.c.g = par4 / 57.295776f;
        this.c.f = par5 / 57.295776f;
        this.f.f = ke.b(par1 * 0.6662f + 3.1415927f) * 2.0f * par2 * 0.5f;
        this.g.f = ke.b(par1 * 0.6662f) * 2.0f * par2 * 0.5f;
        this.f.h = 0.0f;
        this.g.h = 0.0f;
        this.f.f = -0.47123894f;
        this.g.f = -0.47123894f;
        this.h.f = ke.b(par1 * 0.6662f) * 1.4f * par2;
        this.i.f = ke.b(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.h.g = 0.0f;
        this.i.g = 0.0f;
        final ayf f = this.f;
        f.h += ke.b(par3 * 0.19f) * 0.15f + 0.05f;
        final ayf g = this.g;
        g.h -= ke.b(par3 * 0.19f) * 0.15f + 0.05f;
        final ayf f2 = this.f;
        f2.f += ke.a(par3 * 0.267f) * 0.25f;
        final ayf g2 = this.g;
        g2.f -= ke.a(par3 * 0.267f) * 0.25f;
        if (this.isJumping) {
            this.jaw.f = 1.44f;
        }
        else {
            this.jaw.f = 0.20944f;
        }
    }
    
    public void a(final md par1EntityLiving, final float par2, final float par3, final float par4) {
        this.isJumping = (par1EntityLiving.x > 0.0);
    }
    
    public void a(final lq entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5);
        this.c.a(f5);
        this.e.a(f5);
        this.f.a(f5);
        this.g.a(f5);
        this.h.a(f5);
        this.i.a(f5);
    }
}
