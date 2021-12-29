// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.Entity;
import twilightforest.entity.CarminiteGhastguardEntity;
import twilightforest.TwilightForestMod;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.client.model.entity.UrGhastModel;
import twilightforest.entity.boss.UrGhastEntity;

public class UrGhastRenderer extends CarminiteGhastRenderer<UrGhastEntity, UrGhastModel>
{
    private final ResourceLocation textureLocClosed;
    private final ResourceLocation textureLocOpen;
    private final ResourceLocation textureLocAttack;
    
    public UrGhastRenderer(final EntityRendererManager manager, final UrGhastModel modelTFGhast, final float shadowSize, final float scale) {
        super(manager, modelTFGhast, shadowSize, scale);
        this.textureLocClosed = TwilightForestMod.getModelTexture("towerboss.png");
        this.textureLocOpen = TwilightForestMod.getModelTexture("towerboss_openeyes.png");
        this.textureLocAttack = TwilightForestMod.getModelTexture("towerboss_fire.png");
    }
    
    @Override
    public ResourceLocation getEntityTexture(final UrGhastEntity entity) {
        switch (entity.func_110182_bF() ? 2 : entity.getAttackStatus()) {
            default: {
                return this.textureLocClosed;
            }
            case 1: {
                return this.textureLocOpen;
            }
            case 2: {
                return this.textureLocAttack;
            }
        }
    }
}
