// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.entity.EntityTFKingSpider;
import net.minecraft.client.renderer.entity.RenderSpider;

public class RenderTFKingSpider extends RenderSpider<EntityTFKingSpider>
{
    private static final ResourceLocation textureLoc;
    
    public RenderTFKingSpider(final RenderManager manager) {
        super(manager);
    }
    
    protected ResourceLocation getEntityTexture(final EntityTFKingSpider entity) {
        return RenderTFKingSpider.textureLoc;
    }
    
    protected void preRenderCallback(final EntityTFKingSpider entity, final float partialTicks) {
        final float scale = 1.9f;
        GlStateManager.func_179152_a(scale, scale, scale);
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("kingspider.png");
    }
}
