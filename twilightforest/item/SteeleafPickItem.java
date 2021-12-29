// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.PickaxeItem;

public class SteeleafPickItem extends PickaxeItem
{
    protected SteeleafPickItem(final Tier material, final Item.Properties props) {
        super(material, 1, -2.8f, props);
    }
    
    public void m_6787_(final CreativeModeTab tab, final NonNullList<ItemStack> list) {
        if (this.m_41389_(tab)) {
            final ItemStack istack = new ItemStack((ItemLike)this);
            istack.m_41663_(Enchantments.f_44987_, 2);
            list.add((Object)istack);
        }
    }
}
