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

public class RenderBlockTFMagicLeaves implements ISimpleBlockRenderingHandler
{
    final int renderID;
    
    public RenderBlockTFMagicLeaves(final int myRenderID) {
        this.renderID = myRenderID;
    }
    
    public void renderInventoryBlock(final Block block, final int metadata, final int modelID, final RenderBlocks renderer) {
        this.setRenderRotate(renderer, metadata);
        renderInvNormalBlock(renderer, block, metadata);
        this.restoreRendererRotate(renderer);
    }
    
    public boolean renderWorldBlock(final IBlockAccess world, final int x, final int y, final int z, final Block block, final int modelId, final RenderBlocks renderer) {
        final int meta = world.func_72805_g(x, y, z);
        this.setRenderRotate(renderer, meta, x, y, z);
        final boolean didRender = renderer.func_78570_q(block, x, y, z);
        this.restoreRendererRotate(renderer);
        return didRender;
    }
    
    private void restoreRendererRotate(final RenderBlocks renderer) {
        renderer.field_78685_i = 0;
        renderer.field_78662_g = 0;
        renderer.field_78683_h = 0;
        renderer.field_78679_j = 0;
        renderer.field_78681_k = 0;
        renderer.field_78675_l = 0;
    }
    
    private void setRenderRotate(final RenderBlocks renderer, final int meta) {
        this.setRenderRotate(renderer, meta, 0, 0, 0);
    }
    
    private void setRenderRotate(final RenderBlocks renderer, final int meta, final int x, final int y, final int z) {
        final int type = meta & 0x3;
        if (type == 0) {
            renderer.field_78662_g = 3;
            renderer.field_78675_l = 0;
            renderer.field_78679_j = 2;
            renderer.field_78685_i = 2;
        }
        else if (type == 1) {
            renderer.field_78675_l = (x + y + z & 0x3);
            renderer.field_78681_k = (x + y + z & 0x3);
            renderer.field_78662_g = 1;
            renderer.field_78683_h = 2;
            renderer.field_78679_j = 2;
            renderer.field_78685_i = 1;
        }
        else if (type == 2) {
            renderer.field_78675_l = (x + y + z & 0x3);
            renderer.field_78681_k = (x + y + z & 0x3);
            renderer.field_78662_g = 2;
            renderer.field_78683_h = 1;
            renderer.field_78679_j = 1;
            renderer.field_78685_i = 2;
        }
        else if (type == 3) {
            renderer.field_78675_l = (x + y + z & 0x3);
            renderer.field_78681_k = (x + y + z & 0x3);
            renderer.field_78662_g = (x + y + z & 0x3);
            renderer.field_78683_h = (x + y + z & 0x3);
            renderer.field_78679_j = (x + y + z & 0x3);
            renderer.field_78685_i = (x + y + z & 0x3);
        }
    }
    
    public boolean shouldRender3DInInventory() {
        return true;
    }
    
    public int getRenderId() {
        return this.renderID;
    }
    
    public static void renderInvNormalBlock(final RenderBlocks renderblocks, final Block par1Block, final int meta) {
        final Tessellator tessellator = Tessellator.field_78398_a;
        if (renderblocks.field_78668_c) {
            final int colorInt = par1Block.func_71889_f_(meta);
            final float red = (colorInt >> 16 & 0xFF) / 255.0f;
            final float green = (colorInt >> 8 & 0xFF) / 255.0f;
            final float blue = (colorInt & 0xFF) / 255.0f;
            GL11.glColor4f(red, green, blue, 1.0f);
        }
        GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
        par1Block.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
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
