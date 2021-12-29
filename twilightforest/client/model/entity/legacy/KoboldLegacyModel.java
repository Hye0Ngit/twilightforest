// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity.legacy;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import twilightforest.entity.KoboldEntity;
import net.minecraft.client.renderer.entity.model.BipedModel;

public class KoboldLegacyModel extends BipedModel<KoboldEntity>
{
    ModelRenderer rightear;
    ModelRenderer leftear;
    ModelRenderer snout;
    ModelRenderer jaw;
    boolean isJumping;
    
    public KoboldLegacyModel() {
        super(0.0f);
        this.isJumping = false;
        (this.field_78116_c = new ModelRenderer((Model)this, 0, 0)).func_228300_a_(-3.5f, -7.0f, -3.0f, 7.0f, 6.0f, 6.0f);
        this.field_78116_c.func_78793_a(0.0f, 13.0f, 0.0f);
        (this.field_78115_e = new ModelRenderer((Model)this, 12, 19)).func_228300_a_(0.0f, 0.0f, 0.0f, 7.0f, 7.0f, 4.0f);
        this.field_78115_e.func_78793_a(-3.5f, 12.0f, -2.0f);
        (this.field_178723_h = new ModelRenderer((Model)this, 36, 17)).func_228300_a_(-3.0f, -1.0f, -1.5f, 3.0f, 7.0f, 3.0f);
        this.field_178723_h.func_78793_a(-3.5f, 12.0f, 0.0f);
        this.field_178724_i.field_78809_i = true;
        (this.field_178724_i = new ModelRenderer((Model)this, 36, 17)).func_228300_a_(0.0f, -1.0f, -1.5f, 3.0f, 7.0f, 3.0f);
        this.field_178724_i.func_78793_a(3.5f, 12.0f, 0.0f);
        this.field_178724_i.field_78809_i = false;
        (this.field_178721_j = new ModelRenderer((Model)this, 0, 20)).func_228300_a_(-1.5f, 0.0f, -1.5f, 3.0f, 5.0f, 3.0f);
        this.field_178721_j.func_78793_a(-2.0f, 19.0f, 0.0f);
        (this.field_178722_k = new ModelRenderer((Model)this, 0, 20)).func_228300_a_(-1.5f, 0.0f, -1.5f, 3.0f, 5.0f, 3.0f);
        this.field_178722_k.func_78793_a(2.0f, 19.0f, 0.0f);
        (this.rightear = new ModelRenderer((Model)this, 48, 20)).func_228300_a_(0.0f, -4.0f, 0.0f, 4.0f, 4.0f, 1.0f);
        this.rightear.func_78793_a(3.5f, -3.0f, -1.0f);
        this.rightear.field_78796_g = 0.2617994f;
        this.rightear.field_78808_h = -0.3490659f;
        this.field_78116_c.func_78792_a(this.rightear);
        (this.leftear = new ModelRenderer((Model)this, 48, 25)).func_228300_a_(-4.0f, -4.0f, 0.0f, 4.0f, 4.0f, 1.0f);
        this.leftear.func_78793_a(-3.5f, -3.0f, -1.0f);
        this.leftear.field_78796_g = -0.2617994f;
        this.leftear.field_78808_h = 0.3490659f;
        this.field_78116_c.func_78792_a(this.leftear);
        (this.snout = new ModelRenderer((Model)this, 28, 0)).func_228300_a_(-1.5f, -2.0f, -2.0f, 3.0f, 2.0f, 3.0f);
        this.snout.func_78793_a(0.0f, -2.0f, -3.0f);
        this.field_78116_c.func_78792_a(this.snout);
        (this.jaw = new ModelRenderer((Model)this, 28, 5)).func_228300_a_(-1.5f, 0.0f, -2.0f, 3.0f, 1.0f, 3.0f);
        this.jaw.func_78793_a(0.0f, -2.0f, -3.0f);
        this.jaw.field_78795_f = 0.20944f;
        this.field_78116_c.func_78792_a(this.jaw);
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
            this.jaw.field_78795_f = 1.44f;
        }
        else {
            this.jaw.field_78795_f = 0.20944f;
        }
    }
    
    public void setLivingAnimations(final KoboldEntity entity, final float limbSwing, final float limbSwingAmount, final float partialTicks) {
        this.isJumping = (entity.func_213322_ci().func_82617_b() > 0.0);
    }
    
    protected Iterable<ModelRenderer> func_225602_a_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.field_78116_c);
    }
    
    protected Iterable<ModelRenderer> func_225600_b_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.field_78115_e, (Object)this.field_178723_h, (Object)this.field_178724_i, (Object)this.field_178721_j, (Object)this.field_178722_k);
    }
}
