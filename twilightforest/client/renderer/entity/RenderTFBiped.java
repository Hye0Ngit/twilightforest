// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.RenderBiped;

public class RenderTFBiped extends RenderBiped
{
    private final ResourceLocation textureLoc;
    
    public RenderTFBiped(final ModelBiped modelBiped, final float scale, final String textureName) {
        super(modelBiped, scale);
        if (textureName.startsWith("textures")) {
            this.textureLoc = new ResourceLocation(textureName);
        }
        else {
            this.textureLoc = new ResourceLocation("twilightforest:textures/model/" + textureName);
        }
    }
    
    protected ResourceLocation func_110775_a(final Entity par1Entity) {
        return this.textureLoc;
    }
}
