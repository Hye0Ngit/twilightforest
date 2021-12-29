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

public class NagaTrophyModel extends GenericTrophyModel
{
    public ModelPart head;
    public ModelPart tongue;
    
    public NagaTrophyModel(final ModelPart part) {
        this.head = part.m_171324_("head");
        this.tongue = this.head.m_171324_("tongue");
    }
    
    public static LayerDefinition createHead() {
        final MeshDefinition meshdefinition = new MeshDefinition();
        final PartDefinition partdefinition = meshdefinition.m_171576_();
        final PartDefinition head = partdefinition.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-8.0f, -16.0f, -8.0f, 16.0f, 16.0f, 16.0f), PartPose.m_171419_(0.0f, -4.0f, 0.0f));
        head.m_171599_("tongue", CubeListBuilder.m_171558_().m_171514_(42, 0).m_171481_(-3.0f, -3.0f, -14.0f, 6.0f, 0.0f, 6.0f), PartPose.f_171404_);
        return LayerDefinition.m_171565_(meshdefinition, 64, 32);
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
