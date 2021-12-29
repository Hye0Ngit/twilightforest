// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.util.Mth;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import twilightforest.entity.boss.AlphaYeti;
import net.minecraft.client.model.HumanoidModel;

public class AlphaYetiModel extends HumanoidModel<AlphaYeti>
{
    public AlphaYetiModel(final ModelPart root) {
        super(root);
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = HumanoidModel.m_170681_(CubeDeformation.f_171458_, 0.0f);
        final PartDefinition partRoot = mesh.m_171576_();
        partRoot.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-4.0f, -8.0f, -4.0f, 0.0f, 0.0f, 0.0f), PartPose.f_171404_);
        partRoot.m_171599_("hat", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171481_(-4.0f, -8.0f, -4.0f, 0.0f, 0.0f, 0.0f), PartPose.f_171404_);
        final PartDefinition body = partRoot.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(80, 0).m_171481_(-24.0f, -60.0f, -18.0f, 48.0f, 72.0f, 36.0f), PartPose.m_171419_(0.0f, -6.0f, 0.0f));
        body.m_171599_("mouth", CubeListBuilder.m_171558_().m_171514_(121, 50).m_171481_(-17.0f, -7.0f, -1.5f, 34.0f, 29.0f, 2.0f), PartPose.m_171419_(0.0f, -37.0f, -18.0f));
        body.m_171599_("right_eye", CubeListBuilder.m_171558_().m_171514_(64, 0).m_171481_(-6.0f, -6.0f, -1.5f, 12.0f, 12.0f, 2.0f), PartPose.m_171419_(-14.0f, -50.0f, -18.0f));
        body.m_171599_("left_eye", CubeListBuilder.m_171558_().m_171514_(64, 0).m_171481_(-6.0f, -6.0f, -1.5f, 12.0f, 12.0f, 2.0f), PartPose.m_171419_(14.0f, -50.0f, -18.0f));
        partRoot.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-15.0f, -6.0f, -8.0f, 16.0f, 48.0f, 16.0f), PartPose.m_171419_(-25.0f, -26.0f, 0.0f));
        partRoot.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171480_().m_171514_(0, 0).m_171481_(-1.0f, -6.0f, -8.0f, 16.0f, 48.0f, 16.0f), PartPose.m_171419_(25.0f, -26.0f, 0.0f));
        partRoot.m_171599_("right_leg", CubeListBuilder.m_171558_().m_171514_(0, 66).m_171481_(-10.0f, 0.0f, -10.0f, 20.0f, 20.0f, 20.0f), PartPose.m_171419_(-13.5f, 4.0f, 0.0f));
        partRoot.m_171599_("left_leg", CubeListBuilder.m_171558_().m_171480_().m_171514_(0, 66).m_171481_(-10.0f, 0.0f, -10.0f, 20.0f, 20.0f, 20.0f), PartPose.m_171419_(13.5f, 4.0f, 0.0f));
        addPairHorns(body, -58.0f, 35.0f, 1);
        addPairHorns(body, -46.0f, 15.0f, 2);
        addPairHorns(body, -36.0f, -5.0f, 3);
        return LayerDefinition.m_171565_(mesh, 256, 128);
    }
    
    private static void addPairHorns(final PartDefinition partdefinition, final float height, final float zangle, final int set) {
        final PartDefinition leftHorn = partdefinition.m_171599_("left_horn_" + set, CubeListBuilder.m_171558_().m_171514_(0, 108).m_171481_(-9.0f, -5.0f, -5.0f, 10.0f, 10.0f, 10.0f), PartPose.m_171423_(-24.0f, height, -8.0f, 0.0f, -0.5235988f, zangle / 57.295776f));
        leftHorn.m_171599_("left_horn_" + set + "_top", CubeListBuilder.m_171558_().m_171514_(40, 108).m_171481_(-14.0f, -4.0f, -4.0f, 18.0f, 8.0f, 8.0f), PartPose.m_171423_(-8.0f, 0.0f, 0.0f, 0.0f, -0.34906587f, zangle / 57.295776f));
        final PartDefinition rightHorn = partdefinition.m_171599_("right_horn_" + set, CubeListBuilder.m_171558_().m_171514_(0, 108).m_171481_(-1.0f, -5.0f, -5.0f, 10.0f, 10.0f, 10.0f), PartPose.m_171423_(24.0f, height, 0.0f, 0.0f, 0.5235988f, -zangle / 57.295776f));
        rightHorn.m_171599_("right_horn_" + set + "_top", CubeListBuilder.m_171558_().m_171514_(40, 108).m_171481_(-2.0f, -4.0f, -4.0f, 18.0f, 8.0f, 8.0f), PartPose.m_171423_(8.0f, 0.0f, 0.0f, 0.0f, 0.34906587f, -zangle / 57.295776f));
    }
    
    protected Iterable<ModelPart> m_5608_() {
        return (Iterable<ModelPart>)ImmutableList.of((Object)this.f_102810_, (Object)this.f_102811_, (Object)this.f_102812_, (Object)this.f_102813_, (Object)this.f_102814_);
    }
    
    public void setupAnim(final AlphaYeti entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.f_102808_.f_104204_ = netHeadYaw / 57.295776f;
        this.f_102808_.f_104203_ = headPitch / 57.295776f;
        this.f_102810_.f_104203_ = headPitch / 57.295776f;
        this.f_102813_.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.f_102814_.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.f_102813_.f_104204_ = 0.0f;
        this.f_102814_.f_104204_ = 0.0f;
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
        this.f_102810_.f_104201_ = -6.0f;
        this.f_102813_.f_104201_ = 4.0f;
        this.f_102814_.f_104201_ = 4.0f;
        if (entity.isTired()) {
            this.f_102811_.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f + 3.1415927f) * 2.0f * limbSwingAmount * 0.5f;
            this.f_102812_.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f) * 2.0f * limbSwingAmount * 0.5f;
            this.f_102811_.f_104205_ = 0.0f;
            this.f_102812_.f_104205_ = 0.0f;
            final ModelPart f_102811_4 = this.f_102811_;
            f_102811_4.f_104203_ -= 0.62831855f;
            final ModelPart f_102812_4 = this.f_102812_;
            f_102812_4.f_104203_ -= 0.62831855f;
            this.f_102813_.f_104203_ = -1.2566371f;
            this.f_102814_.f_104203_ = -1.2566371f;
            this.f_102813_.f_104204_ = 0.31415927f;
            this.f_102814_.f_104204_ = -0.31415927f;
            this.f_102810_.f_104201_ = 6.0f;
            this.f_102813_.f_104201_ = 12.0f;
            this.f_102814_.f_104201_ = 12.0f;
        }
        if (entity.isRampaging()) {
            this.f_102811_.f_104203_ = Mth.m_14089_(limbSwing * 0.66f + 3.1415927f) * 2.0f * limbSwingAmount * 0.5f;
            this.f_102812_.f_104203_ = Mth.m_14089_(limbSwing * 0.66f) * 2.0f * limbSwingAmount * 0.5f;
            final ModelPart f_102811_5 = this.f_102811_;
            f_102811_5.f_104204_ += Mth.m_14089_(limbSwing * 0.25f) * 0.5f + 0.5f;
            final ModelPart f_102812_5 = this.f_102812_;
            f_102812_5.f_104204_ -= Mth.m_14089_(limbSwing * 0.25f) * 0.5f + 0.5f;
            final ModelPart f_102811_6 = this.f_102811_;
            f_102811_6.f_104203_ += (float)3.9269908169872414;
            final ModelPart f_102812_6 = this.f_102812_;
            f_102812_6.f_104203_ += (float)3.9269908169872414;
            this.f_102811_.f_104205_ = 0.0f;
            this.f_102812_.f_104205_ = 0.0f;
        }
        if (entity.m_20160_()) {
            final ModelPart f_102811_7 = this.f_102811_;
            f_102811_7.f_104203_ += (float)3.141592653589793;
            final ModelPart f_102812_7 = this.f_102812_;
            f_102812_7.f_104203_ += (float)3.141592653589793;
        }
    }
}
