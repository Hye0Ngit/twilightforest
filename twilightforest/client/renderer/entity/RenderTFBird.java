// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import twilightforest.TwilightForestMod;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.entity.passive.EntityTFBird;
import net.minecraft.client.renderer.entity.RenderLiving;

public class RenderTFBird extends RenderLiving<EntityTFBird>
{
    private final ResourceLocation textureLoc;
    
    public RenderTFBird(final RenderManager manager, final ModelBase model, final float shadowSize, final String textureName) {
        super(manager, model, shadowSize);
        this.textureLoc = TwilightForestMod.getModelTexture(textureName);
    }
    
    protected float handleRotationFloat(final EntityTFBird living, final float time) {
        final float var3 = living.lastFlapLength + (living.flapLength - living.lastFlapLength) * time;
        final float var4 = living.lastFlapIntensity + (living.flapIntensity - living.lastFlapIntensity) * time;
        return (MathHelper.func_76126_a(var3) + 1.0f) * var4;
    }
    
    protected ResourceLocation getEntityTexture(final EntityTFBird entity) {
        return this.textureLoc;
    }
}
