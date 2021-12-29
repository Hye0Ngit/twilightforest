// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import twilightforest.entity.EntityTFYeti;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBiped;

public class ModelTFYeti extends ModelBiped
{
    public ModelRenderer mouth;
    public ModelRenderer leftEye;
    public ModelRenderer rightEye;
    public ModelRenderer angryLeftEye;
    public ModelRenderer angryRightEye;
    
    public ModelTFYeti() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        (this.field_78116_c = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-4.0f, -8.0f, -4.0f, 0, 0, 0);
        (this.field_178720_f = new ModelRenderer((ModelBase)this, 32, 0)).func_78789_a(-4.0f, -8.0f, -4.0f, 0, 0, 0);
        (this.field_78115_e = new ModelRenderer((ModelBase)this, 32, 0)).func_78789_a(-10.0f, 0.0f, -6.0f, 20, 26, 12);
        this.field_78115_e.func_78793_a(0.0f, -14.0f, 0.0f);
        (this.mouth = new ModelRenderer((ModelBase)this, 96, 6)).func_78789_a(-7.0f, -5.0f, -0.5f, 14, 10, 1);
        this.mouth.func_78793_a(0.0f, 12.0f, -6.0f);
        this.field_78115_e.func_78792_a(this.mouth);
        (this.rightEye = new ModelRenderer((ModelBase)this, 96, 0)).func_78789_a(-2.5f, -2.5f, -0.5f, 5, 5, 1);
        this.rightEye.func_78793_a(-5.5f, 4.5f, -6.0f);
        this.field_78115_e.func_78792_a(this.rightEye);
        (this.leftEye = new ModelRenderer((ModelBase)this, 96, 0)).func_78789_a(-2.5f, -2.5f, -0.5f, 5, 5, 1);
        this.leftEye.func_78793_a(5.5f, 4.5f, -6.0f);
        this.field_78115_e.func_78792_a(this.leftEye);
        (this.angryRightEye = new ModelRenderer((ModelBase)this, 109, 0)).func_78789_a(-2.5f, -2.5f, -0.5f, 5, 5, 1);
        this.angryRightEye.func_78793_a(5.5f, 4.5f, -6.0f);
        this.field_78115_e.func_78792_a(this.angryRightEye);
        (this.angryLeftEye = new ModelRenderer((ModelBase)this, 109, 0)).func_78789_a(-2.5f, -2.5f, -0.5f, 5, 5, 1);
        this.angryLeftEye.func_78793_a(-5.5f, 4.5f, -6.0f);
        this.field_78115_e.func_78792_a(this.angryLeftEye);
        (this.field_178723_h = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-5.0f, -2.0f, -3.0f, 6, 16, 6);
        this.field_178723_h.func_78793_a(-11.0f, -4.0f, 0.0f);
        this.field_178724_i = new ModelRenderer((ModelBase)this, 0, 0);
        this.field_178724_i.field_78809_i = true;
        this.field_178724_i.func_78789_a(-1.0f, -2.0f, -3.0f, 6, 16, 6);
        this.field_178724_i.func_78793_a(11.0f, -4.0f, 0.0f);
        (this.field_178721_j = new ModelRenderer((ModelBase)this, 0, 22)).func_78789_a(-4.0f, 0.0f, -4.0f, 8, 12, 8);
        this.field_178721_j.func_78793_a(-6.0f, 12.0f, 0.0f);
        this.field_178722_k = new ModelRenderer((ModelBase)this, 0, 22);
        this.field_178722_k.field_78809_i = true;
        this.field_178722_k.func_78789_a(-4.0f, 0.0f, -4.0f, 8, 12, 8);
        this.field_178722_k.func_78793_a(6.0f, 12.0f, 0.0f);
    }
    
    public void func_78087_a(final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scaleFactor, final Entity entity) {
        final EntityTFYeti yeti = (EntityTFYeti)entity;
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
        if (this.field_187075_l != ModelBiped.ArmPose.EMPTY) {
            this.field_178724_i.field_78795_f = this.field_178724_i.field_78795_f * 0.5f - 0.31415927f;
        }
        if (this.field_187076_m != ModelBiped.ArmPose.EMPTY) {
            this.field_178723_h.field_78795_f = this.field_178723_h.field_78795_f * 0.5f - 0.31415927f;
        }
        this.field_178723_h.field_78796_g = 0.0f;
        this.field_178724_i.field_78796_g = 0.0f;
        final ModelRenderer field_178723_h2 = this.field_178723_h;
        field_178723_h2.field_78808_h += MathHelper.func_76134_b(ageInTicks * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer field_178724_i2 = this.field_178724_i;
        field_178724_i2.field_78808_h -= MathHelper.func_76134_b(ageInTicks * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer field_178723_h3 = this.field_178723_h;
        field_178723_h3.field_78795_f += MathHelper.func_76126_a(ageInTicks * 0.067f) * 0.05f;
        final ModelRenderer field_178724_i3 = this.field_178724_i;
        field_178724_i3.field_78795_f -= MathHelper.func_76126_a(ageInTicks * 0.067f) * 0.05f;
        if (yeti.isAngry()) {
            final float f6 = MathHelper.func_76126_a(this.field_78095_p * 3.1415927f);
            final float f7 = MathHelper.func_76126_a((1.0f - (1.0f - this.field_78095_p) * (1.0f - this.field_78095_p)) * 3.1415927f);
            this.field_178723_h.field_78808_h = 0.0f;
            this.field_178724_i.field_78808_h = 0.0f;
            this.field_178723_h.field_78796_g = -(0.1f - f6 * 0.6f);
            this.field_178724_i.field_78796_g = 0.1f - f6 * 0.6f;
            this.field_178723_h.field_78795_f = -1.5707964f;
            this.field_178724_i.field_78795_f = -1.5707964f;
            final ModelRenderer field_178723_h4 = this.field_178723_h;
            field_178723_h4.field_78795_f -= f6 * 1.2f - f7 * 0.4f;
            final ModelRenderer field_178724_i4 = this.field_178724_i;
            field_178724_i4.field_78795_f -= f6 * 1.2f - f7 * 0.4f;
            final ModelRenderer field_178723_h5 = this.field_178723_h;
            field_178723_h5.field_78808_h += MathHelper.func_76134_b(ageInTicks * 0.09f) * 0.05f + 0.05f;
            final ModelRenderer field_178724_i5 = this.field_178724_i;
            field_178724_i5.field_78808_h -= MathHelper.func_76134_b(ageInTicks * 0.09f) * 0.05f + 0.05f;
            final ModelRenderer field_178723_h6 = this.field_178723_h;
            field_178723_h6.field_78795_f += MathHelper.func_76126_a(ageInTicks * 0.067f) * 0.05f;
            final ModelRenderer field_178724_i6 = this.field_178724_i;
            field_178724_i6.field_78795_f -= MathHelper.func_76126_a(ageInTicks * 0.067f) * 0.05f;
        }
    }
    
    public void func_78086_a(final EntityLivingBase entity, final float limbSwing, final float limbSwingAmount, final float partialTicks) {
        final EntityTFYeti yeti = (EntityTFYeti)entity;
        if (yeti.isAngry()) {
            this.rightEye.field_78807_k = true;
            this.leftEye.field_78807_k = true;
            this.angryRightEye.field_78807_k = false;
            this.angryLeftEye.field_78807_k = false;
        }
        else {
            this.rightEye.field_78807_k = false;
            this.leftEye.field_78807_k = false;
            this.angryRightEye.field_78807_k = true;
            this.angryLeftEye.field_78807_k = true;
        }
    }
}
