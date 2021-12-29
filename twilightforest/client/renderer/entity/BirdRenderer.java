// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;
import twilightforest.TwilightForestMod;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import twilightforest.entity.passive.BirdEntity;

public class BirdRenderer<T extends BirdEntity, M extends EntityModel<T>> extends MobRenderer<T, M>
{
    private final ResourceLocation textureLoc;
    
    public BirdRenderer(final EntityRendererManager manager, final M model, final float shadowSize, final String textureName) {
        super(manager, (EntityModel)model, shadowSize);
        this.textureLoc = TwilightForestMod.getModelTexture(textureName);
    }
    
    protected float handleRotationFloat(final T living, final float time) {
        final float var3 = living.lastFlapLength + (living.flapLength - living.lastFlapLength) * time;
        final float var4 = living.lastFlapIntensity + (living.flapIntensity - living.lastFlapIntensity) * time;
        return (MathHelper.func_76126_a(var3) + 1.0f) * var4;
    }
    
    public ResourceLocation getEntityTexture(final T entity) {
        return this.textureLoc;
    }
}
