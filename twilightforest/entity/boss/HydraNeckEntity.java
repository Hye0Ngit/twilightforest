// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import twilightforest.client.renderer.entity.HydraNeckRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;

public class HydraNeckEntity extends HydraPartEntity
{
    public final HydraHeadEntity head;
    
    public HydraNeckEntity(final HydraHeadEntity head) {
        super((HydraEntity)head.getParent(), 2.0f, 2.0f);
        this.head = head;
    }
    
    @OnlyIn(Dist.CLIENT)
    @Override
    public EntityRenderer<?> renderer(final EntityRendererManager manager) {
        return new HydraNeckRenderer(manager);
    }
}
