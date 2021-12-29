// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.blocks;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderBlockTFCritters implements ISimpleBlockRenderingHandler
{
    final int renderID;
    
    public RenderBlockTFCritters(final int blockComplexRenderID) {
        this.renderID = blockComplexRenderID;
    }
    
    public void renderInventoryBlock(final aqw block, final int metadata, final int modelID, final bfo renderer) {
    }
    
    public boolean renderWorldBlock(final ace world, final int x, final int y, final int z, final aqw block, final int modelId, final bfo renderer) {
        return false;
    }
    
    public boolean shouldRender3DInInventory() {
        return false;
    }
    
    public int getRenderId() {
        return this.renderID;
    }
}
