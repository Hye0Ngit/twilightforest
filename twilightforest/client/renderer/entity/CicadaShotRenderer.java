// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.world.entity.Entity;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.Mth;
import com.mojang.math.Vector3f;
import net.minecraft.client.renderer.MultiBufferSource;
import com.mojang.blaze3d.vertex.PoseStack;
import twilightforest.client.model.TFModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import twilightforest.client.model.entity.CicadaModel;
import net.minecraft.resources.ResourceLocation;
import twilightforest.entity.projectile.CicadaShot;
import net.minecraft.client.renderer.entity.EntityRenderer;

public class CicadaShotRenderer extends EntityRenderer<CicadaShot>
{
    private static final ResourceLocation textureLoc;
    private final CicadaModel cicadaModel;
    
    public CicadaShotRenderer(final EntityRendererProvider.Context manager) {
        super(manager);
        this.f_114477_ = 0.25f;
        this.cicadaModel = new CicadaModel(manager.m_174023_(TFModelLayers.CICADA));
    }
    
    public void render(final CicadaShot entity, final float yaw, final float partialTicks, final PoseStack stack, final MultiBufferSource buffer, final int light) {
        stack.m_85836_();
        stack.m_85837_(0.0, 0.5, 0.0);
        stack.m_85841_(-1.0f, -1.0f, -1.0f);
        stack.m_85845_(Vector3f.f_122225_.m_122240_(Mth.m_14179_(partialTicks, entity.f_19859_, entity.m_146908_()) - 180.0f));
        stack.m_85845_(Vector3f.f_122223_.m_122240_(Mth.m_14179_(partialTicks, entity.f_19860_, entity.m_146909_())));
        final VertexConsumer builder = buffer.m_6299_(this.cicadaModel.m_103119_(CicadaShotRenderer.textureLoc));
        this.cicadaModel.m_7695_(stack, builder, light, OverlayTexture.f_118083_, 1.0f, 1.0f, 1.0f, 1.0f);
        stack.m_85849_();
    }
    
    public ResourceLocation getTextureLocation(final CicadaShot entity) {
        return CicadaShotRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("cicada-model.png");
    }
}
