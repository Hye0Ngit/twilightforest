// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class InventoryTFGoblinUncrafting implements la
{
    private um[] contents;
    public int numberOfInputItems;
    public int uncraftingCost;
    public int recraftingCost;
    
    public InventoryTFGoblinUncrafting(final ContainerTFUncrafting containerTFGoblinCrafting) {
        this.contents = new um[9];
    }
    
    public int k_() {
        return 9;
    }
    
    public um a(final int var1) {
        return this.contents[var1];
    }
    
    public um a(final int slotNum, final int amount) {
        if (this.contents[slotNum] == null) {
            return null;
        }
        if (this.contents[slotNum].a <= amount) {
            final um takenStack = this.contents[slotNum];
            this.contents[slotNum] = null;
            return takenStack;
        }
        final um takenStack = this.contents[slotNum].a(amount);
        if (this.contents[slotNum].a == 0) {
            this.contents[slotNum] = null;
        }
        return takenStack;
    }
    
    public um a_(final int par1) {
        if (this.contents[par1] != null) {
            final um var2 = this.contents[par1];
            this.contents[par1] = null;
            return var2;
        }
        return null;
    }
    
    public void a(final int par1, final um par2ItemStack) {
        this.contents[par1] = par2ItemStack;
        if (par2ItemStack != null && par2ItemStack.a > this.c()) {
            par2ItemStack.a = this.c();
        }
        this.d();
    }
    
    public String b() {
        return "twilightforest.goblincrafting";
    }
    
    public int c() {
        return 64;
    }
    
    public void d() {
    }
    
    public boolean a_(final qx var1) {
        return true;
    }
    
    public void l_() {
    }
    
    public void f() {
    }
}
