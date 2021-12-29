// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class TFMapCloningRecipe implements wj
{
    public int fullMapID;
    public int blankMapID;
    
    public TFMapCloningRecipe(final int map, final int blank) {
        this.fullMapID = map;
        this.blankMapID = blank;
    }
    
    public boolean a(final rx par1InventoryCrafting, final xv par2World) {
        int var3 = 0;
        um var4 = null;
        for (int var5 = 0; var5 < par1InventoryCrafting.k_(); ++var5) {
            final um var6 = par1InventoryCrafting.a(var5);
            if (var6 != null) {
                if (var6.c == this.fullMapID) {
                    if (var4 != null) {
                        return false;
                    }
                    var4 = var6;
                }
                else {
                    if (var6.c != this.blankMapID) {
                        return false;
                    }
                    ++var3;
                }
            }
        }
        return var4 != null && var3 > 0;
    }
    
    public um a(final rx par1InventoryCrafting) {
        int var2 = 0;
        um var3 = null;
        for (int var4 = 0; var4 < par1InventoryCrafting.k_(); ++var4) {
            final um var5 = par1InventoryCrafting.a(var4);
            if (var5 != null) {
                if (var5.c == this.fullMapID) {
                    if (var3 != null) {
                        return null;
                    }
                    var3 = var5;
                }
                else {
                    if (var5.c != this.blankMapID) {
                        return null;
                    }
                    ++var2;
                }
            }
        }
        if (var3 != null && var2 >= 1) {
            final um var6 = new um(this.fullMapID, var2 + 1, var3.j());
            if (var3.s()) {
                var6.c(var3.r());
            }
            return var6;
        }
        return null;
    }
    
    public int a() {
        return 9;
    }
    
    public um b() {
        return null;
    }
}
