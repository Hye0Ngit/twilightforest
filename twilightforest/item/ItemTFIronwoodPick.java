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
import net.minecraft.item.ItemPickaxe;

public class ItemTFIronwoodPick extends ItemPickaxe implements ModelRegisterCallback
{
    protected ItemTFIronwoodPick(final Item.ToolMaterial material) {
        super(material);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public void func_150895_a(final CreativeTabs tab, final NonNullList<ItemStack> list) {
        if (this.func_194125_a(tab)) {
            final ItemStack istack = new ItemStack((Item)this);
            istack.func_77966_a(Enchantments.field_185305_q, 1);
            list.add((Object)istack);
        }
    }
}
