// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.tileentity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;

public class AlphaYetiTrophyModel extends GenericTrophyModel
{
    public final ModelPart main;
    public final ModelPart leftHorn1;
    public final ModelPart leftHorn1Top;
    public final ModelPart leftHorn2;
    public final ModelPart leftHorn2Top;
    public final ModelPart leftHorn3;
    public final ModelPart leftHorn3Top;
    public final ModelPart rightHorn1;
    public final ModelPart rightHorn1Top;
    public final ModelPart rightHorn2;
    public final ModelPart rightHorn2Top;
    public final ModelPart rightHorn3;
    public final ModelPart rightHorn3Top;
    
    public AlphaYetiTrophyModel(final ModelPart part) {
        this.main = part.m_171324_("main");
        this.leftHorn1 = this.main.m_171324_("left_horn_1");
        this.leftHorn1Top = this.leftHorn1.m_171324_("left_horn_1_top");
        this.leftHorn2 = this.main.m_171324_("left_horn_2");
        this.leftHorn2Top = this.leftHorn2.m_171324_("left_horn_2_top");
        this.leftHorn3 = this.main.m_171324_("left_horn_3");
        this.leftHorn3Top = this.leftHorn3.m_171324_("left_horn_3_top");
        this.rightHorn1 = this.main.m_171324_("right_horn_1");
        this.rightHorn1Top = this.rightHorn1.m_171324_("right_horn_1_top");
        this.rightHorn2 = this.main.m_171324_("right_horn_2");
        this.rightHorn2Top = this.rightHorn2.m_171324_("right_horn_2_top");
        this.rightHorn3 = this.main.m_171324_("right_horn_3");
        this.rightHorn3Top = this.rightHorn3.m_171324_("right_horn_3_top");
    }
    
    public static LayerDefinition createHead() {
        final MeshDefinition meshdefinition = new MeshDefinition();
        final PartDefinition partdefinition = meshdefinition.m_171576_();
        final PartDefinition main = partdefinition.m_171599_("main", CubeListBuilder.m_171558_().m_171514_(80, 0).m_171481_(-24.0f, -24.0f, -18.0f, 48.0f, 54.0f, 36.0f).m_171514_(64, 0).m_171481_(8.0f, -20.0f, -19.5f, 12.0f, 12.0f, 2.0f).m_171514_(121, 50).m_171481_(-17.0f, -8.0f, -19.5f, 34.0f, 29.0f, 2.0f).m_171514_(64, 0).m_171481_(-20.0f, -20.0f, -19.5f, 12.0f, 12.0f, 2.0f), PartPose.m_171419_(0.0f, -6.0f, 0.0f));
        main.m_171599_("left_horn_1", CubeListBuilder.m_171558_().m_171514_(0, 108).m_171481_(1.6981f, -10.9848f, -5.1743f, 10.0f, 10.0f, 10.0f), PartPose.m_171423_(22.0f, 6.0f, -1.0f, 0.0f, 0.5236f, 0.0873f)).m_171599_("left_horn_1_top", CubeListBuilder.m_171558_().m_171514_(40, 108).m_171481_(0.4505f, -7.9433f, -4.3855f, 18.0f, 8.0f, 8.0f), PartPose.m_171423_(11.0f, -2.0f, 0.0f, 0.0f, 0.3491f, 0.0873f));
        main.m_171599_("left_horn_2", CubeListBuilder.m_171558_().m_171514_(0, 108).m_171481_(0.8966f, -10.8637f, -4.4824f, 10.0f, 10.0f, 10.0f), PartPose.m_171423_(24.0f, -4.0f, -1.0f, 0.0f, 0.5236f, -0.2618f)).m_171599_("left_horn_2_top", CubeListBuilder.m_171558_().m_171514_(40, 108).m_171481_(2.5764f, -8.5f, -2.8753f, 18.0f, 8.0f, 8.0f), PartPose.m_171423_(9.0f, -1.0f, 0.0f, 0.0f, 0.3491f, -0.2618f));
        main.m_171599_("left_horn_3", CubeListBuilder.m_171558_().m_171514_(0, 108).m_171481_(1.9869f, -10.2766f, -3.8528f, 10.0f, 10.0f, 10.0f), PartPose.m_171423_(24.0f, -16.0f, -1.0f, 0.0f, 0.5236f, -0.6109f)).m_171599_("left_horn_3_top", CubeListBuilder.m_171558_().m_171514_(40, 108).m_171481_(4.9031f, -5.5443f, -1.7225f, 18.0f, 8.0f, 8.0f), PartPose.m_171423_(8.0f, -2.0f, 0.0f, 0.0f, 0.3491f, -0.6109f));
        main.m_171599_("right_horn_1", CubeListBuilder.m_171558_().m_171480_().m_171514_(0, 108).m_171481_(-11.6981f, -10.9848f, -5.1743f, 10.0f, 10.0f, 10.0f), PartPose.m_171423_(-22.0f, 6.0f, -1.0f, 0.0f, -0.5236f, -0.0873f)).m_171599_("right_horn_1_top", CubeListBuilder.m_171558_().m_171480_().m_171514_(40, 108).m_171481_(-18.4505f, -7.9433f, -4.3855f, 18.0f, 8.0f, 8.0f), PartPose.m_171423_(-11.0f, -2.0f, 0.0f, 0.0f, -0.3491f, -0.0873f));
        main.m_171599_("right_horn_2", CubeListBuilder.m_171558_().m_171480_().m_171514_(0, 108).m_171481_(-10.8966f, -10.8637f, -4.4824f, 10.0f, 10.0f, 10.0f), PartPose.m_171423_(-24.0f, -4.0f, -1.0f, 0.0f, -0.5236f, 0.2618f)).m_171599_("right_horn_2_top", CubeListBuilder.m_171558_().m_171480_().m_171514_(40, 108).m_171481_(-20.5764f, -8.5f, -2.8753f, 18.0f, 8.0f, 8.0f), PartPose.m_171423_(-9.0f, -1.0f, 0.0f, 0.0f, -0.3491f, 0.2618f));
        main.m_171599_("right_horn_3", CubeListBuilder.m_171558_().m_171480_().m_171514_(0, 108).m_171481_(-11.9869f, -10.2766f, -3.8528f, 10.0f, 10.0f, 10.0f), PartPose.m_171423_(-24.0f, -16.0f, -1.0f, 0.0f, -0.5236f, 0.6109f)).m_171599_("right_horn_3_top", CubeListBuilder.m_171558_().m_171480_().m_171514_(40, 108).m_171481_(-22.9031f, -5.5443f, -1.7225f, 18.0f, 8.0f, 8.0f), PartPose.m_171423_(-8.0f, -2.0f, 0.0f, 0.0f, -0.3491f, 0.6109f));
        return LayerDefinition.m_171565_(meshdefinition, 256, 128);
    }
    
    @Override
    public void setRotations(final float x, final float y, final float z) {
        this.main.f_104204_ = y * 0.017453292f;
        this.main.f_104203_ = x * 0.017453292f;
    }
    
    public void m_7695_(final PoseStack matrixStack, final VertexConsumer buffer, final int packedLight, final int packedOverlay, final float red, final float green, final float blue, final float alpha) {
        this.main.m_104301_(matrixStack, buffer, packedLight, packedOverlay);
    }
    
    public void setRotationAngle(final ModelPart modelRenderer, final float x, final float y, final float z) {
        modelRenderer.f_104203_ = x;
        modelRenderer.f_104204_ = y;
        modelRenderer.f_104205_ = z;
    }
}
