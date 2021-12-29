// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import org.lwjgl.opengl.GL11;

public class RenderTFMinoshroom extends bgr
{
    private static final bjl textureLoc;
    
    public RenderTFMinoshroom(final bbg par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }
    
    protected void renderMooshroomEquippedItems(final oe par1EntityLiving, final float par2) {
        super.c(par1EntityLiving, par2);
        this.a(bih.b);
        GL11.glEnable(2884);
        GL11.glPushMatrix();
        GL11.glScalef(1.0f, -1.0f, 1.0f);
        GL11.glTranslatef(0.2f, 0.375f, 0.5f);
        GL11.glRotatef(42.0f, 0.0f, 1.0f, 0.0f);
        this.c.a((aqw)aqw.al, 0, 1.0f);
        GL11.glTranslatef(0.1f, 0.0f, -0.6f);
        GL11.glRotatef(42.0f, 0.0f, 1.0f, 0.0f);
        this.c.a((aqw)aqw.al, 0, 1.0f);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        ((bbg)this.i).c.c(0.0625f);
        GL11.glScalef(1.0f, -1.0f, 1.0f);
        GL11.glTranslatef(0.0f, 1.0f, 0.0f);
        GL11.glRotatef(12.0f, 0.0f, 1.0f, 0.0f);
        this.c.a((aqw)aqw.al, 0, 1.0f);
        GL11.glPopMatrix();
        GL11.glDisable(2884);
    }
    
    protected void c(final oe par1EntityLiving, final float par2) {
        this.renderMooshroomEquippedItems(par1EntityLiving, par2);
    }
    
    protected bjl a(final nm par1Entity) {
        return RenderTFMinoshroom.textureLoc;
    }
    
    static {
        textureLoc = new bjl("twilightforest:textures/model/minoshroomtaur.png");
    }
}
