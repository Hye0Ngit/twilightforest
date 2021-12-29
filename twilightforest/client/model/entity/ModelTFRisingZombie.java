// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelZombie;

public class ModelTFRisingZombie extends ModelZombie
{
    public void func_78088_a(final Entity entityIn, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scale) {
        this.func_78087_a(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
        GlStateManager.func_179094_E();
        if (this.field_78091_s) {
            GlStateManager.func_179094_E();
            GlStateManager.func_179152_a(0.75f, 0.75f, 0.75f);
            GlStateManager.func_179109_b(0.0f, 16.0f * scale, 0.0f);
            this.field_78116_c.func_78785_a(scale);
            GlStateManager.func_179121_F();
            GlStateManager.func_179094_E();
            GlStateManager.func_179152_a(0.5f, 0.5f, 0.5f);
            GlStateManager.func_179109_b(0.0f, 24.0f * scale, 0.0f);
            this.field_78115_e.func_78785_a(scale);
            this.field_178723_h.func_78785_a(scale);
            this.field_178724_i.func_78785_a(scale);
            this.field_178720_f.func_78785_a(scale);
            GlStateManager.func_179121_F();
            this.field_178721_j.func_78785_a(scale);
            this.field_178722_k.func_78785_a(scale);
        }
        else {
            if (entityIn.func_70093_af()) {
                GlStateManager.func_179109_b(0.0f, 0.2f, 0.0f);
            }
            GlStateManager.func_179109_b(0.0f, (80.0f - Math.min(80.0f, ageInTicks)) / 80.0f, 0.0f);
            GlStateManager.func_179109_b(0.0f, (40.0f - Math.min(40.0f, Math.max(0.0f, ageInTicks - 80.0f))) / 40.0f, 0.0f);
            GlStateManager.func_179094_E();
            final float yOff = 1.0f;
            GlStateManager.func_179109_b(0.0f, 1.0f, 0.0f);
            GlStateManager.func_179114_b(-120.0f * (80.0f - Math.min(80.0f, ageInTicks)) / 80.0f, 1.0f, 0.0f, 0.0f);
            GlStateManager.func_179114_b(30.0f * (40.0f - Math.min(40.0f, Math.max(0.0f, ageInTicks - 80.0f))) / 40.0f, 1.0f, 0.0f, 0.0f);
            GlStateManager.func_179109_b(0.0f, -1.0f, 0.0f);
            this.field_78116_c.func_78785_a(scale);
            this.field_78115_e.func_78785_a(scale);
            this.field_178723_h.func_78785_a(scale);
            this.field_178724_i.func_78785_a(scale);
            this.field_178720_f.func_78785_a(scale);
            GlStateManager.func_179121_F();
            this.field_178721_j.func_78785_a(scale);
            this.field_178722_k.func_78785_a(scale);
        }
        GlStateManager.func_179121_F();
    }
}
