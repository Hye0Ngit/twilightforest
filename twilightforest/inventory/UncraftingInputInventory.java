// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.inventory;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.IInventory;

public class UncraftingInputInventory implements IInventory
{
    private ItemStack stack;
    private final UncraftingContainer container;
    
    public UncraftingInputInventory(final UncraftingContainer containerTFGoblinCrafting) {
        this.stack = ItemStack.field_190927_a;
        this.container = containerTFGoblinCrafting;
    }
    
    public int func_70302_i_() {
        return 1;
    }
    
    public boolean func_191420_l() {
        return this.stack.func_190926_b();
    }
    
    public ItemStack func_70301_a(final int index) {
        return (index == 0) ? this.stack : ItemStack.field_190927_a;
    }
    
    public ItemStack func_70298_a(final int index, final int amount) {
        if (index != 0 || this.stack.func_190926_b()) {
            return ItemStack.field_190927_a;
        }
        if (this.stack.func_190916_E() <= amount) {
            final ItemStack takenStack = this.stack;
            this.stack = ItemStack.field_190927_a;
            this.container.func_75130_a((IInventory)this);
            return takenStack;
        }
        final ItemStack takenStack = this.stack.func_77979_a(amount);
        this.container.func_75130_a((IInventory)this);
        return takenStack;
    }
    
    public ItemStack func_70304_b(final int index) {
        if (index == 0 && !this.stack.func_190926_b()) {
            final ItemStack stack = this.stack;
            this.stack = ItemStack.field_190927_a;
            return stack;
        }
        return ItemStack.field_190927_a;
    }
    
    public void func_70299_a(final int index, final ItemStack stack) {
        if (index == 0) {
            this.stack = stack;
            this.container.func_75130_a((IInventory)this);
        }
    }
    
    public void func_70296_d() {
        this.container.func_75130_a((IInventory)this);
    }
    
    public boolean func_70300_a(final PlayerEntity player) {
        return true;
    }
    
    public void func_174888_l() {
        this.stack = ItemStack.field_190927_a;
    }
}
