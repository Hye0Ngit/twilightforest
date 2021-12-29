// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelQuadruped;

public class ModelTFDeer extends ModelQuadruped
{
    public ModelRenderer neck;
    
    public ModelTFDeer() {
        super(12, 0.0f);
        this.field_78145_g = 10.0f;
        (this.field_78150_a = new ModelRenderer((ModelBase)this, 0, 5)).func_78790_a(-2.0f, -8.0f, -6.0f, 4, 6, 6, 0.0f);
        this.field_78150_a.func_78793_a(0.0f, 4.0f, -7.0f);
        (this.field_78148_b = new ModelRenderer((ModelBase)this, 36, 6)).func_78790_a(-4.0f, -10.0f, -7.0f, 6, 18, 8, 0.0f);
        this.field_78148_b.func_78793_a(1.0f, 5.0f, 2.0f);
        this.field_78148_b.field_78795_f = 1.570796f;
        (this.field_78149_c = new ModelRenderer((ModelBase)this, 0, 17)).func_78790_a(-3.0f, 0.0f, -2.0f, 2, 12, 3, 0.0f);
        this.field_78149_c.func_78793_a(0.0f, 12.0f, 9.0f);
        (this.field_78146_d = new ModelRenderer((ModelBase)this, 0, 17)).func_78790_a(-1.0f, 0.0f, -2.0f, 2, 12, 3, 0.0f);
        this.field_78146_d.func_78793_a(2.0f, 12.0f, 9.0f);
        (this.field_78147_e = new ModelRenderer((ModelBase)this, 0, 17)).func_78790_a(-3.0f, 0.0f, -3.0f, 2, 12, 3, 0.0f);
        this.field_78147_e.func_78793_a(0.0f, 12.0f, -5.0f);
        (this.field_78144_f = new ModelRenderer((ModelBase)this, 0, 17)).func_78790_a(-1.0f, 0.0f, -3.0f, 2, 12, 3, 0.0f);
        this.field_78144_f.func_78793_a(2.0f, 12.0f, -5.0f);
        (this.neck = new ModelRenderer((ModelBase)this, 10, 19)).func_78790_a(-2.5f, -8.0f, -11.0f, 3, 9, 4, 0.0f);
        this.neck.field_78795_f = 4.974188f;
        this.field_78148_b.func_78792_a(this.neck);
        this.field_78150_a.func_78784_a(52, 0).func_78790_a(-1.5f, -5.0f, -9.0f, 3, 3, 3, 0.0f);
        this.field_78150_a.func_78784_a(20, 0);
        this.field_78150_a.func_78790_a(-3.0f, -10.0f, -2.0f, 2, 2, 2, 0.0f);
        this.field_78150_a.func_78790_a(-3.0f, -10.0f, -2.0f, 2, 2, 2, 0.0f);
        this.field_78150_a.func_78790_a(-4.0f, -10.0f, -1.0f, 1, 1, 3, 0.0f);
        this.field_78150_a.func_78790_a(-5.0f, -11.0f, 1.0f, 1, 1, 5, 0.0f);
        this.field_78150_a.func_78790_a(-5.0f, -14.0f, 2.0f, 1, 4, 1, 0.0f);
        this.field_78150_a.func_78790_a(-6.0f, -17.0f, 3.0f, 1, 4, 1, 0.0f);
        this.field_78150_a.func_78790_a(-6.0f, -13.0f, 0.0f, 1, 1, 3, 0.0f);
        this.field_78150_a.func_78790_a(-6.0f, -14.0f, -3.0f, 1, 1, 4, 0.0f);
        this.field_78150_a.func_78790_a(-7.0f, -15.0f, -6.0f, 1, 1, 4, 0.0f);
        this.field_78150_a.func_78790_a(-6.0f, -16.0f, -9.0f, 1, 1, 4, 0.0f);
        this.field_78150_a.func_78790_a(-7.0f, -18.0f, -1.0f, 1, 5, 1, 0.0f);
        this.field_78150_a.func_78790_a(-6.0f, -19.0f, -6.0f, 1, 5, 1, 0.0f);
        this.field_78150_a.func_78790_a(1.0f, -10.0f, -2.0f, 2, 2, 2, 0.0f);
        this.field_78150_a.func_78790_a(3.0f, -10.0f, -1.0f, 1, 1, 3, 0.0f);
        this.field_78150_a.func_78790_a(4.0f, -11.0f, 1.0f, 1, 1, 5, 0.0f);
        this.field_78150_a.func_78790_a(4.0f, -14.0f, 2.0f, 1, 4, 1, 0.0f);
        this.field_78150_a.func_78790_a(5.0f, -17.0f, 3.0f, 1, 4, 1, 0.0f);
        this.field_78150_a.func_78790_a(5.0f, -13.0f, 0.0f, 1, 1, 3, 0.0f);
        this.field_78150_a.func_78790_a(5.0f, -14.0f, -3.0f, 1, 1, 4, 0.0f);
        this.field_78150_a.func_78790_a(6.0f, -15.0f, -6.0f, 1, 1, 4, 0.0f);
        this.field_78150_a.func_78790_a(5.0f, -16.0f, -9.0f, 1, 1, 4, 0.0f);
        this.field_78150_a.func_78790_a(6.0f, -18.0f, -1.0f, 1, 5, 1, 0.0f);
        this.field_78150_a.func_78790_a(5.0f, -19.0f, -6.0f, 1, 5, 1, 0.0f);
    }
}
