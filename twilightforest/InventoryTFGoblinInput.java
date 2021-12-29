// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class InventoryTFGoblinInput implements io
{
    private aan[] stackInput;
    private ContainerTFGoblinCrafting craftingContainer;
    
    public InventoryTFGoblinInput(final ContainerTFGoblinCrafting containerTFGoblinCrafting) {
        this.stackInput = new aan[1];
        this.craftingContainer = containerTFGoblinCrafting;
    }
    
    public int a() {
        return 1;
    }
    
    public aan k_(final int par1) {
        return this.stackInput[par1];
    }
    
    public String c() {
        return "Input";
    }
    
    public aan a(final int slotNum, final int amount) {
        if (this.stackInput[slotNum] == null) {
            return null;
        }
        if (this.stackInput[slotNum].a <= amount) {
            final aan takenStack = this.stackInput[slotNum];
            this.stackInput[slotNum] = null;
            this.craftingContainer.a((io)this);
            return takenStack;
        }
        final aan takenStack = this.stackInput[slotNum].a(amount);
        if (this.stackInput[slotNum].a == 0) {
            this.stackInput[slotNum] = null;
        }
        this.craftingContainer.a((io)this);
        return takenStack;
    }
    
    public aan b(final int par1) {
        if (this.stackInput[par1] != null) {
            final aan var2 = this.stackInput[par1];
            this.stackInput[par1] = null;
            return var2;
        }
        return null;
    }
    
    public void a(final int par1, final aan par2ItemStack) {
        this.stackInput[par1] = par2ItemStack;
        this.craftingContainer.a((io)this);
    }
    
    public int d() {
        return 64;
    }
    
    public void j() {
        this.craftingContainer.a((io)this);
    }
    
    public boolean a_(final yw par1EntityPlayer) {
        return true;
    }
    
    public void e() {
    }
    
    public void f() {
    }
}
