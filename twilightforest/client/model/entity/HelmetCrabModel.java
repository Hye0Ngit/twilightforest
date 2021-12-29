// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import twilightforest.entity.monster.HelmetCrab;
import net.minecraft.client.model.HierarchicalModel;

@OnlyIn(Dist.CLIENT)
public class HelmetCrabModel extends HierarchicalModel<HelmetCrab>
{
    public ModelPart root;
    public ModelPart body;
    public ModelPart leftClaw;
    public ModelPart rightClaw;
    public ModelPart rightLeg1;
    public ModelPart rightLeg2;
    public ModelPart leftLeg1;
    public ModelPart leftLeg2;
    
    public HelmetCrabModel(final ModelPart root) {
        this.root = root;
        this.body = root.m_171324_("body");
        this.rightClaw = this.body.m_171324_("right_claw");
        this.leftClaw = this.body.m_171324_("left_claw");
        this.rightLeg1 = root.m_171324_("right_leg_1");
        this.rightLeg2 = root.m_171324_("right_leg_2");
        this.leftLeg1 = root.m_171324_("left_leg_1");
        this.leftLeg2 = root.m_171324_("left_leg_2");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = new MeshDefinition();
        final PartDefinition partRoot = mesh.m_171576_();
        final PartDefinition body = partRoot.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 9).m_171481_(-2.5f, -4.0f, -2.5f, 5.0f, 4.0f, 5.0f).m_171514_(58, 0).m_171481_(-1.5f, -5.0f, -3.5f, 1.0f, 2.0f, 1.0f).m_171514_(58, 3).m_171481_(0.5f, -5.0f, -3.5f, 1.0f, 2.0f, 1.0f), PartPose.m_171419_(0.0f, 21.0f, 0.0f));
        final PartDefinition helmet = body.m_171599_("helmet", CubeListBuilder.m_171558_().m_171514_(40, 0).m_171481_(-4.0f, -8.0f, -4.0f, 6.0f, 8.0f, 6.0f).m_171514_(16, 0).m_171488_(-4.0f, -8.0f, -4.0f, 6.0f, 8.0f, 6.0f, new CubeDeformation(-0.25f)), PartPose.m_171423_(0.0f, -1.0f, 0.5f, -1.3089969f, -0.2617994f, 0.7463028f));
        helmet.m_171599_("horns", CubeListBuilder.m_171558_().m_171514_(18, 23).m_171481_(-11.5f, -12.0f, -0.67f, 23.0f, 9.0f, 0.0f), PartPose.m_171423_(0.0f, 0.0f, 0.0f, 0.0f, 0.7853982f, 0.0f));
        body.m_171599_("right_claw", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-1.0f, -3.0f, -5.0f, 2.0f, 4.0f, 5.0f), PartPose.m_171423_(-3.0f, 0.0f, -3.0f, 0.0f, 0.3926991f, 0.0f));
        body.m_171599_("left_claw", CubeListBuilder.m_171558_().m_171514_(0, 23).m_171481_(-1.0f, -3.0f, -5.0f, 2.0f, 4.0f, 5.0f), PartPose.m_171423_(3.0f, 0.0f, -3.0f, 0.0f, -0.3926991f, 0.0f));
        partRoot.m_171599_("right_leg_1", CubeListBuilder.m_171558_().m_171514_(32, 15).m_171481_(-6.0f, -1.0f, -1.0f, 6.0f, 2.0f, 2.0f), PartPose.m_171423_(-2.0f, 21.0f, 0.0f, 0.21816616f, 0.43633232f, -0.43633232f));
        partRoot.m_171599_("left_leg_1", CubeListBuilder.m_171558_().m_171514_(48, 19).m_171481_(0.0f, -1.0f, -1.0f, 6.0f, 2.0f, 2.0f), PartPose.m_171423_(2.0f, 21.0f, 0.0f, 0.21816616f, -0.43633232f, 0.43633232f));
        partRoot.m_171599_("right_leg_2", CubeListBuilder.m_171558_().m_171514_(32, 19).m_171481_(-6.0f, -1.0f, -1.0f, 6.0f, 2.0f, 2.0f), PartPose.m_171423_(-2.0f, 21.0f, -1.5f, 0.21816616f, 0.0f, -0.43633232f));
        partRoot.m_171599_("left_leg_2", CubeListBuilder.m_171558_().m_171514_(48, 15).m_171481_(0.0f, -1.0f, -1.0f, 6.0f, 2.0f, 2.0f), PartPose.m_171423_(2.0f, 21.0f, -1.5f, 0.21816616f, 0.0f, 0.43633232f));
        return LayerDefinition.m_171565_(mesh, 64, 32);
    }
    
    public void m_7695_(final PoseStack matrixStackIn, final VertexConsumer bufferIn, final int packedLightIn, final int packedOverlayIn, final float red, final float green, final float blue, final float alpha) {
        if (this.f_102609_) {
            matrixStackIn.m_85837_(0.0, -0.25, 0.0);
        }
        super.m_7695_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }
    
    public ModelPart m_142109_() {
        return this.root;
    }
    
    public void setupAnim(final HelmetCrab entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.body.f_104204_ = netHeadYaw / 57.295776f;
        this.body.f_104203_ = headPitch / 57.295776f;
        final float f6 = 0.7853982f;
        this.rightLeg1.f_104205_ = -f6 * 0.74f;
        this.leftLeg1.f_104205_ = f6 * 0.74f;
        this.rightLeg2.f_104205_ = -f6 * 0.74f;
        this.leftLeg2.f_104205_ = f6 * 0.74f;
        final float f7 = -0.0f;
        final float f8 = 0.3926991f;
        this.rightLeg1.f_104204_ = f8 + f7;
        this.leftLeg1.f_104204_ = -f8 - f7;
        this.rightLeg2.f_104204_ = -f8 + f7;
        this.leftLeg2.f_104204_ = f8 - f7;
        final float f9 = -(Mth.m_14089_(limbSwing * 0.6662f * 2.0f + 3.1415927f) * 0.4f) * limbSwingAmount;
        final float f10 = -(Mth.m_14089_(limbSwing * 0.6662f * 2.0f + 1.5707964f) * 0.4f) * limbSwingAmount;
        final float f11 = Math.abs(Mth.m_14031_(limbSwing * 0.6662f + 3.1415927f) * 0.4f) * limbSwingAmount;
        final float f12 = Math.abs(Mth.m_14031_(limbSwing * 0.6662f + 1.5707964f) * 0.4f) * limbSwingAmount;
        final ModelPart rightLeg1 = this.rightLeg1;
        rightLeg1.f_104204_ += f9;
        final ModelPart leftLeg1 = this.leftLeg1;
        leftLeg1.f_104204_ += -f9;
        final ModelPart rightLeg2 = this.rightLeg2;
        rightLeg2.f_104204_ += f10;
        final ModelPart leftLeg2 = this.leftLeg2;
        leftLeg2.f_104204_ += -f10;
        final ModelPart rightLeg3 = this.rightLeg1;
        rightLeg3.f_104205_ += f11;
        final ModelPart leftLeg3 = this.leftLeg1;
        leftLeg3.f_104205_ += -f11;
        final ModelPart rightLeg4 = this.rightLeg2;
        rightLeg4.f_104205_ += f12;
        final ModelPart leftLeg4 = this.leftLeg2;
        leftLeg4.f_104205_ += -f12;
        this.leftClaw.f_104204_ = -0.319531f;
        final ModelPart leftClaw = this.leftClaw;
        leftClaw.f_104204_ += -(Mth.m_14089_(limbSwing * 0.6662f + 3.1415927f) * 2.0f * limbSwingAmount * 0.5f) / 2.0f;
        this.rightClaw.f_104204_ = 0.319531f;
        final ModelPart rightClaw = this.rightClaw;
        rightClaw.f_104204_ += Mth.m_14089_(limbSwing * 0.6662f + 3.1415927f) * 2.0f * limbSwingAmount * 0.5f / 2.0f;
    }
}
