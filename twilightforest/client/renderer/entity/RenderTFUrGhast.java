// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.entity.EntityTFTowerGhast;
import net.minecraft.entity.Entity;
import twilightforest.client.model.ModelTFGhast;
import net.minecraft.util.ResourceLocation;

public class RenderTFUrGhast extends RenderTFTowerGhast
{
    final ResourceLocation textureLocClosed;
    final ResourceLocation textureLocOpen;
    final ResourceLocation textureLocAttack;
    
    public RenderTFUrGhast(final ModelTFGhast modelTFGhast, final float f, final float scale) {
        super(modelTFGhast, f, scale);
        this.textureLocClosed = new ResourceLocation("twilightforest:textures/model/towerboss.png");
        this.textureLocOpen = new ResourceLocation("twilightforest:textures/model/towerboss_openeyes.png");
        this.textureLocAttack = new ResourceLocation("twilightforest:textures/model/towerboss_fire.png");
    }
    
    @Override
    protected ResourceLocation func_110775_a(final Entity par1Entity) {
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
