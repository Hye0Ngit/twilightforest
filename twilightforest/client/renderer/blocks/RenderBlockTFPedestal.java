// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.blocks;

import org.lwjgl.opengl.GL11;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderBlockTFPedestal implements ISimpleBlockRenderingHandler
{
    final int renderID;
    
    public RenderBlockTFPedestal(final int blockComplexRenderID) {
        this.renderID = blockComplexRenderID;
    }
    
    public void renderInventoryBlock(final aqw block, final int metadata, final int modelID, final bfo renderer) {
        renderInvJar(renderer, block, metadata);
    }
    
    public boolean renderWorldBlock(final ace world, final int x, final int y, final int z, final aqw block, final int modelId, final bfo renderer) {
        return renderPedestal(renderer, world, x, y, z, block);
    }
    
    public boolean shouldRender3DInInventory() {
        return true;
    }
    
    public int getRenderId() {
        return this.renderID;
    }
    
    public static boolean renderPedestal(final bfo renderblocks, final ace world, final int x, final int y, final int z, final aqw block) {
        renderblocks.a(0.0625, 0.0, 0.0625, 0.9375, 0.1875, 0.9375);
        renderblocks.p(block, x, y, z);
        renderblocks.a(0.125, 0.1875, 0.125, 0.875, 0.8125, 0.875);
        renderblocks.p(block, x, y, z);
        renderblocks.a(0.0625, 0.8125, 0.0625, 0.9375, 1.0, 0.9375);
        renderblocks.p(block, x, y, z);
        block.g();
        return true;
    }
    
    public static void renderInvJar(final bfo renderblocks, final aqw par1Block, final int meta) {
        final bfn tessellator = bfn.a;
        GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        renderblocks.a(0.0625, 0.0, 0.0625, 0.9375, 0.1875, 0.9375);
        renderInvBlock(renderblocks, par1Block, meta, tessellator);
        renderblocks.a(0.125, 0.1875, 0.125, 0.875, 0.8125, 0.875);
        renderInvBlock(renderblocks, par1Block, meta, tessellator);
        renderblocks.a(0.0625, 0.8125, 0.0625, 0.9375, 1.0, 0.9375);
        renderInvBlock(renderblocks, par1Block, meta, tessellator);
        GL11.glTranslatef(0.5f, 0.5f, 0.5f);
        par1Block.g();
    }
    
    protected static void renderInvBlock(final bfo renderblocks, final aqw par1Block, final int meta, final bfn tessellator) {
        tessellator.b();
        tessellator.b(0.0f, -1.0f, 0.0f);
        renderblocks.a(par1Block, 0.0, 0.0, 0.0, par1Block.a(0, meta));
        tessellator.a();
        tessellator.b();
        tessellator.b(0.0f, 1.0f, 0.0f);
        renderblocks.b(par1Block, 0.0, 0.0, 0.0, par1Block.a(1, meta));
        tessellator.a();
        tessellator.b();
        tessellator.b(0.0f, 0.0f, -1.0f);
        renderblocks.f(par1Block, 0.0, 0.0, 0.0, par1Block.a(2, meta));
        tessellator.a();
        tessellator.b();
        tessellator.b(0.0f, 0.0f, 1.0f);
        renderblocks.e(par1Block, 0.0, 0.0, 0.0, par1Block.a(3, meta));
        tessellator.a();
        tessellator.b();
        tessellator.b(-1.0f, 0.0f, 0.0f);
        renderblocks.c(par1Block, 0.0, 0.0, 0.0, par1Block.a(4, meta));
        tessellator.a();
        tessellator.b();
        tessellator.b(1.0f, 0.0f, 0.0f);
        renderblocks.d(par1Block, 0.0, 0.0, 0.0, par1Block.a(5, meta));
        tessellator.a();
    }
}
