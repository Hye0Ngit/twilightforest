// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import org.lwjgl.opengl.GL11;

public class RenderTFWraith extends bgr
{
    private static final bjl textureWraith;
    private static final bjl textureCrown;
    
    public RenderTFWraith(final bbg modelbiped, final float f) {
        super(modelbiped, f);
    }
    
    protected int a(final oe entityliving, final int i, final float f) {
        this.a(this.i);
        if (i == 1) {
            this.a(RenderTFWraith.textureWraith);
            GL11.glEnable(3042);
            GL11.glDisable(3008);
            GL11.glBlendFunc(1, 1);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.5f);
            return 1;
        }
        return 0;
    }
    
    protected bjl a(final nm par1Entity) {
        return RenderTFWraith.textureCrown;
    }
    
    static {
        textureWraith = new bjl("twilightforest:textures/model/ghost.png");
        textureCrown = new bjl("twilightforest:textures/model/ghost-crown.png");
    }
}
