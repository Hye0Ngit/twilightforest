// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.world.entity.Entity;
import twilightforest.entity.monster.CarminiteGhastguard;
import twilightforest.TwilightForestMod;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import twilightforest.client.model.entity.UrGhastModel;
import twilightforest.entity.boss.UrGhast;

public class UrGhastRenderer extends CarminiteGhastRenderer<UrGhast, UrGhastModel>
{
    private final ResourceLocation textureLocClosed;
    private final ResourceLocation textureLocOpen;
    private final ResourceLocation textureLocAttack;
    
    public UrGhastRenderer(final EntityRendererProvider.Context manager, final UrGhastModel modelTFGhast, final float shadowSize, final float scale) {
        super(manager, modelTFGhast, shadowSize, scale);
        this.textureLocClosed = TwilightForestMod.getModelTexture("towerboss.png");
        this.textureLocOpen = TwilightForestMod.getModelTexture("towerboss_openeyes.png");
        this.textureLocAttack = TwilightForestMod.getModelTexture("towerboss_fire.png");
    }
    
    @Override
    public ResourceLocation getTextureLocation(final UrGhast entity) {
        return switch (entity.m_32756_() ? 2 : entity.getAttackStatus()) {
            case 1 -> this.textureLocOpen;
            case 2 -> this.textureLocAttack;
            default -> this.textureLocClosed;
        };
    }
}
