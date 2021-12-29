// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class InventoryTFGoblinUncrafting implements io
{
    private aan[] contents;
    public int numberOfInputItems;
    public int uncraftingCost;
    public int recraftingCost;
    
    public InventoryTFGoblinUncrafting(final ContainerTFGoblinCrafting containerTFGoblinCrafting) {
        this.contents = new aan[9];
    }
    
    public int a() {
        return 9;
    }
    
    public aan k_(final int var1) {
        return this.contents[var1];
    }
    
    public aan a(final int slotNum, final int amount) {
        if (this.contents[slotNum] == null) {
            return null;
        }
        if (this.contents[slotNum].a <= amount) {
            final aan takenStack = this.contents[slotNum];
            this.contents[slotNum] = null;
            return takenStack;
        }
        final aan takenStack = this.contents[slotNum].a(amount);
        if (this.contents[slotNum].a == 0) {
            this.contents[slotNum] = null;
        }
        return takenStack;
    }
    
    public aan b(final int par1) {
        if (this.contents[par1] != null) {
            final aan var2 = this.contents[par1];
            this.contents[par1] = null;
            return var2;
        }
        return null;
    }
    
    public void a(final int par1, final aan par2ItemStack) {
        this.contents[par1] = par2ItemStack;
        if (par2ItemStack != null && par2ItemStack.a > this.d()) {
            par2ItemStack.a = this.d();
        }
        this.j();
    }
    
    public String c() {
        return "twilightforest.goblincrafting";
    }
    
    public int d() {
        return 64;
    }
    
    public void j() {
    }
    
    public boolean a_(final yw var1) {
        return true;
    }
    
    public void e() {
    }
    
    public void f() {
    }
}
