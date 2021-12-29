// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;
import twilightforest.entity.boss.EntityTFLich;
import javax.annotation.Nonnull;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBiped;

public class ModelTFLich extends ModelBiped
{
    private final ModelRenderer collar;
    private final ModelRenderer cloak;
    
    public ModelTFLich() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        (this.field_78115_e = new ModelRenderer((ModelBase)this, 8, 16)).func_78789_a(-4.0f, 0.0f, -2.0f, 8, 24, 4);
        this.field_78115_e.func_78793_a(0.0f, -4.0f, 0.0f);
        this.field_78115_e.func_78787_b(64, 64);
        (this.field_178723_h = new ModelRenderer((ModelBase)this, 0, 16)).func_78789_a(-2.0f, -2.0f, -1.0f, 2, 12, 2);
        this.field_178723_h.func_78787_b(64, 64);
        this.field_178723_h.func_78793_a(-5.0f, -2.0f, 0.0f);
        this.field_178724_i = new ModelRenderer((ModelBase)this, 0, 16);
        this.field_178724_i.field_78809_i = true;
        this.field_178724_i.func_78789_a(-2.0f, -2.0f, -1.0f, 2, 12, 2);
        this.field_178724_i.func_78793_a(5.0f, -2.0f, 0.0f);
        this.field_178724_i.func_78787_b(64, 64);
        (this.field_178720_f = new ModelRenderer((ModelBase)this, 32, 0)).func_78790_a(-4.0f, -12.0f, -4.0f, 8, 8, 8, 0.5f);
        this.field_178720_f.func_78793_a(0.0f, -4.0f, 0.0f);
        this.field_178720_f.func_78787_b(64, 64);
        (this.field_78116_c = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-4.0f, -8.0f, -4.0f, 8, 8, 8);
        this.field_78116_c.func_78793_a(0.0f, -4.0f, 0.0f);
        this.field_78116_c.func_78787_b(64, 64);
        (this.field_178721_j = new ModelRenderer((ModelBase)this, 0, 16)).func_78789_a(-1.0f, 0.0f, -1.0f, 2, 12, 2);
        this.field_178721_j.func_78793_a(-2.0f, 9.5f, 0.0f);
        this.field_178721_j.func_78787_b(64, 64);
        (this.field_178722_k = new ModelRenderer((ModelBase)this, 0, 16)).func_78789_a(-1.0f, 0.0f, -1.0f, 2, 12, 2);
        this.field_178722_k.func_78793_a(2.0f, 9.5f, 0.0f);
        this.field_178722_k.func_78787_b(64, 64);
        this.field_178722_k.field_78809_i = true;
        (this.collar = new ModelRenderer((ModelBase)this, 32, 16)).func_78789_a(-6.0f, 0.0f, 0.0f, 12, 12, 1);
        this.collar.func_78793_a(0.0f, -3.0f, -1.0f);
        this.collar.func_78787_b(64, 64);
        this.setRotation(this.collar, 2.164208f, 0.0f, 0.0f);
        (this.cloak = new ModelRenderer((ModelBase)this, 0, 44)).func_78789_a(-6.0f, 0.0f, 0.0f, 12, 19, 1);
        this.cloak.func_78793_a(0.0f, -4.0f, 2.5f);
        this.cloak.func_78787_b(64, 64);
        this.setRotation(this.cloak, 0.0f, 0.0f, 0.0f);
    }
    
    public void func_78088_a(@Nonnull final Entity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scale) {
        if (!((EntityTFLich)entity).isShadowClone()) {
            super.func_78088_a(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
            this.collar.func_78785_a(scale * 1.125f);
            this.cloak.func_78785_a(scale * 1.125f);
        }
        else {
            GlStateManager.func_179147_l();
            GlStateManager.func_179112_b(770, 771);
            final float shadow = 0.33f;
            GlStateManager.func_179131_c(shadow, shadow, shadow, 0.8f);
            super.func_78088_a(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
            GlStateManager.func_179084_k();
        }
    }
    
    public void func_78087_a(final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scaleFactor, final Entity entity) {
        super.func_78087_a(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
        final float ogSin = MathHelper.func_76126_a(this.field_78095_p * 3.141593f);
        final float otherSin = MathHelper.func_76126_a((1.0f - (1.0f - this.field_78095_p) * (1.0f - this.field_78095_p)) * 3.141593f);
        this.field_178723_h.field_78808_h = 0.0f;
        this.field_178724_i.field_78808_h = 0.5f;
        this.field_178723_h.field_78796_g = -(0.1f - ogSin * 0.6f);
        this.field_178724_i.field_78796_g = 0.1f - ogSin * 0.6f;
        this.field_178723_h.field_78795_f = -1.570796f;
        this.field_178724_i.field_78795_f = -3.141593f;
        final ModelRenderer field_178723_h = this.field_178723_h;
        field_178723_h.field_78795_f -= ogSin * 1.2f - otherSin * 0.4f;
        final ModelRenderer field_178724_i = this.field_178724_i;
        field_178724_i.field_78795_f -= ogSin * 1.2f - otherSin * 0.4f;
        final ModelRenderer field_178723_h2 = this.field_178723_h;
        field_178723_h2.field_78808_h += MathHelper.func_76134_b(ageInTicks * 0.26f) * 0.15f + 0.05f;
        final ModelRenderer field_178724_i2 = this.field_178724_i;
        field_178724_i2.field_78808_h -= MathHelper.func_76134_b(ageInTicks * 0.26f) * 0.15f + 0.05f;
        final ModelRenderer field_178723_h3 = this.field_178723_h;
        field_178723_h3.field_78795_f += MathHelper.func_76126_a(ageInTicks * 0.167f) * 0.15f;
        final ModelRenderer field_178724_i3 = this.field_178724_i;
        field_178724_i3.field_78795_f -= MathHelper.func_76126_a(ageInTicks * 0.167f) * 0.15f;
        this.field_78116_c.field_78797_d = -4.0f;
        this.field_178720_f.field_78797_d = -4.0f;
        this.field_178721_j.field_78797_d = 9.5f;
        this.field_178722_k.field_78797_d = 9.5f;
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.field_78795_f = x;
        model.field_78796_g = y;
        model.field_78808_h = z;
    }
}
