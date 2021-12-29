// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class SlotTFGoblinUncrafting extends uf
{
    protected sk thePlayer;
    protected lt inputSlot;
    protected InventoryTFGoblinUncrafting uncraftingMatrix;
    protected lt assemblyMatrix;
    
    public SlotTFGoblinUncrafting(final sk par1EntityPlayer, final lt inputSlot, final InventoryTFGoblinUncrafting uncraftingMatrix, final lt assemblyMatrix, final int slotNum, final int x, final int y) {
        super((lt)uncraftingMatrix, slotNum, x, y);
        this.thePlayer = par1EntityPlayer;
        this.inputSlot = inputSlot;
        this.uncraftingMatrix = uncraftingMatrix;
        this.assemblyMatrix = assemblyMatrix;
    }
    
    public boolean a(final wg par1ItemStack) {
        return false;
    }
    
    public void a(final sk par1EntityPlayer, final wg par1ItemStack) {
        super.a(par1EntityPlayer, par1ItemStack);
        if (this.uncraftingMatrix.uncraftingCost > 0) {
            this.thePlayer.a(-this.uncraftingMatrix.uncraftingCost);
        }
        for (int i = 0; i < 9; ++i) {
            final wg transferStack = this.uncraftingMatrix.a(i);
            if (transferStack != null && transferStack.a > 0) {
                this.assemblyMatrix.a(i, transferStack.m());
            }
        }
        final wg inputStack = this.inputSlot.a(0);
        if (inputStack != null) {
            this.inputSlot.a(0, this.uncraftingMatrix.numberOfInputItems);
        }
    }
}
