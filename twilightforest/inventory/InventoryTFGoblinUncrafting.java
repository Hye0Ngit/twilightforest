// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.inventory;

import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.ITextComponent;
import twilightforest.TFConfig;
import net.minecraft.entity.player.EntityPlayer;
import java.util.Iterator;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.inventory.IInventory;

public class InventoryTFGoblinUncrafting implements IInventory
{
    private final NonNullList<ItemStack> contents;
    public int numberOfInputItems;
    public int uncraftingCost;
    public int recraftingCost;
    
    public InventoryTFGoblinUncrafting(final ContainerTFUncrafting container) {
        this.contents = (NonNullList<ItemStack>)NonNullList.func_191197_a(9, (Object)ItemStack.field_190927_a);
    }
    
    public int func_70302_i_() {
        return 9;
    }
    
    public boolean func_191420_l() {
        for (final ItemStack stack : this.contents) {
            if (!stack.func_190926_b()) {
                return false;
            }
        }
        return true;
    }
    
    public ItemStack func_70301_a(final int index) {
        return (ItemStack)this.contents.get(index);
    }
    
    public ItemStack func_70298_a(final int index, final int amount) {
        final ItemStack stack = (ItemStack)this.contents.get(index);
        if (stack.func_190926_b()) {
            return ItemStack.field_190927_a;
        }
        if (stack.func_190916_E() <= amount) {
            this.contents.set(index, (Object)ItemStack.field_190927_a);
            return stack;
        }
        return stack.func_77979_a(amount);
    }
    
    public ItemStack func_70304_b(final int index) {
        final ItemStack stack = (ItemStack)this.contents.get(index);
        if (stack.func_190926_b()) {
            return ItemStack.field_190927_a;
        }
        this.contents.set(index, (Object)ItemStack.field_190927_a);
        return stack;
    }
    
    public void func_70299_a(final int index, final ItemStack stack) {
        this.contents.set(index, (Object)stack);
        if (!stack.func_190926_b() && stack.func_190916_E() > this.func_70297_j_()) {
            stack.func_190920_e(this.func_70297_j_());
        }
        this.func_70296_d();
    }
    
    public String func_70005_c_() {
        return "twilightforest.goblincrafting";
    }
    
    public int func_70297_j_() {
        return 64;
    }
    
    public void func_70296_d() {
    }
    
    public boolean func_70300_a(final EntityPlayer player) {
        return !TFConfig.disableUncrafting;
    }
    
    public void func_174889_b(final EntityPlayer player) {
    }
    
    public void func_174886_c(final EntityPlayer player) {
    }
    
    public boolean func_94041_b(final int index, final ItemStack stack) {
        return false;
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
        this.contents.clear();
    }
    
    public boolean func_145818_k_() {
        return false;
    }
    
    public ITextComponent func_145748_c_() {
        return (ITextComponent)new TextComponentString(this.func_70005_c_());
    }
}
