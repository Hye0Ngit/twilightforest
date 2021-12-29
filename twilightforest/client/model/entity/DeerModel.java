// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.world.entity.Entity;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import twilightforest.entity.passive.Deer;
import net.minecraft.client.model.QuadrupedModel;

@OnlyIn(Dist.CLIENT)
public class DeerModel extends QuadrupedModel<Deer>
{
    private final ModelPart neck;
    private final ModelPart realHead;
    
    public DeerModel(final ModelPart root) {
        super(root, false, 4.0f, 4.0f, 2.0f, 2.0f, 10);
        this.neck = root.m_171324_("neck");
        this.realHead = this.neck.m_171324_("head");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = QuadrupedModel.m_170864_(12, CubeDeformation.f_171458_);
        final PartDefinition partRoot = mesh.m_171576_();
        final PartDefinition neck = partRoot.m_171599_("neck", CubeListBuilder.m_171558_().m_171514_(22, 14).m_171481_(-1.5f, -8.0f, -2.0f, 3.0f, 9.0f, 4.0f), PartPose.m_171423_(0.0f, 8.0f, -5.0f, 0.43633232f, 0.0f, 0.0f));
        final PartDefinition head = neck.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(24, 2).m_171481_(-2.0f, -4.0f, -4.0f, 4.0f, 6.0f, 6.0f).m_171514_(52, 0).m_171481_(-1.5f, -1.0f, -7.0f, 3.0f, 3.0f, 3.0f), PartPose.m_171423_(0.0f, -9.0f, 0.0f, -0.43633232f, 0.0f, 0.0f));
        head.m_171599_("right_antler", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171481_(0.0f, -16.0f, -8.0f, 0.0f, 16.0f, 16.0f), PartPose.m_171423_(-1.0f, -4.0f, 0.0f, 0.0f, -0.3926991f, -0.3926991f));
        head.m_171599_("left_antler", CubeListBuilder.m_171558_().m_171514_(32, 16).m_171481_(0.0f, -16.0f, -8.0f, 0.0f, 16.0f, 16.0f), PartPose.m_171423_(1.0f, -4.0f, 0.0f, 0.0f, 0.3926991f, 0.3926991f));
        partRoot.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(36, 6).m_171481_(-3.0f, -14.0f, -2.0f, 6.0f, 18.0f, 8.0f), PartPose.m_171423_(0.0f, 10.0f, 7.0f, 1.5707964f, 0.0f, 0.0f));
        partRoot.m_171599_("left_hind_leg", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171481_(-1.0f, 0.0f, -1.5f, 2.0f, 12.0f, 3.0f), PartPose.m_171419_(-2.0f, 12.0f, 9.5f));
        partRoot.m_171599_("right_hind_leg", CubeListBuilder.m_171558_().m_171514_(10, 15).m_171481_(-1.0f, 0.0f, -1.5f, 2.0f, 12.0f, 3.0f), PartPose.m_171419_(2.0f, 12.0f, 9.5f));
        partRoot.m_171599_("left_front_leg", CubeListBuilder.m_171558_().m_171481_(-1.0f, 0.0f, -1.5f, 2.0f, 12.0f, 3.0f), PartPose.m_171419_(-2.0f, 12.0f, -4.5f));
        partRoot.m_171599_("right_front_leg", CubeListBuilder.m_171558_().m_171514_(10, 0).m_171481_(-1.0f, 0.0f, -1.5f, 2.0f, 12.0f, 3.0f), PartPose.m_171419_(2.0f, 12.0f, -4.5f));
        return LayerDefinition.m_171565_(mesh, 64, 48);
    }
    
    protected Iterable<ModelPart> m_5607_() {
        return (Iterable<ModelPart>)ImmutableList.of((Object)this.neck);
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
    
    public void setupAnim(final Deer p_103509_, final float p_103510_, final float p_103511_, final float p_103512_, final float p_103513_, final float p_103514_) {
        super.m_6973_((Entity)p_103509_, p_103510_, p_103511_, p_103512_, p_103513_, p_103514_);
        this.realHead.f_104203_ = this.f_103492_.f_104203_;
        this.realHead.f_104204_ = this.f_103492_.f_104204_;
    }
}
