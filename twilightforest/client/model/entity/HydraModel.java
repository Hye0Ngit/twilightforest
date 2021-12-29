// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import twilightforest.entity.boss.Hydra;
import net.minecraft.client.model.HierarchicalModel;

@OnlyIn(Dist.CLIENT)
public class HydraModel extends HierarchicalModel<Hydra>
{
    public ModelPart root;
    public ModelPart body;
    public ModelPart tail;
    public ModelPart rightLeg;
    public ModelPart leftLeg;
    
    public HydraModel(final ModelPart root) {
        this.root = root;
        this.body = root.m_171324_("torso");
        this.tail = root.m_171324_("tail_1");
        this.rightLeg = root.m_171324_("right_leg");
        this.leftLeg = root.m_171324_("left_leg");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = new MeshDefinition();
        final PartDefinition partRoot = mesh.m_171576_();
        final PartDefinition head1 = partRoot.m_171599_("head_1", CubeListBuilder.m_171558_().m_171514_(260, 64).m_171481_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f).m_171514_(236, 128).m_171481_(-16.0f, -2.0f, -40.0f, 32.0f, 10.0f, 24.0f).m_171514_(356, 70).m_171481_(-12.0f, 8.0f, -36.0f, 24.0f, 6.0f, 20.0f), PartPose.m_171419_(-8.0f, -24.0f, -16.0f));
        final PartDefinition head2 = partRoot.m_171599_("head_2", CubeListBuilder.m_171558_().m_171514_(260, 64).m_171481_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f).m_171514_(236, 128).m_171481_(-16.0f, -2.0f, -40.0f, 32.0f, 10.0f, 24.0f).m_171514_(356, 70).m_171481_(-12.0f, 8.0f, -36.0f, 24.0f, 6.0f, 20.0f), PartPose.m_171419_(0.0f, -32.0f, -16.0f));
        final PartDefinition head3 = partRoot.m_171599_("head_3", CubeListBuilder.m_171558_().m_171514_(260, 64).m_171481_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f).m_171514_(236, 128).m_171481_(-16.0f, -2.0f, -40.0f, 32.0f, 10.0f, 24.0f).m_171514_(356, 70).m_171481_(-12.0f, 8.0f, -36.0f, 24.0f, 6.0f, 20.0f), PartPose.m_171419_(8.0f, -24.0f, -16.0f));
        head1.m_171599_("mouth_1", CubeListBuilder.m_171558_().m_171514_(240, 162).m_171481_(-15.0f, 0.0f, -24.0f, 30.0f, 8.0f, 24.0f), PartPose.m_171419_(0.0f, 8.0f, -16.0f));
        head2.m_171599_("mouth_2", CubeListBuilder.m_171558_().m_171514_(240, 162).m_171481_(-15.0f, 0.0f, -24.0f, 30.0f, 8.0f, 24.0f), PartPose.m_171419_(0.0f, 8.0f, -16.0f));
        head3.m_171599_("mouth_3", CubeListBuilder.m_171558_().m_171514_(240, 162).m_171481_(-15.0f, 0.0f, -24.0f, 30.0f, 8.0f, 24.0f), PartPose.m_171419_(0.0f, 8.0f, -16.0f));
        head1.m_171599_("plate_1", CubeListBuilder.m_171558_().m_171514_(388, 0).m_171481_(-24.0f, -48.0f, 0.0f, 48.0f, 48.0f, 6.0f).m_171514_(220, 0).m_171481_(-4.0f, -32.0f, -8.0f, 8.0f, 32.0f, 8.0f), PartPose.m_171423_(0.0f, 0.0f, -1.0f, -0.7853982f, 0.0f, 0.0f));
        head2.m_171599_("plate_2", CubeListBuilder.m_171558_().m_171514_(388, 0).m_171481_(-24.0f, -48.0f, 0.0f, 48.0f, 48.0f, 6.0f).m_171514_(220, 0).m_171481_(-4.0f, -32.0f, -8.0f, 8.0f, 32.0f, 8.0f), PartPose.m_171423_(0.0f, 0.0f, -1.0f, -0.7853982f, 0.0f, 0.0f));
        head3.m_171599_("plate_3", CubeListBuilder.m_171558_().m_171514_(388, 0).m_171481_(-24.0f, -48.0f, 0.0f, 48.0f, 48.0f, 6.0f).m_171514_(220, 0).m_171481_(-4.0f, -32.0f, -8.0f, 8.0f, 32.0f, 8.0f), PartPose.m_171423_(0.0f, 0.0f, -1.0f, -0.7853982f, 0.0f, 0.0f));
        final PartDefinition neck1 = partRoot.m_171599_("neck_1", CubeListBuilder.m_171558_().m_171514_(260, 0).m_171481_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f).m_171514_(0, 0).m_171481_(-2.0f, -24.0f, 0.0f, 4.0f, 8.0f, 16.0f), PartPose.m_171419_(-42.0f, -48.0f, 0.0f));
        final PartDefinition neck2 = partRoot.m_171599_("neck_2", CubeListBuilder.m_171558_().m_171514_(260, 0).m_171481_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f).m_171514_(0, 0).m_171481_(-2.0f, -24.0f, 0.0f, 4.0f, 8.0f, 16.0f), PartPose.m_171419_(0.0f, -58.0f, -16.0f));
        final PartDefinition neck3 = partRoot.m_171599_("neck_3", CubeListBuilder.m_171558_().m_171514_(260, 0).m_171481_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f).m_171514_(0, 0).m_171481_(-2.0f, -24.0f, 0.0f, 4.0f, 8.0f, 16.0f), PartPose.m_171419_(42.0f, -48.0f, 0.0f));
        final PartDefinition neck4 = neck1.m_171599_("neck_4", CubeListBuilder.m_171558_().m_171514_(260, 0).m_171481_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f).m_171514_(0, 0).m_171481_(-2.0f, -24.0f, 0.0f, 4.0f, 8.0f, 16.0f), PartPose.m_171419_(-16.0f, -24.0f, -16.0f));
        final PartDefinition neck5 = neck2.m_171599_("neck_5", CubeListBuilder.m_171558_().m_171514_(260, 0).m_171481_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f).m_171514_(0, 0).m_171481_(-2.0f, -24.0f, 0.0f, 4.0f, 8.0f, 16.0f), PartPose.m_171419_(-16.0f, -24.0f, -16.0f));
        final PartDefinition neck6 = neck3.m_171599_("neck_6", CubeListBuilder.m_171558_().m_171514_(260, 0).m_171481_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f).m_171514_(0, 0).m_171481_(-2.0f, -24.0f, 0.0f, 4.0f, 8.0f, 16.0f), PartPose.m_171419_(-8.0f, -24.0f, -16.0f));
        neck4.m_171599_("neck_7", CubeListBuilder.m_171558_().m_171514_(260, 0).m_171481_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f).m_171514_(0, 0).m_171481_(-2.0f, -24.0f, 0.0f, 4.0f, 8.0f, 16.0f), PartPose.m_171419_(8.0f, -24.0f, -16.0f));
        neck5.m_171599_("neck_8", CubeListBuilder.m_171558_().m_171514_(260, 0).m_171481_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f).m_171514_(0, 0).m_171481_(-2.0f, -24.0f, 0.0f, 4.0f, 8.0f, 16.0f), PartPose.m_171419_(16.0f, -24.0f, -16.0f));
        neck6.m_171599_("neck_9", CubeListBuilder.m_171558_().m_171514_(260, 0).m_171481_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f).m_171514_(0, 0).m_171481_(-2.0f, -24.0f, 0.0f, 4.0f, 8.0f, 16.0f), PartPose.m_171419_(16.0f, -24.0f, -16.0f));
        partRoot.m_171599_("torso", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-45.0f, -12.0f, -20.0f, 90.0f, 96.0f, 40.0f).m_171514_(88, 136).m_171481_(-2.0f, 20.0f, 20.0f, 4.0f, 16.0f, 12.0f).m_171514_(120, 136).m_171481_(-2.0f, 48.0f, 20.0f, 4.0f, 16.0f, 12.0f), PartPose.m_171423_(0.0f, -32.0f, 0.0f, 1.1170107f, 0.0f, 0.0f));
        partRoot.m_171599_("right_leg", CubeListBuilder.m_171558_().m_171514_(0, 136).m_171481_(-14.0f, -8.0f, -16.0f, 28.0f, 52.0f, 32.0f).m_171514_(0, 220).m_171481_(-14.0f, 36.0f, -22.0f, 28.0f, 8.0f, 6.0f), PartPose.m_171419_(-40.0f, -20.0f, -12.0f));
        partRoot.m_171599_("left_leg", CubeListBuilder.m_171558_().m_171514_(120, 136).m_171481_(-14.0f, -8.0f, -16.0f, 28.0f, 52.0f, 32.0f).m_171514_(68, 220).m_171481_(-14.0f, 36.0f, -22.0f, 28.0f, 8.0f, 6.0f), PartPose.m_171419_(40.0f, -20.0f, -12.0f));
        final PartDefinition tail1 = partRoot.m_171599_("tail_1", CubeListBuilder.m_171558_().m_171514_(260, 0).m_171481_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f).m_171514_(0, 0).m_171481_(-2.0f, -24.0f, 0.0f, 4.0f, 8.0f, 16.0f), PartPose.m_171419_(0.0f, 8.0f, 80.0f));
        final PartDefinition tail2 = tail1.m_171599_("tail_2", CubeListBuilder.m_171558_().m_171514_(260, 0).m_171481_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f).m_171514_(0, 0).m_171481_(-2.0f, -24.0f, 0.0f, 4.0f, 8.0f, 16.0f), PartPose.m_171419_(0.0f, 0.0f, 32.0f));
        final PartDefinition tail3 = tail2.m_171599_("tail_3", CubeListBuilder.m_171558_().m_171514_(260, 0).m_171481_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f).m_171514_(0, 0).m_171481_(-2.0f, -24.0f, 0.0f, 4.0f, 8.0f, 16.0f), PartPose.m_171419_(0.0f, 0.0f, 32.0f));
        tail3.m_171599_("tail_4", CubeListBuilder.m_171558_().m_171514_(260, 0).m_171481_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f).m_171514_(0, 0).m_171481_(-2.0f, -24.0f, 0.0f, 4.0f, 8.0f, 16.0f), PartPose.m_171419_(0.0f, 0.0f, 32.0f));
        return LayerDefinition.m_171565_(mesh, 512, 256);
    }
    
    public ModelPart m_142109_() {
        return this.root;
    }
    
    public void m_7695_(final PoseStack p_170625_, final VertexConsumer p_170626_, final int p_170627_, final int p_170628_, final float p_170629_, final float p_170630_, final float p_170631_, final float p_170632_) {
        this.leftLeg.m_104306_(p_170625_, p_170626_, p_170627_, p_170628_, p_170629_, p_170630_, p_170631_, p_170632_);
        this.rightLeg.m_104306_(p_170625_, p_170626_, p_170627_, p_170628_, p_170629_, p_170630_, p_170631_, p_170632_);
        this.body.m_104306_(p_170625_, p_170626_, p_170627_, p_170628_, p_170629_, p_170630_, p_170631_, p_170632_);
        this.tail.m_104306_(p_170625_, p_170626_, p_170627_, p_170628_, p_170629_, p_170630_, p_170631_, p_170632_);
    }
    
    public void setupAnim(final Hydra entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.leftLeg.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.rightLeg.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f + 3.141593f) * 1.4f * limbSwingAmount;
        this.leftLeg.f_104204_ = 0.0f;
        this.rightLeg.f_104204_ = 0.0f;
    }
}
