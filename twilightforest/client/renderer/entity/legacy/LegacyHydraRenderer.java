// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity.legacy;

import twilightforest.TwilightForestMod;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import twilightforest.client.model.entity.legacy.HydraLegacyModel;
import twilightforest.entity.boss.Hydra;
import net.minecraft.client.renderer.entity.MobRenderer;

public class LegacyHydraRenderer extends MobRenderer<Hydra, HydraLegacyModel>
{
    private static final ResourceLocation textureLoc;
    
    public LegacyHydraRenderer(final EntityRendererProvider.Context manager, final HydraLegacyModel modelbase, final float shadowSize) {
        super(manager, (EntityModel)modelbase, shadowSize);
    }
    
    protected float getFlipDegrees(final Hydra entity) {
        return 0.0f;
    }
    
    public ResourceLocation getTextureLocation(final Hydra entity) {
        return LegacyHydraRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("hydra4.png");
    }
}
