// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.GlStateManager;
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
        this.field_178720_f = new ModelRenderer((ModelBase)this, 0, 0);
        this.field_78115_e = new ModelRenderer((ModelBase)this, 0, 0);
        this.field_178723_h = new ModelRenderer((ModelBase)this, 0, 0);
        this.field_178724_i = new ModelRenderer((ModelBase)this, 0, 0);
        this.field_178721_j = new ModelRenderer((ModelBase)this, 0, 0);
        this.field_178722_k = new ModelRenderer((ModelBase)this, 0, 0);
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
    
    public void func_78088_a(final Entity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scale) {
        this.func_78087_a(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
        this.field_78116_c.func_78785_a(scale);
        for (int i = 0; i < this.spikes.length; ++i) {
            if (entity.func_70089_S()) {
                GlStateManager.func_179147_l();
                GlStateManager.func_179112_b(770, 771);
                GlStateManager.func_179131_c(1.0f, 1.0f, 1.0f, 0.6f);
            }
            this.spikes[i].func_78785_a(scale);
            GlStateManager.func_179084_k();
        }
    }
    
    public void func_78086_a(final EntityLivingBase entity, final float limbSwing, final float limbSwingAmount, final float partialTicks) {
        for (int i = 0; i < this.spikes.length; ++i) {
            this.spikes[i].field_78796_g = (entity.field_70173_aa + partialTicks) / 5.0f;
            this.spikes[i].field_78795_f = MathHelper.func_76126_a((entity.field_70173_aa + partialTicks) / 5.0f) / 4.0f;
            this.spikes[i].field_78808_h = MathHelper.func_76134_b((entity.field_70173_aa + partialTicks) / 5.0f) / 4.0f;
            final ModelRenderer modelRenderer = this.spikes[i];
            modelRenderer.field_78795_f += i * 5;
            final ModelRenderer modelRenderer2 = this.spikes[i];
            modelRenderer2.field_78796_g += i * 2.5f;
            final ModelRenderer modelRenderer3 = this.spikes[i];
            modelRenderer3.field_78808_h += i * 3;
            this.spikes[i].field_78800_c = MathHelper.func_76134_b((entity.field_70173_aa + partialTicks) / i) * 3.0f;
            this.spikes[i].field_78797_d = 5.0f + MathHelper.func_76126_a((entity.field_70173_aa + partialTicks) / i) * 3.0f;
            this.spikes[i].field_78798_e = MathHelper.func_76126_a((entity.field_70173_aa + partialTicks) / i) * 3.0f;
            this.spikes[i].field_78805_m.get(0).field_78797_d = 10.0f + MathHelper.func_76126_a((i + entity.field_70173_aa + partialTicks) / i) * 3.0f;
        }
    }
}
