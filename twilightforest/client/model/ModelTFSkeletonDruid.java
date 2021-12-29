// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBiped;

public class ModelTFSkeletonDruid extends ModelBiped
{
    public ModelRenderer dress;
    
    public ModelTFSkeletonDruid() {
        final float f = 0.0f;
        (this.field_78115_e = new ModelRenderer((ModelBase)this, 8, 16)).func_78790_a(-4.0f, 0.0f, -2.0f, 8, 12, 4, f);
        this.field_78115_e.func_78793_a(0.0f, 0.0f + f, 0.0f);
        (this.field_78112_f = new ModelRenderer((ModelBase)this, 0, 16)).func_78790_a(-1.0f, -2.0f, -1.0f, 2, 12, 2, f);
        this.field_78112_f.func_78793_a(-5.0f, 2.0f, 0.0f);
        this.field_78113_g = new ModelRenderer((ModelBase)this, 0, 16);
        this.field_78113_g.field_78809_i = true;
        this.field_78113_g.func_78790_a(-1.0f, -2.0f, -1.0f, 2, 12, 2, f);
        this.field_78113_g.func_78793_a(5.0f, 2.0f, 0.0f);
        (this.field_78123_h = new ModelRenderer((ModelBase)this, 0, 16)).func_78789_a(-1.0f, 0.0f, -1.0f, 2, 12, 2);
        this.field_78123_h.func_78793_a(-2.0f, 12.0f, 0.0f);
        this.field_78124_i = new ModelRenderer((ModelBase)this, 0, 16);
        this.field_78124_i.field_78809_i = true;
        this.field_78124_i.func_78789_a(-1.0f, 0.0f, -1.0f, 2, 12, 2);
        this.field_78124_i.func_78793_a(2.0f, 12.0f, 0.0f);
        (this.dress = new ModelRenderer((ModelBase)this, 32, 16)).func_78790_a(-4.0f, 12.0f, -2.0f, 8, 12, 4, f);
        this.dress.func_78793_a(0.0f, 0.0f, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.dress.func_78785_a(f5);
    }
}
