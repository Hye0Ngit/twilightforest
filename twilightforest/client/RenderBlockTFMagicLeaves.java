// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import org.lwjgl.opengl.GL11;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderBlockTFMagicLeaves implements ISimpleBlockRenderingHandler
{
    final int renderID;
    
    public RenderBlockTFMagicLeaves(final int myRenderID) {
        this.renderID = myRenderID;
    }
    
    public void renderInventoryBlock(final amq block, final int metadata, final int modelID, final bbb renderer) {
        this.setRenderRotate(renderer, metadata);
        renderInvNormalBlock(renderer, block, metadata);
        this.restoreRendererRotate(renderer);
    }
    
    public boolean renderWorldBlock(final ym world, final int x, final int y, final int z, final amq block, final int modelId, final bbb renderer) {
        final int meta = world.h(x, y, z);
        this.setRenderRotate(renderer, meta);
        final boolean didRender = renderer.q(block, x, y, z);
        this.restoreRendererRotate(renderer);
        return didRender;
    }
    
    private void restoreRendererRotate(final bbb renderer) {
        renderer.p = 0;
        renderer.n = 0;
        renderer.o = 0;
        renderer.q = 0;
        renderer.r = 0;
        renderer.s = 0;
    }
    
    private void setRenderRotate(final bbb renderer, final int meta) {
        final int type = meta & 0xC;
        final int orient = meta & 0x3;
        renderer.n = 3;
        renderer.s = 0;
        renderer.q = 2;
        renderer.p = 2;
    }
    
    public boolean shouldRender3DInInventory() {
        return true;
    }
    
    public int getRenderId() {
        return this.renderID;
    }
    
    public static void renderInvNormalBlock(final bbb renderblocks, final amq par1Block, final int meta) {
        final baz tessellator = baz.a;
        GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        par1Block.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
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
        renderblocks.c(par1Block, 0.0, 0.0, 0.0, par1Block.a(2, meta));
        tessellator.a();
        tessellator.b();
        tessellator.b(0.0f, 0.0f, 1.0f);
        renderblocks.d(par1Block, 0.0, 0.0, 0.0, par1Block.a(3, meta));
        tessellator.a();
        tessellator.b();
        tessellator.b(-1.0f, 0.0f, 0.0f);
        renderblocks.e(par1Block, 0.0, 0.0, 0.0, par1Block.a(4, meta));
        tessellator.a();
        tessellator.b();
        tessellator.b(1.0f, 0.0f, 0.0f);
        renderblocks.f(par1Block, 0.0, 0.0, 0.0, par1Block.a(5, meta));
        tessellator.a();
    }
}
