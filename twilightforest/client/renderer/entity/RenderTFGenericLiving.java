// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.RenderLiving;

public class RenderTFGenericLiving extends RenderLiving
{
    final ResourceLocation textureLoc;
    
    public RenderTFGenericLiving(final ModelBase par1ModelBase, final float par2, final String textureName) {
        super(par1ModelBase, par2);
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
