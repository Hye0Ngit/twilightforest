// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.EntityLivingBase;
import org.lwjgl.opengl.GL11;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.boss.BossStatus;
import twilightforest.entity.EntityTFUrGhast;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
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
    
    public void func_76986_a(final Entity entity, final double d, final double d1, final double d2, final float f, final float f1) {
        super.func_76986_a(entity, d, d1, d2, f, f1);
        if (entity instanceof EntityTFUrGhast && entity.field_70173_aa > 0) {
            BossStatus.func_82824_a((IBossDisplayData)entity, false);
        }
    }
    
    protected void preRenderGhast(final EntityGhast par1EntityGhast, final float par2) {
        float scaleVariable = (par1EntityGhast.field_70794_e + (par1EntityGhast.field_70791_f - par1EntityGhast.field_70794_e) * par2) / 20.0f;
        if (scaleVariable < 0.0f) {
            scaleVariable = 0.0f;
        }
        scaleVariable = 1.0f / (scaleVariable * scaleVariable * scaleVariable * scaleVariable * scaleVariable * 2.0f + 1.0f);
        final float yScale = (this.ghastScale + scaleVariable) / 2.0f;
        final float xzScale = (this.ghastScale + 1.0f / scaleVariable) / 2.0f;
        GL11.glScalef(xzScale, yScale, xzScale);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }
    
    protected void func_77041_b(final EntityLivingBase par1EntityLiving, final float par2) {
        this.preRenderGhast((EntityGhast)par1EntityLiving, par2);
    }
}
