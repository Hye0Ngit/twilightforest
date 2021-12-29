// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class SlotTFGoblinAssembly extends yu
{
    private yw thePlayer;
    private io inputSlot;
    private io uncraftingMatrix;
    private io assemblyMatrix;
    
    public SlotTFGoblinAssembly(final yw par1EntityPlayer, final io inputSlot, final io assemblyMatrix, final io uncraftingMatrix, final int slotNum, final int x, final int y) {
        super(assemblyMatrix, slotNum, x, y);
        this.thePlayer = par1EntityPlayer;
        this.inputSlot = inputSlot;
        this.uncraftingMatrix = uncraftingMatrix;
        this.assemblyMatrix = assemblyMatrix;
    }
    
    public aan b() {
        return super.b();
    }
}
