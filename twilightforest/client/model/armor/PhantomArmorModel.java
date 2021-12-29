// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.armor;

import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.CubeDeformation;

public class PhantomArmorModel
{
    public static MeshDefinition addPieces(final CubeDeformation deformation) {
        final MeshDefinition mesh = KnightmetalArmorModel.setup(deformation);
        final PartDefinition part = mesh.m_171576_();
        final PartDefinition head = part.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, deformation), PartPose.m_171419_(0.0f, 0.0f, 0.0f));
        final PartDefinition rightHorn = head.m_171599_("right_horn_1", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171488_(-5.5f, -1.5f, -1.5f, 5.0f, 3.0f, 3.0f, new CubeDeformation(0.25f)), PartPose.m_171423_(-4.0f, -6.5f, 0.0f, 0.0f, -0.43633235f, 0.7853982f));
        rightHorn.m_171599_("right_horn_2", CubeListBuilder.m_171558_().m_171514_(54, 16).m_171488_(-3.5f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, new CubeDeformation(0.25f)), PartPose.m_171423_(-4.5f, 0.0f, 0.0f, 0.0f, -0.2617994f, 0.7853982f));
        final PartDefinition leftHorn = head.m_171599_("left_horn_1", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171480_().m_171488_(0.5f, -1.5f, -1.5f, 5.0f, 3.0f, 3.0f, new CubeDeformation(0.25f)), PartPose.m_171423_(4.0f, -6.5f, 0.0f, 0.0f, 0.43633235f, -0.7853982f));
        leftHorn.m_171599_("left_horn_2", CubeListBuilder.m_171558_().m_171514_(54, 16).m_171488_(0.5f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, new CubeDeformation(0.25f)), PartPose.m_171423_(4.5f, 0.0f, 0.0f, 0.0f, 0.2617994f, -0.7853982f));
        return mesh;
    }
}
