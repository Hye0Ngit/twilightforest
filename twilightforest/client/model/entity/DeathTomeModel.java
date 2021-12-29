// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import twilightforest.entity.DeathTomeEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;

public class DeathTomeModel extends EntityModel<DeathTomeEntity>
{
    private final ModelRenderer everything;
    private final ModelRenderer book;
    private final ModelRenderer loosePage1;
    private final ModelRenderer loosePage2;
    private final ModelRenderer loosePage3;
    private final ModelRenderer loosePage4;
    private final ModelRenderer coverRight;
    private final ModelRenderer coverLeft;
    private final ModelRenderer pagesRight;
    private final ModelRenderer pagesLeft;
    private final ModelRenderer flippingPageRight;
    private final ModelRenderer flippingPageLeft;
    
    public DeathTomeModel() {
        this.coverRight = new ModelRenderer(64, 32, 0, 0).func_228300_a_(-6.0f, -5.0f, -0.005f, 6.0f, 10.0f, 0.005f);
        this.coverLeft = new ModelRenderer(64, 32, 16, 0).func_228300_a_(0.0f, -5.0f, -0.005f, 6.0f, 10.0f, 0.005f);
        this.everything = new ModelRenderer((Model)this).func_78784_a(0, 0).func_228300_a_(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        this.book = new ModelRenderer((Model)this).func_78784_a(0, 0).func_228300_a_(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        this.pagesRight = new ModelRenderer(64, 32, 0, 10).func_228300_a_(0.0f, -4.0f, -0.99f, 5.0f, 8.0f, 1.0f);
        this.pagesLeft = new ModelRenderer(64, 32, 12, 10).func_228300_a_(0.0f, -4.0f, -0.01f, 5.0f, 8.0f, 1.0f);
        this.flippingPageRight = new ModelRenderer(64, 32, 24, 10).func_228300_a_(0.0f, -4.0f, 0.0f, 5.0f, 8.0f, 0.005f);
        this.flippingPageLeft = new ModelRenderer(64, 32, 24, 10).func_228300_a_(0.0f, -4.0f, 0.0f, 5.0f, 8.0f, 0.005f);
        this.coverRight.func_78793_a(0.0f, 0.0f, -1.0f);
        this.coverLeft.func_78793_a(0.0f, 0.0f, 1.0f);
        final ModelRenderer bookSpine = new ModelRenderer(64, 32, 12, 0).func_228300_a_(-1.0f, -5.0f, 0.0f, 2.0f, 10.0f, 0.005f);
        bookSpine.field_78796_g = 1.5707964f;
        this.book.func_78792_a(this.coverRight);
        this.book.func_78792_a(this.coverLeft);
        this.book.func_78792_a(bookSpine);
        this.book.func_78792_a(this.pagesRight);
        this.book.func_78792_a(this.pagesLeft);
        this.book.func_78792_a(this.flippingPageRight);
        this.book.func_78792_a(this.flippingPageLeft);
        this.loosePage1 = new ModelRenderer((Model)this).func_78784_a(24, 10).func_228300_a_(0.0f, -4.0f, -8.0f, 5.0f, 8.0f, 0.005f);
        this.loosePage2 = new ModelRenderer((Model)this).func_78784_a(24, 10).func_228300_a_(0.0f, -4.0f, 9.0f, 5.0f, 8.0f, 0.005f);
        this.loosePage3 = new ModelRenderer((Model)this).func_78784_a(24, 10).func_228300_a_(0.0f, -4.0f, 11.0f, 5.0f, 8.0f, 0.005f);
        this.loosePage4 = new ModelRenderer((Model)this).func_78784_a(24, 10).func_228300_a_(0.0f, -4.0f, 7.0f, 5.0f, 8.0f, 0.005f);
        this.everything.func_78792_a(this.loosePage1);
        this.everything.func_78792_a(this.loosePage2);
        this.everything.func_78792_a(this.loosePage3);
        this.everything.func_78792_a(this.loosePage4);
    }
    
    public void func_225598_a_(final MatrixStack stack, final IVertexBuilder builder, final int light, final int overlay, final float red, final float green, final float blue, final float scale) {
        this.everything.func_228308_a_(stack, builder, light, overlay);
        this.book.func_228308_a_(stack, builder, light, overlay);
    }
    
    public void setRotationAngles(final DeathTomeEntity entity, final float limbAngle, final float limbDistance, final float customAngle, final float headYaw, final float headPitch) {
        this.book.field_78808_h = -0.87266463f;
        this.everything.field_78796_g = customAngle / 57.295776f + 1.5707964f;
    }
    
    public void setLivingAnimations(final DeathTomeEntity entity, final float limbSwing, final float limbSwingAmount, final float partialTicks) {
        final float bounce = entity.field_70173_aa + partialTicks;
        final float open = 0.9f;
        final float flipRight = 0.4f;
        final float flipLeft = 0.6f;
        this.book.func_78793_a(0.0f, 4.0f + MathHelper.func_76126_a(bounce * 0.3f) * 2.0f, 0.0f);
        final float openAngle = (MathHelper.func_76126_a(bounce * 0.4f) * 0.3f + 1.25f) * open;
        this.coverRight.field_78796_g = 3.1415927f + openAngle;
        this.coverLeft.field_78796_g = -openAngle;
        this.pagesRight.field_78796_g = openAngle;
        this.pagesLeft.field_78796_g = -openAngle;
        this.flippingPageRight.field_78796_g = openAngle - openAngle * 2.0f * flipRight;
        this.flippingPageLeft.field_78796_g = openAngle - openAngle * 2.0f * flipLeft;
        this.pagesRight.field_78800_c = MathHelper.func_76126_a(openAngle);
        this.pagesLeft.field_78800_c = MathHelper.func_76126_a(openAngle);
        this.flippingPageRight.field_78800_c = MathHelper.func_76126_a(openAngle);
        this.flippingPageLeft.field_78800_c = MathHelper.func_76126_a(openAngle);
        this.loosePage1.field_78796_g = bounce / 4.0f;
        this.loosePage1.field_78795_f = MathHelper.func_76126_a(bounce / 5.0f) / 3.0f;
        this.loosePage1.field_78808_h = MathHelper.func_76134_b(bounce / 5.0f) / 5.0f;
        this.loosePage2.field_78796_g = bounce / 3.0f;
        this.loosePage2.field_78795_f = MathHelper.func_76126_a(bounce / 5.0f) / 3.0f;
        this.loosePage2.field_78808_h = MathHelper.func_76134_b(bounce / 5.0f) / 4.0f + 2.0f;
        this.loosePage3.field_78796_g = bounce / 4.0f;
        this.loosePage3.field_78795_f = -MathHelper.func_76126_a(bounce / 5.0f) / 3.0f;
        this.loosePage3.field_78808_h = MathHelper.func_76134_b(bounce / 5.0f) / 5.0f - 1.0f;
        this.loosePage4.field_78796_g = bounce / 4.0f;
        this.loosePage4.field_78795_f = -MathHelper.func_76126_a(bounce / 2.0f) / 4.0f;
        this.loosePage4.field_78808_h = MathHelper.func_76134_b(bounce / 7.0f) / 5.0f;
    }
}
