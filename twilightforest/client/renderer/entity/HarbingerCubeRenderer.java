// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import twilightforest.client.model.TFModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import twilightforest.client.model.entity.HarbingerCubeModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import twilightforest.entity.monster.HarbingerCube;

public class HarbingerCubeRenderer<T extends HarbingerCube> extends MobRenderer<T, HarbingerCubeModel<T>>
{
    private static final ResourceLocation textureLoc;
    
    public HarbingerCubeRenderer(final EntityRendererProvider.Context manager) {
        super(manager, (EntityModel)new HarbingerCubeModel(manager.m_174023_(TFModelLayers.HARBINGER_CUBE)), 1.0f);
    }
    
    public ResourceLocation getTextureLocation(final HarbingerCube entity) {
        return HarbingerCubeRenderer.textureLoc;
    }
    
    protected void scale(final T entity, final PoseStack stack, final float partialTicks) {
        final float scale = 1.0f;
        stack.m_85841_(scale, scale, scale);
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("apocalypse2.png");
    }
}
