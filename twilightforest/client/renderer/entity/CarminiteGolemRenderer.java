// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.world.entity.Entity;
import com.mojang.math.Vector3f;
import net.minecraft.world.entity.LivingEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import twilightforest.client.model.entity.CarminiteGolemModel;
import twilightforest.entity.monster.CarminiteGolem;

public class CarminiteGolemRenderer<T extends CarminiteGolem, M extends CarminiteGolemModel<T>> extends MobRenderer<T, M>
{
    private static final ResourceLocation textureLoc;
    
    public CarminiteGolemRenderer(final EntityRendererProvider.Context manager, final M model, final float shadowSize) {
        super(manager, (EntityModel)model, shadowSize);
    }
    
    protected void setupRotations(final T entity, final PoseStack ms, final float ageInTicks, final float rotationYaw, final float partialTicks) {
        super.m_7523_((LivingEntity)entity, ms, ageInTicks, rotationYaw, partialTicks);
        if (entity.f_20924_ >= 0.01) {
            final float f = 13.0f;
            final float f2 = entity.f_20925_ - entity.f_20924_ * (1.0f - partialTicks) + 6.0f;
            final float f3 = (Math.abs(f2 % 13.0f - 6.5f) - 3.25f) / 3.25f;
            ms.m_85845_(Vector3f.f_122227_.m_122240_(6.5f * f3));
        }
    }
    
    public ResourceLocation getTextureLocation(final T entity) {
        return CarminiteGolemRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("carminitegolem.png");
    }
}
