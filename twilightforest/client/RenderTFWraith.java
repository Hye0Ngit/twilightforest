// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import org.lwjgl.opengl.GL11;

public class RenderTFWraith extends bcc
{
    public RenderTFWraith(final aww modelbiped, final float f) {
        super(modelbiped, f);
    }
    
    protected int a(final md entityliving, final int i, final float f) {
        this.a(this.i);
        if (i == 1) {
            this.a("/twilightforest/ghost.png");
            GL11.glEnable(3042);
            GL11.glDisable(3008);
            GL11.glBlendFunc(1, 1);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.5f);
            return 1;
        }
        return 0;
    }
}
