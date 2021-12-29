// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

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
import twilightforest.entity.monster.Minotaur;
import net.minecraft.client.model.HumanoidModel;

@OnlyIn(Dist.CLIENT)
public class MinotaurModel extends HumanoidModel<Minotaur>
{
    public MinotaurModel(final ModelPart root) {
        super(root);
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = HumanoidModel.m_170681_(CubeDeformation.f_171458_, 0.0f);
        final PartDefinition partRoot = mesh.m_171576_();
        partRoot.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-4.0f, -10.0f, -4.0f, 8.0f, 8.0f, 8.0f).m_171514_(25, 1).m_171481_(-3.0f, -5.0f, -5.0f, 6.0f, 3.0f, 1.0f).m_171514_(0, 16).m_171481_(-8.0f, -9.0f, -1.0f, 4.0f, 2.0f, 2.0f).m_171514_(0, 20).m_171481_(-8.0f, -11.0f, -1.0f, 2.0f, 2.0f, 2.0f).m_171514_(12, 16).m_171481_(4.0f, -9.0f, -1.0f, 4.0f, 2.0f, 2.0f).m_171514_(12, 20).m_171481_(6.0f, -11.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171419_(0.0f, -2.0f, 0.0f));
        partRoot.m_171599_("hat", CubeListBuilder.m_171558_(), PartPose.f_171404_);
        partRoot.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(34, 0).m_171481_(-5.0f, -2.0f, -2.5f, 10.0f, 14.0f, 5.0f), PartPose.m_171419_(0.0f, -2.0f, 0.0f));
        partRoot.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(20, 26).m_171481_(-3.0f, -4.0f, -2.5f, 4.0f, 14.0f, 5.0f), PartPose.m_171419_(-7.5f, -4.0f, 0.0f));
        partRoot.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171514_(20, 45).m_171481_(0.0f, -4.0f, -2.5f, 4.0f, 14.0f, 5.0f), PartPose.m_171419_(7.5f, -4.0f, 0.0f));
        partRoot.m_171599_("right_leg", CubeListBuilder.m_171558_().m_171514_(0, 26).m_171481_(-2.5f, 0.0f, -2.5f, 5.0f, 12.0f, 5.0f), PartPose.m_171419_(-2.5f, 12.0f, 0.0f));
        partRoot.m_171599_("left_leg", CubeListBuilder.m_171558_().m_171514_(0, 43).m_171481_(-2.5f, 0.0f, -2.5f, 5.0f, 12.0f, 5.0f), PartPose.m_171419_(2.5f, 12.0f, 0.0f));
        return LayerDefinition.m_171565_(mesh, 64, 64);
    }
    
    public void m_7695_(final PoseStack matrixStackIn, final VertexConsumer bufferIn, final int packedLightIn, final int packedOverlayIn, final float red, final float green, final float blue, final float alpha) {
        if (this.f_102609_) {
            matrixStackIn.m_85837_(0.0, 0.5, 0.0);
        }
        super.m_7695_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }
}
