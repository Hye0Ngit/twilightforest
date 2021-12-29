// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer;

import org.lwjgl.opengl.GL11;
import twilightforest.tileentity.TileEntityTFCicada;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import twilightforest.client.model.ModelTFCicada;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class TileEntityTFCicadaRenderer extends TileEntitySpecialRenderer
{
    private ModelTFCicada cicadaModel;
    private static final ResourceLocation textureLoc;
    
    public TileEntityTFCicadaRenderer() {
        this.cicadaModel = new ModelTFCicada();
    }
    
    public void func_147500_a(final TileEntity tileentity, final double d, final double d1, final double d2, final float f) {
        this.renderTileEntityCicadaAt((TileEntityTFCicada)tileentity, d, d1, d2, f);
    }
    
    private void renderTileEntityCicadaAt(final TileEntityTFCicada tileentity, final double d, final double d1, final double d2, final float f) {
        GL11.glPushMatrix();
        final int facing = tileentity.func_145832_p();
        float rotX = 90.0f;
        float rotZ = 0.0f;
        if (facing == 3) {
            rotZ = 0.0f;
        }
        if (facing == 4) {
            rotZ = 180.0f;
        }
        if (facing == 1) {
            rotZ = -90.0f;
        }
        if (facing == 2) {
            rotZ = 90.0f;
        }
        if (facing == 5) {
            rotX = 0.0f;
        }
        if (facing == 6) {
            rotX = 180.0f;
        }
        GL11.glTranslatef((float)d + 0.5f, (float)d1 + 0.5f, (float)d2 + 0.5f);
        GL11.glRotatef(rotX, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(rotZ, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef((float)tileentity.currentYaw, 0.0f, 1.0f, 0.0f);
        this.func_147499_a(TileEntityTFCicadaRenderer.textureLoc);
        GL11.glPushMatrix();
        GL11.glScalef(1.0f, -1.0f, -1.0f);
        this.cicadaModel.render(0.0625f);
        GL11.glPopMatrix();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glPopMatrix();
    }
    
    static {
        textureLoc = new ResourceLocation("twilightforest:textures/model/cicada-model.png");
    }
}
