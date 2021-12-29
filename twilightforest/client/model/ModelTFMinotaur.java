// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBiped;

public class ModelTFMinotaur extends ModelBiped
{
    ModelRenderer horn1a;
    ModelRenderer horn1b;
    ModelRenderer horn2a;
    ModelRenderer horn2b;
    ModelRenderer snout;
    
    public ModelTFMinotaur() {
        (this.horn1a = new ModelRenderer((ModelBase)this, 24, 0)).func_78789_a(0.0f, -1.0f, -1.0f, 3, 2, 2);
        this.horn1a.func_78793_a(4.0f, -6.0f, 0.0f);
        this.horn1a.field_78796_g = 0.2617994f;
        this.field_78116_c.func_78792_a(this.horn1a);
        (this.horn1b = new ModelRenderer((ModelBase)this, 24, 2)).func_78789_a(-1.0f, -4.0f, -1.0f, 2, 4, 2);
        this.horn1b.func_78793_a(2.75f, 0.0f, 0.0f);
        this.horn1b.field_78795_f = 0.5235988f;
        this.horn1b.field_78796_g = -0.5235988f;
        this.horn1a.func_78792_a(this.horn1b);
        (this.horn2a = new ModelRenderer((ModelBase)this, 24, 0)).func_78789_a(-3.0f, -1.0f, -1.0f, 3, 2, 2);
        this.horn2a.func_78793_a(-4.0f, -6.0f, 0.0f);
        this.horn2a.field_78796_g = -0.2617994f;
        this.field_78116_c.func_78792_a(this.horn2a);
        (this.horn2b = new ModelRenderer((ModelBase)this, 24, 2)).func_78789_a(-1.0f, -4.0f, -1.0f, 2, 4, 2);
        this.horn2b.func_78793_a(-2.75f, 0.0f, 0.0f);
        this.horn2b.field_78795_f = 0.5235988f;
        this.horn2b.field_78796_g = 0.5235988f;
        this.horn2a.func_78792_a(this.horn2b);
        (this.snout = new ModelRenderer((ModelBase)this, 9, 12)).func_78789_a(-2.0f, -1.0f, -1.0f, 4, 3, 1);
        this.snout.func_78793_a(0.0f, -2.0f, -4.0f);
        this.field_78116_c.func_78792_a(this.snout);
    }
}
