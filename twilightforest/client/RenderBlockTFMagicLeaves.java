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
    
    public void renderInventoryBlock(final aou block, final int metadata, final int modelID, final bfz renderer) {
        this.setRenderRotate(renderer, metadata);
        renderInvNormalBlock(renderer, block, metadata);
        this.restoreRendererRotate(renderer);
    }
    
    public boolean renderWorldBlock(final aae world, final int x, final int y, final int z, final aou block, final int modelId, final bfz renderer) {
        final int meta = world.h(x, y, z);
        this.setRenderRotate(renderer, meta, x, y, z);
        final boolean didRender = renderer.p(block, x, y, z);
        this.restoreRendererRotate(renderer);
        return didRender;
    }
    
    private void restoreRendererRotate(final bfz renderer) {
        renderer.r = 0;
        renderer.p = 0;
        renderer.q = 0;
        renderer.s = 0;
        renderer.t = 0;
        renderer.u = 0;
    }
    
    private void setRenderRotate(final bfz renderer, final int meta) {
        this.setRenderRotate(renderer, meta, 0, 0, 0);
    }
    
    private void setRenderRotate(final bfz renderer, final int meta, final int x, final int y, final int z) {
        final int type = meta & 0x3;
        if (type == 0) {
            renderer.p = 3;
            renderer.u = 0;
            renderer.s = 2;
            renderer.r = 2;
        }
        else if (type == 1) {
            renderer.u = (x + y + z & 0x3);
            renderer.t = (x + y + z & 0x3);
            renderer.p = 1;
            renderer.q = 2;
            renderer.s = 2;
            renderer.r = 1;
        }
        else if (type == 2) {
            renderer.u = (x + y + z & 0x3);
            renderer.t = (x + y + z & 0x3);
            renderer.p = 2;
            renderer.q = 1;
            renderer.s = 1;
            renderer.r = 2;
        }
        else if (type == 3) {
            renderer.u = (x + y + z & 0x3);
            renderer.t = (x + y + z & 0x3);
            renderer.p = (x + y + z & 0x3);
            renderer.q = (x + y + z & 0x3);
            renderer.s = (x + y + z & 0x3);
            renderer.r = (x + y + z & 0x3);
        }
    }
    
    public boolean shouldRender3DInInventory() {
        return true;
    }
    
    public int getRenderId() {
        return this.renderID;
    }
    
    public static void renderInvNormalBlock(final bfz renderblocks, final aou par1Block, final int meta) {
        final bfx tessellator = bfx.a;
        if (renderblocks.c) {
            final int colorInt = par1Block.b(meta);
            final float red = (colorInt >> 16 & 0xFF) / 255.0f;
            final float green = (colorInt >> 8 & 0xFF) / 255.0f;
            final float blue = (colorInt & 0xFF) / 255.0f;
            GL11.glColor4f(red, green, blue, 1.0f);
        }
        GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
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
