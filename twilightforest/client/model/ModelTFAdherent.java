// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import org.lwjgl.opengl.GL11;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBiped;

public class ModelTFAdherent extends ModelBiped
{
    ModelRenderer leftSleeve;
    ModelRenderer rightSleeve;
    
    public ModelTFAdherent() {
        this.field_78114_d = new ModelRenderer((ModelBase)this, 0, 0);
        this.field_78124_i = new ModelRenderer((ModelBase)this, 0, 0);
        this.field_78123_h = new ModelRenderer((ModelBase)this, 0, 0);
        (this.field_78116_c = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-4.0f, -8.0f, -4.0f, 8, 8, 8);
        this.field_78116_c.func_78793_a(0.0f, 0.0f, 0.0f);
        (this.field_78115_e = new ModelRenderer((ModelBase)this, 32, 0)).func_78789_a(-4.0f, 0.0f, -2.0f, 8, 24, 4);
        this.field_78115_e.func_78793_a(0.0f, 0.0f, 0.0f);
        (this.field_78112_f = new ModelRenderer((ModelBase)this, 0, 16)).func_78789_a(-3.0f, -2.0f, -2.0f, 4, 12, 4);
        this.field_78112_f.func_78793_a(-5.0f, 2.0f, 0.0f);
        (this.field_78113_g = new ModelRenderer((ModelBase)this, 0, 16)).func_78789_a(-1.0f, -2.0f, -2.0f, 4, 12, 4);
        this.field_78113_g.func_78793_a(5.0f, 2.0f, 0.0f);
        (this.leftSleeve = new ModelRenderer((ModelBase)this, 16, 16)).func_78789_a(-1.0f, -2.0f, 2.0f, 4, 12, 4);
        this.leftSleeve.func_78793_a(0.0f, 0.0f, 0.0f);
        this.field_78113_g.func_78792_a(this.leftSleeve);
        (this.rightSleeve = new ModelRenderer((ModelBase)this, 16, 16)).func_78789_a(-3.0f, -2.0f, 2.0f, 4, 12, 4);
        this.rightSleeve.func_78793_a(0.0f, 0.0f, 0.0f);
        this.field_78112_f.func_78792_a(this.rightSleeve);
    }
    
    public void func_78087_a(final float f, final float f1, final float f2, final float yaw, final float pitch, final float time, final Entity entity) {
        this.field_78116_c.field_78796_g = yaw / 57.295776f;
        this.field_78116_c.field_78795_f = pitch / 57.295776f;
        this.field_78112_f.field_78795_f = 0.0f;
        this.field_78113_g.field_78795_f = 0.0f;
        this.field_78112_f.field_78808_h = 0.0f;
        this.field_78113_g.field_78808_h = 0.0f;
        final ModelRenderer field_78112_f = this.field_78112_f;
        field_78112_f.field_78808_h += MathHelper.func_76134_b((f2 + 10.0f) * 0.133f) * 0.3f + 0.3f;
        final ModelRenderer field_78113_g = this.field_78113_g;
        field_78113_g.field_78808_h -= MathHelper.func_76134_b((f2 + 10.0f) * 0.133f) * 0.3f + 0.3f;
        final ModelRenderer field_78112_f2 = this.field_78112_f;
        field_78112_f2.field_78795_f += MathHelper.func_76126_a(f2 * 0.067f) * 0.05f;
        final ModelRenderer field_78113_g2 = this.field_78113_g;
        field_78113_g2.field_78795_f -= MathHelper.func_76126_a(f2 * 0.067f) * 0.05f;
    }
    
    public void func_78086_a(final EntityLivingBase par1EntityLiving, final float par2, final float par3, final float partialTick) {
        final float bounce = par1EntityLiving.field_70173_aa + partialTick;
        GL11.glTranslatef(0.0f, -0.125f - MathHelper.func_76126_a(bounce * 0.133f) * 0.1f, 0.0f);
    }
}
