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

public class HydraTrophyModel extends GenericTrophyModel
{
    public ModelPart head;
    public ModelPart plate;
    public ModelPart mouth;
    
    public HydraTrophyModel(final ModelPart part) {
        this.head = part.m_171324_("head");
        this.plate = this.head.m_171324_("plate");
        this.mouth = this.head.m_171324_("mouth");
    }
    
    public static LayerDefinition createHead() {
        final MeshDefinition meshdefinition = new MeshDefinition();
        final PartDefinition partdefinition = meshdefinition.m_171576_();
        final PartDefinition head = partdefinition.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(260, 64).m_171481_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f).m_171514_(236, 128).m_171481_(-16.0f, -2.0f, -40.0f, 32.0f, 10.0f, 24.0f).m_171514_(356, 70).m_171481_(-12.0f, 8.0f, -36.0f, 24.0f, 6.0f, 20.0f), PartPose.f_171404_);
        head.m_171599_("plate", CubeListBuilder.m_171558_().m_171514_(388, 0).m_171481_(-24.0f, -48.0f, 0.0f, 48.0f, 48.0f, 6.0f).m_171514_(220, 0).m_171481_(-4.0f, -32.0f, -8.0f, 8.0f, 32.0f, 8.0f), PartPose.m_171430_(-0.7853982f, 0.0f, 0.0f));
        head.m_171599_("mouth", CubeListBuilder.m_171558_().m_171514_(240, 162).m_171481_(-15.0f, -2.0f, -24.0f, 30.0f, 8.0f, 24.0f), PartPose.m_171419_(0.0f, 10.0f, -14.0f));
        return LayerDefinition.m_171565_(meshdefinition, 512, 256);
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
        this.mouth.f_104203_ = (float)(mouthOpen * 1.0471975511965976);
    }
    
    public void m_7695_(final PoseStack matrix, final VertexConsumer buffer, final int packedLight, final int packedOverlay, final float red, final float green, final float blue, final float alpha) {
        this.head.m_104306_(matrix, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
