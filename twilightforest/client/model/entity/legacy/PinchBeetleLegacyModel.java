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
import twilightforest.entity.monster.PinchBeetle;
import net.minecraft.client.model.HierarchicalModel;

public class PinchBeetleLegacyModel extends HierarchicalModel<PinchBeetle>
{
    ModelPart root;
    ModelPart head;
    ModelPart leg6;
    ModelPart leg4;
    ModelPart leg2;
    ModelPart leg5;
    ModelPart leg3;
    ModelPart leg1;
    ModelPart jaw1a;
    ModelPart jaw2a;
    
    public PinchBeetleLegacyModel(final ModelPart root) {
        this.root = root;
        this.head = root.m_171324_("head");
        this.leg1 = root.m_171324_("leg_1");
        this.leg2 = root.m_171324_("leg_2");
        this.leg3 = root.m_171324_("leg_3");
        this.leg4 = root.m_171324_("leg_4");
        this.leg5 = root.m_171324_("leg_5");
        this.leg6 = root.m_171324_("leg_6");
        this.jaw1a = this.head.m_171324_("right_jaw_bottom");
        this.jaw2a = this.head.m_171324_("left_jaw_bottom");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = new MeshDefinition();
        final PartDefinition partRoot = mesh.m_171576_();
        final PartDefinition head = partRoot.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-4.0f, -4.0f, -6.0f, 8.0f, 6.0f, 6.0f), PartPose.m_171419_(0.0f, 19.0f, -5.0f));
        head.m_171599_("right_antenna", CubeListBuilder.m_171558_().m_171514_(42, 4).m_171481_(0.0f, -0.5f, -0.5f, 10.0f, 1.0f, 1.0f), PartPose.m_171423_(1.0f, -3.0f, -5.0f, 0.0f, 1.047198f, -0.296706f));
        head.m_171599_("left_antenna", CubeListBuilder.m_171558_().m_171514_(42, 4).m_171481_(0.0f, -0.5f, -0.5f, 10.0f, 1.0f, 1.0f), PartPose.m_171423_(-1.0f, -3.0f, -5.0f, 0.0f, 2.094395f, 0.296706f));
        head.m_171599_("right_eye", CubeListBuilder.m_171558_().m_171514_(15, 12).m_171481_(-1.5f, -1.5f, -1.5f, 3.0f, 3.0f, 3.0f), PartPose.m_171419_(-3.0f, -2.0f, -5.0f));
        head.m_171599_("left_eye", CubeListBuilder.m_171558_().m_171514_(15, 12).m_171481_(-1.5f, -1.5f, -1.5f, 3.0f, 3.0f, 3.0f), PartPose.m_171419_(3.0f, -2.0f, -5.0f));
        final PartDefinition rightJaw = head.m_171599_("right_jaw_bottom", CubeListBuilder.m_171558_().m_171514_(40, 6).m_171481_(-1.0f, -1.0f, -1.5f, 8.0f, 2.0f, 3.0f), PartPose.m_171423_(-3.0f, 1.0f, -6.0f, 0.0f, 2.635447f, 0.0f));
        final PartDefinition rightJawTooth = rightJaw.m_171599_("right_jaw_top", CubeListBuilder.m_171558_().m_171514_(40, 10).m_171481_(-1.0f, -1.0f, -1.0f, 10.0f, 2.0f, 2.0f), PartPose.m_171423_(7.0f, 0.0f, 0.0f, 0.0f, -1.047197f, 0.0f));
        rightJawTooth.m_171599_("right_tooth_1", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(0.0f, -0.5f, -0.0f, 2.0f, 1.0f, 1.0f), PartPose.m_171423_(9.0f, 0.0f, 0.0f, 0.0f, -0.5235987f, 0.0f));
        rightJawTooth.m_171599_("right_tooth_2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(0.0f, -0.5f, -0.0f, 2.0f, 1.0f, 1.0f), PartPose.m_171423_(6.0f, 0.0f, 0.0f, 0.0f, 1.5707963f, 0.0f));
        rightJawTooth.m_171599_("right_tooth_3", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(0.0f, -0.5f, -0.0f, 2.0f, 1.0f, 1.0f), PartPose.m_171423_(3.0f, 0.0f, 0.0f, 0.0f, 1.5707963f, 0.0f));
        final PartDefinition leftJaw = head.m_171599_("left_jaw_bottom", CubeListBuilder.m_171558_().m_171514_(40, 6).m_171481_(-1.0f, -1.0f, -1.5f, 8.0f, 2.0f, 3.0f), PartPose.m_171423_(3.0f, 1.0f, -6.0f, 0.0f, 0.541052f, 0.0f));
        final PartDefinition leftJawTooth = leftJaw.m_171599_("left_jaw_top", CubeListBuilder.m_171558_().m_171514_(40, 10).m_171481_(-1.0f, -1.0f, -1.0f, 10.0f, 2.0f, 2.0f), PartPose.m_171423_(7.0f, 0.0f, 0.0f, 0.0f, 1.047197f, 0.0f));
        leftJawTooth.m_171599_("left_tooth_1", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(0.0f, -0.5f, -0.0f, 2.0f, 1.0f, 1.0f), PartPose.m_171423_(9.0f, 0.0f, 0.0f, 0.0f, 0.5235987f, 0.0f));
        leftJawTooth.m_171599_("left_tooth_2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(0.0f, -0.5f, -0.0f, 2.0f, 1.0f, 1.0f), PartPose.m_171423_(6.0f, 0.0f, 0.0f, 0.0f, -1.5707963f, 0.0f));
        leftJawTooth.m_171599_("left_tooth_3", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(0.0f, -0.5f, -0.0f, 2.0f, 1.0f, 1.0f), PartPose.m_171423_(3.0f, 0.0f, 0.0f, 0.0f, -1.5707963f, 0.0f));
        partRoot.m_171599_("thorax", CubeListBuilder.m_171558_().m_171514_(0, 22).m_171481_(-4.5f, -4.0f, 0.0f, 9.0f, 8.0f, 2.0f), PartPose.m_171419_(0.0f, 18.0f, -4.5f));
        partRoot.m_171599_("connector_1", CubeListBuilder.m_171558_().m_171514_(0, 12).m_171481_(-3.0f, -3.0f, 0.0f, 6.0f, 6.0f, 1.0f), PartPose.m_171419_(0.0f, 18.0f, -3.0f));
        partRoot.m_171599_("connector_2", CubeListBuilder.m_171558_().m_171514_(0, 12).m_171481_(-3.0f, -3.0f, -1.0f, 6.0f, 6.0f, 1.0f), PartPose.m_171419_(0.0f, 18.0f, -4.0f));
        partRoot.m_171599_("rear", CubeListBuilder.m_171558_().m_171514_(28, 14).m_171481_(-5.0f, -9.0f, -4.0f, 10.0f, 10.0f, 8.0f), PartPose.m_171423_(0.0f, 18.0f, 7.0f, 1.570796f, 0.0f, 0.0f));
        partRoot.m_171599_("leg_1", CubeListBuilder.m_171558_().m_171480_().m_171514_(40, 0).m_171481_(-9.0f, -1.0f, -1.0f, 10.0f, 2.0f, 2.0f), PartPose.m_171423_(-4.0f, 21.0f, 4.0f, 0.0f, 0.6981317f, -0.3490659f));
        partRoot.m_171599_("leg_2", CubeListBuilder.m_171558_().m_171514_(40, 0).m_171481_(-1.0f, -1.0f, -1.0f, 10.0f, 2.0f, 2.0f), PartPose.m_171423_(4.0f, 21.0f, 4.0f, 0.0f, -0.6981317f, 0.3490659f));
        partRoot.m_171599_("leg_3", CubeListBuilder.m_171558_().m_171480_().m_171514_(40, 0).m_171481_(-9.0f, -1.0f, -1.0f, 10.0f, 2.0f, 2.0f), PartPose.m_171423_(-4.0f, 21.0f, -1.0f, 0.0f, 0.2792527f, -0.3490659f));
        partRoot.m_171599_("leg_4", CubeListBuilder.m_171558_().m_171514_(40, 0).m_171481_(-1.0f, -1.0f, -1.0f, 10.0f, 2.0f, 2.0f), PartPose.m_171423_(4.0f, 21.0f, -1.0f, 0.0f, -0.2792527f, 0.3490659f));
        partRoot.m_171599_("leg_5", CubeListBuilder.m_171558_().m_171480_().m_171514_(40, 0).m_171481_(-9.0f, -1.0f, -1.0f, 10.0f, 2.0f, 2.0f), PartPose.m_171423_(-4.0f, 21.0f, -4.0f, 0.0f, -0.2792527f, -0.3490659f));
        partRoot.m_171599_("leg_6", CubeListBuilder.m_171558_().m_171514_(40, 0).m_171481_(-1.0f, -1.0f, -1.0f, 10.0f, 2.0f, 2.0f), PartPose.m_171423_(4.0f, 21.0f, -4.0f, 0.0f, 0.2792527f, 0.3490659f));
        return LayerDefinition.m_171565_(mesh, 64, 32);
    }
    
    public ModelPart m_142109_() {
        return this.root;
    }
    
    public void setupAnim(final PinchBeetle entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.head.f_104204_ = netHeadYaw / 57.295776f;
        this.head.f_104203_ = headPitch / 57.295776f;
        final float legZ = 0.28559935f;
        this.leg1.f_104205_ = -legZ;
        this.leg2.f_104205_ = legZ;
        this.leg3.f_104205_ = -legZ * 0.74f;
        this.leg4.f_104205_ = legZ * 0.74f;
        this.leg5.f_104205_ = -legZ;
        this.leg6.f_104205_ = legZ;
        final float var9 = -0.0f;
        final float var10 = 0.3926991f;
        this.leg1.f_104204_ = var10 * 2.0f + var9;
        this.leg2.f_104204_ = -var10 * 2.0f - var9;
        this.leg3.f_104204_ = var10 + var9;
        this.leg4.f_104204_ = -var10 - var9;
        this.leg5.f_104204_ = -var10 * 2.0f + var9;
        this.leg6.f_104204_ = var10 * 2.0f - var9;
        final float var11 = -(Mth.m_14089_(limbSwing * 0.6662f * 2.0f + 0.0f) * 0.4f) * limbSwingAmount;
        final float var12 = -(Mth.m_14089_(limbSwing * 0.6662f * 2.0f + 3.1415927f) * 0.4f) * limbSwingAmount;
        final float var13 = -(Mth.m_14089_(limbSwing * 0.6662f * 2.0f + 4.712389f) * 0.4f) * limbSwingAmount;
        final float var14 = Math.abs(Mth.m_14031_(limbSwing * 0.6662f + 0.0f) * 0.4f) * limbSwingAmount;
        final float var15 = Math.abs(Mth.m_14031_(limbSwing * 0.6662f + 3.1415927f) * 0.4f) * limbSwingAmount;
        final float var16 = Math.abs(Mth.m_14031_(limbSwing * 0.6662f + 4.712389f) * 0.4f) * limbSwingAmount;
        final ModelPart leg1 = this.leg1;
        leg1.f_104204_ += var11;
        final ModelPart leg2 = this.leg2;
        leg2.f_104204_ += -var11;
        final ModelPart leg3 = this.leg3;
        leg3.f_104204_ += var12;
        final ModelPart leg4 = this.leg4;
        leg4.f_104204_ += -var12;
        final ModelPart leg5 = this.leg5;
        leg5.f_104204_ += var13;
        final ModelPart leg6 = this.leg6;
        leg6.f_104204_ += -var13;
        final ModelPart leg7 = this.leg1;
        leg7.f_104205_ += var14;
        final ModelPart leg8 = this.leg2;
        leg8.f_104205_ += -var14;
        final ModelPart leg9 = this.leg3;
        leg9.f_104205_ += var15;
        final ModelPart leg10 = this.leg4;
        leg10.f_104205_ += -var15;
        final ModelPart leg11 = this.leg5;
        leg11.f_104205_ += var16;
        final ModelPart leg12 = this.leg6;
        leg12.f_104205_ += -var16;
    }
    
    public void prepareMobModel(final PinchBeetle entity, final float limbSwing, final float limbSwingAmount, final float partialTicks) {
        if (entity.m_20160_()) {
            this.jaw1a.f_104204_ = 2.9670596f;
            this.jaw2a.f_104204_ = 0.34906584f;
        }
        else {
            this.jaw1a.f_104204_ = 2.3561945f;
            this.jaw2a.f_104204_ = 0.7853982f;
        }
    }
}
