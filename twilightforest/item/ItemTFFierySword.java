// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import java.util.List;

public class ItemTFFierySword extends vu
{
    public ItemTFFierySword(final int par1, final uq par2EnumToolMaterial) {
        super(par1, par2EnumToolMaterial);
        this.a((tj)TFItems.creativeTab);
    }
    
    public String getTextureFile() {
        return "/twilightforest/items.png";
    }
    
    public void a(final int par1, final tj par2CreativeTabs, final List par3List) {
        final ur istack = new ur(par1, 1, 0);
        istack.a(xc.p, 1);
        par3List.add(istack);
    }
    
    public vb f(final ur par1ItemStack) {
        return vb.c;
    }
    
    public boolean a(final ur par1ItemStack, final ur par2ItemStack) {
        return par2ItemStack.c == TFItems.fieryIngot.cj || super.a(par1ItemStack, par2ItemStack);
    }
}
