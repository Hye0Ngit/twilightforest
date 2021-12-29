// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.entity.Entity;

public class NoopRenderer<T extends Entity> extends EntityRenderer<T>
{
    public NoopRenderer(final EntityRendererManager mgr) {
        super(mgr);
    }
    
    public ResourceLocation func_110775_a(final T p_110775_1_) {
        throw new UnsupportedOperationException();
    }
}
