// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.client.model.entity.HarbingerCubeModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import twilightforest.entity.HarbingerCubeEntity;

public class HarbingerCubeRenderer<T extends HarbingerCubeEntity> extends MobRenderer<T, HarbingerCubeModel<T>>
{
    private static final ResourceLocation textureLoc;
    
    public HarbingerCubeRenderer(final EntityRendererManager manager) {
        super(manager, (EntityModel)new HarbingerCubeModel(), 1.0f);
    }
    
    public ResourceLocation getEntityTexture(final HarbingerCubeEntity entity) {
        return HarbingerCubeRenderer.textureLoc;
    }
    
    protected void preRenderCallback(final T entity, final MatrixStack stack, final float partialTicks) {
        final float scale = 1.0f;
        stack.func_227862_a_(scale, scale, scale);
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("apocalypse2.png");
    }
}
