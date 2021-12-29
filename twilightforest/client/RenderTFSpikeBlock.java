// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;

public class RenderTFSpikeBlock extends Render
{
    private ModelBase model;
    private String textureString;
    
    public RenderTFSpikeBlock(final ModelBase modelTFSpikeBlock, final float f) {
        this.model = modelTFSpikeBlock;
    }
    
    public void renderSpikeBlock(final Entity par1Entity, final double par2, final double par4, final double par6, final float par8, final float time) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)par2, (float)par4, (float)par6);
        GL11.glRotatef(180.0f - MathHelper.func_76142_g(par8), 0.0f, 1.0f, 0.0f);
        final float pitch = par1Entity.field_70127_C + (par1Entity.field_70125_A - par1Entity.field_70127_C) * time;
        GL11.glRotatef(pitch, 1.0f, 0.0f, 0.0f);
        this.func_76985_a(par1Entity.func_70073_O());
        GL11.glScalef(-1.0f, -1.0f, 1.0f);
        this.model.func_78088_a(par1Entity, 0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        GL11.glPopMatrix();
    }
    
    public void func_76986_a(final Entity par1Entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.renderSpikeBlock(par1Entity, par2, par4, par6, par8, par9);
    }
}
