// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity.legacy;

import twilightforest.TwilightForestMod;
import twilightforest.entity.TFPart;
import net.minecraft.world.entity.Entity;
import twilightforest.entity.boss.Naga;
import com.mojang.math.Vector3f;
import net.minecraft.client.renderer.MultiBufferSource;
import com.mojang.blaze3d.vertex.PoseStack;
import twilightforest.client.model.TFModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import twilightforest.client.model.entity.legacy.NagaLegacyModel;
import twilightforest.client.renderer.entity.TFPartRenderer;
import twilightforest.entity.boss.NagaSegment;

public class LegacyNagaSegmentRenderer<T extends NagaSegment> extends TFPartRenderer<T, NagaLegacyModel<T>>
{
    private static final ResourceLocation part_TextureLoc;
    
    public LegacyNagaSegmentRenderer(final EntityRendererProvider.Context m) {
        super(m, new NagaLegacyModel(m.m_174023_(TFModelLayers.LEGACY_NAGA_BODY)));
    }
    
    @Override
    public void render(final T entityIn, final float entityYaw, final float partialTicks, final PoseStack matrixStackIn, final MultiBufferSource bufferIn, final int packedLightIn) {
        if (!entityIn.m_20145_()) {
            matrixStackIn.m_85836_();
            float yawDiff = entityIn.m_146908_() - entityIn.f_19859_;
            if (yawDiff > 180.0f) {
                yawDiff -= 360.0f;
            }
            else if (yawDiff < -180.0f) {
                yawDiff += 360.0f;
            }
            final float yaw2 = entityIn.f_19859_ + yawDiff * partialTicks;
            matrixStackIn.m_85845_(Vector3f.f_122225_.m_122240_(yaw2));
            matrixStackIn.m_85845_(Vector3f.f_122223_.m_122240_(entityIn.m_146909_()));
            matrixStackIn.m_85841_(2.0f, 2.0f, 2.0f);
            matrixStackIn.m_85837_(0.0, -1.5010000467300415, 0.0);
            final int light = this.f_114476_.m_114394_((Entity)entityIn.getParent(), partialTicks);
            super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, light);
            matrixStackIn.m_85849_();
        }
    }
    
    public ResourceLocation getTextureLocation(final T entity) {
        return LegacyNagaSegmentRenderer.part_TextureLoc;
    }
    
    static {
        part_TextureLoc = TwilightForestMod.getModelTexture("nagasegment.png");
    }
}
