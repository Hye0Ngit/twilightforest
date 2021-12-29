// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity.legacy;

import net.minecraft.world.entity.Entity;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.client.model.AnimationUtils;
import net.minecraft.util.Mth;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HumanoidModel;
import twilightforest.entity.monster.Redcap;

public class RedcapLegacyModel<T extends Redcap> extends HumanoidModel<T>
{
    public RedcapLegacyModel(final ModelPart root) {
        super(root);
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = HumanoidModel.m_170681_(CubeDeformation.f_171458_, 0.0f);
        final PartDefinition partRoot = mesh.m_171576_();
        final PartDefinition head = partRoot.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-3.5f, -5.0f, -4.0f, 7.0f, 7.0f, 7.0f), PartPose.m_171419_(0.0f, 4.0f, 0.0f));
        partRoot.m_171599_("hat", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171481_(-2.0f, -6.0f, -3.0f, 4.0f, 5.0f, 7.0f), PartPose.m_171419_(0.0f, 7.0f, 0.0f));
        head.m_171599_("right_ear", CubeListBuilder.m_171558_().m_171514_(48, 20).m_171481_(3.0f, -10.0f, -1.0f, 2.0f, 3.0f, 1.0f), PartPose.m_171419_(0.0f, 7.0f, 0.0f));
        head.m_171599_("left_ear", CubeListBuilder.m_171558_().m_171480_().m_171514_(48, 20).m_171481_(-5.0f, -10.0f, -1.0f, 2.0f, 3.0f, 1.0f), PartPose.m_171419_(0.0f, 7.0f, 0.0f));
        partRoot.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(12, 19).m_171481_(-4.0f, 6.0f, -2.0f, 8.0f, 9.0f, 4.0f), PartPose.f_171404_);
        partRoot.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(36, 17).m_171481_(-2.0f, -2.0f, -1.5f, 3.0f, 12.0f, 3.0f), PartPose.m_171419_(-5.0f, 8.0f, 0.0f));
        partRoot.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171514_(36, 17).m_171481_(-1.0f, -2.0f, -1.5f, 3.0f, 12.0f, 3.0f), PartPose.m_171419_(5.0f, 8.0f, 0.0f));
        partRoot.m_171599_("right_leg", CubeListBuilder.m_171558_().m_171514_(0, 20).m_171481_(-2.0f, 0.0f, -1.5f, 3.0f, 9.0f, 3.0f), PartPose.m_171419_(-2.0f, 15.0f, 0.0f));
        partRoot.m_171599_("left_leg", CubeListBuilder.m_171558_().m_171514_(0, 20).m_171481_(-2.0f, 0.0f, -1.5f, 3.0f, 9.0f, 3.0f), PartPose.m_171419_(3.0f, 15.0f, 0.0f));
        return LayerDefinition.m_171565_(mesh, 64, 32);
    }
    
    public void setupAnim(final T entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.f_102808_.f_104203_ = headPitch * 0.017453292f;
        this.f_102808_.f_104204_ = netHeadYaw * 0.017453292f;
        this.f_102810_.f_104204_ = 0.0f;
        this.f_102811_.f_104202_ = 0.0f;
        this.f_102811_.f_104200_ = -5.0f;
        this.f_102812_.f_104202_ = 0.0f;
        this.f_102812_.f_104200_ = 5.0f;
        final float f = 1.0f;
        this.f_102811_.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f + 3.1415927f) * 2.0f * limbSwingAmount * 0.5f / f;
        this.f_102812_.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f) * 2.0f * limbSwingAmount * 0.5f / f;
        this.f_102811_.f_104205_ = 0.0f;
        this.f_102812_.f_104205_ = 0.0f;
        this.f_102813_.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f) * 1.4f * limbSwingAmount / f;
        this.f_102814_.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount / f;
        this.f_102813_.f_104204_ = 0.0f;
        this.f_102814_.f_104204_ = 0.0f;
        this.f_102813_.f_104205_ = 0.0f;
        this.f_102814_.f_104205_ = 0.0f;
        this.f_102811_.f_104204_ = 0.0f;
        this.f_102812_.f_104204_ = 0.0f;
        if (this.f_102609_) {
            final ModelPart f_102811_ = this.f_102811_;
            f_102811_.f_104203_ -= 0.62831855f;
            final ModelPart f_102812_ = this.f_102812_;
            f_102812_.f_104203_ -= 0.62831855f;
            this.f_102813_.f_104203_ = -1.4137167f;
            this.f_102813_.f_104204_ = 0.31415927f;
            this.f_102813_.f_104205_ = 0.07853982f;
            this.f_102814_.f_104203_ = -1.4137167f;
            this.f_102814_.f_104204_ = -0.31415927f;
            this.f_102814_.f_104205_ = -0.07853982f;
        }
        AnimationUtils.m_102082_(this.f_102811_, this.f_102812_, ageInTicks);
        if (this.f_102818_ > 0.0f) {
            final float f2 = limbSwing % 26.0f;
            final HumanoidArm handside = this.m_102856_((LivingEntity)entity);
            final float f3 = (handside == HumanoidArm.RIGHT && this.f_102608_ > 0.0f) ? 0.0f : this.f_102818_;
            final float f4 = (handside == HumanoidArm.LEFT && this.f_102608_ > 0.0f) ? 0.0f : this.f_102818_;
            if (f2 < 14.0f) {
                this.f_102812_.f_104203_ = this.m_102835_(f4, this.f_102812_.f_104203_, 0.0f);
                this.f_102811_.f_104203_ = Mth.m_14179_(f3, this.f_102811_.f_104203_, 0.0f);
                this.f_102812_.f_104204_ = this.m_102835_(f4, this.f_102812_.f_104204_, 3.1415927f);
                this.f_102811_.f_104204_ = Mth.m_14179_(f3, this.f_102811_.f_104204_, 3.1415927f);
                this.f_102812_.f_104205_ = this.m_102835_(f4, this.f_102812_.f_104205_, 3.1415927f + 1.8707964f * this.getArmAngleSq(f2) / this.getArmAngleSq(14.0f));
                this.f_102811_.f_104205_ = Mth.m_14179_(f3, this.f_102811_.f_104205_, 3.1415927f - 1.8707964f * this.getArmAngleSq(f2) / this.getArmAngleSq(14.0f));
            }
            else if (f2 >= 14.0f && f2 < 22.0f) {
                final float f5 = (f2 - 14.0f) / 8.0f;
                this.f_102812_.f_104203_ = this.m_102835_(f4, this.f_102812_.f_104203_, 1.5707964f * f5);
                this.f_102811_.f_104203_ = Mth.m_14179_(f3, this.f_102811_.f_104203_, 1.5707964f * f5);
                this.f_102812_.f_104204_ = this.m_102835_(f4, this.f_102812_.f_104204_, 3.1415927f);
                this.f_102811_.f_104204_ = Mth.m_14179_(f3, this.f_102811_.f_104204_, 3.1415927f);
                this.f_102812_.f_104205_ = this.m_102835_(f4, this.f_102812_.f_104205_, 5.012389f - 1.8707964f * f5);
                this.f_102811_.f_104205_ = Mth.m_14179_(f3, this.f_102811_.f_104205_, 1.2707963f + 1.8707964f * f5);
            }
            else if (f2 >= 22.0f && f2 < 26.0f) {
                final float f6 = (f2 - 22.0f) / 4.0f;
                this.f_102812_.f_104203_ = this.m_102835_(f4, this.f_102812_.f_104203_, 1.5707964f - 1.5707964f * f6);
                this.f_102811_.f_104203_ = Mth.m_14179_(f3, this.f_102811_.f_104203_, 1.5707964f - 1.5707964f * f6);
                this.f_102812_.f_104204_ = this.m_102835_(f4, this.f_102812_.f_104204_, 3.1415927f);
                this.f_102811_.f_104204_ = Mth.m_14179_(f3, this.f_102811_.f_104204_, 3.1415927f);
                this.f_102812_.f_104205_ = this.m_102835_(f4, this.f_102812_.f_104205_, 3.1415927f);
                this.f_102811_.f_104205_ = Mth.m_14179_(f3, this.f_102811_.f_104205_, 3.1415927f);
            }
            this.f_102814_.f_104203_ = Mth.m_14179_(this.f_102818_, this.f_102814_.f_104203_, 0.3f * Mth.m_14089_(limbSwing * 0.33333334f + 3.1415927f));
            this.f_102813_.f_104203_ = Mth.m_14179_(this.f_102818_, this.f_102813_.f_104203_, 0.3f * Mth.m_14089_(limbSwing * 0.33333334f));
        }
        this.m_7884_((LivingEntity)entity, ageInTicks);
        this.f_102809_.m_104315_(this.f_102808_);
    }
    
    public void m_7695_(final PoseStack matrixStack, final VertexConsumer buffer, final int packedLight, final int packedOverlay, final float red, final float green, final float blue, final float alpha) {
        if (this.f_102609_) {
            matrixStack.m_85837_(0.0, 0.25, 0.0);
        }
        this.f_102808_.m_104301_(matrixStack, buffer, packedLight, packedOverlay);
        this.f_102809_.m_104301_(matrixStack, buffer, packedLight, packedOverlay);
        this.f_102810_.m_104301_(matrixStack, buffer, packedLight, packedOverlay);
        this.f_102811_.m_104301_(matrixStack, buffer, packedLight, packedOverlay);
        this.f_102812_.m_104301_(matrixStack, buffer, packedLight, packedOverlay);
        this.f_102813_.m_104301_(matrixStack, buffer, packedLight, packedOverlay);
        this.f_102814_.m_104301_(matrixStack, buffer, packedLight, packedOverlay);
    }
    
    private float getArmAngleSq(final float limbSwing) {
        return -65.0f * limbSwing + limbSwing * limbSwing;
    }
}
