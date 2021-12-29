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
        final int type = meta & 0xC;
        final int orient = meta & 0x3;
        if (type == 0) {
            switch (orient) {
                case 0: {
                    renderer.field_78681_k = 1;
                    renderer.field_78675_l = 2;
                    break;
                }
                case 1: {
                    renderer.field_78681_k = 2;
                    renderer.field_78675_l = 1;
                    break;
                }
                case 2: {
                    renderer.field_78681_k = 0;
                    renderer.field_78675_l = 3;
                    break;
                }
                case 3: {
                    renderer.field_78681_k = 3;
                    renderer.field_78675_l = 0;
                    break;
                }
            }
        }
        else if (type == 4 || type == 8) {
            switch (orient) {
                case 0: {
                    renderer.field_78681_k = 2;
                    renderer.field_78675_l = 1;
                    renderer.field_78683_h = 2;
                    break;
                }
                case 1: {
                    renderer.field_78681_k = 1;
                    renderer.field_78675_l = 2;
                    renderer.field_78662_g = 2;
                    break;
                }
                case 2: {
                    renderer.field_78681_k = 3;
                    renderer.field_78675_l = 0;
                    renderer.field_78685_i = 2;
                    break;
                }
                case 3: {
                    renderer.field_78681_k = 0;
                    renderer.field_78675_l = 3;
                    renderer.field_78679_j = 2;
                    break;
                }
            }
        }
        else if (type == 12) {
            switch (orient) {
                case 0: {
                    renderer.field_78681_k = 0;
                    renderer.field_78675_l = 0;
                    break;
                }
                case 1: {
                    renderer.field_78681_k = 1;
                    renderer.field_78675_l = 1;
                    break;
                }
                case 2: {
                    renderer.field_78679_j = 2;
                    renderer.field_78685_i = 2;
                    renderer.field_78662_g = 2;
                    renderer.field_78683_h = 2;
                    break;
                }
            }
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
        GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
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
