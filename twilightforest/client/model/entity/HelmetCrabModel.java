// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import twilightforest.entity.HelmetCrabEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;

@OnlyIn(Dist.CLIENT)
public class HelmetCrabModel extends SegmentedModel<HelmetCrabEntity>
{
    public ModelRenderer body;
    public ModelRenderer rightLeg1;
    public ModelRenderer rightLeg2;
    public ModelRenderer leftLeg1;
    public ModelRenderer leftLeg2;
    public ModelRenderer leftClaw;
    public ModelRenderer rightClaw;
    public ModelRenderer helmet;
    public ModelRenderer horns;
    
    public HelmetCrabModel() {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        (this.leftLeg1 = new ModelRenderer((Model)this, 0, 0)).func_78793_a(2.0f, 21.0f, 0.0f);
        this.leftLeg1.func_78784_a(48, 19).func_228302_a_(0.0f, -1.0f, -1.0f, 6.0f, 2.0f, 2.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.leftLeg1, 0.21816616f, -0.43633232f, 0.43633232f);
        (this.helmet = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, -1.0f, 0.5f);
        this.helmet.func_78784_a(40, 0).func_228302_a_(-4.0f, -8.0f, -4.0f, 6.0f, 8.0f, 6.0f, 0.0f, 0.0f, 0.0f);
        this.helmet.func_78784_a(16, 0).func_228302_a_(-4.0f, -8.0f, -4.0f, 6.0f, 8.0f, 6.0f, -0.25f, -0.25f, -0.25f);
        this.setRotateAngle(this.helmet, -1.3089969f, -0.2617994f, 0.7463028f);
        (this.leftLeg2 = new ModelRenderer((Model)this, 0, 0)).func_78793_a(2.0f, 21.0f, -1.5f);
        this.leftLeg2.func_78784_a(48, 15).func_228302_a_(0.0f, -1.0f, -1.0f, 6.0f, 2.0f, 2.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.leftLeg2, 0.21816616f, 0.0f, 0.43633232f);
        (this.leftClaw = new ModelRenderer((Model)this, 0, 0)).func_78793_a(3.0f, 0.0f, -3.0f);
        this.leftClaw.func_78784_a(0, 23).func_228302_a_(-1.0f, -3.0f, -5.0f, 2.0f, 4.0f, 5.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.leftClaw, 0.0f, -0.3926991f, 0.0f);
        (this.horns = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.horns.func_78784_a(18, 23).func_228302_a_(-11.5f, -12.0f, -0.67f, 23.0f, 9.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.horns, 0.0f, 0.7853982f, 0.0f);
        (this.rightLeg1 = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-2.0f, 21.0f, 0.0f);
        this.rightLeg1.func_78784_a(32, 15).func_228302_a_(-6.0f, -1.0f, -1.0f, 6.0f, 2.0f, 2.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.rightLeg1, 0.21816616f, 0.43633232f, -0.43633232f);
        (this.rightClaw = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-3.0f, 0.0f, -3.0f);
        this.rightClaw.func_228302_a_(-1.0f, -3.0f, -5.0f, 2.0f, 4.0f, 5.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.rightClaw, 0.0f, 0.3926991f, 0.0f);
        (this.rightLeg2 = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-2.0f, 21.0f, -1.5f);
        this.rightLeg2.func_78784_a(32, 19).func_228302_a_(-6.0f, -1.0f, -1.0f, 6.0f, 2.0f, 2.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.rightLeg2, 0.21816616f, 0.0f, -0.43633232f);
        (this.body = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 21.0f, 0.0f);
        this.body.func_78784_a(0, 9).func_228302_a_(-2.5f, -4.0f, -2.5f, 5.0f, 4.0f, 5.0f, 0.0f, 0.0f, 0.0f);
        this.body.func_78784_a(58, 0).func_228302_a_(-1.5f, -5.0f, -3.5f, 1.0f, 2.0f, 1.0f, 0.0f, 0.0f, 0.0f);
        this.body.func_78784_a(58, 3).func_228302_a_(0.5f, -5.0f, -3.5f, 1.0f, 2.0f, 1.0f, 0.0f, 0.0f, 0.0f);
        this.body.func_78792_a(this.helmet);
        this.body.func_78792_a(this.leftClaw);
        this.body.func_78792_a(this.rightClaw);
        this.helmet.func_78792_a(this.horns);
    }
    
    public void func_225598_a_(final MatrixStack matrixStackIn, final IVertexBuilder bufferIn, final int packedLightIn, final int packedOverlayIn, final float red, final float green, final float blue, final float alpha) {
        if (this.field_217113_d) {
            matrixStackIn.func_227861_a_(0.0, -0.25, 0.0);
        }
        super.func_225598_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }
    
    public Iterable<ModelRenderer> func_225601_a_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.body, (Object)this.rightLeg1, (Object)this.rightLeg2, (Object)this.leftLeg1, (Object)this.leftLeg2);
    }
    
    public void setRotationAngles(final HelmetCrabEntity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.body.field_78796_g = netHeadYaw / 57.295776f;
        this.body.field_78795_f = headPitch / 57.295776f;
        final float f6 = 0.7853982f;
        this.rightLeg1.field_78808_h = -f6 * 0.74f;
        this.leftLeg1.field_78808_h = f6 * 0.74f;
        this.rightLeg2.field_78808_h = -f6 * 0.74f;
        this.leftLeg2.field_78808_h = f6 * 0.74f;
        final float f7 = -0.0f;
        final float f8 = 0.3926991f;
        this.rightLeg1.field_78796_g = f8 + f7;
        this.leftLeg1.field_78796_g = -f8 - f7;
        this.rightLeg2.field_78796_g = -f8 + f7;
        this.leftLeg2.field_78796_g = f8 - f7;
        final float f9 = -(MathHelper.func_76134_b(limbSwing * 0.6662f * 2.0f + 3.1415927f) * 0.4f) * limbSwingAmount;
        final float f10 = -(MathHelper.func_76134_b(limbSwing * 0.6662f * 2.0f + 1.5707964f) * 0.4f) * limbSwingAmount;
        final float f11 = Math.abs(MathHelper.func_76126_a(limbSwing * 0.6662f + 3.1415927f) * 0.4f) * limbSwingAmount;
        final float f12 = Math.abs(MathHelper.func_76126_a(limbSwing * 0.6662f + 1.5707964f) * 0.4f) * limbSwingAmount;
        final ModelRenderer rightLeg1 = this.rightLeg1;
        rightLeg1.field_78796_g += f9;
        final ModelRenderer leftLeg1 = this.leftLeg1;
        leftLeg1.field_78796_g += -f9;
        final ModelRenderer rightLeg2 = this.rightLeg2;
        rightLeg2.field_78796_g += f10;
        final ModelRenderer leftLeg2 = this.leftLeg2;
        leftLeg2.field_78796_g += -f10;
        final ModelRenderer rightLeg3 = this.rightLeg1;
        rightLeg3.field_78808_h += f11;
        final ModelRenderer leftLeg3 = this.leftLeg1;
        leftLeg3.field_78808_h += -f11;
        final ModelRenderer rightLeg4 = this.rightLeg2;
        rightLeg4.field_78808_h += f12;
        final ModelRenderer leftLeg4 = this.leftLeg2;
        leftLeg4.field_78808_h += -f12;
        this.leftClaw.field_78796_g = -0.319531f;
        final ModelRenderer leftClaw = this.leftClaw;
        leftClaw.field_78796_g += -(MathHelper.func_76134_b(limbSwing * 0.6662f + 3.1415927f) * 2.0f * limbSwingAmount * 0.5f) / 2.0f;
        this.rightClaw.field_78796_g = 0.319531f;
        final ModelRenderer rightClaw = this.rightClaw;
        rightClaw.field_78796_g += MathHelper.func_76134_b(limbSwing * 0.6662f + 3.1415927f) * 2.0f * limbSwingAmount * 0.5f / 2.0f;
    }
    
    public void setRotateAngle(final ModelRenderer modelRenderer, final float x, final float y, final float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}
