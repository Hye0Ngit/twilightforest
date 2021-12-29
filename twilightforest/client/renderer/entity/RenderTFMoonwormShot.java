// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import org.lwjgl.opengl.GL11;
import twilightforest.client.model.ModelTFMoonworm;

public class RenderTFMoonwormShot extends bgj
{
    private ModelTFMoonworm wormModel;
    private static final bjl textureLoc;
    
    public RenderTFMoonwormShot() {
        this.wormModel = new ModelTFMoonworm();
        this.d = 0.5f;
    }
    
    public void a(final nm var1, final double x, final double y, final double z, final float var8, final float partialTick) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x, (float)y, (float)z);
        GL11.glRotatef(90.0f, 1.0f, 0.0f, 1.0f);
        this.wormModel.render(0.075f);
        GL11.glPopMatrix();
    }
    
    protected bjl a(final nm par1Entity) {
        return RenderTFMoonwormShot.textureLoc;
    }
    
    static {
        textureLoc = new bjl("twilightforest:textures/model/moonworm.png");
    }
}
