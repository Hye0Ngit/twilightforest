// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.math.MathHelper;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import twilightforest.client.model.entity.UnstableIceCoreModel;
import twilightforest.entity.UnstableIceCoreEntity;

public class UnstableIceCoreRenderer<T extends UnstableIceCoreEntity, M extends UnstableIceCoreModel<T>> extends TFBipedRenderer<T, M>
{
    public UnstableIceCoreRenderer(final EntityRendererManager manager, final M model) {
        super(manager, model, 0.4f, "iceexploder.png");
    }
    
    protected void preRenderCallback(final T entity, final MatrixStack stack, final float partialTicks) {
        final float bounce = entity.field_70173_aa + partialTicks;
        stack.func_227861_a_(0.0, (double)(MathHelper.func_76126_a(bounce * 0.2f) * 0.15f), 0.0);
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
            stack.func_227862_a_(f3, f4, f3);
        }
    }
    
    protected void applyRotations(final T entity, final MatrixStack stack, final float ageInTicks, final float rotationYaw, final float partialTicks) {
        stack.func_227863_a_(Vector3f.field_229181_d_.func_229187_a_(180.0f - rotationYaw));
    }
    
    protected float getOverlayProgress(final T entity, final float partialTicks) {
        if (entity.field_70725_aQ <= 0) {
            return 0.0f;
        }
        final float f2 = entity.field_70725_aQ + partialTicks;
        if ((int)(f2 / 2.0f) % 2 == 0) {
            return 0.0f;
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
        return (float)(i << 24 | short1 << 16 | short2 << 8 | short3);
    }
}
