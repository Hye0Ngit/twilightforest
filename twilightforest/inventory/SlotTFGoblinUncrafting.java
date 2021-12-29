// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.inventory;

import twilightforest.TwilightForestMod;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.IInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;

public class SlotTFGoblinUncrafting extends Slot
{
    protected EntityPlayer thePlayer;
    protected IInventory inputSlot;
    protected InventoryTFGoblinUncrafting uncraftingMatrix;
    protected IInventory assemblyMatrix;
    
    public SlotTFGoblinUncrafting(final EntityPlayer par1EntityPlayer, final IInventory inputSlot, final InventoryTFGoblinUncrafting uncraftingMatrix, final IInventory assemblyMatrix, final int slotNum, final int x, final int y) {
        super((IInventory)uncraftingMatrix, slotNum, x, y);
        this.thePlayer = par1EntityPlayer;
        this.inputSlot = inputSlot;
        this.uncraftingMatrix = uncraftingMatrix;
        this.assemblyMatrix = assemblyMatrix;
    }
    
    public boolean func_75214_a(final ItemStack par1ItemStack) {
        return false;
    }
    
    public boolean func_82869_a(final EntityPlayer par1EntityPlayer) {
        for (int i = 0; i < this.assemblyMatrix.func_70302_i_(); ++i) {
            if (this.assemblyMatrix.func_70301_a(i) != null) {
                return false;
            }
        }
        return !TwilightForestMod.disableUncrafting && (this.uncraftingMatrix.uncraftingCost <= par1EntityPlayer.field_71068_ca || par1EntityPlayer.field_71075_bZ.field_75098_d);
    }
    
    public void func_82870_a(final EntityPlayer par1EntityPlayer, final ItemStack par1ItemStack) {
        super.func_82870_a(par1EntityPlayer, par1ItemStack);
        if (this.uncraftingMatrix.uncraftingCost > 0) {
            this.thePlayer.func_82242_a(-this.uncraftingMatrix.uncraftingCost);
        }
        for (int i = 0; i < 9; ++i) {
            final ItemStack transferStack = this.uncraftingMatrix.func_70301_a(i);
            if (transferStack != null && transferStack.field_77994_a > 0) {
                this.assemblyMatrix.func_70299_a(i, transferStack.func_77946_l());
            }
        }
        final ItemStack inputStack = this.inputSlot.func_70301_a(0);
        if (inputStack != null) {
            this.inputSlot.func_70298_a(0, this.uncraftingMatrix.numberOfInputItems);
        }
    }
}
