// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.Mob;
import net.minecraft.client.model.SpiderModel;
import net.minecraft.client.renderer.MultiBufferSource;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import twilightforest.entity.monster.SwarmSpider;
import net.minecraft.client.renderer.entity.SpiderRenderer;

public class SwarmSpiderRenderer extends SpiderRenderer<SwarmSpider>
{
    private static final ResourceLocation textureLoc;
    
    public SwarmSpiderRenderer(final EntityRendererProvider.Context manager) {
        super(manager);
        this.f_114477_ = 0.25f;
    }
    
    public ResourceLocation getTextureLocation(final SwarmSpider entity) {
        return SwarmSpiderRenderer.textureLoc;
    }
    
    public void render(final SwarmSpider entityIn, final float entityYaw, final float partialTicks, final PoseStack matrixStackIn, final MultiBufferSource bufferIn, final int packedLightIn) {
        if (((SpiderModel)this.f_115290_).f_102609_) {
            matrixStackIn.m_85837_(0.0, 0.15000000596046448, 0.0);
        }
        super.m_7392_((Mob)entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
    
    protected void scale(final SwarmSpider entity, final PoseStack stack, final float partialTicks) {
        final float scale = 0.5f;
        stack.m_85841_(scale, scale, scale);
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("swarmspider.png");
    }
}
