// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import org.lwjgl.opengl.GL11;

public class RenderTFMinoshroom extends bbr
{
    public RenderTFMinoshroom(final awp par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }
    
    protected void renderMooshroomEquippedItems(final md par1EntityLiving, final float par2) {
        super.c(par1EntityLiving, par2);
        this.a("/terrain.png");
        GL11.glEnable(2884);
        GL11.glPushMatrix();
        GL11.glScalef(1.0f, -1.0f, 1.0f);
        GL11.glTranslatef(0.2f, 0.375f, 0.5f);
        GL11.glRotatef(42.0f, 0.0f, 1.0f, 0.0f);
        this.c.a((amj)amj.aj, 0, 1.0f);
        GL11.glTranslatef(0.1f, 0.0f, -0.6f);
        GL11.glRotatef(42.0f, 0.0f, 1.0f, 0.0f);
        this.c.a((amj)amj.aj, 0, 1.0f);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        ((awp)this.i).c.c(0.0625f);
        GL11.glScalef(1.0f, -1.0f, 1.0f);
        GL11.glTranslatef(0.0f, 1.0f, 0.0f);
        GL11.glRotatef(12.0f, 0.0f, 1.0f, 0.0f);
        this.c.a((amj)amj.aj, 0, 1.0f);
        GL11.glPopMatrix();
        GL11.glDisable(2884);
    }
    
    protected void c(final md par1EntityLiving, final float par2) {
        this.renderMooshroomEquippedItems(par1EntityLiving, par2);
    }
}
