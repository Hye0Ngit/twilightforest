// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.client.renderer.texture.OverlayTexture;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Matrix3f;
import com.mojang.math.Matrix4f;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.renderer.RenderType;
import com.mojang.math.Vector3f;
import net.minecraft.client.renderer.MultiBufferSource;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import twilightforest.entity.projectile.TFThrowable;
import net.minecraft.client.renderer.entity.EntityRenderer;

public class CustomProjectileTextureRenderer extends EntityRenderer<TFThrowable>
{
    private final ResourceLocation TEXTURE;
    
    public CustomProjectileTextureRenderer(final EntityRendererProvider.Context ctx, final ResourceLocation texture) {
        super(ctx);
        this.TEXTURE = texture;
    }
    
    public void render(final TFThrowable entity, final float entityYaw, final float partialTicks, final PoseStack ms, final MultiBufferSource buffer, final int light) {
        ms.m_85836_();
        ms.m_85841_(0.5f, 0.5f, 0.5f);
        ms.m_85845_(this.f_114476_.m_114470_());
        ms.m_85845_(Vector3f.f_122225_.m_122240_(180.0f));
        final PoseStack.Pose posestack$pose = ms.m_85850_();
        final Matrix4f matrix4f = posestack$pose.m_85861_();
        final Matrix3f matrix3f = posestack$pose.m_85864_();
        final VertexConsumer vertexconsumer = buffer.m_6299_(RenderType.m_110458_(this.TEXTURE));
        vertex(vertexconsumer, matrix4f, matrix3f, light, 0.0f, 0, 0, 1);
        vertex(vertexconsumer, matrix4f, matrix3f, light, 1.0f, 0, 1, 1);
        vertex(vertexconsumer, matrix4f, matrix3f, light, 1.0f, 1, 1, 0);
        vertex(vertexconsumer, matrix4f, matrix3f, light, 0.0f, 1, 0, 0);
        ms.m_85849_();
        super.m_7392_((Entity)entity, entityYaw, partialTicks, ms, buffer, light);
    }
    
    private static void vertex(final VertexConsumer p_114090_, final Matrix4f p_114091_, final Matrix3f p_114092_, final int p_114093_, final float p_114094_, final int p_114095_, final int p_114096_, final int p_114097_) {
        p_114090_.m_85982_(p_114091_, p_114094_ - 0.5f, p_114095_ - 0.25f, 0.0f).m_6122_(255, 255, 255, 255).m_7421_((float)p_114096_, (float)p_114097_).m_86008_(OverlayTexture.f_118083_).m_85969_(p_114093_).m_85977_(p_114092_, 0.0f, 1.0f, 0.0f).m_5752_();
    }
    
    public ResourceLocation getTextureLocation(final TFThrowable entity) {
        return this.TEXTURE;
    }
}
