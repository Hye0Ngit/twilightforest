// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.util.Mth;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HumanoidModel;
import twilightforest.entity.monster.Yeti;

public class YetiModel<T extends Yeti> extends HumanoidModel<T>
{
    private final ModelPart leftEye;
    private final ModelPart rightEye;
    private final ModelPart angryLeftEye;
    private final ModelPart angryRightEye;
    
    public YetiModel(final ModelPart root) {
        super(root);
        final ModelPart body = root.m_171324_("body");
        this.rightEye = body.m_171324_("right_eye");
        this.leftEye = body.m_171324_("left_eye");
        this.angryRightEye = body.m_171324_("angry_right_eye");
        this.angryLeftEye = body.m_171324_("angry_left_eye");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = new MeshDefinition();
        final PartDefinition partRoot = mesh.m_171576_();
        partRoot.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-4.0f, -8.0f, -4.0f, 0.0f, 0.0f, 0.0f), PartPose.f_171404_);
        partRoot.m_171599_("hat", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171481_(-4.0f, -8.0f, -4.0f, 0.0f, 0.0f, 0.0f), PartPose.f_171404_);
        final PartDefinition body = partRoot.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171481_(-10.0f, 0.0f, -6.0f, 20.0f, 26.0f, 12.0f), PartPose.m_171419_(0.0f, -14.0f, 0.0f));
        body.m_171599_("mouth", CubeListBuilder.m_171558_().m_171514_(96, 6).m_171481_(-7.0f, -5.0f, -0.5f, 14.0f, 10.0f, 1.0f), PartPose.m_171419_(0.0f, 12.0f, -6.0f));
        body.m_171599_("right_eye", CubeListBuilder.m_171558_().m_171514_(96, 0).m_171481_(-2.5f, -2.5f, -0.5f, 5.0f, 5.0f, 1.0f), PartPose.m_171419_(-5.5f, 4.5f, -6.0f));
        body.m_171599_("left_eye", CubeListBuilder.m_171558_().m_171514_(96, 0).m_171481_(-2.5f, -2.5f, -0.5f, 5.0f, 5.0f, 1.0f), PartPose.m_171419_(5.5f, 4.5f, -6.0f));
        body.m_171599_("angry_right_eye", CubeListBuilder.m_171558_().m_171514_(109, 0).m_171481_(-2.5f, -2.5f, -0.5f, 5.0f, 5.0f, 1.0f), PartPose.m_171419_(5.5f, 4.5f, -6.0f));
        body.m_171599_("angry_left_eye", CubeListBuilder.m_171558_().m_171514_(109, 0).m_171481_(-2.5f, -2.5f, -0.5f, 5.0f, 5.0f, 1.0f), PartPose.m_171419_(-5.5f, 4.5f, -6.0f));
        partRoot.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-5.0f, -2.0f, -3.0f, 6.0f, 16.0f, 6.0f), PartPose.m_171419_(-11.0f, -4.0f, 0.0f));
        partRoot.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171480_().m_171514_(0, 0).m_171481_(-1.0f, -2.0f, -3.0f, 6.0f, 16.0f, 6.0f), PartPose.m_171419_(11.0f, -4.0f, 0.0f));
        partRoot.m_171599_("right_leg", CubeListBuilder.m_171558_().m_171514_(0, 22).m_171481_(-4.0f, 0.0f, -4.0f, 8.0f, 12.0f, 8.0f), PartPose.m_171419_(-6.0f, 12.0f, 0.0f));
        partRoot.m_171599_("left_leg", CubeListBuilder.m_171558_().m_171480_().m_171514_(0, 22).m_171481_(-4.0f, 0.0f, -4.0f, 8.0f, 12.0f, 8.0f), PartPose.m_171419_(6.0f, 12.0f, 0.0f));
        return LayerDefinition.m_171565_(mesh, 128, 64);
    }
    
    public void setupAnim(final T entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.f_102808_.f_104204_ = netHeadYaw * 0.017453292f;
        this.f_102808_.f_104203_ = headPitch * 0.017453292f;
        this.f_102809_.f_104204_ = this.f_102808_.f_104204_;
        this.f_102809_.f_104203_ = this.f_102808_.f_104203_;
        this.f_102811_.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f + 3.1415927f) * 2.0f * limbSwingAmount * 0.5f;
        this.f_102812_.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f) * 2.0f * limbSwingAmount * 0.5f;
        this.f_102811_.f_104205_ = 0.0f;
        this.f_102812_.f_104205_ = 0.0f;
        this.f_102813_.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.f_102814_.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.f_102813_.f_104204_ = 0.0f;
        this.f_102814_.f_104204_ = 0.0f;
        if (entity.m_20160_()) {
            final ModelPart f_102811_ = this.f_102811_;
            f_102811_.f_104203_ += 3.1415927f;
            final ModelPart f_102812_ = this.f_102812_;
            f_102812_.f_104203_ += 3.1415927f;
        }
        if (this.f_102815_ != HumanoidModel.ArmPose.EMPTY) {
            this.f_102812_.f_104203_ = this.f_102812_.f_104203_ * 0.5f - 0.31415927f;
        }
        if (this.f_102816_ != HumanoidModel.ArmPose.EMPTY) {
            this.f_102811_.f_104203_ = this.f_102811_.f_104203_ * 0.5f - 0.31415927f;
        }
        this.f_102811_.f_104204_ = 0.0f;
        this.f_102812_.f_104204_ = 0.0f;
        final ModelPart f_102811_2 = this.f_102811_;
        f_102811_2.f_104205_ += Mth.m_14089_(ageInTicks * 0.09f) * 0.05f + 0.05f;
        final ModelPart f_102812_2 = this.f_102812_;
        f_102812_2.f_104205_ -= Mth.m_14089_(ageInTicks * 0.09f) * 0.05f + 0.05f;
        final ModelPart f_102811_3 = this.f_102811_;
        f_102811_3.f_104203_ += Mth.m_14031_(ageInTicks * 0.067f) * 0.05f;
        final ModelPart f_102812_3 = this.f_102812_;
        f_102812_3.f_104203_ -= Mth.m_14031_(ageInTicks * 0.067f) * 0.05f;
        if (entity.isAngry()) {
            final float f6 = Mth.m_14031_(this.f_102608_ * 3.1415927f);
            final float f7 = Mth.m_14031_((1.0f - (1.0f - this.f_102608_) * (1.0f - this.f_102608_)) * 3.1415927f);
            this.f_102811_.f_104205_ = 0.0f;
            this.f_102812_.f_104205_ = 0.0f;
            this.f_102811_.f_104204_ = -(0.1f - f6 * 0.6f);
            this.f_102812_.f_104204_ = 0.1f - f6 * 0.6f;
            this.f_102811_.f_104203_ = -1.5707964f;
            this.f_102812_.f_104203_ = -1.5707964f;
            final ModelPart f_102811_4 = this.f_102811_;
            f_102811_4.f_104203_ -= f6 * 1.2f - f7 * 0.4f;
            final ModelPart f_102812_4 = this.f_102812_;
            f_102812_4.f_104203_ -= f6 * 1.2f - f7 * 0.4f;
            final ModelPart f_102811_5 = this.f_102811_;
            f_102811_5.f_104205_ += Mth.m_14089_(ageInTicks * 0.09f) * 0.05f + 0.05f;
            final ModelPart f_102812_5 = this.f_102812_;
            f_102812_5.f_104205_ -= Mth.m_14089_(ageInTicks * 0.09f) * 0.05f + 0.05f;
            final ModelPart f_102811_6 = this.f_102811_;
            f_102811_6.f_104203_ += Mth.m_14031_(ageInTicks * 0.067f) * 0.05f;
            final ModelPart f_102812_6 = this.f_102812_;
            f_102812_6.f_104203_ -= Mth.m_14031_(ageInTicks * 0.067f) * 0.05f;
        }
    }
    
    public void prepareMobModel(final T entity, final float limbSwing, final float limbSwingAmount, final float partialTicks) {
        if (entity.isAngry()) {
            this.rightEye.f_104207_ = false;
            this.leftEye.f_104207_ = false;
            this.angryRightEye.f_104207_ = true;
            this.angryLeftEye.f_104207_ = true;
        }
        else {
            this.rightEye.f_104207_ = true;
            this.leftEye.f_104207_ = true;
            this.angryRightEye.f_104207_ = false;
            this.angryLeftEye.f_104207_ = false;
        }
    }
}
