// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;

public class FireflyModel extends SegmentedModel<Entity>
{
    public ModelRenderer legs;
    public ModelRenderer fatbody;
    public ModelRenderer skinnybody;
    public ModelRenderer glow;
    
    public FireflyModel() {
        (this.legs = new ModelRenderer((Model)this, 0, 21)).func_228301_a_(-4.0f, 7.9f, -5.0f, 8.0f, 1.0f, 10.0f, 0.0f);
        (this.fatbody = new ModelRenderer((Model)this, 0, 11)).func_228301_a_(-2.0f, 6.0f, -4.0f, 4.0f, 2.0f, 6.0f, 0.0f);
        (this.skinnybody = new ModelRenderer((Model)this, 0, 0)).func_228301_a_(-1.0f, 7.0f, -5.0f, 2.0f, 1.0f, 8.0f, 0.0f);
        (this.glow = new ModelRenderer((Model)this, 20, 0)).func_228301_a_(-5.0f, 5.9f, -9.0f, 10.0f, 0.0f, 10.0f, 0.0f);
    }
    
    public Iterable<ModelRenderer> func_225601_a_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.legs, (Object)this.fatbody, (Object)this.skinnybody);
    }
    
    public void func_225597_a_(final Entity entity, final float v, final float v1, final float v2, final float v3, final float v4) {
    }
}
