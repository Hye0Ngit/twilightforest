// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity.legacy;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import twilightforest.entity.boss.SnowQueenEntity;
import net.minecraft.client.renderer.entity.model.BipedModel;

public class SnowQueenLegacyModel extends BipedModel<SnowQueenEntity>
{
    public SnowQueenLegacyModel() {
        super(0.0f);
        final float par1 = 0.0f;
        final float par2 = 0.0f;
        (this.field_178720_f = new ModelRenderer((Model)this, 0, 0)).func_78792_a(this.makeFrontCrown(-1.0f, -4.0f, 10.0f));
        this.field_178720_f.func_78792_a(this.makeFrontCrown(0.0f, 4.0f, -10.0f));
        this.field_178720_f.func_78792_a(this.makeSideCrown(-1.0f, -4.0f, 10.0f));
        this.field_178720_f.func_78792_a(this.makeSideCrown(0.0f, 4.0f, -10.0f));
        (this.field_78115_e = new ModelRenderer((Model)this, 32, 0)).func_228301_a_(-4.0f, 0.0f, -2.0f, 8.0f, 23.0f, 4.0f, par1);
        this.field_78115_e.func_78793_a(0.0f, 0.0f + par2, 0.0f);
        (this.field_178723_h = new ModelRenderer((Model)this, 16, 16)).func_228301_a_(-2.0f, -2.0f, -1.5f, 3.0f, 12.0f, 3.0f, par1);
        this.field_178723_h.func_78793_a(-5.0f, 2.0f + par2, 0.0f);
        this.field_178724_i = new ModelRenderer((Model)this, 16, 16);
        this.field_178724_i.field_78809_i = true;
        this.field_178724_i.func_228301_a_(-1.0f, -2.0f, -1.3f, 3.0f, 12.0f, 3.0f, par1);
        this.field_178724_i.func_78793_a(5.0f, 2.0f + par2, 0.0f);
        (this.field_178721_j = new ModelRenderer((Model)this, 0, 16)).func_228301_a_(-1.5f, 0.0f, -1.5f, 3.0f, 12.0f, 3.0f, par1);
        this.field_178721_j.func_78793_a(-1.9f, 12.0f + par2, 0.0f);
        this.field_178722_k = new ModelRenderer((Model)this, 0, 16);
        this.field_178722_k.field_78809_i = true;
        this.field_178722_k.func_228301_a_(-1.5f, 0.0f, -1.5f, 3.0f, 12.0f, 3.0f, par1);
        this.field_178722_k.func_78793_a(1.9f, 12.0f + par2, 0.0f);
    }
    
    private ModelRenderer makeSideCrown(final float spikeDepth, final float crownX, final float angle) {
        final ModelRenderer crownSide = new ModelRenderer((Model)this, 28, 28);
        crownSide.func_228300_a_(-3.5f, -0.5f, -0.5f, 7.0f, 1.0f, 1.0f);
        crownSide.func_78793_a(crownX, -6.0f, 0.0f);
        crownSide.field_78796_g = 1.570795f;
        final ModelRenderer spike4 = new ModelRenderer((Model)this, 48, 27);
        spike4.func_228300_a_(-0.5f, -3.5f, spikeDepth, 1.0f, 4.0f, 1.0f);
        spike4.field_78795_f = angle * 1.5f / 180.0f * 3.14159f;
        final ModelRenderer spike3l = new ModelRenderer((Model)this, 52, 28);
        spike3l.func_228300_a_(-0.5f, -2.5f, spikeDepth, 1.0f, 3.0f, 1.0f);
        spike3l.func_78793_a(-2.5f, 0.0f, 0.0f);
        spike3l.field_78795_f = angle / 180.0f * 3.14159f;
        spike3l.field_78808_h = -0.17453279f;
        final ModelRenderer spike3r = new ModelRenderer((Model)this, 52, 28);
        spike3r.func_228300_a_(-0.5f, -2.5f, spikeDepth, 1.0f, 3.0f, 1.0f);
        spike3r.func_78793_a(2.5f, 0.0f, 0.0f);
        spike3r.field_78795_f = angle / 180.0f * 3.14159f;
        spike3r.field_78808_h = 0.17453279f;
        crownSide.func_78792_a(spike4);
        crownSide.func_78792_a(spike3l);
        crownSide.func_78792_a(spike3r);
        return crownSide;
    }
    
    private ModelRenderer makeFrontCrown(final float spikeDepth, final float crownZ, final float angle) {
        final ModelRenderer crownFront = new ModelRenderer((Model)this, 28, 30);
        crownFront.func_228300_a_(-4.5f, -0.5f, -0.5f, 9.0f, 1.0f, 1.0f);
        crownFront.func_78793_a(0.0f, -6.0f, crownZ);
        final ModelRenderer spike4 = new ModelRenderer((Model)this, 48, 27);
        spike4.func_228300_a_(-0.5f, -3.5f, spikeDepth, 1.0f, 4.0f, 1.0f);
        spike4.field_78795_f = angle * 1.5f / 180.0f * 3.14159f;
        final ModelRenderer spike3l = new ModelRenderer((Model)this, 52, 28);
        spike3l.func_228300_a_(-0.5f, -2.5f, spikeDepth, 1.0f, 3.0f, 1.0f);
        spike3l.func_78793_a(-2.5f, 0.0f, 0.0f);
        spike3l.field_78795_f = angle / 180.0f * 3.14159f;
        spike3l.field_78808_h = -0.17453279f;
        final ModelRenderer spike3r = new ModelRenderer((Model)this, 52, 28);
        spike3r.func_228300_a_(-0.5f, -2.5f, spikeDepth, 1.0f, 3.0f, 1.0f);
        spike3r.func_78793_a(2.5f, 0.0f, 0.0f);
        spike3r.field_78795_f = angle / 180.0f * 3.14159f;
        spike3r.field_78808_h = 0.17453279f;
        crownFront.func_78792_a(spike4);
        crownFront.func_78792_a(spike3l);
        crownFront.func_78792_a(spike3r);
        return crownFront;
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
}
