// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.WolfRenderer;

public class WinterWolfRenderer extends WolfRenderer
{
    private static final ResourceLocation textureLoc;
    
    public WinterWolfRenderer(final EntityRendererProvider.Context manager) {
        super(manager);
        this.f_114477_ = 1.0f;
    }
    
    protected void scale(final Wolf entity, final PoseStack stack, final float partialTicks) {
        final float wolfScale = 1.9f;
        stack.m_85841_(wolfScale, wolfScale, wolfScale);
    }
    
    public ResourceLocation m_5478_(final Wolf entity) {
        return WinterWolfRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("winterwolf.png");
    }
}
