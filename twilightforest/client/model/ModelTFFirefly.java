// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelTFFirefly extends ModelBase
{
    public ModelRenderer legs;
    public ModelRenderer fatbody;
    public ModelRenderer skinnybody;
    public ModelRenderer glow;
    
    public ModelTFFirefly() {
        (this.legs = new ModelRenderer((ModelBase)this, 0, 21)).func_78790_a(-4.0f, 7.9f, -5.0f, 8, 1, 10, 0.0f);
        (this.fatbody = new ModelRenderer((ModelBase)this, 0, 11)).func_78790_a(-2.0f, 6.0f, -4.0f, 4, 2, 6, 0.0f);
        (this.skinnybody = new ModelRenderer((ModelBase)this, 0, 0)).func_78790_a(-1.0f, 7.0f, -5.0f, 2, 1, 8, 0.0f);
        (this.glow = new ModelRenderer((ModelBase)this, 20, 0)).func_78790_a(-5.0f, 5.9f, -9.0f, 10, 0, 10, 0.0f);
    }
    
    public void render(final float f5) {
        this.legs.func_78785_a(f5);
        this.fatbody.func_78785_a(f5);
        this.skinnybody.func_78785_a(f5);
    }
    
    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
    }
}
