// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import twilightforest.client.model.entity.HydraModel;
import twilightforest.entity.boss.Hydra;
import net.minecraft.client.renderer.entity.MobRenderer;

public class HydraRenderer extends MobRenderer<Hydra, HydraModel>
{
    private static final ResourceLocation textureLoc;
    
    public HydraRenderer(final EntityRendererProvider.Context manager, final HydraModel modelbase, final float shadowSize) {
        super(manager, (EntityModel)modelbase, shadowSize);
    }
    
    protected float getFlipDegrees(final Hydra entity) {
        return 0.0f;
    }
    
    public ResourceLocation getTextureLocation(final Hydra entity) {
        return HydraRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("hydra4.png");
    }
}
