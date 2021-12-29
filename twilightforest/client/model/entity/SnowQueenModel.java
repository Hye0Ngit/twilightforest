// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import twilightforest.entity.boss.SnowQueenEntity;
import net.minecraft.client.renderer.entity.model.BipedModel;

@OnlyIn(Dist.CLIENT)
public class SnowQueenModel extends BipedModel<SnowQueenEntity>
{
    public ModelRenderer crownFront;
    public ModelRenderer crownBack;
    public ModelRenderer crownRight;
    public ModelRenderer crownLeft;
    
    public SnowQueenModel() {
        super(0.0f, 0.0f, 64, 64);
        (this.crownRight = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-4.0f, -6.0f, 0.0f);
        this.crownRight.func_78784_a(24, 4).func_228302_a_(-5.0f, -4.0f, 0.0f, 10.0f, 4.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.crownRight, 0.3926991f, 1.5707964f, 0.0f);
        (this.crownBack = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, -6.0f, 4.0f);
        this.crownBack.func_78784_a(44, 0).func_228302_a_(-5.0f, -4.0f, 0.0f, 10.0f, 4.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.crownBack, -0.3926991f, 0.0f, 0.0f);
        (this.field_78115_e = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.field_78115_e.func_78784_a(0, 16).func_228302_a_(-4.0f, 0.0f, -2.0f, 8.0f, 12.0f, 4.0f, 0.0f, 0.0f, 0.0f);
        this.field_78115_e.func_78784_a(32, 45).func_228302_a_(-4.5f, 10.0f, -2.5f, 9.0f, 14.0f, 5.0f, 0.0f, 0.0f, 0.0f);
        (this.field_78116_c = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.field_78116_c.func_228302_a_(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, 0.0f, 0.0f, 0.0f);
        (this.field_178724_i = new ModelRenderer((Model)this, 0, 0)).func_78793_a(5.0f, 2.0f, 0.0f);
        this.field_178724_i.func_78784_a(14, 32).func_228302_a_(-1.0f, -2.0f, -2.0f, 3.0f, 12.0f, 4.0f, 0.0f, 0.0f, 0.0f);
        (this.field_178722_k = new ModelRenderer((Model)this, 0, 0)).func_78793_a(1.9f, 12.0f, 0.0f);
        this.field_178722_k.func_78784_a(16, 48).func_228302_a_(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, 0.0f, 0.0f, 0.0f);
        (this.crownLeft = new ModelRenderer((Model)this, 0, 0)).func_78793_a(4.0f, -6.0f, 0.0f);
        this.crownLeft.func_78784_a(44, 4).func_228302_a_(-5.0f, -4.0f, 0.0f, 10.0f, 4.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.crownLeft, -0.3926991f, 1.5707964f, 0.0f);
        (this.field_178721_j = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-1.9f, 12.0f, 0.0f);
        this.field_178721_j.func_78784_a(0, 48).func_228302_a_(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, 0.0f, 0.0f, 0.0f);
        (this.field_178723_h = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-5.0f, 2.0f, 0.0f);
        this.field_178723_h.func_78784_a(0, 32).func_228302_a_(-2.0f, -2.0f, -2.0f, 3.0f, 12.0f, 4.0f, 0.0f, 0.0f, 0.0f);
        (this.crownFront = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, -6.0f, -4.0f);
        this.crownFront.func_78784_a(24, 0).func_228302_a_(-5.0f, -4.0f, 0.0f, 10.0f, 4.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.crownFront, 0.3926991f, 0.0f, 0.0f);
        (this.field_178720_f = new ModelRenderer((Model)this, 0, 0)).func_228300_a_(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        this.field_178720_f.func_78792_a(this.crownRight);
        this.field_178720_f.func_78792_a(this.crownBack);
        this.field_178720_f.func_78792_a(this.crownLeft);
        this.field_178720_f.func_78792_a(this.crownFront);
    }
    
    public void setRotationAngles(final SnowQueenEntity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        super.func_225597_a_((LivingEntity)entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        if (entity.getCurrentPhase() == SnowQueenEntity.Phase.BEAM) {
            if (entity.isBreathing()) {
                final float f6 = MathHelper.func_76126_a(this.field_217112_c * 3.1415927f);
                final float f7 = MathHelper.func_76126_a((1.0f - (1.0f - this.field_217112_c) * (1.0f - this.field_217112_c)) * 3.1415927f);
                this.field_178723_h.field_78808_h = 0.0f;
                this.field_178724_i.field_78808_h = 0.0f;
                this.field_178723_h.field_78796_g = -(0.1f - f6 * 0.6f);
                this.field_178724_i.field_78796_g = 0.1f - f6 * 0.6f;
                this.field_178723_h.field_78795_f = -1.5707964f;
                this.field_178724_i.field_78795_f = -1.5707964f;
                final ModelRenderer field_178723_h = this.field_178723_h;
                field_178723_h.field_78795_f -= f6 * 1.2f - f7 * 0.4f;
                final ModelRenderer field_178724_i = this.field_178724_i;
                field_178724_i.field_78795_f -= f6 * 1.2f - f7 * 0.4f;
                final ModelRenderer field_178723_h2 = this.field_178723_h;
                field_178723_h2.field_78808_h += MathHelper.func_76134_b(ageInTicks * 0.09f) * 0.05f + 0.05f;
                final ModelRenderer field_178724_i2 = this.field_178724_i;
                field_178724_i2.field_78808_h -= MathHelper.func_76134_b(ageInTicks * 0.09f) * 0.05f + 0.05f;
                final ModelRenderer field_178723_h3 = this.field_178723_h;
                field_178723_h3.field_78795_f += MathHelper.func_76126_a(ageInTicks * 0.067f) * 0.05f;
                final ModelRenderer field_178724_i3 = this.field_178724_i;
                field_178724_i3.field_78795_f -= MathHelper.func_76126_a(ageInTicks * 0.067f) * 0.05f;
            }
            else {
                final ModelRenderer field_178723_h4 = this.field_178723_h;
                field_178723_h4.field_78795_f += (float)3.141592653589793;
                final ModelRenderer field_178724_i4 = this.field_178724_i;
                field_178724_i4.field_78795_f += (float)3.141592653589793;
            }
        }
    }
    
    public void setRotateAngle(final ModelRenderer modelRenderer, final float x, final float y, final float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}
