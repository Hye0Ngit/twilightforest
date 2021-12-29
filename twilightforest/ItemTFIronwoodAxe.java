// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.List;

public class ItemTFIronwoodAxe extends ui
{
    protected ItemTFIronwoodAxe(final int par1, final ul par2EnumToolMaterial) {
        super(par1, par2EnumToolMaterial);
    }
    
    public String getTextureFile() {
        return "/twilightforest/items.png";
    }
    
    public void a(final int par1, final th par2CreativeTabs, final List par3List) {
        final um istack = new um(par1, 1, 0);
        istack.a(ww.s, 1);
        par3List.add(istack);
    }
    
    public boolean a(final um par1ItemStack, final um par2ItemStack) {
        return par2ItemStack.c == TFItems.ironwoodIngot.cg || super.a(par1ItemStack, par2ItemStack);
    }
}
