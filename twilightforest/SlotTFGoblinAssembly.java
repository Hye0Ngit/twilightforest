// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class SlotTFGoblinAssembly extends uf
{
    private sk thePlayer;
    private lt inputSlot;
    private lt uncraftingMatrix;
    private lt assemblyMatrix;
    
    public SlotTFGoblinAssembly(final sk par1EntityPlayer, final lt inputSlot, final lt assemblyMatrix, final lt uncraftingMatrix, final int slotNum, final int x, final int y) {
        super(assemblyMatrix, slotNum, x, y);
        this.thePlayer = par1EntityPlayer;
        this.inputSlot = inputSlot;
        this.uncraftingMatrix = uncraftingMatrix;
        this.assemblyMatrix = assemblyMatrix;
    }
}
