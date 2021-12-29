// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelSkeleton;

public class ModelTFSkeletonDruid extends ModelSkeleton
{
    private ModelRenderer dress;
    
    public ModelTFSkeletonDruid() {
        (this.field_78115_e = new ModelRenderer((ModelBase)this, 8, 16)).func_78790_a(-4.0f, 0.0f, -2.0f, 8, 12, 4, 0.0f);
        this.field_78115_e.func_78793_a(0.0f, 0.0f, 0.0f);
        (this.field_178723_h = new ModelRenderer((ModelBase)this, 0, 16)).func_78790_a(-1.0f, -2.0f, -1.0f, 2, 12, 2, 0.0f);
        this.field_178723_h.func_78793_a(-5.0f, 2.0f, 0.0f);
        this.field_178724_i = new ModelRenderer((ModelBase)this, 0, 16);
        this.field_178724_i.field_78809_i = true;
        this.field_178724_i.func_78790_a(-1.0f, -2.0f, -1.0f, 2, 12, 2, 0.0f);
        this.field_178724_i.func_78793_a(5.0f, 2.0f, 0.0f);
        (this.dress = new ModelRenderer((ModelBase)this, 32, 16)).func_78790_a(-4.0f, 12.0f, -2.0f, 8, 12, 4, 0.0f);
        this.dress.func_78793_a(0.0f, 0.0f, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scale) {
        super.func_78088_a(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.dress.func_78785_a(scale);
    }
}
