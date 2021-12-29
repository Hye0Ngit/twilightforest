// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity.legacy;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.util.Mth;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import twilightforest.entity.monster.UpperGoblinKnight;
import net.minecraft.client.model.HumanoidModel;

public class UpperGoblinKnightLegacyModel extends HumanoidModel<UpperGoblinKnight>
{
    public ModelPart breastplate;
    public ModelPart shield;
    public ModelPart spear;
    
    public UpperGoblinKnightLegacyModel(final ModelPart root) {
        super(root);
        this.breastplate = root.m_171324_("breastplate");
        this.shield = this.f_102812_.m_171324_("shield");
        this.spear = this.f_102811_.m_171324_("spear");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = new MeshDefinition();
        final PartDefinition partRoot = mesh.m_171576_();
        partRoot.m_171599_("head", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0f, 12.0f, 0.0f));
        final PartDefinition hat = partRoot.m_171599_("hat", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0f, 12.0f, 0.0f));
        final PartDefinition helm = hat.m_171599_("helmet", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-3.5f, -11.0f, -3.5f, 7.0f, 11.0f, 7.0f), PartPose.m_171423_(0.0f, 0.0f, 0.0f, 0.0f, 0.7853982f, 0.0f));
        final PartDefinition rightHorn = hat.m_171599_("right_horn_1", CubeListBuilder.m_171558_().m_171514_(28, 0).m_171481_(-6.0f, -1.5f, -1.5f, 7.0f, 3.0f, 3.0f), PartPose.m_171423_(-3.5f, -9.0f, 0.0f, 0.0f, 0.2617994f, 0.17453294f));
        rightHorn.m_171599_("right_horn_2", CubeListBuilder.m_171558_().m_171514_(28, 6).m_171481_(-3.0f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f), PartPose.m_171423_(-5.5f, 0.0f, 0.0f, 0.0f, 0.0f, 0.17453294f));
        final PartDefinition leftHorn = hat.m_171599_("left_horn_1", CubeListBuilder.m_171558_().m_171480_().m_171514_(28, 0).m_171481_(-1.0f, -1.5f, -1.5f, 7.0f, 3.0f, 3.0f), PartPose.m_171423_(3.5f, -9.0f, 0.0f, 0.0f, -0.2617994f, -0.17453294f));
        leftHorn.m_171599_("left_horn_2", CubeListBuilder.m_171558_().m_171480_().m_171514_(28, 6).m_171481_(0.0f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f), PartPose.m_171423_(5.5f, 0.0f, 0.0f, 0.0f, 0.0f, -0.17453294f));
        partRoot.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 18).m_171481_(-5.5f, 0.0f, -2.0f, 11.0f, 8.0f, 4.0f).m_171514_(30, 24).m_171481_(-6.5f, 0.0f, -2.0f, 1.0f, 4.0f, 4.0f).m_171514_(30, 24).m_171481_(5.5f, 0.0f, -2.0f, 1.0f, 4.0f, 4.0f), PartPose.m_171419_(0.0f, 12.0f, 0.0f));
        partRoot.m_171599_("breastplate", CubeListBuilder.m_171558_().m_171514_(64, 0).m_171481_(-6.5f, 0.0f, -3.0f, 13.0f, 12.0f, 6.0f), PartPose.m_171419_(0.0f, 11.5f, 0.0f));
        final PartDefinition rightArm = partRoot.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(44, 16).m_171481_(-4.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f), PartPose.m_171419_(-6.5f, 14.0f, 0.0f));
        rightArm.m_171599_("spear", CubeListBuilder.m_171558_().m_171514_(108, 0).m_171481_(-1.0f, -19.0f, -1.0f, 2.0f, 40.0f, 2.0f), PartPose.m_171423_(-2.0f, 8.5f, 0.0f, 1.5707964f, 0.0f, 0.0f));
        final PartDefinition leftArm = partRoot.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171514_(44, 16).m_171481_(0.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f), PartPose.m_171419_(6.5f, 14.0f, 0.0f));
        leftArm.m_171599_("shield", CubeListBuilder.m_171558_().m_171514_(63, 36).m_171481_(-6.0f, -6.0f, -2.0f, 12.0f, 20.0f, 2.0f), PartPose.m_171423_(0.0f, 12.0f, 0.0f, 1.5707964f, 0.0f, 0.0f));
        partRoot.m_171599_("right_leg", CubeListBuilder.m_171558_().m_171514_(30, 16).m_171481_(-1.5f, 0.0f, -2.0f, 3.0f, 4.0f, 4.0f), PartPose.m_171419_(-4.0f, 20.0f, 0.0f));
        partRoot.m_171599_("left_leg", CubeListBuilder.m_171558_().m_171514_(30, 16).m_171481_(-1.5f, 0.0f, -2.0f, 3.0f, 4.0f, 4.0f), PartPose.m_171419_(4.0f, 20.0f, 0.0f));
        return LayerDefinition.m_171565_(mesh, 128, 64);
    }
    
    public void m_7695_(final PoseStack stack, final VertexConsumer builder, final int light, final int overlay, final float red, final float green, final float blue, final float scale) {
        super.m_7695_(stack, builder, light, overlay, red, green, blue, scale);
        this.breastplate.m_104306_(stack, builder, light, overlay, red, green, blue, scale);
    }
    
    public void setupAnim(final UpperGoblinKnight entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        final boolean hasShield = entity.hasShield();
        this.f_102808_.f_104204_ = netHeadYaw / 57.295776f;
        this.f_102808_.f_104203_ = headPitch / 57.295776f;
        this.f_102808_.f_104205_ = 0.0f;
        this.f_102809_.f_104204_ = this.f_102808_.f_104204_;
        this.f_102809_.f_104203_ = this.f_102808_.f_104203_;
        this.f_102809_.f_104205_ = this.f_102808_.f_104205_;
        this.f_102811_.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f + 3.1415927f) * 2.0f * limbSwingAmount * 0.5f;
        final float leftConstraint = hasShield ? 0.2f : limbSwingAmount;
        this.f_102812_.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f) * 2.0f * leftConstraint * 0.5f;
        this.f_102811_.f_104205_ = 0.0f;
        this.f_102812_.f_104205_ = 0.0f;
        this.f_102813_.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.f_102814_.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.f_102813_.f_104204_ = 0.0f;
        this.f_102814_.f_104204_ = 0.0f;
        if (this.f_102609_) {
            final ModelPart f_102811_ = this.f_102811_;
            f_102811_.f_104203_ -= 0.62831855f;
            final ModelPart f_102812_ = this.f_102812_;
            f_102812_.f_104203_ -= 0.62831855f;
            this.f_102813_.f_104203_ = 0.0f;
            this.f_102814_.f_104203_ = 0.0f;
        }
        if (this.f_102815_ != HumanoidModel.ArmPose.EMPTY) {
            this.f_102812_.f_104203_ = this.f_102812_.f_104203_ * 0.5f - 0.31415927f;
        }
        this.f_102816_ = HumanoidModel.ArmPose.ITEM;
        if (this.f_102816_ != HumanoidModel.ArmPose.EMPTY) {
            this.f_102811_.f_104203_ = this.f_102811_.f_104203_ * 0.5f - 0.31415927f;
        }
        final ModelPart f_102811_2 = this.f_102811_;
        f_102811_2.f_104203_ -= (float)2.0734511513692637;
        if (entity.heavySpearTimer > 0) {
            final ModelPart f_102811_3 = this.f_102811_;
            f_102811_3.f_104203_ -= this.getArmRotationDuringSwing((float)(60 - entity.heavySpearTimer)) / 57.295776f;
        }
        this.f_102811_.f_104204_ = 0.0f;
        this.f_102812_.f_104204_ = 0.0f;
        final ModelPart f_102811_4 = this.f_102811_;
        f_102811_4.f_104205_ += Mth.m_14089_(ageInTicks * 0.09f) * 0.05f + 0.05f;
        final ModelPart f_102812_2 = this.f_102812_;
        f_102812_2.f_104205_ -= Mth.m_14089_(ageInTicks * 0.09f) * 0.05f + 0.05f;
        final ModelPart f_102811_5 = this.f_102811_;
        f_102811_5.f_104203_ += Mth.m_14031_(ageInTicks * 0.067f) * 0.05f;
        final ModelPart f_102812_3 = this.f_102812_;
        f_102812_3.f_104203_ -= Mth.m_14031_(ageInTicks * 0.067f) * 0.05f;
        this.f_102812_.f_104205_ = -this.f_102812_.f_104205_;
        this.shield.f_104203_ = (float)(6.283185307179586 - this.f_102812_.f_104203_);
        this.breastplate.f_104207_ = entity.hasArmor();
        this.shield.f_104207_ = entity.hasShield();
    }
    
    private float getArmRotationDuringSwing(final float attackTime) {
        if (attackTime <= 10.0f) {
            return attackTime;
        }
        if (attackTime > 10.0f && attackTime <= 30.0f) {
            return 10.0f;
        }
        if (attackTime > 30.0f && attackTime <= 33.0f) {
            return (attackTime - 30.0f) * -8.0f + 10.0f;
        }
        if (attackTime > 33.0f && attackTime <= 50.0f) {
            return -15.0f;
        }
        if (attackTime > 50.0f && attackTime <= 60.0f) {
            return (10.0f - (attackTime - 50.0f)) * -1.5f;
        }
        return 0.0f;
    }
}
