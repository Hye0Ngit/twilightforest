// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.IInventory;

public class InventoryTFGoblinUncrafting implements IInventory
{
    private ItemStack[] contents;
    public int numberOfInputItems;
    public int uncraftingCost;
    public int recraftingCost;
    
    public InventoryTFGoblinUncrafting(final ContainerTFUncrafting containerTFGoblinCrafting) {
        this.contents = new ItemStack[9];
    }
    
    public int func_70302_i_() {
        return 9;
    }
    
    public ItemStack func_70301_a(final int var1) {
        return this.contents[var1];
    }
    
    public ItemStack func_70298_a(final int slotNum, final int amount) {
        if (this.contents[slotNum] == null) {
            return null;
        }
        if (this.contents[slotNum].field_77994_a <= amount) {
            final ItemStack takenStack = this.contents[slotNum];
            this.contents[slotNum] = null;
            return takenStack;
        }
        final ItemStack takenStack = this.contents[slotNum].func_77979_a(amount);
        if (this.contents[slotNum].field_77994_a == 0) {
            this.contents[slotNum] = null;
        }
        return takenStack;
    }
    
    public ItemStack func_70304_b(final int par1) {
        if (this.contents[par1] != null) {
            final ItemStack var2 = this.contents[par1];
            this.contents[par1] = null;
            return var2;
        }
        return null;
    }
    
    public void func_70299_a(final int par1, final ItemStack par2ItemStack) {
        this.contents[par1] = par2ItemStack;
        if (par2ItemStack != null && par2ItemStack.field_77994_a > this.func_70297_j_()) {
            par2ItemStack.field_77994_a = this.func_70297_j_();
        }
        this.func_70296_d();
    }
    
    public String func_70303_b() {
        return "twilightforest.goblincrafting";
    }
    
    public int func_70297_j_() {
        return 64;
    }
    
    public void func_70296_d() {
    }
    
    public boolean func_70300_a(final EntityPlayer var1) {
        return true;
    }
    
    public void func_70295_k_() {
    }
    
    public void func_70305_f() {
    }
    
    public boolean func_94041_b(final int par1, final ItemStack par2ItemStack) {
        return false;
    }
    
    public boolean func_94042_c() {
        return false;
    }
}
