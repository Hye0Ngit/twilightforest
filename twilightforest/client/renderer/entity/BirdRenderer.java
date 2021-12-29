// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.util.Mth;
import twilightforest.TwilightForestMod;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.model.EntityModel;
import twilightforest.entity.passive.Bird;

public class BirdRenderer<T extends Bird, M extends EntityModel<T>> extends MobRenderer<T, M>
{
    private final ResourceLocation textureLoc;
    
    public BirdRenderer(final EntityRendererProvider.Context manager, final M model, final float shadowSize, final String textureName) {
        super(manager, (EntityModel)model, shadowSize);
        this.textureLoc = TwilightForestMod.getModelTexture(textureName);
    }
    
    protected float getBob(final T living, final float time) {
        final float var3 = living.lastFlapLength + (living.flapLength - living.lastFlapLength) * time;
        final float var4 = living.lastFlapIntensity + (living.flapIntensity - living.lastFlapIntensity) * time;
        return (Mth.m_14031_(var3) + 1.0f) * var4;
    }
    
    public ResourceLocation getTextureLocation(final T entity) {
        return this.textureLoc;
    }
}
