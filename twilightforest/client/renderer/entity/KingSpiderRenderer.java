// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.SpiderEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.entity.KingSpiderEntity;
import net.minecraft.client.renderer.entity.SpiderRenderer;

public class KingSpiderRenderer extends SpiderRenderer<KingSpiderEntity>
{
    private static final ResourceLocation textureLoc;
    
    public KingSpiderRenderer(final EntityRendererManager manager) {
        super(manager);
    }
    
    public ResourceLocation getEntityTexture(final KingSpiderEntity entity) {
        return KingSpiderRenderer.textureLoc;
    }
    
    protected void preRenderCallback(final KingSpiderEntity entity, final MatrixStack stack, final float partialTicks) {
        final float scale = 1.9f;
        stack.func_227862_a_(scale, scale, scale);
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("kingspider.png");
    }
}
