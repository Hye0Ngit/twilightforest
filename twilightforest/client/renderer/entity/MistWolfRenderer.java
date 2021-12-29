// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.WolfRenderer;

public class MistWolfRenderer extends WolfRenderer
{
    private static final ResourceLocation textureLoc;
    
    public MistWolfRenderer(final EntityRendererProvider.Context manager) {
        super(manager);
        this.f_114477_ = 1.0f;
    }
    
    protected void scale(final Wolf entity, final PoseStack stack, final float partialTicks) {
        final float wolfScale = 1.9f;
        stack.m_85841_(wolfScale, wolfScale, wolfScale);
        RenderSystem.m_69478_();
        RenderSystem.m_69405_(770, 771);
        float misty = entity.m_6073_() * 3.0f + 0.25f;
        misty = Math.min(1.0f, misty);
        final float smoky = entity.m_6073_() * 2.0f + 0.6f;
        RenderSystem.m_157429_(misty, misty, misty, smoky);
    }
    
    public ResourceLocation m_5478_(final Wolf entity) {
        return MistWolfRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("mistwolf.png");
    }
}
