// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.entity.Entity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import twilightforest.entity.boss.HydraMortarHead;
import net.minecraft.client.renderer.entity.model.SegmentedModel;

public class HydraMortarModel extends SegmentedModel<HydraMortarHead>
{
    public ModelRenderer box;
    
    public HydraMortarModel() {
        this.field_78090_t = 32;
        this.field_78089_u = 32;
        (this.box = new ModelRenderer((Model)this, 0, 0)).func_228301_a_(-4.0f, 0.0f, -4.0f, 8.0f, 8.0f, 8.0f, 0.0f);
        this.box.func_78793_a(0.0f, 0.0f, 0.0f);
    }
    
    public void setRotationAngles(final HydraMortarHead entity, final float v, final float v1, final float v2, final float v3, final float v4) {
    }
    
    public Iterable<ModelRenderer> func_225601_a_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.box);
    }
}
