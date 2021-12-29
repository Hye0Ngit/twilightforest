// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.world.entity.Entity;
import twilightforest.entity.TFPart;
import twilightforest.entity.boss.HydraHeadContainer;
import com.mojang.math.Vector3f;
import net.minecraft.client.renderer.MultiBufferSource;
import com.mojang.blaze3d.vertex.PoseStack;
import twilightforest.client.model.TFModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import twilightforest.client.model.entity.HydraNeckModel;
import twilightforest.entity.boss.HydraNeck;

public class HydraNeckRenderer extends TFPartRenderer<HydraNeck, HydraNeckModel>
{
    private static final ResourceLocation textureLoc;
    
    public HydraNeckRenderer(final EntityRendererProvider.Context manager) {
        super(manager, new HydraNeckModel(manager.m_174023_(TFModelLayers.HYDRA_NECK)));
    }
    
    @Override
    public void render(final HydraNeck entityIn, final float entityYaw, final float partialTicks, final PoseStack matrixStackIn, final MultiBufferSource bufferIn, final int light) {
        final HydraHeadContainer headCon = HydraHeadRenderer.getHeadObject(entityIn.head);
        if (headCon != null && headCon.shouldRenderHead()) {
            float yawDiff = entityIn.m_146908_() - entityIn.f_19859_;
            if (yawDiff > 180.0f) {
                yawDiff -= 360.0f;
            }
            else if (yawDiff < -180.0f) {
                yawDiff += 360.0f;
            }
            final float yaw2 = entityIn.f_19859_ + yawDiff * partialTicks;
            matrixStackIn.m_85845_(Vector3f.f_122224_.m_122240_(yaw2 + 180.0f));
            super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, light);
        }
    }
    
    public ResourceLocation getTextureLocation(final HydraNeck entity) {
        return HydraNeckRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("hydra4.png");
    }
}
