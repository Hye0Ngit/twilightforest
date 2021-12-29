// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.entity.EntityTFTowerGhast;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.RenderLiving;

public class RenderTFMiniGhast extends RenderLiving
{
    final ResourceLocation textureLocClosed;
    final ResourceLocation textureLocOpen;
    final ResourceLocation textureLocAttack;
    
    public RenderTFMiniGhast(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
        this.textureLocClosed = new ResourceLocation("twilightforest:textures/model/towerghast.png");
        this.textureLocOpen = new ResourceLocation("twilightforest:textures/model/towerghast_openeyes.png");
        this.textureLocAttack = new ResourceLocation("twilightforest:textures/model/towerghast_fire.png");
    }
    
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
