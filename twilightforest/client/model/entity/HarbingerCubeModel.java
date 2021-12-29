// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import twilightforest.entity.HarbingerCubeEntity;

public class HarbingerCubeModel<T extends HarbingerCubeEntity> extends QuadrupedModel<T>
{
    public HarbingerCubeModel() {
        this(0.0f);
    }
    
    public HarbingerCubeModel(final float fNumber) {
        super(6, fNumber, false, 0.0f, 0.0f, 0.0f, 0.0f, 4);
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.field_78150_a = new ModelRenderer((Model)this, 0, 0);
        (this.field_78148_b = new ModelRenderer((Model)this, 0, 0)).func_228300_a_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f);
        this.field_78148_b.func_78793_a(0.0f, 0.0f, -2.0f);
        (this.field_78149_c = new ModelRenderer((Model)this, 0, 0)).func_228300_a_(-4.0f, 0.0f, -4.0f, 8.0f, 8.0f, 8.0f);
        this.field_78149_c.func_78793_a(-6.0f, 16.0f, 9.0f);
        (this.field_78146_d = new ModelRenderer((Model)this, 0, 0)).func_228300_a_(-4.0f, 0.0f, -4.0f, 8.0f, 8.0f, 8.0f);
        this.field_78146_d.func_78793_a(6.0f, 16.0f, 9.0f);
        (this.field_78147_e = new ModelRenderer((Model)this, 0, 0)).func_228300_a_(-4.0f, 0.0f, -4.0f, 8.0f, 8.0f, 8.0f);
        this.field_78147_e.func_78793_a(-9.0f, 16.0f, -14.0f);
        (this.field_78144_f = new ModelRenderer((Model)this, 0, 0)).func_228300_a_(-4.0f, 0.0f, -4.0f, 8.0f, 8.0f, 8.0f);
        this.field_78144_f.func_78793_a(9.0f, 16.0f, -14.0f);
    }
    
    public void setRotationAngles(final T entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        super.func_225597_a_((Entity)entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        this.field_78148_b.field_78795_f = 0.0f;
    }
}
