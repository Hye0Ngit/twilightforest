// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.util.Mth;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import twilightforest.entity.passive.Penguin;
import net.minecraft.client.model.HumanoidModel;

public class PenguinModel extends HumanoidModel<Penguin>
{
    public PenguinModel(final ModelPart root) {
        super(root);
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = HumanoidModel.m_170681_(CubeDeformation.f_171458_, 0.0f);
        final PartDefinition partRoot = mesh.m_171576_();
        partRoot.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171481_(-4.0f, 0.0f, -4.0f, 8.0f, 9.0f, 8.0f), PartPose.m_171419_(0.0f, 14.0f, 0.0f));
        final PartDefinition head = partRoot.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-3.5f, -4.0f, -3.5f, 7.0f, 5.0f, 7.0f), PartPose.m_171419_(0.0f, 13.0f, 0.0f));
        partRoot.m_171599_("hat", CubeListBuilder.m_171558_(), PartPose.f_171404_);
        head.m_171599_("beak", CubeListBuilder.m_171558_().m_171514_(0, 13).m_171481_(-1.0f, 0.0f, -1.0f, 2.0f, 1.0f, 2.0f), PartPose.m_171419_(0.0f, -1.0f, -4.0f));
        partRoot.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(34, 18).m_171481_(-1.0f, -1.0f, -2.0f, 1.0f, 8.0f, 4.0f), PartPose.m_171419_(-4.0f, 15.0f, 0.0f));
        partRoot.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171514_(24, 18).m_171481_(0.0f, -1.0f, -2.0f, 1.0f, 8.0f, 4.0f), PartPose.m_171419_(4.0f, 15.0f, 0.0f));
        partRoot.m_171599_("right_leg", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171481_(-2.0f, 0.0f, -5.0f, 4.0f, 1.0f, 8.0f), PartPose.m_171419_(-2.0f, 23.0f, 0.0f));
        partRoot.m_171599_("left_leg", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171481_(-2.0f, 0.0f, -5.0f, 4.0f, 1.0f, 8.0f), PartPose.m_171419_(2.0f, 23.0f, 0.0f));
        return LayerDefinition.m_171565_(mesh, 64, 32);
    }
    
    public void m_7695_(final PoseStack stack, final VertexConsumer builder, final int light, final int overlay, final float red, final float green, final float blue, final float scale) {
        if (this.f_102610_) {
            final float f = 2.0f;
            stack.m_85836_();
            stack.m_85841_(1.0f / f, 1.0f / f, 1.0f / f);
            stack.m_85837_(0.0, (double)(1.5f * scale), 0.0);
            this.m_5607_().forEach(renderer -> renderer.m_104306_(stack, builder, light, overlay, red, green, blue, scale));
            stack.m_85849_();
            stack.m_85836_();
            stack.m_85841_(1.0f / f, 1.0f / f, 1.0f / f);
            stack.m_85837_(0.0, (double)(1.5f * scale), 0.0);
            this.m_5608_().forEach(renderer -> renderer.m_104306_(stack, builder, light, overlay, red, green, blue, scale));
            stack.m_85849_();
        }
        else {
            this.m_5607_().forEach(renderer -> renderer.m_104306_(stack, builder, light, overlay, red, green, blue, scale));
            this.m_5608_().forEach(renderer -> renderer.m_104306_(stack, builder, light, overlay, red, green, blue, scale));
        }
    }
    
    public void setupAnim(final Penguin entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.f_102808_.f_104203_ = headPitch / 57.295776f;
        this.f_102808_.f_104204_ = netHeadYaw / 57.295776f;
        this.f_102813_.f_104203_ = Mth.m_14089_(limbSwing) * 0.7f * limbSwingAmount;
        this.f_102814_.f_104203_ = Mth.m_14089_(limbSwing + 3.1415927f) * 0.7f * limbSwingAmount;
        this.f_102811_.f_104205_ = ageInTicks;
        this.f_102812_.f_104205_ = -ageInTicks;
    }
}
