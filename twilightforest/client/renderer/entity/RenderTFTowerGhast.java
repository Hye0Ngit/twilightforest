// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import org.lwjgl.opengl.GL11;
import twilightforest.entity.EntityTFUrGhast;
import twilightforest.client.model.ModelTFGhast;

public class RenderTFTowerGhast extends RenderTFMiniGhast
{
    private float ghastScale;
    
    public RenderTFTowerGhast(final ModelTFGhast modelTFGhast, final float f) {
        super(modelTFGhast, f);
        this.ghastScale = 8.0f;
    }
    
    public RenderTFTowerGhast(final ModelTFGhast modelTFGhast, final float f, final float scale) {
        super(modelTFGhast, f);
        this.ghastScale = 8.0f;
        this.ghastScale = scale;
    }
    
    public void a(final nm entity, final double d, final double d1, final double d2, final float f, final float f1) {
        super.a(entity, d, d1, d2, f, f1);
        if (entity instanceof EntityTFUrGhast && entity.ac > 0) {
            bew.a((sf)entity, false);
        }
    }
    
    protected void preRenderGhast(final ti par1EntityGhast, final float par2) {
        float scaleVariable = (par1EntityGhast.bo + (par1EntityGhast.bp - par1EntityGhast.bo) * par2) / 20.0f;
        if (scaleVariable < 0.0f) {
            scaleVariable = 0.0f;
        }
        scaleVariable = 1.0f / (scaleVariable * scaleVariable * scaleVariable * scaleVariable * scaleVariable * 2.0f + 1.0f);
        final float yScale = (this.ghastScale + scaleVariable) / 2.0f;
        final float xzScale = (this.ghastScale + 1.0f / scaleVariable) / 2.0f;
        GL11.glScalef(xzScale, yScale, xzScale);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }
    
    protected void a(final oe par1EntityLiving, final float par2) {
        this.preRenderGhast((ti)par1EntityLiving, par2);
    }
}
