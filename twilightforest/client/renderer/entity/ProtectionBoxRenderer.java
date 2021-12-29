// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.renderer.MultiBufferSource;
import com.mojang.blaze3d.vertex.PoseStack;
import twilightforest.client.model.TFModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import twilightforest.client.model.entity.ProtectionBoxModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRenderer;
import twilightforest.entity.ProtectionBox;

public class ProtectionBoxRenderer<T extends ProtectionBox> extends EntityRenderer<T>
{
    private static final ResourceLocation textureLoc;
    private final ProtectionBoxModel<T> boxModel;
    
    public ProtectionBoxRenderer(final EntityRendererProvider.Context manager) {
        super(manager);
        this.f_114477_ = 0.5f;
        this.boxModel = new ProtectionBoxModel<T>(manager.m_174023_(TFModelLayers.PROTECTION_BOX));
    }
    
    public void render(final T entity, final float yaw, final float partialTicks, final PoseStack stack, final MultiBufferSource buffer, final int light) {
        stack.m_85836_();
        stack.m_85849_();
    }
    
    public ResourceLocation getTextureLocation(final T entity) {
        return ProtectionBoxRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("protectionbox.png");
    }
}
