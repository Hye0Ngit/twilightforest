// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import org.lwjgl.opengl.GL11;
import twilightforest.EntityTFCharmEffect;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderTFCharm extends bbk
{
    private int itemIconIndex;
    
    public RenderTFCharm(final int par1) {
        this.itemIconIndex = par1;
    }
    
    public void a(final lq par1Entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        if (par1Entity instanceof EntityTFCharmEffect) {
            final EntityTFCharmEffect charm = (EntityTFCharmEffect)par1Entity;
            if (charm.getItemID() > 0) {
                this.itemIconIndex = uk.e[charm.getItemID()].b(0);
            }
        }
        GL11.glPushMatrix();
        GL11.glTranslatef((float)par2, (float)par4, (float)par6);
        GL11.glEnable(32826);
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        this.a("/twilightforest/items.png");
        final bao var10 = bao.a;
        this.func_77026_a(var10, this.itemIconIndex);
        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }
    
    private void func_77026_a(final bao par1Tessellator, final int par2) {
        final float var3 = (par2 % 16 * 16 + 0) / 256.0f;
        final float var4 = (par2 % 16 * 16 + 16) / 256.0f;
        final float var5 = (par2 / 16 * 16 + 0) / 256.0f;
        final float var6 = (par2 / 16 * 16 + 16) / 256.0f;
        final float var7 = 1.0f;
        final float var8 = 0.5f;
        final float var9 = 0.25f;
        GL11.glRotatef(180.0f - this.b.i, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-this.b.j, 1.0f, 0.0f, 0.0f);
        par1Tessellator.b();
        par1Tessellator.b(0.0f, 1.0f, 0.0f);
        par1Tessellator.a((double)(0.0f - var8), (double)(0.0f - var9), 0.0, (double)var3, (double)var6);
        par1Tessellator.a((double)(var7 - var8), (double)(0.0f - var9), 0.0, (double)var4, (double)var6);
        par1Tessellator.a((double)(var7 - var8), (double)(var7 - var9), 0.0, (double)var4, (double)var5);
        par1Tessellator.a((double)(0.0f - var8), (double)(var7 - var9), 0.0, (double)var3, (double)var5);
        par1Tessellator.a();
    }
}
