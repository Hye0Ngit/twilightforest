// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import org.lwjgl.opengl.GL11;
import twilightforest.entity.EntityTFCharmEffect;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderTFCharm extends bgj
{
    private mr itemIcon;
    
    public RenderTFCharm(final mr par1) {
        this.itemIcon = par1;
    }
    
    public void a(final nm par1Entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        if (par1Entity instanceof EntityTFCharmEffect) {
            final EntityTFCharmEffect charm = (EntityTFCharmEffect)par1Entity;
            if (charm.getItemID() > 0) {
                this.itemIcon = yb.g[charm.getItemID()].b_(0);
            }
        }
        GL11.glPushMatrix();
        GL11.glTranslatef((float)par2, (float)par4, (float)par6);
        GL11.glEnable(32826);
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        this.b(par1Entity);
        final bfn var10 = bfn.a;
        this.func_77026_a(var10, this.itemIcon);
        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }
    
    private void func_77026_a(final bfn par1Tessellator, final mr par2Icon) {
        final float f = par2Icon.c();
        final float f2 = par2Icon.d();
        final float f3 = par2Icon.e();
        final float f4 = par2Icon.f();
        final float f5 = 1.0f;
        final float f6 = 0.5f;
        final float f7 = 0.25f;
        GL11.glRotatef(180.0f - this.b.j, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-this.b.k, 1.0f, 0.0f, 0.0f);
        par1Tessellator.b();
        par1Tessellator.b(0.0f, 1.0f, 0.0f);
        par1Tessellator.a((double)(0.0f - f6), (double)(0.0f - f7), 0.0, (double)f, (double)f4);
        par1Tessellator.a((double)(f5 - f6), (double)(0.0f - f7), 0.0, (double)f2, (double)f4);
        par1Tessellator.a((double)(f5 - f6), (double)(f5 - f7), 0.0, (double)f2, (double)f3);
        par1Tessellator.a((double)(0.0f - f6), (double)(f5 - f7), 0.0, (double)f, (double)f3);
        par1Tessellator.a();
    }
    
    protected bjl a(final nm par1Entity) {
        return bih.c;
    }
}
