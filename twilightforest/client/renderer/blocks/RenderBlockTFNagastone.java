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

public class RenderBlockTFNagastone implements ISimpleBlockRenderingHandler
{
    final int renderID;
    
    public RenderBlockTFNagastone(final int nagastoneRenderID) {
        this.renderID = nagastoneRenderID;
    }
    
    public void renderInventoryBlock(final Block block, final int metadata, final int modelID, final RenderBlocks renderer) {
        this.setRenderRotate(renderer, metadata);
        renderInvNormalBlock(renderer, block, metadata);
        this.restoreRendererRotate(renderer);
    }
    
    public boolean renderWorldBlock(final IBlockAccess world, final int x, final int y, final int z, final Block block, final int modelId, final RenderBlocks renderer) {
        final int meta = world.func_72805_g(x, y, z);
        this.setRenderRotate(renderer, meta);
        final boolean didRender = renderer.func_147784_q(block, x, y, z);
        this.restoreRendererRotate(renderer);
        return didRender;
    }
    
    private void restoreRendererRotate(final RenderBlocks renderer) {
        renderer.field_147871_s = 0;
        renderer.field_147875_q = 0;
        renderer.field_147873_r = 0;
        renderer.field_147869_t = 0;
        renderer.field_147867_u = 0;
        renderer.field_147865_v = 0;
    }
    
    private void setRenderRotate(final RenderBlocks renderer, final int meta) {
        final int type = meta & 0xC;
        final int orient = meta & 0x3;
        if (type == 0) {
            switch (orient) {
                case 0: {
                    renderer.field_147867_u = 1;
                    renderer.field_147865_v = 2;
                    break;
                }
                case 1: {
                    renderer.field_147867_u = 2;
                    renderer.field_147865_v = 1;
                    renderer.field_147871_s = 0;
                    break;
                }
                case 2: {
                    renderer.field_147867_u = 0;
                    renderer.field_147865_v = 3;
                    break;
                }
                case 3: {
                    renderer.field_147867_u = 3;
                    renderer.field_147865_v = 0;
                    break;
                }
            }
        }
        else if (type == 4 || type == 8) {
            switch (orient) {
                case 0: {
                    renderer.field_147867_u = 2;
                    renderer.field_147865_v = 1;
                    renderer.field_147873_r = 2;
                    break;
                }
                case 1: {
                    renderer.field_147867_u = 1;
                    renderer.field_147865_v = 2;
                    renderer.field_147875_q = 2;
                    break;
                }
                case 2: {
                    renderer.field_147867_u = 3;
                    renderer.field_147865_v = 0;
                    renderer.field_147871_s = 2;
                    break;
                }
                case 3: {
                    renderer.field_147867_u = 0;
                    renderer.field_147865_v = 3;
                    renderer.field_147869_t = 2;
                    break;
                }
            }
        }
        else if (type == 12) {
            switch (orient) {
                case 0: {
                    renderer.field_147867_u = 0;
                    renderer.field_147865_v = 0;
                    break;
                }
                case 1: {
                    renderer.field_147867_u = 1;
                    renderer.field_147865_v = 1;
                    break;
                }
                case 2: {
                    renderer.field_147869_t = 2;
                    renderer.field_147871_s = 2;
                    renderer.field_147875_q = 2;
                    renderer.field_147873_r = 2;
                    break;
                }
            }
        }
    }
    
    public boolean shouldRender3DInInventory(final int modelId) {
        return true;
    }
    
    public int getRenderId() {
        return this.renderID;
    }
    
    public static void renderInvNormalBlock(final RenderBlocks renderblocks, final Block par1Block, final int meta) {
        final Tessellator tessellator = Tessellator.field_78398_a;
        GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        par1Block.func_149676_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
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
