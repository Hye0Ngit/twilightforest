// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class SlotTFGoblinCraftResult extends amn
{
    protected yw thePlayer;
    protected io inputSlot;
    protected InventoryTFGoblinUncrafting uncraftingMatrix;
    protected ade assemblyMatrix;
    protected io resultSlot;
    
    public SlotTFGoblinCraftResult(final yw player, final io input, final io uncraftingMatrix, final io assemblyMatrix, final io result, final int slotIndex, final int x, final int y) {
        super(player, assemblyMatrix, result, slotIndex, x, y);
        this.thePlayer = player;
        this.inputSlot = input;
        this.uncraftingMatrix = (InventoryTFGoblinUncrafting)uncraftingMatrix;
        this.assemblyMatrix = (ade)assemblyMatrix;
    }
    
    public void b(final aan par1ItemStack) {
        boolean combined = true;
        if (aan.b(fr.a().a(this.assemblyMatrix), par1ItemStack)) {
            combined = false;
        }
        if (combined) {
            if (this.uncraftingMatrix.recraftingCost > 0) {
                this.thePlayer.j(this.uncraftingMatrix.recraftingCost);
            }
            for (int i = 0; i < this.uncraftingMatrix.a(); ++i) {
                this.uncraftingMatrix.a(i, null);
                this.inputSlot.a(0, this.uncraftingMatrix.numberOfInputItems);
            }
        }
        super.b(par1ItemStack);
    }
}
