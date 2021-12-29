// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import twilightforest.TwilightForestMod;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.EntityLiving;

public class RenderTFBiped<T extends EntityLiving> extends RenderBiped<T>
{
    private final ResourceLocation textureLoc;
    
    public RenderTFBiped(final RenderManager manager, final ModelBiped modelBiped, final float shadowSize, final String textureName) {
        super(manager, modelBiped, shadowSize);
        this.func_177094_a((LayerRenderer)new LayerBipedArmor((RenderLivingBase)this));
        if (textureName.startsWith("textures")) {
            this.textureLoc = new ResourceLocation(textureName);
        }
        else {
            this.textureLoc = TwilightForestMod.getModelTexture(textureName);
        }
    }
    
    protected ResourceLocation func_110775_a(final T entity) {
        return this.textureLoc;
    }
}
