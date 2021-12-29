// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.entity.Entity;
import com.google.common.collect.ImmutableList;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.DyeColor;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import twilightforest.entity.passive.QuestRamEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;

@OnlyIn(Dist.CLIENT)
public class QuestRamModel extends SegmentedModel<QuestRamEntity>
{
    public ModelRenderer rightFrontLeg;
    public ModelRenderer leftFrontLeg;
    public ModelRenderer rightBackLeg;
    public ModelRenderer leftBackLeg;
    public ModelRenderer frontTorso;
    public ModelRenderer horns;
    public ModelRenderer neck;
    public ModelRenderer backtorso;
    public ModelRenderer head;
    ModelRenderer[] segments;
    int[] colorOrder;
    
    public QuestRamModel() {
        this.colorOrder = new int[] { 0, 8, 7, 15, 14, 1, 4, 5, 13, 3, 9, 11, 10, 2, 6, 12 };
        this.field_78090_t = 128;
        this.field_78089_u = 128;
        (this.head = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, -4.0f, 3.0f);
        this.head.func_78784_a(74, 70).func_228302_a_(-6.0f, -2.0f, -13.0f, 12.0f, 8.0f, 15.0f, 0.0f, 0.0f, 0.0f);
        this.head.func_78784_a(42, 71).func_228302_a_(-6.0f, -5.0f, -9.0f, 12.0f, 3.0f, 11.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.head, 0.43633232f, 0.0f, 0.0f);
        (this.frontTorso = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.frontTorso.func_228302_a_(-8.0f, -7.0f, -6.0f, 16.0f, 14.0f, 16.0f, 0.0f, 0.0f, 0.0f);
        (this.rightFrontLeg = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-5.0f, 6.0f, 0.0f);
        this.rightFrontLeg.func_78784_a(0, 60).func_228302_a_(-3.0f, 2.0f, -3.0f, 6.0f, 16.0f, 6.0f, 0.0f, 0.0f, 0.0f);
        this.rightFrontLeg.func_78784_a(54, 20).func_228302_a_(-4.0f, -4.0f, -5.0f, 8.0f, 10.0f, 10.0f, 0.0f, 0.0f, 0.0f);
        (this.neck = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 2.0f, -3.0f);
        this.neck.func_78784_a(84, 93).func_228302_a_(-5.0f, -11.0f, -2.0f, 10.0f, 12.0f, 12.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.neck, 0.61086524f, 0.0f, 0.0f);
        (this.leftBackLeg = new ModelRenderer((Model)this, 0, 0)).func_78793_a(16.0f, 6.0f, 0.0f);
        this.leftBackLeg.func_78784_a(24, 82).func_228302_a_(-13.0f, 2.0f, -5.0f, 6.0f, 16.0f, 6.0f, 0.0f, 0.0f, 0.0f);
        this.leftBackLeg.func_78784_a(90, 50).func_228302_a_(-14.0f, -4.0f, -7.0f, 8.0f, 10.0f, 10.0f, 0.0f, 0.0f, 0.0f);
        (this.leftFrontLeg = new ModelRenderer((Model)this, 0, 0)).func_78793_a(5.0f, 6.0f, 0.0f);
        this.leftFrontLeg.func_78784_a(24, 60).func_228302_a_(-3.0f, 2.0f, -3.0f, 6.0f, 16.0f, 6.0f, 0.0f, 0.0f, 0.0f);
        this.leftFrontLeg.func_78784_a(90, 20).func_228302_a_(-4.0f, -4.0f, -5.0f, 8.0f, 10.0f, 10.0f, 0.0f, 0.0f, 0.0f);
        (this.backtorso = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 0.0f, 6.0f);
        this.backtorso.func_78784_a(0, 30).func_228302_a_(-8.0f, -7.0f, 8.0f, 16.0f, 14.0f, 16.0f, 0.0f, 0.0f, 0.0f);
        (this.horns = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, -10.0f, -8.0f);
        this.horns.func_78784_a(64, 0).func_228302_a_(-9.0f, -11.0f, -1.0f, 4.0f, 10.0f, 10.0f, 0.0f, 0.0f, 0.0f);
        this.horns.func_78784_a(48, 0).func_228302_a_(-13.0f, -11.0f, 5.0f, 4.0f, 4.0f, 4.0f, 0.0f, 0.0f, 0.0f);
        this.horns.func_78784_a(92, 0).func_228302_a_(5.0f, -11.0f, -1.0f, 4.0f, 10.0f, 10.0f, 0.0f, 0.0f, 0.0f);
        this.horns.func_78784_a(110, 0).func_228302_a_(9.0f, -11.0f, 5.0f, 4.0f, 4.0f, 4.0f, 0.0f, 0.0f, 0.0f);
        (this.rightBackLeg = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-16.0f, 6.0f, 0.0f);
        this.rightBackLeg.func_78784_a(0, 82).func_228302_a_(7.0f, 2.0f, -5.0f, 6.0f, 16.0f, 6.0f, 0.0f, 0.0f, 0.0f);
        this.rightBackLeg.func_78784_a(54, 50).func_228302_a_(6.0f, -4.0f, -7.0f, 8.0f, 10.0f, 10.0f, 0.0f, 0.0f, 0.0f);
        this.segments = new ModelRenderer[16];
        for (int i = 0; i < 16; ++i) {
            (this.segments[i] = new ModelRenderer((Model)this, 0, 112)).func_228302_a_(-8.0f, -7.0f, 8.0f, 16.0f, 14.0f, 2.0f, 0.0f, 0.0f, 0.0f);
            this.segments[i].func_78793_a(0.0f, 0.0f, 10.0f);
            this.segments[i].field_78806_j = false;
            this.frontTorso.func_78792_a(this.segments[i]);
        }
        this.horns.func_78792_a(this.head);
        this.frontTorso.func_78792_a(this.neck);
    }
    
    public void func_225598_a_(final MatrixStack stack, final IVertexBuilder builder, final int light, final int overlay, final float red, final float green, final float blue, final float alpha) {
        super.func_225598_a_(stack, builder, light, overlay, red, green, blue, alpha);
        for (int i = 0; i < 16; ++i) {
            final float[] dyeRgb = SheepEntity.func_175513_a(DyeColor.func_196056_a(i));
            this.segments[i].func_228309_a_(stack, builder, light, overlay, dyeRgb[0], dyeRgb[1], dyeRgb[2], alpha);
        }
    }
    
    public void setRotationAngles(final QuestRamEntity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.horns.field_78795_f = headPitch / 57.295776f;
        this.horns.field_78796_g = netHeadYaw / 57.295776f;
        this.leftBackLeg.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f) * 1.4f * limbSwingAmount * 0.5f;
        this.rightBackLeg.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount * 0.5f;
        this.leftFrontLeg.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount * 0.5f;
        this.rightFrontLeg.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f) * 1.4f * limbSwingAmount * 0.5f;
    }
    
    public void setLivingAnimations(final QuestRamEntity entity, final float limbSwing, final float limbSwingAmount, final float partialTicks) {
        final int count = entity.countColorsSet();
        this.backtorso.field_78798_e = (float)(2 + 2 * count);
        this.leftBackLeg.field_78798_e = (float)(25 + 2 * count);
        this.rightBackLeg.field_78798_e = (float)(25 + 2 * count);
        int segmentOffset = 2;
        for (final int color : this.colorOrder) {
            if (entity.isColorPresent(DyeColor.func_196056_a(color))) {
                this.segments[color].field_78806_j = true;
                this.segments[color].field_78798_e = (float)segmentOffset;
                segmentOffset += 2;
            }
            else {
                this.segments[color].field_78806_j = false;
            }
        }
    }
    
    public Iterable<ModelRenderer> func_225601_a_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.horns, (Object)this.frontTorso, (Object)this.backtorso, (Object)this.leftFrontLeg, (Object)this.rightFrontLeg, (Object)this.leftBackLeg, (Object)this.rightBackLeg);
    }
    
    public void setRotateAngle(final ModelRenderer modelRenderer, final float x, final float y, final float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}
