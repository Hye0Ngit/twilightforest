// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.entity.EntityTFTowerGhast;

public class RenderTFMiniGhast extends bhb
{
    final bjl textureLocClosed;
    final bjl textureLocOpen;
    final bjl textureLocAttack;
    
    public RenderTFMiniGhast(final bbl par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
        this.textureLocClosed = new bjl("twilightforest:textures/model/towerghast.png");
        this.textureLocOpen = new bjl("twilightforest:textures/model/towerghast_openeyes.png");
        this.textureLocAttack = new bjl("twilightforest:textures/model/towerghast_fire.png");
    }
    
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
