// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.blocks;

import twilightforest.block.TFBlocks;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.IIcon;
import twilightforest.block.BlockTFCastleMagic;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.block.Block;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderBlockTFCastleMagic implements ISimpleBlockRenderingHandler
{
    private int renderID;
    
    public RenderBlockTFCastleMagic(final int castleMagicBlockRenderID) {
        this.renderID = castleMagicBlockRenderID;
    }
    
    public void renderInventoryBlock(final Block block, final int metadata, final int modelId, final RenderBlocks renderer) {
        renderInvBlock(renderer, block, metadata);
    }
    
    public static void renderInvBlock(final RenderBlocks renderblocks, final Block par1Block, final int meta) {
        final Tessellator tessellator = Tessellator.field_78398_a;
        GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        renderInvBlock(renderblocks, par1Block, meta, tessellator);
        GL11.glTranslatef(0.5f, 0.5f, 0.5f);
        par1Block.func_149683_g();
    }
    
    protected static void renderInvBlock(final RenderBlocks renderblocks, final Block par1Block, final int meta, final Tessellator tessellator) {
        tessellator.func_78382_b();
        tessellator.func_78375_b(0.0f, -1.0f, 0.0f);
        renderblocks.func_147768_a(par1Block, 0.0, 0.0, 0.0, par1Block.func_149691_a(0, meta));
        tessellator.func_78381_a();
        tessellator.func_78382_b();
        tessellator.func_78375_b(0.0f, 1.0f, 0.0f);
        renderblocks.func_147806_b(par1Block, 0.0, 0.0, 0.0, par1Block.func_149691_a(1, meta));
        tessellator.func_78381_a();
        tessellator.func_78382_b();
        tessellator.func_78375_b(0.0f, 0.0f, -1.0f);
        renderblocks.func_147764_f(par1Block, 0.0, 0.0, 0.0, par1Block.func_149691_a(2, meta));
        tessellator.func_78381_a();
        tessellator.func_78382_b();
        tessellator.func_78375_b(0.0f, 0.0f, 1.0f);
        renderblocks.func_147798_e(par1Block, 0.0, 0.0, 0.0, par1Block.func_149691_a(3, meta));
        tessellator.func_78381_a();
        tessellator.func_78382_b();
        tessellator.func_78375_b(-1.0f, 0.0f, 0.0f);
        renderblocks.func_147761_c(par1Block, 0.0, 0.0, 0.0, par1Block.func_149691_a(4, meta));
        tessellator.func_78381_a();
        tessellator.func_78382_b();
        tessellator.func_78375_b(1.0f, 0.0f, 0.0f);
        renderblocks.func_147734_d(par1Block, 0.0, 0.0, 0.0, par1Block.func_149691_a(5, meta));
        tessellator.func_78381_a();
        final float pixel = 0.0625f;
        final IIcon icon = BlockTFCastleMagic.getMagicIconFor(meta, 0, 0);
        final int color = BlockTFCastleMagic.getMagicColorFor(meta);
        final float red = (color >> 16 & 0xFF) / 255.0f;
        final float grn = (color >> 8 & 0xFF) / 255.0f;
        final float blu = (color & 0xFF) / 255.0f;
        renderblocks.field_147863_w = false;
        GL11.glDisable(2896);
        tessellator.func_78382_b();
        tessellator.func_78380_c(15728880);
        tessellator.func_78386_a(red, grn, blu);
        renderblocks.func_147768_a(par1Block, 0.0, (double)(-pixel), 0.0, icon);
        tessellator.func_78381_a();
        tessellator.func_78382_b();
        tessellator.func_78380_c(15728880);
        tessellator.func_78386_a(red, grn, blu);
        renderblocks.func_147806_b(par1Block, 0.0, (double)pixel, 0.0, icon);
        tessellator.func_78381_a();
        tessellator.func_78382_b();
        tessellator.func_78380_c(15728880);
        tessellator.func_78386_a(red, grn, blu);
        renderblocks.func_147764_f(par1Block, (double)pixel, 0.0, 0.0, icon);
        tessellator.func_78381_a();
        tessellator.func_78382_b();
        tessellator.func_78380_c(15728880);
        tessellator.func_78386_a(red, grn, blu);
        renderblocks.func_147798_e(par1Block, (double)(-pixel), 0.0, 0.0, icon);
        tessellator.func_78381_a();
        tessellator.func_78382_b();
        tessellator.func_78380_c(15728880);
        tessellator.func_78386_a(red, grn, blu);
        renderblocks.func_147761_c(par1Block, 0.0, 0.0, (double)(-pixel), icon);
        tessellator.func_78381_a();
        tessellator.func_78382_b();
        tessellator.func_78380_c(15728880);
        tessellator.func_78386_a(red, grn, blu);
        renderblocks.func_147734_d(par1Block, 0.0, 0.0, (double)pixel, icon);
        tessellator.func_78381_a();
        GL11.glEnable(2896);
    }
    
    public boolean renderWorldBlock(final IBlockAccess world, final int x, final int y, final int z, final Block block, final int modelId, final RenderBlocks renderer) {
        renderer.func_147771_a();
        renderer.func_147782_a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
        renderer.func_147784_q(block, x, y, z);
        renderer.field_147840_d = BlockTFCastleMagic.getMagicIconFor(x, y, z);
        final int meta = world.func_72805_g(x, y, z);
        final int color = BlockTFCastleMagic.getMagicColorFor(meta);
        final float red = (color >> 16 & 0xFF) / 255.0f;
        final float grn = (color >> 8 & 0xFF) / 255.0f;
        final float blu = (color & 0xFF) / 255.0f;
        if (block == TFBlocks.castleDoor) {}
        final Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78380_c(15728880);
        tessellator.func_78386_a(red, grn, blu);
        renderer.field_147863_w = false;
        final float pixel = 0.0625f;
        if (renderer.field_147837_f || (block.func_149646_a(world, x, y - 1, z, 0) && world.func_147437_c(x, y - 1, z))) {
            renderer.func_147768_a(block, (double)x, y - (double)pixel, (double)z, renderer.field_147840_d);
        }
        if (renderer.field_147837_f || (block.func_149646_a(world, x, y + 1, z, 1) && world.func_147437_c(x, y + 1, z))) {
            renderer.func_147806_b(block, (double)x, y + (double)pixel, (double)z, renderer.field_147840_d);
        }
        if (renderer.field_147837_f || (block.func_149646_a(world, x, y, z - 1, 2) && world.func_147437_c(x, y, z - 1))) {
            renderer.func_147761_c(block, (double)x, (double)y, z - (double)pixel, renderer.field_147840_d);
        }
        if (renderer.field_147837_f || (block.func_149646_a(world, x, y, z + 1, 3) && world.func_147437_c(x, y, z + 1))) {
            renderer.func_147734_d(block, (double)x, (double)y, z + (double)pixel, renderer.field_147840_d);
        }
        if (renderer.field_147837_f || (block.func_149646_a(world, x - 1, y, z, 4) && world.func_147437_c(x - 1, y, z))) {
            renderer.func_147798_e(block, x - (double)pixel, (double)y, (double)z, renderer.field_147840_d);
        }
        if (renderer.field_147837_f || (block.func_149646_a(world, x + 1, y, z, 5) && world.func_147437_c(x + 1, y, z))) {
            renderer.func_147764_f(block, x + (double)pixel, (double)y, (double)z, renderer.field_147840_d);
        }
        renderer.func_147771_a();
        return true;
    }
    
    public boolean shouldRender3DInInventory(final int modelId) {
        return true;
    }
    
    public int getRenderId() {
        return this.renderID;
    }
}
