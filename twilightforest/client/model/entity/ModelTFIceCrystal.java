// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelTFIceCrystal extends ModelBase
{
    public ModelRenderer[] spikes;
    
    public ModelTFIceCrystal() {
        this.spikes = new ModelRenderer[16];
        this.field_78090_t = 32;
        this.field_78089_u = 32;
        final float par1 = 0.0f;
        final float par2 = 0.0f;
        for (int i = 0; i < this.spikes.length; ++i) {
            this.spikes[i] = new ModelRenderer((ModelBase)this, 0, 16);
            final int spikeLength = (i % 2 == 0) ? 6 : 8;
            this.spikes[i].func_78790_a(-1.0f, -1.0f, -1.0f, 2, spikeLength, 2, par1);
            this.spikes[i].func_78793_a(0.0f, 0.0f + par2, 0.0f);
            final ModelRenderer cube = new ModelRenderer((ModelBase)this, 8, 16);
            cube.func_78789_a(-1.5f, -1.5f, -1.5f, 3, 3, 3);
            cube.func_78793_a(0.0f, (float)spikeLength, 0.0f);
            cube.field_78808_h = 0.7853982f;
            this.spikes[i].func_78792_a(cube);
        }
    }
    
    public void func_78088_a(final Entity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scale) {
        this.func_78087_a(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
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
            this.spikes[i].field_78795_f = MathHelper.func_76126_a((entity.field_70173_aa + partialTicks) / 5.0f) / 4.0f;
            this.spikes[i].field_78796_g = (entity.field_70173_aa + partialTicks) / 5.0f;
            this.spikes[i].field_78808_h = MathHelper.func_76134_b((entity.field_70173_aa + partialTicks) / 5.0f) / 4.0f;
            final ModelRenderer modelRenderer = this.spikes[i];
            modelRenderer.field_78795_f += (float)(i * 0.39269908169872414);
            if (i % 4 == 0) {
                final ModelRenderer modelRenderer2 = this.spikes[i];
                ++modelRenderer2.field_78796_g;
            }
            else if (i % 4 == 2) {
                final ModelRenderer modelRenderer3 = this.spikes[i];
                --modelRenderer3.field_78796_g;
            }
        }
    }
}
