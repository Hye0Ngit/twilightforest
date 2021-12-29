// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.RenderSpider;

public class RenderTFHedgeSpider extends RenderSpider
{
    private static final ResourceLocation textureLoc;
    
    protected ResourceLocation func_110775_a(final Entity entity) {
        return RenderTFHedgeSpider.textureLoc;
    }
    
    static {
        textureLoc = new ResourceLocation("twilightforest:textures/model/hedgespider.png");
    }
}
