// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.world.entity.LivingEntity;
import com.mojang.math.Vector3f;
import net.minecraft.util.Mth;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import twilightforest.client.model.entity.UnstableIceCoreModel;
import twilightforest.entity.monster.UnstableIceCore;

public class UnstableIceCoreRenderer<T extends UnstableIceCore, M extends UnstableIceCoreModel<T>> extends TFGenericMobRenderer<T, M>
{
    public UnstableIceCoreRenderer(final EntityRendererProvider.Context manager, final M model) {
        super(manager, (EntityModel)model, 0.4f, "iceexploder.png");
    }
    
    protected void scale(final T entity, final PoseStack stack, final float partialTicks) {
        final float bounce = entity.f_19797_ + partialTicks;
        stack.m_85837_(0.0, (double)(Mth.m_14031_(bounce * 0.2f) * 0.15f), 0.0);
        float f1 = (float)entity.f_20919_;
        if (f1 > 0.0f) {
            final float f2 = 1.0f + Mth.m_14031_(f1 * 100.0f) * f1 * 0.01f;
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
            stack.m_85841_(f3, f4, f3);
        }
    }
    
    protected void setupRotations(final T entity, final PoseStack stack, final float ageInTicks, final float rotationYaw, final float partialTicks) {
        stack.m_85845_(Vector3f.f_122225_.m_122240_(180.0f - rotationYaw));
    }
    
    protected float getWhiteOverlayProgress(final T entity, final float partialTicks) {
        if (entity.f_20919_ <= 0) {
            return 0.0f;
        }
        final float f2 = entity.f_20919_ + partialTicks;
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
