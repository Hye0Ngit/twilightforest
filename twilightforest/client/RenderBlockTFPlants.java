// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderBlockTFPlants implements ISimpleBlockRenderingHandler
{
    final int renderID;
    
    public RenderBlockTFPlants(final int blockRenderID) {
        this.renderID = blockRenderID;
    }
    
    public void renderInventoryBlock(final amj block, final int metadata, final int modelID, final baq renderer) {
    }
    
    public boolean renderWorldBlock(final yf world, final int x, final int y, final int z, final amj block, final int modelId, final baq renderer) {
        final int meta = world.h(x, y, z);
        if (meta != 15) {
            renderer.l(block, x, y, z);
        }
        return true;
    }
    
    public boolean shouldRender3DInInventory() {
        return false;
    }
    
    public int getRenderId() {
        return this.renderID;
    }
}
