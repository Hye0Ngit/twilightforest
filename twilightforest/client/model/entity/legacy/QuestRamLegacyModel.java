// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity.legacy;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.item.DyeColor;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import java.util.Arrays;
import net.minecraft.client.model.geom.ModelPart;
import twilightforest.entity.passive.QuestRam;
import net.minecraft.client.model.HierarchicalModel;

public class QuestRamLegacyModel extends HierarchicalModel<QuestRam>
{
    public ModelPart root;
    ModelPart rearbody;
    public ModelPart leg1;
    public ModelPart haunch1;
    public ModelPart leg2;
    public ModelPart haunch2;
    public ModelPart leg3;
    public ModelPart haunch3;
    public ModelPart leg4;
    public ModelPart haunch4;
    public ModelPart neck;
    public ModelPart head;
    public ModelPart[] segments;
    int[] colorOrder;
    
    public QuestRamLegacyModel(final ModelPart root) {
        this.segments = new ModelPart[16];
        this.colorOrder = new int[] { 0, 8, 7, 15, 14, 1, 4, 5, 13, 3, 9, 11, 10, 2, 6, 12 };
        this.root = root;
        this.head = root.m_171324_("head");
        this.neck = root.m_171324_("neck");
        this.rearbody = root.m_171324_("rear_body");
        this.haunch1 = root.m_171324_("right_front_haunch");
        this.leg1 = root.m_171324_("right_front_leg");
        this.haunch2 = root.m_171324_("left_front_haunch");
        this.leg2 = root.m_171324_("left_front_leg");
        this.haunch3 = root.m_171324_("right_back_haunch");
        this.leg3 = root.m_171324_("right_back_leg");
        this.haunch4 = root.m_171324_("left_back_haunch");
        this.leg4 = root.m_171324_("left_back_leg");
        Arrays.setAll(this.segments, num -> root.m_171324_(getSegmentName(num)));
        for (int i = 0; i < 16; ++i) {
            this.segments[i].f_104207_ = false;
        }
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = new MeshDefinition();
        final PartDefinition base = mesh.m_171576_();
        final PartDefinition headpart = base.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 70).m_171481_(-6.0f, -4.5f, -15.0f, 12.0f, 9.0f, 15.0f).m_171514_(0, 94).m_171481_(5.0f, -9.0f, -7.0f, 4.0f, 4.0f, 6.0f).m_171514_(20, 96).m_171481_(7.0f, -8.0f, -2.0f, 3.0f, 4.0f, 4.0f).m_171514_(34, 95).m_171481_(8.0f, -6.0f, 0.0f, 3.0f, 6.0f, 3.0f).m_171514_(46, 98).m_171481_(9.5f, -2.0f, -2.0f, 3.0f, 3.0f, 3.0f).m_171514_(58, 95).m_171481_(11.0f, 0.0f, -7.0f, 3.0f, 3.0f, 6.0f).m_171514_(76, 95).m_171481_(12.0f, -4.0f, -9.0f, 3.0f, 6.0f, 3.0f).m_171514_(88, 97).m_171481_(13.0f, -6.0f, -7.0f, 3.0f, 3.0f, 4.0f).m_171514_(0, 94).m_171481_(-9.0f, -9.0f, -7.0f, 4.0f, 4.0f, 6.0f).m_171514_(20, 96).m_171481_(-10.0f, -8.0f, -2.0f, 3.0f, 4.0f, 4.0f).m_171514_(34, 95).m_171481_(-11.0f, -6.0f, 0.0f, 3.0f, 6.0f, 3.0f).m_171514_(46, 98).m_171481_(-12.5f, -2.0f, -2.0f, 3.0f, 3.0f, 3.0f).m_171514_(58, 95).m_171481_(-14.0f, 0.0f, -7.0f, 3.0f, 3.0f, 6.0f).m_171514_(76, 95).m_171481_(-15.0f, -4.0f, -9.0f, 3.0f, 6.0f, 3.0f).m_171514_(88, 97).m_171481_(-16.0f, -6.0f, -7.0f, 3.0f, 3.0f, 4.0f), PartPose.m_171419_(0.0f, -13.0f, -5.0f));
        headpart.m_171599_("nose", CubeListBuilder.m_171558_().m_171514_(54, 73).m_171481_(-5.5f, -5.0f, -13.0f, 11.0f, 9.0f, 12.0f), PartPose.m_171423_(0.0f, -7.0f, -1.0f, 0.5235988f, 0.0f, 0.0f));
        base.m_171599_("neck", CubeListBuilder.m_171558_().m_171514_(66, 37).m_171481_(-5.5f, -8.0f, -8.0f, 11.0f, 14.0f, 12.0f), PartPose.m_171423_(0.0f, -8.0f, -7.0f, 0.2617994f, 0.0f, 0.0f));
        base.m_171599_("front_body", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-9.0f, -7.5f, -15.0f, 18.0f, 15.0f, 15.0f), PartPose.m_171419_(0.0f, -1.0f, 2.0f));
        base.m_171599_("rear_body", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171481_(-9.0f, -7.5f, 0.0f, 18.0f, 15.0f, 15.0f), PartPose.m_171419_(0.0f, -1.0f, 4.0f));
        base.m_171599_("right_front_haunch", CubeListBuilder.m_171558_().m_171514_(90, 0).m_171481_(-3.5f, 0.0f, -6.0f, 7.0f, 10.0f, 10.0f), PartPose.m_171419_(-6.0f, 2.0f, 13.0f));
        base.m_171599_("right_front_leg", CubeListBuilder.m_171558_().m_171514_(66, 0).m_171481_(-3.0f, 10.0f, -3.0f, 6.0f, 12.0f, 6.0f), PartPose.m_171419_(-6.0f, 2.0f, 13.0f));
        base.m_171599_("left_front_haunch", CubeListBuilder.m_171558_().m_171514_(90, 0).m_171481_(-3.5f, 0.0f, -6.0f, 7.0f, 10.0f, 10.0f), PartPose.m_171419_(6.0f, 2.0f, 13.0f));
        base.m_171599_("left_front_leg", CubeListBuilder.m_171558_().m_171514_(66, 0).m_171481_(-3.0f, 10.0f, -3.0f, 6.0f, 12.0f, 6.0f), PartPose.m_171419_(6.0f, 2.0f, 13.0f));
        base.m_171599_("right_back_haunch", CubeListBuilder.m_171558_().m_171514_(90, 20).m_171481_(-3.5f, 0.0f, -4.0f, 7.0f, 10.0f, 7.0f), PartPose.m_171419_(-6.0f, 1.0f, -8.0f));
        base.m_171599_("right_back_leg", CubeListBuilder.m_171558_().m_171514_(66, 18).m_171481_(-3.0f, 10.0f, -3.0f, 6.0f, 13.0f, 6.0f), PartPose.m_171419_(-6.0f, 1.0f, -8.0f));
        base.m_171599_("left_back_haunch", CubeListBuilder.m_171558_().m_171514_(90, 20).m_171481_(-3.5f, 0.0f, -4.0f, 7.0f, 10.0f, 7.0f), PartPose.m_171419_(6.0f, 1.0f, -8.0f));
        base.m_171599_("left_back_leg", CubeListBuilder.m_171558_().m_171514_(66, 18).m_171481_(-3.0f, 10.0f, -3.0f, 6.0f, 13.0f, 6.0f), PartPose.m_171419_(6.0f, 1.0f, -8.0f));
        final CubeListBuilder bodycube = CubeListBuilder.m_171558_().m_171514_(0, 104).m_171481_(-9.0f, -7.5f, 0.0f, 18.0f, 15.0f, 2.0f);
        for (int i = 0; i < 16; ++i) {
            base.m_171599_(getSegmentName(i), bodycube, PartPose.m_171419_(0.0f, -1.0f, 2.0f));
        }
        return LayerDefinition.m_171565_(mesh, 128, 128);
    }
    
    private static String getSegmentName(final int num) {
        return "segment" + num;
    }
    
    public ModelPart m_142109_() {
        return this.root;
    }
    
    public void m_7695_(final PoseStack stack, final VertexConsumer builder, final int light, final int overlay, final float red, final float green, final float blue, final float alpha) {
        super.m_7695_(stack, builder, light, overlay, red, green, blue, alpha);
        for (int i = 0; i < 16; ++i) {
            final float[] dyeRgb = Sheep.m_29829_(DyeColor.m_41053_(i));
            this.segments[i].m_104306_(stack, builder, light, overlay, dyeRgb[0], dyeRgb[1], dyeRgb[2], alpha);
        }
    }
    
    public void setupAnim(final QuestRam entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.head.f_104203_ = headPitch / 57.295776f;
        this.head.f_104204_ = netHeadYaw / 57.295776f;
        this.neck.f_104204_ = this.head.f_104204_;
        this.leg1.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f) * 1.4f * limbSwingAmount * 0.5f;
        this.leg2.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount * 0.5f;
        this.leg3.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount * 0.5f;
        this.leg4.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f) * 1.4f * limbSwingAmount * 0.5f;
        this.haunch1.f_104203_ = this.leg1.f_104203_;
        this.haunch2.f_104203_ = this.leg2.f_104203_;
        this.haunch3.f_104203_ = this.leg3.f_104203_;
        this.haunch4.f_104203_ = this.leg4.f_104203_;
    }
    
    public void prepareMobModel(final QuestRam entity, final float limbSwing, final float limbSwingAmount, final float partialTicks) {
        final int count = entity.countColorsSet();
        this.rearbody.f_104202_ = (float)(2 + 2 * count);
        this.leg1.f_104202_ = (float)(11 + 2 * count);
        this.leg2.f_104202_ = (float)(11 + 2 * count);
        this.haunch1.f_104202_ = (float)(11 + 2 * count);
        this.haunch2.f_104202_ = (float)(11 + 2 * count);
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
