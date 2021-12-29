// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import twilightforest.entity.TrollEntity;
import net.minecraft.client.renderer.entity.model.BipedModel;

public class TrollModel extends BipedModel<TrollEntity>
{
    public ModelRenderer nose;
    
    public TrollModel() {
        super(0.0f, 0.0f, 128, 64);
        (this.field_78116_c = new ModelRenderer((Model)this, 0, 0)).func_228300_a_(-5.0f, -8.0f, -3.0f, 10.0f, 10.0f, 10.0f);
        this.field_78116_c.func_78793_a(0.0f, -9.0f, -6.0f);
        (this.field_178720_f = new ModelRenderer((Model)this, 32, 0)).func_228300_a_(-4.0f, -8.0f, -4.0f, 0.0f, 0.0f, 0.0f);
        (this.field_78115_e = new ModelRenderer((Model)this, 40, 0)).func_228300_a_(-8.0f, 0.0f, -5.0f, 16.0f, 26.0f, 10.0f);
        this.field_78115_e.func_78793_a(0.0f, -14.0f, 0.0f);
        (this.nose = new ModelRenderer((Model)this, 0, 21)).func_228300_a_(-2.0f, -2.0f, -2.0f, 4.0f, 8.0f, 4.0f);
        this.nose.func_78793_a(0.0f, -2.0f, -4.0f);
        this.field_78116_c.func_78792_a(this.nose);
        (this.field_178723_h = new ModelRenderer((Model)this, 32, 36)).func_228300_a_(-5.0f, -2.0f, -3.0f, 6.0f, 22.0f, 6.0f);
        this.field_178723_h.func_78793_a(-9.0f, -9.0f, 0.0f);
        this.field_178724_i = new ModelRenderer((Model)this, 32, 36);
        this.field_178724_i.field_78809_i = true;
        this.field_178724_i.func_228300_a_(-1.0f, -2.0f, -3.0f, 6.0f, 22.0f, 6.0f);
        this.field_178724_i.func_78793_a(9.0f, -9.0f, 0.0f);
        (this.field_178721_j = new ModelRenderer((Model)this, 0, 44)).func_228300_a_(-3.0f, 0.0f, -4.0f, 6.0f, 12.0f, 8.0f);
        this.field_178721_j.func_78793_a(-5.0f, 12.0f, 0.0f);
        this.field_178722_k = new ModelRenderer((Model)this, 0, 44);
        this.field_178722_k.field_78809_i = true;
        this.field_178722_k.func_228300_a_(-3.0f, 0.0f, -4.0f, 6.0f, 12.0f, 8.0f);
        this.field_178722_k.func_78793_a(5.0f, 12.0f, 0.0f);
    }
    
    public void setRotationAngles(final TrollEntity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.field_78116_c.field_78796_g = netHeadYaw / 57.295776f;
        this.field_78116_c.field_78795_f = headPitch / 57.295776f;
        this.field_178720_f.field_78796_g = this.field_78116_c.field_78796_g;
        this.field_178720_f.field_78795_f = this.field_78116_c.field_78795_f;
        this.field_178723_h.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f + 3.1415927f) * 2.0f * limbSwingAmount * 0.5f;
        this.field_178724_i.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f) * 2.0f * limbSwingAmount * 0.5f;
        this.field_178723_h.field_78808_h = 0.0f;
        this.field_178724_i.field_78808_h = 0.0f;
        this.field_178721_j.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.field_178722_k.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.field_178721_j.field_78796_g = 0.0f;
        this.field_178722_k.field_78796_g = 0.0f;
        if (entity.func_184207_aI()) {
            final ModelRenderer field_178723_h = this.field_178723_h;
            field_178723_h.field_78795_f += (float)3.141592653589793;
            final ModelRenderer field_178724_i = this.field_178724_i;
            field_178724_i.field_78795_f += (float)3.141592653589793;
        }
        if (this.field_187075_l != BipedModel.ArmPose.EMPTY) {
            final ModelRenderer field_178723_h2 = this.field_178723_h;
            field_178723_h2.field_78795_f += (float)3.141592653589793;
        }
        if (this.field_187076_m != BipedModel.ArmPose.EMPTY) {
            final ModelRenderer field_178724_i2 = this.field_178724_i;
            field_178724_i2.field_78795_f += (float)3.141592653589793;
        }
        if (this.field_217112_c > 0.0f) {
            final float swing = 1.0f - this.field_217112_c;
            final ModelRenderer field_178723_h3 = this.field_178723_h;
            field_178723_h3.field_78795_f -= (float)(3.141592653589793 * swing);
            final ModelRenderer field_178724_i3 = this.field_178724_i;
            field_178724_i3.field_78795_f -= (float)(3.141592653589793 * swing);
        }
        this.field_178723_h.field_78796_g = 0.0f;
        this.field_178724_i.field_78796_g = 0.0f;
        final ModelRenderer field_178723_h4 = this.field_178723_h;
        field_178723_h4.field_78808_h += MathHelper.func_76134_b(ageInTicks * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer field_178724_i4 = this.field_178724_i;
        field_178724_i4.field_78808_h -= MathHelper.func_76134_b(ageInTicks * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer field_178723_h5 = this.field_178723_h;
        field_178723_h5.field_78795_f += MathHelper.func_76126_a(ageInTicks * 0.067f) * 0.05f;
        final ModelRenderer field_178724_i5 = this.field_178724_i;
        field_178724_i5.field_78795_f -= MathHelper.func_76126_a(ageInTicks * 0.067f) * 0.05f;
    }
    
    public void setLivingAnimations(final TrollEntity entity, final float limbSwing, final float limbSwingAmount, final float partialTicks) {
        if (entity.func_70638_az() != null) {
            final ModelRenderer field_178723_h = this.field_178723_h;
            field_178723_h.field_78795_f += (float)3.141592653589793;
            final ModelRenderer field_178724_i = this.field_178724_i;
            field_178724_i.field_78795_f += (float)3.141592653589793;
        }
    }
}
