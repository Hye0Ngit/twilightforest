// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBiped;

public class ModelTFAdherent extends ModelBiped
{
    ModelRenderer leftSleeve;
    ModelRenderer rightSleeve;
    
    public ModelTFAdherent() {
        this.field_178720_f = new ModelRenderer((ModelBase)this, 0, 0);
        this.field_178722_k = new ModelRenderer((ModelBase)this, 0, 0);
        this.field_178721_j = new ModelRenderer((ModelBase)this, 0, 0);
        (this.field_78116_c = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-4.0f, -8.0f, -4.0f, 8, 8, 8);
        this.field_78116_c.func_78793_a(0.0f, 0.0f, 0.0f);
        (this.field_78115_e = new ModelRenderer((ModelBase)this, 32, 0)).func_78789_a(-4.0f, 0.0f, -2.0f, 8, 24, 4);
        this.field_78115_e.func_78793_a(0.0f, 0.0f, 0.0f);
        (this.field_178723_h = new ModelRenderer((ModelBase)this, 0, 16)).func_78789_a(-3.0f, -2.0f, -2.0f, 4, 12, 4);
        this.field_178723_h.func_78793_a(-5.0f, 2.0f, 0.0f);
        (this.field_178724_i = new ModelRenderer((ModelBase)this, 0, 16)).func_78789_a(-1.0f, -2.0f, -2.0f, 4, 12, 4);
        this.field_178724_i.func_78793_a(5.0f, 2.0f, 0.0f);
        (this.leftSleeve = new ModelRenderer((ModelBase)this, 16, 16)).func_78789_a(-1.0f, -2.0f, 2.0f, 4, 12, 4);
        this.leftSleeve.func_78793_a(0.0f, 0.0f, 0.0f);
        this.field_178724_i.func_78792_a(this.leftSleeve);
        (this.rightSleeve = new ModelRenderer((ModelBase)this, 16, 16)).func_78789_a(-3.0f, -2.0f, 2.0f, 4, 12, 4);
        this.rightSleeve.func_78793_a(0.0f, 0.0f, 0.0f);
        this.field_178723_h.func_78792_a(this.rightSleeve);
    }
    
    public void func_78087_a(final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scaleFactor, final Entity entity) {
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
    
    public void func_78086_a(final EntityLivingBase entity, final float limbSwing, final float limbSwingAmount, final float partialTicks) {
        final float bounce = entity.field_70173_aa + partialTicks;
        GlStateManager.func_179109_b(0.0f, -0.125f - MathHelper.func_76126_a(bounce * 0.133f) * 0.1f, 0.0f);
    }
}
