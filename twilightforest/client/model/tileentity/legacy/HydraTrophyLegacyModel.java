// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.tileentity.legacy;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import twilightforest.client.model.tileentity.GenericTrophyModel;

public class HydraTrophyLegacyModel extends GenericTrophyModel
{
    public ModelPart head;
    public ModelPart jaw;
    
    public HydraTrophyLegacyModel(final ModelPart root) {
        this.head = root.m_171324_("head");
        this.jaw = this.head.m_171324_("jaw");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = new MeshDefinition();
        final PartDefinition partRoot = mesh.m_171576_();
        final PartDefinition head = partRoot.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(272, 0).m_171481_(-16.0f, -14.0f, -32.0f, 32.0f, 24.0f, 32.0f).m_171514_(272, 56).m_171481_(-15.0f, -2.0f, -56.0f, 30.0f, 12.0f, 24.0f).m_171514_(272, 132).m_171481_(-15.0f, 10.0f, -20.0f, 30.0f, 8.0f, 16.0f).m_171514_(128, 200).m_171481_(-2.0f, -30.0f, -12.0f, 4.0f, 24.0f, 24.0f).m_171514_(272, 156).m_171481_(-12.0f, 10.0f, -49.0f, 2.0f, 5.0f, 2.0f).m_171514_(272, 156).m_171481_(10.0f, 10.0f, -49.0f, 2.0f, 5.0f, 2.0f).m_171514_(280, 156).m_171481_(-8.0f, 9.0f, -49.0f, 16.0f, 2.0f, 2.0f).m_171514_(280, 160).m_171481_(-10.0f, 9.0f, -45.0f, 2.0f, 2.0f, 16.0f).m_171514_(280, 160).m_171481_(8.0f, 9.0f, -45.0f, 2.0f, 2.0f, 16.0f), PartPose.f_171404_);
        head.m_171599_("jaw", CubeListBuilder.m_171558_().m_171514_(272, 92).m_171481_(-15.0f, 0.0f, -32.0f, 30.0f, 8.0f, 32.0f).m_171514_(272, 156).m_171481_(-10.0f, -5.0f, -29.0f, 2.0f, 5.0f, 2.0f).m_171514_(272, 156).m_171481_(8.0f, -5.0f, -29.0f, 2.0f, 5.0f, 2.0f).m_171514_(280, 156).m_171481_(-8.0f, -1.0f, -29.0f, 16.0f, 2.0f, 2.0f).m_171514_(280, 160).m_171481_(-10.0f, -1.0f, -25.0f, 2.0f, 2.0f, 16.0f).m_171514_(280, 160).m_171481_(8.0f, -1.0f, -25.0f, 2.0f, 2.0f, 16.0f), PartPose.m_171419_(0.0f, 10.0f, -20.0f));
        head.m_171599_("frill", CubeListBuilder.m_171558_().m_171514_(272, 200).m_171481_(-24.0f, -40.0f, 0.0f, 48.0f, 48.0f, 4.0f), PartPose.m_171423_(0.0f, 0.0f, -14.0f, -0.5235988f, 0.0f, 0.0f));
        return LayerDefinition.m_171565_(mesh, 512, 256);
    }
    
    @Override
    public void setRotations(final float x, final float y, final float z) {
        this.head.f_104204_ = y * 0.017453292f;
        this.head.f_104203_ = x * 0.017453292f;
    }
    
    @Override
    public void openMouthForTrophy(final float mouthOpen) {
        this.head.f_104204_ = 0.0f;
        this.head.f_104203_ = 0.0f;
        final ModelPart head = this.head;
        head.f_104203_ -= (float)(mouthOpen * 0.2617993877991494);
        this.jaw.f_104203_ = (float)(mouthOpen * 1.0471975511965976);
    }
    
    public void m_7695_(final PoseStack matrix, final VertexConsumer buffer, final int packedLight, final int packedOverlay, final float red, final float green, final float blue, final float alpha) {
        this.head.m_104306_(matrix, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
