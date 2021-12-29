// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.client.model.entity.HydraModel;
import twilightforest.entity.boss.HydraEntity;
import net.minecraft.client.renderer.entity.MobRenderer;

public class HydraRenderer extends MobRenderer<HydraEntity, HydraModel>
{
    private static final ResourceLocation textureLoc;
    
    public HydraRenderer(final EntityRendererManager manager, final HydraModel modelbase, final float shadowSize) {
        super(manager, (EntityModel)modelbase, shadowSize);
    }
    
    protected float getDeathMaxRotation(final HydraEntity entity) {
        return 0.0f;
    }
    
    public ResourceLocation getEntityTexture(final HydraEntity entity) {
        return HydraRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("hydra4.png");
    }
}
