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

public class FireflyModel extends Model
{
    public ModelPart legs;
    public ModelPart fatbody;
    public ModelPart skinnybody;
    public ModelPart glow;
    
    public FireflyModel(final ModelPart root) {
        super((Function)RenderType::m_110458_);
        this.legs = root.m_171324_("legs");
        this.fatbody = root.m_171324_("fat_body");
        this.skinnybody = root.m_171324_("skinny_body");
        this.glow = root.m_171324_("glow");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition meshdefinition = new MeshDefinition();
        final PartDefinition partdefinition = meshdefinition.m_171576_();
        partdefinition.m_171599_("legs", CubeListBuilder.m_171558_().m_171514_(0, 21).m_171481_(-4.0f, 7.9f, -5.0f, 8.0f, 1.0f, 10.0f), PartPose.f_171404_);
        partdefinition.m_171599_("fat_body", CubeListBuilder.m_171558_().m_171514_(0, 11).m_171481_(-2.0f, 6.0f, -4.0f, 4.0f, 2.0f, 6.0f), PartPose.f_171404_);
        partdefinition.m_171599_("skinny_body", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-1.0f, 6.9f, -5.0f, 2.0f, 1.0f, 8.0f), PartPose.f_171404_);
        partdefinition.m_171599_("glow", CubeListBuilder.m_171558_().m_171514_(20, 0).m_171481_(-5.0f, 5.9f, -9.0f, 10.0f, 0.0f, 10.0f), PartPose.f_171404_);
        return LayerDefinition.m_171565_(meshdefinition, 64, 32);
    }
    
    public void m_7695_(final PoseStack stack, final VertexConsumer consumer, final int light, final int overlay, final float red, final float green, final float blue, final float alpha) {
        this.legs.m_104306_(stack, consumer, light, overlay, red, green, blue, alpha);
        this.fatbody.m_104306_(stack, consumer, light, overlay, red, green, blue, alpha);
        this.skinnybody.m_104306_(stack, consumer, light, overlay, red, green, blue, alpha);
    }
}
