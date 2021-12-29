// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.SwordItem;

public class GiantSwordItem extends SwordItem
{
    public GiantSwordItem(final IItemTier material, final Item.Properties props) {
        super(material, 10, -3.5f, props);
    }
    
    public boolean func_82789_a(final ItemStack stack, final ItemStack material) {
        return material.func_77973_b() == TFItems.ironwood_ingot.get() || super.func_82789_a(stack, material);
    }
}
