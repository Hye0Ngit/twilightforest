// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import twilightforest.TwilightForestMod;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.entity.passive.EntityTFBunny;
import net.minecraft.client.renderer.entity.RenderLiving;

public class RenderTFBunny extends RenderLiving<EntityTFBunny>
{
    private final ResourceLocation textureLocDutch;
    private final ResourceLocation textureLocWhite;
    private final ResourceLocation textureLocBrown;
    
    public RenderTFBunny(final RenderManager manager, final ModelBase model, final float shadowSize) {
        super(manager, model, shadowSize);
        this.textureLocDutch = TwilightForestMod.getModelTexture("bunnydutch.png");
        this.textureLocWhite = TwilightForestMod.getModelTexture("bunnywhite.png");
        this.textureLocBrown = TwilightForestMod.getModelTexture("bunnybrown.png");
    }
    
    protected ResourceLocation getEntityTexture(final EntityTFBunny entity) {
        switch (entity.getBunnyType()) {
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
