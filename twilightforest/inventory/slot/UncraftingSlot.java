// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.inventory.slot;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import twilightforest.TFConfig;
import twilightforest.inventory.UncraftingContainer;
import net.minecraft.item.ItemStack;
import twilightforest.inventory.UncraftingInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.Slot;

public class UncraftingSlot extends Slot
{
    protected final PlayerEntity player;
    protected final IInventory inputSlot;
    protected final UncraftingInventory uncraftingMatrix;
    protected final IInventory assemblyMatrix;
    
    public UncraftingSlot(final PlayerEntity player, final IInventory inputSlot, final UncraftingInventory uncraftingMatrix, final IInventory assemblyMatrix, final int slotNum, final int x, final int y) {
        super((IInventory)uncraftingMatrix, slotNum, x, y);
        this.player = player;
        this.inputSlot = inputSlot;
        this.uncraftingMatrix = uncraftingMatrix;
        this.assemblyMatrix = assemblyMatrix;
    }
    
    public boolean func_75214_a(final ItemStack stack) {
        return false;
    }
    
    public boolean func_82869_a(final PlayerEntity player) {
        return this.assemblyMatrix.func_191420_l() && !UncraftingContainer.isMarked(this.func_75211_c()) && !(boolean)TFConfig.COMMON_CONFIG.disableUncrafting.get() && (this.uncraftingMatrix.uncraftingCost <= player.field_71068_ca || player.field_71075_bZ.field_75098_d);
    }
    
    public ItemStack func_190901_a(final PlayerEntity player, final ItemStack stack) {
        if (this.uncraftingMatrix.uncraftingCost > 0) {
            this.player.func_82242_a(-this.uncraftingMatrix.uncraftingCost);
        }
        for (int i = 0; i < 9; ++i) {
            final ItemStack transferStack = this.uncraftingMatrix.func_70301_a(i);
            if (!transferStack.func_190926_b() && !UncraftingContainer.isMarked(transferStack)) {
                this.assemblyMatrix.func_70299_a(i, transferStack.func_77946_l());
            }
        }
        final ItemStack inputStack = this.inputSlot.func_70301_a(0);
        if (!inputStack.func_190926_b()) {
            this.inputSlot.func_70298_a(0, this.uncraftingMatrix.numberOfInputItems);
        }
        return super.func_190901_a(player, stack);
    }
    
    @OnlyIn(Dist.CLIENT)
    public boolean func_111238_b() {
        return false;
    }
}
