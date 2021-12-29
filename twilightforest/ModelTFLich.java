// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class ModelTFLich extends ie
{
    qp collar;
    qp cloak;
    qp shieldBelt;
    boolean renderPass;
    
    public ModelTFLich() {
        this.renderPass = false;
        this.renderPass = false;
        this.l = 64;
        this.m = 64;
        final float f = 0.0f;
        (this.e = new qp((ho)this, 8, 16)).a(-4.0f, 0.0f, -2.0f, 8, 24, 4, f);
        this.e.a(0.0f, -4.0f + f, 0.0f);
        this.e.b(64, 64);
        (this.f = new qp((ho)this, 0, 16)).a(-2.0f, -2.0f, -1.0f, 2, 12, 2, f);
        this.f.b(64, 64);
        this.f.a(-5.0f, -2.0f, 0.0f);
        this.g = new qp((ho)this, 0, 16);
        this.g.i = true;
        this.g.a(-2.0f, -2.0f, -1.0f, 2, 12, 2, f);
        this.g.a(5.0f, -2.0f, 0.0f);
        this.g.b(64, 64);
        (this.d = new qp((ho)this, 32, 0)).a(-4.0f, -12.0f, -4.0f, 8, 8, 8, f + 0.5f);
        this.d.a(0.0f, -4.0f, 0.0f);
        this.d.b(64, 64);
        (this.c = new qp((ho)this, 0, 0)).a(-4.0f, -8.0f, -4.0f, 8, 8, 8);
        this.c.a(0.0f, -4.0f, 0.0f);
        this.c.b(64, 64);
        (this.n = new qp((ho)this, 0, 16)).a(-1.0f, 0.0f, -1.0f, 2, 12, 2);
        this.n.a(-2.0f, 9.5f, 0.0f);
        this.n.b(64, 64);
        (this.o = new qp((ho)this, 0, 16)).a(-1.0f, 0.0f, -1.0f, 2, 12, 2);
        this.o.a(2.0f, 9.5f, 0.0f);
        this.o.b(64, 64);
        this.o.i = true;
        (this.collar = new qp((ho)this, 32, 16)).a(-6.0f, 0.0f, 0.0f, 12, 12, 1);
        this.collar.a(0.0f, -3.0f, -1.0f);
        this.collar.b(64, 64);
        this.setRotation(this.collar, 2.164208f, 0.0f, 0.0f);
        (this.cloak = new qp((ho)this, 0, 44)).a(-6.0f, 0.0f, 0.0f, 12, 19, 1);
        this.cloak.a(0.0f, -4.0f, 2.5f);
        this.cloak.b(64, 64);
        this.setRotation(this.cloak, 0.0f, 0.0f, 0.0f);
        (this.shieldBelt = new qp((ho)this)).a(0.0f, 0.0f, 0.0f);
    }
    
    public ModelTFLich(final boolean specialRenderModel) {
        this();
        this.renderPass = specialRenderModel;
    }
    
    public void a(final nn entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        final EntityTFLich lich = (EntityTFLich)entity;
        if (!this.renderPass) {
            if (!lich.isShadowClone()) {
                super.a(entity, f, f1, f2, f3, f4, f5 * 1.125f);
                this.collar.a(f5 * 1.125f);
                this.cloak.a(f5 * 1.125f);
            }
        }
        else if (lich.isShadowClone()) {
            super.a(entity, f, f1, f2, f3, f4, f5 * 1.125f);
        }
        else if (lich.getShieldStrength() > 0) {
            this.shieldBelt.a(f5 * 1.125f);
        }
    }
    
    public void a(final acq par1EntityLiving, final float par2, final float par3, final float time) {
        final EntityTFLich lich = (EntityTFLich)par1EntityLiving;
        final int shields = lich.getShieldStrength();
        if (!lich.isShadowClone() && shields > 0) {
            if (this.shieldBelt.m == null || this.shieldBelt.m.size() != shields) {
                if (this.shieldBelt.m != null) {
                    this.shieldBelt.m.clear();
                }
                for (int i = 0; i < shields; ++i) {
                    final bo vec = bo.b(11.0, 0.0, 0.0);
                    final float rotateY = i * (360.0f / shields) * 3.141593f / 180.0f;
                    vec.b(rotateY);
                    final qp shield = new qp((ho)this, 26, 40);
                    shield.a(0.5f, -6.0f, -6.0f, 1, 12, 12);
                    shield.a((float)vec.a, (float)vec.b, (float)vec.c);
                    shield.b(64, 64);
                    shield.g = rotateY;
                    this.shieldBelt.a(shield);
                }
            }
            this.shieldBelt.g = (lich.V + time) / 5.0f;
            this.shieldBelt.f = gk.a((lich.V + time) / 5.0f) / 4.0f;
            this.shieldBelt.h = gk.b((lich.V + time) / 5.0f) / 4.0f;
        }
    }
    
    public void a(final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        this.u = false;
        super.a(f, f1, f2, f3, f4, f5);
        final float ogSin = gk.a(this.h * 3.141593f);
        final float otherSin = gk.a((1.0f - (1.0f - this.h) * (1.0f - this.h)) * 3.141593f);
        this.f.h = 0.0f;
        this.g.h = 0.5f;
        this.f.g = -(0.1f - ogSin * 0.6f);
        this.g.g = 0.1f - ogSin * 0.6f;
        this.f.f = -1.570796f;
        this.g.f = -3.141593f;
        final qp f6 = this.f;
        f6.f -= ogSin * 1.2f - otherSin * 0.4f;
        final qp g = this.g;
        g.f -= ogSin * 1.2f - otherSin * 0.4f;
        final qp f7 = this.f;
        f7.h += gk.b(f2 * 0.26f) * 0.15f + 0.05f;
        final qp g2 = this.g;
        g2.h -= gk.b(f2 * 0.26f) * 0.15f + 0.05f;
        final qp f8 = this.f;
        f8.f += gk.a(f2 * 0.167f) * 0.15f;
        final qp g3 = this.g;
        g3.f -= gk.a(f2 * 0.167f) * 0.15f;
        this.c.d = -4.0f;
        this.n.d = 9.5f;
        this.o.d = 9.5f;
    }
    
    private void setRotation(final qp model, final float x, final float y, final float z) {
        model.f = x;
        model.g = y;
        model.h = z;
    }
}
