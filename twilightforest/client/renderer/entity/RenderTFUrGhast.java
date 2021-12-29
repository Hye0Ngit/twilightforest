// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.Entity;
import twilightforest.entity.EntityTFTowerGhast;
import twilightforest.TwilightForestMod;
import twilightforest.client.model.entity.ModelTFGhast;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderTFUrGhast extends RenderTFTowerGhast
{
    private final ResourceLocation textureLocClosed;
    private final ResourceLocation textureLocOpen;
    private final ResourceLocation textureLocAttack;
    
    public RenderTFUrGhast(final RenderManager manager, final ModelTFGhast modelTFGhast, final float shadowSize, final float scale) {
        super(manager, modelTFGhast, shadowSize, scale);
        this.textureLocClosed = TwilightForestMod.getModelTexture("towerboss.png");
        this.textureLocOpen = TwilightForestMod.getModelTexture("towerboss_openeyes.png");
        this.textureLocAttack = TwilightForestMod.getModelTexture("towerboss_fire.png");
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityTFTowerGhast entity) {
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
