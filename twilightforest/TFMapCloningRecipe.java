// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class TFMapCloningRecipe implements yg
{
    public int fullMapID;
    public int blankMapID;
    
    public TFMapCloningRecipe(final int map, final int blank) {
        this.fullMapID = map;
        this.blankMapID = blank;
    }
    
    public boolean a(final tl par1InventoryCrafting, final zv par2World) {
        int var3 = 0;
        wg var4 = null;
        for (int var5 = 0; var5 < par1InventoryCrafting.j_(); ++var5) {
            final wg var6 = par1InventoryCrafting.a(var5);
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
    
    public wg a(final tl par1InventoryCrafting) {
        int var2 = 0;
        wg var3 = null;
        for (int var4 = 0; var4 < par1InventoryCrafting.j_(); ++var4) {
            final wg var5 = par1InventoryCrafting.a(var4);
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
            final wg var6 = new wg(this.fullMapID, var2 + 1, var3.k());
            if (var3.t()) {
                var6.c(var3.s());
            }
            return var6;
        }
        return null;
    }
    
    public int a() {
        return 9;
    }
    
    public wg b() {
        return null;
    }
}
