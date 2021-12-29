// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity.legacy;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import twilightforest.entity.UpperGoblinKnightEntity;
import net.minecraft.client.renderer.entity.model.BipedModel;

public class UpperGoblinKnightLegacyModel extends BipedModel<UpperGoblinKnightEntity>
{
    public ModelRenderer breastplate;
    public ModelRenderer helmet;
    public ModelRenderer righthorn1;
    public ModelRenderer righthorn2;
    public ModelRenderer lefthorn1;
    public ModelRenderer lefthorn2;
    public ModelRenderer shield;
    public ModelRenderer spear;
    
    public UpperGoblinKnightLegacyModel() {
        super(0.0f, 0.0f, 128, 64);
        this.field_228270_o_ = false;
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        (this.field_78116_c = new ModelRenderer((Model)this, 0, 0)).func_228300_a_(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        this.field_78116_c.func_78793_a(0.0f, 12.0f, 0.0f);
        (this.field_178720_f = new ModelRenderer((Model)this, 0, 0)).func_228300_a_(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        this.field_178720_f.func_78793_a(0.0f, 12.0f, 0.0f);
        (this.helmet = new ModelRenderer((Model)this, 0, 0)).func_228300_a_(-3.5f, -11.0f, -3.5f, 7.0f, 11.0f, 7.0f);
        this.helmet.field_78796_g = 0.7853982f;
        (this.righthorn1 = new ModelRenderer((Model)this, 28, 0)).func_228300_a_(-6.0f, -1.5f, -1.5f, 7.0f, 3.0f, 3.0f);
        this.righthorn1.func_78793_a(-3.5f, -9.0f, 0.0f);
        this.righthorn1.field_78796_g = 0.2617994f;
        this.righthorn1.field_78808_h = 0.17453294f;
        (this.righthorn2 = new ModelRenderer((Model)this, 28, 6)).func_228300_a_(-3.0f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f);
        this.righthorn2.func_78793_a(-5.5f, 0.0f, 0.0f);
        this.righthorn2.field_78808_h = 0.17453294f;
        this.righthorn1.func_78792_a(this.righthorn2);
        this.lefthorn1 = new ModelRenderer((Model)this, 28, 0);
        this.lefthorn1.field_78809_i = true;
        this.lefthorn1.func_228300_a_(-1.0f, -1.5f, -1.5f, 7.0f, 3.0f, 3.0f);
        this.lefthorn1.func_78793_a(3.5f, -9.0f, 0.0f);
        this.lefthorn1.field_78796_g = -0.2617994f;
        this.lefthorn1.field_78808_h = -0.17453294f;
        (this.lefthorn2 = new ModelRenderer((Model)this, 28, 6)).func_228300_a_(0.0f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f);
        this.lefthorn2.func_78793_a(5.5f, 0.0f, 0.0f);
        this.lefthorn2.field_78808_h = -0.17453294f;
        this.lefthorn1.func_78792_a(this.lefthorn2);
        this.field_178720_f.func_78792_a(this.helmet);
        this.field_178720_f.func_78792_a(this.righthorn1);
        this.field_178720_f.func_78792_a(this.lefthorn1);
        (this.field_78115_e = new ModelRenderer((Model)this, 0, 18)).func_78793_a(0.0f, 12.0f, 0.0f);
        this.field_78115_e.func_228300_a_(-5.5f, 0.0f, -2.0f, 11.0f, 8.0f, 4.0f);
        this.field_78115_e.func_78784_a(30, 24).func_228300_a_(-6.5f, 0.0f, -2.0f, 1.0f, 4.0f, 4.0f);
        this.field_78115_e.func_78784_a(30, 24).func_228300_a_(5.5f, 0.0f, -2.0f, 1.0f, 4.0f, 4.0f);
        (this.field_178723_h = new ModelRenderer((Model)this, 44, 16)).func_228300_a_(-4.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f);
        this.field_178723_h.func_78793_a(-6.5f, 14.0f, 0.0f);
        this.field_178724_i = new ModelRenderer((Model)this, 44, 16);
        this.field_178724_i.field_78809_i = true;
        this.field_178724_i.func_228300_a_(0.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f);
        this.field_178724_i.func_78793_a(6.5f, 14.0f, 0.0f);
        (this.field_178721_j = new ModelRenderer((Model)this, 30, 16)).func_228300_a_(-1.5f, 0.0f, -2.0f, 3.0f, 4.0f, 4.0f);
        this.field_178721_j.func_78793_a(-4.0f, 20.0f, 0.0f);
        this.field_178722_k = new ModelRenderer((Model)this, 30, 16);
        this.field_178722_k.field_78809_i = true;
        this.field_178722_k.func_228300_a_(-1.5f, 0.0f, -2.0f, 3.0f, 4.0f, 4.0f);
        this.field_178722_k.func_78793_a(4.0f, 20.0f, 0.0f);
        (this.shield = new ModelRenderer((Model)this, 63, 36)).func_228300_a_(-6.0f, -6.0f, -2.0f, 12.0f, 20.0f, 2.0f);
        this.shield.func_78793_a(0.0f, 12.0f, 0.0f);
        this.shield.field_78795_f = 1.5707964f;
        this.field_178724_i.func_78792_a(this.shield);
        (this.spear = new ModelRenderer((Model)this, 108, 0)).func_228300_a_(-1.0f, -19.0f, -1.0f, 2.0f, 40.0f, 2.0f);
        this.spear.func_78793_a(-2.0f, 8.5f, 0.0f);
        this.spear.field_78795_f = 1.5707964f;
        this.field_178723_h.func_78792_a(this.spear);
        (this.breastplate = new ModelRenderer((Model)this, 64, 0)).func_228300_a_(-6.5f, 0.0f, -3.0f, 13.0f, 12.0f, 6.0f);
        this.breastplate.func_78793_a(0.0f, 11.5f, 0.0f);
    }
    
    public void func_225598_a_(final MatrixStack stack, final IVertexBuilder builder, final int light, final int overlay, final float red, final float green, final float blue, final float scale) {
        super.func_225598_a_(stack, builder, light, overlay, red, green, blue, scale);
        this.breastplate.func_228309_a_(stack, builder, light, overlay, red, green, blue, scale);
    }
    
    public void setRotationAngles(final UpperGoblinKnightEntity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        final boolean hasShield = entity.hasShield();
        this.field_78116_c.field_78796_g = netHeadYaw / 57.295776f;
        this.field_78116_c.field_78795_f = headPitch / 57.295776f;
        this.field_78116_c.field_78808_h = 0.0f;
        this.field_178720_f.field_78796_g = this.field_78116_c.field_78796_g;
        this.field_178720_f.field_78795_f = this.field_78116_c.field_78795_f;
        this.field_178720_f.field_78808_h = this.field_78116_c.field_78808_h;
        this.field_178723_h.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f + 3.1415927f) * 2.0f * limbSwingAmount * 0.5f;
        final float leftConstraint = hasShield ? 0.2f : limbSwingAmount;
        this.field_178724_i.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f) * 2.0f * leftConstraint * 0.5f;
        this.field_178723_h.field_78808_h = 0.0f;
        this.field_178724_i.field_78808_h = 0.0f;
        this.field_178721_j.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.field_178722_k.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.field_178721_j.field_78796_g = 0.0f;
        this.field_178722_k.field_78796_g = 0.0f;
        if (this.field_217113_d) {
            final ModelRenderer field_178723_h = this.field_178723_h;
            field_178723_h.field_78795_f -= 0.62831855f;
            final ModelRenderer field_178724_i = this.field_178724_i;
            field_178724_i.field_78795_f -= 0.62831855f;
            this.field_178721_j.field_78795_f = 0.0f;
            this.field_178722_k.field_78795_f = 0.0f;
        }
        if (this.field_187075_l != BipedModel.ArmPose.EMPTY) {
            this.field_178724_i.field_78795_f = this.field_178724_i.field_78795_f * 0.5f - 0.31415927f;
        }
        this.field_187076_m = BipedModel.ArmPose.ITEM;
        if (this.field_187076_m != BipedModel.ArmPose.EMPTY) {
            this.field_178723_h.field_78795_f = this.field_178723_h.field_78795_f * 0.5f - 0.31415927f;
        }
        final ModelRenderer field_178723_h2 = this.field_178723_h;
        field_178723_h2.field_78795_f -= (float)2.0734511513692637;
        if (entity.heavySpearTimer > 0) {
            final ModelRenderer field_178723_h3 = this.field_178723_h;
            field_178723_h3.field_78795_f -= this.getArmRotationDuringSwing((float)(60 - entity.heavySpearTimer)) / 57.295776f;
        }
        this.field_178723_h.field_78796_g = 0.0f;
        this.field_178724_i.field_78796_g = 0.0f;
        final ModelRenderer field_178723_h4 = this.field_178723_h;
        field_178723_h4.field_78808_h += MathHelper.func_76134_b(ageInTicks * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer field_178724_i2 = this.field_178724_i;
        field_178724_i2.field_78808_h -= MathHelper.func_76134_b(ageInTicks * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer field_178723_h5 = this.field_178723_h;
        field_178723_h5.field_78795_f += MathHelper.func_76126_a(ageInTicks * 0.067f) * 0.05f;
        final ModelRenderer field_178724_i3 = this.field_178724_i;
        field_178724_i3.field_78795_f -= MathHelper.func_76126_a(ageInTicks * 0.067f) * 0.05f;
        this.field_178724_i.field_78808_h = -this.field_178724_i.field_78808_h;
        this.shield.field_78795_f = (float)(6.283185307179586 - this.field_178724_i.field_78795_f);
        this.breastplate.field_78806_j = entity.hasArmor();
        this.shield.field_78806_j = entity.hasShield();
    }
    
    private float getArmRotationDuringSwing(final float attackTime) {
        if (attackTime <= 10.0f) {
            return attackTime;
        }
        if (attackTime > 10.0f && attackTime <= 30.0f) {
            return 10.0f;
        }
        if (attackTime > 30.0f && attackTime <= 33.0f) {
            return (attackTime - 30.0f) * -8.0f + 10.0f;
        }
        if (attackTime > 33.0f && attackTime <= 50.0f) {
            return -15.0f;
        }
        if (attackTime > 50.0f && attackTime <= 60.0f) {
            return (10.0f - (attackTime - 50.0f)) * -1.5f;
        }
        return 0.0f;
    }
}
