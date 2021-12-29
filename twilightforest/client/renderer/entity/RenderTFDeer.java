// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.RenderCow;

public class RenderTFDeer extends RenderCow
{
    private static final ResourceLocation textureLoc;
    
    public RenderTFDeer(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }
    
    protected ResourceLocation func_110775_a(final Entity par1Entity) {
        return RenderTFDeer.textureLoc;
    }
    
    static {
        textureLoc = new ResourceLocation("twilightforest:textures/model/wilddeer.png");
    }
}
