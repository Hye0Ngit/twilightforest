// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelTFHydraMortar extends ModelBase
{
    public ModelRenderer box;
    
    public ModelTFHydraMortar() {
        this.field_78090_t = 32;
        this.field_78089_u = 32;
        (this.box = new ModelRenderer((ModelBase)this, 0, 0)).func_78790_a(-4.0f, 0.0f, -4.0f, 8, 8, 8, 0.0f);
        this.box.func_78793_a(0.0f, 0.0f, 0.0f);
    }
    
    public void render(final float f5) {
        this.box.func_78785_a(f5);
    }
}
