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

public class MinoshroomTrophyModel extends GenericTrophyModel
{
    public ModelPart head;
    
    public MinoshroomTrophyModel(final ModelPart part) {
        this.head = part.m_171324_("head");
    }
    
    public static LayerDefinition createHead() {
        final MeshDefinition meshdefinition = new MeshDefinition();
        final PartDefinition partdefinition = meshdefinition.m_171576_();
        partdefinition.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-4.0f, -9.0f, -4.0f, 8.0f, 8.0f, 8.0f).m_171514_(0, 16).m_171481_(-3.0f, -4.0f, -5.0f, 6.0f, 3.0f, 1.0f).m_171514_(32, 0).m_171481_(-8.0f, -8.0f, -1.0f, 4.0f, 2.0f, 3.0f).m_171514_(32, 5).m_171481_(-8.0f, -11.0f, -1.0f, 2.0f, 3.0f, 3.0f).m_171514_(46, 0).m_171481_(4.0f, -8.0f, -1.0f, 4.0f, 2.0f, 3.0f).m_171514_(46, 5).m_171481_(6.0f, -11.0f, -1.0f, 2.0f, 3.0f, 3.0f), PartPose.m_171419_(0.0f, -4.0f, 0.0f));
        return LayerDefinition.m_171565_(meshdefinition, 64, 64);
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
