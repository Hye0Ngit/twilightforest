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

public class KnightmetalArmorModel
{
    public static MeshDefinition setup(final CubeDeformation deformation) {
        final MeshDefinition meshdefinition = HumanoidModel.m_170681_(deformation, 0.0f);
        final PartDefinition partdefinition = meshdefinition.m_171576_();
        final PartDefinition head = partdefinition.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, deformation), PartPose.m_171419_(0.0f, 0.0f, 0.0f));
        final PartDefinition rightHorn = head.m_171599_("right_horn_1", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171488_(-5.5f, -1.5f, -1.5f, 5.0f, 3.0f, 3.0f, new CubeDeformation(0.25f)), PartPose.m_171423_(-4.0f, -6.5f, 0.0f, 0.0f, -0.2617994f, 0.17453294f));
        rightHorn.m_171599_("right_horn_2", CubeListBuilder.m_171558_().m_171514_(54, 16).m_171488_(-3.5f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, new CubeDeformation(0.25f)), PartPose.m_171423_(-4.5f, 0.0f, 0.0f, 0.0f, 0.0f, 0.17453294f));
        final PartDefinition leftHorn = head.m_171599_("left_horn_1", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171480_().m_171488_(0.5f, -1.5f, -1.5f, 5.0f, 3.0f, 3.0f, new CubeDeformation(0.25f)), PartPose.m_171423_(4.0f, -6.5f, 0.0f, 0.0f, 0.2617994f, -0.17453294f));
        leftHorn.m_171599_("left_horn_2", CubeListBuilder.m_171558_().m_171514_(54, 16).m_171488_(0.5f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, new CubeDeformation(0.25f)), PartPose.m_171423_(4.5f, 0.0f, 0.0f, 0.0f, 0.0f, -0.17453294f));
        final PartDefinition rightArm = partdefinition.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(40, 16).m_171488_(-3.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f, deformation), PartPose.m_171419_(-5.0f, 2.0f, 0.0f));
        final PartDefinition leftArm = partdefinition.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171514_(40, 16).m_171480_().m_171488_(-1.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f, deformation), PartPose.m_171419_(5.0f, 2.0f, 0.0f));
        rightArm.m_171599_("shoulder_spike_1", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f, new CubeDeformation(0.25f)), PartPose.m_171423_(-3.75f, -2.5f, 3.0f, 0.7853982f, 0.17453294f, 0.6108653f));
        leftArm.m_171599_("shoulder_spike_2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f, new CubeDeformation(0.25f)), PartPose.m_171423_(3.75f, -2.5f, 3.0f, -0.7853982f, -0.17453294f, 0.95993114f));
        final PartDefinition rightLeg = partdefinition.m_171599_("right_leg", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, deformation), PartPose.m_171419_(-1.9f, 12.0f, 0.0f));
        final PartDefinition leftLeg = partdefinition.m_171599_("left_leg", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171480_().m_171488_(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, deformation), PartPose.m_171419_(1.9f, 12.0f, 0.0f));
        rightLeg.m_171599_("shoe_spike_1", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f, new CubeDeformation(0.25f)), PartPose.m_171423_(-2.5f, 11.0f, 3.0f, 0.0f, -0.7853982f, 0.0f));
        leftLeg.m_171599_("shoe_spike_2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f, new CubeDeformation(0.25f)), PartPose.m_171423_(2.5f, 11.0f, 3.0f, 0.0f, 0.7853982f, 0.0f));
        return meshdefinition;
    }
}
