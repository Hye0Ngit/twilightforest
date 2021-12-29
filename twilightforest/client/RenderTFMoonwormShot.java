// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import org.lwjgl.opengl.GL11;
import twilightforest.client.model.ModelTFMoonworm;

public class RenderTFMoonwormShot extends bgt
{
    private ModelTFMoonworm wormModel;
    
    public RenderTFMoonwormShot() {
        this.wormModel = new ModelTFMoonworm();
        this.d = 0.5f;
    }
    
    public void a(final mp var1, final double x, final double y, final double z, final float var8, final float partialTick) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x, (float)y, (float)z);
        GL11.glRotatef(90.0f, 1.0f, 0.0f, 1.0f);
        this.a("/mods/twilightforest/textures/model/moonworm.png");
        this.wormModel.render(0.075f);
        GL11.glPopMatrix();
    }
}
