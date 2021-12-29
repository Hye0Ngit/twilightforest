// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.util.math.MathHelper;
import twilightforest.entity.EntityTFGoblinKnightLower;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBiped;

public class ModelTFGoblinKnightLower extends ModelBiped
{
    public ModelRenderer tunic;
    
    public ModelTFGoblinKnightLower() {
        this.field_78117_n = false;
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        (this.field_78116_c = new ModelRenderer((ModelBase)this, 0, 32)).func_78789_a(-2.5f, -5.0f, -3.5f, 5, 5, 5);
        this.field_78116_c.func_78793_a(0.0f, 10.0f, 1.0f);
        (this.field_178720_f = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 0, 0, 0);
        (this.field_78115_e = new ModelRenderer((ModelBase)this, 16, 48)).func_78789_a(-3.5f, 0.0f, -2.0f, 7, 8, 4);
        this.field_78115_e.func_78793_a(0.0f, 8.0f, 0.0f);
        (this.field_178723_h = new ModelRenderer((ModelBase)this, 40, 48)).func_78789_a(-2.0f, -2.0f, -1.5f, 2, 8, 3);
        this.field_178723_h.func_78793_a(-3.5f, 10.0f, 0.0f);
        this.field_178724_i = new ModelRenderer((ModelBase)this, 40, 48);
        this.field_178724_i.field_78809_i = true;
        this.field_178724_i.func_78789_a(0.0f, -2.0f, -1.5f, 2, 8, 3);
        this.field_178724_i.func_78793_a(3.5f, 10.0f, 0.0f);
        (this.field_178721_j = new ModelRenderer((ModelBase)this, 0, 48)).func_78789_a(-3.0f, 0.0f, -2.0f, 4, 8, 4);
        this.field_178721_j.func_78793_a(-2.5f, 16.0f, 0.0f);
        this.field_178722_k = new ModelRenderer((ModelBase)this, 0, 48);
        this.field_178722_k.field_78809_i = true;
        this.field_178722_k.func_78789_a(-1.0f, 0.0f, -2.0f, 4, 8, 4);
        this.field_178722_k.func_78793_a(2.5f, 16.0f, 0.0f);
        (this.tunic = new ModelRenderer((ModelBase)this, 64, 19)).func_78789_a(-6.0f, 0.0f, -3.0f, 12, 9, 6);
        this.tunic.func_78793_a(0.0f, 7.5f, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scale) {
        super.func_78088_a(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        if (((EntityTFGoblinKnightLower)entity).hasArmor()) {
            this.renderTunic(scale);
        }
    }
    
    public void renderTunic(final float scale) {
        this.tunic.func_78785_a(scale);
    }
    
    public void func_78087_a(final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scaleFactor, final Entity entity) {
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
        if (this.field_187075_l != ModelBiped.ArmPose.EMPTY) {
            this.field_178724_i.field_78795_f = this.field_178724_i.field_78795_f * 0.5f - 0.31415927f;
        }
        if (this.field_187076_m != ModelBiped.ArmPose.EMPTY) {
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
    }
}
