// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class InventoryTFGoblinInput implements lt
{
    private wg[] stackInput;
    private ContainerTFUncrafting craftingContainer;
    
    public InventoryTFGoblinInput(final ContainerTFUncrafting containerTFGoblinCrafting) {
        this.stackInput = new wg[1];
        this.craftingContainer = containerTFGoblinCrafting;
    }
    
    public int j_() {
        return 1;
    }
    
    public wg a(final int par1) {
        return this.stackInput[par1];
    }
    
    public String b() {
        return "Input";
    }
    
    public wg a(final int slotNum, final int amount) {
        if (this.stackInput[slotNum] == null) {
            return null;
        }
        if (this.stackInput[slotNum].a <= amount) {
            final wg takenStack = this.stackInput[slotNum];
            this.stackInput[slotNum] = null;
            this.craftingContainer.a((lt)this);
            return takenStack;
        }
        final wg takenStack = this.stackInput[slotNum].a(amount);
        if (this.stackInput[slotNum].a == 0) {
            this.stackInput[slotNum] = null;
        }
        this.craftingContainer.a((lt)this);
        return takenStack;
    }
    
    public wg b(final int par1) {
        if (this.stackInput[par1] != null) {
            final wg var2 = this.stackInput[par1];
            this.stackInput[par1] = null;
            return var2;
        }
        return null;
    }
    
    public void a(final int par1, final wg par2ItemStack) {
        this.stackInput[par1] = par2ItemStack;
        this.craftingContainer.a((lt)this);
    }
    
    public int d() {
        return 64;
    }
    
    public void k_() {
        this.craftingContainer.a((lt)this);
    }
    
    public boolean a(final sk par1EntityPlayer) {
        return true;
    }
    
    public void f() {
    }
    
    public void g() {
    }
    
    public boolean c() {
        return false;
    }
    
    public boolean b(final int i, final wg itemstack) {
        return false;
    }
}
