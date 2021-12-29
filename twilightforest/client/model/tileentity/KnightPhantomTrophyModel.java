// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.tileentity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;

public class KnightPhantomTrophyModel extends GenericTrophyModel
{
    public ModelPart head;
    public ModelPart helmet;
    
    public KnightPhantomTrophyModel(final ModelPart part) {
        this.head = part.m_171324_("head");
        this.helmet = part.m_171324_("helmet");
    }
    
    public static LayerDefinition createHead() {
        final MeshDefinition meshdefinition = new MeshDefinition();
        final PartDefinition partdefinition = meshdefinition.m_171576_();
        final CubeDeformation deformation = new CubeDeformation(0.25f);
        partdefinition.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f), PartPose.m_171419_(0.0f, -4.0f, 0.0f));
        final PartDefinition helm = partdefinition.m_171599_("helmet", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, deformation), PartPose.m_171419_(0.0f, -4.0f, 0.0f));
        final PartDefinition rightHorn = helm.m_171599_("right_horn_1", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171488_(-5.5f, -1.5f, -1.5f, 5.0f, 3.0f, 3.0f, deformation), PartPose.m_171423_(-4.0f, -6.5f, 0.0f, 0.0f, -0.43633235f, 0.7853982f));
        rightHorn.m_171599_("right_horn_2", CubeListBuilder.m_171558_().m_171514_(54, 16).m_171488_(-3.5f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, deformation), PartPose.m_171423_(-4.5f, 0.0f, 0.0f, 0.0f, -0.2617994f, 0.7853982f));
        final PartDefinition leftHorn = helm.m_171599_("left_horn_1", CubeListBuilder.m_171558_().m_171480_().m_171514_(24, 0).m_171488_(0.5f, -1.5f, -1.5f, 5.0f, 3.0f, 3.0f, deformation), PartPose.m_171423_(4.0f, -6.5f, 0.0f, 0.0f, 0.43633235f, -0.7853982f));
        leftHorn.m_171599_("left_horn_2", CubeListBuilder.m_171558_().m_171514_(54, 16).m_171488_(0.5f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, deformation), PartPose.m_171423_(4.5f, 0.0f, 0.0f, 0.0f, 0.2617994f, -0.7853982f));
        return LayerDefinition.m_171565_(meshdefinition, 64, 32);
    }
    
    @Override
    public void setRotations(final float x, final float y, final float z) {
        this.head.f_104204_ = y * 0.017453292f;
        this.head.f_104203_ = x * 0.017453292f;
        this.helmet.f_104203_ = this.head.f_104203_;
        this.helmet.f_104204_ = this.head.f_104204_;
    }
    
    public void m_7695_(final PoseStack matrix, final VertexConsumer buffer, final int packedLight, final int packedOverlay, final float red, final float green, final float blue, final float alpha) {
        this.head.m_104306_(matrix, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }
    
    @Override
    public void renderHelmToBuffer(final PoseStack matrix, final VertexConsumer buffer, final int packedLight, final int packedOverlay, final float red, final float green, final float blue, final float alpha) {
        this.helmet.m_104306_(matrix, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
