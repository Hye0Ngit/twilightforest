// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class SlotTFGoblinUncrafting extends wd
{
    protected ue thePlayer;
    protected mn inputSlot;
    protected InventoryTFGoblinUncrafting uncraftingMatrix;
    protected mn assemblyMatrix;
    
    public SlotTFGoblinUncrafting(final ue par1EntityPlayer, final mn inputSlot, final InventoryTFGoblinUncrafting uncraftingMatrix, final mn assemblyMatrix, final int slotNum, final int x, final int y) {
        super((mn)uncraftingMatrix, slotNum, x, y);
        this.thePlayer = par1EntityPlayer;
        this.inputSlot = inputSlot;
        this.uncraftingMatrix = uncraftingMatrix;
        this.assemblyMatrix = assemblyMatrix;
    }
    
    public boolean a(final yd par1ItemStack) {
        return false;
    }
    
    public void a(final ue par1EntityPlayer, final yd par1ItemStack) {
        super.a(par1EntityPlayer, par1ItemStack);
        if (this.uncraftingMatrix.uncraftingCost > 0) {
            this.thePlayer.a(-this.uncraftingMatrix.uncraftingCost);
        }
        for (int i = 0; i < 9; ++i) {
            final yd transferStack = this.uncraftingMatrix.a(i);
            if (transferStack != null && transferStack.b > 0) {
                this.assemblyMatrix.a(i, transferStack.m());
            }
        }
        final yd inputStack = this.inputSlot.a(0);
        if (inputStack != null) {
            this.inputSlot.a(0, this.uncraftingMatrix.numberOfInputItems);
        }
    }
}
