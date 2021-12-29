// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelTFHelmetCrab extends ModelBase
{
    ModelRenderer body;
    ModelRenderer helmetBase;
    ModelRenderer Leg8;
    ModelRenderer Leg6;
    ModelRenderer Leg4;
    ModelRenderer rightArm;
    ModelRenderer Leg5;
    ModelRenderer Leg3;
    ModelRenderer clawbase;
    ModelRenderer clawtop;
    ModelRenderer clawbottom;
    ModelRenderer righteye;
    ModelRenderer lefteye;
    public ModelRenderer helmet;
    public ModelRenderer righthorn1;
    public ModelRenderer righthorn2;
    public ModelRenderer lefthorn1;
    public ModelRenderer lefthorn2;
    
    public ModelTFHelmetCrab() {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        (this.body = new ModelRenderer((ModelBase)this, 32, 4)).func_78789_a(-2.5f, -2.5f, -5.0f, 5, 5, 5);
        this.body.func_78793_a(0.0f, 19.0f, 0.0f);
        (this.helmetBase = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 0, 0, 0);
        this.helmetBase.func_78793_a(0.0f, 18.0f, 0.0f);
        this.helmetBase.field_78795_f = -1.7453294f;
        this.helmetBase.field_78796_g = -0.5235988f;
        (this.helmet = new ModelRenderer((ModelBase)this, 0, 14)).func_78789_a(-3.5f, -11.0f, -3.5f, 7, 11, 7);
        this.helmet.field_78796_g = 0.7853982f;
        (this.righthorn1 = new ModelRenderer((ModelBase)this, 28, 14)).func_78789_a(-6.0f, -1.5f, -1.5f, 7, 3, 3);
        this.righthorn1.func_78793_a(-3.5f, -9.0f, 0.0f);
        this.righthorn1.field_78796_g = -0.2617994f;
        this.righthorn1.field_78808_h = 0.17453294f;
        (this.righthorn2 = new ModelRenderer((ModelBase)this, 28, 20)).func_78789_a(-3.0f, -1.0f, -1.0f, 3, 2, 2);
        this.righthorn2.func_78793_a(-5.5f, 0.0f, 0.0f);
        this.righthorn2.field_78796_g = -0.2617994f;
        this.righthorn2.field_78808_h = 0.17453294f;
        this.righthorn1.func_78792_a(this.righthorn2);
        this.lefthorn1 = new ModelRenderer((ModelBase)this, 28, 14);
        this.lefthorn1.field_78809_i = true;
        this.lefthorn1.func_78789_a(-1.0f, -1.5f, -1.5f, 7, 3, 3);
        this.lefthorn1.func_78793_a(3.5f, -9.0f, 0.0f);
        this.lefthorn1.field_78796_g = 0.2617994f;
        this.lefthorn1.field_78808_h = -0.17453294f;
        (this.lefthorn2 = new ModelRenderer((ModelBase)this, 28, 20)).func_78789_a(0.0f, -1.0f, -1.0f, 3, 2, 2);
        this.lefthorn2.func_78793_a(5.5f, 0.0f, 0.0f);
        this.lefthorn2.field_78796_g = 0.2617994f;
        this.lefthorn2.field_78808_h = -0.17453294f;
        this.lefthorn1.func_78792_a(this.lefthorn2);
        this.helmetBase.func_78792_a(this.helmet);
        this.helmetBase.func_78792_a(this.righthorn1);
        this.helmetBase.func_78792_a(this.lefthorn1);
        (this.Leg8 = new ModelRenderer((ModelBase)this, 18, 0)).func_78789_a(-1.0f, -1.0f, -1.0f, 8, 2, 2);
        this.Leg8.func_78793_a(3.0f, 20.0f, -3.0f);
        this.setRotation(this.Leg8, 0.0f, 0.5759587f, 0.1919862f);
        (this.Leg6 = new ModelRenderer((ModelBase)this, 18, 0)).func_78789_a(-1.0f, -1.0f, -1.0f, 8, 2, 2);
        this.Leg6.func_78793_a(3.0f, 20.0f, -2.0f);
        this.setRotation(this.Leg6, 0.0f, 0.2792527f, 0.1919862f);
        (this.Leg4 = new ModelRenderer((ModelBase)this, 18, 0)).func_78789_a(-1.0f, -1.0f, -1.0f, 8, 2, 2);
        this.Leg4.func_78793_a(3.0f, 20.0f, -1.0f);
        this.setRotation(this.Leg4, 0.0f, -0.2792527f, 0.1919862f);
        (this.rightArm = new ModelRenderer((ModelBase)this, 38, 0)).func_78789_a(-7.0f, -1.0f, -1.0f, 8, 2, 2);
        this.rightArm.func_78793_a(-3.0f, 20.0f, -3.0f);
        this.setRotation(this.rightArm, 0.0f, -1.319531f, -0.1919862f);
        (this.Leg5 = new ModelRenderer((ModelBase)this, 18, 0)).func_78789_a(-7.0f, -1.0f, -1.0f, 8, 2, 2);
        this.Leg5.func_78793_a(-3.0f, 20.0f, -2.0f);
        this.setRotation(this.Leg5, 0.0f, -0.2792527f, -0.1919862f);
        (this.Leg3 = new ModelRenderer((ModelBase)this, 18, 0)).func_78789_a(-7.0f, -1.0f, -1.0f, 8, 2, 2);
        this.Leg3.func_78793_a(-3.0f, 20.0f, -1.0f);
        this.setRotation(this.Leg3, 0.0f, 0.2792527f, -0.1919862f);
        (this.clawbase = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(0.0f, -1.5f, -1.0f, 3, 3, 2);
        this.clawbase.func_78793_a(-6.0f, 0.0f, -0.5f);
        this.setRotation(this.clawbase, 0.0f, 1.5707964f, 0.0f);
        (this.clawtop = new ModelRenderer((ModelBase)this, 0, 5)).func_78789_a(0.0f, -0.5f, -1.0f, 3, 1, 2);
        this.clawtop.func_78793_a(3.0f, -1.0f, 0.0f);
        this.setRotation(this.clawtop, 0.0f, 0.0f, -0.1858931f);
        (this.clawbottom = new ModelRenderer((ModelBase)this, 0, 8)).func_78789_a(0.0f, -0.5f, -1.0f, 3, 2, 2);
        this.clawbottom.func_78793_a(3.0f, 0.0f, 0.0f);
        this.setRotation(this.clawbottom, 0.0f, 0.0f, 0.2602503f);
        this.clawbase.func_78792_a(this.clawtop);
        this.clawbase.func_78792_a(this.clawbottom);
        this.rightArm.func_78792_a(this.clawbase);
        (this.righteye = new ModelRenderer((ModelBase)this, 10, 0)).func_78789_a(-1.0f, -3.0f, -1.0f, 2, 3, 2);
        this.righteye.func_78793_a(-1.0f, -1.0f, -4.0f);
        this.setRotation(this.righteye, 0.7853982f, 0.0f, -0.7853982f);
        (this.lefteye = new ModelRenderer((ModelBase)this, 10, 0)).func_78789_a(-1.0f, -3.0f, -1.0f, 2, 3, 2);
        this.lefteye.func_78793_a(1.0f, -1.0f, -4.0f);
        this.setRotation(this.lefteye, 0.7853982f, 0.0f, 0.7853982f);
        this.body.func_78792_a(this.righteye);
        this.body.func_78792_a(this.lefteye);
    }
    
    public void func_78088_a(final Entity par1Entity, final float par2, final float par3, final float par4, final float par5, final float par6, final float par7) {
        this.func_78087_a(par2, par3, par4, par5, par6, par7, par1Entity);
        this.body.func_78785_a(par7);
        this.helmetBase.func_78785_a(par7);
        this.Leg8.func_78785_a(par7);
        this.Leg6.func_78785_a(par7);
        this.Leg4.func_78785_a(par7);
        this.rightArm.func_78785_a(par7);
        this.Leg5.func_78785_a(par7);
        this.Leg3.func_78785_a(par7);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.field_78795_f = x;
        model.field_78796_g = y;
        model.field_78808_h = z;
    }
    
    public void func_78087_a(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final Entity par7Entity) {
        super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
        this.body.field_78796_g = par4 / 57.295776f;
        this.body.field_78795_f = par5 / 57.295776f;
        final float f6 = 0.7853982f;
        this.Leg3.field_78808_h = -f6 * 0.74f;
        this.Leg4.field_78808_h = f6 * 0.74f;
        this.Leg5.field_78808_h = -f6 * 0.74f;
        this.Leg6.field_78808_h = f6 * 0.74f;
        this.Leg8.field_78808_h = f6;
        final float f7 = -0.0f;
        final float f8 = 0.3926991f;
        this.Leg3.field_78796_g = f8 * 1.0f + f7;
        this.Leg4.field_78796_g = -f8 * 1.0f - f7;
        this.Leg5.field_78796_g = -f8 * 1.0f + f7;
        this.Leg6.field_78796_g = f8 * 1.0f - f7;
        this.Leg8.field_78796_g = f8 * 2.0f - f7;
        final float f9 = -(MathHelper.func_76134_b(par1 * 0.6662f * 2.0f + 0.0f) * 0.4f) * par2;
        final float f10 = -(MathHelper.func_76134_b(par1 * 0.6662f * 2.0f + 3.1415927f) * 0.4f) * par2;
        final float f11 = -(MathHelper.func_76134_b(par1 * 0.6662f * 2.0f + 1.5707964f) * 0.4f) * par2;
        final float f12 = -(MathHelper.func_76134_b(par1 * 0.6662f * 2.0f + 4.712389f) * 0.4f) * par2;
        final float f13 = Math.abs(MathHelper.func_76126_a(par1 * 0.6662f + 0.0f) * 0.4f) * par2;
        final float f14 = Math.abs(MathHelper.func_76126_a(par1 * 0.6662f + 3.1415927f) * 0.4f) * par2;
        final float f15 = Math.abs(MathHelper.func_76126_a(par1 * 0.6662f + 1.5707964f) * 0.4f) * par2;
        final float f16 = Math.abs(MathHelper.func_76126_a(par1 * 0.6662f + 4.712389f) * 0.4f) * par2;
        final ModelRenderer leg3 = this.Leg3;
        leg3.field_78796_g += f10;
        final ModelRenderer leg4 = this.Leg4;
        leg4.field_78796_g += -f10;
        final ModelRenderer leg5 = this.Leg5;
        leg5.field_78796_g += f11;
        final ModelRenderer leg6 = this.Leg6;
        leg6.field_78796_g += -f11;
        final ModelRenderer leg7 = this.Leg8;
        leg7.field_78796_g += -f12;
        final ModelRenderer leg8 = this.Leg3;
        leg8.field_78808_h += f14;
        final ModelRenderer leg9 = this.Leg4;
        leg9.field_78808_h += -f14;
        final ModelRenderer leg10 = this.Leg5;
        leg10.field_78808_h += f15;
        final ModelRenderer leg11 = this.Leg6;
        leg11.field_78808_h += -f15;
        final ModelRenderer leg12 = this.Leg8;
        leg12.field_78808_h += -f16;
        this.rightArm.field_78796_g = -1.319531f;
        final ModelRenderer rightArm = this.rightArm;
        rightArm.field_78796_g += MathHelper.func_76134_b(par1 * 0.6662f + 3.1415927f) * 2.0f * par2 * 0.5f;
    }
}
