// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity.legacy;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import twilightforest.entity.monster.HelmetCrab;
import net.minecraft.client.model.HierarchicalModel;

public class HelmetCrabLegacyModel extends HierarchicalModel<HelmetCrab>
{
    ModelPart root;
    ModelPart body;
    ModelPart rightArm;
    ModelPart leg1;
    ModelPart leg2;
    ModelPart leg3;
    ModelPart leg4;
    ModelPart leg5;
    
    public HelmetCrabLegacyModel(final ModelPart root) {
        this.root = root;
        this.body = root.m_171324_("body");
        this.rightArm = root.m_171324_("right_arm");
        this.leg1 = root.m_171324_("leg_1");
        this.leg2 = root.m_171324_("leg_2");
        this.leg3 = root.m_171324_("leg_3");
        this.leg4 = root.m_171324_("leg_4");
        this.leg5 = root.m_171324_("leg_5");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = new MeshDefinition();
        final PartDefinition partRoot = mesh.m_171576_();
        final PartDefinition body = partRoot.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(32, 4).m_171481_(-2.5f, -2.5f, -5.0f, 5.0f, 5.0f, 5.0f), PartPose.m_171419_(0.0f, 19.0f, 0.0f));
        body.m_171599_("right_eye", CubeListBuilder.m_171558_().m_171514_(10, 0).m_171481_(-1.0f, -3.0f, -1.0f, 2.0f, 3.0f, 2.0f), PartPose.m_171423_(-1.0f, -1.0f, -4.0f, 0.7853982f, 0.0f, -0.7853982f));
        body.m_171599_("left_eye", CubeListBuilder.m_171558_().m_171514_(10, 0).m_171481_(-1.0f, -3.0f, -1.0f, 2.0f, 3.0f, 2.0f), PartPose.m_171423_(1.0f, -1.0f, -4.0f, 0.7853982f, 0.0f, 0.7853982f));
        final PartDefinition helmetBase = partRoot.m_171599_("helmet_base", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0f, 18.0f, 0.0f, -1.7453294f, -0.5235988f, 0.0f));
        helmetBase.m_171599_("helmet", CubeListBuilder.m_171558_().m_171514_(0, 14).m_171481_(-3.5f, -11.0f, -3.5f, 7.0f, 11.0f, 7.0f), PartPose.m_171423_(0.0f, 0.0f, 0.0f, 0.0f, 0.7853982f, 0.0f));
        final PartDefinition rightHorn = helmetBase.m_171599_("right_horn_1", CubeListBuilder.m_171558_().m_171514_(28, 14).m_171481_(-6.0f, -1.5f, -1.5f, 7.0f, 3.0f, 3.0f), PartPose.m_171423_(-3.5f, -9.0f, 0.0f, 0.0f, -0.2617994f, 0.17453294f));
        rightHorn.m_171599_("right_horn_2", CubeListBuilder.m_171558_().m_171514_(28, 20).m_171481_(-3.0f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f), PartPose.m_171423_(-5.5f, 0.0f, 0.0f, 0.0f, -0.2617994f, 0.17453294f));
        final PartDefinition leftHorn = helmetBase.m_171599_("left_horn_1", CubeListBuilder.m_171558_().m_171514_(28, 14).m_171481_(-6.0f, -1.5f, -1.5f, 7.0f, 3.0f, 3.0f), PartPose.m_171423_(3.5f, -9.0f, 0.0f, 0.0f, 0.2617994f, -0.17453294f));
        leftHorn.m_171599_("left_horn_2", CubeListBuilder.m_171558_().m_171514_(28, 20).m_171481_(-3.0f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f), PartPose.m_171423_(5.5f, 0.0f, 0.0f, 0.0f, 0.2617994f, -0.17453294f));
        final PartDefinition rightArm = partRoot.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(38, 0).m_171481_(-7.0f, -1.0f, -1.0f, 8.0f, 2.0f, 2.0f), PartPose.m_171423_(-3.0f, 20.0f, -3.0f, 0.0f, -1.319531f, -0.1919862f));
        final PartDefinition clawBase = rightArm.m_171599_("claw_base", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(0.0f, -1.5f, -1.0f, 3.0f, 3.0f, 2.0f), PartPose.m_171423_(-6.0f, 0.0f, -0.5f, 0.0f, 1.5707964f, 0.0f));
        clawBase.m_171599_("claw_bottom", CubeListBuilder.m_171558_().m_171514_(0, 8).m_171481_(0.0f, -0.5f, -1.0f, 3.0f, 2.0f, 2.0f), PartPose.m_171423_(3.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.2602503f));
        clawBase.m_171599_("claw_top", CubeListBuilder.m_171558_().m_171514_(0, 5).m_171481_(0.0f, -0.5f, -1.0f, 3.0f, 1.0f, 2.0f), PartPose.m_171423_(3.0f, -1.0f, 0.0f, 0.0f, 0.0f, -0.1858931f));
        partRoot.m_171599_("leg_1", CubeListBuilder.m_171558_().m_171514_(18, 0).m_171481_(-7.0f, -1.0f, -1.0f, 8.0f, 2.0f, 2.0f), PartPose.m_171423_(-3.0f, 20.0f, -1.0f, 0.0f, 0.2792527f, -0.1919862f));
        partRoot.m_171599_("leg_2", CubeListBuilder.m_171558_().m_171514_(18, 0).m_171481_(-1.0f, -1.0f, -1.0f, 8.0f, 2.0f, 2.0f), PartPose.m_171423_(3.0f, 20.0f, -1.0f, 0.0f, -0.2792527f, 0.1919862f));
        partRoot.m_171599_("leg_3", CubeListBuilder.m_171558_().m_171514_(18, 0).m_171481_(-7.0f, -1.0f, -1.0f, 8.0f, 2.0f, 2.0f), PartPose.m_171423_(-3.0f, 20.0f, -2.0f, 0.0f, -0.2792527f, -0.1919862f));
        partRoot.m_171599_("leg_4", CubeListBuilder.m_171558_().m_171514_(18, 0).m_171481_(-1.0f, -1.0f, -1.0f, 8.0f, 2.0f, 2.0f), PartPose.m_171423_(3.0f, 20.0f, -2.0f, 0.0f, 0.2792527f, 0.1919862f));
        partRoot.m_171599_("leg_5", CubeListBuilder.m_171558_().m_171514_(18, 0).m_171481_(-1.0f, -1.0f, -1.0f, 8.0f, 2.0f, 2.0f), PartPose.m_171423_(3.0f, 20.0f, -3.0f, 0.0f, 0.5759587f, 0.1919862f));
        return LayerDefinition.m_171565_(mesh, 64, 32);
    }
    
    public ModelPart m_142109_() {
        return this.root;
    }
    
    public void setupAnim(final HelmetCrab entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.body.f_104204_ = netHeadYaw / 57.295776f;
        this.body.f_104203_ = headPitch / 57.295776f;
        final float f6 = 0.7853982f;
        this.leg1.f_104205_ = -f6 * 0.74f;
        this.leg2.f_104205_ = f6 * 0.74f;
        this.leg3.f_104205_ = -f6 * 0.74f;
        this.leg4.f_104205_ = f6 * 0.74f;
        this.leg5.f_104205_ = f6;
        final float f7 = -0.0f;
        final float f8 = 0.3926991f;
        this.leg1.f_104204_ = f8 + f7;
        this.leg2.f_104204_ = -f8 - f7;
        this.leg3.f_104204_ = -f8 + f7;
        this.leg4.f_104204_ = f8 - f7;
        this.leg5.f_104204_ = f8 * 2.0f - f7;
        final float f9 = -(Mth.m_14089_(limbSwing * 0.6662f * 2.0f + 3.1415927f) * 0.4f) * limbSwingAmount;
        final float f10 = -(Mth.m_14089_(limbSwing * 0.6662f * 2.0f + 1.5707964f) * 0.4f) * limbSwingAmount;
        final float f11 = -(Mth.m_14089_(limbSwing * 0.6662f * 2.0f + 4.712389f) * 0.4f) * limbSwingAmount;
        final float f12 = Math.abs(Mth.m_14031_(limbSwing * 0.6662f + 3.1415927f) * 0.4f) * limbSwingAmount;
        final float f13 = Math.abs(Mth.m_14031_(limbSwing * 0.6662f + 1.5707964f) * 0.4f) * limbSwingAmount;
        final float f14 = Math.abs(Mth.m_14031_(limbSwing * 0.6662f + 4.712389f) * 0.4f) * limbSwingAmount;
        final ModelPart leg1 = this.leg1;
        leg1.f_104204_ += f9;
        final ModelPart leg2 = this.leg2;
        leg2.f_104204_ += -f9;
        final ModelPart leg3 = this.leg3;
        leg3.f_104204_ += f10;
        final ModelPart leg4 = this.leg4;
        leg4.f_104204_ += -f10;
        final ModelPart leg5 = this.leg5;
        leg5.f_104204_ += -f11;
        final ModelPart leg6 = this.leg1;
        leg6.f_104205_ += f12;
        final ModelPart leg7 = this.leg2;
        leg7.f_104205_ += -f12;
        final ModelPart leg8 = this.leg3;
        leg8.f_104205_ += f13;
        final ModelPart leg9 = this.leg4;
        leg9.f_104205_ += -f13;
        final ModelPart leg10 = this.leg5;
        leg10.f_104205_ += -f14;
        this.rightArm.f_104204_ = -1.319531f;
        final ModelPart rightArm = this.rightArm;
        rightArm.f_104204_ += Mth.m_14089_(limbSwing * 0.6662f + 3.1415927f) * 2.0f * limbSwingAmount * 0.5f;
    }
}
