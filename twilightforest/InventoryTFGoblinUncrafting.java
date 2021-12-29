// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class InventoryTFGoblinUncrafting implements lt
{
    private wg[] contents;
    public int numberOfInputItems;
    public int uncraftingCost;
    public int recraftingCost;
    
    public InventoryTFGoblinUncrafting(final ContainerTFUncrafting containerTFGoblinCrafting) {
        this.contents = new wg[9];
    }
    
    public int j_() {
        return 9;
    }
    
    public wg a(final int var1) {
        return this.contents[var1];
    }
    
    public wg a(final int slotNum, final int amount) {
        if (this.contents[slotNum] == null) {
            return null;
        }
        if (this.contents[slotNum].a <= amount) {
            final wg takenStack = this.contents[slotNum];
            this.contents[slotNum] = null;
            return takenStack;
        }
        final wg takenStack = this.contents[slotNum].a(amount);
        if (this.contents[slotNum].a == 0) {
            this.contents[slotNum] = null;
        }
        return takenStack;
    }
    
    public wg b(final int par1) {
        if (this.contents[par1] != null) {
            final wg var2 = this.contents[par1];
            this.contents[par1] = null;
            return var2;
        }
        return null;
    }
    
    public void a(final int par1, final wg par2ItemStack) {
        this.contents[par1] = par2ItemStack;
        if (par2ItemStack != null && par2ItemStack.a > this.d()) {
            par2ItemStack.a = this.d();
        }
        this.k_();
    }
    
    public String b() {
        return "twilightforest.goblincrafting";
    }
    
    public int d() {
        return 64;
    }
    
    public void k_() {
    }
    
    public boolean a(final sk var1) {
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
