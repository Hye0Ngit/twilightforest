// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.inventory;

import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.SlotCrafting;

public class SlotTFGoblinCraftResult extends SlotCrafting
{
    private final EntityPlayer player;
    private final IInventory inputSlot;
    private final InventoryTFGoblinUncrafting uncraftingMatrix;
    private final InventoryCrafting assemblyMatrix;
    
    public SlotTFGoblinCraftResult(final EntityPlayer player, final IInventory input, final IInventory uncraftingMatrix, final IInventory assemblyMatrix, final IInventory result, final int slotIndex, final int x, final int y) {
        super(player, (InventoryCrafting)assemblyMatrix, result, slotIndex, x, y);
        this.player = player;
        this.inputSlot = input;
        this.uncraftingMatrix = (InventoryTFGoblinUncrafting)uncraftingMatrix;
        this.assemblyMatrix = (InventoryCrafting)assemblyMatrix;
    }
    
    public ItemStack func_190901_a(final EntityPlayer player, final ItemStack stack) {
        boolean combined = true;
        if (ItemStack.func_77989_b(CraftingManager.func_82787_a(this.assemblyMatrix, this.player.field_70170_p), stack)) {
            combined = false;
        }
        if (combined) {
            if (this.uncraftingMatrix.recraftingCost > 0) {
                this.player.func_82242_a(-this.uncraftingMatrix.recraftingCost);
            }
            for (int i = 0; i < this.uncraftingMatrix.func_70302_i_(); ++i) {
                this.uncraftingMatrix.func_70299_a(i, ItemStack.field_190927_a);
                this.inputSlot.func_70298_a(0, this.uncraftingMatrix.numberOfInputItems);
            }
        }
        return super.func_190901_a(player, stack);
    }
}
