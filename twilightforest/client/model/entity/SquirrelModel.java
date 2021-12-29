// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import twilightforest.entity.passive.Squirrel;
import net.minecraft.client.model.QuadrupedModel;

@OnlyIn(Dist.CLIENT)
public class SquirrelModel extends QuadrupedModel<Squirrel>
{
    public ModelPart tail1;
    public ModelPart tail2;
    
    public SquirrelModel(final ModelPart root) {
        super(root, false, 4.0f, 4.0f, 2.0f, 2.0f, 24);
        this.tail1 = this.f_103493_.m_171324_("tail_1");
        this.tail2 = this.tail1.m_171324_("tail_2");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = QuadrupedModel.m_170864_(1, CubeDeformation.f_171458_);
        final PartDefinition partRoot = mesh.m_171576_();
        partRoot.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-2.0f, -2.0f, -3.0f, 4.0f, 4.0f, 4.0f).m_171481_(-2.0f, -3.0f, -1.0f, 1.0f, 1.0f, 1.0f).m_171514_(0, 2).m_171481_(1.0f, -3.0f, -1.0f, 1.0f, 1.0f, 1.0f), PartPose.m_171419_(0.0f, 20.0f, -3.0f));
        final PartDefinition body = partRoot.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 8).m_171481_(-2.0f, -3.0f, -3.0f, 4.0f, 3.0f, 5.0f), PartPose.m_171419_(0.0f, 23.0f, 0.0f));
        partRoot.m_171599_("right_front_leg", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171481_(-0.5f, 0.0f, -0.5f, 1.0f, 1.0f, 1.0f), PartPose.m_171419_(-1.5f, 23.0f, -2.5f));
        partRoot.m_171599_("left_front_leg", CubeListBuilder.m_171558_().m_171514_(4, 16).m_171481_(-0.5f, 0.0f, -0.5f, 1.0f, 1.0f, 1.0f), PartPose.m_171419_(1.5f, 23.0f, -2.5f));
        partRoot.m_171599_("right_hind_leg", CubeListBuilder.m_171558_().m_171514_(0, 18).m_171481_(-0.5f, 0.0f, -0.5f, 1.0f, 1.0f, 1.0f), PartPose.m_171419_(-1.5f, 23.0f, 1.5f));
        partRoot.m_171599_("left_hind_leg", CubeListBuilder.m_171558_().m_171514_(4, 18).m_171481_(-0.5f, 0.0f, -0.5f, 1.0f, 1.0f, 1.0f), PartPose.m_171419_(1.5f, 23.0f, 1.5f));
        final PartDefinition tail1 = body.m_171599_("tail_1", CubeListBuilder.m_171558_().m_171514_(18, 0).m_171481_(-1.5f, 0.0f, -1.5f, 3.0f, 4.0f, 3.0f), PartPose.m_171423_(0.0f, -3.0f, 2.0f, 2.5307274f, 0.0f, 0.0f));
        tail1.m_171599_("tail_2", CubeListBuilder.m_171558_().m_171514_(13, 11).m_171481_(-1.5f, -1.0f, 0.0f, 3.0f, 3.0f, 5.0f), PartPose.m_171419_(0.0f, 4.0f, 0.5f));
        return LayerDefinition.m_171565_(mesh, 32, 32);
    }
    
    public void setupAnim(final Squirrel entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.f_103492_.f_104203_ = headPitch / 57.295776f;
        this.f_103492_.f_104204_ = netHeadYaw / 57.295776f;
        this.f_170855_.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.f_170854_.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.f_170853_.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.f_170852_.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        if (limbSwingAmount > 0.2) {
            final float wiggle = Math.min(limbSwingAmount, 0.6f);
            this.tail2.f_104203_ = (Mth.m_14089_(ageInTicks * 0.6662f) - 1.0471976f) * wiggle;
            this.tail1.f_104203_ = 2.5f + Mth.m_14089_(ageInTicks * 0.7774f) * 1.2f * wiggle;
        }
        else {
            this.tail2.f_104203_ = 0.2f + Mth.m_14089_(ageInTicks * 0.3335f) * 0.25f;
            this.tail1.f_104203_ = 2.5f + Mth.m_14089_(ageInTicks * 0.4445f) * 0.2f;
        }
    }
}
