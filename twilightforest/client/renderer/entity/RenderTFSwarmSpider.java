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
import twilightforest.entity.EntityTFSwarmSpider;
import net.minecraft.client.renderer.entity.RenderSpider;

public class RenderTFSwarmSpider extends RenderSpider<EntityTFSwarmSpider>
{
    private static final ResourceLocation textureLoc;
    
    public RenderTFSwarmSpider(final RenderManager manager) {
        super(manager);
    }
    
    protected ResourceLocation getEntityTexture(final EntityTFSwarmSpider entity) {
        return RenderTFSwarmSpider.textureLoc;
    }
    
    protected void preRenderCallback(final EntityTFSwarmSpider entity, final float partialTicks) {
        final float scale = 0.5f;
        GlStateManager.func_179152_a(scale, scale, scale);
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("swarmspider.png");
    }
}
