// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.RenderLiving;
import twilightforest.entity.EntityTFTowerGhast;

public class RenderTFGhast<T extends EntityTFTowerGhast> extends RenderLiving<T>
{
    private static final ResourceLocation textureLocClosed;
    private static final ResourceLocation textureLocOpen;
    private static final ResourceLocation textureLocAttack;
    
    public RenderTFGhast(final RenderManager manager, final ModelBase model, final float shadowSize) {
        super(manager, model, shadowSize);
    }
    
    protected ResourceLocation getEntityTexture(final EntityTFTowerGhast entity) {
        switch (entity.func_110182_bF() ? 2 : entity.getAttackStatus()) {
            default: {
                return RenderTFGhast.textureLocClosed;
            }
            case 1: {
                return RenderTFGhast.textureLocOpen;
            }
            case 2: {
                return RenderTFGhast.textureLocAttack;
            }
        }
    }
    
    static {
        textureLocClosed = TwilightForestMod.getModelTexture("towerghast.png");
        textureLocOpen = TwilightForestMod.getModelTexture("towerghast_openeyes.png");
        textureLocAttack = TwilightForestMod.getModelTexture("towerghast_fire.png");
    }
}
