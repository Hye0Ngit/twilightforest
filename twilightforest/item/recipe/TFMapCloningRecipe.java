// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.RecipesMapCloning;

public class TFMapCloningRecipe extends RecipesMapCloning
{
    private final Item fullMapID;
    private final Item blankMapID;
    
    public TFMapCloningRecipe(final Item magicMap, final Item emptyMagicMap) {
        this.fullMapID = magicMap;
        this.blankMapID = emptyMagicMap;
    }
    
    public boolean func_77569_a(final InventoryCrafting inv, final World worldIn) {
        int i = 0;
        ItemStack itemstack = ItemStack.field_190927_a;
        for (int j = 0; j < inv.func_70302_i_(); ++j) {
            final ItemStack itemstack2 = inv.func_70301_a(j);
            if (!itemstack2.func_190926_b()) {
                if (itemstack2.func_77973_b() == this.fullMapID) {
                    if (!itemstack.func_190926_b()) {
                        return false;
                    }
                    itemstack = itemstack2;
                }
                else {
                    if (itemstack2.func_77973_b() != this.blankMapID) {
                        return false;
                    }
                    ++i;
                }
            }
        }
        return !itemstack.func_190926_b() && i > 0;
    }
    
    public ItemStack func_77572_b(final InventoryCrafting inv) {
        int i = 0;
        ItemStack itemstack = ItemStack.field_190927_a;
        for (int j = 0; j < inv.func_70302_i_(); ++j) {
            final ItemStack itemstack2 = inv.func_70301_a(j);
            if (!itemstack2.func_190926_b()) {
                if (itemstack2.func_77973_b() == this.fullMapID) {
                    if (!itemstack.func_190926_b()) {
                        return ItemStack.field_190927_a;
                    }
                    itemstack = itemstack2;
                }
                else {
                    if (itemstack2.func_77973_b() != this.blankMapID) {
                        return ItemStack.field_190927_a;
                    }
                    ++i;
                }
            }
        }
        if (!itemstack.func_190926_b() && i >= 1) {
            final ItemStack itemstack3 = new ItemStack(this.fullMapID, i + 1, itemstack.func_77960_j());
            if (itemstack.func_82837_s()) {
                itemstack3.func_151001_c(itemstack.func_82833_r());
            }
            if (itemstack.func_77942_o()) {
                itemstack3.func_77982_d(itemstack.func_77978_p());
            }
            return itemstack3;
        }
        return ItemStack.field_190927_a;
    }
}
