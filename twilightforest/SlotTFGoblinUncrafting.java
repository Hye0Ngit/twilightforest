// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class SlotTFGoblinUncrafting extends yu
{
    protected yw thePlayer;
    protected io inputSlot;
    protected InventoryTFGoblinUncrafting uncraftingMatrix;
    protected io assemblyMatrix;
    
    public SlotTFGoblinUncrafting(final yw par1EntityPlayer, final io inputSlot, final InventoryTFGoblinUncrafting uncraftingMatrix, final io assemblyMatrix, final int slotNum, final int x, final int y) {
        super((io)uncraftingMatrix, slotNum, x, y);
        this.thePlayer = par1EntityPlayer;
        this.inputSlot = inputSlot;
        this.uncraftingMatrix = uncraftingMatrix;
        this.assemblyMatrix = assemblyMatrix;
    }
    
    public boolean a(final aan par1ItemStack) {
        return false;
    }
    
    public void b(final aan par1ItemStack) {
        super.b(par1ItemStack);
        if (this.uncraftingMatrix.uncraftingCost > 0) {
            this.thePlayer.j(this.uncraftingMatrix.uncraftingCost);
        }
        for (int i = 0; i < 9; ++i) {
            final aan transferStack = this.uncraftingMatrix.k_(i);
            if (transferStack != null && transferStack.a > 0) {
                this.assemblyMatrix.a(i, transferStack.k());
            }
        }
        final aan inputStack = this.inputSlot.k_(0);
        if (inputStack != null) {
            this.inputSlot.a(0, this.uncraftingMatrix.numberOfInputItems);
        }
    }
}
