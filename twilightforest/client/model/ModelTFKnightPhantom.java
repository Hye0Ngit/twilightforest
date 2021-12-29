// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBiped;

public class ModelTFKnightPhantom extends ModelBiped
{
    public ModelRenderer helmet;
    public ModelRenderer righthorn1;
    public ModelRenderer righthorn2;
    public ModelRenderer lefthorn1;
    public ModelRenderer lefthorn2;
    
    public ModelTFKnightPhantom() {
        this.field_78119_l = 0;
        this.field_78120_m = 0;
        this.field_78117_n = false;
        this.field_78118_o = false;
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        (this.field_78122_k = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-5.0f, 0.0f, -1.0f, 10, 16, 1);
        (this.field_78121_j = new ModelRenderer((ModelBase)this, 24, 0)).func_78789_a(-3.0f, -6.0f, -1.0f, 6, 6, 1);
        (this.field_78116_c = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 0, 0, 0);
        this.field_78116_c.func_78793_a(0.0f, -10.0f, 0.0f);
        (this.field_78114_d = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 0, 0, 0);
        this.field_78114_d.func_78793_a(0.0f, -10.0f, 0.0f);
        (this.helmet = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-4.0f, -11.0f, -4.0f, 8, 11, 8);
        this.helmet.field_78796_g = 0.7853982f;
        (this.righthorn1 = new ModelRenderer((ModelBase)this, 28, 0)).func_78789_a(-6.0f, -1.5f, -1.5f, 7, 3, 3);
        this.righthorn1.func_78793_a(-3.5f, -9.0f, 0.0f);
        this.righthorn1.field_78796_g = 0.2617994f;
        this.righthorn1.field_78808_h = 0.17453294f;
        (this.righthorn2 = new ModelRenderer((ModelBase)this, 28, 6)).func_78789_a(-3.0f, -1.0f, -1.0f, 3, 2, 2);
        this.righthorn2.func_78793_a(-5.5f, 0.0f, 0.0f);
        this.righthorn2.field_78808_h = 0.17453294f;
        this.righthorn1.func_78792_a(this.righthorn2);
        this.lefthorn1 = new ModelRenderer((ModelBase)this, 28, 0);
        this.lefthorn1.field_78809_i = true;
        this.lefthorn1.func_78789_a(-1.0f, -1.5f, -1.5f, 7, 3, 3);
        this.lefthorn1.func_78793_a(3.5f, -9.0f, 0.0f);
        this.lefthorn1.field_78796_g = -0.2617994f;
        this.lefthorn1.field_78808_h = -0.17453294f;
        (this.lefthorn2 = new ModelRenderer((ModelBase)this, 28, 6)).func_78789_a(0.0f, -1.0f, -1.0f, 3, 2, 2);
        this.lefthorn2.func_78793_a(5.5f, 0.0f, 0.0f);
        this.lefthorn2.field_78808_h = -0.17453294f;
        this.lefthorn1.func_78792_a(this.lefthorn2);
        this.field_78114_d.func_78792_a(this.helmet);
        this.field_78114_d.func_78792_a(this.righthorn1);
        this.field_78114_d.func_78792_a(this.lefthorn1);
        (this.field_78115_e = new ModelRenderer((ModelBase)this, 0, 18)).func_78793_a(0.0f, 2.0f, 0.0f);
        this.field_78115_e.func_78789_a(-7.0f, -12.0f, -3.5f, 14, 12, 7);
        this.field_78115_e.func_78784_a(30, 24).func_78789_a(-6.0f, 0.0f, -3.0f, 12, 8, 6);
        (this.field_78112_f = new ModelRenderer((ModelBase)this, 44, 16)).func_78789_a(-5.0f, -2.0f, -3.0f, 6, 7, 6);
        this.field_78112_f.func_78793_a(-8.0f, -8.0f, 0.0f);
        this.field_78113_g = new ModelRenderer((ModelBase)this, 44, 16);
        this.field_78113_g.field_78809_i = true;
        this.field_78113_g.func_78789_a(-1.0f, -2.0f, -3.0f, 6, 7, 6);
        this.field_78113_g.func_78793_a(8.0f, -8.0f, 0.0f);
        (this.field_78123_h = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 0, 0, 0);
        this.field_78123_h.func_78793_a(0.0f, 12.0f, 0.0f);
        (this.field_78124_i = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 0, 0, 0);
        this.field_78124_i.func_78793_a(0.0f, 12.0f, 0.0f);
    }
    
    public void func_78087_a(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final Entity par7Entity) {
        this.field_78116_c.field_78796_g = par4 / 57.295776f;
        this.field_78116_c.field_78795_f = par5 / 57.295776f;
        this.field_78116_c.field_78808_h = 0.0f;
        this.field_78114_d.field_78796_g = this.field_78116_c.field_78796_g;
        this.field_78114_d.field_78795_f = this.field_78116_c.field_78795_f;
        this.field_78114_d.field_78808_h = this.field_78116_c.field_78808_h;
        this.field_78112_f.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662f + 3.1415927f) * 2.0f * par2 * 0.5f;
        this.field_78113_g.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662f) * 2.0f * par2 * 0.5f;
        this.field_78112_f.field_78808_h = 0.0f;
        this.field_78113_g.field_78808_h = 0.0f;
        if (this.field_78119_l != 0) {
            this.field_78113_g.field_78795_f = this.field_78113_g.field_78795_f * 0.5f - 0.31415927f * this.field_78119_l;
        }
        this.field_78120_m = 1;
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
    }
}
