// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import com.google.common.collect.Iterables;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.ModelPart;
import twilightforest.entity.monster.SkeletonDruid;
import net.minecraft.client.model.SkeletonModel;

public class SkeletonDruidModel extends SkeletonModel<SkeletonDruid>
{
    private final ModelPart dress;
    
    public SkeletonDruidModel(final ModelPart root) {
        super(root);
        this.dress = root.m_171324_("dress");
    }
    
    public static LayerDefinition create(final CubeDeformation deformation) {
        final MeshDefinition mesh = SkeletonModel.m_170681_(deformation, 0.0f);
        final PartDefinition partRoot = mesh.m_171576_();
        partRoot.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(8, 16).m_171488_(-4.0f, 0.0f, -2.0f, 8.0f, 12.0f, 4.0f, deformation), PartPose.f_171404_);
        partRoot.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171480_().m_171514_(0, 16).m_171488_(-1.0f, -2.0f, -1.0f, 2.0f, 12.0f, 2.0f, deformation), PartPose.m_171419_(5.0f, 2.0f, 0.0f));
        partRoot.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-1.0f, -2.0f, -1.0f, 2.0f, 12.0f, 2.0f, deformation), PartPose.m_171419_(-5.0f, 2.0f, 0.0f));
        partRoot.m_171599_("left_leg", CubeListBuilder.m_171558_().m_171480_().m_171514_(0, 16).m_171488_(-2.0f, 0.0f, -2.0f, 2.0f, 12.0f, 2.0f, deformation), PartPose.m_171419_(3.0f, 12.0f, 0.0f));
        partRoot.m_171599_("right_leg", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-2.0f, 0.0f, -2.0f, 2.0f, 12.0f, 2.0f, deformation), PartPose.m_171419_(-1.0f, 12.0f, 0.0f));
        partRoot.m_171599_("dress", CubeListBuilder.m_171558_().m_171514_(32, 16).m_171488_(-4.0f, 12.0f, -2.0f, 8.0f, 12.0f, 4.0f, deformation), PartPose.f_171404_);
        return LayerDefinition.m_171565_(mesh, 64, 32);
    }
    
    public static LayerDefinition create() {
        return create(CubeDeformation.f_171458_);
    }
    
    public void m_7695_(final PoseStack matrixStackIn, final VertexConsumer bufferIn, final int packedLightIn, final int packedOverlayIn, final float red, final float green, final float blue, final float alpha) {
        if (this.f_102609_) {
            matrixStackIn.m_85837_(0.0, -0.25, 0.0);
        }
        super.m_7695_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }
    
    protected Iterable<ModelPart> m_5608_() {
        return Iterables.concat(super.m_5608_(), (Iterable)ImmutableList.of((Object)this.dress));
    }
}
