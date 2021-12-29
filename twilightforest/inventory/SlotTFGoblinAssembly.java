// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.inventory;

import net.minecraft.inventory.IInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;

public class SlotTFGoblinAssembly extends Slot
{
    public SlotTFGoblinAssembly(final EntityPlayer par1EntityPlayer, final IInventory inputSlot, final IInventory assemblyMatrix, final IInventory uncraftingMatrix, final int slotNum, final int x, final int y) {
        super(assemblyMatrix, slotNum, x, y);
    }
}
