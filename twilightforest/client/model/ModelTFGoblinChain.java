// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

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
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        this.chain.func_78785_a(f5);
    }
}
