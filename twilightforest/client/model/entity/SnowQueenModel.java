// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import twilightforest.entity.boss.SnowQueen;
import net.minecraft.client.model.HumanoidModel;

@OnlyIn(Dist.CLIENT)
public class SnowQueenModel extends HumanoidModel<SnowQueen>
{
    public SnowQueenModel(final ModelPart root) {
        super(root);
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = new MeshDefinition();
        final PartDefinition partRoot = mesh.m_171576_();
        partRoot.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171481_(-4.0f, 0.0f, -2.0f, 8.0f, 12.0f, 4.0f).m_171514_(32, 45).m_171481_(-4.5f, 10.0f, -2.5f, 9.0f, 14.0f, 5.0f), PartPose.f_171404_);
        partRoot.m_171599_("head", CubeListBuilder.m_171558_().m_171481_(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f), PartPose.f_171404_);
        partRoot.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171514_(14, 32).m_171481_(-1.0f, -2.0f, -2.0f, 3.0f, 12.0f, 4.0f), PartPose.m_171419_(5.0f, 2.0f, 0.0f));
        partRoot.m_171599_("left_leg", CubeListBuilder.m_171558_().m_171514_(16, 48).m_171481_(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f), PartPose.m_171419_(1.9f, 12.0f, 0.0f));
        partRoot.m_171599_("right_leg", CubeListBuilder.m_171558_().m_171514_(0, 48).m_171481_(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f), PartPose.m_171419_(-1.9f, 12.0f, 0.0f));
        partRoot.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(0, 32).m_171481_(-2.0f, -2.0f, -2.0f, 3.0f, 12.0f, 4.0f), PartPose.m_171419_(-5.0f, 2.0f, 0.0f));
        final PartDefinition hat = partRoot.m_171599_("hat", CubeListBuilder.m_171558_().m_171481_(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f), PartPose.f_171404_);
        hat.m_171599_("crown_front", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171481_(-5.0f, -4.0f, 0.0f, 10.0f, 4.0f, 0.0f), PartPose.m_171423_(0.0f, -6.0f, -4.0f, 0.3926991f, 0.0f, 0.0f));
        hat.m_171599_("crown_right", CubeListBuilder.m_171558_().m_171514_(24, 4).m_171481_(-5.0f, -4.0f, 0.0f, 10.0f, 4.0f, 0.0f), PartPose.m_171423_(-4.0f, -6.0f, 0.0f, 0.3926991f, 1.5707964f, 0.0f));
        hat.m_171599_("crown_left", CubeListBuilder.m_171558_().m_171514_(44, 4).m_171481_(-5.0f, -4.0f, 0.0f, 10.0f, 4.0f, 0.0f), PartPose.m_171423_(4.0f, -6.0f, 0.0f, -0.3926991f, 1.5707964f, 0.0f));
        hat.m_171599_("crown_back", CubeListBuilder.m_171558_().m_171514_(44, 0).m_171481_(-5.0f, -4.0f, 0.0f, 10.0f, 4.0f, 0.0f), PartPose.m_171423_(0.0f, -6.0f, 4.0f, -0.3926991f, 0.0f, 0.0f));
        return LayerDefinition.m_171565_(mesh, 64, 64);
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
                f_102811_4.f_104203_ += 3.1415927f;
                final ModelPart f_102812_4 = this.f_102812_;
                f_102812_4.f_104203_ += 3.1415927f;
            }
        }
    }
}
