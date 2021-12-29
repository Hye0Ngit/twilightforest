// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.crafting.IRecipe;

public class TFMapCloningRecipe implements IRecipe
{
    public int fullMapID;
    public int blankMapID;
    
    public TFMapCloningRecipe(final int map, final int blank) {
        this.fullMapID = map;
        this.blankMapID = blank;
    }
    
    public boolean func_77569_a(final InventoryCrafting par1InventoryCrafting, final World par2World) {
        int var3 = 0;
        ItemStack var4 = null;
        for (int var5 = 0; var5 < par1InventoryCrafting.func_70302_i_(); ++var5) {
            final ItemStack var6 = par1InventoryCrafting.func_70301_a(var5);
            if (var6 != null) {
                if (var6.field_77993_c == this.fullMapID) {
                    if (var4 != null) {
                        return false;
                    }
                    var4 = var6;
                }
                else {
                    if (var6.field_77993_c != this.blankMapID) {
                        return false;
                    }
                    ++var3;
                }
            }
        }
        return var4 != null && var3 > 0;
    }
    
    public ItemStack func_77572_b(final InventoryCrafting par1InventoryCrafting) {
        int var2 = 0;
        ItemStack var3 = null;
        for (int var4 = 0; var4 < par1InventoryCrafting.func_70302_i_(); ++var4) {
            final ItemStack var5 = par1InventoryCrafting.func_70301_a(var4);
            if (var5 != null) {
                if (var5.field_77993_c == this.fullMapID) {
                    if (var3 != null) {
                        return null;
                    }
                    var3 = var5;
                }
                else {
                    if (var5.field_77993_c != this.blankMapID) {
                        return null;
                    }
                    ++var2;
                }
            }
        }
        if (var3 != null && var2 >= 1) {
            final ItemStack var6 = new ItemStack(this.fullMapID, var2 + 1, var3.func_77960_j());
            if (var3.func_82837_s()) {
                var6.func_82834_c(var3.func_82833_r());
            }
            return var6;
        }
        return null;
    }
    
    public int func_77570_a() {
        return 9;
    }
    
    public ItemStack func_77571_b() {
        return null;
    }
}
