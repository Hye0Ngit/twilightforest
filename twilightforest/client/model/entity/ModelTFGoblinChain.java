// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelTFGoblinChain extends ModelBase
{
    ModelRenderer chain;
    
    public ModelTFGoblinChain() {
        (this.chain = new ModelRenderer((ModelBase)this, 56, 16)).func_78790_a(-1.0f, -1.0f, -1.0f, 2, 2, 2, 0.0f);
        this.chain.func_78793_a(0.0f, 0.0f, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scale) {
        this.chain.func_78785_a(scale);
    }
}
