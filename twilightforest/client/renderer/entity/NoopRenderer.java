// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.world.entity.Entity;

public class NoopRenderer<T extends Entity> extends EntityRenderer<T>
{
    public NoopRenderer(final EntityRendererProvider.Context mgr) {
        super(mgr);
    }
    
    public ResourceLocation m_5478_(final T p_110775_1_) {
        throw new UnsupportedOperationException();
    }
}
