// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;
import net.minecraft.entity.Entity;
import twilightforest.client.model.ModelTFCubeOfAnnihilation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;

public class RenderTFCubeOfAnnihilation extends Render
{
    private ModelBase model;
    private static final ResourceLocation textureLoc;
    
    public RenderTFCubeOfAnnihilation() {
        this.model = new ModelTFCubeOfAnnihilation();
    }
    
    public void renderSpikeBlock(final Entity entity, final double x, final double y, final double z, final float par8, final float time) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x, (float)y, (float)z);
        this.func_110777_b(entity);
        GL11.glScalef(-1.0f, -1.0f, 1.0f);
        GL11.glRotatef(MathHelper.func_76142_g(((float)x + (float)z + entity.field_70173_aa + time) * 11.0f), 0.0f, 1.0f, 0.0f);
        GL11.glDisable(2896);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glTranslatef(0.0f, -0.5f, 0.0f);
        this.model.func_78088_a(entity, 0.0f, 0.0f, 0.0f, 0.0f, time, 0.03125f);
        GL11.glEnable(2896);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
    }
    
    public void func_76986_a(final Entity par1Entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.renderSpikeBlock(par1Entity, par2, par4, par6, par8, par9);
    }
    
    protected ResourceLocation func_110775_a(final Entity par1Entity) {
        return RenderTFCubeOfAnnihilation.textureLoc;
    }
    
    static {
        textureLoc = new ResourceLocation("twilightforest:textures/model/cubeofannihilation.png");
    }
}
