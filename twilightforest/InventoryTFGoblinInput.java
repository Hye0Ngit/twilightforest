// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class InventoryTFGoblinInput implements mn
{
    private yd[] stackInput;
    private ContainerTFUncrafting craftingContainer;
    
    public InventoryTFGoblinInput(final ContainerTFUncrafting containerTFGoblinCrafting) {
        this.stackInput = new yd[1];
        this.craftingContainer = containerTFGoblinCrafting;
    }
    
    public int j_() {
        return 1;
    }
    
    public yd a(final int par1) {
        return this.stackInput[par1];
    }
    
    public String b() {
        return "Input";
    }
    
    public yd a(final int slotNum, final int amount) {
        if (this.stackInput[slotNum] == null) {
            return null;
        }
        if (this.stackInput[slotNum].b <= amount) {
            final yd takenStack = this.stackInput[slotNum];
            this.stackInput[slotNum] = null;
            this.craftingContainer.a((mn)this);
            return takenStack;
        }
        final yd takenStack = this.stackInput[slotNum].a(amount);
        if (this.stackInput[slotNum].b == 0) {
            this.stackInput[slotNum] = null;
        }
        this.craftingContainer.a((mn)this);
        return takenStack;
    }
    
    public yd a_(final int par1) {
        if (this.stackInput[par1] != null) {
            final yd var2 = this.stackInput[par1];
            this.stackInput[par1] = null;
            return var2;
        }
        return null;
    }
    
    public void a(final int par1, final yd par2ItemStack) {
        this.stackInput[par1] = par2ItemStack;
        this.craftingContainer.a((mn)this);
    }
    
    public int d() {
        return 64;
    }
    
    public void e() {
        this.craftingContainer.a((mn)this);
    }
    
    public boolean a(final ue par1EntityPlayer) {
        return true;
    }
    
    public void k_() {
    }
    
    public void g() {
    }
    
    public boolean b(final int par1, final yd par2ItemStack) {
        return true;
    }
    
    public boolean c() {
        return false;
    }
}
