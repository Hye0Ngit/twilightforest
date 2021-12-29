// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.entity.Entity;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.LivingEntity;
import twilightforest.entity.LoyalZombieEntity;
import net.minecraft.client.renderer.entity.model.BipedModel;

public class LoyalZombieModel extends BipedModel<LoyalZombieEntity>
{
    public LoyalZombieModel(final boolean armor) {
        super(0.0f, 0.0f, 64, armor ? 32 : 64);
    }
    
    public void setRotationAngles(final LoyalZombieEntity e, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        super.func_225597_a_((LivingEntity)e, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        final boolean flag = e.func_213398_dR();
        final float f = MathHelper.func_76126_a(this.field_217112_c * 3.1415927f);
        final float f2 = MathHelper.func_76126_a((1.0f - (1.0f - this.field_217112_c) * (1.0f - this.field_217112_c)) * 3.1415927f);
        this.field_178723_h.field_78808_h = 0.0f;
        this.field_178724_i.field_78808_h = 0.0f;
        this.field_178723_h.field_78796_g = -(0.1f - f * 0.6f);
        this.field_178724_i.field_78796_g = 0.1f - f * 0.6f;
        final float f3 = -3.1415927f / (flag ? 1.5f : 2.25f);
        this.field_178723_h.field_78795_f = f3;
        this.field_178724_i.field_78795_f = f3;
        final ModelRenderer field_178723_h = this.field_178723_h;
        field_178723_h.field_78795_f += f * 1.2f - f2 * 0.4f;
        final ModelRenderer field_178724_i = this.field_178724_i;
        field_178724_i.field_78795_f += f * 1.2f - f2 * 0.4f;
        final ModelRenderer field_178723_h2 = this.field_178723_h;
        field_178723_h2.field_78808_h += MathHelper.func_76134_b(ageInTicks * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer field_178724_i2 = this.field_178724_i;
        field_178724_i2.field_78808_h -= MathHelper.func_76134_b(ageInTicks * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer field_178723_h3 = this.field_178723_h;
        field_178723_h3.field_78795_f += MathHelper.func_76126_a(ageInTicks * 0.067f) * 0.05f;
        final ModelRenderer field_178724_i3 = this.field_178724_i;
        field_178724_i3.field_78795_f -= MathHelper.func_76126_a(ageInTicks * 0.067f) * 0.05f;
    }
    
    public void func_225598_a_(final MatrixStack stack, final IVertexBuilder builder, final int light, final int overlay, final float red, final float green, final float blue, final float scale) {
        super.func_225598_a_(stack, builder, light, overlay, red * 0.25f, green, blue * 0.25f, scale);
    }
}
