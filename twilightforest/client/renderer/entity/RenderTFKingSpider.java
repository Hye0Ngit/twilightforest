// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import org.lwjgl.opengl.GL11;

public class RenderTFKingSpider extends bhm
{
    private static final bjl textureLoc;
    
    protected bjl a(final nm entity) {
        return RenderTFKingSpider.textureLoc;
    }
    
    protected void a(final oe par1EntityLivingBase, final float par2) {
        final float scale = 1.9f;
        GL11.glScalef(scale, scale, scale);
    }
    
    static {
        textureLoc = new bjl("twilightforest:textures/model/kingspider.png");
    }
}
