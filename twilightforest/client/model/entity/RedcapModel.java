// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.entity.Entity;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.util.HandSide;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.renderer.model.ModelHelper;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import twilightforest.entity.RedcapEntity;

public class RedcapModel<T extends RedcapEntity> extends BipedModel<T>
{
    public RedcapModel(final float size) {
        super(size);
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        this.field_78116_c = new ModelRenderer((Model)this);
        this.field_78116_c.func_78784_a(0, 0).func_228303_a_(-3.5f, -5.0f, -4.0f, 7.0f, 7.0f, 7.0f, 0.0f, false);
        this.field_78116_c.func_78793_a(0.0f, 4.0f, 0.0f);
        (this.field_178720_f = new ModelRenderer((Model)this)).func_78793_a(0.0f, 7.0f, 0.0f);
        this.field_178720_f.func_78784_a(32, 0).func_228303_a_(-2.0f, -6.0f, -3.0f, 4.0f, 5.0f, 7.0f, 0.0f, false);
        (this.field_78115_e = new ModelRenderer((Model)this)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.field_78115_e.func_78784_a(12, 19).func_228303_a_(-4.0f, 6.0f, -2.0f, 8.0f, 9.0f, 4.0f, 0.0f, false);
        (this.field_178723_h = new ModelRenderer((Model)this)).func_78793_a(-5.0f, 8.0f, 0.0f);
        this.field_178723_h.func_78784_a(36, 17).func_228303_a_(-2.0f, -2.0f, -1.5f, 3.0f, 12.0f, 3.0f, 0.0f, false);
        (this.field_178724_i = new ModelRenderer((Model)this)).func_78793_a(5.0f, 8.0f, 0.0f);
        this.field_178724_i.func_78784_a(36, 17).func_228303_a_(-1.0f, -2.0f, -1.5f, 3.0f, 12.0f, 3.0f, 0.0f, false);
        (this.field_178721_j = new ModelRenderer((Model)this)).func_78793_a(-2.0f, 15.0f, 0.0f);
        this.field_178721_j.func_78784_a(0, 20).func_228303_a_(-2.0f, 0.0f, -1.5f, 3.0f, 9.0f, 3.0f, 0.0f, false);
        (this.field_178722_k = new ModelRenderer((Model)this)).func_78793_a(3.0f, 15.0f, 0.0f);
        this.field_178722_k.func_78784_a(0, 20).func_228303_a_(-2.0f, 0.0f, -1.5f, 3.0f, 9.0f, 3.0f, 0.0f, false);
        final ModelRenderer goblinRightEar = new ModelRenderer((Model)this);
        goblinRightEar.func_78793_a(0.0f, 7.0f, 0.0f);
        goblinRightEar.func_78784_a(48, 20).func_228303_a_(3.0f, -10.0f, -1.0f, 2.0f, 3.0f, 1.0f, 0.0f, false);
        final ModelRenderer goblinLeftEar = new ModelRenderer((Model)this);
        goblinLeftEar.func_78793_a(0.0f, 7.0f, 0.0f);
        goblinLeftEar.func_78784_a(48, 20).func_228303_a_(-5.0f, -10.0f, -1.0f, 2.0f, 3.0f, 1.0f, 0.0f, true);
        this.field_78116_c.func_78792_a(goblinLeftEar);
        this.field_78116_c.func_78792_a(goblinRightEar);
    }
    
    public void setRotationAngles(final T entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.field_78116_c.field_78795_f = headPitch * 0.017453292f;
        this.field_78116_c.field_78796_g = netHeadYaw * 0.017453292f;
        this.field_78115_e.field_78796_g = 0.0f;
        this.field_178723_h.field_78798_e = 0.0f;
        this.field_178723_h.field_78800_c = -5.0f;
        this.field_178724_i.field_78798_e = 0.0f;
        this.field_178724_i.field_78800_c = 5.0f;
        final float f = 1.0f;
        this.field_178723_h.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f + 3.1415927f) * 2.0f * limbSwingAmount * 0.5f / f;
        this.field_178724_i.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f) * 2.0f * limbSwingAmount * 0.5f / f;
        this.field_178723_h.field_78808_h = 0.0f;
        this.field_178724_i.field_78808_h = 0.0f;
        this.field_178721_j.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f) * 1.4f * limbSwingAmount / f;
        this.field_178722_k.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount / f;
        this.field_178721_j.field_78796_g = 0.0f;
        this.field_178722_k.field_78796_g = 0.0f;
        this.field_178721_j.field_78808_h = 0.0f;
        this.field_178722_k.field_78808_h = 0.0f;
        this.field_178723_h.field_78796_g = 0.0f;
        this.field_178724_i.field_78796_g = 0.0f;
        if (this.field_217113_d) {
            final ModelRenderer field_178723_h = this.field_178723_h;
            field_178723_h.field_78795_f -= 0.62831855f;
            final ModelRenderer field_178724_i = this.field_178724_i;
            field_178724_i.field_78795_f -= 0.62831855f;
            this.field_178721_j.field_78795_f = -1.4137167f;
            this.field_178721_j.field_78796_g = 0.31415927f;
            this.field_178721_j.field_78808_h = 0.07853982f;
            this.field_178722_k.field_78795_f = -1.4137167f;
            this.field_178722_k.field_78796_g = -0.31415927f;
            this.field_178722_k.field_78808_h = -0.07853982f;
        }
        ModelHelper.func_239101_a_(this.field_178723_h, this.field_178724_i, ageInTicks);
        if (this.field_205061_a > 0.0f) {
            final float f2 = limbSwing % 26.0f;
            final HandSide handside = this.func_217147_a((LivingEntity)entity);
            final float f3 = (handside == HandSide.RIGHT && this.field_217112_c > 0.0f) ? 0.0f : this.field_205061_a;
            final float f4 = (handside == HandSide.LEFT && this.field_217112_c > 0.0f) ? 0.0f : this.field_205061_a;
            if (f2 < 14.0f) {
                this.field_178724_i.field_78795_f = this.func_205060_a(f4, this.field_178724_i.field_78795_f, 0.0f);
                this.field_178723_h.field_78795_f = MathHelper.func_219799_g(f3, this.field_178723_h.field_78795_f, 0.0f);
                this.field_178724_i.field_78796_g = this.func_205060_a(f4, this.field_178724_i.field_78796_g, 3.1415927f);
                this.field_178723_h.field_78796_g = MathHelper.func_219799_g(f3, this.field_178723_h.field_78796_g, 3.1415927f);
                this.field_178724_i.field_78808_h = this.func_205060_a(f4, this.field_178724_i.field_78808_h, 3.1415927f + 1.8707964f * this.getArmAngleSq(f2) / this.getArmAngleSq(14.0f));
                this.field_178723_h.field_78808_h = MathHelper.func_219799_g(f3, this.field_178723_h.field_78808_h, 3.1415927f - 1.8707964f * this.getArmAngleSq(f2) / this.getArmAngleSq(14.0f));
            }
            else if (f2 >= 14.0f && f2 < 22.0f) {
                final float f5 = (f2 - 14.0f) / 8.0f;
                this.field_178724_i.field_78795_f = this.func_205060_a(f4, this.field_178724_i.field_78795_f, 1.5707964f * f5);
                this.field_178723_h.field_78795_f = MathHelper.func_219799_g(f3, this.field_178723_h.field_78795_f, 1.5707964f * f5);
                this.field_178724_i.field_78796_g = this.func_205060_a(f4, this.field_178724_i.field_78796_g, 3.1415927f);
                this.field_178723_h.field_78796_g = MathHelper.func_219799_g(f3, this.field_178723_h.field_78796_g, 3.1415927f);
                this.field_178724_i.field_78808_h = this.func_205060_a(f4, this.field_178724_i.field_78808_h, 5.012389f - 1.8707964f * f5);
                this.field_178723_h.field_78808_h = MathHelper.func_219799_g(f3, this.field_178723_h.field_78808_h, 1.2707963f + 1.8707964f * f5);
            }
            else if (f2 >= 22.0f && f2 < 26.0f) {
                final float f6 = (f2 - 22.0f) / 4.0f;
                this.field_178724_i.field_78795_f = this.func_205060_a(f4, this.field_178724_i.field_78795_f, 1.5707964f - 1.5707964f * f6);
                this.field_178723_h.field_78795_f = MathHelper.func_219799_g(f3, this.field_178723_h.field_78795_f, 1.5707964f - 1.5707964f * f6);
                this.field_178724_i.field_78796_g = this.func_205060_a(f4, this.field_178724_i.field_78796_g, 3.1415927f);
                this.field_178723_h.field_78796_g = MathHelper.func_219799_g(f3, this.field_178723_h.field_78796_g, 3.1415927f);
                this.field_178724_i.field_78808_h = this.func_205060_a(f4, this.field_178724_i.field_78808_h, 3.1415927f);
                this.field_178723_h.field_78808_h = MathHelper.func_219799_g(f3, this.field_178723_h.field_78808_h, 3.1415927f);
            }
            this.field_178722_k.field_78795_f = MathHelper.func_219799_g(this.field_205061_a, this.field_178722_k.field_78795_f, 0.3f * MathHelper.func_76134_b(limbSwing * 0.33333334f + 3.1415927f));
            this.field_178721_j.field_78795_f = MathHelper.func_219799_g(this.field_205061_a, this.field_178721_j.field_78795_f, 0.3f * MathHelper.func_76134_b(limbSwing * 0.33333334f));
        }
        this.func_230486_a_((LivingEntity)entity, ageInTicks);
        this.field_178720_f.func_217177_a(this.field_78116_c);
    }
    
    public void func_225598_a_(final MatrixStack matrixStack, final IVertexBuilder buffer, final int packedLight, final int packedOverlay, final float red, final float green, final float blue, final float alpha) {
        if (this.field_217113_d) {
            matrixStack.func_227861_a_(0.0, 0.25, 0.0);
        }
        this.field_78116_c.func_228308_a_(matrixStack, buffer, packedLight, packedOverlay);
        this.field_178720_f.func_228308_a_(matrixStack, buffer, packedLight, packedOverlay);
        this.field_78115_e.func_228308_a_(matrixStack, buffer, packedLight, packedOverlay);
        this.field_178723_h.func_228308_a_(matrixStack, buffer, packedLight, packedOverlay);
        this.field_178724_i.func_228308_a_(matrixStack, buffer, packedLight, packedOverlay);
        this.field_178721_j.func_228308_a_(matrixStack, buffer, packedLight, packedOverlay);
        this.field_178722_k.func_228308_a_(matrixStack, buffer, packedLight, packedOverlay);
    }
    
    private float getArmAngleSq(final float limbSwing) {
        return -65.0f * limbSwing + limbSwing * limbSwing;
    }
}
