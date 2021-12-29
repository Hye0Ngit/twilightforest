// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.inventory;

import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.IInventory;

public class InventoryTFGoblinInput implements IInventory
{
    private ItemStack stackInput;
    private final ContainerTFUncrafting craftingContainer;
    
    public InventoryTFGoblinInput(final ContainerTFUncrafting containerTFGoblinCrafting) {
        this.stackInput = ItemStack.field_190927_a;
        this.craftingContainer = containerTFGoblinCrafting;
    }
    
    public int func_70302_i_() {
        return 1;
    }
    
    public boolean func_191420_l() {
        return this.stackInput.func_190926_b();
    }
    
    public ItemStack func_70301_a(final int index) {
        return (index == 0) ? this.stackInput : ItemStack.field_190927_a;
    }
    
    public String func_70005_c_() {
        return "Input";
    }
    
    public ItemStack func_70298_a(final int index, final int amount) {
        if (index != 0 || this.stackInput.func_190926_b()) {
            return ItemStack.field_190927_a;
        }
        if (this.stackInput.func_190916_E() <= amount) {
            final ItemStack takenStack = this.stackInput;
            this.stackInput = ItemStack.field_190927_a;
            this.craftingContainer.func_75130_a((IInventory)this);
            return takenStack;
        }
        final ItemStack takenStack = this.stackInput.func_77979_a(amount);
        this.craftingContainer.func_75130_a((IInventory)this);
        return takenStack;
    }
    
    public ItemStack func_70304_b(final int index) {
        if (index == 0 && !this.stackInput.func_190926_b()) {
            final ItemStack stack = this.stackInput;
            this.stackInput = ItemStack.field_190927_a;
            return stack;
        }
        return ItemStack.field_190927_a;
    }
    
    public void func_70299_a(final int index, final ItemStack stack) {
        if (index == 0) {
            this.stackInput = stack;
            this.craftingContainer.func_75130_a((IInventory)this);
        }
    }
    
    public int func_70297_j_() {
        return 64;
    }
    
    public void func_70296_d() {
        this.craftingContainer.func_75130_a((IInventory)this);
    }
    
    public boolean func_70300_a(final EntityPlayer player) {
        return true;
    }
    
    public void func_174889_b(final EntityPlayer player) {
    }
    
    public void func_174886_c(final EntityPlayer player) {
    }
    
    public boolean func_94041_b(final int index, final ItemStack stack) {
        return true;
    }
    
    public int func_174887_a_(final int id) {
        return 0;
    }
    
    public void func_174885_b(final int id, final int value) {
    }
    
    public int func_174890_g() {
        return 0;
    }
    
    public void func_174888_l() {
        this.stackInput = ItemStack.field_190927_a;
    }
    
    public boolean func_145818_k_() {
        return false;
    }
    
    public ITextComponent func_145748_c_() {
        return (ITextComponent)new TextComponentString(this.func_70005_c_());
    }
}
