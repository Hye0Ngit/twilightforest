// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBiped;

public class ModelTFKobold extends ModelBiped
{
    ModelRenderer rightear;
    ModelRenderer leftear;
    ModelRenderer snout;
    ModelRenderer jaw;
    boolean isJumping;
    
    public ModelTFKobold() {
        this.isJumping = false;
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        (this.field_78116_c = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-3.5f, -7.0f, -3.0f, 7, 6, 6);
        this.field_78116_c.func_78793_a(0.0f, 13.0f, 0.0f);
        (this.field_78115_e = new ModelRenderer((ModelBase)this, 12, 19)).func_78789_a(0.0f, 0.0f, 0.0f, 7, 7, 4);
        this.field_78115_e.func_78793_a(-3.5f, 12.0f, -2.0f);
        (this.field_78112_f = new ModelRenderer((ModelBase)this, 36, 17)).func_78789_a(-3.0f, -1.0f, -1.5f, 3, 7, 3);
        this.field_78112_f.func_78793_a(-3.5f, 12.0f, 0.0f);
        this.field_78113_g.field_78809_i = true;
        (this.field_78113_g = new ModelRenderer((ModelBase)this, 36, 17)).func_78789_a(0.0f, -1.0f, -1.5f, 3, 7, 3);
        this.field_78113_g.func_78793_a(3.5f, 12.0f, 0.0f);
        this.field_78113_g.field_78809_i = false;
        (this.field_78123_h = new ModelRenderer((ModelBase)this, 0, 20)).func_78789_a(-1.5f, 0.0f, -1.5f, 3, 5, 3);
        this.field_78123_h.func_78793_a(-2.0f, 19.0f, 0.0f);
        (this.field_78124_i = new ModelRenderer((ModelBase)this, 0, 20)).func_78789_a(-1.5f, 0.0f, -1.5f, 3, 5, 3);
        this.field_78124_i.func_78793_a(2.0f, 19.0f, 0.0f);
        (this.rightear = new ModelRenderer((ModelBase)this, 48, 20)).func_78789_a(0.0f, -4.0f, 0.0f, 4, 4, 1);
        this.rightear.func_78793_a(3.5f, -3.0f, -1.0f);
        this.rightear.field_78796_g = 0.2617994f;
        this.rightear.field_78808_h = -0.3490659f;
        this.field_78116_c.func_78792_a(this.rightear);
        (this.leftear = new ModelRenderer((ModelBase)this, 48, 25)).func_78789_a(-4.0f, -4.0f, 0.0f, 4, 4, 1);
        this.leftear.func_78793_a(-3.5f, -3.0f, -1.0f);
        this.leftear.field_78796_g = -0.2617994f;
        this.leftear.field_78808_h = 0.3490659f;
        this.field_78116_c.func_78792_a(this.leftear);
        (this.snout = new ModelRenderer((ModelBase)this, 28, 0)).func_78789_a(-1.5f, -2.0f, -2.0f, 3, 2, 3);
        this.snout.func_78793_a(0.0f, -2.0f, -3.0f);
        this.field_78116_c.func_78792_a(this.snout);
        (this.jaw = new ModelRenderer((ModelBase)this, 28, 5)).func_78789_a(-1.5f, 0.0f, -2.0f, 3, 1, 3);
        this.jaw.func_78793_a(0.0f, -2.0f, -3.0f);
        this.jaw.field_78795_f = 0.20944f;
        this.field_78116_c.func_78792_a(this.jaw);
    }
    
    public void setRotationAngles(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6) {
        this.field_78116_c.field_78796_g = par4 / 57.295776f;
        this.field_78116_c.field_78795_f = par5 / 57.295776f;
        this.field_78112_f.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662f + 3.1415927f) * 2.0f * par2 * 0.5f;
        this.field_78113_g.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662f) * 2.0f * par2 * 0.5f;
        this.field_78112_f.field_78808_h = 0.0f;
        this.field_78113_g.field_78808_h = 0.0f;
        this.field_78112_f.field_78795_f = -0.47123894f;
        this.field_78113_g.field_78795_f = -0.47123894f;
        this.field_78123_h.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662f) * 1.4f * par2;
        this.field_78124_i.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.field_78123_h.field_78796_g = 0.0f;
        this.field_78124_i.field_78796_g = 0.0f;
        final ModelRenderer field_78112_f = this.field_78112_f;
        field_78112_f.field_78808_h += MathHelper.func_76134_b(par3 * 0.19f) * 0.15f + 0.05f;
        final ModelRenderer field_78113_g = this.field_78113_g;
        field_78113_g.field_78808_h -= MathHelper.func_76134_b(par3 * 0.19f) * 0.15f + 0.05f;
        final ModelRenderer field_78112_f2 = this.field_78112_f;
        field_78112_f2.field_78795_f += MathHelper.func_76126_a(par3 * 0.267f) * 0.25f;
        final ModelRenderer field_78113_g2 = this.field_78113_g;
        field_78113_g2.field_78795_f -= MathHelper.func_76126_a(par3 * 0.267f) * 0.25f;
        if (this.isJumping) {
            this.jaw.field_78795_f = 1.44f;
        }
        else {
            this.jaw.field_78795_f = 0.20944f;
        }
    }
    
    public void func_78086_a(final EntityLivingBase par1EntityLiving, final float par2, final float par3, final float partialTick) {
        this.isJumping = (par1EntityLiving.field_70181_x > 0.0);
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5);
        this.field_78116_c.func_78785_a(f5);
        this.field_78115_e.func_78785_a(f5);
        this.field_78112_f.func_78785_a(f5);
        this.field_78113_g.func_78785_a(f5);
        this.field_78123_h.func_78785_a(f5);
        this.field_78124_i.func_78785_a(f5);
    }
}
