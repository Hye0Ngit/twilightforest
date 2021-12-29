// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import twilightforest.entity.KoboldEntity;
import net.minecraft.client.renderer.entity.model.BipedModel;

@OnlyIn(Dist.CLIENT)
public class KoboldModel extends BipedModel<KoboldEntity>
{
    public ModelRenderer mouth;
    public ModelRenderer rightEar;
    public ModelRenderer leftEar;
    boolean isJumping;
    
    public KoboldModel() {
        super(0.0f, 0.0f, 64, 32);
        (this.field_178723_h = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-4.5f, 13.0f, 0.0f);
        this.field_178723_h.func_78784_a(34, 12).func_228302_a_(-2.0f, -1.0f, -1.5f, 3.0f, 7.0f, 3.0f, 0.0f, 0.0f, 0.0f);
        (this.field_78116_c = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 12.0f, 0.0f);
        this.field_78116_c.func_228302_a_(-3.5f, -6.0f, -3.0f, 7.0f, 6.0f, 6.0f, 0.0f, 0.0f, 0.0f);
        this.field_78116_c.func_78784_a(20, 0).func_228302_a_(-1.5f, -3.0f, -6.0f, 3.0f, 2.0f, 3.0f, 0.0f, 0.0f, 0.0f);
        (this.field_78115_e = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 12.0f, 0.0f);
        this.field_78115_e.func_78784_a(12, 12).func_228302_a_(-3.5f, 0.0f, -2.0f, 7.0f, 7.0f, 4.0f, 0.0f, 0.0f, 0.0f);
        (this.field_178722_k = new ModelRenderer((Model)this, 0, 0)).func_78793_a(1.9f, 19.0f, 0.0f);
        this.field_178722_k.func_78784_a(0, 20).func_228302_a_(-1.5f, 0.0f, -1.5f, 3.0f, 5.0f, 3.0f, 0.0f, 0.0f, 0.0f);
        (this.mouth = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, -1.0f, -3.0f);
        this.mouth.func_78784_a(26, 5).func_228302_a_(-1.5f, 0.0f, -3.0f, 3.0f, 1.0f, 3.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.mouth, 0.21816616f, 0.0f, 0.0f);
        (this.rightEar = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-3.0f, -4.0f, 0.0f);
        this.rightEar.func_78784_a(32, 0).func_228302_a_(-2.0f, -4.0f, 0.0f, 4.0f, 4.0f, 1.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.rightEar, 0.0f, 0.0f, -1.3089969f);
        (this.field_178721_j = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-1.9f, 19.0f, 0.0f);
        this.field_178721_j.func_78784_a(0, 12).func_228302_a_(-1.5f, 0.0f, -1.5f, 3.0f, 5.0f, 3.0f, 0.0f, 0.0f, 0.0f);
        (this.field_178724_i = new ModelRenderer((Model)this, 0, 0)).func_78793_a(4.5f, 13.0f, 0.0f);
        this.field_178724_i.func_78784_a(34, 22).func_228302_a_(-1.0f, -1.0f, -1.5f, 3.0f, 7.0f, 3.0f, 0.0f, 0.0f, 0.0f);
        (this.leftEar = new ModelRenderer((Model)this, 0, 0)).func_78793_a(3.0f, -4.0f, 0.0f);
        this.leftEar.func_78784_a(42, 0).func_228302_a_(-2.0f, -4.0f, 0.0f, 4.0f, 4.0f, 1.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.leftEar, 0.0f, 0.0f, 1.3089969f);
        (this.field_178720_f = new ModelRenderer((Model)this, 0, 0)).func_228300_a_(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        this.field_78116_c.func_78792_a(this.mouth);
        this.field_78116_c.func_78792_a(this.rightEar);
        this.field_78116_c.func_78792_a(this.leftEar);
    }
    
    public void setLivingAnimations(final KoboldEntity entity, final float limbSwing, final float limbSwingAmount, final float partialTicks) {
        this.isJumping = (entity.func_213322_ci().func_82617_b() > 0.0);
    }
    
    public void setRotationAngles(final KoboldEntity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.field_78116_c.field_78796_g = netHeadYaw / 57.295776f;
        this.field_78116_c.field_78795_f = headPitch / 57.295776f;
        this.field_178723_h.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f + 3.1415927f) * 2.0f * limbSwingAmount * 0.5f;
        this.field_178724_i.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f) * 2.0f * limbSwingAmount * 0.5f;
        this.field_178723_h.field_78808_h = 0.0f;
        this.field_178724_i.field_78808_h = 0.0f;
        this.field_178723_h.field_78795_f = -0.47123894f;
        this.field_178724_i.field_78795_f = -0.47123894f;
        this.field_178721_j.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.field_178722_k.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.field_178721_j.field_78796_g = 0.0f;
        this.field_178722_k.field_78796_g = 0.0f;
        final ModelRenderer field_178723_h = this.field_178723_h;
        field_178723_h.field_78808_h += MathHelper.func_76134_b(ageInTicks * 0.19f) * 0.15f + 0.05f;
        final ModelRenderer field_178724_i = this.field_178724_i;
        field_178724_i.field_78808_h -= MathHelper.func_76134_b(ageInTicks * 0.19f) * 0.15f + 0.05f;
        final ModelRenderer field_178723_h2 = this.field_178723_h;
        field_178723_h2.field_78795_f += MathHelper.func_76126_a(ageInTicks * 0.267f) * 0.25f;
        final ModelRenderer field_178724_i2 = this.field_178724_i;
        field_178724_i2.field_78795_f -= MathHelper.func_76126_a(ageInTicks * 0.267f) * 0.25f;
        if (this.isJumping) {
            this.mouth.field_78795_f = 0.6f;
        }
        else {
            this.mouth.field_78795_f = 0.20944f;
        }
    }
    
    public void setRotateAngle(final ModelRenderer modelRenderer, final float x, final float y, final float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}
