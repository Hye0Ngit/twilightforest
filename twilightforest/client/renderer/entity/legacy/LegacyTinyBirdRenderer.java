// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity.legacy;

import twilightforest.TwilightForestMod;
import net.minecraft.world.entity.Entity;
import twilightforest.entity.passive.Bird;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import twilightforest.client.model.entity.legacy.TinyBirdLegacyModel;
import twilightforest.entity.passive.TinyBird;
import twilightforest.client.renderer.entity.BirdRenderer;

public class LegacyTinyBirdRenderer extends BirdRenderer<TinyBird, TinyBirdLegacyModel>
{
    private static final ResourceLocation textureLocSparrow;
    private static final ResourceLocation textureLocFinch;
    private static final ResourceLocation textureLocCardinal;
    private static final ResourceLocation textureLocBluebird;
    
    public LegacyTinyBirdRenderer(final EntityRendererProvider.Context manager, final TinyBirdLegacyModel model, final float shadowSize) {
        super(manager, (EntityModel)model, shadowSize, "");
    }
    
    @Override
    public ResourceLocation getTextureLocation(final TinyBird entity) {
        return switch (entity.getBirdType()) {
            case 1 -> LegacyTinyBirdRenderer.textureLocBluebird;
            case 2 -> LegacyTinyBirdRenderer.textureLocCardinal;
            case 3 -> LegacyTinyBirdRenderer.textureLocFinch;
            default -> LegacyTinyBirdRenderer.textureLocSparrow;
        };
    }
    
    static {
        textureLocSparrow = TwilightForestMod.getModelTexture("tinybirdbrown.png");
        textureLocFinch = TwilightForestMod.getModelTexture("tinybirdgold.png");
        textureLocCardinal = TwilightForestMod.getModelTexture("tinybirdred.png");
        textureLocBluebird = TwilightForestMod.getModelTexture("tinybirdblue.png");
    }
}
