// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity.legacy;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import twilightforest.entity.passive.Deer;
import net.minecraft.client.model.QuadrupedModel;

public class DeerLegacyModel extends QuadrupedModel<Deer>
{
    public DeerLegacyModel(final ModelPart root) {
        super(root, false, 4.0f, 4.0f, 2.0f, 2.0f, 10);
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = QuadrupedModel.m_170864_(0, CubeDeformation.f_171458_);
        final PartDefinition partRoot = mesh.m_171576_();
        partRoot.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 5).m_171481_(-2.0f, -8.0f, -6.0f, 4.0f, 6.0f, 6.0f).m_171514_(52, 0).m_171481_(-1.5f, -5.0f, -9.0f, 3.0f, 3.0f, 3.0f).m_171514_(20, 0).m_171481_(-3.0f, -10.0f, -2.0f, 2.0f, 2.0f, 2.0f).m_171481_(-3.0f, -10.0f, -2.0f, 2.0f, 2.0f, 2.0f).m_171481_(-4.0f, -10.0f, -1.0f, 1.0f, 1.0f, 3.0f).m_171481_(-5.0f, -11.0f, 1.0f, 1.0f, 1.0f, 5.0f).m_171481_(-5.0f, -14.0f, 2.0f, 1.0f, 4.0f, 1.0f).m_171481_(-6.0f, -17.0f, 3.0f, 1.0f, 4.0f, 1.0f).m_171481_(-6.0f, -13.0f, 0.0f, 1.0f, 1.0f, 3.0f).m_171481_(-6.0f, -14.0f, -3.0f, 1.0f, 1.0f, 4.0f).m_171481_(-7.0f, -15.0f, -6.0f, 1.0f, 1.0f, 4.0f).m_171481_(-6.0f, -16.0f, -9.0f, 1.0f, 1.0f, 4.0f).m_171481_(-7.0f, -18.0f, -1.0f, 1.0f, 5.0f, 1.0f).m_171481_(-6.0f, -19.0f, -6.0f, 1.0f, 5.0f, 1.0f).m_171481_(1.0f, -10.0f, -2.0f, 2.0f, 2.0f, 2.0f).m_171481_(3.0f, -10.0f, -1.0f, 1.0f, 1.0f, 3.0f).m_171481_(4.0f, -11.0f, 1.0f, 1.0f, 1.0f, 5.0f).m_171481_(4.0f, -14.0f, 2.0f, 1.0f, 4.0f, 1.0f).m_171481_(5.0f, -17.0f, 3.0f, 1.0f, 4.0f, 1.0f).m_171481_(5.0f, -13.0f, 0.0f, 1.0f, 1.0f, 3.0f).m_171481_(5.0f, -14.0f, -3.0f, 1.0f, 1.0f, 4.0f).m_171481_(6.0f, -15.0f, -6.0f, 1.0f, 1.0f, 4.0f).m_171481_(5.0f, -16.0f, -9.0f, 1.0f, 1.0f, 4.0f).m_171481_(6.0f, -18.0f, -1.0f, 1.0f, 5.0f, 1.0f).m_171481_(5.0f, -19.0f, -6.0f, 1.0f, 5.0f, 1.0f), PartPose.m_171419_(0.0f, 4.0f, -7.0f));
        final PartDefinition body = partRoot.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(36, 6).m_171481_(-4.0f, -10.0f, -7.0f, 6.0f, 18.0f, 8.0f), PartPose.m_171423_(1.0f, 5.0f, 2.0f, 1.570796f, 0.0f, 0.0f));
        body.m_171599_("neck", CubeListBuilder.m_171558_().m_171514_(10, 19).m_171481_(-2.5f, -8.0f, -11.0f, 3.0f, 9.0f, 4.0f), PartPose.m_171423_(0.0f, 0.0f, 0.0f, 4.974188f, 0.0f, 0.0f));
        partRoot.m_171599_("right_front_leg", CubeListBuilder.m_171558_().m_171514_(0, 17).m_171481_(-3.0f, 0.0f, -2.0f, 2.0f, 12.0f, 3.0f), PartPose.m_171419_(0.0f, 12.0f, 9.0f));
        partRoot.m_171599_("left_front_leg", CubeListBuilder.m_171558_().m_171514_(0, 17).m_171481_(-1.0f, 0.0f, -2.0f, 2.0f, 12.0f, 3.0f), PartPose.m_171419_(2.0f, 12.0f, 9.0f));
        partRoot.m_171599_("right_hind_leg", CubeListBuilder.m_171558_().m_171514_(0, 17).m_171481_(-3.0f, 0.0f, -2.0f, 2.0f, 12.0f, 3.0f), PartPose.m_171419_(0.0f, 12.0f, -5.0f));
        partRoot.m_171599_("left_hind_leg", CubeListBuilder.m_171558_().m_171514_(0, 17).m_171481_(-1.0f, 0.0f, -2.0f, 2.0f, 12.0f, 3.0f), PartPose.m_171419_(2.0f, 12.0f, -5.0f));
        return LayerDefinition.m_171565_(mesh, 64, 32);
    }
    
    public void m_7695_(final PoseStack stack, final VertexConsumer builder, final int light, final int overlay, final float red, final float green, final float blue, final float scale) {
        if (this.f_102610_) {
            stack.m_85836_();
            stack.m_85841_(0.75f, 0.75f, 0.75f);
            stack.m_85837_(0.0, 0.949999988079071, 0.15000000596046448);
            this.m_5607_().forEach(modelRenderer -> modelRenderer.m_104306_(stack, builder, light, overlay, red, green, blue, scale));
            stack.m_85849_();
            stack.m_85836_();
            stack.m_85841_(0.5f, 0.5f, 0.5f);
            stack.m_85837_(0.0, 1.5, 0.0);
            this.m_5608_().forEach(modelRenderer -> modelRenderer.m_104306_(stack, builder, light, overlay, red, green, blue, scale));
            stack.m_85849_();
        }
        else {
            this.m_5607_().forEach(renderer -> renderer.m_104306_(stack, builder, light, overlay, red, green, blue, scale));
            this.m_5608_().forEach(renderer -> renderer.m_104306_(stack, builder, light, overlay, red, green, blue, scale));
        }
    }
}
