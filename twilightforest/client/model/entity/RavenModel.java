// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import twilightforest.entity.passive.Raven;
import net.minecraft.client.model.HierarchicalModel;

@OnlyIn(Dist.CLIENT)
public class RavenModel extends HierarchicalModel<Raven>
{
    public ModelPart root;
    public ModelPart head;
    public ModelPart rightWing;
    public ModelPart leftWing;
    public ModelPart rightLeg;
    public ModelPart leftLeg;
    public ModelPart tail;
    
    public RavenModel(final ModelPart root) {
        this.root = root;
        this.head = root.m_171324_("head");
        final ModelPart body = root.m_171324_("torso");
        this.rightWing = body.m_171324_("right_wing");
        this.leftWing = body.m_171324_("left_wing");
        this.rightLeg = root.m_171324_("right_leg");
        this.leftLeg = root.m_171324_("left_leg");
        this.tail = body.m_171324_("tail");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = new MeshDefinition();
        final PartDefinition partRoot = mesh.m_171576_();
        partRoot.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-1.5f, -1.0f, -2.0f, 3.0f, 3.0f, 3.0f).m_171514_(9, 0).m_171481_(-0.5f, 0.0f, -3.0f, 1.0f, 2.0f, 1.0f), PartPose.m_171419_(0.0f, 18.5f, -2.0f));
        final PartDefinition body = partRoot.m_171599_("torso", CubeListBuilder.m_171558_().m_171514_(0, 6).m_171481_(-2.0f, -1.5f, 0.0f, 4.0f, 3.0f, 6.0f), PartPose.m_171423_(0.0f, 18.5f, -2.0f, -0.43633232f, 0.0f, 0.0f));
        body.m_171599_("right_wing", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171481_(-1.0f, 0.0f, -1.0f, 1.0f, 3.0f, 6.0f), PartPose.m_171423_(-2.0f, -1.0f, 2.0f, 0.2617994f, 0.0f, 0.0f));
        body.m_171599_("left_wing", CubeListBuilder.m_171558_().m_171514_(14, 15).m_171481_(0.0f, 0.0f, -1.0f, 1.0f, 3.0f, 6.0f), PartPose.m_171423_(2.0f, -1.0f, 2.0f, 0.2617994f, 0.0f, 0.0f));
        partRoot.m_171599_("right_leg", CubeListBuilder.m_171558_().m_171514_(8, 15).m_171481_(0.0f, 0.0f, -1.0f, 1.0f, 2.0f, 2.0f), PartPose.m_171423_(-1.0f, 0.0f, 0.0f, 0.7853982f, 0.0f, 0.0f));
        partRoot.m_171599_("left_leg", CubeListBuilder.m_171558_().m_171514_(14, 15).m_171481_(0.0f, 0.0f, -1.0f, 1.0f, 2.0f, 2.0f), PartPose.m_171423_(1.0f, 0.0f, 0.0f, 0.7853982f, 0.0f, 0.0f));
        body.m_171599_("tail", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171481_(-2.5f, 0.0f, 0.0f, 5.0f, 0.0f, 5.0f), PartPose.m_171423_(0.0f, -1.5f, 6.0f, -0.43633232f, 0.0f, 0.0f));
        return LayerDefinition.m_171565_(mesh, 32, 32);
    }
    
    public ModelPart m_142109_() {
        return this.root;
    }
    
    public void setupAnim(final Raven entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.head.f_104203_ = headPitch / 57.295776f;
        this.head.f_104204_ = netHeadYaw / 57.295776f;
        this.head.f_104205_ = ((netHeadYaw > 5.0f) ? -0.2617994f : 0.0f);
        this.leftLeg.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.rightLeg.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.rightWing.f_104205_ = ageInTicks;
        this.leftWing.f_104205_ = -ageInTicks;
        if (entity.isBirdLanded()) {
            this.rightLeg.f_104201_ = 21.0f;
            this.leftLeg.f_104201_ = 21.0f;
        }
        else {
            this.rightLeg.f_104201_ = 20.0f;
            this.leftLeg.f_104201_ = 20.0f;
        }
    }
}
