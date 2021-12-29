// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.SpiderRenderer;
import twilightforest.entity.HedgeSpiderEntity;

public class HedgeSpiderRenderer<T extends HedgeSpiderEntity> extends SpiderRenderer<T>
{
    private static final ResourceLocation textureLoc;
    
    public HedgeSpiderRenderer(final EntityRendererManager manager) {
        super(manager);
    }
    
    public ResourceLocation getEntityTexture(final T entity) {
        return HedgeSpiderRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("hedgespider.png");
    }
}
