// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import org.lwjgl.opengl.GL11;

public class RenderTFMistWolf extends bcr
{
    public RenderTFMistWolf(final awt par1ModelBase, final awt par2ModelBase, final float par3) {
        super(par1ModelBase, par2ModelBase, par3);
    }
    
    protected void a(final md par1EntityLiving, final float par2) {
        final float wolfScale = 1.75f;
        GL11.glScalef(wolfScale, wolfScale, wolfScale);
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(770, 771);
        float misty = par1EntityLiving.c(0.0f) * 3.0f + 0.25f;
        misty = Math.min(1.0f, misty);
        final float smoky = par1EntityLiving.c(0.0f) * 2.0f + 0.6f;
        GL11.glColor4f(misty, misty, misty, smoky);
    }
    
    protected int a(final md par1EntityLiving, final int par2, final float par3) {
        return -1;
    }
}
