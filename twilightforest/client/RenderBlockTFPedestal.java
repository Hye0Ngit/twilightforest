// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

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
    
    public boolean shouldRender3DInInventory() {
        return true;
    }
    
    public int getRenderId() {
        return this.renderID;
    }
    
    public static boolean renderPedestal(final RenderBlocks renderblocks, final IBlockAccess world, final int x, final int y, final int z, final Block block) {
        renderblocks.func_83020_a(0.0625, 0.0, 0.0625, 0.9375, 0.1875, 0.9375);
        renderblocks.func_78570_q(block, x, y, z);
        renderblocks.func_83020_a(0.125, 0.1875, 0.125, 0.875, 0.8125, 0.875);
        renderblocks.func_78570_q(block, x, y, z);
        renderblocks.func_83020_a(0.0625, 0.8125, 0.0625, 0.9375, 1.0, 0.9375);
        renderblocks.func_78570_q(block, x, y, z);
        block.func_71919_f();
        return true;
    }
    
    public static void renderInvJar(final RenderBlocks renderblocks, final Block par1Block, final int meta) {
        final Tessellator tessellator = Tessellator.field_78398_a;
        GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        renderblocks.func_83020_a(0.0625, 0.0, 0.0625, 0.9375, 0.1875, 0.9375);
        renderInvBlock(renderblocks, par1Block, meta, tessellator);
        renderblocks.func_83020_a(0.125, 0.1875, 0.125, 0.875, 0.8125, 0.875);
        renderInvBlock(renderblocks, par1Block, meta, tessellator);
        renderblocks.func_83020_a(0.0625, 0.8125, 0.0625, 0.9375, 1.0, 0.9375);
        renderInvBlock(renderblocks, par1Block, meta, tessellator);
        GL11.glTranslatef(0.5f, 0.5f, 0.5f);
        par1Block.func_71919_f();
    }
    
    protected static void renderInvBlock(final RenderBlocks renderblocks, final Block par1Block, final int meta, final Tessellator tessellator) {
        tessellator.func_78382_b();
        tessellator.func_78375_b(0.0f, -1.0f, 0.0f);
        renderblocks.func_78613_a(par1Block, 0.0, 0.0, 0.0, par1Block.func_71858_a(0, meta));
        tessellator.func_78381_a();
        tessellator.func_78382_b();
        tessellator.func_78375_b(0.0f, 1.0f, 0.0f);
        renderblocks.func_78617_b(par1Block, 0.0, 0.0, 0.0, par1Block.func_71858_a(1, meta));
        tessellator.func_78381_a();
        tessellator.func_78382_b();
        tessellator.func_78375_b(0.0f, 0.0f, -1.0f);
        renderblocks.func_78605_f(par1Block, 0.0, 0.0, 0.0, par1Block.func_71858_a(2, meta));
        tessellator.func_78381_a();
        tessellator.func_78382_b();
        tessellator.func_78375_b(0.0f, 0.0f, 1.0f);
        renderblocks.func_78573_e(par1Block, 0.0, 0.0, 0.0, par1Block.func_71858_a(3, meta));
        tessellator.func_78381_a();
        tessellator.func_78382_b();
        tessellator.func_78375_b(-1.0f, 0.0f, 0.0f);
        renderblocks.func_78611_c(par1Block, 0.0, 0.0, 0.0, par1Block.func_71858_a(4, meta));
        tessellator.func_78381_a();
        tessellator.func_78382_b();
        tessellator.func_78375_b(1.0f, 0.0f, 0.0f);
        renderblocks.func_78622_d(par1Block, 0.0, 0.0, 0.0, par1Block.func_71858_a(5, meta));
        tessellator.func_78381_a();
    }
}
