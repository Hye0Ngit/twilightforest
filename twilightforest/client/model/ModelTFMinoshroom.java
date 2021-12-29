// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBiped;

public class ModelTFMinoshroom extends ModelBiped
{
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer udders;
    ModelRenderer snout;
    public ModelRenderer righthorn1;
    public ModelRenderer righthorn2;
    public ModelRenderer lefthorn1;
    public ModelRenderer lefthorn2;
    
    public ModelTFMinoshroom() {
        this.field_78090_t = 128;
        this.field_78089_u = 32;
        (this.field_78116_c = new ModelRenderer((ModelBase)this, 96, 16)).func_78789_a(-4.0f, -8.0f, -4.0f, 8, 8, 8);
        this.field_78116_c.func_78793_a(0.0f, -6.0f, -9.0f);
        (this.body = new ModelRenderer((ModelBase)this, 18, 4)).func_78789_a(-6.0f, -10.0f, -7.0f, 12, 18, 10);
        this.body.func_78793_a(0.0f, 5.0f, 2.0f);
        this.setRotation(this.body, 1.570796f, 0.0f, 0.0f);
        (this.leg1 = new ModelRenderer((ModelBase)this, 0, 16)).func_78789_a(-3.0f, 0.0f, -2.0f, 4, 12, 4);
        this.leg1.func_78793_a(-3.0f, 12.0f, 7.0f);
        (this.leg2 = new ModelRenderer((ModelBase)this, 0, 16)).func_78789_a(-1.0f, 0.0f, -2.0f, 4, 12, 4);
        this.leg2.func_78793_a(3.0f, 12.0f, 7.0f);
        (this.leg3 = new ModelRenderer((ModelBase)this, 0, 16)).func_78789_a(-3.0f, 0.0f, -3.0f, 4, 12, 4);
        this.leg3.func_78793_a(-3.0f, 12.0f, -5.0f);
        (this.leg4 = new ModelRenderer((ModelBase)this, 0, 16)).func_78789_a(-1.0f, 0.0f, -3.0f, 4, 12, 4);
        this.leg4.func_78793_a(3.0f, 12.0f, -5.0f);
        (this.udders = new ModelRenderer((ModelBase)this, 52, 0)).func_78789_a(-2.0f, -3.0f, 0.0f, 4, 6, 2);
        this.udders.func_78793_a(0.0f, 14.0f, 6.0f);
        this.setRotation(this.udders, 1.570796f, 0.0f, 0.0f);
        (this.field_78115_e = new ModelRenderer((ModelBase)this, 64, 0)).func_78789_a(-4.0f, 0.0f, -2.5f, 8, 12, 5);
        this.field_78115_e.func_78793_a(0.0f, -6.0f, -9.0f);
        (this.field_78113_g = new ModelRenderer((ModelBase)this, 90, 0)).func_78789_a(-1.0f, -2.0f, -2.0f, 4, 12, 4);
        this.field_78113_g.func_78793_a(5.0f, -4.0f, -9.0f);
        this.field_78113_g.field_78809_i = true;
        (this.field_78112_f = new ModelRenderer((ModelBase)this, 90, 0)).func_78789_a(-3.0f, -2.0f, -2.0f, 4, 12, 4);
        this.field_78112_f.func_78793_a(-5.0f, -4.0f, -9.0f);
        (this.righthorn1 = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-5.5f, -1.5f, -1.5f, 5, 3, 3);
        this.righthorn1.func_78793_a(-2.5f, -6.5f, 0.0f);
        this.righthorn1.field_78796_g = -0.43633235f;
        this.righthorn1.field_78808_h = 0.17453294f;
        (this.righthorn2 = new ModelRenderer((ModelBase)this, 16, 0)).func_78789_a(-3.5f, -1.0f, -1.0f, 3, 2, 2);
        this.righthorn2.func_78793_a(-4.5f, 0.0f, 0.0f);
        this.righthorn2.field_78796_g = -0.2617994f;
        this.righthorn2.field_78808_h = 0.7853982f;
        this.righthorn1.func_78792_a(this.righthorn2);
        this.lefthorn1 = new ModelRenderer((ModelBase)this, 0, 0);
        this.lefthorn1.field_78809_i = true;
        this.lefthorn1.func_78789_a(0.5f, -1.5f, -1.5f, 5, 3, 3);
        this.lefthorn1.func_78793_a(2.5f, -6.5f, 0.0f);
        this.lefthorn1.field_78796_g = 0.43633235f;
        this.lefthorn1.field_78808_h = -0.17453294f;
        (this.lefthorn2 = new ModelRenderer((ModelBase)this, 16, 0)).func_78789_a(0.5f, -1.0f, -1.0f, 3, 2, 2);
        this.lefthorn2.func_78793_a(4.5f, 0.0f, 0.0f);
        this.lefthorn2.field_78796_g = 0.2617994f;
        this.lefthorn2.field_78808_h = -0.7853982f;
        this.lefthorn1.func_78792_a(this.lefthorn2);
        this.field_78116_c.func_78792_a(this.righthorn1);
        this.field_78116_c.func_78792_a(this.lefthorn1);
        (this.snout = new ModelRenderer((ModelBase)this, 105, 28)).func_78789_a(-2.0f, -1.0f, -1.0f, 4, 3, 1);
        this.snout.func_78793_a(0.0f, -2.0f, -4.0f);
        this.field_78116_c.func_78792_a(this.snout);
        this.field_78114_d = new ModelRenderer((ModelBase)this, 0, 0);
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        this.field_78116_c.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.leg1.func_78785_a(f5);
        this.leg2.func_78785_a(f5);
        this.leg3.func_78785_a(f5);
        this.leg4.func_78785_a(f5);
        this.udders.func_78785_a(f5);
        this.field_78115_e.func_78785_a(f5);
        this.field_78113_g.func_78785_a(f5);
        this.field_78112_f.func_78785_a(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.field_78795_f = x;
        model.field_78796_g = y;
        model.field_78808_h = z;
    }
    
    public void func_78087_a(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final Entity entity) {
        this.field_78116_c.field_78796_g = par4 / 57.295776f;
        this.field_78116_c.field_78795_f = par5 / 57.295776f;
        this.field_78114_d.field_78796_g = this.field_78116_c.field_78796_g;
        this.field_78114_d.field_78795_f = this.field_78116_c.field_78795_f;
        this.field_78112_f.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662f + 3.1415927f) * 2.0f * par2 * 0.5f;
        this.field_78113_g.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662f) * 2.0f * par2 * 0.5f;
        this.field_78112_f.field_78808_h = 0.0f;
        this.field_78113_g.field_78808_h = 0.0f;
        this.field_78123_h.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662f) * 1.4f * par2;
        this.field_78124_i.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.field_78123_h.field_78796_g = 0.0f;
        this.field_78124_i.field_78796_g = 0.0f;
        if (this.field_78119_l != 0) {
            this.field_78113_g.field_78795_f = this.field_78113_g.field_78795_f * 0.5f - 0.31415927f * this.field_78119_l;
        }
        if (this.field_78120_m != 0) {
            this.field_78112_f.field_78795_f = this.field_78112_f.field_78795_f * 0.5f - 0.31415927f * this.field_78120_m;
        }
        final ModelRenderer field_78112_f = this.field_78112_f;
        field_78112_f.field_78808_h += MathHelper.func_76134_b(par3 * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer field_78113_g = this.field_78113_g;
        field_78113_g.field_78808_h -= MathHelper.func_76134_b(par3 * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer field_78112_f2 = this.field_78112_f;
        field_78112_f2.field_78795_f += MathHelper.func_76126_a(par3 * 0.067f) * 0.05f;
        final ModelRenderer field_78113_g2 = this.field_78113_g;
        field_78113_g2.field_78795_f -= MathHelper.func_76126_a(par3 * 0.067f) * 0.05f;
        if (this.field_78118_o) {
            final float var7 = 0.0f;
            final float var8 = 0.0f;
            this.field_78112_f.field_78808_h = 0.0f;
            this.field_78113_g.field_78808_h = 0.0f;
            this.field_78112_f.field_78796_g = -(0.1f - var7 * 0.6f) + this.field_78116_c.field_78796_g;
            this.field_78113_g.field_78796_g = 0.1f - var7 * 0.6f + this.field_78116_c.field_78796_g + 0.4f;
            this.field_78112_f.field_78795_f = -1.5707964f + this.field_78116_c.field_78795_f;
            this.field_78113_g.field_78795_f = -1.5707964f + this.field_78116_c.field_78795_f;
            final ModelRenderer field_78112_f3 = this.field_78112_f;
            field_78112_f3.field_78795_f -= var7 * 1.2f - var8 * 0.4f;
            final ModelRenderer field_78113_g3 = this.field_78113_g;
            field_78113_g3.field_78795_f -= var7 * 1.2f - var8 * 0.4f;
            final ModelRenderer field_78112_f4 = this.field_78112_f;
            field_78112_f4.field_78808_h += MathHelper.func_76134_b(par3 * 0.09f) * 0.05f + 0.05f;
            final ModelRenderer field_78113_g4 = this.field_78113_g;
            field_78113_g4.field_78808_h -= MathHelper.func_76134_b(par3 * 0.09f) * 0.05f + 0.05f;
            final ModelRenderer field_78112_f5 = this.field_78112_f;
            field_78112_f5.field_78795_f += MathHelper.func_76126_a(par3 * 0.067f) * 0.05f;
            final ModelRenderer field_78113_g5 = this.field_78113_g;
            field_78113_g5.field_78795_f -= MathHelper.func_76126_a(par3 * 0.067f) * 0.05f;
        }
        this.body.field_78795_f = 1.5707964f;
        this.leg1.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662f) * 1.4f * par2;
        this.leg2.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.leg3.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.leg4.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662f) * 1.4f * par2;
    }
}
