// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelTFTinyFirefly extends ModelBase
{
    public ModelRenderer glow1;
    
    public ModelTFTinyFirefly() {
        (this.glow1 = new ModelRenderer((ModelBase)this, 20, 0)).func_78790_a(-5.0f, -5.0f, 0.0f, 10, 10, 0, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scale) {
        this.glow1.func_78785_a(scale);
    }
    
    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
    }
}
