// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity.legacy;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import com.google.common.collect.Iterables;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import twilightforest.entity.passive.Squirrel;
import net.minecraft.client.model.QuadrupedModel;

public class SquirrelLegacyModel extends QuadrupedModel<Squirrel>
{
    ModelPart tail;
    ModelPart fluff1;
    ModelPart fluff2;
    ModelPart fluff3;
    
    public SquirrelLegacyModel(final ModelPart root) {
        super(root, false, 4.0f, 4.0f, 2.0f, 2.0f, 24);
        this.tail = root.m_171324_("tail");
        this.fluff1 = this.tail.m_171324_("fluff_1");
        this.fluff2 = this.fluff1.m_171324_("fluff_2");
        this.fluff3 = this.fluff2.m_171324_("fluff_3");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = QuadrupedModel.m_170864_(0, CubeDeformation.f_171458_);
        final PartDefinition partRoot = mesh.m_171576_();
        partRoot.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-2.0f, -5.0f, -3.0f, 4.0f, 4.0f, 4.0f).m_171514_(16, 0).m_171481_(-2.0f, -6.0f, -0.5f, 1.0f, 1.0f, 1.0f).m_171514_(16, 0).m_171481_(1.0f, -6.0f, -0.5f, 1.0f, 1.0f, 1.0f), PartPose.m_171419_(0.0f, 22.0f, -2.0f));
        final PartDefinition body = partRoot.m_171599_("body", CubeListBuilder.m_171558_().m_171480_().m_171514_(0, 8).m_171481_(-2.0f, -1.0f, -2.0f, 4.0f, 3.0f, 5.0f), PartPose.m_171419_(0.0f, 21.0f, 0.0f));
        partRoot.m_171599_("right_hind_leg", CubeListBuilder.m_171558_().m_171480_().m_171514_(0, 16).m_171481_(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f), PartPose.m_171419_(-2.0f, 23.0f, 2.0f));
        partRoot.m_171599_("left_hind_leg", CubeListBuilder.m_171558_().m_171480_().m_171514_(0, 16).m_171481_(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f), PartPose.m_171419_(1.0f, 23.0f, 2.0f));
        partRoot.m_171599_("right_front_leg", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171481_(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f), PartPose.m_171419_(-2.0f, 23.0f, -2.0f));
        partRoot.m_171599_("left_front_leg", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171481_(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f), PartPose.m_171419_(1.0f, 23.0f, -2.0f));
        final PartDefinition tail = partRoot.m_171599_("tail", CubeListBuilder.m_171558_().m_171514_(0, 18).m_171481_(-0.5f, -1.5f, 0.5f, 1.0f, 1.0f, 1.0f), PartPose.m_171419_(0.0f, 21.0f, 2.0f));
        final PartDefinition fluff1 = tail.m_171599_("fluff_1", CubeListBuilder.m_171558_().m_171514_(0, 20).m_171481_(-1.5f, -4.0f, 1.0f, 3.0f, 3.0f, 3.0f), PartPose.f_171404_);
        final PartDefinition fluff2 = fluff1.m_171599_("fluff_2", CubeListBuilder.m_171558_().m_171514_(0, 20).m_171481_(0.0f, -3.0f, -1.5f, 3.0f, 3.0f, 3.0f), PartPose.m_171419_(-1.5f, -4.0f, 2.5f));
        fluff2.m_171599_("fluff_3", CubeListBuilder.m_171558_().m_171514_(0, 26).m_171481_(1.5f, -3.0f, -1.5f, 3.0f, 3.0f, 3.0f), PartPose.m_171419_(-1.5f, -3.0f, 0.0f));
        return LayerDefinition.m_171565_(mesh, 32, 32);
    }
    
    protected Iterable<ModelPart> m_5608_() {
        return Iterables.concat(super.m_5608_(), (Iterable)ImmutableList.of((Object)this.tail));
    }
    
    public void setupAnim(final Squirrel entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.f_103492_.f_104203_ = headPitch / 57.295776f;
        this.f_103492_.f_104204_ = netHeadYaw / 57.295776f;
        this.f_170852_.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.f_170853_.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.f_170854_.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.f_170855_.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        if (limbSwingAmount > 0.2) {
            final float wiggle = Math.min(limbSwingAmount, 0.6f);
            this.tail.f_104203_ = (Mth.m_14089_(ageInTicks * 0.6662f) - 1.0471976f) * wiggle;
            this.fluff2.f_104203_ = Mth.m_14089_(ageInTicks * 0.7774f) * 1.2f * wiggle;
            this.fluff3.f_104203_ = Mth.m_14089_(ageInTicks * 0.8886f + 1.5707964f) * 1.4f * wiggle;
        }
        else {
            this.tail.f_104203_ = 0.2f + Mth.m_14089_(ageInTicks * 0.3335f) * 0.15f;
            this.fluff2.f_104203_ = 0.1f + Mth.m_14089_(ageInTicks * 0.4445f) * 0.2f;
            this.fluff3.f_104203_ = 0.1f + Mth.m_14089_(ageInTicks * 0.5555f) * 0.25f;
        }
    }
}
