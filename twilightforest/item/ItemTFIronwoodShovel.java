// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import java.util.List;

public class ItemTFIronwoodShovel extends vj
{
    public ItemTFIronwoodShovel(final int par1, final uq par2EnumToolMaterial) {
        super(par1, par2EnumToolMaterial);
        this.a((tj)TFItems.creativeTab);
    }
    
    public String getTextureFile() {
        return "/twilightforest/items.png";
    }
    
    public void a(final int par1, final tj par2CreativeTabs, final List par3List) {
        final ur istack = new ur(par1, 1, 0);
        istack.a(xc.t, 1);
        par3List.add(istack);
    }
    
    public boolean a(final ur par1ItemStack, final ur par2ItemStack) {
        return par2ItemStack.c == TFItems.ironwoodIngot.cj || super.a(par1ItemStack, par2ItemStack);
    }
}
