// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.Tessellator;
import org.lwjgl.opengl.GL11;
import net.minecraft.item.Item;
import twilightforest.entity.EntityTFCharmEffect;
import net.minecraft.entity.Entity;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.Render;

@SideOnly(Side.CLIENT)
public class RenderTFCharm extends Render
{
    private Icon itemIcon;
    
    public RenderTFCharm(final Icon par1) {
        this.itemIcon = par1;
    }
    
    public void func_76986_a(final Entity par1Entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        if (par1Entity instanceof EntityTFCharmEffect) {
            final EntityTFCharmEffect charm = (EntityTFCharmEffect)par1Entity;
            if (charm.getItemID() > 0) {
                this.itemIcon = Item.field_77698_e[charm.getItemID()].func_77617_a(0);
            }
        }
        GL11.glPushMatrix();
        GL11.glTranslatef((float)par2, (float)par4, (float)par6);
        GL11.glEnable(32826);
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        this.func_110777_b(par1Entity);
        final Tessellator var10 = Tessellator.field_78398_a;
        this.func_77026_a(var10, this.itemIcon);
        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }
    
    private void func_77026_a(final Tessellator par1Tessellator, final Icon par2Icon) {
        final float f = par2Icon.func_94209_e();
        final float f2 = par2Icon.func_94212_f();
        final float f3 = par2Icon.func_94206_g();
        final float f4 = par2Icon.func_94210_h();
        final float f5 = 1.0f;
        final float f6 = 0.5f;
        final float f7 = 0.25f;
        GL11.glRotatef(180.0f - this.field_76990_c.field_78735_i, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-this.field_76990_c.field_78732_j, 1.0f, 0.0f, 0.0f);
        par1Tessellator.func_78382_b();
        par1Tessellator.func_78375_b(0.0f, 1.0f, 0.0f);
        par1Tessellator.func_78374_a((double)(0.0f - f6), (double)(0.0f - f7), 0.0, (double)f, (double)f4);
        par1Tessellator.func_78374_a((double)(f5 - f6), (double)(0.0f - f7), 0.0, (double)f2, (double)f4);
        par1Tessellator.func_78374_a((double)(f5 - f6), (double)(f5 - f7), 0.0, (double)f2, (double)f3);
        par1Tessellator.func_78374_a((double)(0.0f - f6), (double)(f5 - f7), 0.0, (double)f, (double)f3);
        par1Tessellator.func_78381_a();
    }
    
    protected ResourceLocation func_110775_a(final Entity par1Entity) {
        return TextureMap.field_110576_c;
    }
}
