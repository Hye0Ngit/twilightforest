// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.entity.item.EntityItem;
import org.lwjgl.opengl.GL11;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.entity.RenderItem;

public class RenderTFThrownAxe extends RenderItem
{
    Item myItem;
    
    public RenderTFThrownAxe(final Item knightlyAxe) {
        this.myItem = knightlyAxe;
    }
    
    public void func_76986_a(final Entity entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        GL11.glPushMatrix();
        final float spin = (entity.field_70173_aa + par9) * -10.0f + 90.0f;
        this.doRenderItem(null, par2, par4, par6, par8, spin);
        GL11.glPopMatrix();
    }
    
    public void doRenderItem(final EntityItem par1EntityItem, final double x, final double y, final double z, final float rotation, final float spin) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x, (float)y, (float)z);
        GL11.glEnable(32826);
        GL11.glScalef(1.25f, 1.25f, 1.25f);
        final IIcon icon1 = this.myItem.func_77617_a(0);
        this.renderDroppedItem(icon1, rotation, spin);
        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }
    
    private void renderDroppedItem(final IIcon par2Icon, final float rotation, final float spin) {
        final Tessellator tessellator = Tessellator.field_78398_a;
        final float f9 = 0.5f;
        final float f10 = 0.25f;
        GL11.glPushMatrix();
        GL11.glRotatef(rotation + 270.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(spin, 0.0f, 0.0f, 1.0f);
        final float f11 = 0.0625f;
        final float f12 = 0.021875f;
        GL11.glTranslatef(-f9, -f10, -(f11 + f12));
        GL11.glTranslatef(0.0f, 0.0f, f11 + f12);
        this.func_110776_a(TextureMap.field_110576_c);
        ItemRenderer.func_78439_a(tessellator, par2Icon.func_94212_f(), par2Icon.func_94206_g(), par2Icon.func_94209_e(), par2Icon.func_94210_h(), par2Icon.func_94211_a(), par2Icon.func_94216_b(), f11);
        GL11.glPopMatrix();
    }
    
    protected ResourceLocation func_110775_a(final Entity entity) {
        return this.field_76990_c.field_78724_e.func_130087_a(this.myItem.func_94901_k());
    }
    
    public boolean shouldBob() {
        return false;
    }
}
