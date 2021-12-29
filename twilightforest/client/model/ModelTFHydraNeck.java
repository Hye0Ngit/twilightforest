// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelTFHydraNeck extends ModelBase
{
    ModelRenderer neck;
    
    public ModelTFHydraNeck() {
        this.field_78090_t = 512;
        this.field_78089_u = 256;
        this.func_78085_a("neck.box", 128, 136);
        this.func_78085_a("neck.fin", 128, 200);
        (this.neck = new ModelRenderer((ModelBase)this, "neck")).func_78786_a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.neck.func_78786_a("fin", -2.0f, -23.0f, 0.0f, 4, 24, 24);
        this.neck.func_78793_a(0.0f, 0.0f, 0.0f);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.field_78795_f = x;
        model.field_78796_g = y;
        model.field_78808_h = z;
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        this.neck.func_78785_a(f5);
    }
    
    public void func_78087_a(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity entity) {
        this.neck.field_78796_g = f3 / 57.29578f;
        this.neck.field_78795_f = f4 / 57.29578f;
    }
}
