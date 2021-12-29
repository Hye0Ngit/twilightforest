// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import net.minecraft.util.MathHelper;
import twilightforest.entity.EntityTFGoblinKnightLower;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBiped;

public class ModelTFGoblinKnightLower extends ModelBiped
{
    public ModelRenderer tunic;
    
    public ModelTFGoblinKnightLower() {
        this.field_78119_l = 0;
        this.field_78120_m = 0;
        this.field_78117_n = false;
        this.field_78118_o = false;
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        (this.field_78122_k = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-5.0f, 0.0f, -1.0f, 10, 16, 1);
        (this.field_78121_j = new ModelRenderer((ModelBase)this, 24, 0)).func_78789_a(-3.0f, -6.0f, -1.0f, 6, 6, 1);
        (this.field_78116_c = new ModelRenderer((ModelBase)this, 0, 32)).func_78789_a(-2.5f, -5.0f, -3.5f, 5, 5, 5);
        this.field_78116_c.func_78793_a(0.0f, 10.0f, 1.0f);
        (this.field_78114_d = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 0, 0, 0);
        (this.field_78115_e = new ModelRenderer((ModelBase)this, 16, 48)).func_78789_a(-3.5f, 0.0f, -2.0f, 7, 8, 4);
        this.field_78115_e.func_78793_a(0.0f, 8.0f, 0.0f);
        (this.field_78112_f = new ModelRenderer((ModelBase)this, 40, 48)).func_78789_a(-2.0f, -2.0f, -1.5f, 2, 8, 3);
        this.field_78112_f.func_78793_a(-3.5f, 10.0f, 0.0f);
        this.field_78113_g = new ModelRenderer((ModelBase)this, 40, 48);
        this.field_78113_g.field_78809_i = true;
        this.field_78113_g.func_78789_a(0.0f, -2.0f, -1.5f, 2, 8, 3);
        this.field_78113_g.func_78793_a(3.5f, 10.0f, 0.0f);
        (this.field_78123_h = new ModelRenderer((ModelBase)this, 0, 48)).func_78789_a(-3.0f, 0.0f, -2.0f, 4, 8, 4);
        this.field_78123_h.func_78793_a(-2.5f, 16.0f, 0.0f);
        this.field_78124_i = new ModelRenderer((ModelBase)this, 0, 48);
        this.field_78124_i.field_78809_i = true;
        this.field_78124_i.func_78789_a(-1.0f, 0.0f, -2.0f, 4, 8, 4);
        this.field_78124_i.func_78793_a(2.5f, 16.0f, 0.0f);
        (this.tunic = new ModelRenderer((ModelBase)this, 64, 19)).func_78789_a(-6.0f, 0.0f, -3.0f, 12, 9, 6);
        this.tunic.func_78793_a(0.0f, 7.5f, 0.0f);
    }
    
    public void func_78088_a(final Entity par1Entity, final float par2, final float par3, final float par4, final float par5, final float par6, final float par7) {
        super.func_78088_a(par1Entity, par2, par3, par4, par5, par6, par7);
        if (((EntityTFGoblinKnightLower)par1Entity).hasArmor()) {
            this.renderTunic(par7);
        }
    }
    
    public void renderTunic(final float par1) {
        this.tunic.func_78785_a(par1);
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
            this.field_78116_c.field_78796_g = 0.0f;
            this.field_78116_c.field_78795_f = 0.0f;
            this.field_78114_d.field_78796_g = this.field_78116_c.field_78796_g;
            this.field_78114_d.field_78795_f = this.field_78116_c.field_78795_f;
        }
        if (this.field_78119_l != 0) {
            this.field_78113_g.field_78795_f = this.field_78113_g.field_78795_f * 0.5f - 0.31415927f * this.field_78119_l;
        }
        if (this.field_78120_m != 0) {
            this.field_78112_f.field_78795_f = this.field_78112_f.field_78795_f * 0.5f - 0.31415927f * this.field_78120_m;
        }
        this.field_78112_f.field_78796_g = 0.0f;
        this.field_78113_g.field_78796_g = 0.0f;
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
