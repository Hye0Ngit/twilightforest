// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity.legacy;

import net.minecraft.world.entity.Entity;
import twilightforest.entity.boss.HydraPart;
import net.minecraft.util.Mth;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import twilightforest.entity.boss.Hydra;
import net.minecraft.client.model.HierarchicalModel;

public class HydraLegacyModel extends HierarchicalModel<Hydra>
{
    ModelPart root;
    ModelPart body;
    ModelPart tail;
    ModelPart leg1;
    ModelPart leg2;
    
    public HydraLegacyModel(final ModelPart root) {
        this.root = root;
        this.body = root.m_171324_("body");
        this.tail = root.m_171324_("tail_1");
        this.leg1 = root.m_171324_("leg_1");
        this.leg2 = root.m_171324_("leg_2");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = new MeshDefinition();
        final PartDefinition partRoot = mesh.m_171576_();
        partRoot.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-48.0f, 0.0f, 0.0f, 96.0f, 96.0f, 40.0f), PartPose.m_171423_(0.0f, -12.0f, 0.0f, 1.22173f, 0.0f, 0.0f));
        partRoot.m_171599_("leg_1", CubeListBuilder.m_171558_().m_171514_(0, 136).m_171481_(-16.0f, 0.0f, -16.0f, 32.0f, 48.0f, 32.0f).m_171514_(184, 200).m_171481_(-20.0f, 40.0f, -20.0f, 8.0f, 8.0f, 8.0f).m_171514_(184, 200).m_171481_(-4.0f, 40.0f, -22.0f, 8.0f, 8.0f, 8.0f).m_171514_(184, 200).m_171481_(12.0f, 40.0f, -20.0f, 8.0f, 8.0f, 8.0f), PartPose.m_171419_(48.0f, -24.0f, 0.0f));
        partRoot.m_171599_("leg_2", CubeListBuilder.m_171558_().m_171480_().m_171514_(0, 136).m_171481_(-16.0f, 0.0f, -16.0f, 32.0f, 48.0f, 32.0f).m_171514_(184, 200).m_171481_(-20.0f, 40.0f, -20.0f, 8.0f, 8.0f, 8.0f).m_171514_(184, 200).m_171481_(-4.0f, 40.0f, -22.0f, 8.0f, 8.0f, 8.0f).m_171514_(184, 200).m_171481_(12.0f, 40.0f, -20.0f, 8.0f, 8.0f, 8.0f), PartPose.m_171419_(-48.0f, -24.0f, 0.0f));
        final PartDefinition tail1 = partRoot.m_171599_("tail_1", CubeListBuilder.m_171558_().m_171514_(128, 136).m_171481_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f).m_171514_(128, 200).m_171481_(-2.0f, -28.0f, -11.0f, 4.0f, 24.0f, 24.0f), PartPose.m_171419_(0.0f, 6.0f, 108.0f));
        final PartDefinition tail2 = tail1.m_171599_("tail_2", CubeListBuilder.m_171558_().m_171514_(128, 136).m_171481_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f).m_171514_(128, 200).m_171481_(-2.0f, -28.0f, -11.0f, 4.0f, 24.0f, 24.0f), PartPose.m_171419_(0.0f, 0.0f, 32.0f));
        final PartDefinition tail3 = tail2.m_171599_("tail_3", CubeListBuilder.m_171558_().m_171514_(128, 136).m_171481_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f).m_171514_(128, 200).m_171481_(-2.0f, -28.0f, -11.0f, 4.0f, 24.0f, 24.0f), PartPose.m_171419_(0.0f, 0.0f, 32.0f));
        tail3.m_171599_("tail_4", CubeListBuilder.m_171558_().m_171514_(128, 136).m_171481_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f).m_171514_(128, 200).m_171481_(-2.0f, -28.0f, -11.0f, 4.0f, 24.0f, 24.0f), PartPose.m_171419_(0.0f, 0.0f, 32.0f));
        final PartDefinition head1 = partRoot.m_171599_("head_1", CubeListBuilder.m_171558_().m_171514_(272, 0).m_171481_(-16.0f, -14.0f, -32.0f, 32.0f, 24.0f, 32.0f).m_171514_(272, 56).m_171481_(-15.0f, -2.0f, -56.0f, 30.0f, 12.0f, 24.0f).m_171514_(128, 200).m_171481_(-2.0f, -30.0f, -12.0f, 4.0f, 24.0f, 24.0f), PartPose.m_171419_(0.0f, -128.0f, -53.0f));
        head1.m_171599_("jaw_1", CubeListBuilder.m_171558_().m_171514_(272, 92).m_171481_(-15.0f, 0.0f, -48.0f, 30.0f, 8.0f, 48.0f), PartPose.m_171419_(0.0f, 10.0f, -4.0f));
        head1.m_171599_("frill_1", CubeListBuilder.m_171558_().m_171514_(272, 200).m_171481_(-24.0f, -40.0f, 0.0f, 48.0f, 48.0f, 4.0f), PartPose.m_171423_(0.0f, 0.0f, -10.0f, -0.5235988f, 0.0f, 0.0f));
        partRoot.m_171599_("neck_1a", CubeListBuilder.m_171558_().m_171514_(128, 136).m_171481_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f).m_171514_(128, 200).m_171481_(-2.0f, -23.0f, 0.0f, 4.0f, 24.0f, 24.0f), PartPose.m_171419_(0.0f, -48.0f, 16.0f));
        partRoot.m_171599_("neck_1b", CubeListBuilder.m_171558_().m_171514_(128, 136).m_171481_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f).m_171514_(128, 200).m_171481_(-2.0f, -23.0f, 0.0f, 4.0f, 24.0f, 24.0f), PartPose.m_171419_(0.0f, -68.0f, 0.0f));
        partRoot.m_171599_("neck_1c", CubeListBuilder.m_171558_().m_171514_(128, 136).m_171481_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f).m_171514_(128, 200).m_171481_(-2.0f, -23.0f, 0.0f, 4.0f, 24.0f, 24.0f), PartPose.m_171419_(0.0f, -93.0f, -14.0f));
        partRoot.m_171599_("neck_1d", CubeListBuilder.m_171558_().m_171514_(128, 136).m_171481_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f).m_171514_(128, 200).m_171481_(-2.0f, -23.0f, 0.0f, 4.0f, 24.0f, 24.0f), PartPose.m_171419_(0.0f, -116.0f, -37.0f));
        final PartDefinition head2 = partRoot.m_171599_("head_2", CubeListBuilder.m_171558_().m_171514_(272, 0).m_171481_(-16.0f, -14.0f, -32.0f, 32.0f, 24.0f, 32.0f).m_171514_(272, 56).m_171481_(-15.0f, -2.0f, -56.0f, 30.0f, 12.0f, 24.0f).m_171514_(128, 200).m_171481_(-2.0f, -30.0f, -12.0f, 4.0f, 24.0f, 24.0f), PartPose.m_171419_(108.0f, -128.0f, -53.0f));
        head2.m_171599_("jaw_2", CubeListBuilder.m_171558_().m_171514_(272, 92).m_171481_(-15.0f, 0.0f, -48.0f, 30.0f, 8.0f, 48.0f), PartPose.m_171419_(0.0f, 10.0f, -4.0f));
        head2.m_171599_("frill_2", CubeListBuilder.m_171558_().m_171514_(272, 200).m_171481_(-24.0f, -40.0f, 0.0f, 48.0f, 48.0f, 4.0f), PartPose.m_171423_(0.0f, 0.0f, -10.0f, -0.5235988f, 0.0f, 0.0f));
        partRoot.m_171599_("neck_2a", CubeListBuilder.m_171558_().m_171514_(128, 136).m_171481_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f).m_171514_(128, 200).m_171481_(-2.0f, -23.0f, 0.0f, 4.0f, 24.0f, 24.0f), PartPose.m_171419_(48.0f, -48.0f, 16.0f));
        partRoot.m_171599_("neck_2b", CubeListBuilder.m_171558_().m_171514_(128, 136).m_171481_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f).m_171514_(128, 200).m_171481_(-2.0f, -23.0f, 0.0f, 4.0f, 24.0f, 24.0f), PartPose.m_171419_(71.0f, -68.0f, 0.0f));
        partRoot.m_171599_("neck_2c", CubeListBuilder.m_171558_().m_171514_(128, 136).m_171481_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f).m_171514_(128, 200).m_171481_(-2.0f, -23.0f, 0.0f, 4.0f, 24.0f, 24.0f), PartPose.m_171419_(96.0f, -93.0f, -14.0f));
        partRoot.m_171599_("neck_2d", CubeListBuilder.m_171558_().m_171514_(128, 136).m_171481_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f).m_171514_(128, 200).m_171481_(-2.0f, -23.0f, 0.0f, 4.0f, 24.0f, 24.0f), PartPose.m_171419_(108.0f, -116.0f, -37.0f));
        final PartDefinition head3 = partRoot.m_171599_("head_3", CubeListBuilder.m_171558_().m_171514_(272, 0).m_171481_(-16.0f, -14.0f, -32.0f, 32.0f, 24.0f, 32.0f).m_171514_(272, 56).m_171481_(-15.0f, -2.0f, -56.0f, 30.0f, 12.0f, 24.0f).m_171514_(128, 200).m_171481_(-2.0f, -30.0f, -12.0f, 4.0f, 24.0f, 24.0f), PartPose.m_171419_(-108.0f, -24.0f, -53.0f));
        head3.m_171599_("jaw_3", CubeListBuilder.m_171558_().m_171514_(272, 92).m_171481_(-15.0f, 0.0f, -48.0f, 30.0f, 8.0f, 48.0f), PartPose.m_171419_(0.0f, 10.0f, -4.0f));
        head3.m_171599_("frill_3", CubeListBuilder.m_171558_().m_171514_(272, 200).m_171481_(-24.0f, -40.0f, 0.0f, 48.0f, 48.0f, 4.0f), PartPose.m_171423_(0.0f, 0.0f, -10.0f, -0.5235988f, 0.0f, 0.0f));
        partRoot.m_171599_("neck_3a", CubeListBuilder.m_171558_().m_171514_(128, 136).m_171481_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f).m_171514_(128, 200).m_171481_(-2.0f, -23.0f, 0.0f, 4.0f, 24.0f, 24.0f), PartPose.m_171419_(-48.0f, -48.0f, 16.0f));
        partRoot.m_171599_("neck_3b", CubeListBuilder.m_171558_().m_171514_(128, 136).m_171481_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f).m_171514_(128, 200).m_171481_(-2.0f, -23.0f, 0.0f, 4.0f, 24.0f, 24.0f), PartPose.m_171419_(-71.0f, -43.0f, 0.0f));
        partRoot.m_171599_("neck_3c", CubeListBuilder.m_171558_().m_171514_(128, 136).m_171481_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f).m_171514_(128, 200).m_171481_(-2.0f, -23.0f, 0.0f, 4.0f, 24.0f, 24.0f), PartPose.m_171419_(-96.0f, -33.0f, -14.0f));
        partRoot.m_171599_("neck_3d", CubeListBuilder.m_171558_().m_171514_(128, 136).m_171481_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f).m_171514_(128, 200).m_171481_(-2.0f, -23.0f, 0.0f, 4.0f, 24.0f, 24.0f), PartPose.m_171419_(-108.0f, -24.0f, -37.0f));
        return LayerDefinition.m_171565_(mesh, 512, 256);
    }
    
    public ModelPart m_142109_() {
        return this.root;
    }
    
    public void m_7695_(final PoseStack p_170625_, final VertexConsumer p_170626_, final int p_170627_, final int p_170628_, final float p_170629_, final float p_170630_, final float p_170631_, final float p_170632_) {
        this.leg1.m_104306_(p_170625_, p_170626_, p_170627_, p_170628_, p_170629_, p_170630_, p_170631_, p_170632_);
        this.leg2.m_104306_(p_170625_, p_170626_, p_170627_, p_170628_, p_170629_, p_170630_, p_170631_, p_170632_);
        this.body.m_104306_(p_170625_, p_170626_, p_170627_, p_170628_, p_170629_, p_170630_, p_170631_, p_170632_);
        this.tail.m_104306_(p_170625_, p_170626_, p_170627_, p_170628_, p_170629_, p_170630_, p_170631_, p_170632_);
    }
    
    public void setupAnim(final Hydra entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.leg1.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.leg2.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f + 3.141593f) * 1.4f * limbSwingAmount;
        this.leg1.f_104204_ = 0.0f;
        this.leg2.f_104204_ = 0.0f;
    }
    
    public float getRotationY(final Hydra hydra, final HydraPart whichHead, final float time) {
        final float yawOffset = hydra.f_20884_ + (hydra.f_20883_ - hydra.f_20884_) * time;
        final float yaw = whichHead.f_19859_ + (whichHead.m_146908_() - whichHead.f_19859_) * time;
        return (yaw - yawOffset) / 57.29578f;
    }
    
    public float getRotationX(final Hydra hydra, final HydraPart whichHead, final float time) {
        return (whichHead.f_19860_ + (whichHead.m_146909_() - whichHead.f_19860_) * time) / 57.29578f;
    }
}
