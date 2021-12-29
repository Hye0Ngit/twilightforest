// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.world.entity.Entity;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.Mth;
import net.minecraft.client.renderer.MultiBufferSource;
import com.mojang.blaze3d.vertex.PoseStack;
import twilightforest.client.model.TFModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import twilightforest.client.model.entity.HydraMortarModel;
import net.minecraft.resources.ResourceLocation;
import twilightforest.entity.boss.HydraMortarHead;
import net.minecraft.client.renderer.entity.EntityRenderer;

public class HydraMortarRenderer extends EntityRenderer<HydraMortarHead>
{
    private static final ResourceLocation textureLoc;
    private final HydraMortarModel mortarModel;
    
    public HydraMortarRenderer(final EntityRendererProvider.Context manager) {
        super(manager);
        this.f_114477_ = 0.5f;
        this.mortarModel = new HydraMortarModel(manager.m_174023_(TFModelLayers.HYDRA_MORTAR));
    }
    
    public void render(final HydraMortarHead mortar, final float yaw, final float partialTicks, final PoseStack stack, final MultiBufferSource buffers, final int light) {
        stack.m_85836_();
        if (mortar.fuse - partialTicks + 1.0f < 10.0f) {
            float f = 1.0f - (mortar.fuse - partialTicks + 1.0f) / 10.0f;
            f = Mth.m_14036_(f, 0.0f, 1.0f);
            f *= f;
            f *= f;
            final float f2 = 1.0f + f * 0.3f;
            stack.m_85841_(f2, f2, f2);
        }
        final float alpha = (1.0f - (mortar.fuse - partialTicks + 1.0f) / 100.0f) * 0.8f;
        VertexConsumer builder = buffers.m_6299_(this.mortarModel.m_103119_(HydraMortarRenderer.textureLoc));
        this.mortarModel.m_7695_(stack, builder, light, OverlayTexture.f_118083_, 1.0f, 1.0f, 1.0f, 0.075f);
        if (mortar.fuse / 5 % 2 == 0) {
            builder = buffers.m_6299_(RenderType.m_110473_(HydraMortarRenderer.textureLoc));
            this.mortarModel.m_7695_(stack, builder, light, OverlayTexture.m_118093_(OverlayTexture.m_118088_(1.0f), 10), 1.0f, 1.0f, 1.0f, alpha);
        }
        stack.m_85849_();
    }
    
    public ResourceLocation getTextureLocation(final HydraMortarHead entity) {
        return HydraMortarRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("hydramortar.png");
    }
}
