// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity.legacy;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.DyeColor;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import twilightforest.entity.passive.QuestRamEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;

public class QuestRamLegacyModel extends SegmentedModel<QuestRamEntity>
{
    ModelRenderer frontbody;
    ModelRenderer rearbody;
    ModelRenderer leg1;
    ModelRenderer haunch1;
    ModelRenderer leg2;
    ModelRenderer haunch2;
    ModelRenderer leg3;
    ModelRenderer haunch3;
    ModelRenderer leg4;
    ModelRenderer haunch4;
    ModelRenderer neck;
    ModelRenderer nose;
    public ModelRenderer head;
    ModelRenderer[] segments;
    int[] colorOrder;
    
    public QuestRamLegacyModel() {
        this.colorOrder = new int[] { 0, 8, 7, 15, 14, 1, 4, 5, 13, 3, 9, 11, 10, 2, 6, 12 };
        this.field_78090_t = 128;
        this.field_78089_u = 128;
        (this.frontbody = new ModelRenderer((Model)this, 0, 0)).func_228300_a_(-9.0f, -7.5f, -15.0f, 18.0f, 15.0f, 15.0f);
        this.frontbody.func_78793_a(0.0f, -1.0f, 2.0f);
        (this.rearbody = new ModelRenderer((Model)this, 0, 30)).func_228300_a_(-9.0f, -7.5f, 0.0f, 18.0f, 15.0f, 15.0f);
        this.rearbody.func_78793_a(0.0f, -1.0f, 4.0f);
        (this.leg1 = new ModelRenderer((Model)this, 66, 0)).func_228300_a_(-3.0f, 10.0f, -3.0f, 6.0f, 12.0f, 6.0f);
        this.leg1.func_78793_a(-6.0f, 2.0f, 13.0f);
        (this.haunch1 = new ModelRenderer((Model)this, 90, 0)).func_228300_a_(-3.5f, 0.0f, -6.0f, 7.0f, 10.0f, 10.0f);
        this.haunch1.func_78793_a(-6.0f, 2.0f, 13.0f);
        (this.leg2 = new ModelRenderer((Model)this, 66, 0)).func_228300_a_(-3.0f, 10.0f, -3.0f, 6.0f, 12.0f, 6.0f);
        this.leg2.func_78793_a(6.0f, 2.0f, 13.0f);
        (this.haunch2 = new ModelRenderer((Model)this, 90, 0)).func_228300_a_(-3.5f, 0.0f, -6.0f, 7.0f, 10.0f, 10.0f);
        this.haunch2.func_78793_a(6.0f, 2.0f, 13.0f);
        (this.leg3 = new ModelRenderer((Model)this, 66, 18)).func_228300_a_(-3.0f, 10.0f, -3.0f, 6.0f, 13.0f, 6.0f);
        this.leg3.func_78793_a(-6.0f, 1.0f, -8.0f);
        (this.haunch3 = new ModelRenderer((Model)this, 90, 20)).func_228300_a_(-3.5f, 0.0f, -4.0f, 7.0f, 10.0f, 7.0f);
        this.haunch3.func_78793_a(-6.0f, 1.0f, -8.0f);
        (this.leg4 = new ModelRenderer((Model)this, 66, 18)).func_228300_a_(-3.0f, 10.0f, -3.0f, 6.0f, 13.0f, 6.0f);
        this.leg4.func_78793_a(6.0f, 1.0f, -8.0f);
        (this.haunch4 = new ModelRenderer((Model)this, 90, 20)).func_228300_a_(-3.5f, 0.0f, -4.0f, 7.0f, 10.0f, 7.0f);
        this.haunch4.func_78793_a(6.0f, 1.0f, -8.0f);
        (this.neck = new ModelRenderer((Model)this, 66, 37)).func_228300_a_(-5.5f, -8.0f, -8.0f, 11.0f, 14.0f, 12.0f);
        this.neck.func_78793_a(0.0f, -8.0f, -7.0f);
        this.setRotation(this.neck, 0.2617994f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((Model)this)).func_78793_a(0.0f, -13.0f, -5.0f);
        this.head.func_78784_a(0, 70).func_228300_a_(-6.0f, -4.5f, -15.0f, 12.0f, 9.0f, 15.0f);
        this.head.func_78784_a(0, 94).func_228300_a_(5.0f, -9.0f, -7.0f, 4.0f, 4.0f, 6.0f);
        this.head.func_78784_a(20, 96).func_228300_a_(7.0f, -8.0f, -2.0f, 3.0f, 4.0f, 4.0f);
        this.head.func_78784_a(34, 95).func_228300_a_(8.0f, -6.0f, 0.0f, 3.0f, 6.0f, 3.0f);
        this.head.func_78784_a(46, 98).func_228300_a_(9.5f, -2.0f, -2.0f, 3.0f, 3.0f, 3.0f);
        this.head.func_78784_a(58, 95).func_228300_a_(11.0f, 0.0f, -7.0f, 3.0f, 3.0f, 6.0f);
        this.head.func_78784_a(76, 95).func_228300_a_(12.0f, -4.0f, -9.0f, 3.0f, 6.0f, 3.0f);
        this.head.func_78784_a(88, 97).func_228300_a_(13.0f, -6.0f, -7.0f, 3.0f, 3.0f, 4.0f);
        this.head.func_78784_a(0, 94).func_228300_a_(-9.0f, -9.0f, -7.0f, 4.0f, 4.0f, 6.0f);
        this.head.func_78784_a(20, 96).func_228300_a_(-10.0f, -8.0f, -2.0f, 3.0f, 4.0f, 4.0f);
        this.head.func_78784_a(34, 95).func_228300_a_(-11.0f, -6.0f, 0.0f, 3.0f, 6.0f, 3.0f);
        this.head.func_78784_a(46, 98).func_228300_a_(-12.5f, -2.0f, -2.0f, 3.0f, 3.0f, 3.0f);
        this.head.func_78784_a(58, 95).func_228300_a_(-14.0f, 0.0f, -7.0f, 3.0f, 3.0f, 6.0f);
        this.head.func_78784_a(76, 95).func_228300_a_(-15.0f, -4.0f, -9.0f, 3.0f, 6.0f, 3.0f);
        this.head.func_78784_a(88, 97).func_228300_a_(-16.0f, -6.0f, -7.0f, 3.0f, 3.0f, 4.0f);
        (this.nose = new ModelRenderer((Model)this, 54, 73)).func_228300_a_(-5.5f, -5.0f, -13.0f, 11.0f, 9.0f, 12.0f);
        this.nose.func_78793_a(0.0f, -7.0f, -1.0f);
        this.nose.func_78787_b(128, 128);
        this.setRotation(this.nose, 0.5235988f, 0.0f, 0.0f);
        this.head.func_78792_a(this.nose);
        this.segments = new ModelRenderer[16];
        for (int i = 0; i < 16; ++i) {
            (this.segments[i] = new ModelRenderer((Model)this, 0, 104)).func_228300_a_(-9.0f, -7.5f, 0.0f, 18.0f, 15.0f, 2.0f);
            this.segments[i].func_78793_a(0.0f, -1.0f, 2.0f);
            this.segments[i].field_78806_j = false;
        }
    }
    
