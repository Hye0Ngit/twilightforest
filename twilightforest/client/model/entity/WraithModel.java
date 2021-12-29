// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.LivingEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.Model;
import java.util.function.Function;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.ModelRenderer;
import twilightforest.entity.WraithEntity;
import net.minecraft.client.renderer.entity.model.BipedModel;

public class WraithModel extends BipedModel<WraithEntity>
{
    public ModelRenderer dress;
    
    public WraithModel() {
        super((Function)RenderType::func_228644_e_, 0.0f, 0.0f, 64, 32);
        final float f = 0.0f;
        (this.dress = new ModelRenderer((Model)this, 40, 16)).func_228301_a_(-4.0f, 12.0f, -2.0f, 8.0f, 12.0f, 4.0f, f);
        this.dress.func_78793_a(0.0f, 0.0f, 0.0f);
    }
    
    protected Iterable<ModelRenderer> func_225602_a_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.field_78116_c, (Object)this.field_178720_f);
    }
    
    protected Iterable<ModelRenderer> func_225600_b_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.field_78115_e, (Object)this.field_178723_h, (Object)this.field_178724_i, (Object)this.dress);
    }
    
    public void setRotationAngles(final WraithEntity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        super.func_225597_a_((LivingEntity)entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        final float var8 = MathHelper.func_76126_a(this.field_217112_c * 3.1415927f);
        final float var9 = MathHelper.func_76126_a((1.0f - (1.0f - this.field_217112_c) * (1.0f - this.field_217112_c)) * 3.1415927f);
        this.field_178723_h.field_78808_h = 0.0f;
        this.field_178724_i.field_78808_h = 0.0f;
        this.field_178723_h.field_78796_g = -(0.1f - var8 * 0.6f);
        this.field_178724_i.field_78796_g = 0.1f - var8 * 0.6f;
        this.field_178723_h.field_78795_f = -1.5707964f;
        this.field_178724_i.field_78795_f = -1.5707964f;
        final ModelRenderer field_178723_h = this.field_178723_h;
        field_178723_h.field_78795_f -= var8 * 1.2f - var9 * 0.4f;
        final ModelRenderer field_178724_i = this.field_178724_i;
        field_178724_i.field_78795_f -= var8 * 1.2f - var9 * 0.4f;
        final ModelRenderer field_178723_h2 = this.field_178723_h;
        field_178723_h2.field_78808_h += MathHelper.func_76134_b(ageInTicks * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer field_178724_i2 = this.field_178724_i;
        field_178724_i2.field_78808_h -= MathHelper.func_76134_b(ageInTicks * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer field_178723_h3 = this.field_178723_h;
        field_178723_h3.field_78795_f += MathHelper.func_76126_a(ageInTicks * 0.067f) * 0.05f;
        final ModelRenderer field_178724_i3 = this.field_178724_i;
        field_178724_i3.field_78795_f -= MathHelper.func_76126_a(ageInTicks * 0.067f) * 0.05f;
    }
}
