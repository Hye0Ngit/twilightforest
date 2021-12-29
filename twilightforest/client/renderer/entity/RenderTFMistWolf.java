// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import org.lwjgl.opengl.GL11;

public class RenderTFMistWolf extends bhv
{
    private static final bjl textureLoc;
    
    public RenderTFMistWolf(final bbl par1ModelBase, final bbl par2ModelBase, final float par3) {
        super(par1ModelBase, par2ModelBase, par3);
    }
    
    protected void a(final oe par1EntityLiving, final float par2) {
        final float wolfScale = 1.9f;
        GL11.glScalef(wolfScale, wolfScale, wolfScale);
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(770, 771);
        float misty = par1EntityLiving.d(0.0f) * 3.0f + 0.25f;
        misty = Math.min(1.0f, misty);
        final float smoky = par1EntityLiving.d(0.0f) * 2.0f + 0.6f;
        GL11.glColor4f(misty, misty, misty, smoky);
    }
    
    protected int a(final oe par1EntityLiving, final int par2, final float par3) {
        return -1;
    }
    
    protected bjl a(final nm par1Entity) {
        return RenderTFMistWolf.textureLoc;
    }
    
    static {
        textureLoc = new bjl("twilightforest:textures/model/mistwolf.png");
    }
}
