// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import org.lwjgl.opengl.GL11;

public class RenderTFNagaSegment extends bgj
{
    private bbl model;
    private static final bjl textureLoc;
    
    public RenderTFNagaSegment(final bbl model, final float f) {
        this.model = model;
    }
    
    public void renderMe(final nm par1Entity, final double par2, final double par4, final double par6, final float par8, final float time) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)par2, (float)par4, (float)par6);
        GL11.glRotatef(180.0f - lr.g(par8), 0.0f, 1.0f, 0.0f);
        final float pitch = par1Entity.D + (par1Entity.B - par1Entity.D) * time;
        GL11.glRotatef(pitch, 1.0f, 0.0f, 0.0f);
        this.a(RenderTFNagaSegment.textureLoc);
        GL11.glScalef(-1.0f, -1.0f, 1.0f);
        this.model.a(par1Entity, 0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        GL11.glPopMatrix();
    }
    
    public void a(final nm par1Entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.renderMe(par1Entity, par2, par4, par6, par8, par9);
    }
    
    protected bjl a(final nm par1Entity) {
        return RenderTFNagaSegment.textureLoc;
    }
    
    static {
        textureLoc = new bjl("twilightforest:textures/model/nagasegment.png");
    }
}
