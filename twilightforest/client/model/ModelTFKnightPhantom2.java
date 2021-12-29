// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import net.minecraft.util.MathHelper;
import twilightforest.entity.boss.EntityTFKnightPhantom;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBiped;

public class ModelTFKnightPhantom2 extends ModelBiped
{
    public ModelTFKnightPhantom2() {
        this(0.0f);
    }
    
    public ModelTFKnightPhantom2(final float par1) {
        super(par1, 0.0f, 64, 32);
        (this.field_78112_f = new ModelRenderer((ModelBase)this, 40, 16)).func_78790_a(-1.0f, -2.0f, -1.0f, 2, 12, 2, par1);
        this.field_78112_f.func_78793_a(-5.0f, 2.0f, 0.0f);
        this.field_78113_g = new ModelRenderer((ModelBase)this, 40, 16);
        this.field_78113_g.field_78809_i = true;
        this.field_78113_g.func_78790_a(-1.0f, -2.0f, -1.0f, 2, 12, 2, par1);
        this.field_78113_g.func_78793_a(5.0f, 2.0f, 0.0f);
        (this.field_78123_h = new ModelRenderer((ModelBase)this, 0, 16)).func_78790_a(-1.0f, 0.0f, -1.0f, 2, 12, 2, par1);
        this.field_78123_h.func_78793_a(-2.0f, 12.0f, 0.0f);
        this.field_78124_i = new ModelRenderer((ModelBase)this, 0, 16);
        this.field_78124_i.field_78809_i = true;
        this.field_78124_i.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 12, 2, par1);
        this.field_78124_i.func_78793_a(2.0f, 12.0f, 0.0f);
    }
    
    public void func_78088_a(final Entity par1Entity, final float par2, final float par3, final float par4, final float par5, final float par6, final float par7) {
        this.func_78087_a(par2, par3, par4, par5, par6, par7, par1Entity);
        if (((EntityTFKnightPhantom)par1Entity).isChargingAtPlayer()) {
            super.func_78088_a(par1Entity, par2, par3, par4, par5, par6, par7);
        }
    }
    
    public void func_78087_a(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final Entity par7Entity) {
        super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
        this.field_78124_i.field_78795_f = 0.0f;
        this.field_78124_i.field_78796_g = 0.0f;
        this.field_78124_i.field_78808_h = 0.0f;
        this.field_78123_h.field_78795_f = 0.0f;
        this.field_78123_h.field_78796_g = 0.0f;
        this.field_78123_h.field_78808_h = 0.0f;
        this.field_78123_h.field_78795_f = 0.2f * MathHelper.func_76126_a(par3 * 0.3f) + 0.4f;
        this.field_78124_i.field_78795_f = 0.2f * MathHelper.func_76126_a(par3 * 0.3f) + 0.4f;
    }
}
