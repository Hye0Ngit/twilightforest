// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.block.TFBlocks;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabTwilightForest extends CreativeTabs
{
    public CreativeTabTwilightForest(final String label) {
        super(label);
    }
    
    public ItemStack func_78016_d() {
        return new ItemStack(TFBlocks.miniature_structure);
    }
}
