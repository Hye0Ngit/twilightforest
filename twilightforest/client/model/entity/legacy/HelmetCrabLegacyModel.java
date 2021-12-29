// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity.legacy;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import twilightforest.entity.HelmetCrabEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;

public class HelmetCrabLegacyModel extends SegmentedModel<HelmetCrabEntity>
{
    ModelRenderer body;
    ModelRenderer helmetBase;
    ModelRenderer Leg8;
    ModelRenderer Leg6;
    ModelRenderer Leg4;
    ModelRenderer rightArm;
    ModelRenderer Leg5;
    ModelRenderer Leg3;
    ModelRenderer clawbase;
    ModelRenderer clawtop;
    ModelRenderer clawbottom;
    ModelRenderer righteye;
    ModelRenderer lefteye;
    public ModelRenderer helmet;
    public ModelRenderer righthorn1;
    public ModelRenderer righthorn2;
    public ModelRenderer lefthorn1;
    public ModelRenderer lefthorn2;
    
    public HelmetCrabLegacyModel() {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        (this.body = new ModelRenderer((Model)this, 32, 4)).func_228300_a_(-2.5f, -2.5f, -5.0f, 5.0f, 5.0f, 5.0f);
        this.body.func_78793_a(0.0f, 19.0f, 0.0f);
        (this.helmetBase = new ModelRenderer((Model)this, 0, 0)).func_228300_a_(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        this.helmetBase.func_78793_a(0.0f, 18.0f, 0.0f);
        this.helmetBase.field_78795_f = -1.7453294f;
        this.helmetBase.field_78796_g = -0.5235988f;
        (this.helmet = new ModelRenderer((Model)this, 0, 14)).func_228300_a_(-3.5f, -11.0f, -3.5f, 7.0f, 11.0f, 7.0f);
        this.helmet.field_78796_g = 0.7853982f;
        (this.righthorn1 = new ModelRenderer((Model)this, 28, 14)).func_228300_a_(-6.0f, -1.5f, -1.5f, 7.0f, 3.0f, 3.0f);
        this.righthorn1.func_78793_a(-3.5f, -9.0f, 0.0f);
        this.righthorn1.field_78796_g = -0.2617994f;
        this.righthorn1.field_78808_h = 0.17453294f;
        (this.righthorn2 = new ModelRenderer((Model)this, 28, 20)).func_228300_a_(-3.0f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f);
        this.righthorn2.func_78793_a(-5.5f, 0.0f, 0.0f);
        this.righthorn2.field_78796_g = -0.2617994f;
        this.righthorn2.field_78808_h = 0.17453294f;
        this.righthorn1.func_78792_a(this.righthorn2);
        this.lefthorn1 = new ModelRenderer((Model)this, 28, 14);
        this.lefthorn1.field_78809_i = true;
        this.lefthorn1.func_228300_a_(-1.0f, -1.5f, -1.5f, 7.0f, 3.0f, 3.0f);
        this.lefthorn1.func_78793_a(3.5f, -9.0f, 0.0f);
        this.lefthorn1.field_78796_g = 0.2617994f;
        this.lefthorn1.field_78808_h = -0.17453294f;
        (this.lefthorn2 = new ModelRenderer((Model)this, 28, 20)).func_228300_a_(0.0f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f);
        this.lefthorn2.func_78793_a(5.5f, 0.0f, 0.0f);
        this.lefthorn2.field_78796_g = 0.2617994f;
        this.lefthorn2.field_78808_h = -0.17453294f;
        this.lefthorn1.func_78792_a(this.lefthorn2);
        this.helmetBase.func_78792_a(this.helmet);
        this.helmetBase.func_78792_a(this.righthorn1);
        this.helmetBase.func_78792_a(this.lefthorn1);
        (this.Leg8 = new ModelRenderer((Model)this, 18, 0)).func_228300_a_(-1.0f, -1.0f, -1.0f, 8.0f, 2.0f, 2.0f);
        this.Leg8.func_78793_a(3.0f, 20.0f, -3.0f);
        this.setRotation(this.Leg8, 0.0f, 0.5759587f, 0.1919862f);
        (this.Leg6 = new ModelRenderer((Model)this, 18, 0)).func_228300_a_(-1.0f, -1.0f, -1.0f, 8.0f, 2.0f, 2.0f);
        this.Leg6.func_78793_a(3.0f, 20.0f, -2.0f);
        this.setRotation(this.Leg6, 0.0f, 0.2792527f, 0.1919862f);
        (this.Leg4 = new ModelRenderer((Model)this, 18, 0)).func_228300_a_(-1.0f, -1.0f, -1.0f, 8.0f, 2.0f, 2.0f);
        this.Leg4.func_78793_a(3.0f, 20.0f, -1.0f);
        this.setRotation(this.Leg4, 0.0f, -0.2792527f, 0.1919862f);
        (this.rightArm = new ModelRenderer((Model)this, 38, 0)).func_228300_a_(-7.0f, -1.0f, -1.0f, 8.0f, 2.0f, 2.0f);
        this.rightArm.func_78793_a(-3.0f, 20.0f, -3.0f);
        this.setRotation(this.rightArm, 0.0f, -1.319531f, -0.1919862f);
        (this.Leg5 = new ModelRenderer((Model)this, 18, 0)).func_228300_a_(-7.0f, -1.0f, -1.0f, 8.0f, 2.0f, 2.0f);
        this.Leg5.func_78793_a(-3.0f, 20.0f, -2.0f);
        this.setRotation(this.Leg5, 0.0f, -0.2792527f, -0.1919862f);
        (this.Leg3 = new ModelRenderer((Model)this, 18, 0)).func_228300_a_(-7.0f, -1.0f, -1.0f, 8.0f, 2.0f, 2.0f);
        this.Leg3.func_78793_a(-3.0f, 20.0f, -1.0f);
        this.setRotation(this.Leg3, 0.0f, 0.2792527f, -0.1919862f);
        (this.clawbase = new ModelRenderer((Model)this, 0, 0)).func_228300_a_(0.0f, -1.5f, -1.0f, 3.0f, 3.0f, 2.0f);
        this.clawbase.func_78793_a(-6.0f, 0.0f, -0.5f);
        this.setRotation(this.clawbase, 0.0f, 1.5707964f, 0.0f);
        (this.clawtop = new ModelRenderer((Model)this, 0, 5)).func_228300_a_(0.0f, -0.5f, -1.0f, 3.0f, 1.0f, 2.0f);
        this.clawtop.func_78793_a(3.0f, -1.0f, 0.0f);
        this.setRotation(this.clawtop, 0.0f, 0.0f, -0.1858931f);
        (this.clawbottom = new ModelRenderer((Model)this, 0, 8)).func_228300_a_(0.0f, -0.5f, -1.0f, 3.0f, 2.0f, 2.0f);
        this.clawbottom.func_78793_a(3.0f, 0.0f, 0.0f);
        this.setRotation(this.clawbottom, 0.0f, 0.0f, 0.2602503f);
        this.clawbase.func_78792_a(this.clawtop);
        this.clawbase.func_78792_a(this.clawbottom);
        this.rightArm.func_78792_a(this.clawbase);
        (this.righteye = new ModelRenderer((Model)this, 10, 0)).func_228300_a_(-1.0f, -3.0f, -1.0f, 2.0f, 3.0f, 2.0f);
        this.righteye.func_78793_a(-1.0f, -1.0f, -4.0f);
        this.setRotation(this.righteye, 0.7853982f, 0.0f, -0.7853982f);
        (this.lefteye = new ModelRenderer((Model)this, 10, 0)).func_228300_a_(-1.0f, -3.0f, -1.0f, 2.0f, 3.0f, 2.0f);
        this.lefteye.func_78793_a(1.0f, -1.0f, -4.0f);
        this.setRotation(this.lefteye, 0.7853982f, 0.0f, 0.7853982f);
        this.body.func_78792_a(this.righteye);
        this.body.func_78792_a(this.lefteye);
    }
    
    public Iterable<ModelRenderer> func_225601_a_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.body, (Object)this.helmetBase, (Object)this.Leg8, (Object)this.Leg6, (Object)this.Leg4, (Object)this.rightArm, (Object)this.Leg5, (Object)this.Leg3);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.field_78795_f = x;
        model.field_78796_g = y;
        model.field_78808_h = z;
    }
    
    public void setRotationAngles(final HelmetCrabEntity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.body.field_78796_g = netHeadYaw / 57.295776f;
        this.body.field_78795_f = headPitch / 57.295776f;
        final float f6 = 0.7853982f;
        this.Leg3.field_78808_h = -f6 * 0.74f;
        this.Leg4.field_78808_h = f6 * 0.74f;
        this.Leg5.field_78808_h = -f6 * 0.74f;
        this.Leg6.field_78808_h = f6 * 0.74f;
        this.Leg8.field_78808_h = f6;
        final float f7 = -0.0f;
        final float f8 = 0.3926991f;
        this.Leg3.field_78796_g = f8 + f7;
        this.Leg4.field_78796_g = -f8 - f7;
        this.Leg5.field_78796_g = -f8 + f7;
        this.Leg6.field_78796_g = f8 - f7;
        this.Leg8.field_78796_g = f8 * 2.0f - f7;
        final float f9 = -(MathHelper.func_76134_b(limbSwing * 0.6662f * 2.0f + 3.1415927f) * 0.4f) * limbSwingAmount;
        final float f10 = -(MathHelper.func_76134_b(limbSwing * 0.6662f * 2.0f + 1.5707964f) * 0.4f) * limbSwingAmount;
        final float f11 = -(MathHelper.func_76134_b(limbSwing * 0.6662f * 2.0f + 4.712389f) * 0.4f) * limbSwingAmount;
        final float f12 = Math.abs(MathHelper.func_76126_a(limbSwing * 0.6662f + 3.1415927f) * 0.4f) * limbSwingAmount;
        final float f13 = Math.abs(MathHelper.func_76126_a(limbSwing * 0.6662f + 1.5707964f) * 0.4f) * limbSwingAmount;
        final float f14 = Math.abs(MathHelper.func_76126_a(limbSwing * 0.6662f + 4.712389f) * 0.4f) * limbSwingAmount;
        final ModelRenderer leg3 = this.Leg3;
        leg3.field_78796_g += f9;
        final ModelRenderer leg4 = this.Leg4;
        leg4.field_78796_g += -f9;
        final ModelRenderer leg5 = this.Leg5;
        leg5.field_78796_g += f10;
        final ModelRenderer leg6 = this.Leg6;
        leg6.field_78796_g += -f10;
        final ModelRenderer leg7 = this.Leg8;
        leg7.field_78796_g += -f11;
        final ModelRenderer leg8 = this.Leg3;
        leg8.field_78808_h += f12;
        final ModelRenderer leg9 = this.Leg4;
        leg9.field_78808_h += -f12;
        final ModelRenderer leg10 = this.Leg5;
        leg10.field_78808_h += f13;
        final ModelRenderer leg11 = this.Leg6;
        leg11.field_78808_h += -f13;
        final ModelRenderer leg12 = this.Leg8;
        leg12.field_78808_h += -f14;
        this.rightArm.field_78796_g = -1.319531f;
        final ModelRenderer rightArm = this.rightArm;
        rightArm.field_78796_g += MathHelper.func_76134_b(limbSwing * 0.6662f + 3.1415927f) * 2.0f * limbSwingAmount * 0.5f;
    }
}
