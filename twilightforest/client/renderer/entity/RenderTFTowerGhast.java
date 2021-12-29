// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.model.ModelBase;
import twilightforest.client.model.entity.ModelTFGhast;
import net.minecraft.client.renderer.entity.RenderManager;
import twilightforest.entity.EntityTFTowerGhast;

public class RenderTFTowerGhast extends RenderTFGhast<EntityTFTowerGhast>
{
    private float ghastScale;
    
    public RenderTFTowerGhast(final RenderManager renderManager, final ModelTFGhast modelTFGhast, final float f) {
        super(renderManager, modelTFGhast, f);
        this.ghastScale = 8.0f;
    }
    
    public RenderTFTowerGhast(final RenderManager renderManager, final ModelTFGhast modelTFGhast, final float f, final float scale) {
        super(renderManager, modelTFGhast, f);
        this.ghastScale = 8.0f;
        this.ghastScale = scale;
    }
    
    protected void preRenderCallback(final EntityTFTowerGhast ghast, final float partialTicks) {
        final int attackTimer = ghast.getAttackTimer();
        final int prevAttackTimer = ghast.getPrevAttackTimer();
        float scaleVariable = (prevAttackTimer + (attackTimer - prevAttackTimer) * partialTicks) / 20.0f;
        if (scaleVariable < 0.0f) {
            scaleVariable = 0.0f;
        }
        scaleVariable = 1.0f / (scaleVariable * scaleVariable * scaleVariable * scaleVariable * scaleVariable * 2.0f + 1.0f);
        final float yScale = (this.ghastScale + scaleVariable) / 2.0f;
        final float xzScale = (this.ghastScale + 1.0f / scaleVariable) / 2.0f;
        GlStateManager.func_179152_a(xzScale, yScale, xzScale);
        GlStateManager.func_179131_c(1.0f, 1.0f, 1.0f, 1.0f);
    }
}
