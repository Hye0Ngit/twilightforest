// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity.legacy;

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
import twilightforest.entity.monster.Kobold;
import net.minecraft.client.model.HumanoidModel;

public class KoboldLegacyModel extends HumanoidModel<Kobold>
{
    ModelPart jaw;
    boolean isJumping;
    
    public KoboldLegacyModel(final ModelPart root) {
        super(root);
        this.isJumping = false;
        this.jaw = this.m_5585_().m_171324_("jaw");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = HumanoidModel.m_170681_(CubeDeformation.f_171458_, 0.0f);
        final PartDefinition partRoot = mesh.m_171576_();
        final PartDefinition head = partRoot.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-3.5f, -7.0f, -3.0f, 7.0f, 6.0f, 6.0f), PartPose.m_171419_(0.0f, 13.0f, 0.0f));
        partRoot.m_171599_("hat", CubeListBuilder.m_171558_(), PartPose.f_171404_);
        head.m_171599_("right_ear", CubeListBuilder.m_171558_().m_171514_(48, 20).m_171481_(0.0f, -4.0f, 0.0f, 4.0f, 4.0f, 1.0f), PartPose.m_171423_(3.5f, -3.0f, -1.0f, 0.0f, 0.2617994f, -0.3490659f));
        head.m_171599_("left_ear", CubeListBuilder.m_171558_().m_171514_(48, 25).m_171481_(-4.0f, -4.0f, 0.0f, 4.0f, 4.0f, 1.0f), PartPose.m_171423_(-3.5f, -3.0f, -1.0f, 0.0f, -0.2617994f, 0.3490659f));
        head.m_171599_("snout", CubeListBuilder.m_171558_().m_171514_(28, 0).m_171481_(-1.5f, -2.0f, -2.0f, 3.0f, 2.0f, 3.0f), PartPose.m_171419_(0.0f, -2.0f, -3.0f));
        head.m_171599_("jaw", CubeListBuilder.m_171558_().m_171514_(28, 5).m_171481_(-1.5f, 0.0f, -2.0f, 3.0f, 1.0f, 3.0f), PartPose.m_171423_(0.0f, -2.0f, -3.0f, 0.20944f, 0.0f, 0.0f));
        partRoot.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(12, 19).m_171481_(0.0f, 0.0f, 0.0f, 7.0f, 7.0f, 4.0f), PartPose.m_171419_(-3.5f, 12.0f, -2.0f));
        partRoot.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(36, 17).m_171481_(-3.0f, -1.0f, -1.5f, 3.0f, 7.0f, 3.0f), PartPose.m_171419_(-3.5f, 12.0f, 0.0f));
        partRoot.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171480_().m_171514_(36, 17).m_171481_(0.0f, -1.0f, -1.5f, 3.0f, 7.0f, 3.0f), PartPose.m_171419_(3.5f, 12.0f, 0.0f));
        partRoot.m_171599_("right_leg", CubeListBuilder.m_171558_().m_171514_(0, 20).m_171481_(-1.5f, 0.0f, -1.5f, 3.0f, 5.0f, 3.0f), PartPose.m_171419_(-2.0f, 19.0f, 0.0f));
        partRoot.m_171599_("left_leg", CubeListBuilder.m_171558_().m_171480_().m_171514_(0, 20).m_171481_(-1.5f, 0.0f, -1.5f, 3.0f, 5.0f, 3.0f), PartPose.m_171419_(2.0f, 19.0f, 0.0f));
        return LayerDefinition.m_171565_(mesh, 64, 32);
    }
    
    public void setupAnim(final Kobold entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.f_102808_.f_104204_ = netHeadYaw / 57.295776f;
        this.f_102808_.f_104203_ = headPitch / 57.295776f;
        this.f_102811_.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f + 3.1415927f) * 2.0f * limbSwingAmount * 0.5f;
        this.f_102812_.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f) * 2.0f * limbSwingAmount * 0.5f;
        this.f_102811_.f_104205_ = 0.0f;
        this.f_102812_.f_104205_ = 0.0f;
        this.f_102811_.f_104203_ = -0.47123894f;
        this.f_102812_.f_104203_ = -0.47123894f;
        this.f_102813_.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.f_102814_.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.f_102813_.f_104204_ = 0.0f;
        this.f_102814_.f_104204_ = 0.0f;
        final ModelPart f_102811_ = this.f_102811_;
        f_102811_.f_104205_ += Mth.m_14089_(ageInTicks * 0.19f) * 0.15f + 0.05f;
        final ModelPart f_102812_ = this.f_102812_;
        f_102812_.f_104205_ -= Mth.m_14089_(ageInTicks * 0.19f) * 0.15f + 0.05f;
        final ModelPart f_102811_2 = this.f_102811_;
        f_102811_2.f_104203_ += Mth.m_14031_(ageInTicks * 0.267f) * 0.25f;
        final ModelPart f_102812_2 = this.f_102812_;
        f_102812_2.f_104203_ -= Mth.m_14031_(ageInTicks * 0.267f) * 0.25f;
        if (this.isJumping) {
            this.jaw.f_104203_ = 1.44f;
        }
        else {
            this.jaw.f_104203_ = 0.20944f;
        }
    }
    
    public void prepareMobModel(final Kobold entity, final float limbSwing, final float limbSwingAmount, final float partialTicks) {
        this.isJumping = (entity.m_20184_().m_7098_() > 0.0);
    }
}
