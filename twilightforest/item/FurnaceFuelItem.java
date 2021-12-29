// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

public class FurnaceFuelItem extends BlockItem
{
    private final int burntime;
    
    public FurnaceFuelItem(final Block block, final Item.Properties properties, final int burn) {
        super(block, properties);
        this.burntime = burn;
    }
    
    public int getBurnTime(final ItemStack itemStack) {
        return this.burntime;
    }
}
