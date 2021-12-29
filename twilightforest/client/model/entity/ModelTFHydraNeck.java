// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

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
    
    public void func_78088_a(final Entity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scale) {
        super.func_78088_a(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.func_78087_a(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
        this.neck.func_78785_a(scale);
    }
    
    public void func_78087_a(final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scaleFactor, final Entity entity) {
        this.neck.field_78796_g = netHeadYaw / 57.29578f;
        this.neck.field_78795_f = headPitch / 57.29578f;
    }
}
