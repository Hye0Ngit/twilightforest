// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.armor;

import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.CubeDeformation;

public class ArcticArmorModel
{
    public static MeshDefinition addPieces(final CubeDeformation deformation) {
        final MeshDefinition meshdefinition = HumanoidModel.m_170681_(deformation, 0.0f);
        final PartDefinition partdefinition = meshdefinition.m_171576_();
        final PartDefinition head = partdefinition.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, deformation), PartPose.m_171419_(0.0f, 0.0f, 0.0f));
        head.m_171599_("right_hood", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.0f, -2.0f, -1.0f, 1.0f, 4.0f, 1.0f, new CubeDeformation(0.5f)), PartPose.m_171419_(-2.5f, -3.0f, -5.0f));
        head.m_171599_("left_hood", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(0.0f, -2.0f, -1.0f, 1.0f, 4.0f, 1.0f, new CubeDeformation(0.5f)), PartPose.m_171419_(2.5f, -3.0f, -5.0f));
        head.m_171599_("top_hood", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171488_(-2.0f, -1.0f, -1.0f, 4.0f, 1.0f, 1.0f, new CubeDeformation(0.5f)), PartPose.m_171419_(0.0f, -5.5f, -5.0f));
        head.m_171599_("bottom_hood", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171488_(-2.0f, -1.0f, -1.0f, 4.0f, 1.0f, 1.0f, new CubeDeformation(0.5f)), PartPose.m_171419_(0.0f, 0.5f, -5.0f));
        return meshdefinition;
    }
}
