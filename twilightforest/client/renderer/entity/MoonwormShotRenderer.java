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
import twilightforest.client.model.entity.MoonwormModel;
import net.minecraft.resources.ResourceLocation;
import twilightforest.entity.projectile.MoonwormShot;
import net.minecraft.client.renderer.entity.EntityRenderer;

public class MoonwormShotRenderer extends EntityRenderer<MoonwormShot>
{
    private static final ResourceLocation textureLoc;
    private final MoonwormModel wormModel;
    
    public MoonwormShotRenderer(final EntityRendererProvider.Context manager) {
        super(manager);
        this.f_114477_ = 0.25f;
        this.wormModel = new MoonwormModel(manager.m_174023_(TFModelLayers.MOONWORM));
    }
    
    public void render(final MoonwormShot entity, final float yaw, final float partialTicks, final PoseStack stack, final MultiBufferSource buffer, final int light) {
        stack.m_85836_();
        stack.m_85837_(0.0, 0.5, 0.0);
        stack.m_85841_(-1.0f, -1.0f, -1.0f);
        stack.m_85845_(Vector3f.f_122225_.m_122240_(Mth.m_14179_(partialTicks, entity.f_19859_, entity.m_146908_()) - 180.0f));
        stack.m_85845_(Vector3f.f_122227_.m_122240_(Mth.m_14179_(partialTicks, entity.f_19860_, entity.m_146909_())));
        final VertexConsumer builder = buffer.m_6299_(this.wormModel.m_103119_(MoonwormShotRenderer.textureLoc));
        this.wormModel.m_7695_(stack, builder, light, OverlayTexture.f_118083_, 1.0f, 1.0f, 1.0f, 1.0f);
        stack.m_85849_();
    }
    
    public ResourceLocation getTextureLocation(final MoonwormShot entity) {
        return MoonwormShotRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("moonworm.png");
    }
}
