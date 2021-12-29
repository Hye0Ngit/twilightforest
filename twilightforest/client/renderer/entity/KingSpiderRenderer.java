// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Spider;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import twilightforest.entity.monster.KingSpider;
import net.minecraft.client.renderer.entity.SpiderRenderer;

public class KingSpiderRenderer extends SpiderRenderer<KingSpider>
{
    private static final ResourceLocation textureLoc;
    
    public KingSpiderRenderer(final EntityRendererProvider.Context manager) {
        super(manager);
    }
    
    public ResourceLocation getTextureLocation(final KingSpider entity) {
        return KingSpiderRenderer.textureLoc;
    }
    
    protected void scale(final KingSpider entity, final PoseStack stack, final float partialTicks) {
        final float scale = 1.9f;
        stack.m_85841_(scale, scale, scale);
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("kingspider.png");
    }
}