    public Iterable<ModelRenderer> func_225601_a_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.frontbody, (Object)this.rearbody, (Object)this.leg1, (Object)this.haunch1, (Object)this.leg2, (Object)this.haunch2, (Object)this.leg3, (Object)this.haunch3, (Object)this.leg4, (Object)this.haunch4, (Object)this.neck, (Object)this.head, (Object[])new ModelRenderer[0]);
    }
    
    public void func_225598_a_(final MatrixStack stack, final IVertexBuilder builder, final int light, final int overlay, final float red, final float green, final float blue, final float alpha) {
        super.func_225598_a_(stack, builder, light, overlay, red, green, blue, alpha);
        for (int i = 0; i < 16; ++i) {
            final float[] dyeRgb = SheepEntity.func_175513_a(DyeColor.func_196056_a(i));
            this.segments[i].func_228309_a_(stack, builder, light, overlay, dyeRgb[0], dyeRgb[1], dyeRgb[2], alpha);
        }
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.field_78795_f = x;
        model.field_78796_g = y;
        model.field_78808_h = z;
    }
    
    public void setRotationAngles(final QuestRamEntity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.head.field_78795_f = headPitch / 57.295776f;
        this.head.field_78796_g = netHeadYaw / 57.295776f;
        this.neck.field_78796_g = this.head.field_78796_g;
        this.leg1.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f) * 1.4f * limbSwingAmount * 0.5f;
        this.leg2.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount * 0.5f;
        this.leg3.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount * 0.5f;
        this.leg4.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f) * 1.4f * limbSwingAmount * 0.5f;
        this.haunch1.field_78795_f = this.leg1.field_78795_f;
        this.haunch2.field_78795_f = this.leg2.field_78795_f;
        this.haunch3.field_78795_f = this.leg3.field_78795_f;
        this.haunch4.field_78795_f = this.leg4.field_78795_f;
    }
    
    public void setLivingAnimations(final QuestRamEntity entity, final float limbSwing, final float limbSwingAmount, final float partialTicks) {
        final int count = entity.countColorsSet();
        this.rearbody.field_78798_e = (float)(2 + 2 * count);
        this.leg1.field_78798_e = (float)(11 + 2 * count);
        this.leg2.field_78798_e = (float)(11 + 2 * count);
        this.haunch1.field_78798_e = (float)(11 + 2 * count);
        this.haunch2.field_78798_e = (float)(11 + 2 * count);
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
}
