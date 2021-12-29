// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.util.Mth;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import twilightforest.entity.monster.LowerGoblinKnight;
import net.minecraft.client.model.HumanoidModel;

@OnlyIn(Dist.CLIENT)
public class LowerGoblinKnightModel extends HumanoidModel<LowerGoblinKnight>
{
    public ModelPart tunic;
    
    public LowerGoblinKnightModel(final ModelPart root) {
        super(root);
        this.tunic = root.m_171324_("tunic");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = HumanoidModel.m_170681_(CubeDeformation.f_171458_, 0.0f);
        final PartDefinition partRoot = mesh.m_171576_();
        partRoot.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171481_(-2.5f, -5.0f, -3.5f, 5.0f, 5.0f, 5.0f), PartPose.m_171419_(0.0f, 8.0f, 1.0f));
        partRoot.m_171599_("hat", CubeListBuilder.m_171558_(), PartPose.f_171404_);
        partRoot.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(16, 48).m_171481_(-3.5f, 0.0f, -2.0f, 7.0f, 8.0f, 4.0f), PartPose.m_171419_(0.0f, 8.0f, 0.0f));
        partRoot.m_171599_("tunic", CubeListBuilder.m_171558_().m_171514_(64, 19).m_171481_(-6.0f, 0.0f, -3.0f, 12.0f, 9.0f, 6.0f), PartPose.m_171419_(0.0f, 7.5f, 0.0f));
        partRoot.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(48, 48).m_171481_(-2.0f, -2.0f, -1.5f, 2.0f, 8.0f, 3.0f), PartPose.m_171423_(-3.5f, 10.0f, 0.0f, 0.0f, 0.0f, 0.1f));
        partRoot.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171514_(38, 48).m_171481_(0.0f, -2.0f, -1.5f, 2.0f, 8.0f, 3.0f), PartPose.m_171423_(3.5f, 10.0f, 0.0f, 0.0f, 0.0f, -0.10000737f));
        partRoot.m_171599_("right_leg", CubeListBuilder.m_171558_().m_171514_(0, 40).m_171481_(-3.0f, 0.0f, -2.0f, 4.0f, 8.0f, 4.0f), PartPose.m_171419_(-2.5f, 16.0f, 0.0f));
        partRoot.m_171599_("left_leg", CubeListBuilder.m_171558_().m_171514_(0, 52).m_171481_(-1.0f, 0.0f, -2.0f, 4.0f, 8.0f, 4.0f), PartPose.m_171419_(2.5f, 16.0f, 0.0f));
        return LayerDefinition.m_171565_(mesh, 128, 64);
    }
    
    public void m_7695_(final PoseStack stack, final VertexConsumer builder, final int light, final int overlay, final float red, final float green, final float blue, final float scale) {
        super.m_7695_(stack, builder, light, overlay, red, green, blue, scale);
        this.tunic.m_104306_(stack, builder, light, overlay, red, green, blue, scale);
    }
    
    public void setupAnim(final LowerGoblinKnight entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
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
        this.f_102813_.f_104205_ = 0.0f;
        this.f_102814_.f_104205_ = 0.0f;
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
        if (entity.m_20160_()) {
            this.f_102808_.f_104204_ = 0.0f;
            this.f_102808_.f_104203_ = 0.0f;
            this.f_102809_.f_104204_ = this.f_102808_.f_104204_;
            this.f_102809_.f_104203_ = this.f_102808_.f_104203_;
        }
        if (this.f_102815_ != HumanoidModel.ArmPose.EMPTY) {
            this.f_102812_.f_104203_ = this.f_102812_.f_104203_ * 0.5f - 0.31415927f;
        }
        if (this.f_102816_ != HumanoidModel.ArmPose.EMPTY) {
            this.f_102811_.f_104203_ = this.f_102811_.f_104203_ * 0.5f - 0.31415927f;
        }
        this.f_102811_.f_104204_ = 0.0f;
        this.f_102812_.f_104204_ = 0.0f;
        final ModelPart f_102811_2 = this.f_102811_;
        f_102811_2.f_104205_ += Mth.m_14089_(ageInTicks * 0.09f) * 0.05f + 0.05f;
        final ModelPart f_102812_2 = this.f_102812_;
        f_102812_2.f_104205_ -= Mth.m_14089_(ageInTicks * 0.09f) * 0.05f + 0.05f;
        final ModelPart f_102811_3 = this.f_102811_;
        f_102811_3.f_104203_ += Mth.m_14031_(ageInTicks * 0.067f) * 0.05f;
        final ModelPart f_102812_3 = this.f_102812_;
        f_102812_3.f_104203_ -= Mth.m_14031_(ageInTicks * 0.067f) * 0.05f;
        this.tunic.f_104207_ = entity.hasArmor();
        if (entity.hasArmor()) {
            this.f_102812_.f_104203_ = 0.0f;
            this.f_102811_.f_104203_ = 0.0f;
            this.f_102812_.f_104205_ = 0.0f;
            this.f_102811_.f_104205_ = 0.0f;
        }
    }
}
