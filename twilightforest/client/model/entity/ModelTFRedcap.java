// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

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
        (this.field_178720_f = new ModelRenderer((ModelBase)this, 32, 0)).func_78790_a(-2.0f, 0.0f, -3.0f, 4, 5, 7, 0.0f);
        this.field_178720_f.func_78793_a(0.0f, 0.0f, 0.0f);
        (this.field_78115_e = new ModelRenderer((ModelBase)this, 12, 19)).func_78790_a(-4.0f, 6.0f, -2.0f, 8, 9, 4, 0.0f);
        this.field_78115_e.func_78793_a(0.0f, 0.0f, 0.0f);
        (this.field_178723_h = new ModelRenderer((ModelBase)this, 36, 17)).func_78790_a(-2.0f, -2.0f, -2.0f, 3, 12, 3, 0.0f);
        this.field_178723_h.func_78793_a(-5.0f, 8.0f, 0.0f);
        (this.field_178724_i = new ModelRenderer((ModelBase)this, 36, 17)).func_78790_a(-1.0f, -2.0f, -2.0f, 3, 12, 3, 0.0f);
        this.field_178724_i.func_78793_a(5.0f, 8.0f, 0.0f);
        (this.field_178721_j = new ModelRenderer((ModelBase)this, 0, 20)).func_78790_a(-2.0f, 2.0f, -1.0f, 3, 9, 3, 0.0f);
        this.field_178721_j.func_78793_a(-2.0f, 12.0f, 0.0f);
        (this.field_178722_k = new ModelRenderer((ModelBase)this, 0, 20)).func_78790_a(-1.0f, 3.0f, -1.0f, 3, 9, 3, 0.0f);
        this.field_178722_k.func_78793_a(2.0f, 12.0f, 0.0f);
        (this.goblinRightEar = new ModelRenderer((ModelBase)this, 48, 20)).func_78790_a(3.0f, -2.0f, -1.0f, 2, 3, 1, 0.0f);
        this.goblinRightEar.func_78793_a(0.0f, 3.0f, 0.0f);
        (this.goblinLeftEar = new ModelRenderer((ModelBase)this, 48, 24)).func_78790_a(-5.0f, -2.0f, -1.0f, 2, 3, 1, 0.0f);
        this.goblinLeftEar.func_78793_a(0.0f, 3.0f, 0.0f);
        this.goblinLeftEar.field_78809_i = true;
    }
    
    public void func_78087_a(final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scaleFactor, final Entity entity) {
        super.func_78087_a(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
        this.goblinRightEar.field_78795_f = this.field_78116_c.field_78795_f;
        this.goblinRightEar.field_78796_g = this.field_78116_c.field_78796_g;
        this.goblinRightEar.field_78808_h = this.field_78116_c.field_78808_h;
        this.goblinLeftEar.field_78795_f = this.field_78116_c.field_78795_f;
        this.goblinLeftEar.field_78796_g = this.field_78116_c.field_78796_g;
        this.goblinLeftEar.field_78808_h = this.field_78116_c.field_78808_h;
    }
    
    public void func_78088_a(final Entity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scale) {
        super.func_78088_a(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.goblinRightEar.func_78785_a(scale);
        this.goblinLeftEar.func_78785_a(scale);
    }
}
