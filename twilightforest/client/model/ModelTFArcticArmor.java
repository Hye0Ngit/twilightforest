// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBiped;

public class ModelTFArcticArmor extends ModelBiped
{
    public ModelTFArcticArmor(final int part, final float expand) {
        super(expand);
        final ModelRenderer rightHood = new ModelRenderer((ModelBase)this, 0, 0);
        rightHood.func_78790_a(-1.0f, -2.0f, -1.0f, 1, 4, 1, expand);
        rightHood.func_78793_a(-2.5f, -3.0f, -5.0f);
        this.field_78116_c.func_78792_a(rightHood);
        final ModelRenderer leftHood = new ModelRenderer((ModelBase)this, 0, 0);
        leftHood.func_78790_a(0.0f, -2.0f, -1.0f, 1, 4, 1, expand);
        leftHood.func_78793_a(2.5f, -3.0f, -5.0f);
        this.field_78116_c.func_78792_a(leftHood);
        final ModelRenderer topHood = new ModelRenderer((ModelBase)this, 24, 0);
        topHood.func_78790_a(-2.0f, -1.0f, -1.0f, 4, 1, 1, expand);
        topHood.func_78793_a(0.0f, -5.5f, -5.0f);
        this.field_78116_c.func_78792_a(topHood);
        final ModelRenderer bottomHood = new ModelRenderer((ModelBase)this, 24, 0);
        bottomHood.func_78790_a(-2.0f, -1.0f, -1.0f, 4, 1, 1, expand);
        bottomHood.func_78793_a(0.0f, 0.5f, -5.0f);
        this.field_78116_c.func_78792_a(bottomHood);
        switch (part) {
            case 0: {
                this.field_78116_c.field_78806_j = true;
                this.field_78114_d.field_78806_j = false;
                this.field_78115_e.field_78806_j = false;
                this.field_78112_f.field_78806_j = false;
                this.field_78113_g.field_78806_j = false;
                this.field_78123_h.field_78806_j = false;
                this.field_78124_i.field_78806_j = false;
                break;
            }
            case 1: {
                this.field_78116_c.field_78806_j = false;
                this.field_78114_d.field_78806_j = false;
                this.field_78115_e.field_78806_j = true;
                this.field_78112_f.field_78806_j = true;
                this.field_78113_g.field_78806_j = true;
                this.field_78123_h.field_78806_j = false;
                this.field_78124_i.field_78806_j = false;
                break;
            }
            case 2: {
                this.field_78116_c.field_78806_j = false;
                this.field_78114_d.field_78806_j = false;
                this.field_78115_e.field_78806_j = true;
                this.field_78112_f.field_78806_j = false;
                this.field_78113_g.field_78806_j = false;
                this.field_78123_h.field_78806_j = true;
                this.field_78124_i.field_78806_j = true;
                break;
            }
            case 3: {
                this.field_78116_c.field_78806_j = false;
                this.field_78114_d.field_78806_j = false;
                this.field_78115_e.field_78806_j = false;
                this.field_78112_f.field_78806_j = false;
                this.field_78113_g.field_78806_j = false;
                this.field_78123_h.field_78806_j = true;
                this.field_78124_i.field_78806_j = true;
                break;
            }
        }
    }
    
    public void func_78088_a(final Entity par1Entity, final float par2, final float par3, final float par4, final float par5, final float par6, final float par7) {
        if (par1Entity != null) {
            this.field_78117_n = par1Entity.func_70093_af();
        }
        if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
            this.field_78120_m = ((((EntityLivingBase)par1Entity).func_70694_bm() != null) ? 1 : 0);
        }
        super.func_78088_a(par1Entity, par2, par3, par4, par5, par6, par7);
    }
}
