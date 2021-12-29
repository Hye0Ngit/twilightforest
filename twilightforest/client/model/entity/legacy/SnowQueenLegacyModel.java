// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity.legacy;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import twilightforest.entity.boss.SnowQueen;
import net.minecraft.client.model.HumanoidModel;

public class SnowQueenLegacyModel extends HumanoidModel<SnowQueen>
{
    public SnowQueenLegacyModel(final ModelPart root) {
        super(root);
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = HumanoidModel.m_170681_(CubeDeformation.f_171458_, 0.0f);
        final PartDefinition partRoot = mesh.m_171576_();
        final PartDefinition head = partRoot.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f), PartPose.m_171419_(0.0f, -4.0f, 0.0f));
        partRoot.m_171599_("hat", CubeListBuilder.m_171558_(), PartPose.f_171404_);
        final PartDefinition crown = head.m_171599_("crown", CubeListBuilder.m_171558_(), PartPose.f_171404_);
        makeFrontCrown(crown, -1.0f, -4.0f, 10.0f, 0);
        makeFrontCrown(crown, 0.0f, 4.0f, -10.0f, 1);
        makeSideCrown(crown, -1.0f, -4.0f, 10.0f, 0);
        makeSideCrown(crown, 0.0f, 4.0f, -10.0f, 1);
        partRoot.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171481_(-4.0f, 0.0f, -2.0f, 8.0f, 23.0f, 4.0f), PartPose.f_171404_);
        partRoot.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(16, 16).m_171481_(-2.0f, -2.0f, -1.5f, 3.0f, 12.0f, 3.0f), PartPose.m_171419_(-5.0f, 2.0f, 0.0f));
        partRoot.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171514_(16, 16).m_171481_(-1.0f, -2.0f, -1.3f, 3.0f, 12.0f, 3.0f), PartPose.m_171419_(5.0f, 2.0f, 0.0f));
        partRoot.m_171599_("right_leg", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171481_(-1.5f, 0.0f, -1.5f, 3.0f, 12.0f, 3.0f), PartPose.m_171419_(-1.9f, 12.0f, 0.0f));
        partRoot.m_171599_("left_leg", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171481_(-1.5f, 0.0f, -1.5f, 3.0f, 12.0f, 3.0f), PartPose.m_171419_(1.9f, 12.0f, 0.0f));
        return LayerDefinition.m_171565_(mesh, 64, 32);
    }
    
    private static void makeSideCrown(final PartDefinition parent, final float spikeDepth, final float crownX, final float angle, final int iteration) {
        final PartDefinition crownSide = parent.m_171599_("crown_side_" + iteration, CubeListBuilder.m_171558_().m_171514_(28, 28).m_171481_(-3.5f, -0.5f, -0.5f, 7.0f, 1.0f, 1.0f), PartPose.m_171423_(crownX, -6.0f, 0.0f, 0.0f, 1.5707964f, 0.0f));
        crownSide.m_171599_("spike_4", CubeListBuilder.m_171558_().m_171514_(48, 27).m_171481_(-0.5f, -3.5f, spikeDepth, 1.0f, 4.0f, 1.0f), PartPose.m_171423_(0.0f, 0.0f, 0.0f, angle * 1.5f / 180.0f * 3.1415927f, 0.0f, 0.0f));
        crownSide.m_171599_("spike_3l", CubeListBuilder.m_171558_().m_171514_(52, 28).m_171481_(-0.5f, -2.5f, spikeDepth, 1.0f, 3.0f, 1.0f), PartPose.m_171423_(-2.5f, 0.0f, 0.0f, angle / 180.0f * 3.1415927f, 0.0f, -0.17453294f));
        crownSide.m_171599_("spike_3r", CubeListBuilder.m_171558_().m_171514_(52, 28).m_171481_(-0.5f, -2.5f, spikeDepth, 1.0f, 3.0f, 1.0f), PartPose.m_171423_(2.5f, 0.0f, 0.0f, angle / 180.0f * 3.1415927f, 0.0f, 0.17453294f));
    }
    
    private static void makeFrontCrown(final PartDefinition parent, final float spikeDepth, final float crownZ, final float angle, final int iteration) {
        final PartDefinition crownFront = parent.m_171599_("crown_front_" + iteration, CubeListBuilder.m_171558_().m_171514_(28, 30).m_171481_(-4.5f, -0.5f, -0.5f, 9.0f, 1.0f, 1.0f), PartPose.m_171419_(0.0f, -6.0f, crownZ));
        crownFront.m_171599_("spike_4", CubeListBuilder.m_171558_().m_171514_(48, 27).m_171481_(-0.5f, -3.5f, spikeDepth, 1.0f, 4.0f, 1.0f), PartPose.m_171423_(0.0f, 0.0f, 0.0f, angle * 1.5f / 180.0f * 3.1415927f, 0.0f, 0.0f));
        crownFront.m_171599_("spike_3l", CubeListBuilder.m_171558_().m_171514_(52, 28).m_171481_(-0.5f, -2.5f, spikeDepth, 1.0f, 3.0f, 1.0f), PartPose.m_171423_(-2.5f, 0.0f, 0.0f, angle / 180.0f * 3.1415927f, 0.0f, -0.17453279f));
        crownFront.m_171599_("spike_3r", CubeListBuilder.m_171558_().m_171514_(52, 28).m_171481_(-0.5f, -2.5f, spikeDepth, 1.0f, 3.0f, 1.0f), PartPose.m_171423_(2.5f, 0.0f, 0.0f, angle / 180.0f * 3.1415927f, 0.0f, 0.17453279f));
    }
    
    public void setupAnim(final SnowQueen entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        super.m_6973_((LivingEntity)entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        if (entity.getCurrentPhase() == SnowQueen.Phase.BEAM) {
            if (entity.isBreathing()) {
                final float f6 = Mth.m_14031_(this.f_102608_ * 3.1415927f);
                final float f7 = Mth.m_14031_((1.0f - (1.0f - this.f_102608_) * (1.0f - this.f_102608_)) * 3.1415927f);
                this.f_102811_.f_104205_ = 0.0f;
                this.f_102812_.f_104205_ = 0.0f;
                this.f_102811_.f_104204_ = -(0.1f - f6 * 0.6f);
                this.f_102812_.f_104204_ = 0.1f - f6 * 0.6f;
                this.f_102811_.f_104203_ = -1.5707964f;
                this.f_102812_.f_104203_ = -1.5707964f;
                final ModelPart f_102811_ = this.f_102811_;
                f_102811_.f_104203_ -= f6 * 1.2f - f7 * 0.4f;
                final ModelPart f_102812_ = this.f_102812_;
                f_102812_.f_104203_ -= f6 * 1.2f - f7 * 0.4f;
                final ModelPart f_102811_2 = this.f_102811_;
                f_102811_2.f_104205_ += Mth.m_14089_(ageInTicks * 0.09f) * 0.05f + 0.05f;
                final ModelPart f_102812_2 = this.f_102812_;
                f_102812_2.f_104205_ -= Mth.m_14089_(ageInTicks * 0.09f) * 0.05f + 0.05f;
                final ModelPart f_102811_3 = this.f_102811_;
                f_102811_3.f_104203_ += Mth.m_14031_(ageInTicks * 0.067f) * 0.05f;
                final ModelPart f_102812_3 = this.f_102812_;
                f_102812_3.f_104203_ -= Mth.m_14031_(ageInTicks * 0.067f) * 0.05f;
            }
            else {
                final ModelPart f_102811_4 = this.f_102811_;
                f_102811_4.f_104203_ += (float)3.141592653589793;
                final ModelPart f_102812_4 = this.f_102812_;
                f_102812_4.f_104203_ += (float)3.141592653589793;
            }
        }
    }
}
