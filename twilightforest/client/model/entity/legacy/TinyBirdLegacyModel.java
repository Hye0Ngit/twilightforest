// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity.legacy;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import twilightforest.entity.passive.TinyBird;
import net.minecraft.client.model.AgeableListModel;

public class TinyBirdLegacyModel extends AgeableListModel<TinyBird>
{
    ModelPart head;
    ModelPart body;
    ModelPart rightarm;
    ModelPart leftarm;
    ModelPart rightleg;
    ModelPart leftleg;
    ModelPart tail;
    
    public TinyBirdLegacyModel(final ModelPart root) {
        this.head = root.m_171324_("head");
        this.body = root.m_171324_("body");
        this.rightarm = root.m_171324_("right_arm");
        this.leftarm = root.m_171324_("left_arm");
        this.rightleg = root.m_171324_("right_leg");
        this.leftleg = root.m_171324_("left_leg");
        this.tail = root.m_171324_("tail");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = new MeshDefinition();
        final PartDefinition partRoot = mesh.m_171576_();
        final PartDefinition head = partRoot.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-1.5f, -1.5f, -1.5f, 3.0f, 3.0f, 3.0f), PartPose.m_171419_(0.0f, 20.5f, -0.5f));
        head.m_171599_("beak", CubeListBuilder.m_171558_().m_171514_(12, 0).m_171481_(-0.5f, -0.5f, -0.5f, 1.0f, 1.0f, 1.0f), PartPose.m_171419_(0.0f, 0.5f, -2.0f));
        partRoot.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 6).m_171481_(-1.5f, 0.0f, -1.0f, 3.0f, 3.0f, 3.0f), PartPose.m_171419_(0.0f, 20.0f, 0.0f));
        partRoot.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(12, 2).m_171481_(-1.0f, 0.0f, -1.5f, 1.0f, 2.0f, 3.0f), PartPose.m_171419_(-1.5f, 20.5f, 1.0f));
        partRoot.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171480_().m_171514_(12, 2).m_171481_(0.0f, 0.0f, -1.5f, 1.0f, 2.0f, 3.0f), PartPose.m_171419_(1.5f, 20.5f, 1.0f));
        partRoot.m_171599_("right_leg", CubeListBuilder.m_171558_().m_171514_(0, 12).m_171481_(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f), PartPose.m_171419_(-1.5f, 23.0f, 0.0f));
        partRoot.m_171599_("left_leg", CubeListBuilder.m_171558_().m_171480_().m_171514_(0, 12).m_171481_(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f), PartPose.m_171419_(0.0f, 23.0f, 0.0f));
        partRoot.m_171599_("tail", CubeListBuilder.m_171558_().m_171514_(0, 14).m_171481_(-1.5f, -0.5f, 0.0f, 3.0f, 1.0f, 2.0f), PartPose.m_171419_(0.0f, 22.0f, 2.0f));
        return LayerDefinition.m_171565_(mesh, 32, 32);
    }
    
    protected Iterable<ModelPart> m_5607_() {
        return (Iterable<ModelPart>)ImmutableList.of((Object)this.head);
    }
    
    protected Iterable<ModelPart> m_5608_() {
        return (Iterable<ModelPart>)ImmutableList.of((Object)this.head, (Object)this.body, (Object)this.rightleg, (Object)this.leftleg, (Object)this.rightarm, (Object)this.leftarm, (Object)this.tail);
    }
    
    public void m_7695_(final PoseStack stack, final VertexConsumer builder, final int light, final int overlay, final float red, final float green, final float blue, final float scale) {
        if (this.f_102610_) {
            final float f = 2.0f;
            stack.m_85836_();
            stack.m_85837_(0.0, (double)(5.0f * scale), (double)(0.75f * scale));
            this.m_5607_().forEach(renderer -> renderer.m_104306_(stack, builder, light, overlay, red, green, blue, scale));
            stack.m_85849_();
            stack.m_85836_();
            stack.m_85841_(1.0f / f, 1.0f / f, 1.0f / f);
            stack.m_85837_(0.0, (double)(24.0f * scale), 0.0);
            this.m_5608_().forEach(renderer -> renderer.m_104306_(stack, builder, light, overlay, red, green, blue, scale));
            stack.m_85849_();
        }
        else {
            this.m_5607_().forEach(renderer -> renderer.m_104306_(stack, builder, light, overlay, red, green, blue, scale));
            this.m_5608_().forEach(renderer -> renderer.m_104306_(stack, builder, light, overlay, red, green, blue, scale));
        }
    }
    
    public void setupAnim(final TinyBird entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.head.f_104203_ = headPitch / 57.295776f;
        this.head.f_104204_ = netHeadYaw / 57.295776f;
        this.rightleg.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.leftleg.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.rightarm.f_104205_ = ageInTicks;
        this.leftarm.f_104205_ = -ageInTicks;
        if (entity.isBirdLanded()) {
            this.rightleg.f_104201_ = 23.0f;
            this.leftleg.f_104201_ = 23.0f;
        }
        else {
            this.rightleg.f_104201_ = 22.5f;
            this.leftleg.f_104201_ = 22.5f;
        }
    }
}
