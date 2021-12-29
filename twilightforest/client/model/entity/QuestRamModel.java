// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.item.DyeColor;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import twilightforest.entity.passive.QuestRam;
import net.minecraft.client.model.QuadrupedModel;

@OnlyIn(Dist.CLIENT)
public class QuestRamModel extends QuadrupedModel<QuestRam>
{
    public ModelPart horns;
    public ModelPart backtorso;
    public ModelPart frontTorso;
    public ModelPart[] segments;
    int[] colorOrder;
    
    public QuestRamModel(final ModelPart root) {
        super(root, false, 4.0f, 4.0f, 2.0f, 2.0f, 24);
        this.segments = new ModelPart[16];
        this.colorOrder = new int[] { 0, 8, 7, 15, 14, 1, 4, 5, 13, 3, 9, 11, 10, 2, 6, 12 };
        this.horns = root.m_171324_("horns");
        this.backtorso = root.m_171324_("back_torso");
        this.frontTorso = root.m_171324_("front_torso");
        for (int i = 0; i < 16; ++i) {
            this.segments[i] = this.frontTorso.m_171324_("segment_" + i);
        }
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = QuadrupedModel.m_170864_(16, CubeDeformation.f_171458_);
        final PartDefinition partRoot = mesh.m_171576_();
        final PartDefinition horns = partRoot.m_171599_("horns", CubeListBuilder.m_171558_().m_171514_(64, 0).m_171481_(-9.0f, -11.0f, -1.0f, 4.0f, 10.0f, 10.0f).m_171514_(48, 0).m_171481_(-13.0f, -11.0f, 5.0f, 4.0f, 4.0f, 4.0f).m_171514_(92, 0).m_171481_(5.0f, -11.0f, -1.0f, 4.0f, 10.0f, 10.0f).m_171514_(110, 0).m_171481_(9.0f, -11.0f, 5.0f, 4.0f, 4.0f, 4.0f), PartPose.m_171419_(0.0f, -10.0f, -8.0f));
        horns.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(74, 70).m_171481_(-6.0f, -2.0f, -13.0f, 12.0f, 8.0f, 15.0f).m_171514_(42, 71).m_171481_(-6.0f, -5.0f, -9.0f, 12.0f, 3.0f, 11.0f), PartPose.m_171423_(0.0f, -4.0f, 3.0f, 0.43633232f, 0.0f, 0.0f));
        final PartDefinition frontTorso = partRoot.m_171599_("front_torso", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-8.0f, -7.0f, -6.0f, 16.0f, 14.0f, 16.0f), PartPose.m_171419_(0.0f, 0.0f, 0.0f));
        frontTorso.m_171599_("neck", CubeListBuilder.m_171558_().m_171514_(84, 93).m_171481_(-5.0f, -11.0f, -2.0f, 10.0f, 12.0f, 12.0f), PartPose.m_171423_(0.0f, 2.0f, -3.0f, 0.61086524f, 0.0f, 0.0f));
        partRoot.m_171599_("back_torso", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171481_(-8.0f, -7.0f, 8.0f, 16.0f, 14.0f, 16.0f), PartPose.m_171419_(0.0f, 0.0f, 6.0f));
        partRoot.m_171599_("right_front_leg", CubeListBuilder.m_171558_().m_171514_(0, 60).m_171481_(-3.0f, 2.0f, -3.0f, 6.0f, 16.0f, 6.0f).m_171514_(54, 20).m_171481_(-4.0f, -4.0f, -5.0f, 8.0f, 10.0f, 10.0f), PartPose.m_171419_(-5.0f, 6.0f, 0.0f));
        partRoot.m_171599_("left_front_leg", CubeListBuilder.m_171558_().m_171514_(24, 60).m_171481_(-3.0f, 2.0f, -3.0f, 6.0f, 16.0f, 6.0f).m_171514_(90, 20).m_171481_(-4.0f, -4.0f, -5.0f, 8.0f, 10.0f, 10.0f), PartPose.m_171419_(5.0f, 6.0f, 0.0f));
        partRoot.m_171599_("right_hind_leg", CubeListBuilder.m_171558_().m_171514_(0, 82).m_171481_(7.0f, 2.0f, -5.0f, 6.0f, 16.0f, 6.0f).m_171514_(54, 50).m_171481_(6.0f, -4.0f, -7.0f, 8.0f, 10.0f, 10.0f), PartPose.m_171419_(-16.0f, 6.0f, 0.0f));
        partRoot.m_171599_("left_hind_leg", CubeListBuilder.m_171558_().m_171514_(24, 82).m_171481_(-13.0f, 2.0f, -5.0f, 6.0f, 16.0f, 6.0f).m_171514_(90, 50).m_171481_(-14.0f, -4.0f, -7.0f, 8.0f, 10.0f, 10.0f), PartPose.m_171419_(16.0f, 6.0f, 0.0f));
        for (int i = 0; i < 16; ++i) {
            frontTorso.m_171599_("segment_" + i, CubeListBuilder.m_171558_().m_171514_(0, 112).m_171481_(-8.0f, -7.0f, 8.0f, 16.0f, 14.0f, 2.0f), PartPose.m_171419_(0.0f, 0.0f, 10.0f));
        }
        return LayerDefinition.m_171565_(mesh, 128, 128);
    }
    
    protected Iterable<ModelPart> m_5607_() {
        return (Iterable<ModelPart>)ImmutableList.of((Object)this.horns);
    }
    
    protected Iterable<ModelPart> m_5608_() {
        return (Iterable<ModelPart>)ImmutableList.of((Object)this.horns, (Object)this.frontTorso, (Object)this.backtorso, (Object)this.f_170854_, (Object)this.f_170855_, (Object)this.f_170852_, (Object)this.f_170853_);
    }
    
    public void m_7695_(final PoseStack stack, final VertexConsumer builder, final int light, final int overlay, final float red, final float green, final float blue, final float alpha) {
        super.m_7695_(stack, builder, light, overlay, red, green, blue, alpha);
        for (int i = 0; i < 16; ++i) {
            final float[] dyeRgb = Sheep.m_29829_(DyeColor.m_41053_(i));
            this.segments[i].m_104306_(stack, builder, light, overlay, dyeRgb[0], dyeRgb[1], dyeRgb[2], alpha);
        }
    }
    
    public void setupAnim(final QuestRam entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.horns.f_104203_ = headPitch / 57.295776f;
        this.horns.f_104204_ = netHeadYaw / 57.295776f;
        this.f_170853_.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f) * 1.4f * limbSwingAmount * 0.5f;
        this.f_170852_.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount * 0.5f;
        this.f_170855_.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount * 0.5f;
        this.f_170854_.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f) * 1.4f * limbSwingAmount * 0.5f;
    }
    
    public void prepareMobModel(final QuestRam entity, final float limbSwing, final float limbSwingAmount, final float partialTicks) {
        final int count = entity.countColorsSet();
        this.backtorso.f_104202_ = (float)(2 + 2 * count);
        this.f_170853_.f_104202_ = (float)(25 + 2 * count);
        this.f_170852_.f_104202_ = (float)(25 + 2 * count);
        int segmentOffset = 2;
        for (final int color : this.colorOrder) {
            if (entity.isColorPresent(DyeColor.m_41053_(color))) {
                this.segments[color].f_104207_ = true;
                this.segments[color].f_104202_ = (float)segmentOffset;
                segmentOffset += 2;
            }
            else {
                this.segments[color].f_104207_ = false;
            }
        }
    }
}
