// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import twilightforest.entity.AdherentEntity;
import net.minecraft.client.renderer.entity.model.BipedModel;

public class AdherentModel extends BipedModel<AdherentEntity>
{
    ModelRenderer leftSleeve;
    ModelRenderer rightSleeve;
    
    public AdherentModel() {
        super(0.0f);
        this.field_178720_f = new ModelRenderer((Model)this, 0, 0);
        this.field_178722_k = new ModelRenderer((Model)this, 0, 0);
        this.field_178721_j = new ModelRenderer((Model)this, 0, 0);
        (this.field_78116_c = new ModelRenderer((Model)this, 0, 0)).func_228300_a_(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f);
        this.field_78116_c.func_78793_a(0.0f, 0.0f, 0.0f);
        (this.field_78115_e = new ModelRenderer((Model)this, 32, 0)).func_228300_a_(-4.0f, 0.0f, -2.0f, 8.0f, 24.0f, 4.0f);
        this.field_78115_e.func_78793_a(0.0f, 0.0f, 0.0f);
        (this.field_178723_h = new ModelRenderer((Model)this, 0, 16)).func_228300_a_(-3.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f);
        this.field_178723_h.func_78793_a(-5.0f, 2.0f, 0.0f);
        (this.field_178724_i = new ModelRenderer((Model)this, 0, 16)).func_228300_a_(-1.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f);
        this.field_178724_i.func_78793_a(5.0f, 2.0f, 0.0f);
        (this.leftSleeve = new ModelRenderer((Model)this, 16, 16)).func_228300_a_(-1.0f, -2.0f, 2.0f, 4.0f, 12.0f, 4.0f);
        this.leftSleeve.func_78793_a(0.0f, 0.0f, 0.0f);
        this.field_178724_i.func_78792_a(this.leftSleeve);
        (this.rightSleeve = new ModelRenderer((Model)this, 16, 16)).func_228300_a_(-3.0f, -2.0f, 2.0f, 4.0f, 12.0f, 4.0f);
        this.rightSleeve.func_78793_a(0.0f, 0.0f, 0.0f);
        this.field_178723_h.func_78792_a(this.rightSleeve);
    }
    
    public void setRotationAngles(final AdherentEntity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.field_78116_c.field_78796_g = netHeadYaw / 57.295776f;
        this.field_78116_c.field_78795_f = headPitch / 57.295776f;
        this.field_178723_h.field_78795_f = 0.0f;
        this.field_178724_i.field_78795_f = 0.0f;
        this.field_178723_h.field_78808_h = 0.0f;
        this.field_178724_i.field_78808_h = 0.0f;
        final ModelRenderer field_178723_h = this.field_178723_h;
        field_178723_h.field_78808_h += MathHelper.func_76134_b((ageInTicks + 10.0f) * 0.133f) * 0.3f + 0.3f;
        final ModelRenderer field_178724_i = this.field_178724_i;
        field_178724_i.field_78808_h -= MathHelper.func_76134_b((ageInTicks + 10.0f) * 0.133f) * 0.3f + 0.3f;
        final ModelRenderer field_178723_h2 = this.field_178723_h;
        field_178723_h2.field_78795_f += MathHelper.func_76126_a(ageInTicks * 0.067f) * 0.05f;
        final ModelRenderer field_178724_i2 = this.field_178724_i;
        field_178724_i2.field_78795_f -= MathHelper.func_76126_a(ageInTicks * 0.067f) * 0.05f;
    }
}
