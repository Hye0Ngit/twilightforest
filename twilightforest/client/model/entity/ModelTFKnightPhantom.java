// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBiped;

@Deprecated
public class ModelTFKnightPhantom extends ModelBiped
{
    public ModelRenderer helmet;
    public ModelRenderer righthorn1;
    public ModelRenderer righthorn2;
    public ModelRenderer lefthorn1;
    public ModelRenderer lefthorn2;
    
    @Deprecated
    public ModelTFKnightPhantom() {
        this.field_78117_n = false;
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        (this.field_78116_c = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 0, 0, 0);
        this.field_78116_c.func_78793_a(0.0f, -10.0f, 0.0f);
        (this.field_178720_f = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 0, 0, 0);
        this.field_178720_f.func_78793_a(0.0f, -10.0f, 0.0f);
        (this.helmet = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-4.0f, -11.0f, -4.0f, 8, 11, 8);
        this.helmet.field_78796_g = 0.7853982f;
        (this.righthorn1 = new ModelRenderer((ModelBase)this, 28, 0)).func_78789_a(-6.0f, -1.5f, -1.5f, 7, 3, 3);
        this.righthorn1.func_78793_a(-3.5f, -9.0f, 0.0f);
        this.righthorn1.field_78796_g = 0.2617994f;
        this.righthorn1.field_78808_h = 0.17453294f;
        (this.righthorn2 = new ModelRenderer((ModelBase)this, 28, 6)).func_78789_a(-3.0f, -1.0f, -1.0f, 3, 2, 2);
        this.righthorn2.func_78793_a(-5.5f, 0.0f, 0.0f);
        this.righthorn2.field_78808_h = 0.17453294f;
        this.righthorn1.func_78792_a(this.righthorn2);
        this.lefthorn1 = new ModelRenderer((ModelBase)this, 28, 0);
        this.lefthorn1.field_78809_i = true;
        this.lefthorn1.func_78789_a(-1.0f, -1.5f, -1.5f, 7, 3, 3);
        this.lefthorn1.func_78793_a(3.5f, -9.0f, 0.0f);
        this.lefthorn1.field_78796_g = -0.2617994f;
        this.lefthorn1.field_78808_h = -0.17453294f;
        (this.lefthorn2 = new ModelRenderer((ModelBase)this, 28, 6)).func_78789_a(0.0f, -1.0f, -1.0f, 3, 2, 2);
        this.lefthorn2.func_78793_a(5.5f, 0.0f, 0.0f);
        this.lefthorn2.field_78808_h = -0.17453294f;
        this.lefthorn1.func_78792_a(this.lefthorn2);
        this.field_178720_f.func_78792_a(this.helmet);
        this.field_178720_f.func_78792_a(this.righthorn1);
        this.field_178720_f.func_78792_a(this.lefthorn1);
        (this.field_78115_e = new ModelRenderer((ModelBase)this, 0, 18)).func_78793_a(0.0f, 2.0f, 0.0f);
        this.field_78115_e.func_78789_a(-7.0f, -12.0f, -3.5f, 14, 12, 7);
        this.field_78115_e.func_78784_a(30, 24).func_78789_a(-6.0f, 0.0f, -3.0f, 12, 8, 6);
        (this.field_178723_h = new ModelRenderer((ModelBase)this, 44, 16)).func_78789_a(-5.0f, -2.0f, -3.0f, 6, 7, 6);
        this.field_178723_h.func_78793_a(-8.0f, -8.0f, 0.0f);
        this.field_178724_i = new ModelRenderer((ModelBase)this, 44, 16);
        this.field_178724_i.field_78809_i = true;
        this.field_178724_i.func_78789_a(-1.0f, -2.0f, -3.0f, 6, 7, 6);
        this.field_178724_i.func_78793_a(8.0f, -8.0f, 0.0f);
        (this.field_178721_j = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 0, 0, 0);
        this.field_178721_j.func_78793_a(0.0f, 12.0f, 0.0f);
        (this.field_178722_k = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 0, 0, 0);
        this.field_178722_k.func_78793_a(0.0f, 12.0f, 0.0f);
    }
    
    public void func_78087_a(final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scaleFactor, final Entity entity) {
        this.field_78116_c.field_78796_g = netHeadYaw / 57.295776f;
        this.field_78116_c.field_78795_f = headPitch / 57.295776f;
        this.field_78116_c.field_78808_h = 0.0f;
        this.field_178720_f.field_78796_g = this.field_78116_c.field_78796_g;
        this.field_178720_f.field_78795_f = this.field_78116_c.field_78795_f;
        this.field_178720_f.field_78808_h = this.field_78116_c.field_78808_h;
        this.field_178723_h.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f + 3.1415927f) * 2.0f * limbSwingAmount * 0.5f;
        this.field_178724_i.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f) * 2.0f * limbSwingAmount * 0.5f;
        this.field_178723_h.field_78808_h = 0.0f;
        this.field_178724_i.field_78808_h = 0.0f;
        if (this.field_187075_l != ModelBiped.ArmPose.EMPTY) {
            this.field_178724_i.field_78795_f = this.field_178724_i.field_78795_f * 0.5f - 0.31415927f;
        }
        this.field_187076_m = ModelBiped.ArmPose.ITEM;
        if (this.field_187076_m != ModelBiped.ArmPose.EMPTY) {
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
    }
}
