// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import twilightforest.entity.monster.PinchBeetle;
import net.minecraft.client.model.HierarchicalModel;

@OnlyIn(Dist.CLIENT)
public class PinchBeetleModel extends HierarchicalModel<PinchBeetle>
{
    public ModelPart root;
    public ModelPart head;
    public ModelPart rightLeg1;
    public ModelPart rightLeg2;
    public ModelPart rightLeg3;
    public ModelPart leftLeg1;
    public ModelPart leftLeg2;
    public ModelPart leftLeg3;
    public ModelPart rightPincer;
    public ModelPart leftPincer;
    
    public PinchBeetleModel(final ModelPart root) {
        this.root = root;
        this.head = root.m_171324_("head");
        this.leftPincer = this.head.m_171324_("left_pincher");
        this.rightPincer = this.head.m_171324_("right_pincher");
        this.rightLeg1 = root.m_171324_("right_leg_1");
        this.rightLeg2 = root.m_171324_("right_leg_2");
        this.rightLeg3 = root.m_171324_("right_leg_3");
        this.leftLeg1 = root.m_171324_("left_leg_1");
        this.leftLeg2 = root.m_171324_("left_leg_2");
        this.leftLeg3 = root.m_171324_("left_leg_3");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = new MeshDefinition();
        final PartDefinition partRoot = mesh.m_171576_();
        final PartDefinition head = partRoot.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-4.0f, -3.0f, -6.0f, 8.0f, 6.0f, 6.0f), PartPose.m_171419_(0.0f, 19.0f, 0.0f));
        head.m_171599_("left_antenna", CubeListBuilder.m_171558_().m_171514_(52, 0).m_171481_(0.0f, 0.0f, -10.0f, 1.0f, 0.0f, 10.0f), PartPose.m_171423_(1.0f, -3.0f, -6.0f, -0.43633232f, -0.43633232f, 0.0f));
        head.m_171599_("right_antenna", CubeListBuilder.m_171558_().m_171514_(48, 0).m_171481_(-1.0f, 0.0f, -10.0f, 1.0f, 0.0f, 10.0f), PartPose.m_171423_(-1.0f, -3.0f, -6.0f, -0.43633232f, 0.43633232f, 0.0f));
        head.m_171599_("left_pincher", CubeListBuilder.m_171558_().m_171514_(16, 14).m_171481_(0.0f, 0.0f, -12.0f, 12.0f, 2.0f, 12.0f), PartPose.m_171423_(4.0f, 2.0f, -4.0f, 0.08726646f, 0.61086524f, 0.0f));
        head.m_171599_("right_pincher", CubeListBuilder.m_171558_().m_171514_(16, 0).m_171481_(-12.0f, 0.0f, -12.0f, 12.0f, 2.0f, 12.0f), PartPose.m_171423_(-4.0f, 2.0f, -4.0f, 0.08726646f, -0.61086524f, 0.0f));
        partRoot.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 28).m_171481_(-5.0f, -8.0f, -3.0f, 10.0f, 10.0f, 7.0f), PartPose.m_171423_(0.0f, 19.0f, 8.0f, 1.5707964f, 0.0f, 0.0f));
        partRoot.m_171599_("right_leg_1", CubeListBuilder.m_171558_().m_171514_(40, 28).m_171481_(-10.0f, 0.0f, -1.0f, 10.0f, 2.0f, 2.0f), PartPose.m_171423_(-2.0f, 21.0f, 6.0f, 0.0f, 0.61086524f, -0.17453292f));
        partRoot.m_171599_("right_leg_2", CubeListBuilder.m_171558_().m_171514_(40, 32).m_171481_(-10.0f, 0.0f, -1.0f, 10.0f, 2.0f, 2.0f), PartPose.m_171423_(-2.0f, 21.0f, 4.0f, 0.0f, 0.20943952f, -0.17453292f));
        partRoot.m_171599_("right_leg_3", CubeListBuilder.m_171558_().m_171514_(40, 36).m_171481_(-10.0f, 0.0f, -1.0f, 10.0f, 2.0f, 2.0f), PartPose.m_171423_(-2.0f, 21.0f, 2.0f, 0.0f, -0.20943952f, -0.17453292f));
        partRoot.m_171599_("left_leg_1", CubeListBuilder.m_171558_().m_171514_(40, 42).m_171481_(0.0f, 0.0f, -1.0f, 10.0f, 2.0f, 2.0f), PartPose.m_171423_(2.0f, 21.0f, 6.0f, 0.0f, -0.61086524f, 0.17453292f));
        partRoot.m_171599_("left_leg_2", CubeListBuilder.m_171558_().m_171514_(40, 46).m_171481_(0.0f, 0.0f, -1.0f, 10.0f, 2.0f, 2.0f), PartPose.m_171423_(2.0f, 21.0f, 4.0f, 0.0f, -0.20943952f, 0.17453292f));
        partRoot.m_171599_("left_leg_3", CubeListBuilder.m_171558_().m_171514_(40, 50).m_171481_(0.0f, 0.0f, -1.0f, 10.0f, 2.0f, 2.0f), PartPose.m_171423_(2.0f, 21.0f, 2.0f, 0.0f, 0.20943952f, 0.17453292f));
        return LayerDefinition.m_171565_(mesh, 64, 64);
    }
    
    public void m_7695_(final PoseStack matrixStackIn, final VertexConsumer bufferIn, final int packedLightIn, final int packedOverlayIn, final float red, final float green, final float blue, final float alpha) {
        if (this.f_102609_) {
            matrixStackIn.m_85837_(0.0, -0.15000000596046448, 0.0);
        }
        super.m_7695_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }
    
    public ModelPart m_142109_() {
        return this.root;
    }
    
    public void setupAnim(final PinchBeetle entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.head.f_104204_ = netHeadYaw / 57.295776f;
        this.head.f_104203_ = headPitch / 57.295776f;
        final float legZ = 0.28559935f;
        this.leftLeg1.f_104205_ = legZ;
        this.rightLeg1.f_104205_ = -legZ;
        this.leftLeg2.f_104205_ = legZ * 0.74f;
        this.rightLeg2.f_104205_ = -legZ * 0.74f;
        this.leftLeg3.f_104205_ = legZ;
        this.rightLeg3.f_104205_ = -legZ;
        final float var9 = -0.0f;
        final float var10 = 0.3926991f;
        this.leftLeg1.f_104204_ = -var10 * 2.0f + var9;
        this.rightLeg1.f_104204_ = var10 * 2.0f - var9;
        this.leftLeg2.f_104204_ = var10 + var9;
        this.rightLeg2.f_104204_ = -var10 - var9;
        this.leftLeg3.f_104204_ = var10 * 2.0f + var9;
        this.rightLeg3.f_104204_ = -var10 * 2.0f - var9;
        final float var11 = -(Mth.m_14089_(limbSwing * 0.6662f * 2.0f + 0.0f) * 0.4f) * limbSwingAmount;
        final float var12 = -(Mth.m_14089_(limbSwing * 0.6662f * 2.0f + 3.1415927f) * 0.4f) * limbSwingAmount;
        final float var13 = -(Mth.m_14089_(limbSwing * 0.6662f * 2.0f + 4.712389f) * 0.4f) * limbSwingAmount;
        final float var14 = Math.abs(Mth.m_14031_(limbSwing * 0.6662f + 0.0f) * 0.4f) * limbSwingAmount;
        final float var15 = Math.abs(Mth.m_14031_(limbSwing * 0.6662f + 3.1415927f) * 0.4f) * limbSwingAmount;
        final float var16 = Math.abs(Mth.m_14031_(limbSwing * 0.6662f + 4.712389f) * 0.4f) * limbSwingAmount;
        final ModelPart leftLeg1 = this.leftLeg1;
        leftLeg1.f_104204_ += var11;
        final ModelPart rightLeg1 = this.rightLeg1;
        rightLeg1.f_104204_ += -var11;
        final ModelPart leftLeg2 = this.leftLeg2;
        leftLeg2.f_104204_ += var12;
        final ModelPart rightLeg2 = this.rightLeg2;
        rightLeg2.f_104204_ += -var12;
        final ModelPart leftLeg3 = this.leftLeg3;
        leftLeg3.f_104204_ += var13;
        final ModelPart rightLeg3 = this.rightLeg3;
        rightLeg3.f_104204_ += -var13;
        final ModelPart leftLeg4 = this.leftLeg1;
        leftLeg4.f_104205_ += var14;
        final ModelPart rightLeg4 = this.rightLeg1;
        rightLeg4.f_104205_ += -var14;
        final ModelPart leftLeg5 = this.leftLeg2;
        leftLeg5.f_104205_ += var15;
        final ModelPart rightLeg5 = this.rightLeg2;
        rightLeg5.f_104205_ += -var15;
        final ModelPart leftLeg6 = this.leftLeg3;
        leftLeg6.f_104205_ += var16;
        final ModelPart rightLeg6 = this.rightLeg3;
        rightLeg6.f_104205_ += -var16;
    }
    
    public void prepareMobModel(final PinchBeetle entity, final float limbSwing, final float limbSwingAmount, final float partialTicks) {
        if (entity.m_20160_()) {
            this.rightPincer.f_104204_ = -0.34906584f;
            this.leftPincer.f_104204_ = 0.34906584f;
        }
        else {
            this.rightPincer.f_104204_ = -0.7853982f;
            this.leftPincer.f_104204_ = 0.7853982f;
        }
    }
}
