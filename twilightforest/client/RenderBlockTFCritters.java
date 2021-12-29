// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderBlockTFCritters implements ISimpleBlockRenderingHandler
{
    final int renderID;
    
    public RenderBlockTFCritters(final int blockComplexRenderID) {
        this.renderID = blockComplexRenderID;
    }
    
    public void renderInventoryBlock(final amq block, final int metadata, final int modelID, final bbb renderer) {
    }
    
    public boolean renderWorldBlock(final ym world, final int x, final int y, final int z, final amq block, final int modelId, final bbb renderer) {
        return false;
    }
    
    public boolean shouldRender3DInInventory() {
        return false;
    }
    
    public int getRenderId() {
        return this.renderID;
    }
}
