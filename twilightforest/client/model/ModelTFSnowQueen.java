// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import net.minecraft.util.MathHelper;
import twilightforest.entity.boss.EntityTFSnowQueen;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBiped;

public class ModelTFSnowQueen extends ModelBiped
{
    public ModelTFSnowQueen() {
        final float par1 = 0.0f;
        final float par2 = 0.0f;
        (this.field_78114_d = new ModelRenderer((ModelBase)this, 0, 0)).func_78792_a(this.makeFrontCrown(-1.0f, -4.0f, 10.0f));
        this.field_78114_d.func_78792_a(this.makeFrontCrown(0.0f, 4.0f, -10.0f));
        this.field_78114_d.func_78792_a(this.makeSideCrown(-1.0f, -4.0f, 10.0f));
        this.field_78114_d.func_78792_a(this.makeSideCrown(0.0f, 4.0f, -10.0f));
        (this.field_78115_e = new ModelRenderer((ModelBase)this, 32, 0)).func_78790_a(-4.0f, 0.0f, -2.0f, 8, 23, 4, par1);
        this.field_78115_e.func_78793_a(0.0f, 0.0f + par2, 0.0f);
        (this.field_78112_f = new ModelRenderer((ModelBase)this, 16, 16)).func_78790_a(-2.0f, -2.0f, -1.5f, 3, 12, 3, par1);
        this.field_78112_f.func_78793_a(-5.0f, 2.0f + par2, 0.0f);
        this.field_78113_g = new ModelRenderer((ModelBase)this, 16, 16);
        this.field_78113_g.field_78809_i = true;
        this.field_78113_g.func_78790_a(-1.0f, -2.0f, -1.3f, 3, 12, 3, par1);
        this.field_78113_g.func_78793_a(5.0f, 2.0f + par2, 0.0f);
        (this.field_78123_h = new ModelRenderer((ModelBase)this, 0, 16)).func_78790_a(-1.5f, 0.0f, -1.5f, 3, 12, 3, par1);
        this.field_78123_h.func_78793_a(-1.9f, 12.0f + par2, 0.0f);
        this.field_78124_i = new ModelRenderer((ModelBase)this, 0, 16);
        this.field_78124_i.field_78809_i = true;
        this.field_78124_i.func_78790_a(-1.5f, 0.0f, -1.5f, 3, 12, 3, par1);
        this.field_78124_i.func_78793_a(1.9f, 12.0f + par2, 0.0f);
    }
    
    private ModelRenderer makeSideCrown(final float spikeDepth, final float crownX, final float angle) {
        final ModelRenderer crownSide = new ModelRenderer((ModelBase)this, 28, 28);
        crownSide.func_78789_a(-3.5f, -0.5f, -0.5f, 7, 1, 1);
        crownSide.func_78793_a(crownX, -6.0f, 0.0f);
        crownSide.field_78796_g = 1.570795f;
        final ModelRenderer spike4 = new ModelRenderer((ModelBase)this, 48, 27);
        spike4.func_78789_a(-0.5f, -3.5f, spikeDepth, 1, 4, 1);
        spike4.field_78795_f = angle * 1.5f / 180.0f * 3.14159f;
        final ModelRenderer spike3l = new ModelRenderer((ModelBase)this, 52, 28);
        spike3l.func_78789_a(-0.5f, -2.5f, spikeDepth, 1, 3, 1);
        spike3l.func_78793_a(-2.5f, 0.0f, 0.0f);
        spike3l.field_78795_f = angle / 180.0f * 3.14159f;
        spike3l.field_78808_h = -0.17453279f;
        final ModelRenderer spike3r = new ModelRenderer((ModelBase)this, 52, 28);
        spike3r.func_78789_a(-0.5f, -2.5f, spikeDepth, 1, 3, 1);
        spike3r.func_78793_a(2.5f, 0.0f, 0.0f);
        spike3r.field_78795_f = angle / 180.0f * 3.14159f;
        spike3r.field_78808_h = 0.17453279f;
        crownSide.func_78792_a(spike4);
        crownSide.func_78792_a(spike3l);
        crownSide.func_78792_a(spike3r);
        return crownSide;
    }
    
