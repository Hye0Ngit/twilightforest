// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import java.util.function.Function;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.model.Model;

public class CicadaModel extends Model
{
    public ModelRenderer legs;
    public ModelRenderer fatbody;
    public ModelRenderer skinnybody;
    public ModelRenderer eye1;
    public ModelRenderer eye2;
    public ModelRenderer wings;
    
    public CicadaModel() {
        super((Function)RenderType::func_228640_c_);
        (this.legs = new ModelRenderer((Model)this, 0, 21)).func_228301_a_(-4.0f, 7.9f, -5.0f, 8.0f, 1.0f, 9.0f, 0.0f);
        (this.fatbody = new ModelRenderer((Model)this, 0, 11)).func_228301_a_(-2.0f, 6.0f, -4.0f, 4.0f, 2.0f, 6.0f, 0.0f);
        (this.skinnybody = new ModelRenderer((Model)this, 0, 0)).func_228301_a_(-1.0f, 7.0f, -5.0f, 2.0f, 1.0f, 8.0f, 0.0f);
        (this.eye1 = new ModelRenderer((Model)this, 20, 15)).func_228301_a_(1.0f, 5.0f, 2.0f, 2.0f, 2.0f, 2.0f, 0.0f);
        (this.eye2 = new ModelRenderer((Model)this, 20, 15)).func_228301_a_(-3.0f, 5.0f, 2.0f, 2.0f, 2.0f, 2.0f, 0.0f);
        (this.wings = new ModelRenderer((Model)this, 20, 0)).func_228301_a_(-4.0f, 5.0f, -7.0f, 8.0f, 1.0f, 8.0f, 0.0f);
    }
    
    public void func_225598_a_(final MatrixStack ms, final IVertexBuilder buffer, final int light, final int overlay, final float r, final float g, final float b, final float a) {
        this.legs.func_228309_a_(ms, buffer, light, overlay, r, g, b, a);
        this.fatbody.func_228309_a_(ms, buffer, light, overlay, r, g, b, a);
        this.skinnybody.func_228309_a_(ms, buffer, light, overlay, r, g, b, a);
        this.eye1.func_228309_a_(ms, buffer, light, overlay, r, g, b, a);
        this.eye2.func_228309_a_(ms, buffer, light, overlay, r, g, b, a);
        this.wings.func_228309_a_(ms, buffer, light, overlay, r, g, b, a);
    }
}
