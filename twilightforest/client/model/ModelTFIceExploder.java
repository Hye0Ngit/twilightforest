// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.EntityLivingBase;
import org.lwjgl.opengl.GL11;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBiped;

public class ModelTFIceExploder extends ModelBiped
{
    public ModelRenderer[] spikes;
    
    public ModelTFIceExploder() {
        this.spikes = new ModelRenderer[16];
        this.field_78090_t = 32;
        this.field_78089_u = 32;
        final float par1 = 0.0f;
        final float par2 = 0.0f;
        (this.field_78116_c = new ModelRenderer((ModelBase)this, 0, 0)).func_78790_a(-4.0f, 0.0f, -4.0f, 8, 8, 8, par1);
        this.field_78116_c.func_78793_a(0.0f, 0.0f + par2, 0.0f);
        this.field_78114_d = new ModelRenderer((ModelBase)this, 0, 0);
        this.field_78115_e = new ModelRenderer((ModelBase)this, 0, 0);
        this.field_78112_f = new ModelRenderer((ModelBase)this, 0, 0);
        this.field_78113_g = new ModelRenderer((ModelBase)this, 0, 0);
        this.field_78123_h = new ModelRenderer((ModelBase)this, 0, 0);
        this.field_78124_i = new ModelRenderer((ModelBase)this, 0, 0);
        for (int i = 0; i < this.spikes.length; ++i) {
            this.spikes[i] = new ModelRenderer((ModelBase)this, 0, 16);
            final int spikeLength = (i % 2 == 0) ? 6 : 8;
            this.spikes[i].func_78790_a(-1.0f, 6.0f, -1.0f, 2, spikeLength, 2, par1);
            this.spikes[i].func_78793_a(0.0f, 4.0f + par2, 0.0f);
            final ModelRenderer cube = new ModelRenderer((ModelBase)this, 8, 16);
            cube.func_78789_a(-1.5f, -1.5f, -1.5f, 3, 3, 3);
            cube.func_78793_a(0.0f, 8.0f, 0.0f);
            cube.field_78808_h = 0.7853982f;
            this.spikes[i].func_78792_a(cube);
        }
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        this.field_78116_c.func_78785_a(f5);
        for (int i = 0; i < this.spikes.length; ++i) {
            if (entity.func_70089_S()) {
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.6f);
            }
            this.spikes[i].func_78785_a(f5);
            GL11.glDisable(3042);
        }
    }
    
    public void func_78086_a(final EntityLivingBase par1EntityLiving, final float par2, final float par3, final float time) {
        for (int i = 0; i < this.spikes.length; ++i) {
            this.spikes[i].field_78796_g = (par1EntityLiving.field_70173_aa + time) / 5.0f;
            this.spikes[i].field_78795_f = MathHelper.func_76126_a((par1EntityLiving.field_70173_aa + time) / 5.0f) / 4.0f;
            this.spikes[i].field_78808_h = MathHelper.func_76134_b((par1EntityLiving.field_70173_aa + time) / 5.0f) / 4.0f;
            final ModelRenderer modelRenderer = this.spikes[i];
            modelRenderer.field_78795_f += i * 5;
            final ModelRenderer modelRenderer2 = this.spikes[i];
            modelRenderer2.field_78796_g += i * 2.5f;
            final ModelRenderer modelRenderer3 = this.spikes[i];
            modelRenderer3.field_78808_h += i * 3;
            this.spikes[i].field_78800_c = MathHelper.func_76134_b((par1EntityLiving.field_70173_aa + time) / i) * 3.0f;
            this.spikes[i].field_78797_d = 5.0f + MathHelper.func_76126_a((par1EntityLiving.field_70173_aa + time) / i) * 3.0f;
            this.spikes[i].field_78798_e = MathHelper.func_76126_a((par1EntityLiving.field_70173_aa + time) / i) * 3.0f;
            this.spikes[i].field_78805_m.get(0).field_78797_d = 10.0f + MathHelper.func_76126_a((i + par1EntityLiving.field_70173_aa + time) / i) * 3.0f;
        }
    }
}
