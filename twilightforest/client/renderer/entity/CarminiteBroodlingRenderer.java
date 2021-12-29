// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Spider;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.SpiderRenderer;
import twilightforest.entity.monster.TowerBroodling;

public class CarminiteBroodlingRenderer<T extends TowerBroodling> extends SpiderRenderer<T>
{
    private static final ResourceLocation textureLoc;
    
    public CarminiteBroodlingRenderer(final EntityRendererProvider.Context manager) {
        super(manager);
    }
    
    public ResourceLocation getTextureLocation(final T entity) {
        return CarminiteBroodlingRenderer.textureLoc;
    }
    
    protected void scale(final T entity, final PoseStack stack, final float partialTicks) {
        final float scale = 0.7f;
        stack.m_85841_(scale, scale, scale);
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("towerbroodling.png");
    }
}
