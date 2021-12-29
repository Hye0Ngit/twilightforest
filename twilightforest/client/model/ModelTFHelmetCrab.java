// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

public class ModelTFHelmetCrab extends bbl
{
    bcr body;
    bcr helmetBase;
    bcr Leg8;
    bcr Leg6;
    bcr Leg4;
    bcr rightArm;
    bcr Leg5;
    bcr Leg3;
    bcr clawbase;
    bcr clawtop;
    bcr clawbottom;
    bcr righteye;
    bcr lefteye;
    public bcr helmet;
    public bcr righthorn1;
    public bcr righthorn2;
    public bcr lefthorn1;
    public bcr lefthorn2;
    
    public ModelTFHelmetCrab() {
        this.t = 64;
        this.u = 32;
        (this.body = new bcr((bbl)this, 32, 4)).a(-2.5f, -2.5f, -5.0f, 5, 5, 5);
        this.body.a(0.0f, 19.0f, 0.0f);
        (this.helmetBase = new bcr((bbl)this, 0, 0)).a(0.0f, 0.0f, 0.0f, 0, 0, 0);
        this.helmetBase.a(0.0f, 18.0f, 0.0f);
        this.helmetBase.f = -1.7453294f;
        this.helmetBase.g = -0.5235988f;
        (this.helmet = new bcr((bbl)this, 0, 14)).a(-3.5f, -11.0f, -3.5f, 7, 11, 7);
        this.helmet.g = 0.7853982f;
        (this.righthorn1 = new bcr((bbl)this, 28, 14)).a(-6.0f, -1.5f, -1.5f, 7, 3, 3);
        this.righthorn1.a(-3.5f, -9.0f, 0.0f);
        this.righthorn1.g = -0.2617994f;
        this.righthorn1.h = 0.17453294f;
        (this.righthorn2 = new bcr((bbl)this, 28, 20)).a(-3.0f, -1.0f, -1.0f, 3, 2, 2);
        this.righthorn2.a(-5.5f, 0.0f, 0.0f);
        this.righthorn2.g = -0.2617994f;
        this.righthorn2.h = 0.17453294f;
        this.righthorn1.a(this.righthorn2);
        this.lefthorn1 = new bcr((bbl)this, 28, 14);
        this.lefthorn1.i = true;
        this.lefthorn1.a(-1.0f, -1.5f, -1.5f, 7, 3, 3);
        this.lefthorn1.a(3.5f, -9.0f, 0.0f);
        this.lefthorn1.g = 0.2617994f;
        this.lefthorn1.h = -0.17453294f;
        (this.lefthorn2 = new bcr((bbl)this, 28, 20)).a(0.0f, -1.0f, -1.0f, 3, 2, 2);
        this.lefthorn2.a(5.5f, 0.0f, 0.0f);
        this.lefthorn2.g = 0.2617994f;
        this.lefthorn2.h = -0.17453294f;
        this.lefthorn1.a(this.lefthorn2);
        this.helmetBase.a(this.helmet);
        this.helmetBase.a(this.righthorn1);
        this.helmetBase.a(this.lefthorn1);
        (this.Leg8 = new bcr((bbl)this, 18, 0)).a(-1.0f, -1.0f, -1.0f, 8, 2, 2);
        this.Leg8.a(3.0f, 20.0f, -3.0f);
        this.setRotation(this.Leg8, 0.0f, 0.5759587f, 0.1919862f);
        (this.Leg6 = new bcr((bbl)this, 18, 0)).a(-1.0f, -1.0f, -1.0f, 8, 2, 2);
        this.Leg6.a(3.0f, 20.0f, -2.0f);
        this.setRotation(this.Leg6, 0.0f, 0.2792527f, 0.1919862f);
        (this.Leg4 = new bcr((bbl)this, 18, 0)).a(-1.0f, -1.0f, -1.0f, 8, 2, 2);
        this.Leg4.a(3.0f, 20.0f, -1.0f);
        this.setRotation(this.Leg4, 0.0f, -0.2792527f, 0.1919862f);
        (this.rightArm = new bcr((bbl)this, 38, 0)).a(-7.0f, -1.0f, -1.0f, 8, 2, 2);
        this.rightArm.a(-3.0f, 20.0f, -3.0f);
        this.setRotation(this.rightArm, 0.0f, -1.319531f, -0.1919862f);
        (this.Leg5 = new bcr((bbl)this, 18, 0)).a(-7.0f, -1.0f, -1.0f, 8, 2, 2);
        this.Leg5.a(-3.0f, 20.0f, -2.0f);
        this.setRotation(this.Leg5, 0.0f, -0.2792527f, -0.1919862f);
        (this.Leg3 = new bcr((bbl)this, 18, 0)).a(-7.0f, -1.0f, -1.0f, 8, 2, 2);
        this.Leg3.a(-3.0f, 20.0f, -1.0f);
        this.setRotation(this.Leg3, 0.0f, 0.2792527f, -0.1919862f);
        (this.clawbase = new bcr((bbl)this, 0, 0)).a(0.0f, -1.5f, -1.0f, 3, 3, 2);
        this.clawbase.a(-6.0f, 0.0f, -0.5f);
        this.setRotation(this.clawbase, 0.0f, 1.5707964f, 0.0f);
        (this.clawtop = new bcr((bbl)this, 0, 5)).a(0.0f, -0.5f, -1.0f, 3, 1, 2);
        this.clawtop.a(3.0f, -1.0f, 0.0f);
        this.setRotation(this.clawtop, 0.0f, 0.0f, -0.1858931f);
        (this.clawbottom = new bcr((bbl)this, 0, 8)).a(0.0f, -0.5f, -1.0f, 3, 2, 2);
        this.clawbottom.a(3.0f, 0.0f, 0.0f);
        this.setRotation(this.clawbottom, 0.0f, 0.0f, 0.2602503f);
        this.clawbase.a(this.clawtop);
        this.clawbase.a(this.clawbottom);
        this.rightArm.a(this.clawbase);
        (this.righteye = new bcr((bbl)this, 10, 0)).a(-1.0f, -3.0f, -1.0f, 2, 3, 2);
        this.righteye.a(-1.0f, -1.0f, -4.0f);
        this.setRotation(this.righteye, 0.7853982f, 0.0f, -0.7853982f);
        (this.lefteye = new bcr((bbl)this, 10, 0)).a(-1.0f, -3.0f, -1.0f, 2, 3, 2);
        this.lefteye.a(1.0f, -1.0f, -4.0f);
        this.setRotation(this.lefteye, 0.7853982f, 0.0f, 0.7853982f);
        this.body.a(this.righteye);
        this.body.a(this.lefteye);
    }
    
