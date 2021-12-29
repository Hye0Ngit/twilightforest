import java.nio.FloatBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class RenderTFTinyFirefly extends rg
{
    ModelTFTinyFirefly fireflyModel;
    
    public RenderTFTinyFirefly() {
        this.fireflyModel = new ModelTFTinyFirefly();
    }
    
    public void doRenderTinyFirefly(final EntityTFTinyFirefly firefly, final double x, final double y, final double z, final float f, final float f1) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x + 0.5f, (float)y + 0.5f, (float)z + 0.5f);
        final FloatBuffer modelview = BufferUtils.createFloatBuffer(16);
        GL11.glGetFloat(2982, modelview);
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                final int index = i * 4 + j;
                if (i == j) {
                    modelview.put(index, 1.0f);
                }
                else {
                    modelview.put(index, 0.0f);
                }
            }
        }
        GL11.glLoadMatrix(modelview);
        this.a("/twilightforest/firefly-tiny.png");
        GL11.glColorMask(true, true, true, true);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 1);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, firefly.getGlowBrightness());
        this.fireflyModel.glow1.a(0.0625f * firefly.glowSize);
        GL11.glDisable(3042);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glPopMatrix();
    }
    
    public void a(final ia entity, final double d, final double d1, final double d2, final float f, final float f1) {
        this.doRenderTinyFirefly((EntityTFTinyFirefly)entity, d, d1, d2, f, f1);
    }
}
