// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.inventory;

import twilightforest.TFConfig;
import net.minecraft.world.entity.player.Player;
import java.util.Iterator;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.NonNullList;
import net.minecraft.world.Container;

public class UncraftingInventory implements Container
{
    private final NonNullList<ItemStack> contents;
    public int numberOfInputItems;
    public int uncraftingCost;
    public int recraftingCost;
    
    public UncraftingInventory() {
        this.contents = (NonNullList<ItemStack>)NonNullList.m_122780_(9, (Object)ItemStack.f_41583_);
    }
    
    public int m_6643_() {
        return 9;
    }
    
    public boolean m_7983_() {
        for (final ItemStack stack : this.contents) {
            if (!stack.m_41619_()) {
                return false;
            }
        }
        return true;
    }
    
    public ItemStack m_8020_(final int index) {
        return (ItemStack)this.contents.get(index);
    }
    
    public ItemStack m_7407_(final int index, final int amount) {
        final ItemStack stack = (ItemStack)this.contents.get(index);
        if (stack.m_41619_()) {
            return ItemStack.f_41583_;
        }
        if (stack.m_41613_() <= amount) {
            this.contents.set(index, (Object)ItemStack.f_41583_);
            return stack;
        }
        return stack.m_41620_(amount);
    }
    
    public ItemStack m_8016_(final int index) {
        final ItemStack stack = (ItemStack)this.contents.get(index);
        if (stack.m_41619_()) {
            return ItemStack.f_41583_;
        }
        this.contents.set(index, (Object)ItemStack.f_41583_);
        return stack;
    }
    
    public void m_6836_(final int index, final ItemStack stack) {
        this.contents.set(index, (Object)stack);
        if (!stack.m_41619_() && stack.m_41613_() > this.m_6893_()) {
            stack.m_41764_(this.m_6893_());
        }
        this.m_6596_();
    }
    
    public int m_6893_() {
        return 64;
    }
    
    public void m_6596_() {
    }
    
    public boolean m_6542_(final Player player) {
        return !(boolean)TFConfig.COMMON_CONFIG.UNCRAFTING_STUFFS.disableUncrafting.get();
    }
    
    public void m_5856_(final Player player) {
    }
    
    public void m_5785_(final Player player) {
    }
    
    public boolean m_7013_(final int index, final ItemStack stack) {
        return false;
    }
    
    public void m_6211_() {
        this.contents.clear();
    }
}
