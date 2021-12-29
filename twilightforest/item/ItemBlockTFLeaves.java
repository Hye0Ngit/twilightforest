// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.block.Block;

public class ItemBlockTFLeaves extends ItemBlockTFMeta
{
    public ItemBlockTFLeaves(final Block block) {
        super(block);
    }
    
    @Override
    public int func_77647_b(final int stackMeta) {
        return stackMeta | 0x4;
    }
}
