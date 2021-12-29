// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import twilightforest.entity.boss.AlphaYetiEntity;
import net.minecraft.client.renderer.entity.model.BipedModel;

public class AlphaYetiModel extends BipedModel<AlphaYetiEntity>
{
    public ModelRenderer mouth;
    public ModelRenderer leftEye;
    public ModelRenderer rightEye;
    
    public AlphaYetiModel() {
        super(0.0f, 0.0f, 256, 128);
        (this.field_78116_c = new ModelRenderer((Model)this, 0, 0)).func_228300_a_(-4.0f, -8.0f, -4.0f, 0.0f, 0.0f, 0.0f);
        (this.field_178720_f = new ModelRenderer((Model)this, 32, 0)).func_228300_a_(-4.0f, -8.0f, -4.0f, 0.0f, 0.0f, 0.0f);
        (this.field_78115_e = new ModelRenderer((Model)this, 80, 0)).func_228300_a_(-24.0f, -60.0f, -18.0f, 48.0f, 72.0f, 36.0f);
        this.field_78115_e.func_78793_a(0.0f, -6.0f, 0.0f);
        (this.mouth = new ModelRenderer((Model)this, 121, 50)).func_228300_a_(-17.0f, -7.0f, -1.5f, 34.0f, 29.0f, 2.0f);
        this.mouth.func_78793_a(0.0f, -37.0f, -18.0f);
        this.field_78115_e.func_78792_a(this.mouth);
        (this.rightEye = new ModelRenderer((Model)this, 64, 0)).func_228300_a_(-6.0f, -6.0f, -1.5f, 12.0f, 12.0f, 2.0f);
        this.rightEye.func_78793_a(-14.0f, -50.0f, -18.0f);
        this.field_78115_e.func_78792_a(this.rightEye);
        (this.leftEye = new ModelRenderer((Model)this, 64, 0)).func_228300_a_(-6.0f, -6.0f, -1.5f, 12.0f, 12.0f, 2.0f);
        this.leftEye.func_78793_a(14.0f, -50.0f, -18.0f);
        this.field_78115_e.func_78792_a(this.leftEye);
        (this.field_178723_h = new ModelRenderer((Model)this, 0, 0)).func_228300_a_(-15.0f, -6.0f, -8.0f, 16.0f, 48.0f, 16.0f);
        this.field_178723_h.func_78793_a(-25.0f, -26.0f, 0.0f);
        this.field_78115_e.func_78792_a(this.field_178723_h);
        this.field_178724_i = new ModelRenderer((Model)this, 0, 0);
        this.field_178724_i.field_78809_i = true;
        this.field_178724_i.func_228300_a_(-1.0f, -6.0f, -8.0f, 16.0f, 48.0f, 16.0f);
        this.field_178724_i.func_78793_a(25.0f, -26.0f, 0.0f);
        this.field_78115_e.func_78792_a(this.field_178724_i);
        (this.field_178721_j = new ModelRenderer((Model)this, 0, 66)).func_228300_a_(-10.0f, 0.0f, -10.0f, 20.0f, 20.0f, 20.0f);
        this.field_178721_j.func_78793_a(-13.5f, 4.0f, 0.0f);
        this.field_178722_k = new ModelRenderer((Model)this, 0, 66);
        this.field_178722_k.field_78809_i = true;
        this.field_178722_k.func_228300_a_(-10.0f, 0.0f, -10.0f, 20.0f, 20.0f, 20.0f);
        this.field_178722_k.func_78793_a(13.5f, 4.0f, 0.0f);
        this.addPairHorns(-58.0f, 35.0f);
        this.addPairHorns(-46.0f, 15.0f);
        this.addPairHorns(-36.0f, -5.0f);
    }
    
