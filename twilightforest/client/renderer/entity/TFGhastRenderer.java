// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import twilightforest.client.model.entity.TFGhastModel;
import twilightforest.entity.CarminiteGhastguardEntity;

public class TFGhastRenderer<T extends CarminiteGhastguardEntity, M extends TFGhastModel<T>> extends MobRenderer<T, M>
{
    private static final ResourceLocation textureLocClosed;
    private static final ResourceLocation textureLocOpen;
    private static final ResourceLocation textureLocAttack;
    
    public TFGhastRenderer(final EntityRendererManager manager, final M model, final float shadowSize) {
        super(manager, (EntityModel)model, shadowSize);
    }
    
    public ResourceLocation getEntityTexture(final T entity) {
        switch (entity.func_110182_bF() ? 2 : entity.getAttackStatus()) {
            default: {
                return TFGhastRenderer.textureLocClosed;
            }
            case 1: {
                return TFGhastRenderer.textureLocOpen;
            }
            case 2: {
                return TFGhastRenderer.textureLocAttack;
            }
        }
    }
    
    static {
        textureLocClosed = TwilightForestMod.getModelTexture("towerghast.png");
        textureLocOpen = TwilightForestMod.getModelTexture("towerghast_openeyes.png");
        textureLocAttack = TwilightForestMod.getModelTexture("towerghast_fire.png");
    }
}
