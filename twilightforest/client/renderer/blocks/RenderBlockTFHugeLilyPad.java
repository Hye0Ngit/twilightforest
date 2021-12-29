// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.blocks;

import net.minecraft.world.IBlockAccess;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.block.Block;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderBlockTFHugeLilyPad implements ISimpleBlockRenderingHandler
{
    final int renderID;
    
    public RenderBlockTFHugeLilyPad(final int blockComplexRenderID) {
        this.renderID = blockComplexRenderID;
    }
    
    public void renderInventoryBlock(final Block block, final int metadata, final int modelID, final RenderBlocks renderer) {
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
        int orient = meta >> 2;
        if (orient == 2) {
            orient = 3;
        }
        else if (orient == 3) {
            orient = 2;
        }
        renderer.field_147867_u = orient;
        renderer.field_147865_v = orient;
    }
    
    public boolean shouldRender3DInInventory(final int modelId) {
        return false;
    }
    
    public int getRenderId() {
        return this.renderID;
    }
}
