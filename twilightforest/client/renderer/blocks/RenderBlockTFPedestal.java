// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.blocks;

import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.block.Block;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderBlockTFPedestal implements ISimpleBlockRenderingHandler
{
    final int renderID;
    
    public RenderBlockTFPedestal(final int blockComplexRenderID) {
        this.renderID = blockComplexRenderID;
    }
    
    public void renderInventoryBlock(final Block block, final int metadata, final int modelID, final RenderBlocks renderer) {
        renderInvJar(renderer, block, metadata);
    }
    
    public boolean renderWorldBlock(final IBlockAccess world, final int x, final int y, final int z, final Block block, final int modelId, final RenderBlocks renderer) {
        return renderPedestal(renderer, world, x, y, z, block);
    }
    
    public boolean shouldRender3DInInventory(final int modelId) {
        return true;
    }
    
    public int getRenderId() {
        return this.renderID;
    }
    
    public static boolean renderPedestal(final RenderBlocks renderblocks, final IBlockAccess world, final int x, final int y, final int z, final Block block) {
        renderblocks.func_147782_a(0.0625, 0.0, 0.0625, 0.9375, 0.1875, 0.9375);
        renderblocks.func_147784_q(block, x, y, z);
        renderblocks.func_147782_a(0.125, 0.1875, 0.125, 0.875, 0.8125, 0.875);
        renderblocks.func_147784_q(block, x, y, z);
        renderblocks.func_147782_a(0.0625, 0.8125, 0.0625, 0.9375, 1.0, 0.9375);
        renderblocks.func_147784_q(block, x, y, z);
        block.func_149683_g();
        return true;
    }
    
    public static void renderInvJar(final RenderBlocks renderblocks, final Block par1Block, final int meta) {
        final Tessellator tessellator = Tessellator.field_78398_a;
        GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        renderblocks.func_147782_a(0.0625, 0.0, 0.0625, 0.9375, 0.1875, 0.9375);
        renderInvBlock(renderblocks, par1Block, meta, tessellator);
        renderblocks.func_147782_a(0.125, 0.1875, 0.125, 0.875, 0.8125, 0.875);
        renderInvBlock(renderblocks, par1Block, meta, tessellator);
        renderblocks.func_147782_a(0.0625, 0.8125, 0.0625, 0.9375, 1.0, 0.9375);
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
    }
}
