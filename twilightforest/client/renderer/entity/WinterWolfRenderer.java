// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.WolfRenderer;

public class WinterWolfRenderer extends WolfRenderer
{
    private static final ResourceLocation textureLoc;
    
    public WinterWolfRenderer(final EntityRendererManager manager) {
        super(manager);
        this.field_76989_e = 1.0f;
    }
    
    protected void preRenderCallback(final WolfEntity entity, final MatrixStack stack, final float partialTicks) {
        final float wolfScale = 1.9f;
        stack.func_227862_a_(wolfScale, wolfScale, wolfScale);
    }
    
    public ResourceLocation func_110775_a(final WolfEntity entity) {
        return WinterWolfRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("winterwolf.png");
    }
}
