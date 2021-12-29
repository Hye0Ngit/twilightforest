// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

public class ItemTFIronwoodShovel extends wz
{
    public ItemTFIronwoodShovel(final int par1, final wf par2EnumToolMaterial) {
        super(par1, par2EnumToolMaterial);
        this.a((uy)TFItems.creativeTab);
    }
    
    public void a(final int par1, final uy par2CreativeTabs, final List par3List) {
        final wg istack = new wg(par1, 1, 0);
        istack.a(yt.t, 1);
        par3List.add(istack);
    }
    
    public boolean a(final wg par1ItemStack, final wg par2ItemStack) {
        return par2ItemStack.c == TFItems.ironwoodIngot.cp || super.a(par1ItemStack, par2ItemStack);
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ly par1IconRegister) {
        this.ct = par1IconRegister.a("twilightforest:" + this.a().substring(5));
    }
}
