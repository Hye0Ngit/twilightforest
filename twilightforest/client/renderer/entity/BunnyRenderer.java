// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.Entity;
import twilightforest.TwilightForestMod;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.client.model.entity.BunnyModel;
import twilightforest.entity.passive.BunnyEntity;
import net.minecraft.client.renderer.entity.MobRenderer;

public class BunnyRenderer extends MobRenderer<BunnyEntity, BunnyModel>
{
    private final ResourceLocation textureLocDutch;
    private final ResourceLocation textureLocWhite;
    private final ResourceLocation textureLocBrown;
    
    public BunnyRenderer(final EntityRendererManager manager, final BunnyModel model, final float shadowSize) {
        super(manager, (EntityModel)model, shadowSize);
        this.textureLocDutch = TwilightForestMod.getModelTexture("bunnydutch.png");
        this.textureLocWhite = TwilightForestMod.getModelTexture("bunnywhite.png");
        this.textureLocBrown = TwilightForestMod.getModelTexture("bunnybrown.png");
    }
    
    public ResourceLocation getEntityTexture(final BunnyEntity entity) {
        switch (entity.getBunnyType()) {
            default: {
                return this.textureLocDutch;
            }
            case 2: {
                return this.textureLocWhite;
            }
            case 3: {
                return this.textureLocBrown;
            }
        }
    }
}
