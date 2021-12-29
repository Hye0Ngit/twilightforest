// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.world.entity.Entity;
import twilightforest.TwilightForestMod;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.world.entity.Mob;

public class TFGenericMobRenderer<T extends Mob, M extends EntityModel<T>> extends MobRenderer<T, M>
{
    private final ResourceLocation textureLoc;
    
    public TFGenericMobRenderer(final EntityRendererProvider.Context manager, final M model, final float shadowSize, final String textureName) {
        super(manager, (EntityModel)model, shadowSize);
        if (textureName.startsWith("textures")) {
            this.textureLoc = new ResourceLocation(textureName);
        }
        else {
            this.textureLoc = TwilightForestMod.getModelTexture(textureName);
        }
    }
    
    public ResourceLocation getTextureLocation(final T entity) {
        return this.textureLoc;
    }
}
