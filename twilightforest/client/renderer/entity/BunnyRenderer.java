// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.world.entity.Entity;
import twilightforest.TwilightForestMod;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import twilightforest.client.model.entity.BunnyModel;
import twilightforest.entity.passive.DwarfRabbit;
import net.minecraft.client.renderer.entity.MobRenderer;

public class BunnyRenderer extends MobRenderer<DwarfRabbit, BunnyModel>
{
    private final ResourceLocation textureLocDutch;
    private final ResourceLocation textureLocWhite;
    private final ResourceLocation textureLocBrown;
    
    public BunnyRenderer(final EntityRendererProvider.Context manager, final BunnyModel model, final float shadowSize) {
        super(manager, (EntityModel)model, shadowSize);
        this.textureLocDutch = TwilightForestMod.getModelTexture("bunnydutch.png");
        this.textureLocWhite = TwilightForestMod.getModelTexture("bunnywhite.png");
        this.textureLocBrown = TwilightForestMod.getModelTexture("bunnybrown.png");
    }
    
    public ResourceLocation getTextureLocation(final DwarfRabbit entity) {
        return switch (entity.getBunnyType()) {
            case 2 -> this.textureLocWhite;
            case 3 -> this.textureLocBrown;
            default -> this.textureLocDutch;
        };
    }
}