    public void a(final nm par1Entity, final float par2, final float par3, final float par4, final float par5, final float par6, final float par7) {
        this.a(par2, par3, par4, par5, par6, par7, par1Entity);
        this.body.a(par7);
        this.helmetBase.a(par7);
        this.Leg8.a(par7);
        this.Leg6.a(par7);
        this.Leg4.a(par7);
        this.rightArm.a(par7);
        this.Leg5.a(par7);
        this.Leg3.a(par7);
    }
    
    private void setRotation(final bcr model, final float x, final float y, final float z) {
        model.f = x;
        model.g = y;
        model.h = z;
    }
    
    public void a(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final nm par7Entity) {
        super.a(par1, par2, par3, par4, par5, par6, par7Entity);
        this.body.g = par4 / 57.295776f;
        this.body.f = par5 / 57.295776f;
        final float f6 = 0.7853982f;
        this.Leg3.h = -f6 * 0.74f;
        this.Leg4.h = f6 * 0.74f;
        this.Leg5.h = -f6 * 0.74f;
        this.Leg6.h = f6 * 0.74f;
        this.Leg8.h = f6;
        final float f7 = -0.0f;
        final float f8 = 0.3926991f;
        this.Leg3.g = f8 * 1.0f + f7;
        this.Leg4.g = -f8 * 1.0f - f7;
        this.Leg5.g = -f8 * 1.0f + f7;
        this.Leg6.g = f8 * 1.0f - f7;
        this.Leg8.g = f8 * 2.0f - f7;
        final float f9 = -(lr.b(par1 * 0.6662f * 2.0f + 0.0f) * 0.4f) * par2;
        final float f10 = -(lr.b(par1 * 0.6662f * 2.0f + 3.1415927f) * 0.4f) * par2;
        final float f11 = -(lr.b(par1 * 0.6662f * 2.0f + 1.5707964f) * 0.4f) * par2;
        final float f12 = -(lr.b(par1 * 0.6662f * 2.0f + 4.712389f) * 0.4f) * par2;
        final float f13 = Math.abs(lr.a(par1 * 0.6662f + 0.0f) * 0.4f) * par2;
        final float f14 = Math.abs(lr.a(par1 * 0.6662f + 3.1415927f) * 0.4f) * par2;
        final float f15 = Math.abs(lr.a(par1 * 0.6662f + 1.5707964f) * 0.4f) * par2;
        final float f16 = Math.abs(lr.a(par1 * 0.6662f + 4.712389f) * 0.4f) * par2;
        final bcr leg3 = this.Leg3;
        leg3.g += f10;
        final bcr leg4 = this.Leg4;
        leg4.g += -f10;
        final bcr leg5 = this.Leg5;
        leg5.g += f11;
        final bcr leg6 = this.Leg6;
        leg6.g += -f11;
        final bcr leg7 = this.Leg8;
        leg7.g += -f12;
        final bcr leg8 = this.Leg3;
        leg8.h += f14;
        final bcr leg9 = this.Leg4;
        leg9.h += -f14;
        final bcr leg10 = this.Leg5;
        leg10.h += f15;
        final bcr leg11 = this.Leg6;
        leg11.h += -f15;
        final bcr leg12 = this.Leg8;
        leg12.h += -f16;
        this.rightArm.g = -1.319531f;
        final bcr rightArm = this.rightArm;
        rightArm.g += lr.b(par1 * 0.6662f + 3.1415927f) * 2.0f * par2 * 0.5f;
    }
}
