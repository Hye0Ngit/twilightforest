// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.item.ItemSpade;

public class ItemTFSteeleafShovel extends ItemSpade implements ModelRegisterCallback
{
    public ItemTFSteeleafShovel(final Item.ToolMaterial toolMaterial) {
        super(toolMaterial);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public void func_150895_a(final CreativeTabs tab, final NonNullList<ItemStack> list) {
        if (this.func_194125_a(tab)) {
            final ItemStack istack = new ItemStack((Item)this);
            istack.func_77966_a(Enchantments.field_185305_q, 2);
            list.add((Object)istack);
        }
    }
}
