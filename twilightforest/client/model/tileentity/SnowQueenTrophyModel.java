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

public class SnowQueenTrophyModel extends GenericTrophyModel
{
    public ModelPart head;
    public ModelPart crownFront;
    public ModelPart crownBack;
    public ModelPart crownRight;
    public ModelPart crownLeft;
    
    public SnowQueenTrophyModel(final ModelPart part) {
        this.head = part.m_171324_("head");
        this.crownRight = this.head.m_171324_("crown_right");
        this.crownBack = this.head.m_171324_("crown_back");
        this.crownLeft = this.head.m_171324_("crown_left");
        this.crownFront = this.head.m_171324_("crown_front");
    }
    
    public static LayerDefinition createHead() {
        final MeshDefinition meshdefinition = new MeshDefinition();
        final PartDefinition partdefinition = meshdefinition.m_171576_();
        final PartDefinition head = partdefinition.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f), PartPose.f_171404_);
        head.m_171599_("crown_right", CubeListBuilder.m_171558_().m_171514_(24, 4).m_171481_(-5.0f, -4.0f, 0.0f, 10.0f, 4.0f, 0.0f), PartPose.m_171423_(-4.0f, -6.0f, 0.0f, 0.3926991f, 1.5707964f, 0.0f));
        head.m_171599_("crown_back", CubeListBuilder.m_171558_().m_171514_(44, 0).m_171481_(-5.0f, -4.0f, 0.0f, 10.0f, 4.0f, 0.0f), PartPose.m_171423_(0.0f, -6.0f, 4.0f, -0.3926991f, 0.0f, 0.0f));
        head.m_171599_("crown_left", CubeListBuilder.m_171558_().m_171514_(44, 4).m_171481_(-5.0f, -4.0f, 0.0f, 10.0f, 4.0f, 0.0f), PartPose.m_171423_(4.0f, -6.0f, 0.0f, -0.3926991f, 1.5707964f, 0.0f));
        head.m_171599_("crown_front", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171481_(-5.0f, -4.0f, 0.0f, 10.0f, 4.0f, 0.0f), PartPose.m_171423_(0.0f, -6.0f, -4.0f, 0.3926991f, 0.0f, 0.0f));
        return LayerDefinition.m_171565_(meshdefinition, 64, 64);
    }
    
    public void setRotateAngle(final ModelPart modelRenderer, final float x, final float y, final float z) {
        modelRenderer.f_104203_ = x;
        modelRenderer.f_104204_ = y;
        modelRenderer.f_104205_ = z;
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
