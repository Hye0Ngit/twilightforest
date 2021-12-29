// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.block.BlockSlab;
import twilightforest.block.BlockTFAuroraSlab;
import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;

public class ItemBlockTFAuroraSlab extends ItemSlab
{
    public ItemBlockTFAuroraSlab(final Block block, final BlockTFAuroraSlab singleSlab, final BlockTFAuroraSlab doubleSlab, final Boolean isDouble) {
        super(block, (BlockSlab)singleSlab, (BlockSlab)doubleSlab, (boolean)isDouble);
    }
}
