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
import twilightforest.entity.SlimeBeetleEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;

@OnlyIn(Dist.CLIENT)
public class SlimeBeetleModel extends SegmentedModel<SlimeBeetleEntity>
{
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer tailBottom;
    public ModelRenderer rightLeg1;
    public ModelRenderer rightLeg2;
    public ModelRenderer rightLeg3;
    public ModelRenderer leftLeg1;
    public ModelRenderer leftLeg2;
    public ModelRenderer leftLeg3;
    public ModelRenderer rightAntenna;
    public ModelRenderer leftAntenna;
    public ModelRenderer rightEye;
    public ModelRenderer leftEye;
    public ModelRenderer tailTop;
    public ModelRenderer slime;
    public ModelRenderer slimeCenter;
    private final boolean translucent;
    
    public SlimeBeetleModel() {
        this(false);
    }
    
    public SlimeBeetleModel(final boolean translucent) {
        this.translucent = translucent;
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        (this.body = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 17.0f, -8.0f);
        this.body.func_78784_a(32, 8).func_228302_a_(-4.0f, 0.0f, -4.0f, 8.0f, 10.0f, 8.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.body, 1.5707964f, 0.0f, 0.0f);
        (this.rightLeg1 = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-2.0f, 20.0f, -6.0f);
        this.rightLeg1.func_78784_a(40, 0).func_228302_a_(-10.0f, -1.0f, -1.0f, 10.0f, 2.0f, 2.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.rightLeg1, 0.0f, -0.43633232f, -0.43633232f);
        (this.tailBottom = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 18.0f, 2.0f);
        this.tailBottom.func_78784_a(0, 34).func_228302_a_(-3.0f, -3.0f, 0.0f, 6.0f, 6.0f, 6.0f, 0.0f, 0.0f, 0.0f);
        (this.slime = new ModelRenderer((Model)this, 16, 40)).func_78793_a(0.0f, -8.0f, 2.0f);
        this.slime.func_228302_a_(-6.0f, -12.0f, -7.0f, 12.0f, 12.0f, 12.0f, 0.0f, 0.0f, 0.0f);
        (this.slimeCenter = new ModelRenderer((Model)this, 0, 18)).func_78793_a(0.0f, -9.0f, 2.0f);
        this.slimeCenter.func_228302_a_(-4.0f, -9.0f, -5.0f, 8.0f, 8.0f, 8.0f, 0.0f, 0.0f, 0.0f);
        (this.rightEye = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-2.5f, -1.0f, -4.5f);
        this.rightEye.func_78784_a(0, 12).func_228302_a_(-2.0f, -1.0f, -2.0f, 3.0f, 3.0f, 3.0f, 0.0f, 0.0f, 0.0f);
        (this.leftEye = new ModelRenderer((Model)this, 0, 0)).func_78793_a(2.5f, -1.0f, -4.5f);
        this.leftEye.func_78784_a(16, 12).func_228302_a_(-1.0f, -1.0f, -2.0f, 3.0f, 3.0f, 3.0f, 0.0f, 0.0f, 0.0f);
        (this.rightAntenna = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-0.5f, -1.5f, -5.0f);
        this.rightAntenna.func_78784_a(38, 4).func_228302_a_(-12.0f, -0.5f, -0.5f, 12.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.rightAntenna, 0.0f, -0.7853982f, 0.7853982f);
        this.leftLeg2 = new ModelRenderer((Model)this, 0, 0);
        this.leftLeg2.field_78809_i = true;
        this.leftLeg2.func_78793_a(2.0f, 20.0f, -4.0f);
        this.leftLeg2.func_78784_a(40, 0).func_228302_a_(0.0f, -1.0f, -1.0f, 10.0f, 2.0f, 2.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.leftLeg2, 0.0f, -0.21816616f, 0.43633232f);
        (this.tailTop = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 0.0f, 3.0f);
        this.tailTop.func_78784_a(32, 28).func_228302_a_(-3.0f, -9.0f, -1.0f, 6.0f, 6.0f, 6.0f, 0.0f, 0.0f, 0.0f);
        (this.rightLeg3 = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-2.0f, 20.0f, -2.0f);
        this.rightLeg3.func_78784_a(40, 0).func_228302_a_(-10.0f, -1.0f, -1.0f, 10.0f, 2.0f, 2.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.rightLeg3, 0.0f, 0.7853982f, -0.43633232f);
        (this.leftAntenna = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.5f, -1.5f, -5.0f);
        this.leftAntenna.func_78784_a(38, 6).func_228302_a_(0.0f, -0.5f, -0.5f, 12.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.leftAntenna, 0.0f, 0.7853982f, -0.7853982f);
        (this.head = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 17.0f, -8.0f);
        this.head.func_228302_a_(-4.0f, -3.0f, -6.0f, 8.0f, 6.0f, 6.0f, 0.0f, 0.0f, 0.0f);
        (this.rightLeg2 = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-2.0f, 20.0f, -4.0f);
        this.rightLeg2.func_78784_a(40, 0).func_228302_a_(-10.0f, -1.0f, -1.0f, 10.0f, 2.0f, 2.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.rightLeg2, 0.0f, 0.21816616f, -0.43633232f);
        this.leftLeg3 = new ModelRenderer((Model)this, 0, 0);
        this.leftLeg3.field_78809_i = true;
        this.leftLeg3.func_78793_a(2.0f, 20.0f, -2.0f);
        this.leftLeg3.func_78784_a(40, 0).func_228302_a_(0.0f, -1.0f, -1.0f, 10.0f, 2.0f, 2.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.leftLeg3, 0.0f, -0.7853982f, 0.43633232f);
        this.leftLeg1 = new ModelRenderer((Model)this, 0, 0);
        this.leftLeg1.field_78809_i = true;
        this.leftLeg1.func_78793_a(2.0f, 20.0f, -6.0f);
        this.leftLeg1.func_78784_a(40, 0).func_228302_a_(0.0f, -1.0f, -1.0f, 10.0f, 2.0f, 2.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.leftLeg1, 0.0f, 0.43633232f, 0.43633232f);
        this.tailTop.func_78792_a(translucent ? this.slime : this.slimeCenter);
        this.head.func_78792_a(this.rightEye);
        this.head.func_78792_a(this.leftEye);
        this.head.func_78792_a(this.rightAntenna);
        this.tailBottom.func_78792_a(this.tailTop);
        this.head.func_78792_a(this.leftAntenna);
    }
    
