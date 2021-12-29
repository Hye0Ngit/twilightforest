// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class SlotTFGoblinCraftResult extends ue
{
    protected sk thePlayer;
    protected lt inputSlot;
    protected InventoryTFGoblinUncrafting uncraftingMatrix;
    protected tl assemblyMatrix;
    protected lt resultSlot;
    
    public SlotTFGoblinCraftResult(final sk player, final lt input, final lt uncraftingMatrix, final lt assemblyMatrix, final lt result, final int slotIndex, final int x, final int y) {
        super(player, assemblyMatrix, result, slotIndex, x, y);
        this.thePlayer = player;
        this.inputSlot = input;
        this.uncraftingMatrix = (InventoryTFGoblinUncrafting)uncraftingMatrix;
        this.assemblyMatrix = (tl)assemblyMatrix;
    }
    
    public void a(final sk par1EntityPlayer, final wg par1ItemStack) {
        boolean combined = true;
        if (wg.b(ye.a().a(this.assemblyMatrix, this.thePlayer.q), par1ItemStack)) {
            combined = false;
        }
        if (combined) {
            if (this.uncraftingMatrix.recraftingCost > 0) {
                this.thePlayer.a(-this.uncraftingMatrix.recraftingCost);
            }
            for (int i = 0; i < this.uncraftingMatrix.j_(); ++i) {
                this.uncraftingMatrix.a(i, null);
                this.inputSlot.a(0, this.uncraftingMatrix.numberOfInputItems);
            }
        }
        super.a(par1EntityPlayer, par1ItemStack);
    }
}
