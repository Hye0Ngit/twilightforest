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

public class MinoshroomTrophyLegacyModel extends GenericTrophyModel
{
    public ModelPart head;
    
    public MinoshroomTrophyLegacyModel(final ModelPart part) {
        this.head = part.m_171324_("head");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = new MeshDefinition();
        final PartDefinition partRoot = mesh.m_171576_();
        final PartDefinition head = partRoot.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(96, 16).m_171481_(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f), PartPose.m_171419_(0.0f, -6.0f, -9.0f));
        partRoot.m_171599_("hat", CubeListBuilder.m_171558_(), PartPose.f_171404_);
        head.m_171599_("snout", CubeListBuilder.m_171558_().m_171514_(105, 28).m_171481_(-2.0f, -1.0f, -1.0f, 4.0f, 3.0f, 1.0f), PartPose.m_171419_(0.0f, -2.0f, -4.0f));
        final PartDefinition rightHorn = head.m_171599_("right_horn_1", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-5.5f, -1.5f, -1.5f, 5.0f, 3.0f, 3.0f), PartPose.m_171423_(-2.5f, -6.5f, 0.0f, 0.0f, -0.43633235f, 0.17453294f));
        rightHorn.m_171599_("right_horn_2", CubeListBuilder.m_171558_().m_171514_(16, 0).m_171481_(-3.5f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f), PartPose.m_171423_(-4.5f, 0.0f, 0.0f, 0.0f, -0.2617994f, 0.7853982f));
        final PartDefinition leftHorn = head.m_171599_("left_horn_1", CubeListBuilder.m_171558_().m_171480_().m_171514_(0, 0).m_171481_(0.5f, -1.5f, -1.5f, 5.0f, 3.0f, 3.0f), PartPose.m_171423_(2.5f, -6.5f, 0.0f, 0.0f, 0.43633235f, -0.17453294f));
        leftHorn.m_171599_("left_horn_2", CubeListBuilder.m_171558_().m_171514_(16, 0).m_171481_(0.5f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f), PartPose.m_171423_(4.5f, 0.0f, 0.0f, 0.0f, 0.2617994f, -0.7853982f));
        return LayerDefinition.m_171565_(mesh, 128, 32);
    }
    
    @Override
    public void setRotations(final float x, final float y, final float z) {
        this.head.f_104204_ = y * 0.017453292f;
        this.head.f_104203_ = x * 0.017453292f;
    }
    
    public void m_7695_(final PoseStack matrix, final VertexConsumer buffer, final int packedLight, final int packedOverlay, final float red, final float green, final float blue, final float alpha) {
        matrix.m_85837_(0.0, 0.25, 0.0);
        this.head.m_104306_(matrix, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
