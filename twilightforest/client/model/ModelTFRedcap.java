// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBiped;

public class ModelTFRedcap extends ModelBiped
{
    ModelRenderer goblinRightEar;
    ModelRenderer goblinLeftEar;
    
    public ModelTFRedcap() {
        (this.field_78116_c = new ModelRenderer((ModelBase)this, 0, 0)).func_78790_a(-3.4f, 1.0f, -4.0f, 7, 7, 7, 0.0f);
        this.field_78116_c.func_78793_a(0.0f, 0.0f, 0.0f);
        (this.field_78114_d = new ModelRenderer((ModelBase)this, 32, 0)).func_78790_a(-2.0f, 0.0f, -3.0f, 4, 5, 7, 0.0f);
        this.field_78114_d.func_78793_a(0.0f, 0.0f, 0.0f);
        (this.field_78115_e = new ModelRenderer((ModelBase)this, 12, 19)).func_78790_a(-4.0f, 6.0f, -2.0f, 8, 9, 4, 0.0f);
        this.field_78115_e.func_78793_a(0.0f, 0.0f, 0.0f);
        (this.field_78112_f = new ModelRenderer((ModelBase)this, 36, 17)).func_78790_a(-2.0f, -2.0f, -2.0f, 3, 12, 3, 0.0f);
        this.field_78112_f.func_78793_a(-5.0f, 8.0f, 0.0f);
        (this.field_78113_g = new ModelRenderer((ModelBase)this, 36, 17)).func_78790_a(-1.0f, -2.0f, -2.0f, 3, 12, 3, 0.0f);
        this.field_78113_g.func_78793_a(5.0f, 8.0f, 0.0f);
        (this.field_78123_h = new ModelRenderer((ModelBase)this, 0, 20)).func_78790_a(-2.0f, 2.0f, -1.0f, 3, 9, 3, 0.0f);
        this.field_78123_h.func_78793_a(-2.0f, 12.0f, 0.0f);
        (this.field_78124_i = new ModelRenderer((ModelBase)this, 0, 20)).func_78790_a(-1.0f, 3.0f, -1.0f, 3, 9, 3, 0.0f);
        this.field_78124_i.func_78793_a(2.0f, 12.0f, 0.0f);
        (this.goblinRightEar = new ModelRenderer((ModelBase)this, 48, 20)).func_78790_a(3.0f, -2.0f, -1.0f, 2, 3, 1, 0.0f);
        this.goblinRightEar.func_78793_a(0.0f, 3.0f, 0.0f);
        (this.goblinLeftEar = new ModelRenderer((ModelBase)this, 48, 24)).func_78790_a(-5.0f, -2.0f, -1.0f, 2, 3, 1, 0.0f);
        this.goblinLeftEar.func_78793_a(0.0f, 3.0f, 0.0f);
        this.goblinLeftEar.field_78809_i = true;
    }
    
    public void func_78087_a(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity entity) {
        super.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        this.goblinRightEar.field_78795_f = this.field_78116_c.field_78795_f;
        this.goblinRightEar.field_78796_g = this.field_78116_c.field_78796_g;
        this.goblinRightEar.field_78808_h = this.field_78116_c.field_78808_h;
        this.goblinLeftEar.field_78795_f = this.field_78116_c.field_78795_f;
        this.goblinLeftEar.field_78796_g = this.field_78116_c.field_78796_g;
        this.goblinLeftEar.field_78808_h = this.field_78116_c.field_78808_h;
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.goblinRightEar.func_78785_a(f5);
        this.goblinLeftEar.func_78785_a(f5);
    }
}
