// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity.legacy;

import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import twilightforest.entity.monster.Minotaur;
import net.minecraft.client.model.HumanoidModel;

public class MinotaurLegacyModel extends HumanoidModel<Minotaur>
{
    public MinotaurLegacyModel(final ModelPart root) {
        super(root);
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = HumanoidModel.m_170681_(CubeDeformation.f_171458_, 0.0f);
        final PartDefinition partRoot = mesh.m_171576_();
        final PartDefinition head = partRoot.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f), PartPose.m_171419_(0.0f, 0.0f, 0.0f));
        partRoot.m_171599_("hat", CubeListBuilder.m_171558_(), PartPose.f_171404_);
        head.m_171599_("snout", CubeListBuilder.m_171558_().m_171514_(9, 12).m_171481_(-2.0f, -1.0f, -1.0f, 4.0f, 3.0f, 1.0f), PartPose.m_171419_(0.0f, -2.0f, -4.0f));
        final PartDefinition rightHorn = head.m_171599_("right_horn_1", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171481_(-5.5f, -1.5f, -1.5f, 5.0f, 3.0f, 3.0f), PartPose.m_171423_(-2.5f, -6.5f, 0.0f, 0.0f, -0.43633235f, 0.17453294f));
        rightHorn.m_171599_("right_horn_2", CubeListBuilder.m_171558_().m_171514_(40, 0).m_171481_(-3.5f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f), PartPose.m_171423_(-4.5f, 0.0f, 0.0f, 0.0f, -0.2617994f, 0.7853982f));
        final PartDefinition leftHorn = head.m_171599_("left_horn_1", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171481_(0.5f, -1.5f, -1.5f, 5.0f, 3.0f, 3.0f), PartPose.m_171423_(2.5f, -6.5f, 0.0f, 0.0f, 0.43633235f, -0.17453294f));
        leftHorn.m_171599_("left_horn_2", CubeListBuilder.m_171558_().m_171514_(40, 0).m_171481_(0.5f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f), PartPose.m_171423_(4.5f, 0.0f, 0.0f, 0.0f, 0.2617994f, -0.7853982f));
        return LayerDefinition.m_171565_(mesh, 64, 32);
    }
}
