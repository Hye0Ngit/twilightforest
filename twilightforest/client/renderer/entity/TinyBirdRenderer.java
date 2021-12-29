// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.world.entity.Entity;
import twilightforest.entity.passive.Bird;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import twilightforest.client.model.entity.TinyBirdModel;
import twilightforest.entity.passive.TinyBird;

public class TinyBirdRenderer extends BirdRenderer<TinyBird, TinyBirdModel>
{
    private static final ResourceLocation textureLocSparrow;
    private static final ResourceLocation textureLocFinch;
    private static final ResourceLocation textureLocCardinal;
    private static final ResourceLocation textureLocBluebird;
    
    public TinyBirdRenderer(final EntityRendererProvider.Context manager, final TinyBirdModel model, final float shadowSize) {
        super(manager, (EntityModel)model, shadowSize, "");
    }
    
    @Override
    public ResourceLocation getTextureLocation(final TinyBird entity) {
        return switch (entity.getBirdType()) {
            case 1 -> TinyBirdRenderer.textureLocBluebird;
            case 2 -> TinyBirdRenderer.textureLocCardinal;
            case 3 -> TinyBirdRenderer.textureLocFinch;
            default -> TinyBirdRenderer.textureLocSparrow;
        };
    }
    
    static {
        textureLocSparrow = TwilightForestMod.getModelTexture("tinybirdbrown.png");
        textureLocFinch = TwilightForestMod.getModelTexture("tinybirdgold.png");
        textureLocCardinal = TwilightForestMod.getModelTexture("tinybirdred.png");
        textureLocBluebird = TwilightForestMod.getModelTexture("tinybirdblue.png");
    }
}
