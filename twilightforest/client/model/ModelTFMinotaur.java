// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBiped;

public class ModelTFMinotaur extends ModelBiped
{
    public ModelRenderer righthorn1;
    public ModelRenderer righthorn2;
    public ModelRenderer lefthorn1;
    public ModelRenderer lefthorn2;
    ModelRenderer snout;
    
    public ModelTFMinotaur() {
        (this.righthorn1 = new ModelRenderer((ModelBase)this, 24, 0)).func_78789_a(-5.5f, -1.5f, -1.5f, 5, 3, 3);
        this.righthorn1.func_78793_a(-2.5f, -6.5f, 0.0f);
        this.righthorn1.field_78796_g = -0.43633235f;
        this.righthorn1.field_78808_h = 0.17453294f;
        (this.righthorn2 = new ModelRenderer((ModelBase)this, 40, 0)).func_78789_a(-3.5f, -1.0f, -1.0f, 3, 2, 2);
        this.righthorn2.func_78793_a(-4.5f, 0.0f, 0.0f);
        this.righthorn2.field_78796_g = -0.2617994f;
        this.righthorn2.field_78808_h = 0.7853982f;
        this.righthorn1.func_78792_a(this.righthorn2);
        this.lefthorn1 = new ModelRenderer((ModelBase)this, 24, 0);
        this.lefthorn1.field_78809_i = true;
        this.lefthorn1.func_78789_a(0.5f, -1.5f, -1.5f, 5, 3, 3);
        this.lefthorn1.func_78793_a(2.5f, -6.5f, 0.0f);
        this.lefthorn1.field_78796_g = 0.43633235f;
        this.lefthorn1.field_78808_h = -0.17453294f;
        (this.lefthorn2 = new ModelRenderer((ModelBase)this, 40, 0)).func_78789_a(0.5f, -1.0f, -1.0f, 3, 2, 2);
        this.lefthorn2.func_78793_a(4.5f, 0.0f, 0.0f);
        this.lefthorn2.field_78796_g = 0.2617994f;
        this.lefthorn2.field_78808_h = -0.7853982f;
        this.lefthorn1.func_78792_a(this.lefthorn2);
        this.field_78116_c.func_78792_a(this.righthorn1);
        this.field_78116_c.func_78792_a(this.lefthorn1);
        (this.snout = new ModelRenderer((ModelBase)this, 9, 12)).func_78789_a(-2.0f, -1.0f, -1.0f, 4, 3, 1);
        this.snout.func_78793_a(0.0f, -2.0f, -4.0f);
        this.field_78116_c.func_78792_a(this.snout);
        this.field_78114_d = new ModelRenderer((ModelBase)this, 0, 0);
    }
}
