// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import org.lwjgl.opengl.GL11;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderBlockTFFireflyJar implements ISimpleBlockRenderingHandler
{
    public static int jarTop;
    public static int jarSide;
    public static int jarLid;
    final int renderID;
    
    public RenderBlockTFFireflyJar(final int blockComplexRenderID) {
        this.renderID = blockComplexRenderID;
    }
    
    public void renderInventoryBlock(final amq block, final int metadata, final int modelID, final bbb renderer) {
        renderInvJar(renderer, block, metadata);
    }
    
    public boolean renderWorldBlock(final ym world, final int x, final int y, final int z, final amq block, final int modelId, final bbb renderer) {
        return renderJar(renderer, world, x, y, z, block);
    }
    
    public boolean shouldRender3DInInventory() {
        return true;
    }
    
    public int getRenderId() {
        return this.renderID;
    }
    
    public static boolean renderJar(final bbb renderblocks, final ym world, final int x, final int y, final int z, final amq block) {
        renderblocks.a();
        renderblocks.a(0.1875, 0.0, 0.1875, 0.8125, 0.875, 0.8125);
        renderblocks.q(block, x, y, z);
        renderblocks.d = RenderBlockTFFireflyJar.jarLid;
        renderblocks.a(0.25, 0.75, 0.25, 0.75, 1.0, 0.75);
        renderblocks.q(block, x, y, z);
        renderblocks.a();
        block.f();
        return true;
    }
    
    public static void renderInvJar(final bbb renderblocks, final amq par1Block, final int meta) {
        final baz tessellator = baz.a;
        GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        renderblocks.a(0.1875, 0.0, 0.1875, 0.8125, 0.875, 0.8125);
        tessellator.b();
        tessellator.b(0.0f, -1.0f, 0.0f);
        renderblocks.a(par1Block, 0.0, 0.0, 0.0, RenderBlockTFFireflyJar.jarTop);
        tessellator.a();
        tessellator.b();
        tessellator.b(0.0f, 1.0f, 0.0f);
        renderblocks.b(par1Block, 0.0, 0.0, 0.0, RenderBlockTFFireflyJar.jarTop);
        tessellator.a();
        tessellator.b();
        tessellator.b(0.0f, 0.0f, -1.0f);
        renderblocks.c(par1Block, 0.0, 0.0, 0.0, RenderBlockTFFireflyJar.jarSide);
        tessellator.a();
        tessellator.b();
        tessellator.b(0.0f, 0.0f, 1.0f);
        renderblocks.d(par1Block, 0.0, 0.0, 0.0, RenderBlockTFFireflyJar.jarSide);
        tessellator.a();
        tessellator.b();
        tessellator.b(-1.0f, 0.0f, 0.0f);
        renderblocks.e(par1Block, 0.0, 0.0, 0.0, RenderBlockTFFireflyJar.jarSide);
        tessellator.a();
        tessellator.b();
        tessellator.b(1.0f, 0.0f, 0.0f);
        renderblocks.f(par1Block, 0.0, 0.0, 0.0, RenderBlockTFFireflyJar.jarSide);
        tessellator.a();
        renderblocks.a(0.25, 0.75, 0.25, 0.75, 1.0, 0.75);
        tessellator.b();
        tessellator.b(0.0f, -1.0f, 0.0f);
        renderblocks.a(par1Block, 0.0, 0.0, 0.0, RenderBlockTFFireflyJar.jarLid);
        tessellator.a();
        tessellator.b();
        tessellator.b(0.0f, 1.0f, 0.0f);
        renderblocks.b(par1Block, 0.0, 0.0, 0.0, RenderBlockTFFireflyJar.jarLid);
        tessellator.a();
        tessellator.b();
        tessellator.b(0.0f, 0.0f, -1.0f);
        renderblocks.c(par1Block, 0.0, 0.0, 0.0, RenderBlockTFFireflyJar.jarLid);
        tessellator.a();
        tessellator.b();
        tessellator.b(0.0f, 0.0f, 1.0f);
        renderblocks.d(par1Block, 0.0, 0.0, 0.0, RenderBlockTFFireflyJar.jarLid);
        tessellator.a();
        tessellator.b();
        tessellator.b(-1.0f, 0.0f, 0.0f);
        renderblocks.e(par1Block, 0.0, 0.0, 0.0, RenderBlockTFFireflyJar.jarLid);
        tessellator.a();
        tessellator.b();
        tessellator.b(1.0f, 0.0f, 0.0f);
        renderblocks.f(par1Block, 0.0, 0.0, 0.0, RenderBlockTFFireflyJar.jarLid);
        tessellator.a();
        GL11.glTranslatef(0.5f, 0.5f, 0.5f);
        par1Block.f();
    }
    
    static {
        RenderBlockTFFireflyJar.jarTop = 7;
        RenderBlockTFFireflyJar.jarSide = 8;
        RenderBlockTFFireflyJar.jarLid = 9;
    }
}
