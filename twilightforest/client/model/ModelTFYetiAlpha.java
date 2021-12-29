// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import net.minecraft.util.MathHelper;
import twilightforest.entity.boss.EntityTFYetiAlpha;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBiped;

public class ModelTFYetiAlpha extends ModelBiped
{
    public ModelRenderer mouth;
    public ModelRenderer leftEye;
    public ModelRenderer rightEye;
    
    public ModelTFYetiAlpha() {
        this.field_78090_t = 256;
        this.field_78089_u = 128;
        (this.field_78116_c = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-4.0f, -8.0f, -4.0f, 0, 0, 0);
        (this.field_78114_d = new ModelRenderer((ModelBase)this, 32, 0)).func_78789_a(-4.0f, -8.0f, -4.0f, 0, 0, 0);
        (this.field_78115_e = new ModelRenderer((ModelBase)this, 80, 0)).func_78789_a(-24.0f, -60.0f, -18.0f, 48, 72, 36);
        this.field_78115_e.func_78793_a(0.0f, -6.0f, 0.0f);
        (this.mouth = new ModelRenderer((ModelBase)this, 121, 50)).func_78789_a(-17.0f, -7.0f, -1.5f, 34, 29, 2);
        this.mouth.func_78793_a(0.0f, -37.0f, -18.0f);
        this.field_78115_e.func_78792_a(this.mouth);
        (this.rightEye = new ModelRenderer((ModelBase)this, 64, 0)).func_78789_a(-6.0f, -6.0f, -1.5f, 12, 12, 2);
        this.rightEye.func_78793_a(-14.0f, -50.0f, -18.0f);
        this.field_78115_e.func_78792_a(this.rightEye);
        (this.leftEye = new ModelRenderer((ModelBase)this, 64, 0)).func_78789_a(-6.0f, -6.0f, -1.5f, 12, 12, 2);
        this.leftEye.func_78793_a(14.0f, -50.0f, -18.0f);
        this.field_78115_e.func_78792_a(this.leftEye);
        (this.field_78112_f = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-15.0f, -6.0f, -8.0f, 16, 48, 16);
        this.field_78112_f.func_78793_a(-25.0f, -26.0f, 0.0f);
        this.field_78115_e.func_78792_a(this.field_78112_f);
        this.field_78113_g = new ModelRenderer((ModelBase)this, 0, 0);
        this.field_78113_g.field_78809_i = true;
        this.field_78113_g.func_78789_a(-1.0f, -6.0f, -8.0f, 16, 48, 16);
        this.field_78113_g.func_78793_a(25.0f, -26.0f, 0.0f);
        this.field_78115_e.func_78792_a(this.field_78113_g);
        (this.field_78123_h = new ModelRenderer((ModelBase)this, 0, 66)).func_78789_a(-10.0f, 0.0f, -10.0f, 20, 20, 20);
        this.field_78123_h.func_78793_a(-13.5f, 4.0f, 0.0f);
        this.field_78124_i = new ModelRenderer((ModelBase)this, 0, 66);
        this.field_78124_i.field_78809_i = true;
        this.field_78124_i.func_78789_a(-10.0f, 0.0f, -10.0f, 20, 20, 20);
        this.field_78124_i.func_78793_a(13.5f, 4.0f, 0.0f);
        this.addPairHorns(-58.0f, 35.0f);
        this.addPairHorns(-46.0f, 15.0f);
        this.addPairHorns(-36.0f, -5.0f);
    }
    
    private void addPairHorns(final float height, final float zangle) {
        final ModelRenderer horn1a = new ModelRenderer((ModelBase)this, 0, 108);
        horn1a.func_78789_a(-9.0f, -5.0f, -5.0f, 10, 10, 10);
        horn1a.func_78793_a(-24.0f, height, -8.0f);
        horn1a.field_78796_g = -0.5235988f;
        horn1a.field_78808_h = zangle / 57.295776f;
        this.field_78115_e.func_78792_a(horn1a);
        final ModelRenderer horn1b = new ModelRenderer((ModelBase)this, 40, 108);
        horn1b.func_78789_a(-14.0f, -4.0f, -4.0f, 18, 8, 8);
        horn1b.func_78793_a(-8.0f, 0.0f, 0.0f);
        horn1b.field_78796_g = -0.34906587f;
        horn1b.field_78808_h = zangle / 57.295776f;
        horn1a.func_78792_a(horn1b);
        final ModelRenderer horn2a = new ModelRenderer((ModelBase)this, 0, 108);
        horn2a.func_78789_a(-1.0f, -5.0f, -5.0f, 10, 10, 10);
        horn2a.func_78793_a(24.0f, height, 0.0f);
        horn2a.field_78796_g = 0.5235988f;
        horn2a.field_78808_h = -zangle / 57.295776f;
        this.field_78115_e.func_78792_a(horn2a);
        final ModelRenderer horn2b = new ModelRenderer((ModelBase)this, 40, 108);
        horn2b.func_78789_a(-2.0f, -4.0f, -4.0f, 18, 8, 8);
        horn2b.func_78793_a(8.0f, 0.0f, 0.0f);
        horn2b.field_78796_g = 0.34906587f;
        horn2b.field_78808_h = -zangle / 57.295776f;
        horn2a.func_78792_a(horn2b);
    }
    
