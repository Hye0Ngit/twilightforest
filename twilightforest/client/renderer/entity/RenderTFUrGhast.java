// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.entity.EntityTFTowerGhast;
import twilightforest.client.model.ModelTFGhast;

public class RenderTFUrGhast extends RenderTFTowerGhast
{
    final bjl textureLocClosed;
    final bjl textureLocOpen;
    final bjl textureLocAttack;
    
    public RenderTFUrGhast(final ModelTFGhast modelTFGhast, final float f, final float scale) {
        super(modelTFGhast, f, scale);
        this.textureLocClosed = new bjl("twilightforest:textures/model/towerboss.png");
        this.textureLocOpen = new bjl("twilightforest:textures/model/towerboss_openeyes.png");
        this.textureLocAttack = new bjl("twilightforest:textures/model/towerboss_fire.png");
    }
    
    @Override
    protected bjl a(final nm par1Entity) {
        if (!(par1Entity instanceof EntityTFTowerGhast)) {
            return this.textureLocClosed;
        }
        switch (((EntityTFTowerGhast)par1Entity).getAttackStatus()) {
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
