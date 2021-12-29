// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class SlotTFGoblinAssembly extends wd
{
    private ue thePlayer;
    private mn inputSlot;
    private mn uncraftingMatrix;
    private mn assemblyMatrix;
    
    public SlotTFGoblinAssembly(final ue par1EntityPlayer, final mn inputSlot, final mn assemblyMatrix, final mn uncraftingMatrix, final int slotNum, final int x, final int y) {
        super(assemblyMatrix, slotNum, x, y);
        this.thePlayer = par1EntityPlayer;
        this.inputSlot = inputSlot;
        this.uncraftingMatrix = uncraftingMatrix;
        this.assemblyMatrix = assemblyMatrix;
    }
}
