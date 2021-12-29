// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import java.util.function.Function;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.Model;

public class CicadaModel extends Model
{
    public ModelPart legs;
    public ModelPart fatbody;
    public ModelPart skinnybody;
    public ModelPart eye1;
    public ModelPart eye2;
    public ModelPart wings;
    
    public CicadaModel(final ModelPart root) {
        super((Function)RenderType::m_110458_);
        this.legs = root.m_171324_("legs");
        this.fatbody = root.m_171324_("fat_body");
        this.skinnybody = root.m_171324_("skinny_body");
        this.eye1 = root.m_171324_("eye_1");
        this.eye2 = root.m_171324_("eye_2");
        this.wings = root.m_171324_("wings");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition meshdefinition = new MeshDefinition();
        final PartDefinition partdefinition = meshdefinition.m_171576_();
        partdefinition.m_171599_("legs", CubeListBuilder.m_171558_().m_171514_(0, 21).m_171481_(-4.0f, 7.9f, -5.0f, 8.0f, 1.0f, 9.0f), PartPose.f_171404_);
        partdefinition.m_171599_("fat_body", CubeListBuilder.m_171558_().m_171514_(0, 11).m_171481_(-2.0f, 6.0f, -4.0f, 4.0f, 2.0f, 6.0f), PartPose.f_171404_);
        partdefinition.m_171599_("skinny_body", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-1.0f, 7.0f, -5.0f, 2.0f, 1.0f, 8.0f), PartPose.f_171404_);
        partdefinition.m_171599_("eye_1", CubeListBuilder.m_171558_().m_171514_(20, 15).m_171481_(1.0f, 5.0f, 2.0f, 2.0f, 2.0f, 2.0f), PartPose.f_171404_);
        partdefinition.m_171599_("eye_2", CubeListBuilder.m_171558_().m_171514_(20, 15).m_171481_(-3.0f, 5.0f, 2.0f, 2.0f, 2.0f, 2.0f), PartPose.f_171404_);
        partdefinition.m_171599_("wings", CubeListBuilder.m_171558_().m_171514_(20, 0).m_171481_(-4.0f, 5.0f, -7.0f, 8.0f, 1.0f, 8.0f), PartPose.f_171404_);
        return LayerDefinition.m_171565_(meshdefinition, 64, 32);
    }
    
    public void m_7695_(final PoseStack ms, final VertexConsumer buffer, final int light, final int overlay, final float r, final float g, final float b, final float a) {
        this.legs.m_104306_(ms, buffer, light, overlay, r, g, b, a);
        this.fatbody.m_104306_(ms, buffer, light, overlay, r, g, b, a);
        this.skinnybody.m_104306_(ms, buffer, light, overlay, r, g, b, a);
        this.eye1.m_104306_(ms, buffer, light, overlay, r, g, b, a);
        this.eye2.m_104306_(ms, buffer, light, overlay, r, g, b, a);
        this.wings.m_104306_(ms, buffer, light, overlay, r, g, b, a);
    }
}
