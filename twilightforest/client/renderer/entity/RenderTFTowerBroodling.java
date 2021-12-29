// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import org.lwjgl.opengl.GL11;

public class RenderTFTowerBroodling extends bhm
{
    private static final bjl textureLoc;
    
    protected bjl a(final nm entity) {
        return RenderTFTowerBroodling.textureLoc;
    }
    
    protected void a(final oe par1EntityLivingBase, final float par2) {
        final float scale = 0.7f;
        GL11.glScalef(scale, scale, scale);
    }
    
    static {
        textureLoc = new bjl("twilightforest:textures/model/towerbroodling.png");
    }
}
