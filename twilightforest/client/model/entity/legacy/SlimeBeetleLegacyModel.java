// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity.legacy;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import twilightforest.entity.monster.SlimeBeetle;
import net.minecraft.client.model.HierarchicalModel;

public class SlimeBeetleLegacyModel extends HierarchicalModel<SlimeBeetle>
{
    public ModelPart root;
    public ModelPart head;
    public ModelPart legFL;
    public ModelPart legML;
    public ModelPart legBL;
    public ModelPart legFR;
    public ModelPart legMR;
    public ModelPart legBR;
    public ModelPart slimeCube;
    public ModelPart tail1;
    public ModelPart tail2;
    public ModelPart slimeCenter;
    
    public SlimeBeetleLegacyModel(final ModelPart root) {
        this.root = root;
        this.head = root.m_171324_("head");
        this.legFL = root.m_171324_("front_left_leg");
        this.legFR = root.m_171324_("front_right_leg");
        this.legML = root.m_171324_("middle_left_leg");
        this.legMR = root.m_171324_("middle_right_leg");
        this.legBL = root.m_171324_("back_left_leg");
        this.legBR = root.m_171324_("back_right_leg");
        this.tail1 = root.m_171324_("tail1");
        this.tail2 = this.tail1.m_171324_("tail2");
        this.slimeCenter = this.tail2.m_171324_("slime_center");
        this.slimeCube = this.slimeCenter.m_171324_("slime_cube");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = new MeshDefinition();
        final PartDefinition base = mesh.m_171576_();
        final PartDefinition headpart = base.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-4.0f, -4.0f, -6.0f, 8.0f, 6.0f, 6.0f), PartPose.m_171419_(0.0f, 19.0f, -5.0f));
        headpart.m_171599_("left_antenna", CubeListBuilder.m_171558_().m_171514_(38, 4).m_171481_(0.0f, -0.5f, -0.5f, 12.0f, 1.0f, 1.0f), PartPose.m_171423_(1.0f, -3.0f, -5.0f, 0.0f, 1.047198f, -0.296706f));
        headpart.m_171599_("right_antenna", CubeListBuilder.m_171558_().m_171514_(38, 4).m_171481_(0.0f, -0.5f, -0.5f, 12.0f, 1.0f, 1.0f), PartPose.m_171423_(-1.0f, -3.0f, -5.0f, 0.0f, 2.094395f, 0.296706f));
        headpart.m_171599_("left_eye", CubeListBuilder.m_171558_().m_171514_(15, 12).m_171481_(-1.5f, -1.5f, -1.5f, 3.0f, 3.0f, 3.0f), PartPose.m_171419_(3.0f, -2.0f, -5.0f));
        headpart.m_171599_("right_eye", CubeListBuilder.m_171558_().m_171514_(15, 12).m_171481_(-1.5f, -1.5f, -1.5f, 3.0f, 3.0f, 3.0f), PartPose.m_171419_(-3.0f, -2.0f, -5.0f));
        headpart.m_171599_("mouth", CubeListBuilder.m_171558_().m_171514_(17, 12).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 1.0f), PartPose.m_171419_(0.0f, 1.0f, -6.0f));
        base.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(31, 6).m_171481_(-4.0f, -11.0f, -4.0f, 8.0f, 10.0f, 8.0f), PartPose.m_171423_(0.0f, 18.0f, 7.0f, 1.570796f, 0.0f, 0.0f));
        base.m_171599_("front_left_leg", CubeListBuilder.m_171558_().m_171514_(40, 0).m_171481_(-1.0f, -1.0f, -1.0f, 10.0f, 2.0f, 2.0f), PartPose.m_171423_(2.0f, 21.0f, -4.0f, 0.0f, 0.2792527f, 0.3490659f));
        base.m_171599_("front_right_leg", CubeListBuilder.m_171558_().m_171514_(40, 0).m_171481_(-9.0f, -1.0f, -1.0f, 10.0f, 2.0f, 2.0f).m_171480_(), PartPose.m_171423_(-2.0f, 21.0f, -4.0f, 0.0f, -0.2792527f, -0.3490659f));
        base.m_171599_("middle_left_leg", CubeListBuilder.m_171558_().m_171514_(40, 0).m_171481_(-1.0f, -1.0f, -1.0f, 10.0f, 2.0f, 2.0f), PartPose.m_171423_(2.0f, 21.0f, -1.0f, 0.0f, -0.2792527f, 0.3490659f));
        base.m_171599_("middle_right_leg", CubeListBuilder.m_171558_().m_171514_(40, 0).m_171481_(-9.0f, -1.0f, -1.0f, 10.0f, 2.0f, 2.0f).m_171480_(), PartPose.m_171423_(-2.0f, 21.0f, -1.0f, 0.0f, 0.2792527f, -0.3490659f));
        base.m_171599_("back_left_leg", CubeListBuilder.m_171558_().m_171514_(40, 0).m_171481_(-1.0f, -1.0f, -1.0f, 10.0f, 2.0f, 2.0f), PartPose.m_171423_(2.0f, 21.0f, 4.0f, 0.0f, -0.6981317f, 0.3490659f));
        base.m_171599_("back_right_leg", CubeListBuilder.m_171558_().m_171514_(40, 0).m_171481_(-9.0f, -1.0f, -1.0f, 10.0f, 2.0f, 2.0f).m_171480_(), PartPose.m_171423_(-2.0f, 21.0f, 4.0f, 0.0f, 0.6981317f, -0.3490659f));
        base.m_171599_("connector", CubeListBuilder.m_171558_().m_171514_(0, 12).m_171481_(-3.0f, -3.0f, -1.0f, 6.0f, 6.0f, 1.0f), PartPose.m_171419_(0.0f, 19.0f, -4.0f));
        final PartDefinition tail1part = base.m_171599_("tail1", CubeListBuilder.m_171558_().m_171514_(0, 20).m_171481_(-3.0f, -3.0f, -3.0f, 6.0f, 6.0f, 6.0f), PartPose.m_171419_(0.0f, 19.0f, 9.0f));
        final PartDefinition tail2part = tail1part.m_171599_("tail2", CubeListBuilder.m_171558_().m_171514_(0, 20).m_171481_(-3.0f, -6.0f, -3.0f, 6.0f, 6.0f, 6.0f), PartPose.m_171419_(0.0f, -3.0f, 2.0f));
        final PartDefinition center = tail2part.m_171599_("slime_center", CubeListBuilder.m_171558_().m_171514_(32, 24).m_171481_(-4.0f, -10.0f, -7.0f, 8.0f, 8.0f, 8.0f), PartPose.m_171419_(0.0f, -6.0f, 0.0f));
        center.m_171599_("slime_cube", CubeListBuilder.m_171558_().m_171514_(0, 40).m_171481_(-6.0f, -12.0f, -9.0f, 12.0f, 12.0f, 12.0f), PartPose.m_171419_(0.0f, 0.0f, 0.0f));
        return LayerDefinition.m_171565_(mesh, 64, 64);
    }
    
    public ModelPart m_142109_() {
        return this.root;
    }
    
    public void m_7695_(final PoseStack stack, final VertexConsumer builder, final int light, final int overlay, final float red, final float green, final float blue, final float alpha) {
        this.slimeCube.f_104207_ = false;
        this.m_142109_().m_104306_(stack, builder, light, overlay, red, green, blue, alpha);
    }
    
    public void renderTail(final PoseStack stack, final VertexConsumer builder, final int light, final int overlay, final float red, final float green, final float blue, final float alpha) {
        this.tail1.m_104306_(stack, builder, light, overlay, red, green, blue, alpha);
    }
    
    public void setupAnim(final SlimeBeetle entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.head.f_104204_ = netHeadYaw / 57.295776f;
        this.head.f_104203_ = headPitch / 57.295776f;
        final float legZ = 0.28559935f;
        this.legBR.f_104205_ = -legZ;
        this.legBL.f_104205_ = legZ;
        this.legMR.f_104205_ = -legZ * 0.74f;
        this.legML.f_104205_ = legZ * 0.74f;
        this.legFR.f_104205_ = -legZ;
        this.legFL.f_104205_ = legZ;
        final float var9 = -0.0f;
        final float var10 = 0.3926991f;
        this.legBR.f_104204_ = var10 * 2.0f + var9;
        this.legBL.f_104204_ = -var10 * 2.0f - var9;
        this.legMR.f_104204_ = var10 + var9;
        this.legML.f_104204_ = -var10 - var9;
        this.legFR.f_104204_ = -var10 * 2.0f + var9;
        this.legFL.f_104204_ = var10 * 2.0f - var9;
        final float var11 = -(Mth.m_14089_(limbSwing * 0.6662f * 2.0f + 0.0f) * 0.4f) * limbSwingAmount;
        final float var12 = -(Mth.m_14089_(limbSwing * 0.6662f * 2.0f + 3.1415927f) * 0.4f) * limbSwingAmount;
        final float var13 = -(Mth.m_14089_(limbSwing * 0.6662f * 2.0f + 4.712389f) * 0.4f) * limbSwingAmount;
        final float var14 = Math.abs(Mth.m_14031_(limbSwing * 0.6662f + 0.0f) * 0.4f) * limbSwingAmount;
        final float var15 = Math.abs(Mth.m_14031_(limbSwing * 0.6662f + 3.1415927f) * 0.4f) * limbSwingAmount;
        final float var16 = Math.abs(Mth.m_14031_(limbSwing * 0.6662f + 4.712389f) * 0.4f) * limbSwingAmount;
        final ModelPart legBR = this.legBR;
        legBR.f_104204_ += var11;
        final ModelPart legBL = this.legBL;
        legBL.f_104204_ += -var11;
        final ModelPart legMR = this.legMR;
        legMR.f_104204_ += var12;
        final ModelPart legML = this.legML;
        legML.f_104204_ += -var12;
        final ModelPart legFR = this.legFR;
        legFR.f_104204_ += var13;
        final ModelPart legFL = this.legFL;
        legFL.f_104204_ += -var13;
        final ModelPart legBR2 = this.legBR;
        legBR2.f_104205_ += var14;
        final ModelPart legBL2 = this.legBL;
        legBL2.f_104205_ += -var14;
        final ModelPart legMR2 = this.legMR;
        legMR2.f_104205_ += var15;
        final ModelPart legML2 = this.legML;
        legML2.f_104205_ += -var15;
        final ModelPart legFR2 = this.legFR;
        legFR2.f_104205_ += var16;
        final ModelPart legFL2 = this.legFL;
        legFL2.f_104205_ += -var16;
        this.tail1.f_104203_ = Mth.m_14089_(ageInTicks * 0.3335f) * 0.15f;
        this.tail2.f_104203_ = Mth.m_14089_(ageInTicks * 0.4445f) * 0.2f;
        this.slimeCenter.f_104203_ = Mth.m_14089_(ageInTicks * 0.5555f + 0.25f) * 0.25f;
    }
}