    private void addPairHorns(final float height, final float zangle) {
        final ModelRenderer horn1a = new ModelRenderer((Model)this, 0, 108);
        horn1a.func_228300_a_(-9.0f, -5.0f, -5.0f, 10.0f, 10.0f, 10.0f);
        horn1a.func_78793_a(-24.0f, height, -8.0f);
        horn1a.field_78796_g = -0.5235988f;
        horn1a.field_78808_h = zangle / 57.295776f;
        this.field_78115_e.func_78792_a(horn1a);
        final ModelRenderer horn1b = new ModelRenderer((Model)this, 40, 108);
        horn1b.func_228300_a_(-14.0f, -4.0f, -4.0f, 18.0f, 8.0f, 8.0f);
        horn1b.func_78793_a(-8.0f, 0.0f, 0.0f);
        horn1b.field_78796_g = -0.34906587f;
        horn1b.field_78808_h = zangle / 57.295776f;
        horn1a.func_78792_a(horn1b);
        final ModelRenderer horn2a = new ModelRenderer((Model)this, 0, 108);
        horn2a.func_228300_a_(-1.0f, -5.0f, -5.0f, 10.0f, 10.0f, 10.0f);
        horn2a.func_78793_a(24.0f, height, 0.0f);
        horn2a.field_78796_g = 0.5235988f;
        horn2a.field_78808_h = -zangle / 57.295776f;
        this.field_78115_e.func_78792_a(horn2a);
        final ModelRenderer horn2b = new ModelRenderer((Model)this, 40, 108);
        horn2b.func_228300_a_(-2.0f, -4.0f, -4.0f, 18.0f, 8.0f, 8.0f);
        horn2b.func_78793_a(8.0f, 0.0f, 0.0f);
        horn2b.field_78796_g = 0.34906587f;
        horn2b.field_78808_h = -zangle / 57.295776f;
        horn2a.func_78792_a(horn2b);
    }
    
    protected Iterable<ModelRenderer> func_225600_b_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.field_78115_e, (Object)this.field_178721_j, (Object)this.field_178722_k);
    }
    
    public void setRotationAngles(final AlphaYetiEntity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.field_78116_c.field_78796_g = netHeadYaw / 57.295776f;
        this.field_78116_c.field_78795_f = headPitch / 57.295776f;
        this.field_78115_e.field_78795_f = headPitch / 57.295776f;
        this.field_178721_j.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.field_178722_k.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.field_178721_j.field_78796_g = 0.0f;
        this.field_178722_k.field_78796_g = 0.0f;
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
        this.field_78115_e.field_78797_d = -6.0f;
        this.field_178721_j.field_78797_d = 4.0f;
        this.field_178722_k.field_78797_d = 4.0f;
        if (entity.isTired()) {
            this.field_178723_h.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f + 3.1415927f) * 2.0f * limbSwingAmount * 0.5f;
            this.field_178724_i.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f) * 2.0f * limbSwingAmount * 0.5f;
            this.field_178723_h.field_78808_h = 0.0f;
            this.field_178724_i.field_78808_h = 0.0f;
            final ModelRenderer field_178723_h4 = this.field_178723_h;
            field_178723_h4.field_78795_f -= 0.62831855f;
            final ModelRenderer field_178724_i4 = this.field_178724_i;
            field_178724_i4.field_78795_f -= 0.62831855f;
            this.field_178721_j.field_78795_f = -1.2566371f;
            this.field_178722_k.field_78795_f = -1.2566371f;
            this.field_178721_j.field_78796_g = 0.31415927f;
            this.field_178722_k.field_78796_g = -0.31415927f;
            this.field_78115_e.field_78797_d = 6.0f;
            this.field_178721_j.field_78797_d = 12.0f;
            this.field_178722_k.field_78797_d = 12.0f;
        }
        if (entity.isRampaging()) {
            this.field_178723_h.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.66f + 3.1415927f) * 2.0f * limbSwingAmount * 0.5f;
            this.field_178724_i.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.66f) * 2.0f * limbSwingAmount * 0.5f;
            final ModelRenderer field_178723_h5 = this.field_178723_h;
            field_178723_h5.field_78796_g += MathHelper.func_76134_b(limbSwing * 0.25f) * 0.5f + 0.5f;
            final ModelRenderer field_178724_i5 = this.field_178724_i;
            field_178724_i5.field_78796_g -= MathHelper.func_76134_b(limbSwing * 0.25f) * 0.5f + 0.5f;
            final ModelRenderer field_178723_h6 = this.field_178723_h;
            field_178723_h6.field_78795_f += (float)3.9269908169872414;
            final ModelRenderer field_178724_i6 = this.field_178724_i;
            field_178724_i6.field_78795_f += (float)3.9269908169872414;
            this.field_178723_h.field_78808_h = 0.0f;
            this.field_178724_i.field_78808_h = 0.0f;
        }
        if (entity.func_184207_aI()) {
            final ModelRenderer field_178723_h7 = this.field_178723_h;
            field_178723_h7.field_78795_f += (float)3.141592653589793;
            final ModelRenderer field_178724_i7 = this.field_178724_i;
            field_178724_i7.field_78795_f += (float)3.141592653589793;
        }
    }
}
