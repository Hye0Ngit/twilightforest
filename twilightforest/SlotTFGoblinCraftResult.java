// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class SlotTFGoblinCraftResult extends sp
{
    protected qx thePlayer;
    protected la inputSlot;
    protected InventoryTFGoblinUncrafting uncraftingMatrix;
    protected rx assemblyMatrix;
    protected la resultSlot;
    
    public SlotTFGoblinCraftResult(final qx player, final la input, final la uncraftingMatrix, final la assemblyMatrix, final la result, final int slotIndex, final int x, final int y) {
        super(player, assemblyMatrix, result, slotIndex, x, y);
        this.thePlayer = player;
        this.inputSlot = input;
        this.uncraftingMatrix = (InventoryTFGoblinUncrafting)uncraftingMatrix;
        this.assemblyMatrix = (rx)assemblyMatrix;
    }
    
    public void a(final qx par1EntityPlayer, final um par1ItemStack) {
        boolean combined = true;
        if (um.b(wh.a().a(this.assemblyMatrix, this.thePlayer.p), par1ItemStack)) {
            combined = false;
        }
        if (combined) {
            if (this.uncraftingMatrix.recraftingCost > 0) {
                this.thePlayer.a(-this.uncraftingMatrix.recraftingCost);
            }
            for (int i = 0; i < this.uncraftingMatrix.k_(); ++i) {
                this.uncraftingMatrix.a(i, null);
                this.inputSlot.a(0, this.uncraftingMatrix.numberOfInputItems);
            }
        }
        super.a(par1EntityPlayer, par1ItemStack);
    }
}
