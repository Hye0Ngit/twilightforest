// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import twilightforest.client.model.entity.TFGhastModel;
import twilightforest.entity.monster.CarminiteGhastguard;

public class TFGhastRenderer<T extends CarminiteGhastguard, M extends TFGhastModel<T>> extends MobRenderer<T, M>
{
    private static final ResourceLocation textureLocClosed;
    private static final ResourceLocation textureLocOpen;
    private static final ResourceLocation textureLocAttack;
    
    public TFGhastRenderer(final EntityRendererProvider.Context manager, final M model, final float shadowSize) {
        super(manager, (EntityModel)model, shadowSize);
    }
    
    public ResourceLocation getTextureLocation(final T entity) {
        return switch (entity.m_32756_() ? 2 : entity.getAttackStatus()) {
            case 1 -> TFGhastRenderer.textureLocOpen;
            case 2 -> TFGhastRenderer.textureLocAttack;
            default -> TFGhastRenderer.textureLocClosed;
        };
    }
    
    static {
        textureLocClosed = TwilightForestMod.getModelTexture("towerghast.png");
        textureLocOpen = TwilightForestMod.getModelTexture("towerghast_openeyes.png");
        textureLocAttack = TwilightForestMod.getModelTexture("towerghast_fire.png");
    }
}
