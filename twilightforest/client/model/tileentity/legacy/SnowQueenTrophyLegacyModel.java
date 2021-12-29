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

public class SnowQueenTrophyLegacyModel extends GenericTrophyModel
{
    public ModelPart head;
    
    public SnowQueenTrophyLegacyModel(final ModelPart root) {
        this.head = root.m_171324_("head");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = new MeshDefinition();
        final PartDefinition partRoot = mesh.m_171576_();
        final PartDefinition head = partRoot.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f), PartPose.m_171419_(0.0f, -4.0f, 0.0f));
        final PartDefinition crown = head.m_171599_("crown", CubeListBuilder.m_171558_(), PartPose.f_171404_);
        makeFrontCrown(crown, -1.0f, -4.0f, 10.0f, 0);
        makeFrontCrown(crown, 0.0f, 4.0f, -10.0f, 1);
        makeSideCrown(crown, -1.0f, -4.0f, 10.0f, 0);
        makeSideCrown(crown, 0.0f, 4.0f, -10.0f, 1);
        return LayerDefinition.m_171565_(mesh, 64, 32);
    }
    
    private static void makeSideCrown(final PartDefinition parent, final float spikeDepth, final float crownX, final float angle, final int iteration) {
        final PartDefinition crownSide = parent.m_171599_("crown_side_" + iteration, CubeListBuilder.m_171558_().m_171514_(28, 28).m_171481_(-3.5f, -0.5f, -0.5f, 7.0f, 1.0f, 1.0f), PartPose.m_171423_(crownX, -6.0f, 0.0f, 0.0f, 1.5707964f, 0.0f));
        crownSide.m_171599_("spike_4", CubeListBuilder.m_171558_().m_171514_(48, 27).m_171481_(-0.5f, -3.5f, spikeDepth, 1.0f, 4.0f, 1.0f), PartPose.m_171423_(0.0f, 0.0f, 0.0f, angle * 1.5f / 180.0f * 3.1415927f, 0.0f, 0.0f));
        crownSide.m_171599_("spike_3l", CubeListBuilder.m_171558_().m_171514_(52, 28).m_171481_(-0.5f, -2.5f, spikeDepth, 1.0f, 3.0f, 1.0f), PartPose.m_171423_(-2.5f, 0.0f, 0.0f, angle / 180.0f * 3.1415927f, 0.0f, -0.17453294f));
        crownSide.m_171599_("spike_3r", CubeListBuilder.m_171558_().m_171514_(52, 28).m_171481_(-0.5f, -2.5f, spikeDepth, 1.0f, 3.0f, 1.0f), PartPose.m_171423_(2.5f, 0.0f, 0.0f, angle / 180.0f * 3.1415927f, 0.0f, 0.17453294f));
    }
    
    private static void makeFrontCrown(final PartDefinition parent, final float spikeDepth, final float crownZ, final float angle, final int iteration) {
        final PartDefinition crownFront = parent.m_171599_("crown_front_" + iteration, CubeListBuilder.m_171558_().m_171514_(28, 30).m_171481_(-4.5f, -0.5f, -0.5f, 9.0f, 1.0f, 1.0f), PartPose.m_171419_(0.0f, -6.0f, crownZ));
        crownFront.m_171599_("spike_4", CubeListBuilder.m_171558_().m_171514_(48, 27).m_171481_(-0.5f, -3.5f, spikeDepth, 1.0f, 4.0f, 1.0f), PartPose.m_171423_(0.0f, 0.0f, 0.0f, angle * 1.5f / 180.0f * 3.1415927f, 0.0f, 0.0f));
        crownFront.m_171599_("spike_3l", CubeListBuilder.m_171558_().m_171514_(52, 28).m_171481_(-0.5f, -2.5f, spikeDepth, 1.0f, 3.0f, 1.0f), PartPose.m_171423_(-2.5f, 0.0f, 0.0f, angle / 180.0f * 3.1415927f, 0.0f, -0.17453279f));
        crownFront.m_171599_("spike_3r", CubeListBuilder.m_171558_().m_171514_(52, 28).m_171481_(-0.5f, -2.5f, spikeDepth, 1.0f, 3.0f, 1.0f), PartPose.m_171423_(2.5f, 0.0f, 0.0f, angle / 180.0f * 3.1415927f, 0.0f, 0.17453279f));
    }
    
    @Override
    public void setRotations(final float x, final float y, final float z) {
        this.head.f_104204_ = y * 0.017453292f;
        this.head.f_104203_ = x * 0.017453292f;
    }
    
    public void m_7695_(final PoseStack matrix, final VertexConsumer buffer, final int packedLight, final int packedOverlay, final float red, final float green, final float blue, final float alpha) {
        this.head.m_104306_(matrix, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
