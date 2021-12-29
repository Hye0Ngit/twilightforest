// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import twilightforest.TwilightForestMod;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.resources.ResourceLocation;

public class HydraNeck extends HydraPart
{
    public static final ResourceLocation RENDERER;
    public final HydraHead head;
    
    public HydraNeck(final HydraHead head) {
        super((Hydra)head.getParent(), 2.0f, 2.0f);
        this.head = head;
    }
    
    @OnlyIn(Dist.CLIENT)
    @Override
    public ResourceLocation renderer() {
        return HydraNeck.RENDERER;
    }
    
    static {
        RENDERER = TwilightForestMod.prefix("hydra_neck");
    }
}
