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
import net.minecraft.client.model.SheepModel;
import twilightforest.entity.passive.Bighorn;

public class BighornLegacyModel<T extends Bighorn> extends SheepModel<T>
{
    public BighornLegacyModel(final ModelPart root) {
        super(root);
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = SheepModel.m_170864_(0, CubeDeformation.f_171458_);
        final PartDefinition partRoot = mesh.m_171576_();
        partRoot.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-3.0f, -4.0f, -6.0f, 6.0f, 6.0f, 7.0f).m_171514_(28, 16).m_171481_(-5.0f, -4.0f, -4.0f, 2.0f, 2.0f, 2.0f).m_171514_(16, 13).m_171481_(-6.0f, -5.0f, -3.0f, 2.0f, 2.0f, 4.0f).m_171514_(16, 19).m_171481_(-7.0f, -4.0f, 0.0f, 2.0f, 5.0f, 2.0f).m_171514_(18, 27).m_171481_(-8.0f, 0.0f, -2.0f, 2.0f, 2.0f, 3.0f).m_171514_(28, 27).m_171481_(-9.0f, -1.0f, -3.0f, 2.0f, 2.0f, 1.0f).m_171514_(28, 16).m_171481_(3.0f, -4.0f, -4.0f, 2.0f, 2.0f, 2.0f).m_171514_(16, 13).m_171481_(4.0f, -5.0f, -3.0f, 2.0f, 2.0f, 4.0f).m_171514_(16, 19).m_171481_(5.0f, -4.0f, 0.0f, 2.0f, 5.0f, 2.0f).m_171514_(18, 27).m_171481_(6.0f, 0.0f, -2.0f, 2.0f, 2.0f, 3.0f).m_171514_(28, 27).m_171481_(7.0f, -1.0f, -3.0f, 2.0f, 2.0f, 1.0f), PartPose.m_171419_(0.0f, 6.0f, -8.0f));
        partRoot.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(36, 10).m_171481_(-4.0f, -9.0f, -7.0f, 8.0f, 15.0f, 6.0f), PartPose.m_171423_(0.0f, 5.0f, 2.0f, 1.5707964f, 0.0f, 0.0f));
        partRoot.m_171599_("left_front_leg", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171481_(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f), PartPose.m_171419_(-3.0f, 12.0f, 7.0f));
        partRoot.m_171599_("right_front_leg", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171481_(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f), PartPose.m_171419_(3.0f, 12.0f, 7.0f));
        partRoot.m_171599_("left_hind_leg", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171481_(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f), PartPose.m_171419_(-3.0f, 12.0f, -5.0f));
        partRoot.m_171599_("right_hind_leg", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171481_(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f), PartPose.m_171419_(3.0f, 12.0f, -5.0f));
        return LayerDefinition.m_171565_(mesh, 64, 32);
    }
}
