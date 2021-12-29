// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.LivingEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import twilightforest.client.model.entity.TFGhastModel;
import twilightforest.entity.CarminiteGhastguardEntity;

public class CarminiteGhastRenderer<T extends CarminiteGhastguardEntity, M extends TFGhastModel<T>> extends TFGhastRenderer<T, M>
{
    private float ghastScale;
    
    public CarminiteGhastRenderer(final EntityRendererManager renderManager, final M modelTFGhast, final float f) {
        super(renderManager, modelTFGhast, f);
        this.ghastScale = 8.0f;
    }
    
    public CarminiteGhastRenderer(final EntityRendererManager renderManager, final M modelTFGhast, final float f, final float scale) {
        super(renderManager, modelTFGhast, f);
        this.ghastScale = 8.0f;
        this.ghastScale = scale;
    }
    
    protected void preRenderCallback(final T ghast, final MatrixStack stack, final float partialTicks) {
        final int attackTimer = ghast.getAttackTimer();
        final int prevAttackTimer = ghast.getPrevAttackTimer();
        float scaleVariable = (prevAttackTimer + (attackTimer - prevAttackTimer) * partialTicks) / 20.0f;
        if (scaleVariable < 0.0f) {
            scaleVariable = 0.0f;
        }
        scaleVariable = 1.0f / (scaleVariable * scaleVariable * scaleVariable * scaleVariable * scaleVariable * 2.0f + 1.0f);
        final float yScale = (this.ghastScale + scaleVariable) / 2.0f;
        final float xzScale = (this.ghastScale + 1.0f / scaleVariable) / 2.0f;
        stack.func_227862_a_(xzScale, yScale, xzScale);
    }
}
