// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import twilightforest.entity.passive.BirdEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.client.model.entity.TinyBirdModel;
import twilightforest.entity.passive.TinyBirdEntity;

public class TinyBirdRenderer extends BirdRenderer<TinyBirdEntity, TinyBirdModel>
{
    private static final ResourceLocation textureLocSparrow;
    private static final ResourceLocation textureLocFinch;
    private static final ResourceLocation textureLocCardinal;
    private static final ResourceLocation textureLocBluebird;
    
    public TinyBirdRenderer(final EntityRendererManager manager, final TinyBirdModel model, final float shadowSize) {
        super(manager, (EntityModel)model, shadowSize, "");
    }
    
    @Override
    public ResourceLocation getEntityTexture(final TinyBirdEntity entity) {
        switch (entity.getBirdType()) {
            default: {
                return TinyBirdRenderer.textureLocSparrow;
            }
            case 1: {
                return TinyBirdRenderer.textureLocBluebird;
            }
            case 2: {
                return TinyBirdRenderer.textureLocCardinal;
            }
            case 3: {
                return TinyBirdRenderer.textureLocFinch;
            }
        }
    }
    
    static {
        textureLocSparrow = TwilightForestMod.getModelTexture("tinybirdbrown.png");
        textureLocFinch = TwilightForestMod.getModelTexture("tinybirdgold.png");
        textureLocCardinal = TwilightForestMod.getModelTexture("tinybirdred.png");
        textureLocBluebird = TwilightForestMod.getModelTexture("tinybirdblue.png");
    }
}
