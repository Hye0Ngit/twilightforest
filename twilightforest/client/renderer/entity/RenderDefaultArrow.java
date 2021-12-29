// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.entity.projectile.EntityArrow;

public class RenderDefaultArrow<T extends EntityArrow> extends RenderArrow<T>
{
    public static final ResourceLocation RES_ARROW;
    
    public RenderDefaultArrow(final RenderManager manager) {
        super(manager);
    }
    
    protected ResourceLocation getEntityTexture(final T entity) {
        return RenderDefaultArrow.RES_ARROW;
    }
    
    static {
        RES_ARROW = new ResourceLocation("textures/entity/projectiles/arrow.png");
    }
}
