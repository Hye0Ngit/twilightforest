// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import org.lwjgl.opengl.GL11;
import twilightforest.tileentity.TileEntityTFMoonworm;
import net.minecraft.tileentity.TileEntity;
import twilightforest.client.model.ModelTFMoonworm;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class TileEntityTFMoonwormRenderer extends TileEntitySpecialRenderer
{
    private ModelTFMoonworm moonwormModel;
    
    public TileEntityTFMoonwormRenderer() {
        this.moonwormModel = new ModelTFMoonworm();
    }
    
    public void func_76894_a(final TileEntity tileentity, final double d, final double d1, final double d2, final float f) {
        this.renderTileEntityFireflyAt((TileEntityTFMoonworm)tileentity, d, d1, d2, f);
    }
    
    private void renderTileEntityFireflyAt(final TileEntityTFMoonworm tileentity, final double d, final double d1, final double d2, final float partialTime) {
        GL11.glPushMatrix();
        final int facing = tileentity.func_70322_n();
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
        this.func_76897_a("/mods/twilightforest/textures/model/moonworm.png");
        GL11.glScalef(1.0f, -1.0f, -1.0f);
        this.moonwormModel.setLivingAnimations(tileentity, partialTime);
        this.moonwormModel.render(0.0625f);
        GL11.glPopMatrix();
    }
}
