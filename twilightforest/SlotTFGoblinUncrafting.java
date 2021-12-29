// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class SlotTFGoblinUncrafting extends sr
{
    protected qx thePlayer;
    protected la inputSlot;
    protected InventoryTFGoblinUncrafting uncraftingMatrix;
    protected la assemblyMatrix;
    
    public SlotTFGoblinUncrafting(final qx par1EntityPlayer, final la inputSlot, final InventoryTFGoblinUncrafting uncraftingMatrix, final la assemblyMatrix, final int slotNum, final int x, final int y) {
        super((la)uncraftingMatrix, slotNum, x, y);
        this.thePlayer = par1EntityPlayer;
        this.inputSlot = inputSlot;
        this.uncraftingMatrix = uncraftingMatrix;
        this.assemblyMatrix = assemblyMatrix;
    }
    
    public boolean a(final ur par1ItemStack) {
        return false;
    }
    
    public void a(final qx par1EntityPlayer, final ur par1ItemStack) {
        super.a(par1EntityPlayer, par1ItemStack);
        if (this.uncraftingMatrix.uncraftingCost > 0) {
            this.thePlayer.a(-this.uncraftingMatrix.uncraftingCost);
        }
        for (int i = 0; i < 9; ++i) {
            final ur transferStack = this.uncraftingMatrix.a(i);
            if (transferStack != null && transferStack.a > 0) {
                this.assemblyMatrix.a(i, transferStack.l());
            }
        }
        final ur inputStack = this.inputSlot.a(0);
        if (inputStack != null) {
            this.inputSlot.a(0, this.uncraftingMatrix.numberOfInputItems);
        }
    }
}
