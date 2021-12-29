// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import twilightforest.entity.passive.DeerEntity;
import net.minecraft.client.renderer.entity.model.QuadrupedModel;

@OnlyIn(Dist.CLIENT)
public class DeerModel extends QuadrupedModel<DeerEntity>
{
    public ModelRenderer neck;
    public ModelRenderer rightAntler;
    public ModelRenderer leftAntler;
    
    public DeerModel() {
        super(12, 0.0f, false, 4.0f, 4.0f, 2.0f, 2.0f, 10);
        this.field_78090_t = 64;
        this.field_78089_u = 48;
        (this.field_78148_b = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 10.0f, 7.0f);
        this.field_78148_b.func_78784_a(36, 6).func_228302_a_(-3.0f, -14.0f, -2.0f, 6.0f, 18.0f, 8.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.field_78148_b, 1.5707964f, 0.0f, 0.0f);
        (this.rightAntler = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-1.0f, -4.0f, 0.0f);
        this.rightAntler.func_78784_a(0, 16).func_228302_a_(0.0f, -16.0f, -8.0f, 0.0f, 16.0f, 16.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.rightAntler, 0.0f, -0.3926991f, -0.3926991f);
        (this.leftAntler = new ModelRenderer((Model)this, 0, 0)).func_78793_a(1.0f, -4.0f, 0.0f);
        this.leftAntler.func_78784_a(32, 16).func_228302_a_(0.0f, -16.0f, -8.0f, 0.0f, 16.0f, 16.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.leftAntler, 0.0f, 0.3926991f, 0.3926991f);
        (this.field_78144_f = new ModelRenderer((Model)this, 0, 0)).func_78793_a(2.0f, 12.0f, -4.5f);
        this.field_78144_f.func_78784_a(10, 0).func_228302_a_(-1.0f, 0.0f, -1.5f, 2.0f, 12.0f, 3.0f, 0.0f, 0.0f, 0.0f);
        (this.field_78147_e = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-2.0f, 12.0f, -4.5f);
        this.field_78147_e.func_228302_a_(-1.0f, 0.0f, -1.5f, 2.0f, 12.0f, 3.0f, 0.0f, 0.0f, 0.0f);
        (this.field_78146_d = new ModelRenderer((Model)this, 0, 0)).func_78793_a(2.0f, 12.0f, 9.5f);
        this.field_78146_d.func_78784_a(10, 15).func_228302_a_(-1.0f, 0.0f, -1.5f, 2.0f, 12.0f, 3.0f, 0.0f, 0.0f, 0.0f);
        (this.field_78150_a = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, -9.0f, 0.0f);
        this.field_78150_a.func_78784_a(24, 2).func_228302_a_(-2.0f, -4.0f, -4.0f, 4.0f, 6.0f, 6.0f, 0.0f, 0.0f, 0.0f);
        this.field_78150_a.func_78784_a(52, 0).func_228302_a_(-1.5f, -1.0f, -7.0f, 3.0f, 3.0f, 3.0f, 0.0f, 0.0f, 0.0f);
        (this.neck = new ModelRenderer((Model)this, 22, 14)).func_78793_a(0.0f, 8.0f, -5.0f);
        this.neck.func_228302_a_(-1.5f, -8.0f, -2.0f, 3.0f, 9.0f, 4.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.neck, 0.43633232f, 0.0f, 0.0f);
        this.setRotateAngle(this.field_78150_a, -0.43633232f, 0.0f, 0.0f);
        (this.field_78149_c = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-2.0f, 12.0f, 9.5f);
        this.field_78149_c.func_78784_a(0, 15).func_228302_a_(-1.0f, 0.0f, -1.5f, 2.0f, 12.0f, 3.0f, 0.0f, 0.0f, 0.0f);
        this.field_78150_a.func_78792_a(this.rightAntler);
        this.field_78150_a.func_78792_a(this.leftAntler);
        this.neck.func_78792_a(this.field_78150_a);
    }
    
    protected Iterable<ModelRenderer> func_225602_a_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.neck);
    }
    
    protected Iterable<ModelRenderer> func_225600_b_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.field_78148_b, (Object)this.field_78149_c, (Object)this.field_78146_d, (Object)this.field_78147_e, (Object)this.field_78144_f);
    }
    
    public void func_225598_a_(final MatrixStack stack, final IVertexBuilder builder, final int light, final int overlay, final float red, final float green, final float blue, final float scale) {
        if (this.field_217114_e) {
            stack.func_227860_a_();
            stack.func_227862_a_(0.75f, 0.75f, 0.75f);
            stack.func_227861_a_(0.0, 0.949999988079071, 0.15000000596046448);
            this.func_225602_a_().forEach(modelRenderer -> modelRenderer.func_228309_a_(stack, builder, light, overlay, red, green, blue, scale));
            stack.func_227865_b_();
            stack.func_227860_a_();
            stack.func_227862_a_(0.5f, 0.5f, 0.5f);
            stack.func_227861_a_(0.0, 1.5, 0.0);
            this.func_225600_b_().forEach(modelRenderer -> modelRenderer.func_228309_a_(stack, builder, light, overlay, red, green, blue, scale));
            stack.func_227865_b_();
        }
        else {
            this.func_225602_a_().forEach(renderer -> renderer.func_228309_a_(stack, builder, light, overlay, red, green, blue, scale));
            this.func_225600_b_().forEach(renderer -> renderer.func_228309_a_(stack, builder, light, overlay, red, green, blue, scale));
        }
    }
    
    public void setRotateAngle(final ModelRenderer modelRenderer, final float x, final float y, final float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}
