// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import twilightforest.TwilightForestMod;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.MobEntity;

public class TFBipedRenderer<T extends MobEntity, M extends BipedModel<T>> extends BipedRenderer<T, M>
{
    private final ResourceLocation textureLoc;
    
    public TFBipedRenderer(final EntityRendererManager manager, final M modelBiped, final float shadowSize, final String textureName) {
        super(manager, (BipedModel)modelBiped, shadowSize);
        if (textureName.startsWith("textures")) {
            this.textureLoc = new ResourceLocation(textureName);
        }
        else {
            this.textureLoc = TwilightForestMod.getModelTexture(textureName);
        }
    }
    
    public TFBipedRenderer(final EntityRendererManager manager, final M modelBiped, final M armorModel1, final M armorModel2, final float shadowSize, final String textureName) {
        this(manager, modelBiped, shadowSize, textureName);
        this.func_177094_a((LayerRenderer)new BipedArmorLayer((IEntityRenderer)this, (BipedModel)armorModel1, (BipedModel)armorModel2));
    }
    
    public ResourceLocation func_110775_a(final T entity) {
        return this.textureLoc;
    }
}
