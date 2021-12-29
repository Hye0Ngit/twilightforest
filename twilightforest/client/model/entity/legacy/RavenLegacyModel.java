// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity.legacy;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import twilightforest.entity.passive.Raven;
import net.minecraft.client.model.HierarchicalModel;

public class RavenLegacyModel extends HierarchicalModel<Raven>
{
    ModelPart root;
    ModelPart head;
    ModelPart rightarm;
    ModelPart leftarm;
    ModelPart rightleg;
    ModelPart leftleg;
    
    public RavenLegacyModel(final ModelPart root) {
        this.root = root;
        this.head = root.m_171324_("head");
        this.rightarm = root.m_171324_("right_wing");
        this.leftarm = root.m_171324_("left_wing");
        this.rightleg = root.m_171324_("right_leg");
        this.leftleg = root.m_171324_("left_leg");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = new MeshDefinition();
        final PartDefinition base = mesh.m_171576_();
        final PartDefinition headpart = base.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-1.5f, -1.5f, -3.0f, 3.0f, 3.0f, 3.0f).m_171480_(), PartPose.m_171419_(0.0f, 18.0f, 0.0f));
        headpart.m_171599_("beak1", CubeListBuilder.m_171558_().m_171514_(12, 0).m_171481_(-0.5f, -1.0f, -2.0f, 1.0f, 1.0f, 2.0f), PartPose.m_171423_(0.0f, 0.0f, -2.5f, 0.2617994f, 0.0f, 0.0f));
        headpart.m_171599_("beak2", CubeListBuilder.m_171558_().m_171514_(12, 0).m_171481_(-0.5f, 0.0f, -2.0f, 1.0f, 1.0f, 2.0f), PartPose.m_171423_(0.0f, 0.0f, -2.5f, -0.2617994f, 0.0f, 0.0f));
        base.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 6).m_171481_(-1.5f, 0.0f, -1.0f, 3.0f, 4.0f, 6.0f), PartPose.m_171423_(0.0f, 17.0f, 1.0f, -0.5235988f, 0.0f, 0.0f));
        base.m_171599_("right_wing", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171481_(-1.0f, 0.0f, -1.5f, 1.0f, 3.0f, 6.0f), PartPose.m_171419_(-1.5f, 18.0f, 1.0f));
        base.m_171599_("left_wing", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171481_(0.0f, 0.0f, -1.5f, 1.0f, 3.0f, 6.0f), PartPose.m_171419_(1.5f, 18.0f, 1.0f));
        final PartDefinition rightlegpart = base.m_171599_("right_leg", CubeListBuilder.m_171558_().m_171514_(14, 16).m_171481_(0.0f, 0.0f, 0.0f, 1.0f, 2.0f, 1.0f), PartPose.m_171419_(-1.5f, 21.0f, 1.0f));
        rightlegpart.m_171599_("right_foot", CubeListBuilder.m_171558_().m_171514_(14, 20).m_171481_(0.0f, -1.0f, -2.0f, 1.0f, 1.0f, 2.0f), PartPose.m_171423_(0.0f, 2.0f, 1.0f, 0.5235988f, 0.0f, 0.0f));
        final PartDefinition leftlegpart = base.m_171599_("left_leg", CubeListBuilder.m_171558_().m_171514_(14, 16).m_171481_(0.0f, 0.0f, 0.0f, 1.0f, 2.0f, 1.0f), PartPose.m_171419_(0.5f, 21.0f, 1.0f));
        leftlegpart.m_171599_("left_foot", CubeListBuilder.m_171558_().m_171514_(14, 20).m_171481_(0.0f, -1.0f, -2.0f, 1.0f, 1.0f, 2.0f), PartPose.m_171423_(0.0f, 2.0f, 1.0f, 0.5235988f, 0.0f, 0.0f));
        base.m_171599_("tail", CubeListBuilder.m_171558_().m_171514_(0, 25).m_171481_(-1.5f, -0.5f, 0.0f, 3.0f, 1.0f, 3.0f), PartPose.m_171423_(0.0f, 21.0f, 4.0f, -0.5235988f, 0.0f, 0.0f));
        return LayerDefinition.m_171565_(mesh, 32, 32);
    }
    
    public ModelPart m_142109_() {
        return this.root;
    }
    
    public void setupAnim(final Raven entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.head.f_104203_ = headPitch / 57.295776f;
        this.head.f_104204_ = netHeadYaw / 57.295776f;
        this.head.f_104205_ = ((netHeadYaw > 5.0f) ? -0.2617994f : 0.0f);
        this.rightleg.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.leftleg.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.rightarm.f_104205_ = ageInTicks;
        this.leftarm.f_104205_ = -ageInTicks;
        if (entity.isBirdLanded()) {
            this.rightleg.f_104201_ = 21.0f;
            this.leftleg.f_104201_ = 21.0f;
        }
        else {
            this.rightleg.f_104201_ = 20.0f;
            this.leftleg.f_104201_ = 20.0f;
        }
    }
}
