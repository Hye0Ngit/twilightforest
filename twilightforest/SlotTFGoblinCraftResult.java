// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.SlotCrafting;

public class SlotTFGoblinCraftResult extends SlotCrafting
{
    protected EntityPlayer thePlayer;
    protected IInventory inputSlot;
    protected InventoryTFGoblinUncrafting uncraftingMatrix;
    protected InventoryCrafting assemblyMatrix;
    protected IInventory resultSlot;
    
    public SlotTFGoblinCraftResult(final EntityPlayer player, final IInventory input, final IInventory uncraftingMatrix, final IInventory assemblyMatrix, final IInventory result, final int slotIndex, final int x, final int y) {
        super(player, assemblyMatrix, result, slotIndex, x, y);
        this.thePlayer = player;
        this.inputSlot = input;
        this.uncraftingMatrix = (InventoryTFGoblinUncrafting)uncraftingMatrix;
        this.assemblyMatrix = (InventoryCrafting)assemblyMatrix;
    }
    
    public void func_82870_a(final EntityPlayer par1EntityPlayer, final ItemStack par1ItemStack) {
        boolean combined = true;
        if (ItemStack.func_77989_b(CraftingManager.func_77594_a().func_82787_a(this.assemblyMatrix, this.thePlayer.field_70170_p), par1ItemStack)) {
            combined = false;
        }
        if (combined) {
            if (this.uncraftingMatrix.recraftingCost > 0) {
                this.thePlayer.func_82242_a(-this.uncraftingMatrix.recraftingCost);
            }
            for (int i = 0; i < this.uncraftingMatrix.func_70302_i_(); ++i) {
                this.uncraftingMatrix.func_70299_a(i, null);
                this.inputSlot.func_70298_a(0, this.uncraftingMatrix.numberOfInputItems);
            }
        }
        super.func_82870_a(par1EntityPlayer, par1ItemStack);
    }
}
