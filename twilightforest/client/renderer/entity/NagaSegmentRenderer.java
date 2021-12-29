// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

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
import twilightforest.client.model.entity.NagaModel;
import twilightforest.entity.boss.NagaSegment;

public class NagaSegmentRenderer<T extends NagaSegment> extends TFPartRenderer<T, NagaModel<T>>
{
    private static final ResourceLocation part_TextureLoc;
    
    public NagaSegmentRenderer(final EntityRendererProvider.Context m) {
        super(m, new NagaModel(m.m_174023_(TFModelLayers.NAGA_BODY)));
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
            final int light = this.f_114476_.m_114394_((Entity)entityIn.getParent(), partialTicks);
            super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, light);
            matrixStackIn.m_85849_();
        }
    }
    
    public ResourceLocation getTextureLocation(final T entity) {
        return NagaSegmentRenderer.part_TextureLoc;
    }
    
    static {
        part_TextureLoc = TwilightForestMod.getModelTexture("nagasegment.png");
    }
}
