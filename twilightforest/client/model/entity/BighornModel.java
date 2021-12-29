// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.model.SheepModel;
import twilightforest.entity.passive.Bighorn;

@OnlyIn(Dist.CLIENT)
public class BighornModel<T extends Bighorn> extends SheepModel<T>
{
    public BighornModel(final ModelPart part) {
        super(part);
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = SheepModel.m_170864_(0, CubeDeformation.f_171458_);
        final PartDefinition partRoot = mesh.m_171576_();
        final PartDefinition head = partRoot.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(38, 0).m_171481_(-3.0f, -4.0f, -6.0f, 6.0f, 6.0f, 7.0f), PartPose.m_171419_(0.0f, 5.0f, -8.0f));
        head.m_171599_("right_horn", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-3.0f, -1.0f, -7.0f, 3.0f, 3.0f, 5.0f).m_171514_(0, 8).m_171481_(-4.0f, 2.0f, -9.0f, 3.0f, 2.0f, 5.0f).m_171514_(4, 15).m_171481_(-4.0f, 0.0f, -11.0f, 2.0f, 3.0f, 2.0f), PartPose.m_171423_(-2.0f, -3.0f, -1.0f, 0.0f, 0.3926991f, 0.21816616f));
        head.m_171599_("left_horn", CubeListBuilder.m_171558_().m_171514_(16, 0).m_171481_(0.0f, -1.0f, -7.0f, 3.0f, 3.0f, 5.0f).m_171514_(16, 8).m_171481_(1.0f, 2.0f, -9.0f, 3.0f, 2.0f, 5.0f).m_171514_(20, 15).m_171481_(2.0f, 0.0f, -11.0f, 2.0f, 3.0f, 2.0f), PartPose.m_171423_(2.0f, -3.0f, -1.0f, 0.0f, -0.3926991f, -0.21816616f));
        partRoot.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(34, 13).m_171481_(-4.5f, -14.0f, -3.0f, 9.0f, 16.0f, 6.0f), PartPose.m_171423_(0.0f, 10.0f, 6.0f, 1.5707964f, 0.0f, 0.0f));
        partRoot.m_171599_("right_hind_leg", CubeListBuilder.m_171558_().m_171514_(0, 48).m_171481_(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f), PartPose.m_171419_(-3.0f, 12.0f, 7.0f));
        partRoot.m_171599_("left_hind_leg", CubeListBuilder.m_171558_().m_171514_(16, 48).m_171481_(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f), PartPose.m_171419_(3.0f, 12.0f, 7.0f));
        partRoot.m_171599_("right_front_leg", CubeListBuilder.m_171558_().m_171514_(0, 32).m_171481_(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f), PartPose.m_171419_(-3.0f, 12.0f, -5.0f));
        partRoot.m_171599_("left_front_leg", CubeListBuilder.m_171558_().m_171514_(16, 32).m_171481_(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f), PartPose.m_171419_(3.0f, 12.0f, -5.0f));
        return LayerDefinition.m_171565_(mesh, 64, 64);
    }
    
    public void m_7695_(final PoseStack matrixStackIn, final VertexConsumer bufferIn, final int packedLightIn, final int packedOverlayIn, final float red, final float green, final float blue, final float alpha) {
        if (this.f_102610_) {
            matrixStackIn.m_85836_();
            matrixStackIn.m_85837_(0.0, 0.5, 0.25);
            ImmutableList.of((Object)this.f_103492_).forEach(modelRenderer -> modelRenderer.m_104306_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha));
            matrixStackIn.m_85849_();
            matrixStackIn.m_85836_();
            matrixStackIn.m_85841_(0.5f, 0.5f, 0.5f);
            matrixStackIn.m_85837_(0.0, 1.5, 0.0);
            ImmutableList.of((Object)this.f_170853_, (Object)this.f_170852_, (Object)this.f_103493_, (Object)this.f_170855_, (Object)this.f_170854_).forEach(modelRenderer -> modelRenderer.m_104306_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha));
            matrixStackIn.m_85849_();
        }
        else {
            ImmutableList.of((Object)this.f_170853_, (Object)this.f_170852_, (Object)this.f_103493_, (Object)this.f_170855_, (Object)this.f_170854_, (Object)this.f_103492_).forEach(modelRenderer -> modelRenderer.m_104306_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha));
        }
    }
}
