// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.model.ModelBiped;
import twilightforest.client.model.entity.ModelTFIceExploder;
import net.minecraft.client.renderer.entity.RenderManager;
import twilightforest.entity.EntityTFIceExploder;

public class RenderTFIceExploder extends RenderTFBiped<EntityTFIceExploder>
{
    public RenderTFIceExploder(final RenderManager manager) {
        super(manager, new ModelTFIceExploder(), 0.4f, "iceexploder.png");
    }
    
    protected void preRenderCallback(final EntityTFIceExploder entity, final float partialTicks) {
        final float bounce = entity.field_70173_aa + partialTicks;
        GlStateManager.func_179109_b(0.0f, MathHelper.func_76126_a(bounce * 0.2f) * 0.15f, 0.0f);
        float f1 = (float)entity.field_70725_aQ;
        if (f1 > 0.0f) {
            final float f2 = 1.0f + MathHelper.func_76126_a(f1 * 100.0f) * f1 * 0.01f;
            if (f1 < 0.0f) {
                f1 = 0.0f;
            }
            if (f1 > 1.0f) {
                f1 = 1.0f;
            }
            f1 *= f1;
            f1 *= f1;
            final float f3 = (1.0f + f1 * 0.4f) * f2;
            final float f4 = (1.0f + f1 * 0.1f) / f2;
            GlStateManager.func_179152_a(f3, f4, f3);
        }
    }
    
    protected void applyRotations(final EntityTFIceExploder entity, final float ageInTicks, final float rotationYaw, final float partialTicks) {
        GlStateManager.func_179114_b(180.0f - rotationYaw, 0.0f, 1.0f, 0.0f);
    }
    
    protected int getColorMultiplier(final EntityTFIceExploder entity, final float brightness, final float partialTicks) {
        if (entity.field_70725_aQ <= 0) {
            return 0;
        }
        final float f2 = entity.field_70725_aQ + partialTicks;
        if ((int)(f2 / 2.0f) % 2 == 0) {
            return 0;
        }
        int i = (int)(f2 * 0.2f * 255.0f);
        if (i < 0) {
            i = 0;
        }
        if (i > 255) {
            i = 255;
        }
        final short short1 = 255;
        final short short2 = 255;
        final short short3 = 255;
        return i << 24 | short1 << 16 | short2 << 8 | short3;
    }
}
