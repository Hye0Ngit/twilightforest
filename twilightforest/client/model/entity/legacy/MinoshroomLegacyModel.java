// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity.legacy;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.HandSide;
import net.minecraft.util.math.MathHelper;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import twilightforest.entity.boss.MinoshroomEntity;
import net.minecraft.client.renderer.entity.model.BipedModel;

public class MinoshroomLegacyModel extends BipedModel<MinoshroomEntity>
{
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer udders;
    ModelRenderer snout;
    public ModelRenderer righthorn1;
    public ModelRenderer righthorn2;
    public ModelRenderer lefthorn1;
    public ModelRenderer lefthorn2;
    
    public MinoshroomLegacyModel() {
        super(0.0f, 0.0f, 128, 32);
        (this.field_78116_c = new ModelRenderer((Model)this, 96, 16)).func_228300_a_(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f);
        this.field_78116_c.func_78793_a(0.0f, -6.0f, -9.0f);
        (this.body = new ModelRenderer((Model)this, 18, 4)).func_228300_a_(-6.0f, -10.0f, -7.0f, 12.0f, 18.0f, 10.0f);
        this.body.func_78793_a(0.0f, 5.0f, 2.0f);
        this.setRotation(this.body, 1.570796f, 0.0f, 0.0f);
        (this.leg1 = new ModelRenderer((Model)this, 0, 16)).func_228300_a_(-3.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f);
        this.leg1.func_78793_a(-3.0f, 12.0f, 7.0f);
        (this.leg2 = new ModelRenderer((Model)this, 0, 16)).func_228300_a_(-1.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f);
        this.leg2.func_78793_a(3.0f, 12.0f, 7.0f);
        (this.leg3 = new ModelRenderer((Model)this, 0, 16)).func_228300_a_(-3.0f, 0.0f, -3.0f, 4.0f, 12.0f, 4.0f);
        this.leg3.func_78793_a(-3.0f, 12.0f, -5.0f);
        (this.leg4 = new ModelRenderer((Model)this, 0, 16)).func_228300_a_(-1.0f, 0.0f, -3.0f, 4.0f, 12.0f, 4.0f);
        this.leg4.func_78793_a(3.0f, 12.0f, -5.0f);
        (this.udders = new ModelRenderer((Model)this, 52, 0)).func_228300_a_(-2.0f, -3.0f, 0.0f, 4.0f, 6.0f, 2.0f);
        this.udders.func_78793_a(0.0f, 14.0f, 6.0f);
        this.setRotation(this.udders, 1.570796f, 0.0f, 0.0f);
        (this.field_78115_e = new ModelRenderer((Model)this, 64, 0)).func_228300_a_(-4.0f, 0.0f, -2.5f, 8.0f, 12.0f, 5.0f);
        this.field_78115_e.func_78793_a(0.0f, -6.0f, -9.0f);
        (this.field_178724_i = new ModelRenderer((Model)this, 90, 0)).func_228300_a_(-1.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f);
        this.field_178724_i.func_78793_a(5.0f, -4.0f, -9.0f);
        this.field_178724_i.field_78809_i = true;
        (this.field_178723_h = new ModelRenderer((Model)this, 90, 0)).func_228300_a_(-3.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f);
        this.field_178723_h.func_78793_a(-5.0f, -4.0f, -9.0f);
        (this.righthorn1 = new ModelRenderer((Model)this, 0, 0)).func_228300_a_(-5.5f, -1.5f, -1.5f, 5.0f, 3.0f, 3.0f);
        this.righthorn1.func_78793_a(-2.5f, -6.5f, 0.0f);
        this.righthorn1.field_78796_g = -0.43633235f;
        this.righthorn1.field_78808_h = 0.17453294f;
        (this.righthorn2 = new ModelRenderer((Model)this, 16, 0)).func_228300_a_(-3.5f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f);
        this.righthorn2.func_78793_a(-4.5f, 0.0f, 0.0f);
        this.righthorn2.field_78796_g = -0.2617994f;
        this.righthorn2.field_78808_h = 0.7853982f;
        this.righthorn1.func_78792_a(this.righthorn2);
        this.lefthorn1 = new ModelRenderer((Model)this, 0, 0);
        this.lefthorn1.field_78809_i = true;
        this.lefthorn1.func_228300_a_(0.5f, -1.5f, -1.5f, 5.0f, 3.0f, 3.0f);
        this.lefthorn1.func_78793_a(2.5f, -6.5f, 0.0f);
        this.lefthorn1.field_78796_g = 0.43633235f;
        this.lefthorn1.field_78808_h = -0.17453294f;
        (this.lefthorn2 = new ModelRenderer((Model)this, 16, 0)).func_228300_a_(0.5f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f);
        this.lefthorn2.func_78793_a(4.5f, 0.0f, 0.0f);
        this.lefthorn2.field_78796_g = 0.2617994f;
        this.lefthorn2.field_78808_h = -0.7853982f;
        this.lefthorn1.func_78792_a(this.lefthorn2);
        this.field_78116_c.func_78792_a(this.righthorn1);
        this.field_78116_c.func_78792_a(this.lefthorn1);
        (this.snout = new ModelRenderer((Model)this, 105, 28)).func_228300_a_(-2.0f, -1.0f, -1.0f, 4.0f, 3.0f, 1.0f);
        this.snout.func_78793_a(0.0f, -2.0f, -4.0f);
        this.field_78116_c.func_78792_a(this.snout);
        this.field_178720_f = new ModelRenderer((Model)this, 0, 0);
    }
    
