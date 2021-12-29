// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import twilightforest.entity.PinchBeetleEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;

@OnlyIn(Dist.CLIENT)
public class PinchBeetleModel extends SegmentedModel<PinchBeetleEntity>
{
    public ModelRenderer Head;
    public ModelRenderer body;
    public ModelRenderer rightLeg1;
    public ModelRenderer rightLeg2;
    public ModelRenderer rightLeg3;
    public ModelRenderer leftLeg1;
    public ModelRenderer leftLeg2;
    public ModelRenderer leftLeg3;
    public ModelRenderer rightPincer;
    public ModelRenderer leftPincer;
    public ModelRenderer rightAntenna;
    public ModelRenderer leftAntenna;
    
    public PinchBeetleModel() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        (this.leftLeg2 = new ModelRenderer((Model)this, 0, 0)).func_78793_a(2.0f, 21.0f, 4.0f);
        this.leftLeg2.func_78784_a(40, 46).func_228302_a_(0.0f, 0.0f, -1.0f, 10.0f, 2.0f, 2.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.leftLeg2, 0.0f, -0.20943952f, 0.17453292f);
        (this.leftAntenna = new ModelRenderer((Model)this, 0, 0)).func_78793_a(1.0f, -3.0f, -6.0f);
        this.leftAntenna.func_78784_a(52, 0).func_228302_a_(0.0f, 0.0f, -10.0f, 1.0f, 0.0f, 10.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.leftAntenna, -0.43633232f, -0.43633232f, 0.0f);
        (this.rightLeg3 = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-2.0f, 21.0f, 2.0f);
        this.rightLeg3.func_78784_a(40, 36).func_228302_a_(-10.0f, 0.0f, -1.0f, 10.0f, 2.0f, 2.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.rightLeg3, 0.0f, -0.20943952f, -0.17453292f);
        (this.rightLeg2 = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-2.0f, 21.0f, 4.0f);
        this.rightLeg2.func_78784_a(40, 32).func_228302_a_(-10.0f, 0.0f, -1.0f, 10.0f, 2.0f, 2.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.rightLeg2, 0.0f, 0.20943952f, -0.17453292f);
        (this.rightLeg1 = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-2.0f, 21.0f, 6.0f);
        this.rightLeg1.func_78784_a(40, 28).func_228302_a_(-10.0f, 0.0f, -1.0f, 10.0f, 2.0f, 2.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.rightLeg1, 0.0f, 0.61086524f, -0.17453292f);
        (this.leftPincer = new ModelRenderer((Model)this, 0, 0)).func_78793_a(4.0f, 2.0f, -4.0f);
        this.leftPincer.func_78784_a(16, 14).func_228302_a_(0.0f, 0.0f, -12.0f, 12.0f, 2.0f, 12.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.leftPincer, 0.08726646f, 0.61086524f, 0.0f);
        (this.leftLeg1 = new ModelRenderer((Model)this, 0, 0)).func_78793_a(2.0f, 21.0f, 6.0f);
        this.leftLeg1.func_78784_a(40, 42).func_228302_a_(0.0f, 0.0f, -1.0f, 10.0f, 2.0f, 2.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.leftLeg1, 0.0f, -0.61086524f, 0.17453292f);
        (this.Head = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 19.0f, 0.0f);
        this.Head.func_228302_a_(-4.0f, -3.0f, -6.0f, 8.0f, 6.0f, 6.0f, 0.0f, 0.0f, 0.0f);
        (this.body = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 19.0f, 8.0f);
        this.body.func_78784_a(0, 28).func_228302_a_(-5.0f, -8.0f, -3.0f, 10.0f, 10.0f, 7.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.body, 1.5707964f, 0.0f, 0.0f);
        (this.leftLeg3 = new ModelRenderer((Model)this, 0, 0)).func_78793_a(2.0f, 21.0f, 2.0f);
        this.leftLeg3.func_78784_a(40, 50).func_228302_a_(0.0f, 0.0f, -1.0f, 10.0f, 2.0f, 2.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.leftLeg3, 0.0f, 0.20943952f, 0.17453292f);
        (this.rightPincer = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-4.0f, 2.0f, -4.0f);
        this.rightPincer.func_78784_a(16, 0).func_228302_a_(-12.0f, 0.0f, -12.0f, 12.0f, 2.0f, 12.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.rightPincer, 0.08726646f, -0.61086524f, 0.0f);
        (this.rightAntenna = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-1.0f, -3.0f, -6.0f);
        this.rightAntenna.func_78784_a(48, 0).func_228302_a_(-1.0f, 0.0f, -10.0f, 1.0f, 0.0f, 10.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.rightAntenna, -0.43633232f, 0.43633232f, 0.0f);
        this.Head.func_78792_a(this.leftAntenna);
        this.Head.func_78792_a(this.leftPincer);
        this.Head.func_78792_a(this.rightPincer);
        this.Head.func_78792_a(this.rightAntenna);
    }
    
    public Iterable<ModelRenderer> func_225601_a_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.Head, (Object)this.body, (Object)this.leftLeg1, (Object)this.leftLeg2, (Object)this.leftLeg3, (Object)this.rightLeg1, (Object)this.rightLeg2, (Object)this.rightLeg3);
    }
    
    public void func_225598_a_(final MatrixStack matrixStackIn, final IVertexBuilder bufferIn, final int packedLightIn, final int packedOverlayIn, final float red, final float green, final float blue, final float alpha) {
        if (this.field_217113_d) {
            matrixStackIn.func_227861_a_(0.0, -0.15000000596046448, 0.0);
        }
        super.func_225598_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }
    
    public void setRotationAngles(final PinchBeetleEntity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.Head.field_78796_g = netHeadYaw / 57.295776f;
        this.Head.field_78795_f = headPitch / 57.295776f;
        final float legZ = 0.28559935f;
        this.leftLeg1.field_78808_h = legZ;
        this.rightLeg1.field_78808_h = -legZ;
        this.leftLeg2.field_78808_h = legZ * 0.74f;
        this.rightLeg2.field_78808_h = -legZ * 0.74f;
        this.leftLeg3.field_78808_h = legZ;
        this.rightLeg3.field_78808_h = -legZ;
        final float var9 = -0.0f;
        final float var10 = 0.3926991f;
        this.leftLeg1.field_78796_g = -var10 * 2.0f + var9;
        this.rightLeg1.field_78796_g = var10 * 2.0f - var9;
        this.leftLeg2.field_78796_g = var10 + var9;
        this.rightLeg2.field_78796_g = -var10 - var9;
        this.leftLeg3.field_78796_g = var10 * 2.0f + var9;
        this.rightLeg3.field_78796_g = -var10 * 2.0f - var9;
        final float var11 = -(MathHelper.func_76134_b(limbSwing * 0.6662f * 2.0f + 0.0f) * 0.4f) * limbSwingAmount;
        final float var12 = -(MathHelper.func_76134_b(limbSwing * 0.6662f * 2.0f + 3.1415927f) * 0.4f) * limbSwingAmount;
        final float var13 = -(MathHelper.func_76134_b(limbSwing * 0.6662f * 2.0f + 4.712389f) * 0.4f) * limbSwingAmount;
        final float var14 = Math.abs(MathHelper.func_76126_a(limbSwing * 0.6662f + 0.0f) * 0.4f) * limbSwingAmount;
        final float var15 = Math.abs(MathHelper.func_76126_a(limbSwing * 0.6662f + 3.1415927f) * 0.4f) * limbSwingAmount;
        final float var16 = Math.abs(MathHelper.func_76126_a(limbSwing * 0.6662f + 4.712389f) * 0.4f) * limbSwingAmount;
        final ModelRenderer leftLeg1 = this.leftLeg1;
        leftLeg1.field_78796_g += var11;
        final ModelRenderer rightLeg1 = this.rightLeg1;
        rightLeg1.field_78796_g += -var11;
        final ModelRenderer leftLeg2 = this.leftLeg2;
        leftLeg2.field_78796_g += var12;
        final ModelRenderer rightLeg2 = this.rightLeg2;
        rightLeg2.field_78796_g += -var12;
        final ModelRenderer leftLeg3 = this.leftLeg3;
        leftLeg3.field_78796_g += var13;
        final ModelRenderer rightLeg3 = this.rightLeg3;
        rightLeg3.field_78796_g += -var13;
        final ModelRenderer leftLeg4 = this.leftLeg1;
        leftLeg4.field_78808_h += var14;
        final ModelRenderer rightLeg4 = this.rightLeg1;
        rightLeg4.field_78808_h += -var14;
        final ModelRenderer leftLeg5 = this.leftLeg2;
        leftLeg5.field_78808_h += var15;
        final ModelRenderer rightLeg5 = this.rightLeg2;
        rightLeg5.field_78808_h += -var15;
        final ModelRenderer leftLeg6 = this.leftLeg3;
        leftLeg6.field_78808_h += var16;
        final ModelRenderer rightLeg6 = this.rightLeg3;
        rightLeg6.field_78808_h += -var16;
    }
    
    public void setLivingAnimations(final PinchBeetleEntity entity, final float limbSwing, final float limbSwingAmount, final float partialTicks) {
        if (entity.func_184207_aI()) {
            this.rightPincer.field_78796_g = -0.34906584f;
            this.leftPincer.field_78796_g = 0.34906584f;
        }
        else {
            this.rightPincer.field_78796_g = -0.7853982f;
            this.leftPincer.field_78796_g = 0.7853982f;
        }
    }
    
    public void setRotateAngle(final ModelRenderer modelRenderer, final float x, final float y, final float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}
