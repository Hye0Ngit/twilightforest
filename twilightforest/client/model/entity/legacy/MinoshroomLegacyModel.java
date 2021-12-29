// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity.legacy;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.util.Mth;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import twilightforest.entity.boss.Minoshroom;
import net.minecraft.client.model.HumanoidModel;

public class MinoshroomLegacyModel extends HumanoidModel<Minoshroom>
{
    ModelPart leg1;
    ModelPart leg2;
    ModelPart leg3;
    ModelPart leg4;
    ModelPart cowbody;
    ModelPart udders;
    
    public MinoshroomLegacyModel(final ModelPart root) {
        super(root);
        this.leg1 = root.m_171324_("leg_1");
        this.leg2 = root.m_171324_("leg_2");
        this.leg3 = root.m_171324_("leg_3");
        this.leg4 = root.m_171324_("leg_4");
        this.cowbody = root.m_171324_("cow_body");
        this.udders = root.m_171324_("udders");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = HumanoidModel.m_170681_(CubeDeformation.f_171458_, 0.0f);
        final PartDefinition partRoot = mesh.m_171576_();
        final PartDefinition head = partRoot.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(96, 16).m_171481_(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f), PartPose.m_171419_(0.0f, -6.0f, -9.0f));
        partRoot.m_171599_("hat", CubeListBuilder.m_171558_(), PartPose.f_171404_);
        head.m_171599_("snout", CubeListBuilder.m_171558_().m_171514_(105, 28).m_171481_(-2.0f, -1.0f, -1.0f, 4.0f, 3.0f, 1.0f), PartPose.m_171419_(0.0f, -2.0f, -4.0f));
        final PartDefinition rightHorn = head.m_171599_("right_horn_1", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-5.5f, -1.5f, -1.5f, 5.0f, 3.0f, 3.0f), PartPose.m_171423_(-2.5f, -6.5f, 0.0f, 0.0f, -0.43633235f, 0.17453294f));
        rightHorn.m_171599_("right_horn_2", CubeListBuilder.m_171558_().m_171514_(16, 0).m_171481_(-3.5f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f), PartPose.m_171423_(-4.5f, 0.0f, 0.0f, 0.0f, -0.2617994f, 0.7853982f));
        final PartDefinition leftHorn = head.m_171599_("left_horn_1", CubeListBuilder.m_171558_().m_171480_().m_171514_(0, 0).m_171481_(0.5f, -1.5f, -1.5f, 5.0f, 3.0f, 3.0f), PartPose.m_171423_(2.5f, -6.5f, 0.0f, 0.0f, 0.43633235f, -0.17453294f));
        leftHorn.m_171599_("left_horn_2", CubeListBuilder.m_171558_().m_171514_(16, 0).m_171481_(0.5f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f), PartPose.m_171423_(4.5f, 0.0f, 0.0f, 0.0f, 0.2617994f, -0.7853982f));
        partRoot.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(64, 0).m_171481_(-4.0f, 0.0f, -2.5f, 8.0f, 12.0f, 5.0f), PartPose.m_171419_(0.0f, -6.0f, -9.0f));
        partRoot.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(90, 0).m_171481_(-3.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f), PartPose.m_171419_(-5.0f, -4.0f, -9.0f));
        partRoot.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171480_().m_171514_(90, 0).m_171481_(-1.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f), PartPose.m_171419_(5.0f, -4.0f, -9.0f));
        partRoot.m_171599_("cow_body", CubeListBuilder.m_171558_().m_171514_(18, 4).m_171481_(-6.0f, -10.0f, -7.0f, 12.0f, 18.0f, 10.0f), PartPose.m_171423_(0.0f, 5.0f, 2.0f, 1.570796f, 0.0f, 0.0f));
        partRoot.m_171599_("udders", CubeListBuilder.m_171558_().m_171514_(52, 0).m_171481_(-2.0f, -3.0f, 0.0f, 4.0f, 6.0f, 2.0f), PartPose.m_171423_(0.0f, 14.0f, 6.0f, 1.570796f, 0.0f, 0.0f));
        partRoot.m_171599_("leg_1", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171481_(-3.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f), PartPose.m_171419_(-3.0f, 12.0f, 7.0f));
        partRoot.m_171599_("leg_2", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171481_(-1.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f), PartPose.m_171419_(3.0f, 12.0f, 7.0f));
        partRoot.m_171599_("leg_3", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171481_(-3.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f), PartPose.m_171419_(-3.0f, 12.0f, -5.0f));
        partRoot.m_171599_("leg_4", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171481_(-1.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f), PartPose.m_171419_(3.0f, 12.0f, -5.0f));
        return LayerDefinition.m_171565_(mesh, 128, 32);
    }
    
    protected Iterable<ModelPart> m_5608_() {
        return (Iterable<ModelPart>)ImmutableList.of((Object)this.f_102808_, (Object)this.f_102810_, (Object)this.f_102812_, (Object)this.f_102811_, (Object)this.cowbody, (Object)this.udders, (Object)this.leg1, (Object)this.leg2, (Object)this.leg3, (Object)this.leg4);
    }
    
    public void setupAnim(final Minoshroom entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.f_102808_.f_104204_ = netHeadYaw / 57.295776f;
        this.f_102808_.f_104203_ = headPitch / 57.295776f;
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
        if (this.f_102815_ != HumanoidModel.ArmPose.EMPTY) {
            this.f_102812_.f_104203_ = this.f_102812_.f_104203_ * 0.5f - 0.31415927f;
        }
        if (this.f_102816_ != HumanoidModel.ArmPose.EMPTY) {
            this.f_102811_.f_104203_ = this.f_102811_.f_104203_ * 0.5f - 0.31415927f;
        }
        final ModelPart f_102811_ = this.f_102811_;
        f_102811_.f_104205_ += Mth.m_14089_(ageInTicks * 0.09f) * 0.05f + 0.05f;
        final ModelPart f_102812_ = this.f_102812_;
        f_102812_.f_104205_ -= Mth.m_14089_(ageInTicks * 0.09f) * 0.05f + 0.05f;
        final ModelPart f_102811_2 = this.f_102811_;
        f_102811_2.f_104203_ += Mth.m_14031_(ageInTicks * 0.067f) * 0.05f;
        final ModelPart f_102812_2 = this.f_102812_;
        f_102812_2.f_104203_ -= Mth.m_14031_(ageInTicks * 0.067f) * 0.05f;
        final float var7 = 0.0f;
        final float var8 = 0.0f;
        if (this.f_102815_ == HumanoidModel.ArmPose.BOW_AND_ARROW) {
            this.f_102812_.f_104205_ = 0.0f;
            this.f_102812_.f_104204_ = 0.1f - var7 * 0.6f + this.f_102808_.f_104204_ + 0.4f;
            this.f_102812_.f_104203_ = -1.5707964f + this.f_102808_.f_104203_;
            final ModelPart f_102812_3 = this.f_102812_;
            f_102812_3.f_104203_ -= var7 * 1.2f - var8 * 0.4f;
            final ModelPart f_102812_4 = this.f_102812_;
            f_102812_4.f_104205_ -= Mth.m_14089_(ageInTicks * 0.09f) * 0.05f + 0.05f;
            final ModelPart f_102812_5 = this.f_102812_;
            f_102812_5.f_104203_ -= Mth.m_14031_(ageInTicks * 0.067f) * 0.05f;
        }
        if (this.f_102816_ == HumanoidModel.ArmPose.BOW_AND_ARROW) {
            this.f_102811_.f_104205_ = 0.0f;
            this.f_102811_.f_104204_ = -(0.1f - var7 * 0.6f) + this.f_102808_.f_104204_;
            this.f_102811_.f_104203_ = -1.5707964f + this.f_102808_.f_104203_;
            final ModelPart f_102811_3 = this.f_102811_;
            f_102811_3.f_104203_ -= var7 * 1.2f - var8 * 0.4f;
            final ModelPart f_102811_4 = this.f_102811_;
            f_102811_4.f_104205_ += Mth.m_14089_(ageInTicks * 0.09f) * 0.05f + 0.05f;
            final ModelPart f_102811_5 = this.f_102811_;
            f_102811_5.f_104203_ += Mth.m_14031_(ageInTicks * 0.067f) * 0.05f;
        }
        this.cowbody.f_104203_ = 1.5707964f;
        this.leg1.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.leg2.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.leg3.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.leg4.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        final float f = ageInTicks - entity.f_19797_;
        float f2 = entity.getChargeAnimationScale(f);
        f2 *= f2;
        final float f3 = 1.0f - f2;
        if (f2 > 0.0f) {
            if (entity.m_5737_() == HumanoidArm.RIGHT) {
                this.f_102811_.f_104203_ = f2 * -1.8f;
                this.f_102812_.f_104203_ = 0.0f;
                this.f_102811_.f_104205_ = -0.2f;
            }
            else {
                this.f_102811_.f_104203_ = 0.0f;
                this.f_102812_.f_104203_ = f2 * -1.8f;
                this.f_102812_.f_104205_ = 0.2f;
            }
            this.cowbody.f_104203_ = 1.5707964f - f2 * 3.1415927f * 0.2f;
            this.leg3.f_104201_ = 12.0f + -5.8f * f2;
            this.leg3.f_104202_ = -4.0f + -5.8f * f2;
            final ModelPart leg3 = this.leg3;
            leg3.f_104203_ -= f2 * 3.1415927f * 0.3f;
            this.leg4.f_104201_ = this.leg3.f_104201_;
            this.leg4.f_104202_ = this.leg3.f_104202_;
            final ModelPart leg4 = this.leg4;
            leg4.f_104203_ -= f2 * 3.1415927f * 0.3f;
            this.f_102810_.f_104201_ = -6.0f + -3.0f * f2;
        }
    }
}