    public Iterable<ModelRenderer> func_225601_a_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.head, (Object)this.body, (Object)this.leftLeg1, (Object)this.leftLeg2, (Object)this.leftLeg3, (Object)this.rightLeg1, (Object)this.rightLeg2, (Object)this.rightLeg3, (Object)this.tailBottom);
    }
    
    public void func_225598_a_(final MatrixStack stack, final IVertexBuilder builder, final int light, final int overlay, final float red, final float green, final float blue, final float alpha) {
        this.tailBottom.func_228309_a_(stack, builder, light, overlay, red, green, blue, alpha);
        if (!this.translucent) {
            this.func_225601_a_().forEach(part -> part.func_228309_a_(stack, builder, light, overlay, red, green, blue, alpha));
        }
    }
    
    public void setRotationAngles(final SlimeBeetleEntity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.head.field_78796_g = netHeadYaw / 57.295776f;
        this.head.field_78795_f = headPitch / 57.295776f;
        final float legZ = 0.28559935f;
        this.leftLeg1.field_78808_h = legZ;
        this.rightLeg1.field_78808_h = -legZ;
        this.leftLeg2.field_78808_h = legZ * 0.74f;
        this.rightLeg2.field_78808_h = -legZ * 0.74f;
        this.leftLeg3.field_78808_h = legZ;
        this.rightLeg3.field_78808_h = -legZ;
        final float var9 = -0.0f;
        final float var10 = 0.3926991f;
        this.leftLeg1.field_78796_g = var10 * 2.0f + var9;
        this.rightLeg1.field_78796_g = -var10 * 2.0f - var9;
        this.leftLeg2.field_78796_g = var10 + var9;
        this.rightLeg2.field_78796_g = -var10 - var9;
        this.leftLeg3.field_78796_g = -var10 * 2.0f + var9;
        this.rightLeg3.field_78796_g = var10 * 2.0f - var9;
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
        this.tailBottom.field_78795_f = MathHelper.func_76134_b(ageInTicks * 0.3335f) * 0.15f;
        this.tailTop.field_78795_f = MathHelper.func_76134_b(ageInTicks * 0.4445f) * 0.2f;
        this.slime.field_78795_f = MathHelper.func_76134_b(ageInTicks * 0.5555f) * 0.25f;
        this.slimeCenter.field_78795_f = MathHelper.func_76134_b(ageInTicks * 0.5555f + 0.25f) * 0.25f;
    }
    
    public void setRotateAngle(final ModelRenderer modelRenderer, final float x, final float y, final float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}