    private ModelRenderer makeFrontCrown(final float spikeDepth, final float crownZ, final float angle) {
        final ModelRenderer crownFront = new ModelRenderer((ModelBase)this, 28, 30);
        crownFront.func_78789_a(-4.5f, -0.5f, -0.5f, 9, 1, 1);
        crownFront.func_78793_a(0.0f, -6.0f, crownZ);
        final ModelRenderer spike4 = new ModelRenderer((ModelBase)this, 48, 27);
        spike4.func_78789_a(-0.5f, -3.5f, spikeDepth, 1, 4, 1);
        spike4.field_78795_f = angle * 1.5f / 180.0f * 3.14159f;
        final ModelRenderer spike3l = new ModelRenderer((ModelBase)this, 52, 28);
        spike3l.func_78789_a(-0.5f, -2.5f, spikeDepth, 1, 3, 1);
        spike3l.func_78793_a(-2.5f, 0.0f, 0.0f);
        spike3l.field_78795_f = angle / 180.0f * 3.14159f;
        spike3l.field_78808_h = -0.17453279f;
        final ModelRenderer spike3r = new ModelRenderer((ModelBase)this, 52, 28);
        spike3r.func_78789_a(-0.5f, -2.5f, spikeDepth, 1, 3, 1);
        spike3r.func_78793_a(2.5f, 0.0f, 0.0f);
        spike3r.field_78795_f = angle / 180.0f * 3.14159f;
        spike3r.field_78808_h = 0.17453279f;
        crownFront.func_78792_a(spike4);
        crownFront.func_78792_a(spike3l);
        crownFront.func_78792_a(spike3r);
        return crownFront;
    }
    
    public void func_78087_a(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final Entity par7Entity) {
        super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
        final EntityTFSnowQueen queen = (EntityTFSnowQueen)par7Entity;
        if (queen.getCurrentPhase() == EntityTFSnowQueen.Phase.BEAM) {
            if (queen.isBreathing()) {
                final float f6 = MathHelper.func_76126_a(this.field_78095_p * 3.1415927f);
                final float f7 = MathHelper.func_76126_a((1.0f - (1.0f - this.field_78095_p) * (1.0f - this.field_78095_p)) * 3.1415927f);
                this.field_78112_f.field_78808_h = 0.0f;
                this.field_78113_g.field_78808_h = 0.0f;
                this.field_78112_f.field_78796_g = -(0.1f - f6 * 0.6f);
                this.field_78113_g.field_78796_g = 0.1f - f6 * 0.6f;
                this.field_78112_f.field_78795_f = -1.5707964f;
                this.field_78113_g.field_78795_f = -1.5707964f;
                final ModelRenderer field_78112_f = this.field_78112_f;
                field_78112_f.field_78795_f -= f6 * 1.2f - f7 * 0.4f;
                final ModelRenderer field_78113_g = this.field_78113_g;
                field_78113_g.field_78795_f -= f6 * 1.2f - f7 * 0.4f;
                final ModelRenderer field_78112_f2 = this.field_78112_f;
                field_78112_f2.field_78808_h += MathHelper.func_76134_b(par3 * 0.09f) * 0.05f + 0.05f;
                final ModelRenderer field_78113_g2 = this.field_78113_g;
                field_78113_g2.field_78808_h -= MathHelper.func_76134_b(par3 * 0.09f) * 0.05f + 0.05f;
                final ModelRenderer field_78112_f3 = this.field_78112_f;
                field_78112_f3.field_78795_f += MathHelper.func_76126_a(par3 * 0.067f) * 0.05f;
                final ModelRenderer field_78113_g3 = this.field_78113_g;
                field_78113_g3.field_78795_f -= MathHelper.func_76126_a(par3 * 0.067f) * 0.05f;
            }
            else {
                final ModelRenderer field_78112_f4 = this.field_78112_f;
                field_78112_f4.field_78795_f += (float)3.141592653589793;
                final ModelRenderer field_78113_g4 = this.field_78113_g;
                field_78113_g4.field_78795_f += (float)3.141592653589793;
            }
        }
    }
}
