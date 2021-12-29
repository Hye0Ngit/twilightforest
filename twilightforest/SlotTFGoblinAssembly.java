// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class SlotTFGoblinAssembly extends sq
{
    private qx thePlayer;
    private la inputSlot;
    private la uncraftingMatrix;
    private la assemblyMatrix;
    
    public SlotTFGoblinAssembly(final qx par1EntityPlayer, final la inputSlot, final la assemblyMatrix, final la uncraftingMatrix, final int slotNum, final int x, final int y) {
        super(assemblyMatrix, slotNum, x, y);
        this.thePlayer = par1EntityPlayer;
        this.inputSlot = inputSlot;
        this.uncraftingMatrix = uncraftingMatrix;
        this.assemblyMatrix = assemblyMatrix;
    }
}
