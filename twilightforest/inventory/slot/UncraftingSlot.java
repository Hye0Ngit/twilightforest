// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.inventory.slot;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import twilightforest.TFConfig;
import twilightforest.inventory.UncraftingContainer;
import net.minecraft.world.item.ItemStack;
import twilightforest.inventory.UncraftingInventory;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;

public class UncraftingSlot extends Slot
{
    protected final Player player;
    protected final Container inputSlot;
    protected final UncraftingInventory uncraftingMatrix;
    protected final Container assemblyMatrix;
    
    public UncraftingSlot(final Player player, final Container inputSlot, final UncraftingInventory uncraftingMatrix, final Container assemblyMatrix, final int slotNum, final int x, final int y) {
        super((Container)uncraftingMatrix, slotNum, x, y);
        this.player = player;
        this.inputSlot = inputSlot;
        this.uncraftingMatrix = uncraftingMatrix;
        this.assemblyMatrix = assemblyMatrix;
    }
    
    public boolean m_5857_(final ItemStack stack) {
        return false;
    }
    
    public boolean m_8010_(final Player player) {
        return this.assemblyMatrix.m_7983_() && !UncraftingContainer.isMarked(this.m_7993_()) && !(boolean)TFConfig.COMMON_CONFIG.UNCRAFTING_STUFFS.disableUncrafting.get() && (this.uncraftingMatrix.uncraftingCost <= player.f_36078_ || player.m_150110_().f_35937_);
    }
    
    public void m_142406_(final Player player, final ItemStack stack) {
        if (this.uncraftingMatrix.uncraftingCost > 0) {
            this.player.m_6749_(-this.uncraftingMatrix.uncraftingCost);
        }
        for (int i = 0; i < 9; ++i) {
            final ItemStack transferStack = this.uncraftingMatrix.m_8020_(i);
            if (!transferStack.m_41619_() && !UncraftingContainer.isMarked(transferStack)) {
                this.assemblyMatrix.m_6836_(i, transferStack.m_41777_());
            }
        }
        final ItemStack inputStack = this.inputSlot.m_8020_(0);
        if (!inputStack.m_41619_()) {
            this.inputSlot.m_7407_(0, this.uncraftingMatrix.numberOfInputItems);
        }
        super.m_142406_(player, stack);
    }
    
    @OnlyIn(Dist.CLIENT)
    public boolean m_6659_() {
        return false;
    }
}
