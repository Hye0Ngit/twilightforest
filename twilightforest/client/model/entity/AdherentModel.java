// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.util.Mth;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import twilightforest.entity.monster.Adherent;
import net.minecraft.client.model.HumanoidModel;

public class AdherentModel extends HumanoidModel<Adherent>
{
    public AdherentModel(final ModelPart root) {
        super(root);
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = HumanoidModel.m_170681_(CubeDeformation.f_171458_, 0.0f);
        final PartDefinition partRoot = mesh.m_171576_();
        partRoot.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f), PartPose.f_171404_);
        partRoot.m_171599_("hat", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f), PartPose.f_171404_);
        partRoot.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171481_(-4.0f, 0.0f, -2.0f, 8.0f, 24.0f, 4.0f), PartPose.f_171404_);
        final PartDefinition leftArm = partRoot.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171481_(-1.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f), PartPose.m_171419_(5.0f, 2.0f, 0.0f));
        leftArm.m_171599_("left_sleeve", CubeListBuilder.m_171558_().m_171514_(16, 16).m_171481_(-1.0f, -2.0f, 2.0f, 4.0f, 12.0f, 4.0f), PartPose.f_171404_);
        final PartDefinition rightArm = partRoot.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171481_(-3.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f), PartPose.m_171419_(-5.0f, 2.0f, 0.0f));
        rightArm.m_171599_("right_sleeve", CubeListBuilder.m_171558_().m_171514_(16, 16).m_171481_(-3.0f, -2.0f, 2.0f, 4.0f, 12.0f, 4.0f), PartPose.f_171404_);
        partRoot.m_171599_("left_leg", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f), PartPose.f_171404_);
        partRoot.m_171599_("right_leg", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f), PartPose.f_171404_);
        return LayerDefinition.m_171565_(mesh, 64, 32);
    }
    
    public void setupAnim(final Adherent entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.f_102808_.f_104204_ = netHeadYaw * 0.017453292f;
        this.f_102808_.f_104203_ = headPitch * 0.017453292f;
        this.f_102811_.f_104203_ = 0.0f;
        this.f_102812_.f_104203_ = 0.0f;
        this.f_102811_.f_104205_ = 0.0f;
        this.f_102812_.f_104205_ = 0.0f;
        final ModelPart f_102811_ = this.f_102811_;
        f_102811_.f_104205_ += Mth.m_14089_((ageInTicks + 10.0f) * 0.133f) * 0.3f + 0.3f;
        final ModelPart f_102812_ = this.f_102812_;
        f_102812_.f_104205_ -= Mth.m_14089_((ageInTicks + 10.0f) * 0.133f) * 0.3f + 0.3f;
        final ModelPart f_102811_2 = this.f_102811_;
        f_102811_2.f_104203_ += Mth.m_14031_(ageInTicks * 0.067f) * 0.05f;
        final ModelPart f_102812_2 = this.f_102812_;
        f_102812_2.f_104203_ -= Mth.m_14031_(ageInTicks * 0.067f) * 0.05f;
    }
}