    protected Iterable<ModelRenderer> func_225602_a_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.field_78116_c);
    }
    
    protected Iterable<ModelRenderer> func_225600_b_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.body, (Object)this.leg1, (Object)this.leg2, (Object)this.leg3, (Object)this.leg4, (Object)this.udders, (Object)this.field_78115_e, (Object)this.field_178724_i, (Object)this.field_178723_h);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.field_78795_f = x;
        model.field_78796_g = y;
        model.field_78808_h = z;
    }
    
    public void setRotationAngles(final MinoshroomEntity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.field_78116_c.field_78796_g = netHeadYaw / 57.295776f;
        this.field_78116_c.field_78795_f = headPitch / 57.295776f;
        this.field_178720_f.field_78796_g = this.field_78116_c.field_78796_g;
        this.field_178720_f.field_78795_f = this.field_78116_c.field_78795_f;
        this.field_178723_h.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f + 3.1415927f) * 2.0f * limbSwingAmount * 0.5f;
        this.field_178724_i.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f) * 2.0f * limbSwingAmount * 0.5f;
        this.field_178723_h.field_78808_h = 0.0f;
        this.field_178724_i.field_78808_h = 0.0f;
        this.field_178721_j.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.field_178722_k.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.field_178721_j.field_78796_g = 0.0f;
        this.field_178722_k.field_78796_g = 0.0f;
        if (this.field_187075_l != BipedModel.ArmPose.EMPTY) {
            this.field_178724_i.field_78795_f = this.field_178724_i.field_78795_f * 0.5f - 0.31415927f;
        }
        if (this.field_187076_m != BipedModel.ArmPose.EMPTY) {
            this.field_178723_h.field_78795_f = this.field_178723_h.field_78795_f * 0.5f - 0.31415927f;
        }
        final ModelRenderer field_178723_h = this.field_178723_h;
        field_178723_h.field_78808_h += MathHelper.func_76134_b(ageInTicks * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer field_178724_i = this.field_178724_i;
        field_178724_i.field_78808_h -= MathHelper.func_76134_b(ageInTicks * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer field_178723_h2 = this.field_178723_h;
        field_178723_h2.field_78795_f += MathHelper.func_76126_a(ageInTicks * 0.067f) * 0.05f;
        final ModelRenderer field_178724_i2 = this.field_178724_i;
        field_178724_i2.field_78795_f -= MathHelper.func_76126_a(ageInTicks * 0.067f) * 0.05f;
        final float var7 = 0.0f;
        final float var8 = 0.0f;
        if (this.field_187075_l == BipedModel.ArmPose.BOW_AND_ARROW) {
            this.field_178724_i.field_78808_h = 0.0f;
            this.field_178724_i.field_78796_g = 0.1f - var7 * 0.6f + this.field_78116_c.field_78796_g + 0.4f;
            this.field_178724_i.field_78795_f = -1.5707964f + this.field_78116_c.field_78795_f;
            final ModelRenderer field_178724_i3 = this.field_178724_i;
            field_178724_i3.field_78795_f -= var7 * 1.2f - var8 * 0.4f;
            final ModelRenderer field_178724_i4 = this.field_178724_i;
            field_178724_i4.field_78808_h -= MathHelper.func_76134_b(ageInTicks * 0.09f) * 0.05f + 0.05f;
            final ModelRenderer field_178724_i5 = this.field_178724_i;
            field_178724_i5.field_78795_f -= MathHelper.func_76126_a(ageInTicks * 0.067f) * 0.05f;
        }
        if (this.field_187076_m == BipedModel.ArmPose.BOW_AND_ARROW) {
            this.field_178723_h.field_78808_h = 0.0f;
            this.field_178723_h.field_78796_g = -(0.1f - var7 * 0.6f) + this.field_78116_c.field_78796_g;
            this.field_178723_h.field_78795_f = -1.5707964f + this.field_78116_c.field_78795_f;
            final ModelRenderer field_178723_h3 = this.field_178723_h;
            field_178723_h3.field_78795_f -= var7 * 1.2f - var8 * 0.4f;
            final ModelRenderer field_178723_h4 = this.field_178723_h;
            field_178723_h4.field_78808_h += MathHelper.func_76134_b(ageInTicks * 0.09f) * 0.05f + 0.05f;
            final ModelRenderer field_178723_h5 = this.field_178723_h;
            field_178723_h5.field_78795_f += MathHelper.func_76126_a(ageInTicks * 0.067f) * 0.05f;
        }
        this.body.field_78795_f = 1.5707964f;
        this.leg1.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.leg2.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.leg3.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.leg4.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        final float f = ageInTicks - entity.field_70173_aa;
        float f2 = entity.getChargeAnimationScale(f);
        f2 *= f2;
        final float f3 = 1.0f - f2;
        if (f2 > 0.0f) {
            if (entity.func_184591_cq() == HandSide.RIGHT) {
                this.field_178723_h.field_78795_f = f2 * -1.8f;
                this.field_178724_i.field_78795_f = 0.0f;
                this.field_178723_h.field_78808_h = -0.2f;
            }
            else {
                this.field_178723_h.field_78795_f = 0.0f;
                this.field_178724_i.field_78795_f = f2 * -1.8f;
                this.field_178724_i.field_78808_h = 0.2f;
            }
            this.body.field_78795_f = 1.5707964f - f2 * 3.1415927f * 0.2f;
            this.leg3.field_78797_d = 12.0f + -5.8f * f2;
            this.leg3.field_78798_e = -4.0f + -5.8f * f2;
            final ModelRenderer leg3 = this.leg3;
            leg3.field_78795_f -= f2 * 3.1415927f * 0.3f;
            this.leg4.field_78797_d = this.leg3.field_78797_d;
            this.leg4.field_78798_e = this.leg3.field_78798_e;
            final ModelRenderer leg4 = this.leg4;
            leg4.field_78795_f -= f2 * 3.1415927f * 0.3f;
            this.field_78115_e.field_78797_d = -6.0f + -3.0f * f2;
        }
    }
}
