// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.world.entity.projectile.AbstractArrow;

public class DefaultArrowRenderer<T extends AbstractArrow> extends ArrowRenderer<T>
{
    public static final ResourceLocation RES_ARROW;
    
    public DefaultArrowRenderer(final EntityRendererProvider.Context manager) {
        super(manager);
    }
    
    public ResourceLocation getTextureLocation(final T entity) {
        return DefaultArrowRenderer.RES_ARROW;
    }
    
    static {
        RES_ARROW = new ResourceLocation("textures/entity/projectiles/arrow.png");
    }
}
