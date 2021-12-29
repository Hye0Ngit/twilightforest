// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.blocks;

import org.lwjgl.opengl.GL11;
import twilightforest.block.BlockTFFireflyJar;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderBlockTFFireflyJar implements ISimpleBlockRenderingHandler
{
    final int renderID;
    
    public RenderBlockTFFireflyJar(final int blockComplexRenderID) {
        this.renderID = blockComplexRenderID;
    }
    
    public void renderInventoryBlock(final aqw block, final int metadata, final int modelID, final bfo renderer) {
        renderInvJar(renderer, block, metadata);
    }
    
    public boolean renderWorldBlock(final ace world, final int x, final int y, final int z, final aqw block, final int modelId, final bfo renderer) {
        return renderJar(renderer, world, x, y, z, block);
    }
    
    public boolean shouldRender3DInInventory() {
        return true;
    }
    
    public int getRenderId() {
        return this.renderID;
    }
    
    public static boolean renderJar(final bfo renderblocks, final ace world, final int x, final int y, final int z, final aqw block) {
        renderblocks.a();
        renderblocks.a(0.1875, 0.0, 0.1875, 0.8125, 0.875, 0.8125);
        renderblocks.p(block, x, y, z);
        renderblocks.d = BlockTFFireflyJar.jarCork;
        renderblocks.a(0.25, 0.75, 0.25, 0.75, 1.0, 0.75);
        renderblocks.p(block, x, y, z);
        renderblocks.a();
        block.g();
        return true;
    }
    
    public static void renderInvJar(final bfo renderblocks, final aqw par1Block, final int meta) {
        final bfn tessellator = bfn.a;
        GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        renderblocks.a(0.1875, 0.0, 0.1875, 0.8125, 0.875, 0.8125);
        tessellator.b();
        tessellator.b(0.0f, -1.0f, 0.0f);
        renderblocks.a(par1Block, 0.0, 0.0, 0.0, BlockTFFireflyJar.jarTop);
        tessellator.a();
        tessellator.b();
        tessellator.b(0.0f, 1.0f, 0.0f);
        renderblocks.b(par1Block, 0.0, 0.0, 0.0, BlockTFFireflyJar.jarTop);
        tessellator.a();
        tessellator.b();
        tessellator.b(0.0f, 0.0f, -1.0f);
        renderblocks.f(par1Block, 0.0, 0.0, 0.0, BlockTFFireflyJar.jarSide);
        tessellator.a();
        tessellator.b();
        tessellator.b(0.0f, 0.0f, 1.0f);
        renderblocks.e(par1Block, 0.0, 0.0, 0.0, BlockTFFireflyJar.jarSide);
        tessellator.a();
        tessellator.b();
        tessellator.b(-1.0f, 0.0f, 0.0f);
        renderblocks.c(par1Block, 0.0, 0.0, 0.0, BlockTFFireflyJar.jarSide);
        tessellator.a();
        tessellator.b();
        tessellator.b(1.0f, 0.0f, 0.0f);
        renderblocks.d(par1Block, 0.0, 0.0, 0.0, BlockTFFireflyJar.jarSide);
        tessellator.a();
        renderblocks.a(0.25, 0.75, 0.25, 0.75, 1.0, 0.75);
        tessellator.b();
        tessellator.b(0.0f, -1.0f, 0.0f);
        renderblocks.a(par1Block, 0.0, 0.0, 0.0, BlockTFFireflyJar.jarCork);
        tessellator.a();
        tessellator.b();
        tessellator.b(0.0f, 1.0f, 0.0f);
        renderblocks.b(par1Block, 0.0, 0.0, 0.0, BlockTFFireflyJar.jarCork);
        tessellator.a();
        tessellator.b();
        tessellator.b(0.0f, 0.0f, -1.0f);
        renderblocks.f(par1Block, 0.0, 0.0, 0.0, BlockTFFireflyJar.jarCork);
        tessellator.a();
        tessellator.b();
        tessellator.b(0.0f, 0.0f, 1.0f);
        renderblocks.e(par1Block, 0.0, 0.0, 0.0, BlockTFFireflyJar.jarCork);
        tessellator.a();
        tessellator.b();
        tessellator.b(-1.0f, 0.0f, 0.0f);
        renderblocks.c(par1Block, 0.0, 0.0, 0.0, BlockTFFireflyJar.jarCork);
        tessellator.a();
        tessellator.b();
        tessellator.b(1.0f, 0.0f, 0.0f);
        renderblocks.d(par1Block, 0.0, 0.0, 0.0, BlockTFFireflyJar.jarCork);
        tessellator.a();
        GL11.glTranslatef(0.5f, 0.5f, 0.5f);
        par1Block.g();
    }
}
