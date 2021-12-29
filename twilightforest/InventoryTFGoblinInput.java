// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class InventoryTFGoblinInput implements la
{
    private um[] stackInput;
    private ContainerTFUncrafting craftingContainer;
    
    public InventoryTFGoblinInput(final ContainerTFUncrafting containerTFGoblinCrafting) {
        this.stackInput = new um[1];
        this.craftingContainer = containerTFGoblinCrafting;
    }
    
    public int k_() {
        return 1;
    }
    
    public um a(final int par1) {
        return this.stackInput[par1];
    }
    
    public String b() {
        return "Input";
    }
    
    public um a(final int slotNum, final int amount) {
        if (this.stackInput[slotNum] == null) {
            return null;
        }
        if (this.stackInput[slotNum].a <= amount) {
            final um takenStack = this.stackInput[slotNum];
            this.stackInput[slotNum] = null;
            this.craftingContainer.a((la)this);
            return takenStack;
        }
        final um takenStack = this.stackInput[slotNum].a(amount);
        if (this.stackInput[slotNum].a == 0) {
            this.stackInput[slotNum] = null;
        }
        this.craftingContainer.a((la)this);
        return takenStack;
    }
    
    public um a_(final int par1) {
        if (this.stackInput[par1] != null) {
            final um var2 = this.stackInput[par1];
            this.stackInput[par1] = null;
            return var2;
        }
        return null;
    }
    
    public void a(final int par1, final um par2ItemStack) {
        this.stackInput[par1] = par2ItemStack;
        this.craftingContainer.a((la)this);
    }
    
    public int c() {
        return 64;
    }
    
    public void d() {
        this.craftingContainer.a((la)this);
    }
    
    public boolean a_(final qx par1EntityPlayer) {
        return true;
    }
    
    public void l_() {
    }
    
    public void f() {
    }
}
