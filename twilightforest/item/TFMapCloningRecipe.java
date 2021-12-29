// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

public class TFMapCloningRecipe implements aag
{
    public int fullMapID;
    public int blankMapID;
    
    public TFMapCloningRecipe(final int map, final int blank) {
        this.fullMapID = map;
        this.blankMapID = blank;
    }
    
    public boolean a(final vj par1InventoryCrafting, final abv par2World) {
        int var3 = 0;
        yd var4 = null;
        for (int var5 = 0; var5 < par1InventoryCrafting.j_(); ++var5) {
            final yd var6 = par1InventoryCrafting.a(var5);
            if (var6 != null) {
                if (var6.d == this.fullMapID) {
                    if (var4 != null) {
                        return false;
                    }
                    var4 = var6;
                }
                else {
                    if (var6.d != this.blankMapID) {
                        return false;
                    }
                    ++var3;
                }
            }
        }
        return var4 != null && var3 > 0;
    }
    
    public yd a(final vj par1InventoryCrafting) {
        int var2 = 0;
        yd var3 = null;
        for (int var4 = 0; var4 < par1InventoryCrafting.j_(); ++var4) {
            final yd var5 = par1InventoryCrafting.a(var4);
            if (var5 != null) {
                if (var5.d == this.fullMapID) {
                    if (var3 != null) {
                        return null;
                    }
                    var3 = var5;
                }
                else {
                    if (var5.d != this.blankMapID) {
                        return null;
                    }
                    ++var2;
                }
            }
        }
        if (var3 != null && var2 >= 1) {
            final yd var6 = new yd(this.fullMapID, var2 + 1, var3.k());
            if (var3.u()) {
                var6.c(var3.s());
            }
            return var6;
        }
        return null;
    }
    
    public int a() {
        return 9;
    }
    
    public yd b() {
        return null;
    }
}
