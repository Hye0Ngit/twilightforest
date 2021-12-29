// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBiped;

public class ModelTFTroll extends ModelBiped
{
    public ModelRenderer nose;
    
    public ModelTFTroll() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        (this.field_78116_c = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-5.0f, -8.0f, -3.0f, 10, 10, 10);
        this.field_78116_c.func_78793_a(0.0f, -9.0f, -6.0f);
        (this.field_78114_d = new ModelRenderer((ModelBase)this, 32, 0)).func_78789_a(-4.0f, -8.0f, -4.0f, 0, 0, 0);
        (this.field_78115_e = new ModelRenderer((ModelBase)this, 40, 0)).func_78789_a(-8.0f, 0.0f, -5.0f, 16, 26, 10);
        this.field_78115_e.func_78793_a(0.0f, -14.0f, 0.0f);
        (this.nose = new ModelRenderer((ModelBase)this, 0, 21)).func_78789_a(-2.0f, -2.0f, -2.0f, 4, 8, 4);
        this.nose.func_78793_a(0.0f, -2.0f, -4.0f);
        this.field_78116_c.func_78792_a(this.nose);
        (this.field_78112_f = new ModelRenderer((ModelBase)this, 32, 36)).func_78789_a(-5.0f, -2.0f, -3.0f, 6, 22, 6);
        this.field_78112_f.func_78793_a(-9.0f, -10.0f, 0.0f);
        this.field_78113_g = new ModelRenderer((ModelBase)this, 32, 36);
        this.field_78113_g.field_78809_i = true;
        this.field_78113_g.func_78789_a(-1.0f, -2.0f, -3.0f, 6, 22, 6);
        this.field_78113_g.func_78793_a(9.0f, -10.0f, 0.0f);
        (this.field_78123_h = new ModelRenderer((ModelBase)this, 0, 44)).func_78789_a(-3.0f, 0.0f, -4.0f, 6, 12, 8);
        this.field_78123_h.func_78793_a(-5.0f, 12.0f, 0.0f);
        this.field_78124_i = new ModelRenderer((ModelBase)this, 0, 44);
        this.field_78124_i.field_78809_i = true;
        this.field_78124_i.func_78789_a(-3.0f, 0.0f, -4.0f, 6, 12, 8);
        this.field_78124_i.func_78793_a(5.0f, 12.0f, 0.0f);
    }
    
    public void func_78087_a(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final Entity par7Entity) {
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
        if (par7Entity.field_70153_n != null) {
            final ModelRenderer field_78112_f = this.field_78112_f;
            field_78112_f.field_78795_f += (float)3.141592653589793;
            final ModelRenderer field_78113_g = this.field_78113_g;
            field_78113_g.field_78795_f += (float)3.141592653589793;
        }
        if (this.field_78119_l != 0) {
            this.field_78113_g.field_78795_f = this.field_78113_g.field_78795_f * 0.5f - 0.31415927f * this.field_78119_l;
        }
        if (this.field_78120_m != 0) {
            this.field_78112_f.field_78795_f = this.field_78112_f.field_78795_f * 0.5f - 0.31415927f * this.field_78120_m;
        }
        this.field_78112_f.field_78796_g = 0.0f;
        this.field_78113_g.field_78796_g = 0.0f;
        final ModelRenderer field_78112_f2 = this.field_78112_f;
        field_78112_f2.field_78808_h += MathHelper.func_76134_b(par3 * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer field_78113_g2 = this.field_78113_g;
        field_78113_g2.field_78808_h -= MathHelper.func_76134_b(par3 * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer field_78112_f3 = this.field_78112_f;
        field_78112_f3.field_78795_f += MathHelper.func_76126_a(par3 * 0.067f) * 0.05f;
        final ModelRenderer field_78113_g3 = this.field_78113_g;
        field_78113_g3.field_78795_f -= MathHelper.func_76126_a(par3 * 0.067f) * 0.05f;
    }
    
    public void func_78086_a(final EntityLivingBase par1EntityLivingBase, final float par2, final float par3, final float par4) {
    }
}
