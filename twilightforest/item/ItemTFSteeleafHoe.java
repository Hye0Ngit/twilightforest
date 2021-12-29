// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTFSteeleafHoe extends wd
{
    public ItemTFSteeleafHoe(final int par1, final wf par2EnumToolMaterial) {
        super(par1, par2EnumToolMaterial);
        this.a((uy)TFItems.creativeTab);
    }
    
    public boolean a(final wg par1ItemStack, final wg par2ItemStack) {
        return par2ItemStack.c == TFItems.steeleafIngot.cp || super.a(par1ItemStack, par2ItemStack);
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ly par1IconRegister) {
        this.ct = par1IconRegister.a("twilightforest:" + this.a().substring(5));
    }
}
