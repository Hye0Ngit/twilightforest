// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class SlotTFGoblinCraftResult extends wc
{
    protected ue b;
    protected mn inputSlot;
    protected InventoryTFGoblinUncrafting uncraftingMatrix;
    protected vj assemblyMatrix;
    protected mn resultSlot;
    
    public SlotTFGoblinCraftResult(final ue player, final mn input, final mn uncraftingMatrix, final mn assemblyMatrix, final mn result, final int slotIndex, final int x, final int y) {
        super(player, assemblyMatrix, result, slotIndex, x, y);
        this.b = player;
        this.inputSlot = input;
        this.uncraftingMatrix = (InventoryTFGoblinUncrafting)uncraftingMatrix;
        this.assemblyMatrix = (vj)assemblyMatrix;
    }
    
    public void a(final ue par1EntityPlayer, final yd par1ItemStack) {
        boolean combined = true;
        if (yd.b(aae.a().a(this.assemblyMatrix, this.b.q), par1ItemStack)) {
            combined = false;
        }
        if (combined) {
            if (this.uncraftingMatrix.recraftingCost > 0) {
                this.b.a(-this.uncraftingMatrix.recraftingCost);
            }
            for (int i = 0; i < this.uncraftingMatrix.j_(); ++i) {
                this.uncraftingMatrix.a(i, null);
                this.inputSlot.a(0, this.uncraftingMatrix.numberOfInputItems);
            }
        }
        super.a(par1EntityPlayer, par1ItemStack);
    }
}
