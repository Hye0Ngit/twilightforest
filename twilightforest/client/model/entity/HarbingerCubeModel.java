// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.QuadrupedModel;
import twilightforest.entity.monster.HarbingerCube;

public class HarbingerCubeModel<T extends HarbingerCube> extends QuadrupedModel<T>
{
    public HarbingerCubeModel(final ModelPart part) {
        super(part, false, 0.0f, 0.0f, 0.0f, 0.0f, 4);
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = QuadrupedModel.m_170864_(0, CubeDeformation.f_171458_);
        final PartDefinition partRoot = mesh.m_171576_();
        partRoot.m_171599_("head", CubeListBuilder.m_171558_(), PartPose.f_171404_);
        partRoot.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f), PartPose.m_171419_(0.0f, 0.0f, -2.0f));
        partRoot.m_171599_("right_hind_leg", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-4.0f, 0.0f, -4.0f, 8.0f, 8.0f, 8.0f), PartPose.m_171419_(-6.0f, 16.0f, 9.0f));
        partRoot.m_171599_("left_hind_leg", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-4.0f, 0.0f, -4.0f, 8.0f, 8.0f, 8.0f), PartPose.m_171419_(6.0f, 16.0f, 9.0f));
        partRoot.m_171599_("right_front_leg", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-4.0f, 0.0f, -4.0f, 8.0f, 8.0f, 8.0f), PartPose.m_171419_(-9.0f, 16.0f, -14.0f));
        partRoot.m_171599_("left_front_leg", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-4.0f, 0.0f, -4.0f, 8.0f, 8.0f, 8.0f), PartPose.m_171419_(9.0f, 16.0f, -14.0f));
        return LayerDefinition.m_171565_(mesh, 128, 64);
    }
    
    public void setupAnim(final T entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        super.m_6973_((Entity)entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        this.f_103493_.f_104203_ = 0.0f;
    }
}
