// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import twilightforest.entity.passive.TinyBird;
import net.minecraft.client.model.AgeableListModel;

@OnlyIn(Dist.CLIENT)
public class TinyBirdModel extends AgeableListModel<TinyBird>
{
    public ModelPart head;
    public ModelPart body;
    public ModelPart rightFoot;
    public ModelPart leftFoot;
    public ModelPart rightWing;
    public ModelPart leftWing;
    public ModelPart tail;
    
    public TinyBirdModel(final ModelPart root) {
        this.body = root.m_171324_("body");
        this.head = root.m_171324_("head");
        this.rightFoot = root.m_171324_("right_foot");
        this.leftFoot = root.m_171324_("left_foot");
        this.rightWing = this.body.m_171324_("right_wing");
        this.leftWing = this.body.m_171324_("left_wing");
        this.tail = this.body.m_171324_("tail");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = new MeshDefinition();
        final PartDefinition partRoot = mesh.m_171576_();
        partRoot.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-1.5f, -2.0f, -2.0f, 3.0f, 3.0f, 3.0f).m_171514_(9, 0).m_171481_(-0.5f, 0.0f, -3.0f, 1.0f, 1.0f, 1.0f).m_171514_(0, 6).m_171481_(-1.5f, -5.0f, 1.0f, 3.0f, 3.0f, 0.0f), PartPose.m_171419_(0.0f, 21.0f, 0.0f));
        final PartDefinition body = partRoot.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(12, 0).m_171481_(-1.5f, 0.0f, 0.0f, 3.0f, 3.0f, 3.0f), PartPose.m_171419_(0.0f, 20.0f, 0.0f));
        partRoot.m_171599_("right_foot", CubeListBuilder.m_171558_().m_171514_(0, 9).m_171481_(-0.5f, 0.0f, -1.0f, 1.0f, 1.0f, 1.0f), PartPose.m_171419_(-1.0f, 23.0f, 2.0f));
        partRoot.m_171599_("left_foot", CubeListBuilder.m_171558_().m_171514_(0, 11).m_171481_(-0.5f, 0.0f, -1.0f, 1.0f, 1.0f, 1.0f), PartPose.m_171419_(1.0f, 23.0f, 2.0f));
        body.m_171599_("right_wing", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171481_(-0.5f, 0.0f, -1.0f, 1.0f, 2.0f, 3.0f), PartPose.m_171419_(-2.0f, 0.0f, 1.0f));
        body.m_171599_("left_wing", CubeListBuilder.m_171558_().m_171514_(24, 5).m_171481_(-0.5f, 0.0f, -1.0f, 1.0f, 2.0f, 3.0f), PartPose.m_171419_(2.0f, 0.0f, 1.0f));
        body.m_171599_("tail", CubeListBuilder.m_171558_().m_171514_(1, 6).m_171481_(-2.5f, 0.0f, 0.0f, 5.0f, 0.0f, 5.0f), PartPose.m_171423_(0.0f, 1.0f, 3.0f, 0.43633232f, 0.0f, 0.0f));
        return LayerDefinition.m_171565_(mesh, 32, 32);
    }
    
    protected Iterable<ModelPart> m_5607_() {
        return (Iterable<ModelPart>)ImmutableList.of((Object)this.head);
    }
    
    protected Iterable<ModelPart> m_5608_() {
        return (Iterable<ModelPart>)ImmutableList.of((Object)this.head, (Object)this.body, (Object)this.rightFoot, (Object)this.leftFoot);
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
        this.rightFoot.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.leftFoot.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.rightWing.f_104205_ = ageInTicks;
        this.leftWing.f_104205_ = -ageInTicks;
        if (entity.isBirdLanded()) {
            this.rightFoot.f_104201_ = 23.0f;
            this.leftFoot.f_104201_ = 23.0f;
        }
        else {
            this.rightFoot.f_104201_ = 22.5f;
            this.leftFoot.f_104201_ = 22.5f;
        }
    }
}
