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
import net.minecraft.item.ItemAxe;

public class ItemTFIronwoodAxe extends ItemAxe implements ModelRegisterCallback
{
    protected ItemTFIronwoodAxe(final Item.ToolMaterial material) {
        super(material, 6.0f + material.func_78000_c(), material.func_77998_b() * 0.05f - 3.4f);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public void func_150895_a(final CreativeTabs tab, final NonNullList<ItemStack> list) {
        if (this.func_194125_a(tab)) {
            final ItemStack istack = new ItemStack((Item)this);
            istack.func_77966_a(Enchantments.field_185308_t, 1);
            list.add((Object)istack);
        }
    }
}
