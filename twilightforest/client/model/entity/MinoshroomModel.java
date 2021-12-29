// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import twilightforest.entity.boss.Minoshroom;
import net.minecraft.client.model.HumanoidModel;

@OnlyIn(Dist.CLIENT)
public class MinoshroomModel extends HumanoidModel<Minoshroom>
{
    public ModelPart cowTorso;
    public ModelPart rightFrontLeg;
    public ModelPart leftFrontLeg;
    public ModelPart rightBackLeg;
    public ModelPart leftBackLeg;
    
    public MinoshroomModel(final ModelPart root) {
        super(root);
        this.cowTorso = root.m_171324_("cow_torso");
        this.rightFrontLeg = root.m_171324_("right_front_leg");
        this.leftFrontLeg = root.m_171324_("left_front_leg");
        this.rightBackLeg = root.m_171324_("right_back_leg");
        this.leftBackLeg = root.m_171324_("left_back_leg");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = HumanoidModel.m_170681_(CubeDeformation.f_171458_, 0.0f);
        final PartDefinition partRoot = mesh.m_171576_();
        partRoot.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-4.0f, -11.0f, -4.0f, 8.0f, 8.0f, 8.0f).m_171514_(0, 16).m_171481_(-3.0f, -6.0f, -5.0f, 6.0f, 3.0f, 1.0f).m_171514_(32, 0).m_171481_(-8.0f, -10.0f, -1.0f, 4.0f, 2.0f, 3.0f).m_171514_(32, 5).m_171481_(-8.0f, -13.0f, -1.0f, 2.0f, 3.0f, 3.0f).m_171514_(46, 0).m_171481_(4.0f, -10.0f, -1.0f, 4.0f, 2.0f, 3.0f).m_171514_(46, 5).m_171481_(6.0f, -13.0f, -1.0f, 2.0f, 3.0f, 3.0f), PartPose.m_171419_(0.0f, -6.0f, -7.0f));
        partRoot.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 29).m_171481_(-5.0f, -3.0f, 0.0f, 10.0f, 12.0f, 5.0f), PartPose.m_171419_(0.0f, -6.0f, -9.0f));
        partRoot.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171514_(46, 15).m_171481_(0.0f, -1.0f, -2.0f, 4.0f, 14.0f, 5.0f), PartPose.m_171419_(5.0f, -8.0f, -7.0f));
        partRoot.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(28, 15).m_171481_(-4.0f, -1.0f, -2.0f, 4.0f, 14.0f, 5.0f), PartPose.m_171419_(-5.0f, -8.0f, -7.0f));
        partRoot.m_171599_("cow_torso", CubeListBuilder.m_171558_().m_171514_(20, 36).m_171481_(-6.0f, -14.0f, -2.0f, 12.0f, 18.0f, 10.0f).m_171514_(0, 20).m_171481_(-2.0f, -2.0f, -3.0f, 4.0f, 6.0f, 1.0f), PartPose.m_171423_(0.0f, 10.0f, 6.0f, 1.5707964f, 0.0f, 0.0f));
        partRoot.m_171599_("right_front_leg", CubeListBuilder.m_171558_().m_171514_(0, 48).m_171481_(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f), PartPose.m_171419_(-4.0f, 12.0f, -6.0f));
        partRoot.m_171599_("left_front_leg", CubeListBuilder.m_171558_().m_171514_(0, 48).m_171481_(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f), PartPose.m_171419_(4.0f, 12.0f, -6.0f));
        partRoot.m_171599_("right_back_leg", CubeListBuilder.m_171558_().m_171514_(0, 48).m_171481_(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f), PartPose.m_171419_(-4.0f, 12.0f, 7.0f));
        partRoot.m_171599_("left_back_leg", CubeListBuilder.m_171558_().m_171514_(0, 48).m_171481_(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f), PartPose.m_171419_(4.0f, 12.0f, 7.0f));
        return LayerDefinition.m_171565_(mesh, 64, 64);
    }
    
    protected Iterable<ModelPart> m_5608_() {
        return (Iterable<ModelPart>)ImmutableList.of((Object)this.f_102810_, (Object)this.f_102811_, (Object)this.f_102812_, (Object)this.cowTorso, (Object)this.leftBackLeg, (Object)this.rightBackLeg, (Object)this.leftFrontLeg, (Object)this.rightFrontLeg);
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
        this.cowTorso.f_104203_ = 1.5707964f;
        this.leftFrontLeg.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.rightFrontLeg.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.leftBackLeg.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.rightBackLeg.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        final float f = ageInTicks - entity.f_19797_;
        float f2 = entity.getChargeAnimationScale(f);
        f2 *= f2;
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
            this.cowTorso.f_104203_ = 1.5707964f - f2 * 3.1415927f * 0.2f;
            this.leftFrontLeg.f_104201_ = 12.0f + -5.8f * f2;
            this.leftFrontLeg.f_104202_ = -4.0f + -5.8f * f2;
            final ModelPart leftFrontLeg = this.leftFrontLeg;
            leftFrontLeg.f_104203_ -= f2 * 3.1415927f * 0.3f;
            this.rightFrontLeg.f_104201_ = this.leftFrontLeg.f_104201_;
            this.rightFrontLeg.f_104202_ = this.leftFrontLeg.f_104202_;
            final ModelPart rightFrontLeg = this.rightFrontLeg;
            rightFrontLeg.f_104203_ -= f2 * 3.1415927f * 0.3f;
            this.f_102810_.f_104201_ = -6.0f + -3.0f * f2;
        }
    }
}
