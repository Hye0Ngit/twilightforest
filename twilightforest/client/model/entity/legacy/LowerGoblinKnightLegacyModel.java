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
import twilightforest.entity.LowerGoblinKnightEntity;
import net.minecraft.client.renderer.entity.model.BipedModel;

public class LowerGoblinKnightLegacyModel extends BipedModel<LowerGoblinKnightEntity>
{
    public ModelRenderer tunic;
    
    public LowerGoblinKnightLegacyModel() {
        super(0.0f, 0.0f, 128, 64);
        this.field_228270_o_ = false;
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        (this.field_78116_c = new ModelRenderer((Model)this, 0, 32)).func_228300_a_(-2.5f, -5.0f, -3.5f, 5.0f, 5.0f, 5.0f);
        this.field_78116_c.func_78793_a(0.0f, 10.0f, 1.0f);
        (this.field_178720_f = new ModelRenderer((Model)this, 0, 0)).func_228300_a_(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        (this.field_78115_e = new ModelRenderer((Model)this, 16, 48)).func_228300_a_(-3.5f, 0.0f, -2.0f, 7.0f, 8.0f, 4.0f);
        this.field_78115_e.func_78793_a(0.0f, 8.0f, 0.0f);
        (this.field_178723_h = new ModelRenderer((Model)this, 40, 48)).func_228300_a_(-2.0f, -2.0f, -1.5f, 2.0f, 8.0f, 3.0f);
        this.field_178723_h.func_78793_a(-3.5f, 10.0f, 0.0f);
        this.field_178724_i = new ModelRenderer((Model)this, 40, 48);
        this.field_178724_i.field_78809_i = true;
        this.field_178724_i.func_228300_a_(0.0f, -2.0f, -1.5f, 2.0f, 8.0f, 3.0f);
        this.field_178724_i.func_78793_a(3.5f, 10.0f, 0.0f);
        (this.field_178721_j = new ModelRenderer((Model)this, 0, 48)).func_228300_a_(-3.0f, 0.0f, -2.0f, 4.0f, 8.0f, 4.0f);
        this.field_178721_j.func_78793_a(-2.5f, 16.0f, 0.0f);
        this.field_178722_k = new ModelRenderer((Model)this, 0, 48);
        this.field_178722_k.field_78809_i = true;
        this.field_178722_k.func_228300_a_(-1.0f, 0.0f, -2.0f, 4.0f, 8.0f, 4.0f);
        this.field_178722_k.func_78793_a(2.5f, 16.0f, 0.0f);
        (this.tunic = new ModelRenderer((Model)this, 64, 19)).func_228300_a_(-6.0f, 0.0f, -3.0f, 12.0f, 9.0f, 6.0f);
        this.tunic.func_78793_a(0.0f, 7.5f, 0.0f);
    }
    
    public void func_225598_a_(final MatrixStack stack, final IVertexBuilder builder, final int light, final int overlay, final float red, final float green, final float blue, final float scale) {
        super.func_225598_a_(stack, builder, light, overlay, red, green, blue, scale);
        this.tunic.func_228309_a_(stack, builder, light, overlay, red, green, blue, scale);
    }
    
    public void setRotationAngles(final LowerGoblinKnightEntity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
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
        if (entity.func_184207_aI()) {
            this.field_78116_c.field_78796_g = 0.0f;
            this.field_78116_c.field_78795_f = 0.0f;
            this.field_178720_f.field_78796_g = this.field_78116_c.field_78796_g;
            this.field_178720_f.field_78795_f = this.field_78116_c.field_78795_f;
        }
        if (this.field_187075_l != BipedModel.ArmPose.EMPTY) {
            this.field_178724_i.field_78795_f = this.field_178724_i.field_78795_f * 0.5f - 0.31415927f;
        }
        if (this.field_187076_m != BipedModel.ArmPose.EMPTY) {
            this.field_178723_h.field_78795_f = this.field_178723_h.field_78795_f * 0.5f - 0.31415927f;
        }
        this.field_178723_h.field_78796_g = 0.0f;
        this.field_178724_i.field_78796_g = 0.0f;
        final ModelRenderer field_178723_h = this.field_178723_h;
        field_178723_h.field_78808_h += MathHelper.func_76134_b(ageInTicks * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer field_178724_i = this.field_178724_i;
        field_178724_i.field_78808_h -= MathHelper.func_76134_b(ageInTicks * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer field_178723_h2 = this.field_178723_h;
        field_178723_h2.field_78795_f += MathHelper.func_76126_a(ageInTicks * 0.067f) * 0.05f;
        final ModelRenderer field_178724_i2 = this.field_178724_i;
        field_178724_i2.field_78795_f -= MathHelper.func_76126_a(ageInTicks * 0.067f) * 0.05f;
        this.tunic.field_78806_j = entity.hasArmor();
    }
}
