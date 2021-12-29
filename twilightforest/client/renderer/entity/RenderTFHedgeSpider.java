// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.entity.EntityTFHedgeSpider;
import net.minecraft.client.renderer.entity.RenderSpider;

public class RenderTFHedgeSpider extends RenderSpider<EntityTFHedgeSpider>
{
    private static final ResourceLocation textureLoc;
    
    public RenderTFHedgeSpider(final RenderManager manager) {
        super(manager);
    }
    
    protected ResourceLocation getEntityTexture(final EntityTFHedgeSpider entity) {
        return RenderTFHedgeSpider.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("hedgespider.png");
    }
}
