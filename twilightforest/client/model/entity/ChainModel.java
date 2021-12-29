// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;

public class ChainModel extends SegmentedModel<Entity>
{
    ModelRenderer chain;
    
    public ChainModel() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        (this.chain = new ModelRenderer((Model)this, 56, 36)).func_228301_a_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f, 0.0f);
        this.chain.func_78793_a(0.0f, 0.0f, 0.0f);
    }
    
    public Iterable<ModelRenderer> func_225601_a_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.chain);
    }
    
    public void func_225597_a_(final Entity entity, final float v, final float v1, final float v2, final float v3, final float v4) {
    }
}
