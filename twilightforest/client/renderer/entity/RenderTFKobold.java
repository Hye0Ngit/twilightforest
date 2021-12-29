// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;
import net.minecraft.entity.EntityLiving;
import net.minecraft.client.model.ModelBiped;

public class RenderTFKobold extends RenderTFBiped
{
    public RenderTFKobold(final ModelBiped modelBiped, final float scale, final String textureName) {
        super(modelBiped, scale, textureName);
    }
    
    protected void func_77029_c(final EntityLiving p_77029_1_, final float p_77029_2_) {
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        final ItemStack itemstack = p_77029_1_.func_70694_bm();
        final ItemStack itemstack2 = p_77029_1_.func_130225_q(3);
        if (itemstack != null && itemstack.func_77973_b() != null) {
            final Item item = itemstack.func_77973_b();
            GL11.glPushMatrix();
            this.field_77071_a.field_78112_f.func_78794_c(0.0625f);
            GL11.glTranslatef(-0.0625f, 0.4375f, 0.0625f);
            final IItemRenderer customRenderer = MinecraftForgeClient.getItemRenderer(itemstack, IItemRenderer.ItemRenderType.EQUIPPED);
            final boolean is3D = customRenderer != null && customRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, itemstack, IItemRenderer.ItemRendererHelper.BLOCK_3D);
            if (item instanceof ItemBlock && (is3D || RenderBlocks.func_147739_a(Block.func_149634_a(item).func_149645_b()))) {
                float f1 = 0.5f;
                GL11.glTranslatef(0.0f, 0.1875f, -0.3125f);
                f1 *= 0.75f;
                GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScalef(-f1, -f1, f1);
            }
            else if (item == Items.field_151031_f) {
                final float f1 = 0.625f;
                GL11.glTranslatef(0.0f, 0.125f, 0.3125f);
                GL11.glRotatef(-20.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScalef(f1, -f1, f1);
                GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            }
            else if (item.func_77662_d()) {
                final float f1 = 0.625f;
                if (item.func_77629_n_()) {
                    GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
                    GL11.glTranslatef(0.0f, -0.125f, 0.0f);
                }
                this.func_82422_c();
                GL11.glScalef(f1, -f1, f1);
                GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            }
            else {
                final float f1 = 0.375f;
                GL11.glTranslatef(0.25f, 0.0f, -0.1875f);
                this.func_82422_c();
                GL11.glScalef(f1, f1, f1);
                GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
                GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
            }
            if (itemstack.func_77973_b().func_77623_v()) {
                for (int i = 0; i < itemstack.func_77973_b().getRenderPasses(itemstack.func_77960_j()); ++i) {
                    final int j = itemstack.func_77973_b().func_82790_a(itemstack, i);
                    final float f2 = (j >> 16 & 0xFF) / 255.0f;
                    final float f3 = (j >> 8 & 0xFF) / 255.0f;
                    final float f4 = (j & 0xFF) / 255.0f;
                    GL11.glColor4f(f2, f3, f4, 1.0f);
                    this.field_76990_c.field_78721_f.func_78443_a((EntityLivingBase)p_77029_1_, itemstack, i);
                }
            }
            else {
                final int i = itemstack.func_77973_b().func_82790_a(itemstack, 0);
                final float f5 = (i >> 16 & 0xFF) / 255.0f;
                final float f2 = (i >> 8 & 0xFF) / 255.0f;
                final float f3 = (i & 0xFF) / 255.0f;
                GL11.glColor4f(f5, f2, f3, 1.0f);
                this.field_76990_c.field_78721_f.func_78443_a((EntityLivingBase)p_77029_1_, itemstack, 0);
            }
            GL11.glPopMatrix();
        }
    }
    
    protected void func_82422_c() {
        GL11.glTranslatef(0.0f, 0.01875f, 0.0f);
    }
}
