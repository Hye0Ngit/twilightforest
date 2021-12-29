// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.block.TFBlocks;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabTwilightForest extends CreativeTabs
{
    public CreativeTabTwilightForest(final String label) {
        super(label);
    }
    
    public Item func_78016_d() {
        return Item.func_150898_a(TFBlocks.fireflyJar);
    }
}
