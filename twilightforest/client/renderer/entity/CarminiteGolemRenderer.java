// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.entity.LivingEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import twilightforest.client.model.entity.CarminiteGolemModel;
import twilightforest.entity.CarminiteGolemEntity;

public class CarminiteGolemRenderer<T extends CarminiteGolemEntity, M extends CarminiteGolemModel<T>> extends MobRenderer<T, M>
{
    private static final ResourceLocation textureLoc;
    
    public CarminiteGolemRenderer(final EntityRendererManager manager, final M model, final float shadowSize) {
        super(manager, (EntityModel)model, shadowSize);
    }
    
    protected void applyRotations(final T entity, final MatrixStack ms, final float ageInTicks, final float rotationYaw, final float partialTicks) {
        super.func_225621_a_((LivingEntity)entity, ms, ageInTicks, rotationYaw, partialTicks);
        if (entity.field_70721_aZ >= 0.01) {
            final float f = 13.0f;
            final float f2 = entity.field_184619_aG - entity.field_70721_aZ * (1.0f - partialTicks) + 6.0f;
            final float f3 = (Math.abs(f2 % 13.0f - 6.5f) - 3.25f) / 3.25f;
            ms.func_227863_a_(Vector3f.field_229183_f_.func_229187_a_(6.5f * f3));
        }
    }
    
    public ResourceLocation getEntityTexture(final T entity) {
        return CarminiteGolemRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("carminitegolem.png");
    }
}
