// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import twilightforest.TwilightForestMod;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.Mob;

public class TFBipedRenderer<T extends Mob, M extends HumanoidModel<T>> extends HumanoidMobRenderer<T, M>
{
    private final ResourceLocation textureLoc;
    
    public TFBipedRenderer(final EntityRendererProvider.Context manager, final M modelBiped, final float shadowSize, final String textureName) {
        super(manager, (HumanoidModel)modelBiped, shadowSize);
        if (textureName.startsWith("textures")) {
            this.textureLoc = new ResourceLocation(textureName);
        }
        else {
            this.textureLoc = TwilightForestMod.getModelTexture(textureName);
        }
    }
    
    public TFBipedRenderer(final EntityRendererProvider.Context manager, final M modelBiped, final M armorModel1, final M armorModel2, final float shadowSize, final String textureName) {
        this(manager, modelBiped, shadowSize, textureName);
        this.m_115326_((RenderLayer)new HumanoidArmorLayer((RenderLayerParent)this, (HumanoidModel)armorModel1, (HumanoidModel)armorModel2));
    }
    
    public ResourceLocation m_5478_(final T entity) {
        return this.textureLoc;
    }
}
