// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.entity.projectile.AbstractArrowEntity;

public class DefaultArrowRenderer<T extends AbstractArrowEntity> extends ArrowRenderer<T>
{
    public static final ResourceLocation RES_ARROW;
    
    public DefaultArrowRenderer(final EntityRendererManager manager) {
        super(manager);
    }
    
    public ResourceLocation getEntityTexture(final T entity) {
        return DefaultArrowRenderer.RES_ARROW;
    }
    
    static {
        RES_ARROW = new ResourceLocation("textures/entity/projectiles/arrow.png");
    }
}
