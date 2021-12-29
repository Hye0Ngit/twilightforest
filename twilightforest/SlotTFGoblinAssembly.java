// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import net.minecraft.inventory.IInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;

public class SlotTFGoblinAssembly extends Slot
{
    private EntityPlayer thePlayer;
    private IInventory inputSlot;
    private IInventory uncraftingMatrix;
    private IInventory assemblyMatrix;
    
    public SlotTFGoblinAssembly(final EntityPlayer par1EntityPlayer, final IInventory inputSlot, final IInventory assemblyMatrix, final IInventory uncraftingMatrix, final int slotNum, final int x, final int y) {
        super(assemblyMatrix, slotNum, x, y);
        this.thePlayer = par1EntityPlayer;
        this.inputSlot = inputSlot;
        this.uncraftingMatrix = uncraftingMatrix;
        this.assemblyMatrix = assemblyMatrix;
    }
}
