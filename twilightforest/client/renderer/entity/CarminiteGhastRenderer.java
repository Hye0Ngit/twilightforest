// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.world.entity.LivingEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import twilightforest.client.model.entity.TFGhastModel;
import twilightforest.entity.monster.CarminiteGhastguard;

public class CarminiteGhastRenderer<T extends CarminiteGhastguard, M extends TFGhastModel<T>> extends TFGhastRenderer<T, M>
{
    private float ghastScale;
    
    public CarminiteGhastRenderer(final EntityRendererProvider.Context renderManager, final M modelTFGhast, final float f) {
        super(renderManager, modelTFGhast, f);
        this.ghastScale = 8.0f;
    }
    
    public CarminiteGhastRenderer(final EntityRendererProvider.Context renderManager, final M modelTFGhast, final float f, final float scale) {
        super(renderManager, modelTFGhast, f);
        this.ghastScale = 8.0f;
        this.ghastScale = scale;
    }
    
    protected void scale(final T ghast, final PoseStack stack, final float partialTicks) {
        final int attackTimer = ghast.getAttackTimer();
        final int prevAttackTimer = ghast.getPrevAttackTimer();
        float scaleVariable = (prevAttackTimer + (attackTimer - prevAttackTimer) * partialTicks) / 20.0f;
        if (scaleVariable < 0.0f) {
            scaleVariable = 0.0f;
        }
        scaleVariable = 1.0f / (scaleVariable * scaleVariable * scaleVariable * scaleVariable * scaleVariable * 2.0f + 1.0f);
        final float yScale = (this.ghastScale + scaleVariable) / 2.0f;
        final float xzScale = (this.ghastScale + 1.0f / scaleVariable) / 2.0f;
        stack.m_85841_(xzScale, yScale, xzScale);
    }
}
