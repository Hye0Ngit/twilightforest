// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelQuadruped;

public class ModelTFBoar extends ModelQuadruped
{
    public ModelTFBoar() {
        super(6, 0.0f);
        this.field_78145_g = 4.0f;
        (this.field_78150_a = new ModelRenderer((ModelBase)this, 0, 0)).func_78790_a(-4.0f, -2.0f, -6.0f, 8, 7, 6, 0.0f);
        this.field_78150_a.func_78793_a(0.0f, 12.0f, -6.0f);
        (this.field_78148_b = new ModelRenderer((ModelBase)this, 28, 10)).func_78790_a(-5.0f, -8.0f, -7.0f, 10, 14, 8, 0.0f);
        this.field_78148_b.func_78793_a(0.0f, 11.0f, 2.0f);
        this.field_78148_b.field_78795_f = 1.570796f;
        (this.field_78149_c = new ModelRenderer((ModelBase)this, 0, 16)).func_78790_a(-2.0f, 0.0f, -2.0f, 4, 6, 4, 0.0f);
        this.field_78149_c.func_78793_a(-3.0f, 18.0f, 7.0f);
        (this.field_78146_d = new ModelRenderer((ModelBase)this, 0, 16)).func_78790_a(-2.0f, 0.0f, -2.0f, 4, 6, 4, 0.0f);
        this.field_78146_d.func_78793_a(3.0f, 18.0f, 7.0f);
        (this.field_78147_e = new ModelRenderer((ModelBase)this, 0, 16)).func_78790_a(-2.0f, 0.0f, -2.0f, 4, 6, 4, 0.0f);
        this.field_78147_e.func_78793_a(-3.0f, 18.0f, -5.0f);
        (this.field_78144_f = new ModelRenderer((ModelBase)this, 0, 16)).func_78790_a(-2.0f, 0.0f, -2.0f, 4, 6, 4, 0.0f);
        this.field_78144_f.func_78793_a(3.0f, 18.0f, -5.0f);
        this.field_78150_a.func_78784_a(28, 0).func_78790_a(-3.0f, 1.0f, -9.0f, 6, 4, 3, 0.0f);
        this.field_78150_a.func_78784_a(17, 17).func_78790_a(3.0f, 2.0f, -9.0f, 1, 2, 1, 0.0f);
        this.field_78150_a.func_78784_a(17, 17).func_78790_a(-4.0f, 2.0f, -9.0f, 1, 2, 1, 0.0f);
    }
}
