// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class InventoryTFGoblinUncrafting implements mn
{
    private yd[] contents;
    public int numberOfInputItems;
    public int uncraftingCost;
    public int recraftingCost;
    
    public InventoryTFGoblinUncrafting(final ContainerTFUncrafting containerTFGoblinCrafting) {
        this.contents = new yd[9];
    }
    
    public int j_() {
        return 9;
    }
    
    public yd a(final int var1) {
        return this.contents[var1];
    }
    
    public yd a(final int slotNum, final int amount) {
        if (this.contents[slotNum] == null) {
            return null;
        }
        if (this.contents[slotNum].b <= amount) {
            final yd takenStack = this.contents[slotNum];
            this.contents[slotNum] = null;
            return takenStack;
        }
        final yd takenStack = this.contents[slotNum].a(amount);
        if (this.contents[slotNum].b == 0) {
            this.contents[slotNum] = null;
        }
        return takenStack;
    }
    
    public yd a_(final int par1) {
        if (this.contents[par1] != null) {
            final yd var2 = this.contents[par1];
            this.contents[par1] = null;
            return var2;
        }
        return null;
    }
    
    public void a(final int par1, final yd par2ItemStack) {
        this.contents[par1] = par2ItemStack;
        if (par2ItemStack != null && par2ItemStack.b > this.d()) {
            par2ItemStack.b = this.d();
        }
        this.e();
    }
    
    public String b() {
        return "twilightforest.goblincrafting";
    }
    
    public int d() {
        return 64;
    }
    
    public void e() {
    }
    
    public boolean a(final ue var1) {
        return true;
    }
    
    public void k_() {
    }
    
    public void g() {
    }
    
    public boolean b(final int par1, final yd par2ItemStack) {
        return false;
    }
    
    public boolean c() {
        return false;
    }
}
