// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import twilightforest.entity.passive.DwarfRabbit;
import net.minecraft.client.model.QuadrupedModel;

public class BunnyModel extends QuadrupedModel<DwarfRabbit>
{
    public BunnyModel(final ModelPart root) {
        super(root, false, 4.0f, 4.0f, 2.0f, 2.0f, 24);
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = QuadrupedModel.m_170864_(1, CubeDeformation.f_171458_);
        final PartDefinition partRoot = mesh.m_171576_();
        partRoot.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 8).m_171481_(-2.0f, -1.0f, -2.0f, 4.0f, 3.0f, 5.0f).m_171514_(0, 18).m_171481_(-1.0f, -2.0f, 3.0f, 2.0f, 2.0f, 2.0f).m_171480_(), PartPose.m_171419_(0.0f, 21.0f, 0.0f));
        partRoot.m_171599_("left_hind_leg", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171481_(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f).m_171480_(), PartPose.m_171419_(-2.0f, 23.0f, 2.0f));
        partRoot.m_171599_("right_hind_leg", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171481_(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f).m_171480_(), PartPose.m_171419_(1.0f, 23.0f, 2.0f));
        partRoot.m_171599_("left_front_leg", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171481_(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f).m_171480_(), PartPose.m_171419_(-2.0f, 23.0f, -2.0f));
        partRoot.m_171599_("right_front_leg", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171481_(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f).m_171480_(), PartPose.m_171419_(1.0f, 23.0f, -2.0f));
        partRoot.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.0f, -4.0f, -3.0f, 4.0f, 4.0f, 4.0f, new CubeDeformation(0.1f)).m_171514_(16, 0).m_171481_(-2.5f, -8.0f, -0.5f, 2.0f, 4.0f, 1.0f).m_171514_(16, 0).m_171481_(0.5f, -8.0f, -0.5f, 2.0f, 4.0f, 1.0f).m_171480_(), PartPose.m_171419_(0.0f, 22.0f, -1.0f));
        return LayerDefinition.m_171565_(mesh, 32, 32);
    }
    
    public void m_7695_(final PoseStack ms, final VertexConsumer buffer, final int light, final int overlay, final float red, final float green, final float blue, final float alpha) {
        if (this.f_102610_) {
            ms.m_85836_();
            ms.m_85841_(0.85f, 0.85f, 0.85f);
            ms.m_85837_(0.0, 0.25, 0.0);
            ImmutableList.of((Object)this.f_103492_).forEach(p_103597_ -> p_103597_.m_104306_(ms, buffer, light, overlay, red, green, blue, alpha));
            ms.m_85849_();
            ms.m_85836_();
            ms.m_85841_(0.8f, 0.8f, 0.8f);
            ms.m_85837_(0.0, 0.3700000047683716, 0.0);
            ImmutableList.of((Object)this.f_103493_, (Object)this.f_170855_, (Object)this.f_170854_, (Object)this.f_170853_, (Object)this.f_170852_).forEach(p_103587_ -> p_103587_.m_104306_(ms, buffer, light, overlay, red, green, blue, alpha));
            ms.m_85849_();
        }
        else {
            super.m_7695_(ms, buffer, light, overlay, red, green, blue, alpha);
        }
    }
    
    public void setupAnim(final DwarfRabbit entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.f_103492_.f_104203_ = headPitch * 0.017453292f;
        this.f_103492_.f_104204_ = netHeadYaw * 0.017453292f;
        this.f_170853_.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.f_170852_.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.f_170855_.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.f_170854_.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
    }
}
