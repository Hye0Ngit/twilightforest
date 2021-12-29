// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.entity.passive.EntityTFTinyBird;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;

public class RenderTFTinyBird extends RenderTFBird
{
    final ResourceLocation textureLocSparrow;
    final ResourceLocation textureLocFinch;
    final ResourceLocation textureLocCardinal;
    final ResourceLocation textureLocBluebird;
    
    public RenderTFTinyBird(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2, "tinybirdbrown.png");
        this.textureLocSparrow = new ResourceLocation("twilightforest:textures/model/tinybirdbrown.png");
        this.textureLocFinch = new ResourceLocation("twilightforest:textures/model/tinybirdgold.png");
        this.textureLocCardinal = new ResourceLocation("twilightforest:textures/model/tinybirdred.png");
        this.textureLocBluebird = new ResourceLocation("twilightforest:textures/model/tinybirdblue.png");
    }
    
    @Override
    protected ResourceLocation func_110775_a(final Entity par1Entity) {
        if (!(par1Entity instanceof EntityTFTinyBird)) {
            return this.textureLocSparrow;
        }
        switch (((EntityTFTinyBird)par1Entity).getBirdType()) {
            default: {
                return this.textureLocSparrow;
            }
            case 1: {
                return this.textureLocBluebird;
            }
            case 2: {
                return this.textureLocCardinal;
            }
            case 3: {
                return this.textureLocFinch;
            }
        }
    }
}
