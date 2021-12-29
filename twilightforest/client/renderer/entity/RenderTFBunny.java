// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.entity.passive.EntityTFBunny;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.RenderLiving;

public class RenderTFBunny extends RenderLiving
{
    final ResourceLocation textureLocDutch;
    final ResourceLocation textureLocWhite;
    final ResourceLocation textureLocBrown;
    
    public RenderTFBunny(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
        this.textureLocDutch = new ResourceLocation("twilightforest:textures/model/bunnydutch.png");
        this.textureLocWhite = new ResourceLocation("twilightforest:textures/model/bunnywhite.png");
        this.textureLocBrown = new ResourceLocation("twilightforest:textures/model/bunnybrown.png");
    }
    
    protected ResourceLocation func_110775_a(final Entity par1Entity) {
        if (!(par1Entity instanceof EntityTFBunny)) {
            return this.textureLocDutch;
        }
        switch (((EntityTFBunny)par1Entity).getBunnyType()) {
            default: {
                return this.textureLocDutch;
            }
            case 2: {
                return this.textureLocWhite;
            }
            case 3: {
                return this.textureLocBrown;
            }
        }
    }
}
