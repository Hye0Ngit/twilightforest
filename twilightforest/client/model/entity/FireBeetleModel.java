// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import twilightforest.entity.monster.FireBeetle;
import net.minecraft.client.model.HierarchicalModel;

@OnlyIn(Dist.CLIENT)
public class FireBeetleModel extends HierarchicalModel<FireBeetle>
{
    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart rightLeg1;
    private final ModelPart rightLeg2;
    private final ModelPart rightLeg3;
    private final ModelPart leftLeg1;
    private final ModelPart leftLeg2;
    private final ModelPart leftLeg3;
    
    public FireBeetleModel(final ModelPart root) {
        this.root = root;
        this.head = this.root.m_171324_("head");
        this.rightLeg1 = this.root.m_171324_("right_leg_1");
        this.rightLeg2 = this.root.m_171324_("right_leg_2");
        this.rightLeg3 = this.root.m_171324_("right_leg_3");
        this.leftLeg1 = this.root.m_171324_("left_leg_1");
        this.leftLeg2 = this.root.m_171324_("left_leg_2");
        this.leftLeg3 = this.root.m_171324_("left_leg_3");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = new MeshDefinition();
        final PartDefinition partRoot = mesh.m_171576_();
        final PartDefinition head = partRoot.m_171599_("head", CubeListBuilder.m_171558_().m_171481_(-4.0f, -3.0f, -6.0f, 8.0f, 6.0f, 6.0f), PartPose.m_171419_(0.0f, 18.0f, -4.0f));
        head.m_171599_("jaws", CubeListBuilder.m_171558_().m_171514_(-6, 18).m_171481_(-3.0f, 0.0f, -6.0f, 6.0f, 0.0f, 6.0f), PartPose.m_171423_(0.0f, 2.0f, -6.0f, 0.3926991f, 0.0f, 0.0f));
        head.m_171599_("right_eye", CubeListBuilder.m_171558_().m_171514_(0, 12).m_171481_(-2.0f, -1.0f, -2.0f, 3.0f, 3.0f, 3.0f), PartPose.m_171419_(-2.5f, -1.0f, -4.5f));
        head.m_171599_("left_eye", CubeListBuilder.m_171558_().m_171514_(16, 12).m_171481_(-1.0f, -1.0f, -2.0f, 3.0f, 3.0f, 3.0f), PartPose.m_171419_(2.5f, -1.0f, -4.5f));
        head.m_171599_("right_antenna", CubeListBuilder.m_171558_().m_171514_(38, 4).m_171481_(-12.0f, -0.5f, -0.5f, 12.0f, 1.0f, 1.0f), PartPose.m_171423_(-0.5f, -1.5f, -5.0f, 0.0f, -0.7853982f, 0.21816616f));
        head.m_171599_("left_antenna", CubeListBuilder.m_171558_().m_171514_(38, 6).m_171481_(0.0f, -0.5f, -0.5f, 12.0f, 1.0f, 1.0f), PartPose.m_171423_(0.5f, -1.5f, -5.0f, 0.0f, 0.7853982f, -0.21816616f));
        partRoot.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(22, 9).m_171481_(-6.0f, 0.0f, -4.0f, 12.0f, 14.0f, 9.0f), PartPose.m_171423_(0.0f, 18.0f, -4.0f, 1.5707964f, 0.0f, 0.0f));
        partRoot.m_171599_("right_leg_1", CubeListBuilder.m_171558_().m_171514_(40, 0).m_171481_(-10.0f, -1.0f, -1.0f, 10.0f, 2.0f, 2.0f), PartPose.m_171423_(-3.0f, 21.0f, -3.0f, 0.0f, -0.3926991f, -0.21816616f));
        partRoot.m_171599_("right_leg_2", CubeListBuilder.m_171558_().m_171514_(40, 0).m_171481_(-10.0f, -1.0f, -1.0f, 10.0f, 2.0f, 2.0f), PartPose.m_171423_(-3.0f, 21.0f, 0.0f, 0.0f, 0.21816616f, -0.21816616f));
        partRoot.m_171599_("right_leg_3", CubeListBuilder.m_171558_().m_171514_(40, 0).m_171481_(-10.0f, -1.0f, -1.0f, 10.0f, 2.0f, 2.0f), PartPose.m_171423_(-3.0f, 21.0f, 4.0f, 0.0f, 0.3926991f, -0.21816616f));
        partRoot.m_171599_("left_leg_1", CubeListBuilder.m_171558_().m_171480_().m_171514_(40, 0).m_171481_(0.0f, -1.0f, -1.0f, 10.0f, 2.0f, 2.0f), PartPose.m_171423_(3.0f, 21.0f, -3.0f, 0.0f, 0.3926991f, 0.21816616f));
        partRoot.m_171599_("left_leg_2", CubeListBuilder.m_171558_().m_171480_().m_171514_(40, 0).m_171481_(0.0f, -1.0f, -1.0f, 10.0f, 2.0f, 2.0f), PartPose.m_171423_(3.0f, 21.0f, 0.0f, 0.0f, -0.21816616f, 0.21816616f));
        partRoot.m_171599_("left_leg_3", CubeListBuilder.m_171558_().m_171480_().m_171514_(40, 0).m_171481_(0.0f, -1.0f, -1.0f, 10.0f, 2.0f, 2.0f), PartPose.m_171423_(3.0f, 21.0f, 4.0f, 0.0f, -0.3926991f, 0.21816616f));
        return LayerDefinition.m_171565_(mesh, 64, 32);
    }
    
    public ModelPart m_142109_() {
        return this.root;
    }
    
    public void setupAnim(final FireBeetle entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.head.f_104204_ = netHeadYaw * 0.017453292f;
        this.head.f_104203_ = headPitch * 0.017453292f;
        final float legZ = 0.28559935f;
        this.leftLeg1.f_104205_ = legZ;
        this.rightLeg1.f_104205_ = -legZ;
        this.leftLeg2.f_104205_ = legZ * 0.74f;
        this.rightLeg2.f_104205_ = -legZ * 0.74f;
        this.leftLeg3.f_104205_ = legZ;
        this.rightLeg3.f_104205_ = -legZ;
        final float var9 = -0.0f;
        final float var10 = 0.3926991f;
        this.leftLeg1.f_104204_ = var10 * 2.0f + var9;
        this.rightLeg1.f_104204_ = -var10 * 2.0f - var9;
        this.leftLeg2.f_104204_ = var10 + var9;
        this.rightLeg2.f_104204_ = -var10 - var9;
        this.leftLeg3.f_104204_ = -var10 * 2.0f + var9;
        this.rightLeg3.f_104204_ = var10 * 2.0f - var9;
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
}
