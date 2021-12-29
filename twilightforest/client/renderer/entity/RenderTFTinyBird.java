// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import twilightforest.entity.passive.EntityTFTinyBird;
import twilightforest.entity.passive.EntityTFBird;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderTFTinyBird extends RenderTFBird
{
    private static final ResourceLocation textureLocSparrow;
    private static final ResourceLocation textureLocFinch;
    private static final ResourceLocation textureLocCardinal;
    private static final ResourceLocation textureLocBluebird;
    
    public RenderTFTinyBird(final RenderManager manager, final ModelBase model, final float shadowSize) {
        super(manager, model, shadowSize, "");
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityTFBird entity) {
        if (!(entity instanceof EntityTFTinyBird)) {
            return RenderTFTinyBird.textureLocSparrow;
        }
        switch (((EntityTFTinyBird)entity).getBirdType()) {
            default: {
                return RenderTFTinyBird.textureLocSparrow;
            }
            case 1: {
                return RenderTFTinyBird.textureLocBluebird;
            }
            case 2: {
                return RenderTFTinyBird.textureLocCardinal;
            }
            case 3: {
                return RenderTFTinyBird.textureLocFinch;
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
