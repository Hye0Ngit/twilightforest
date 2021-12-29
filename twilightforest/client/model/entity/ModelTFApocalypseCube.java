// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelQuadruped;

public class ModelTFApocalypseCube extends ModelQuadruped
{
    public ModelTFApocalypseCube() {
        this(0.0f);
    }
    
    public ModelTFApocalypseCube(final float fNumber) {
        super(6, fNumber);
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.field_78150_a = new ModelRenderer((ModelBase)this, 0, 0);
        (this.field_78148_b = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.field_78148_b.func_78793_a(0.0f, 0.0f, -2.0f);
        (this.field_78149_c = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-4.0f, 0.0f, -4.0f, 8, 8, 8);
        this.field_78149_c.func_78793_a(-6.0f, 16.0f, 9.0f);
        (this.field_78146_d = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-4.0f, 0.0f, -4.0f, 8, 8, 8);
        this.field_78146_d.func_78793_a(6.0f, 16.0f, 9.0f);
        (this.field_78147_e = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-4.0f, 0.0f, -4.0f, 8, 8, 8);
        this.field_78147_e.func_78793_a(-9.0f, 16.0f, -14.0f);
        (this.field_78144_f = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-4.0f, 0.0f, -4.0f, 8, 8, 8);
        this.field_78144_f.func_78793_a(9.0f, 16.0f, -14.0f);
        this.field_78145_g = 4.0f;
    }
    
    public void func_78087_a(final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scaleFactor, final Entity entity) {
        super.func_78087_a(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
        this.field_78148_b.field_78795_f = 0.0f;
    }
}
