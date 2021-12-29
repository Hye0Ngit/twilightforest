// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.LivingEntity;
import com.google.common.collect.Iterables;
import java.util.Arrays;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import twilightforest.entity.boss.LichEntity;
import net.minecraft.client.renderer.entity.model.BipedModel;

public class LichModel extends BipedModel<LichEntity>
{
    private final ModelRenderer collar;
    private final ModelRenderer cloak;
    private boolean shadowClone;
    
    public LichModel() {
        super(0.0f, 0.0f, 64, 64);
        (this.field_78115_e = new ModelRenderer((Model)this, 8, 16)).func_228300_a_(-4.0f, 0.0f, -2.0f, 8.0f, 24.0f, 4.0f);
        this.field_78115_e.func_78793_a(0.0f, -4.0f, 0.0f);
        this.field_78115_e.func_78787_b(64, 64);
        (this.field_178723_h = new ModelRenderer((Model)this, 0, 16)).func_228300_a_(-2.0f, -2.0f, -2.0f, 2.0f, 12.0f, 2.0f);
        this.field_178723_h.func_78787_b(64, 64);
        this.field_178723_h.func_78793_a(-5.0f, -2.0f, 0.0f);
        this.field_178724_i = new ModelRenderer((Model)this, 0, 16);
        this.field_178724_i.field_78809_i = true;
        this.field_178724_i.func_228300_a_(-1.0f, -2.0f, -2.0f, 2.0f, 12.0f, 2.0f);
        this.field_178724_i.func_78793_a(5.0f, 2.0f, 0.0f);
        this.field_178724_i.func_78787_b(64, 64);
        (this.field_178720_f = new ModelRenderer((Model)this, 32, 0)).func_228301_a_(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, 0.5f);
        this.field_178720_f.func_78793_a(0.0f, -4.0f, 0.0f);
        this.field_178720_f.func_78787_b(64, 64);
        (this.field_78116_c = new ModelRenderer((Model)this, 0, 0)).func_228300_a_(-4.0f, -4.0f, -4.0f, 8.0f, 8.0f, 8.0f);
        this.field_78116_c.func_78793_a(0.0f, -4.0f, 0.0f);
        this.field_78116_c.func_78787_b(64, 64);
        (this.field_178721_j = new ModelRenderer((Model)this, 0, 16)).func_228300_a_(-1.0f, 2.0f, -1.0f, 2.0f, 12.0f, 2.0f);
        this.field_178721_j.func_78793_a(-2.0f, 9.5f, 0.0f);
        this.field_178721_j.func_78787_b(64, 64);
        (this.field_178722_k = new ModelRenderer((Model)this, 0, 16)).func_228300_a_(-1.0f, 2.0f, -1.0f, 2.0f, 12.0f, 2.0f);
        this.field_178722_k.func_78793_a(2.0f, 9.5f, 0.0f);
        this.field_178722_k.func_78787_b(64, 64);
        this.field_178722_k.field_78809_i = true;
        (this.collar = new ModelRenderer((Model)this, 32, 16)).func_228300_a_(-6.0f, -2.0f, -4.0f, 12.0f, 12.0f, 1.0f);
        this.collar.func_78793_a(0.0f, -3.0f, -1.0f);
        this.collar.func_78787_b(64, 64);
        this.setRotation(this.collar, 2.164208f, 0.0f, 0.0f);
        (this.cloak = new ModelRenderer((Model)this, 0, 44)).func_228300_a_(-6.0f, 2.0f, 0.0f, 12.0f, 19.0f, 1.0f);
        this.cloak.func_78793_a(0.0f, -4.0f, 2.5f);
        this.cloak.func_78787_b(64, 64);
        this.setRotation(this.cloak, 0.0f, 0.0f, 0.0f);
    }
    
    public void func_225598_a_(final MatrixStack stack, final IVertexBuilder builder, final int light, final int overlay, final float red, final float green, final float blue, final float alpha) {
        if (!this.shadowClone) {
            super.func_225598_a_(stack, builder, light, overlay, red, green, blue, alpha);
        }
        else {
            final float shadow = 0.33f;
            super.func_225598_a_(stack, builder, light, overlay, red * shadow, green * shadow, blue * shadow, 0.8f);
        }
    }
    
    protected Iterable<ModelRenderer> func_225600_b_() {
        if (this.shadowClone) {
            return super.func_225600_b_();
        }
        return Iterables.concat((Iterable)Arrays.asList(this.cloak, this.collar), super.func_225600_b_());
    }
    
    public void setRotationAngles(final LichEntity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.shadowClone = entity.isShadowClone();
        super.func_225597_a_((LivingEntity)entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        final float ogSin = MathHelper.func_76126_a(this.field_217112_c * 3.141593f);
        final float otherSin = MathHelper.func_76126_a((1.0f - (1.0f - this.field_217112_c) * (1.0f - this.field_217112_c)) * 3.141593f);
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
