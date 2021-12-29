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

public class QuestRamTrophyLegacyModel extends GenericTrophyModel
{
    public ModelPart head;
    
    public QuestRamTrophyLegacyModel(final ModelPart root) {
        this.head = root.m_171324_("head");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = new MeshDefinition();
        final PartDefinition partRoot = mesh.m_171576_();
        final PartDefinition head = partRoot.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 70).m_171481_(-6.0f, -4.5f, -7.0f, 12.0f, 9.0f, 15.0f).m_171514_(0, 94).m_171481_(5.0f, -9.0f, 1.0f, 4.0f, 4.0f, 6.0f).m_171514_(20, 96).m_171481_(7.0f, -8.0f, 6.0f, 3.0f, 4.0f, 4.0f).m_171514_(34, 95).m_171481_(8.0f, -6.0f, 8.0f, 3.0f, 6.0f, 3.0f).m_171514_(46, 98).m_171481_(9.5f, -2.0f, 6.0f, 3.0f, 3.0f, 3.0f).m_171514_(58, 95).m_171481_(11.0f, 0.0f, 1.0f, 3.0f, 3.0f, 6.0f).m_171514_(76, 95).m_171481_(12.0f, -4.0f, -1.0f, 3.0f, 6.0f, 3.0f).m_171514_(88, 97).m_171481_(13.0f, -6.0f, 1.0f, 3.0f, 3.0f, 4.0f).m_171514_(0, 94).m_171481_(-9.0f, -9.0f, 1.0f, 4.0f, 4.0f, 6.0f).m_171514_(20, 96).m_171481_(-10.0f, -8.0f, 6.0f, 3.0f, 4.0f, 4.0f).m_171514_(34, 95).m_171481_(-11.0f, -6.0f, 8.0f, 3.0f, 6.0f, 3.0f).m_171514_(46, 98).m_171481_(-12.5f, -2.0f, 6.0f, 3.0f, 3.0f, 3.0f).m_171514_(58, 95).m_171481_(-14.0f, 0.0f, 1.0f, 3.0f, 3.0f, 6.0f).m_171514_(76, 95).m_171481_(-15.0f, -4.0f, -1.0f, 3.0f, 6.0f, 3.0f).m_171514_(88, 97).m_171481_(-16.0f, -6.0f, 1.0f, 3.0f, 3.0f, 4.0f), PartPose.m_171419_(0.0f, -4.0f, -0.0f));
        partRoot.m_171599_("neck", CubeListBuilder.m_171558_().m_171514_(66, 37).m_171481_(-5.5f, -8.0f, 0.0f, 11.0f, 14.0f, 12.0f), PartPose.m_171423_(0.0f, -8.0f, -7.0f, 0.2617994f, 0.0f, 0.0f));
        head.m_171599_("nose", CubeListBuilder.m_171558_().m_171514_(54, 73).m_171481_(-5.5f, -1.0f, -6.0f, 11.0f, 9.0f, 12.0f), PartPose.m_171423_(0.0f, -7.0f, -1.0f, 0.5235988f, 0.0f, 0.0f));
        return LayerDefinition.m_171565_(mesh, 128, 128);
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