    public void func_78088_a(final Entity par1Entity, final float par2, final float par3, final float par4, final float par5, final float par6, final float par7) {
        this.func_78087_a(par2, par3, par4, par5, par6, par7, par1Entity);
        this.field_78115_e.func_78785_a(par7);
        this.field_78123_h.func_78785_a(par7);
        this.field_78124_i.func_78785_a(par7);
    }
    
    public void func_78087_a(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final Entity par7Entity) {
        final EntityTFYetiAlpha yeti = (EntityTFYetiAlpha)par7Entity;
        this.field_78116_c.field_78796_g = par4 / 57.295776f;
        this.field_78116_c.field_78795_f = par5 / 57.295776f;
        this.field_78115_e.field_78795_f = par5 / 57.295776f;
        this.field_78123_h.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662f) * 1.4f * par2;
        this.field_78124_i.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.field_78123_h.field_78796_g = 0.0f;
        this.field_78124_i.field_78796_g = 0.0f;
        final float f6 = MathHelper.func_76126_a(this.field_78095_p * 3.1415927f);
        final float f7 = MathHelper.func_76126_a((1.0f - (1.0f - this.field_78095_p) * (1.0f - this.field_78095_p)) * 3.1415927f);
        this.field_78112_f.field_78808_h = 0.0f;
        this.field_78113_g.field_78808_h = 0.0f;
        this.field_78112_f.field_78796_g = -(0.1f - f6 * 0.6f);
        this.field_78113_g.field_78796_g = 0.1f - f6 * 0.6f;
        this.field_78112_f.field_78795_f = -1.5707964f;
        this.field_78113_g.field_78795_f = -1.5707964f;
        final ModelRenderer field_78112_f = this.field_78112_f;
        field_78112_f.field_78795_f -= f6 * 1.2f - f7 * 0.4f;
        final ModelRenderer field_78113_g = this.field_78113_g;
        field_78113_g.field_78795_f -= f6 * 1.2f - f7 * 0.4f;
        final ModelRenderer field_78112_f2 = this.field_78112_f;
        field_78112_f2.field_78808_h += MathHelper.func_76134_b(par3 * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer field_78113_g2 = this.field_78113_g;
        field_78113_g2.field_78808_h -= MathHelper.func_76134_b(par3 * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer field_78112_f3 = this.field_78112_f;
        field_78112_f3.field_78795_f += MathHelper.func_76126_a(par3 * 0.067f) * 0.05f;
        final ModelRenderer field_78113_g3 = this.field_78113_g;
        field_78113_g3.field_78795_f -= MathHelper.func_76126_a(par3 * 0.067f) * 0.05f;
        this.field_78115_e.field_78797_d = -6.0f;
        this.field_78123_h.field_78797_d = 4.0f;
        this.field_78124_i.field_78797_d = 4.0f;
        if (yeti.isTired()) {
            this.field_78112_f.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662f + 3.1415927f) * 2.0f * par2 * 0.5f;
            this.field_78113_g.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662f) * 2.0f * par2 * 0.5f;
            this.field_78112_f.field_78808_h = 0.0f;
            this.field_78113_g.field_78808_h = 0.0f;
            final ModelRenderer field_78112_f4 = this.field_78112_f;
            field_78112_f4.field_78795_f -= 0.62831855f;
            final ModelRenderer field_78113_g4 = this.field_78113_g;
            field_78113_g4.field_78795_f -= 0.62831855f;
            this.field_78123_h.field_78795_f = -1.2566371f;
            this.field_78124_i.field_78795_f = -1.2566371f;
            this.field_78123_h.field_78796_g = 0.31415927f;
            this.field_78124_i.field_78796_g = -0.31415927f;
            this.field_78115_e.field_78797_d = 6.0f;
            this.field_78123_h.field_78797_d = 12.0f;
            this.field_78124_i.field_78797_d = 12.0f;
        }
        if (yeti.isRampaging()) {
            this.field_78112_f.field_78795_f = MathHelper.func_76134_b(par1 * 0.66f + 3.1415927f) * 2.0f * par2 * 0.5f;
            this.field_78113_g.field_78795_f = MathHelper.func_76134_b(par1 * 0.66f) * 2.0f * par2 * 0.5f;
            final ModelRenderer field_78112_f5 = this.field_78112_f;
            field_78112_f5.field_78796_g += MathHelper.func_76134_b(par1 * 0.25f) * 0.5f + 0.5f;
            final ModelRenderer field_78113_g5 = this.field_78113_g;
            field_78113_g5.field_78796_g -= MathHelper.func_76134_b(par1 * 0.25f) * 0.5f + 0.5f;
            final ModelRenderer field_78112_f6 = this.field_78112_f;
            field_78112_f6.field_78795_f += (float)3.9269908169872414;
            final ModelRenderer field_78113_g6 = this.field_78113_g;
            field_78113_g6.field_78795_f += (float)3.9269908169872414;
            this.field_78112_f.field_78808_h = 0.0f;
            this.field_78113_g.field_78808_h = 0.0f;
        }
        if (par7Entity.field_70153_n != null) {
            final ModelRenderer field_78112_f7 = this.field_78112_f;
            field_78112_f7.field_78795_f += (float)3.141592653589793;
            final ModelRenderer field_78113_g7 = this.field_78113_g;
            field_78113_g7.field_78795_f += (float)3.141592653589793;
        }
    }
}
