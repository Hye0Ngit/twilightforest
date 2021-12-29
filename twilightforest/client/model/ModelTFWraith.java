// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBiped;

public class ModelTFWraith extends ModelBiped
{
    public ModelRenderer dress;
    
    public ModelTFWraith() {
        final float f = 0.0f;
        (this.dress = new ModelRenderer((ModelBase)this, 40, 16)).func_78790_a(-4.0f, 12.0f, -2.0f, 8, 12, 4, f);
        this.dress.func_78793_a(0.0f, 0.0f, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        this.field_78116_c.func_78785_a(f5);
        this.field_78115_e.func_78785_a(f5);
        this.field_78112_f.func_78785_a(f5);
        this.field_78113_g.func_78785_a(f5);
        this.dress.func_78785_a(f5);
        this.field_78114_d.func_78785_a(f5);
    }
    
    public void func_78087_a(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final Entity par7Entity) {
        super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
        final float var8 = MathHelper.func_76126_a(this.field_78095_p * 3.1415927f);
        final float var9 = MathHelper.func_76126_a((1.0f - (1.0f - this.field_78095_p) * (1.0f - this.field_78095_p)) * 3.1415927f);
        this.field_78112_f.field_78808_h = 0.0f;
        this.field_78113_g.field_78808_h = 0.0f;
        this.field_78112_f.field_78796_g = -(0.1f - var8 * 0.6f);
        this.field_78113_g.field_78796_g = 0.1f - var8 * 0.6f;
        this.field_78112_f.field_78795_f = -1.5707964f;
        this.field_78113_g.field_78795_f = -1.5707964f;
        final ModelRenderer field_78112_f = this.field_78112_f;
        field_78112_f.field_78795_f -= var8 * 1.2f - var9 * 0.4f;
        final ModelRenderer field_78113_g = this.field_78113_g;
        field_78113_g.field_78795_f -= var8 * 1.2f - var9 * 0.4f;
        final ModelRenderer field_78112_f2 = this.field_78112_f;
        field_78112_f2.field_78808_h += MathHelper.func_76134_b(par3 * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer field_78113_g2 = this.field_78113_g;
        field_78113_g2.field_78808_h -= MathHelper.func_76134_b(par3 * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer field_78112_f3 = this.field_78112_f;
        field_78112_f3.field_78795_f += MathHelper.func_76126_a(par3 * 0.067f) * 0.05f;
        final ModelRenderer field_78113_g3 = this.field_78113_g;
        field_78113_g3.field_78795_f -= MathHelper.func_76126_a(par3 * 0.067f) * 0.05f;
    }
}
