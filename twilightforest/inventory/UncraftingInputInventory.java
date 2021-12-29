// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.inventory;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.Container;

public class UncraftingInputInventory implements Container
{
    private ItemStack stack;
    private final UncraftingContainer container;
    
    public UncraftingInputInventory(final UncraftingContainer containerTFGoblinCrafting) {
        this.stack = ItemStack.f_41583_;
        this.container = containerTFGoblinCrafting;
    }
    
    public int m_6643_() {
        return 1;
    }
    
    public boolean m_7983_() {
        return this.stack.m_41619_();
    }
    
    public ItemStack m_8020_(final int index) {
        return (index == 0) ? this.stack : ItemStack.f_41583_;
    }
    
    public ItemStack m_7407_(final int index, final int amount) {
        if (index != 0 || this.stack.m_41619_()) {
            return ItemStack.f_41583_;
        }
        if (this.stack.m_41613_() <= amount) {
            final ItemStack takenStack = this.stack;
            this.stack = ItemStack.f_41583_;
            this.container.m_6199_((Container)this);
            return takenStack;
        }
        final ItemStack takenStack = this.stack.m_41620_(amount);
        this.container.m_6199_((Container)this);
        return takenStack;
    }
    
    public ItemStack m_8016_(final int index) {
        if (index == 0 && !this.stack.m_41619_()) {
            final ItemStack stack = this.stack;
            this.stack = ItemStack.f_41583_;
            return stack;
        }
        return ItemStack.f_41583_;
    }
    
    public void m_6836_(final int index, final ItemStack stack) {
        if (index == 0) {
            this.stack = stack;
            this.container.m_6199_((Container)this);
        }
    }
    
    public void m_6596_() {
        this.container.m_6199_((Container)this);
    }
    
    public boolean m_6542_(final Player player) {
        return true;
    }
    
    public void m_6211_() {
        this.stack = ItemStack.f_41583_;
    }
}
