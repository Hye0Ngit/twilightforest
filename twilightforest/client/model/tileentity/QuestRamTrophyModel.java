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

public class QuestRamTrophyModel extends GenericTrophyModel
{
    public ModelPart horns;
    public ModelPart head;
    
    public QuestRamTrophyModel(final ModelPart part) {
        this.head = part.m_171324_("head");
        this.horns = this.head.m_171324_("horns");
    }
    
    public static LayerDefinition createHead() {
        final MeshDefinition meshdefinition = new MeshDefinition();
        final PartDefinition partdefinition = meshdefinition.m_171576_();
        final PartDefinition head = partdefinition.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(74, 70).m_171481_(-6.0f, -4.0f, -10.0f, 12.0f, 8.0f, 15.0f).m_171514_(42, 71).m_171481_(-6.0f, -7.0f, -6.0f, 12.0f, 3.0f, 11.0f), PartPose.m_171419_(0.0f, -4.0f, 0.0f));
        head.m_171599_("horns", CubeListBuilder.m_171558_().m_171514_(64, 0).m_171481_(-9.0f, -6.0f, -1.0f, 4.0f, 10.0f, 10.0f).m_171514_(48, 0).m_171481_(-13.0f, -6.0f, 5.0f, 4.0f, 4.0f, 4.0f).m_171514_(92, 0).m_171481_(5.0f, -6.0f, -1.0f, 4.0f, 10.0f, 10.0f).m_171514_(110, 0).m_171481_(9.0f, -6.0f, 5.0f, 4.0f, 4.0f, 4.0f), PartPose.m_171423_(0.0f, -4.0f, 0.0f, -0.43633232f, 0.0f, 0.0f));
        return LayerDefinition.m_171565_(meshdefinition, 128, 128);
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
