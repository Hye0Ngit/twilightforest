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
import twilightforest.entity.monster.Troll;
import net.minecraft.client.model.HumanoidModel;

public class TrollLegacyModel extends HumanoidModel<Troll>
{
    public TrollLegacyModel(final ModelPart root) {
        super(root);
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = HumanoidModel.m_170681_(CubeDeformation.f_171458_, 0.0f);
        final PartDefinition partRoot = mesh.m_171576_();
        final PartDefinition head = partRoot.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-5.0f, -8.0f, -3.0f, 10.0f, 10.0f, 10.0f), PartPose.m_171419_(0.0f, -9.0f, -6.0f));
        partRoot.m_171599_("hat", CubeListBuilder.m_171558_(), PartPose.f_171404_);
        head.m_171599_("nose", CubeListBuilder.m_171558_().m_171514_(0, 21).m_171481_(-2.0f, -2.0f, -2.0f, 4.0f, 8.0f, 4.0f), PartPose.m_171419_(0.0f, -2.0f, -4.0f));
        partRoot.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(40, 0).m_171481_(-8.0f, 0.0f, -5.0f, 16.0f, 26.0f, 10.0f), PartPose.m_171419_(0.0f, -14.0f, 0.0f));
        partRoot.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(32, 36).m_171481_(-5.0f, -2.0f, -3.0f, 6.0f, 22.0f, 6.0f), PartPose.m_171419_(-9.0f, -9.0f, 0.0f));
        partRoot.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171480_().m_171514_(32, 36).m_171481_(-1.0f, -2.0f, -3.0f, 6.0f, 22.0f, 6.0f), PartPose.m_171419_(9.0f, -9.0f, 0.0f));
        partRoot.m_171599_("right_leg", CubeListBuilder.m_171558_().m_171514_(0, 44).m_171481_(-3.0f, 0.0f, -4.0f, 6.0f, 12.0f, 8.0f), PartPose.m_171419_(-5.0f, 12.0f, 0.0f));
        partRoot.m_171599_("left_leg", CubeListBuilder.m_171558_().m_171480_().m_171514_(0, 44).m_171481_(-3.0f, 0.0f, -4.0f, 6.0f, 12.0f, 8.0f), PartPose.m_171419_(5.0f, 12.0f, 0.0f));
        return LayerDefinition.m_171565_(mesh, 128, 64);
    }
    
    public void setupAnim(final Troll entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
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
        if (entity.m_20160_()) {
            final ModelPart f_102811_ = this.f_102811_;
            f_102811_.f_104203_ += (float)3.141592653589793;
            final ModelPart f_102812_ = this.f_102812_;
            f_102812_.f_104203_ += (float)3.141592653589793;
        }
        if (this.f_102815_ != HumanoidModel.ArmPose.EMPTY) {
            final ModelPart f_102811_2 = this.f_102811_;
            f_102811_2.f_104203_ += (float)3.141592653589793;
        }
        if (this.f_102816_ != HumanoidModel.ArmPose.EMPTY) {
            final ModelPart f_102812_2 = this.f_102812_;
            f_102812_2.f_104203_ += (float)3.141592653589793;
        }
        if (this.f_102608_ > 0.0f) {
            final float swing = 1.0f - this.f_102608_;
            final ModelPart f_102811_3 = this.f_102811_;
            f_102811_3.f_104203_ -= (float)(3.141592653589793 * swing);
            final ModelPart f_102812_3 = this.f_102812_;
            f_102812_3.f_104203_ -= (float)(3.141592653589793 * swing);
        }
        this.f_102811_.f_104204_ = 0.0f;
        this.f_102812_.f_104204_ = 0.0f;
        final ModelPart f_102811_4 = this.f_102811_;
        f_102811_4.f_104205_ += Mth.m_14089_(ageInTicks * 0.09f) * 0.05f + 0.05f;
        final ModelPart f_102812_4 = this.f_102812_;
        f_102812_4.f_104205_ -= Mth.m_14089_(ageInTicks * 0.09f) * 0.05f + 0.05f;
        final ModelPart f_102811_5 = this.f_102811_;
        f_102811_5.f_104203_ += Mth.m_14031_(ageInTicks * 0.067f) * 0.05f;
        final ModelPart f_102812_5 = this.f_102812_;
        f_102812_5.f_104203_ -= Mth.m_14031_(ageInTicks * 0.067f) * 0.05f;
    }
    
    public void prepareMobModel(final Troll entity, final float limbSwing, final float limbSwingAmount, final float partialTicks) {
        if (entity.m_5448_() != null) {
            final ModelPart f_102811_ = this.f_102811_;
            f_102811_.f_104203_ += (float)3.141592653589793;
            final ModelPart f_102812_ = this.f_102812_;
            f_102812_.f_104203_ += (float)3.141592653589793;
        }
    }
}
