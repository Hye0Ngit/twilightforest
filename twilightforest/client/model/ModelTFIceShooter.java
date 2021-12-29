// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.EntityLivingBase;

public class ModelTFIceShooter extends ModelTFIceExploder
{
    @Override
    public void func_78086_a(final EntityLivingBase par1EntityLiving, final float par2, final float par3, final float time) {
        for (int i = 0; i < this.spikes.length; ++i) {
            this.spikes[i].field_78796_g = 1.570795f + MathHelper.func_76126_a((par1EntityLiving.field_70173_aa + time) / 5.0f) * 0.5f;
            this.spikes[i].field_78795_f = (par1EntityLiving.field_70173_aa + time) / 5.0f;
            this.spikes[i].field_78808_h = MathHelper.func_76134_b(i / 5.0f) / 4.0f;
            final ModelRenderer modelRenderer = this.spikes[i];
            modelRenderer.field_78795_f += (float)(i * 0.39269908169872414);
            this.spikes[i].field_78805_m.get(0).field_78797_d = 9.5f + MathHelper.func_76126_a((i + par1EntityLiving.field_70173_aa + time) / 3.0f) * 3.0f;
        }
    }
}
