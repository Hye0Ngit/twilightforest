// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.HandSide;
import net.minecraft.util.math.MathHelper;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import twilightforest.entity.boss.MinoshroomEntity;
import net.minecraft.client.renderer.entity.model.BipedModel;

@OnlyIn(Dist.CLIENT)
public class MinoshroomModel extends BipedModel<MinoshroomEntity>
{
    public ModelRenderer cowTorso;
    public ModelRenderer rightFrontLeg;
    public ModelRenderer leftFrontLeg;
    public ModelRenderer rightBackLeg;
    public ModelRenderer leftBackLeg;
    
    public MinoshroomModel() {
        super(0.0f, 0.0f, 64, 64);
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        (this.rightFrontLeg = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-4.0f, 12.0f, -6.0f);
        this.rightFrontLeg.func_78784_a(0, 48).func_228302_a_(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, 0.0f, 0.0f, 0.0f);
        (this.field_78115_e = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, -6.0f, -9.0f);
        this.field_78115_e.func_78784_a(0, 29).func_228302_a_(-5.0f, -3.0f, 0.0f, 10.0f, 12.0f, 5.0f, 0.0f, 0.0f, 0.0f);
        (this.field_178724_i = new ModelRenderer((Model)this, 0, 0)).func_78793_a(5.0f, -6.0f, -9.0f);
        this.field_178724_i.func_78784_a(46, 15).func_228302_a_(0.0f, -3.0f, -0.0f, 4.0f, 14.0f, 5.0f, 0.0f, 0.0f, 0.0f);
        (this.field_78116_c = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, -6.0f, -7.0f);
        this.field_78116_c.func_228302_a_(-4.0f, -11.0f, -4.0f, 8.0f, 8.0f, 8.0f, 0.0f, 0.0f, 0.0f);
        this.field_78116_c.func_78784_a(0, 16).func_228302_a_(-3.0f, -6.0f, -5.0f, 6.0f, 3.0f, 1.0f, 0.0f, 0.0f, 0.0f);
        this.field_78116_c.func_78784_a(32, 0).func_228302_a_(-8.0f, -10.0f, -1.0f, 4.0f, 2.0f, 3.0f, 0.0f, 0.0f, 0.0f);
        this.field_78116_c.func_78784_a(32, 5).func_228302_a_(-8.0f, -13.0f, -1.0f, 2.0f, 3.0f, 3.0f, 0.0f, 0.0f, 0.0f);
        this.field_78116_c.func_78784_a(46, 0).func_228302_a_(4.0f, -10.0f, -1.0f, 4.0f, 2.0f, 3.0f, 0.0f, 0.0f, 0.0f);
        this.field_78116_c.func_78784_a(46, 5).func_228302_a_(6.0f, -13.0f, -1.0f, 2.0f, 3.0f, 3.0f, 0.0f, 0.0f, 0.0f);
        (this.field_178723_h = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-5.0f, -6.0f, -9.0f);
        this.field_178723_h.func_78784_a(28, 15).func_228302_a_(-4.0f, -3.0f, -0.0f, 4.0f, 14.0f, 5.0f, 0.0f, 0.0f, 0.0f);
        (this.leftBackLeg = new ModelRenderer((Model)this, 0, 0)).func_78793_a(4.0f, 12.0f, 7.0f);
        this.leftBackLeg.func_78784_a(0, 48).func_228302_a_(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, 0.0f, 0.0f, 0.0f);
        (this.cowTorso = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 10.0f, 6.0f);
        this.cowTorso.func_78784_a(20, 36).func_228302_a_(-6.0f, -14.0f, -2.0f, 12.0f, 18.0f, 10.0f, 0.0f, 0.0f, 0.0f);
        this.cowTorso.func_78784_a(0, 20).func_228302_a_(-2.0f, -2.0f, -3.0f, 4.0f, 6.0f, 1.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.cowTorso, 1.5707964f, 0.0f, 0.0f);
        (this.leftFrontLeg = new ModelRenderer((Model)this, 0, 0)).func_78793_a(4.0f, 12.0f, -6.0f);
        this.leftFrontLeg.func_78784_a(0, 48).func_228302_a_(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, 0.0f, 0.0f, 0.0f);
        (this.rightBackLeg = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-4.0f, 12.0f, 7.0f);
        this.rightBackLeg.func_78784_a(0, 48).func_228302_a_(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, 0.0f, 0.0f, 0.0f);
    }
    
    protected Iterable<ModelRenderer> func_225600_b_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.field_78115_e, (Object)this.field_178723_h, (Object)this.field_178724_i, (Object)this.cowTorso, (Object)this.leftBackLeg, (Object)this.rightBackLeg, (Object)this.leftFrontLeg, (Object)this.rightFrontLeg);
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
        this.cowTorso.field_78795_f = 1.5707964f;
        this.leftFrontLeg.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.rightFrontLeg.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.leftBackLeg.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.rightBackLeg.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
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
            this.cowTorso.field_78795_f = 1.5707964f - f2 * 3.1415927f * 0.2f;
            this.leftFrontLeg.field_78797_d = 12.0f + -5.8f * f2;
            this.leftFrontLeg.field_78798_e = -4.0f + -5.8f * f2;
            final ModelRenderer leftFrontLeg = this.leftFrontLeg;
            leftFrontLeg.field_78795_f -= f2 * 3.1415927f * 0.3f;
            this.rightFrontLeg.field_78797_d = this.leftFrontLeg.field_78797_d;
            this.rightFrontLeg.field_78798_e = this.leftFrontLeg.field_78798_e;
            final ModelRenderer rightFrontLeg = this.rightFrontLeg;
            rightFrontLeg.field_78795_f -= f2 * 3.1415927f * 0.3f;
            this.field_78115_e.field_78797_d = -6.0f + -3.0f * f2;
        }
    }
    
    public void setRotateAngle(final ModelRenderer modelRenderer, final float x, final float y, final float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}
