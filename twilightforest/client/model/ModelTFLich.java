// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import twilightforest.entity.EntityTFLich;

public class ModelTFLich extends bbg
{
    bcr collar;
    bcr cloak;
    bcr shieldBelt;
    boolean renderPass;
    
    public ModelTFLich() {
        this.renderPass = false;
        this.renderPass = false;
        this.t = 64;
        this.u = 64;
        (this.e = new bcr((bbl)this, 8, 16)).a(-4.0f, 0.0f, -2.0f, 8, 24, 4);
        this.e.a(0.0f, -4.0f, 0.0f);
        this.e.b(64, 64);
        (this.f = new bcr((bbl)this, 0, 16)).a(-2.0f, -2.0f, -1.0f, 2, 12, 2);
        this.f.b(64, 64);
        this.f.a(-5.0f, -2.0f, 0.0f);
        this.g = new bcr((bbl)this, 0, 16);
        this.g.i = true;
        this.g.a(-2.0f, -2.0f, -1.0f, 2, 12, 2);
        this.g.a(5.0f, -2.0f, 0.0f);
        this.g.b(64, 64);
        (this.d = new bcr((bbl)this, 32, 0)).a(-4.0f, -12.0f, -4.0f, 8, 8, 8, 0.5f);
        this.d.a(0.0f, -4.0f, 0.0f);
        this.d.b(64, 64);
        (this.c = new bcr((bbl)this, 0, 0)).a(-4.0f, -8.0f, -4.0f, 8, 8, 8);
        this.c.a(0.0f, -4.0f, 0.0f);
        this.c.b(64, 64);
        (this.h = new bcr((bbl)this, 0, 16)).a(-1.0f, 0.0f, -1.0f, 2, 12, 2);
        this.h.a(-2.0f, 9.5f, 0.0f);
        this.h.b(64, 64);
        (this.i = new bcr((bbl)this, 0, 16)).a(-1.0f, 0.0f, -1.0f, 2, 12, 2);
        this.i.a(2.0f, 9.5f, 0.0f);
        this.i.b(64, 64);
        this.i.i = true;
        (this.collar = new bcr((bbl)this, 32, 16)).a(-6.0f, 0.0f, 0.0f, 12, 12, 1);
        this.collar.a(0.0f, -3.0f, -1.0f);
        this.collar.b(64, 64);
        this.setRotation(this.collar, 2.164208f, 0.0f, 0.0f);
        (this.cloak = new bcr((bbl)this, 0, 44)).a(-6.0f, 0.0f, 0.0f, 12, 19, 1);
        this.cloak.a(0.0f, -4.0f, 2.5f);
        this.cloak.b(64, 64);
        this.setRotation(this.cloak, 0.0f, 0.0f, 0.0f);
        (this.shieldBelt = new bcr((bbl)this)).a(0.0f, 0.0f, 0.0f);
    }
    
    public ModelTFLich(final boolean specialRenderModel) {
        this();
        this.renderPass = specialRenderModel;
    }
    
    public void a(final nm entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
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
    
    public void a(final oe par1EntityLiving, final float par2, final float par3, final float time) {
        final EntityTFLich lich = (EntityTFLich)par1EntityLiving;
        final int shields = lich.getShieldStrength();
        if (!lich.isShadowClone() && shields > 0) {
            if (this.shieldBelt.m == null || this.shieldBelt.m.size() != shields) {
                if (this.shieldBelt.m != null) {
                    this.shieldBelt.m.clear();
                }
                for (int i = 0; i < shields; ++i) {
                    final asz vec = asz.a(11.0, 0.0, 0.0);
                    final float rotateY = i * (360.0f / shields) * 3.141593f / 180.0f;
                    vec.b(rotateY);
                    final bcr shield = new bcr((bbl)this, 26, 40);
                    shield.a(0.5f, -6.0f, -6.0f, 1, 12, 12);
                    shield.a((float)vec.c, (float)vec.d, (float)vec.e);
                    shield.b(64, 64);
                    shield.g = rotateY;
                    this.shieldBelt.a(shield);
                }
            }
            this.shieldBelt.g = (lich.ac + time) / 5.0f;
            this.shieldBelt.f = lr.a((lich.ac + time) / 5.0f) / 4.0f;
            this.shieldBelt.h = lr.b((lich.ac + time) / 5.0f) / 4.0f;
        }
    }
    
    public void a(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final nm entity) {
        this.o = false;
        super.a(f, f1, f2, f3, f4, f5, entity);
        final float ogSin = lr.a(this.p * 3.141593f);
        final float otherSin = lr.a((1.0f - (1.0f - this.p) * (1.0f - this.p)) * 3.141593f);
        this.f.h = 0.0f;
        this.g.h = 0.5f;
        this.f.g = -(0.1f - ogSin * 0.6f);
        this.g.g = 0.1f - ogSin * 0.6f;
        this.f.f = -1.570796f;
        this.g.f = -3.141593f;
        final bcr f6 = this.f;
        f6.f -= ogSin * 1.2f - otherSin * 0.4f;
        final bcr g = this.g;
        g.f -= ogSin * 1.2f - otherSin * 0.4f;
        final bcr f7 = this.f;
        f7.h += lr.b(f2 * 0.26f) * 0.15f + 0.05f;
        final bcr g2 = this.g;
        g2.h -= lr.b(f2 * 0.26f) * 0.15f + 0.05f;
        final bcr f8 = this.f;
        f8.f += lr.a(f2 * 0.167f) * 0.15f;
        final bcr g3 = this.g;
        g3.f -= lr.a(f2 * 0.167f) * 0.15f;
        this.c.d = -4.0f;
        this.d.d = -4.0f;
        this.h.d = 9.5f;
        this.i.d = 9.5f;
    }
    
    private void setRotation(final bcr model, final float x, final float y, final float z) {
        model.f = x;
        model.g = y;
        model.h = z;
    }
}
