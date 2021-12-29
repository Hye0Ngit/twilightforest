// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBiped;

public class ModelTFYetiArmor extends ModelBiped
{
    private ModelRenderer bipedLegBody;
    private ModelRenderer rightRuff;
    private ModelRenderer leftRuff;
    private ModelRenderer rightToe;
    private ModelRenderer leftToe;
    
    public ModelTFYetiArmor(final int part, final float expand) {
        super(expand);
        (this.field_78116_c = new ModelRenderer((ModelBase)this, 0, 0)).func_78790_a(-4.5f, -7.5f, -4.0f, 9, 8, 8, expand);
        this.field_78116_c.func_78793_a(0.0f, 0.0f + expand, 0.0f);
        this.addPairHorns(-8.0f, 35.0f);
        this.addPairHorns(-6.0f, 15.0f);
        this.addPairHorns(-4.0f, -5.0f);
        (this.field_78123_h = new ModelRenderer((ModelBase)this, 40, 0)).func_78790_a(-2.0f, 0.0f, -2.0f, 4, 12, 4, expand);
        this.field_78123_h.func_78793_a(-1.9f, 12.0f, 0.0f);
        this.field_78124_i = new ModelRenderer((ModelBase)this, 40, 0);
        this.field_78124_i.field_78809_i = true;
        this.field_78124_i.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 12, 4, expand);
        this.field_78124_i.func_78793_a(1.9f, 12.0f, 0.0f);
        (this.rightRuff = new ModelRenderer((ModelBase)this, 40, 22)).func_78790_a(-2.5f, 0.0f, -2.5f, 5, 2, 5, expand);
        this.rightRuff.func_78793_a(0.0f, 6.0f, 0.0f);
        this.field_78123_h.func_78792_a(this.rightRuff);
        (this.leftRuff = new ModelRenderer((ModelBase)this, 40, 22)).func_78790_a(-2.5f, 0.0f, -2.5f, 5, 2, 5, expand);
        this.leftRuff.func_78793_a(0.0f, 6.0f, 0.0f);
        this.field_78124_i.func_78792_a(this.leftRuff);
        (this.rightToe = new ModelRenderer((ModelBase)this, 40, 17)).func_78790_a(-2.0f, 0.0f, -1.0f, 4, 2, 1, expand);
        this.rightToe.func_78793_a(0.0f, 10.0f, -2.0f);
        this.field_78123_h.func_78792_a(this.rightToe);
        (this.leftToe = new ModelRenderer((ModelBase)this, 40, 17)).func_78790_a(-2.0f, 0.0f, -1.0f, 4, 2, 1, expand);
        this.leftToe.func_78793_a(0.0f, 10.0f, -2.0f);
        this.field_78124_i.func_78792_a(this.leftToe);
        (this.field_78115_e = new ModelRenderer((ModelBase)this, 0, 0)).func_78790_a(-4.0f, 0.0f, -2.0f, 8, 11, 4, expand);
        this.field_78115_e.func_78793_a(0.0f, 0.0f, 0.0f);
        (this.bipedLegBody = new ModelRenderer((ModelBase)this, 40, 16)).func_78790_a(-4.0f, 0.0f, -2.0f, 8, 12, 4, expand);
        this.bipedLegBody.func_78793_a(0.0f, 0.0f, 0.0f);
        (this.field_78112_f = new ModelRenderer((ModelBase)this, 0, 16)).func_78790_a(-3.0f, -2.0f, -2.0f, 4, 10, 4, expand);
        this.field_78112_f.func_78793_a(-5.0f, 2.0f, 0.0f);
        this.field_78113_g = new ModelRenderer((ModelBase)this, 0, 16);
        this.field_78113_g.field_78809_i = true;
        this.field_78113_g.func_78790_a(-1.0f, -2.0f, -2.0f, 4, 10, 4, expand);
        this.field_78113_g.func_78793_a(5.0f, 2.0f, 0.0f);
        switch (part) {
            case 0: {
                this.field_78116_c.field_78806_j = true;
                this.field_78114_d.field_78806_j = false;
                this.field_78115_e.field_78806_j = false;
                this.field_78112_f.field_78806_j = false;
                this.field_78113_g.field_78806_j = false;
                this.bipedLegBody.field_78806_j = false;
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
                this.bipedLegBody.field_78806_j = false;
                this.field_78123_h.field_78806_j = false;
                this.field_78124_i.field_78806_j = false;
                break;
            }
            case 2: {
                this.field_78116_c.field_78806_j = false;
                this.field_78114_d.field_78806_j = false;
                this.field_78115_e.field_78806_j = false;
                this.field_78112_f.field_78806_j = false;
                this.field_78113_g.field_78806_j = false;
                this.bipedLegBody.field_78806_j = true;
                this.field_78123_h.field_78806_j = true;
                this.field_78124_i.field_78806_j = true;
                this.leftRuff.field_78806_j = false;
                this.leftToe.field_78806_j = false;
                this.rightRuff.field_78806_j = false;
                this.rightToe.field_78806_j = false;
                break;
            }
            case 3: {
                this.field_78116_c.field_78806_j = false;
                this.field_78114_d.field_78806_j = false;
                this.field_78115_e.field_78806_j = false;
                this.field_78112_f.field_78806_j = false;
                this.field_78113_g.field_78806_j = false;
                this.bipedLegBody.field_78806_j = false;
                this.field_78123_h.field_78806_j = true;
                this.field_78124_i.field_78806_j = true;
                this.leftRuff.field_78806_j = true;
                this.leftToe.field_78806_j = true;
                this.rightRuff.field_78806_j = true;
                this.rightToe.field_78806_j = true;
                break;
            }
        }
    }
    
    private void addPairHorns(final float height, final float zangle) {
        final ModelRenderer horn1a = new ModelRenderer((ModelBase)this, 0, 19);
        horn1a.func_78789_a(-3.0f, -1.5f, -1.5f, 3, 3, 3);
        horn1a.func_78793_a(-4.5f, height, -1.0f);
        horn1a.field_78796_g = -0.5235988f;
        horn1a.field_78808_h = zangle / 57.295776f;
        this.field_78116_c.func_78792_a(horn1a);
        final ModelRenderer horn1b = new ModelRenderer((ModelBase)this, 0, 26);
        horn1b.func_78789_a(-4.0f, -1.0f, -1.0f, 5, 2, 2);
        horn1b.func_78793_a(-3.0f, 0.0f, 0.0f);
        horn1b.field_78796_g = -0.34906587f;
        horn1b.field_78808_h = zangle / 57.295776f;
        horn1a.func_78792_a(horn1b);
        final ModelRenderer horn2a = new ModelRenderer((ModelBase)this, 0, 19);
        horn2a.func_78789_a(0.0f, -1.5f, -1.5f, 3, 3, 3);
        horn2a.func_78793_a(4.5f, height, -1.0f);
        horn2a.field_78796_g = 0.5235988f;
        horn2a.field_78808_h = -zangle / 57.295776f;
        this.field_78116_c.func_78792_a(horn2a);
        final ModelRenderer horn2b = new ModelRenderer((ModelBase)this, 0, 26);
        horn2b.func_78789_a(-1.0f, -1.0f, -1.0f, 5, 2, 2);
        horn2b.func_78793_a(3.0f, 0.0f, 0.0f);
        horn2b.field_78796_g = 0.34906587f;
        horn2b.field_78808_h = -zangle / 57.295776f;
        horn2a.func_78792_a(horn2b);
    }
    
    public void func_78088_a(final Entity par1Entity, final float par2, final float par3, final float par4, final float par5, final float par6, final float par7) {
        if (par1Entity != null) {
            this.field_78117_n = par1Entity.func_70093_af();
        }
        if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
            this.field_78120_m = ((((EntityLivingBase)par1Entity).func_70694_bm() != null) ? 1 : 0);
        }
        super.func_78088_a(par1Entity, par2, par3, par4, par5, par6, par7);
        this.bipedLegBody.func_78785_a(par7);
    }
}
