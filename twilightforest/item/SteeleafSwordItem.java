// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.util.IItemProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.SwordItem;

public class SteeleafSwordItem extends SwordItem
{
    public SteeleafSwordItem(final IItemTier material, final Item.Properties props) {
        super(material, 3, -2.4f, props);
    }
    
    public void func_150895_a(final ItemGroup tab, final NonNullList<ItemStack> list) {
        if (this.func_194125_a(tab)) {
            final ItemStack istack = new ItemStack((IItemProvider)this);
            istack.func_77966_a(Enchantments.field_185304_p, 2);
            list.add((Object)istack);
        }
    }
}
