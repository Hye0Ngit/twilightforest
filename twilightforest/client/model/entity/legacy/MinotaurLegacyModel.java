// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity.legacy;

import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import twilightforest.entity.MinotaurEntity;
import net.minecraft.client.renderer.entity.model.BipedModel;

public class MinotaurLegacyModel extends BipedModel<MinotaurEntity>
{
    public ModelRenderer righthorn1;
    public ModelRenderer righthorn2;
    public ModelRenderer lefthorn1;
    public ModelRenderer lefthorn2;
    ModelRenderer snout;
    
    public MinotaurLegacyModel() {
        super(0.0f);
        (this.righthorn1 = new ModelRenderer((Model)this, 24, 0)).func_228300_a_(-5.5f, -1.5f, -1.5f, 5.0f, 3.0f, 3.0f);
        this.righthorn1.func_78793_a(-2.5f, -6.5f, 0.0f);
        this.righthorn1.field_78796_g = -0.43633235f;
        this.righthorn1.field_78808_h = 0.17453294f;
        (this.righthorn2 = new ModelRenderer((Model)this, 40, 0)).func_228300_a_(-3.5f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f);
        this.righthorn2.func_78793_a(-4.5f, 0.0f, 0.0f);
        this.righthorn2.field_78796_g = -0.2617994f;
        this.righthorn2.field_78808_h = 0.7853982f;
        this.righthorn1.func_78792_a(this.righthorn2);
        this.lefthorn1 = new ModelRenderer((Model)this, 24, 0);
        this.lefthorn1.field_78809_i = true;
        this.lefthorn1.func_228300_a_(0.5f, -1.5f, -1.5f, 5.0f, 3.0f, 3.0f);
        this.lefthorn1.func_78793_a(2.5f, -6.5f, 0.0f);
        this.lefthorn1.field_78796_g = 0.43633235f;
        this.lefthorn1.field_78808_h = -0.17453294f;
        (this.lefthorn2 = new ModelRenderer((Model)this, 40, 0)).func_228300_a_(0.5f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f);
        this.lefthorn2.func_78793_a(4.5f, 0.0f, 0.0f);
        this.lefthorn2.field_78796_g = 0.2617994f;
        this.lefthorn2.field_78808_h = -0.7853982f;
        this.lefthorn1.func_78792_a(this.lefthorn2);
        this.field_78116_c.func_78792_a(this.righthorn1);
        this.field_78116_c.func_78792_a(this.lefthorn1);
        (this.snout = new ModelRenderer((Model)this, 9, 12)).func_228300_a_(-2.0f, -1.0f, -1.0f, 4.0f, 3.0f, 1.0f);
        this.snout.func_78793_a(0.0f, -2.0f, -4.0f);
        this.field_78116_c.func_78792_a(this.snout);
        this.field_178720_f = new ModelRenderer((Model)this, 0, 0);
    }
}
