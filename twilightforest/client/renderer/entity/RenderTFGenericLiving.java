// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import twilightforest.TwilightForestMod;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.EntityLiving;

public class RenderTFGenericLiving<T extends EntityLiving> extends RenderLiving<T>
{
    private final ResourceLocation textureLoc;
    
    public RenderTFGenericLiving(final RenderManager manager, final ModelBase model, final float shadowSize, final String textureName) {
        super(manager, model, shadowSize);
        if (textureName.startsWith("textures")) {
            this.textureLoc = new ResourceLocation(textureName);
        }
        else {
            this.textureLoc = TwilightForestMod.getModelTexture(textureName);
        }
    }
    
    protected ResourceLocation getEntityTexture(final T entity) {
        return this.textureLoc;
    }
}
