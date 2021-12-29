// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import twilightforest.entity.boss.EntityTFNagaSegment;
import twilightforest.entity.boss.EntityTFNaga;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelTFNaga extends ModelBase
{
    public ModelRenderer head;
    public ModelRenderer body;
    
    public ModelTFNaga() {
        (this.head = new ModelRenderer((ModelBase)this, 0, 0)).func_78790_a(-8.0f, -12.0f, -8.0f, 16, 16, 16, 0.0f);
        this.head.func_78793_a(0.0f, 0.0f, 0.0f);
        (this.body = new ModelRenderer((ModelBase)this, 0, 0)).func_78790_a(-8.0f, -16.0f, -8.0f, 16, 16, 16, 0.0f);
        this.body.func_78793_a(0.0f, 0.0f, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scale) {
        super.func_78088_a(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.func_78087_a(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
        if (entity instanceof EntityTFNaga) {
            this.head.func_78785_a(scale * 2.0f);
        }
        else if (entity instanceof EntityTFNagaSegment) {
            this.body.func_78785_a(scale * 2.0f);
        }
        else {
            this.head.func_78785_a(scale * 2.0f);
        }
    }
}
