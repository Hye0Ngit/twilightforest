// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.util.math.MathHelper;
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
    
    public void func_78088_a(final Entity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scale) {
        this.func_78087_a(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
        this.field_78116_c.func_78785_a(scale);
        this.field_78115_e.func_78785_a(scale);
        this.field_178723_h.func_78785_a(scale);
        this.field_178724_i.func_78785_a(scale);
        this.dress.func_78785_a(scale);
        this.field_178720_f.func_78785_a(scale);
    }
    
    public void func_78087_a(final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scaleFactor, final Entity entity) {
        super.func_78087_a(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
        final float var8 = MathHelper.func_76126_a(this.field_78095_p * 3.1415927f);
        final float var9 = MathHelper.func_76126_a((1.0f - (1.0f - this.field_78095_p) * (1.0f - this.field_78095_p)) * 3.1415927f);
        this.field_178723_h.field_78808_h = 0.0f;
        this.field_178724_i.field_78808_h = 0.0f;
        this.field_178723_h.field_78796_g = -(0.1f - var8 * 0.6f);
        this.field_178724_i.field_78796_g = 0.1f - var8 * 0.6f;
        this.field_178723_h.field_78795_f = -1.5707964f;
        this.field_178724_i.field_78795_f = -1.5707964f;
        final ModelRenderer field_178723_h = this.field_178723_h;
        field_178723_h.field_78795_f -= var8 * 1.2f - var9 * 0.4f;
        final ModelRenderer field_178724_i = this.field_178724_i;
        field_178724_i.field_78795_f -= var8 * 1.2f - var9 * 0.4f;
        final ModelRenderer field_178723_h2 = this.field_178723_h;
        field_178723_h2.field_78808_h += MathHelper.func_76134_b(ageInTicks * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer field_178724_i2 = this.field_178724_i;
        field_178724_i2.field_78808_h -= MathHelper.func_76134_b(ageInTicks * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer field_178723_h3 = this.field_178723_h;
        field_178723_h3.field_78795_f += MathHelper.func_76126_a(ageInTicks * 0.067f) * 0.05f;
        final ModelRenderer field_178724_i3 = this.field_178724_i;
        field_178724_i3.field_78795_f -= MathHelper.func_76126_a(ageInTicks * 0.067f) * 0.05f;
    }
}
