import org.lwjgl.opengl.GL11;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TileEntityTFFireflyRenderer extends du
{
    private ModelTFFirefly fireflyModel;
    
    public TileEntityTFFireflyRenderer() {
        this.fireflyModel = new ModelTFFirefly();
    }
    
    public void a(final bq tileentity, final double d, final double d1, final double d2, final float f) {
        this.renderTileEntityFireflyAt((TileEntityTFFirefly)tileentity, d, d1, d2, f);
    }
    
    private void renderTileEntityFireflyAt(final TileEntityTFFirefly tileentity, final double d, final double d1, final double d2, final float f) {
        GL11.glPushMatrix();
        final int i = tileentity.f();
        float rotX = 90.0f;
        float rotZ = 0.0f;
        if (i == 3) {
            rotZ = 0.0f;
        }
        if (i == 4) {
            rotZ = 180.0f;
        }
        if (i == 1) {
            rotZ = -90.0f;
        }
        if (i == 2) {
            rotZ = 90.0f;
        }
        if (i == 5) {
            rotX = 0.0f;
        }
        if (i == 6) {
            rotX = 180.0f;
        }
        GL11.glTranslatef((float)d + 0.5f, (float)d1 + 0.5f, (float)d2 + 0.5f);
        GL11.glRotatef(rotX, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(rotZ, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef((float)tileentity.currentYaw, 0.0f, 1.0f, 0.0f);
        this.a("/twilightforest/firefly-tiny.png");
        GL11.glPushMatrix();
        GL11.glScalef(1.0f, -1.0f, -1.0f);
        GL11.glColorMask(true, true, true, true);
        GL11.glDisable(3042);
        this.fireflyModel.render(0.0625f);
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(770, 1);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, tileentity.glowIntensity);
        this.fireflyModel.glow.a(0.0625f);
        GL11.glDisable(3042);
        GL11.glEnable(3008);
        GL11.glPopMatrix();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glPopMatrix();
    }
}
