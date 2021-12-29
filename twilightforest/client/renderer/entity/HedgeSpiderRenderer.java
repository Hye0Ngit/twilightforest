// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.SpiderRenderer;
import twilightforest.entity.monster.HedgeSpider;

public class HedgeSpiderRenderer<T extends HedgeSpider> extends SpiderRenderer<T>
{
    private static final ResourceLocation textureLoc;
    
    public HedgeSpiderRenderer(final EntityRendererProvider.Context manager) {
        super(manager);
    }
    
    public ResourceLocation getTextureLocation(final T entity) {
        return HedgeSpiderRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("hedgespider.png");
    }
}
