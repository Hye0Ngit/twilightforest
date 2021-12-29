// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.RenderSheep;

public class RenderTFBighorn extends RenderSheep
{
    private static final ResourceLocation textureLoc;
    
    public RenderTFBighorn(final ModelBase par1ModelBase, final ModelBase par2ModelBase, final float par3) {
        super(par1ModelBase, par2ModelBase, par3);
    }
    
    protected ResourceLocation func_110775_a(final Entity par1Entity) {
        return RenderTFBighorn.textureLoc;
    }
    
    static {
        textureLoc = new ResourceLocation("twilightforest:textures/model/bighorn.png");
    }
}
