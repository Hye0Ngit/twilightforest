// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.Entity;
import twilightforest.TwilightForestMod;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.MobEntity;

public class TFGenericMobRenderer<T extends MobEntity, M extends EntityModel<T>> extends MobRenderer<T, M>
{
    private final ResourceLocation textureLoc;
    
    public TFGenericMobRenderer(final EntityRendererManager manager, final M model, final float shadowSize, final String textureName) {
        super(manager, (EntityModel)model, shadowSize);
        if (textureName.startsWith("textures")) {
            this.textureLoc = new ResourceLocation(textureName);
        }
        else {
            this.textureLoc = TwilightForestMod.getModelTexture(textureName);
        }
    }
    
    public ResourceLocation getEntityTexture(final T entity) {
        return this.textureLoc;
    }
}
