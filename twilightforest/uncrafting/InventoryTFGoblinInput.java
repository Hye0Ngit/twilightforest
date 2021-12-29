// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.uncrafting;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.IInventory;

public class InventoryTFGoblinInput implements IInventory
{
    private ItemStack[] stackInput;
    private ContainerTFUncrafting craftingContainer;
    
    public InventoryTFGoblinInput(final ContainerTFUncrafting containerTFGoblinCrafting) {
        this.stackInput = new ItemStack[1];
        this.craftingContainer = containerTFGoblinCrafting;
    }
    
    public int func_70302_i_() {
        return 1;
    }
    
    public ItemStack func_70301_a(final int par1) {
        return this.stackInput[par1];
    }
    
    public String func_145825_b() {
        return "Input";
    }
    
    public ItemStack func_70298_a(final int slotNum, final int amount) {
        if (this.stackInput[slotNum] == null) {
            return null;
        }
        if (this.stackInput[slotNum].field_77994_a <= amount) {
            final ItemStack takenStack = this.stackInput[slotNum];
            this.stackInput[slotNum] = null;
            this.craftingContainer.func_75130_a((IInventory)this);
            return takenStack;
        }
        final ItemStack takenStack = this.stackInput[slotNum].func_77979_a(amount);
        if (this.stackInput[slotNum].field_77994_a == 0) {
            this.stackInput[slotNum] = null;
        }
        this.craftingContainer.func_75130_a((IInventory)this);
        return takenStack;
    }
    
    public ItemStack func_70304_b(final int par1) {
        if (this.stackInput[par1] != null) {
            final ItemStack var2 = this.stackInput[par1];
            this.stackInput[par1] = null;
            return var2;
        }
        return null;
    }
    
    public void func_70299_a(final int par1, final ItemStack par2ItemStack) {
        this.stackInput[par1] = par2ItemStack;
        this.craftingContainer.func_75130_a((IInventory)this);
    }
    
    public int func_70297_j_() {
        return 64;
    }
    
    public void func_70296_d() {
        this.craftingContainer.func_75130_a((IInventory)this);
    }
    
    public boolean func_70300_a(final EntityPlayer par1EntityPlayer) {
        return true;
    }
    
    public void func_70295_k_() {
    }
    
    public void func_70305_f() {
    }
    
    public boolean func_94041_b(final int par1, final ItemStack par2ItemStack) {
        return true;
    }
    
    public boolean func_145818_k_() {
        return false;
    }
}
